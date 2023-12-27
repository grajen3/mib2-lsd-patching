/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.devices;

import de.vw.mib.input.devices.InputDeviceListener;

public interface TouchInputDeviceListener
extends InputDeviceListener {
    public static final int GESTURE_RELEASE;
    public static final int GESTURE_PRESS;
    public static final int GESTURE_TAP;
    public static final int GESTURE_DRAG;
    public static final int GESTURE_FLICK;
    public static final int GESTURE_ROTATE;
    public static final int GESTURE_PRESS2;
    public static final int GESTURE_DRAG2;
    public static final int GESTURE_FLICK2;
    public static final int GESTURE_ZOOM;
    public static final int GESTURE_RIGHTCLICK;
    public static final int GESTURE_RAW2;
    public static final int GESTURE_RAW2PLUS;

    default public void updateTouchInput(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }
}

