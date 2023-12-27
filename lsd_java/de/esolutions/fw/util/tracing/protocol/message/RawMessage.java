/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;

public class RawMessage
extends AbstractMessage {
    private byte[] data;

    public RawMessage(byte by) {
        super(new MessageType(by));
    }

    public RawMessage(byte by, byte[] byArray) {
        super(new MessageType(by));
        this.data = byArray;
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putRawBytes(this.data);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        int n = iDeserializer.bytesLeft();
        this.data = new byte[n];
        iDeserializer.getRawBytes(this.data);
    }

    public byte[] getData() {
        return this.data;
    }

    @Override
    public void toStringBuffer(Buffer buffer) {
        buffer.append("Raw: type=");
        buffer.append(this.getProtocolMessageType().toByte());
        buffer.append(" size=");
        buffer.append(this.data.length);
    }

    @Override
    public byte[] getRawDataPortion() {
        return this.data;
    }
}

