/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.TouchArea;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultTouchAreaController$1;
import de.vw.mib.widgets.controller.DefaultTouchAreaController$DragEventAccumulator;
import de.vw.mib.widgets.controller.DefaultTouchAreaController$EventAccumulator;
import de.vw.mib.widgets.controller.TouchAreaController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel$ProximityDataStorage;
import de.vw.mib.widgets.models.TouchAreaModel$TouchDataStorage;

public class DefaultTouchAreaController
extends AbstractWidgetController
implements TouchAreaController {
    private static final String TIMER_NAME;
    private static final int TRAJECTORY_RECORDING_STATE_INACTIVE;
    private static final int TRAJECTORY_RECORDING_STATE_ACTIVE;
    private DefaultTouchAreaController$EventAccumulator dragEventAccumulator;
    private DefaultTouchAreaController$EventAccumulator flickEventAccumulator;
    private DefaultTouchAreaController$EventAccumulator zoomEventAccumulator;
    private DefaultTouchAreaController$EventAccumulator rotateEventAccumulator;
    private DefaultTouchAreaController$EventAccumulator drag2EventAccumulator;
    private DefaultTouchAreaController$EventAccumulator flick2EventAccumulator;
    private Point lastTouchPoint;
    protected final Point initialTouchPoint = new Point();
    protected boolean dragThresholdExceededHorizontally;
    protected boolean dragThresholdExceededVertically;
    protected boolean dragThresholdExceeded;
    private int trajectoryRecordingState;
    private Timer longPressTimer = null;
    private boolean press2Cycle = false;

    public DefaultTouchAreaController() {
        this.lastTouchPoint = new Point(-129, -129);
    }

    @Override
    protected void reset() {
        super.reset();
        this.longPressTimer = null;
        this.press2Cycle = false;
    }

    @Override
    public void init() {
        super.init();
        this.trajectoryRecordingState = 0;
        this.zoomEventAccumulator = new DefaultTouchAreaController$EventAccumulator(this, "zoomed");
        this.rotateEventAccumulator = new DefaultTouchAreaController$EventAccumulator(this, "rotated");
        this.dragEventAccumulator = new DefaultTouchAreaController$DragEventAccumulator(this, "dragged");
        this.flickEventAccumulator = new DefaultTouchAreaController$DragEventAccumulator(this, "flicked");
        this.drag2EventAccumulator = new DefaultTouchAreaController$DragEventAccumulator(this, "dragged2");
        this.flick2EventAccumulator = new DefaultTouchAreaController$DragEventAccumulator(this, "flicked2");
    }

    @Override
    public void activate() {
        boolean bl;
        super.activate();
        boolean bl2 = this.getOutEventMapping("dragged") != -1;
        boolean bl3 = this.getOutEventMapping("flicked") != -1;
        boolean bl4 = this.getOutEventMapping("dragged2") != -1;
        boolean bl5 = bl = this.getOutEventMapping("flicked2") != -1;
        if (!bl2) {
            this.dragEventAccumulator = this.flickEventAccumulator;
        }
        if (!bl3) {
            this.flickEventAccumulator = this.dragEventAccumulator;
        }
        if (!bl4) {
            this.drag2EventAccumulator = this.flick2EventAccumulator;
        }
        if (!bl) {
            this.flick2EventAccumulator = this.drag2EventAccumulator;
        }
    }

    @Override
    public int getTouchForwardingMode() {
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        return touchAreaModel.get_touchForwardingMode();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        boolean bl = false;
        if ("clearTouchTrajectories" == string) {
            this.trajectoryRecordingState = 0;
            touchAreaModel.clearTouchTrajectories();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        boolean bl = false;
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        if (touchAreaModel.isStoreProximityData()) {
            this.storeProximityData(proximityEvent);
        }
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        int n;
        int n2;
        boolean bl = false;
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        boolean bl2 = touchAreaModel.is_accumulateEvents();
        boolean bl3 = touchAreaModel.is_absoluteCoordinates();
        int n3 = touchAreaModel.getAbsX();
        int n4 = touchAreaModel.getAbsY();
        if (bl3) {
            n2 = Util.clamp(touchEvent.getX(), n3, n3 + touchAreaModel.get_width());
            n = Util.clamp(touchEvent.getY(), n4, n4 + touchAreaModel.get_height());
        } else {
            n2 = Util.clamp(touchEvent.getX() - n3, 0, touchAreaModel.get_width());
            n = Util.clamp(touchEvent.getY() - n4, 0, touchAreaModel.get_height());
        }
        boolean bl4 = this.handleLongPressTimer(touchAreaModel.get_mode(), touchEvent.getType());
        switch (touchEvent.getType()) {
            case 1: {
                this.dragThresholdExceededHorizontally = false;
                this.dragThresholdExceededVertically = false;
                this.dragThresholdExceeded = false;
                this.initialTouchPoint.setLocation(n2, n);
                this.fireAccumulatedEvents();
                this.fireEvent("pressed", n2, n, 0, 0);
                bl = true;
                break;
            }
            case 6: {
                this.fireAccumulatedEvents();
                this.fireEvent("pressed2", n2, n, touchEvent.getZDelta(), 0);
                bl = true;
                break;
            }
            case 3: {
                if (touchAreaModel.is_dragDeltaRelativeToPress()) {
                    this.dragEventAccumulator.accumulateEvent(n2, n, n2 - this.initialTouchPoint.x, n - this.initialTouchPoint.y);
                    break;
                }
                this.dragEventAccumulator.accumulateEvent(n2, n, touchEvent.getGestureParam1(), touchEvent.getGestureParam2());
                break;
            }
            case 7: {
                this.drag2EventAccumulator.accumulateEvent(n2, n, touchEvent.getZDelta(), 0);
                break;
            }
            case 4: {
                if (touchAreaModel.is_dragDeltaRelativeToPress()) {
                    this.flickEventAccumulator.accumulateEvent(n2, n, n2 - this.initialTouchPoint.x, n - this.initialTouchPoint.y);
                    break;
                }
                this.flickEventAccumulator.accumulateEvent(n2, n, touchEvent.getGestureParam1(), touchEvent.getGestureParam2());
                break;
            }
            case 8: {
                this.flick2EventAccumulator.accumulateEvent(n2, n, touchEvent.getZDelta(), 0);
                break;
            }
            case 10: {
                bl = this.fireAccumulatedEvents();
                this.fireEvent("rightClicked", n2, n, 0, 0);
                break;
            }
            case 5: {
                this.rotateEventAccumulator.accumulateEvent(n2, n, touchEvent.getGestureParam1(), touchEvent.getGestureParam2());
                break;
            }
            case 9: {
                this.zoomEventAccumulator.accumulateEvent(n2, n, touchEvent.getGestureParam1(), touchEvent.getZDelta());
                break;
            }
            case 11: {
                break;
            }
            case 2: {
                bl = this.fireAccumulatedEvents();
                if (this.checkDoubleClicked(touchEvent.getGestureParam1(), n2, n)) {
                    this.fireEvent("doubleClicked", n2, n, 0, 0);
                    break;
                }
                this.fireEvent("clicked", n2, n, touchEvent.getGestureParam1(), 0);
                break;
            }
            case 0: {
                bl = this.fireAccumulatedEvents();
                this.fireEvent("released", n2, n, 0, 0);
                break;
            }
        }
        if (!bl2) {
            bl |= this.fireAccumulatedEvents();
        }
        if (touchAreaModel.is_showTouchTrajectories()) {
            this.storeTouchTrajectories(touchEvent);
        }
        if (touchAreaModel.isStoreTouchData()) {
            this.storeTouchData(touchEvent);
        }
        this.lastTouchPoint.x = touchEvent.getX();
        this.lastTouchPoint.y = touchEvent.getY();
        return bl;
    }

    private boolean checkDoubleClicked(int n, int n2, int n3) {
        return n == 2 && this.isInBounds(this.initialTouchPoint.x, this.initialTouchPoint.y) && this.isInBounds(n2, n3);
    }

    private boolean isInBounds(int n, int n2) {
        if (this.getWidget() != null) {
            Rectangle rectangle = new Rectangle();
            if (!((TouchArea)this.getWidget()).is_absoluteCoordinates()) {
                rectangle.setBounds(0, 0, this.getWidget().get_width(), this.getWidget().get_height());
            } else {
                this.getWidget().getAbsBounds(rectangle);
            }
            return rectangle.contains(n, n2);
        }
        return false;
    }

    private boolean handleLongPressTimer(int n, int n2) {
        if (n == 1) {
            switch (n2) {
                case 1: {
                    if (this.press2Cycle) break;
                    this.startLongPressTimer();
                    return true;
                }
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    this.stopLongPressTimer();
                    this.press2Cycle = true;
                    return true;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    this.stopLongPressTimer();
                    this.press2Cycle = false;
                    return true;
                }
            }
        }
        return false;
    }

    private void startLongPressTimer() {
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        this.longPressTimer = ServiceManager.timerManager.createTimer("DefaultTouchAreaController.longPressTimer", touchAreaModel.get_duration(), false, new DefaultTouchAreaController$1(this), ServiceManager.eventDispatcher);
        this.longPressTimer.start();
    }

    protected void stopLongPressTimer() {
        if (this.longPressTimer != null) {
            this.longPressTimer.stop();
        }
        this.longPressTimer = null;
    }

    private void storeTouchTrajectories(TouchEvent touchEvent) {
        TouchAreaModel touchAreaModel = (TouchAreaModel)this.getWidget();
        int n = touchAreaModel.getAbsX();
        int n2 = touchAreaModel.getAbsY();
        int n3 = touchEvent.getX() - n;
        int n4 = touchEvent.getY() - n2;
        boolean bl = touchAreaModel.isAbsPointInside(touchEvent.getX(), touchEvent.getY());
        boolean bl2 = touchAreaModel.isAbsPointInside(this.lastTouchPoint.x, this.lastTouchPoint.y);
        switch (touchEvent.getType()) {
            case 1: 
            case 10: {
                if (!bl) break;
                touchAreaModel.startTouchTrajectory();
                touchAreaModel.addTouchTrajectoryKnot(new Point2f(n3, n4));
                this.trajectoryRecordingState = 1;
                break;
            }
            case 0: 
            case 2: {
                touchAreaModel.addTouchTrajectoryKnot(new Point2f(n3, n4));
                touchAreaModel.finishTouchTrajectory();
                this.trajectoryRecordingState = 0;
                break;
            }
            case 6: {
                touchAreaModel.finishTouchTrajectory();
                this.trajectoryRecordingState = 0;
                break;
            }
            case 11: {
                touchAreaModel.finishTouchTrajectory();
                this.trajectoryRecordingState = 0;
                break;
            }
            default: {
                if (this.trajectoryRecordingState != 1) break;
                if (bl) {
                    if (!bl2) {
                        int n5 = Util.clamp(this.lastTouchPoint.x - n, 0, touchAreaModel.get_width());
                        int n6 = Util.clamp(this.lastTouchPoint.y - n2, 0, touchAreaModel.get_height());
                        touchAreaModel.startTouchTrajectory();
                        touchAreaModel.addTouchTrajectoryKnot(new Point2f(n5, n6));
                    }
                    touchAreaModel.addTouchTrajectoryKnot(new Point2f(n3, n4));
                    break;
                }
                if (!bl2) break;
                int n7 = Util.clamp(n3, 0, touchAreaModel.get_width());
                int n8 = Util.clamp(n4, 0, touchAreaModel.get_height());
                touchAreaModel.addTouchTrajectoryKnot(new Point2f(n7, n8));
                touchAreaModel.finishTouchTrajectory();
            }
        }
    }

    protected final void fireEvent(String string, int n, int n2, int n3, int n4) {
        if (string != null) {
            int n5;
            int n6;
            TouchArea touchArea = (TouchArea)this.getWidget();
            if (touchArea.is_dragDeltaRelativeToPress() && (string == "dragged" || string == "flicked")) {
                n6 = touchArea.isNormalizeXValues() ? touchArea.normalizeDeltaXValue(n3, true) : n3;
                n5 = touchArea.isNormalizeYValues() ? touchArea.normalizeDeltaYValue(n4, true) : n4;
            } else {
                n6 = touchArea.isNormalizeXValues() ? touchArea.normalizeXValue(n) : n3;
                n5 = touchArea.isNormalizeYValues() ? touchArea.normalizeYValue(n2) : n4;
            }
            this.firePointEvent(string, n, n2, n6, n5);
        }
    }

    protected int getDragThreshold() {
        TouchArea touchArea = (TouchArea)this.getWidget();
        return touchArea.get_dragThreshold();
    }

    protected int getDragThresholdMode() {
        TouchArea touchArea = (TouchArea)this.getWidget();
        return touchArea.get_dragThresholdMode();
    }

    private boolean fireAccumulatedEvents() {
        boolean bl = false;
        bl |= this.dragEventAccumulator.fireEvent();
        bl |= this.flickEventAccumulator.fireEvent();
        bl |= this.drag2EventAccumulator.fireEvent();
        bl |= this.flick2EventAccumulator.fireEvent();
        bl |= this.zoomEventAccumulator.fireEvent();
        return bl |= this.rotateEventAccumulator.fireEvent();
    }

    private void storeTouchData(TouchEvent touchEvent) {
        TouchArea touchArea = (TouchArea)this.getWidget();
        TouchAreaModel$TouchDataStorage touchAreaModel$TouchDataStorage = touchArea.getTouchDataStorage();
        touchAreaModel$TouchDataStorage.x = touchEvent.getX();
        touchAreaModel$TouchDataStorage.y = touchEvent.getY();
        touchAreaModel$TouchDataStorage.gestureParam1 = touchEvent.getGestureParam1();
        touchAreaModel$TouchDataStorage.gestureParam2 = touchEvent.getGestureParam2();
        touchAreaModel$TouchDataStorage.time = touchEvent.getTimestamp();
        touchAreaModel$TouchDataStorage.type = touchEvent.getType();
        touchArea.repaint();
    }

    private void storeProximityData(ProximityEvent proximityEvent) {
        TouchArea touchArea = (TouchArea)this.getWidget();
        TouchAreaModel$ProximityDataStorage touchAreaModel$ProximityDataStorage = touchArea.getProximityDataStorage();
        touchAreaModel$ProximityDataStorage.x = proximityEvent.getX();
        touchAreaModel$ProximityDataStorage.y = proximityEvent.getY();
        touchAreaModel$ProximityDataStorage.width = proximityEvent.getWidth();
        touchAreaModel$ProximityDataStorage.height = proximityEvent.getHeight();
        touchAreaModel$ProximityDataStorage.distance = proximityEvent.getDistance();
        touchAreaModel$ProximityDataStorage.time = proximityEvent.getTimestamp();
        touchAreaModel$ProximityDataStorage.type = proximityEvent.getType();
        touchAreaModel$ProximityDataStorage.proximityArea = proximityEvent.getProximityArea();
        touchAreaModel$ProximityDataStorage.objectId = proximityEvent.getObjectId();
        touchArea.repaint();
    }
}

