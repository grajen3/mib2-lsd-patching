/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.drawable.DrawablePerformanceMetrics;
import de.vw.mib.graphics.drawable.image.ScaleImageGradientDrawable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.gradient.WeightedGradientEffect;
import de.vw.mib.graphics.internal.drawable.renderer.AbstractSharedDrawableRenderer;
import de.vw.mib.graphics.internal.drawable.renderer.image.ScaleImageDrawableRenderer$SharedScaleImageDrawable;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.pool.ObjectPool;

final class ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable
extends ScaleImageDrawableRenderer$SharedScaleImageDrawable
implements ScaleImageGradientDrawable {
    private Gradient gradient;
    private Color4f[] gradientColors;
    private int absX;
    private int absY;
    private int referenceWidth;
    private Matrix4f gradientTransformation;

    public ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable(AbstractSharedDrawableRenderer abstractSharedDrawableRenderer, ObjectPool objectPool) {
        super(abstractSharedDrawableRenderer, objectPool, true);
    }

    @Override
    public void dispose() {
        this.gradient = null;
        this.gradientColors = null;
        this.absX = 0;
        this.absY = 0;
        this.referenceWidth = 0;
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics, boolean bl) {
        drawablePerformanceMetrics.allocatedScaleImageGradients = drawablePerformanceMetrics.allocatedScaleImageGradients + (bl ? 1 : -1);
    }

    @Override
    public Gradient getGradient() {
        return this.gradient;
    }

    @Override
    public void setGradient(Gradient gradient) {
        if (this.gradient != null && gradient != null && this.gradient.getBlendMode() != gradient.getBlendMode()) {
            this.clearEffect();
        }
        this.gradient = gradient;
    }

    @Override
    public Color4f[] getGradientColors() {
        return this.gradientColors;
    }

    @Override
    public void setGradientColors(Color4f[] color4fArray) {
        if (this.gradientColors != null && this.gradientColors.length != color4fArray.length) {
            this.clearEffect();
        }
        this.gradientColors = color4fArray;
    }

    @Override
    public void setAbsolutePosition(int n, int n2) {
        this.absX = n;
        this.absY = n2;
        this.clearEffect();
    }

    @Override
    public void setReferenceAreaSize(int n, int n2) {
        this.referenceWidth = n;
        this.clearEffect();
    }

    @Override
    protected Effect createEffect(Graphics3D graphics3D) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        boolean bl;
        boolean bl2 = bl = this.gradient.getGradientType() == 2;
        if (this.gradientTransformation == null) {
            this.gradientTransformation = new Matrix4f();
        }
        float f8 = (float)this.getHeight() / (float)this.getWidth();
        if (bl) {
            f7 = f8 < 1.0f ? 1.0f / f8 : 1.0f;
            float f9 = f6 = f8 > 1.0f ? f8 : 1.0f;
            if (this.gradient.isScale()) {
                f4 = f5 = 1.0f;
            } else {
                f5 = (float)this.getWidth() / f7 / (float)this.referenceWidth;
                f4 = (float)this.getHeight() / f6 / (float)this.referenceWidth;
            }
        } else {
            f7 = 1.0f;
            f6 = f8;
            if (this.gradient.isScale()) {
                f5 = 1.0f;
                f4 = 0.0f;
            } else {
                f5 = (float)this.getWidth() / (float)this.referenceWidth;
                f4 = 0.0f;
            }
        }
        switch (this.gradient.getCenterPositionType()) {
            case 2: {
                f3 = (float)(-(this.absX - this.gradient.getCenterX())) / (float)this.getWidth();
                f2 = (float)(-(this.absY - this.gradient.getCenterY())) / (float)this.getHeight();
                break;
            }
            case 0: {
                f3 = (float)this.gradient.getCenterX() / 51266 * f7;
                f2 = bl ? (float)this.gradient.getCenterY() / 51266 * f6 : 0.0f;
                break;
            }
            default: {
                f3 = (float)this.gradient.getCenterX() / (float)this.getWidth() * f7;
                f2 = (float)this.gradient.getCenterY() / (float)this.getHeight() * f6;
            }
        }
        this.gradientTransformation.setIdentity();
        this.gradientTransformation.scale(f5, f4, 1.0f);
        this.gradientTransformation.translate(63, 63, 0.0f);
        this.gradientTransformation.rotate(Util.toRadians(this.gradient.getRotation()), 0.0f, 0.0f, 1.0f);
        this.gradientTransformation.translate(191 - f3, 191 - f2, 0.0f);
        this.gradientTransformation.scale(f7, f6, 1.0f);
        int n = ScaleImageGradientDrawableRenderer$SharedScaleImageGradientDrawable.mapGradientBlendMode(this.gradient.getBlendMode());
        boolean bl3 = this.getScaleImage() != null && !this.getScaleImage().isEmpty();
        return graphics3D.getEffectManager().getWeightedGradientEffect(n, this.gradientColors.length, bl3);
    }

    @Override
    protected void updateEffect(Effect effect) {
        WeightedGradientEffect weightedGradientEffect = (WeightedGradientEffect)effect;
        this.setImageTransformation(this.gradientTransformation);
        this.setImageBlending(weightedGradientEffect.getImageBlending());
        this.updateTransformationEffect(weightedGradientEffect);
        this.updateColorEffect(weightedGradientEffect);
        this.updateImageEffect(weightedGradientEffect);
        this.updateImageTransformationEffect(weightedGradientEffect);
        this.updateImageBlendingEffect(weightedGradientEffect);
        this.updateImageCompositionEffect(weightedGradientEffect);
        this.updateWeightedGradientEffect(weightedGradientEffect);
    }

    protected void updateWeightedGradientEffect(WeightedGradientEffect weightedGradientEffect) {
        weightedGradientEffect.setColors(this.gradientColors);
        weightedGradientEffect.setColorPositions(this.gradient.getColorPositions());
        weightedGradientEffect.setColorTransitions(this.gradient.getColorTransitions());
    }

    @Override
    protected void updateDrawingStatistics(DrawablePerformanceMetrics drawablePerformanceMetrics) {
        ++drawablePerformanceMetrics.drawnScaleImageGradients;
    }

    private static int mapGradientBlendMode(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 4;
            }
        }
        throw new IllegalArgumentException("Invalid gardient blend mode");
    }
}

