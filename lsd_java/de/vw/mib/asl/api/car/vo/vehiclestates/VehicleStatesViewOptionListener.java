/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo.vehiclestates;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.api.car.vo.vehiclestates.VehicleInfoViewOptionsData;

public interface VehicleStatesViewOptionListener {
    default public void updateVINViewOption(CarFunctionState carFunctionState, int n) {
    }

    default public void updateVINDevice(int n) {
    }

    default public void updateVehicleInfoViewOption(VehicleInfoViewOptionsData vehicleInfoViewOptionsData, int n) {
    }

    default public void updateVehicleInfoDevice(int n) {
    }
}

