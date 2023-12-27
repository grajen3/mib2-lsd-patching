/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import com.ibm.oti.connection.http.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;

final class Connection$2
extends InputStream {
    final /* synthetic */ Connection this$0;

    Connection$2(Connection connection) {
        this.this$0 = connection;
    }

    @Override
    public int available() {
        if (Connection.access$0(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.this$0.uis.available();
    }

    @Override
    public int read() {
        if (Connection.access$0(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.this$0.uis.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (Connection.access$0(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.this$0.uis.read(byArray, n, n2);
    }

    public long skip(int n) {
        if (Connection.access$0(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.this$0.uis.skip(n);
    }

    @Override
    public void close() {
        if (Connection.access$0(this.this$0) != 2) {
            Connection.access$1(this.this$0, 2);
            this.this$0.closeSocket();
        }
    }
}

