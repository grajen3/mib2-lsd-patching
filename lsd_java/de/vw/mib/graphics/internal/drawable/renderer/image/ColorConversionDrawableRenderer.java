/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ColorConversionDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ColorConversionDrawableRenderer$SharedColorConversionDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.log4mib.Logger;

public final class ColorConversionDrawableRenderer
extends AbstractImageDrawableRenderer {
    private static final int COLORCONVERSION_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.colorconversion.geometry.count", 1024);

    public ColorConversionDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, COLORCONVERSION_SHARED_GEOMETRY_VERTEX_COUNT);
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new ColorConversionDrawableRenderer$SharedColorConversionDrawable((AbstractSharedDrawableRenderer)this, abstractPooledDrawableRenderer$DrawablePool);
    }

    public ColorConversionDrawable createColorConversionDrawable() {
        return (ColorConversionDrawable)((Object)this.getPooledInstance());
    }
}

