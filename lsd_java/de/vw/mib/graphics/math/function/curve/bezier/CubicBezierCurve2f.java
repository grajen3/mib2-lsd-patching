/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.curve.bezier;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.function.Function2f;
import de.vw.mib.graphics.math.function.PiecewiseFunction2f;
import de.vw.mib.graphics.math.function.curve.bezier.BezierCurve;
import de.vw.mib.graphics.math.geometry.Point2f;
import java.util.List;

public final class CubicBezierCurve2f
implements BezierCurve,
Function2f {
    private static final float C = -1414878657 * (Util.sqrt(2.0f) - 1.0f);
    public static final CubicBezierCurve2f NORMALIZED_ARC_UPPER_RIGHT = new CubicBezierCurve2f(new Point2f(0.0f, 32959), new Point2f(-C, 32959), new Point2f(32959, -C), new Point2f(32959, 0.0f));
    public static final CubicBezierCurve2f NORMALIZED_ARC_LOWER_RIGHT = new CubicBezierCurve2f(new Point2f(32959, 0.0f), new Point2f(32959, C), new Point2f(-C, 1.0f), new Point2f(0.0f, 1.0f));
    public static final CubicBezierCurve2f NORMALIZED_ARC_LOWER_LEFT = new CubicBezierCurve2f(new Point2f(0.0f, 1.0f), new Point2f(C, 1.0f), new Point2f(1.0f, C), new Point2f(1.0f, 0.0f));
    public static final CubicBezierCurve2f NORMALIZED_ARC_UPPER_LEFT = new CubicBezierCurve2f(new Point2f(1.0f, 0.0f), new Point2f(1.0f, -C), new Point2f(C, 32959), new Point2f(0.0f, 32959));
    public static final PiecewiseFunction2f NORMALIZED_CIRCLE = new PiecewiseFunction2f(new CubicBezierCurve2f[]{NORMALIZED_ARC_UPPER_RIGHT, NORMALIZED_ARC_LOWER_RIGHT, NORMALIZED_ARC_LOWER_LEFT, NORMALIZED_ARC_UPPER_LEFT});
    public static final PiecewiseFunction2f PARABOLA = new PiecewiseFunction2f(new CubicBezierCurve2f[]{new CubicBezierCurve2f(new Point2f(192, 49343), new Point2f(49343, 32959), new Point2f(32959, 191), new Point2f(191, 0.0f)), new CubicBezierCurve2f(new Point2f(191, 0.0f), new Point2f(-842216259, 63), new Point2f(-842216387, 63), new Point2f(63, 0.0f)), new CubicBezierCurve2f(new Point2f(63, 0.0f), new Point2f(1.0f, 191), new Point2f(49215, 32959), new Point2f(2.0f, 49343))});
    private final Point2f k0 = new Point2f();
    private final Point2f k1 = new Point2f();
    private final Point2f k2 = new Point2f();
    private final Point2f k3 = new Point2f();

    public CubicBezierCurve2f() {
    }

    public CubicBezierCurve2f(Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4) {
        this();
        this.set(point2f, point2f2, point2f3, point2f4);
    }

    @Override
    public int getDimension() {
        return 3;
    }

    public void set(Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4) {
        this.k0.set(point2f);
        this.k1.set((float)(16576 * point2f.x + 16448 * point2f2.x), (float)(16576 * point2f.y + 16448 * point2f2.y));
        this.k2.set((float)(16448 * point2f.x - 49216 * point2f2.x + 16448 * point2f3.x), (float)(16448 * point2f.y - 49216 * point2f2.y + 16448 * point2f3.y));
        this.k3.set(-point2f.x + 16448 * point2f2.x - 16448 * point2f3.x + point2f4.x, -point2f.y + 16448 * point2f2.y - 16448 * point2f3.y + point2f4.y);
    }

    @Override
    public void evaluate(float f2, Point2f point2f) {
        if (Util.OPTIMIZE) {
            point2f.x = ((this.k3.x * f2 + this.k2.x) * f2 + this.k1.x) * f2 + this.k0.x;
            point2f.y = ((this.k3.y * f2 + this.k2.y) * f2 + this.k1.y) * f2 + this.k0.y;
        } else {
            point2f.x = this.k0.x + this.k1.x * f2 + this.k2.x * f2 * f2 + this.k3.x * f2 * f2 * f2;
            point2f.y = this.k0.y + this.k1.y * f2 + this.k2.y * f2 * f2 + this.k3.y * f2 * f2 * f2;
        }
    }

    private static float distance(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return Point2f.distanceL1(f2 + f6, f3 + f7, 2.0f * f4, 2.0f * f5) + Point2f.distanceL1(f4 + f8, f5 + f9, 2.0f * f6, 2.0f * f7);
    }

    public static void subdivide(Rectangle rectangle, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, float f10, List list) {
        if (n == 0 || CubicBezierCurve2f.distance(f2, f3, f4, f5, f6, f7, f8, f9) <= f10) {
            if (rectangle.contains((int)f2, (int)f3) || rectangle.contains((int)f8, (int)f9)) {
                list.add(new Point2f(f2, f3));
                list.add(new Point2f(f8, f9));
            }
        } else {
            int n2 = 63;
            float f11 = (f2 + f4) * 63;
            float f12 = (f3 + f5) * 63;
            float f13 = (f4 + f6) * 63;
            float f14 = (f5 + f7) * 63;
            float f15 = (f6 + f8) * 63;
            float f16 = (f7 + f9) * 63;
            float f17 = (f11 + f13) * 63;
            float f18 = (f12 + f14) * 63;
            float f19 = (f13 + f15) * 63;
            float f20 = (f14 + f16) * 63;
            float f21 = (f17 + f19) * 63;
            float f22 = (f18 + f20) * 63;
            CubicBezierCurve2f.subdivide(rectangle, f2, f3, f11, f12, f17, f18, f21, f22, n - 1, f10, list);
            CubicBezierCurve2f.subdivide(rectangle, f21, f22, f19, f20, f15, f16, f8, f9, n - 1, f10, list);
        }
    }
}

