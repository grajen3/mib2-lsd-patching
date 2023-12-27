/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.osgi.AgentDumpInfoProvider;
import de.esolutions.fw.comm.agent.osgi.AgentDumpInfoProvider$1;

class AgentDumpInfoProvider$DumperRunnable
implements Runnable {
    private final /* synthetic */ AgentDumpInfoProvider this$0;

    private AgentDumpInfoProvider$DumperRunnable(AgentDumpInfoProvider agentDumpInfoProvider) {
        this.this$0 = agentDumpInfoProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        while (true) {
            Object object = AgentDumpInfoProvider.access$100(this.this$0);
            synchronized (object) {
                while (!AgentDumpInfoProvider.access$200(this.this$0)) {
                    try {
                        AgentDumpInfoProvider.access$100(this.this$0).wait();
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
            object = Agent.getAgent();
            if (object == null) {
                AgentDumpInfoProvider.access$300(this.this$0).println("FATAL: No Agent found!");
            } else {
                ((Agent)object).writeDiagnosisReport(AgentDumpInfoProvider.access$300(this.this$0));
            }
            Object object2 = AgentDumpInfoProvider.access$400(this.this$0);
            synchronized (object2) {
                AgentDumpInfoProvider.access$502(this.this$0, true);
                AgentDumpInfoProvider.access$202(this.this$0, false);
                AgentDumpInfoProvider.access$400(this.this$0).notifyAll();
            }
        }
    }

    /* synthetic */ AgentDumpInfoProvider$DumperRunnable(AgentDumpInfoProvider agentDumpInfoProvider, AgentDumpInfoProvider$1 agentDumpInfoProvider$1) {
        this(agentDumpInfoProvider);
    }
}

