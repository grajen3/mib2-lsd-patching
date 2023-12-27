/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketOptions;
import java.net.SocketTimeoutException;

public abstract class SocketImpl
implements SocketOptions {
    protected InetAddress address;
    protected int port;
    protected FileDescriptor fd;
    protected int localport;
    int receiveTimeout;
    boolean shutdownInput = false;

    static {
        SocketImpl.oneTimeInitialization(true);
    }

    private static native void oneTimeInitialization(boolean bl) {
    }

    public SocketImpl() {
        this.initializeSocket();
    }

    protected abstract void accept(SocketImpl socketImpl) {
    }

    protected abstract int available() {
    }

    protected abstract void bind(InetAddress inetAddress, int n) {
    }

    protected abstract void close() {
    }

    protected abstract void connect(String string, int n) {
    }

    protected abstract void connect(InetAddress inetAddress, int n) {
    }

    protected abstract void create(boolean bl) {
    }

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    protected InetAddress getInetAddress() {
        return this.address;
    }

    protected abstract InputStream getInputStream() {
    }

    protected int getLocalPort() {
        return this.localport;
    }

    @Override
    public abstract Object getOption(int n) {
    }

    protected abstract OutputStream getOutputStream() {
    }

    protected int getPort() {
        return this.port;
    }

    void initializeSocket() {
        this.fd = new FileDescriptor();
        this.receiveTimeout = 0;
    }

    protected abstract void listen(int n) {
    }

    static native void acceptStreamSocketImpl(FileDescriptor fileDescriptor, SocketImpl socketImpl, FileDescriptor fileDescriptor2, int n) {
    }

    static native int availableStreamImpl(FileDescriptor fileDescriptor) {
    }

    static native void createStreamSocketImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    static native void createDatagramSocketImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    static native void listenStreamSocketImpl(FileDescriptor fileDescriptor, int n) {
    }

    static native int receiveStreamImpl(FileDescriptor fileDescriptor, byte[] byArray, int n, int n2, int n3) {
    }

    static native int sendStreamImpl(FileDescriptor fileDescriptor, byte[] byArray, int n, int n2) {
    }

    int read(byte[] byArray, int n, int n2) {
        if (this.shutdownInput) {
            return -1;
        }
        try {
            int n3 = SocketImpl.receiveStreamImpl(this.fd, byArray, n, n2, this.receiveTimeout);
            if (n3 == -1) {
                this.shutdownInput = true;
            }
            return n3;
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
    }

    @Override
    public abstract void setOption(int n, Object object) {
    }

    public String toString() {
        return new StringBuffer(100).append("Socket[addr=").append(this.getInetAddress()).append(",port=").append(this.port).append(",localport=").append(this.getLocalPort()).append("]").toString();
    }

    int write(byte[] byArray, int n, int n2) {
        return SocketImpl.sendStreamImpl(this.fd, byArray, n, n2);
    }

    protected void shutdownInput() {
        this.shutdownInput = true;
        this.shutdownInputImpl(this.fd);
    }

    private native void shutdownInputImpl(FileDescriptor fileDescriptor) {
    }

    protected void shutdownOutput() {
        this.shutdownOutputImpl(this.fd);
    }

    private native void shutdownOutputImpl(FileDescriptor fileDescriptor) {
    }

    protected abstract void connect(SocketAddress socketAddress, int n) {
    }

    protected boolean supportsUrgentData() {
        return false;
    }

    protected abstract void sendUrgentData(int n) {
    }

    static native boolean supportsUrgentDataImpl(FileDescriptor fileDescriptor) {
    }

    static native boolean sendUrgentDataImpl(FileDescriptor fileDescriptor, byte by) {
    }
}

