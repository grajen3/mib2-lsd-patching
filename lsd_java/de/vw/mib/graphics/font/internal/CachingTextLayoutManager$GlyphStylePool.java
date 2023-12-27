/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.font.internal;

import de.vw.mib.graphics.font.internal.CachingTextLayoutManager$PooledGlyphStyle;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

final class CachingTextLayoutManager$GlyphStylePool
extends AbstractUnsynchronizedObjectPool {
    public CachingTextLayoutManager$GlyphStylePool(int n) {
        super(n);
    }

    @Override
    protected PooledObject createObjectInternal() {
        return new CachingTextLayoutManager$PooledGlyphStyle(this);
    }
}

