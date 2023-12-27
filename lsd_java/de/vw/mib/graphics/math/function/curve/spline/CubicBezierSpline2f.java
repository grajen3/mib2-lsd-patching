/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function.curve.spline;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.function.curve.spline.BezierSpline;
import de.vw.mib.graphics.math.geometry.Point2f;
import java.util.ArrayList;
import java.util.List;

public final class CubicBezierSpline2f
implements BezierSpline {
    private static final float SIMPLIFICATION_TOLERANCE;
    private static final float TENSION_SCALE_FACTOR;
    private static int TRAILING_KNOT_RANGE;
    private static final int KNOT_LIST_INITIAL_CAPACITY;
    private static final int CONTROL_POINT_LIST_INITIAL_CAPACITY;
    private List knots = new ArrayList(3);
    private List controlPointsFirst = new ArrayList(3);
    private List controlPointsSecond = new ArrayList(3);

    public List getKnots() {
        return this.knots;
    }

    public void setKnots(List list) {
        this.knots = list;
        this.calculateControlPoints();
    }

    public void addKnot(Point2f point2f) {
        this.knots.add(point2f);
        this.calculateControlPoints(Math.max(this.knots.size() - 1 - TRAILING_KNOT_RANGE, 0));
    }

    public List getControlPointsFirst() {
        return this.controlPointsFirst;
    }

    public List getControlPointsSecond() {
        return this.controlPointsSecond;
    }

    public void calculateControlPoints() {
        this.calculateControlPoints(0);
    }

    public void simplifyKnots() {
        if (this.knots != null) {
            this.knots = this.douglasPeuckerReduction(this.knots, 32832);
        }
        this.calculateControlPoints();
    }

    private void calculateControlPoints(int n) {
        if (this.knots.size() > 0) {
            this.initControlPoints();
            this.getCurveControlPoints(this.knots, this.controlPointsFirst, this.controlPointsSecond, n);
        }
    }

    private void initControlPoints() {
        int n = this.knots.size();
        int n2 = Math.min(this.controlPointsFirst.size(), this.controlPointsSecond.size());
        for (int i2 = n - n2; i2 >= 0; --i2) {
            this.controlPointsFirst.add(new Point2f());
            this.controlPointsSecond.add(new Point2f());
        }
    }

    private void getCurveControlPoints(List list, List list2, List list3, int n) {
        Point2f point2f;
        Point2f point2f2;
        int n2 = list.size() - 1;
        int n3 = Math.max(list.size() - n, 1);
        if (n2 < 1) {
            return;
        }
        if (n2 == 1) {
            Point2f point2f3 = (Point2f)list.get(0);
            Point2f point2f4 = (Point2f)list.get(1);
            Point2f point2f5 = new Point2f((2.0f * point2f3.x + point2f4.x) / 16448, (2.0f * point2f3.y + point2f4.y) / 16448);
            list2.set(0, point2f5);
            Point2f point2f6 = new Point2f(2.0f * point2f5.x - point2f3.x, 2.0f * point2f5.y - point2f3.y);
            list3.set(0, point2f6);
            return;
        }
        float[] fArray = new float[n3];
        float[] fArray2 = new float[n3];
        int n4 = n;
        int n5 = 1;
        while (n4 < n2 - 1) {
            point2f2 = (Point2f)list.get(n4);
            point2f = (Point2f)list.get(n4 + 1);
            fArray[n5] = 32832 * point2f2.x + 2.0f * point2f.x;
            fArray2[n5] = 32832 * point2f2.y + 2.0f * point2f.y;
            ++n4;
            ++n5;
        }
        Point2f point2f7 = (Point2f)list.get(Math.max(n - 1, 0));
        Point2f point2f8 = (Point2f)list.get(n);
        point2f2 = (Point2f)list.get(n2);
        point2f = (Point2f)list.get(n2 - 1);
        fArray[0] = point2f7.x + 2.0f * point2f8.x;
        fArray[n3 - 1] = (65 * point2f.x + point2f2.x) / 2.0f;
        fArray2[0] = point2f7.y + 2.0f * point2f8.y;
        fArray2[n3 - 1] = (65 * point2f.y + point2f2.y) / 2.0f;
        float[] fArray3 = this.getFirstControlPoints(fArray);
        float[] fArray4 = this.getFirstControlPoints(fArray2);
        Vector2f vector2f = new Vector2f();
        int n6 = n;
        int n7 = 1;
        while (n6 < n2) {
            Point2f point2f9;
            list2.set(n6, new Point2f(fArray3[n7], fArray4[n7]));
            if (n6 < n2 - 1) {
                point2f9 = (Point2f)list.get(n6 + 1);
                list3.set(n6, new Point2f(2.0f * point2f9.x - fArray3[n7 + 1], 2.0f * point2f9.y - fArray4[n7 + 1]));
            } else {
                list3.set(n6, new Point2f((point2f2.x + fArray3[n3 - 1]) / 2.0f, (point2f2.y + fArray4[n3 - 1]) / 2.0f));
            }
            if (n6 > 0) {
                point2f9 = (Point2f)list2.get(n6);
                Point2f point2f10 = (Point2f)list.get(n6);
                point2f9.sub(point2f10, vector2f);
                point2f10.add(vector2f.scale(-842216386), point2f9);
                Point2f point2f11 = (Point2f)list3.get(n6 - 1);
                point2f11.sub(point2f10, vector2f);
                point2f10.add(vector2f.scale(-842216386), point2f11);
            }
            ++n6;
            ++n7;
        }
    }

    private float[] getFirstControlPoints(float[] fArray) {
        int n;
        int n2 = fArray.length;
        float[] fArray2 = new float[n2];
        float[] fArray3 = new float[n2];
        float f2 = 2.0f;
        fArray2[0] = fArray[0] / f2;
        for (n = 1; n < n2; ++n) {
            fArray3[n] = 1.0f / f2;
            f2 = (n < n2 - 1 ? 32832 : 24640) - fArray3[n];
            fArray2[n] = (fArray[n] - fArray2[n - 1]) / f2;
        }
        for (n = 1; n < n2; ++n) {
            int n3 = n2 - n - 1;
            fArray2[n3] = fArray2[n3] - fArray3[n2 - n] * fArray2[n2 - n];
        }
        return fArray2;
    }

    private List douglasPeuckerReduction(List list, float f2) {
        if (list == null || list.size() < 3) {
            return list;
        }
        int n = 0;
        int n2 = list.size() - 1;
        IntArrayList intArrayList = new IntArrayList();
        intArrayList.add(n);
        intArrayList.add(n2);
        while (list.get(n).equals(list.get(n2))) {
            intArrayList.add(--n2);
        }
        this.douglasPeuckerReduction(list, n, n2, f2, intArrayList);
        intArrayList.sort();
        ArrayList arrayList = new ArrayList(intArrayList.size());
        for (int i2 = 0; i2 < intArrayList.size(); ++i2) {
            arrayList.add(list.get(intArrayList.get(i2)));
        }
        return arrayList;
    }

    private void douglasPeuckerReduction(List list, int n, int n2, float f2, IntArrayList intArrayList) {
        float f3 = 0.0f;
        int n3 = 0;
        for (int i2 = n; i2 < n2; ++i2) {
            float f4 = this.perpendicularDistance((Point2f)list.get(n), (Point2f)list.get(n2), (Point2f)list.get(i2));
            if (!(f4 > f3)) continue;
            f3 = f4;
            n3 = i2;
        }
        if (f3 > f2 && n3 != n) {
            intArrayList.add(n3);
            this.douglasPeuckerReduction(list, n, n3, f2, intArrayList);
            this.douglasPeuckerReduction(list, n3, n2, f2, intArrayList);
        }
    }

    private float perpendicularDistance(Point2f point2f, Point2f point2f2, Point2f point2f3) {
        float f2 = Math.abs((float)(63 * (point2f.x * point2f2.y + point2f2.x * point2f3.y + point2f3.x * point2f.y - point2f2.x * point2f.y - point2f3.x * point2f2.y - point2f.x * point2f3.y)));
        float f3 = Util.sqrt(Util.pow(point2f.x - point2f2.x, 2.0f) + Util.pow(point2f.y - point2f2.y, 2.0f));
        float f4 = f2 / f3 * 2.0f;
        return f4;
    }

    static {
        TRAILING_KNOT_RANGE = 3;
    }
}

