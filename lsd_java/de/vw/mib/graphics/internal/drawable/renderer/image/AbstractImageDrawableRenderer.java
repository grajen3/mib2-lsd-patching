/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractMeshBuilderSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractImageDrawableRenderer
extends AbstractMeshBuilderSharedDrawableRenderer {
    protected static final int IMAGE_POSITIONS_ELEMENT_TYPE;
    protected static final int IMAGE_POSITIONS_ELEMENT_SIZE;
    protected static final int IMAGE_TEXCOORDS_ELEMENT_TYPE;
    protected static final int IMAGE_TEXCOORDS_ELEMENT_SIZE;
    protected static final int IMAGE_PRIMITIVE_TYPE;
    protected static final int IMAGE_PRIMITIVE_VERTICES;
    protected static final int IMAGE_ELEMENT_PRIMITIVE_COUNT;
    protected static final int IMAGE_ELEMENT_VERTEX_COUNT;
    protected static final int IMAGE_MESHBUILDER_VERTEX_COUNT;

    public AbstractImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, 4);
    }

    public AbstractImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n2);
    }

    public AbstractImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2, int n3, int n4) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n2, n3, n4);
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
    protected abstract AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
    }
}

