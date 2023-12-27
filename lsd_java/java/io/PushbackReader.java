/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class PushbackReader
extends FilterReader {
    char[] buf;
    int pos;

    public PushbackReader(Reader reader) {
        super(reader);
        this.buf = new char[1];
        this.pos = 1;
    }

    public PushbackReader(Reader reader, int n) {
        super(reader);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.buf = new char[n];
        this.pos = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            this.buf = null;
            this.in.close();
        }
    }

    @Override
    public void mark(int n) {
        throw new IOException(Msg.getString("K007f"));
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        Object object = this.lock;
        synchronized (object) {
            if (this.buf != null) {
                if (this.pos < this.buf.length) {
                    return this.buf[this.pos++];
                }
                return this.in.read();
            }
            throw new IOException();
        }
    }

    @Override
    public int read(char[] cArray, int n, int n2) {
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                if (this.buf != null) {
                    int n3 = 0;
                    int n4 = 0;
                    int n5 = n;
                    if (this.pos < this.buf.length) {
                        n4 = this.buf.length - this.pos >= n2 ? n2 : this.buf.length - this.pos;
                        System.arraycopy((Object)this.buf, this.pos, (Object)cArray, n5, n4);
                        n5 += n4;
                        n3 += n4;
                        this.pos += n4;
                    }
                    if (n4 == n2) {
                        return n2;
                    }
                    int n6 = this.in.read(cArray, n5, n2 - n3);
                    if (n6 > 0) {
                        return n6 + n3;
                    }
                    if (n3 == 0) {
                        return n6;
                    }
                    return n3;
                }
                throw new IOException();
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            if (this.buf != null) {
                return this.buf.length - this.pos > 0 || this.in.ready();
            }
            throw new IOException(Msg.getString("K0080"));
        }
    }

    @Override
    public void reset() {
        throw new IOException(Msg.getString("K007f"));
    }

    public void unread(char[] cArray) {
        this.unread(cArray, 0, cArray.length);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unread(char[] cArray, int n, int n2) {
        if (n2 > this.pos) {
            throw new IOException(Msg.getString("K007e"));
        }
        if (n >= 0 && n <= cArray.length && n2 >= 0 && n2 <= cArray.length - n) {
            Object object = this.lock;
            synchronized (object) {
                int n3 = n + n2 - 1;
                while (n3 >= n) {
                    this.unread(cArray[n3]);
                    --n3;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unread(int n) {
        Object object = this.lock;
        synchronized (object) {
            if (this.buf != null) {
                if (this.pos == 0) {
                    throw new IOException(Msg.getString("K007e"));
                }
            } else {
                throw new IOException();
            }
            this.buf[--this.pos] = (char)n;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long skip(long l) {
        if (l < 0L) {
            throw new IllegalArgumentException();
        }
        Object object = this.lock;
        synchronized (object) {
            long l2;
            block8: {
                if (this.buf == null) throw new IOException();
                if (l != 0L) break block8;
                return 0L;
            }
            int n = this.buf.length - this.pos;
            if (n > 0) {
                long l3 = l - (long)n;
                if (l3 <= 0L) {
                    this.pos = (int)((long)this.pos + l);
                    return l;
                }
                this.pos += n;
                l2 = this.in.skip(l3);
            } else {
                l2 = this.in.skip(l);
            }
            return l2 + (long)n;
        }
    }
}

