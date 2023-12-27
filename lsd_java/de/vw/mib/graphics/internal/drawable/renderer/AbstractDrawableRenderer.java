/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.drawable.renderer.DrawableRenderer;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractDrawableRenderer
extends AbstractResource
implements DrawableRenderer {
    private final GraphicsState state;
    private final DrawablePerformanceMetrics performanceMetrics;

    public AbstractDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger);
        this.state = graphicsState;
        this.performanceMetrics = drawablePerformanceMetrics;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public final GraphicsState getGraphicsState() {
        return this.state;
    }

    @Override
    public final DrawablePerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }
}

