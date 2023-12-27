/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.ColorEffect;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.effect.EffectException;
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
import de.vw.mib.graphics.internal.effect.shader.ColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.animation.DemoShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.debug.DepthVisualizationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.debug.DummyShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.debug.NormalVisualizationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.gradient.ColorGradientShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.gradient.RadialGradientShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.gradient.WeightedGradientShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.ColorConversionShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.ImageCompositionShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.ImageShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.ImageTransformationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.filter.convolution.ConvolutionFilterShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.image.filter.depthoffield.BokehDepthOfFieldBlurFilterShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.lighting.BlinnPhongLightingShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.particle.BlurredParticleHeightMapShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.particle.BlurredParticleShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.particle.ParticleShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.procedural.CheckerboardShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.text.TextShaderEffect;
import de.vw.mib.graphics.internal.state.GraphicsState;
import de.vw.mib.graphics.shader.ShaderException;
import de.vw.mib.log4mib.Logger;
import java.util.Iterator;

public final class ShaderEffectManager
extends AbstractEffectManager {
    private static final int DEMO_SHADEREFFECT_MAP_INITIAL_CAPACITY;
    private static final int WEIGHTEDGRADIENT_SHADEREFFECT_MAP_INITIAL_CAPACITY;
    private static final int CONVOLUTIONFILTER_SHADEREFFECT_MAP_INITIAL_CAPACITY;
    private final GraphicsState state;
    private DummyShaderEffect dummyShaderEffect;
    private CheckerboardShaderEffect checkerboardShaderEffect;
    private IntObjectMap demoShaderEffectMap;
    private DepthVisualizationShaderEffect depthVisualizationShaderEffect;
    private NormalVisualizationShaderEffect normalVisualizationShaderEffect;
    private ColorShaderEffect colorShaderEffect;
    private ImageShaderEffect imageShaderEffect;
    private ImageTransformationShaderEffect imageTransformationShaderEffect;
    private ImageCompositionShaderEffect imageCompositionShaderEffect;
    private TextShaderEffect textShaderEffect;
    private ColorConversionShaderEffect colorConversionShaderEffect;
    private ColorGradientShaderEffect colorGradientShaderEffect;
    private RadialGradientShaderEffect radialGradientShaderEffect;
    private IntObjectMap weightedGradientShaderEffectMap;
    private IntObjectMap convolutionFilterShaderEffectMap;
    private BlinnPhongLightingShaderEffect phongLightingShaderEffect;
    private ParticleShaderEffect particleShaderEffect;
    private BlurredParticleShaderEffect blurredParticleShaderEffect;
    private BlurredParticleHeightMapShaderEffect blurredParticleHeightMapShaderEffect;
    private BokehDepthOfFieldBlurFilterShaderEffect bokehDepthOfFieldBlurFilterShaderEffect;

    public ShaderEffectManager(Graphics3D graphics3D, Logger logger, GraphicsState graphicsState) {
        super(graphics3D, logger);
        this.state = graphicsState;
        this.demoShaderEffectMap = new IntObjectOptHashMap(3);
        this.weightedGradientShaderEffectMap = new IntObjectOptHashMap(2);
        this.convolutionFilterShaderEffectMap = new IntObjectOptHashMap(5);
    }

    @Override
    public void dispose() {
        Effect effect;
        if (this.dummyShaderEffect != null) {
            this.dummyShaderEffect.dispose();
            this.dummyShaderEffect = null;
        }
        if (this.checkerboardShaderEffect != null) {
            this.checkerboardShaderEffect.dispose();
            this.checkerboardShaderEffect = null;
        }
        Iterator iterator = this.demoShaderEffectMap.valueIterator();
        while (iterator.hasNext()) {
            effect = (Effect)iterator.next();
            effect.dispose();
        }
        if (this.depthVisualizationShaderEffect != null) {
            this.depthVisualizationShaderEffect.dispose();
            this.depthVisualizationShaderEffect = null;
        }
        if (this.normalVisualizationShaderEffect != null) {
            this.normalVisualizationShaderEffect.dispose();
            this.normalVisualizationShaderEffect = null;
        }
        this.demoShaderEffectMap.clear();
        if (this.colorShaderEffect != null) {
            this.colorShaderEffect.dispose();
            this.colorShaderEffect = null;
        }
        if (this.imageShaderEffect != null) {
            this.imageShaderEffect.dispose();
            this.imageShaderEffect = null;
        }
        if (this.imageTransformationShaderEffect != null) {
            this.imageTransformationShaderEffect.dispose();
            this.imageTransformationShaderEffect = null;
        }
        if (this.imageCompositionShaderEffect != null) {
            this.imageCompositionShaderEffect.dispose();
            this.imageCompositionShaderEffect = null;
        }
        if (this.textShaderEffect != null) {
            this.textShaderEffect.dispose();
            this.textShaderEffect = null;
        }
        if (this.colorConversionShaderEffect != null) {
            this.colorConversionShaderEffect.dispose();
            this.colorConversionShaderEffect = null;
        }
        if (this.colorGradientShaderEffect != null) {
            this.colorGradientShaderEffect.dispose();
            this.colorGradientShaderEffect = null;
        }
        if (this.radialGradientShaderEffect != null) {
            this.radialGradientShaderEffect.dispose();
            this.radialGradientShaderEffect = null;
        }
        iterator = this.weightedGradientShaderEffectMap.valueIterator();
        while (iterator.hasNext()) {
            effect = (Effect)iterator.next();
            effect.dispose();
        }
        this.weightedGradientShaderEffectMap.clear();
        iterator = this.convolutionFilterShaderEffectMap.valueIterator();
        while (iterator.hasNext()) {
            effect = (Effect)iterator.next();
            effect.dispose();
        }
        this.convolutionFilterShaderEffectMap.clear();
        if (this.phongLightingShaderEffect != null) {
            this.phongLightingShaderEffect.dispose();
            this.phongLightingShaderEffect = null;
        }
        if (this.particleShaderEffect != null) {
            this.particleShaderEffect.dispose();
            this.particleShaderEffect = null;
        }
        if (this.blurredParticleShaderEffect != null) {
            this.blurredParticleShaderEffect.dispose();
            this.blurredParticleShaderEffect = null;
        }
        if (this.blurredParticleHeightMapShaderEffect != null) {
            this.blurredParticleHeightMapShaderEffect.dispose();
            this.blurredParticleHeightMapShaderEffect = null;
        }
        if (this.bokehDepthOfFieldBlurFilterShaderEffect != null) {
            this.bokehDepthOfFieldBlurFilterShaderEffect.dispose();
            this.bokehDepthOfFieldBlurFilterShaderEffect = null;
        }
        super.dispose();
    }

    public GraphicsState getGraphicsState() {
        return this.state;
    }

    @Override
    public Effect getDummyEffect() {
        if (this.dummyShaderEffect == null) {
            try {
                this.dummyShaderEffect = new DummyShaderEffect(this);
                this.dummyShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.dummyShaderEffect.dispose();
                this.dummyShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.dummyShaderEffect;
    }

    @Override
    public CheckerboardEffect getCheckerboardEffect() {
        if (this.checkerboardShaderEffect == null) {
            try {
                this.checkerboardShaderEffect = new CheckerboardShaderEffect(this);
                this.checkerboardShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.checkerboardShaderEffect.dispose();
                this.checkerboardShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.checkerboardShaderEffect;
    }

    @Override
    public DemoEffect getDemoEffect(int n) {
        DemoShaderEffect demoShaderEffect = (DemoShaderEffect)this.demoShaderEffectMap.get(n);
        if (demoShaderEffect == null) {
            try {
                demoShaderEffect = new DemoShaderEffect(this, n);
                demoShaderEffect.initialize();
                this.demoShaderEffectMap.put(n, demoShaderEffect);
            }
            catch (ShaderException shaderException) {
                demoShaderEffect.dispose();
                throw new EffectException(shaderException);
            }
        }
        return demoShaderEffect;
    }

    @Override
    public Effect getDepthVisualizationEffect() {
        if (this.depthVisualizationShaderEffect == null) {
            try {
                this.depthVisualizationShaderEffect = new DepthVisualizationShaderEffect(this);
                this.depthVisualizationShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.depthVisualizationShaderEffect.dispose();
                this.depthVisualizationShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.depthVisualizationShaderEffect;
    }

    @Override
    public NormalTransformationEffect getNormalVisualizationEffect() {
        if (this.normalVisualizationShaderEffect == null) {
            try {
                this.normalVisualizationShaderEffect = new NormalVisualizationShaderEffect(this);
                this.normalVisualizationShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.normalVisualizationShaderEffect.dispose();
                this.normalVisualizationShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.normalVisualizationShaderEffect;
    }

    @Override
    public ColorEffect getColorEffect() {
        if (this.colorShaderEffect == null) {
            try {
                this.colorShaderEffect = new ColorShaderEffect(this);
                this.colorShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.colorShaderEffect.dispose();
                this.colorShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.colorShaderEffect;
    }

    @Override
    public ImageEffect getImageEffect() {
        if (this.imageShaderEffect == null) {
            try {
                this.imageShaderEffect = new ImageShaderEffect(this);
                this.imageShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.imageShaderEffect.dispose();
                this.imageShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.imageShaderEffect;
    }

    @Override
    public ImageTransformationEffect getImageTransformationEffect() {
        if (this.imageTransformationShaderEffect == null) {
            try {
                this.imageTransformationShaderEffect = new ImageTransformationShaderEffect(this);
                this.imageTransformationShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.imageTransformationShaderEffect.dispose();
                this.imageTransformationShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.imageTransformationShaderEffect;
    }

    @Override
    public ImageCompositionEffect getImageCompositionEffect() {
        if (this.imageCompositionShaderEffect == null) {
            try {
                this.imageCompositionShaderEffect = new ImageCompositionShaderEffect(this);
                this.imageCompositionShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.imageCompositionShaderEffect.dispose();
                this.imageCompositionShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.imageCompositionShaderEffect;
    }

    @Override
    public TextEffect getTextEffect() {
        if (this.textShaderEffect == null) {
            try {
                this.textShaderEffect = new TextShaderEffect(this);
                this.textShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.textShaderEffect.dispose();
                this.textShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.textShaderEffect;
    }

    @Override
    public ColorConversionEffect getColorConversionEffect() {
        if (this.colorConversionShaderEffect == null) {
            try {
                this.colorConversionShaderEffect = new ColorConversionShaderEffect(this);
                this.colorConversionShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.colorConversionShaderEffect.dispose();
                this.colorConversionShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.colorConversionShaderEffect;
    }

    @Override
    public ColorGradientEffect getColorGradientEffect() {
        if (this.colorGradientShaderEffect == null) {
            try {
                this.colorGradientShaderEffect = new ColorGradientShaderEffect(this);
                this.colorGradientShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.colorGradientShaderEffect.dispose();
                this.colorGradientShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.colorGradientShaderEffect;
    }

    @Override
    public RadialGradientEffect getRadialGradientEffect() {
        if (this.radialGradientShaderEffect == null) {
            try {
                this.radialGradientShaderEffect = new RadialGradientShaderEffect(this);
                this.radialGradientShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.radialGradientShaderEffect.dispose();
                this.radialGradientShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.radialGradientShaderEffect;
    }

    @Override
    public WeightedGradientEffect getWeightedGradientEffect(int n, int n2, boolean bl) {
        int n3 = (n << 16) + (bl ? 256 : 0) + n2;
        WeightedGradientShaderEffect weightedGradientShaderEffect = (WeightedGradientShaderEffect)this.weightedGradientShaderEffectMap.get(n3);
        if (weightedGradientShaderEffect == null) {
            try {
                weightedGradientShaderEffect = new WeightedGradientShaderEffect(this, n, n2, bl);
                weightedGradientShaderEffect.initialize();
                this.weightedGradientShaderEffectMap.put(n3, weightedGradientShaderEffect);
            }
            catch (ShaderException shaderException) {
                weightedGradientShaderEffect.dispose();
                throw new EffectException(shaderException);
            }
        }
        return weightedGradientShaderEffect;
    }

    @Override
    public ConvolutionFilterEffect getConvolutionFilterEffect(int n, int n2) {
        int n3 = (n & 0xFFFF0000) << 16 | n2 & 0xFFFF0000;
        ConvolutionFilterShaderEffect convolutionFilterShaderEffect = (ConvolutionFilterShaderEffect)this.convolutionFilterShaderEffectMap.get(n3);
        if (convolutionFilterShaderEffect == null) {
            try {
                convolutionFilterShaderEffect = new ConvolutionFilterShaderEffect(this, n, n2);
                convolutionFilterShaderEffect.initialize();
                this.convolutionFilterShaderEffectMap.put(n3, convolutionFilterShaderEffect);
            }
            catch (ShaderException shaderException) {
                convolutionFilterShaderEffect.dispose();
                throw new EffectException(shaderException);
            }
        }
        return convolutionFilterShaderEffect;
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
        if (this.phongLightingShaderEffect == null) {
            try {
                this.phongLightingShaderEffect = new BlinnPhongLightingShaderEffect(this);
                this.phongLightingShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.phongLightingShaderEffect.dispose();
                this.phongLightingShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.phongLightingShaderEffect;
    }

    @Override
    public BlinnLightingEffect getBlinnLightingEffect() {
        throw new NotYetImplementedException();
    }

    @Override
    public ParticleEffect getParticleEffect() {
        if (this.particleShaderEffect == null) {
            try {
                this.particleShaderEffect = new ParticleShaderEffect(this);
                this.particleShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.particleShaderEffect.dispose();
                this.particleShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.particleShaderEffect;
    }

    @Override
    public BlurredParticleEffect getBlurredParticleEffect() {
        if (this.blurredParticleShaderEffect == null) {
            try {
                this.blurredParticleShaderEffect = new BlurredParticleShaderEffect(this);
                this.blurredParticleShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.blurredParticleShaderEffect.dispose();
                this.blurredParticleShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.blurredParticleShaderEffect;
    }

    @Override
    public BlurredParticleHeightMapEffect getBlurredParticleHeightMapEffect() {
        if (this.blurredParticleHeightMapShaderEffect == null) {
            try {
                this.blurredParticleHeightMapShaderEffect = new BlurredParticleHeightMapShaderEffect(this);
                this.blurredParticleHeightMapShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.blurredParticleHeightMapShaderEffect.dispose();
                this.blurredParticleHeightMapShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.blurredParticleHeightMapShaderEffect;
    }

    @Override
    public BokehDepthOfFieldBlurFilterEffect getBokehDepthOfFieldBlurFilterEffect() {
        if (this.bokehDepthOfFieldBlurFilterShaderEffect == null) {
            try {
                this.bokehDepthOfFieldBlurFilterShaderEffect = new BokehDepthOfFieldBlurFilterShaderEffect(this);
                this.bokehDepthOfFieldBlurFilterShaderEffect.initialize();
            }
            catch (ShaderException shaderException) {
                this.bokehDepthOfFieldBlurFilterShaderEffect.dispose();
                this.bokehDepthOfFieldBlurFilterShaderEffect = null;
                throw new EffectException(shaderException);
            }
        }
        return this.bokehDepthOfFieldBlurFilterShaderEffect;
    }
}

