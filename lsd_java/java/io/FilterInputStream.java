/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.InputStream;

public class FilterInputStream
extends InputStream {
    protected InputStream in;

    protected FilterInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    @Override
    public int available() {
        return this.in.available();
    }

    @Override
    public void close() {
        this.in.close();
    }

    @Override
    public synchronized void mark(int n) {
        this.in.mark(n);
    }

    @Override
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override
    public int read() {
        return this.in.read();
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        return this.in.read(byArray, n, n2);
    }

    @Override
    public synchronized void reset() {
        this.in.reset();
    }

    @Override
    public long skip(long l) {
        return this.in.skip(l);
    }
}

