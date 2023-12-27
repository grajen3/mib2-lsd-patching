/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.objectswapper;

import java.io.EOFException;
import java.io.InputStream;

public class LittleEndianDataInputStream
extends InputStream {
    private final InputStream in;

    public LittleEndianDataInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override
    public int read() {
        return this.in.read();
    }

    @Override
    public final int read(byte[] byArray) {
        return this.in.read(byArray, 0, byArray.length);
    }

    @Override
    public final int read(byte[] byArray, int n, int n2) {
        return this.in.read(byArray, n, n2);
    }

    public final boolean readBoolean() {
        int n = this.in.read();
        if (n >= 0) {
            return n != 0;
        }
        throw new EOFException();
    }

    public final byte readByte() {
        int n = this.in.read();
        if (n >= 0) {
            return (byte)n;
        }
        throw new EOFException();
    }

    public final char readChar() {
        int n = this.in.read();
        int n2 = this.in.read();
        if ((n2 | n) >= 0) {
            return (char)((n2 << 8) + n);
        }
        throw new EOFException();
    }

    public final void readFully(byte[] byArray) {
        this.readFully(byArray, 0, byArray.length);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void readFully(byte[] byArray, int n, int n2) {
        if (byArray == null) throw new NullPointerException();
        if (0 > n || n > byArray.length || 0 > n2 || n2 > byArray.length - n) throw new IndexOutOfBoundsException();
        while (n2 > 0) {
            int n3 = this.in.read(byArray, n, n2);
            if (n3 < 0) throw new EOFException();
            n += n3;
            n2 -= n3;
        }
    }

    public final int readInt() {
        int n = this.in.read();
        int n2 = this.in.read();
        int n3 = this.in.read();
        int n4 = this.in.read();
        if ((n4 | n3 | n2 | n) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }

    public final short readShort() {
        int n = this.in.read();
        int n2 = this.in.read();
        if ((n2 | n) >= 0) {
            return (short)((n2 << 8) + n);
        }
        throw new EOFException();
    }
}

