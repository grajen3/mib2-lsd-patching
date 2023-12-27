/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Tuple3f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.graphics.math.algebra.Vector3f;
import de.vw.mib.graphics.math.geometry.Geometry3D;
import de.vw.mib.graphics.math.geometry.Point;

public final class Point3f
extends Tuple3f
implements Point,
Geometry3D {
    private static final long serialVersionUID;

    public Point3f() {
    }

    public Point3f(Tuple3f tuple3f) {
        super(tuple3f);
    }

    public Point3f(Tuple2f tuple2f, float f2) {
        this(tuple2f.x, tuple2f.y, f2);
    }

    public Point3f(float[] fArray) {
        super(fArray);
    }

    public Point3f(float f2, float f3, float f4) {
        super(f2, f3, f4);
    }

    public static float distanceL1(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.abs(f5 - f2) + Math.abs(f6 - f3) + Math.abs(f7 - f4);
    }

    public static float distanceL2(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Util.sqrt((f5 - f2) * (f5 - f2) + (f6 - f3) * (f6 - f3) + (f7 - f4) * (f7 - f4));
    }

    public static float distanceLinf(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Math.max(Math.max(Math.abs(f5 - f2), Math.abs(f6 - f3)), Math.abs(f7 - f4));
    }

    public float getDistanceToOrigin() {
        return new Vector3f(this).getLength();
    }

    public void transform(Matrix4f matrix4f, Point3f point3f) {
        matrix4f.mul(this, point3f);
    }

    @Override
    public void transform(Matrix4f matrix4f) {
        this.transform(matrix4f, this);
    }

    public void transform(Transform transform, Point3f point3f) {
        transform.transform(this, point3f);
    }

    @Override
    public void transform(Transform transform) {
        this.transform(transform, this);
    }
}

