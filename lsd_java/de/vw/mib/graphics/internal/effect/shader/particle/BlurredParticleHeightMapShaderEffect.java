/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.particle;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.particle.BlurredParticleHeightMapEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.particle.BlurredParticleShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.Float4ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple4f;
import java.util.List;

public final class BlurredParticleHeightMapShaderEffect
extends BlurredParticleShaderEffect
implements BlurredParticleHeightMapEffect {
    private static final int MIN_VERTEX_TEXTURE_UNITS;
    private static String[] VERTEX_SHADER_FILE_NAMES;
    private static String[] FRAGMENT_SHADER_FILE_NAMES;
    private static final String UNIFORM_NAME_ANIMATION_START_MAP1_SAMPLER;
    private static final String UNIFORM_NAME_ANIMATION_START_MAP1_RECT;
    private static final String UNIFORM_NAME_ANIMATION_START_MAP2_SAMPLER;
    private static final String UNIFORM_NAME_ANIMATION_START_MAP2_RECT;
    private static final String UNIFORM_NAME_ANIMATION_END_MAP1_SAMPLER;
    private static final String UNIFORM_NAME_ANIMATION_END_MAP1_RECT;
    private static final String UNIFORM_NAME_ANIMATION_END_MAP2_SAMPLER;
    private static final String UNIFORM_NAME_ANIMATION_END_MAP2_RECT;
    private Sampler2DShaderEffectVariable animationStartMap1Sampler;
    private Float4ShaderEffectVariable animationStartMap1Rect;
    private Sampler2DShaderEffectVariable animationStartMap2Sampler;
    private Float4ShaderEffectVariable animationStartMap2Rect;
    private Sampler2DShaderEffectVariable animationEndMap1Sampler;
    private Float4ShaderEffectVariable animationEndMap1Rect;
    private Sampler2DShaderEffectVariable animationEndMap2Sampler;
    private Float4ShaderEffectVariable animationEndMap2Rect;

    public BlurredParticleHeightMapShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
        if (this.getGraphics3D().getTextureManager().getMaxVertexTextureUnits() < 4) {
            throw new UnsupportedOperationException("Minimum 4 vertex texture units required");
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedBlurredParticleHeightMapEffects = effectPerformanceMetrics.allocatedBlurredParticleHeightMapEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        for (int i2 = 0; i2 < VERTEX_SHADER_FILE_NAMES.length; ++i2) {
            list.add(VERTEX_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        for (int i2 = 0; i2 < FRAGMENT_SHADER_FILE_NAMES.length; ++i2) {
            list.add(FRAGMENT_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.animationStartMap1Sampler = this.addSampler2DShaderEffectVariable("u_animationStartMap1");
        this.animationStartMap1Rect = this.addFloat4ShaderEffectVariable("u_animationStartMap1Rect");
        this.animationStartMap2Sampler = this.addSampler2DShaderEffectVariable("u_animationStartMap2");
        this.animationStartMap2Rect = this.addFloat4ShaderEffectVariable("u_animationStartMap2Rect");
        this.animationEndMap1Sampler = this.addSampler2DShaderEffectVariable("u_animationEndMap1");
        this.animationEndMap1Rect = this.addFloat4ShaderEffectVariable("u_animationEndMap1Rect");
        this.animationEndMap2Sampler = this.addSampler2DShaderEffectVariable("u_animationEndMap2");
        this.animationEndMap2Rect = this.addFloat4ShaderEffectVariable("u_animationEndMap2Rect");
    }

    @Override
    public int getAnimationStartMap1Sampler() {
        return this.animationStartMap1Sampler.getSampler();
    }

    @Override
    public void setAnimationStartMap1Sampler(int n) {
        this.animationStartMap1Sampler.setSampler(n);
    }

    @Override
    public Tuple4f getAnimationStartMap1Rect() {
        return this.animationStartMap1Rect.getValue();
    }

    @Override
    public void setAnimationStartMap1Rect(Tuple4f tuple4f) {
        this.animationStartMap1Rect.setValue(tuple4f);
    }

    @Override
    public int getAnimationStartMap2Sampler() {
        return this.animationStartMap2Sampler.getSampler();
    }

    @Override
    public void setAnimationStartMap2Sampler(int n) {
        this.animationStartMap2Sampler.setSampler(n);
    }

    @Override
    public Tuple4f getAnimationStartMap2Rect() {
        return this.animationStartMap2Rect.getValue();
    }

    @Override
    public void setAnimationStartMap2Rect(Tuple4f tuple4f) {
        this.animationStartMap2Rect.setValue(tuple4f);
    }

    @Override
    public int getAnimationEndMap1Sampler() {
        return this.animationEndMap1Sampler.getSampler();
    }

    @Override
    public void setAnimationEndMap1Sampler(int n) {
        this.animationEndMap1Sampler.setSampler(n);
    }

    @Override
    public Tuple4f getAnimationEndMap1Rect() {
        return this.animationEndMap1Rect.getValue();
    }

    @Override
    public void setAnimationEndMap1Rect(Tuple4f tuple4f) {
        this.animationEndMap1Rect.setValue(tuple4f);
    }

    @Override
    public int getAnimationEndMap2Sampler() {
        return this.animationEndMap2Sampler.getSampler();
    }

    @Override
    public void setAnimationEndMap2Sampler(int n) {
        this.animationEndMap2Sampler.setSampler(n);
    }

    @Override
    public Tuple4f getAnimationEndMap2Rect() {
        return this.animationEndMap2Rect.getValue();
    }

    @Override
    public void setAnimationEndMap2Rect(Tuple4f tuple4f) {
        this.animationEndMap2Rect.setValue(tuple4f);
    }

    static {
        VERTEX_SHADER_FILE_NAMES = new String[]{"particle/BlurredParticleHeightMap"};
        FRAGMENT_SHADER_FILE_NAMES = new String[]{"particle/BlurredParticleHeightMap"};
    }
}

