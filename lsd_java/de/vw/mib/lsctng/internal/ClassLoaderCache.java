/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.lsctng.internal.ServiceManager;
import java.util.ArrayList;

public abstract class ClassLoaderCache {
    protected static final Logger LOG = ServiceManager.loggerFactory.getLogger(1024);
    protected static final int SUB_CLASSIFIER;
    private final ArrayList cache = new ArrayList();

    public ClassLoader getCachedClassloader(int n) {
        this.ensureCacheSize(n);
        ClassLoader classLoader = this.getClassloader(n, this.cache);
        if (classLoader == null) {
            LOG.normal(4096).append("No cached classloader for skin ").append(n).log();
        } else {
            LOG.normal(4096).append("Found cached classloader for skin ").append(n).log();
        }
        return classLoader;
    }

    public void storeClassloader(int n, ClassLoader classLoader) {
        this.ensureCacheSize(n);
        this.storeClassloader(n, classLoader, this.cache);
        LOG.normal(4096, new StringBuffer().append("Store classloader for skin ").append(n).append(".").toString());
    }

    private void ensureCacheSize(int n) {
        while (this.cache.size() <= n) {
            this.cache.add(null);
        }
    }

    protected abstract void storeClassloader(int n, ClassLoader classLoader, ArrayList arrayList) {
    }

    protected abstract ClassLoader getClassloader(int n, ArrayList arrayList) {
    }
}

