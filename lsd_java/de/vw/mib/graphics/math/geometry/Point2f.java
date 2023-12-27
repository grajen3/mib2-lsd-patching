/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.geometry;

import de.vw.mib.graphics.math.Tuple2f;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.geometry.Geometry2D;
import de.vw.mib.graphics.math.geometry.Point;

public final class Point2f
extends Tuple2f
implements Point,
Geometry2D {
    private static final long serialVersionUID;

    public Point2f() {
    }

    public Point2f(Tuple2f tuple2f) {
        super(tuple2f);
    }

    public Point2f(float[] fArray) {
        super(fArray);
    }

    public Point2f(float f2, float f3) {
        super(f2, f3);
        this.x = f2;
        this.y = f3;
    }

    public static float distanceL1(float f2, float f3, float f4, float f5) {
        return Math.abs(f4 - f2) + Math.abs(f5 - f3);
    }

    public static float distanceL2(float f2, float f3, float f4, float f5) {
        return Util.sqrt((f4 - f2) * (f4 - f2) + (f5 - f3) * (f5 - f3));
    }

    public static float distanceLinf(float f2, float f3, float f4, float f5) {
        return Math.max(Math.abs(f4 - f2), Math.abs(f5 - f3));
    }

    public float getDistanceToOrigin() {
        return new Vector2f(this).getLength();
    }

    public void transform(Matrix3f matrix3f, Point2f point2f) {
        matrix3f.mul(this, point2f);
    }

    @Override
    public void transform(Matrix3f matrix3f) {
        this.transform(matrix3f, this);
    }
}

