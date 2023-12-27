/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.codec;

public class Base64 {
    private static final int BASELENGTH;
    private static final int LOOKUPLENGTH;
    private static final int TWENTYFOURBITGROUP;
    private static final int EIGHTBIT;
    private static final int SIXTEENBIT;
    private static final int FOURBYTE;
    private static final int SIGN;
    private static final char PAD;
    private static final byte[] BASE64ALPHABET;
    private static final char[] LOOKUPBASE64ALPHABET;

    protected static boolean isWhiteSpace(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    protected static boolean isPad(char c2) {
        return c2 == '=';
    }

    protected static boolean isData(char c2) {
        return BASE64ALPHABET[c2] != -1;
    }

    protected static boolean isBase64(char c2) {
        return Base64.isWhiteSpace(c2) || Base64.isPad(c2) || Base64.isData(c2);
    }

    protected static int removeWhiteSpace(char[] cArray) {
        if (cArray == null) {
            return 0;
        }
        int n = 0;
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (Base64.isWhiteSpace(cArray[i2])) continue;
            cArray[n++] = cArray[i2];
        }
        return n;
    }

    public static String encode(byte[] byArray) {
        byte by;
        int n;
        if (byArray == null) {
            return null;
        }
        int n2 = byArray.length * 8;
        if (n2 == 0) {
            return "";
        }
        int n3 = n2 % 24;
        int n4 = n2 / 24;
        int n5 = n3 != 0 ? n4 + 1 : n4;
        char[] cArray = null;
        cArray = new char[n5 * 4];
        byte by2 = 0;
        byte by3 = 0;
        byte by4 = 0;
        byte by5 = 0;
        byte by6 = 0;
        int n6 = 0;
        int n7 = 0;
        for (n = 0; n < n4; ++n) {
            by4 = byArray[n7++];
            by5 = byArray[n7++];
            by6 = byArray[n7++];
            by3 = (byte)(by5 & 0xF);
            by2 = (byte)(by4 & 3);
            by = (by4 & 0xFFFFFF80) == 0 ? (byte)(by4 >> 2) : (byte)(by4 >> 2 ^ 0xC0);
            byte by7 = (by5 & 0xFFFFFF80) == 0 ? (byte)(by5 >> 4) : (byte)(by5 >> 4 ^ 0xF0);
            byte by8 = (by6 & 0xFFFFFF80) == 0 ? (byte)(by6 >> 6) : (byte)(by6 >> 6 ^ 0xFC);
            cArray[n6++] = LOOKUPBASE64ALPHABET[by];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by7 | by2 << 4];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by3 << 2 | by8];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by6 & 0x3F];
        }
        if (n3 == 8) {
            by4 = byArray[n7];
            by2 = (byte)(by4 & 3);
            n = (by4 & 0xFFFFFF80) == 0 ? (byte)(by4 >> 2) : (byte)(by4 >> 2 ^ 0xC0);
            cArray[n6++] = LOOKUPBASE64ALPHABET[n];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by2 << 4];
            cArray[n6++] = 61;
            cArray[n6++] = 61;
        } else if (n3 == 16) {
            by4 = byArray[n7];
            by5 = byArray[n7 + 1];
            by3 = (byte)(by5 & 0xF);
            by2 = (byte)(by4 & 3);
            n = (by4 & 0xFFFFFF80) == 0 ? (byte)(by4 >> 2) : (byte)(by4 >> 2 ^ 0xC0);
            by = (by5 & 0xFFFFFF80) == 0 ? (byte)(by5 >> 4) : (byte)(by5 >> 4 ^ 0xF0);
            cArray[n6++] = LOOKUPBASE64ALPHABET[n];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by | by2 << 4];
            cArray[n6++] = LOOKUPBASE64ALPHABET[by3 << 2];
            cArray[n6++] = 61;
        }
        return new String(cArray);
    }

    public static byte[] decode(String string) {
        int n;
        if (string == null) {
            return null;
        }
        char[] cArray = string.toCharArray();
        int n2 = Base64.removeWhiteSpace(cArray);
        if (n2 % 4 != 0) {
            return null;
        }
        int n3 = n2 / 4;
        if (n3 == 0) {
            return new byte[0];
        }
        byte[] byArray = null;
        byte by = 0;
        byte by2 = 0;
        byte by3 = 0;
        byte by4 = 0;
        char c2 = '\u0000';
        char c3 = '\u0000';
        char c4 = '\u0000';
        char c5 = '\u0000';
        int n4 = 0;
        int n5 = 0;
        byArray = new byte[n3 * 3];
        for (n = 0; n < n3 - 1; ++n) {
            if (!(Base64.isData(c2 = cArray[n5++]) && Base64.isData(c3 = cArray[n5++]) && Base64.isData(c4 = cArray[n5++]) && Base64.isData(c5 = cArray[n5++]))) {
                return null;
            }
            by = BASE64ALPHABET[c2];
            by2 = BASE64ALPHABET[c3];
            by3 = BASE64ALPHABET[c4];
            by4 = BASE64ALPHABET[c5];
            byArray[n4++] = (byte)(by << 2 | by2 >> 4);
            byArray[n4++] = (byte)((by2 & 0xF) << 4 | by3 >> 2 & 0xF);
            byArray[n4++] = (byte)(by3 << 6 | by4);
        }
        if (!Base64.isData(c2 = cArray[n5++]) || !Base64.isData(c3 = cArray[n5++])) {
            return null;
        }
        by = BASE64ALPHABET[c2];
        by2 = BASE64ALPHABET[c3];
        c4 = cArray[n5++];
        c5 = cArray[n5++];
        if (!Base64.isData(c4) || !Base64.isData(c5)) {
            if (Base64.isPad(c4) && Base64.isPad(c5)) {
                if ((by2 & 0xF) != 0) {
                    return null;
                }
                byte[] byArray2 = new byte[n * 3 + 1];
                System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n * 3);
                byArray2[n4] = (byte)(by << 2 | by2 >> 4);
                return byArray2;
            }
            if (!Base64.isPad(c4) && Base64.isPad(c5)) {
                by3 = BASE64ALPHABET[c4];
                if ((by3 & 3) != 0) {
                    return null;
                }
                byte[] byArray3 = new byte[n * 3 + 2];
                System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, n * 3);
                byArray3[n4++] = (byte)(by << 2 | by2 >> 4);
                byArray3[n4] = (byte)((by2 & 0xF) << 4 | by3 >> 2 & 0xF);
                return byArray3;
            }
            return null;
        }
        by3 = BASE64ALPHABET[c4];
        by4 = BASE64ALPHABET[c5];
        byArray[n4++] = (byte)(by << 2 | by2 >> 4);
        byArray[n4++] = (byte)((by2 & 0xF) << 4 | by3 >> 2 & 0xF);
        byArray[n4++] = (byte)(by3 << 6 | by4);
        return byArray;
    }

    static {
        int n;
        BASE64ALPHABET = new byte[255];
        LOOKUPBASE64ALPHABET = new char[64];
        for (n = 0; n < 255; ++n) {
            Base64.BASE64ALPHABET[n] = -1;
        }
        for (n = 90; n >= 65; --n) {
            Base64.BASE64ALPHABET[n] = (byte)(n - 65);
        }
        for (n = 122; n >= 97; --n) {
            Base64.BASE64ALPHABET[n] = (byte)(n - 97 + 26);
        }
        for (n = 57; n >= 48; --n) {
            Base64.BASE64ALPHABET[n] = (byte)(n - 48 + 52);
        }
        Base64.BASE64ALPHABET[43] = 62;
        Base64.BASE64ALPHABET[47] = 63;
        for (n = 0; n <= 25; ++n) {
            Base64.LOOKUPBASE64ALPHABET[n] = (char)(65 + n);
        }
        n = 26;
        int n2 = 0;
        while (n <= 51) {
            Base64.LOOKUPBASE64ALPHABET[n] = (char)(97 + n2);
            ++n;
            ++n2;
        }
        n = 52;
        n2 = 0;
        while (n <= 61) {
            Base64.LOOKUPBASE64ALPHABET[n] = (char)(48 + n2);
            ++n;
            ++n2;
        }
        Base64.LOOKUPBASE64ALPHABET[62] = 43;
        Base64.LOOKUPBASE64ALPHABET[63] = 47;
    }
}

