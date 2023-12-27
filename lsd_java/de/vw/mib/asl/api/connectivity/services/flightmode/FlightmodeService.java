/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.connectivity.services.flightmode;

import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse;
import de.vw.mib.asl.api.connectivity.services.flightmode.FlightmodeResponse2;

public interface FlightmodeService {
    default public void setFlightmode(boolean bl, FlightmodeResponse2 flightmodeResponse2) {
    }

    default public void setFlightmode(boolean bl, FlightmodeResponse flightmodeResponse) {
    }
}

