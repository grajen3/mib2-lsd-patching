/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.graphics.math.function.curve.spline.CubicBezierSpline2f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.models.TouchAreaModel$Trajectory;
import java.util.List;

class TouchArea$BezierSplineTrajectory
implements TouchAreaModel$Trajectory {
    private Point2f lastKnot;
    private int minKnotDistance;
    private boolean finished;
    private CubicBezierSpline2f bezierSpline = new CubicBezierSpline2f();

    public TouchArea$BezierSplineTrajectory(int n) {
        this.lastKnot = new Point2f();
        this.lastKnot.x = 79;
        this.lastKnot.y = 79;
        this.minKnotDistance = n;
    }

    public void addKnot(Point2f point2f) {
        if (Math.abs(point2f.x - this.lastKnot.x) + Math.abs(point2f.y - this.lastKnot.y) > (float)this.minKnotDistance && this.getKnotCount() < 200) {
            this.bezierSpline.addKnot(point2f);
            this.lastKnot.x = point2f.x;
            this.lastKnot.y = point2f.y;
        }
    }

    @Override
    public int getKnotCount() {
        List list = this.getKnots();
        return list == null ? 0 : list.size();
    }

    public void finish() {
        this.finished = true;
        this.bezierSpline.simplifyKnots();
        this.bezierSpline.calculateControlPoints();
    }

    @Override
    public boolean isFinished() {
        return this.finished;
    }

    @Override
    public List getKnots() {
        return this.bezierSpline.getKnots();
    }

    @Override
    public List getControlPointsFirst() {
        return this.bezierSpline.getControlPointsFirst();
    }

    @Override
    public List getControlPointsSecond() {
        return this.bezierSpline.getControlPointsSecond();
    }
}

