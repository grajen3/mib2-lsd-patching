/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.material;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.material.AbstractMaterialManager;
import de.vw.mib.graphics.material.BlinnMaterial;
import de.vw.mib.graphics.material.ConstantMaterial;
import de.vw.mib.graphics.material.LambertMaterial;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.material.PhongMaterial;
import de.vw.mib.log4mib.Logger;

public final class UncachedMaterialManager
extends AbstractMaterialManager {
    public UncachedMaterialManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public Material createMaterial() {
        return new Material();
    }

    @Override
    public ConstantMaterial createConstantMaterial() {
        return this.createMaterial();
    }

    @Override
    public LambertMaterial createLambertMaterial() {
        return this.createMaterial();
    }

    @Override
    public PhongMaterial createPhongMaterial() {
        return this.createMaterial();
    }

    @Override
    public BlinnMaterial createBlinnMaterial() {
        return this.createMaterial();
    }
}

