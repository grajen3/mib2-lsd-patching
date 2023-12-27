/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

import de.vw.mib.codec.ByteArrayWriter;
import java.util.zip.CRC32;

public class CRCByteArrayWriter
extends ByteArrayWriter {
    private static final int CRC_PADDING;
    private final CRC32 crc = new CRC32();
    private int crcPositionMarker = -1;

    public void beginCRCCalculation() {
        this.crc.reset();
        this.crcPositionMarker = this.count;
        this.writeInt(0);
    }

    public void appendBoolean(boolean bl) {
        this.writeBoolean(bl);
    }

    public void appendByte(byte by) {
        this.writeByte(by);
    }

    public void appendByteArray(byte[] byArray, int n, int n2) {
        this.write(byArray, n, n2);
    }

    public void appendByteArray(byte[] byArray) {
        this.writeByteArray(byArray);
    }

    public void appendChar(char c2) {
        this.writeChar(c2);
    }

    public void appendDouble(double d2) {
        this.writeDouble(d2);
    }

    public void appendFloat(float f2) {
        this.writeFloat(f2);
    }

    public void appendInt(int n) {
        this.writeInt(n);
    }

    public void appendLong(long l) {
        this.writeLong(l);
    }

    public void appendShort(short s) {
        this.writeShort(s);
    }

    public byte[] finish() {
        if (this.crcPositionMarker > -1) {
            this.crc.update(this.buffer, this.crcPositionMarker + 4, this.count - this.crcPositionMarker - 4);
            this.writeInt(this.crcPositionMarker, (int)this.crc.getValue());
            this.crc.reset();
            this.crcPositionMarker = -1;
        }
        byte[] byArray = this.toByteArray();
        this.reset();
        return byArray;
    }
}

