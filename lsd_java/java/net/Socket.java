/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainSocketImpl;
import java.net.PlainSocketImpl2;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;
import java.security.AccessController;

public class Socket {
    SocketImpl impl;
    static SocketImplFactory factory;
    private volatile boolean isCreated = false;
    private boolean isBound = false;
    private boolean isConnected = false;
    private boolean isClosed = false;
    private boolean isInputShutdown = false;
    private boolean isOutputShutdown = false;
    private Object connectLock = new Object();
    static final int MULTICAST_IF;
    static final int MULTICAST_TTL;
    static final int TCP_NODELAY;
    static final int FLAG_SHUTDOWN;
    static final int FLAG_BIND;

    static {
        Socket.oneTimeInitialization(true);
    }

    private static native void oneTimeInitialization(boolean bl) {
    }

    public Socket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainSocketImpl2();
    }

    public Socket(String string, int n) {
        this();
        InetAddress inetAddress = InetAddress.getByName(string);
        this.checkDestination(inetAddress, n);
        this.startupSocket(inetAddress, n, null, 0, true);
    }

    public Socket(String string, int n, InetAddress inetAddress, int n2) {
        this();
        InetAddress inetAddress2 = InetAddress.getByName(string);
        this.checkDestination(inetAddress2, n);
        this.startupSocket(inetAddress2, n, inetAddress, n2, true);
    }

    public Socket(InetAddress inetAddress, int n) {
        this();
        this.checkDestination(inetAddress, n);
        this.startupSocket(inetAddress, n, null, 0, true);
    }

    public Socket(InetAddress inetAddress, int n, InetAddress inetAddress2, int n2) {
        this();
        this.checkDestination(inetAddress, n);
        this.startupSocket(inetAddress, n, inetAddress2, n2, true);
    }

    protected Socket(SocketImpl socketImpl) {
        this.impl = socketImpl;
    }

    void checkDestination(InetAddress inetAddress, int n) {
        if (n < 0 || n > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0032"));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkConnect(inetAddress.getHostAddress(), n);
        }
    }

    public synchronized void close() {
        this.isClosed = true;
        this.impl.close();
    }

    public InetAddress getInetAddress() {
        if (!this.isConnected()) {
            return null;
        }
        return this.impl.getInetAddress();
    }

    public InputStream getInputStream() {
        this.checkClosedAndCreate(false);
        if (this.isInputShutdown()) {
            throw new SocketException(Msg.getString("K0321"));
        }
        return this.impl.getInputStream();
    }

    public boolean getKeepAlive() {
        this.checkClosedAndCreate(true);
        return (Boolean)this.impl.getOption(8);
    }

    public InetAddress getLocalAddress() {
        if (!this.isBound()) {
            return InetAddress.ANY;
        }
        return Socket.getSocketLocalAddressImpl(this.impl.fd, InetAddress.preferIPv6Addresses());
    }

    public int getLocalPort() {
        if (!this.isBound()) {
            return -1;
        }
        return this.impl.getLocalPort();
    }

    public OutputStream getOutputStream() {
        this.checkClosedAndCreate(false);
        return this.impl.getOutputStream();
    }

    public int getPort() {
        if (!this.isConnected()) {
            return 0;
        }
        return this.impl.getPort();
    }

    public int getSoLinger() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(128);
    }

    public synchronized int getReceiveBufferSize() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(4098);
    }

    public synchronized int getSendBufferSize() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(4097);
    }

    public synchronized int getSoTimeout() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(4102);
    }

    public boolean getTcpNoDelay() {
        this.checkClosedAndCreate(true);
        return (Boolean)this.impl.getOption(1);
    }

    static native InetAddress getSocketLocalAddressImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    static native int getSocketLocalPortImpl(FileDescriptor fileDescriptor, boolean bl) {
    }

    static native Object getSocketOptionImpl(FileDescriptor fileDescriptor, int n) {
    }

    static native void setSocketOptionImpl(FileDescriptor fileDescriptor, int n, Object object) {
    }

    public void setKeepAlive(boolean bl) {
        this.checkClosedAndCreate(true);
        this.impl.setOption(8, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    static native int getSocketFlags() {
    }

    static native void socketCloseImpl(FileDescriptor fileDescriptor) {
    }

    public static synchronized void setSocketImplFactory(SocketImplFactory socketImplFactory) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        if (factory != null) {
            throw new SocketException(Msg.getString("K0044"));
        }
        factory = socketImplFactory;
    }

    public synchronized void setSendBufferSize(int n) {
        this.checkClosedAndCreate(true);
        if (n < 1) {
            throw new IllegalArgumentException(Msg.getString("K0035"));
        }
        this.impl.setOption(4097, new Integer(n));
    }

    public synchronized void setReceiveBufferSize(int n) {
        this.checkClosedAndCreate(true);
        if (n < 1) {
            throw new IllegalArgumentException(Msg.getString("K0035"));
        }
        this.impl.setOption(4098, new Integer(n));
    }

    public void setSoLinger(boolean bl, int n) {
        this.checkClosedAndCreate(true);
        if (!bl || n >= 0) {
        } else {
            throw new IllegalArgumentException(Msg.getString("K0045"));
        }
        int n2 = bl ? (-65536 < n ? -65536 : n) : -1;
        this.impl.setOption(128, new Integer(n2));
    }

    public synchronized void setSoTimeout(int n) {
        this.checkClosedAndCreate(true);
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K0036"));
        }
        this.impl.setOption(4102, new Integer(n));
    }

    public void setTcpNoDelay(boolean bl) {
        this.checkClosedAndCreate(true);
        this.impl.setOption(1, new Boolean(bl));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void startupSocket(InetAddress inetAddress, int n, InetAddress inetAddress2, int n2, boolean bl) {
        if (n2 < 0 || n2 > -65536) {
            throw new IllegalArgumentException(Msg.getString("K0046"));
        }
        InetAddress inetAddress3 = inetAddress2 == null ? InetAddress.ANY : inetAddress2;
        Socket socket = this;
        synchronized (socket) {
            this.impl.create(bl);
            this.isCreated = true;
            try {
                if (!bl || !PlainSocketImpl.usingSocks()) {
                    this.impl.bind(inetAddress3, n2);
                }
                this.isBound = true;
                this.impl.connect(inetAddress, n);
                this.isConnected = true;
            }
            catch (IOException iOException) {
                this.impl.close();
                throw iOException;
            }
        }
    }

    public String toString() {
        if (!this.isConnected()) {
            return "Socket[unconnected]";
        }
        return this.impl.toString();
    }

    public void shutdownInput() {
        this.checkClosedAndCreate(false);
        this.impl.shutdownInput();
        this.isInputShutdown = true;
    }

    public void shutdownOutput() {
        this.checkClosedAndCreate(false);
        this.impl.shutdownOutput();
        this.isOutputShutdown = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkClosedAndCreate(boolean bl) {
        if (this.isClosed()) {
            throw new SocketException(Msg.getString("K003d"));
        }
        if (!bl && !this.isConnected()) {
            throw new SocketException(Msg.getString("K0074"));
        }
        if (this.isCreated) {
            return;
        }
        Socket socket = this;
        synchronized (socket) {
            if (this.isCreated) {
                return;
            }
            try {
                this.impl.create(true);
            }
            catch (SocketException socketException) {
                throw socketException;
            }
            catch (IOException iOException) {
                throw new SocketException(iOException.toString());
            }
            this.isCreated = true;
        }
    }

    public SocketAddress getLocalSocketAddress() {
        if (!this.isBound()) {
            return null;
        }
        return new InetSocketAddress(this.getLocalAddress(), this.getLocalPort());
    }

    public SocketAddress getRemoteSocketAddress() {
        if (!this.isConnected()) {
            return null;
        }
        return new InetSocketAddress(this.getInetAddress(), this.getPort());
    }

    public boolean isBound() {
        return this.isBound;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void bind(SocketAddress socketAddress) {
        Object object;
        this.checkClosedAndCreate(true);
        if (this.isBound()) {
            throw new BindException(Msg.getString("K0315"));
        }
        int n = 0;
        InetAddress inetAddress = InetAddress.ANY;
        if (socketAddress != null) {
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
            }
            object = (InetSocketAddress)socketAddress;
            inetAddress = ((InetSocketAddress)object).getAddress();
            if (inetAddress == null) {
                throw new SocketException(Msg.getString("K0317", ((InetSocketAddress)object).getHostName()));
            }
            n = ((InetSocketAddress)object).getPort();
        }
        object = this;
        synchronized (object) {
            try {
                if (!PlainSocketImpl.usingSocks()) {
                    this.impl.bind(inetAddress, n);
                }
                this.isBound = true;
            }
            catch (IOException iOException) {
                this.impl.close();
                throw iOException;
            }
        }
    }

    public void connect(SocketAddress socketAddress) {
        this.connect(socketAddress, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void connect(SocketAddress socketAddress, int n) {
        this.checkClosedAndCreate(true);
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K0036"));
        }
        if (this.isConnected()) {
            throw new SocketException(Msg.getString("K0079"));
        }
        if (socketAddress == null) {
            throw new IllegalArgumentException(Msg.getString("K0318"));
        }
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new IllegalArgumentException(Msg.getString("K0316", super.getClass()));
        }
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        InetAddress inetAddress = inetSocketAddress.getAddress();
        if (inetAddress == null) {
            throw new SocketException(Msg.getString("K0317", inetSocketAddress.getHostName()));
        }
        int n2 = inetSocketAddress.getPort();
        this.checkDestination(inetAddress, n2);
        Object object = this.connectLock;
        synchronized (object) {
            try {
                if (!this.isBound()) {
                    if (!PlainSocketImpl.usingSocks()) {
                        this.impl.bind(InetAddress.ANY, 0);
                    }
                    this.isBound = true;
                }
                this.impl.connect(socketAddress, n);
                this.isConnected = true;
            }
            catch (IOException iOException) {
                this.impl.close();
                throw iOException;
            }
        }
    }

    public boolean isInputShutdown() {
        return this.isInputShutdown;
    }

    public boolean isOutputShutdown() {
        return this.isOutputShutdown;
    }

    public void setReuseAddress(boolean bl) {
        this.checkClosedAndCreate(true);
        this.impl.setOption(4, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getReuseAddress() {
        this.checkClosedAndCreate(true);
        return (Boolean)this.impl.getOption(4);
    }

    public void setOOBInline(boolean bl) {
        this.checkClosedAndCreate(true);
        this.impl.setOption(4099, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getOOBInline() {
        this.checkClosedAndCreate(true);
        return (Boolean)this.impl.getOption(4099);
    }

    public void setTrafficClass(int n) {
        this.checkClosedAndCreate(true);
        if (n < 0 || n > 255) {
            throw new IllegalArgumentException();
        }
        this.impl.setOption(3, new Integer(n));
    }

    public int getTrafficClass() {
        this.checkClosedAndCreate(true);
        return ((Number)this.impl.getOption(3)).intValue();
    }

    public void sendUrgentData(int n) {
        if (!this.impl.supportsUrgentData()) {
            throw new SocketException(Msg.getString("K0333"));
        }
        this.impl.sendUrgentData(n);
    }

    void accepted() {
        this.isConnected = true;
        this.isBound = true;
        this.isCreated = true;
    }

    static boolean preferIPv4Stack() {
        String string = (String)AccessController.doPrivileged(new PriviAction("java.net.preferIPv4Stack"));
        return "true".equals(string);
    }
}

