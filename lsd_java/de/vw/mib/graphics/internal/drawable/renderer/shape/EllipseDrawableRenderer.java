/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.EllipseDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.shape.EllipseDrawableRenderer$SharedEllipseDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class EllipseDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    protected static final Vector2f ELLIPSE_CENTER = new Vector2f(63, 63);
    protected static final Color4f ELLIPSE_COLOR = new Color4f(1.0f, 1.0f, 1.0f, 0.0f);
    private static final int ELLIPSE_SHARED_GEOMETRY_VERTEXT_COUNT = Integer.getInteger("de.vw.mib.graphics.ellipserenderer.geometry.count", 1024);
    private static final int ELLIPSE_POSITIONS_ELEMENT_TYPE;
    private static final int ELLIPSE_POSITIONS_ELEMENT_SIZE;
    private static final int ELLIPSE_TEXCOORDS_ELEMENT_TYPE;
    private static final int ELLIPSE_TEXCOORDS_ELEMENT_SIZE;
    private static final int ELLIPSE_PRIMITIVE_TYPE;
    private static final int ELLIPSE_PRIMITIVE_VERTICES;
    private static final int ELLIPSE_ELEMENT_PRIMITIVE_COUNT;
    private static final int ELLIPSE_ELEMENT_VERTEX_COUNT;
    private static final int ELLIPSE_MESHBUILDER_VERTEX_COUNT;

    public EllipseDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, null, ELLIPSE_SHARED_GEOMETRY_VERTEXT_COUNT, 4);
    }

    @Override
    public void dispose() {
        super.dispose();
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
        return new EllipseDrawableRenderer$SharedEllipseDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public EllipseDrawable createEllipseDrawable() {
        return (EllipseDrawable)((Object)this.getPooledInstance());
    }
}

