/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainServerSocketImpl;
import java.net.PlainSocketImpl;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public class ServerSocket {
    SocketImpl impl;
    static SocketImplFactory factory;
    private volatile boolean isCreated = false;
    private boolean isBound = false;
    private boolean isClosed = false;

    public ServerSocket() {
        this.impl = factory != null ? factory.createSocketImpl() : new PlainServerSocketImpl();
    }

    public ServerSocket(int n) {
        this(n, ServerSocket.defaultBacklog(), InetAddress.ANY);
    }

    public ServerSocket(int n, int n2) {
        this(n, n2, InetAddress.ANY);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ServerSocket(int n, int n2, InetAddress inetAddress) {
        this.checkListen(n);
        this.impl = factory != null ? factory.createSocketImpl() : new PlainServerSocketImpl();
        InetAddress inetAddress2 = inetAddress == null ? InetAddress.ANY : inetAddress;
        ServerSocket serverSocket = this;
        synchronized (serverSocket) {
            this.impl.create(true);
            this.isCreated = true;
            try {
                this.impl.bind(inetAddress2, n);
                this.isBound = true;
                this.impl.listen(n2 > 0 ? n2 : ServerSocket.defaultBacklog());
            }
            catch (IOException iOException) {
                this.close();
                throw iOException;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Socket accept() {
        this.checkClosedAndCreate(false);
        if (!this.isBound()) {
            throw new SocketException(Msg.getString("K031f"));
        }
        if (PlainSocketImpl.usingSocks()) {
            if (this.impl instanceof PlainSocketImpl) {
                try {
                    SecurityManager securityManager = System.getSecurityManager();
                    if (securityManager != null) {
                        securityManager.checkAccept(this.getInetAddress().getHostAddress(), this.getLocalPort());
                    }
                }
                catch (SecurityException securityException) {
                    this.close();
                    throw securityException;
                }
                ((PlainSocketImpl)this.impl).socksAccept();
                return new Socket(this.impl);
            }
            throw new IOException(Msg.getString("K0041"));
        }
        Socket socket = new Socket();
        try {
            Object object = this;
            synchronized (object) {
                this.implAccept(socket);
            }
            object = System.getSecurityManager();
            if (object != null) {
                ((SecurityManager)object).checkAccept(socket.getInetAddress().getHostAddress(), socket.getPort());
            }
        }
        catch (SecurityException securityException) {
            socket.close();
            throw securityException;
        }
        catch (IOException iOException) {
            socket.close();
            throw iOException;
        }
        return socket;
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

    static int defaultBacklog() {
        return 50;
    }

    public InetAddress getInetAddress() {
        if (!this.isBound()) {
            return null;
        }
        return this.impl.getInetAddress();
    }

    public int getLocalPort() {
        if (!this.isBound()) {
            return -1;
        }
        return this.impl.getLocalPort();
    }

    public synchronized int getSoTimeout() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(4102);
    }

    protected final void implAccept(Socket socket) {
        this.impl.accept(socket.impl);
        socket.accepted();
    }

    public static synchronized void setSocketFactory(SocketImplFactory socketImplFactory) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        if (factory != null) {
            throw new SocketException(Msg.getString("K0042"));
        }
        factory = socketImplFactory;
    }

    public synchronized void setSoTimeout(int n) {
        this.checkClosedAndCreate(true);
        if (n < 0) {
            throw new IllegalArgumentException(Msg.getString("K0036"));
        }
        this.impl.setOption(4102, new Integer(n));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append("ServerSocket[");
        if (!this.isBound()) {
            return stringBuffer.append("unbound]").toString();
        }
        return stringBuffer.append("addr=").append(this.getInetAddress()).append(",port=0,localport=").append(this.getLocalPort()).append("]").toString();
    }

    public void bind(SocketAddress socketAddress) {
        this.bind(socketAddress, ServerSocket.defaultBacklog());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void bind(SocketAddress socketAddress, int n) {
        Object object;
        this.checkClosedAndCreate(true);
        if (this.isBound()) {
            throw new BindException(Msg.getString("K0315"));
        }
        int n2 = 0;
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
            n2 = ((InetSocketAddress)object).getPort();
        }
        if ((object = System.getSecurityManager()) != null) {
            ((SecurityManager)object).checkListen(n2);
        }
        ServerSocket serverSocket = this;
        synchronized (serverSocket) {
            try {
                this.impl.bind(inetAddress, n2);
                this.isBound = true;
                this.impl.listen(n > 0 ? n : ServerSocket.defaultBacklog());
            }
            catch (IOException iOException) {
                this.close();
                throw iOException;
            }
        }
    }

    public SocketAddress getLocalSocketAddress() {
        if (!this.isBound()) {
            return null;
        }
        return new InetSocketAddress(this.getInetAddress(), this.getLocalPort());
    }

    public boolean isBound() {
        return this.isBound;
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkClosedAndCreate(boolean bl) {
        if (this.isClosed()) {
            throw new SocketException(Msg.getString("K003d"));
        }
        if (!bl || this.isCreated) {
            return;
        }
        ServerSocket serverSocket = this;
        synchronized (serverSocket) {
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

    public void setReuseAddress(boolean bl) {
        this.checkClosedAndCreate(true);
        this.impl.setOption(4, bl ? Boolean.TRUE : Boolean.FALSE);
    }

    public boolean getReuseAddress() {
        this.checkClosedAndCreate(true);
        return (Boolean)this.impl.getOption(4);
    }

    public void setReceiveBufferSize(int n) {
        this.checkClosedAndCreate(true);
        if (n < 1) {
            throw new IllegalArgumentException(Msg.getString("K0035"));
        }
        this.impl.setOption(4098, new Integer(n));
    }

    public int getReceiveBufferSize() {
        this.checkClosedAndCreate(true);
        return (Integer)this.impl.getOption(4098);
    }
}

