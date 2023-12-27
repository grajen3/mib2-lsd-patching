/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.http;

import com.ibm.oti.net.www.protocol.http.HttpURLConnection;
import java.io.InputStream;

class HttpURLConnection$LimitedInputStream
extends InputStream {
    int bytesRemaining;
    final /* synthetic */ HttpURLConnection this$0;

    public HttpURLConnection$LimitedInputStream(HttpURLConnection httpURLConnection, int n) {
        this.this$0 = httpURLConnection;
        this.bytesRemaining = n;
    }

    @Override
    public void close() {
        this.this$0.closeSocket();
        this.bytesRemaining = 0;
    }

    @Override
    public int available() {
        int n = this.this$0.is.available();
        if (n > this.bytesRemaining) {
            return this.bytesRemaining;
        }
        return n;
    }

    @Override
    public int read() {
        if (this.bytesRemaining <= 0) {
            return -1;
        }
        int n = this.this$0.is.read();
        --this.bytesRemaining;
        return n;
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
        if (this.bytesRemaining <= 0) {
            return -1L;
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

