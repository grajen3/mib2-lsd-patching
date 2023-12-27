/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.animation.target;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.internal.scene.animation.target.AbstractAnimationTarget;
import de.vw.mib.graphics.scene.animation.target.LightAnimationTarget;
import de.vw.mib.graphics.scene.graph.visual.light.AmbientLight;
import de.vw.mib.graphics.scene.graph.visual.light.LightEntity;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;
import de.vw.mib.graphics.scene.graph.visual.light.ReflectiveLight;
import de.vw.mib.graphics.scene.graph.visual.light.SpotLight;
import de.vw.mib.util.StringBuilder;

public final class UnpooledLightAnimationTarget
extends AbstractAnimationTarget
implements LightAnimationTarget {
    private final LightEntity light;

    public UnpooledLightAnimationTarget(int n, int n2, LightEntity lightEntity) {
        super(1, n, n2);
        this.light = lightEntity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",light=").append(this.light);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public Object getTarget() {
        return this.light;
    }

    @Override
    public void setValue(float[] fArray) {
        int n = this.getAttribute();
        int n2 = this.getArrayIndex();
        switch (n) {
            case 1000: {
                AmbientLight ambientLight = (AmbientLight)this.light;
                Color4f color4f = ambientLight.getAmbientColor();
                UnpooledLightAnimationTarget.setValue(color4f, fArray, n2);
                ReflectiveLight reflectiveLight = (ReflectiveLight)this.light;
                Color4f color4f2 = reflectiveLight.getDiffuseColor();
                UnpooledLightAnimationTarget.setValue(color4f2, fArray, n2);
                Color4f color4f3 = reflectiveLight.getSpecularColor();
                UnpooledLightAnimationTarget.setValue(color4f3, fArray, n2);
                break;
            }
            case 1001: {
                AmbientLight ambientLight = (AmbientLight)this.light;
                Color4f color4f = ambientLight.getAmbientColor();
                UnpooledLightAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 1002: {
                ReflectiveLight reflectiveLight = (ReflectiveLight)this.light;
                Color4f color4f = reflectiveLight.getDiffuseColor();
                UnpooledLightAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 1003: {
                ReflectiveLight reflectiveLight = (ReflectiveLight)this.light;
                Color4f color4f = reflectiveLight.getSpecularColor();
                UnpooledLightAnimationTarget.setValue(color4f, fArray, n2);
                break;
            }
            case 1004: {
                PointLight pointLight = (PointLight)this.light;
                float f2 = fArray[0];
                pointLight.setConstantAttenuation(f2);
                break;
            }
            case 1005: {
                PointLight pointLight = (PointLight)this.light;
                float f3 = fArray[0];
                pointLight.setLinearAttenuation(f3);
                break;
            }
            case 1006: {
                PointLight pointLight = (PointLight)this.light;
                float f4 = fArray[0];
                pointLight.setQuadraticAttenuation(f4);
                break;
            }
            case 1007: {
                SpotLight spotLight = (SpotLight)this.light;
                float f5 = fArray[0];
                spotLight.setSpotExponent(f5);
                break;
            }
            case 1008: {
                SpotLight spotLight = (SpotLight)this.light;
                float f6 = fArray[0];
                spotLight.setSpotCutoffAngle(f6);
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid light target attribute");
            }
        }
    }
}

