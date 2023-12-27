/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.GraphicsListener;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectManager;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.NormalTransformationEffect;
import de.vw.mib.graphics.effect.animation.DemoEffect;
import de.vw.mib.graphics.effect.gradient.ColorGradientEffect;
import de.vw.mib.graphics.effect.gradient.RadialGradientEffect;
import de.vw.mib.graphics.effect.gradient.WeightedGradientEffect;
import de.vw.mib.graphics.effect.image.ColorConversionEffect;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;
import de.vw.mib.graphics.effect.image.filter.convolution.ConvolutionFilterEffect;
import de.vw.mib.graphics.effect.image.filter.depthoffield.BokehDepthOfFieldBlurFilterEffect;
import de.vw.mib.graphics.effect.lighting.BlinnLightingEffect;
import de.vw.mib.graphics.effect.lighting.ConstantLightingEffect;
import de.vw.mib.graphics.effect.lighting.LambertLightingEffect;
import de.vw.mib.graphics.effect.lighting.PhongLightingEffect;
import de.vw.mib.graphics.effect.particle.BlurredParticleEffect;
import de.vw.mib.graphics.effect.particle.BlurredParticleHeightMapEffect;
import de.vw.mib.graphics.effect.particle.ParticleEffect;
import de.vw.mib.graphics.effect.procedural.CheckerboardEffect;
import de.vw.mib.graphics.effect.text.TextEffect;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractEffectManager
extends AbstractResource
implements EffectManager,
GraphicsListener {
    private final EffectPerformanceMetrics performanceMetrics = new EffectPerformanceMetrics();

    public AbstractEffectManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
        graphics3D.addListener(this);
    }

    @Override
    public void dispose() {
        Graphics3D graphics3D = this.getGraphics3D();
        graphics3D.removeListener(this);
        super.dispose();
    }

    @Override
    public final EffectPerformanceMetrics getPerformanceMetrics() {
        return this.performanceMetrics;
    }

    @Override
    public abstract Effect getDummyEffect() {
    }

    @Override
    public abstract CheckerboardEffect getCheckerboardEffect() {
    }

    @Override
    public abstract Effect getDepthVisualizationEffect() {
    }

    @Override
    public abstract NormalTransformationEffect getNormalVisualizationEffect() {
    }

    @Override
    public abstract DemoEffect getDemoEffect(int n) {
    }

    @Override
    public abstract ColorEffect getColorEffect() {
    }

    @Override
    public abstract ImageEffect getImageEffect() {
    }

    @Override
    public abstract ImageTransformationEffect getImageTransformationEffect() {
    }

    @Override
    public abstract ImageCompositionEffect getImageCompositionEffect() {
    }

    @Override
    public abstract TextEffect getTextEffect() {
    }

    @Override
    public abstract ColorConversionEffect getColorConversionEffect() {
    }

    @Override
    public abstract ColorGradientEffect getColorGradientEffect() {
    }

    @Override
    public abstract RadialGradientEffect getRadialGradientEffect() {
    }

    @Override
    public abstract WeightedGradientEffect getWeightedGradientEffect(int n, int n2, boolean bl) {
    }

    @Override
    public abstract ConvolutionFilterEffect getConvolutionFilterEffect(int n, int n2) {
    }

    @Override
    public abstract ConstantLightingEffect getConstantLightingEffect() {
    }

    @Override
    public abstract LambertLightingEffect getLambertLightingEffect() {
    }

    @Override
    public abstract PhongLightingEffect getPhongLightingEffect() {
    }

    @Override
    public abstract BlinnLightingEffect getBlinnLightingEffect() {
    }

    @Override
    public abstract ParticleEffect getParticleEffect() {
    }

    @Override
    public abstract BlurredParticleEffect getBlurredParticleEffect() {
    }

    @Override
    public abstract BlurredParticleHeightMapEffect getBlurredParticleHeightMapEffect() {
    }

    @Override
    public abstract BokehDepthOfFieldBlurFilterEffect getBokehDepthOfFieldBlurFilterEffect() {
    }

    @Override
    public final void beginFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void endFrame(Graphics3D graphics3D) {
    }

    @Override
    public final void performanceMetricsEnabledChanged(Graphics3D graphics3D, boolean bl) {
        if (bl) {
            this.performanceMetrics.clear();
        }
    }
}

