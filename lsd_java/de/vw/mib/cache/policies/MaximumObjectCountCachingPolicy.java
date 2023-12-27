/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache.policies;

import de.vw.mib.cache.Cache;
import de.vw.mib.cache.Cacheable;
import de.vw.mib.cache.CachingPolicy;

public class MaximumObjectCountCachingPolicy
implements CachingPolicy {
    private int maxObjectCountLimit;

    public MaximumObjectCountCachingPolicy(int n) {
        this.maxObjectCountLimit = n;
    }

    @Override
    public boolean isEvictionRequired(Cache cache, Cacheable cacheable) {
        return cache.size() + 1 > this.maxObjectCountLimit;
    }
}

