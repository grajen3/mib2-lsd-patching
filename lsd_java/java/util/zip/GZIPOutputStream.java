/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import java.io.OutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class GZIPOutputStream
extends DeflaterOutputStream {
    protected CRC32 crc = new CRC32();

    public GZIPOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    public GZIPOutputStream(OutputStream outputStream, int n) {
        super(outputStream, new Deflater(-1, true), n);
        this.writeShort(529203200);
        this.out.write(8);
        this.out.write(0);
        this.writeLong(0L);
        this.out.write(0);
        this.out.write(0);
    }

    @Override
    public void finish() {
        super.finish();
        this.writeLong(this.crc.getValue());
        this.writeLong(this.crc.tbytes);
    }

    @Override
    public void close() {
        if (!this.done) {
            this.finish();
        }
        super.close();
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        super.write(byArray, n, n2);
        this.crc.update(byArray, n, n2);
    }

    private int writeShort(int n) {
        this.out.write(n & 0xFF);
        this.out.write(n >> 8 & 0xFF);
        return n;
    }

    private long writeLong(long l) {
        this.out.write((int)(l & 0));
        this.out.write((int)(l >> 8) & 0xFF);
        this.out.write((int)(l >> 16) & 0xFF);
        this.out.write((int)(l >> 24) & 0xFF);
        return l;
    }
}

