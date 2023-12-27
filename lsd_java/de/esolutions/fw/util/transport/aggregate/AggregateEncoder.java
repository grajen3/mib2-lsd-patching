/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.aggregate;

import de.esolutions.fw.util.transport.CopyWriter;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.aggregate.AggregatedWriters;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.exception.InvalidTransportFormatException;

public class AggregateEncoder {
    protected ITransport transport;
    protected int packetSize;
    protected int maxLeftForSend;
    protected AggregatedWriters aggregate;

    public AggregateEncoder(ITransport iTransport) {
        this.transport = iTransport;
    }

    public void init(int n) {
        this.packetSize = n;
        if (this.packetSize == 0) {
            this.packetSize = this.transport.maxMsgSize();
        }
        this.maxLeftForSend = this.packetSize / 4;
        this.aggregate = new AggregatedWriters(this.packetSize);
    }

    public int getMaxMessageSize() {
        return this.aggregate.maxSize();
    }

    protected void sendPacket() {
        if (this.aggregate.numEntries() == 0) {
            return;
        }
        this.transport.send(this.aggregate);
        this.aggregate = new AggregatedWriters(this.packetSize);
    }

    public void putMessage(IWriter iWriter) {
        int n = iWriter.size();
        if (n > this.aggregate.maxSize()) {
            throw new InvalidTransportFormatException("Message too large");
        }
        if (!this.aggregate.doesFit(iWriter)) {
            this.sendPacket();
        }
        this.aggregate.addWritable(iWriter);
        if (this.aggregate.sizeLeft() < this.maxLeftForSend) {
            this.sendPacket();
        }
    }

    public void putMessageCopy(IWriter iWriter) {
        TransportBuffer transportBuffer = new TransportBuffer(iWriter.size());
        iWriter.write(transportBuffer);
        this.putMessage(new CopyWriter(transportBuffer));
    }

    public int getNumPendingMessages() {
        return this.aggregate.numEntries();
    }

    public void flushPacket() {
        if (this.aggregate.numEntries() > 0) {
            this.sendPacket();
        }
    }
}

