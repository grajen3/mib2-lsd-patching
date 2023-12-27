/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.util;

import de.vw.mib.collections.longs.LongObjectMap;
import de.vw.mib.collections.longs.LongObjectOptHashMap;
import de.vw.mib.util.Util;
import java.lang.ref.SoftReference;

public final class ListColumnsUtil {
    private static final int[] EMPTY_COLUMNS = new int[0];
    private static SoftReference columnMapRef;
    private static final long INT_IN_LONG_MASK;

    private ListColumnsUtil() {
    }

    private static long toLong(int n) {
        return (long)n & 0;
    }

    public static int[] getSimpleIntArray(int n) {
        return ListColumnsUtil.getIntArrayByBits(-1L >>> 64 - n, n);
    }

    public static int[] getIntArrayByBits(int n) {
        return ListColumnsUtil.getIntArrayByBits(n, -1);
    }

    public static int[] getIntArrayByBits(int n, int n2) {
        int[] nArray;
        if (0 == n2 || 0 == n) {
            return EMPTY_COLUMNS;
        }
        SoftReference softReference = columnMapRef;
        LongObjectMap longObjectMap = null != softReference ? (LongObjectMap)softReference.get() : null;
        long l = ListColumnsUtil.toLong(n);
        int[] nArray2 = nArray = null != longObjectMap ? (int[])longObjectMap.get(l) : null;
        if (null == nArray) {
            if (0 > n2) {
                n2 = Util.getNumberOfSetBits(n);
            }
            nArray = new int[n2];
            int n3 = 0;
            int n4 = 0;
            int n5 = n;
            do {
                byte by = (byte)(0xFF & n5);
                int n6 = n4;
                while (0 != by && n3 < n2) {
                    while (0 == (by & 1)) {
                        by = (byte)(0x7F & by >>> 1);
                        ++n6;
                    }
                    nArray[n3++] = n6++;
                    by = (byte)(0x7F & by >>> 1);
                }
                n4 += 8;
            } while (0 != (n5 >>>= 8) && n3 < n2);
            if (n3 < n2) {
                throw new IllegalArgumentException(new StringBuffer().append("Mismatching number of set bits: ").append(n3).append(" < ").append(n2).toString());
            }
            if (1 == n2 || nArray[n2 - 1] <= n2) {
                if (null == longObjectMap) {
                    longObjectMap = new LongObjectOptHashMap().synchronize();
                    columnMapRef = new SoftReference(longObjectMap);
                }
                longObjectMap.put(l, nArray);
            }
        }
        return nArray;
    }

    public static int[] getIntArrayByBits(long l) {
        return ListColumnsUtil.getIntArrayByBits(l, -1);
    }

    public static int[] getIntArrayByBits(long l, int n) {
        int[] nArray;
        if (0 == n || 0L == l) {
            return EMPTY_COLUMNS;
        }
        SoftReference softReference = columnMapRef;
        LongObjectMap longObjectMap = null != softReference ? (LongObjectMap)softReference.get() : null;
        int[] nArray2 = nArray = null != longObjectMap ? (int[])longObjectMap.get(l) : null;
        if (null == nArray) {
            if (0 > n) {
                n = Util.getNumberOfSetBits(l);
            }
            nArray = new int[n];
            int n2 = 0;
            int n3 = 0;
            long l2 = l;
            do {
                int n4 = n3;
                for (char c2 = (char)l2; '\u0000' != c2 && n2 < n; c2 = (char)(c2 >>> 1)) {
                    while (0 == (c2 & '\u0001')) {
                        c2 = (char)(c2 >>> 1);
                        ++n4;
                    }
                    nArray[n2++] = n4++;
                }
                n3 += 16;
            } while (0L != (l2 >>>= 16) && n2 < n);
            if (n2 < n) {
                throw new IllegalArgumentException(new StringBuffer().append("Mismatching number of set bits: ").append(n2).append(" < ").append(n).toString());
            }
            if (1 == n || nArray[n - 1] <= n) {
                if (null == longObjectMap) {
                    longObjectMap = new LongObjectOptHashMap().synchronize();
                    columnMapRef = new SoftReference(longObjectMap);
                }
                longObjectMap.put(l, nArray);
            }
        }
        return nArray;
    }
}

