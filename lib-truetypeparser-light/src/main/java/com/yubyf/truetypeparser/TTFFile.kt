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

    //region Public fields
    /**
     * Copyright notices in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val copyright: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the copyright for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getCopyright(locale: Locale) = getValueOrFallbackByLocale(copyright, locale)

    /**
     * Font Family names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val family: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the Family name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getFamily(locale: Locale) = getValueOrFallbackByLocale(family, locale)

    /**
     * Font Subfamily names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val subfamily: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the Subfamily name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getSubfamily(locale: Locale) = getValueOrFallbackByLocale(subfamily, locale)

    /**
     * Full names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val fullName: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the full name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getFullName(locale: Locale) = getValueOrFallbackByLocale(fullName, locale)

    /**
     * PostScript names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val postscriptName: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the postscript name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getPostscriptName(locale: Locale) = getValueOrFallbackByLocale(postscriptName, locale)

    /**
     * Manufacturer names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val manufacturer: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the manufacturer for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getManufacturer(locale: Locale) = getValueOrFallbackByLocale(manufacturer, locale)

    /**
     * Designer names of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val designer: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the designer for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getDesigner(locale: Locale) = getValueOrFallbackByLocale(designer, locale)

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
     * Preferred Family names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val preferFamily: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the prefer Family name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getPreferFamily(locale: Locale) = getValueOrFallbackByLocale(preferFamily, locale)

    /**
     * Preferred Subfamily names in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    val preferSubfamily: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the prefer Subfamily name for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getPreferSubfamily(locale: Locale) = getValueOrFallbackByLocale(preferSubfamily, locale)

    /**
     * Sample Texts of the font in different locales.
     *
     * Key are the tags for identifying languages based on the IETF BCP 47 specification -
     * [BCP47](https://tools.ietf.org/html/bcp47).
     */
    var sampleText: MutableMap<String, String> = mutableMapOf()

    /**
     *  Returns the sample text for the specified locale.
     *
     *  If no value is found for the specified locale, fallback in order of [Locale.ENGLISH],
     *  [Locale.ROOT], the same language, and the first entry to return the first value that matches.
     */
    fun getSampleText(locale: Locale) = getValueOrFallbackByLocale(sampleText, locale)

    /**
     * The weight class of this font. Valid values are 100, 200....,800, 900
     * or 0 if there was no OS/2 table in the font.
     */
    var weightClass = 0
        private set
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
        // Read table by order of offset from the beginning of the file to reduce the reading duration
        when {
            nameEntry != null && os2Entry != null -> {
                if (nameEntry.offset > os2Entry.offset) {
                    readWeight(reader)
                    readName(reader)
                } else {
                    readName(reader)
                    readWeight(reader)
                }
            }
            nameEntry != null -> {
                readName(reader)
            }
            os2Entry != null -> {
                readWeight(reader)
            }
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
     * https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6name.html
     * https://docs.microsoft.com/en-us/typography/opentype/spec/name
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
            for (i in 0 until nameCount) {
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
                ) continue
                nameReader.seekAt((stringOffset
                        // Back to the beginning of the table
                        // We moved 3xUInt16 at the beginning of this function ↑.
                        - 2 * 3
                        + nameStringOffset).toLong())
                val nameText: String = if (platformId == PLATFORM_ID_MICROSOFT) {
                    nameReader.readString(nameStringLength, Charsets.UTF_16BE)
                } else {
                    nameReader.readString(nameStringLength)
                }
                getLocaleCode(platformId, languageId).let { locale ->
                    when (nameId) {
                        NAME_ID_COPYRIGHT_NOTICE -> copyright[locale] = nameText
                        NAME_ID_FONT_FAMILY_NAME -> family[locale] = nameText
                        NAME_ID_FONT_SUBFAMILY_NAME -> subfamily[locale] = nameText
                        NAME_ID_FULL_FONT_NAME -> fullName[locale] = nameText
                        NAME_ID_POSTSCRIPT_NAME -> postscriptName[locale] = nameText
                        NAME_ID_MANUFACTURER -> manufacturer[locale] = nameText
                        NAME_ID_DESIGNER -> designer[locale] = nameText
                        NAME_ID_VENDOR_URL -> vendorURL = nameText
                        NAME_ID_DESIGNER_URL -> if (designerURL.isEmpty()) designerURL = nameText
                        NAME_ID_PREFERRED_FAMILY -> preferFamily[locale] = nameText
                        NAME_ID_PREFERRED_SUBFAMILY -> preferSubfamily[locale] = nameText
                        NAME_ID_SAMPLE_TEXT -> sampleText[locale] = nameText
                        else -> {}
                    }
                }
            }
        } ?: throw IOException("Name table not found")
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
    }
}