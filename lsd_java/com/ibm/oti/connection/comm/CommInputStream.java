/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.comm;

import com.ibm.oti.connection.comm.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;

final class CommInputStream
extends InputStream {
    private Connection connection;
    private boolean open;
    private byte[] aByte = new byte[1];

    CommInputStream(Connection connection) {
        this.connection = connection;
        this.open = true;
    }

    @Override
    public int available() {
        if (this.open) {
            return this.connection.available();
        }
        throw new IOException(Msg.getString("K0059"));
    }

    @Override
    public void close() {
        if (this.open) {
            this.connection.closeStream(true);
        }
        this.open = false;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.open) {
            if (byArray != null) {
                if (n >= 0 && n2 >= 0 && n <= byArray.length && byArray.length - n >= n2) {
                    return this.connection.read(byArray, n, n2);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException();
        }
        throw new IOException(Msg.getString("K0059"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int read() {
        if (this.open) {
            CommInputStream commInputStream = this;
            synchronized (commInputStream) {
                if (this.connection.read(this.aByte, 0, 1) > 0) {
                    return this.aByte[0] & 0xFF;
                }
            }
            return -1;
        }
        throw new IOException(Msg.getString("K0059"));
    }
}

