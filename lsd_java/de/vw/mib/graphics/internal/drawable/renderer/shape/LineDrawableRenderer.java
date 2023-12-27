/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.PolyLineDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.LineDrawableRenderer$SharedLineDrawable;
import de.vw.mib.graphics.internal.mesh.tesselation.LineMeshTesselator;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class LineDrawableRenderer
extends AbstractSharedDrawableRenderer {
    private static final int LINE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.linerenderer.geometry.count", 4096);
    private static final int LINE_TESSELATOR_VERTEX_COUNT;
    private LineMeshTesselator tesselator;

    public LineDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, null, LINE_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    @Override
    protected VertexFormat getVertexFormat() {
        return this.getTesselator().getVertexFormat(0);
    }

    @Override
    protected int getIndexFormat() {
        return this.getTesselator().getIndexFormat();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new LineDrawableRenderer$SharedLineDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    protected LineMeshTesselator getTesselator() {
        if (this.tesselator == null) {
            this.tesselator = new LineMeshTesselator(false, 1024);
            this.tesselator.initialize();
            Logger logger = this.getLogger();
            if (logger.isTraceEnabled(512)) {
                LogMessage logMessage = logger.trace(512);
                logMessage.append("Created ");
                logMessage.append(super.getClass().getName());
                logMessage.append(" maxVertices ").append(this.tesselator.getMaxVertexCount());
                logMessage.append(" (").append(this.tesselator.getMaxVertexCount() * this.tesselator.getVertexSize()).append(" bytes) ");
                logMessage.append(" maxIndices ").append(this.tesselator.getMaxIndexCount());
                logMessage.log();
            }
        }
        return this.tesselator;
    }

    public PolyLineDrawable createPolyLineDrawable() {
        return (PolyLineDrawable)((Object)this.getPooledInstance());
    }
}

