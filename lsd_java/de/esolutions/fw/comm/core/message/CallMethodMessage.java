/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.transport.IWriteable;

public class CallMethodMessage
extends AbstractMessage {
    private short stubID;
    private short methodID;
    private IDeserializer deserializer;
    private ISerializable payload;
    private ICallMethodSerializeCallback serCallback;

    public CallMethodMessage(ISerializer iSerializer, short s, short s2, ISerializable iSerializable) {
        super(MessageType.CALL_METHOD, iSerializer);
        this.stubID = s;
        this.methodID = s2;
        this.payload = iSerializable;
    }

    public CallMethodMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.CALL_METHOD, iDeserializer, bl);
    }

    public void setSerializeCallback(ICallMethodSerializeCallback iCallMethodSerializeCallback) {
        this.serCallback = iCallMethodSerializeCallback;
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.stubID);
        iSerializer.putInt16(this.methodID);
        IWriteable iWriteable = iSerializer.getAttachedBuffer();
        boolean bl = false;
        if (iWriteable != null && this.serCallback != null) {
            this.serCallback.beginSerializeCallMethodPayload(this.stubID, this.methodID, iSerializer);
            bl = true;
        }
        if (this.payload != null) {
            this.payload.serialize(iSerializer);
        }
        if (bl) {
            this.serCallback.endSerializeCallMethodPayload(this.stubID, this.methodID, iSerializer);
        }
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.stubID = iDeserializer.getInt16();
        this.methodID = iDeserializer.getInt16();
        this.deserializer = iDeserializer;
    }

    public short getStubID() {
        return this.stubID;
    }

    public short getMethodID() {
        return this.methodID;
    }

    public IDeserializer getDeserializer() {
        return this.deserializer;
    }

    @Override
    public void dump(Buffer buffer) {
        buffer.append("CallMethod: stub #");
        buffer.append(this.stubID);
        buffer.append(" method #");
        buffer.append(this.methodID);
    }
}

