/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateSeatVentilatorBalance {
    public static final int SEAT_VENTILATOR_BALANCE_MAX;
    public static final int SEAT_VENTILATOR_BALANCE_MIN;

    default public int getSeatVentilationBalance() {
    }

    default public int getZoneMember() {
    }

    default public ClimateSeatVentilatorBalance createSeatVentilatorBalance(int n) {
    }

    default public ClimateSeatVentilatorBalance increaseSeatVentilatorBalance() {
    }

    default public ClimateSeatVentilatorBalance decreaseSeatVentilatorBalance() {
    }

    default public boolean isSeatVentilatorBalanceInDeviceRange() {
    }
}

