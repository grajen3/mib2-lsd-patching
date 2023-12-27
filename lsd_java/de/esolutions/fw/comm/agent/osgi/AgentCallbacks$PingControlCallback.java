/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.tracing.ITraceCallback;

class AgentCallbacks$PingControlCallback
implements ITraceCallback {
    private AgentCallbacks$PingControlCallback() {
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        try {
            String string = new String(byArray, "UTF-8");
            Agent agent = Agent.getAgent();
            if (agent != null) {
                AgentCallbacks.access$000().log((short)2, "Ping control command=%1", new Short(string));
                agent.pingControl(string);
            }
        }
        catch (Exception exception) {
            AgentCallbacks.access$000().log((short)4, new StringBuffer().append("Invalid Ping control call! Reason: %1 ").append(exception).toString());
        }
    }

    /* synthetic */ AgentCallbacks$PingControlCallback(AgentCallbacks$1 agentCallbacks$1) {
        this();
    }
}

