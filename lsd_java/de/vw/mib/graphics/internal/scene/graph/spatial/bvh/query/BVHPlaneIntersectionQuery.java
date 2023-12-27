/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.AbstractBVHIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.scene.query.PlaneIntersectionQuery;

public final class BVHPlaneIntersectionQuery
extends AbstractBVHIntersectionQuery
implements PlaneIntersectionQuery {
    private final Plane3f plane = new Plane3f();

    public BVHPlaneIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHPlaneIntersectionQuery(BVHScene bVHScene, int n, Plane3f plane3f) {
        this(bVHScene, n);
        this.plane.set(plane3f);
    }

    public BVHPlaneIntersectionQuery(BVHScene bVHScene, Plane3f plane3f) {
        this(bVHScene, 0, plane3f);
    }

    @Override
    public Plane3f getPlane() {
        return this.plane;
    }

    @Override
    public void setPlane(Plane3f plane3f) {
        this.plane.set(plane3f);
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        return boundingVolume.intersects(this.plane) ? 1 : 2;
    }
}

