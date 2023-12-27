/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.shape.RectangleDrawableRenderer$SharedRectangleDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class RectangleDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    private static final int RECTANGLE_SHARED_GEOMETRY_VERTEXT_COUNT = Integer.getInteger("de.vw.mib.graphics.rectanglerenderer.geometry.count", 1024);
    private static final int RECTANGLE_POSITIONS_ELEMENT_TYPE;
    private static final int RECTANGLE_POSITIONS_ELEMENT_SIZE;
    private static final int RECTANGLE_PRIMITIVE_TYPE;
    private static final int RECTANGLE_PRIMITIVE_VERTICES;
    private static final int RECTANGLE_ELEMENT_PRIMITIVE_COUNT;
    private static final int RECTANGLE_ELEMENT_VERTEX_COUNT;
    private static final int RECTANGLE_MESHBUILDER_VERTEX_COUNT;

    public RectangleDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, null, RECTANGLE_SHARED_GEOMETRY_VERTEXT_COUNT, 4);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected VertexFormat getVertexFormat() {
        VertexFormat vertexFormat = new VertexFormat();
        vertexFormat.addVertexAttribute(3, 2, 0);
        return vertexFormat;
    }

    @Override
    protected int getIndexFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new RectangleDrawableRenderer$SharedRectangleDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public RectangleDrawable createRectangleDrawable() {
        return (RectangleDrawable)((Object)this.getPooledInstance());
    }
}

