/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache;
import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.CachingPolicy;

public final class ARCache
extends AbstractCache {
    public ARCache(CachingPolicy cachingPolicy, boolean bl) {
        super(cachingPolicy, bl);
    }

    @Override
    protected void touch(AbstractCache.Entry entry) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

