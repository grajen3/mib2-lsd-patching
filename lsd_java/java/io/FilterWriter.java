/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.Writer;

public abstract class FilterWriter
extends Writer {
    protected Writer out;

    protected FilterWriter(Writer writer) {
        super(writer);
        this.out = writer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            this.out.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flush() {
        Object object = this.lock;
        synchronized (object) {
            this.out.flush();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            this.out.write(cArray, n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        Object object = this.lock;
        synchronized (object) {
            this.out.write(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String string, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            this.out.write(string, n, n2);
        }
    }
}

