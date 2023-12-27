/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledNativeTextLayout;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class CachingTextLayoutManager$NativeTextLayoutPool
extends AbstractUnsynchronizedObjectPool {
    public CachingTextLayoutManager$NativeTextLayoutPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledNativeTextLayout(this);
    }
}

