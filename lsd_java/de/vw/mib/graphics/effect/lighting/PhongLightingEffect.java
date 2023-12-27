/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.lighting;

import de.vw.mib.graphics.effect.lighting.LightingEffect;
import de.vw.mib.graphics.material.PhongMaterial;

public interface PhongLightingEffect
extends LightingEffect {
    default public PhongMaterial getMaterial() {
    }

    default public void setMaterial(PhongMaterial phongMaterial) {
    }
}

