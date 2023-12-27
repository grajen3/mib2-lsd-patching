/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.light;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.algebra.Vector4f;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Light
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private static HashCodeBuilder hcb;
    private Color4f ambientColor;
    private Color4f diffuseColor;
    private Color4f specularColor;
    private Vector4f position;
    private Vector3f spotDirection;
    private float spotExponent;
    private float spotCutoffAngle;
    private float constantAttenuation;
    private float linearAttenuation;
    private float quadraticAttenuation;

    public Light() {
        this.ambientColor = new Color4f(Color4f.BLACK);
        this.diffuseColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.specularColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.position = new Vector4f(0.0f, 0.0f, 1.0f, 0.0f);
        this.spotDirection = new Vector3f(0.0f, 0.0f, 32959);
        this.spotExponent = 0.0f;
        this.spotCutoffAngle = 13379;
        this.constantAttenuation = 1.0f;
        this.linearAttenuation = 0.0f;
        this.quadraticAttenuation = 0.0f;
    }

    public Light(Color4f color4f, Color4f color4f2, Color4f color4f3, Vector4f vector4f) {
        this(color4f, color4f2, color4f3, vector4f, new Vector3f(), 0.0f, 0.0f);
    }

    public Light(Color4f color4f, Color4f color4f2, Color4f color4f3, Vector4f vector4f, Vector3f vector3f, float f2, float f3) {
        this.ambientColor = new Color4f(color4f);
        this.diffuseColor = new Color4f(color4f2);
        this.specularColor = new Color4f(color4f3);
        this.position = new Vector4f(vector4f);
        this.spotDirection = new Vector3f(vector3f);
        this.spotExponent = f2;
        this.spotCutoffAngle = f3;
    }

    public Light(Light light) {
        this.ambientColor = new Color4f(light.ambientColor);
        this.diffuseColor = new Color4f(light.diffuseColor);
        this.specularColor = new Color4f(light.specularColor);
        this.position = new Vector4f(light.position);
        this.spotDirection = new Vector3f(light.spotDirection);
        this.spotExponent = light.spotExponent;
        this.spotCutoffAngle = light.spotCutoffAngle;
        this.constantAttenuation = light.constantAttenuation;
        this.linearAttenuation = light.linearAttenuation;
        this.quadraticAttenuation = light.quadraticAttenuation;
    }

    public Object clone() {
        try {
            Light light = (Light)super.clone();
            light.ambientColor = (Color4f)this.ambientColor.clone();
            light.diffuseColor = (Color4f)this.diffuseColor.clone();
            light.specularColor = (Color4f)this.specularColor.clone();
            light.position = (Vector4f)this.position.clone();
            light.spotDirection = (Vector3f)this.spotDirection.clone();
            return light;
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
        hcb.append(this.diffuseColor);
        hcb.append(this.specularColor);
        hcb.append(this.position);
        hcb.append(this.spotDirection);
        hcb.append(this.spotExponent);
        hcb.append(this.spotCutoffAngle);
        hcb.append(this.constantAttenuation);
        hcb.append(this.linearAttenuation);
        hcb.append(this.quadraticAttenuation);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Light light = (Light)object;
            if (Util.IDENTITY_EQUALS) {
                return this.ambientColor.equals(light.ambientColor) && this.diffuseColor.equals(light.diffuseColor) && this.specularColor.equals(light.specularColor) && this.position.equals(light.position) && this.spotDirection.equals(light.spotDirection) && this.spotExponent == light.spotExponent && this.spotCutoffAngle == light.spotCutoffAngle && this.constantAttenuation == light.constantAttenuation && this.linearAttenuation == light.linearAttenuation && this.quadraticAttenuation == light.quadraticAttenuation;
            }
            if (Util.EXACT_EQUALS) {
                return this.ambientColor.equals(light.ambientColor) && this.diffuseColor.equals(light.diffuseColor) && this.specularColor.equals(light.specularColor) && this.position.equals(light.position) && this.spotDirection.equals(light.spotDirection) && Float.compare(this.spotExponent, light.spotExponent) == 0 && Float.compare(this.spotCutoffAngle, light.spotCutoffAngle) == 0 && Float.compare(this.constantAttenuation, light.constantAttenuation) == 0 && Float.compare(this.linearAttenuation, light.linearAttenuation) == 0 && Float.compare(this.quadraticAttenuation, light.quadraticAttenuation) == 0;
            }
            return this.ambientColor.equals(light.ambientColor) && this.diffuseColor.equals(light.diffuseColor) && this.specularColor.equals(light.specularColor) && this.position.equals(light.position) && this.spotDirection.equals(light.spotDirection) && Util.equalsEpsilon(this.spotExponent, light.spotExponent) && Util.equalsEpsilon(this.spotCutoffAngle, light.spotCutoffAngle) && Util.equalsEpsilon(this.constantAttenuation, light.constantAttenuation) && Util.equalsEpsilon(this.linearAttenuation, light.linearAttenuation) && Util.equalsEpsilon(this.quadraticAttenuation, light.quadraticAttenuation);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[ambient=").append(this.ambientColor);
        stringBuilder.append(",diffuse=").append(this.diffuseColor);
        stringBuilder.append(",specular=").append(this.specularColor);
        stringBuilder.append(",position=").append(this.position);
        stringBuilder.append(",spotDirection=").append(this.spotDirection);
        stringBuilder.append(",spotExponent=").append(this.spotExponent);
        stringBuilder.append(",spotCutoffAngle=").append(this.spotCutoffAngle);
        stringBuilder.append(",constantAttenuation=").append(this.constantAttenuation);
        stringBuilder.append(",linearAttenuation=").append(this.linearAttenuation);
        stringBuilder.append(",quadraticAttenuation=").append(this.quadraticAttenuation);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void set(Light light) {
        if (this != light) {
            this.ambientColor.set(light.ambientColor);
            this.diffuseColor.set(light.diffuseColor);
            this.specularColor.set(light.specularColor);
            this.position.set(light.position);
            this.spotDirection.set(light.spotDirection);
            this.spotExponent = light.spotExponent;
            this.spotCutoffAngle = light.spotCutoffAngle;
            this.constantAttenuation = light.constantAttenuation;
            this.linearAttenuation = light.linearAttenuation;
            this.quadraticAttenuation = light.quadraticAttenuation;
        }
    }

    public boolean isPointLight() {
        return this.position.w != 0.0f;
    }

    public boolean isDirectionalLight() {
        return this.position.w == 0.0f;
    }

    public boolean isSpotLight() {
        return this.isPointLight() && this.spotCutoffAngle != 13379;
    }

    public Color4f getAmbientColor() {
        return this.ambientColor;
    }

    public void setAmbientColor(Color4f color4f) {
        this.ambientColor.set(color4f);
    }

    public Color4f getDiffuseColor() {
        return this.diffuseColor;
    }

    public void setDiffuseColor(Color4f color4f) {
        this.diffuseColor.set(color4f);
    }

    public Color4f getSpecularColor() {
        return this.specularColor;
    }

    public void setSpecularColor(Color4f color4f) {
        this.specularColor.set(color4f);
    }

    public Vector4f getPosition() {
        return this.position;
    }

    public void setPosition(Vector4f vector4f) {
        this.position.set(vector4f);
    }

    public Vector3f getSpotDirection() {
        return this.spotDirection;
    }

    public void setSpotDirection(Vector3f vector3f) {
        this.spotDirection.set(vector3f);
    }

    public float getSpotExponent() {
        return this.spotExponent;
    }

    public void setSpotExponent(float f2) {
        this.spotExponent = f2;
    }

    public float getSpotCutoffAngle() {
        return this.spotCutoffAngle;
    }

    public void setSpotCutoffAngle(float f2) {
        this.spotCutoffAngle = f2;
    }

    public float getConstantAttenuation() {
        return this.constantAttenuation;
    }

    public void setConstantAttenuation(float f2) {
        this.constantAttenuation = f2;
    }

    public float getLinearAttenuation() {
        return this.linearAttenuation;
    }

    public void setLinearAttenuation(float f2) {
        this.linearAttenuation = f2;
    }

    public float getQuadraticAttenuation() {
        return this.quadraticAttenuation;
    }

    public void setQuadraticAttenuation(float f2) {
        this.quadraticAttenuation = f2;
    }

    public void setAttenuation(float f2, float f3, float f4) {
        this.constantAttenuation = f2;
        this.linearAttenuation = f3;
        this.quadraticAttenuation = f4;
    }
}

