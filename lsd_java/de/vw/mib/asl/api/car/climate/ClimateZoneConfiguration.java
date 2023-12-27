/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateZoneConfiguration {
    public static final int VALUE_OF_UNKNOWN;
    public static final int VALUE_OF_IONISATOR;

    default public int getExistance(int n) {
    }

    default public int getTempeatureAvailability() {
    }

    default public int getTempeatureType() {
    }

    default public int getSeatHeaterAvailability() {
    }

    default public int getSeatVentilationAvailability() {
    }

    default public int getSeatHeaterDistributionAvailability() {
    }

    default public int getSeatVentilationDistributionAvailability() {
    }

    default public int getAirDistributionAutoAvailability() {
    }

    default public int getAirDistributionCombinedAvailability() {
    }
}

