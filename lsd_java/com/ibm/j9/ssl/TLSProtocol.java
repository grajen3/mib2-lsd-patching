/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.j9.ssl;

import com.ibm.j9.bluez.crypto.CL3State;
import com.ibm.j9.bluez.crypto.HMAC;
import com.ibm.j9.ssl.Util;

public class TLSProtocol {
    public static final byte[] TLS_PROTOCOL_VERSION = new byte[]{3, 1};
    public static final String TLS_PROTOCOL_NAME;

    public static byte[] PRF(byte[] byArray, String string, byte[] byArray2, int n) {
        int n2 = 0;
        int n3 = byArray.length / 2;
        if (byArray.length % 2 != 0) {
            ++n3;
            ++n2;
        }
        byte[] byArray3 = new byte[n3];
        byte[] byArray4 = new byte[n3];
        System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, n3);
        System.arraycopy((Object)byArray, n3 - n2, (Object)byArray4, 0, n3);
        byte[] byArray5 = Util.concatenate(string.getBytes(), byArray2);
        byte[] byArray6 = TLSProtocol.pHash(2, byArray3, byArray5, n);
        byte[] byArray7 = TLSProtocol.pHash(3, byArray4, byArray5, n);
        byte[] byArray8 = new byte[n];
        int n4 = 0;
        while (n4 < n) {
            byArray8[n4] = (byte)(byArray6[n4] ^ byArray7[n4]);
            ++n4;
        }
        return byArray8;
    }

    private static byte[] pHash(int n, byte[] byArray, byte[] byArray2, int n2) {
        int n3;
        if (n == 2) {
            n3 = 16;
        } else if (n == 3) {
            n3 = 20;
        } else {
            throw new IllegalArgumentException("Unsupported hashType.  Must be MD5 or SHA");
        }
        int n4 = n2 / n3;
        if (n2 % n3 > 0) {
            ++n4;
        }
        byte[] byArray3 = new byte[n4 * n3];
        byte[][] byArray4 = new byte[n4 + 1][n3];
        byArray4[0] = byArray2;
        CL3State cL3State = null;
        int n5 = 1;
        while (n5 <= n4) {
            cL3State = HMAC.hmacInit(cL3State, n, byArray, 0, byArray.length);
            HMAC.hmac(cL3State, byArray4[n5 - 1], 0, byArray4[n5 - 1].length, byArray4[n5], 0);
            ++n5;
        }
        n5 = 1;
        while (n5 <= n4) {
            byte[] byArray5 = Util.concatenate(byArray4[n5], byArray2);
            cL3State = HMAC.hmacInit(cL3State, n, byArray, 0, byArray.length);
            HMAC.hmac(cL3State, byArray5, 0, byArray5.length, byArray3, (n5 - 1) * n3);
            ++n5;
        }
        return byArray3;
    }
}

