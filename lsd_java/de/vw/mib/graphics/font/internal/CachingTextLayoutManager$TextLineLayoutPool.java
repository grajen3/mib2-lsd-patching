/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextLineLayout;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class CachingTextLayoutManager$TextLineLayoutPool
extends AbstractUnsynchronizedObjectPool {
    public CachingTextLayoutManager$TextLineLayoutPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledTextLineLayout(this);
    }
}

