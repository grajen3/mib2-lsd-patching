/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ColorGradientDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.gradient.ColorGradientEffect;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractPooledDrawableRenderer$DrawablePool;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer$AbstractSharedImageDrawable;
import de.vw.mib.graphics.internal.mesh.MeshHeap$SubMesh;
import de.vw.mib.graphics.texture.Texture;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;
import java.util.List;

final class ColorGradientDrawableRenderer$SharedColorGradientDrawable
extends AbstractImageDrawableRenderer$AbstractSharedImageDrawable
implements ColorGradientDrawable {
    private final Color4f colorStart = new Color4f(Color4f.BLACK_TRANSPARENT);
    private final Color4f colorEnd = new Color4f(Color4f.BLACK_TRANSPARENT);

    public ColorGradientDrawableRenderer$SharedColorGradientDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, AbstractPooledDrawableRenderer$DrawablePool abstractPooledDrawableRenderer$DrawablePool) {
        super(abstractSharedDrawableRenderer, (ObjectPool)abstractPooledDrawableRenderer$DrawablePool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",colorStart=").append(this.colorStart);
        stringBuilder.append(",colorEnd=").append(this.colorEnd);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.colorStart.set(Color4f.BLACK_TRANSPARENT);
        this.colorEnd.set(Color4f.BLACK_TRANSPARENT);
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedColorGradients = drawablePerformanceMetrics.allocatedColorGradients + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getColorGradientEffect();
    }

    @Override
    public Color4f getColorStart() {
        return this.colorStart;
    }

    @Override
    public void setColorStart(Color4f color4f) {
        if (!this.colorStart.equals(color4f)) {
            this.colorStart.set(color4f);
        }
    }

    @Override
    public Color4f getColorEnd() {
        return this.colorEnd;
    }

    @Override
    public void setColorEnd(Color4f color4f) {
        if (!this.colorEnd.equals(color4f)) {
            this.colorEnd.set(color4f);
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ColorGradientEffect colorGradientEffect = (ColorGradientEffect)effect;
        this.updateTransformationEffect(colorGradientEffect);
        this.updateColorEffect(colorGradientEffect);
        this.updateImageEffect(colorGradientEffect);
        this.updateColorGradientEffect(colorGradientEffect);
    }

    protected void updateColorGradientEffect(ColorGradientEffect colorGradientEffect) {
        colorGradientEffect.setColorStart(this.colorStart);
        colorGradientEffect.setColorEnd(this.colorEnd);
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnColorGradients;
    }

    @Override
    protected MeshHeap$SubMesh updateMesh(Texture[] textureArray, List list) {
        BufferImage bufferImage = this.getImage();
        int n = bufferImage.getWidth();
        int n2 = bufferImage.getHeight();
        this.setSourceX(0);
        this.setSourceY(0);
        this.setSourceWidth(n);
        this.setSourceHeight(n2);
        this.setDestinationX(0);
        this.setDestinationY(0);
        this.setDestinationWidth(n);
        this.setDestinationHeight(n2);
        return super.updateMesh(textureArray, list);
    }
}

