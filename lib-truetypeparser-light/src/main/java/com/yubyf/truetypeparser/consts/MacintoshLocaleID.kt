package com.yubyf.truetypeparser.consts

import android.util.SparseArray

/**
 * Macintosh's Locale ID.
 * [Reference](https://developer.apple.com/fonts/TrueType-Reference-Manual/RM06/Chap6name.html)
 * 0 English
 * 1 French
 * 2 German
 * 3 Italian
 * 4 Dutch
 * 5 Swedish
 * 6 Spanish
 * 7 Danish
 * 8 Portuguese
 * 9 Norwegian
 * 10 Hebrew
 * 11 Japanese
 * 12 Arabic
 * 13 Finnish
 * 14 Greek
 * 15 Icelandic
 * 16 Maltese
 * 17 Turkish
 * 18 Croatian
 * 19 Chinese (traditional)
 * 20 Urdu
 * 21 Hindi
 * 22 Thai
 * 23 Korean
 * 24 Lithuanian
 * 25 Polish
 * 26 Hungarian
 * 27 Estonian
 * 28 Latvian
 * 29 Sami
 * 30 Faroese
 * 31 Farsi/Persian
 * 32 Russian
 * 33 Chinese (simplified)
 * 34 Flemish
 * 35 Irish Gaelic
 * 36 Albanian
 * 37 Romanian
 * 38 Czech
 * 39 Slovak
 * 40 Slovenian
 * 41 Yiddish
 * 42 Serbian
 * 43 Macedonian
 * 44 Bulgarian
 * 45 Ukrainian
 * 46 Byelorussian
 * 47 Uzbek
 * 48 Kazakh
 * 49 Azerbaijani (Cyrillic script)
 * 50 Azerbaijani (Arabic script)
 * 51 Armenian
 * 52 Georgian
 * 53 Moldavian
 * 54 Kirghiz
 * 55 Tajiki
 * 56 Turkmen
 * 57 Mongolian (Mongolian script)
 * 58 Mongolian (Cyrillic script)
 * 59 Pashto
 * 60 Kurdish
 * 61 Kashmiri
 * 62 Sindhi
 * 63 Tibetan
 * 64 Nepali
 * 65 Sanskrit
 * 66 Marathi
 * 67 Bengali
 * 68 Assamese
 * 69 Gujarati
 * 70 Punjabi
 * 71 Oriya
 * 72 Malayalam
 * 73 Kannada
 * 74 Tamil
 * 75 Telugu
 * 76 Sinhalese
 * 77 Burmese
 * 78 Khmer
 * 79 Lao
 * 80 Vietnamese
 * 81 Indonesian
 * 82 Tagalog
 * 83 Malay (Roman script)
 * 84 Malay (Arabic script)
 * 85 Amharic
 * 86 Tigrinya
 * 87 Galla
 * 88 Somali
 * 89 Swahili
 * 90 Kinyarwanda/Ruanda
 * 91 Rundi
 * 92 Nyanja/Chewa
 * 93 Malagasy
 * 94 Esperanto
 * 128 Welsh
 * 129 Basque
 * 130 Catalan
 * 131 Latin
 * 132 Quechua
 * 133 Guarani
 * 134 Aymara
 * 135 Tatar
 * 136 Uighur
 * 137 Dzongkha
 * 138 Javanese (Roman script)
 * 139 Sundanese (Roman script)
 * 140 Galician
 * 141 Afrikaans
 * 142 Breton
 * 143 Inuktitut
 * 144 Scottish Gaelic
 * 145 Manx Gaelic
 * 146 Irish Gaelic (with dot above)
 * 147 Tongan
 * 148 Greek (polytonic)
 * 149 Greenlandic
 * 150 Azerbaijani (Roman script)
 *
 * @author Yubyf
 *
 */
@Suppress("unused")
internal object MacintoshLocaleID {
    private const val ENGLISH = 0
    private const val FRENCH = 1
    private const val GERMAN = 2
    private const val ITALIAN = 3
    private const val DUTCH = 4
    private const val SWEDISH = 5
    private const val SPANISH = 6
    private const val DANISH = 7
    private const val PORTUGUESE = 8
    private const val NORWEGIAN = 9
    private const val HEBREW = 10
    private const val JAPANESE = 11
    private const val ARABIC = 12
    private const val FINNISH = 13
    private const val GREEK = 14
    private const val ICELANDIC = 15
    private const val MALTESE = 16
    private const val TURKISH = 17
    private const val CROATIAN = 18
    private const val CHINESE_TRADITIONAL = 19
    private const val URDU = 20
    private const val HINDI = 21
    private const val THAI = 22
    private const val KOREAN = 23
    private const val LITHUANIAN = 24
    private const val POLISH = 25
    private const val HUNGARIAN = 26
    private const val ESTONIAN = 27
    private const val LATVIAN = 28
    private const val SAMI = 29
    private const val FAROESE = 30
    private const val FARSI_PERSIAN = 31
    private const val RUSSIAN = 32
    private const val CHINESE_SIMPLIFIED = 33
    private const val FLEMISH = 34
    private const val IRISH_GAELIC = 35
    private const val ALBANIAN = 36
    private const val ROMANIAN = 37
    private const val CZECH = 38
    private const val SLOVAK = 39
    private const val SLOVENIAN = 40
    private const val YIDDISH = 41
    private const val SERBIAN = 42
    private const val MACEDONIAN = 43
    private const val BULGARIAN = 44
    private const val UKRAINIAN = 45
    private const val BYELORUSSIAN = 46
    private const val UZBEK = 47
    private const val KAZAKH = 48
    private const val AZERBAIJANI_CYRILLIC_SCRIPT = 49
    private const val AZERBAIJANI_ARABIC_SCRIPT = 50
    private const val ARMENIAN = 51
    private const val GEORGIAN = 52
    private const val MOLDAVIAN = 53
    private const val KIRGHIZ = 54
    private const val TAJIKI = 55
    private const val TURKMEN = 56
    private const val MONGOLIAN_MONGOLIAN_SCRIPT = 57
    private const val MONGOLIAN_CYRILLIC_SCRIPT = 58
    private const val PASHTO = 59
    private const val KURDISH = 60
    private const val KASHMIRI = 61
    private const val SINDHI = 62
    private const val TIBETAN = 63
    private const val NEPALI = 64
    private const val SANSKRIT = 65
    private const val MARATHI = 66
    private const val BENGALI = 67
    private const val ASSAMESE = 68
    private const val GUJARATI = 69
    private const val PUNJABI = 70
    private const val ORIYA = 71
    private const val MALAYALAM = 72
    private const val KANNADA = 73
    private const val TAMIL = 74
    private const val TELUGU = 75
    private const val SINHALESE = 76
    private const val BURMESE = 77
    private const val KHMER = 78
    private const val LAO = 79
    private const val VIETNAMESE = 80
    private const val INDONESIAN = 81
    private const val TAGALOG = 82
    private const val MALAY_ROMAN_SCRIPT = 83
    private const val MALAY_ARABIC_SCRIPT = 84
    private const val AMHARIC = 85
    private const val TIGRINYA = 86
    private const val GALLA = 87
    private const val SOMALI = 88
    private const val SWAHILI = 89
    private const val KINYARWANDA_RUANDA = 90
    private const val RUNDI = 91
    private const val NYANJA_CHEWA = 92
    private const val MALAGASY = 93
    private const val ESPERANTO = 94
    private const val WELSH = 128
    private const val BASQUE = 129
    private const val CATALAN = 130
    private const val LATIN = 131
    private const val QUECHUA = 132
    private const val GUARANI = 133
    private const val AYMARA = 134
    private const val TATAR = 135
    private const val UIGHUR = 136
    private const val DZONGKHA = 137
    private const val JAVANESE_ROMAN_SCRIPT = 138
    private const val SUNDANESE_ROMAN_SCRIPT = 139
    private const val GALICIAN = 140
    private const val AFRIKAANS = 141
    private const val BRETON = 142
    private const val INUKTITUT = 143
    private const val SCOTTISH_GAELIC = 144
    private const val MANX_GAELIC = 145
    private const val IRISH_GAELIC_WITH_DOT_ABOVE = 146
    private const val TONGAN = 147
    private const val GREEK_POLYTONIC = 148
    private const val GREENLANDIC = 149
    private const val AZERBAIJANI_ROMAN_SCRIPT = 150

    private val LOCALE_ID_MAP = SparseArray<String>().apply {
        append(CHINESE_SIMPLIFIED, BCP47Code.ZH_CN)
        append(CHINESE_TRADITIONAL, BCP47Code.ZH_TW)
        append(ENGLISH, BCP47Code.EN_US)
        append(FRENCH, BCP47Code.FR_FR)
        append(GERMAN, BCP47Code.DE_DE)
        append(ITALIAN, BCP47Code.IT_IT)
        append(DUTCH, BCP47Code.NL_NL)
        append(SWEDISH, BCP47Code.SV_SE)
        append(SPANISH, BCP47Code.ES_ES)
        append(DANISH, BCP47Code.DA_DK)
        append(PORTUGUESE, BCP47Code.PT_PT)
        append(NORWEGIAN, BCP47Code.NB_NO)
        append(HEBREW, BCP47Code.HE_IL)
        append(JAPANESE, BCP47Code.JA_JP)
        append(ARABIC, BCP47Code.AR_SA)
        append(FINNISH, BCP47Code.FI_FI)
        append(GREEK, BCP47Code.EL_GR)
        append(ICELANDIC, BCP47Code.IS_IS)
        append(MALTESE, BCP47Code.MT_MT)
        append(TURKISH, BCP47Code.TR_TR)
        append(CROATIAN, BCP47Code.HR_HR)
        append(URDU, BCP47Code.UR_PK)
        append(HINDI, BCP47Code.HI_IN)
        append(THAI, BCP47Code.TH_TH)
        append(KOREAN, BCP47Code.KO_KR)
        append(LITHUANIAN, BCP47Code.LT_LT)
        append(POLISH, BCP47Code.PL_PL)
        append(HUNGARIAN, BCP47Code.HU_HU)
        append(ESTONIAN, BCP47Code.ET_EE)
        append(LATVIAN, BCP47Code.LV_LV)
        append(LATIN, BCP47Code.LA)
        append(VIETNAMESE, BCP47Code.VI_VN)
        append(UZBEK, BCP47Code.UZ_LATN_UZ)
        append(KAZAKH, BCP47Code.KK_KZ)
        append(AZERBAIJANI_CYRILLIC_SCRIPT, BCP47Code.AZ_CYRL_AZ)
        append(AZERBAIJANI_ARABIC_SCRIPT, BCP47Code.AZ_ARAB_AZ)
        append(ARMENIAN, BCP47Code.HY_AM)
        append(GEORGIAN, BCP47Code.KA_GE)
        append(MOLDAVIAN, BCP47Code.RO_MD)
        append(KIRGHIZ, BCP47Code.KY_KG)
        append(TAJIKI, BCP47Code.TG_CYRL_TJ)
        append(TURKMEN, BCP47Code.TK_TM)
        append(MONGOLIAN_MONGOLIAN_SCRIPT, BCP47Code.MN_MONG_CN)
        append(MONGOLIAN_CYRILLIC_SCRIPT, BCP47Code.MN_MN)
        append(PASHTO, BCP47Code.PS_AF)
        append(SINDHI, BCP47Code.SD_IN)
        append(TIBETAN, BCP47Code.BO_CN)
        append(NEPALI, BCP47Code.NE_NP)
        append(BASQUE, BCP47Code.EU_ES)
        append(CATALAN, BCP47Code.CA_ES)
        append(QUECHUA, BCP47Code.QUZ_PE)
        append(GUARANI, BCP47Code.GN_PY)
        append(TATAR, BCP47Code.TT_RU)
        append(UIGHUR, BCP47Code.UG_ARAB_CN)
        append(GALICIAN, BCP47Code.GL_ES)
        append(AFRIKAANS, BCP47Code.AF_ZA)
        append(INUKTITUT, BCP47Code.IU_CANS_CA)
        append(SCOTTISH_GAELIC, BCP47Code.GD_GB)
        append(IRISH_GAELIC_WITH_DOT_ABOVE, BCP47Code.GA_IE)
        append(GREEK_POLYTONIC, BCP47Code.EL_GR)
        append(AZERBAIJANI_ROMAN_SCRIPT, BCP47Code.AZ_LATN_AZ)
        append(FAROESE, BCP47Code.FO_FO)
        append(SAMI, BCP47Code.SE_NO)
        append(RUSSIAN, BCP47Code.RU_RU)
        append(IRISH_GAELIC, BCP47Code.GA_IE)
        append(ALBANIAN, BCP47Code.SQ_AL)
        append(SANSKRIT, BCP47Code.SA_IN)
        append(ROMANIAN, BCP47Code.RO_RO)
        append(CZECH, BCP47Code.CS_CZ)
        append(SLOVAK, BCP47Code.SK_SK)
        append(SLOVENIAN, BCP47Code.SL_SI)
        append(YIDDISH, BCP47Code.YI)
        append(SERBIAN, BCP47Code.SR_LATN_CS)
        append(MACEDONIAN, BCP47Code.MK_MK)
        append(BULGARIAN, BCP47Code.BG_BG)
        append(UKRAINIAN, BCP47Code.UK_UA)
        append(BYELORUSSIAN, BCP47Code.BE_BY)
        append(KASHMIRI, BCP47Code.KS_ARAB_IN)
        append(MARATHI, BCP47Code.MR_IN)
        append(BENGALI, BCP47Code.BN_IN)
        append(ASSAMESE, BCP47Code.AS_IN)
        append(GUJARATI, BCP47Code.GU_IN)
        append(PUNJABI, BCP47Code.PA_IN)
        append(ORIYA, BCP47Code.OR_IN)
        append(MALAYALAM, BCP47Code.ML_IN)
        append(KANNADA, BCP47Code.KN_IN)
        append(TAMIL, BCP47Code.TA_IN)
        append(TELUGU, BCP47Code.TE_IN)
        append(SINHALESE, BCP47Code.SI_LK)
        append(BURMESE, BCP47Code.MY_MM)
        append(KHMER, BCP47Code.KM_KH)
        append(LAO, BCP47Code.LO_LA)
        append(INDONESIAN, BCP47Code.ID_ID)
        append(MALAY_ROMAN_SCRIPT, BCP47Code.MS_MY)
        append(MALAY_ARABIC_SCRIPT, BCP47Code.MS_MY)
        append(AMHARIC, BCP47Code.AM_ET)
        append(TIGRINYA, BCP47Code.TI_ER)
        append(SOMALI, BCP47Code.SO_SO)
        append(SWAHILI, BCP47Code.SW_KE)
        append(WELSH, BCP47Code.CY_GB)
    }

    fun getBcp47Code(localeID: Int): String? {
        return LOCALE_ID_MAP[localeID]
    }

    fun contains(localeID: Int): Boolean {
        return LOCALE_ID_MAP.indexOfKey(localeID) >= 0
    }
}