/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.tracing.ITraceCallback;

class AgentCallbacks$FloaterFlushCommand
implements ITraceCallback {
    private final /* synthetic */ AgentCallbacks this$0;

    private AgentCallbacks$FloaterFlushCommand(AgentCallbacks agentCallbacks) {
        this.this$0 = agentCallbacks;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        AgentCallbacks.access$200(this.this$0).flush();
    }

    /* synthetic */ AgentCallbacks$FloaterFlushCommand(AgentCallbacks agentCallbacks, AgentCallbacks$1 agentCallbacks$1) {
        this(agentCallbacks);
    }
}

