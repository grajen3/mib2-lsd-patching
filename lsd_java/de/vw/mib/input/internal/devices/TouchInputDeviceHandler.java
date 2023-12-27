/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal.devices;

import de.vw.mib.input.devices.TouchInputDeviceListener;
import de.vw.mib.input.internal.InputManagerNotifier;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.input.internal.devices.BaseInputDeviceHandler;

public class TouchInputDeviceHandler
extends BaseInputDeviceHandler
implements TouchInputDeviceListener {
    private static final int CLICK_THRESHOLD;
    private int eventType;
    private int x;
    private int y;
    private int param1;
    private int param2;
    private int zDelta;
    private int time;
    private boolean clickThresholdExceeded;
    private int mClickCountPrev;
    private int xInitial;
    private int yInitial;

    public TouchInputDeviceHandler(InputManagerNotifier inputManagerNotifier) {
        super(0, inputManagerNotifier);
    }

    @Override
    public void updateTouchInput(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.calculateEventType(n);
        if (this.eventType == 3 || this.eventType == 4) {
            this.param1 = n3 - this.x;
            this.param2 = n4 - this.y;
        } else {
            this.param1 = n5;
            this.param2 = n6;
        }
        this.x = n3;
        this.y = n4;
        this.time = n7;
        this.zDelta = n5 << 2;
        this.validateClickGesture();
        this.notifyUserInteraction();
        this.transmitEvent();
    }

    private void calculateEventType(int n) {
        switch (n) {
            case 3: {
                this.eventType = 0;
                break;
            }
            case 4: {
                this.eventType = 1;
                break;
            }
            case 1: {
                this.eventType = 2;
                break;
            }
            case 5: {
                this.eventType = 3;
                break;
            }
            case 6: {
                this.eventType = 4;
                break;
            }
            case 7: {
                this.eventType = 5;
                break;
            }
            case 8: {
                this.eventType = 6;
                break;
            }
            case 9: {
                this.eventType = 7;
                break;
            }
            case 10: {
                this.eventType = 8;
                break;
            }
            case 11: {
                this.eventType = 9;
                break;
            }
            case 12: {
                this.eventType = 10;
                break;
            }
            case 14: 
            case 15: {
                TouchInputDeviceHandler.error().append("RAW2/RAW2PLUS gesture code not suppored yet.").log();
                this.eventType = 11;
                break;
            }
            default: {
                TouchInputDeviceHandler.error().append("Unknown gesture code received from touch input device: ").append(n).log();
                this.eventType = 11;
            }
        }
    }

    private void validateClickGesture() {
        switch (this.eventType) {
            case 1: 
            case 6: {
                this.xInitial = this.x;
                this.yInitial = this.y;
                this.clickThresholdExceeded = false;
                break;
            }
            case 2: {
                int n = this.param1;
                if (!(this.clickThresholdExceeded || n != 1 && n - 1 != this.mClickCountPrev)) {
                    this.mClickCountPrev = n;
                    break;
                }
                this.mClickCountPrev = 0;
                this.eventType = 0;
                break;
            }
            case 0: {
                this.mClickCountPrev = 0;
                break;
            }
            default: {
                this.clickThresholdExceeded |= Math.abs(this.xInitial - this.x) > 15 || Math.abs(this.yInitial - this.y) > 15;
            }
        }
    }

    private void notifyUserInteraction() {
        if (this.eventType == 1) {
            if (TouchInputDeviceHandler.isTracingEnabled()) {
                TouchInputDeviceHandler.trace().append("User interaction started by touch input.").log();
            }
            this.inputManagerNotifier.notifyUserInteractionStarted(1, 0);
        } else if (this.eventType == 0 || this.eventType == 2) {
            if (TouchInputDeviceHandler.isTracingEnabled()) {
                TouchInputDeviceHandler.trace().append("User interaction stopped by touch input.").log();
            }
            this.inputManagerNotifier.notifyUserInteractionStopped(1, 0);
        }
    }

    protected void transmitEvent() {
        ServiceManager.gestureEventDispatcher.createAndSubmitTouchEvent(this.eventType, this.x, this.y, this.zDelta, this.param1, this.param2, this.time);
    }
}

