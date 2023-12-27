/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vehicle;

public interface VehicleServiceListener {
    default public void updateValetParkingActive(boolean bl) {
    }

    default public void updateValetParkingAvailable(boolean bl) {
    }

    default public void updateOilLevel(int n) {
    }

    default public void updateOilLevelAvailability(int n) {
    }

    default public void updateOilRefillQuantity(int n) {
    }

    default public void updateOilRefillUnit(int n) {
    }

    default public void updateOilWarning(int n) {
    }

    default public void updateWarningCount(int n) {
    }

    default public void updateCarStatusTileSFunctionAvailabilty(int n, boolean bl) {
    }

    default public void updateCarStatusTileSFunctionExistence(int n, boolean bl) {
    }

    default public void updateOillevelFunctionAvailableReason(int n) {
    }

    default public void updateRDKFunctionAvailableReason(int n) {
    }

    default public void updateCarGearType(int n) {
    }

    default public void updateAutomaticGearShiftTransMode(int n) {
    }

    default public void updateClutchState(int n) {
    }

    default public void updateParkingBrakeState(int n) {
    }

    default public void updateSystemState(boolean bl, boolean bl2) {
    }
}

