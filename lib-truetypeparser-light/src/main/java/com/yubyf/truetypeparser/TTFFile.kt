/*
 * Modified by Yubyf on 2022:
 * Copyright (c) 2022 Yubyf <lpy19920505@gmail.com>
 *
 * Copyright (C) 2016 Jared Rummler <jared.rummler@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
/* $Id: TTFFile.java 1395925 2012-10-09 09:13:18Z jeremias $ */
package com.yubyf.truetypeparser

import com.yubyf.truetypeparser.consts.*
import java.io.*
import java.util.*

/**
 * Reads a TrueType file or a TrueType Collection.
 * The TrueType spec can be found at the Microsoft/Apple.
 *
 * Typography site:
 * [Microsoft](https://docs.microsoft.com/en-us/typography/opentype/spec/)
 * [Apple](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6.html)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class TTFFile internal constructor() {

    /**
     * Table directory
     */
    private val tableDirectories: MutableMap<String, TableDirectory?> = mutableMapOf()

    private val _copyrights: MutableMap<String, String> = mutableMapOf()
    private val _families: MutableMap<String, String> = mutableMapOf()
    private val _subfamilies: MutableMap<String, String> = mutableMapOf()
    private val _fullNames: MutableMap<String, String> = mutableMapOf()
    private val _postscriptNames: MutableMap<String, String> = mutableMapOf()
    private val _trademarks: MutableMap<String, String> = mutableMapOf()
    private val _manufacturers: MutableMap<String, String> = mutableMapOf()
    private val _designers: MutableMap<String, String> = mutableMapOf()
    private val _descriptions: MutableMap<String, String> = mutableMapOf()
    private val _licenseDescriptions: MutableMap<String, String> = mutableMapOf()
    private val _preferFamilies: MutableMap<String, String> = mutableMapOf()
    private val _preferSubfamilies: MutableMap<String, String> = mutableMapOf()
    private val _sampleTexts: MutableMap<String, String> = mutableMapOf()
    private val _extraFields: MutableMap<Int, MutableMap<String, String>> = mutableMapOf()
    private val _variationAxes: MutableList<VariationAxis> = mutableListOf()
    private val _variationInstances: MutableList<VariationInstance> = mutableListOf()

    //region Public fields
    /**
     * Copyright notices in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val copyrights: Map<String, String>
        get() = _copyrights.toImmutableMap()

    /**
     * Font Family names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val families: Map<String, String>
        get() = _families.toImmutableMap()

    /**
     * Font Subfamily names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val subfamilies: Map<String, String>
        get() = _subfamilies.toImmutableMap()

    /**
     * Unique subfamily identification.
     */
    var uniqueIdentifier: String = ""
        private set

    /**
     * Full names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val fullNames: Map<String, String>
        get() = _fullNames.toImmutableMap()

    /**
     * Version of the name table.
     */
    var version: String = ""
        private set

    /**
     * PostScript names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val postscriptNames: Map<String, String>
        get() = _postscriptNames.toImmutableMap()

    /**
     * Trademark notices in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val trademarks: Map<String, String>
        get() = _trademarks.toImmutableMap()

    /**
     * Manufacturer names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val manufacturers: Map<String, String>
        get() = _manufacturers.toImmutableMap()

    /**
     * Designer names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val designers: Map<String, String>
        get() = _designers.toImmutableMap()

    /**
     * descriptions of the typeface in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val descriptions: Map<String, String>
        get() = _descriptions.toImmutableMap()

    /**
     * URL of the font vendor.
     */
    var vendorURL = ""
        private set

    /**
     * URL of the font designer.
     */
    var designerURL = ""
        private set

    /**
     * License descriptions in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val licenseDescriptions: Map<String, String>
        get() = _licenseDescriptions.toImmutableMap()

    /**
     * License information URL.
     */
    var licenseInfoURL = ""
        private set

    /**
     * Preferred Family names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val preferFamilies: Map<String, String>
        get() = _preferFamilies.toImmutableMap()

    /**
     * Preferred Subfamily names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val preferSubfamilies: Map<String, String>
        get() = _preferSubfamilies.toImmutableMap()

    /**
     * Sample Texts of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val sampleTexts: Map<String, String>
        get() = _sampleTexts.toImmutableMap()

    /**
     * The weight class of this font. Valid values are 100, 200....,800, 900
     * or 0 if there was no OS/2 table in the font.
     */
    var weightClass = 0
        private set

    /**
     * Whether the font is variable font.
     */
    var variable = false
        private set

    /**
     * The variation axes of this font if it is a variable font.
     *
     * Only available if the value of [variable] is `true`.
     */
    val variationAxes: List<VariationAxis>
        get() = _variationAxes.toImmutableList()

    /**
     * The variation instances of this font if it is a variable font.
     *
     * Only available if the value of [variable] is `true`.
     */
    val variationInstances: List<VariationInstance>
        get() = _variationInstances.toImmutableList()

    /**
     * The variation axis data.
     *
     * @param tag The axis name..
     * @param minValue The minimum style coordinate for the axis.
     * @param defaultValue The default style coordinate for the axis.
     * @param maxValue The maximum style coordinate for the axis.
     */
    data class VariationAxis(
        val tag: String,
        val minValue: Float,
        val defaultValue: Float,
        val maxValue: Float,
        internal val _nameId: Int,
        var nm: String = "",
    ) {
        /**
         * The designation in the 'name' table in different locales.
         */
        var name: Map<String, String> = emptyMap()
            internal set

        override fun toString(): String {
            return "[tag=$tag, minValue=$minValue, defaultValue=$defaultValue, maxValue=$maxValue, name=$name]"
        }
    }

    /**
     * The variation instance data.
     *
     * @param coordinates The coordinates of defined instances in different axes.
     */
    data class VariationInstance(
        internal val _nameId: Int,
        val coordinates: Map<String, Float>,
        internal val _postscriptNameId: Int?,
    ) {
        /**
         * The names of the defined instance coordinate in different locales.
         */
        var name: Map<String, String> = emptyMap()
            internal set

        /**
         * The PostScript names of the defined instance coordinate in different locales.
         */
        var postscriptName: Map<String, String> = emptyMap()
            internal set

        override fun toString(): String {
            return "[name=$name, coordinates=$coordinates, postscriptName=$postscriptName]"
        }
    }
    //endregion

    /**
     * Reads the font using a FontFileReader.
     *
     * @param reader The FontFileReader to use
     * @throws IOException In case of an I/O problem
     */
    @Throws(IOException::class)
    private fun readFont(reader: FontStreamReader?) = reader?.use {
        if (!checkSfntVersion(it)) {
            throw IOException("Not a valid TrueType/OpenType font")
        }
        readTableDirectories(it)
        readTablesOrderByOffset(it)
    } ?: throw IOException("FontFileReader is null")

    /**
     * Check the sfnt version of the font.
     *
     * @return false if the file is not a valid TrueType/OpenType font
     */
    private fun checkSfntVersion(reader: FontStreamReader): Boolean =
        SFNT_VERSIONS.contains(reader.readUInt32())

    /**
     * Read Table Directory from the current position in the FontFileReader and fill the global
     * HashMap [tableDirectories] with the table tag (String) as key and a [TableDirectory] as value.
     *
     * Reference:
     * [Apple](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6.html)
     * [Microsoft](https://docs.microsoft.com/en-us/typography/opentype/spec/otff#table-directory)
     *
     * @throws IOException in case of an I/O problem
     */
    @Throws(IOException::class)
    private fun readTableDirectories(reader: FontStreamReader) {
        val numTables = reader.readUInt16()
        // Skip 3xUInt16
        reader.skip(2 * 3)
        for (i in 0 until numTables) {
            TableDirectory().read(reader).run {
                if (tag == TABLE_FVAR) {
                    variable = true
                }
                tableDirectories[tag] = this
            }
        }
    }

    /**
     * Reads the tables in the order of their offsets in the file.
     */
    @Throws(IOException::class)
    private fun readTablesOrderByOffset(reader: FontStreamReader) {
        val nameEntry = tableDirectories[TABLE_NAME]
        val os2Entry = tableDirectories[TABLE_OS2]
        val fvarEntry = tableDirectories[TABLE_FVAR]
        // Read table by order of offset from the beginning of the file to reduce the reading duration
        sequenceOf(nameEntry, os2Entry, fvarEntry).filterNotNull().sortedBy { it.offset }.forEach {
            when (it.tag) {
                TABLE_NAME -> readName(reader)
                TABLE_OS2 -> readWeight(reader)
                TABLE_FVAR -> runCatching { readFvarTable(reader) }
            }
        }
        if (variable) {
            // If the font is variable, we need to populate the names of the variation fields.
            populateVariationNames()
        }
    }

    /**
     * Read weight form the [TABLE_OS2] table.
     *
     * Reference:
     * [Apple](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6OS2.html)
     * [Microsoft](https://docs.microsoft.com/en-us/typography/opentype/spec/os2)
     *
     * @throws IOException In case of a I/O problem
     */
    @Throws(IOException::class)
    private fun readWeight(reader: FontStreamReader) {
        seekTable(reader, TABLE_OS2)
        // OS/2 table version number
        reader.readUInt16()
        //Skip xAvgCharWidth
        reader.skip(2)
        weightClass = reader.readUInt16()
    }

    /**
     * Read the [TABLE_NAME] table.
     * [Apple](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6name.html)
     * [Microsoft](https://docs.microsoft.com/en-us/typography/opentype/spec/name)
     *
     * @throws IOException In case of a I/O problem
     */
    @Throws(IOException::class)
    private fun readName(reader: FontStreamReader) {
        // Skip table version number - UInt16
        seekTable(reader, TABLE_NAME, 2)
        val nameCount = reader.readUInt16()
        val stringOffset = reader.readUInt16()
        tableDirectories[TABLE_NAME]?.let {
            FontStreamReader(ByteArrayInputStream(ByteArray(it.length.toInt()).apply {
                reader.readTo(this)
            }))
        }?.use { nameReader ->
            (0 until nameCount).forEach { i ->
                // Every name record is 12 bytes long - 6xUInt16
                nameReader.seekAt(i * 12L)
                val platformId = nameReader.readUInt16()
                val encodingId = nameReader.readUInt16()
                val languageId = nameReader.readUInt16()
                val nameId = nameReader.readUInt16()
                val nameStringLength = nameReader.readUInt16()
                val nameStringOffset = nameReader.readUInt16()
                if (platformId != PLATFORM_ID_MACINTOSH && platformId != PLATFORM_ID_MICROSOFT
                    || encodingId != ENCODING_ID_UNICODE_1_0 && encodingId != ENCODING_ID_UNICODE_1_1
                ) return@forEach
                nameReader.seekAt(
                    (stringOffset
                            // Back to the beginning of the table
                            // We moved 3xUInt16 at the beginning of this function ↑.
                            - 2 * 3
                            + nameStringOffset).toLong()
                )
                val nameText: String = if (platformId == PLATFORM_ID_MICROSOFT) {
                    nameReader.readString(nameStringLength, Charsets.UTF_16BE)
                } else {
                    nameReader.readString(nameStringLength)
                }
                getLocaleCode(platformId, languageId).let { locale ->
                    when (nameId) {
                        NAME_ID_COPYRIGHT_NOTICE -> _copyrights[locale] = nameText
                        NAME_ID_FONT_FAMILY_NAME -> _families[locale] = nameText
                        NAME_ID_FONT_SUBFAMILY_NAME -> _subfamilies[locale] = nameText
                        NAME_ID_UNIQUE_IDENTIFIER -> uniqueIdentifier = nameText
                        NAME_ID_FULL_FONT_NAME -> _fullNames[locale] = nameText
                        NAME_ID_VERSION_STRING -> version = nameText
                        NAME_ID_POSTSCRIPT_NAME -> _postscriptNames[locale] = nameText
                        NAME_ID_TRADEMARK -> _trademarks[locale] = nameText
                        NAME_ID_MANUFACTURER -> _manufacturers[locale] = nameText
                        NAME_ID_DESIGNER -> _designers[locale] = nameText
                        NAME_ID_DESCRIPTION -> _descriptions[locale] = nameText
                        NAME_ID_VENDOR_URL -> vendorURL = nameText
                        NAME_ID_DESIGNER_URL -> if (designerURL.isEmpty()) designerURL = nameText
                        NAME_ID_LICENSE_DESCRIPTION -> _licenseDescriptions[locale] = nameText
                        NAME_ID_LICENSE_INFO_URL -> licenseInfoURL = nameText
                        NAME_ID_PREFERRED_FAMILY -> _preferFamilies[locale] = nameText
                        NAME_ID_PREFERRED_SUBFAMILY -> _preferSubfamilies[locale] = nameText
                        NAME_ID_SAMPLE_TEXT -> _sampleTexts[locale] = nameText
                        in 256..32767 -> _extraFields[nameId]?.let { it[locale] = nameText }
                            ?: run { _extraFields[nameId] = mutableMapOf(locale to nameText) }

                        else -> {}
                    }
                }
            }
        } ?: throw IOException("Name table not found")
    }

    /**
     * Read the [TABLE_FVAR] table.
     * [Apple](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6fvar.html)
     * [Microsoft](https://learn.microsoft.com/en-us/typography/opentype/spec/fvar)
     *
     * @throws IOException In case of a I/O problem
     */
    private fun readFvarTable(reader: FontStreamReader) {
        // Skip table version number - UInt16 * 2
        seekTable(reader, TABLE_FVAR, 4)
        // Axes array offset
        reader.readUInt16()
        // Skip reserved field - UInt16
        reader.skip(2)
        val axisCount = reader.readUInt16()
        if (axisCount == 0) {
            variable = false
            return
        }
        val axisSize = reader.readUInt16()
        val instanceCount = reader.readUInt16()
        val instanceSize = reader.readUInt16()
        // Variation axis record
        FontStreamReader(ByteArrayInputStream(ByteArray(axisSize * axisCount).apply {
            reader.readTo(this)
        })).use { axisReader ->
            (0 until axisCount).forEach { i ->
                axisReader.seekAt((i * axisSize).toLong())
                val axisTag = axisReader.readString(4)
                val axisMinValue = axisReader.readFixedFloat32()
                val axisDefaultValue = axisReader.readFixedFloat32()
                val axisMaxValue = axisReader.readFixedFloat32()
                // Axis flags
                axisReader.readUInt16()
                val axisNameId = axisReader.readUInt16()
                _variationAxes += VariationAxis(
                    axisTag,
                    axisMinValue,
                    axisDefaultValue,
                    axisMaxValue,
                    axisNameId
                )
            }
        }
        if (instanceCount <= 0) {
            return
        }
        val instanceIncludePostScriptName = 2 * 3 + 4 * axisCount == instanceSize
        // Instance record
        FontStreamReader(ByteArrayInputStream(ByteArray(instanceSize * instanceCount).apply {
            reader.readTo(this)
        })).use { instanceReader ->
            (0 until instanceCount).forEach { i ->
                instanceReader.seekAt((i * instanceSize).toLong())
                val instanceNameId = instanceReader.readUInt16()
                // Instance flags
                instanceReader.readUInt16()
                val instanceCoordinates = _variationAxes.associate { axis ->
                    axis.tag to instanceReader.readFixedFloat32()
                }
                val instancePostScriptNameId =
                    if (instanceIncludePostScriptName) instanceReader.readUInt16() else null
                _variationInstances += VariationInstance(
                    instanceNameId,
                    instanceCoordinates,
                    instancePostScriptNameId
                )
            }
        }
    }

    private fun populateVariationNames() {
        _variationAxes.forEach { axis ->
            axis.name = _extraFields[axis._nameId] ?: emptyMap()
        }
        _variationInstances.forEach { instance ->
            instance.name = _extraFields[instance._nameId] ?: emptyMap()
            instance.postscriptName = _extraFields[instance._postscriptNameId] ?: emptyMap()
        }
    }

    /**
     * Position [InputStream] to position indicated in the [TableDirectory.offset] + [offset]
     *
     * @param reader Font file reader
     * @param tag Tag of table
     * @param offset From start of table
     * @return true if seek succeeded
     * @throws IOException if I/O exception occurs during seek
     */
    @Throws(IOException::class)
    private fun seekTable(reader: FontStreamReader, tag: String, offset: Long = 0): Boolean =
        tableDirectories[tag]?.run {
            reader.seekAt(this.offset + offset)
            true
        } ?: false

    @Suppress("unused")
    companion object {
        /**
         * Reads a TTF file
         *
         * @param file The font file
         * @return The TrueType file
         * @throws IOException if an IO error occurs
         */
        @Throws(IOException::class)
        fun open(file: File): TTFFile = open(FileInputStream(file))

        /**
         * Reads a TTF file from an InputStream
         *
         * @param inputStream InputStream to read from
         * @return The TrueType file
         * @throws IOException if an IO error occurs
         */
        @Throws(IOException::class)
        fun open(inputStream: InputStream): TTFFile =
            TTFFile().apply { readFont(FontStreamReader(inputStream)) }

        @Suppress("NOTHING_TO_INLINE")
        private inline fun <K, V> Map<K, V>.toImmutableMap(): Map<K, V> =
            Collections.unmodifiableMap(this)

        @Suppress("NOTHING_TO_INLINE")
        private inline fun <T> List<T>.toImmutableList(): List<T> =
            Collections.unmodifiableList(this)
    }
}

/**
 *  Returns the value of the specified locale in the font property map.
 *
 *  If no value is found for the specified [locale],
 *  fallback and try to find the first matching locale in the following order
 *  and returns the value corresponding to the found locale:
 *  - Locale in [this] that has the same language as the given [locale]
 *  - Tag of [Locale.US] generated by [Locale.toLanguageTag]
 *  - Locale with English language
 *  - Tag of [Locale.ROOT] generated by [Locale.toLanguageTag]
 *  - Locale of first entry in [this]
 *
 *  @param locale the locale to get the value for.
 */
@JvmName("getValueOrFallbackByLocale")
operator fun Map<String, String>.get(locale: Locale): String =
    if (isEmpty()) ""
    else this[locale.toLanguageTag()]
        ?: this.entries.firstOrNull { entry ->
            Locale.forLanguageTag(entry.key).language == locale.language
        }?.value
        ?: this[BCP47Code.EN_US]
        ?: this.entries.firstOrNull { entry ->
            Locale.forLanguageTag(entry.key).language == Locale.ENGLISH.language
        }?.value
        ?: this[Locale.ROOT.toLanguageTag()]
        ?: this.values.firstOrNull()
        ?: ""
