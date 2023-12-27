/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.model;

import de.vw.mib.graphics.Resource;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.mesh.Mesh;
import java.util.List;

public interface Model
extends Resource {
    default public Mesh getMesh() {
    }

    default public void setMesh(Mesh mesh) {
    }

    default public Effect getEffect() {
    }

    default public void setEffect(Effect effect) {
    }

    default public List getMaterials() {
    }

    default public void setMaterials(List list) {
    }
}

