/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.CompositeImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.image.CompositeImageDrawableRenderer$SharedCompositeImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.image.ImageDrawableRenderer;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public class CompositeImageDrawableRenderer
extends ImageDrawableRenderer {
    private static final int COMPOSITE_IMAGE_GEOMETRY_COUNT = Integer.getInteger("de.vw.mib.graphics.compositeimagerenderer.geometry.count", 1024);
    private static final int COMPOSITE_IMAGE_SHARED_GEOMETRY_VERTEX_COUNT = 4 * COMPOSITE_IMAGE_GEOMETRY_COUNT;

    public CompositeImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, COMPOSITE_IMAGE_SHARED_GEOMETRY_VERTEX_COUNT, 4);
    }

    protected CompositeImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, 4);
    }

    protected CompositeImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2, int n3, int n4) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n2, n3, n4);
    }

    @Override
    protected VertexFormat getVertexFormat() {
        VertexFormat vertexFormat = new VertexFormat();
        vertexFormat.addVertexAttribute(3, 2, 0);
        vertexFormat.addVertexAttribute(3, 2, 3, 0);
        vertexFormat.addVertexAttribute(3, 2, 3, 1);
        return vertexFormat;
    }

    @Override
    protected int getIndexFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new CompositeImageDrawableRenderer$SharedCompositeImageDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public CompositeImageDrawable createCompositeImageDrawable() {
        return (CompositeImageDrawable)((Object)this.getPooledInstance());
    }
}

