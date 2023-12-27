/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.ResourceManager;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
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

public interface EffectManager
extends ResourceManager {
    default public EffectPerformanceMetrics getPerformanceMetrics() {
    }

    default public Effect getDummyEffect() {
    }

    default public CheckerboardEffect getCheckerboardEffect() {
    }

    default public Effect getDepthVisualizationEffect() {
    }

    default public NormalTransformationEffect getNormalVisualizationEffect() {
    }

    default public DemoEffect getDemoEffect(int n) {
    }

    default public ColorEffect getColorEffect() {
    }

    default public ImageEffect getImageEffect() {
    }

    default public ImageTransformationEffect getImageTransformationEffect() {
    }

    default public ImageCompositionEffect getImageCompositionEffect() {
    }

    default public TextEffect getTextEffect() {
    }

    default public ColorConversionEffect getColorConversionEffect() {
    }

    default public ColorGradientEffect getColorGradientEffect() {
    }

    default public RadialGradientEffect getRadialGradientEffect() {
    }

    default public WeightedGradientEffect getWeightedGradientEffect(int n, int n2, boolean bl) {
    }

    default public ConvolutionFilterEffect getConvolutionFilterEffect(int n, int n2) {
    }

    default public ConstantLightingEffect getConstantLightingEffect() {
    }

    default public LambertLightingEffect getLambertLightingEffect() {
    }

    default public PhongLightingEffect getPhongLightingEffect() {
    }

    default public BlinnLightingEffect getBlinnLightingEffect() {
    }

    default public ParticleEffect getParticleEffect() {
    }

    default public BlurredParticleEffect getBlurredParticleEffect() {
    }

    default public BlurredParticleHeightMapEffect getBlurredParticleHeightMapEffect() {
    }

    default public BokehDepthOfFieldBlurFilterEffect getBokehDepthOfFieldBlurFilterEffect() {
    }
}

