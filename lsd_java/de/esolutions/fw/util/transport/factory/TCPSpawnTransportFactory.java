/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.SocketHelper;
import de.esolutions.fw.util.transport.socket.SocketOptions;
import de.esolutions.fw.util.transport.socket.TcpByteTransport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TCPSpawnTransportFactory
extends BaseTransportFactory
implements ISpawnTransportFactory,
Runnable {
    protected String addrString;
    protected InetAddress addr;
    protected final int port;
    protected Thread thread;
    protected boolean stopNow;
    protected ISpawnedTransportListener listener;
    protected boolean isEnabled;
    protected SocketOptions options;
    protected int reconnectDelay = 500;
    protected IServerSocket serverSocketGlobal;

    public TCPSpawnTransportFactory(InetAddress inetAddress, int n) {
        this.addr = inetAddress;
        this.port = n;
    }

    public TCPSpawnTransportFactory(String string, int n) {
        this.addrString = string;
        this.port = n;
    }

    public void setOptions(SocketOptions socketOptions) {
        this.options = socketOptions;
    }

    @Override
    public void enableSpawning() {
        if (this.isEnabled) {
            return;
        }
        this.thread = new Thread(this, "TCPSpawnTransport");
        this.thread.start();
        this.isEnabled = true;
    }

    @Override
    public void disableSpawning() {
        if (!this.isEnabled) {
            return;
        }
        this.stopNow = true;
        try {
            if (this.serverSocketGlobal != null) {
                this.serverSocketGlobal.close();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        try {
            this.thread.interrupt();
            this.thread.join();
            this.thread = null;
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    @Override
    public void setListener(ISpawnedTransportListener iSpawnedTransportListener) {
        this.listener = iSpawnedTransportListener;
    }

    @Override
    public void run() {
        while (!this.stopNow) {
            Object object;
            IServerSocket iServerSocket = null;
            SocketHelper socketHelper = null;
            while (!this.stopNow) {
                boolean bl;
                object = null;
                if (socketHelper == null) {
                    try {
                        socketHelper = new SocketHelper(this.options);
                    }
                    catch (IOException iOException) {
                        object = iOException;
                        socketHelper = null;
                    }
                }
                if (this.addr == null) {
                    try {
                        this.addr = InetAddress.getByName(this.addrString);
                    }
                    catch (UnknownHostException unknownHostException) {
                        object = unknownHostException;
                    }
                }
                if (this.addr != null && socketHelper != null) {
                    try {
                        iServerSocket = socketHelper.createServerSocket(this.addr, this.port);
                    }
                    catch (IOException iOException) {
                        object = iOException;
                        iServerSocket = null;
                    }
                }
                if (iServerSocket != null) break;
                if (object != null && this.listener != null && !(bl = this.listener.spawningRetry(this, (IOException)object, this.reconnectDelay))) {
                    this.stopNow = true;
                    break;
                }
                try {
                    Thread.sleep(this.reconnectDelay);
                }
                catch (InterruptedException interruptedException) {
                    break;
                }
            }
            if (iServerSocket == null) break;
            if (this.listener != null) {
                this.listener.spawningEnabled(this);
            }
            this.serverSocketGlobal = iServerSocket;
            while (!this.stopNow) {
                try {
                    object = socketHelper.accept(iServerSocket);
                    TcpByteTransport tcpByteTransport = new TcpByteTransport((ISocket)object);
                    ITransport iTransport = new PacketTransport(tcpByteTransport);
                    iTransport = this.enrichTransport(iTransport);
                    if (this.listener != null) {
                        this.listener.spawnedTransport(iTransport);
                        continue;
                    }
                    System.out.println("TCPSpawnTransportFactory: spawned transport but no listener!");
                }
                catch (IOException iOException) {
                    // empty catch block
                    break;
                }
            }
            this.serverSocketGlobal = null;
            if (this.listener != null) {
                this.listener.spawningDisabled(this);
            }
            if (iServerSocket == null) continue;
            try {
                iServerSocket.close();
            }
            catch (IOException iOException) {}
        }
        this.isEnabled = false;
    }

    @Override
    public String getDescription() {
        String string = this.addrString != null ? this.addrString : (this.addr != null ? this.addr.toString() : "n/a");
        if (this.options == null) {
            return new StringBuffer().append("[TCP:listen=").append(string).append(":").append(this.port).append("]").toString();
        }
        return new StringBuffer().append("[TCP:listen=").append(string).append(":").append(this.port).append(",opts=").append(this.options).append("]").toString();
    }
}

