/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.hmi.utils;

import de.vw.mib.hmi.utils.Preconditions;
import java.util.Arrays;

public final class BitArray {
    public static final BitArray EMPTY = new BitArray(0, null);
    private static final int INT_MASK;
    private static final int INT_SHIFT;
    private final int bitCount;
    private final int[] data;

    public static int getInternDataSize(int n) {
        return n + 31 >> 5;
    }

    public BitArray(int n, int[] nArray) {
        Preconditions.checkArgument(n >= 0, "Negative bit count not allowed.");
        this.bitCount = n;
        this.data = nArray != null ? nArray : new int[BitArray.getInternDataSize(n)];
        Preconditions.checkArgument(this.data.length >= BitArray.getInternDataSize(n), "Data array is too small for specified size.");
    }

    public BitArray(int[] nArray) {
        this.bitCount = BitArray.extractBitCount(nArray);
        this.data = nArray;
    }

    public static int extractBitCount(int[] nArray) {
        if (nArray == null) {
            throw new IllegalArgumentException(String.valueOf("Data and bit count array is null."));
        }
        Preconditions.checkArgument(nArray.length > 0, "Array is too small to contain the bit count.");
        int n = nArray[nArray.length - 1];
        Preconditions.checkArgument(n >= 0, "Negative bit count not allowed.");
        Preconditions.checkArgument(nArray.length - 1 >= BitArray.getInternDataSize(n), "Data array is too small for specified size.");
        return n;
    }

    public int length() {
        return this.bitCount;
    }

    public int[] getInternData() {
        return this.data;
    }

    public boolean get(int n) {
        if (0 <= n && n < this.bitCount) {
            return (this.data[n >> 5] & 1 << (n & 0x1F)) != 0;
        }
        return false;
    }

    public void set(int n, boolean bl) {
        if (0 <= n && n < this.bitCount) {
            if (bl) {
                int n2 = n >> 5;
                this.data[n2] = this.data[n2] | 1 << (n & 0x1F);
            } else {
                int n3 = n >> 5;
                this.data[n3] = this.data[n3] & ~(1 << (n & 0x1F));
            }
        }
    }

    public void set(int n) {
        if (0 <= n && n < this.bitCount) {
            int n2 = n >> 5;
            this.data[n2] = this.data[n2] | 1 << (n & 0x1F);
        }
    }

    public void clear(int n) {
        if (0 <= n && n < this.bitCount) {
            int n2 = n >> 5;
            this.data[n2] = this.data[n2] & ~(1 << (n & 0x1F));
        }
    }

    public void invert(int n) {
        if (0 <= n && n < this.bitCount) {
            int n2 = n >> 5;
            this.data[n2] = this.data[n2] ^ ~(1 << (n & 0x1F));
        }
    }

    public int hashCode() {
        int n = 31;
        int n2 = this.bitCount;
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            n2 = 31 * n2 + this.data[i2];
        }
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        return this.equals((BitArray)object);
    }

    private boolean equals(BitArray bitArray) {
        if (this.bitCount != bitArray.bitCount) {
            return false;
        }
        return Arrays.equals(this.data, bitArray.data);
    }
}

