/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;

public class PipedOutputStream
extends OutputStream {
    private PipedInputStream dest;

    public PipedOutputStream() {
    }

    public PipedOutputStream(PipedInputStream pipedInputStream) {
        this.connect(pipedInputStream);
    }

    @Override
    public void close() {
        if (this.dest != null) {
            this.dest.done();
            this.dest = null;
        }
    }

    public void connect(PipedInputStream pipedInputStream) {
        if (this.dest == null) {
            if (pipedInputStream.isConnected) {
                throw new IOException(Msg.getString("K007a"));
            }
        } else {
            throw new IOException(Msg.getString("K0079"));
        }
        pipedInputStream.buffer = new byte[1024];
        pipedInputStream.isConnected = true;
        this.dest = pipedInputStream;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flush() {
        if (this.dest != null) {
            PipedInputStream pipedInputStream = this.dest;
            synchronized (pipedInputStream) {
                super.notifyAll();
            }
        }
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        super.write(byArray, n, n2);
    }

    @Override
    public void write(int n) {
        if (this.dest == null) {
            throw new IOException();
        }
        this.dest.receive(n);
    }
}

