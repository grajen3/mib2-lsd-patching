/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.scene.query.IntersectionQuery;

public interface PlaneIntersectionQuery
extends IntersectionQuery {
    default public Plane3f getPlane() {
    }

    default public void setPlane(Plane3f plane3f) {
    }
}

