/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.crypto;

import com.ibm.oti.util.Msg;
import java.io.IOException;

public final class Util {
    static byte[] padPKCS5(byte[] byArray, int n, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        if (byArray.length > 0) {
            System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        }
        int n4 = n3 - n2;
        int n5 = n2;
        while (n5 < n3) {
            byArray2[n5] = (byte)n4;
            ++n5;
        }
        return byArray2;
    }

    static byte[] unpadPKCS5(byte[] byArray) {
        int n = byArray.length;
        byte by = byArray[n - 1];
        if (by < 1 || by > n) {
            throw new IOException(Msg.getString("K01f7"));
        }
        if (by == n) {
            return new byte[0];
        }
        byte[] byArray2 = new byte[n - by];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n - by);
        return byArray2;
    }

    static byte[] padTLS10(byte[] byArray, int n, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        int n4 = n3 - n2;
        int n5 = n2;
        while (n5 < n3) {
            byArray2[n5] = (byte)(n4 - 1);
            ++n5;
        }
        return byArray2;
    }

    static byte[] unpadTLS10(byte[] byArray) {
        int n = byArray[byArray.length - 1] + 1;
        if (n < 1 || n > 256) {
            throw new IOException(Msg.getString("K01f7"));
        }
        if (n == byArray.length) {
            return new byte[0];
        }
        byte[] byArray2 = new byte[byArray.length - n];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, byArray2.length);
        return byArray2;
    }

    static byte[] padSSL(byte[] byArray, int n, int n2, int n3) {
        byte[] byArray2 = new byte[n3];
        int n4 = n3 - n2;
        if (n2 > 0) {
            System.arraycopy((Object)byArray, n, (Object)byArray2, 0, n2);
        }
        int n5 = n2;
        while (n5 < n3 - 1) {
            byArray2[n5] = 0;
            ++n5;
        }
        byArray2[n3 - 1] = (byte)(n4 - 1);
        return byArray2;
    }

    static byte[] unpadSSL(byte[] byArray) {
        int n = byArray[byArray.length - 1] + 1;
        if (n < 1 || n > byArray.length) {
            throw new IOException(Msg.getString("K01f7"));
        }
        if (n == byArray.length) {
            return new byte[0];
        }
        byte[] byArray2 = new byte[byArray.length - n];
        System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, byArray2.length);
        return byArray2;
    }

    public static byte[] concatenate(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray3, byArray.length, byArray2.length);
        return byArray3;
    }
}

