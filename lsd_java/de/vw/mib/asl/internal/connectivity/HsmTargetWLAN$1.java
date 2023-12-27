/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse;
import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse2;
import de.vw.mib.asl.internal.connectivity.HsmTargetWLAN;

class HsmTargetWLAN$1
implements FlightmodeResponse2 {
    private final /* synthetic */ FlightmodeResponse val$callback;
    private final /* synthetic */ HsmTargetWLAN this$0;

    HsmTargetWLAN$1(HsmTargetWLAN hsmTargetWLAN, FlightmodeResponse flightmodeResponse) {
        this.this$0 = hsmTargetWLAN;
        this.val$callback = flightmodeResponse;
    }

    @Override
    public void responseSetFlightmode(boolean bl, int n) {
        this.val$callback.responseSetFlightmode(n);
    }
}

