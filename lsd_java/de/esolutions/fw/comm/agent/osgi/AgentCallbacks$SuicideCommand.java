/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.commons.os.Slayer;
import de.esolutions.fw.util.tracing.ITraceCallback;

class AgentCallbacks$SuicideCommand
implements ITraceCallback {
    private final /* synthetic */ AgentCallbacks this$0;

    private AgentCallbacks$SuicideCommand(AgentCallbacks agentCallbacks) {
        this.this$0 = agentCallbacks;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        Slayer slayer = new Slayer();
        slayer.suicide();
    }

    /* synthetic */ AgentCallbacks$SuicideCommand(AgentCallbacks agentCallbacks, AgentCallbacks$1 agentCallbacks$1) {
        this(agentCallbacks);
    }
}

