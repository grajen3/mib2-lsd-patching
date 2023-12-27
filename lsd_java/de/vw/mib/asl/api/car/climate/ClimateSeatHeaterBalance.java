/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateSeatHeaterBalance {
    public static final int SEAT_HEATER_BALANCE_MAX;
    public static final int SEAT_HEATER_BALANCE_MIN;

    default public int getSeatHeatingBalance() {
    }

    default public int getZoneMember() {
    }

    default public ClimateSeatHeaterBalance createSeatHeaterBalance(int n) {
    }

    default public ClimateSeatHeaterBalance increaseSeatHeaterBalance() {
    }

    default public ClimateSeatHeaterBalance decreaseSeatHeaterBalance() {
    }

    default public boolean isSeatHeatingBalanceInDeviceRange() {
    }
}

