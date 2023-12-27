/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.NotYetImplementedException;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.AbstractBVHIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.scene.query.PlaneBoundedVolumeIntersectionQuery;

public class BVHPlaneBoundedVolumeIntersectionQuery
extends AbstractBVHIntersectionQuery
implements PlaneBoundedVolumeIntersectionQuery {
    private Plane3f[] planes;

    public BVHPlaneBoundedVolumeIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHPlaneBoundedVolumeIntersectionQuery(BVHScene bVHScene, int n, Plane3f[] plane3fArray) {
        this(bVHScene, n);
        this.planes = plane3fArray;
    }

    public BVHPlaneBoundedVolumeIntersectionQuery(BVHScene bVHScene, Plane3f[] plane3fArray) {
        this(bVHScene, 0, plane3fArray);
    }

    @Override
    public final Plane3f[] getPlanes() {
        return this.planes;
    }

    @Override
    public final void setPlanes(Plane3f[] plane3fArray) {
        this.planes = plane3fArray;
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        if (this.planes != null) {
            for (int i2 = 0; i2 < this.planes.length; ++i2) {
                Plane3f plane3f = this.planes[i2];
            }
            throw new NotYetImplementedException();
        }
        return 2;
    }
}

