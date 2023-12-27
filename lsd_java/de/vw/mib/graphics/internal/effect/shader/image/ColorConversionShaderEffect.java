/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.image;

import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.image.ColorConversionEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.Float3ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple3f;
import java.util.List;

public final class ColorConversionShaderEffect
extends ImageShaderEffect
implements ColorConversionEffect {
    private static String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformTexture"};
    private static String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"ColorConversion"};
    private static final String UNIFORM_NAME_HUE1;
    private static final String UNIFORM_NAME_FIRST_COLOR_CONVERSION_PARAM1;
    private static final String UNIFORM_NAME_FIRST_COLOR_CONVERSION_PARAM2;
    private static final String UNIFORM_NAME_FIRST_COLOR_CONVERSION_PARAM3;
    private static final String UNIFORM_NAME_HUE2;
    private static final String UNIFORM_NAME_SECOND_COLOR_CONVERSION_PARAM1;
    private static final String UNIFORM_NAME_SECOND_COLOR_CONVERSION_PARAM2;
    private static final String UNIFORM_NAME_SECOND_COLOR_CONVERSION_PARAM3;
    private FloatShaderEffectVariable firstSignalHue;
    private FloatShaderEffectVariable secondSignalHue;
    private Float3ShaderEffectVariable firstColorConversionParam1;
    private Float3ShaderEffectVariable firstColorConversionParam2;
    private Float3ShaderEffectVariable firstColorConversionParam3;
    private Float3ShaderEffectVariable secondColorConversionParam1;
    private Float3ShaderEffectVariable secondColorConversionParam2;
    private Float3ShaderEffectVariable secondColorConversionParam3;

    public ColorConversionShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedColorConversionEffects = effectPerformanceMetrics.allocatedColorConversionEffects + (bl ? 1 : -1);
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
        this.firstSignalHue = this.addFloatShaderEffectVariable("u_hue1");
        this.secondSignalHue = this.addFloatShaderEffectVariable("u_hue2");
        this.firstColorConversionParam1 = this.addFloat3ShaderEffectVariable("u_color1ConvParam1");
        this.firstColorConversionParam2 = this.addFloat3ShaderEffectVariable("u_color1ConvParam2");
        this.firstColorConversionParam3 = this.addFloat3ShaderEffectVariable("u_color1ConvParam3");
        this.secondColorConversionParam1 = this.addFloat3ShaderEffectVariable("u_color2ConvParam1");
        this.secondColorConversionParam2 = this.addFloat3ShaderEffectVariable("u_color2ConvParam2");
        this.secondColorConversionParam3 = this.addFloat3ShaderEffectVariable("u_color2ConvParam3");
    }

    @Override
    public float getFirstSignalHue() {
        return this.firstSignalHue.getValue();
    }

    @Override
    public void setFirstSignalHue(float f2) {
        this.firstSignalHue.setValue(f2);
    }

    @Override
    public float getSecondSignalHue() {
        return this.secondSignalHue.getValue();
    }

    @Override
    public void setSecondSignalHue(float f2) {
        this.secondSignalHue.setValue(f2);
    }

    @Override
    public Tuple3f getFirstColorConversionParam1() {
        return this.firstColorConversionParam1.getValue();
    }

    @Override
    public void setFirstColorConversionParam1(Tuple3f tuple3f) {
        this.firstColorConversionParam1.setValue(tuple3f);
    }

    @Override
    public Tuple3f getFirstColorConversionParam2() {
        return this.firstColorConversionParam2.getValue();
    }

    @Override
    public void setFirstColorConversionParam2(Tuple3f tuple3f) {
        this.firstColorConversionParam2.setValue(tuple3f);
    }

    @Override
    public Tuple3f getFirstColorConversionParam3() {
        return this.firstColorConversionParam3.getValue();
    }

    @Override
    public void setFirstColorConversionParam3(Tuple3f tuple3f) {
        this.firstColorConversionParam3.setValue(tuple3f);
    }

    @Override
    public Tuple3f getSecondColorConversionParam1() {
        return this.secondColorConversionParam1.getValue();
    }

    @Override
    public void setSecondColorConversionParam1(Tuple3f tuple3f) {
        this.secondColorConversionParam1.setValue(tuple3f);
    }

    @Override
    public Tuple3f getSecondColorConversionParam2() {
        return this.secondColorConversionParam2.getValue();
    }

    @Override
    public void setSecondColorConversionParam2(Tuple3f tuple3f) {
        this.secondColorConversionParam2.setValue(tuple3f);
    }

    @Override
    public Tuple3f getSecondColorConversionParam3() {
        return this.secondColorConversionParam3.getValue();
    }

    @Override
    public void setSecondColorConversionParam3(Tuple3f tuple3f) {
        this.secondColorConversionParam3.setValue(tuple3f);
    }
}

