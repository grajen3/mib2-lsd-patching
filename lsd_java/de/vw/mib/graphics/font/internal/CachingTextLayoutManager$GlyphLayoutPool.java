/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledGlyphLayout;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class CachingTextLayoutManager$GlyphLayoutPool
extends AbstractUnsynchronizedObjectPool {
    public CachingTextLayoutManager$GlyphLayoutPool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledGlyphLayout(this);
    }
}

