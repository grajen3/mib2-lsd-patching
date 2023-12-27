/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry.polytope.polyhedron;

import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Plane3f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.graphics.math.geometry.polytope.polygon.Rectangle3f;
import de.vw.mib.graphics.math.geometry.polytope.polyhedron.Hexahedron;

public interface Box
extends Hexahedron {
    default public void set(Point3f point3f, Vector3f vector3f) {
    }

    default public void getCenter(Point3f point3f) {
    }

    default public void setCenter(Point3f point3f) {
    }

    default public void getExtents(Vector3f vector3f) {
    }

    default public void setExtents(Vector3f vector3f) {
    }

    default public void getMin(Point3f point3f) {
    }

    default public void setMin(Point3f point3f) {
    }

    default public void setMin(float f2, float f3, float f4) {
    }

    default public void getMax(Point3f point3f) {
    }

    default public void setMax(Point3f point3f) {
    }

    default public void setMax(float f2, float f3, float f4) {
    }

    default public void set(Point3f point3f, Point3f point3f2) {
    }

    default public void getVertex(int n, Point3f point3f) {
    }

    default public void getFace(int n, Plane3f plane3f) {
    }

    default public void getFace(int n, Rectangle3f rectangle3f) {
    }
}

