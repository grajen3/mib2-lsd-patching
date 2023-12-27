/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PushbackInputStream
extends FilterInputStream {
    protected byte[] buf;
    protected int pos;

    public PushbackInputStream(InputStream inputStream) {
        super(inputStream);
        this.buf = new byte[1];
        this.pos = 1;
    }

    public PushbackInputStream(InputStream inputStream, int n) {
        super(inputStream);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.buf = new byte[n];
        this.pos = n;
    }

    @Override
    public int available() {
        if (this.buf != null) {
            return this.buf.length - this.pos + this.in.available();
        }
        throw new IOException();
    }

    @Override
    public void close() {
        if (this.in != null) {
            this.in.close();
            this.in = null;
            this.buf = null;
        }
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        if (this.buf != null) {
            if (this.pos < this.buf.length) {
                return this.buf[this.pos++] & 0xFF;
            }
            return this.in.read();
        }
        throw new IOException();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.buf != null && byArray != null) {
            if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
                int n3 = 0;
                int n4 = 0;
                int n5 = n;
                if (this.pos < this.buf.length) {
                    n4 = this.buf.length - this.pos >= n2 ? n2 : this.buf.length - this.pos;
                    System.arraycopy((Object)this.buf, this.pos, (Object)byArray, n5, n4);
                    n5 += n4;
                    n3 += n4;
                    this.pos += n4;
                }
                if (n4 == n2) {
                    return n2;
                }
                int n6 = this.in.read(byArray, n5, n2 - n3);
                if (n6 > 0) {
                    return n6 + n3;
                }
                if (n3 == 0) {
                    return n6;
                }
                return n3;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.buf == null) {
            throw new IOException();
        }
        throw new NullPointerException();
    }

    @Override
    public long skip(long l) {
        if (this.in != null) {
            if (l <= 0L) {
                return 0L;
            }
            int n = 0;
            if (this.pos < this.buf.length) {
                n = (int)((long)n + (l < (long)(this.buf.length - this.pos) ? l : (long)(this.buf.length - this.pos)));
                this.pos += n;
            }
            if ((long)n < l) {
                n = (int)((long)n + this.in.skip(l - (long)n));
            }
            return n;
        }
        throw new IOException(Msg.getString("K0059"));
    }

    public void unread(byte[] byArray) {
        this.unread(byArray, 0, byArray.length);
    }

    public void unread(byte[] byArray, int n, int n2) {
        if (n2 > this.pos) {
            throw new IOException(Msg.getString("K007e"));
        }
        if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
            int n3 = n + n2 - 1;
            while (n3 >= n) {
                this.unread(byArray[n3]);
                --n3;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void unread(int n) {
        if (this.buf != null) {
            if (this.pos == 0) {
                throw new IOException(Msg.getString("K007e"));
            }
        } else {
            throw new IOException();
        }
        this.buf[--this.pos] = (byte)n;
    }
}

