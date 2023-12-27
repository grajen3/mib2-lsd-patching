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

public class CreateRRStubMessage
extends AbstractMessage {
    private short agentID;
    private short proxyID;
    private short stubID;
    private ServiceInstanceID instanceID;
    private ServiceInstanceID replyInstanceID;

    public CreateRRStubMessage(IDeserializer iDeserializer, boolean bl) {
        super(MessageType.CREATE_RRSTUB, iDeserializer, bl);
    }

    public CreateRRStubMessage(ISerializer iSerializer, short s, short s2, short s3, ServiceInstanceID serviceInstanceID, ServiceInstanceID serviceInstanceID2) {
        super(MessageType.CREATE_RRSTUB, iSerializer);
        this.agentID = s;
        this.stubID = s3;
        this.proxyID = s2;
        this.instanceID = serviceInstanceID;
        this.replyInstanceID = serviceInstanceID2;
    }

    @Override
    protected void serializeElements(ISerializer iSerializer) {
        iSerializer.putInt16(this.agentID);
        iSerializer.putInt16(this.proxyID);
        InstanceIDTool.serializeUUID(this.instanceID, iSerializer);
        InstanceIDTool.serializeUUID(this.replyInstanceID, iSerializer);
        iSerializer.putInt16(this.stubID);
    }

    @Override
    protected void deserializeElements(IDeserializer iDeserializer) {
        this.agentID = iDeserializer.getInt16();
        this.proxyID = iDeserializer.getInt16();
        this.instanceID = InstanceIDTool.deserializeUUID(iDeserializer);
        this.replyInstanceID = InstanceIDTool.deserializeUUID(iDeserializer);
        this.stubID = iDeserializer.getInt16();
    }

    public short getAgentID() {
        return this.agentID;
    }

    public void setAgentID(short s) {
        this.agentID = s;
    }

    public short getProxyID() {
        return this.proxyID;
    }

    public void setProxyID(short s) {
        this.proxyID = s;
    }

    public short getStubID() {
        return this.stubID;
    }

    public void setStubID(short s) {
        this.stubID = s;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public void setInstanceID(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
    }

    public ServiceInstanceID getReplyInstanceID() {
        return this.replyInstanceID;
    }

    public void setReplyInstanceID(ServiceInstanceID serviceInstanceID) {
        this.replyInstanceID = serviceInstanceID;
    }
}

