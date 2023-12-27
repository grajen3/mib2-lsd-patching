/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.shape.CurveDrawableRenderer$SharedCubicBezierCurveDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class CurveDrawableRenderer
extends AbstractImageDrawableRenderer {
    private static final int CURVE_POSITIONS_ELEMENT_TYPE;
    private static final int CURVE_POSITIONS_ELEMENT_SIZE;
    private static final int CURVE_TEXCOORDS_ELEMENT_TYPE;
    private static final int CURVE_TEXCOORDS_ELEMENT_SIZE;
    private static final int CURVE_PRIMITIVE_TYPE;
    private static final int CURVE_SHARED_GEOMETRY_VERTEX_COUNT;
    private static final int CURVE_MESHBUILDER_VERTEX_COUNT;

    public CurveDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, CURVE_SHARED_GEOMETRY_VERTEX_COUNT, 1024);
    }

    @Override
    protected VertexFormat getVertexFormat() {
        VertexFormat vertexFormat = new VertexFormat();
        vertexFormat.addVertexAttribute(3, 2, 0);
        vertexFormat.addVertexAttribute(3, 2, 3, 0);
        return vertexFormat;
    }

    @Override
    protected int getIndexFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new CurveDrawableRenderer$SharedCubicBezierCurveDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public CubicBezierCurveDrawable createCubicBezierCurveDrawable() {
        return (CubicBezierCurveDrawable)((Object)this.getPooledInstance());
    }

    static {
        CURVE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.curverenderer.geometry.count", 4096);
    }
}

