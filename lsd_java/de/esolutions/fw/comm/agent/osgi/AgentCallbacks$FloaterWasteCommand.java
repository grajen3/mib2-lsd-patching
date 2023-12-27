/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.tracing.ITraceCallback;

class AgentCallbacks$FloaterWasteCommand
implements ITraceCallback {
    private final /* synthetic */ AgentCallbacks this$0;

    private AgentCallbacks$FloaterWasteCommand(AgentCallbacks agentCallbacks) {
        this.this$0 = agentCallbacks;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        int n2 = 256;
        if (byArray != null) {
            try {
                String string = new String(byArray, "UTF-8");
                n2 = Integer.parseInt(string);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        AgentCallbacks.access$200(this.this$0).waste(n2);
    }

    /* synthetic */ AgentCallbacks$FloaterWasteCommand(AgentCallbacks agentCallbacks, AgentCallbacks$1 agentCallbacks$1) {
        this(agentCallbacks);
    }
}

