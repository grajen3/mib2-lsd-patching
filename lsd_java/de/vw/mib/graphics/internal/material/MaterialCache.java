/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.material;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

public final class MaterialCache
extends LRUCache {
    public MaterialCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    public int getMaximumCacheSizeBytes() {
        return 0;
    }
}

