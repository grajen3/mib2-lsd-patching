/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ColorGradientDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ColorGradientDrawableRenderer$SharedColorGradientDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.log4mib.Logger;

public final class ColorGradientDrawableRenderer
extends AbstractImageDrawableRenderer {
    private static final int COLORCONVERSION_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.colorgradient.geometry.count", 1024);

    public ColorGradientDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, COLORCONVERSION_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new ColorGradientDrawableRenderer$SharedColorGradientDrawable((AbstractSharedDrawableRenderer)this, abstractPooledDrawableRenderer$DrawablePool);
    }

    public ColorGradientDrawable createColorGradientDrawable() {
        return (ColorGradientDrawable)((Object)this.getPooledInstance());
    }
}

