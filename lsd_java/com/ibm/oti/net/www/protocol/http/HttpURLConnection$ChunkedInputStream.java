/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import java.io.InputStream;

class HttpURLConnection$ChunkedInputStream
extends InputStream {
    int bytesRemaining = -1;
    boolean atEnd = false;
    final /* synthetic */ HttpURLConnection this$0;

    public HttpURLConnection$ChunkedInputStream(HttpURLConnection httpURLConnection) {
        this.this$0 = httpURLConnection;
        this.readChunkSize();
    }

    @Override
    public void close() {
        this.this$0.closeSocket();
        this.atEnd = true;
    }

    @Override
    public int available() {
        int n = this.this$0.is.available();
        if (n > this.bytesRemaining) {
            return this.bytesRemaining;
        }
        return n;
    }

    private void readChunkSize() {
        String string;
        int n;
        if (this.atEnd) {
            return;
        }
        if (this.bytesRemaining == 0) {
            this.this$0.readln();
        }
        if ((n = (string = this.this$0.readln()).indexOf(59)) >= 0) {
            string = string.substring(0, n);
        }
        this.bytesRemaining = Integer.parseInt(string.trim(), 16);
        if (this.bytesRemaining == 0) {
            this.atEnd = true;
            this.this$0.readHeaders();
        }
    }

    @Override
    public int read() {
        if (this.bytesRemaining <= 0) {
            this.readChunkSize();
        }
        if (this.atEnd) {
            return -1;
        }
        --this.bytesRemaining;
        return this.this$0.is.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        int n3;
        if (byArray == null) {
            throw new NullPointerException();
        }
        if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.bytesRemaining <= 0) {
            this.readChunkSize();
        }
        if (this.atEnd) {
            return -1;
        }
        if (n2 > this.bytesRemaining) {
            n2 = this.bytesRemaining;
        }
        if ((n3 = this.this$0.is.read(byArray, n, n2)) > 0) {
            this.bytesRemaining -= n3;
        }
        return n3;
    }

    public long skip(int n) {
        long l;
        if (this.atEnd) {
            return -1L;
        }
        if (this.bytesRemaining <= 0) {
            this.readChunkSize();
        }
        if (n > this.bytesRemaining) {
            n = this.bytesRemaining;
        }
        if ((l = this.this$0.is.skip(n)) > 0L) {
            this.bytesRemaining = (int)((long)this.bytesRemaining - l);
        }
        return l;
    }
}

