/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.codec;

import java.io.EOFException;

public final class ByteArrayReader {
    protected byte[] buffer;
    protected int length;
    protected int position;

    public ByteArrayReader() {
        this(new byte[0]);
    }

    public ByteArrayReader(byte[] byArray) {
        this.buffer = byArray;
        this.length = byArray.length;
    }

    public int getLength() {
        return this.length;
    }

    public int getPosition() {
        return this.position;
    }

    public int read() {
        return this.position < this.length ? this.buffer[this.position++] & 0xFF : -1;
    }

    public int read(byte[] byArray, int n, int n2) {
        if (this.position >= this.length) {
            return -1;
        }
        if (byArray != null) {
            if (0 <= n && n <= byArray.length && 0 <= n2 && n2 <= byArray.length - n) {
                if (n2 == 0) {
                    return 0;
                }
                int n3 = this.length - this.position < n2 ? this.length - this.position : n2;
                System.arraycopy((Object)this.buffer, this.position, (Object)byArray, n, n3);
                this.position += n3;
                return n3;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    public boolean readBoolean() {
        int n = this.read();
        if (n >= 0) {
            return n != 0;
        }
        throw new EOFException();
    }

    public byte readByte() {
        int n = this.read();
        if (n >= 0) {
            return (byte)n;
        }
        throw new EOFException();
    }

    public byte[] readByteArray() {
        int n = this.readInt();
        byte[] byArray = new byte[n];
        this.read(byArray, 0, n);
        return byArray;
    }

    public char readChar() {
        int n;
        int n2 = this.read();
        if ((n2 | (n = this.read())) >= 0) {
            return (char)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    public double readDouble() {
        return Double.longBitsToDouble((long)this.readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(this.readInt());
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

    public short readShort() {
        int n;
        int n2 = this.read();
        if ((n2 | (n = this.read())) >= 0) {
            return (short)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    public String readString() {
        int n = this.readInt();
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = this.readChar();
        }
        return new String(cArray);
    }

    public void reset(byte[] byArray) {
        this.buffer = byArray;
        this.length = byArray.length;
        this.position = 0;
    }

    public void reset(byte[] byArray, int n) {
        this.buffer = byArray;
        this.length = byArray.length;
        this.position = n;
    }

    public int skipBytes(int n) {
        if (n <= 0) {
            return 0;
        }
        int n2 = this.position;
        this.position = this.length - this.position < n ? this.length : this.position + n;
        return this.position - n2;
    }
}

