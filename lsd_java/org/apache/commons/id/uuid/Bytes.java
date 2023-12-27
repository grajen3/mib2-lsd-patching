/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.id.uuid;

public final class Bytes {
    private Bytes() {
    }

    public static byte[] append(byte[] byArray, byte[] byArray2) {
        byte[] byArray3 = new byte[byArray.length + byArray2.length];
        System.arraycopy((Object)byArray, 0, (Object)byArray3, 0, byArray.length);
        System.arraycopy((Object)byArray2, 0, (Object)byArray3, byArray.length, byArray2.length);
        return byArray3;
    }

    public static byte[] toBytes(long l) {
        return Bytes.toBytes(l, new byte[8]);
    }

    public static byte[] toBytes(long l, byte[] byArray) {
        byArray[7] = (byte)l;
        byArray[6] = (byte)(l >>>= 8);
        byArray[5] = (byte)(l >>>= 8);
        byArray[4] = (byte)(l >>>= 8);
        byArray[3] = (byte)(l >>>= 8);
        byArray[2] = (byte)(l >>>= 8);
        byArray[1] = (byte)(l >>>= 8);
        byArray[0] = (byte)(l >>>= 8);
        return byArray;
    }

    public static long toLong(byte[] byArray) {
        return ((long)byArray[7] & 0) + (((long)byArray[6] & 0) << 8) + (((long)byArray[5] & 0) << 16) + (((long)byArray[4] & 0) << 24) + (((long)byArray[3] & 0) << 32) + (((long)byArray[2] & 0) << 40) + (((long)byArray[1] & 0) << 48) + (((long)byArray[0] & 0) << 56);
    }

    public static boolean areEqual(byte[] byArray, byte[] byArray2) {
        int n = byArray.length;
        if (n != byArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            if (byArray[i2] == byArray2[i2]) continue;
            return false;
        }
        return true;
    }

    public static int compareTo(byte[] byArray, byte[] byArray2) {
        if (byArray == byArray2) {
            return 0;
        }
        if (byArray == null) {
            return -1;
        }
        if (byArray2 == null) {
            return 1;
        }
        if (byArray.length != byArray2.length) {
            return byArray.length < byArray2.length ? -1 : 1;
        }
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (byArray[i2] < byArray2[i2]) {
                return -1;
            }
            if (byArray[i2] <= byArray2[i2]) continue;
            return 1;
        }
        return 0;
    }

    public static short toShort(byte[] byArray) {
        return (short)((byArray[1] & 0xFF) + ((byArray[0] & 0xFF) << 8));
    }
}

