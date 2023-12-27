/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.text;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.text.TextDrawableRenderer$SharedTextDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class TextDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    private static final int TEXT_POSITIONS_ELEMENT_TYPE;
    private static final int TEXT_POSITIONS_ELEMENT_SIZE;
    private static final int TEXT_TEXCOORDS_ELEMENT_TYPE;
    private static final int TEXT_TEXCOORDS_ELEMENT_SIZE;
    private static final int TEXT_PRIMITIVE_TYPE;
    private static final int TEXT_PRIMITIVE_VERTICES;
    private static final int TEXT_ELEMENT_PRIMITIVE_COUNT;
    private static final int TEXT_ELEMENT_VERTEX_COUNT;
    private static final int TEXT_LENGTH_MAX;
    private static final int TEXT_MESHBUILDER_VERTEX_COUNT;
    private static final int TEXT_GEOMETRY_COUNT;
    private static final int TEXT_SHARED_GEOMETRY_VERTEX_COUNT;

    public TextDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, TEXT_SHARED_GEOMETRY_VERTEX_COUNT, 6144);
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
        return new TextDrawableRenderer$SharedTextDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public TextDrawable createTextDrawable() {
        return (TextDrawable)((Object)this.getPooledInstance());
    }

    static {
        TEXT_GEOMETRY_COUNT = Integer.getInteger("de.vw.mib.graphics.textrenderer.geometry.count", 2048);
        TEXT_SHARED_GEOMETRY_VERTEX_COUNT = 6 * TEXT_GEOMETRY_COUNT;
    }
}

