/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ftp;

import com.ibm.oti.connection.ftp.Connection;
import java.io.InputStream;

final class Connection$1
extends InputStream {
    final /* synthetic */ Connection this$0;
    private final /* synthetic */ InputStream val$dataIn;

    Connection$1(Connection connection, InputStream inputStream) {
        this.this$0 = connection;
        this.val$dataIn = inputStream;
    }

    @Override
    public int available() {
        return this.val$dataIn.available();
    }

    @Override
    public int read() {
        return this.val$dataIn.read();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        return this.val$dataIn.read(byArray, n, n2);
    }

    @Override
    public long skip(long l) {
        return this.val$dataIn.skip(l);
    }

    @Override
    public void close() {
        this.val$dataIn.close();
    }
}

