/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.Writer;

public class StringWriter
extends Writer {
    private StringBuffer buf;

    public StringWriter() {
        this.buf = new StringBuffer(16);
        this.lock = this.buf;
    }

    public StringWriter(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        this.buf = new StringBuffer(n);
        this.lock = this.buf;
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public StringBuffer getBuffer() {
        Object object = this.lock;
        synchronized (object) {
            return this.buf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.lock;
        synchronized (object) {
            return this.buf.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                this.buf.append(cArray, n, n2);
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.buf.append((char)n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String string) {
        Object object = this.lock;
        synchronized (object) {
            this.buf.append(string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String string, int n, int n2) {
        String string2 = string.substring(n, n + n2);
        Object object = this.lock;
        synchronized (object) {
            this.buf.append(string2);
        }
    }
}

