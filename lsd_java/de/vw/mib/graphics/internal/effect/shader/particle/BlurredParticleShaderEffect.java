/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.particle;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.particle.BlurredParticleEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.image.ImageShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float2ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float4ShaderEffectVariable;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple4f;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public class BlurredParticleShaderEffect
extends ImageShaderEffect
implements BlurredParticleEffect {
    private static final int ANIMATION_START1_SET;
    private static final int ANIMATION_START2_SET;
    private static final int ANIMATION_END1_SET;
    private static final int ANIMATION_END2_SET;
    private static String[] VERTEX_SHADER_FILE_NAMES;
    private static String[] FRAGMENT_SHADER_FILE_NAMES;
    public static final String ATTRIBUTE_NAME_ANIMATION_START1;
    public static final String ATTRIBUTE_NAME_ANIMATION_START2;
    public static final String ATTRIBUTE_NAME_ANIMATION_END1;
    public static final String ATTRIBUTE_NAME_ANIMATION_END2;
    private static final String UNIFORM_NAME_TINT_COLOR;
    public static final String[] UNIFORM_NAMES_ATTRIBUTE_START_VALUES;
    public static final String[] UNIFORM_NAMES_ATTRIBUTE_END_VALUES;
    public static final String[] UNIFORM_NAMES_ATTRIBUTE_ANIMATION_VALUES;
    private static final String UNIFORM_NAME_GEONETRY_CENTER;
    public static final int ATTRIBUTE_COUNT;
    private Tuple4f[] attributeStartValues;
    private Tuple4f[] attributeEndValues;
    private Tuple4f[] attributeAnimationValues;
    private Float4ShaderEffectVariable[] attributeStartValuesShaderEffectVariables;
    private Float4ShaderEffectVariable[] attributeEndValuesShaderEffectVariables;
    private Float4ShaderEffectVariable[] attributeAnimationValuesShaderEffectVariables;
    private Float2ShaderEffectVariable geometryCenter;
    private ColorShaderEffectVariable tintColor;

    public BlurredParticleShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedBlurredParticleEffects = effectPerformanceMetrics.allocatedBlurredParticleEffects + (bl ? 1 : -1);
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
    protected void getVertexFormat(VertexFormat vertexFormat) {
        vertexFormat.addVertexAttribute(3, 3, 0);
        vertexFormat.addVertexAttribute(3, 4, 2, 0);
        vertexFormat.addVertexAttribute(3, 4, 2, 1);
        vertexFormat.addVertexAttribute(3, 4, 2, 2);
        vertexFormat.addVertexAttribute(3, 4, 2, 3);
        vertexFormat.addVertexAttribute(3, 4, 2, 4);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        vertexAttributeBinding.addBinding(2, 1, "a_animationStart1");
        vertexAttributeBinding.addBinding(2, 2, "a_animationStart2");
        vertexAttributeBinding.addBinding(2, 3, "a_animationEnd1");
        vertexAttributeBinding.addBinding(2, 4, "a_animationEnd2");
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.tintColor = this.addColorShaderEffectVariable("u_tintColor");
        this.attributeStartValuesShaderEffectVariables = new Float4ShaderEffectVariable[4];
        this.attributeEndValuesShaderEffectVariables = new Float4ShaderEffectVariable[4];
        this.attributeAnimationValuesShaderEffectVariables = new Float4ShaderEffectVariable[4];
        this.geometryCenter = this.addFloat2ShaderEffectVariable("u_geometryCenter");
        for (int i2 = 0; i2 < 4; ++i2) {
            this.attributeStartValuesShaderEffectVariables[i2] = this.addFloat4ShaderEffectVariable(UNIFORM_NAMES_ATTRIBUTE_START_VALUES[i2]);
            this.attributeEndValuesShaderEffectVariables[i2] = this.addFloat4ShaderEffectVariable(UNIFORM_NAMES_ATTRIBUTE_END_VALUES[i2]);
            this.attributeAnimationValuesShaderEffectVariables[i2] = this.addFloat4ShaderEffectVariable(UNIFORM_NAMES_ATTRIBUTE_ANIMATION_VALUES[i2]);
        }
    }

    @Override
    public Tuple4f[] getAttributeStartValues() {
        return this.attributeStartValues;
    }

    @Override
    public void setAttributeStartValues(Tuple4f[] tuple4fArray) {
        this.attributeStartValues = tuple4fArray;
        for (int i2 = 0; i2 < tuple4fArray.length; ++i2) {
            this.attributeStartValuesShaderEffectVariables[i2].setValue(tuple4fArray[i2]);
        }
    }

    @Override
    public Tuple4f[] getAttributeEndValues() {
        return this.attributeEndValues;
    }

    @Override
    public void setAttributeEndValues(Tuple4f[] tuple4fArray) {
        this.attributeEndValues = tuple4fArray;
        for (int i2 = 0; i2 < tuple4fArray.length; ++i2) {
            this.attributeEndValuesShaderEffectVariables[i2].setValue(tuple4fArray[i2]);
        }
    }

    @Override
    public Tuple4f[] getAttributeAnimationValues() {
        return this.attributeAnimationValues;
    }

    @Override
    public void setAttributeAnimationValues(Tuple4f[] tuple4fArray) {
        this.attributeAnimationValues = tuple4fArray;
        for (int i2 = 0; i2 < tuple4fArray.length; ++i2) {
            this.attributeAnimationValuesShaderEffectVariables[i2].setValue(tuple4fArray[i2]);
        }
    }

    @Override
    public Tuple2f getGeometryCenter() {
        return this.geometryCenter.getValue();
    }

    @Override
    public void setGeometryCenter(Tuple2f tuple2f) {
        this.geometryCenter.setValue(tuple2f);
    }

    @Override
    public Color4f getTintColor() {
        return this.tintColor.getColor();
    }

    @Override
    public void setTintColor(Color4f color4f) {
        this.tintColor.setColor(color4f);
    }

    static {
        VERTEX_SHADER_FILE_NAMES = new String[]{"particle/BlurredParticle"};
        FRAGMENT_SHADER_FILE_NAMES = new String[]{"particle/BlurredParticleHeightMap"};
        UNIFORM_NAMES_ATTRIBUTE_START_VALUES = new String[]{"u_attributeStartValues1", "u_attributeStartValues2", "u_attributeStartValues3", "u_attributeStartValues4"};
        UNIFORM_NAMES_ATTRIBUTE_END_VALUES = new String[]{"u_attributeEndValues1", "u_attributeEndValues2", "u_attributeEndValues3", "u_attributeEndValues4"};
        UNIFORM_NAMES_ATTRIBUTE_ANIMATION_VALUES = new String[]{"u_attributeAnimationValues1", "u_attributeAnimationValues2", "u_attributeAnimationValues3", "u_attributeAnimationValues4"};
    }
}

