/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.ssl;

import com.ibm.j9.ssl.StreamQueue;
import com.ibm.oti.connection.ssl.Connection;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;

final class Connection$SSLInputStream
extends InputStream {
    private final StreamQueue applicationDataInputQueue;
    final /* synthetic */ Connection this$0;

    Connection$SSLInputStream(Connection connection, StreamQueue streamQueue) {
        this.this$0 = connection;
        this.applicationDataInputQueue = streamQueue;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int available() {
        if (this.this$0.inputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.applicationDataInputQueue.getReadStream().available() != 0 || this.this$0.inputStream != null) ** GOTO lbl7
        return -1;
lbl-1000:
        // 1 sources

        {
            this.this$0.readData();
lbl7:
            // 2 sources

            ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && this.this$0.inputStream != null && this.this$0.inputStream.available() > 0)
        }
lbl8:
        // 1 sources

        return this.applicationDataInputQueue.getReadStream().available();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int read() {
        if (this.this$0.inputStatus != 2) ** GOTO lbl5
        throw new IOException(Msg.getString("K0059"));
lbl-1000:
        // 1 sources

        {
            this.this$0.readData();
lbl5:
            // 2 sources

            ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && this.this$0.inputStream != null)
        }
lbl6:
        // 1 sources

        if (this.applicationDataInputQueue.getReadStream().available() == 0 && this.this$0.inputStream == null) {
            return -1;
        }
        return this.applicationDataInputQueue.getReadStream().read();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int read(byte[] var1_1, int var2_2, int var3_3) {
        if (this.this$0.inputStatus != 2) ** GOTO lbl5
        throw new IOException(Msg.getString("K0059"));
lbl-1000:
        // 1 sources

        {
            this.this$0.readData();
lbl5:
            // 2 sources

            ** while (this.applicationDataInputQueue.getReadStream().available() == 0 && this.this$0.inputStream != null)
        }
lbl6:
        // 2 sources

        while (this.this$0.inputStream != null && this.this$0.inputStream.available() > 0 && this.applicationDataInputQueue.getReadStream().available() < var3_3) {
            this.this$0.readData();
        }
        if (this.this$0.inputStream == null && this.applicationDataInputQueue.getReadStream().available() == 0) {
            return -1;
        }
        return this.applicationDataInputQueue.getReadStream().read(var1_1, var2_2, var3_3);
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public void close() {
        if (this.this$0.inputStatus != 2) {
            this.this$0.inputStatus = 2;
            if (this.this$0.inputStream != null) {
                this.this$0.inputStream.close();
            }
            if (this.this$0.outputStatus == 2) {
                this.this$0.closeConnection();
            }
        }
    }
}

