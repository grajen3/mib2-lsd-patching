/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.drawable.AbstractDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractPooledDrawableRenderer$AbstractPooledDrawable
extends AbstractDrawable
implements PooledObject {
    private final ObjectPool pool;

    public AbstractPooledDrawableRenderer$AbstractPooledDrawable(AbstractPooledDrawableRenderer abstractPooledDrawableRenderer, ObjectPool objectPool) {
        super(abstractPooledDrawableRenderer);
        this.pool = objectPool;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",pool=").append(this.pool);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
        this.updateAllocationStatistics(this.getDrawableRenderer().getPerformanceMetrics(), false);
        this.pool.releaseObject(this);
    }

    protected abstract void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
    }

    @Override
    public final void backToPool() {
    }
}

