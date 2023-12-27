/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

public class BASE64Encoder {
    static char[] digits = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    private BASE64Encoder() {
    }

    public static byte[] encode(byte[] byArray) {
        int n = byArray.length / 3;
        int n2 = (byArray.length + 2) / 3 * 4;
        byte[] byArray2 = new byte[n2];
        int n3 = byArray.length - n * 3;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (n7 < n) {
            n6 = 0;
            int n8 = 0;
            while (n8 < 3) {
                n6 = n6 << 8 | byArray[n4++] & 0xFF;
                ++n8;
            }
            n8 = n5 + 3;
            while (n8 >= n5) {
                byArray2[n8] = (byte)digits[n6 & 0x3F];
                n6 >>>= 6;
                --n8;
            }
            n5 += 4;
            ++n7;
        }
        switch (n3) {
            case 1: {
                n6 = byArray[n4++];
                n6 <<= 8;
                n6 <<= 8;
                n7 = n5 + 3;
                while (n7 >= n5) {
                    byArray2[n7] = (byte)digits[n6 & 0x3F];
                    n6 >>>= 6;
                    --n7;
                }
                byArray2[byArray2.length - 1] = 61;
                byArray2[byArray2.length - 2] = 61;
                break;
            }
            case 2: {
                n6 = byArray[n4++];
                n6 = n6 << 8 | byArray[n4++] & 0xFF;
                n6 <<= 8;
                n7 = n5 + 3;
                while (n7 >= n5) {
                    byArray2[n7] = (byte)digits[n6 & 0x3F];
                    n6 >>>= 6;
                    --n7;
                }
                byArray2[byArray2.length - 1] = 61;
            }
        }
        return byArray2;
    }
}

