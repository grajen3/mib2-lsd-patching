/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.mesh;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

public final class MeshCache
extends LRUCache {
    public MeshCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    public int getMaximumCacheSizeBytes() {
        return 0;
    }
}

