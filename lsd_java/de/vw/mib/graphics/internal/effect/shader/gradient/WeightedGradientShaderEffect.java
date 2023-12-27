/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.gradient.WeightedGradientEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageTransformationShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorArrayShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatArrayShaderEffectVariable;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public final class WeightedGradientShaderEffect
extends ImageTransformationShaderEffect
implements WeightedGradientEffect {
    private static final String[] VERTEX_SHADER_FILE_NAMES = new String[]{"TransformMultiTextureGradient"};
    private static final String[] FRAGMENT_SHADER_FILE_NAMES = new String[]{"gradient/WeightedGradient"};
    private static final String UNIFORM_NAME_COLORS;
    private static final String UNIFORM_NAME_COLOR_TRANSITIONS;
    private static final String UNIFORM_NAME_COLOR_POSITIONS;
    private static final String UNIFORM_NAME_IMAGE_BLENDING_COLOR;
    private static final int MAX_IMAGE_COUNT;
    private final boolean textureEnabled;
    private final int gradientDepth;
    private final int imageBlendingMode;
    private ColorShaderEffectVariable imageBlendingColor;
    private ColorArrayShaderEffectVariable colors;
    private FloatArrayShaderEffectVariable colorTransitions;
    private FloatArrayShaderEffectVariable colorPositions;

    public WeightedGradientShaderEffect(ShaderEffectManager shaderEffectManager, int n, int n2, boolean bl) {
        super(shaderEffectManager);
        this.textureEnabled = bl;
        this.gradientDepth = n2;
        this.imageBlendingMode = n;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedWeightedGradientEffects = effectPerformanceMetrics.allocatedWeightedGradientEffects + (bl ? 1 : -1);
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
        String string;
        super.getFragmentShaderDefines(list);
        switch (this.imageBlendingMode) {
            case 4: {
                string = "COLOR_COMBINATION_ADD";
                break;
            }
            case 2: {
                string = "COLOR_COMBINATION_DECAL";
                break;
            }
            case 1: {
                string = "COLOR_COMBINATION_REPLACE";
                break;
            }
            case 3: {
                string = "COLOR_COMBINATION_BLEND";
                break;
            }
            default: {
                string = "COLOR_COMBINATION_MODULATE";
            }
        }
        list.add(WeightedGradientShaderEffect.createDefine("GRADIENT_DEPTH", this.gradientDepth));
        if (this.textureEnabled) {
            list.add(WeightedGradientShaderEffect.createDefine("TEXTURE_ENABLED"));
        }
        list.add(WeightedGradientShaderEffect.createDefine(string));
    }

    @Override
    protected void getFragmentShaderFilenames(List list) {
        for (int i2 = 0; i2 < FRAGMENT_SHADER_FILE_NAMES.length; ++i2) {
            list.add(FRAGMENT_SHADER_FILE_NAMES[i2]);
        }
    }

    @Override
    protected void getVertexFormat(VertexFormat vertexFormat) {
        super.getVertexFormat(vertexFormat);
        vertexFormat.addVertexAttribute(3, 2, 3, 1);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        vertexAttributeBinding.addBinding(3, 1, "a_texCoord1");
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.imageBlendingColor = this.addColorShaderEffectVariable("u_imageSamplerBlendingColor");
        this.colors = this.addColorArrayShaderEffectVariable(WeightedGradientShaderEffect.buildArrayUniformName("u_gradientColors"), this.gradientDepth);
        this.colorPositions = this.addFloatArrayShaderEffectVariable(WeightedGradientShaderEffect.buildArrayUniformName("u_gradientColorPositions"), this.gradientDepth);
        this.colorTransitions = this.addFloatArrayShaderEffectVariable(WeightedGradientShaderEffect.buildArrayUniformName("u_gradientColorTransitions"), this.gradientDepth - 1);
    }

    @Override
    public int getMaximumImageLayerCount() {
        return 1;
    }

    @Override
    public int getImageSampler(int n) {
        return this.getImageSampler();
    }

    @Override
    public void setImageSampler(int n, int n2) {
        if (n == 0) {
            this.setImageSampler(n2);
        }
    }

    @Override
    public int getImageBlending() {
        return this.imageBlendingMode;
    }

    @Override
    public void setImageBlending(int n) {
    }

    @Override
    public Color4f getImageBlendingColor() {
        return this.imageBlendingColor.getColor();
    }

    @Override
    public void setImageBlendingColor(Color4f color4f) {
        this.imageBlendingColor.setColor(color4f);
    }

    @Override
    public Color4f[] getColors() {
        return this.colors.getValue();
    }

    @Override
    public void setColors(Color4f[] color4fArray) {
        this.colors.setValue(color4fArray);
    }

    @Override
    public float[] getColorTransitions() {
        return this.colorTransitions.getValue();
    }

    @Override
    public void setColorTransitions(float[] fArray) {
        this.colorTransitions.setValue(fArray);
    }

    @Override
    public float[] getColorPositions() {
        return this.colorPositions.getValue();
    }

    @Override
    public void setColorPositions(float[] fArray) {
        this.colorPositions.setValue(fArray);
    }
}

