/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;
import org.dsi.ifc.androidauto2.TouchEvent;

public class GestureHandler {
    public String classname = "ANDROIDAUTO.GestureHandler";
    private AndroidAutoTarget target;
    private StartupHandler startupHandler;
    private boolean actionDown;
    private boolean pointerDown;
    private int canvasWidthResolution;
    private int canvasHeightResolution;
    boolean mapHorizontal = true;
    private final int ANDROID_AUTO_RIGHT_ICON_BAR_WIDTH;

    public GestureHandler(AndroidAutoTarget androidAutoTarget, StartupHandler startupHandler, int n, int n2) {
        this.ANDROID_AUTO_RIGHT_ICON_BAR_WIDTH = 120;
        this.target = androidAutoTarget;
        this.startupHandler = startupHandler;
        this.canvasWidthResolution = n;
        this.canvasHeightResolution = n2;
        this.actionDown = false;
        this.pointerDown = false;
    }

    public void handleTouchEventGesture(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        switch (n7) {
            case 0: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C0_PRESSED at posX = ").append(n).append("; posY = ").append(n2).toString());
                }
                this.handleGesturePressed(n, n2);
                break;
            }
            case 1: 
            case 2: {
                if (this.target.isTraceEnabled()) {
                    if (n7 == 1) {
                        this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C1_RELEASED at posX = ").append(n).append("; posY = ").append(n2).toString());
                    } else {
                        this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C2_CLICKED at posX = ").append(n).append("; posY = ").append(n2).toString());
                    }
                }
                this.handleGestureRelease(n, n2);
                break;
            }
            case 3: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C3_DRAGGED at posX = ").append(n).append("; posY = ").append(n2).toString());
                }
                this.handleGestureDrag(n, n2);
                break;
            }
            case 4: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C4_ZOOMED at posX = ").append(n).append("; posY = ").append(n2).append("; fingerDistance = ").append(n5).toString());
                }
                this.handleGestureWith2Fingers(n, n2, this.calculateDistanceToMidPoint(n5));
                break;
            }
            case 5: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C5_PRESSED2 at posX = ").append(n).append("; posY = ").append(n2).append("; fingerDistance = ").append(n5).toString());
                }
                this.handleGesturePressed2(n, n2, this.calculateDistanceToMidPoint(n5));
                break;
            }
            case 6: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("case ASLAndroidAutoSetter.TOUCH_EVENT_GESTURE__GESTURETYPE__C6_DRAGGED2 at posX = ").append(n).append("; posY = ").append(n2).append("; fingerDistance = ").append(n5).toString());
                }
                this.handleGestureWith2Fingers(n, n2, this.calculateDistanceToMidPoint(n5));
                break;
            }
        }
    }

    private void handleGestureRelease(int n, int n2) {
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n, n2, 0)};
        if (this.isPointerDown()) {
            if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
                this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 6, 0);
            }
            this.setPointerDown(false);
        }
        if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
            this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 1, 0);
        }
        this.setActionDown(false);
    }

    private void handleGesturePressed(int n, int n2) {
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n, n2, 0)};
        if (this.isPointerDown()) {
            if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
                this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 1, 0);
            }
            this.setActionDown(false);
            this.setPointerDown(false);
        } else {
            if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
                this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 0, 0);
                if (this.target.isTraceEnabled()) {
                    this.target.trace(new StringBuffer().append("handleGesturePressed( ").append(touchEventArray[0].toString()).append(" )").toString());
                }
            }
            this.setActionDown(true);
        }
    }

    private void handleGesturePressed2(int n, int n2, int n3) {
        TouchEvent[] touchEventArray;
        TouchEvent touchEvent;
        TouchEvent touchEvent2;
        if (n + n3 < this.canvasWidthResolution - 120) {
            touchEvent2 = new TouchEvent(this.limitPosXtoResolution(n - n3), n2, 0);
            touchEvent = new TouchEvent(this.limitPosXtoResolution(n + n3), n2, 1);
            this.mapHorizontal = true;
        } else {
            touchEvent2 = new TouchEvent(n, this.limitPosYtoResolution(n2 - n3), 0);
            touchEvent = new TouchEvent(n, this.limitPosYtoResolution(n2 + n3), 1);
            this.mapHorizontal = false;
        }
        if (!this.isActionDown()) {
            touchEventArray = new TouchEvent[]{touchEvent2};
            if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
                this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 0, 0);
            }
            this.setActionDown(true);
        }
        touchEventArray = new TouchEvent[]{touchEvent2, touchEvent};
        if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
            this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 5, 1);
            this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 2, 0);
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("handleGesturePressed2( ").append(touchEventArray[0].toString()).append(", ").append(touchEventArray[1].toString()).append(" )").toString());
        }
        this.setPointerDown(true);
    }

    private void handleGestureDrag(int n, int n2) {
        TouchEvent[] touchEventArray = new TouchEvent[]{new TouchEvent(n, n2, 0)};
        if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
            this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 2, 0);
        }
    }

    private void handleGestureWith2Fingers(int n, int n2, int n3) {
        TouchEvent touchEvent;
        TouchEvent touchEvent2;
        if (this.mapHorizontal) {
            touchEvent2 = new TouchEvent(this.limitPosXtoResolution(n - n3), n2, 0);
            touchEvent = new TouchEvent(this.limitPosXtoResolution(n + n3), n2, 1);
        } else {
            touchEvent2 = new TouchEvent(n, this.limitPosYtoResolution(n2 - n3), 0);
            touchEvent = new TouchEvent(n, this.limitPosYtoResolution(n2 + n3), 1);
        }
        TouchEvent[] touchEventArray = new TouchEvent[]{touchEvent2, touchEvent};
        if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
            this.target.getDSIAndroidAuto2().postTouchEvent(1, touchEventArray, 2, 0);
        }
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("handle2FingerGesture( ").append(touchEventArray[0].toString()).append(", ").append(touchEventArray[1].toString()).append(" )").toString());
        }
    }

    private int calculateDistanceToMidPoint(int n) {
        return n / 2;
    }

    private int limitPosXtoResolution(int n) {
        return Math.min(Math.max(n, 0), this.canvasWidthResolution);
    }

    private int limitPosYtoResolution(int n) {
        return Math.min(Math.max(n, 0), this.canvasHeightResolution);
    }

    private void setPointerDown(boolean bl) {
        this.pointerDown = bl;
    }

    private boolean isPointerDown() {
        return this.pointerDown;
    }

    private void setActionDown(boolean bl) {
        this.actionDown = bl;
    }

    private boolean isActionDown() {
        return this.actionDown;
    }
}

