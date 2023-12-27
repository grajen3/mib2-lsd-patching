/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.aggregate;

import de.esolutions.fw.util.commons.miniser.BEMiniIntDeserializer;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.exception.InvalidTransportFormatException;

public class AggregateDecoder {
    protected ITransport transport;
    protected IReadable packet;
    protected int messagesLeft;
    protected int offset;

    public AggregateDecoder(ITransport iTransport) {
        this.transport = iTransport;
        this.packet = null;
        this.messagesLeft = 0;
        this.offset = 0;
    }

    public IReadable getMessage() {
        if (this.messagesLeft == 0) {
            this.getNextMessagePacket();
        }
        BEMiniIntDeserializer bEMiniIntDeserializer = new BEMiniIntDeserializer();
        int n = bEMiniIntDeserializer.retrieveInt(this.packet.getData(this.offset, 4));
        this.offset += 4;
        IReadable iReadable = this.packet.createSubBuffer(this.offset, n);
        this.offset += n;
        --this.messagesLeft;
        return iReadable;
    }

    protected void getNextMessagePacket() {
        this.packet = this.transport.recv();
        BEMiniIntDeserializer bEMiniIntDeserializer = new BEMiniIntDeserializer();
        this.messagesLeft = bEMiniIntDeserializer.retrieveInt(this.packet.getData(0, 4));
        if (this.messagesLeft == 0) {
            throw new InvalidTransportFormatException("No Message in packet");
        }
        this.offset = 4;
    }
}

