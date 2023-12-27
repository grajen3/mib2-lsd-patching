/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.net.DatagramPacket;
import java.net.DatagramSocketImpl;
import java.net.DatagramSocketImplFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.AccessController;

public class DatagramSocket {
    DatagramSocketImpl impl;
    InetAddress address;
    int port = -1;
    static DatagramSocketImplFactory factory;
    boolean isBound = false;
    private boolean isConnected = false;
    private boolean isClosed = false;
    Object lock = new Object();

    public DatagramSocket() {
        this(0);
    }

    public DatagramSocket(int n) {
        this.checkListen(n);
        this.createSocket(n, InetAddress.ANY);
    }

    public DatagramSocket(int n, InetAddress inetAddress) {
        this.checkListen(n);
        this.createSocket(n, inetAddress == null ? InetAddress.ANY : inetAddress);
    }

    void checkListen(int n) {
        if (n < 0 || n > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0325", n));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkListen(n);
        }
    }

    public void close() {
        this.isClosed = true;
        this.impl.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connect(InetAddress inetAddress, int n) {
        if (inetAddress == null || n < 0 || n > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0032"));
        }
        Object object = this.lock;
        synchronized (object) {
            if (this.isClosed()) {
                return;
            }
            try {
                this.checkClosedAndBind(true);
            }
            catch (SocketException socketException) {}
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                if (inetAddress.isMulticastAddress()) {
                    securityManager.checkMulticast(inetAddress);
                } else {
                    securityManager.checkConnect(inetAddress.getHostAddress(), n);
                }
            }
            try {
                this.impl.connect(inetAddress, n);
            }
            catch (SocketException socketException) {}
            this.address = inetAddress;
            this.port = n;
            this.isConnected = true;
        }
    }

    public void disconnect() {
        if (this.isClosed() || !this.isConnected()) {
            return;
        }
        this.impl.disconnect();
        this.address = null;
        this.port = -1;
        this.isConnected = false;
    }

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

    DatagramSocketImpl createSocketImpl() {
        Object object = null;
        String string = (String)AccessController.doPrivileged(new PriviAction("impl.prefix", "Plain"));
        try {
            Class clazz = Class.forName(new StringBuffer("java.net.").append(string).append("DatagramSocketImpl").toString());
            object = clazz.newInstance();
        }
        catch (Exception exception) {
            throw new SocketException(Msg.getString("K0033"));
        }
        return (DatagramSocketImpl)object;
    }

    public InetAddress getInetAddress() {
        return this.address;
    }

    public InetAddress getLocalAddress() {
        if (this.isClosed()) {
            return null;
        }
        if (!this.isBound()) {
            return InetAddress.ANY;
        }
        InetAddress inetAddress = this.impl.getLocalAddress();
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkConnect(inetAddress.getHostAddress(), -1);
            }
        }
        catch (SecurityException securityException) {
            return InetAddress.ANY;
        }
        return inetAddress;
    }

    public int getLocalPort() {
        if (this.isClosed()) {
            return -1;
        }
        if (!this.isBound()) {
            return 0;
        }
        return this.impl.getLocalPort();
    }

    public int getPort() {
        return this.port;
    }

    boolean isMulticastSocket() {
        return false;
    }

    public synchronized int getReceiveBufferSize() {
        this.checkClosedAndBind(false);
        return (Integer)this.impl.getOption(4098);
    }

    public synchronized int getSendBufferSize() {
        this.checkClosedAndBind(false);
        return (Integer)this.impl.getOption(4097);
    }

    public synchronized int getSoTimeout() {
        this.checkClosedAndBind(false);
        return (Integer)this.impl.getOption(4102);
    }

    public synchronized void receive(DatagramPacket datagramPacket) {
        this.checkClosedAndBind(true);
        boolean bl = true;
        InetAddress inetAddress = null;
        int n = 0;
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1], 1);
        boolean bl2 = false;
        SecurityManager securityManager = System.getSecurityManager();
        if (this.address != null || securityManager != null) {
            if (datagramPacket == null) {
                throw new NullPointerException();
            }
            bl = false;
            while (!bl) {
                bl2 = false;
                try {
                    n = this.impl.peekData(datagramPacket2);
                    inetAddress = datagramPacket2.getAddress();
                }
                catch (SocketException socketException) {
                    if (socketException.getMessage().equals("The socket does not support the operation")) {
                        datagramPacket2 = new DatagramPacket(new byte[datagramPacket.length], datagramPacket.getLength());
                        this.impl.receive(datagramPacket2);
                        inetAddress = datagramPacket2.getAddress();
                        n = datagramPacket2.getPort();
                        bl2 = true;
                    }
                    throw socketException;
                }
                if (this.address == null) {
                    try {
                        securityManager.checkAccept(inetAddress.getHostAddress(), n);
                        if (bl2) break;
                        bl = true;
                        break;
                    }
                    catch (SecurityException securityException) {
                        if (bl2) continue;
                        if (datagramPacket2 == null) {
                            datagramPacket2 = new DatagramPacket(new byte[datagramPacket.length], datagramPacket.length);
                        }
                        this.impl.receive(datagramPacket2);
                        continue;
                    }
                }
                if (this.port == n && this.address.equals(inetAddress)) {
                    if (bl2) break;
                    bl = true;
                    break;
                }
                if (bl2) continue;
                if (datagramPacket2 == null) {
                    datagramPacket2 = new DatagramPacket(new byte[datagramPacket.length], datagramPacket.length);
                }
                this.impl.receive(datagramPacket2);
            }
        }
        if (bl2) {
            System.arraycopy((Object)datagramPacket2.getData(), 0, (Object)datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket2.getLength());
            datagramPacket.setLength(datagramPacket2.getLength());
            datagramPacket.setAddress(datagramPacket2.getAddress());
            datagramPacket.setPort(datagramPacket2.getPort());
        }
        if (bl) {
            this.impl.receive(datagramPacket);
        }
    }

    public void send(DatagramPacket datagramPacket) {
        this.checkClosedAndBind(true);
        InetAddress inetAddress = datagramPacket.getAddress();
        if (this.address != null) {
            if (inetAddress != null) {
                if (!this.address.equals(inetAddress) || this.port != datagramPacket.getPort()) {
                    throw new IllegalArgumentException(Msg.getString("K0034"));
                }
            } else {
                datagramPacket.setAddress(this.address);
                datagramPacket.setPort(this.port);
            }
        } else {
            if (inetAddress == null) {
                throw new NullPointerException(Msg.getString("K0331"));
            }
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                if (inetAddress.isMulticastAddress()) {
                    securityManager.checkMulticast(inetAddress);
                } else {
                    securityManager.checkConnect(inetAddress.getHostAddress(), datagramPacket.getPort());
                }
            }
        }
        this.impl.send(datagramPacket);
    }

    public synchronized void setSendBufferSize(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(Msg.getString("K0035"));
        }
        this.checkClosedAndBind(false);
        this.impl.setOption(4097, new Integer(n));
    }

    public synchronized void setReceiveBufferSize(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(Msg.getString("K0035"));
        }
        this.checkClosedAndBind(false);
        this.impl.setOption(4098, new Integer(n));
    }

    public synchronized void setSoTimeout(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K0036"));
        }
        this.checkClosedAndBind(false);
        this.impl.setOption(4102, new Integer(n));
    }

    public static synchronized void setDatagramSocketImplFactory(DatagramSocketImplFactory datagramSocketImplFactory) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        if (factory != null) {
            throw new SocketException(Msg.getString("K0044"));
        }
        factory = datagramSocketImplFactory;
    }

    protected DatagramSocket(DatagramSocketImpl datagramSocketImpl) {
        this.impl = datagramSocketImpl;
    }

    public DatagramSocket(SocketAddress socketAddress) {
        if (socketAddress != null) {
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
            }
            this.checkListen(((InetSocketAddress)socketAddress).getPort());
        }
        this.impl = factory != null ? factory.createDatagramSocketImpl() : this.createSocketImpl();
        this.impl.create();
        if (socketAddress != null) {
            try {
                this.bind(socketAddress);
            }
            catch (SocketException socketException) {
                this.close();
                throw socketException;
            }
        }
    }

    void checkClosedAndBind(boolean bl) {
        if (this.isClosed()) {
            throw new SocketException(Msg.getString("K003d"));
        }
        if (bl && !this.isBound()) {
            this.checkListen(0);
            this.impl.bind(0, InetAddress.ANY);
            this.isBound = true;
        }
    }

    public void bind(SocketAddress socketAddress) {
        this.checkClosedAndBind(false);
        int n = 0;
        InetAddress inetAddress = InetAddress.ANY;
        if (socketAddress != null) {
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
            inetAddress = inetSocketAddress.getAddress();
            if (inetAddress == null) {
                throw new SocketException(Msg.getString("K0317", inetSocketAddress.getHostName()));
            }
            n = inetSocketAddress.getPort();
            this.checkListen(n);
        }
        this.impl.bind(n, inetAddress);
        this.isBound = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connect(SocketAddress socketAddress) {
        if (socketAddress == null) {
            throw new IllegalArgumentException(Msg.getString("K0318"));
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        if (inetSocketAddress.getAddress() == null) {
            throw new SocketException(Msg.getString("K0317", inetSocketAddress.getHostName()));
        }
        Object object = this.lock;
        synchronized (object) {
            this.checkClosedAndBind(true);
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                if (inetSocketAddress.getAddress().isMulticastAddress()) {
                    securityManager.checkMulticast(inetSocketAddress.getAddress());
                } else {
                    securityManager.checkConnect(inetSocketAddress.getAddress().getHostAddress(), inetSocketAddress.getPort());
                }
            }
            try {
                this.impl.connect(inetSocketAddress.getAddress(), inetSocketAddress.getPort());
            }
            catch (Exception exception) {}
            this.address = inetSocketAddress.getAddress();
            this.port = inetSocketAddress.getPort();
            this.isConnected = true;
        }
    }

    public boolean isBound() {
        return this.isBound;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public SocketAddress getRemoteSocketAddress() {
        if (!this.isConnected()) {
            return null;
        }
        return new InetSocketAddress(this.getInetAddress(), this.getPort());
    }

    public SocketAddress getLocalSocketAddress() {
        if (!this.isBound()) {
            return null;
        }
        return new InetSocketAddress(this.getLocalAddress(), this.getLocalPort());
    }

    public void setReuseAddress(boolean bl) {
        this.checkClosedAndBind(false);
        this.impl.setOption(4, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getReuseAddress() {
        this.checkClosedAndBind(false);
        return (Boolean)this.impl.getOption(4);
    }

    public void setBroadcast(boolean bl) {
        this.checkClosedAndBind(false);
        this.impl.setOption(32, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getBroadcast() {
        this.checkClosedAndBind(false);
        return (Boolean)this.impl.getOption(32);
    }

    public void setTrafficClass(int n) {
        this.checkClosedAndBind(false);
        if (n < 0 || n > 255) {
            throw new IllegalArgumentException();
        }
        this.impl.setOption(3, new Integer(n));
    }

    public int getTrafficClass() {
        this.checkClosedAndBind(false);
        return ((Number)this.impl.getOption(3)).intValue();
    }

    public boolean isClosed() {
        return this.isClosed;
    }
}

