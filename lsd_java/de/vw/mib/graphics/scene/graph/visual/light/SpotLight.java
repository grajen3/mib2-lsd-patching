/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.visual.light;

import de.vw.mib.graphics.scene.graph.visual.light.DirectionalLight;
import de.vw.mib.graphics.scene.graph.visual.light.PointLight;

public interface SpotLight
extends DirectionalLight,
PointLight {
    default public float getSpotExponent() {
    }

    default public void setSpotExponent(float f2) {
    }

    default public float getSpotCutoffAngle() {
    }

    default public void setSpotCutoffAngle(float f2) {
    }
}

