/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.effect.shader.lighting;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.EffectPerformanceMetrics;
import de.vw.mib.graphics.effect.lighting.PhongLightingEffect;
import de.vw.mib.graphics.internal.effect.shader.ShaderEffectManager;
import de.vw.mib.graphics.internal.effect.shader.TransformNormalShaderEffect;
import de.vw.mib.graphics.internal.effect.shader.variable.BooleanShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.ColorShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float3ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Float4ShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.FloatShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.IntegerShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.Sampler2DShaderEffectVariable;
import de.vw.mib.graphics.internal.effect.shader.variable.SamplerCubeShaderEffectVariable;
import de.vw.mib.graphics.light.Light;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.material.PhongMaterial;
import de.vw.mib.graphics.mesh.VertexFormat;
import de.vw.mib.graphics.shader.VertexAttributeBinding;
import java.util.List;

public final class BlinnPhongLightingShaderEffect
extends TransformNormalShaderEffect
implements PhongLightingEffect {
    private static final boolean PHONG_SHADING = System.getProperty("de.vw.mib.graphics.effect.lighting.disablephongshading") == null;
    public static final int MAX_LIGHTS = Integer.getInteger("de.vw.mib.graphics.effect.lighting.maxlights", 6);
    private static final String DEFINE_NAME_MAX_LIGHTS;
    private static String[] VERTEX_SHADER_FILE_NAMES;
    private static String[] FRAGMENT_SHADER_FILE_NAMES;
    private static final String ATTRIBUTE_NAME_DIFFUSE_TEXCOORD;
    private static final String UNIFORM_NAME_MATERIAL;
    private static final String UNIFORM_NAME_MATERIAL_AMBIENT_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_AMBIENT_MAP;
    private static final String UNIFORM_NAME_MATERIAL_DIFFUSE_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_DIFFUSE_MAP;
    private static final String UNIFORM_NAME_MATERIAL_DIFFUSE_MAP_ENABLE;
    private static final String UNIFORM_NAME_MATERIAL_SPECULAR_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_SPECULAR_EXPONENT;
    private static final String UNIFORM_NAME_MATERIAL_GLOSS_MAP;
    private static final String UNIFORM_NAME_MATERIAL_EMISSIVE_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_EMISSIVE_MAP;
    private static final String UNIFORM_NAME_MATERIAL_REFLECTIVE_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_SPHERE_REFLECTION_MAP;
    private static final String UNIFORM_NAME_MATERIAL_CUBE_REFLECTION_MAP;
    private static final String UNIFORM_NAME_MATERIAL_REFLECTIVITY;
    private static final String UNIFORM_NAME_MATERIAL_TRANSPARENT_COLOR;
    private static final String UNIFORM_NAME_MATERIAL_TRANSPARENT_MAP;
    private static final String UNIFORM_NAME_MATERIAL_TRANSPARENCY;
    private static final String UNIFORM_NAME_MATERIAL_NORMAL_MAP;
    private static final String UNIFORM_NAME_FRESNEL_REFLECTANCE;
    private static final String UNIFORM_NAME_LIGHT;
    private static final String UNIFORM_NAME_LIGHT_AMBIENT_COLOR;
    private static final String UNIFORM_NAME_LIGHT_DIFFUSE_COLOR;
    private static final String UNIFORM_NAME_LIGHT_SPECULAR_COLOR;
    private static final String UNIFORM_NAME_LIGHT_POSITION;
    private static final String UNIFORM_NAME_LIGHT_SPOT_DIRECTION;
    private static final String UNIFORM_NAME_LIGHT_SPOT_EXPONENT;
    private static final String UNIFORM_NAME_LIGHT_SPOT_CUTOFF_ANGLE;
    private static final String UNIFORM_NAME_LIGHT_DISTANCE_ATTENUATION;
    private static final String UNIFORM_NAME_LIGHT_DISTANCE_ATTENUATION_FACTORS;
    private static final String UNIFORM_NAME_LIGHT_COUNT;
    private static final String UNIFORM_NAME_LIGHTING_AMBIENT_COLOR;
    public static final int SAMPLER_DIFFUSE;
    private Material material = new Material(Color4f.BLACK_TRANSPARENT, Color4f.BLACK_TRANSPARENT, Color4f.BLACK_TRANSPARENT, Color4f.BLACK_TRANSPARENT, 0.0f);
    private ColorShaderEffectVariable materialAmbientColor;
    private Sampler2DShaderEffectVariable materialAmbientMap;
    private ColorShaderEffectVariable materialDiffuseColor;
    private Sampler2DShaderEffectVariable materialDiffuseMap;
    private BooleanShaderEffectVariable materialDiffuseMapEnable;
    private ColorShaderEffectVariable materialSpecularColor;
    private FloatShaderEffectVariable materialSpecularExponent;
    private Sampler2DShaderEffectVariable materialGlossMap;
    private ColorShaderEffectVariable materialEmissiveColor;
    private Sampler2DShaderEffectVariable materialEmissiveMap;
    private ColorShaderEffectVariable materialReflectiveColor;
    private Sampler2DShaderEffectVariable materialSphereReflectionMap;
    private SamplerCubeShaderEffectVariable materialCubeReflectionMap;
    private FloatShaderEffectVariable materialReflectivity;
    private ColorShaderEffectVariable materialTransparentColor;
    private Sampler2DShaderEffectVariable materialTransparentMap;
    private FloatShaderEffectVariable materialTransparency;
    private Sampler2DShaderEffectVariable materialNormalMap;
    private FloatShaderEffectVariable fresnelReflectance;
    private Light[] lights;
    private ColorShaderEffectVariable[] lightAmbientColor;
    private ColorShaderEffectVariable[] lightDiffuseColor;
    private ColorShaderEffectVariable[] lightSpecularColor;
    private Float4ShaderEffectVariable[] lightPosition;
    private Float3ShaderEffectVariable[] lightSpotDirection;
    private FloatShaderEffectVariable[] lightSpotExponent;
    private FloatShaderEffectVariable[] lightSpotCutoffAngle;
    private BooleanShaderEffectVariable[] lightDistanceAttenuation;
    private Float3ShaderEffectVariable[] lightDistanceAttenuationFactors;
    private IntegerShaderEffectVariable lightCount;
    private ColorShaderEffectVariable lightingAmbientColor;

    public BlinnPhongLightingShaderEffect(ShaderEffectManager shaderEffectManager) {
        super(shaderEffectManager);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    protected void updateAllocationStatistics(EffectPerformanceMetrics effectPerformanceMetrics, boolean bl) {
        effectPerformanceMetrics.allocatedPhongLightingEffects = effectPerformanceMetrics.allocatedPhongLightingEffects + (bl ? 1 : -1);
    }

    @Override
    protected void getVertexShaderDefines(List list) {
        super.getVertexShaderDefines(list);
        if (!PHONG_SHADING) {
            list.add(BlinnPhongLightingShaderEffect.createDefine("MAX_LIGHTS", MAX_LIGHTS));
        }
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
        if (PHONG_SHADING) {
            list.add(BlinnPhongLightingShaderEffect.createDefine("MAX_LIGHTS", MAX_LIGHTS));
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
        super.getVertexFormat(vertexFormat);
        vertexFormat.addVertexAttribute(3, 2, 3, 0);
    }

    @Override
    protected void getVertexAttributeBinding(VertexAttributeBinding vertexAttributeBinding) {
        super.getVertexAttributeBinding(vertexAttributeBinding);
        vertexAttributeBinding.addBinding(3, 0, "a_diffuseTexCoord");
    }

    @Override
    protected void registerShaderEffectVariables() {
        super.registerShaderEffectVariables();
        this.materialAmbientColor = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "ambientColor"));
        this.materialDiffuseColor = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "diffuseColor"));
        this.materialDiffuseMap = this.addSampler2DShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "diffuseMap"));
        this.materialDiffuseMapEnable = this.addBooleanShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "diffuseMapEnable"));
        this.materialSpecularColor = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "specularColor"));
        this.materialSpecularExponent = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "specularExponent"));
        this.materialEmissiveColor = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "emissiveColor"));
        this.materialReflectiveColor = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "reflectiveColor"));
        this.materialReflectivity = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "reflectivity"));
        this.materialTransparency = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "transparency"));
        this.fresnelReflectance = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructUniformName("u_material", "u_fresnelReflectance"));
        this.lights = new Light[MAX_LIGHTS];
        this.lightAmbientColor = new ColorShaderEffectVariable[MAX_LIGHTS];
        this.lightDiffuseColor = new ColorShaderEffectVariable[MAX_LIGHTS];
        this.lightSpecularColor = new ColorShaderEffectVariable[MAX_LIGHTS];
        this.lightPosition = new Float4ShaderEffectVariable[MAX_LIGHTS];
        this.lightSpotDirection = new Float3ShaderEffectVariable[MAX_LIGHTS];
        this.lightSpotExponent = new FloatShaderEffectVariable[MAX_LIGHTS];
        this.lightSpotCutoffAngle = new FloatShaderEffectVariable[MAX_LIGHTS];
        this.lightDistanceAttenuation = new BooleanShaderEffectVariable[MAX_LIGHTS];
        this.lightDistanceAttenuationFactors = new Float3ShaderEffectVariable[MAX_LIGHTS];
        for (int i2 = 0; i2 < this.lights.length; ++i2) {
            this.lightAmbientColor[i2] = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "ambientColor", i2));
            this.lightDiffuseColor[i2] = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "diffuseColor", i2));
            this.lightSpecularColor[i2] = this.addColorShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "specularColor", i2));
            this.lightPosition[i2] = this.addFloat4ShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "position", i2));
            this.lightSpotDirection[i2] = this.addFloat3ShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "spotDirection", i2));
            this.lightSpotExponent[i2] = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "spotExponent", i2));
            this.lightSpotCutoffAngle[i2] = this.addFloatShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "spotCutoffAngle", i2));
            this.lightDistanceAttenuation[i2] = this.addBooleanShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "distanceAttenuation", i2));
            this.lightDistanceAttenuationFactors[i2] = this.addFloat3ShaderEffectVariable(BlinnPhongLightingShaderEffect.buildStructArrayUniformName("u_light", "attenuationFactors", i2));
        }
        this.lightCount = this.addIntegerShaderEffectVariable("u_lightCount");
        this.lightingAmbientColor = this.addColorShaderEffectVariable("u_lightingAmbientColor");
    }

    @Override
    public List getLights() {
        return null;
    }

    @Override
    public void setLights(List list) {
        int n = list.size();
        if (n > MAX_LIGHTS) {
            n = MAX_LIGHTS;
        }
        for (int i2 = 0; i2 < n; ++i2) {
            Light light = (Light)list.get(i2);
            this.setLight(i2, light);
        }
        this.setLightCount(n);
        this.setLightingAmbientColor(Color4f.BLACK);
    }

    @Override
    public PhongMaterial getMaterial() {
        return this.material;
    }

    @Override
    public void setMaterial(PhongMaterial phongMaterial) {
        if (!this.material.equals(phongMaterial)) {
            boolean bl;
            this.materialAmbientColor.setColor(phongMaterial.getAmbientColor());
            boolean bl2 = bl = phongMaterial.getDiffuseMap() != null;
            if (bl) {
                this.materialDiffuseMap.setSampler(0);
            } else {
                this.materialDiffuseColor.setColor(phongMaterial.getDiffuseColor());
            }
            this.materialDiffuseMapEnable.setValue(bl);
            this.materialSpecularColor.setColor(phongMaterial.getSpecularColor());
            this.materialSpecularExponent.setValue(phongMaterial.getShininess());
            this.materialEmissiveColor.setColor(phongMaterial.getEmissiveColor());
            this.materialReflectiveColor.setColor(phongMaterial.getReflectiveColor());
            this.materialReflectivity.setValue(phongMaterial.getReflectivity());
            this.materialTransparency.setValue(phongMaterial.getTransparency());
            this.fresnelReflectance.setValue(BlinnPhongLightingShaderEffect.calculateFresnelTerm(phongMaterial.getRefractionIndex(), 1.0f));
            this.material.set((Material)phongMaterial);
        }
    }

    private static float calculateFresnelTerm(float f2, float f3) {
        float f4 = f2 / f3;
        return (1.0f - f4) * (1.0f - f4) / ((1.0f + f4) * (1.0f + f4));
    }

    protected Color4f getLightingAmbientColor() {
        return this.lightingAmbientColor.getColor();
    }

    public void setLightingAmbientColor(Color4f color4f) {
        this.lightingAmbientColor.setColor(color4f);
    }

    public void setLight(int n, Light light) {
        if (this.lights[n] == null) {
            this.lights[n] = new Light();
        }
        if (!this.lights[n].equals(light)) {
            boolean bl = light.getConstantAttenuation() != 1.0f && light.getLinearAttenuation() != 0.0f && light.getQuadraticAttenuation() != 0.0f;
            this.lightAmbientColor[n].setColor(light.getAmbientColor());
            this.lightDiffuseColor[n].setColor(light.getDiffuseColor());
            this.lightSpecularColor[n].setColor(light.getSpecularColor());
            this.lightPosition[n].setValue(light.getPosition());
            this.lightSpotDirection[n].setValue(light.getSpotDirection());
            this.lightSpotExponent[n].setValue(light.getSpotExponent());
            this.lightSpotCutoffAngle[n].setValue(light.getSpotCutoffAngle());
            this.lightDistanceAttenuation[n].setValue(bl);
            this.lightDistanceAttenuationFactors[n].setValue(light.getConstantAttenuation(), light.getLinearAttenuation(), light.getQuadraticAttenuation());
            this.lights[n].set(light);
        }
    }

    protected int getLightCount() {
        return this.lightCount.getValue();
    }

    public void setLightCount(int n) {
        this.lightCount.setValue(n);
    }

    static {
        VERTEX_SHADER_FILE_NAMES = new String[]{PHONG_SHADING ? "lighting/BlinnPhongPerFragment" : "lighting/BlinnPhongPerVertex"};
        FRAGMENT_SHADER_FILE_NAMES = new String[]{PHONG_SHADING ? "lighting/PhongShading" : "lighting/GouraudShading"};
    }
}

