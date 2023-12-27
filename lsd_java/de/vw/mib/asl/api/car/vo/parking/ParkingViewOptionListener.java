/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.parking;

import de.vw.mib.asl.api.car.vo.parking.ParkingViewOptionData;

public interface ParkingViewOptionListener {
    default public void updateParkingViewOptions(ParkingViewOptionData parkingViewOptionData, int n) {
    }

    default public void updateParkingDevice(int n) {
    }

    default public void updateParkingFifthCamCoded() {
    }
}

