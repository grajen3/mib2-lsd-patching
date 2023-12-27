/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.scene.query.RegionIntersectionQuery;

public interface PlaneBoundedVolumeIntersectionQuery
extends RegionIntersectionQuery {
    default public Plane3f[] getPlanes() {
    }

    default public void setPlanes(Plane3f[] plane3fArray) {
    }
}

