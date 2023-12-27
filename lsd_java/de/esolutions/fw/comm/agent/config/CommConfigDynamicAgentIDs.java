/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

public class CommConfigDynamicAgentIDs
implements IConfigValueTracer {
    private boolean enabled = false;
    private int range_begin = 31000;
    private int range_end = 32000;
    private int reuse_timeout = 3000;

    public CommConfigDynamicAgentIDs(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.enabled = configPathQuery.getBooleanValue("enabled", this.enabled);
            this.range_begin = configPathQuery.getIntegerValue("range.0", this.range_begin);
            this.range_end = configPathQuery.getIntegerValue("range.1", this.range_end);
            this.reuse_timeout = configPathQuery.getIntegerValue("reuse_timeout", this.reuse_timeout);
        }
    }

    @Override
    public void traceValues() {
        CommAgentTracing.CONFIG.log((short)2, "dyn_agent_ids.enabled        = %1", new Boolean(this.enabled));
        CommAgentTracing.CONFIG.log((short)2, "dyn_agent_ids.range          = [%1,%2]", new Integer(this.range_begin), (Object)new Integer(this.range_end));
        CommAgentTracing.CONFIG.log((short)2, "dyn_agent_ids.reuse_timeout  = %1", new Integer(this.reuse_timeout));
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public int getRangeBegin() {
        return this.range_begin;
    }

    public int getRangeEnd() {
        return this.range_end;
    }

    public int getReuseTimeout() {
        return this.reuse_timeout;
    }

    public boolean isDynamicAgentID(short s) {
        boolean bl = false;
        if (this.isEnabled()) {
            int n = this.getRangeBegin();
            int n2 = this.getRangeEnd();
            if (s >= n && s <= n2) {
                bl = true;
            }
        }
        return bl;
    }
}

