/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class DatagramPacket {
    byte[] data;
    int length;
    InetAddress address;
    int port;
    int offset = 0;

    public DatagramPacket(byte[] byArray, int n) {
        this(byArray, 0, n);
    }

    public DatagramPacket(byte[] byArray, int n, int n2) {
        this.setData(byArray, n, n2);
    }

    public DatagramPacket(byte[] byArray, int n, int n2, InetAddress inetAddress, int n3) {
        this(byArray, n, n2);
        this.setPort(n3);
        this.address = inetAddress;
    }

    public DatagramPacket(byte[] byArray, int n, InetAddress inetAddress, int n2) {
        this(byArray, 0, n, inetAddress, n2);
    }

    public synchronized InetAddress getAddress() {
        return this.address;
    }

    public synchronized byte[] getData() {
        return this.data;
    }

    public synchronized int getLength() {
        return this.length;
    }

    public synchronized int getOffset() {
        return this.offset;
    }

    public synchronized int getPort() {
        return this.port;
    }

    public synchronized void setAddress(InetAddress inetAddress) {
        this.address = inetAddress;
    }

    public synchronized void setData(byte[] byArray, int n, int n2) {
        if (n < 0 || n > byArray.length || n2 < 0 || n2 > byArray.length - n) {
            throw new IllegalArgumentException(Msg.getString("K002f"));
        }
        this.data = byArray;
        this.offset = n;
        this.length = n2;
    }

    public synchronized void setData(byte[] byArray) {
        this.length = byArray.length;
        this.data = byArray;
        this.offset = 0;
    }

    public synchronized void setLength(int n) {
        if (n < 0 || this.offset + n > this.data.length) {
            throw new IllegalArgumentException(Msg.getString("K002f"));
        }
        this.length = n;
    }

    public synchronized void setPort(int n) {
        if (n < 0 || n > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0325", n));
        }
        this.port = n;
    }

    public DatagramPacket(byte[] byArray, int n, SocketAddress socketAddress) {
        this(byArray, 0, n);
        this.setSocketAddress(socketAddress);
    }

    public DatagramPacket(byte[] byArray, int n, int n2, SocketAddress socketAddress) {
        this(byArray, n, n2);
        this.setSocketAddress(socketAddress);
    }

    public SocketAddress getSocketAddress() {
        return new InetSocketAddress(this.getAddress(), this.getPort());
    }

    public void setSocketAddress(SocketAddress socketAddress) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException(Msg.getString("K0316", socketAddress == null ? null : super.getClass()));
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        this.port = inetSocketAddress.getPort();
        this.address = inetSocketAddress.getAddress();
    }
}

