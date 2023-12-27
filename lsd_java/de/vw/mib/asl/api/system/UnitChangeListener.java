/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

public interface UnitChangeListener {
    public static final int UNIT_TEMPERATURE;
    public static final int UNIT_SPEED;
    public static final int UNIT_WEIGHT;
    public static final int UNIT_DISTANCE;
    public static final int UNIT_VOLUME;
    public static final int UNIT_PETROL_CONSUMPTION;
    public static final int UNIT_GAS_CONSUMPTION;
    public static final int UNIT_ELECTRIC_CONSUMPTION;
    public static final int UNIT_PRSSURE;
    public static final int UNIT_ALL;

    default public void onUnitChanged(int n, int n2) {
    }
}

