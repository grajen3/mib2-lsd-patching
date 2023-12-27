/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class HttpURLConnection$HttpOutputStream
extends OutputStream {
    static final int MAX;
    ByteArrayOutputStream cache = new ByteArrayOutputStream(1031);
    boolean writeToSocket;
    boolean closed = false;
    int limit;
    final /* synthetic */ HttpURLConnection this$0;

    public HttpURLConnection$HttpOutputStream(HttpURLConnection httpURLConnection) {
        this.this$0 = httpURLConnection;
        this.limit = -1;
    }

    public HttpURLConnection$HttpOutputStream(HttpURLConnection httpURLConnection, int n) {
        this.this$0 = httpURLConnection;
        this.writeToSocket = true;
        this.limit = n;
    }

    private void output(String string) {
        this.this$0.socketOut.write(string.getBytes("ISO8859_1"));
    }

    private void sendCache(boolean bl) {
        int n = this.cache.size();
        if (n > 0 || bl) {
            if (this.limit < 0) {
                if (n > 0) {
                    this.output(new StringBuffer(String.valueOf(Integer.toHexString(n))).append("\r\n").toString());
                    this.cache.write(13);
                    this.cache.write(10);
                }
                if (bl) {
                    this.cache.write(48);
                    this.cache.write(13);
                    this.cache.write(10);
                    this.cache.write(13);
                    this.cache.write(10);
                }
            }
            this.this$0.socketOut.write(this.cache.toByteArray());
            this.cache.reset();
        }
    }

    @Override
    public synchronized void flush() {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.writeToSocket) {
            this.sendCache(false);
            this.this$0.socketOut.flush();
        }
    }

    @Override
    public synchronized void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        if (this.writeToSocket) {
            if (this.limit > 0) {
                throw new IOException(Msg.getString("K00a4"));
            }
            this.sendCache(this.closed);
        }
    }

    @Override
    public synchronized void write(int n) {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.limit >= 0) {
            if (this.limit == 0) {
                throw new IOException(Msg.getString("K00b2"));
            }
            --this.limit;
        }
        this.cache.write(n);
        if (this.writeToSocket && this.cache.size() >= 1024) {
            this.sendCache(false);
        }
    }

    @Override
    public synchronized void write(byte[] byArray, int n, int n2) {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (byArray == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException(Msg.getString("K002f"));
        }
        if (this.limit >= 0) {
            if (n2 > this.limit) {
                throw new IOException(Msg.getString("K00b2"));
            }
            this.limit -= n2;
        }
        if (!this.writeToSocket || this.cache.size() + n2 < 1024) {
            this.cache.write(byArray, n, n2);
        } else {
            if (this.limit < 0) {
                this.output(new StringBuffer(String.valueOf(Integer.toHexString(n2 + this.cache.size()))).append("\r\n").toString());
            }
            this.this$0.socketOut.write(this.cache.toByteArray());
            this.cache.reset();
            this.this$0.socketOut.write(byArray, n, n2);
            if (this.limit < 0) {
                this.output("\r\n");
            }
        }
    }

    synchronized int size() {
        return this.cache.size();
    }

    synchronized byte[] toByteArray() {
        return this.cache.toByteArray();
    }

    boolean isCached() {
        return !this.writeToSocket;
    }

    boolean isChunked() {
        return this.writeToSocket && this.limit == -1;
    }
}

