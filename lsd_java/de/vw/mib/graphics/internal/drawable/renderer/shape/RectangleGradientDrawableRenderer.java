/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.RectangleGradientDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.shape.RectangleGradientDrawableRenderer$SharedRectangleGradientDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class RectangleGradientDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    private static final int RECTANGLE_SHARED_GEOMETRY_VERTEXT_COUNT = Integer.getInteger("de.vw.mib.graphics.rectanglegradientrenderer.geometry.count", 512);
    private static final int RECTANGLE_POSITIONS_ELEMENT_TYPE;
    private static final int RECTANGLE_POSITIONS_ELEMENT_SIZE;
    private static final int RECTANGLE_PRIMITIVE_TYPE;
    private static final int RECTANGLE_TEXCOORDS_ELEMENT_TYPE;
    private static final int RECTANGLE_TEXCOORDS_ELEMENT_SIZE;
    private static final int RECTANGLE_PRIMITIVE_VERTICES;
    private static final int RECTANGLE_ELEMENT_PRIMITIVE_COUNT;
    private static final int RECTANGLE_ELEMENT_VERTEX_COUNT;
    private static final int RECTANGLE_MESHBUILDER_VERTEX_COUNT;

    public RectangleGradientDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
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
        vertexFormat.addVertexAttribute(3, 2, 3, 1);
        return vertexFormat;
    }

    @Override
    protected int getIndexFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new RectangleGradientDrawableRenderer$SharedRectangleGradientDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public RectangleGradientDrawable createGradientDrawable() {
        return (RectangleGradientDrawable)((Object)this.getPooledInstance());
    }
}

