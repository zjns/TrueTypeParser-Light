package com.yubyf.truetype.sample

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.text.Html
import android.util.Log
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yubyf.truetypeparser.TTFFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private var loadingDialog: ProgressDialog? = null
    private lateinit var tvContent: TextView

    private val pickFontFileLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.data?.let { uri ->
                    tvContent.text = "Click the FAB button to pick a font file."
                    showProgress()
                    lifecycleScope.launch {
                        loadFontInfo(uri)
                        hideProgress()
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvContent = findViewById(R.id.tv_content)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                addCategory(Intent.CATEGORY_OPENABLE)
                type = "*/*"
                putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("font/ttf", "font/otf"))
            }
            pickFontFileLauncher.launch(intent)
        }
    }

    private suspend fun loadFontInfo(uri: Uri) {
        withContext(Dispatchers.IO) {
            val importResult =
                importFont(this@MainActivity, uri)
            if (!importResult.isNullOrEmpty()) {
                val properties: MutableList<Array<String>> = ArrayList()
                try {
                    val ttfFile: TTFFile
                    val duration = measureTimeMillis {
                        ttfFile = TTFFile.open(File(importResult))
                    }

                    properties.add(arrayOf("PARSE DURATION", "$duration ms"))
                    ttfFile.fullNames.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("FULL NAMES", buildContentLine(map)))
                    }
                    ttfFile.postscriptNames.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("POST SCRIPT NAMES", buildContentLine(map)))
                    }
                    ttfFile.families.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("FAMILIES", buildContentLine(map)))
                    }
                    ttfFile.subfamilies.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("SUB FAMILIES", buildContentLine(map)))
                    }
                    ttfFile.manufacturers.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("MANUFACTURER", buildContentLine(map)))
                    }
                    ttfFile.designers.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("DESIGNER", buildContentLine(map)))
                    }
                    properties.add(arrayOf("VENDOR URL", ttfFile.vendorURL))
                    properties.add(arrayOf("DESIGNER URL", ttfFile.designerURL))
                    ttfFile.preferFamilies.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("PREFER FAMILIES", buildContentLine(map)))
                    }
                    ttfFile.preferSubfamilies.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("PREFER SUBFAMILIES", buildContentLine(map)))
                    }
                    ttfFile.sampleTexts.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("SAMPLE TEXTS", buildContentLine(map)))
                    }
                    properties.add(arrayOf("WEIGHT", ttfFile.weightClass.toString()))

                    properties.add(arrayOf("VARIABLE FONT", ttfFile.variable.toString()))
                    ttfFile.variationAxes.takeIf { it.isNotEmpty() }?.let { list ->
                        properties.add(arrayOf("VARIATION AXES", buildContentLine(list)))
                    }
                    ttfFile.variationInstances.takeIf { it.isNotEmpty() }?.let { list ->
                        properties.add(arrayOf("VARIATION INSTANCES", buildContentLine(list)))
                    }

                    ttfFile.copyrights.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("COPYRIGHT", buildContentLine(map)))
                    }
                    properties.add(arrayOf("UNIQUE IDENTIFIER", ttfFile.uniqueIdentifier))
                    properties.add(arrayOf("VERSION", ttfFile.version))
                    ttfFile.trademarks.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("TRADEMARKS", buildContentLine(map)))
                    }
                    ttfFile.descriptions.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("DESCRIPTIONS", buildContentLine(map)))
                    }
                    ttfFile.licenseDescriptions.takeIf { it.isNotEmpty() }?.let { map ->
                        properties.add(arrayOf("LICENSE DESCRIPTIONS", buildContentLine(map)))
                    }
                    properties.add(arrayOf("LICENSE URL", ttfFile.licenseInfoURL))
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                properties
            } else {
                null
            }
        }?.let {
            val html = StringBuilder()
            for (property in it) {
                html.append("<strong>")
                    .append(property[0])
                    .append(":</strong>")
                    .append(" ")
                    .append(property[1])
                    .append("<br><br>")
            }
            tvContent.text = Html.fromHtml(html.toString())
        }
    }

    private fun buildContentLine(map: Map<String, String>): String =
        "<br/>" + map.map { "\t\t[${it.key}] - ${it.value}" }
            .reduce { acc, s -> "$acc<br/>$s" }

    private fun buildContentLine(list: List<Any>): String =
        "<br/>" + list.map { "\t\t${it}" }
            .reduce { acc, s -> "$acc<br/>$s" }

    private fun importFont(context: Context, fileUri: Uri): String? = runCatching {
        val name = context.contentResolver.query(
            fileUri, null, null, null, null
        )?.use { cursor ->
            // Get the name of the font file
            val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            cursor.moveToFirst()
            cursor.getString(nameIndex)
        } ?: fileUri.lastPathSegment ?: throw IOException("Failed to get font name")
        val fontFile = File(context.cacheDir, name)
        context.contentResolver.openInputStream(fileUri)?.use { inputStream ->
            val fos: OutputStream = FileOutputStream(fontFile)
            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0) {
                fos.write(buffer, 0, length)
            }
            fos.flush()
            fos.close()
        }
        fontFile.absolutePath
    }.onFailure {
        Log.e(MainActivity::class.simpleName, "Failed to import font", it)
    }.getOrNull()

    private fun showProgress(message: String? = null) {
        val dialog = loadingDialog
            ?: (ProgressDialog(this).also { loadingDialog = it })
        dialog.setMessage(message)
        dialog.show()
    }

    private fun hideProgress() {
        loadingDialog?.dismiss()
    }
}
