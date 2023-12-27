/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.parking;

import de.vw.mib.asl.api.car.parking.ParkingService;

public class NotAvailableParkingService
implements ParkingService {
    @Override
    public boolean isParkingActivated() {
        return false;
    }

    @Override
    public void triggerParking(boolean bl) {
    }
}

