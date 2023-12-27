/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$Entry;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class AbstractCache$CacheEntryPool
extends AbstractUnsynchronizedObjectPool {
    public AbstractCache$CacheEntryPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new AbstractCache$Entry();
    }
}

