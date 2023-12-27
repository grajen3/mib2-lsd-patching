/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream
extends FilterInputStream {
    protected byte[] buf;
    protected int count;
    protected int marklimit;
    protected int markpos = -1;
    protected int pos;

    public BufferedInputStream(InputStream inputStream) {
        super(inputStream);
        this.buf = new byte[2048];
    }

    public BufferedInputStream(InputStream inputStream, int n) {
        super(inputStream);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.buf = new byte[n];
    }

    @Override
    public synchronized int available() {
        if (this.buf == null) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.count - this.pos + this.in.available();
    }

    @Override
    public synchronized void close() {
        super.close();
        this.buf = null;
    }

    private int fillbuf() {
        int n;
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            int n2 = this.in.read(this.buf);
            if (n2 > 0) {
                this.markpos = -1;
                this.pos = 0;
                this.count = n2 == -1 ? 0 : n2;
            }
            return n2;
        }
        if (this.markpos == 0 && this.marklimit > this.buf.length) {
            n = this.buf.length * 2;
            if (n > this.marklimit) {
                n = this.marklimit;
            }
            byte[] byArray = new byte[n];
            System.arraycopy((Object)this.buf, 0, (Object)byArray, 0, this.buf.length);
            this.buf = byArray;
        } else if (this.markpos > 0) {
            System.arraycopy((Object)this.buf, this.markpos, (Object)this.buf, 0, this.buf.length - this.markpos);
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        n = this.in.read(this.buf, this.pos, this.buf.length - this.pos);
        this.count = n <= 0 ? this.pos : this.pos + n;
        return n;
    }

    @Override
    public synchronized void mark(int n) {
        this.marklimit = n;
        this.markpos = this.pos;
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    @Override
    public synchronized int read() {
        if (this.buf != null) {
            if (this.pos >= this.count && this.fillbuf() == -1) {
                return -1;
            }
            if (this.count - this.pos > 0) {
                return this.buf[this.pos++] & 0xFF;
            }
            return -1;
        }
        throw new IOException(Msg.getString("K0059"));
    }

    @Override
    public synchronized int read(byte[] byArray, int n, int n2) {
        if (this.buf != null && byArray != null) {
            if (n >= 0 && n <= byArray.length && n2 >= 0 && n2 <= byArray.length - n) {
                int n3;
                int n4;
                if (n2 == 0) {
                    return 0;
                }
                if (this.pos < this.count) {
                    n4 = this.count - this.pos >= n2 ? n2 : this.count - this.pos;
                    System.arraycopy((Object)this.buf, this.pos, (Object)byArray, n, n4);
                    this.pos += n4;
                    if (n4 == n2 || this.in.available() == 0) {
                        return n4;
                    }
                    n += n4;
                    n3 = n2 - n4;
                } else {
                    n3 = n2;
                }
                while (true) {
                    if (this.markpos == -1 && n3 >= this.buf.length) {
                        n4 = this.in.read(byArray, n, n3);
                        if (n4 == -1) {
                            return n3 == n2 ? -1 : n2 - n3;
                        }
                    } else {
                        if (this.fillbuf() == -1) {
                            return n3 == n2 ? -1 : n2 - n3;
                        }
                        n4 = this.count - this.pos >= n3 ? n3 : this.count - this.pos;
                        System.arraycopy((Object)this.buf, this.pos, (Object)byArray, n, n4);
                        this.pos += n4;
                    }
                    if ((n3 -= n4) == 0) {
                        return n2;
                    }
                    if (this.in.available() == 0) {
                        return n2 - n3;
                    }
                    n += n4;
                }
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.buf == null) {
            throw new IOException(Msg.getString("K0059"));
        }
        throw new NullPointerException(Msg.getString("K0047"));
    }

    @Override
    public synchronized void reset() {
        if (this.markpos != -1) {
            if (this.buf == null) {
                throw new IOException(Msg.getString("K0059"));
            }
        } else {
            throw new IOException(Msg.getString("K005a"));
        }
        this.pos = this.markpos;
    }

    @Override
    public synchronized long skip(long l) {
        if (l < 1L) {
            long l2 = 0L;
            return;
        }
        if ((long)(this.count - this.pos) >= l) {
            this.pos = (int)((long)this.pos + l);
            long l3 = l;
            return;
        }
        long l4 = this.count - this.pos;
        this.pos = this.count;
        if (this.markpos != -1) {
            if (l <= (long)this.marklimit) {
                if (this.fillbuf() == -1) {
                    long l5 = l4;
                    return;
                }
                if ((long)(this.count - this.pos) >= l - l4) {
                    this.pos = (int)((long)this.pos + (l - l4));
                    long l6 = l;
                    return;
                }
                this.pos = this.count;
                long l7 = l4 += (long)(this.count - this.pos);
                return;
            }
            this.markpos = -1;
        }
        long l8 = l4 + this.in.skip(l - l4);
    }
}

