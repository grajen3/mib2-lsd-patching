/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.models.OPSModel;
import de.vw.mib.widgets.ui.OPSUI$AbstractTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$BezierTrackDrawer;
import de.vw.mib.widgets.ui.OPSUI$TrackHelper;

final class OPSUI$DefaultBezierTrackDrawer
extends OPSUI$AbstractTrackDrawer
implements OPSUI$BezierTrackDrawer {
    private final Graphics3D g;
    private final CubicBezierCurveDrawable trackCurveDrawable;
    private final OPSModel ops;
    final Rectangle[] trackValues;
    private Point2f trackEndInterpolationPoint;
    private Point2f trackEndPoint;
    private Point2f trackStartingInterpolationPoint;
    private Point2f trackStartingPoint;

    public OPSUI$DefaultBezierTrackDrawer(Graphics3D graphics3D, OPSModel oPSModel, Rectangle[] rectangleArray, CubicBezierCurveDrawable cubicBezierCurveDrawable) {
        super(null);
        this.g = graphics3D;
        this.trackCurveDrawable = cubicBezierCurveDrawable;
        this.trackValues = rectangleArray;
        this.ops = oPSModel;
    }

    @Override
    public void draw(Rectangle rectangle, Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4, float f2) {
        this.trackCurveDrawable.draw();
    }

    private void updateTrackCurveDrawable(Rectangle rectangle, Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4, float f2) {
        this.trackCurveDrawable.setBounds(rectangle);
        this.trackCurveDrawable.setP0(point2f);
        this.trackCurveDrawable.setP1(point2f2);
        this.trackCurveDrawable.setP2(point2f3);
        this.trackCurveDrawable.setP3(point2f4);
        this.trackCurveDrawable.setStrokeWidth(f2);
    }

    private void calculateBezierPoints(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f2 * 63;
        float f9 = TRACK_BEZIER_CIRCLE_APPROX_CONST * (f7 + f8);
        float f10 = f3;
        float f11 = f4 + f7 + f8;
        float f12 = f10 - f9;
        float f13 = f11;
        float f14 = f3 - f7 - f8;
        float f15 = f4;
        float f16 = f14;
        float f17 = f15 + f9;
        if (this.trackStartingPoint == null || this.trackStartingInterpolationPoint == null) {
            this.trackStartingPoint = new Point2f(f10, f11);
            this.trackStartingInterpolationPoint = new Point2f(f12, f13);
        } else {
            this.trackStartingPoint.x = f10;
            this.trackStartingPoint.y = f11;
            this.trackStartingInterpolationPoint.x = f12;
            this.trackStartingInterpolationPoint.y = f13;
        }
        if (this.trackEndPoint == null || this.trackEndInterpolationPoint == null) {
            this.trackEndPoint = new Point2f(f14, f15);
            this.trackEndInterpolationPoint = new Point2f(f16, f17);
        } else {
            this.trackEndPoint.x = f14;
            this.trackEndPoint.y = f15;
            this.trackEndInterpolationPoint.x = f16;
            this.trackEndInterpolationPoint.y = f17;
        }
    }

    @Override
    public void draw(Rectangle rectangle, float f2, float f3, float f4) {
        float f5 = OPSUI$TrackHelper.calculateTrackScaledRadius(this.ops, this.trackValues);
        this.calculateBezierPoints(f2, 0.0f, 0.0f, f3, f4, f5);
        boolean bl = this.ops.is_direction();
        boolean bl2 = this.ops.get_trackDisplay() == 2;
        this.g.pushMatrix(0);
        this.g.translateMatrix(0, f3, f4, 0.0f);
        if (bl) {
            this.g.translateMatrix(0, 0.0f, 2.0f * this.trackEndPoint.y, 0.0f);
            this.g.scaleMatrix(0, 1.0f, 32959, 1.0f);
        }
        this.updateTrackCurveDrawable(rectangle, this.trackStartingPoint, this.trackStartingInterpolationPoint, this.trackEndInterpolationPoint, this.trackEndPoint, f2);
        this.draw(rectangle, this.trackStartingPoint, this.trackStartingInterpolationPoint, this.trackEndInterpolationPoint, this.trackEndPoint, f2);
        if (bl2) {
            this.g.scaleMatrix(0, 32959, 1.0f, 1.0f);
            this.draw(rectangle, this.trackStartingPoint, this.trackStartingInterpolationPoint, this.trackEndInterpolationPoint, this.trackEndPoint, f2);
        }
        this.g.popMatrix(0);
    }
}

