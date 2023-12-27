/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpTransport
implements ITransport {
    private DatagramSocket socket = null;
    private InetAddress srcAddr;
    private InetAddress tgtAddr;
    private int srcPort;
    private int tgtPort;
    private int timeOut;
    private boolean isOpen;
    private ITransportDebug debug;

    public UdpTransport(InetAddress inetAddress, int n, InetAddress inetAddress2, int n2, int n3) {
        this.srcAddr = inetAddress;
        this.tgtAddr = inetAddress2;
        this.srcPort = n;
        this.tgtPort = n2;
        this.timeOut = n3;
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    @Override
    public IReadable recv() {
        int n = this.getReceiveBufferSize();
        TransportBuffer transportBuffer = new TransportBuffer(n);
        DatagramPacket datagramPacket = new DatagramPacket(transportBuffer.data(), transportBuffer.size());
        if (this.debug != null) {
            long l = System.currentTimeMillis();
            Long l2 = new Long(l);
            transportBuffer.setDebugTag(l2);
            this.debug.log(l, 266, n, l2);
        }
        this.socket.receive(datagramPacket);
        int n2 = datagramPacket.getLength();
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 274, n2, transportBuffer.getDebugTag());
        }
        if (n2 < n) {
            return transportBuffer.createSubBuffer(0, n2);
        }
        return transportBuffer;
    }

    @Override
    public void open() {
        if (!this.isOpen) {
            this.isOpen = true;
            this.socket = new DatagramSocket(this.srcPort, this.srcAddr);
            this.socket.setSoTimeout(this.timeOut);
        }
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public void close(boolean bl) {
        if (this.isOpen) {
            this.isOpen = false;
            this.socket.close();
            this.socket = null;
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public void send(IWriter iWriter) {
        int n = iWriter.size();
        TransportBuffer transportBuffer = new TransportBuffer(n);
        iWriter.write(transportBuffer);
        DatagramPacket datagramPacket = new DatagramPacket(transportBuffer.data(), n, this.tgtAddr, this.tgtPort);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 265, n, iWriter.getDebugTag());
        }
        this.socket.send(datagramPacket);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 273, n, iWriter.getDebugTag());
        }
    }

    @Override
    public void sendSync(IWriter iWriter) {
        this.send(iWriter);
    }

    @Override
    public int maxMsgSize() {
        try {
            return this.socket.getSendBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    public int getReceiveBufferSize() {
        try {
            return this.socket.getReceiveBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    @Override
    public boolean isReliable() {
        return false;
    }

    @Override
    public boolean detectsPeerReset() {
        return true;
    }

    @Override
    public boolean keepsRecordBoundaries() {
        return true;
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[UDP:src=").append(this.srcAddr).append(":").append(this.srcPort).append(",tgt=").append(this.tgtAddr).append(":").append(this.tgtPort).append("]").toString();
    }
}

