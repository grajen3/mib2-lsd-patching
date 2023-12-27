/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;

public interface AgentS {
    default public void serviceUpdate(UpdateEvent[] updateEventArray) {
    }

    default public void agentUpdate(AgentUpdateEvent[] agentUpdateEventArray) {
    }
}

