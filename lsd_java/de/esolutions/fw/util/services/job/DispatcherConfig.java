/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.job.PooledDispatcher;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.services.job.InterceptorConfig;
import de.esolutions.fw.util.services.threading.ThreadPoolManager;

public final class DispatcherConfig {
    public static final int prioDefault;
    public static final String threadPoolDefault;
    public static final String threadPolicyDefault;
    public static final boolean dumpInfoProviderDefault;
    private int prio;
    private String threadPool;
    private String threadPolicy;
    private boolean dumpInfoProvider;
    private InterceptorConfig[] interceptors;

    public DispatcherConfig() {
        this.reset();
    }

    public void reset() {
        this.prio = 5;
        this.threadPool = "default";
        this.threadPolicy = "ondemand";
        this.dumpInfoProvider = false;
        this.interceptors = null;
    }

    public int getPrio() {
        return this.prio;
    }

    public String getThreadPool() {
        return this.threadPool;
    }

    public String getThreadPolicy() {
        return this.threadPolicy;
    }

    public boolean getDumpInfoProvider() {
        return this.dumpInfoProvider;
    }

    public InterceptorConfig[] getInterceptors() {
        return this.interceptors;
    }

    public void parseConfig(IConfigQuery iConfigQuery) {
        int n;
        this.prio = iConfigQuery.getIntegerValue("prio", this.prio);
        this.threadPool = iConfigQuery.getStringValue("threadPool", this.threadPool);
        this.threadPolicy = iConfigQuery.getStringValue("threadPolicy", this.threadPolicy);
        this.dumpInfoProvider = iConfigQuery.getBooleanValue("dumpInfoProvider", this.dumpInfoProvider);
        ConfigValue configValue = iConfigQuery.getArray("interceptors");
        if (configValue != null && (n = configValue.getArraySize()) > 0) {
            this.interceptors = new InterceptorConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                this.interceptors[i2] = new InterceptorConfig();
                ConfigPathQuery configPathQuery = new ConfigPathQuery(configValue.getArrayValue(i2));
                this.interceptors[i2].parseConfig(configPathQuery);
            }
        }
    }

    public DispatcherBase createDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, ThreadPoolManager threadPoolManager) {
        ThreadPool threadPool = threadPoolManager.getThreadPool(this.threadPool);
        DispatcherBase dispatcherBase = this.threadPolicy.equals("ondemand") ? new PooledDispatcher(string, iTimeSource, iJobLogger, threadPool) : new DispatcherBase(string, iTimeSource, iJobLogger, threadPool);
        this.setupDispatcher(dispatcherBase);
        return dispatcherBase;
    }

    public DispatcherBase createDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, ThreadPoolManager threadPoolManager) {
        ThreadPool threadPool = threadPoolManager.getThreadPool(this.threadPool);
        DispatcherBase dispatcherBase = this.threadPolicy.equals("ondemand") ? new PooledDispatcher(string, iTimeSource, iJobLogger, jobQueue, threadPool) : new DispatcherBase(string, iTimeSource, iJobLogger, jobQueue, threadPool);
        this.setupDispatcher(dispatcherBase);
        return dispatcherBase;
    }

    public DispatcherBase createDispatcher(String string, ITimeSource iTimeSource, IJobLogger iJobLogger, JobQueue jobQueue, IInterceptor iInterceptor, Job job, ThreadPoolManager threadPoolManager) {
        ThreadPool threadPool = threadPoolManager.getThreadPool(this.threadPool);
        DispatcherBase dispatcherBase = this.threadPolicy.equals("ondemand") ? new PooledDispatcher(string, iTimeSource, iJobLogger, jobQueue, iInterceptor, job, threadPool) : new DispatcherBase(string, iTimeSource, iJobLogger, jobQueue, iInterceptor, job, threadPool);
        this.setupDispatcher(dispatcherBase);
        return dispatcherBase;
    }

    private void setupDispatcher(DispatcherBase dispatcherBase) {
        dispatcherBase.setPriority(this.prio);
        InterceptorConfig[] interceptorConfigArray = this.getInterceptors();
        for (int i2 = 0; i2 < interceptorConfigArray.length; ++i2) {
            IInterceptor iInterceptor = interceptorConfigArray[i2].createInterceptor(dispatcherBase);
            if (iInterceptor == null) continue;
            dispatcherBase.addInterceptor(iInterceptor);
        }
    }

    public static DispatcherConfig createConfig(ConfigValue configValue, String string) {
        DispatcherConfig dispatcherConfig = new DispatcherConfig();
        if (configValue != null) {
            ConfigOverlayPathQuery configOverlayPathQuery = ConfigOverlayPathQuery.createPackagePathQuery(configValue, string, "*");
            dispatcherConfig.parseConfig(configOverlayPathQuery);
        }
        return dispatcherConfig;
    }
}

