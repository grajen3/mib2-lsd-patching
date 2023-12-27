/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;

public interface Agent {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void serviceUpdate(UpdateEvent[] updateEventArray) {
    }

    default public void agentUpdate(AgentUpdateEvent[] agentUpdateEventArray) {
    }
}

