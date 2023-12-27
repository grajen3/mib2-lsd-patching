/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.phone.ASLPhoneFactory;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.api.system.valetparking.ValetParkingListenerAdapter;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN$1;

class HsmTargetWLAN$ValetParkingListenerWLAN
extends ValetParkingListenerAdapter {
    private final /* synthetic */ HsmTargetWLAN this$0;

    private HsmTargetWLAN$ValetParkingListenerWLAN(HsmTargetWLAN hsmTargetWLAN) {
        this.this$0 = hsmTargetWLAN;
    }

    @Override
    public void notifyValetParkingStateChanged(boolean bl, ValetParkingCallback valetParkingCallback) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("HsmTargetWLAN.ValetParkingListenerWLAN.notifyValetParkingStateChanged() ").append(bl).append(", pre VP WiFi state = ").append(ASLPhoneFactory.getPhoneApi().getPersistence().getPreValetParkingWiFiState()).append(valetParkingCallback == null ? ", callback == null" : "").log();
        }
        this.this$0.stateWLANMain.valetParkingCallback = valetParkingCallback;
        this.this$0.stateWLANMain.switchWLANState(bl);
    }

    /* synthetic */ HsmTargetWLAN$ValetParkingListenerWLAN(HsmTargetWLAN hsmTargetWLAN, HsmTargetWLAN$1 hsmTargetWLAN$1) {
        this(hsmTargetWLAN);
    }
}

