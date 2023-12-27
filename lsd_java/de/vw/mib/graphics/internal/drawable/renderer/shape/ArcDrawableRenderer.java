/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.shape;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.shape.ArcDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.shape.ArcDrawableRenderer$SharedArcDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class ArcDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    private static final int ARC_POSITIONS_ELEMENT_TYPE;
    private static final int ARC_POSITIONS_ELEMENT_SIZE;
    private static final int ARC_TEXCOORDS_ELEMENT_TYPE;
    private static final int ARC_TEXCOORDS_ELEMENT_SIZE;
    private static final int ARC_PRIMITIVE_TYPE;
    private static final int ARC_PRIMITIVE_VERTICES;
    private static final int ARC_ELEMENT_PRIMITIVE_COUNT;
    private static final int ARC_ELEMENT_VERTEX_COUNT;
    private static final int ARC_GEOMETRY_COUNT;
    private static final int ARC_BUFFER_VERTEX_COUNT;
    private static final int ARC_GEOMETRY_VERTEX_COUNT;

    public ArcDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, ARC_GEOMETRY_VERTEX_COUNT, ARC_BUFFER_VERTEX_COUNT);
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
        return new ArcDrawableRenderer$SharedArcDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public ArcDrawable createArcDrawable() {
        return (ArcDrawable)((Object)this.getPooledInstance());
    }

    static {
        ARC_GEOMETRY_COUNT = Integer.getInteger("de.vw.mib.graphics.shaperenderer.geometry.count", 16);
        ARC_BUFFER_VERTEX_COUNT = 2 * ARC_GEOMETRY_COUNT;
        ARC_GEOMETRY_VERTEX_COUNT = 2 * ARC_GEOMETRY_COUNT;
    }
}

