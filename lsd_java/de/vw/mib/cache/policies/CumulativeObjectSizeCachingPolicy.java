/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache.policies;

import de.vw.mib.cache.Cache;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.cache.CachingPolicy;

public class CumulativeObjectSizeCachingPolicy
implements CachingPolicy {
    private int cumulativeObjectSizeLimit;

    public CumulativeObjectSizeCachingPolicy(int n) {
        this.cumulativeObjectSizeLimit = n;
    }

    @Override
    public boolean isEvictionRequired(Cache cache, Cacheable cacheable) {
        return cache.getByteSize() + cacheable.getByteSize() > this.cumulativeObjectSizeLimit;
    }
}

