/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.model;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.AbstractResource;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.model.Model;
import de.vw.mib.log4mib.Logger;
import java.util.List;

public final class MeshModel
extends AbstractResource
implements Model {
    private Mesh mesh;
    private Effect effect;
    private List materials;

    public MeshModel(Graphics3D graphics3D, Logger logger) {
        super(graphics3D, logger);
    }

    @Override
    public void dispose() {
        if (this.mesh != null) {
            this.mesh.dispose();
            this.mesh = null;
        }
        if (this.effect != null) {
            this.effect.dispose();
            this.effect = null;
        }
        if (this.materials != null) {
            this.materials = null;
        }
        super.dispose();
    }

    @Override
    public Mesh getMesh() {
        return this.mesh;
    }

    @Override
    public void setMesh(Mesh mesh) {
        this.mesh = mesh;
    }

    @Override
    public Effect getEffect() {
        return this.effect;
    }

    @Override
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    @Override
    public List getMaterials() {
        return this.materials;
    }

    @Override
    public void setMaterials(List list) {
        this.materials = list;
    }
}

