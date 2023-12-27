/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.threading;

import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;

public final class ThreadPoolConfig {
    public static final int minThreadsDefault;
    public static final int maxThreadsDefault;
    public static final int jobQueueSizeDefault;
    public static final int defaultPrioDefault;
    public static final int latencyDefault;
    public static final int MaxWaitTimeDefault;
    private int minThreads;
    private int maxThreads;
    private int jobQueueSize;
    private int defaultPrio;
    private int latency;
    private int maxWaitTime;

    public ThreadPoolConfig() {
        this.reset();
    }

    public void reset() {
        this.minThreads = 0;
        this.maxThreads = 30;
        this.jobQueueSize = 0;
        this.defaultPrio = 5;
        this.latency = 1000;
        this.maxWaitTime = 10000;
    }

    public void parseConfig(IConfigQuery iConfigQuery) {
        this.minThreads = iConfigQuery.getIntegerValue("minThreads", this.minThreads);
        this.maxThreads = iConfigQuery.getIntegerValue("maxThreads", this.maxThreads);
        this.jobQueueSize = iConfigQuery.getIntegerValue("jobQueueSize", this.jobQueueSize);
        this.defaultPrio = iConfigQuery.getIntegerValue("defaultPrio", this.defaultPrio);
        this.latency = iConfigQuery.getIntegerValue("latency", this.latency);
        this.maxWaitTime = iConfigQuery.getIntegerValue("maxWaitTime", this.maxWaitTime);
    }

    public int getMinThreads() {
        return this.minThreads;
    }

    public int getMaxThreads() {
        return this.maxThreads;
    }

    public int getJobQueueSize() {
        return this.jobQueueSize;
    }

    public int getDefaultPrio() {
        return this.defaultPrio;
    }

    public int getLatency() {
        return this.latency;
    }

    public int getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public ThreadPool createThreadPool(String string, ITimeSource iTimeSource) {
        return new ThreadPool(string, iTimeSource, this.defaultPrio, this.maxThreads, this.minThreads, this.jobQueueSize, this.latency, this.maxWaitTime);
    }

    public static ThreadPoolConfig createConfig(ConfigValue configValue, String string) {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
        if (configValue != null) {
            ConfigOverlayPathQuery configOverlayPathQuery = ConfigOverlayPathQuery.createPackagePathQuery(configValue, string, "*");
            threadPoolConfig.parseConfig(configOverlayPathQuery);
        }
        return threadPoolConfig;
    }
}

