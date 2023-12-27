/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image.filter.depthoffield;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.filter.depthoffield.BokehDepthOfFieldBlurFilterEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageTransformationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import java.util.List;

public final class BokehDepthOfFieldBlurFilterShaderEffect
extends ImageTransformationShaderEffect
implements BokehDepthOfFieldBlurFilterEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"image/filter/depthoffield/BokehDepthOfFieldBlurFilter"};
    public static final String UNIFORM_NAME_DEPTH_TEXTURE;
    private Sampler2DShaderEffectVariable depthSamplerUnit;

    public BokehDepthOfFieldBlurFilterShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedBokehDepthOfFieldBlurFilterEffects = effectPerformanceMetrics.allocatedBokehDepthOfFieldBlurFilterEffects + (bl ? 1 : -1);
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
        this.depthSamplerUnit = this.addSampler2DShaderEffectVariable("u_depthTexture");
    }

    @Override
    public int getDepthSampler() {
        return this.depthSamplerUnit.getSampler();
    }

    @Override
    public void setDepthSampler(int n) {
        this.depthSamplerUnit.setSampler(n);
    }
}

