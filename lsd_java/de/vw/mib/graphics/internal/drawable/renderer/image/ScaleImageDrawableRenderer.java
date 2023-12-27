/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.image.CompositeImageDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageDrawableRenderer$SharedScaleImageDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.internal.texture.TextureAtlas;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public class ScaleImageDrawableRenderer
extends CompositeImageDrawableRenderer {
    private static final int SCALEIMAGE_PRIMITIVE_TYPE;
    private static final int SCALEIMAGE_MESHBUILDER_VERTEX_COUNT;
    private static final int SCALEIMAGE_SHARED_GEOMETRY_VERTEX_COUNT;
    private static final int SCALEIMAGE_SHARED_GEOMETRY_INDEX_COUNT;
    private static final int SCALEIMAGE_GEOMETRY_INDEX_FORMAT;
    private static final int SCALEIMAGE_MESHBUILDER_INDEX_COUNT;

    public ScaleImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, SCALEIMAGE_SHARED_GEOMETRY_VERTEX_COUNT, 2048, SCALEIMAGE_SHARED_GEOMETRY_INDEX_COUNT, SCALEIMAGE_MESHBUILDER_INDEX_COUNT);
    }

    protected ScaleImageDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics, TextureAtlas textureAtlas, int n) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics, textureAtlas, n, 2048, SCALEIMAGE_SHARED_GEOMETRY_INDEX_COUNT, SCALEIMAGE_MESHBUILDER_INDEX_COUNT);
    }

    @Override
    protected int getIndexFormat() {
        return 1;
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new ScaleImageDrawableRenderer$SharedScaleImageDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public ScaleImageDrawable createScaleImageDrawable() {
        return (ScaleImageDrawable)((Object)this.getPooledInstance());
    }

    static {
        SCALEIMAGE_MESHBUILDER_INDEX_COUNT = SCALEIMAGE_SHARED_GEOMETRY_INDEX_COUNT = (SCALEIMAGE_SHARED_GEOMETRY_VERTEX_COUNT = Integer.getInteger("de.vw.mib.graphics.scaleimagerenderer.geometry.count", 4096).intValue());
    }
}

