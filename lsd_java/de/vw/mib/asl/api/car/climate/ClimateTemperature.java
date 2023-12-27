/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateTemperature {
    public static final int UNIT_FAHRENHEIT;
    public static final int UNIT_CELCIUS;

    default public int getTemperature() {
    }

    default public int getUnit() {
    }

    default public int getZoneMember() {
    }

    default public ClimateTemperature createTemperatureInUnit(int n) {
    }

    default public ClimateTemperature increaseTemperature() {
    }

    default public ClimateTemperature decreaseTemperature() {
    }
}

