/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal.devices;

import de.vw.mib.input.internal.devices.ProximityInputDeviceHandler;

final class ProximityInputDeviceHandler$SwipeUnLocker
implements Runnable {
    private final /* synthetic */ ProximityInputDeviceHandler this$0;

    public ProximityInputDeviceHandler$SwipeUnLocker(ProximityInputDeviceHandler proximityInputDeviceHandler) {
        this.this$0 = proximityInputDeviceHandler;
    }

    @Override
    public void run() {
        this.this$0.swipeTypeLocked = 0;
    }
}

