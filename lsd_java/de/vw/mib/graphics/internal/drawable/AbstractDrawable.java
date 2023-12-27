/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.internal.drawable.renderer.DrawableRenderer;

public abstract class AbstractDrawable
extends AbstractResource
implements Drawable {
    protected static final Color4f DEFAULT_COLOR = Color4f.WHITE;
    private static final float DEFAULT_ALPHA;
    private final DrawableRenderer renderer;
    private Color4f color;
    private float alpha;

    public AbstractDrawable(DrawableRenderer drawableRenderer) {
        super(drawableRenderer.getGraphics3D(), drawableRenderer.getLogger());
        this.renderer = drawableRenderer;
        this.color = new Color4f(DEFAULT_COLOR);
        this.alpha = 1.0f;
    }

    @Override
    public void dispose() {
        this.color.set(DEFAULT_COLOR);
        this.alpha = 1.0f;
    }

    protected final DrawableRenderer getDrawableRenderer() {
        return this.renderer;
    }

    @Override
    public final Color4f getColor() {
        return this.color;
    }

    @Override
    public final void setColor(Color4b color4b) {
        this.color.set(color4b);
    }

    @Override
    public final void setColor(Color4f color4f) {
        this.color.set(color4f);
    }

    @Override
    public final float getAlpha() {
        return this.alpha;
    }

    @Override
    public final void setAlpha(float f2) {
        this.alpha = f2;
    }

    public final void setColorAlpha(Color4b color4b, float f2) {
        this.color.set(color4b);
        this.alpha = f2;
    }

    public final void setColorAlpha(Color4f color4f, float f2) {
        this.color.set(color4f);
        this.alpha = f2;
    }

    protected final boolean isFullyTransparent() {
        return this.color.isFullyTransparent() && this.alpha == 0.0f;
    }

    @Override
    public void draw() {
        Graphics3D graphics3D = this.getGraphics3D();
        if (graphics3D.arePerformanceMetricsEnabled()) {
            DrawablePerformanceMetrics drawablePerformanceMetrics = this.getDrawableRenderer().getPerformanceMetrics();
            this.updateDrawingStatistics(drawablePerformanceMetrics);
        }
    }

    protected abstract void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
    }

    @Override
    public final void draw(float f2, float f3) {
        if (f2 != 0.0f || f3 != 0.0f) {
            Graphics3D graphics3D = this.getGraphics3D();
            graphics3D.pushMatrix(0);
            graphics3D.translateMatrix(0, f2, f3, 0.0f);
            this.draw();
            graphics3D.popMatrix(0);
        } else {
            this.draw();
        }
    }
}

