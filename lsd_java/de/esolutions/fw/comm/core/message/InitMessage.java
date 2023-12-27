/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class InitMessage
extends AbstractMessage {
    private short agentID;
    private byte protocolRevision;

    public InitMessage(ISerializer iSerializer, short s, byte by) {
        super(MessageType.INIT, iSerializer);
        this.agentID = s;
        this.protocolRevision = by;
    }

    public InitMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.INIT, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt8(this.protocolRevision);
        iSerializer.putInt16(this.agentID);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.protocolRevision = iDeserializer.getInt8();
        this.agentID = iDeserializer.getInt16();
    }

    public short getAgentID() {
        return this.agentID;
    }

    public byte getProtocolRevision() {
        return this.protocolRevision;
    }
}

