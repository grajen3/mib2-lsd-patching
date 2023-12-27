/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Agent;
import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentUpdateEventSerializer;
import de.esolutions.fw.comm.comm.broker.v4.impl.UpdateEventSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AgentService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.comm.broker.Agent");
    private Agent p_Agent;

    public AgentService(int n, Agent agent) {
        super(new ServiceInstanceID("78a07e56-255a-4309-8bde-b1e1c73bc71c", n, "299585a3-5e89-5854-a716-dafd54af2e50", "comm.broker.Agent"));
        this.p_Agent = agent;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 2: {
                    UpdateEvent[] updateEventArray = UpdateEventSerializer.getOptionalUpdateEventVarArray(iDeserializer);
                    this.p_Agent.serviceUpdate(updateEventArray);
                    break;
                }
                case 0: {
                    AgentUpdateEvent[] agentUpdateEventArray = AgentUpdateEventSerializer.getOptionalAgentUpdateEventVarArray(iDeserializer);
                    this.p_Agent.agentUpdate(agentUpdateEventArray);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

