package com.yubyf.truetypeparser.consts

import android.util.SparseArray

/**
 * Microsoft's Locale ID.
 * [Reference](https://docs.microsoft.com/en-us/openspecs/office_standards/ms-oe376/6c085406-a698-4e12-9d4d-c3b0ee3dbc4a)
 *
 * @author Yubyf
 */
@Suppress("unused")
internal object MicrosoftLocaleID {
    private const val AR_SA = 1025
    private const val BG_BG = 1026
    private const val CA_ES = 1027
    private const val ZH_TW = 1028
    private const val CS_CZ = 1029
    private const val DA_DK = 1030
    private const val DE_DE = 1031
    private const val EL_GR = 1032
    private const val EN_US = 1033
    private const val ES_ES = 1034
    private const val FI_FI = 1035
    private const val FR_FR = 1036
    private const val HE_IL = 1037
    private const val HU_HU = 1038
    private const val IS_IS = 1039
    private const val IT_IT = 1040
    private const val JA_JP = 1041
    private const val KO_KR = 1042
    private const val NL_NL = 1043
    private const val NB_NO = 1044
    private const val PL_PL = 1045
    private const val PT_BR = 1046
    private const val RM_CH = 1047
    private const val RO_RO = 1048
    private const val RU_RU = 1049
    private const val HR_HR = 1050
    private const val SK_SK = 1051
    private const val SQ_AL = 1052
    private const val SV_SE = 1053
    private const val TH_TH = 1054
    private const val TR_TR = 1055
    private const val UR_PK = 1056
    private const val ID_ID = 1057
    private const val UK_UA = 1058
    private const val BE_BY = 1059
    private const val SL_SI = 1060
    private const val ET_EE = 1061
    private const val LV_LV = 1062
    private const val LT_LT = 1063
    private const val TG_CYRL_TJ = 1064
    private const val FA_IR = 1065
    private const val VI_VN = 1066
    private const val HY_AM = 1067
    private const val AZ_LATN_AZ = 1068
    private const val EU_ES = 1069
    private const val WEN_DE = 1070
    private const val MK_MK = 1071
    private const val ST_ZA = 1072
    private const val TS_ZA = 1073
    private const val TN_ZA = 1074
    private const val VEN_ZA = 1075
    private const val XH_ZA = 1076
    private const val ZU_ZA = 1077
    private const val AF_ZA = 1078
    private const val KA_GE = 1079
    private const val FO_FO = 1080
    private const val HI_IN = 1081
    private const val MT_MT = 1082
    private const val SE_NO = 1083
    private const val GD_GB = 1084
    private const val YI = 1085
    private const val MS_MY = 1086
    private const val KK_KZ = 1087
    private const val KY_KG = 1088
    private const val SW_KE = 1089
    private const val TK_TM = 1090
    private const val UZ_LATN_UZ = 1091
    private const val TT_RU = 1092
    private const val BN_IN = 1093
    private const val PA_IN = 1094
    private const val GU_IN = 1095
    private const val OR_IN = 1096
    private const val TA_IN = 1097
    private const val TE_IN = 1098
    private const val KN_IN = 1099
    private const val ML_IN = 1100
    private const val AS_IN = 1101
    private const val MR_IN = 1102
    private const val SA_IN = 1103
    private const val MN_MN = 1104
    private const val BO_CN = 1105
    private const val CY_GB = 1106
    private const val KM_KH = 1107
    private const val LO_LA = 1108
    private const val MY_MM = 1109
    private const val GL_ES = 1110
    private const val KOK_IN = 1111
    private const val MNI = 1112
    private const val SD_IN = 1113
    private const val SYR_SY = 1114
    private const val SI_LK = 1115
    private const val CHR_US = 1116
    private const val IU_CANS_CA = 1117
    private const val AM_ET = 1118
    private const val TMZ = 1119
    private const val KS_ARAB_IN = 1120
    private const val NE_NP = 1121
    private const val FY_NL = 1122
    private const val PS_AF = 1123
    private const val FIL_PH = 1124
    private const val DV_MV = 1125
    private const val BIN_NG = 1126
    private const val FUV_NG = 1127
    private const val HA_LATN_NG = 1128
    private const val IBB_NG = 1129
    private const val YO_NG = 1130
    private const val QUZ_BO = 1131
    private const val NSO_ZA = 1132
    private const val IG_NG = 1136
    private const val KR_NG = 1137
    private const val GAZ_ET = 1138
    private const val TI_ER = 1139
    private const val GN_PY = 1140
    private const val HAW_US = 1141
    private const val LA = 1142
    private const val SO_SO = 1143
    private const val II_CN = 1144
    private const val PAP_AN = 1145
    private const val UG_ARAB_CN = 1152
    private const val MI_NZ = 1153
    private const val AR_IQ = 2049
    private const val ZH_CN = 2052
    private const val DE_CH = 2055
    private const val EN_GB = 2057
    private const val ES_MX = 2058
    private const val FR_BE = 2060
    private const val IT_CH = 2064
    private const val NL_BE = 2067
    private const val NN_NO = 2068
    private const val PT_PT = 2070
    private const val RO_MD = 2072
    private const val RU_MD = 2073
    private const val SR_LATN_CS = 2074
    private const val SV_FI = 2077
    private const val UR_IN = 2080
    private const val AZ_CYRL_AZ = 2092
    private const val GA_IE = 2108
    private const val MS_BN = 2110
    private const val UZ_CYRL_UZ = 2115
    private const val BN_BD = 2117
    private const val PA_PK = 2118
    private const val MN_MONG_CN = 2128
    private const val BO_BT = 2129
    private const val SD_PK = 2137
    private const val TZM_LATN_DZ = 2143
    private const val KS_DEVA_IN = 2144
    private const val NE_IN = 2145
    private const val QUZ_EC = 2155
    private const val TI_ET = 2163
    private const val AR_EG = 3073
    private const val ZH_HK = 3076
    private const val DE_AT = 3079
    private const val EN_AU = 3081
    private const val FR_CA = 3084
    private const val SR_CYRL_CS = 3098
    private const val QUZ_PE = 3179
    private const val AR_LY = 4097
    private const val ZH_SG = 4100
    private const val DE_LU = 4103
    private const val EN_CA = 4105
    private const val ES_GT = 4106
    private const val FR_CH = 4108
    private const val HR_BA = 4122
    private const val AR_DZ = 5121
    private const val ZH_MO = 5124
    private const val DE_LI = 5127
    private const val EN_NZ = 5129
    private const val ES_CR = 5130
    private const val FR_LU = 5132
    private const val BS_LATN_BA = 5146
    private const val AR_MO = 6145
    private const val EN_IE = 6153
    private const val ES_PA = 6154
    private const val FR_MC = 6156
    private const val AR_TN = 7169
    private const val EN_ZA = 7177
    private const val ES_DO = 7178
    private const val FR_029 = 7180
    private const val AR_OM = 8193
    private const val EN_JM = 8201
    private const val ES_VE = 8202
    private const val FR_RE = 8204
    private const val AR_YE = 9217
    private const val EN_029 = 9225
    private const val ES_CO = 9226
    private const val FR_CG = 9228
    private const val AR_SY = 10241
    private const val EN_BZ = 10249
    private const val ES_PE = 10250
    private const val FR_SN = 10252
    private const val AR_JO = 11265
    private const val EN_TT = 11273
    private const val ES_AR = 11274
    private const val FR_CM = 11276
    private const val AR_LB = 12289
    private const val EN_ZW = 12297
    private const val ES_EC = 12298
    private const val FR_CI = 12300
    private const val AR_KW = 13313
    private const val EN_PH = 13321
    private const val ES_CL = 13322
    private const val FR_ML = 13324
    private const val AR_AE = 14337
    private const val EN_ID = 14345
    private const val ES_UY = 14346
    private const val FR_MA = 14348
    private const val AR_BH = 15361
    private const val EN_HK = 15369
    private const val ES_PY = 15370
    private const val FR_HT = 15372
    private const val AR_QA = 16385
    private const val EN_IN = 16393
    private const val ES_BO = 16394
    private const val EN_MY = 17417
    private const val ES_SV = 17418
    private const val EN_SG = 18441
    private const val ES_HN = 18442
    private const val ES_NI = 19466
    private const val ES_PR = 20490
    private const val ES_US = 21514
    private const val ES_419 = 58378
    private const val FR_015 = 58380

    private val LOCALE_ID_MAP = SparseArray<String>().apply {
        append(AR_SA, BCP47Code.AR_SA)
        append(BG_BG, BCP47Code.BG_BG)
        append(CA_ES, BCP47Code.CA_ES)
        append(ZH_TW, BCP47Code.ZH_TW)
        append(CS_CZ, BCP47Code.CS_CZ)
        append(DA_DK, BCP47Code.DA_DK)
        append(DE_DE, BCP47Code.DE_DE)
        append(EL_GR, BCP47Code.EL_GR)
        append(EN_US, BCP47Code.EN_US)
        append(ES_ES, BCP47Code.ES_ES)
        append(FI_FI, BCP47Code.FI_FI)
        append(FR_FR, BCP47Code.FR_FR)
        append(HE_IL, BCP47Code.HE_IL)
        append(HU_HU, BCP47Code.HU_HU)
        append(IS_IS, BCP47Code.IS_IS)
        append(IT_IT, BCP47Code.IT_IT)
        append(JA_JP, BCP47Code.JA_JP)
        append(KO_KR, BCP47Code.KO_KR)
        append(NL_NL, BCP47Code.NL_NL)
        append(NB_NO, BCP47Code.NB_NO)
        append(PL_PL, BCP47Code.PL_PL)
        append(PT_BR, BCP47Code.PT_BR)
        append(RM_CH, BCP47Code.RM_CH)
        append(RO_RO, BCP47Code.RO_RO)
        append(RU_RU, BCP47Code.RU_RU)
        append(HR_HR, BCP47Code.HR_HR)
        append(SK_SK, BCP47Code.SK_SK)
        append(SQ_AL, BCP47Code.SQ_AL)
        append(SV_SE, BCP47Code.SV_SE)
        append(TH_TH, BCP47Code.TH_TH)
        append(TR_TR, BCP47Code.TR_TR)
        append(UR_PK, BCP47Code.UR_PK)
        append(ID_ID, BCP47Code.ID_ID)
        append(UK_UA, BCP47Code.UK_UA)
        append(BE_BY, BCP47Code.BE_BY)
        append(SL_SI, BCP47Code.SL_SI)
        append(ET_EE, BCP47Code.ET_EE)
        append(LV_LV, BCP47Code.LV_LV)
        append(LT_LT, BCP47Code.LT_LT)
        append(TG_CYRL_TJ, BCP47Code.TG_CYRL_TJ)
        append(FA_IR, BCP47Code.FA_IR)
        append(VI_VN, BCP47Code.VI_VN)
        append(HY_AM, BCP47Code.HY_AM)
        append(AZ_LATN_AZ, BCP47Code.AZ_LATN_AZ)
        append(EU_ES, BCP47Code.EU_ES)
        append(WEN_DE, BCP47Code.WEN_DE)
        append(MK_MK, BCP47Code.MK_MK)
        append(ST_ZA, BCP47Code.ST_ZA)
        append(TS_ZA, BCP47Code.TS_ZA)
        append(TN_ZA, BCP47Code.TN_ZA)
        append(VEN_ZA, BCP47Code.VEN_ZA)
        append(XH_ZA, BCP47Code.XH_ZA)
        append(ZU_ZA, BCP47Code.ZU_ZA)
        append(AF_ZA, BCP47Code.AF_ZA)
        append(KA_GE, BCP47Code.KA_GE)
        append(FO_FO, BCP47Code.FO_FO)
        append(HI_IN, BCP47Code.HI_IN)
        append(MT_MT, BCP47Code.MT_MT)
        append(SE_NO, BCP47Code.SE_NO)
        append(GD_GB, BCP47Code.GD_GB)
        append(YI, BCP47Code.YI)
        append(MS_MY, BCP47Code.MS_MY)
        append(KK_KZ, BCP47Code.KK_KZ)
        append(KY_KG, BCP47Code.KY_KG)
        append(SW_KE, BCP47Code.SW_KE)
        append(TK_TM, BCP47Code.TK_TM)
        append(UZ_LATN_UZ, BCP47Code.UZ_LATN_UZ)
        append(TT_RU, BCP47Code.TT_RU)
        append(BN_IN, BCP47Code.BN_IN)
        append(PA_IN, BCP47Code.PA_IN)
        append(GU_IN, BCP47Code.GU_IN)
        append(OR_IN, BCP47Code.OR_IN)
        append(TA_IN, BCP47Code.TA_IN)
        append(TE_IN, BCP47Code.TE_IN)
        append(KN_IN, BCP47Code.KN_IN)
        append(ML_IN, BCP47Code.ML_IN)
        append(AS_IN, BCP47Code.AS_IN)
        append(MR_IN, BCP47Code.MR_IN)
        append(SA_IN, BCP47Code.SA_IN)
        append(MN_MN, BCP47Code.MN_MN)
        append(BO_CN, BCP47Code.BO_CN)
        append(CY_GB, BCP47Code.CY_GB)
        append(KM_KH, BCP47Code.KM_KH)
        append(LO_LA, BCP47Code.LO_LA)
        append(MY_MM, BCP47Code.MY_MM)
        append(GL_ES, BCP47Code.GL_ES)
        append(KOK_IN, BCP47Code.KOK_IN)
        append(MNI, BCP47Code.MNI)
        append(SD_IN, BCP47Code.SD_IN)
        append(SYR_SY, BCP47Code.SYR_SY)
        append(SI_LK, BCP47Code.SI_LK)
        append(CHR_US, BCP47Code.CHR_US)
        append(IU_CANS_CA, BCP47Code.IU_CANS_CA)
        append(AM_ET, BCP47Code.AM_ET)
        append(TMZ, BCP47Code.TMZ)
        append(KS_ARAB_IN, BCP47Code.KS_ARAB_IN)
        append(NE_NP, BCP47Code.NE_NP)
        append(FY_NL, BCP47Code.FY_NL)
        append(PS_AF, BCP47Code.PS_AF)
        append(FIL_PH, BCP47Code.FIL_PH)
        append(DV_MV, BCP47Code.DV_MV)
        append(BIN_NG, BCP47Code.BIN_NG)
        append(FUV_NG, BCP47Code.FUV_NG)
        append(HA_LATN_NG, BCP47Code.HA_LATN_NG)
        append(IBB_NG, BCP47Code.IBB_NG)
        append(YO_NG, BCP47Code.YO_NG)
        append(QUZ_BO, BCP47Code.QUZ_BO)
        append(NSO_ZA, BCP47Code.NSO_ZA)
        append(IG_NG, BCP47Code.IG_NG)
        append(KR_NG, BCP47Code.KR_NG)
        append(GAZ_ET, BCP47Code.GAZ_ET)
        append(TI_ER, BCP47Code.TI_ER)
        append(GN_PY, BCP47Code.GN_PY)
        append(HAW_US, BCP47Code.HAW_US)
        append(LA, BCP47Code.LA)
        append(SO_SO, BCP47Code.SO_SO)
        append(II_CN, BCP47Code.II_CN)
        append(PAP_AN, BCP47Code.PAP_AN)
        append(UG_ARAB_CN, BCP47Code.UG_ARAB_CN)
        append(MI_NZ, BCP47Code.MI_NZ)
        append(AR_IQ, BCP47Code.AR_IQ)
        append(ZH_CN, BCP47Code.ZH_CN)
        append(DE_CH, BCP47Code.DE_CH)
        append(EN_GB, BCP47Code.EN_GB)
        append(ES_MX, BCP47Code.ES_MX)
        append(FR_BE, BCP47Code.FR_BE)
        append(IT_CH, BCP47Code.IT_CH)
        append(NL_BE, BCP47Code.NL_BE)
        append(NN_NO, BCP47Code.NN_NO)
        append(PT_PT, BCP47Code.PT_PT)
        append(RO_MD, BCP47Code.RO_MD)
        append(RU_MD, BCP47Code.RU_MD)
        append(SR_LATN_CS, BCP47Code.SR_LATN_CS)
        append(SV_FI, BCP47Code.SV_FI)
        append(UR_IN, BCP47Code.UR_IN)
        append(AZ_CYRL_AZ, BCP47Code.AZ_CYRL_AZ)
        append(GA_IE, BCP47Code.GA_IE)
        append(MS_BN, BCP47Code.MS_BN)
        append(UZ_CYRL_UZ, BCP47Code.UZ_CYRL_UZ)
        append(BN_BD, BCP47Code.BN_BD)
        append(PA_PK, BCP47Code.PA_PK)
        append(MN_MONG_CN, BCP47Code.MN_MONG_CN)
        append(BO_BT, BCP47Code.BO_BT)
        append(SD_PK, BCP47Code.SD_PK)
        append(TZM_LATN_DZ, BCP47Code.TZM_LATN_DZ)
        append(KS_DEVA_IN, BCP47Code.KS_DEVA_IN)
        append(NE_IN, BCP47Code.NE_IN)
        append(QUZ_EC, BCP47Code.QUZ_EC)
        append(TI_ET, BCP47Code.TI_ET)
        append(AR_EG, BCP47Code.AR_EG)
        append(ZH_HK, BCP47Code.ZH_HK)
        append(DE_AT, BCP47Code.DE_AT)
        append(EN_AU, BCP47Code.EN_AU)
        append(FR_CA, BCP47Code.FR_CA)
        append(SR_CYRL_CS, BCP47Code.SR_CYRL_CS)
        append(QUZ_PE, BCP47Code.QUZ_PE)
        append(AR_LY, BCP47Code.AR_LY)
        append(ZH_SG, BCP47Code.ZH_SG)
        append(DE_LU, BCP47Code.DE_LU)
        append(EN_CA, BCP47Code.EN_CA)
        append(ES_GT, BCP47Code.ES_GT)
        append(FR_CH, BCP47Code.FR_CH)
        append(HR_BA, BCP47Code.HR_BA)
        append(AR_DZ, BCP47Code.AR_DZ)
        append(ZH_MO, BCP47Code.ZH_MO)
        append(DE_LI, BCP47Code.DE_LI)
        append(EN_NZ, BCP47Code.EN_NZ)
        append(ES_CR, BCP47Code.ES_CR)
        append(FR_LU, BCP47Code.FR_LU)
        append(BS_LATN_BA, BCP47Code.BS_LATN_BA)
        append(AR_MO, BCP47Code.AR_MO)
        append(EN_IE, BCP47Code.EN_IE)
        append(ES_PA, BCP47Code.ES_PA)
        append(FR_MC, BCP47Code.FR_MC)
        append(AR_TN, BCP47Code.AR_TN)
        append(EN_ZA, BCP47Code.EN_ZA)
        append(ES_DO, BCP47Code.ES_DO)
        append(FR_029, BCP47Code.FR_029)
        append(AR_OM, BCP47Code.AR_OM)
        append(EN_JM, BCP47Code.EN_JM)
        append(ES_VE, BCP47Code.ES_VE)
        append(FR_RE, BCP47Code.FR_RE)
        append(AR_YE, BCP47Code.AR_YE)
        append(EN_029, BCP47Code.EN_029)
        append(ES_CO, BCP47Code.ES_CO)
        append(FR_CG, BCP47Code.FR_CG)
        append(AR_SY, BCP47Code.AR_SY)
        append(EN_BZ, BCP47Code.EN_BZ)
        append(ES_PE, BCP47Code.ES_PE)
        append(FR_SN, BCP47Code.FR_SN)
        append(AR_JO, BCP47Code.AR_JO)
        append(EN_TT, BCP47Code.EN_TT)
        append(ES_AR, BCP47Code.ES_AR)
        append(FR_CM, BCP47Code.FR_CM)
        append(AR_LB, BCP47Code.AR_LB)
        append(EN_ZW, BCP47Code.EN_ZW)
        append(ES_EC, BCP47Code.ES_EC)
        append(FR_CI, BCP47Code.FR_CI)
        append(AR_KW, BCP47Code.AR_KW)
        append(EN_PH, BCP47Code.EN_PH)
        append(ES_CL, BCP47Code.ES_CL)
        append(FR_ML, BCP47Code.FR_ML)
        append(AR_AE, BCP47Code.AR_AE)
        append(EN_ID, BCP47Code.EN_ID)
        append(ES_UY, BCP47Code.ES_UY)
        append(FR_MA, BCP47Code.FR_MA)
        append(AR_BH, BCP47Code.AR_BH)
        append(EN_HK, BCP47Code.EN_HK)
        append(ES_PY, BCP47Code.ES_PY)
        append(FR_HT, BCP47Code.FR_HT)
        append(AR_QA, BCP47Code.AR_QA)
        append(EN_IN, BCP47Code.EN_IN)
        append(ES_BO, BCP47Code.ES_BO)
        append(EN_MY, BCP47Code.EN_MY)
        append(ES_SV, BCP47Code.ES_SV)
        append(EN_SG, BCP47Code.EN_SG)
        append(ES_HN, BCP47Code.ES_HN)
        append(ES_NI, BCP47Code.ES_NI)
        append(ES_PR, BCP47Code.ES_PR)
        append(ES_US, BCP47Code.ES_US)
        append(ES_419, BCP47Code.ES_419)
        append(FR_015, BCP47Code.FR_015)
    }

    fun getBcp47Code(localeID: Int): String? {
        return LOCALE_ID_MAP[localeID]
    }

    fun contains(localeID: Int): Boolean {
        return LOCALE_ID_MAP.indexOfKey(localeID) >= 0
    }
}
