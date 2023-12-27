/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.AbstractBVHIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.scene.query.RayIntersectionQuery;

public final class BVHRayIntersectionQuery
extends AbstractBVHIntersectionQuery
implements RayIntersectionQuery {
    private final Ray3f ray = new Ray3f();

    public BVHRayIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHRayIntersectionQuery(BVHScene bVHScene, int n, Ray3f ray3f) {
        this(bVHScene, n);
        this.ray.set(ray3f);
    }

    public BVHRayIntersectionQuery(BVHScene bVHScene, Ray3f ray3f) {
        this(bVHScene, 0, ray3f);
    }

    @Override
    public Ray3f getRay() {
        return this.ray;
    }

    @Override
    public void setRay(Ray3f ray3f) {
        this.ray.set(ray3f);
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        return boundingVolume.intersects(this.ray) ? 1 : 2;
    }
}

