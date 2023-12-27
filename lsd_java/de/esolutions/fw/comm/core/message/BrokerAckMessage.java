/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.message.AbstractMessage;
import de.esolutions.fw.comm.core.message.InstanceIDTool;
import de.esolutions.fw.comm.core.message.MessageType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class BrokerAckMessage
extends AbstractMessage {
    protected short brokerAgentID;
    protected ServiceInstanceID brokerInstanceID;

    public BrokerAckMessage(ISerializer iSerializer, short s, ServiceInstanceID serviceInstanceID) {
        super(MessageType.BROKER_ACK, iSerializer);
        this.brokerAgentID = s;
        this.brokerInstanceID = serviceInstanceID;
    }

    public BrokerAckMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.BROKER_ACK, iDeserializer, bl);
    }

    @Override
    public void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.brokerAgentID);
        InstanceIDTool.serializeUUID(this.brokerInstanceID, iSerializer);
    }

    @Override
    public void deserializeElements(IDeserializer iDeserializer) {
        this.brokerAgentID = iDeserializer.getInt16();
        this.brokerInstanceID = InstanceIDTool.deserializeUUID(iDeserializer);
    }

    public short getBrokerAgentID() {
        return this.brokerAgentID;
    }

    public ServiceInstanceID getBrokerInstanceID() {
        return this.brokerInstanceID;
    }
}

