/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentProxy;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentUpdateEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class AgentProxy$2
implements ISerializable {
    private final /* synthetic */ AgentUpdateEvent[] val$events;
    private final /* synthetic */ AgentProxy this$0;

    AgentProxy$2(AgentProxy agentProxy, AgentUpdateEvent[] agentUpdateEventArray) {
        this.this$0 = agentProxy;
        this.val$events = agentUpdateEventArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AgentUpdateEventSerializer.putOptionalAgentUpdateEventVarArray(iSerializer, this.val$events);
    }
}

