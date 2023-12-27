/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import java.util.List;

public interface Geometry {
    default public Mesh getMesh() {
    }

    default public void setMesh(Mesh mesh) {
    }

    default public Primitives getPrimitives() {
    }

    default public void setPrimitives(Primitives primitives) {
    }

    default public Effect getEffect() {
    }

    default public void setEffect(Effect effect) {
    }

    default public Material getMaterial() {
    }

    default public void setMaterial(Material material) {
    }

    default public Transform getTransform() {
    }

    default public void setTransform(Transform transform) {
    }

    default public Matrix4f getProjection() {
    }

    default public void setProjection(Matrix4f matrix4f) {
    }

    default public List getLights() {
    }

    default public void setLights(List list) {
    }

    default public boolean getFrontFaceWindingCCW() {
    }

    default public void setFrontFaceWindingCCW(boolean bl) {
    }

    default public float getSortingDistance() {
    }

    default public void setSortingDistance(float f2) {
    }
}

