/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.query;

import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.scene.query.IntersectionQuery;

public interface RayIntersectionQuery
extends IntersectionQuery {
    default public Ray3f getRay() {
    }

    default public void setRay(Ray3f ray3f) {
    }
}

