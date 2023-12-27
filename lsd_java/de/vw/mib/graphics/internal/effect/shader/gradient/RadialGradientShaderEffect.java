/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.gradient.RadialGradientEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformColorShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float2ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple2f;
import java.util.List;

public final class RadialGradientShaderEffect
extends TransformColorShaderEffect
implements RadialGradientEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"gradient/RadialGradient"};
    private static final String UNIFORM_NAME_CENTER;
    private static final String UNIFORM_NAME_INNER_RADIUS;
    private static final String UNIFORM_NAME_OUTER_RADIUS;
    private static final String UNIFORM_NAME_GRADIENT_COLOR;
    private Float2ShaderEffectVariable center;
    private FloatShaderEffectVariable innerRadius;
    private FloatShaderEffectVariable outerRadius;
    private ColorShaderEffectVariable gradientColor;

    public RadialGradientShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedRadialGradientEffects = effectPerformanceMetrics.allocatedRadialGradientEffects + (bl ? 1 : -1);
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
        this.center = this.addFloat2ShaderEffectVariable("u_center");
        this.innerRadius = this.addFloatShaderEffectVariable("u_innerRadius");
        this.outerRadius = this.addFloatShaderEffectVariable("u_outerRadius");
        this.gradientColor = this.addColorShaderEffectVariable("u_gradientColor");
    }

    @Override
    public Tuple2f getCenter() {
        return this.center.getValue();
    }

    @Override
    public void setCenter(Tuple2f tuple2f) {
        this.center.setValue(tuple2f);
    }

    @Override
    public float getInnerRadius() {
        return this.innerRadius.getValue();
    }

    @Override
    public void setInnerRadius(float f2) {
        this.innerRadius.setValue(f2);
    }

    @Override
    public float getOuterRadius() {
        return this.outerRadius.getValue();
    }

    @Override
    public void setOuterRadius(float f2) {
        this.outerRadius.setValue(f2);
    }

    @Override
    public Color4f getGradientColor() {
        return this.gradientColor.getColor();
    }

    @Override
    public void setGradientColor(Color4f color4f) {
        this.gradientColor.setColor(color4f);
    }
}

