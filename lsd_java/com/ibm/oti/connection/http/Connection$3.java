/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import com.ibm.oti.connection.http.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;

final class Connection$3
extends OutputStream {
    final /* synthetic */ Connection this$0;

    Connection$3(Connection connection) {
        this.this$0 = connection;
    }

    @Override
    public void write(int n) {
        if (Connection.access$2(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.this$0.os.write(n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (Connection.access$2(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.this$0.os.write(byArray, n, n2);
    }

    @Override
    public void flush() {
        if (Connection.access$2(this.this$0) == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.this$0.os.flush();
    }

    @Override
    public void close() {
        if (Connection.access$2(this.this$0) != 2) {
            Connection.access$3(this.this$0, 2);
            this.this$0.os.close();
        }
    }
}

