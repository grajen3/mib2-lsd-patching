/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import de.vw.mib.graphics.scene.query.RegionIntersectionQuery;

public interface SphereIntersectionQuery
extends RegionIntersectionQuery {
    default public Sphere3f getSphere() {
    }

    default public void setSphere(Sphere3f sphere3f) {
    }
}

