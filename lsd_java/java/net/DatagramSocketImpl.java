/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketOptions;

public abstract class DatagramSocketImpl
implements SocketOptions {
    protected FileDescriptor fd;
    protected int localPort;
    int receiveTimeout;

    public DatagramSocketImpl() {
        this.initializeSocket();
    }

    protected abstract void bind(int n, InetAddress inetAddress) {
    }

    protected abstract void close() {
    }

    protected abstract void create() {
    }

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    abstract InetAddress getLocalAddress() {
    }

    protected int getLocalPort() {
        return this.localPort;
    }

    @Override
    public abstract Object getOption(int n) {
    }

    protected abstract int getTimeToLive() {
    }

    void initializeSocket() {
        this.fd = new FileDescriptor();
        this.localPort = -1;
        this.receiveTimeout = 0;
    }

    protected abstract void join(InetAddress inetAddress) {
    }

    protected abstract void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
    }

    protected abstract void leave(InetAddress inetAddress) {
    }

    protected abstract void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
    }

    protected abstract int peek(InetAddress inetAddress) {
    }

    protected abstract void receive(DatagramPacket datagramPacket) {
    }

    protected abstract void send(DatagramPacket datagramPacket) {
    }

    @Override
    public abstract void setOption(int n, Object object) {
    }

    protected abstract void setTimeToLive(int n) {
    }

    protected void connect(InetAddress inetAddress, int n) {
    }

    protected void disconnect() {
    }

    protected abstract int peekData(DatagramPacket datagramPacket) {
    }
}

