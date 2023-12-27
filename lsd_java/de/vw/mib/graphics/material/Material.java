/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.material;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.material.BlinnMaterial;
import de.vw.mib.graphics.material.ConstantMaterial;
import de.vw.mib.graphics.material.LambertMaterial;
import de.vw.mib.graphics.material.PhongMaterial;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.texture.Texture2D;
import de.vw.mib.graphics.texture.TextureCubeMap;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Material
implements Cloneable,
Serializable,
ConstantMaterial,
LambertMaterial,
PhongMaterial,
BlinnMaterial {
    private static final long serialVersionUID;
    private static final Color4f DEFAULT_AMBIENT_COLOR;
    private static final Color4f DEFAULT_DIFFUSE_COLOR;
    private static final Color4f DEFAULT_SPECULAR_COLOR;
    private static final float DEFAULT_SHININESS;
    private static final Color4f DEFAULT_EMISSIVE_COLOR;
    private static final Color4f DEFAULT_REFLECTIVE_COLOR;
    private static final float DEFAULT_REFLECTIVITY;
    private static final Color4f DEFAULT_TRANSPARENT_COLOR;
    private static final float DEFAULT_TRANSPARENCY;
    private static final float DEFAULT_REFRACTION_INDEX;
    public static final float REFRACTION_INDEX_VACUUM;
    public static final float REFRACTION_INDEX_AIR;
    public static final float REFRACTION_INDEX_WATER;
    public static final float REFRACTION_INDEX_GLASS;
    public static final float REFRACTION_INDEX_PLASTIC;
    public static final float REFRACTION_INDEX_DIAMOND;
    private static HashCodeBuilder hcb;
    private Color4f ambientColor;
    private Texture2D ambientMap;
    private Color4f diffuseColor;
    private Texture2D diffuseMap;
    private Color4f specularColor;
    private Texture2D specularMap;
    private float shininess;
    private Texture2D glossMap;
    private Color4f emissiveColor;
    private Texture2D emissiveMap;
    private Color4f reflectiveColor;
    private TextureCubeMap reflectionMap;
    private float reflectivity;
    private Color4f transparentColor;
    private Texture2D transparentMap;
    private float transparency;
    private float refractionIndex;
    private Texture2D normalMap;

    public Material() {
        this.ambientColor = new Color4f(DEFAULT_AMBIENT_COLOR);
        this.ambientMap = null;
        this.diffuseColor = new Color4f(DEFAULT_DIFFUSE_COLOR);
        this.diffuseMap = null;
        this.specularColor = new Color4f(DEFAULT_SPECULAR_COLOR);
        this.specularMap = null;
        this.emissiveColor = new Color4f(DEFAULT_EMISSIVE_COLOR);
        this.emissiveMap = null;
        this.shininess = 0.0f;
        this.glossMap = null;
        this.reflectiveColor = new Color4f(DEFAULT_REFLECTIVE_COLOR);
        this.reflectionMap = null;
        this.reflectivity = 1.0f;
        this.transparentColor = new Color4f(DEFAULT_TRANSPARENT_COLOR);
        this.transparentMap = null;
        this.transparency = 1.0f;
        this.refractionIndex = 0.0f;
        this.normalMap = null;
    }

    public Material(Color4f color4f, Color4f color4f2, Color4f color4f3, Color4f color4f4, float f2) {
        this.ambientColor = new Color4f(color4f);
        this.ambientMap = null;
        this.diffuseColor = new Color4f(color4f2);
        this.diffuseMap = null;
        this.specularColor = new Color4f(color4f3);
        this.shininess = f2;
        this.glossMap = null;
        this.emissiveColor = new Color4f(color4f4);
        this.emissiveMap = null;
        this.reflectiveColor = new Color4f(DEFAULT_REFLECTIVE_COLOR);
        this.reflectionMap = null;
        this.reflectivity = 1.0f;
        this.transparentColor = new Color4f(DEFAULT_TRANSPARENT_COLOR);
        this.transparentMap = null;
        this.transparency = 1.0f;
        this.refractionIndex = 0.0f;
        this.normalMap = null;
    }

    public Material(Material material) {
        this.ambientColor = new Color4f(material.ambientColor);
        this.ambientMap = material.ambientMap;
        this.diffuseColor = new Color4f(material.diffuseColor);
        this.diffuseMap = material.diffuseMap;
        this.specularColor = new Color4f(material.specularColor);
        this.shininess = material.shininess;
        this.glossMap = material.glossMap;
        this.emissiveColor = new Color4f(material.emissiveColor);
        this.emissiveMap = material.emissiveMap;
        this.reflectiveColor = new Color4f(material.reflectiveColor);
        this.reflectionMap = material.reflectionMap;
        this.reflectivity = material.reflectivity;
        this.transparentColor = new Color4f(material.transparentColor);
        this.transparentMap = material.transparentMap;
        this.transparency = material.transparency;
        this.refractionIndex = material.refractionIndex;
        this.normalMap = material.normalMap;
    }

    public Object clone() {
        try {
            Material material = (Material)super.clone();
            material.ambientColor = (Color4f)this.ambientColor.clone();
            material.diffuseColor = (Color4f)this.diffuseColor.clone();
            material.specularColor = (Color4f)this.specularColor.clone();
            material.emissiveColor = (Color4f)this.emissiveColor.clone();
            material.reflectiveColor = (Color4f)this.reflectiveColor.clone();
            material.transparentColor = (Color4f)this.transparentColor.clone();
            return material;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.ambientColor);
        hcb.append(this.ambientMap);
        hcb.append(this.diffuseColor);
        hcb.append(this.diffuseMap);
        hcb.append(this.specularColor);
        hcb.append(this.shininess);
        hcb.append(this.glossMap);
        hcb.append(this.emissiveColor);
        hcb.append(this.emissiveMap);
        hcb.append(this.reflectiveColor);
        hcb.append(this.reflectionMap);
        hcb.append(this.reflectivity);
        hcb.append(this.transparentColor);
        hcb.append(this.transparentMap);
        hcb.append(this.transparency);
        hcb.append(this.refractionIndex);
        hcb.append(this.normalMap);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Material material = (Material)object;
            if (Util.IDENTITY_EQUALS) {
                return this.ambientColor.equals(material.ambientColor) && this.ambientMap == material.ambientMap && this.diffuseColor.equals(material.diffuseColor) && this.diffuseMap == material.diffuseMap && this.specularColor.equals(material.specularColor) && this.specularMap == material.specularMap && this.shininess == material.shininess && this.glossMap == material.glossMap && this.emissiveColor.equals(material.emissiveColor) && this.emissiveMap == material.emissiveMap && this.reflectiveColor.equals(material.reflectiveColor) && this.reflectionMap == material.reflectionMap && this.reflectivity == material.reflectivity && this.transparentColor.equals(material.transparentColor) && this.transparentMap == material.transparentMap && this.transparency == material.transparency && this.refractionIndex == material.refractionIndex && this.normalMap == material.normalMap;
            }
            if (Util.EXACT_EQUALS) {
                return this.ambientColor.equals(material.ambientColor) && this.ambientMap == material.ambientMap && this.diffuseColor.equals(material.diffuseColor) && this.diffuseMap == material.diffuseMap && this.specularColor.equals(material.specularColor) && this.specularMap == material.specularMap && Float.compare(this.shininess, material.shininess) == 0 && this.glossMap == material.glossMap && this.emissiveColor.equals(material.emissiveColor) && this.emissiveMap == material.emissiveMap && this.reflectiveColor.equals(material.reflectiveColor) && this.reflectionMap == material.reflectionMap && Float.compare(this.reflectivity, material.reflectivity) == 0 && this.transparentColor.equals(material.transparentColor) && this.transparentMap == material.transparentMap && Float.compare(this.transparency, material.transparency) == 0 && Float.compare(this.refractionIndex, material.refractionIndex) == 0 && this.normalMap == material.normalMap;
            }
            return this.ambientColor.equals(material.ambientColor) && this.ambientMap == material.ambientMap && this.diffuseColor.equals(material.diffuseColor) && this.diffuseMap == material.diffuseMap && this.specularColor.equals(material.specularColor) && this.specularMap == material.specularMap && Util.equalsEpsilon(this.shininess, material.shininess) && this.glossMap == material.glossMap && this.emissiveColor.equals(material.emissiveColor) && this.emissiveMap == material.emissiveMap && this.reflectiveColor.equals(material.reflectiveColor) && this.reflectionMap == material.reflectionMap && Util.equalsEpsilon(this.reflectivity, material.reflectivity) && this.transparentColor.equals(material.transparentColor) && this.transparentMap == material.transparentMap && Util.equalsEpsilon(this.transparency, material.transparency) && Util.equalsEpsilon(this.refractionIndex, material.refractionIndex) && this.normalMap == material.normalMap;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[ambientColor=").append(this.ambientColor);
        stringBuilder.append(",ambientMap=").append(this.ambientMap);
        stringBuilder.append(",diffuseColor=").append(this.diffuseColor);
        stringBuilder.append(",diffuseMap=").append(this.diffuseMap);
        stringBuilder.append(",specularColor=").append(this.specularColor);
        stringBuilder.append(",shininess=").append(this.shininess);
        stringBuilder.append(",glossMap=").append(this.glossMap);
        stringBuilder.append(",emissionColor=").append(this.emissiveColor);
        stringBuilder.append(",emissiveMap=").append(this.emissiveMap);
        stringBuilder.append(",reflectiveColor=").append(this.reflectiveColor);
        stringBuilder.append(",reflectionMap=").append(this.reflectionMap);
        stringBuilder.append(",reflectivity=").append(this.reflectivity);
        stringBuilder.append(",transparentColor=").append(this.transparentColor);
        stringBuilder.append(",transparentMap=").append(this.transparentMap);
        stringBuilder.append(",transparency=").append(this.transparency);
        stringBuilder.append(",refractionIndex=").append(this.refractionIndex);
        stringBuilder.append(",normalMap=").append(this.normalMap);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Material material) {
        if (this != material) {
            this.ambientColor.set(material.ambientColor);
            this.ambientMap = material.ambientMap;
            this.diffuseColor.set(material.diffuseColor);
            this.diffuseMap = material.diffuseMap;
            this.specularColor.set(material.specularColor);
            this.specularMap = material.specularMap;
            this.shininess = material.shininess;
            this.glossMap = material.glossMap;
            this.emissiveColor.set(material.emissiveColor);
            this.emissiveMap = material.emissiveMap;
            this.reflectiveColor = material.reflectiveColor;
            this.reflectionMap = material.reflectionMap;
            this.reflectivity = material.reflectivity;
            this.transparentColor.set(material.transparentColor);
            this.transparentMap = material.transparentMap;
            this.transparency = material.transparency;
            this.refractionIndex = material.refractionIndex;
            this.normalMap = material.normalMap;
        }
    }

    @Override
    public Color4f getAmbientColor() {
        return this.ambientColor;
    }

    @Override
    public void setAmbientColor(Color4f color4f) {
        this.ambientColor.set(color4f);
    }

    @Override
    public Texture2D getAmbientMap() {
        return this.ambientMap;
    }

    @Override
    public void setAmbientMap(Texture2D texture2D) {
        this.ambientMap = texture2D;
    }

    @Override
    public Color4f getDiffuseColor() {
        return this.diffuseColor;
    }

    @Override
    public void setDiffuseColor(Color4f color4f) {
        this.diffuseColor.set(color4f);
    }

    @Override
    public Texture2D getDiffuseMap() {
        return this.diffuseMap;
    }

    @Override
    public void setDiffuseMap(Texture2D texture2D) {
        this.diffuseMap = texture2D;
    }

    @Override
    public Color4f getSpecularColor() {
        return this.specularColor;
    }

    @Override
    public void setSpecularColor(Color4f color4f) {
        this.specularColor.set(color4f);
    }

    @Override
    public Texture2D getSpecularMap() {
        return this.specularMap;
    }

    @Override
    public void setSpecularMap(Texture2D texture2D) {
        this.specularMap = texture2D;
    }

    @Override
    public float getShininess() {
        return this.shininess;
    }

    @Override
    public void setShininess(float f2) {
        this.shininess = f2;
    }

    public Texture2D getGlossMap() {
        return this.glossMap;
    }

    public void setGlossMap(Texture2D texture2D) {
        this.glossMap = texture2D;
    }

    @Override
    public Color4f getEmissiveColor() {
        return this.emissiveColor;
    }

    @Override
    public void setEmissiveColor(Color4f color4f) {
        this.emissiveColor.set(color4f);
    }

    @Override
    public Texture2D getEmissiveMap() {
        return this.emissiveMap;
    }

    @Override
    public void setEmissiveMap(Texture2D texture2D) {
        this.emissiveMap = texture2D;
    }

    @Override
    public Color4f getReflectiveColor() {
        return this.reflectiveColor;
    }

    @Override
    public void setReflectiveColor(Color4f color4f) {
        this.reflectiveColor.set(color4f);
    }

    @Override
    public TextureCubeMap getReflectionMap() {
        return this.reflectionMap;
    }

    @Override
    public void setReflectionMap(TextureCubeMap textureCubeMap) {
        this.reflectionMap = textureCubeMap;
    }

    @Override
    public float getReflectivity() {
        return this.reflectivity;
    }

    @Override
    public void setReflectivity(float f2) {
        this.reflectivity = f2;
    }

    @Override
    public Color4f getTransparentColor() {
        return this.transparentColor;
    }

    @Override
    public void setTransparentColor(Color4f color4f) {
        this.transparentColor = color4f;
    }

    @Override
    public Texture2D getTransparentMap() {
        return this.transparentMap;
    }

    @Override
    public void setTransparentMap(Texture2D texture2D) {
        this.transparentMap = texture2D;
    }

    @Override
    public float getTransparency() {
        return this.transparency;
    }

    @Override
    public void setTransparency(float f2) {
        this.transparency = f2;
    }

    public boolean hasTransparency() {
        return this.transparency < 1.0f;
    }

    @Override
    public float getRefractionIndex() {
        return this.refractionIndex;
    }

    @Override
    public void setRefractionIndex(float f2) {
        this.refractionIndex = f2;
    }

    @Override
    public Texture2D getNormalMap() {
        return this.normalMap;
    }

    @Override
    public void setNormalMap(Texture2D texture2D) {
        this.normalMap = texture2D;
    }

    public int getComplexity() {
        return 1;
    }

    static {
        DEFAULT_AMBIENT_COLOR = new Color4f((float)-842249154, (float)-842249154, (float)-842249154, 1.0f);
        DEFAULT_DIFFUSE_COLOR = new Color4f((float)-842249153, (float)-842249153, (float)-842249153, 1.0f);
        DEFAULT_SPECULAR_COLOR = new Color4f(0.0f, 0.0f, 0.0f, 1.0f);
        DEFAULT_EMISSIVE_COLOR = new Color4f(0.0f, 0.0f, 0.0f, 1.0f);
        DEFAULT_REFLECTIVE_COLOR = new Color4f(1.0f, 1.0f, 1.0f, 1.0f);
        DEFAULT_TRANSPARENT_COLOR = new Color4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
}

