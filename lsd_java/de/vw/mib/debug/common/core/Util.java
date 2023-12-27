/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.core;

import de.vw.mib.debug.common.core.StringBuilder;
import java.util.ArrayList;

public final class Util {
    private static char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static Object[] arrayCopyOf(Object[] objectArray, int n) {
        Object[] objectArray2 = new Object[n];
        System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, n > objectArray.length ? objectArray.length : n);
        return objectArray2;
    }

    public static boolean isBitSet(int n, int n2) {
        return (n2 & n) == n;
    }

    public static boolean isBitSet(int n, long l) {
        long l2 = (long)n & 0;
        return (l & l2) == l2;
    }

    public static boolean isBitSet(long l, int n) {
        int n2 = (int)l;
        return (n & n2) == n2;
    }

    public static boolean isBitSet(long l, long l2) {
        return (l2 & l) == l;
    }

    public static boolean isAnyBitSet(int n, int n2) {
        return (n2 & n) != 0;
    }

    public static boolean isAnyBitSet(int n, long l) {
        long l2 = (long)n & 0;
        return (l & l2) != 0L;
    }

    public static boolean isAnyBitSet(long l, int n) {
        int n2 = (int)l;
        return (n & n2) != 0;
    }

    public static boolean isAnyBitSet(long l, long l2) {
        return (l2 & l) != 0L;
    }

    public static boolean isNullOrEmpty(boolean[] blArray) {
        return blArray == null || blArray.length == 0;
    }

    public static boolean isNullOrEmpty(int[] nArray) {
        return nArray == null || nArray.length == 0;
    }

    public static boolean isNullOrEmpty(long[] lArray) {
        return lArray == null || lArray.length == 0;
    }

    public static boolean isNullOrEmpty(Object[] objectArray) {
        return objectArray == null || objectArray.length == 0;
    }

    public static boolean isNullOrEmpty(short[] sArray) {
        return sArray == null || sArray.length == 0;
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }

    public static boolean isNullOrEmpty(ArrayList arrayList) {
        return arrayList == null || arrayList.isEmpty();
    }

    public static int setBit(int n, int n2) {
        return n2 | n;
    }

    public static long setBit(int n, long l) {
        return l | (long)n;
    }

    public static String toString(byte[] byArray) {
        return Util.toString(byArray, -129);
    }

    public static String toString(byte[] byArray, int n) {
        if (null == byArray) {
            return "";
        }
        return Util.toString(byArray, 0, byArray.length, n);
    }

    public static String toString(byte[] byArray, int n, int n2) {
        return Util.toString(byArray, n, n2, -129);
    }

    public static String toString(byte[] byArray, int n, int n2, int n3) {
        StringBuilder stringBuilder;
        int n4;
        if (null == byArray || 0 == byArray.length || n2 <= n) {
            return "";
        }
        int n5 = (n2 - n) * 3;
        if (n3 < n5) {
            n4 = n + n3 / 3 + 1;
            stringBuilder = new StringBuilder(n3 + 2);
        } else {
            n4 = n2;
            stringBuilder = new StringBuilder(n5);
        }
        stringBuilder.append(HEX_CHARS[(byArray[n] & 0xF0) >>> 4]).append(HEX_CHARS[byArray[n] & 0xF]);
        for (int i2 = n + 1; i2 < n4; ++i2) {
            byte by = byArray[i2];
            stringBuilder.append(" ").append(HEX_CHARS[(by & 0xF0) >>> 4]).append(HEX_CHARS[by & 0xF]);
        }
        if (stringBuilder.length() > n3) {
            stringBuilder.setLength(n3);
        }
        return stringBuilder.toString();
    }

    public static int unsetBit(int n, int n2) {
        return n2 & ~n;
    }

    public static long unsetBit(int n, long l) {
        return l & (long)(~n);
    }

    public static int getNumberOfSetBits(int n) {
        int n2 = n - (n >>> 1 & 0x55555555);
        n2 = (n2 & 0x33333333) + (n2 >>> 2 & 0x33333333);
        n2 = n2 + (n2 >>> 4) & 0xF0F0F0F;
        return n2 * 0x1010101 >> 24;
    }

    public static int getNumberOfSetBits(long l) {
        long l2 = l - (l >>> 1 & 0x5555555555555555L);
        l2 = (l2 & 0x3333333333333333L) + (l2 >>> 2 & 0x3333333333333333L);
        l2 = l2 + (l2 >>> 4) & 0xF0F0F0F0F0F0F0FL;
        return (int)(l2 * 0x101010101010101L >>> 56);
    }

    public static int log2(int n) {
        if (0 == n) {
            return -1;
        }
        return Util.getNumberOfSetBits(Util.setLowerBitsTo1(n));
    }

    public static int log2(long l) {
        if (0L == l) {
            return -1;
        }
        return Util.getNumberOfSetBits(Util.setLowerBitsTo1(l));
    }

    public static int getHiBit(int n) {
        return n & ~Util.setLowerBitsTo1(n);
    }

    public static long getHiBit(long l) {
        return l & (Util.setLowerBitsTo1(l) ^ 0xFFFFFFFFFFFFFFFFL);
    }

    private static int setLowerBitsTo1(int n) {
        n >>>= 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        return n | n >>> 16;
    }

    private static long setLowerBitsTo1(long l) {
        l >>>= 1;
        l |= l >>> 1;
        l |= l >>> 2;
        l |= l >>> 4;
        l |= l >>> 8;
        l |= l >>> 16;
        return l | l >>> 32;
    }

    public static int getLoBit(int n) {
        int n2 = n | Util.setHigherBitsTo1(n);
        return n2 & ~(n2 - 1);
    }

    public static long getLoBit(long l) {
        long l2 = l | Util.setHigherBitsTo1(l);
        return l2 & (l2 - 1L ^ 0xFFFFFFFFFFFFFFFFL);
    }

    private static int setHigherBitsTo1(int n) {
        n <<= 1;
        n |= n << 1;
        n |= n << 2;
        n |= n << 4;
        n |= n << 8;
        return n | n << 16;
    }

    private static long setHigherBitsTo1(long l) {
        l <<= 1;
        l |= l << 1;
        l |= l << 2;
        l |= l << 4;
        l |= l << 8;
        l |= l << 16;
        return l | l << 32;
    }

    public static int getNextSetBitvalue(int n, int n2) {
        if (n2 != 0) {
            n &= ~(Util.setLowerBitsTo1(n2) | n2);
        }
        return Util.getLoBit(n);
    }

    public static int getNextSetBitIndex(int n, int n2) {
        int n3 = n2 < 0 ? 0 : 1 << n2;
        return Util.log2(Util.getNextSetBitvalue(n, n3));
    }

    public static int load32LE(byte[] byArray, int n) {
        return byArray[n] & 0xFF | (byArray[n + 1] & 0xFF) << 8 | (byArray[n + 2] & 0xFF) << 16 | (byArray[n + 3] & 0xFF) << 24;
    }

    public static void store32LE(byte[] byArray, int n, int n2) {
        byArray[n] = (byte)(n2 >>> 0 & 0xFF);
        byArray[n + 1] = (byte)(n2 >>> 8 & 0xFF);
        byArray[n + 2] = (byte)(n2 >>> 16 & 0xFF);
        byArray[n + 3] = (byte)(n2 >>> 24 & 0xFF);
    }

    public static int load32BE(byte[] byArray, int n) {
        return (byArray[n] & 0xFF) << 24 | (byArray[n + 1] & 0xFF) << 16 | (byArray[n + 2] & 0xFF) << 8 | byArray[n + 3] & 0xFF;
    }

    public static void store32BE(byte[] byArray, int n, int n2) {
        byArray[n] = (byte)(n2 >>> 24 & 0xFF);
        byArray[n + 1] = (byte)(n2 >>> 16 & 0xFF);
        byArray[n + 2] = (byte)(n2 >>> 8 & 0xFF);
        byArray[n + 3] = (byte)(n2 >>> 0 & 0xFF);
    }

    public static int reverse(int n) {
        n = n >> 1 & 0x55555555 | (n & 0x55555555) << 1;
        n = n >> 2 & 0x33333333 | (n & 0x33333333) << 2;
        n = n >> 4 & 0xF0F0F0F | (n & 0xF0F0F0F) << 4;
        n = n >> 8 & 0xFF00FF00 | (n & 0xFF00FF00) << 8;
        n = n >> 16 & 0xFFFF0000 | (n & 0xFFFF0000) << 16;
        return n;
    }

    private Util() {
    }
}

