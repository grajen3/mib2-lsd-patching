/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractPooledDrawableRenderer
extends AbstractDrawableRenderer {
    private static final int DRAWABLE_POOL_MAXIMUM_CAPACITY;
    private final AbstractPooledDrawableRenderer$DrawablePool drawablePool = new AbstractPooledDrawableRenderer$DrawablePool(100, this);

    public AbstractPooledDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics);
    }

    protected final AbstractPooledDrawableRenderer$AbstractPooledDrawable getPooledInstance() {
        Logger logger = this.getLogger();
        AbstractPooledDrawableRenderer$AbstractPooledDrawable abstractPooledDrawableRenderer$AbstractPooledDrawable = (AbstractPooledDrawableRenderer$AbstractPooledDrawable)this.drawablePool.borrowObject();
        abstractPooledDrawableRenderer$AbstractPooledDrawable.updateAllocationStatistics(this.getPerformanceMetrics(), true);
        if (logger.isTraceEnabled(512)) {
            LogMessage logMessage = logger.trace(512);
            logMessage.append(super.getClass().getName());
            logMessage.append(".drawablePool.size(): ").append(this.drawablePool.size()).log();
        }
        return abstractPooledDrawableRenderer$AbstractPooledDrawable;
    }

    protected abstract AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
    }
}

