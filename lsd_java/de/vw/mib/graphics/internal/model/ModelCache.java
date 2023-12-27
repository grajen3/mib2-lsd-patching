/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.model;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

public final class ModelCache
extends LRUCache {
    public ModelCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    public int getMaximumCacheSizeBytes() {
        return 0;
    }
}

