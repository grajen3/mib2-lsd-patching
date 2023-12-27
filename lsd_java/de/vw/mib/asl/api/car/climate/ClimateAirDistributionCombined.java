/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateAirDistributionCombined {
    public static final int AIR_DISTRIBUTION_UNKNOWN;
    public static final int AIR_DISTRIBUTION_WINDOW;
    public static final int AIR_DISTRIBUTION_FEET;
    public static final int AIR_DISTRIBUTION_BODY;
    public static final int AIR_DISTRIBUTION_WINDOW_FEET;
    public static final int AIR_DISTRIBUTION_BODY_FEET;
    public static final int AIR_DISTRIBUTION_WINDOW_BODY_FEET;

    default public int getAirDistibutionCombined() {
    }

    default public int getAirDistributionMemberZone() {
    }

    default public ClimateAirDistributionCombined createAirDistributionCombined(int n) {
    }
}

