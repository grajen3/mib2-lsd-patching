/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.pool.defaultimpl.AbstractUnsynchronizedObjectPool;

public final class AbstractPooledDrawableRenderer$DrawablePool
extends AbstractUnsynchronizedObjectPool {
    private final AbstractPooledDrawableRenderer renderer;

    public AbstractPooledDrawableRenderer$DrawablePool(int n, AbstractPooledDrawableRenderer abstractPooledDrawableRenderer) {
        super(n);
        this.renderer = abstractPooledDrawableRenderer;
    }

    @Override
    protected PooledObject createObjectInternal() {
        return this.renderer.createInstance(this);
    }
}

