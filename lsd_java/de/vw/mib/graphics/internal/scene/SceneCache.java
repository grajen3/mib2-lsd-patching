/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene;

import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

public final class SceneCache
extends LRUCache {
    public SceneCache() {
        super(new UnlimitedCachingPolicy(), true);
    }

    public int getMaximumCacheSizeBytes() {
        return 0;
    }
}

