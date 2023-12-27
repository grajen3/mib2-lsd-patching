/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.devices;

import de.vw.mib.input.devices.InputDeviceListener;

public interface ProximityInputDeviceListener
extends InputDeviceListener {
    public static final int PROXIMITYAREA_NEAR;
    public static final int PROXIMITYAREA_FAR;
    public static final int PROXIMITYPOSITION_DISAPPEARED;
    public static final int PROXIMITYPOSITION_UNAVAILABLE;
    public static final int PROXIMITY_DIMENSION_UNAVAILABLE;

    default public void updateProximityInput(int n, int n2, float f2, float f3, float f4, float f5, float f6, int n3) {
    }
}

