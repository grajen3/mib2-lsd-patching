/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.aggregate;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.aggregate.AggregateDecoder;
import de.esolutions.fw.util.transport.aggregate.AggregateEncoder;
import de.esolutions.fw.util.transport.debug.ITransportDebug;

public class AggregateTransport
implements ITransport {
    protected ITransport transport;
    protected AggregateDecoder decoder;
    protected AggregateEncoder encoder;
    protected int maxPacketSize;
    protected boolean isOpen;

    public AggregateTransport(ITransport iTransport) {
        this.transport = iTransport;
        this.encoder = new AggregateEncoder(iTransport);
        this.decoder = new AggregateDecoder(iTransport);
        this.maxPacketSize = 0;
    }

    public AggregateTransport(ITransport iTransport, int n) {
        this.transport = iTransport;
        this.encoder = new AggregateEncoder(iTransport);
        this.decoder = new AggregateDecoder(iTransport);
        this.maxPacketSize = n;
    }

    @Override
    public void flush() {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.flushPacket();
    }

    @Override
    public void send(IWriter iWriter) {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.putMessage(iWriter);
    }

    @Override
    public void sendSync(IWriter iWriter) {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.putMessageCopy(iWriter);
    }

    @Override
    public IReadable recv() {
        if (this.decoder == null) {
            throw new RuntimeException("No Receiver in Transport!");
        }
        return this.decoder.getMessage();
    }

    @Override
    public void open() {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;
        this.transport.open();
        if (this.encoder != null) {
            this.encoder.init(this.maxPacketSize);
        }
    }

    @Override
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override
    public void close(boolean bl) {
        if (!this.isOpen) {
            return;
        }
        this.isOpen = false;
        this.transport.close(bl);
    }

    @Override
    public int maxMsgSize() {
        if (this.encoder != null) {
            return this.encoder.getMaxMessageSize();
        }
        return 0;
    }

    @Override
    public boolean isReliable() {
        return this.transport.isReliable();
    }

    @Override
    public boolean detectsPeerReset() {
        return this.transport.detectsPeerReset();
    }

    @Override
    public boolean keepsRecordBoundaries() {
        return this.transport.keepsRecordBoundaries();
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[Aggregate:").append(this.transport.getDescription()).append("]").toString();
    }

    @Override
    public void setDebug(ITransportDebug iTransportDebug) {
    }
}

