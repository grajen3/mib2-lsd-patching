/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query;

import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.BVHScene;
import de.vw.mib.graphics.internal.scene.graph.spatial.bvh.query.AbstractBVHIntersectionQuery;
import de.vw.mib.graphics.math.geometry.BoundingVolume;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.scene.query.AxisAlignedBoxIntersectionQuery;

public final class BVHAxisAlignedBoxIntersectionQuery
extends AbstractBVHIntersectionQuery
implements AxisAlignedBoxIntersectionQuery {
    private final AxisAlignedBox axisAlignedBox = new AxisAlignedBox();

    public BVHAxisAlignedBoxIntersectionQuery(BVHScene bVHScene, int n) {
        super(bVHScene, n);
    }

    public BVHAxisAlignedBoxIntersectionQuery(BVHScene bVHScene, int n, AxisAlignedBox axisAlignedBox) {
        this(bVHScene, n);
        this.axisAlignedBox.set(axisAlignedBox);
    }

    public BVHAxisAlignedBoxIntersectionQuery(BVHScene bVHScene, AxisAlignedBox axisAlignedBox) {
        this(bVHScene, 0, axisAlignedBox);
    }

    @Override
    public AxisAlignedBox getAxisAlignedBox() {
        return this.axisAlignedBox;
    }

    @Override
    public void setAxisAlignedBox(AxisAlignedBox axisAlignedBox) {
        this.axisAlignedBox.set(axisAlignedBox);
    }

    @Override
    protected int intersects(BoundingVolume boundingVolume) {
        return boundingVolume.intersects(this.axisAlignedBox) ? 1 : 2;
    }
}

