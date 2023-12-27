/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocketImpl;
import java.net.GenericIPMreq;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.Hashtable;

class PlainDatagramSocketImpl
extends DatagramSocketImpl {
    private static final int SO_BROADCAST;
    static final int IP_MULTICAST_ADD;
    static final int IP_MULTICAST_DROP;
    static final int IP_MULTICAST_TTL;
    private boolean bindToDevice;
    private byte[] ipaddress = new byte[4];
    private int ttl = 1;
    private volatile boolean isNativeConnected = false;
    static final int REUSEADDR_AND_REUSEPORT;
    private InetAddress connectedAddress = null;
    private int connectedPort = -1;
    private int trafficClass = 0;
    private static boolean fixBind;
    private static Hashtable checkBind;
    boolean reuseAddr = false;

    static {
        fixBind = false;
        PlainDatagramSocketImpl.oneTimeInitialization(true);
        String string = (String)AccessController.doPrivileged(new PriviAction("uniqueBindFix"));
        boolean bl = fixBind = string != null && string.toLowerCase().equals("true");
        if (fixBind) {
            checkBind = new Hashtable();
        }
    }

    PlainDatagramSocketImpl() {
    }

    private static native void oneTimeInitialization(boolean bl) {
    }

    @Override
    protected void bind(int n, InetAddress inetAddress) {
        boolean bl;
        String string = (String)AccessController.doPrivileged(new PriviAction("bindToDevice"));
        boolean bl2 = bl = string != null && string.toLowerCase().equals("true");
        if (fixBind && !this.reuseAddr && n != 0 && checkBind.get(new Integer(n)) != null) {
            throw new BindException(Msg.getString("K03ba", n));
        }
        try {
            this.bindToDevice = PlainDatagramSocketImpl.socketBindImpl2(this.fd, n, bl, inetAddress);
        }
        catch (BindException bindException) {
            throw new BindException(new StringBuffer().append(inetAddress).append(":").append(n).append(" - ").append(bindException.getMessage()).toString());
        }
        this.localPort = n != 0 ? n : Socket.getSocketLocalPortImpl(this.fd, InetAddress.preferIPv6Addresses());
        if (fixBind) {
            Integer n2 = new Integer(this.localPort);
            checkBind.put(n2, n2);
        }
        try {
            this.setOption(32, Boolean.TRUE);
        }
        catch (IOException iOException) {}
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void close() {
        FileDescriptor fileDescriptor = this.fd;
        synchronized (fileDescriptor) {
            if (this.fd.valid()) {
                Socket.socketCloseImpl(this.fd);
                if (fixBind) {
                    checkBind.remove(new Integer(this.localPort));
                }
                this.initializeSocket();
            }
        }
    }

    @Override
    protected void create() {
        PlainDatagramSocketImpl.createDatagramSocketImpl(this.fd, Socket.preferIPv4Stack());
    }

    protected void finalize() {
        this.close();
    }

    @Override
    InetAddress getLocalAddress() {
        return Socket.getSocketLocalAddressImpl(this.fd, InetAddress.preferIPv6Addresses());
    }

    @Override
    public Object getOption(int n) {
        if (n == 4102) {
            return new Integer(this.receiveTimeout);
        }
        if (n == 3) {
            return new Integer(this.trafficClass);
        }
        Object object = Socket.getSocketOptionImpl(this.fd, n);
        if (n == 16 && (Socket.getSocketFlags() & 1) != 0) {
            return new Inet4Address(this.ipaddress);
        }
        return object;
    }

    @Override
    protected int getTimeToLive() {
        int n = (Byte)this.getOption(17) & 0xFF;
        if ((Socket.getSocketFlags() & 2) != 0) {
            return this.ttl;
        }
        return n;
    }

    protected byte getTTL() {
        byte by = (Byte)this.getOption(17);
        if ((Socket.getSocketFlags() & 2) != 0) {
            return (byte)this.ttl;
        }
        return by;
    }

    @Override
    protected void join(InetAddress inetAddress) {
        this.setOption(19, new GenericIPMreq(inetAddress));
    }

    @Override
    protected void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            this.setOption(19, new GenericIPMreq(inetAddress, networkInterface));
        }
    }

    @Override
    protected void leave(InetAddress inetAddress) {
        this.setOption(20, new GenericIPMreq(inetAddress));
    }

    @Override
    protected void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            this.setOption(20, new GenericIPMreq(inetAddress, networkInterface));
        }
    }

    protected static native void connectDatagramImpl2(FileDescriptor fileDescriptor, int n, int n2, InetAddress inetAddress) {
    }

    protected static native void disconnectDatagramImpl(FileDescriptor fileDescriptor) {
    }

    protected static native void createDatagramSocketImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    protected static native boolean socketBindImpl2(FileDescriptor fileDescriptor, int n, boolean bl, InetAddress inetAddress) {
    }

    protected static native int peekDatagramImpl(FileDescriptor fileDescriptor, InetAddress inetAddress, int n) {
    }

    protected static native int receiveDatagramImpl2(FileDescriptor fileDescriptor, DatagramPacket datagramPacket, byte[] byArray, int n, int n2, int n3, boolean bl) {
    }

    protected static native int recvConnectedDatagramImpl(FileDescriptor fileDescriptor, DatagramPacket datagramPacket, byte[] byArray, int n, int n2, int n3, boolean bl) {
    }

    protected static native int sendDatagramImpl2(FileDescriptor fileDescriptor, byte[] byArray, int n, int n2, int n3, boolean bl, int n4, InetAddress inetAddress) {
    }

    protected static native int sendConnectedDatagramImpl(FileDescriptor fileDescriptor, byte[] byArray, int n, int n2, boolean bl) {
    }

    @Override
    protected int peek(InetAddress inetAddress) {
        if (this.isNativeConnected) {
            byte[] byArray = new byte[10];
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
            PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
            inetAddress.ipaddress = this.connectedAddress.getAddress();
            return this.connectedPort;
        }
        return PlainDatagramSocketImpl.peekDatagramImpl(this.fd, inetAddress, this.receiveTimeout);
    }

    @Override
    protected void receive(DatagramPacket datagramPacket) {
        boolean bl;
        try {
            if (this.isNativeConnected) {
                PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, false);
                this.updatePacketRecvAddress(datagramPacket);
            } else {
                PlainDatagramSocketImpl.receiveDatagramImpl2(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, false);
            }
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
        byte[] byArray = InetAddress.LOOPBACK.ipaddress;
        boolean bl2 = bl = byArray.length == this.ipaddress.length;
        if (bl) {
            int n = 0;
            while (n < byArray.length) {
                if (byArray[n] != this.ipaddress[n]) {
                    bl = false;
                    break;
                }
                ++n;
            }
        }
        if (bl) {
            try {
                if (datagramPacket.getAddress().equals(InetAddress.getLocalHost())) {
                    datagramPacket.setAddress(InetAddress.LOOPBACK);
                }
            }
            catch (UnknownHostException unknownHostException) {}
        }
    }

    @Override
    protected void send(DatagramPacket datagramPacket) {
        if (this.isNativeConnected) {
            PlainDatagramSocketImpl.sendConnectedDatagramImpl(this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.bindToDevice);
        } else {
            PlainDatagramSocketImpl.sendDatagramImpl2(this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), datagramPacket.getPort(), this.bindToDevice, this.trafficClass, datagramPacket.getAddress());
        }
    }

    @Override
    public void setOption(int n, Object object) {
        if (n == 512) {
            this.reuseAddr = (Boolean)object;
        } else if (n == 4) {
            n = 10001;
            this.reuseAddr = (Boolean)object;
        }
        if (n == 4102) {
            this.receiveTimeout = (Integer)object;
        } else {
            int n2;
            block15: {
                n2 = Socket.getSocketFlags();
                try {
                    Socket.setSocketOptionImpl(this.fd, n | n2 << 16, object);
                }
                catch (SocketException socketException) {
                    if (n == 3) break block15;
                    throw socketException;
                }
            }
            if (n == 16 && (n2 & 1) != 0) {
                InetAddress inetAddress = (InetAddress)object;
                if (inetAddress.ipaddress.length == 4 && InetAddress.bytesToInt(inetAddress.ipaddress, 0) == 0 || inetAddress.equals(InetAddress.LOOPBACK)) {
                    this.ipaddress = ((InetAddress)object).getAddress();
                } else {
                    InetAddress inetAddress2 = null;
                    try {
                        inetAddress2 = InetAddress.getLocalHost();
                    }
                    catch (UnknownHostException unknownHostException) {
                        throw new SocketException(new StringBuffer("getLocalHost(): ").append(unknownHostException.toString()).toString());
                    }
                    if (inetAddress.equals(inetAddress2)) {
                        this.ipaddress = ((InetAddress)object).getAddress();
                    } else {
                        throw new SocketException(new StringBuffer().append(object).append(" != getLocalHost(): ").append(inetAddress2).toString());
                    }
                }
            }
            if (n == 3) {
                this.trafficClass = (Integer)object;
            }
        }
    }

    @Override
    protected void setTimeToLive(int n) {
        this.setOption(17, new Byte((byte)(n & 0xFF)));
        if ((Socket.getSocketFlags() & 2) != 0) {
            this.ttl = n;
        }
    }

    protected void setTTL(byte by) {
        this.setOption(17, new Byte(by));
        if ((Socket.getSocketFlags() & 2) != 0) {
            this.ttl = by;
        }
    }

    @Override
    protected void connect(InetAddress inetAddress, int n) {
        PlainDatagramSocketImpl.connectDatagramImpl2(this.fd, n, this.trafficClass, inetAddress);
        try {
            this.connectedAddress = InetAddress.getByAddress(inetAddress.getAddress());
        }
        catch (UnknownHostException unknownHostException) {
            throw new SocketException(Msg.getString("K0317", inetAddress.getHostName()));
        }
        this.connectedPort = n;
        this.isNativeConnected = true;
    }

    @Override
    protected void disconnect() {
        try {
            PlainDatagramSocketImpl.disconnectDatagramImpl(this.fd);
        }
        catch (Exception exception) {}
        this.connectedPort = -1;
        this.connectedAddress = null;
        this.isNativeConnected = false;
    }

    @Override
    protected int peekData(DatagramPacket datagramPacket) {
        try {
            if (this.isNativeConnected) {
                PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
                this.updatePacketRecvAddress(datagramPacket);
            } else {
                PlainDatagramSocketImpl.receiveDatagramImpl2(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
            }
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
        return datagramPacket.getPort();
    }

    private void updatePacketRecvAddress(DatagramPacket datagramPacket) {
        datagramPacket.setAddress(this.connectedAddress);
        datagramPacket.port = this.connectedPort;
    }
}

