/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image.filter.convolution;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.filter.convolution.ConvolutionFilterEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageTransformationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.BooleanShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float2ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatArrayShaderEffectVariable;
import java.util.List;

public final class ConvolutionFilterShaderEffect
extends ImageTransformationShaderEffect
implements ConvolutionFilterEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTextureMatrix"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"image/filter/convolution/ConvolutionFilter"};
    private static final String UNIFORM_NAME_ALPHA_ONLY;
    private static final String UNIFORM_NAME_KERNEL;
    private static final String UNIFORM_NAME_TEXEL_SIZE;
    private final int kernelWidth;
    private final int kernelHeight;
    private BooleanShaderEffectVariable alphaOnly;
    private FloatArrayShaderEffectVariable kernel;
    private Float2ShaderEffectVariable texelSize;

    public ConvolutionFilterShaderEffect(ShaderEffectManager shaderEffectManager, int n, int n2) {
        super(shaderEffectManager);
        this.kernelWidth = n;
        this.kernelHeight = n2;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedConvolutionFilterEffects = effectPerformanceMetrics.allocatedConvolutionFilterEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderDefines(List list) {
        super.getVertexShaderDefines(list);
    }

    @Override
    protected void getVertexShaderFilenames(List list) {
        for (int i2 = 0; i2 < VERTEX_SHADER_FILE_NAMES.length; ++i2) {
            list.add(VERTEX_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getFragmentShaderDefines(List list) {
        super.getFragmentShaderDefines(list);
        list.add(ConvolutionFilterShaderEffect.createDefine("KERNEL_WIDTH", this.kernelWidth));
        list.add(ConvolutionFilterShaderEffect.createDefine("KERNEL_HEIGHT", this.kernelHeight));
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
        this.alphaOnly = this.addBooleanShaderEffectVariable("u_alphaOnly");
        this.kernel = this.addFloatArrayShaderEffectVariable(ConvolutionFilterShaderEffect.buildArrayUniformName("u_kernel"), this.kernelWidth * this.kernelHeight);
        this.texelSize = this.addFloat2ShaderEffectVariable("u_texelSize");
    }

    @Override
    public boolean getAlphaOnly() {
        return this.alphaOnly.getValue();
    }

    @Override
    public void setAlphaOnly(boolean bl) {
        this.alphaOnly.setValue(bl);
    }

    @Override
    public float[] getKernel() {
        return this.kernel.getValue();
    }

    @Override
    public void setKernel(float[] fArray) {
        this.kernel.setValue(fArray);
    }

    @Override
    public void setTexelSize(float f2, float f3) {
        this.texelSize.setValue(f2, f3);
    }
}

