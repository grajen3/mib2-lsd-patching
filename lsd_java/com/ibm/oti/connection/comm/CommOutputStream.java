/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.comm;

import com.ibm.oti.connection.comm.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;

final class CommOutputStream
extends OutputStream {
    private Connection connection;
    private boolean open;
    private byte[] aByte = new byte[1];

    CommOutputStream(Connection connection) {
        this.connection = connection;
        this.open = true;
    }

    @Override
    public void close() {
        if (this.open) {
            this.connection.closeStream(false);
        }
        this.open = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (!this.open) throw new IOException(Msg.getString("K0059"));
        if (byArray == null) throw new NullPointerException();
        if (n < 0 || n2 < 0 || n > byArray.length || byArray.length - n < n2) {
            throw new IndexOutOfBoundsException();
        }
        this.connection.write(byArray, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        if (this.open) {
            CommOutputStream commOutputStream = this;
            synchronized (commOutputStream) {
                this.aByte[0] = (byte)n;
                this.connection.write(this.aByte, 0, 1);
            }
        } else {
            throw new IOException(Msg.getString("K0059"));
        }
    }
}

