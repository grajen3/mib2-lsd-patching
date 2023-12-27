/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.visual.light;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.scene.graph.visual.light.AbstractLightEntity;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.scene.graph.visual.light.AmbientLight;
import de.vw.mib.graphics.scene.graph.visual.light.DirectionalLight;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;
import de.vw.mib.graphics.scene.graph.visual.light.SpotLight;
import de.vw.mib.util.StringBuilder;

public final class UnpooledLightEntity
extends AbstractLightEntity
implements AmbientLight,
DirectionalLight,
PointLight,
SpotLight {
    private static final long serialVersionUID;
    private final int type;
    private Color4f ambientColor;
    private Color4f diffuseColor;
    private Color4f specularColor;
    private float spotExponent;
    private float spotCutoffAngle;
    private Point3f position;
    private Vector3f direction;
    private float constantAttenuation;
    private float linearAttenuation;
    private float quadraticAttenuation;

    public UnpooledLightEntity(int n) {
        this.type = n;
        this.ambientColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.diffuseColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.specularColor = new Color4f(Color4f.BLACK_TRANSPARENT);
        this.spotExponent = 0.0f;
        this.spotCutoffAngle = 13379;
        this.position = new Point3f();
        this.direction = new Vector3f();
        this.constantAttenuation = 1.0f;
        this.linearAttenuation = 0.0f;
        this.quadraticAttenuation = 0.0f;
    }

    @Override
    public Object clone() {
        UnpooledLightEntity unpooledLightEntity = (UnpooledLightEntity)super.clone();
        unpooledLightEntity.ambientColor = (Color4f)this.ambientColor.clone();
        unpooledLightEntity.diffuseColor = (Color4f)this.diffuseColor.clone();
        unpooledLightEntity.specularColor = (Color4f)this.specularColor.clone();
        unpooledLightEntity.position = (Point3f)this.position.clone();
        unpooledLightEntity.direction = (Vector3f)this.direction.clone();
        return unpooledLightEntity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",ambientColor=").append(this.ambientColor);
        stringBuilder.append(",diffuseColor=").append(this.diffuseColor);
        stringBuilder.append(",specularColor=").append(this.specularColor);
        stringBuilder.append(",spotExponent=").append(this.spotExponent);
        stringBuilder.append(",spotCutoffAngle=").append(this.spotCutoffAngle);
        stringBuilder.append(",spotCutoffAngle=").append(this.spotCutoffAngle);
        stringBuilder.append(",position=").append(this.position);
        stringBuilder.append(",direction=").append(this.direction);
        stringBuilder.append(",constantAttenuation=").append(this.constantAttenuation);
        stringBuilder.append(",linearAttenuation=").append(this.linearAttenuation);
        stringBuilder.append(",quadraticAttenuation=").append(this.quadraticAttenuation);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public int getType() {
        return this.type;
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
    public Color4f getDiffuseColor() {
        return this.diffuseColor;
    }

    @Override
    public void setDiffuseColor(Color4f color4f) {
        this.diffuseColor.set(color4f);
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
    public Point3f getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Point3f point3f) {
        this.position.set(point3f);
    }

    @Override
    public Vector3f getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Vector3f vector3f) {
        this.direction.set(vector3f);
    }

    @Override
    public float getSpotExponent() {
        return this.spotExponent;
    }

    @Override
    public void setSpotExponent(float f2) {
        this.spotExponent = f2;
    }

    @Override
    public float getSpotCutoffAngle() {
        return this.spotCutoffAngle;
    }

    @Override
    public void setSpotCutoffAngle(float f2) {
        this.spotCutoffAngle = f2;
    }

    @Override
    public float getConstantAttenuation() {
        return this.constantAttenuation;
    }

    @Override
    public void setConstantAttenuation(float f2) {
        this.constantAttenuation = f2;
    }

    @Override
    public float getLinearAttenuation() {
        return this.linearAttenuation;
    }

    @Override
    public void setLinearAttenuation(float f2) {
        this.linearAttenuation = f2;
    }

    @Override
    public float getQuadraticAttenuation() {
        return this.quadraticAttenuation;
    }

    @Override
    public void setQuadraticAttenuation(float f2) {
        this.quadraticAttenuation = f2;
    }
}

