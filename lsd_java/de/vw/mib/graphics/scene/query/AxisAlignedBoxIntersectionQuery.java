/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.scene.query.RegionIntersectionQuery;

public interface AxisAlignedBoxIntersectionQuery
extends RegionIntersectionQuery {
    default public AxisAlignedBox getAxisAlignedBox() {
    }

    default public void setAxisAlignedBox(AxisAlignedBox axisAlignedBox) {
    }
}

