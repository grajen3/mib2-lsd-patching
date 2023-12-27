/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.CircleGraphDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CircleGraphDrawableRenderer$SharedCircleGraphDrawable;
import de.vw.mib.graphics.internal.mesh.tesselation.CircleGraphMeshTesselator;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class CircleGraphDrawableRenderer
extends AbstractSharedDrawableRenderer {
    private static final int CIRCLEGRAPH_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.circlegraphrenderer.geometry.count", 1024);
    private static final int CIRCLEGRAPH_TESSELATOR_VERTEX_COUNT;
    private CircleGraphMeshTesselator tesselator;

    public CircleGraphDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, CIRCLEGRAPH_SHARED_GEOMETRY_VERTEX_COUNT);
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
        return new CircleGraphDrawableRenderer$SharedCircleGraphDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public CircleGraphDrawable createCircleGraphDrawable() {
        return (CircleGraphDrawable)((Object)this.getPooledInstance());
    }

    protected CircleGraphMeshTesselator getTesselator() {
        if (this.tesselator == null) {
            this.tesselator = new CircleGraphMeshTesselator(false, 256, false);
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
}

