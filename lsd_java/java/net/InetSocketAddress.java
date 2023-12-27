/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddress
extends SocketAddress {
    private static final long serialVersionUID;
    private String hostName;
    private InetAddress addr;
    private int port;

    public InetSocketAddress(int n) {
        this((InetAddress)null, n);
    }

    public InetSocketAddress(InetAddress inetAddress, int n) {
        if (n < 0 || n > -65536) {
            throw new IllegalArgumentException();
        }
        this.addr = inetAddress == null ? InetAddress.ANY : inetAddress;
        this.port = n;
    }

    public InetSocketAddress(String string, int n) {
        if (string == null || n < 0 || n > -65536) {
            throw new IllegalArgumentException();
        }
        this.port = n;
        try {
            this.addr = InetAddress.getByName(string);
        }
        catch (UnknownHostException unknownHostException) {
            this.hostName = string;
        }
    }

    public final int getPort() {
        return this.port;
    }

    public final InetAddress getAddress() {
        return this.addr;
    }

    public final String getHostName() {
        if (this.addr != null) {
            return this.addr.getHostName();
        }
        return this.hostName;
    }

    public final boolean isUnresolved() {
        return this.addr == null;
    }

    public String toString() {
        String string = this.addr != null ? this.addr.toString() : this.hostName;
        return new StringBuffer(String.valueOf(string)).append(":").append(this.port).toString();
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof InetSocketAddress)) {
            return false;
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)object;
        if (this.port != inetSocketAddress.port) {
            return false;
        }
        if (this.addr == null && inetSocketAddress.addr == null) {
            return this.hostName.equals(inetSocketAddress.hostName);
        }
        if (this.addr == null) {
            return false;
        }
        return this.addr.equals(inetSocketAddress.addr);
    }

    public final int hashCode() {
        if (this.addr == null) {
            return this.hostName.hashCode() + this.port;
        }
        return this.addr.hashCode() + this.port;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.addr == null) {
            try {
                this.addr = InetAddress.getByName(this.hostName);
            }
            catch (UnknownHostException unknownHostException) {}
        }
    }
}

