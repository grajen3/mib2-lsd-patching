/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledTextStyle;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class CachingTextLayoutManager$TextStylePool
extends AbstractUnsynchronizedObjectPool {
    public CachingTextLayoutManager$TextStylePool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledTextStyle(this);
    }
}

