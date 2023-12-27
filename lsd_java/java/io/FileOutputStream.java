/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import com.ibm.oti.util.Msg;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStream
extends OutputStream {
    FileDescriptor fd;

    static {
        FileOutputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization() {
    }

    public FileOutputStream(File file) {
        this(file, false);
    }

    public FileOutputStream(File file, boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(file.getPath());
        }
        this.fd = new FileDescriptor();
        if (this.openImpl(file.properPath(true), bl) != 0) {
            throw new FileNotFoundException(file.getPath());
        }
    }

    public FileOutputStream(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkWrite(fileDescriptor);
            }
        } else {
            throw new NullPointerException(Msg.getString("K006c"));
        }
        this.fd = fileDescriptor;
    }

    public FileOutputStream(String string) {
        this(string, false);
    }

    public FileOutputStream(String string, boolean bl) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkWrite(string);
        }
        this.fd = new FileDescriptor();
        File file = new File(string);
        if (this.openImpl(file.properPath(true), bl) != 0) {
            throw new FileNotFoundException(string);
        }
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

    private native int openImpl(byte[] byArray, boolean bl) {
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.fd == null) {
            throw new IOException();
        }
        this.writeImpl(byArray, n, n2, this.getFD().descriptor);
    }

    private native void writeImpl(byte[] byArray, int n, int n2, long l) {
    }

    @Override
    public void write(int n) {
        if (this.fd == null) {
            throw new IOException();
        }
        this.writeByteImpl(n, this.getFD().descriptor);
    }

    private native void writeByteImpl(int n, long l) {
    }
}

