/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.lighting;

import de.vw.mib.graphics.effect.lighting.LightingEffect;
import de.vw.mib.graphics.material.LambertMaterial;

public interface LambertLightingEffect
extends LightingEffect {
    default public LambertMaterial getMaterial() {
    }

    default public void setMaterial(LambertMaterial lambertMaterial) {
    }
}

