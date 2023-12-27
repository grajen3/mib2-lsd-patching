/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.gradient.ColorGradientEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import java.util.List;

public final class ColorGradientShaderEffect
extends ImageShaderEffect
implements ColorGradientEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"gradient/ColorGradient"};
    private static final String UNIFORM_NAME_COLOR_START;
    private static final String UNIFORM_NAME_COLOR_END;
    private ColorShaderEffectVariable colorStart;
    private ColorShaderEffectVariable colorEnd;

    public ColorGradientShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedColorGradientEffects = effectPerformanceMetrics.allocatedColorGradientEffects + (bl ? 1 : -1);
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
        this.colorStart = this.addColorShaderEffectVariable("u_colorStart");
        this.colorEnd = this.addColorShaderEffectVariable("u_colorEnd");
    }

    @Override
    public Color4f getColorStart() {
        return this.colorStart.getColor();
    }

    @Override
    public void setColorStart(Color4f color4f) {
        this.colorStart.setColor(color4f);
    }

    @Override
    public Color4f getEndColor() {
        return this.colorEnd.getColor();
    }

    @Override
    public void setColorEnd(Color4f color4f) {
        this.colorEnd.setColor(color4f);
    }
}

