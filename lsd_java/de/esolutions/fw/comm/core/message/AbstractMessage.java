/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.CommDebugTag;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriteable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.exception.TransportException;

public abstract class AbstractMessage
implements IWriter {
    private Object debugTag;
    private MessageType type;
    private ISerializer serializer;
    protected IReadable payload;

    public AbstractMessage(MessageType messageType, ISerializer iSerializer) {
        this.type = messageType;
        this.serializer = iSerializer;
    }

    public AbstractMessage(MessageType messageType, IDeserializer iDeserializer, boolean bl) {
        if (!bl) {
            this.type = messageType;
        }
        this.deserialize(iDeserializer, bl);
    }

    public MessageType getMessageType() {
        return this.type;
    }

    protected ISerializer getSerializer() {
        return this.serializer;
    }

    @Override
    public int size() {
        try {
            this.serializer.beginSizeCalc();
            this.serialize(this.serializer);
            return this.serializer.endSizeCalc();
        }
        catch (SerializerException serializerException) {
            return 0;
        }
    }

    @Override
    public void write(IWriteable iWriteable) {
        try {
            this.serializer.attachBuffer(iWriteable);
            this.serialize(this.serializer);
            this.serializer.detachBuffer();
        }
        catch (SerializerException serializerException) {
            throw new TransportException(new StringBuffer().append("Serializer failed with: ").append(serializerException).toString());
        }
    }

    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt8(this.type.toByte());
        this.serializeElements(iSerializer);
    }

    public void deserialize(IDeserializer iDeserializer, boolean bl) {
        if (bl) {
            byte by = iDeserializer.getInt8();
            this.type = MessageType.getType(by);
        }
        this.deserializeElements(iDeserializer);
    }

    protected abstract void serializeElements(ISerializer iSerializer) {
    }

    protected abstract void deserializeElements(IDeserializer iDeserializer) {
    }

    public void setPayload(IReadable iReadable) {
        this.payload = iReadable;
    }

    public IReadable getPayload() {
        return this.payload;
    }

    @Override
    public void setDebugTag(Object object) {
        this.debugTag = object;
    }

    @Override
    public Object getDebugTag() {
        return this.debugTag;
    }

    public void createDebugTag(long l) {
        this.debugTag = new CommDebugTag(l, this);
    }

    public void dump(Buffer buffer) {
        buffer.append(super.getClass().getName());
    }

    public String toString() {
        Buffer buffer = new Buffer();
        this.dump(buffer);
        return buffer.toString();
    }
}

