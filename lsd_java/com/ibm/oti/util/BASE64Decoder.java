/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.Msg;

public class BASE64Decoder {
    private static final byte equalSign;

    private BASE64Decoder() {
    }

    public static byte[] decode(byte[] byArray) {
        int n = byArray.length - 1;
        while (byArray[n] == 61) {
            --n;
        }
        int n2 = byArray.length - 1 - n;
        int n3 = byArray.length * 6 / 8 - n2;
        byte[] byArray2 = new byte[n3];
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = (n + 1) / 4;
        int n8 = 0;
        while (n8 < n7) {
            n6 = 0;
            int n9 = 0;
            while (n9 < 4) {
                n6 = n6 << 6 | BASE64Decoder.decodeDigit(byArray[n4++]);
                ++n9;
            }
            n9 = n5 + 2;
            while (n9 >= n5) {
                byArray2[n9] = (byte)(n6 & 0xFF);
                n6 >>>= 8;
                --n9;
            }
            n5 += 3;
            ++n8;
        }
        switch (n2) {
            case 1: {
                n6 = 0;
                n8 = 0;
                while (n8 < 3) {
                    n6 = n6 << 6 | BASE64Decoder.decodeDigit(byArray[n4++]);
                    ++n8;
                }
                n6 <<= 6;
                n6 >>>= 8;
                n8 = n5 + 1;
                while (n8 >= n5) {
                    byArray2[n8] = (byte)(n6 & 0xFF);
                    n6 >>>= 8;
                    --n8;
                }
                break;
            }
            case 2: {
                n6 = 0;
                n8 = 0;
                while (n8 < 2) {
                    n6 = n6 << 6 | BASE64Decoder.decodeDigit(byArray[n4++]);
                    ++n8;
                }
                n6 <<= 6;
                n6 <<= 6;
                n6 >>>= 8;
                byArray2[n5] = (byte)((n6 >>>= 8) & 0xFF);
            }
        }
        return byArray2;
    }

    static int decodeDigit(byte by) {
        char c2 = (char)by;
        if (c2 <= 'Z' && c2 >= 'A') {
            return c2 - 65;
        }
        if (c2 <= 'z' && c2 >= 'a') {
            return c2 - 97 + 26;
        }
        if (c2 <= '9' && c2 >= '0') {
            return c2 - 48 + 52;
        }
        switch (c2) {
            case '+': {
                return 62;
            }
            case '/': {
                return 63;
            }
        }
        throw new IllegalArgumentException(Msg.getString("K008c", c2));
    }
}

