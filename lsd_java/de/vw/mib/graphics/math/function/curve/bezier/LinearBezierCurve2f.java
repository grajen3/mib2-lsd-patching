/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.curve.bezier;

import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.curve.bezier.BezierCurve;
import de.vw.mib.graphics.math.geometry.Point2f;

public final class LinearBezierCurve2f
implements BezierCurve,
Function2f {
    private final Point2f k0;
    private final Point2f k1;

    public LinearBezierCurve2f(Point2f point2f, Point2f point2f2) {
        this.k0 = new Point2f(point2f);
        this.k1 = new Point2f(point2f2);
    }

    @Override
    public int getDimension() {
        return 1;
    }

    @Override
    public void evaluate(float f2, Point2f point2f) {
        point2f.x = (1.0f - f2) * this.k0.x + f2 * this.k1.x;
        point2f.y = (1.0f - f2) * this.k0.y + f2 * this.k1.y;
    }
}

