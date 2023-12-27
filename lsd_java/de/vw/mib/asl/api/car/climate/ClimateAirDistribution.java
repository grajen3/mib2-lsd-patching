/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateAirDistribution {
    public static final int VALUE_OF_INT_UNKNOWN;
    public static final int VALUE_OF_INT_BODY;
    public static final int VALUE_OF_INT_FOOTWELL;
    public static final int VALUE_OF_INT_UP;
    public static final int VALUE_OF_INT_INDIRECT;
    public static final int VALUE_OF_INT_SIDE;
    public static final int VALUE_OF_INT_ZONE;
    public static final int VALUE_OF_BOOLEAN_AUTOMODE;
    public static final int VALUE_OF_BOOLEAN_AUTODEMANDORIENTED;
    public static final int FUNCTION_INT_UNKNOWN;
    public static final int FUNCTION_INT_ACTIVE;
    public static final int FUNCTION_INT_INACTIVE;
    public static final boolean FUNCTION_BOOLEAN_ACTIVE;
    public static final boolean FUNCTION_BOOLEAN_INACTIVE;

    default public int getAirDistributionIntValue(int n) {
    }

    default public boolean getAirDistributionBooleanValue(int n) {
    }

    default public ClimateAirDistribution modifyAirDistributionIntValue(int n, int n2) {
    }

    default public ClimateAirDistribution modifyAirDistributionBooleanValue(int n, boolean bl) {
    }
}

