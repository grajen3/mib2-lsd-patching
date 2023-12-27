/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PlainSocketImpl2;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.SocketInputStream;
import java.net.SocketOutputStream;
import java.net.SocketTimeoutException;
import java.net.Socks4Message;
import java.security.AccessController;

class PlainSocketImpl
extends SocketImpl {
    private static InetAddress lastConnectedAddress;
    private static int lastConnectedPort;
    private boolean tcpNoDelay = true;
    private Object connectLock = new Object();
    private int trafficClass = 0;

    PlainSocketImpl() {
    }

    @Override
    protected void accept(SocketImpl socketImpl) {
        if (PlainSocketImpl.usingSocks()) {
            ((PlainSocketImpl)socketImpl).socksBind();
            ((PlainSocketImpl)socketImpl).socksAccept();
            return;
        }
        try {
            PlainSocketImpl.acceptStreamSocketImpl(this.fd, socketImpl, socketImpl.fd, this.receiveTimeout);
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
        socketImpl.localport = this.getLocalPort();
    }

    @Override
    protected synchronized int available() {
        if (this.shutdownInput) {
            return 0;
        }
        return PlainSocketImpl.availableStreamImpl(this.fd);
    }

    @Override
    protected void bind(InetAddress inetAddress, int n) {
        if (PlainSocketImpl.usingSocks()) {
            this.socksBind();
            return;
        }
        try {
            PlainSocketImpl2.socketBindImpl2(this.fd, n, inetAddress);
        }
        catch (BindException bindException) {
            throw new BindException(new StringBuffer().append(inetAddress).append(":").append(n).append(" - ").append(bindException.getMessage()).toString());
        }
        this.address = inetAddress;
        this.localport = n != 0 ? n : Socket.getSocketLocalPortImpl(this.fd, InetAddress.preferIPv6Addresses());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void close() {
        FileDescriptor fileDescriptor = this.fd;
        synchronized (fileDescriptor) {
            if (this.fd.valid()) {
                if ((Socket.getSocketFlags() & 8) != 0) {
                    try {
                        this.shutdownOutput();
                    }
                    catch (Exception exception) {}
                }
                Socket.socketCloseImpl(this.fd);
                this.initializeSocket();
            }
        }
    }

    @Override
    protected void connect(String string, int n) {
        InetAddress inetAddress = InetAddress.getHostByNameImpl(string, InetAddress.preferIPv6Addresses());
        this.connect(inetAddress, n);
    }

    @Override
    protected void connect(InetAddress inetAddress, int n) {
        this.connect(inetAddress, n, 0);
    }

    private void connect(InetAddress inetAddress, int n, int n2) {
        InetAddress inetAddress2 = inetAddress.equals(InetAddress.ANY) ? InetAddress.LOOPBACK : inetAddress;
        try {
            if (PlainSocketImpl.usingSocks()) {
                this.socksConnect(inetAddress, n, 0);
            } else if (n2 == 0) {
                PlainSocketImpl2.connectStreamSocketImpl2(this.fd, n, this.trafficClass, inetAddress2);
            } else {
                PlainSocketImpl2.connectStreamWithTimeoutSocketImpl2(this.fd, n, n2, this.trafficClass, inetAddress2);
            }
        }
        catch (ConnectException connectException) {
            throw new ConnectException(new StringBuffer().append(inetAddress).append(":").append(n).append(" - ").append(connectException.getMessage()).toString());
        }
        this.address = inetAddress;
        this.port = n;
    }

    @Override
    protected void create(boolean bl) {
        PlainSocketImpl.createStreamSocketImpl(this.fd, Socket.preferIPv4Stack());
    }

    protected void finalize() {
        this.close();
    }

    @Override
    protected synchronized InputStream getInputStream() {
        if (!this.fd.valid()) {
            throw new SocketException(Msg.getString("K003d"));
        }
        return new SocketInputStream(this);
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
        if (n == 1 && (Socket.getSocketFlags() & 4) != 0) {
            return new Boolean(this.tcpNoDelay);
        }
        return object;
    }

    @Override
    protected synchronized OutputStream getOutputStream() {
        if (!this.fd.valid()) {
            throw new SocketException(Msg.getString("K003d"));
        }
        return new SocketOutputStream(this);
    }

    @Override
    protected void listen(int n) {
        if (PlainSocketImpl.usingSocks()) {
            return;
        }
        PlainSocketImpl.listenStreamSocketImpl(this.fd, n);
    }

    @Override
    public void setOption(int n, Object object) {
        if (n == 4102) {
            this.receiveTimeout = (Integer)object;
        } else {
            block6: {
                try {
                    Socket.setSocketOptionImpl(this.fd, n, object);
                    if (n == 1 && (Socket.getSocketFlags() & 4) != 0) {
                        this.tcpNoDelay = (Boolean)object;
                    }
                }
                catch (SocketException socketException) {
                    if (n == 3) break block6;
                    throw socketException;
                }
            }
            if (n == 3) {
                this.trafficClass = (Integer)object;
            }
        }
    }

    static boolean usingSocks() {
        String string = (String)AccessController.doPrivileged(new PriviAction("socksProxySet"));
        if (string != null) {
            return string.toLowerCase().equals("true");
        }
        return AccessController.doPrivileged(new PriviAction("socksProxyHost")) != null;
    }

    private int socksGetServerPort() {
        int n = -1;
        String string = (String)AccessController.doPrivileged(new PriviAction("socksProxyPort"));
        if (string != null) {
            n = Integer.parseInt(string);
        }
        if (n < 0) {
            n = 1080;
        }
        return n;
    }

    private InetAddress socksGetServerAddress() {
        String string = (String)AccessController.doPrivileged(new PriviAction("socksProxyHost"));
        InetAddress inetAddress = InetAddress.getHostByNameImpl(string, InetAddress.preferIPv6Addresses());
        return inetAddress;
    }

    private void socksConnect(InetAddress inetAddress, int n, int n2) {
        try {
            if (n2 == 0) {
                PlainSocketImpl2.connectStreamSocketImpl2(this.fd, this.socksGetServerPort(), this.trafficClass, this.socksGetServerAddress());
            } else {
                PlainSocketImpl2.connectStreamWithTimeoutSocketImpl2(this.fd, this.socksGetServerPort(), n2, this.trafficClass, this.socksGetServerAddress());
            }
        }
        catch (Exception exception) {
            throw new SocketException(Msg.getString("K003e", exception));
        }
        this.socksRequestConnection(inetAddress, n);
        lastConnectedAddress = inetAddress;
        lastConnectedPort = n;
    }

    private void socksRequestConnection(InetAddress inetAddress, int n) {
        this.socksSendRequest(1, inetAddress, n);
        Socks4Message socks4Message = this.socksReadReply();
        if (socks4Message.getCommandOrResult() != 90) {
            throw new IOException(socks4Message.getErrorString(socks4Message.getCommandOrResult()));
        }
    }

    void socksAccept() {
        Socks4Message socks4Message = this.socksReadReply();
        if (socks4Message.getCommandOrResult() != 90) {
            throw new IOException(socks4Message.getErrorString(socks4Message.getCommandOrResult()));
        }
    }

    private void socksBind() {
        try {
            PlainSocketImpl2.connectStreamSocketImpl2(this.fd, this.socksGetServerPort(), this.trafficClass, this.socksGetServerAddress());
        }
        catch (Exception exception) {
            throw new IOException(Msg.getString("K003f", exception));
        }
        if (lastConnectedAddress == null) {
            throw new SocketException(Msg.getString("K0040"));
        }
        this.socksSendRequest(2, lastConnectedAddress, lastConnectedPort);
        Socks4Message socks4Message = this.socksReadReply();
        if (socks4Message.getCommandOrResult() != 90) {
            throw new IOException(socks4Message.getErrorString(socks4Message.getCommandOrResult()));
        }
        if (socks4Message.getIP() == 0) {
            this.address = this.socksGetServerAddress();
        } else {
            byte[] byArray = new byte[4];
            InetAddress.intToBytes(socks4Message.getIP(), byArray, 0);
            this.address = new InetAddress(byArray);
        }
        this.localport = socks4Message.getPort();
    }

    private void socksSendRequest(int n, InetAddress inetAddress, int n2) {
        Socks4Message socks4Message = new Socks4Message();
        socks4Message.setCommandOrResult(n);
        socks4Message.setPort(n2);
        socks4Message.setIP(inetAddress.getAddress());
        socks4Message.setUserId("default");
        this.getOutputStream().write(socks4Message.getBytes(), 0, socks4Message.getLength());
    }

    private Socks4Message socksReadReply() {
        Socks4Message socks4Message = new Socks4Message();
        int n = 0;
        while (n < 8) {
            n += this.getInputStream().read(socks4Message.getBytes(), n, 8 - n);
        }
        return socks4Message;
    }

    @Override
    protected void connect(SocketAddress socketAddress, int n) {
        InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
        this.connect(inetSocketAddress.getAddress(), inetSocketAddress.getPort(), n);
    }

    @Override
    protected boolean supportsUrgentData() {
        return SocketImpl.supportsUrgentDataImpl(this.fd);
    }

    @Override
    protected void sendUrgentData(int n) {
        SocketImpl.sendUrgentDataImpl(this.fd, (byte)n);
    }
}

