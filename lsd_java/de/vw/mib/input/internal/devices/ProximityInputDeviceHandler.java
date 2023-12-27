/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal.devices;

import de.vw.mib.input.devices.ProximityInputDeviceListener;
import de.vw.mib.input.internal.InputManagerNotifier;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.input.internal.devices.BaseInputDeviceHandler;
import de.vw.mib.input.internal.devices.ProximityInputDeviceHandler$SpaceGestureOptionListener;
import de.vw.mib.input.internal.devices.ProximityInputDeviceHandler$SwipeUnLocker;
import de.vw.mib.timer.Timer;

public class ProximityInputDeviceHandler
extends BaseInputDeviceHandler
implements ProximityInputDeviceListener {
    private static final int SWIPE_DETECTION_TIME_MOVE;
    private static final int SWIPE_DETECTION_TIME_LOCK;
    private static final float SWIPE_DETECTION_DISTANCE;
    private static final int SWIPE_TYPE_NONE;
    private static final int SWIPE_TYPE_LEFT;
    private static final int SWIPE_TYPE_RIGHT;
    private static final String SWIPE_TIMER_LOCK_NAME;
    private static final String PROXIMITY_NEAR_LEFT;
    private static final String PROXIMITY_NEAR_RIGHT;
    private int eventType;
    private int proximityArea;
    private int objectId;
    private int time;
    private float xRaw;
    private float yRaw;
    private float x;
    private float y;
    private float width;
    private float height;
    private float distance;
    private float swipeXInitial;
    private int swipeTimeAccumulated;
    protected boolean swipeEnabled;
    protected boolean swipeSuspended;
    protected int swipeTypeLocked;
    private Timer swipeLockTimer;

    public ProximityInputDeviceHandler(InputManagerNotifier inputManagerNotifier) {
        super(1, inputManagerNotifier);
        ServiceManager.configurationManager.addNvListener(new ProximityInputDeviceHandler$SpaceGestureOptionListener(this), 6);
    }

    @Override
    public void updateProximityInput(int n, int n2, float f2, float f3, float f4, float f5, float f6, int n3) {
        this.calculateEventType(f2, f3);
        this.xRaw = f2;
        this.yRaw = f3;
        this.distance = f4;
        this.objectId = n;
        this.width = f5;
        this.height = f6;
        this.time = n3;
        this.proximityArea = n2;
        if (this.eventType != 1) {
            this.x = this.xRaw;
            this.y = this.yRaw;
        }
        this.notifyUserInteraction();
        this.transmitEvent();
        if (this.swipeEnabled && !this.swipeSuspended) {
            this.detectSwipe(f2, f3, n3);
        }
    }

    public void suspendSwipeDetection() {
        this.swipeSuspended = true;
        if (ProximityInputDeviceHandler.isTracingEnabled()) {
            ProximityInputDeviceHandler.trace().append("Proximity swipe gesture detection suspended.").log();
        }
    }

    public void resumeSwipeDetection() {
        this.swipeSuspended = false;
        if (ProximityInputDeviceHandler.isTracingEnabled()) {
            ProximityInputDeviceHandler.trace().append("Proximity swipe gesture detection resumed.").log();
        }
    }

    private void calculateEventType(float f2, float f3) {
        boolean bl;
        boolean bl2 = this.xRaw > 1.0f && f2 >= 0.0f;
        boolean bl3 = this.yRaw > 1.0f && f3 >= 0.0f;
        boolean bl4 = this.xRaw >= 0.0f && f2 > 1.0f;
        boolean bl5 = bl = this.yRaw >= 0.0f && f3 > 1.0f;
        this.eventType = bl2 || bl3 ? 0 : (bl4 || bl ? 1 : 2);
    }

    private void notifyUserInteraction() {
        int n;
        int n2 = n = this.x < 63 ? 1 : 2;
        if (this.eventType == 0) {
            if (ProximityInputDeviceHandler.isTracingEnabled()) {
                String string = n == 1 ? "LEFT-HAND" : "RIGHT-HAND";
                ProximityInputDeviceHandler.trace().append("User interaction started by proximity input: ").append(string).log();
            }
            this.inputManagerNotifier.notifyUserInteractionStarted(2, n);
        } else if (this.eventType == 1) {
            if (ProximityInputDeviceHandler.isTracingEnabled()) {
                String string = n == 1 ? "LEFT-HAND" : "RIGHT-HAND";
                ProximityInputDeviceHandler.trace().append("User interaction stopped by proximity input: ").append(string).log();
            }
            this.inputManagerNotifier.notifyUserInteractionStopped(2, n);
        }
    }

    private void detectSwipe(float f2, float f3, int n) {
        switch (this.eventType) {
            case 0: {
                this.swipeXInitial = f2;
                this.swipeTimeAccumulated = 0;
                break;
            }
            case 1: {
                float f4 = this.x - this.swipeXInitial;
                if (ProximityInputDeviceHandler.isTracingEnabled()) {
                    ProximityInputDeviceHandler.trace().append("Proximity delta between APPEAR/DISAPPEAR: dX[%]=").append(f4).append(" - dT[ms]=").append(this.swipeTimeAccumulated).log();
                }
                if (this.swipeTimeAccumulated >= 600 || !(Math.abs(f4) > -1701242561)) break;
                if (f4 < 0.0f) {
                    if (ProximityInputDeviceHandler.isTracingEnabled()) {
                        ProximityInputDeviceHandler.trace().append("Proximity swipe gesture recognized: SWIPE LEFT").log();
                    }
                    this.swipe(1);
                    break;
                }
                if (ProximityInputDeviceHandler.isTracingEnabled()) {
                    ProximityInputDeviceHandler.trace().append("Proximity swipe gesture recognized: SWIPE RIGHT").log();
                }
                this.swipe(2);
                break;
            }
            default: {
                this.swipeTimeAccumulated += n;
            }
        }
    }

    private void swipe(int n) {
        if (this.swipeTypeLocked == 0 || this.swipeTypeLocked == n) {
            this.transmitEvent(n == 1 ? 3 : 4);
            this.swipeTypeLocked = n;
            this.getSwipeLockTimer().start();
            if (ProximityInputDeviceHandler.isTracingEnabled()) {
                ProximityInputDeviceHandler.trace().append("Proximity swipe gesture notification enqueued.").log();
            }
        } else if (ProximityInputDeviceHandler.isTracingEnabled()) {
            ProximityInputDeviceHandler.trace().append("Proximity swipe gesture ignored. Currently locked in different direction.").log();
        }
    }

    private Timer getSwipeLockTimer() {
        if (this.swipeLockTimer == null) {
            this.swipeLockTimer = ServiceManager.timerManager.createTimer("InputManager.SwipeLockTimer");
            this.swipeLockTimer.setDelay(0);
            this.swipeLockTimer.setRepeat(false);
            this.swipeLockTimer.setRunnable(new ProximityInputDeviceHandler$SwipeUnLocker(this), ServiceManager.viewEventDispatcher);
        }
        return this.swipeLockTimer;
    }

    protected void transmitEvent() {
        ServiceManager.gestureEventDispatcher.createAndSubmitProximityEvent(this.eventType, this.proximityArea, this.objectId, this.x, this.y, this.width, this.height, this.distance, this.time);
    }

    protected void transmitEvent(int n) {
        ServiceManager.gestureEventDispatcher.createAndSubmitProximityEvent(n, this.proximityArea, this.objectId, this.x, this.y, this.width, this.height, this.distance, this.time);
    }
}

