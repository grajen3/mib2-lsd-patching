/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.util.zip.Checksum;

public class CRC32
implements Checksum {
    private long crc = 0L;
    long tbytes = 0L;

    @Override
    public long getValue() {
        return this.crc;
    }

    @Override
    public void reset() {
        this.crc = 0L;
        this.tbytes = 0L;
    }

    @Override
    public void update(int n) {
        this.crc = this.updateByteImpl((byte)n, this.crc);
    }

    public void update(byte[] byArray) {
        this.update(byArray, 0, byArray.length);
    }

    @Override
    public void update(byte[] byArray, int n, int n2) {
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            this.tbytes += (long)n2;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.crc = this.updateImpl(byArray, n, n2, this.crc);
    }

    private native long updateImpl(byte[] byArray, int n, int n2, long l) {
    }

    private native long updateByteImpl(byte by, long l) {
    }
}

