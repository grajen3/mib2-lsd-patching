/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag.info;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public class WorkerInfo
extends AbstractInfoBase {
    public final int commandQueueSize;
    public final int totalCommandCount;

    public WorkerInfo(AgentWorker agentWorker) {
        super(0);
        this.commandQueueSize = agentWorker.getCommandQueueSize();
        this.totalCommandCount = agentWorker.getTotalCommandCount();
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return null;
    }
}

