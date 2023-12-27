/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.input.internal.devices;

import de.vw.mib.configuration.NvListener;
import de.vw.mib.input.internal.ServiceManager;
import de.vw.mib.input.internal.devices.ProximityInputDeviceHandler;

final class ProximityInputDeviceHandler$SpaceGestureOptionListener
implements NvListener {
    private final /* synthetic */ ProximityInputDeviceHandler this$0;

    public ProximityInputDeviceHandler$SpaceGestureOptionListener(ProximityInputDeviceHandler proximityInputDeviceHandler) {
        this.this$0 = proximityInputDeviceHandler;
        this.updateSwipeEnabled();
    }

    @Override
    public void notifyNvListener(int n) {
        if (n == 6) {
            this.updateSwipeEnabled();
        }
    }

    private void updateSwipeEnabled() {
        this.this$0.swipeEnabled = ServiceManager.configurationManager.isSpaceGestureAvailable();
    }
}

