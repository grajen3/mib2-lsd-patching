/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.parking;

import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionListener;

public interface ParkingViewOptionService {
    default public void addListener(ParkingViewOptionListener parkingViewOptionListener) {
    }

    default public void removeListener(ParkingViewOptionListener parkingViewOptionListener) {
    }
}

