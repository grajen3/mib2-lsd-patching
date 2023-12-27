/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.lighting;

import de.vw.mib.graphics.effect.lighting.LightingEffect;
import de.vw.mib.graphics.material.ConstantMaterial;

public interface ConstantLightingEffect
extends LightingEffect {
    default public ConstantMaterial getMaterial() {
    }

    default public void setMaterial(ConstantMaterial constantMaterial) {
    }
}

