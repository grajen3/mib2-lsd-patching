/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.EndOfTransportException;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.SocketHelper;
import de.esolutions.fw.util.transport.socket.SocketOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public class TcpByteTransport
implements IByteTransport {
    private ISocket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private boolean connected;
    private InetAddress addr;
    private String addrString;
    private int port;
    private boolean listen;
    private SocketOptions options;
    private ITransportDebug debug;

    public TcpByteTransport(InetAddress inetAddress, int n) {
        this(inetAddress, n, false);
    }

    public TcpByteTransport(String string, int n) {
        this(string, n, false);
    }

    public TcpByteTransport(InetAddress inetAddress, int n, boolean bl) {
        this.addr = inetAddress;
        this.port = n;
        this.listen = bl;
        this.connected = false;
    }

    public TcpByteTransport(String string, int n, boolean bl) {
        this.addrString = string;
        this.port = n;
        this.listen = bl;
        this.connected = false;
    }

    public TcpByteTransport(ISocket iSocket) {
        this.addr = iSocket.getSocket().getInetAddress();
        this.port = iSocket.getSocket().getPort();
        this.listen = false;
        this.socket = iSocket;
        this.connected = false;
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public void setOptions(SocketOptions socketOptions) {
        this.options = socketOptions;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void open() {
        if (this.socket == null) {
            if (this.addr == null) {
                this.addr = InetAddress.getByName(this.addrString);
            }
            SocketHelper socketHelper = new SocketHelper(this.options);
            if (this.listen) {
                IServerSocket iServerSocket = socketHelper.createServerSocket(this.addr, this.port);
                try {
                    this.socket = socketHelper.accept(iServerSocket);
                }
                finally {
                    iServerSocket.close();
                }
            } else {
                this.socket = socketHelper.createSocket(this.addr, this.port);
            }
        }
        this.inputStream = this.socket.getInputStream();
        this.outputStream = this.socket.getOutputStream();
        this.connected = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void close(boolean bl) {
        block6: {
            if (this.connected) {
                try {
                    if (!this.socket.isPlainSocket()) {
                        this.socket.close();
                        break block6;
                    }
                    this.socket.getSocket().shutdownOutput();
                    if (!bl) break block6;
                    ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
                    long l = iTimeSource.getCurrentTime();
                    while (this.inputStream.read() != -1) {
                        long l2 = iTimeSource.getCurrentTime();
                        long l3 = l2 - l;
                        if (l3 <= 0) continue;
                        break;
                    }
                }
                finally {
                    this.socket = null;
                    this.connected = false;
                    this.inputStream = null;
                    this.outputStream = null;
                }
            }
        }
    }

    @Override
    public int recv(byte[] byArray, Object object) {
        int n = 0;
        if (this.debug != null) {
            try {
                this.debug.log(System.currentTimeMillis(), 266, byArray.length, object);
                n = this.inputStream.read(byArray);
                this.debug.log(System.currentTimeMillis(), 274, n, object);
            }
            catch (SocketTimeoutException socketTimeoutException) {
                n = 0;
                this.debug.log(System.currentTimeMillis(), 274, n, object);
            }
            catch (IOException iOException) {
                this.debug.log(System.currentTimeMillis(), 290, 1, object);
                throw iOException;
            }
        } else {
            try {
                n = this.inputStream.read(byArray);
            }
            catch (SocketTimeoutException socketTimeoutException) {
                n = 0;
            }
        }
        if (n == -1) {
            throw new EndOfTransportException("EOT");
        }
        return n;
    }

    @Override
    public void send(byte[] byArray, int n, Object object) {
        if (this.connected) {
            if (this.debug != null) {
                try {
                    this.debug.log(System.currentTimeMillis(), 265, n, object);
                    this.outputStream.write(byArray, 0, n);
                    this.debug.log(System.currentTimeMillis(), 273, n, object);
                }
                catch (IOException iOException) {
                    this.debug.log(System.currentTimeMillis(), 289, 1, object);
                    throw iOException;
                }
            } else {
                this.outputStream.write(byArray, 0, n);
            }
        }
    }

    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public int getSendBufferSize() {
        try {
            return this.socket.getSocket().getSendBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    @Override
    public int getReceiveBufferSize() {
        try {
            return this.socket.getSocket().getReceiveBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    @Override
    public boolean isReliable() {
        return true;
    }

    @Override
    public boolean detectsPeerReset() {
        return true;
    }

    @Override
    public String getDescription() {
        if (this.options != null) {
            return new StringBuffer().append("[TCP:add=").append(this.addr).append(":").append(this.port).append(",listen=").append(this.listen).append(",options=").append(this.options).append("]").toString();
        }
        return new StringBuffer().append("[TCP:add=").append(this.addr).append(":").append(this.port).append(",listen=").append(this.listen).append("]").toString();
    }
}

