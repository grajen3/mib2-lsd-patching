/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.commons.PriorityParser;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class CommConfigPriorities
implements IConfigValueTracer {
    private int agentThreadPrio = 5;
    private int notifierThreadPrio = 5;
    private int defaultSvcWorkerPrio = 5;

    public CommConfigPriorities(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.agentThreadPrio = PriorityParser.parse(configPathQuery, "agent", this.agentThreadPrio, false);
            this.notifierThreadPrio = PriorityParser.parse(configPathQuery, "notifier", this.notifierThreadPrio, false);
            this.defaultSvcWorkerPrio = PriorityParser.parse(configPathQuery, "default_svc", this.defaultSvcWorkerPrio, false);
        }
    }

    public int getAgentThreadPrio() {
        return this.agentThreadPrio;
    }

    public int getNotifierThreadPrio() {
        return this.notifierThreadPrio;
    }

    public int getDefaultSvcWorkerPrio() {
        return this.defaultSvcWorkerPrio;
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "priorities.agent           = %1", new Integer(this.agentThreadPrio));
        CommAgentTracing.CONFIG.log((short)2, "priorities.notifier        = %1", new Integer(this.notifierThreadPrio));
        CommAgentTracing.CONFIG.log((short)2, "priorities.default_svc     = %1", new Integer(this.defaultSvcWorkerPrio));
    }
}

