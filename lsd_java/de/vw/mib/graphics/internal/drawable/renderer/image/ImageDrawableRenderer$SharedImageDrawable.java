/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ImageDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.image.ImageBlendingEffect;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.AbstractImageDrawableRenderer$AbstractSharedImageDrawable;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.util.StringBuilder;

public class ImageDrawableRenderer$SharedImageDrawable
extends AbstractImageDrawableRenderer$AbstractSharedImageDrawable
implements ImageDrawable {
    private static final int DEFAULT_IMAGE_BLENDING;
    private static final Color4f DEFAULT_IMAGE_BLENDING_COLOR;
    private int imageBlending = 0;
    private Color4f imageBlendingColor = new Color4f(DEFAULT_IMAGE_BLENDING_COLOR);

    public ImageDrawableRenderer$SharedImageDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",imageBlendingMode=").append(this.imageBlending);
        stringBuilder.append(",imageBlendingColor=").append(this.imageBlendingColor);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        this.imageBlendingColor.set(DEFAULT_IMAGE_BLENDING_COLOR);
        this.imageBlending = 0;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedImages = drawablePerformanceMetrics.allocatedImages + (bl ? 1 : -1);
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        return graphics3D.getEffectManager().getImageCompositionEffect();
    }

    @Override
    public final int getImageBlending() {
        return this.imageBlending;
    }

    @Override
    public final void setImageBlending(int n) {
        if (this.imageBlending != n) {
            this.imageBlending = n;
        }
    }

    @Override
    public final Color4f getImageBlendingColor() {
        return this.imageBlendingColor;
    }

    @Override
    public final void setImageBlendingColor(Color4f color4f) {
        if (!this.imageBlendingColor.equals(color4f)) {
            this.imageBlendingColor.set(color4f);
        }
    }

    @Override
    protected void updateEffect(Effect effect) {
        ImageCompositionEffect imageCompositionEffect = (ImageCompositionEffect)effect;
        this.updateTransformationEffect(imageCompositionEffect);
        this.updateColorEffect(imageCompositionEffect);
        this.updateImageEffect(imageCompositionEffect);
        this.updateImageBlendingEffect(imageCompositionEffect);
        this.updateImageTransformationEffect(imageCompositionEffect);
        this.updateImageCompositionEffect(imageCompositionEffect);
    }

    protected final void updateImageBlendingEffect(ImageBlendingEffect imageBlendingEffect) {
        imageBlendingEffect.setImageBlending(this.imageBlending);
        imageBlendingEffect.setImageBlendingColor(this.imageBlendingColor);
    }

    protected void updateImageTransformationEffect(ImageTransformationEffect imageTransformationEffect) {
        imageTransformationEffect.setImageTransformation(Matrix4f.IDENTITY);
    }

    protected void updateImageCompositionEffect(ImageCompositionEffect imageCompositionEffect) {
        for (int i2 = imageCompositionEffect.getMaximumImageLayerCount() - 1; i2 >= 1; --i2) {
            imageCompositionEffect.setImageSampler(i2, -1);
        }
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnImages;
    }

    static {
        DEFAULT_IMAGE_BLENDING_COLOR = Color4f.WHITE;
    }
}

