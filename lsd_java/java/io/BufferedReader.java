/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.Reader;

public class BufferedReader
extends Reader {
    private Reader in;
    private char[] buf;
    private int marklimit = -1;
    private int count;
    private int markpos = -1;
    private int pos;

    public BufferedReader(Reader reader) {
        super(reader);
        this.in = reader;
        this.buf = new char[8192];
    }

    public BufferedReader(Reader reader, int n) {
        super(reader);
        if (n <= 0) {
            throw new IllegalArgumentException(Msg.getString("K0058"));
        }
        this.in = reader;
        this.buf = new char[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                this.in.close();
                this.buf = null;
            }
        }
    }

    private int fillbuf() {
        int n;
        if (this.markpos == -1 || this.pos - this.markpos >= this.marklimit) {
            int n2 = this.in.read(this.buf, 0, this.buf.length);
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
            char[] cArray = new char[n];
            System.arraycopy((Object)this.buf, 0, (Object)cArray, 0, this.buf.length);
            this.buf = cArray;
        } else if (this.markpos > 0) {
            System.arraycopy((Object)this.buf, this.markpos, (Object)this.buf, 0, this.buf.length - this.markpos);
        }
        this.pos -= this.markpos;
        this.markpos = 0;
        this.count = 0;
        n = this.in.read(this.buf, this.pos, this.buf.length - this.pos);
        this.count = n == -1 ? this.pos : this.pos + n;
        return n;
    }

    private boolean isOpen() {
        return this.buf != null;
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
                    throw new IOException(Msg.getString("K005b"));
                }
                this.marklimit = n;
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
                if (this.pos < this.count || this.fillbuf() != -1) {
                    return this.buf[this.pos++];
                }
                return -1;
            }
            throw new IOException(Msg.getString("K005b"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int read(char[] cArray, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            int n3;
            int n4;
            int n5;
            block16: {
                if (!this.isOpen()) throw new IOException(Msg.getString("K005b"));
                n5 = cArray.length;
                if (n2 != 0) break block16;
                return 0;
            }
            if (n < 0) throw new ArrayIndexOutOfBoundsException();
            if (n > n5) throw new ArrayIndexOutOfBoundsException();
            if (n2 <= 0) throw new ArrayIndexOutOfBoundsException();
            if (n2 > n5 - n) throw new ArrayIndexOutOfBoundsException();
            if (this.pos < this.count) {
                n4 = this.count - this.pos >= n2 ? n2 : this.count - this.pos;
                System.arraycopy((Object)this.buf, this.pos, (Object)cArray, n, n4);
                this.pos += n4;
                if (n4 == n2) return n4;
                if (!this.in.ready()) {
                    return n4;
                }
                n += n4;
                n3 = n2 - n4;
            } else {
                n3 = n2;
            }
            while (true) {
                if (this.markpos == -1 && n3 >= this.buf.length) {
                    n4 = this.in.read(cArray, n, n3);
                    if (n4 == -1) {
                        if (n3 == n2) {
                            return -1;
                        }
                        int n6 = n2 - n3;
                        return n6;
                    }
                } else {
                    if (this.fillbuf() == -1) {
                        if (n3 == n2) {
                            return -1;
                        }
                        int n7 = n2 - n3;
                        return n7;
                    }
                    n4 = this.count - this.pos >= n3 ? n3 : this.count - this.pos;
                    System.arraycopy((Object)this.buf, this.pos, (Object)cArray, n, n4);
                    this.pos += n4;
                }
                if ((n3 -= n4) == 0) {
                    return n2;
                }
                if (!this.in.ready()) {
                    return n2 - n3;
                }
                n += n4;
            }
        }
    }

    public String readLine() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                int n = 0;
                StringBuffer stringBuffer = new StringBuffer(80);
                while (true) {
                    if (this.pos >= this.count) {
                        if (n == 10) {
                            return stringBuffer.toString();
                        }
                        if (this.fillbuf() == -1) {
                            return stringBuffer.length() > 0 || n != 0 ? stringBuffer.toString() : null;
                        }
                    }
                    int n2 = this.pos;
                    while (n2 < this.count) {
                        if (n == 0 && (this.buf[n2] == '\n' || this.buf[n2] == '\r')) {
                            n = this.buf[n2];
                        } else {
                            if (n == 13 && this.buf[n2] == '\n') {
                                if (n2 > this.pos) {
                                    stringBuffer.append(this.buf, this.pos, n2 - this.pos - 1);
                                }
                                this.pos = n2 + 1;
                                return stringBuffer.toString();
                            }
                            if (n != 0) {
                                if (n2 > this.pos) {
                                    stringBuffer.append(this.buf, this.pos, n2 - this.pos - 1);
                                }
                                this.pos = n2;
                                return stringBuffer.toString();
                            }
                        }
                        ++n2;
                    }
                    if (n != 0) {
                        stringBuffer.append(this.buf, this.pos, this.count - this.pos - 1);
                    } else {
                        stringBuffer.append(this.buf, this.pos, this.count - this.pos);
                    }
                    this.pos = this.count;
                }
            }
            throw new IOException(Msg.getString("K005b"));
        }
    }

    @Override
    public boolean ready() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                return this.count - this.pos > 0 || this.in.ready();
            }
            throw new IOException(Msg.getString("K005b"));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        Object object = this.lock;
        synchronized (object) {
            if (this.isOpen()) {
                if (this.markpos == -1) {
                    throw new IOException(Msg.getString("K005c"));
                }
            } else {
                throw new IOException(Msg.getString("K005b"));
            }
            this.pos = this.markpos;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public long skip(long l) {
        if (l < 0L) throw new IllegalArgumentException();
        Object object = this.lock;
        synchronized (object) {
            block8: {
                if (!this.isOpen()) throw new IOException(Msg.getString("K005b"));
                if (l >= 1L) break block8;
                return 0L;
            }
            if ((long)(this.count - this.pos) >= l) {
                this.pos = (int)((long)this.pos + l);
                return l;
            }
            long l2 = this.count - this.pos;
            this.pos = this.count;
            while (l2 < l) {
                if (this.fillbuf() == -1) {
                    return l2;
                }
                if ((long)(this.count - this.pos) >= l - l2) {
                    this.pos = (int)((long)this.pos + (l - l2));
                    return l;
                }
                l2 += (long)(this.count - this.pos);
                this.pos = this.count;
            }
            return l;
        }
    }
}

