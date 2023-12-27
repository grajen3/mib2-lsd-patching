/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.MaximumObjectCountCachingPolicy;
import de.vw.mib.graphics.drawable.Drawable;

public final class DrawableCache
extends LRUCache {
    public DrawableCache(int n) {
        super(new MaximumObjectCountCachingPolicy(n), true);
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return true;
    }

    @Override
    protected void evict(AbstractCache$Entry abstractCache$Entry) {
        Drawable drawable = (Drawable)((Object)abstractCache$Entry.getValue());
        drawable.dispose();
        super.evict(abstractCache$Entry);
    }
}

