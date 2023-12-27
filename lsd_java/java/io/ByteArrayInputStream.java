/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.InputStream;

public class ByteArrayInputStream
extends InputStream {
    protected byte[] buf;
    protected int pos;
    protected int mark;
    protected int count;

    public ByteArrayInputStream(byte[] byArray) {
        this.mark = 0;
        this.buf = byArray;
        this.count = byArray.length;
    }

    public ByteArrayInputStream(byte[] byArray, int n, int n2) {
        this.buf = byArray;
        this.mark = this.pos = n >= byArray.length ? byArray.length : n;
        this.count = n2 + this.pos > byArray.length ? byArray.length : n2 + this.pos;
    }

    @Override
    public synchronized int available() {
        return this.count - this.pos;
    }

    @Override
    public void close() {
    }

    @Override
    public synchronized void mark(int n) {
        this.mark = this.pos;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public synchronized int read() {
        return this.pos < this.count ? this.buf[this.pos++] & 0xFF : -1;
    }

    @Override
    public synchronized int read(byte[] byArray, int n, int n2) {
        if (this.pos >= this.count) {
            return -1;
        }
        if (byArray != null) {
            if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
                if (n2 == 0) {
                    return 0;
                }
                int n3 = this.count - this.pos < n2 ? this.count - this.pos : n2;
                System.arraycopy((Object)this.buf, this.pos, (Object)byArray, n, n3);
                this.pos += n3;
                return n3;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new NullPointerException();
    }

    @Override
    public synchronized void reset() {
        this.pos = this.mark;
    }

    @Override
    public synchronized long skip(long l) {
        if (l <= 0L) {
            long l2 = 0L;
            return;
        }
        int n = this.pos;
        this.pos = (long)(this.count - this.pos) < l ? this.count : (int)((long)this.pos + l);
        long l3 = this.pos - n;
    }
}

