/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cache;

import de.vw.mib.cache.AbstractCache$CacheableStrongReference;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class AbstractCache$CacheableStrongReferencePool
extends AbstractUnsynchronizedObjectPool {
    public AbstractCache$CacheableStrongReferencePool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new AbstractCache$CacheableStrongReference();
    }
}

