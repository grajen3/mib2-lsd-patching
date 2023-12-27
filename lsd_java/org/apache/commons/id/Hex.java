/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id;

import org.apache.commons.id.DecoderException;
import org.apache.commons.id.EncoderException;

public class Hex {
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] decodeHex(char[] cArray) {
        int n = cArray.length;
        if ((n & 1) != 0) {
            throw new DecoderException("Odd number of characters.");
        }
        byte[] byArray = new byte[n >> 1];
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = Hex.toDigit(cArray[n3], n3) << 4;
            n4 |= Hex.toDigit(cArray[++n3], n3);
            ++n3;
            byArray[n2] = (byte)(n4 & 0xFF);
            ++n2;
        }
        return byArray;
    }

    protected static int toDigit(char c2, int n) {
        int n2 = Character.digit(c2, 16);
        if (n2 == -1) {
            throw new DecoderException(new StringBuffer().append("Illegal hexadecimal charcter ").append(c2).append(" at index ").append(n).toString());
        }
        return n2;
    }

    public static char[] encodeHex(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n << 1];
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[n2++] = DIGITS[(0xF0 & byArray[i2]) >>> 4];
            cArray[n2++] = DIGITS[0xF & byArray[i2]];
        }
        return cArray;
    }

    public byte[] decode(byte[] byArray) {
        return Hex.decodeHex(new String(byArray).toCharArray());
    }

    public Object decode(Object object) {
        try {
            char[] cArray = object instanceof String ? ((String)object).toCharArray() : (char[])object;
            return Hex.decodeHex(cArray);
        }
        catch (ClassCastException classCastException) {
            throw new DecoderException(classCastException.getMessage());
        }
    }

    public byte[] encode(byte[] byArray) {
        return new String(Hex.encodeHex(byArray)).getBytes();
    }

    public Object encode(Object object) {
        try {
            byte[] byArray = object instanceof String ? ((String)object).getBytes() : (byte[])object;
            return Hex.encodeHex(byArray);
        }
        catch (ClassCastException classCastException) {
            throw new EncoderException(classCastException.getMessage());
        }
    }
}

