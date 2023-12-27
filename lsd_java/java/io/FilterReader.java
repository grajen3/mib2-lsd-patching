/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.Reader;

public abstract class FilterReader
extends Reader {
    protected Reader in;

    protected FilterReader(Reader reader) {
        super(reader);
        this.in = reader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            this.in.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized void mark(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.in.mark(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean markSupported() {
        Object object = this.lock;
        synchronized (object) {
            return this.in.markSupported();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read() {
        Object object = this.lock;
        synchronized (object) {
            return this.in.read();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            return this.in.read(cArray, n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            return this.in.ready();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            this.in.reset();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long skip(long l) {
        Object object = this.lock;
        synchronized (object) {
            return this.in.skip(l);
        }
    }
}

