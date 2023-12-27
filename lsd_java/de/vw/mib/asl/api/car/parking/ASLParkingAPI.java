/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.parking;

import de.vw.mib.asl.api.car.parking.ParkingService;
import de.vw.mib.asl.api.car.parking.ParkingServiceListener;

public interface ASLParkingAPI {
    default public ParkingService getParkingService() {
    }

    default public void addParkingServiceListener(ParkingServiceListener parkingServiceListener) {
    }

    default public void removeParkingServiceListener(ParkingServiceListener parkingServiceListener) {
    }
}

