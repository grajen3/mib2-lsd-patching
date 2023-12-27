/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia.japan;

import java.util.Arrays;

public final class RomajiMatchConverter {
    public static final int CONVERSION_FULL_MATCHED_KANA_INDEX;
    public static final int CONVERSION_VALID_ROMAJI_INDEX;
    public static final char EMPTY_SPACE;
    private static final int CHAR_CONVERSION_ARRAY_SIZE;
    private static final int CONV_TABLE_COL_HIRAGANA;
    private static final int CONV_TABLE_COL_ROMAJI_FIRST_LETTER;
    private static final char DONT_CARE;
    private static final char[][] ROMAJI_KANA_CONVERSION_TABLE;
    private static char[] charConversionArray;
    private static char fullMatchedKana;
    private static int returnStringLength;

    private static void addCharacterToConversionArray(char c2) {
        for (int i2 = 0; i2 < charConversionArray.length && c2 != charConversionArray[i2]; ++i2) {
            if (charConversionArray[i2] != '\u0000') continue;
            RomajiMatchConverter.charConversionArray[i2] = c2;
            returnStringLength = i2 + 1;
            break;
        }
    }

    public static void convertHiraganas(String string, String string2, String[] stringArray) {
        RomajiMatchConverter.resetCharConversionArray();
        fullMatchedKana = (char)8203;
        if (string2.length() == 0) {
            for (int i2 = 0; i2 < string.length(); ++i2) {
                char c2 = string.charAt(i2);
                for (int i3 = 0; i3 < ROMAJI_KANA_CONVERSION_TABLE.length; ++i3) {
                    if (c2 != ROMAJI_KANA_CONVERSION_TABLE[i3][0]) continue;
                    RomajiMatchConverter.addCharacterToConversionArray(ROMAJI_KANA_CONVERSION_TABLE[i3][2]);
                }
            }
        } else {
            RomajiMatchConverter.parseForRomaji(string, string2);
        }
        Arrays.sort(charConversionArray, 0, returnStringLength);
        stringArray[0] = String.valueOf(fullMatchedKana);
        stringArray[1] = String.valueOf(charConversionArray, 0, returnStringLength);
    }

    private static int parseForHiragana(String string, int n, char c2, int n2, int n3) {
        int n4 = 0;
        char c3 = ROMAJI_KANA_CONVERSION_TABLE[n][0];
        for (int i2 = 0; i2 < string.length() && c2 == ROMAJI_KANA_CONVERSION_TABLE[n][n2]; ++i2) {
            if (c3 != string.charAt(i2)) continue;
            if (n3 < ROMAJI_KANA_CONVERSION_TABLE[0].length) {
                RomajiMatchConverter.addCharacterToConversionArray(ROMAJI_KANA_CONVERSION_TABLE[n][n3]);
            } else {
                RomajiMatchConverter.addCharacterToConversionArray('\u0000');
            }
            fullMatchedKana = ROMAJI_KANA_CONVERSION_TABLE[n][0];
            ++n4;
            break;
        }
        return n4;
    }

    private static int parseForRomaji(String string, String string2) {
        int n = 0;
        int n2 = 0;
        char c2 = string2.charAt(n2);
        char c3 = '\u0000';
        int n3 = 2;
        for (int i2 = 0; i2 < ROMAJI_KANA_CONVERSION_TABLE.length && (n3 <= 2 || c3 == ROMAJI_KANA_CONVERSION_TABLE[i2][n3 - 1]); ++i2) {
            if (c2 != ROMAJI_KANA_CONVERSION_TABLE[i2][n3]) continue;
            if (string2.length() > n2 + 1) {
                c3 = c2;
                c2 = string2.charAt(++n2);
                ++n3;
            }
            n += RomajiMatchConverter.parseForHiragana(string, i2, c2, n3, n3 + 1);
        }
        if (n != 1) {
            fullMatchedKana = (char)8203;
        }
        return n;
    }

    private static void resetCharConversionArray() {
        if (charConversionArray == null) {
            charConversionArray = new char[24];
        } else {
            for (int i2 = 0; i2 < charConversionArray.length; ++i2) {
                RomajiMatchConverter.charConversionArray[i2] = '\u0000';
            }
        }
    }

    private RomajiMatchConverter() {
    }

    static {
        ROMAJI_KANA_CONVERSION_TABLE = new char[][]{{'\u3042', '\u30a2', 'A', '\u0000', '\u0000'}, {'\u3070', '\u30d0', 'B', 'A', '\u0000'}, {'\u3079', '\u30d9', 'B', 'E', '\u0000'}, {'\u3073', '\u30d3', 'B', 'I', '\u0000'}, {'\u307c', '\u30dc', 'B', 'O', '\u0000'}, {'\u3076', '\u30d6', 'B', 'U', '\u0000'}, {'\u3061', '\u30c1', 'C', 'H', 'I'}, {'\u3060', '\u30c0', 'D', 'A', '\u0000'}, {'\u3067', '\u30c7', 'D', 'E', '\u0000'}, {'\u3062', '\u30c2', 'D', 'I', '\u0000'}, {'\u3069', '\u30c9', 'D', 'O', '\u0000'}, {'\u3065', '\u30c5', 'D', 'U', '\u0000'}, {'\u3048', '\u30a8', 'E', '\u0000', '\u0000'}, {'\u3075', '\u30d5', 'F', 'U', '\u0000'}, {'\u304c', '\u30ac', 'G', 'A', '\u0000'}, {'\u3052', '\u30b2', 'G', 'E', '\u0000'}, {'\u304e', '\u30ae', 'G', 'I', '\u0000'}, {'\u3054', '\u30b4', 'G', 'O', '\u0000'}, {'\u3050', '\u30b0', 'G', 'U', '\u0000'}, {'\u306f', '\u30cf', 'H', 'A', '\u0000'}, {'\u3078', '\u30d8', 'H', 'E', '\u0000'}, {'\u3072', '\u30d2', 'H', 'I', '\u0000'}, {'\u307b', '\u30db', 'H', 'O', '\u0000'}, {'\u3075', '\u30d5', 'H', 'U', '\u0000'}, {'\u3044', '\u30a4', 'I', '\u0000', '\u0000'}, {'\u3058', '\u30b8', 'J', 'I', '\u0000'}, {'\u304b', '\u30ab', 'K', 'A', '\u0000'}, {'\u3051', '\u30b1', 'K', 'E', '\u0000'}, {'\u304d', '\u30ad', 'K', 'I', '\u0000'}, {'\u3053', '\u30b3', 'K', 'O', '\u0000'}, {'\u304f', '\u30af', 'K', 'U', '\u0000'}, {'\u3041', '\u30a1', 'L', 'A', '\u0000'}, {'\u3047', '\u30a7', 'L', 'E', '\u0000'}, {'\u3043', '\u30a3', 'L', 'I', '\u0000'}, {'\u3049', '\u30a9', 'L', 'O', '\u0000'}, {'\u3063', '\u30c3', 'L', 'T', 'U'}, {'\u3045', '\u30a5', 'L', 'U', '\u0000'}, {'\u3083', '\u30e3', 'L', 'Y', 'A'}, {'\u3087', '\u30e7', 'L', 'Y', 'O'}, {'\u3085', '\u30e5', 'L', 'Y', 'U'}, {'\u307e', '\u30de', 'M', 'A', '\u0000'}, {'\u3081', '\u30e1', 'M', 'E', '\u0000'}, {'\u307f', '\u30df', 'M', 'I', '\u0000'}, {'\u3082', '\u30e2', 'M', 'O', '\u0000'}, {'\u3080', '\u30e0', 'M', 'U', '\u0000'}, {'\u306a', '\u30ca', 'N', 'A', '\u0000'}, {'\u306d', '\u30cd', 'N', 'E', '\u0000'}, {'\u306b', '\u30cb', 'N', 'I', '\u0000'}, {'\u3093', '\u30f3', 'N', 'N', '\u0000'}, {'\u306e', '\u30be', 'N', 'O', '\u0000'}, {'\u306c', '\u30bc', 'N', 'U', '\u0000'}, {'\u304a', '\u30aa', 'O', '\u0000', '\u0000'}, {'\u3071', '\u30d1', 'P', 'A', '\u0000'}, {'\u307a', '\u30da', 'P', 'E', '\u0000'}, {'\u3074', '\u30d4', 'P', 'I', '\u0000'}, {'\u307d', '\u30dd', 'P', 'O', '\u0000'}, {'\u3077', '\u30d7', 'P', 'U', '\u0000'}, {'\u3089', '\u30e9', 'R', 'A', '\u0000'}, {'\u308c', '\u30ec', 'R', 'E', '\u0000'}, {'\u308a', '\u30ea', 'R', 'I', '\u0000'}, {'\u308d', '\u30ed', 'R', 'O', '\u0000'}, {'\u308b', '\u30eb', 'R', 'U', '\u0000'}, {'\u3055', '\u30b5', 'S', 'A', '\u0000'}, {'\u305b', '\u30bb', 'S', 'E', '\u0000'}, {'\u3057', '\u30b7', 'S', 'H', 'I'}, {'\u3057', '\u30b7', 'S', 'I', '\u0000'}, {'\u305d', '\u30bd', 'S', 'O', '\u0000'}, {'\u3059', '\u30b9', 'S', 'U', '\u0000'}, {'\u305f', '\u30bf', 'T', 'A', '\u0000'}, {'\u3066', '\u30c6', 'T', 'E', '\u0000'}, {'\u3061', '\u30c1', 'T', 'I', '\u0000'}, {'\u3068', '\u30c8', 'T', 'O', '\u0000'}, {'\u3064', '\u30c4', 'T', 'S', 'U'}, {'\u3064', '\u30c4', 'T', 'U', '\u0000'}, {'\u3046', '\u30a6', 'U', '\u0000', '\u0000'}, {'\u308f', '\u30ef', 'W', 'A', '\u0000'}, {'\u3092', '\u30f2', 'W', 'O', '\u0000'}, {'\u3041', '\u30a1', 'X', 'A', '\u0000'}, {'\u3047', '\u30a7', 'X', 'E', '\u0000'}, {'\u3043', '\u30a3', 'X', 'I', '\u0000'}, {'\u3049', '\u30a9', 'X', 'O', '\u0000'}, {'\u3063', '\u30c3', 'X', 'T', 'U'}, {'\u3045', '\u30a5', 'X', 'U', '\u0000'}, {'\u3083', '\u30e3', 'X', 'Y', 'A'}, {'\u3087', '\u30e7', 'X', 'Y', 'O'}, {'\u3085', '\u30e5', 'X', 'Y', 'U'}, {'\u3084', '\u30e4', 'Y', 'A', '\u0000'}, {'\u3088', '\u30e8', 'Y', 'O', '\u0000'}, {'\u3086', '\u30e6', 'Y', 'U', '\u0000'}, {'\u3056', '\u30b6', 'Z', 'A', '\u0000'}, {'\u305c', '\u30bc', 'Z', 'E', '\u0000'}, {'\u3058', '\u30b8', 'Z', 'I', '\u0000'}, {'\u305e', '\u30be', 'Z', 'O', '\u0000'}, {'\u305a', '\u30ba', 'Z', 'U', '\u0000'}};
        fullMatchedKana = (char)8203;
        returnStringLength = 0;
    }
}

