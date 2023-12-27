/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.material;

import de.vw.mib.graphics.material.BlinnMaterial;
import de.vw.mib.graphics.material.ConstantMaterial;
import de.vw.mib.graphics.material.LambertMaterial;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.material.PhongMaterial;

public interface MaterialManager {
    default public Material createMaterial() {
    }

    default public ConstantMaterial createConstantMaterial() {
    }

    default public LambertMaterial createLambertMaterial() {
    }

    default public PhongMaterial createPhongMaterial() {
    }

    default public BlinnMaterial createBlinnMaterial() {
    }
}

