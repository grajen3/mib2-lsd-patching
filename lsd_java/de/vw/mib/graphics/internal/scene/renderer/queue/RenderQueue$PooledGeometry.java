/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.renderer.queue;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.internal.scene.renderer.queue.Geometry;
import de.vw.mib.graphics.material.Material;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.mesh.Mesh;
import de.vw.mib.graphics.mesh.Primitives;
import de.vw.mib.pool.ObjectPool;
import de.vw.mib.pool.PooledObject;
import java.util.List;

final class RenderQueue$PooledGeometry
implements PooledObject,
Disposable,
Geometry {
    private final ObjectPool pool;
    private Mesh mesh;
    private Primitives primitives;
    private Effect effect;
    private Material material;
    private Transform transform;
    private Matrix4f projection;
    private List lights;
    private boolean frontFaceWindingCCW;
    private float sortingDistance;

    public RenderQueue$PooledGeometry(ObjectPool objectPool) {
        this.pool = objectPool;
    }

    @Override
    public void dispose() {
        this.pool.releaseObject(this);
    }

    @Override
    public void backToPool() {
        this.mesh = null;
        this.primitives = null;
        this.effect = null;
        this.material = null;
        this.transform = null;
        this.projection = null;
        this.lights = null;
        this.frontFaceWindingCCW = true;
        this.sortingDistance = 0.0f;
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
    public Primitives getPrimitives() {
        return this.primitives;
    }

    @Override
    public void setPrimitives(Primitives primitives) {
        this.primitives = primitives;
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
    public Material getMaterial() {
        return this.material;
    }

    @Override
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public Transform getTransform() {
        return this.transform;
    }

    @Override
    public void setTransform(Transform transform) {
        this.transform = transform;
    }

    @Override
    public Matrix4f getProjection() {
        return this.projection;
    }

    @Override
    public void setProjection(Matrix4f matrix4f) {
        this.projection = matrix4f;
    }

    @Override
    public List getLights() {
        return this.lights;
    }

    @Override
    public void setLights(List list) {
        this.lights = list;
    }

    @Override
    public boolean getFrontFaceWindingCCW() {
        return this.frontFaceWindingCCW;
    }

    @Override
    public void setFrontFaceWindingCCW(boolean bl) {
        this.frontFaceWindingCCW = bl;
    }

    @Override
    public float getSortingDistance() {
        return this.sortingDistance;
    }

    @Override
    public void setSortingDistance(float f2) {
        this.sortingDistance = f2;
    }
}

