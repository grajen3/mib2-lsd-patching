/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.graphics.math.geometry.Geometry3D;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.Ray3f;
import de.vw.mib.graphics.math.geometry.Volume;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.AxisAlignedBox;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Frustumf;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.OrientedBox;
import de.vw.mib.graphics.math.geometry.quadric.Sphere3f;
import java.util.Iterator;

public interface BoundingVolume
extends Geometry3D,
Volume {
    default public void clear() {
    }

    default public boolean isEmpty() {
    }

    default public void set(BoundingVolume boundingVolume) {
    }

    default public void set(Point3f[] point3fArray) {
    }

    default public void set(Iterator iterator) {
    }

    default public void set(Sphere3f sphere3f) {
    }

    default public void set(AxisAlignedBox axisAlignedBox) {
    }

    default public void set(OrientedBox orientedBox) {
    }

    default public void set(Frustumf frustumf) {
    }

    default public void union(BoundingVolume boundingVolume) {
    }

    default public void union(Point3f point3f) {
    }

    default public void union(float f2, float f3, float f4) {
    }

    default public void union(Point3f[] point3fArray) {
    }

    default public void union(Iterator iterator) {
    }

    default public void union(Sphere3f sphere3f) {
    }

    default public void union(AxisAlignedBox axisAlignedBox) {
    }

    default public void union(OrientedBox orientedBox) {
    }

    default public void union(Frustumf frustumf) {
    }

    default public boolean intersects(BoundingVolume boundingVolume) {
    }

    default public boolean intersects(Point3f point3f) {
    }

    default public boolean intersects(float f2, float f3, float f4) {
    }

    default public boolean intersects(Ray3f ray3f) {
    }

    default public boolean intersects(Plane3f plane3f) {
    }

    default public boolean intersects(Sphere3f sphere3f) {
    }

    default public boolean intersects(AxisAlignedBox axisAlignedBox) {
    }

    default public boolean intersects(OrientedBox orientedBox) {
    }

    default public boolean intersects(Frustumf frustumf) {
    }
}

