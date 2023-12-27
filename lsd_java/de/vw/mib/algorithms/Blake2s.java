/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.algorithms;

import de.vw.mib.algorithms.Blake2s$Param;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public class Blake2s {
    public static final int MEMORY_SIZE;
    public static final int BLOCKBYTES;
    public static final int OUTBYTES;
    public static final int KEYBYTES;
    public static final int SALTBYTES;
    public static final int PERSONALBYTES;
    private static final int[] INITIAL_VECTOR;
    private static final int[][] SIGMA;
    private static final byte[] NO_KEY;
    private final Blake2s$Param param = new Blake2s$Param();
    private byte keyLength;
    private final int[] h = new int[8];
    private int t0;
    private int t1;
    private int f0;
    private final byte[] buf = new byte[64];
    private int buflen;
    final int[] m = new int[16];
    final int[] v = new int[16];
    byte[] digest = new byte[32];

    public Blake2s() {
    }

    public Blake2s(int n) {
        this.param.setDigestLength(n);
    }

    public Blake2s(Blake2s$Param blake2s$Param) {
        this(blake2s$Param.getDigestLength());
        System.arraycopy((Object)blake2s$Param.salt, 0, (Object)this.param.salt, 0, 8);
        System.arraycopy((Object)blake2s$Param.personal, 0, (Object)this.param.personal, 0, 8);
    }

    private void setLastblock() {
        this.f0 = -1;
    }

    private boolean isFinalized() {
        return this.f0 != 0;
    }

    private void incrementCounter(int n) {
        this.t0 += n;
        if (this.t0 < n && this.t0 >= 0) {
            ++this.t1;
        }
    }

    public Blake2s init() {
        return this.init(NO_KEY);
    }

    public Blake2s init(byte[] byArray) {
        this.init0();
        if (byArray.length > 0) {
            if (byArray.length > 32) {
                throw new IllegalArgumentException(new StringBuffer().append("Key too long: ").append(byArray.length).toString());
            }
            this.keyLength = (byte)byArray.length;
            byte[] byArray2 = new byte[64];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, (int)this.keyLength);
            this.update(byArray2);
            Arrays.fill(byArray2, (byte)0);
        }
        this.initInteralMemory();
        return this;
    }

    private void init0() {
        for (int i2 = INITIAL_VECTOR.length - 1; i2 >= 0; --i2) {
            this.h[i2] = INITIAL_VECTOR[i2];
        }
        this.t0 = 0;
        this.t1 = 0;
        this.f0 = 0;
        this.buflen = 0;
    }

    private void initInteralMemory() {
        this.h[0] = this.h[0] ^ Util.load32LE(new byte[]{(byte)this.param.getDigestLength(), this.keyLength, 1, 1}, 0);
        this.h[4] = this.h[4] ^ Util.load32LE(this.param.salt, 0);
        this.h[5] = this.h[5] ^ Util.load32LE(this.param.salt, 4);
        this.h[6] = this.h[6] ^ Util.load32LE(this.param.personal, 0);
        this.h[7] = this.h[7] ^ Util.load32LE(this.param.personal, 4);
    }

    private void compress() {
        for (int i2 = 15; i2 >= 0; --i2) {
            this.m[i2] = Util.load32LE(this.buf, i2 * 4);
        }
        this.v[0] = this.h[0];
        this.v[1] = this.h[1];
        this.v[2] = this.h[2];
        this.v[3] = this.h[3];
        this.v[4] = this.h[4];
        this.v[5] = this.h[5];
        this.v[6] = this.h[6];
        this.v[7] = this.h[7];
        this.v[8] = INITIAL_VECTOR[0];
        this.v[9] = INITIAL_VECTOR[1];
        this.v[10] = INITIAL_VECTOR[2];
        this.v[11] = INITIAL_VECTOR[3];
        this.v[12] = this.t0 ^ INITIAL_VECTOR[4];
        this.v[13] = this.t1 ^ INITIAL_VECTOR[5];
        this.v[14] = this.f0 ^ INITIAL_VECTOR[6];
        this.v[15] = INITIAL_VECTOR[7];
        this.round(0);
        this.round(1);
        this.round(2);
        this.round(3);
        this.round(4);
        this.round(5);
        this.round(6);
        this.round(7);
        this.round(8);
        this.round(9);
        this.h[0] = this.h[0] ^ (this.v[0] ^ this.v[8]);
        this.h[1] = this.h[1] ^ (this.v[1] ^ this.v[9]);
        this.h[2] = this.h[2] ^ (this.v[2] ^ this.v[10]);
        this.h[3] = this.h[3] ^ (this.v[3] ^ this.v[11]);
        this.h[4] = this.h[4] ^ (this.v[4] ^ this.v[12]);
        this.h[5] = this.h[5] ^ (this.v[5] ^ this.v[13]);
        this.h[6] = this.h[6] ^ (this.v[6] ^ this.v[14]);
        this.h[7] = this.h[7] ^ (this.v[7] ^ this.v[15]);
    }

    private void round(int n) {
        this.g(n, 0, 0, 4, 8, 12);
        this.g(n, 1, 1, 5, 9, 13);
        this.g(n, 2, 2, 6, 10, 14);
        this.g(n, 3, 3, 7, 11, 15);
        this.g(n, 4, 0, 5, 10, 15);
        this.g(n, 5, 1, 6, 11, 12);
        this.g(n, 6, 2, 7, 8, 13);
        this.g(n, 7, 3, 4, 9, 14);
    }

    private void g(int n, int n2, int n3, int n4, int n5, int n6) {
        this.v[n3] = this.v[n3] + this.v[n4] + this.m[SIGMA[n][2 * n2 + 0]];
        this.v[n6] = this.rotr32(this.v[n6] ^ this.v[n3], 16);
        this.v[n5] = this.v[n5] + this.v[n6];
        this.v[n4] = this.rotr32(this.v[n4] ^ this.v[n5], 12);
        this.v[n3] = this.v[n3] + this.v[n4] + this.m[SIGMA[n][2 * n2 + 1]];
        this.v[n6] = this.rotr32(this.v[n6] ^ this.v[n3], 8);
        this.v[n5] = this.v[n5] + this.v[n6];
        this.v[n4] = this.rotr32(this.v[n4] ^ this.v[n5], 7);
    }

    private int rotr32(int n, int n2) {
        return n >>> n2 | n << 32 - n2;
    }

    public Blake2s update(byte[] byArray) {
        return this.update(byArray, 0, byArray.length);
    }

    public Blake2s update(byte[] byArray, int n, int n2) {
        if (this.isFinalized()) {
            throw new IllegalStateException("Instance already finalized; use init() to reinitialize.");
        }
        int n3 = n2;
        int n4 = n;
        while (n3 > 0) {
            int n5 = 64 - this.buflen;
            if (n3 > n5) {
                System.arraycopy((Object)byArray, n4, (Object)this.buf, this.buflen, n5);
                n4 += n5;
                n3 -= n5;
                this.incrementCounter(64);
                this.compress();
                this.buflen = 0;
                continue;
            }
            System.arraycopy((Object)byArray, n4, (Object)this.buf, this.buflen, n3);
            this.buflen += n3;
            n4 += n3;
            n3 -= n3;
        }
        return this;
    }

    public byte[] getDigest() {
        if (!this.isFinalized()) {
            this.setLastblock();
            this.incrementCounter(this.buflen);
            Arrays.fill(this.buf, this.buflen, 64, (byte)0);
            this.compress();
            Arrays.fill(this.digest, (byte)0);
            for (int i2 = 0; i2 < 8; ++i2) {
                Util.store32LE(this.digest, 4 * i2, this.h[i2]);
            }
        }
        return Arrays.copyOf(this.digest, this.param.getDigestLength());
    }

    public static byte[] hash(byte[] byArray, int n, int n2, byte[] byArray2, int n3) {
        return new Blake2s(n3).init(byArray2).update(byArray, n, n2).getDigest();
    }

    public static byte[] hash(byte[] byArray, byte[] byArray2, int n) {
        return Blake2s.hash(byArray, 0, byArray.length, byArray2, n);
    }

    public static byte[] hash(byte[] byArray, byte[] byArray2) {
        return Blake2s.hash(byArray, 0, byArray.length, byArray2, 32);
    }

    public static byte[] hash(byte[] byArray, int n, int n2, int n3) {
        return Blake2s.hash(byArray, n, n2, NO_KEY, n3);
    }

    public static byte[] hash(byte[] byArray, int n) {
        return Blake2s.hash(byArray, 0, byArray.length, NO_KEY, n);
    }

    public static byte[] hash(byte[] byArray) {
        return Blake2s.hash(byArray, 0, byArray.length, NO_KEY, 32);
    }

    public static String byteArrayToString(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArray = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            stringBuilder.append(cArray[(byArray[i2] & 0xFF) >> 4]).append(cArray[byArray[i2] & 0xF]);
        }
        return stringBuilder.toString();
    }

    static {
        INITIAL_VECTOR = new int[]{1743128938, -2052167749, 1928556092, 989155237, 2136084049, -1939339877, -1411808481, 432922715};
        SIGMA = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {14, 10, 4, 8, 9, 15, 13, 6, 1, 12, 0, 2, 11, 7, 5, 3}, {11, 8, 12, 0, 5, 2, 15, 13, 10, 14, 3, 6, 7, 1, 9, 4}, {7, 9, 3, 1, 13, 12, 11, 14, 2, 6, 5, 10, 4, 0, 15, 8}, {9, 0, 5, 7, 2, 4, 10, 15, 14, 1, 11, 12, 6, 8, 3, 13}, {2, 12, 6, 10, 0, 11, 8, 3, 4, 13, 7, 5, 15, 14, 1, 9}, {12, 5, 1, 15, 14, 13, 4, 10, 0, 7, 6, 3, 9, 2, 8, 11}, {13, 11, 7, 14, 12, 1, 3, 9, 5, 0, 15, 4, 8, 6, 2, 10}, {6, 15, 14, 9, 11, 3, 0, 8, 12, 2, 13, 7, 1, 4, 10, 5}, {10, 2, 8, 4, 7, 6, 1, 5, 15, 11, 9, 14, 3, 12, 13, 0}};
        NO_KEY = new byte[0];
    }
}

