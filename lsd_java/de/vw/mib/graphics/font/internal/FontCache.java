/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.cache.LRUCache;
import de.vw.mib.cache.policies.UnlimitedCachingPolicy;

public final class FontCache
extends LRUCache {
    public FontCache() {
        super(new UnlimitedCachingPolicy(), false);
    }

    @Override
    protected boolean canEvict(AbstractCache$Entry abstractCache$Entry) {
        return true;
    }
}

