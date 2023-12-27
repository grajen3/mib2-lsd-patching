/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.vehicle;

import de.vw.mib.asl.api.car.vehicle.VehicleService;

class NotAvailableVehicleService
implements VehicleService {
    NotAvailableVehicleService() {
    }

    @Override
    public boolean isValetParkingActive() {
        return false;
    }

    @Override
    public boolean isValetParkingAvailable() {
        return false;
    }

    @Override
    public int getWarningCount() {
        return 0;
    }

    @Override
    public int getOilLevel() {
        return 0;
    }

    @Override
    public int getOilLevelAvailability() {
        return 0;
    }

    @Override
    public int getOilRefillQuantity() {
        return 0;
    }

    @Override
    public int getOilRefillUnit() {
        return 0;
    }

    @Override
    public int getOilWarning() {
        return 0;
    }

    @Override
    public boolean[] getCarStatusTileSFunctionExistence() {
        return null;
    }

    @Override
    public boolean[] getCarStatusTileSFunctionAvailability() {
        return null;
    }

    @Override
    public int getOilLevelAvailabilityReason() {
        return 0;
    }

    @Override
    public int getRDKAvailabilityReason() {
        return 0;
    }

    @Override
    public boolean[] getSystemState() {
        return new boolean[]{false, false};
    }

    @Override
    public int getCarGearType() {
        return 0;
    }

    @Override
    public int getAutomaticGearShiftTransMode() {
        return 0;
    }

    @Override
    public int getClutchState() {
        return 0;
    }

    @Override
    public int getParkingBrakeState() {
        return 0;
    }

    @Override
    public void updateInitState(boolean bl) {
    }
}

