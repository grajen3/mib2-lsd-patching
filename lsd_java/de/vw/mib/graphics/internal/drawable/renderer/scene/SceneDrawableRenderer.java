/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.scene;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.scene.SceneDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$AbstractPooledDrawable;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.scene.SceneDrawableRenderer$SimpleSceneDrawable;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.pool.ObjectPool;

public final class SceneDrawableRenderer
extends AbstractPooledDrawableRenderer {
    public SceneDrawableRenderer(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState, DrawablePerformanceMetrics drawablePerformanceMetrics) {
        super(graphics3D, logger, graphicsState, drawablePerformanceMetrics);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected AbstractPooledDrawableRenderer$AbstractPooledDrawable createInstance(AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        return new SceneDrawableRenderer$SimpleSceneDrawable(this, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    public SceneDrawable createSceneDrawable() {
        return (SceneDrawable)((Object)this.getPooledInstance());
    }
}

