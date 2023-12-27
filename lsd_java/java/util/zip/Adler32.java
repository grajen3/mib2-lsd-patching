/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.util.zip.Checksum;

public class Adler32
implements Checksum {
    private long adler = 1L;

    @Override
    public long getValue() {
        return this.adler;
    }

    @Override
    public void reset() {
        this.adler = 1L;
    }

    @Override
    public void update(int n) {
        this.adler = this.updateByteImpl(n, this.adler);
    }

    public void update(byte[] byArray) {
        this.update(byArray, 0, byArray.length);
    }

    @Override
    public void update(byte[] byArray, int n, int n2) {
        if (n > byArray.length || n2 < 0 || n < 0 || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.adler = this.updateImpl(byArray, n, n2, this.adler);
    }

    private native long updateImpl(byte[] byArray, int n, int n2, long l) {
    }

    private native long updateByteImpl(int n, long l) {
    }
}

