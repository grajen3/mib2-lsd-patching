/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStream
extends InputStream {
    FileDescriptor fd;

    static {
        FileInputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public FileInputStream(File file) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(file.getPath());
        }
        this.fd = new FileDescriptor();
        if (this.openImpl(file.properPath(true)) != 0) {
            throw new FileNotFoundException(file.getPath());
        }
    }

    public FileInputStream(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkRead(fileDescriptor);
            }
        } else {
            throw new NullPointerException();
        }
        this.fd = fileDescriptor;
    }

    public FileInputStream(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkRead(string);
        }
        this.fd = new FileDescriptor();
        if (this.openImpl(new File(string).properPath(true)) != 0) {
            throw new FileNotFoundException(string);
        }
    }

    @Override
    public native int available() {
    }

    @Override
    public void close() {
        this.closeImpl();
    }

    private native void closeImpl() {
    }

    protected void finalize() {
        if (this.fd != null) {
            this.close();
        }
    }

    public final FileDescriptor getFD() {
        if (this.fd != null) {
            return this.fd;
        }
        throw new IOException();
    }

    private native int openImpl(byte[] byArray) {
    }

    @Override
    public int read() {
        if (this.fd != null) {
            return this.readByteImpl(this.getFD().descriptor);
        }
        throw new IOException();
    }

    private native int readByteImpl(long l) {
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.fd != null) {
            return this.readImpl(byArray, n, n2, this.getFD().descriptor);
        }
        throw new IOException();
    }

    private native int readImpl(byte[] byArray, int n, int n2, long l) {
    }

    @Override
    public native long skip(long l) {
    }
}

