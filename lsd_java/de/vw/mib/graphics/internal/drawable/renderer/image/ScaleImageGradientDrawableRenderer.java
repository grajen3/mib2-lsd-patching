/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ScaleImageGradientDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class ScaleImageGradientDrawableRenderer
extends ScaleImageDrawableRenderer {
    private static final int SCALE_IMAGE_GRADIENT_GEOMETRY_COUNT = Integer.getInteger("de.vw.mib.graphics.scaleimagegradientrenderer.geometry.count", 256);

    public ScaleImageGradientDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, SCALE_IMAGE_GRADIENT_GEOMETRY_COUNT);
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public ScaleImageGradientDrawable createScaleImageGradientDrawable() {
        return (ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable)this.getPooledInstance();
    }
}

