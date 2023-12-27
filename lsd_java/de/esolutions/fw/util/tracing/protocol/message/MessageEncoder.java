/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.DefaultExtendedSerializer;
import de.esolutions.fw.util.serializer.stream.BEDefaultSerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessageWriter;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;

public class MessageEncoder {
    private ISerializer serializer;

    public MessageEncoder() {
        this.serializer = new DefaultExtendedSerializer(new BEDefaultSerializer());
    }

    public MessageEncoder(ISerializer iSerializer) {
        this.serializer = iSerializer;
    }

    public byte[] encodeBuffer(AbstractMessage abstractMessage) {
        this.serializer.beginSizeCalc();
        abstractMessage.serialize(this.serializer);
        int n = this.serializer.endSizeCalc();
        TransportBuffer transportBuffer = new TransportBuffer(n);
        this.serializer.attachBuffer(transportBuffer);
        abstractMessage.serialize(this.serializer);
        this.serializer.detachBuffer();
        return transportBuffer.getDirectData();
    }

    public IWriter encodeWriter(AbstractMessage abstractMessage) {
        return new AbstractMessageWriter(this.serializer, abstractMessage);
    }
}

