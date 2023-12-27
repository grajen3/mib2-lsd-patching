/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.socket;

import com.ibm.oti.connection.socket.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;

final class Connection$1
extends InputStream {
    InputStream stream;
    final /* synthetic */ Connection this$0;

    Connection$1(Connection connection) {
        this.this$0 = connection;
        this.stream = Connection.access$0(connection).getInputStream();
    }

    @Override
    public int available() {
        if (Connection.access$1(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.stream.available();
    }

    public long skip(int n) {
        if (Connection.access$1(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.stream.skip(n);
    }

    @Override
    public void close() {
        if (Connection.access$1(this.this$0) != 2) {
            Connection.access$2(this.this$0, 2);
            if (Connection.access$3(this.this$0) != 1 && Connection.access$4(this.this$0) == null) {
                this.stream.close();
            }
        }
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (Connection.access$1(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        int n3 = this.stream.read(byArray, n, n2);
        return n3;
    }

    @Override
    public int read() {
        if (Connection.access$1(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.stream.read();
    }
}

