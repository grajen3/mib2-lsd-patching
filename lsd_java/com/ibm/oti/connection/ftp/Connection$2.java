/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ftp;

import com.ibm.oti.connection.ftp.Connection;
import java.io.OutputStream;

final class Connection$2
extends OutputStream {
    final /* synthetic */ Connection this$0;
    private final /* synthetic */ OutputStream val$dataOut;

    Connection$2(Connection connection, OutputStream outputStream) {
        this.this$0 = connection;
        this.val$dataOut = outputStream;
    }

    @Override
    public void write(int n) {
        this.val$dataOut.write(n);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.val$dataOut.write(byArray, n, n2);
    }

    @Override
    public void close() {
        this.val$dataOut.close();
    }
}

