/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import java.util.List;

public class ImageShaderEffect
extends TransformColorShaderEffect
implements ImageEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"image/Image"};
    public static final String UNIFORM_NAME_IMAGE_SAMPLER;
    private Sampler2DShaderEffectVariable imageSampler;

    public ImageShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedImageEffects = effectPerformanceMetrics.allocatedImageEffects + (bl ? 1 : -1);
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
        this.imageSampler = this.addSampler2DShaderEffectVariable("u_imageSampler");
    }

    @Override
    public final int getImageSampler() {
        return this.imageSampler.getSampler();
    }

    @Override
    public final void setImageSampler(int n) {
        this.imageSampler.setSampler(n);
    }
}

