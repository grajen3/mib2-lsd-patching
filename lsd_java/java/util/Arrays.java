/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.util;

import java.util.Arrays$ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arrays {
    private Arrays() {
    }

    public static List asList(Object[] objectArray) {
        return new Arrays$ArrayList(objectArray);
    }

    public static int binarySearch(byte[] byArray, byte by) {
        int n = 0;
        int n2 = -1;
        int n3 = byArray.length - 1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            if (by > byArray[n2]) {
                n = n2 + 1;
                continue;
            }
            if (by == byArray[n2]) {
                return n2;
            }
            n3 = n2 - 1;
        }
        if (n2 < 0) {
            return -1;
        }
        return -n2 - (by < byArray[n2] ? 1 : 2);
    }

    public static int binarySearch(char[] cArray, char c2) {
        int n = 0;
        int n2 = -1;
        int n3 = cArray.length - 1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            if (c2 > cArray[n2]) {
                n = n2 + 1;
                continue;
            }
            if (c2 == cArray[n2]) {
                return n2;
            }
            n3 = n2 - 1;
        }
        if (n2 < 0) {
            return -1;
        }
        return -n2 - (c2 < cArray[n2] ? 1 : 2);
    }

    public static int binarySearch(double[] dArray, double d2) {
        long l = Double.doubleToLongBits((double)d2);
        int n = 0;
        int n2 = -1;
        int n3 = dArray.length - 1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            if (Arrays.lessThan(dArray[n2], d2)) {
                n = n2 + 1;
                continue;
            }
            if (l == Double.doubleToLongBits((double)dArray[n2])) {
                return n2;
            }
            n3 = n2 - 1;
        }
        if (n2 < 0) {
            return -1;
        }
        return -n2 - (Arrays.lessThan(d2, dArray[n2]) ? 1 : 2);
    }

    public static int binarySearch(float[] fArray, float f2) {
        int n = Float.floatToIntBits(f2);
        int n2 = 0;
        int n3 = -1;
        int n4 = fArray.length - 1;
        while (n2 <= n4) {
            n3 = n2 + n4 >> 1;
            if (Arrays.lessThan(fArray[n3], f2)) {
                n2 = n3 + 1;
                continue;
            }
            if (n == Float.floatToIntBits(fArray[n3])) {
                return n3;
            }
            n4 = n3 - 1;
        }
        if (n3 < 0) {
            return -1;
        }
        return -n3 - (Arrays.lessThan(f2, fArray[n3]) ? 1 : 2);
    }

    public static int binarySearch(int[] nArray, int n) {
        int n2 = 0;
        int n3 = -1;
        int n4 = nArray.length - 1;
        while (n2 <= n4) {
            n3 = n2 + n4 >> 1;
            if (n > nArray[n3]) {
                n2 = n3 + 1;
                continue;
            }
            if (n == nArray[n3]) {
                return n3;
            }
            n4 = n3 - 1;
        }
        if (n3 < 0) {
            return -1;
        }
        return -n3 - (n < nArray[n3] ? 1 : 2);
    }

    public static int binarySearch(long[] lArray, long l) {
        int n = 0;
        int n2 = -1;
        int n3 = lArray.length - 1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            if (l > lArray[n2]) {
                n = n2 + 1;
                continue;
            }
            if (l == lArray[n2]) {
                return n2;
            }
            n3 = n2 - 1;
        }
        if (n2 < 0) {
            return -1;
        }
        return -n2 - (l < lArray[n2] ? 1 : 2);
    }

    public static int binarySearch(Object[] objectArray, Object object) {
        Comparable comparable = (Comparable)object;
        int n = 0;
        int n2 = 0;
        int n3 = objectArray.length - 1;
        int n4 = 0;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparable.compareTo(objectArray[n2]);
            if (n4 > 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 <= 0 ? 1 : 2);
    }

    public static int binarySearch(Object[] objectArray, Object object, Comparator comparator) {
        int n = 0;
        int n2 = 0;
        int n3 = objectArray.length - 1;
        int n4 = 0;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            n4 = comparator.compare(objectArray[n2], object);
            if (n4 < 0) {
                n = n2 + 1;
                continue;
            }
            if (n4 == 0) {
                return n2;
            }
            n3 = n2 - 1;
        }
        return -n2 - (n4 >= 0 ? 1 : 2);
    }

    public static int binarySearch(short[] sArray, short s) {
        int n = 0;
        int n2 = -1;
        int n3 = sArray.length - 1;
        while (n <= n3) {
            n2 = n + n3 >> 1;
            if (s > sArray[n2]) {
                n = n2 + 1;
                continue;
            }
            if (s == sArray[n2]) {
                return n2;
            }
            n3 = n2 - 1;
        }
        if (n2 < 0) {
            return -1;
        }
        return -n2 - (s < sArray[n2] ? 1 : 2);
    }

    public static void fill(byte[] byArray, byte by) {
        Arrays.fillImpl(byArray, 0, byArray.length, by);
    }

    public static void fill(byte[] byArray, int n, int n2, byte by) {
        Arrays.fillImpl(byArray, n, n2, by);
    }

    private static native void fillImpl(byte[] byArray, int n, int n2, byte by) {
    }

    public static void fill(short[] sArray, short s) {
        Arrays.fillImpl(sArray, 0, sArray.length, s);
    }

    public static void fill(short[] sArray, int n, int n2, short s) {
        Arrays.fillImpl(sArray, n, n2, s);
    }

    private static native void fillImpl(short[] sArray, int n, int n2, short s) {
    }

    public static void fill(char[] cArray, char c2) {
        Arrays.fillImpl(cArray, 0, cArray.length, c2);
    }

    public static void fill(char[] cArray, int n, int n2, char c2) {
        Arrays.fillImpl(cArray, n, n2, c2);
    }

    private static native void fillImpl(char[] cArray, int n, int n2, char c2) {
    }

    public static void fill(int[] nArray, int n) {
        Arrays.fillImpl(nArray, 0, nArray.length, n);
    }

    public static void fill(int[] nArray, int n, int n2, int n3) {
        Arrays.fillImpl(nArray, n, n2, n3);
    }

    private static native void fillImpl(int[] nArray, int n, int n2, int n3) {
    }

    public static void fill(long[] lArray, long l) {
        Arrays.fillImpl(lArray, 0, lArray.length, l);
    }

    public static void fill(long[] lArray, int n, int n2, long l) {
        Arrays.fillImpl(lArray, n, n2, l);
    }

    private static native void fillImpl(long[] lArray, int n, int n2, long l) {
    }

    public static void fill(float[] fArray, float f2) {
        Arrays.fillImpl(fArray, 0, fArray.length, f2);
    }

    public static void fill(float[] fArray, int n, int n2, float f2) {
        Arrays.fillImpl(fArray, n, n2, f2);
    }

    private static native void fillImpl(float[] fArray, int n, int n2, float f2) {
    }

    public static void fill(double[] dArray, double d2) {
        Arrays.fillImpl(dArray, 0, dArray.length, d2);
    }

    public static void fill(double[] dArray, int n, int n2, double d2) {
        Arrays.fillImpl(dArray, n, n2, d2);
    }

    private static native void fillImpl(double[] dArray, int n, int n2, double d2) {
    }

    public static void fill(boolean[] blArray, boolean bl) {
        Arrays.fillImpl(blArray, 0, blArray.length, bl);
    }

    public static void fill(boolean[] blArray, int n, int n2, boolean bl) {
        Arrays.fillImpl(blArray, n, n2, bl);
    }

    private static native void fillImpl(boolean[] blArray, int n, int n2, boolean bl) {
    }

    public static void fill(Object[] objectArray, Object object) {
        Arrays.fillImpl(objectArray, 0, objectArray.length, object);
    }

    public static void fill(Object[] objectArray, int n, int n2, Object object) {
        Arrays.fillImpl(objectArray, n, n2, object);
    }

    private static native void fillImpl(Object[] objectArray, int n, int n2, Object object) {
    }

    public static boolean equals(byte[] byArray, byte[] byArray2) {
        return Arrays.equalsImpl(byArray, byArray2);
    }

    private static native boolean equalsImpl(byte[] byArray, byte[] byArray2) {
    }

    public static boolean equals(short[] sArray, short[] sArray2) {
        return Arrays.equalsImpl(sArray, sArray2);
    }

    private static native boolean equalsImpl(short[] sArray, short[] sArray2) {
    }

    public static boolean equals(char[] cArray, char[] cArray2) {
        return Arrays.equalsImpl(cArray, cArray2);
    }

    private static native boolean equalsImpl(char[] cArray, char[] cArray2) {
    }

    public static boolean equals(int[] nArray, int[] nArray2) {
        return Arrays.equalsImpl(nArray, nArray2);
    }

    private static native boolean equalsImpl(int[] nArray, int[] nArray2) {
    }

    public static boolean equals(long[] lArray, long[] lArray2) {
        return Arrays.equalsImpl(lArray, lArray2);
    }

    private static native boolean equalsImpl(long[] lArray, long[] lArray2) {
    }

    public static boolean equals(float[] fArray, float[] fArray2) {
        if (fArray == fArray2) {
            return true;
        }
        if (fArray == null || fArray2 == null || fArray.length != fArray2.length) {
            return false;
        }
        int n = 0;
        while (n < fArray.length) {
            if (Float.floatToIntBits(fArray[n]) != Float.floatToIntBits(fArray2[n])) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public static boolean equals(double[] dArray, double[] dArray2) {
        if (dArray == dArray2) {
            return true;
        }
        if (dArray == null || dArray2 == null || dArray.length != dArray2.length) {
            return false;
        }
        int n = 0;
        while (n < dArray.length) {
            if (Double.doubleToLongBits((double)dArray[n]) != Double.doubleToLongBits((double)dArray2[n])) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public static boolean equals(boolean[] blArray, boolean[] blArray2) {
        return Arrays.equalsImpl(blArray, blArray2);
    }

    private static native boolean equalsImpl(boolean[] blArray, boolean[] blArray2) {
    }

    public static boolean equals(Object[] objectArray, Object[] objectArray2) {
        if (objectArray == objectArray2) {
            return true;
        }
        if (objectArray == null || objectArray2 == null || objectArray.length != objectArray2.length) {
            return false;
        }
        int n = 0;
        while (n < objectArray.length) {
            Object object = objectArray[n];
            Object object2 = objectArray2[n];
            if (object == null ? object2 != null : !object.equals(object2)) {
                return false;
            }
            ++n;
        }
        return true;
    }

    private static int med3(byte[] byArray, int n, int n2, int n3) {
        byte by = byArray[n];
        byte by2 = byArray[n2];
        byte by3 = byArray[n3];
        return by < by2 ? (by2 < by3 ? n2 : (by < by3 ? n3 : n)) : (by2 > by3 ? n2 : (by > by3 ? n3 : n));
    }

    private static int med3(char[] cArray, int n, int n2, int n3) {
        char c2 = cArray[n];
        char c3 = cArray[n2];
        char c4 = cArray[n3];
        return c2 < c3 ? (c3 < c4 ? n2 : (c2 < c4 ? n3 : n)) : (c3 > c4 ? n2 : (c2 > c4 ? n3 : n));
    }

    private static boolean lessThan(double d2, double d3) {
        long l = Double.doubleToLongBits((double)Double.NaN);
        long l2 = Double.doubleToLongBits((double)d2);
        if (l2 == l) {
            return false;
        }
        long l3 = Double.doubleToLongBits((double)d3);
        if (l3 == l) {
            return true;
        }
        if (d2 == d3) {
            if (l2 == l3) {
                return false;
            }
            return l2 < l3;
        }
        return d2 < d3;
    }

    private static int med3(double[] dArray, int n, int n2, int n3) {
        double d2 = dArray[n];
        double d3 = dArray[n2];
        double d4 = dArray[n3];
        return Arrays.lessThan(d2, d3) ? (Arrays.lessThan(d3, d4) ? n2 : (Arrays.lessThan(d2, d4) ? n3 : n)) : (Arrays.lessThan(d4, d3) ? n2 : (Arrays.lessThan(d4, d2) ? n3 : n));
    }

    private static boolean lessThan(float f2, float f3) {
        int n = Float.floatToIntBits(49279);
        int n2 = Float.floatToIntBits(f2);
        if (n2 == n) {
            return false;
        }
        int n3 = Float.floatToIntBits(f3);
        if (n3 == n) {
            return true;
        }
        if (f2 == f3) {
            if (n2 == n3) {
                return false;
            }
            return n2 < n3;
        }
        return f2 < f3;
    }

    private static int med3(float[] fArray, int n, int n2, int n3) {
        float f2 = fArray[n];
        float f3 = fArray[n2];
        float f4 = fArray[n3];
        return Arrays.lessThan(f2, f3) ? (Arrays.lessThan(f3, f4) ? n2 : (Arrays.lessThan(f2, f4) ? n3 : n)) : (Arrays.lessThan(f4, f3) ? n2 : (Arrays.lessThan(f4, f2) ? n3 : n));
    }

    private static int med3(int[] nArray, int n, int n2, int n3) {
        int n4 = nArray[n];
        int n5 = nArray[n2];
        int n6 = nArray[n3];
        return n4 < n5 ? (n5 < n6 ? n2 : (n4 < n6 ? n3 : n)) : (n5 > n6 ? n2 : (n4 > n6 ? n3 : n));
    }

    private static int med3(long[] lArray, int n, int n2, int n3) {
        long l = lArray[n];
        long l2 = lArray[n2];
        long l3 = lArray[n3];
        return l < l2 ? (l2 < l3 ? n2 : (l < l3 ? n3 : n)) : (l2 > l3 ? n2 : (l > l3 ? n3 : n));
    }

    private static int med3(short[] sArray, int n, int n2, int n3) {
        short s = sArray[n];
        short s2 = sArray[n2];
        short s3 = sArray[n3];
        return s < s2 ? (s2 < s3 ? n2 : (s < s3 ? n3 : n)) : (s2 > s3 ? n2 : (s > s3 ? n3 : n));
    }

    public static void sort(byte[] byArray) {
        Arrays.sort(0, byArray.length, byArray);
    }

    public static void sort(byte[] byArray, int n, int n2) {
        if (n >= 0 && n2 <= byArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, byArray);
    }

    private static void sort(int n, int n2, byte[] byArray) {
        byte by;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7 = n2 - n;
        if (n7 < 7) {
            int n8 = n + 1;
            while (n8 < n2) {
                int n9 = n8;
                while (n9 > n && byArray[n9 - 1] > byArray[n9]) {
                    byte by2 = byArray[n9];
                    byArray[n9] = byArray[n9 - 1];
                    byArray[n9 - 1] = by2;
                    --n9;
                }
                ++n8;
            }
            return;
        }
        int n10 = (n + n2) / 2;
        if (n7 > 7) {
            n6 = n;
            n5 = n2 - 1;
            if (n7 > 40) {
                n6 = Arrays.med3(byArray, n6, n6 + (n7 /= 8), n6 + 2 * n7);
                n10 = Arrays.med3(byArray, n10 - n7, n10, n10 + n7);
                n5 = Arrays.med3(byArray, n5 - 2 * n7, n5 - n7, n5);
            }
            n10 = Arrays.med3(byArray, n6, n10, n5);
        }
        n6 = byArray[n10];
        n5 = n4 = n;
        int n11 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n11 && byArray[n4] <= n6) {
                if (byArray[n4] == n6) {
                    by = byArray[n5];
                    byArray[n5++] = byArray[n4];
                    byArray[n4] = by;
                }
                ++n4;
                continue;
            }
            while (n11 >= n4 && byArray[n11] >= n6) {
                if (byArray[n11] == n6) {
                    by = byArray[n11];
                    byArray[n11] = byArray[n3];
                    byArray[n3--] = by;
                }
                --n11;
            }
            if (n4 > n11) break;
            by = byArray[n4];
            byArray[n4++] = byArray[n11];
            byArray[n11--] = by;
        }
        n7 = n5 - n < n4 - n5 ? n5 - n : n4 - n5;
        int n12 = n;
        int n13 = n4 - n7;
        while (n7-- > 0) {
            by = byArray[n12];
            byArray[n12++] = byArray[n13];
            byArray[n13++] = by;
        }
        n7 = n3 - n11 < n2 - 1 - n3 ? n3 - n11 : n2 - 1 - n3;
        n12 = n4;
        n13 = n2 - n7;
        while (n7-- > 0) {
            by = byArray[n12];
            byArray[n12++] = byArray[n13];
            byArray[n13++] = by;
        }
        n7 = n4 - n5;
        if (n7 > 0) {
            Arrays.sort(n, n + n7, byArray);
        }
        if ((n7 = n3 - n11) > 0) {
            Arrays.sort(n2 - n7, n2, byArray);
        }
    }

    public static void sort(char[] cArray) {
        Arrays.sort(0, cArray.length, cArray);
    }

    public static void sort(char[] cArray, int n, int n2) {
        if (n >= 0 && n2 <= cArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, cArray);
    }

    private static void sort(int n, int n2, char[] cArray) {
        char c2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7 = n2 - n;
        if (n7 < 7) {
            int n8 = n + 1;
            while (n8 < n2) {
                int n9 = n8;
                while (n9 > n && cArray[n9 - 1] > cArray[n9]) {
                    char c3 = cArray[n9];
                    cArray[n9] = cArray[n9 - 1];
                    cArray[n9 - 1] = c3;
                    --n9;
                }
                ++n8;
            }
            return;
        }
        int n10 = (n + n2) / 2;
        if (n7 > 7) {
            n6 = n;
            n5 = n2 - 1;
            if (n7 > 40) {
                n6 = Arrays.med3(cArray, n6, n6 + (n7 /= 8), n6 + 2 * n7);
                n10 = Arrays.med3(cArray, n10 - n7, n10, n10 + n7);
                n5 = Arrays.med3(cArray, n5 - 2 * n7, n5 - n7, n5);
            }
            n10 = Arrays.med3(cArray, n6, n10, n5);
        }
        n6 = cArray[n10];
        n5 = n4 = n;
        int n11 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n11 && cArray[n4] <= n6) {
                if (cArray[n4] == n6) {
                    c2 = cArray[n5];
                    cArray[n5++] = cArray[n4];
                    cArray[n4] = c2;
                }
                ++n4;
                continue;
            }
            while (n11 >= n4 && cArray[n11] >= n6) {
                if (cArray[n11] == n6) {
                    c2 = cArray[n11];
                    cArray[n11] = cArray[n3];
                    cArray[n3--] = c2;
                }
                --n11;
            }
            if (n4 > n11) break;
            c2 = cArray[n4];
            cArray[n4++] = cArray[n11];
            cArray[n11--] = c2;
        }
        n7 = n5 - n < n4 - n5 ? n5 - n : n4 - n5;
        int n12 = n;
        int n13 = n4 - n7;
        while (n7-- > 0) {
            c2 = cArray[n12];
            cArray[n12++] = cArray[n13];
            cArray[n13++] = c2;
        }
        n7 = n3 - n11 < n2 - 1 - n3 ? n3 - n11 : n2 - 1 - n3;
        n12 = n4;
        n13 = n2 - n7;
        while (n7-- > 0) {
            c2 = cArray[n12];
            cArray[n12++] = cArray[n13];
            cArray[n13++] = c2;
        }
        n7 = n4 - n5;
        if (n7 > 0) {
            Arrays.sort(n, n + n7, cArray);
        }
        if ((n7 = n3 - n11) > 0) {
            Arrays.sort(n2 - n7, n2, cArray);
        }
    }

    public static void sort(double[] dArray) {
        Arrays.sort(0, dArray.length, dArray);
    }

    public static void sort(double[] dArray, int n, int n2) {
        if (n >= 0 && n2 <= dArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, dArray);
    }

    private static void sort(int n, int n2, double[] dArray) {
        double d2;
        int n3;
        int n4;
        int n5 = n2 - n;
        if (n5 < 7) {
            int n6 = n + 1;
            while (n6 < n2) {
                int n7 = n6;
                while (n7 > n && Arrays.lessThan(dArray[n7], dArray[n7 - 1])) {
                    double d3 = dArray[n7];
                    dArray[n7] = dArray[n7 - 1];
                    dArray[n7 - 1] = d3;
                    --n7;
                }
                ++n6;
            }
            return;
        }
        int n8 = (n + n2) / 2;
        if (n5 > 7) {
            int n9 = n;
            int n10 = n2 - 1;
            if (n5 > 40) {
                n9 = Arrays.med3(dArray, n9, n9 + (n5 /= 8), n9 + 2 * n5);
                n8 = Arrays.med3(dArray, n8 - n5, n8, n8 + n5);
                n10 = Arrays.med3(dArray, n10 - 2 * n5, n10 - n5, n10);
            }
            n8 = Arrays.med3(dArray, n9, n8, n10);
        }
        double d4 = dArray[n8];
        int n11 = n4 = n;
        int n12 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n12 && !Arrays.lessThan(d4, dArray[n4])) {
                if (dArray[n4] == d4) {
                    d2 = dArray[n11];
                    dArray[n11++] = dArray[n4];
                    dArray[n4] = d2;
                }
                ++n4;
                continue;
            }
            while (n12 >= n4 && !Arrays.lessThan(dArray[n12], d4)) {
                if (dArray[n12] == d4) {
                    d2 = dArray[n12];
                    dArray[n12] = dArray[n3];
                    dArray[n3--] = d2;
                }
                --n12;
            }
            if (n4 > n12) break;
            d2 = dArray[n4];
            dArray[n4++] = dArray[n12];
            dArray[n12--] = d2;
        }
        n5 = n11 - n < n4 - n11 ? n11 - n : n4 - n11;
        int n13 = n;
        int n14 = n4 - n5;
        while (n5-- > 0) {
            d2 = dArray[n13];
            dArray[n13++] = dArray[n14];
            dArray[n14++] = d2;
        }
        n5 = n3 - n12 < n2 - 1 - n3 ? n3 - n12 : n2 - 1 - n3;
        n13 = n4;
        n14 = n2 - n5;
        while (n5-- > 0) {
            d2 = dArray[n13];
            dArray[n13++] = dArray[n14];
            dArray[n14++] = d2;
        }
        n5 = n4 - n11;
        if (n5 > 0) {
            Arrays.sort(n, n + n5, dArray);
        }
        if ((n5 = n3 - n12) > 0) {
            Arrays.sort(n2 - n5, n2, dArray);
        }
    }

    public static void sort(float[] fArray) {
        Arrays.sort(0, fArray.length, fArray);
    }

    public static void sort(float[] fArray, int n, int n2) {
        if (n >= 0 && n2 <= fArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, fArray);
    }

    private static void sort(int n, int n2, float[] fArray) {
        float f2;
        int n3;
        int n4;
        int n5;
        int n6 = n2 - n;
        if (n6 < 7) {
            int n7 = n + 1;
            while (n7 < n2) {
                int n8 = n7;
                while (n8 > n && Arrays.lessThan(fArray[n8], fArray[n8 - 1])) {
                    float f3 = fArray[n8];
                    fArray[n8] = fArray[n8 - 1];
                    fArray[n8 - 1] = f3;
                    --n8;
                }
                ++n7;
            }
            return;
        }
        int n9 = (n + n2) / 2;
        if (n6 > 7) {
            int n10 = n;
            n5 = n2 - 1;
            if (n6 > 40) {
                n10 = Arrays.med3(fArray, n10, n10 + (n6 /= 8), n10 + 2 * n6);
                n9 = Arrays.med3(fArray, n9 - n6, n9, n9 + n6);
                n5 = Arrays.med3(fArray, n5 - 2 * n6, n5 - n6, n5);
            }
            n9 = Arrays.med3(fArray, n10, n9, n5);
        }
        float f4 = fArray[n9];
        n5 = n4 = n;
        int n11 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n11 && !Arrays.lessThan(f4, fArray[n4])) {
                if (fArray[n4] == f4) {
                    f2 = fArray[n5];
                    fArray[n5++] = fArray[n4];
                    fArray[n4] = f2;
                }
                ++n4;
                continue;
            }
            while (n11 >= n4 && !Arrays.lessThan(fArray[n11], f4)) {
                if (fArray[n11] == f4) {
                    f2 = fArray[n11];
                    fArray[n11] = fArray[n3];
                    fArray[n3--] = f2;
                }
                --n11;
            }
            if (n4 > n11) break;
            f2 = fArray[n4];
            fArray[n4++] = fArray[n11];
            fArray[n11--] = f2;
        }
        n6 = n5 - n < n4 - n5 ? n5 - n : n4 - n5;
        int n12 = n;
        int n13 = n4 - n6;
        while (n6-- > 0) {
            f2 = fArray[n12];
            fArray[n12++] = fArray[n13];
            fArray[n13++] = f2;
        }
        n6 = n3 - n11 < n2 - 1 - n3 ? n3 - n11 : n2 - 1 - n3;
        n12 = n4;
        n13 = n2 - n6;
        while (n6-- > 0) {
            f2 = fArray[n12];
            fArray[n12++] = fArray[n13];
            fArray[n13++] = f2;
        }
        n6 = n4 - n5;
        if (n6 > 0) {
            Arrays.sort(n, n + n6, fArray);
        }
        if ((n6 = n3 - n11) > 0) {
            Arrays.sort(n2 - n6, n2, fArray);
        }
    }

    public static void sort(int[] nArray) {
        Arrays.sort(0, nArray.length, nArray);
    }

    public static void sort(int[] nArray, int n, int n2) {
        if (n >= 0 && n2 <= nArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, nArray);
    }

    private static void sort(int n, int n2, int[] nArray) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8 = n2 - n;
        if (n8 < 7) {
            int n9 = n + 1;
            while (n9 < n2) {
                int n10 = n9;
                while (n10 > n && nArray[n10 - 1] > nArray[n10]) {
                    int n11 = nArray[n10];
                    nArray[n10] = nArray[n10 - 1];
                    nArray[n10 - 1] = n11;
                    --n10;
                }
                ++n9;
            }
            return;
        }
        int n12 = (n + n2) / 2;
        if (n8 > 7) {
            n7 = n;
            n6 = n2 - 1;
            if (n8 > 40) {
                n7 = Arrays.med3(nArray, n7, n7 + (n8 /= 8), n7 + 2 * n8);
                n12 = Arrays.med3(nArray, n12 - n8, n12, n12 + n8);
                n6 = Arrays.med3(nArray, n6 - 2 * n8, n6 - n8, n6);
            }
            n12 = Arrays.med3(nArray, n7, n12, n6);
        }
        n7 = nArray[n12];
        n6 = n5 = n;
        int n13 = n4 = n2 - 1;
        while (true) {
            if (n5 <= n13 && nArray[n5] <= n7) {
                if (nArray[n5] == n7) {
                    n3 = nArray[n6];
                    nArray[n6++] = nArray[n5];
                    nArray[n5] = n3;
                }
                ++n5;
                continue;
            }
            while (n13 >= n5 && nArray[n13] >= n7) {
                if (nArray[n13] == n7) {
                    n3 = nArray[n13];
                    nArray[n13] = nArray[n4];
                    nArray[n4--] = n3;
                }
                --n13;
            }
            if (n5 > n13) break;
            n3 = nArray[n5];
            nArray[n5++] = nArray[n13];
            nArray[n13--] = n3;
        }
        n8 = n6 - n < n5 - n6 ? n6 - n : n5 - n6;
        int n14 = n;
        int n15 = n5 - n8;
        while (n8-- > 0) {
            n3 = nArray[n14];
            nArray[n14++] = nArray[n15];
            nArray[n15++] = n3;
        }
        n8 = n4 - n13 < n2 - 1 - n4 ? n4 - n13 : n2 - 1 - n4;
        n14 = n5;
        n15 = n2 - n8;
        while (n8-- > 0) {
            n3 = nArray[n14];
            nArray[n14++] = nArray[n15];
            nArray[n15++] = n3;
        }
        n8 = n5 - n6;
        if (n8 > 0) {
            Arrays.sort(n, n + n8, nArray);
        }
        if ((n8 = n4 - n13) > 0) {
            Arrays.sort(n2 - n8, n2, nArray);
        }
    }

    public static void sort(long[] lArray) {
        Arrays.sort(0, lArray.length, lArray);
    }

    public static void sort(long[] lArray, int n, int n2) {
        if (n >= 0 && n2 <= lArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, lArray);
    }

    private static void sort(int n, int n2, long[] lArray) {
        long l;
        int n3;
        int n4;
        int n5 = n2 - n;
        if (n5 < 7) {
            int n6 = n + 1;
            while (n6 < n2) {
                int n7 = n6;
                while (n7 > n && lArray[n7 - 1] > lArray[n7]) {
                    long l2 = lArray[n7];
                    lArray[n7] = lArray[n7 - 1];
                    lArray[n7 - 1] = l2;
                    --n7;
                }
                ++n6;
            }
            return;
        }
        int n8 = (n + n2) / 2;
        if (n5 > 7) {
            int n9 = n;
            int n10 = n2 - 1;
            if (n5 > 40) {
                n9 = Arrays.med3(lArray, n9, n9 + (n5 /= 8), n9 + 2 * n5);
                n8 = Arrays.med3(lArray, n8 - n5, n8, n8 + n5);
                n10 = Arrays.med3(lArray, n10 - 2 * n5, n10 - n5, n10);
            }
            n8 = Arrays.med3(lArray, n9, n8, n10);
        }
        long l3 = lArray[n8];
        int n11 = n4 = n;
        int n12 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n12 && lArray[n4] <= l3) {
                if (lArray[n4] == l3) {
                    l = lArray[n11];
                    lArray[n11++] = lArray[n4];
                    lArray[n4] = l;
                }
                ++n4;
                continue;
            }
            while (n12 >= n4 && lArray[n12] >= l3) {
                if (lArray[n12] == l3) {
                    l = lArray[n12];
                    lArray[n12] = lArray[n3];
                    lArray[n3--] = l;
                }
                --n12;
            }
            if (n4 > n12) break;
            l = lArray[n4];
            lArray[n4++] = lArray[n12];
            lArray[n12--] = l;
        }
        n5 = n11 - n < n4 - n11 ? n11 - n : n4 - n11;
        int n13 = n;
        int n14 = n4 - n5;
        while (n5-- > 0) {
            l = lArray[n13];
            lArray[n13++] = lArray[n14];
            lArray[n14++] = l;
        }
        n5 = n3 - n12 < n2 - 1 - n3 ? n3 - n12 : n2 - 1 - n3;
        n13 = n4;
        n14 = n2 - n5;
        while (n5-- > 0) {
            l = lArray[n13];
            lArray[n13++] = lArray[n14];
            lArray[n14++] = l;
        }
        n5 = n4 - n11;
        if (n5 > 0) {
            Arrays.sort(n, n + n5, lArray);
        }
        if ((n5 = n3 - n12) > 0) {
            Arrays.sort(n2 - n5, n2, lArray);
        }
    }

    public static void sort(Object[] objectArray) {
        Arrays.sort(0, objectArray.length, objectArray);
    }

    public static void sort(Object[] objectArray, int n, int n2) {
        if (n >= 0 && n2 <= objectArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, objectArray);
    }

    private static void sort(int n, int n2, Object[] objectArray) {
        int n3 = (n + n2) / 2;
        if (n + 1 < n3) {
            Arrays.sort(n, n3, objectArray);
        }
        if (n3 + 1 < n2) {
            Arrays.sort(n3, n2, objectArray);
        }
        if (n + 1 >= n2) {
            return;
        }
        if (((Comparable)objectArray[n3 - 1]).compareTo(objectArray[n3]) <= 0) {
            return;
        }
        if (n + 2 == n2) {
            Object object = objectArray[n];
            objectArray[n] = objectArray[n3];
            objectArray[n3] = object;
            return;
        }
        int n4 = n;
        int n5 = n3;
        int n6 = 0;
        Object[] objectArray2 = new Object[n2 - n];
        while (n4 < n3 && n5 < n2) {
            Object object = objectArray2[n6++] = ((Comparable)objectArray[n4]).compareTo(objectArray[n5]) <= 0 ? objectArray[n4++] : objectArray[n5++];
        }
        if (n4 < n3) {
            System.arraycopy((Object)objectArray, n4, (Object)objectArray2, n6, n3 - n4);
        }
        System.arraycopy((Object)objectArray2, 0, (Object)objectArray, n, n5 - n);
    }

    public static void sort(Object[] objectArray, int n, int n2, Comparator comparator) {
        if (n >= 0 && n2 <= objectArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, objectArray, comparator);
    }

    private static void sort(int n, int n2, Object[] objectArray, Comparator comparator) {
        int n3 = (n + n2) / 2;
        if (n + 1 < n3) {
            Arrays.sort(n, n3, objectArray, comparator);
        }
        if (n3 + 1 < n2) {
            Arrays.sort(n3, n2, objectArray, comparator);
        }
        if (n + 1 >= n2) {
            return;
        }
        if (comparator.compare(objectArray[n3 - 1], objectArray[n3]) <= 0) {
            return;
        }
        if (n + 2 == n2) {
            Object object = objectArray[n];
            objectArray[n] = objectArray[n3];
            objectArray[n3] = object;
            return;
        }
        int n4 = n;
        int n5 = n3;
        int n6 = 0;
        Object[] objectArray2 = new Object[n2 - n];
        while (n4 < n3 && n5 < n2) {
            Object object = objectArray2[n6++] = comparator.compare(objectArray[n4], objectArray[n5]) <= 0 ? objectArray[n4++] : objectArray[n5++];
        }
        if (n4 < n3) {
            System.arraycopy((Object)objectArray, n4, (Object)objectArray2, n6, n3 - n4);
        }
        System.arraycopy((Object)objectArray2, 0, (Object)objectArray, n, n5 - n);
    }

    public static void sort(Object[] objectArray, Comparator comparator) {
        Arrays.sort(0, objectArray.length, objectArray, comparator);
    }

    public static void sort(short[] sArray) {
        Arrays.sort(0, sArray.length, sArray);
    }

    public static void sort(short[] sArray, int n, int n2) {
        if (n >= 0 && n2 <= sArray.length) {
            if (n > n2) {
                throw new IllegalArgumentException();
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        Arrays.sort(n, n2, sArray);
    }

    private static void sort(int n, int n2, short[] sArray) {
        short s;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7 = n2 - n;
        if (n7 < 7) {
            int n8 = n + 1;
            while (n8 < n2) {
                int n9 = n8;
                while (n9 > n && sArray[n9 - 1] > sArray[n9]) {
                    short s2 = sArray[n9];
                    sArray[n9] = sArray[n9 - 1];
                    sArray[n9 - 1] = s2;
                    --n9;
                }
                ++n8;
            }
            return;
        }
        int n10 = (n + n2) / 2;
        if (n7 > 7) {
            n6 = n;
            n5 = n2 - 1;
            if (n7 > 40) {
                n6 = Arrays.med3(sArray, n6, n6 + (n7 /= 8), n6 + 2 * n7);
                n10 = Arrays.med3(sArray, n10 - n7, n10, n10 + n7);
                n5 = Arrays.med3(sArray, n5 - 2 * n7, n5 - n7, n5);
            }
            n10 = Arrays.med3(sArray, n6, n10, n5);
        }
        n6 = sArray[n10];
        n5 = n4 = n;
        int n11 = n3 = n2 - 1;
        while (true) {
            if (n4 <= n11 && sArray[n4] <= n6) {
                if (sArray[n4] == n6) {
                    s = sArray[n5];
                    sArray[n5++] = sArray[n4];
                    sArray[n4] = s;
                }
                ++n4;
                continue;
            }
            while (n11 >= n4 && sArray[n11] >= n6) {
                if (sArray[n11] == n6) {
                    s = sArray[n11];
                    sArray[n11] = sArray[n3];
                    sArray[n3--] = s;
                }
                --n11;
            }
            if (n4 > n11) break;
            s = sArray[n4];
            sArray[n4++] = sArray[n11];
            sArray[n11--] = s;
        }
        n7 = n5 - n < n4 - n5 ? n5 - n : n4 - n5;
        int n12 = n;
        int n13 = n4 - n7;
        while (n7-- > 0) {
            s = sArray[n12];
            sArray[n12++] = sArray[n13];
            sArray[n13++] = s;
        }
        n7 = n3 - n11 < n2 - 1 - n3 ? n3 - n11 : n2 - 1 - n3;
        n12 = n4;
        n13 = n2 - n7;
        while (n7-- > 0) {
            s = sArray[n12];
            sArray[n12++] = sArray[n13];
            sArray[n13++] = s;
        }
        n7 = n4 - n5;
        if (n7 > 0) {
            Arrays.sort(n, n + n7, sArray);
        }
        if ((n7 = n3 - n11) > 0) {
            Arrays.sort(n2 - n7, n2, sArray);
        }
    }
}

