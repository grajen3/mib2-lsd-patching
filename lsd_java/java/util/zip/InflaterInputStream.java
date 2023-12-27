/*
 * Decompiled with CFR 0.152.
 */
package java.util.zip;

import com.ibm.oti.util.Msg;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class InflaterInputStream
extends FilterInputStream {
    protected Inflater inf;
    protected byte[] buf;
    protected int len;
    boolean closed = false;
    boolean eof = false;
    static final int BUF_SIZE;

    public InflaterInputStream(InputStream inputStream) {
        this(inputStream, new Inflater(), 512);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater) {
        this(inputStream, inflater, 512);
    }

    public InflaterInputStream(InputStream inputStream, Inflater inflater, int n) {
        super(inputStream);
        if (inputStream == null || inflater == null) {
            throw new NullPointerException();
        }
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.inf = inflater;
        this.buf = new byte[n];
    }

    @Override
    public int read() {
        byte[] byArray = new byte[1];
        if (this.read(byArray, 0, 1) == -1) {
            return -1;
        }
        return byArray[0] & 0xFF;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (byArray == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 < 0 || n + n2 > byArray.length) {
            throw new IndexOutOfBoundsException();
        }
        if (n2 == 0) {
            return 0;
        }
        if (this.inf.finished()) {
            this.eof = true;
            return -1;
        }
        if (n <= byArray.length && n2 >= 0 && n >= 0 && byArray.length - n >= n2) {
            if (n2 == 0) {
                return 0;
            }
            do {
                int n3;
                if (this.inf.needsInput()) {
                    this.fill();
                }
                try {
                    n3 = this.inf.inflate(byArray, n, n2);
                }
                catch (DataFormatException dataFormatException) {
                    if (this.len == -1) {
                        throw new EOFException();
                    }
                    throw new IOException(Msg.getString("K0413", dataFormatException.getMessage()));
                }
                if (n3 > 0) {
                    return n3;
                }
                if (this.inf.finished()) {
                    this.eof = true;
                    return -1;
                }
                if (!this.inf.needsDictionary()) continue;
                return -1;
            } while (this.len != -1);
            throw new EOFException();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    protected void fill() {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.len = this.in.read(this.buf);
        if (this.len > 0) {
            this.inf.setInput(this.buf, 0, this.len);
        }
    }

    @Override
    public long skip(long l) {
        if (l >= 0L) {
            long l2 = 0L;
            long l3 = 0L;
            while (l2 < l) {
                l3 = l - l2;
                int n = this.read(this.buf, 0, l3 > (long)this.buf.length ? this.buf.length : (int)l3);
                if (n == -1) {
                    this.eof = true;
                    return l2;
                }
                l2 += (long)n;
            }
            return l2;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int available() {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.eof) {
            return 0;
        }
        return 1;
    }

    @Override
    public void close() {
        if (!this.closed) {
            this.inf.end();
            this.closed = true;
            this.eof = true;
            super.close();
        }
    }
}

