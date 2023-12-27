/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.AbstractBVHIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.query.SphereIntersectionQuery;

public final class BVHSphereIntersectionQuery
extends AbstractBVHIntersectionQuery
implements SphereIntersectionQuery {
    private final Sphere3f sphere = new Sphere3f();

    public BVHSphereIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHSphereIntersectionQuery(BVHScene bVHScene, int n, Sphere3f sphere3f) {
        this(bVHScene, n);
        this.sphere.set(sphere3f);
    }

    public BVHSphereIntersectionQuery(BVHScene bVHScene, Sphere3f sphere3f) {
        this(bVHScene, 0, sphere3f);
    }

    @Override
    public Sphere3f getSphere() {
        return this.sphere;
    }

    @Override
    public void setSphere(Sphere3f sphere3f) {
        this.sphere.set(sphere3f);
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        return boundingVolume.intersects(this.sphere) ? 1 : 2;
    }
}

