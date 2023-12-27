/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.internal.DynamicImageLoader$ImageRequest;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

final class DynamicImageLoader$ImageRequestPool
extends AbstractSynchronizedObjectPool {
    public DynamicImageLoader$ImageRequestPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new DynamicImageLoader$ImageRequest();
    }
}

