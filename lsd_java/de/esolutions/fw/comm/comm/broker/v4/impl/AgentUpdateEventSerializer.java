/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class AgentUpdateEventSerializer {
    public static void putOptionalAgentUpdateEvent(ISerializer iSerializer, AgentUpdateEvent agentUpdateEvent) {
        boolean bl = agentUpdateEvent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = agentUpdateEvent.getAgent_id();
            iSerializer.putUInt16(n);
            int n2 = agentUpdateEvent.getAgent_epoch();
            iSerializer.putUInt16(n2);
        }
    }

    public static void putOptionalAgentUpdateEventVarArray(ISerializer iSerializer, AgentUpdateEvent[] agentUpdateEventArray) {
        boolean bl = agentUpdateEventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(agentUpdateEventArray.length);
            for (int i2 = 0; i2 < agentUpdateEventArray.length; ++i2) {
                AgentUpdateEventSerializer.putOptionalAgentUpdateEvent(iSerializer, agentUpdateEventArray[i2]);
            }
        }
    }

    public static AgentUpdateEvent getOptionalAgentUpdateEvent(IDeserializer iDeserializer) {
        AgentUpdateEvent agentUpdateEvent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            agentUpdateEvent = new AgentUpdateEvent();
            agentUpdateEvent.agent_id = n2 = iDeserializer.getUInt16();
            agentUpdateEvent.agent_epoch = n = iDeserializer.getUInt16();
        }
        return agentUpdateEvent;
    }

    public static AgentUpdateEvent[] getOptionalAgentUpdateEventVarArray(IDeserializer iDeserializer) {
        AgentUpdateEvent[] agentUpdateEventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            agentUpdateEventArray = new AgentUpdateEvent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                agentUpdateEventArray[i2] = AgentUpdateEventSerializer.getOptionalAgentUpdateEvent(iDeserializer);
            }
        }
        return agentUpdateEventArray;
    }
}

