/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateGeneralConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;

public interface ClimateConfiguration {
    public static final int FUNCTION_STATE_UNKNOWN;
    public static final int FUNCTION_STATE_NOT_EXISTING;
    public static final int FUNCTION_STATE_EXISTING;
    public static final int FUNCTION_STATE_EXISTING_BUT_NOT_WORKING;
    public static final boolean DRIVER_SIDE_RIGHT;
    public static final boolean DRIVER_SIDE_LEFT;
    public static final int TEMPERATURE_TYPE_UNKNOWN;
    public static final int TEMPERATURE;
    public static final int STEPS;

    default public ClimateConfiguration createClimateConfiguration() {
    }

    default public ClimateZoneConfiguration getConfigurationOfZone(int n) {
    }

    default public ClimateZoneConfiguration[] getConfigurationOfAllZone() {
    }

    default public ClimateGeneralConfiguration getGenearlClimateConfiguration() {
    }
}

