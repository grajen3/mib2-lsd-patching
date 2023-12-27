/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.BVHPlaneBoundedVolumeIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.scene.query.FrustumIntersectionQuery;

public final class BVHFrustumIntersectionQuery
extends BVHPlaneBoundedVolumeIntersectionQuery
implements FrustumIntersectionQuery {
    private final Frustumf frustum = new Frustumf();

    public BVHFrustumIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHFrustumIntersectionQuery(BVHScene bVHScene, int n, Frustumf frustumf) {
        this(bVHScene, n);
        this.frustum.set(frustumf);
    }

    public BVHFrustumIntersectionQuery(BVHScene bVHScene, Frustumf frustumf) {
        this(bVHScene, 0, frustumf);
    }

    @Override
    public Frustumf getFrustum() {
        return this.frustum;
    }

    @Override
    public void setFrustum(Frustumf frustumf) {
        this.frustum.set(frustumf);
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        return this.frustum.getIntersection(boundingVolume);
    }
}

