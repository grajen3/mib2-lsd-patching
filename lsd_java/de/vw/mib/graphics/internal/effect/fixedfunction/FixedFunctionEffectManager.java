/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.fixedfunction;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
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
import de.vw.mib.graphics.internal.effect.AbstractEffectManager;
import de.vw.mib.log4mib.Logger;

public final class FixedFunctionEffectManager
extends AbstractEffectManager {
    public FixedFunctionEffectManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public Effect getDummyEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public CheckerboardEffect getCheckerboardEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public DemoEffect getDemoEffect(int n) {
        throw new NotYetImplementedException();
    }

    @Override
    public Effect getDepthVisualizationEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public NormalTransformationEffect getNormalVisualizationEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ColorEffect getColorEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ImageEffect getImageEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ImageTransformationEffect getImageTransformationEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ImageCompositionEffect getImageCompositionEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public TextEffect getTextEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ColorConversionEffect getColorConversionEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ColorGradientEffect getColorGradientEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public RadialGradientEffect getRadialGradientEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public WeightedGradientEffect getWeightedGradientEffect(int n, int n2, boolean bl) {
        throw new NotYetImplementedException();
    }

    @Override
    public ConvolutionFilterEffect getConvolutionFilterEffect(int n, int n2) {
        throw new NotYetImplementedException();
    }

    @Override
    public ConstantLightingEffect getConstantLightingEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public LambertLightingEffect getLambertLightingEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public PhongLightingEffect getPhongLightingEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public BlinnLightingEffect getBlinnLightingEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ParticleEffect getParticleEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public BlurredParticleEffect getBlurredParticleEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public BlurredParticleHeightMapEffect getBlurredParticleHeightMapEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public BokehDepthOfFieldBlurFilterEffect getBokehDepthOfFieldBlurFilterEffect() {
        throw new NotYetImplementedException();
    }
}

