/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache;
import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.CachingPolicy;

public final class LFUCache
extends AbstractCache {
    public LFUCache(CachingPolicy cachingPolicy, boolean bl) {
        super(cachingPolicy, bl);
    }

    @Override
    protected void touch(AbstractCache$Entry abstractCache$Entry) {
        super.touch(abstractCache$Entry);
        abstractCache$Entry.setCost(abstractCache$Entry.getUse());
    }
}

