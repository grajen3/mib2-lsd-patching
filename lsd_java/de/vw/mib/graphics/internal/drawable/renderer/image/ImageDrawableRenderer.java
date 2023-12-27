/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ImageDrawableRenderer$SharedImageDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public class ImageDrawableRenderer
extends AbstractImageDrawableRenderer {
    private static final int IMAGE_GEOMETRY_COUNT = Integer.getInteger("de.vw.mib.graphics.imagerenderer.geometry.count", 1024);
    private static final int IMAGE_SHARED_GEOMETRY_VERTEX_COUNT = 4 * IMAGE_GEOMETRY_COUNT;

    public ImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, IMAGE_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    public ImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n2);
    }

    protected ImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n, int n2, int n3, int n4) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, n2, n3, n4);
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new ImageDrawableRenderer$SharedImageDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public ImageDrawable createImageDrawable() {
        return (ImageDrawable)((Object)this.getPooledInstance());
    }
}

