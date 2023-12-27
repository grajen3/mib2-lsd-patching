/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.Cache;
import de.vw.mib.cache.Cacheable;

public interface CachingPolicy {
    default public boolean isEvictionRequired(Cache cache, Cacheable cacheable) {
    }
}

