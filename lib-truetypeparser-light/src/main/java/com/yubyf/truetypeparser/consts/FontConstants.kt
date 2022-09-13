package com.yubyf.truetypeparser.consts

import java.util.*

/**
 * @author Yubyf
 */

internal val SFNT_VERSIONS = longArrayOf(
    // Standard version
    0x00010000,
    // 'true' - OS X or iOS
    0x74727565,
    // 'type1'
    0x74797031,
    // 'OTTO'
    0x4F54544F,
)

internal const val TABLE_NAME = "name"
internal const val TABLE_OS2 = "OS/2"

internal const val PLATFORM_ID_MACINTOSH = 1
internal const val PLATFORM_ID_MICROSOFT = 3

internal const val ENCODING_ID_UNICODE_1_0 = 0
internal const val ENCODING_ID_UNICODE_1_1 = 1

internal const val NAME_ID_COPYRIGHT_NOTICE = 0
internal const val NAME_ID_FONT_FAMILY_NAME = 1
internal const val NAME_ID_FONT_SUBFAMILY_NAME = 2
internal const val NAME_ID_UNIQUE_IDENTIFIER = 3
internal const val NAME_ID_FULL_FONT_NAME = 4
internal const val NAME_ID_VERSION_STRING = 5
internal const val NAME_ID_POSTSCRIPT_NAME = 6
internal const val NAME_ID_TRADEMARK = 7
internal const val NAME_ID_MANUFACTURER = 8
internal const val NAME_ID_DESIGNER = 9
internal const val NAME_ID_DESCRIPTION = 10
internal const val NAME_ID_VENDOR_URL = 11
internal const val NAME_ID_DESIGNER_URL = 12
internal const val NAME_ID_LICENSE_DESCRIPTION = 13
internal const val NAME_ID_LICENSE_INFO_URL = 14
internal const val NAME_ID_PREFERRED_FAMILY = 16
internal const val NAME_ID_PREFERRED_SUBFAMILY = 17
internal const val NAME_ID_MAC_FULL_NAME = 18
internal const val NAME_ID_SAMPLE_TEXT = 19
internal const val NAME_ID_CID_FINDFONT_NAME = 20

internal fun getLocaleCode(platformId: Int, languageId: Int): String {
    return when (platformId) {
        PLATFORM_ID_MICROSOFT -> MicrosoftLocaleID.getBcp47Code(languageId)
        PLATFORM_ID_MACINTOSH -> MacintoshLocaleID.getBcp47Code(languageId)
        else -> null
    } ?: Locale.ROOT.toLanguageTag()
}