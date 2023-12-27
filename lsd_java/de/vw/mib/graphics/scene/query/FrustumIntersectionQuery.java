/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.scene.query.PlaneBoundedVolumeIntersectionQuery;

public interface FrustumIntersectionQuery
extends PlaneBoundedVolumeIntersectionQuery {
    default public Frustumf getFrustum() {
    }

    default public void setFrustum(Frustumf frustumf) {
    }
}

