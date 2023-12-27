/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ssl;

import com.ibm.oti.connection.ssl.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;

final class Connection$SSLOutputStream
extends OutputStream {
    final /* synthetic */ Connection this$0;

    Connection$SSLOutputStream(Connection connection) {
        this.this$0 = connection;
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.this$0.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.this$0.writeData(byArray, n, n2, (byte)23);
    }

    @Override
    public void write(byte[] byArray) {
        if (this.this$0.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.this$0.writeData(byArray, 0, byArray.length, (byte)23);
    }

    @Override
    public void write(int n) {
        if (this.this$0.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.write(new byte[]{(byte)n});
    }

    @Override
    public void close() {
        if (this.this$0.outputStatus != 2) {
            this.this$0.outputStatus = 2;
            this.this$0.outputStream.close();
            if (this.this$0.inputStatus == 2) {
                this.this$0.closeConnection();
            }
        }
    }
}

