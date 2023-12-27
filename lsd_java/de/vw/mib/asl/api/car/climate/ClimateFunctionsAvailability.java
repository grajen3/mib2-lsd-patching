/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateFunctionsAvailability {
    public static final int FUNCTION_STATE_UNKNOWN;
    public static final int FUNCTION_STATE_NOT_EXISTING;
    public static final int FUNCTION_STATE_EXISTING;
    public static final int FUNCTION_STATE_EXISTING_BUT_NOT_WORKING;
    public static final boolean DRIVER_SIDE_RIGHT;
    public static final boolean DRIVER_SIDE_LEFT;

    default public ClimateFunctionsAvailability createClimateFunctionsAvailability() {
    }

    default public int getTemperatureAvailabilityZone1() {
    }

    default public int getTemperatureAvailabilityZone2() {
    }

    default public int getTemperatureAvailabilityZone3() {
    }

    default public int getTemperatureAvailabilityZone4() {
    }

    default public int getSeatHeaterAvailabilityZone1() {
    }

    default public int getSeatHeaterAvailabilityZone2() {
    }

    default public int getSeatVentilationAvailabilityZone1() {
    }

    default public int getSeatVentilationAvailabilityZone2() {
    }
}

