/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.material;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.material.BlinnMaterial;
import de.vw.mib.graphics.material.ConstantMaterial;
import de.vw.mib.graphics.material.LambertMaterial;
import de.vw.mib.graphics.material.MaterialManager;
import de.vw.mib.graphics.material.PhongMaterial;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractMaterialManager
extends AbstractResource
implements MaterialManager {
    public AbstractMaterialManager(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public abstract ConstantMaterial createConstantMaterial() {
    }

    @Override
    public abstract LambertMaterial createLambertMaterial() {
    }

    @Override
    public abstract PhongMaterial createPhongMaterial() {
    }

    @Override
    public abstract BlinnMaterial createBlinnMaterial() {
    }
}

