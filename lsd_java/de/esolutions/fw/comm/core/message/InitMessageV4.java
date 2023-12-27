/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.InitMessage;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class InitMessageV4
extends InitMessage {
    private short agentEpoch;

    public InitMessageV4(ISerializer iSerializer, short s, byte by, short s2) {
        super(iSerializer, s, by);
        this.agentEpoch = s2;
    }

    public InitMessageV4(IDeserializer iDeserializer, boolean bl) {
        super(iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        super.serializeElements(iSerializer);
        iSerializer.putInt16(this.agentEpoch);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        super.deserializeElements(iDeserializer);
        this.agentEpoch = iDeserializer.getInt16();
    }

    public short getAgentEpoch() {
        return this.agentEpoch;
    }
}

