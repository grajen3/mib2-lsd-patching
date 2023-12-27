/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.shape.CubicBezierCurveDrawable;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.widgets.TouchArea;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel$Trajectory;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import java.util.List;

public class TouchAreaUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private static Color4f OFFSCREEN_CLEAR_COLOR = Color4f.BLACK_TRANSPARENT;
    private static boolean TOUCH_TRAJECTORY_POINTS = System.getProperty("de.vw.mib.widgets.trajectoryPoints") != null;
    private static int TRAILING_KNOT_RANGE = 3;
    private static final int CONTROL_POINT_SIZE;
    private static final int KNOT_SIZE;
    private OffscreenDrawable offscreenDrawable;
    private int lastTrajectoryIndex;
    private int lastKnotIndex;
    private Rectangle trajectoryClipArea;
    private RectangleDrawable knotDrawable;
    private RectangleDrawable controlPointDrawable;
    private RectangleDrawable knotLineWidthDrawable;
    private CubicBezierCurveDrawable curveDrawable;

    @Override
    public void init() {
        super.init();
        this.trajectoryClipArea = new Rectangle();
        this.lastTrajectoryIndex = 0;
        this.lastKnotIndex = 0;
        this.getWidget().addPropertyChangedListener(this);
    }

    @Override
    public void deInit() {
        this.getWidget().removePropertyChangedListener(this);
        this.disposeOffscreenDrawable(this.getWidget());
        TouchAreaUI.disposeDrawable(this.controlPointDrawable);
        this.controlPointDrawable = null;
        TouchAreaUI.disposeDrawable(this.curveDrawable);
        this.curveDrawable = null;
        TouchAreaUI.disposeDrawable(this.knotDrawable);
        this.knotDrawable = null;
        TouchAreaUI.disposeDrawable(this.knotLineWidthDrawable);
        this.knotLineWidthDrawable = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        TouchArea touchArea = (TouchArea)this.getWidget();
        if (touchArea.is_showTouchTrajectories()) {
            touchArea.getView().getBounds(this.trajectoryClipArea);
            this.updateOffscreenDrawables(graphics3D, viewModel, touchArea, rectangle, rectangle2);
            if (this.offscreenDrawable != null) {
                this.offscreenDrawable.draw();
            }
            this.paintTouchTrajectories(graphics3D, touchArea, true);
        }
    }

    private void updateOffscreenDrawables(Graphics3D graphics3D, ViewModel viewModel, TouchAreaModel touchAreaModel, Rectangle rectangle, Rectangle rectangle2) {
        boolean bl = touchAreaModel.isRebuildAllTouchTrajectory();
        if (touchAreaModel.isDirty() || this.offscreenDrawable == null || !this.offscreenDrawable.isValid()) {
            int n;
            int n2 = touchAreaModel.get_width();
            if (!TouchAreaUI.isOffscrenTextureValid(this.offscreenDrawable, n2, n = touchAreaModel.get_height())) {
                this.disposeOffscreenDrawable(touchAreaModel);
                this.offscreenDrawable = graphics3D.getDrawableManager().createOffscreenDrawable(n2, n, false);
                this.lastTrajectoryIndex = 0;
                this.lastKnotIndex = 0;
            }
            if (bl || !this.offscreenDrawable.isValid()) {
                this.offscreenDrawable.prepareGraphics(graphics3D, rectangle2, 0, OFFSCREEN_CLEAR_COLOR);
                this.lastTrajectoryIndex = 0;
                this.lastKnotIndex = 0;
                this.paintTouchTrajectories(graphics3D, touchAreaModel, true);
                touchAreaModel.setRebuildTouchTrajectory(false);
            } else {
                this.offscreenDrawable.prepareGraphics(graphics3D, rectangle2, 0, null);
                this.paintTouchTrajectories(graphics3D, touchAreaModel, false);
            }
            this.offscreenDrawable.restoreGraphics(graphics3D, rectangle2);
        }
    }

    private void disposeOffscreenDrawable(WidgetModel widgetModel) {
        if (this.offscreenDrawable != null) {
            this.offscreenDrawable.dispose();
            this.offscreenDrawable = null;
        }
    }

    private static boolean isOffscrenTextureValid(OffscreenDrawable offscreenDrawable, int n, int n2) {
        if (offscreenDrawable == null) {
            return false;
        }
        return offscreenDrawable.getWidth() == n && offscreenDrawable.getHeight() == n2;
    }

    private void paintTouchTrajectories(Graphics3D graphics3D, TouchAreaModel touchAreaModel, boolean bl) {
        List list = touchAreaModel.getTouchTrajectories();
        int n = touchAreaModel.get_touchTrajectoriesLineWidth();
        Image image = touchAreaModel.get_touchTrajectoriesImage();
        if (image != null && !image.getCurrentImage().isEmpty() && list != null) {
            int n2 = list.size();
            for (int i2 = this.lastTrajectoryIndex; i2 < n2; ++i2) {
                int n3;
                int n4;
                TouchAreaModel$Trajectory touchAreaModel$Trajectory = (TouchAreaModel$Trajectory)list.get(i2);
                int n5 = touchAreaModel$Trajectory.getKnotCount();
                if (n5 <= 0) continue;
                if (this.lastTrajectoryIndex < n2 - 1) {
                    n4 = 0;
                    n3 = n5 - 1;
                } else {
                    n4 = this.lastKnotIndex;
                    n3 = Math.max(n5 - 1 - (bl ? 0 : TRAILING_KNOT_RANGE), 0);
                }
                this.paintTouchTrajectory(graphics3D, touchAreaModel$Trajectory, n4, n3, n);
                this.lastTrajectoryIndex = i2;
                this.lastKnotIndex = Math.max(n5 - 1 - TRAILING_KNOT_RANGE, 0);
            }
        }
    }

    private void paintTouchTrajectory(Graphics3D graphics3D, TouchAreaModel$Trajectory touchAreaModel$Trajectory, int n, int n2, int n3) {
        List list = touchAreaModel$Trajectory.getKnots();
        List list2 = touchAreaModel$Trajectory.getControlPointsFirst();
        List list3 = touchAreaModel$Trajectory.getControlPointsSecond();
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        Color4b color4b = touchAreaModel.get_touchTrajectoriesColor().getCurrentColor();
        if (list2 != null && list3 != null) {
            for (int i2 = n; i2 < n2; ++i2) {
                Point2f point2f = (Point2f)list.get(i2);
                Point2f point2f2 = (Point2f)list.get(i2 + 1);
                Point2f point2f3 = (Point2f)list2.get(i2);
                Point2f point2f4 = (Point2f)list3.get(i2);
                this.updateCurveDrawable(graphics3D, touchAreaModel, point2f, point2f3, point2f4, point2f2);
                this.curveDrawable.setColor(color4b);
                this.curveDrawable.draw();
                if (!TOUCH_TRAJECTORY_POINTS) continue;
                this.updateControlPointDrawable(graphics3D, touchAreaModel);
                this.updateKnotDrawable(graphics3D, touchAreaModel);
                this.controlPointDrawable.setColor(Color4f.BLUE);
                this.controlPointDrawable.draw(point2f3.x, point2f3.y);
                this.controlPointDrawable.draw(point2f4.x, point2f4.y);
                this.knotDrawable.setColor(Color4f.RED);
                this.knotDrawable.draw(point2f.x, point2f.y);
                this.knotDrawable.draw(point2f2.x, point2f2.y);
            }
        }
        if (touchAreaModel$Trajectory.isFinished() && list.size() < 2) {
            Point2f point2f = (Point2f)list.get(0);
            int n4 = n3;
            int n5 = n4 >> 1;
            this.updateKnotLineWidthDrawable(graphics3D, touchAreaModel);
            this.knotLineWidthDrawable.setColor(color4b);
            this.knotLineWidthDrawable.draw(point2f.x - (float)n5, point2f.y - (float)n5);
        }
    }

    private void updateControlPointDrawable(Graphics3D graphics3D, TouchAreaModel touchAreaModel) {
        if (this.controlPointDrawable == null) {
            this.controlPointDrawable = TouchAreaUI.updateRectangleDrawable(graphics3D, this.getWidget(), this.controlPointDrawable, 0, 0, 3, 3);
        }
    }

    private void updateKnotDrawable(Graphics3D graphics3D, TouchAreaModel touchAreaModel) {
        if (this.knotDrawable == null) {
            this.knotDrawable = TouchAreaUI.updateRectangleDrawable(graphics3D, touchAreaModel, this.knotDrawable, 0, 0, 5, 5);
        }
    }

    private void updateKnotLineWidthDrawable(Graphics3D graphics3D, TouchAreaModel touchAreaModel) {
        if (this.knotLineWidthDrawable == null) {
            int n = touchAreaModel.get_touchTrajectoriesLineWidth();
            this.knotLineWidthDrawable = TouchAreaUI.updateRectangleDrawable(graphics3D, touchAreaModel, this.knotLineWidthDrawable, 0, 0, n, n);
        }
    }

    private void updateCurveDrawable(Graphics3D graphics3D, TouchAreaModel touchAreaModel, Point2f point2f, Point2f point2f2, Point2f point2f3, Point2f point2f4) {
        int n = touchAreaModel.get_touchTrajectoriesLineWidth();
        Image image = touchAreaModel.get_touchTrajectoriesImage();
        boolean bl = true;
        this.curveDrawable = TouchAreaUI.createBezierCurveDrawable(graphics3D, touchAreaModel, this.curveDrawable, this.trajectoryClipArea, image, n, true);
        this.curveDrawable.setP0(point2f);
        this.curveDrawable.setP1(point2f2);
        this.curveDrawable.setP2(point2f3);
        this.curveDrawable.setP3(point2f4);
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (n == 23) {
            this.lineWidthChanged();
        }
    }

    private void lineWidthChanged() {
        TouchAreaUI.disposeDrawable(this.knotLineWidthDrawable);
        this.knotLineWidthDrawable = null;
    }
}

