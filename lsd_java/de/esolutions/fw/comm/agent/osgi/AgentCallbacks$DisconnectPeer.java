/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks;
import de.esolutions.fw.comm.agent.osgi.AgentCallbacks$1;
import de.esolutions.fw.util.tracing.ITraceCallback;

class AgentCallbacks$DisconnectPeer
implements ITraceCallback {
    private AgentCallbacks$DisconnectPeer() {
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        try {
            String string = new String(byArray, "UTF-8");
            short s = Short.parseShort(string);
            Agent agent = Agent.getAgent();
            if (agent != null) {
                AgentCallbacks.access$000().log((short)2, "Force disconnect to peer: %1", new Short(s));
                agent.forceDisconnect(s);
            }
        }
        catch (Exception exception) {
            AgentCallbacks.access$000().log((short)4, new StringBuffer().append("Invalid DisconnectPeer call! Reason: %1 ").append(exception).toString());
        }
    }

    /* synthetic */ AgentCallbacks$DisconnectPeer(AgentCallbacks$1 agentCallbacks$1) {
        this();
    }
}

