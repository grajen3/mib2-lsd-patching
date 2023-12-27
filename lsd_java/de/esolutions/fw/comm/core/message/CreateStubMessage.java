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

public class CreateStubMessage
extends AbstractMessage {
    private short agentID;
    private short proxyID;
    private ServiceInstanceID instanceID;

    public CreateStubMessage(ISerializer iSerializer, short s, short s2, ServiceInstanceID serviceInstanceID) {
        super(MessageType.CREATE_STUB, iSerializer);
        this.agentID = s;
        this.proxyID = s2;
        this.instanceID = serviceInstanceID;
    }

    public CreateStubMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.CREATE_STUB, iDeserializer, bl);
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.agentID);
        iSerializer.putInt16(this.proxyID);
        InstanceIDTool.serializeUUID(this.instanceID, iSerializer);
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        this.agentID = iDeserializer.getInt16();
        this.proxyID = iDeserializer.getInt16();
        this.instanceID = InstanceIDTool.deserializeUUID(iDeserializer);
    }

    public short getAgentID() {
        return this.agentID;
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }
}

