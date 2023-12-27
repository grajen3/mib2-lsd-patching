/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.tracing.protocol.message.MessageType;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;

public abstract class AbstractMessage {
    private final MessageType type;
    private int size;

    public AbstractMessage(MessageType messageType) {
        this.type = messageType;
    }

    public final MessageType getMessageType() {
        return this.type;
    }

    public final void serialize(ISerializer iSerializer) {
        iSerializer.putInt8(this.type.toByte());
        this.serializeElements(iSerializer);
        IWriteable iWriteable = iSerializer.getAttachedBuffer();
        if (iWriteable != null) {
            this.size = iWriteable.size();
        }
    }

    public final void deserialize(IDeserializer iDeserializer) {
        this.deserializeElements(iDeserializer);
        IReadable iReadable = iDeserializer.getAttachedBuffer();
        if (iReadable != null) {
            this.size = iReadable.size();
        }
    }

    protected abstract void serializeElements(ISerializer iSerializer) {
    }

    protected abstract void deserializeElements(IDeserializer iDeserializer) {
    }

    public abstract void toStringBuffer(Buffer buffer) {
    }

    public String toString() {
        Buffer buffer = new Buffer();
        this.toStringBuffer(buffer);
        return buffer.toString();
    }

    public MessageType getProtocolMessageType() {
        return this.type;
    }

    public int getProtocolMessageSize() {
        return this.size;
    }

    public byte[] getRawDataPortion() {
        return null;
    }

    public long getTimeStamp() {
        return -1L;
    }

    public long getExternalTimeStamp() {
        return -1L;
    }

    public short getLevel() {
        return -1;
    }
}

