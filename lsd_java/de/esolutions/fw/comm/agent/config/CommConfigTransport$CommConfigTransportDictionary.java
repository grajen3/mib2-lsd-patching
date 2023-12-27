/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

import de.esolutions.fw.comm.agent.config.CommConfigTransport;
import de.esolutions.fw.comm.agent.config.CommConfigTransportParams;
import de.esolutions.fw.comm.agent.config.CommConfigTransportStatic;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.IConfigValueTracer;
import de.esolutions.fw.util.config.commons.PriorityParser;
import de.esolutions.fw.util.config.query.ConfigPathQuery;

class CommConfigTransport$CommConfigTransportDictionary
implements IConfigValueTracer {
    private CommConfigTransportParams defaultTransportConfig;
    private CommConfigTransportParams dynamicTransportConfig;
    private CommConfigTransportStatic staticTransportConfig;
    private String key;
    private final /* synthetic */ CommConfigTransport this$0;

    public CommConfigTransport$CommConfigTransportDictionary(CommConfigTransport commConfigTransport, ConfigValue configValue, String string) {
        this.this$0 = commConfigTransport;
        this.key = string;
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            this.defaultTransportConfig = this.parseCommConfigTransportParams(configPathQuery.getDictionary("default"));
            this.dynamicTransportConfig = this.parseCommConfigTransportParams(configPathQuery.getDictionary("dynamic"), this.defaultTransportConfig);
            this.staticTransportConfig = new CommConfigTransportStatic(configPathQuery.getArray("static"), this.defaultTransportConfig, new StringBuffer().append(this.key).append(".static").toString());
        } else {
            this.defaultTransportConfig = new CommConfigTransportParams();
            this.dynamicTransportConfig = new CommConfigTransportParams();
            this.staticTransportConfig = new CommConfigTransportStatic(null, this.defaultTransportConfig, new StringBuffer().append(this.key).append(".static").toString());
        }
    }

    private void logCommConfigTransportParams(String string, CommConfigTransportParams commConfigTransportParams) {
        CommAgentTracing.CONFIG.log((short)2, "%2.queueLimitBytes = %1", new Integer(commConfigTransportParams.getQueueLimitBytes()), (Object)string);
        CommAgentTracing.CONFIG.log((short)2, "%2.queueLimitJobs  = %1", new Integer(commConfigTransportParams.getQueueLimitJobs()), (Object)string);
        CommAgentTracing.CONFIG.log((short)2, "%2.priority        = %1", new Integer(commConfigTransportParams.getPriority()), (Object)string);
        CommAgentTracing.CONFIG.log((short)2, "%2.async           = %1", new Boolean(commConfigTransportParams.getAsync()));
    }

    private CommConfigTransportParams parseCommConfigTransportParams(ConfigValue configValue) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            boolean bl = configPathQuery.getBooleanValue("async", CommConfigTransportParams.DEFAULT_ASYNC);
            int n = PriorityParser.parse(configPathQuery, "prio", CommConfigTransportParams.DEFAULT_PRIORITY, false);
            int n2 = configPathQuery.getIntegerValue("queue_limit_bytes", CommConfigTransportParams.DEFAULT_QUEUE_LIMIT_BYTES);
            int n3 = configPathQuery.getIntegerValue("queue_limit_jobs", CommConfigTransportParams.DEFAULT_QUEUE_LIMIT_JOBS);
            return new CommConfigTransportParams(bl, n, n3, n2);
        }
        return new CommConfigTransportParams();
    }

    private CommConfigTransportParams parseCommConfigTransportParams(ConfigValue configValue, CommConfigTransportParams commConfigTransportParams) {
        if (configValue != null) {
            ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue);
            int n = configPathQuery.getIntegerValue("queue_limit_bytes", commConfigTransportParams.getQueueLimitBytes());
            int n2 = configPathQuery.getIntegerValue("queue_limit_jobs", commConfigTransportParams.getQueueLimitJobs());
            int n3 = PriorityParser.parse(configPathQuery, "prio", commConfigTransportParams.getPriority(), false);
            boolean bl = configPathQuery.getBooleanValue("async", commConfigTransportParams.getAsync());
            return new CommConfigTransportParams(bl, n3, n2, n);
        }
        return new CommConfigTransportParams(commConfigTransportParams);
    }

    public CommConfigTransportParams getDefault() {
        return this.defaultTransportConfig;
    }

    public CommConfigTransportStatic getStatic() {
        return this.staticTransportConfig;
    }

    public CommConfigTransportParams getDynamic() {
        return this.dynamicTransportConfig;
    }

    @Override
    public void traceValues() {
        this.logCommConfigTransportParams(new StringBuffer().append(this.key).append(".default").toString(), this.defaultTransportConfig);
        this.logCommConfigTransportParams(new StringBuffer().append(this.key).append(".dynamic").toString(), this.dynamicTransportConfig);
        this.staticTransportConfig.traceValues();
    }
}

