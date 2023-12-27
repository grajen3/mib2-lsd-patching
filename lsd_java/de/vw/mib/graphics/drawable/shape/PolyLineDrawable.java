/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.shape;

import de.vw.mib.graphics.drawable.shape.LineDrawable;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;

public interface PolyLineDrawable
extends LineDrawable {
    default public Point2f[] getCoordinates2D() {
    }

    default public void setCoordinates2D(Point2f[] point2fArray) {
    }

    default public Point3f[] getCoordinates3D() {
    }

    default public void setCoordinates3D(Point3f[] point3fArray) {
    }

    default public boolean isClosed() {
    }

    default public void setClosed(boolean bl) {
    }
}

