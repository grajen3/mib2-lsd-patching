/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateAirVolume {
    public static final int VALUE_OF_UNKNOWN;
    public static final int VALUE_OF_AIRVOLUME;
    public static final int VALUE_OF_AIRVOLUME_REGULATED;
    public static final int VALUE_OF_AIRVOLUME_AUTO;
    public static final int VALUE_OF_AIRVOLUME_ZONE;
    public static final int AUTO_ACTIVE;
    public static final int AUTO_INACTIVE;

    default public int getAirVolumeIntSettings(int n) {
    }

    default public ClimateAirVolume modifiyAirVolume(int n, int n2) {
    }
}

