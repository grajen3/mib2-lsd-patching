/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import com.ibm.oti.connection.http.Connection;
import com.ibm.oti.util.Msg;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class Connection$HttpOutputStream
extends OutputStream {
    static final int MAX;
    ByteArrayOutputStream cache = new ByteArrayOutputStream(1031);
    boolean chunked;
    boolean closed = false;
    final /* synthetic */ Connection this$0;

    public Connection$HttpOutputStream(Connection connection, boolean bl) {
        this.this$0 = connection;
        this.chunked = bl;
    }

    private void output(String string) {
        this.this$0.socketOut.write(string.getBytes("ISO8859_1"));
    }

    synchronized void sendCache(boolean bl) {
        if (this.cache == null) {
            return;
        }
        int n = this.cache.size();
        if (n > 0 || bl) {
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
            this.this$0.socketOut.write(this.cache.toByteArray());
            if (bl) {
                this.this$0.socketOut.flush();
                this.chunked = false;
                this.cache = null;
            } else {
                this.cache.reset();
            }
        }
    }

    @Override
    public synchronized void flush() {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (!this.this$0.sentRequest) {
            this.chunked = true;
            this.this$0.sendRequest();
        }
        this.sendCache(false);
        this.this$0.socketOut.flush();
    }

    @Override
    public synchronized void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        IOException iOException = null;
        try {
            if (this.chunked) {
                if (this.this$0.sentRequest && this.this$0.socketOut != null) {
                    this.sendCache(this.closed);
                }
            } else if (!this.this$0.sentRequest) {
                this.this$0.sendRequest();
            }
        }
        catch (IOException iOException2) {
            iOException = iOException2;
        }
        if (this.this$0.conClosed) {
            if (this.this$0.socketOut != null) {
                this.this$0.socketOut.close();
            }
            if (this.this$0.socket != null) {
                this.this$0.socket.close();
            }
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override
    public synchronized void write(int n) {
        if (this.closed) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.cache != null) {
            this.cache.write(n);
            if (this.chunked && this.cache.size() >= 1024) {
                this.sendCache(false);
            }
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
        if (!this.chunked || this.cache.size() + n2 < 1024) {
            if (this.cache != null) {
                this.cache.write(byArray, n, n2);
            }
        } else {
            if (this.chunked) {
                if (!this.this$0.sentRequest) {
                    this.this$0.sendRequest();
                }
                this.output(new StringBuffer(String.valueOf(Integer.toHexString(n2 + this.cache.size()))).append("\r\n").toString());
            }
            this.this$0.socketOut.write(this.cache.toByteArray());
            this.cache.reset();
            this.this$0.socketOut.write(byArray, n, n2);
            if (this.chunked) {
                this.output("\r\n");
            }
        }
    }

    synchronized int size() {
        return this.cache.size();
    }

    synchronized byte[] toByteArray() {
        byte[] byArray = this.cache.toByteArray();
        this.cache = null;
        return byArray;
    }

    boolean isCached() {
        return !this.chunked;
    }

    boolean isChunked() {
        return this.chunked;
    }
}

