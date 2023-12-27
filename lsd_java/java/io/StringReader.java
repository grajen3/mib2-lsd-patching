/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.Reader;

public class StringReader
extends Reader {
    private String str;
    private int markpos = -1;
    private int pos = 0;
    private int count;

    public StringReader(String string) {
        super(string);
        this.str = string;
        this.count = string.length();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                this.str = null;
            }
        }
    }

    private boolean isOpen() {
        return this.str != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void mark(int n) {
        if (n >= 0) {
            Object object = this.lock;
            synchronized (object) {
                if (!this.isOpen()) {
                    throw new IOException(Msg.getString("K0083"));
                }
                this.markpos = this.pos;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public int read() {
        Object object = this.lock;
        synchronized (object) {
            block5: {
                if (!this.isOpen()) break block5;
                if (this.pos != this.count) {
                    return this.str.charAt(this.pos++);
                }
                return -1;
            }
            throw new IOException(Msg.getString("K0083"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int read(char[] cArray, int n, int n2) {
        if (n < 0 || n > cArray.length || n2 < 0 || n2 > cArray.length - n) throw new ArrayIndexOutOfBoundsException();
        Object object = this.lock;
        synchronized (object) {
            block4: {
                if (!this.isOpen()) throw new IOException(Msg.getString("K0083"));
                if (this.pos != this.count) break block4;
                return -1;
            }
            int n3 = this.pos + n2 > this.count ? this.count : this.pos + n2;
            this.str.getChars(this.pos, n3, cArray, n);
            int n4 = n3 - this.pos;
            this.pos = n3;
            return n4;
        }
    }

    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            block4: {
                if (!this.isOpen()) break block4;
                return true;
            }
            throw new IOException(Msg.getString("K0083"));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            if (!this.isOpen()) {
                throw new IOException(Msg.getString("K0083"));
            }
            this.pos = this.markpos != -1 ? this.markpos : 0;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long skip(long l) {
        Object object = this.lock;
        synchronized (object) {
            block5: {
                if (!this.isOpen()) throw new IOException(Msg.getString("K0083"));
                if (l > 0L) break block5;
                return 0L;
            }
            long l2 = 0L;
            if (l < (long)(this.count - this.pos)) {
                this.pos += (int)l;
                return l;
            }
            l2 = this.count - this.pos;
            this.pos = this.count;
            return l2;
        }
    }
}

