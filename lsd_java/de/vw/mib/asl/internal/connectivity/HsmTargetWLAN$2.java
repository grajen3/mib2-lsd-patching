/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse2;
import de.vw.mib.asl.api.system.valetparking.ValetParkingCallback;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN;

class HsmTargetWLAN$2
implements ValetParkingCallback {
    private final /* synthetic */ FlightmodeResponse2 val$callback;
    private final /* synthetic */ HsmTargetWLAN this$0;

    HsmTargetWLAN$2(HsmTargetWLAN hsmTargetWLAN, FlightmodeResponse2 flightmodeResponse2) {
        this.this$0 = hsmTargetWLAN;
        this.val$callback = flightmodeResponse2;
    }

    @Override
    public void notifyValetParkingTransitionFinished(boolean bl) {
        this.val$callback.responseSetFlightmode(bl, HsmTargetWLAN.access$100(this.this$0));
    }
}

