/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.oti.util.PriviAction;
import java.security.AccessController;

public final class Util {
    private static String lineTerminator = null;

    static {
        lineTerminator = (String)AccessController.doPrivileged(new PriviAction("line.separator"));
    }

    public static byte[] repeat(byte by, int n) {
        byte[] byArray = new byte[n];
        int n2 = 0;
        while (n2 < n) {
            byArray[n2] = by;
            ++n2;
        }
        return byArray;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3) {
        byte[] byArray4 = new byte[byArray.length + byArray2.length + byArray3.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray4, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray4, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray4, n += byArray2.length, byArray3.length);
        return byArray4;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4) {
        byte[] byArray5 = new byte[byArray.length + byArray2.length + byArray3.length + byArray4.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray5, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray5, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray5, n += byArray2.length, byArray3.length);
        System.arraycopy((Object)byArray4, 0, (Object)byArray5, n += byArray3.length, byArray4.length);
        return byArray5;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4, byte[] byArray5, byte[] byArray6) {
        byte[] byArray7 = new byte[byArray.length + byArray2.length + byArray3.length + byArray4.length + byArray5.length + byArray6.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray7, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray7, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray7, n += byArray2.length, byArray3.length);
        System.arraycopy((Object)byArray4, 0, (Object)byArray7, n += byArray3.length, byArray4.length);
        System.arraycopy((Object)byArray5, 0, (Object)byArray7, n += byArray4.length, byArray5.length);
        System.arraycopy((Object)byArray6, 0, (Object)byArray7, n += byArray5.length, byArray6.length);
        return byArray7;
    }

    public static byte[] getBytes(int n, int n2) {
        byte[] byArray = new byte[n2];
        int n3 = 0;
        while (n3 < n2 && n3 < 4) {
            byArray[n2 - n3 - 1] = (byte)(n >> n3 * 8);
            ++n3;
        }
        return byArray;
    }

    public static byte[] getBytes(long l, int n) {
        byte[] byArray = new byte[n];
        int n2 = 0;
        while (n2 < n && n2 < 4) {
            byArray[n - n2 - 1] = (byte)(l >> n2 * 8);
            ++n2;
        }
        return byArray;
    }

    public static long getLong(byte[] byArray, int n, int n2) {
        long l = 0L;
        int n3 = 0;
        while (n3 < n2) {
            l = l << 8 | (long)(byArray[n + n3] & 0xFF);
            ++n3;
        }
        return l;
    }

    public static byte[] exclusiveOR(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length];
        int n = 0;
        while (n < byArray.length) {
            byArray3[n] = (byte)(byArray[n] ^ byArray2[n]);
            ++n;
        }
        return byArray3;
    }

    public static boolean equals(byte[] byArray, byte[] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length) {
            return false;
        }
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public static String getStringForByteArray(byte[] byArray) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < byArray.length) {
            stringBuffer.append(Integer.toHexString(byArray[n] >> 4 & 0xF));
            stringBuffer.append(Integer.toHexString(byArray[n] & 0xF));
            stringBuffer.append(' ');
            ++n;
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String getLineTerminator() {
        return lineTerminator;
    }

    public static boolean matchesPattern(String string, String string2) {
        if (string.indexOf(42) != -1) {
            return false;
        }
        if (string.equals(string2)) {
            return true;
        }
        int n = string2.indexOf(42);
        if (n == -1) {
            return false;
        }
        if (n > 0 && !string.regionMatches(false, 0, string2, 0, n)) {
            return false;
        }
        if (n < string2.length() - 1) {
            int n2 = string2.length() - n - 1;
            if (!string.regionMatches(false, string.length() - n2, string2, n + 1, n2)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2, byte[] byArray3, byte[] byArray4, byte[] byArray5) {
        byte[] byArray6 = new byte[byArray.length + byArray2.length + byArray3.length + byArray4.length + byArray5.length];
        int n = 0;
        System.arraycopy((Object)byArray, 0, (Object)byArray6, n, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray6, n += byArray.length, byArray2.length);
        System.arraycopy((Object)byArray3, 0, (Object)byArray6, n += byArray2.length, byArray3.length);
        System.arraycopy((Object)byArray4, 0, (Object)byArray6, n += byArray3.length, byArray4.length);
        System.arraycopy((Object)byArray5, 0, (Object)byArray6, n += byArray4.length, byArray5.length);
        n += byArray5.length;
        return byArray6;
    }
}

