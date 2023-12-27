/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateGeneralConfiguration {
    public static final int EXISTENCE_OF_UNKNOWN;
    public static final int EXISTENCE_OF_SYNC;
    public static final int EXISTENCE_OF_PUREAIR;
    public static final int EXISTENCE_OF_FRESHAIR;
    public static final int EXISTENCE_OF_AC;
    public static final int DRIVERSIDE_UNKNOW;
    public static final int DRIVERSIDE_LEFT;
    public static final int DRIVERSIDE_RIGHT;

    default public int getTemperatureSyncAvaiability() {
    }

    default public int getExistance(int n) {
    }

    default public int getDriverSide() {
    }
}

