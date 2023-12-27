/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Agent;
import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentProxy$1;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentProxy$2;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class AgentProxy
implements Agent {
    private static final CallContext context = CallContext.getContext("PROXY.comm.broker.Agent");
    private Proxy proxy;

    public AgentProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("78a07e56-255a-4309-8bde-b1e1c73bc71c", n, "299585a3-5e89-5854-a716-dafd54af2e50", "comm.broker.Agent");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void serviceUpdate(UpdateEvent[] updateEventArray) {
        AgentProxy$1 agentProxy$1 = new AgentProxy$1(this, updateEventArray);
        this.proxy.remoteCallMethod((short)2, agentProxy$1);
    }

    @Override
    public void agentUpdate(AgentUpdateEvent[] agentUpdateEventArray) {
        AgentProxy$2 agentProxy$2 = new AgentProxy$2(this, agentUpdateEventArray);
        this.proxy.remoteCallMethod((short)0, agentProxy$2);
    }
}

