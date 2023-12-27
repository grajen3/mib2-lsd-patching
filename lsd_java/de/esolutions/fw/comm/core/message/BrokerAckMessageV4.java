/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.BrokerAckMessageV3;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BrokerAckMessageV4
extends BrokerAckMessageV3 {
    private short assignedAgentID;
    private short assignedAgentEpoch;

    public BrokerAckMessageV4(ISerializer iSerializer, short s, ServiceInstanceID serviceInstanceID, short s2, short s3) {
        super(iSerializer, s, serviceInstanceID);
        this.assignedAgentID = s2;
        this.assignedAgentEpoch = s3;
    }

    public BrokerAckMessageV4(IDeserializer iDeserializer, boolean bl) {
        super(iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        super.serializeElements(iSerializer);
        iSerializer.putInt16(this.assignedAgentID);
        iSerializer.putInt16(this.assignedAgentEpoch);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        super.deserializeElements(iDeserializer);
        this.assignedAgentID = iDeserializer.getInt16();
        this.assignedAgentEpoch = iDeserializer.getInt16();
    }

    public short getAssignedAgentID() {
        return this.assignedAgentID;
    }

    public short getAssignedAgentEpoch() {
        return this.assignedAgentEpoch;
    }
}

