/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import java.io.FileDescriptor;
import java.io.OutputStream;

class ProcessOutputStream
extends OutputStream {
    private long handle;
    private FileDescriptor fd = new FileDescriptor();

    static {
        ProcessOutputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    protected ProcessOutputStream(long l) {
        this.setFDImpl(this.fd, l);
        this.handle = l;
    }

    protected void finalize() {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close() {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            if (this.handle == -1L) {
                return;
            }
            this.closeImpl();
            this.handle = -1L;
        }
    }

    private native void closeImpl() {
    }

    private native void setFDImpl(FileDescriptor fileDescriptor, long l) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(byte[] byArray) {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            this.writeImpl(byArray, 0, byArray.length, this.handle);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(byte[] byArray, int n, int n2) {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            if (this.handle == -1L) {
                return;
            }
            this.writeImpl(byArray, n, n2, this.handle);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        byte[] byArray = new byte[]{(byte)n};
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            this.writeImpl(byArray, 0, 1, this.handle);
        }
    }

    private native void writeImpl(byte[] byArray, int n, int n2, long l) {
    }
}

