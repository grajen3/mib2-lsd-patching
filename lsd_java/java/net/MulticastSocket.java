/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.DatagramSocketImpl;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.AccessController;
import java.util.Enumeration;

public class MulticastSocket
extends DatagramSocket {
    static final int SO_REUSEPORT;
    private InetAddress interfaceSet = null;

    public MulticastSocket() {
    }

    public MulticastSocket(int n) {
        super(n);
    }

    public InetAddress getInterface() {
        this.checkClosedAndBind(false);
        if (this.interfaceSet == null) {
            Enumeration enumeration;
            NetworkInterface networkInterface;
            InetAddress inetAddress = (InetAddress)this.impl.getOption(16);
            if (inetAddress.isAnyLocalAddress() && (networkInterface = this.getNetworkInterface()) != null && (enumeration = networkInterface.getInetAddresses()) != null) {
                while (enumeration.hasMoreElements()) {
                    InetAddress inetAddress2 = (InetAddress)enumeration.nextElement();
                    if (!(inetAddress2 instanceof Inet6Address)) continue;
                    return inetAddress2;
                }
            }
            return inetAddress;
        }
        return this.interfaceSet;
    }

    public NetworkInterface getNetworkInterface() {
        InetAddress[] inetAddressArray;
        Object object;
        this.checkClosedAndBind(false);
        Integer n = new Integer(0);
        try {
            n = (Integer)this.impl.getOption(31);
        }
        catch (SocketException socketException) {}
        if (n != 0) {
            object = NetworkInterface.getNetworkInterfaces();
            while (object.hasMoreElements()) {
                inetAddressArray = (InetAddress[])object.nextElement();
                if (inetAddressArray.getIndex() != n.intValue()) continue;
                return inetAddressArray;
            }
        }
        if ((object = (InetAddress)this.impl.getOption(16)) != null) {
            if (!((InetAddress)object).isAnyLocalAddress()) {
                return NetworkInterface.getByInetAddress((InetAddress)object);
            }
            inetAddressArray = new InetAddress[]{!Socket.preferIPv4Stack() && InetAddress.preferIPv6Addresses() ? Inet6Address.ANY : Inet4Address.ANY};
            return new NetworkInterface(null, null, inetAddressArray, -1);
        }
        return null;
    }

    public int getTimeToLive() {
        this.checkClosedAndBind(false);
        return this.impl.getTimeToLive();
    }

    @Override
    boolean isMulticastSocket() {
        return true;
    }

    public void joinGroup(InetAddress inetAddress) {
        this.checkClosedAndBind(false);
        if (!inetAddress.isMulticastAddress()) {
            throw new IOException(Msg.getString("K0039"));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkMulticast(inetAddress);
        }
        this.impl.join(inetAddress);
    }

    public void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
        this.checkClosedAndBind(false);
        if (socketAddress == null) {
            throw new IllegalArgumentException(Msg.getString("K0331"));
        }
        if (networkInterface != null && networkInterface.getFirstAddress() == null) {
            throw new SocketException(Msg.getString("K0335"));
        }
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            if (inetAddress == null) {
                throw new SocketException(Msg.getString("K0317", inetAddress.getHostName()));
            }
            if (!inetAddress.isMulticastAddress()) {
                throw new IOException(Msg.getString("K0039"));
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkMulticast(inetAddress);
            }
        } else {
            throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
        }
        this.impl.joinGroup(socketAddress, networkInterface);
    }

    public void leaveGroup(InetAddress inetAddress) {
        this.checkClosedAndBind(false);
        if (!inetAddress.isMulticastAddress()) {
            throw new IOException(Msg.getString("K003a"));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkMulticast(inetAddress);
        }
        this.impl.leave(inetAddress);
    }

    public void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) {
        this.checkClosedAndBind(false);
        if (socketAddress == null) {
            throw new IllegalArgumentException(Msg.getString("K0331"));
        }
        if (networkInterface != null && networkInterface.getFirstAddress() == null) {
            throw new SocketException(Msg.getString("K0335"));
        }
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            if (inetAddress == null) {
                throw new SocketException(Msg.getString("K0317", inetAddress.getHostName()));
            }
            if (!inetAddress.isMulticastAddress()) {
                throw new IOException(Msg.getString("K003a"));
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkMulticast(inetAddress);
            }
        } else {
            throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
        }
        this.impl.leaveGroup(socketAddress, networkInterface);
    }

    public void send(DatagramPacket datagramPacket, byte by) {
        this.checkClosedAndBind(false);
        InetAddress inetAddress = datagramPacket.getAddress();
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            if (inetAddress.isMulticastAddress()) {
                securityManager.checkMulticast(inetAddress, by);
            } else {
                securityManager.checkConnect(inetAddress.getHostAddress(), datagramPacket.getPort());
            }
        }
        int n = this.getTimeToLive();
        if (inetAddress.isMulticastAddress() && (byte)n != by) {
            try {
                this.setTimeToLive(by & 0xFF);
                this.impl.send(datagramPacket);
            }
            finally {
                this.setTimeToLive(n);
            }
        } else {
            this.impl.send(datagramPacket);
        }
    }

    public void setInterface(InetAddress inetAddress) {
        this.checkClosedAndBind(false);
        if (inetAddress == null) {
            throw new NullPointerException();
        }
        if (inetAddress.isAnyLocalAddress()) {
            this.impl.setOption(16, Inet4Address.ANY);
        } else if (inetAddress instanceof Inet4Address) {
            this.impl.setOption(16, inetAddress);
            this.interfaceSet = inetAddress;
        }
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
        if (networkInterface != null && networkInterface.getIndex() != 0) {
            try {
                this.impl.setOption(31, new Integer(networkInterface.getIndex()));
            }
            catch (SocketException socketException) {}
        } else if (inetAddress.isAnyLocalAddress()) {
            try {
                this.impl.setOption(31, new Integer(0));
            }
            catch (SocketException socketException) {}
        } else if (inetAddress instanceof Inet6Address) {
            throw new SocketException(Msg.getString("K0338"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void setNetworkInterface(NetworkInterface networkInterface) {
        this.checkClosedAndBind(false);
        if (networkInterface == null) throw new SocketException(Msg.getString("K0334"));
        InetAddress inetAddress = networkInterface.getFirstAddress();
        if (inetAddress == null) throw new SocketException(Msg.getString("K0335"));
        if (networkInterface.getIndex() == -1) {
            this.impl.setOption(16, InetAddress.ANY);
            try {
                this.impl.setOption(31, new Integer(0));
            }
            catch (SocketException socketException) {}
        }
        Enumeration enumeration = networkInterface.getInetAddresses();
        boolean bl = false;
        inetAddress = null;
        while (enumeration.hasMoreElements() && !bl) {
            InetAddress inetAddress2 = (InetAddress)enumeration.nextElement();
            if (!(inetAddress2 instanceof Inet4Address)) continue;
            inetAddress = inetAddress2;
            bl = true;
        }
        if (networkInterface.getIndex() == 0) {
            if (inetAddress == null) throw new SocketException(Msg.getString("K0335"));
            this.impl.setOption(16, inetAddress);
        } else {
            if (inetAddress != null) {
                this.impl.setOption(16, inetAddress);
            }
            try {
                this.impl.setOption(31, new Integer(networkInterface.getIndex()));
            }
            catch (SocketException socketException) {}
        }
        this.interfaceSet = null;
    }

    public void setTimeToLive(int n) {
        this.checkClosedAndBind(false);
        if (n < 0 || n > 255) {
            throw new IllegalArgumentException(Msg.getString("K003c"));
        }
        this.impl.setTimeToLive(n);
    }

    @Override
    synchronized void createSocket(int n, InetAddress inetAddress) {
        this.impl = factory != null ? factory.createDatagramSocketImpl() : this.createSocketImpl();
        this.impl.create();
        try {
            this.impl.bind(n, inetAddress);
            this.isBound = true;
        }
        catch (SocketException socketException) {
            this.close();
            throw socketException;
        }
    }

    public MulticastSocket(SocketAddress socketAddress) {
        super(socketAddress);
    }

    public boolean getLoopbackMode() {
        this.checkClosedAndBind(false);
        return (Boolean)this.impl.getOption(18) == false;
    }

    public void setLoopbackMode(boolean bl) {
        this.checkClosedAndBind(false);
        this.impl.setOption(18, bl ? Boolean.FALSE : Boolean.TRUE);
    }

    @Override
    DatagramSocketImpl createSocketImpl() {
        Object object = null;
        String string = (String)AccessController.doPrivileged(new PriviAction("impl.prefix", "Plain"));
        try {
            Class clazz = Class.forName(new StringBuffer("java.net.").append(string).append("MulticastSocketImpl").toString());
            object = clazz.newInstance();
        }
        catch (Exception exception) {
            throw new SocketException(Msg.getString("K0033"));
        }
        return (DatagramSocketImpl)object;
    }
}

