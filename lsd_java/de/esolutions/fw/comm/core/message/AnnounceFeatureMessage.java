/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AnnounceFeatureMessage
extends AbstractMessage {
    private short agentID;
    private byte feature;

    public AnnounceFeatureMessage(ISerializer iSerializer, short s, byte by) {
        super(MessageType.ANNOUNCE_FEATURE, iSerializer);
        this.agentID = s;
        this.feature = by;
    }

    public AnnounceFeatureMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.ANNOUNCE_FEATURE, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.agentID);
        iSerializer.putInt8(this.feature);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.agentID = iDeserializer.getInt16();
        this.feature = iDeserializer.getInt8();
    }

    public short getAgentID() {
        return this.agentID;
    }

    public byte getFeature() {
        return this.feature;
    }
}

