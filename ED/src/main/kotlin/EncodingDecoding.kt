/**
 * Encoding decoding
 * 第一版编码 1.0
 * @constructor Create empty Encoding decoding
 */
object EncodingDecoding {

    private const val byteE0: Byte = 0
    private const val byteE1: Byte = 1
    private const val byteE2: Byte = 2
    private const val byteE3: Byte = 3
    private const val byteE4: Byte = 4
    private const val byteE5: Byte = 5
    private const val byteE6: Byte = 6
    private const val byteE7: Byte = 7
    private const val byteE8: Byte = 8
    private const val byteE9: Byte = 9
    private const val byteE10: Byte = 10
    private const val byteE11: Byte = 11
    private const val byteE12: Byte = 12
    private const val byteE13: Byte = 13
    private const val byteE14: Byte = 14
    private const val byteE15: Byte = 15
    private const val byteE16: Byte = 16
    private const val byteE17: Byte = 17
    private const val byteE18: Byte = 18
    private const val byteE19: Byte = 19
    private const val byteE20: Byte = 20
    private const val byteE21: Byte = 21
    private const val byteE22: Byte = 22
    private const val byteE23: Byte = 23
    private const val byteE24: Byte = 24
    private const val byteE25: Byte = 25
    private const val byteE26: Byte = 26
    private const val byteE27: Byte = 27
    private const val byteE28: Byte = 28
    private const val byteE29: Byte = 29
    private const val byteE30: Byte = 30
    private const val byteE31: Byte = 31
    private const val byteE32: Byte = 32
    private const val byteE33: Byte = 33
    private const val byteE34: Byte = 34
    private const val byteE35: Byte = 35
    private const val byteE36: Byte = 36
    private const val byteE37: Byte = 37
    private const val byteE38: Byte = 38
    private const val byteE39: Byte = 39
    private const val byteE40: Byte = 40
    private const val byteE41: Byte = 41
    private const val byteE42: Byte = 42
    private const val byteE43: Byte = 43
    private const val byteE44: Byte = 44
    private const val byteE45: Byte = 45
    private const val byteE46: Byte = 46
    private const val byteE47: Byte = 47
    private const val byteE48: Byte = 48
    private const val byteE49: Byte = 49
    private const val byteE50: Byte = 50
    private const val byteE51: Byte = 51
    private const val byteE52: Byte = 52
    private const val byteE53: Byte = 53
    private const val byteE54: Byte = 54
    private const val byteE55: Byte = 55
    private const val byteE56: Byte = 56
    private const val byteE57: Byte = 57
    private const val byteE58: Byte = 58
    private const val byteE59: Byte = 59
    private const val byteE60: Byte = 60
    private const val byteE61: Byte = 61
    private const val byteE62: Byte = 62
    private const val byteE63: Byte = 63
    private const val byteE64: Byte = 64
    private const val byteE65: Byte = 65
    private const val byteE66: Byte = 66
    private const val byteE67: Byte = 67
    private const val byteE68: Byte = 68
    private const val byteE69: Byte = 69
    private const val byteE70: Byte = 70
    private const val byteE71: Byte = 71
    private const val byteE72: Byte = 72
    private const val byteE73: Byte = 73
    private const val byteE74: Byte = 74
    private const val byteE75: Byte = 75
    private const val byteE76: Byte = 76
    private const val byteE77: Byte = 77
    private const val byteE78: Byte = 78
    private const val byteE79: Byte = 79
    private const val byteE80: Byte = 80
    private const val byteE81: Byte = 81
    private const val byteE82: Byte = 82
    private const val byteE83: Byte = 83
    private const val byteE84: Byte = 84
    private const val byteE85: Byte = 85
    private const val byteE86: Byte = 86
    private const val byteE87: Byte = 87
    private const val byteE88: Byte = 88
    private const val byteE89: Byte = 89
    private const val byteE90: Byte = 90
    private const val byteE91: Byte = 91
    private const val byteE92: Byte = 92
    private const val byteE93: Byte = 93
    private const val byteE94: Byte = 94
    private const val byteE95: Byte = 95
    private const val byteE96: Byte = 96
    private const val byteE97: Byte = 97
    private const val byteE98: Byte = 98
    private const val byteE99: Byte = 99
    private const val byteE100: Byte = 100
    private const val byteE101: Byte = 101
    private const val byteE102: Byte = 102
    private const val byteE103: Byte = 103
    private const val byteE104: Byte = 104
    private const val byteE105: Byte = 105
    private const val byteE106: Byte = 106
    private const val byteE107: Byte = 107
    private const val byteE108: Byte = 108
    private const val byteE109: Byte = 109
    private const val byteE110: Byte = 110
    private const val byteE111: Byte = 111
    private const val byteE112: Byte = 112
    private const val byteE113: Byte = 113
    private const val byteE114: Byte = 114
    private const val byteE115: Byte = 115
    private const val byteE116: Byte = 116
    private const val byteE117: Byte = 117
    private const val byteE118: Byte = 118
    private const val byteE119: Byte = 119
    private const val byteE120: Byte = 120
    private const val byteE121: Byte = 121
    private const val byteE122: Byte = 122
    private const val byteE123: Byte = 123
    private const val byteE124: Byte = 124
    private const val byteE125: Byte = 125
    private const val byteE126: Byte = 126
    private const val byteE127: Byte = 127
    private const val byteE_1: Byte = -1
    private const val byteE_2: Byte = -2
    private const val byteE_3: Byte = -3
    private const val byteE_4: Byte = -4
    private const val byteE_5: Byte = -5
    private const val byteE_6: Byte = -6
    private const val byteE_7: Byte = -7
    private const val byteE_8: Byte = -8
    private const val byteE_9: Byte = -9
    private const val byteE_10: Byte = -10
    private const val byteE_11: Byte = -11
    private const val byteE_12: Byte = -12
    private const val byteE_13: Byte = -13
    private const val byteE_14: Byte = -14
    private const val byteE_15: Byte = -15
    private const val byteE_16: Byte = -16
    private const val byteE_17: Byte = -17
    private const val byteE_18: Byte = -18
    private const val byteE_19: Byte = -19
    private const val byteE_20: Byte = -20
    private const val byteE_21: Byte = -21
    private const val byteE_22: Byte = -22
    private const val byteE_23: Byte = -23
    private const val byteE_24: Byte = -24
    private const val byteE_25: Byte = -25
    private const val byteE_26: Byte = -26
    private const val byteE_27: Byte = -27
    private const val byteE_28: Byte = -28
    private const val byteE_29: Byte = -29
    private const val byteE_30: Byte = -30
    private const val byteE_31: Byte = -31
    private const val byteE_32: Byte = -32
    private const val byteE_33: Byte = -33
    private const val byteE_34: Byte = -34
    private const val byteE_35: Byte = -35
    private const val byteE_36: Byte = -36
    private const val byteE_37: Byte = -37
    private const val byteE_38: Byte = -38
    private const val byteE_39: Byte = -39
    private const val byteE_40: Byte = -40
    private const val byteE_41: Byte = -41
    private const val byteE_42: Byte = -42
    private const val byteE_43: Byte = -43
    private const val byteE_44: Byte = -44
    private const val byteE_45: Byte = -45
    private const val byteE_46: Byte = -46
    private const val byteE_47: Byte = -47
    private const val byteE_48: Byte = -48
    private const val byteE_49: Byte = -49
    private const val byteE_50: Byte = -50
    private const val byteE_51: Byte = -51
    private const val byteE_52: Byte = -52
    private const val byteE_53: Byte = -53
    private const val byteE_54: Byte = -54
    private const val byteE_55: Byte = -55
    private const val byteE_56: Byte = -56
    private const val byteE_57: Byte = -57
    private const val byteE_58: Byte = -58
    private const val byteE_59: Byte = -59
    private const val byteE_60: Byte = -60
    private const val byteE_61: Byte = -61
    private const val byteE_62: Byte = -62
    private const val byteE_63: Byte = -63
    private const val byteE_64: Byte = -64
    private const val byteE_65: Byte = -65
    private const val byteE_66: Byte = -66
    private const val byteE_67: Byte = -67
    private const val byteE_68: Byte = -68
    private const val byteE_69: Byte = -69
    private const val byteE_70: Byte = -70
    private const val byteE_71: Byte = -71
    private const val byteE_72: Byte = -72
    private const val byteE_73: Byte = -73
    private const val byteE_74: Byte = -74
    private const val byteE_75: Byte = -75
    private const val byteE_76: Byte = -76
    private const val byteE_77: Byte = -77
    private const val byteE_78: Byte = -78
    private const val byteE_79: Byte = -79
    private const val byteE_80: Byte = -80
    private const val byteE_81: Byte = -81
    private const val byteE_82: Byte = -82
    private const val byteE_83: Byte = -83
    private const val byteE_84: Byte = -84
    private const val byteE_85: Byte = -85
    private const val byteE_86: Byte = -86
    private const val byteE_87: Byte = -87
    private const val byteE_88: Byte = -88
    private const val byteE_89: Byte = -89
    private const val byteE_90: Byte = -90
    private const val byteE_91: Byte = -91
    private const val byteE_92: Byte = -92
    private const val byteE_93: Byte = -93
    private const val byteE_94: Byte = -94
    private const val byteE_95: Byte = -95
    private const val byteE_96: Byte = -96
    private const val byteE_97: Byte = -97
    private const val byteE_98: Byte = -98
    private const val byteE_99: Byte = -99
    private const val byteE_100: Byte = -100
    private const val byteE_101: Byte = -101
    private const val byteE_102: Byte = -102
    private const val byteE_103: Byte = -103
    private const val byteE_104: Byte = -104
    private const val byteE_105: Byte = -105
    private const val byteE_106: Byte = -106
    private const val byteE_107: Byte = -107
    private const val byteE_108: Byte = -108
    private const val byteE_109: Byte = -109
    private const val byteE_110: Byte = -110
    private const val byteE_111: Byte = -111
    private const val byteE_112: Byte = -112
    private const val byteE_113: Byte = -113
    private const val byteE_114: Byte = -114
    private const val byteE_115: Byte = -115
    private const val byteE_116: Byte = -116
    private const val byteE_117: Byte = -117
    private const val byteE_118: Byte = -118
    private const val byteE_119: Byte = -119
    private const val byteE_120: Byte = -120
    private const val byteE_121: Byte = -121
    private const val byteE_122: Byte = -122
    private const val byteE_123: Byte = -123
    private const val byteE_124: Byte = -124
    private const val byteE_125: Byte = -125
    private const val byteE_126: Byte = -126
    private const val byteE_127: Byte = -127
    private const val byteE_128: Byte = -128


    private const val byteD_128: Byte = -72
    private const val byteD0: Byte = 71
    private const val byteD1: Byte = 51
    private const val byteD2: Byte = 14
    private const val byteD3: Byte = 60
    private const val byteD4: Byte = 28
    private const val byteD5: Byte = 67
    private const val byteD6: Byte = 111
    private const val byteD7: Byte = 122
    private const val byteD8: Byte = 46
    private const val byteD9: Byte = 63
    private const val byteD10: Byte = 78
    private const val byteD11: Byte = 54
    private const val byteD12: Byte = 119
    private const val byteD13: Byte = 36
    private const val byteD14: Byte = 55
    private const val byteD15: Byte = 61
    private const val byteD16: Byte = 115
    private const val byteD17: Byte = 53
    private const val byteD18: Byte = 45
    private const val byteD19: Byte = 99
    private const val byteD20: Byte = 68
    private const val byteD21: Byte = 13
    private const val byteD22: Byte = 33
    private const val byteD23: Byte = 11
    private const val byteD24: Byte = 17
    private const val byteD25: Byte = 39
    private const val byteD26: Byte = 27
    private const val byteD27: Byte = 117
    private const val byteD28: Byte = 106
    private const val byteD29: Byte = 2
    private const val byteD30: Byte = 43
    private const val byteD31: Byte = 73
    private const val byteD32: Byte = 3
    private const val byteD33: Byte = 83
    private const val byteD34: Byte = 76
    private const val byteD35: Byte = 123
    private const val byteD36: Byte = 118
    private const val byteD37: Byte = 50
    private const val byteD38: Byte = 59
    private const val byteD39: Byte = 91
    private const val byteD40: Byte = 107
    private const val byteD41: Byte = 57
    private const val byteD42: Byte = 105
    private const val byteD43: Byte = 88
    private const val byteD44: Byte = 44
    private const val byteD45: Byte = 108
    private const val byteD46: Byte = 15
    private const val byteD47: Byte = 9
    private const val byteD48: Byte = 35
    private const val byteD49: Byte = 21
    private const val byteD50: Byte = 112
    private const val byteD51: Byte = 62
    private const val byteD52: Byte = 7
    private const val byteD53: Byte = 72
    private const val byteD54: Byte = 126
    private const val byteD55: Byte = 37
    private const val byteD56: Byte = 34
    private const val byteD57: Byte = 81
    private const val byteD58: Byte = 109
    private const val byteD59: Byte = 8
    private const val byteD60: Byte = 66
    private const val byteD61: Byte = 40
    private const val byteD62: Byte = 94
    private const val byteD63: Byte = 84
    private const val byteD64: Byte = 127
    private const val byteD65: Byte = 20
    private const val byteD66: Byte = 29
    private const val byteD67: Byte = 47
    private const val byteD68: Byte = 23
    private const val byteD69: Byte = 96
    private const val byteD70: Byte = 0
    private const val byteD71: Byte = 31
    private const val byteD72: Byte = 41
    private const val byteD73: Byte = 92
    private const val byteD74: Byte = 79
    private const val byteD75: Byte = 65
    private const val byteD76: Byte = 69
    private const val byteD77: Byte = 113
    private const val byteD78: Byte = 98
    private const val byteD79: Byte = 124
    private const val byteD80: Byte = 114
    private const val byteD81: Byte = 80
    private const val byteD82: Byte = 125
    private const val byteD83: Byte = 74
    private const val byteD84: Byte = 97
    private const val byteD85: Byte = 95
    private const val byteD86: Byte = 25
    private const val byteD87: Byte = 30
    private const val byteD88: Byte = 4
    private const val byteD89: Byte = 102
    private const val byteD90: Byte = 24
    private const val byteD91: Byte = 10
    private const val byteD92: Byte = 93
    private const val byteD93: Byte = 64
    private const val byteD94: Byte = 56
    private const val byteD95: Byte = 18
    private const val byteD96: Byte = 32
    private const val byteD97: Byte = 52
    private const val byteD98: Byte = 48
    private const val byteD99: Byte = 86
    private const val byteD100: Byte = 82
    private const val byteD101: Byte = 101
    private const val byteD102: Byte = 58
    private const val byteD103: Byte = 22
    private const val byteD104: Byte = 89
    private const val byteD105: Byte = 70
    private const val byteD106: Byte = 19
    private const val byteD107: Byte = 12
    private const val byteD108: Byte = 6
    private const val byteD109: Byte = 75
    private const val byteD110: Byte = 16
    private const val byteD111: Byte = 103
    private const val byteD112: Byte = 90
    private const val byteD113: Byte = 26
    private const val byteD114: Byte = 87
    private const val byteD115: Byte = 5
    private const val byteD116: Byte = 100
    private const val byteD117: Byte = 121
    private const val byteD118: Byte = 1
    private const val byteD119: Byte = 120
    private const val byteD120: Byte = 49
    private const val byteD121: Byte = 85
    private const val byteD122: Byte = 116
    private const val byteD123: Byte = 42
    private const val byteD124: Byte = 77
    private const val byteD125: Byte = 38
    private const val byteD126: Byte = 104
    private const val byteD127: Byte = 110
    private const val byteD_1: Byte = -34
    private const val byteD_2: Byte = -6
    private const val byteD_3: Byte = -111
    private const val byteD_4: Byte = -112
    private const val byteD_5: Byte = -22
    private const val byteD_6: Byte = -28
    private const val byteD_7: Byte = -38
    private const val byteD_8: Byte = -99
    private const val byteD_9: Byte = -53
    private const val byteD_10: Byte = -18
    private const val byteD_11: Byte = -57
    private const val byteD_12: Byte = -51
    private const val byteD_13: Byte = -125
    private const val byteD_14: Byte = -5
    private const val byteD_15: Byte = -21
    private const val byteD_16: Byte = -123
    private const val byteD_17: Byte = -19
    private const val byteD_18: Byte = -29
    private const val byteD_19: Byte = -55
    private const val byteD_20: Byte = -102
    private const val byteD_21: Byte = -81
    private const val byteD_22: Byte = -37
    private const val byteD_23: Byte = -17
    private const val byteD_24: Byte = -73
    private const val byteD_25: Byte = -59
    private const val byteD_26: Byte = -27
    private const val byteD_27: Byte = -96
    private const val byteD_28: Byte = -121
    private const val byteD_29: Byte = -103
    private const val byteD_30: Byte = -107
    private const val byteD_31: Byte = -63
    private const val byteD_32: Byte = -3
    private const val byteD_33: Byte = -14
    private const val byteD_34: Byte = -116
    private const val byteD_35: Byte = -24
    private const val byteD_36: Byte = -61
    private const val byteD_37: Byte = -118
    private const val byteD_38: Byte = -117
    private const val byteD_39: Byte = -75
    private const val byteD_40: Byte = -109
    private const val byteD_41: Byte = -94
    private const val byteD_42: Byte = -9
    private const val byteD_43: Byte = -44
    private const val byteD_44: Byte = -82
    private const val byteD_45: Byte = -84
    private const val byteD_46: Byte = -114
    private const val byteD_47: Byte = -83
    private const val byteD_48: Byte = -122
    private const val byteD_49: Byte = -101
    private const val byteD_50: Byte = -2
    private const val byteD_51: Byte = -104
    private const val byteD_52: Byte = -105
    private const val byteD_53: Byte = -46
    private const val byteD_54: Byte = -66
    private const val byteD_55: Byte = -119
    private const val byteD_56: Byte = -10
    private const val byteD_57: Byte = -16
    private const val byteD_58: Byte = -39
    private const val byteD_59: Byte = -113
    private const val byteD_60: Byte = -77
    private const val byteD_61: Byte = -74
    private const val byteD_62: Byte = -26
    private const val byteD_63: Byte = -93
    private const val byteD_64: Byte = -11
    private const val byteD_65: Byte = -32
    private const val byteD_66: Byte = -108
    private const val byteD_67: Byte = -36
    private const val byteD_68: Byte = -106
    private const val byteD_69: Byte = -60
    private const val byteD_70: Byte = -65
    private const val byteD_71: Byte = -110
    private const val byteD_72: Byte = -126
    private const val byteD_73: Byte = -78
    private const val byteD_74: Byte = -30
    private const val byteD_75: Byte = -52
    private const val byteD_76: Byte = -4
    private const val byteD_77: Byte = -7
    private const val byteD_78: Byte = -1
    private const val byteD_79: Byte = -70
    private const val byteD_80: Byte = -47
    private const val byteD_81: Byte = -62
    private const val byteD_82: Byte = -97
    private const val byteD_83: Byte = -90
    private const val byteD_84: Byte = -40
    private const val byteD_85: Byte = -50
    private const val byteD_86: Byte = -48
    private const val byteD_87: Byte = -45
    private const val byteD_88: Byte = -127
    private const val byteD_89: Byte = -71
    private const val byteD_90: Byte = -25
    private const val byteD_91: Byte = -31
    private const val byteD_92: Byte = -15
    private const val byteD_93: Byte = -128
    private const val byteD_94: Byte = -88
    private const val byteD_95: Byte = -58
    private const val byteD_96: Byte = -12
    private const val byteD_97: Byte = -56
    private const val byteD_98: Byte = -42
    private const val byteD_99: Byte = -69
    private const val byteD_100: Byte = -67
    private const val byteD_101: Byte = -85
    private const val byteD_102: Byte = -115
    private const val byteD_103: Byte = -49
    private const val byteD_104: Byte = -64
    private const val byteD_105: Byte = -92
    private const val byteD_106: Byte = -43
    private const val byteD_107: Byte = -23
    private const val byteD_108: Byte = -68
    private const val byteD_109: Byte = -91
    private const val byteD_110: Byte = -41
    private const val byteD_111: Byte = -124
    private const val byteD_112: Byte = -13
    private const val byteD_113: Byte = -20
    private const val byteD_114: Byte = -33
    private const val byteD_115: Byte = -89
    private const val byteD_116: Byte = -35
    private const val byteD_117: Byte = -54
    private const val byteD_118: Byte = -120
    private const val byteD_119: Byte = -80
    private const val byteD_120: Byte = -79
    private const val byteD_121: Byte = -100
    private const val byteD_122: Byte = -8
    private const val byteD_123: Byte = -76
    private const val byteD_124: Byte = -98
    private const val byteD_125: Byte = -95
    private const val byteD_126: Byte = -87
    private const val byteD_127: Byte = -86


    fun encoding(byte: Byte): Byte {

        return when (byte) {
            byteE0 -> byteD_128
            byteE_128 -> byteD0

            byteE1 -> byteD_1
            byteE2 -> byteD_2
            byteE3 -> byteD_3
            byteE4 -> byteD_4
            byteE5 -> byteD_5
            byteE6 -> byteD_6
            byteE7 -> byteD_7
            byteE8 -> byteD_8
            byteE9 -> byteD_9
            byteE10 -> byteD_10
            byteE11 -> byteD_11
            byteE12 -> byteD_12
            byteE13 -> byteD_13
            byteE14 -> byteD_14
            byteE15 -> byteD_15
            byteE16 -> byteD_16
            byteE17 -> byteD_17
            byteE18 -> byteD_18
            byteE19 -> byteD_19
            byteE20 -> byteD_20
            byteE21 -> byteD_21
            byteE22 -> byteD_22
            byteE23 -> byteD_23
            byteE24 -> byteD_24
            byteE25 -> byteD_25
            byteE26 -> byteD_26
            byteE27 -> byteD_27
            byteE28 -> byteD_28
            byteE29 -> byteD_29
            byteE30 -> byteD_30
            byteE31 -> byteD_31
            byteE32 -> byteD_32
            byteE33 -> byteD_33
            byteE34 -> byteD_34
            byteE35 -> byteD_35
            byteE36 -> byteD_36
            byteE37 -> byteD_37
            byteE38 -> byteD_38
            byteE39 -> byteD_39
            byteE40 -> byteD_40
            byteE41 -> byteD_41
            byteE42 -> byteD_42
            byteE43 -> byteD_43
            byteE44 -> byteD_44
            byteE45 -> byteD_45
            byteE46 -> byteD_46
            byteE47 -> byteD_47
            byteE48 -> byteD_48
            byteE49 -> byteD_49
            byteE50 -> byteD_50
            byteE51 -> byteD_51
            byteE52 -> byteD_52
            byteE53 -> byteD_53
            byteE54 -> byteD_54
            byteE55 -> byteD_55
            byteE56 -> byteD_56
            byteE57 -> byteD_57
            byteE58 -> byteD_58
            byteE59 -> byteD_59
            byteE60 -> byteD_60
            byteE61 -> byteD_61
            byteE62 -> byteD_62
            byteE63 -> byteD_63
            byteE64 -> byteD_64
            byteE65 -> byteD_65
            byteE66 -> byteD_66
            byteE67 -> byteD_67
            byteE68 -> byteD_68
            byteE69 -> byteD_69
            byteE70 -> byteD_70
            byteE71 -> byteD_71
            byteE72 -> byteD_72
            byteE73 -> byteD_73
            byteE74 -> byteD_74
            byteE75 -> byteD_75
            byteE76 -> byteD_76
            byteE77 -> byteD_77
            byteE78 -> byteD_78
            byteE79 -> byteD_79
            byteE80 -> byteD_80
            byteE81 -> byteD_81
            byteE82 -> byteD_82
            byteE83 -> byteD_83
            byteE84 -> byteD_84
            byteE85 -> byteD_85
            byteE86 -> byteD_86
            byteE87 -> byteD_87
            byteE88 -> byteD_88
            byteE89 -> byteD_89
            byteE90 -> byteD_90
            byteE91 -> byteD_91
            byteE92 -> byteD_92
            byteE93 -> byteD_93
            byteE94 -> byteD_94
            byteE95 -> byteD_95
            byteE96 -> byteD_96
            byteE97 -> byteD_97
            byteE98 -> byteD_98
            byteE99 -> byteD_99
            byteE100 -> byteD_100
            byteE101 -> byteD_101
            byteE102 -> byteD_102
            byteE103 -> byteD_103
            byteE104 -> byteD_104
            byteE105 -> byteD_105
            byteE106 -> byteD_106
            byteE107 -> byteD_107
            byteE108 -> byteD_108
            byteE109 -> byteD_109
            byteE110 -> byteD_110
            byteE111 -> byteD_111
            byteE112 -> byteD_112
            byteE113 -> byteD_113
            byteE114 -> byteD_114
            byteE115 -> byteD_115
            byteE116 -> byteD_116
            byteE117 -> byteD_117
            byteE118 -> byteD_118
            byteE119 -> byteD_119
            byteE120 -> byteD_120
            byteE121 -> byteD_121
            byteE122 -> byteD_122
            byteE123 -> byteD_123
            byteE124 -> byteD_124
            byteE125 -> byteD_125
            byteE126 -> byteD_126
            byteE127 -> byteD_127
            byteE_1 -> byteD1
            byteE_2 -> byteD2
            byteE_3 -> byteD3
            byteE_4 -> byteD4
            byteE_5 -> byteD5
            byteE_6 -> byteD6
            byteE_7 -> byteD7
            byteE_8 -> byteD8
            byteE_9 -> byteD9
            byteE_10 -> byteD10
            byteE_11 -> byteD11
            byteE_12 -> byteD12
            byteE_13 -> byteD13
            byteE_14 -> byteD14
            byteE_15 -> byteD15
            byteE_16 -> byteD16
            byteE_17 -> byteD17
            byteE_18 -> byteD18
            byteE_19 -> byteD19
            byteE_20 -> byteD20
            byteE_21 -> byteD21
            byteE_22 -> byteD22
            byteE_23 -> byteD23
            byteE_24 -> byteD24
            byteE_25 -> byteD25
            byteE_26 -> byteD26
            byteE_27 -> byteD27
            byteE_28 -> byteD28
            byteE_29 -> byteD29
            byteE_30 -> byteD30
            byteE_31 -> byteD31
            byteE_32 -> byteD32
            byteE_33 -> byteD33
            byteE_34 -> byteD34
            byteE_35 -> byteD35
            byteE_36 -> byteD36
            byteE_37 -> byteD37
            byteE_38 -> byteD38
            byteE_39 -> byteD39
            byteE_40 -> byteD40
            byteE_41 -> byteD41
            byteE_42 -> byteD42
            byteE_43 -> byteD43
            byteE_44 -> byteD44
            byteE_45 -> byteD45
            byteE_46 -> byteD46
            byteE_47 -> byteD47
            byteE_48 -> byteD48
            byteE_49 -> byteD49
            byteE_50 -> byteD50
            byteE_51 -> byteD51
            byteE_52 -> byteD52
            byteE_53 -> byteD53
            byteE_54 -> byteD54
            byteE_55 -> byteD55
            byteE_56 -> byteD56
            byteE_57 -> byteD57
            byteE_58 -> byteD58
            byteE_59 -> byteD59
            byteE_60 -> byteD60
            byteE_61 -> byteD61
            byteE_62 -> byteD62
            byteE_63 -> byteD63
            byteE_64 -> byteD64
            byteE_65 -> byteD65
            byteE_66 -> byteD66
            byteE_67 -> byteD67
            byteE_68 -> byteD68
            byteE_69 -> byteD69
            byteE_70 -> byteD70
            byteE_71 -> byteD71
            byteE_72 -> byteD72
            byteE_73 -> byteD73
            byteE_74 -> byteD74
            byteE_75 -> byteD75
            byteE_76 -> byteD76
            byteE_77 -> byteD77
            byteE_78 -> byteD78
            byteE_79 -> byteD79
            byteE_80 -> byteD80
            byteE_81 -> byteD81
            byteE_82 -> byteD82
            byteE_83 -> byteD83
            byteE_84 -> byteD84
            byteE_85 -> byteD85
            byteE_86 -> byteD86
            byteE_87 -> byteD87
            byteE_88 -> byteD88
            byteE_89 -> byteD89
            byteE_90 -> byteD90
            byteE_91 -> byteD91
            byteE_92 -> byteD92
            byteE_93 -> byteD93
            byteE_94 -> byteD94
            byteE_95 -> byteD95
            byteE_96 -> byteD96
            byteE_97 -> byteD97
            byteE_98 -> byteD98
            byteE_99 -> byteD99
            byteE_100 -> byteD100
            byteE_101 -> byteD101
            byteE_102 -> byteD102
            byteE_103 -> byteD103
            byteE_104 -> byteD104
            byteE_105 -> byteD105
            byteE_106 -> byteD106
            byteE_107 -> byteD107
            byteE_108 -> byteD108
            byteE_109 -> byteD109
            byteE_110 -> byteD110
            byteE_111 -> byteD111
            byteE_112 -> byteD112
            byteE_113 -> byteD113
            byteE_114 -> byteD114
            byteE_115 -> byteD115
            byteE_116 -> byteD116
            byteE_117 -> byteD117
            byteE_118 -> byteD118
            byteE_119 -> byteD119
            byteE_120 -> byteD120
            byteE_121 -> byteD121
            byteE_122 -> byteD122
            byteE_123 -> byteD123
            byteE_124 -> byteD124
            byteE_125 -> byteD125
            byteE_126 -> byteD126
            byteE_127 -> byteD127

            else -> {
                0
            }
        }


    }

    fun decoding(byte: Byte): Byte {
        return when (byte) {
            byteD0 -> byteE_128
            byteD_128 -> byteE0

            byteD1 -> byteE_1
            byteD2 -> byteE_2
            byteD3 -> byteE_3
            byteD4 -> byteE_4
            byteD5 -> byteE_5
            byteD6 -> byteE_6
            byteD7 -> byteE_7
            byteD8 -> byteE_8
            byteD9 -> byteE_9
            byteD10 -> byteE_10
            byteD11 -> byteE_11
            byteD12 -> byteE_12
            byteD13 -> byteE_13
            byteD14 -> byteE_14
            byteD15 -> byteE_15
            byteD16 -> byteE_16
            byteD17 -> byteE_17
            byteD18 -> byteE_18
            byteD19 -> byteE_19
            byteD20 -> byteE_20
            byteD21 -> byteE_21
            byteD22 -> byteE_22
            byteD23 -> byteE_23
            byteD24 -> byteE_24
            byteD25 -> byteE_25
            byteD26 -> byteE_26
            byteD27 -> byteE_27
            byteD28 -> byteE_28
            byteD29 -> byteE_29
            byteD30 -> byteE_30
            byteD31 -> byteE_31
            byteD32 -> byteE_32
            byteD33 -> byteE_33
            byteD34 -> byteE_34
            byteD35 -> byteE_35
            byteD36 -> byteE_36
            byteD37 -> byteE_37
            byteD38 -> byteE_38
            byteD39 -> byteE_39
            byteD40 -> byteE_40
            byteD41 -> byteE_41
            byteD42 -> byteE_42
            byteD43 -> byteE_43
            byteD44 -> byteE_44
            byteD45 -> byteE_45
            byteD46 -> byteE_46
            byteD47 -> byteE_47
            byteD48 -> byteE_48
            byteD49 -> byteE_49
            byteD50 -> byteE_50
            byteD51 -> byteE_51
            byteD52 -> byteE_52
            byteD53 -> byteE_53
            byteD54 -> byteE_54
            byteD55 -> byteE_55
            byteD56 -> byteE_56
            byteD57 -> byteE_57
            byteD58 -> byteE_58
            byteD59 -> byteE_59
            byteD60 -> byteE_60
            byteD61 -> byteE_61
            byteD62 -> byteE_62
            byteD63 -> byteE_63
            byteD64 -> byteE_64
            byteD65 -> byteE_65
            byteD66 -> byteE_66
            byteD67 -> byteE_67
            byteD68 -> byteE_68
            byteD69 -> byteE_69
            byteD70 -> byteE_70
            byteD71 -> byteE_71
            byteD72 -> byteE_72
            byteD73 -> byteE_73
            byteD74 -> byteE_74
            byteD75 -> byteE_75
            byteD76 -> byteE_76
            byteD77 -> byteE_77
            byteD78 -> byteE_78
            byteD79 -> byteE_79
            byteD80 -> byteE_80
            byteD81 -> byteE_81
            byteD82 -> byteE_82
            byteD83 -> byteE_83
            byteD84 -> byteE_84
            byteD85 -> byteE_85
            byteD86 -> byteE_86
            byteD87 -> byteE_87
            byteD88 -> byteE_88
            byteD89 -> byteE_89
            byteD90 -> byteE_90
            byteD91 -> byteE_91
            byteD92 -> byteE_92
            byteD93 -> byteE_93
            byteD94 -> byteE_94
            byteD95 -> byteE_95
            byteD96 -> byteE_96
            byteD97 -> byteE_97
            byteD98 -> byteE_98
            byteD99 -> byteE_99
            byteD100 -> byteE_100
            byteD101 -> byteE_101
            byteD102 -> byteE_102
            byteD103 -> byteE_103
            byteD104 -> byteE_104
            byteD105 -> byteE_105
            byteD106 -> byteE_106
            byteD107 -> byteE_107
            byteD108 -> byteE_108
            byteD109 -> byteE_109
            byteD110 -> byteE_110
            byteD111 -> byteE_111
            byteD112 -> byteE_112
            byteD113 -> byteE_113
            byteD114 -> byteE_114
            byteD115 -> byteE_115
            byteD116 -> byteE_116
            byteD117 -> byteE_117
            byteD118 -> byteE_118
            byteD119 -> byteE_119
            byteD120 -> byteE_120
            byteD121 -> byteE_121
            byteD122 -> byteE_122
            byteD123 -> byteE_123
            byteD124 -> byteE_124
            byteD125 -> byteE_125
            byteD126 -> byteE_126
            byteD127 -> byteE_127
            byteD_1 -> byteE1
            byteD_2 -> byteE2
            byteD_3 -> byteE3
            byteD_4 -> byteE4
            byteD_5 -> byteE5
            byteD_6 -> byteE6
            byteD_7 -> byteE7
            byteD_8 -> byteE8
            byteD_9 -> byteE9
            byteD_10 -> byteE10
            byteD_11 -> byteE11
            byteD_12 -> byteE12
            byteD_13 -> byteE13
            byteD_14 -> byteE14
            byteD_15 -> byteE15
            byteD_16 -> byteE16
            byteD_17 -> byteE17
            byteD_18 -> byteE18
            byteD_19 -> byteE19
            byteD_20 -> byteE20
            byteD_21 -> byteE21
            byteD_22 -> byteE22
            byteD_23 -> byteE23
            byteD_24 -> byteE24
            byteD_25 -> byteE25
            byteD_26 -> byteE26
            byteD_27 -> byteE27
            byteD_28 -> byteE28
            byteD_29 -> byteE29
            byteD_30 -> byteE30
            byteD_31 -> byteE31
            byteD_32 -> byteE32
            byteD_33 -> byteE33
            byteD_34 -> byteE34
            byteD_35 -> byteE35
            byteD_36 -> byteE36
            byteD_37 -> byteE37
            byteD_38 -> byteE38
            byteD_39 -> byteE39
            byteD_40 -> byteE40
            byteD_41 -> byteE41
            byteD_42 -> byteE42
            byteD_43 -> byteE43
            byteD_44 -> byteE44
            byteD_45 -> byteE45
            byteD_46 -> byteE46
            byteD_47 -> byteE47
            byteD_48 -> byteE48
            byteD_49 -> byteE49
            byteD_50 -> byteE50
            byteD_51 -> byteE51
            byteD_52 -> byteE52
            byteD_53 -> byteE53
            byteD_54 -> byteE54
            byteD_55 -> byteE55
            byteD_56 -> byteE56
            byteD_57 -> byteE57
            byteD_58 -> byteE58
            byteD_59 -> byteE59
            byteD_60 -> byteE60
            byteD_61 -> byteE61
            byteD_62 -> byteE62
            byteD_63 -> byteE63
            byteD_64 -> byteE64
            byteD_65 -> byteE65
            byteD_66 -> byteE66
            byteD_67 -> byteE67
            byteD_68 -> byteE68
            byteD_69 -> byteE69
            byteD_70 -> byteE70
            byteD_71 -> byteE71
            byteD_72 -> byteE72
            byteD_73 -> byteE73
            byteD_74 -> byteE74
            byteD_75 -> byteE75
            byteD_76 -> byteE76
            byteD_77 -> byteE77
            byteD_78 -> byteE78
            byteD_79 -> byteE79
            byteD_80 -> byteE80
            byteD_81 -> byteE81
            byteD_82 -> byteE82
            byteD_83 -> byteE83
            byteD_84 -> byteE84
            byteD_85 -> byteE85
            byteD_86 -> byteE86
            byteD_87 -> byteE87
            byteD_88 -> byteE88
            byteD_89 -> byteE89
            byteD_90 -> byteE90
            byteD_91 -> byteE91
            byteD_92 -> byteE92
            byteD_93 -> byteE93
            byteD_94 -> byteE94
            byteD_95 -> byteE95
            byteD_96 -> byteE96
            byteD_97 -> byteE97
            byteD_98 -> byteE98
            byteD_99 -> byteE99
            byteD_100 -> byteE100
            byteD_101 -> byteE101
            byteD_102 -> byteE102
            byteD_103 -> byteE103
            byteD_104 -> byteE104
            byteD_105 -> byteE105
            byteD_106 -> byteE106
            byteD_107 -> byteE107
            byteD_108 -> byteE108
            byteD_109 -> byteE109
            byteD_110 -> byteE110
            byteD_111 -> byteE111
            byteD_112 -> byteE112
            byteD_113 -> byteE113
            byteD_114 -> byteE114
            byteD_115 -> byteE115
            byteD_116 -> byteE116
            byteD_117 -> byteE117
            byteD_118 -> byteE118
            byteD_119 -> byteE119
            byteD_120 -> byteE120
            byteD_121 -> byteE121
            byteD_122 -> byteE122
            byteD_123 -> byteE123
            byteD_124 -> byteE124
            byteD_125 -> byteE125
            byteD_126 -> byteE126
            byteD_127 -> byteE127
            else -> {
                0
            }
        }

    }

}