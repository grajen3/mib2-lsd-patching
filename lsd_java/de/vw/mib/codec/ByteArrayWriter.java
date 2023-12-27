/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.codec;

public class ByteArrayWriter {
    private static final int DEFAULT_INITIAL_BYTE_ARRAY_LENGTH;
    private final byte[] initialBuffer;
    protected byte[] buffer;
    protected int count;

    public ByteArrayWriter() {
        this(64);
    }

    public ByteArrayWriter(int n) {
        this.initialBuffer = new byte[n];
        this.buffer = this.initialBuffer;
    }

    protected void ensureCapacity(int n) {
        if (n < this.buffer.length) {
            return;
        }
        int n2 = (this.buffer.length << 1) + 2;
        byte[] byArray = new byte[n > n2 ? n : n2];
        System.arraycopy((Object)this.buffer, 0, (Object)byArray, 0, this.count);
        this.buffer = byArray;
    }

    public final void reset() {
        this.count = 0;
        this.buffer = this.initialBuffer;
    }

    public final byte[] toByteArray() {
        byte[] byArray = new byte[this.count];
        System.arraycopy((Object)this.buffer, 0, (Object)byArray, 0, this.count);
        return byArray;
    }

    public final void trim(int n) {
        if (n > this.count) {
            return;
        }
        this.count = n;
    }

    public final void write(byte[] byArray) {
        this.ensureCapacity(this.count + byArray.length);
        System.arraycopy((Object)byArray, 0, (Object)this.buffer, this.count, byArray.length);
        this.count += byArray.length;
    }

    public final void write(byte[] byArray, int n) {
        this.ensureCapacity(this.count + n);
        System.arraycopy((Object)byArray, 0, (Object)this.buffer, this.count, n);
        this.count += n;
    }

    public final void write(byte[] byArray, int n, int n2) {
        this.ensureCapacity(this.count + n2);
        System.arraycopy((Object)byArray, n, (Object)this.buffer, this.count, n2);
        this.count += n2;
    }

    public final void writeBoolean(boolean bl) {
        this.writeBoolean(this.count, bl);
        ++this.count;
    }

    public final void writeBoolean(int n, boolean bl) {
        this.ensureCapacity(n + 1);
        this.buffer[n] = (byte)(bl ? 1 : 0);
    }

    public final void writeByte(int n) {
        this.writeByte(this.count, n);
        ++this.count;
    }

    public final void writeByte(int n, int n2) {
        this.ensureCapacity(n + 1);
        this.buffer[n] = (byte)n2;
    }

    public final void writeByteArray(byte[] byArray) {
        int n = byArray.length;
        this.writeInt(n);
        this.write(byArray);
    }

    public final void writeChar(int n) {
        this.writeChar(this.count, n);
        this.count += 2;
    }

    public final void writeChar(int n, int n2) {
        this.ensureCapacity(n + 2);
        this.buffer[n] = (byte)(n2 >> 8);
        this.buffer[n + 1] = (byte)n2;
    }

    public final void writeDouble(double d2) {
        this.writeDouble(this.count, d2);
        this.count += 8;
    }

    public final void writeDouble(int n, double d2) {
        this.writeLong(n, Double.doubleToLongBits((double)d2));
    }

    public final void writeFloat(float f2) {
        this.writeFloat(this.count, f2);
        this.count += 4;
    }

    public final void writeFloat(int n, float f2) {
        this.writeInt(n, Float.floatToIntBits(f2));
    }

    public final void writeInt(int n) {
        this.writeInt(this.count, n);
        this.count += 4;
    }

    public final void writeInt(int n, int n2) {
        this.ensureCapacity(n + 4);
        this.buffer[n] = (byte)(n2 >> 24);
        this.buffer[n + 1] = (byte)(n2 >> 16);
        this.buffer[n + 2] = (byte)(n2 >> 8);
        this.buffer[n + 3] = (byte)n2;
    }

    public final void writeLong(long l) {
        this.writeLong(this.count, l);
        this.count += 8;
    }

    public final void writeLong(int n, long l) {
        this.writeInt(n, (int)(l >> 32));
        this.writeInt(n + 4, (int)l);
    }

    public final void writeShort(int n) {
        this.writeShort(this.count, n);
        this.count += 2;
    }

    public final void writeShort(int n, int n2) {
        this.writeChar(n, n2);
    }

    public final void writeString(String string) {
        this.writeString(this.count, string);
        this.count = this.count + 4 + 2 * string.length();
    }

    public final void writeString(int n, String string) {
        int n2 = string.length();
        this.ensureCapacity(n + 4 + 2 * n2 + 1);
        this.buffer[n] = (byte)(n2 >> 24);
        this.buffer[n + 1] = (byte)(n2 >> 16);
        this.buffer[n + 2] = (byte)(n2 >> 8);
        this.buffer[n + 3] = (byte)n2;
        n += 4;
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string.charAt(i2);
            this.buffer[n] = (byte)(c2 >>> 8 & 0xFF);
            this.buffer[n + 1] = (byte)(c2 >>> 0 & 0xFF);
            n += 2;
        }
    }
}

