/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.SocketOptions;
import de.esolutions.fw.util.transport.socket.TcpByteTransport;
import java.net.InetAddress;

public class TCPSingleTransportFactory
extends BaseTransportFactory
implements ISingleTransportFactory {
    protected InetAddress addr;
    protected String addrString;
    protected int port;
    protected boolean server;
    protected SocketOptions opts;

    public TCPSingleTransportFactory(InetAddress inetAddress, int n) {
        this(inetAddress, n, false);
    }

    public TCPSingleTransportFactory(String string, int n) {
        this(string, n, false);
    }

    public TCPSingleTransportFactory(InetAddress inetAddress, int n, boolean bl) {
        this.port = n;
        this.addr = inetAddress;
        this.server = bl;
    }

    public TCPSingleTransportFactory(String string, int n, boolean bl) {
        this.port = n;
        this.addrString = string;
        this.server = bl;
    }

    public void setOptions(SocketOptions socketOptions) {
        this.opts = socketOptions;
    }

    @Override
    public ITransport createTransport() {
        SocketOptions socketOptions = this.opts;
        if (socketOptions == null) {
            socketOptions = new SocketOptions();
            socketOptions.timeOut = 2000;
        }
        TcpByteTransport tcpByteTransport = this.addrString != null ? new TcpByteTransport(this.addrString, this.port, this.server) : new TcpByteTransport(this.addr, this.port, this.server);
        tcpByteTransport.setOptions(socketOptions);
        ITransport iTransport = new PacketTransport(tcpByteTransport);
        iTransport = this.enrichTransport(iTransport);
        return iTransport;
    }

    @Override
    public String getDescription() {
        String string = this.addr != null ? this.addr.toString() : this.addrString;
        if (this.opts == null) {
            return new StringBuffer().append("[TCP:").append(string).append(":").append(this.port).append(",server=").append(this.server).append("]").toString();
        }
        return new StringBuffer().append("[TCP:").append(string).append(":").append(this.port).append(",server=").append(this.server).append(",opts=").append(this.opts).append("]").toString();
    }
}

