/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.lighting;

import de.vw.mib.graphics.effect.lighting.LightingEffect;
import de.vw.mib.graphics.material.BlinnMaterial;

public interface BlinnLightingEffect
extends LightingEffect {
    default public BlinnMaterial getMaterial() {
    }

    default public void setMaterial(BlinnMaterial blinnMaterial) {
    }
}

