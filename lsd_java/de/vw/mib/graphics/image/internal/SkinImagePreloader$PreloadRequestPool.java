/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.image.internal;

import de.vw.mib.graphics.image.internal.SkinImagePreloader$PreloadRequest;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractSynchronizedObjectPool;

final class SkinImagePreloader$PreloadRequestPool
extends AbstractSynchronizedObjectPool {
    public SkinImagePreloader$PreloadRequestPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new SkinImagePreloader$PreloadRequest();
    }
}

