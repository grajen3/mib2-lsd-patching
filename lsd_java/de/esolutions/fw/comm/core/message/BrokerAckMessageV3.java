/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.BrokerAckMessage;
import de.esolutions.fw.comm.core.message.InstanceIDTool;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BrokerAckMessageV3
extends BrokerAckMessage {
    public BrokerAckMessageV3(ISerializer iSerializer, short s, ServiceInstanceID serviceInstanceID) {
        super(iSerializer, s, serviceInstanceID);
    }

    public BrokerAckMessageV3(IDeserializer iDeserializer, boolean bl) {
        super(iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.brokerAgentID);
        InstanceIDTool.serializeUUIDandIK(this.brokerInstanceID, iSerializer);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.brokerAgentID = iDeserializer.getInt16();
        this.brokerInstanceID = InstanceIDTool.deserializeUUIDandIK(iDeserializer);
    }
}

