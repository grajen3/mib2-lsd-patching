/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.socket;

import com.ibm.oti.connection.socket.Connection;
import com.ibm.oti.connection.socket.Socket;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;

final class Connection$2
extends OutputStream {
    OutputStream stream;
    final /* synthetic */ Connection this$0;

    Connection$2(Connection connection) {
        this.this$0 = connection;
        this.stream = Connection.access$0(connection).getOutputStream();
    }

    @Override
    public void close() {
        if (Connection.access$3(this.this$0) != 2) {
            if ((Socket.getSocketFlags() & 8) == 0 || Connection.access$0(this.this$0).getSoLinger() == -1) {
                Connection.access$0(this.this$0).shutdownOutput();
            }
            Connection.access$5(this.this$0, 2);
            if (Connection.access$1(this.this$0) != 1 && Connection.access$4(this.this$0) == null) {
                this.stream.close();
            }
        }
    }

    @Override
    public void write(int n) {
        if (Connection.access$3(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.stream.write(n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (Connection.access$3(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.stream.write(byArray, n, n2);
    }

    @Override
    public void flush() {
        if (Connection.access$3(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.stream.flush();
    }
}

