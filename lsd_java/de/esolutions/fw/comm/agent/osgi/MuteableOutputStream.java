/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import java.io.OutputStream;

public class MuteableOutputStream
extends OutputStream {
    private OutputStream stream;
    private boolean allowWrites;

    public MuteableOutputStream(OutputStream outputStream) {
        this.stream = outputStream;
        this.allowWrites = true;
    }

    @Override
    public synchronized void close() {
        if (this.stream != null) {
            this.stream.close();
            this.allowWrites = false;
            this.stream = null;
        }
    }

    public synchronized void disableWrites() {
        this.allowWrites = false;
    }

    @Override
    public synchronized void write(byte[] byArray) {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(byArray);
        }
    }

    @Override
    public synchronized void write(byte[] byArray, int n, int n2) {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(byArray, n, n2);
        }
    }

    @Override
    public synchronized void write(int n) {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(n);
        }
    }
}

