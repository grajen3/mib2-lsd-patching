/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.threading;

import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import de.esolutions.fw.util.commons.threading.IThreadPoolManager;
import de.esolutions.fw.util.commons.threading.ThreadPool;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.services.threading.ThreadPoolConfig;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ThreadPoolManager
implements IThreadPoolManager,
DumpInfoProvider {
    private final ConfigValue config;
    private final ITimeSource timeSource;
    private final Map namePoolMap;

    public ThreadPoolManager(ConfigValue configValue, ITimeSource iTimeSource) {
        this.config = configValue;
        this.timeSource = iTimeSource;
        this.namePoolMap = new HashMap();
    }

    @Override
    public synchronized ThreadPool getThreadPool(String string) {
        ThreadPool threadPool = (ThreadPool)this.namePoolMap.get(string);
        if (threadPool != null) {
            return threadPool;
        }
        ThreadPoolConfig threadPoolConfig = ThreadPoolConfig.createConfig(this.config, string);
        threadPool = threadPoolConfig.createThreadPool(string, this.timeSource);
        this.namePoolMap.put(string, threadPool);
        return threadPool;
    }

    @Override
    public String getName() {
        return "ThreadPools";
    }

    @Override
    public synchronized void dump(PrintStream printStream, String string) {
        Iterator iterator = this.namePoolMap.values().iterator();
        while (iterator.hasNext()) {
            ((ThreadPool)iterator.next()).dump(printStream);
        }
    }
}

