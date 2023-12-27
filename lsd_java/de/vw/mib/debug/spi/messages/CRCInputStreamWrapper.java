/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

import java.io.EOFException;
import java.io.InputStream;
import java.util.zip.CRC32;

public class CRCInputStreamWrapper {
    private InputStream inputStream;
    private CRC32 crc;
    private boolean crcCalculationStarted;

    public CRCInputStreamWrapper(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public CRCInputStreamWrapper() {
    }

    public void close() {
        this.inputStream.close();
    }

    public void reset(InputStream inputStream) {
        this.crcCalculationStarted = false;
        this.inputStream = inputStream;
        if (this.crc != null) {
            this.crc.reset();
        }
    }

    public int readCRC() {
        this.checkInitializstion();
        if (this.crc == null) {
            this.crc = new CRC32();
        }
        int n = this.readInt();
        this.crcCalculationStarted = true;
        return n;
    }

    private void checkInitializstion() {
        if (this.inputStream == null) {
            throw new IllegalStateException("No hosted stream is setted");
        }
    }

    private int read() {
        this.checkInitializstion();
        int n = this.inputStream.read();
        if (this.crcCalculationStarted) {
            this.crc.update(n);
        }
        return n == -1 ? -1 : n & 0xFF;
    }

    public int getCalculatedCRC() {
        return (int)this.crc.getValue();
    }

    public long skip(long l) {
        long l2;
        for (l2 = 0L; l2 < l; ++l2) {
            int n = this.read();
            if (n != -1) continue;
            throw new EOFException();
        }
        return l2;
    }

    public byte readByte() {
        int n = this.read();
        if (n < 0) {
            throw new EOFException();
        }
        return (byte)n;
    }

    public long readLong() {
        int n;
        int n2;
        int n3;
        int n4 = this.readInt();
        int n5 = this.read();
        if ((n5 | (n3 = this.read()) | (n2 = this.read()) | (n = this.read())) >= 0) {
            return ((long)n4 << 32) + ((long)n5 << 24) + (long)(n3 << 16) + (long)(n2 << 8) + (long)n;
        }
        throw new EOFException();
    }

    public int readInt() {
        int n;
        int n2;
        int n3;
        int n4 = this.read();
        if ((n4 | (n3 = this.read()) | (n2 = this.read()) | (n = this.read())) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }

    public int readBody(byte[] byArray) {
        int n;
        for (int i2 = byArray.length; i2 > 0; i2 -= n) {
            n = this.inputStream.read(byArray, byArray.length - i2, i2);
            if (n >= 0) continue;
            throw new EOFException();
        }
        this.crc.update(byArray, 0, byArray.length);
        return byArray.length;
    }
}

