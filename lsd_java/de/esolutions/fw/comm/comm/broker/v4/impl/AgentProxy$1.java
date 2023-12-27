/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentProxy;
import de.esolutions.fw.comm.comm.broker.v4.impl.UpdateEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class AgentProxy$1
implements ISerializable {
    private final /* synthetic */ UpdateEvent[] val$events;
    private final /* synthetic */ AgentProxy this$0;

    AgentProxy$1(AgentProxy agentProxy, UpdateEvent[] updateEventArray) {
        this.this$0 = agentProxy;
        this.val$events = updateEventArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        UpdateEventSerializer.putOptionalUpdateEventVarArray(iSerializer, this.val$events);
    }
}

