/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.asl.internal.system.abtfeatures.DsiKeyPanelListenerAdapter;
import de.vw.mib.asl.internal.system.input.ProximityInputDeviceImpl;

class ProximityInputDeviceImpl$1
extends DsiKeyPanelListenerAdapter {
    private final /* synthetic */ ProximityInputDeviceImpl this$0;

    ProximityInputDeviceImpl$1(ProximityInputDeviceImpl proximityInputDeviceImpl) {
        this.this$0 = proximityInputDeviceImpl;
    }

    @Override
    public void updateAdvancedProximity(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.this$0.notifiyProximityInputListeners(n2, n3, (float)n4 / 51266, (float)n5 / 51266, (float)n6 / 51266, (float)(n7 - 1) / 49216, (float)(n8 - 1) / 49216, n9);
    }
}

