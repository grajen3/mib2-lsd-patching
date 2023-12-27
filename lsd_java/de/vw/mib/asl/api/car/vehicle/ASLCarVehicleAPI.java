/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vehicle;

import de.vw.mib.asl.api.car.vehicle.VehicleService;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListener;

public interface ASLCarVehicleAPI {
    default public VehicleService getVehicleService() {
    }

    default public void addVehicleServiceListener(VehicleServiceListener vehicleServiceListener) {
    }

    default public void removeVehicleServiceListener(VehicleServiceListener vehicleServiceListener) {
    }
}

