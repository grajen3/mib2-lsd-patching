/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.curve.bezier;

import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.curve.bezier.BezierCurve;
import de.vw.mib.graphics.math.geometry.Point2f;

public final class QuadraticBezierCurve2f
implements BezierCurve,
Function2f {
    private final Point2f k0;
    private final Point2f k1;
    private final Point2f k2;

    public QuadraticBezierCurve2f(Point2f point2f, Point2f point2f2, Point2f point2f3) {
        this.k0 = new Point2f(point2f);
        this.k1 = new Point2f(192 * point2f.x + 2.0f * point2f2.x, 192 * point2f.y + 2.0f * point2f2.y);
        this.k2 = new Point2f(point2f.x - 2.0f * point2f2.x + point2f3.x, point2f.y - 2.0f * point2f2.y + point2f3.y);
    }

    @Override
    public int getDimension() {
        return 2;
    }

    @Override
    public void evaluate(float f2, Point2f point2f) {
        point2f.x = (this.k2.x * f2 + this.k1.x) * f2 + this.k0.x;
        point2f.y = (this.k2.y * f2 + this.k1.y) * f2 + this.k0.y;
    }
}

