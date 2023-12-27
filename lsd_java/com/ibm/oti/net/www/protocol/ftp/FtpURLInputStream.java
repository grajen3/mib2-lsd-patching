/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import java.io.InputStream;
import java.net.Socket;

class FtpURLInputStream
extends InputStream {
    InputStream is;
    Socket controlSocket;

    public FtpURLInputStream(InputStream inputStream, Socket socket) {
        this.is = inputStream;
        this.controlSocket = socket;
    }

    @Override
    public int read() {
        return this.is.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        return this.is.read(byArray, n, n2);
    }

    @Override
    public synchronized void reset() {
        this.is.reset();
    }

    @Override
    public synchronized void mark(int n) {
        this.is.mark(n);
    }

    @Override
    public boolean markSupported() {
        return this.is.markSupported();
    }

    @Override
    public void close() {
        try {
            this.is.close();
        }
        catch (Exception exception) {}
        try {
            this.controlSocket.close();
        }
        catch (Exception exception) {}
    }

    @Override
    public int available() {
        return this.is.available();
    }

    @Override
    public long skip(long l) {
        return this.is.skip(l);
    }
}

