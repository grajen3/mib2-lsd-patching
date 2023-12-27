/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

public interface ClimateAirFlowStyle {
    public static final int AIR_FLOW_STYLE_SOFT;
    public static final int AIR_FLOW_STYLE_MEDIUM;
    public static final int AIR_FLOW_STYLE_INTENSIVE;

    default public int getAirFlowStyle() {
    }

    default public int getAirFlowMemberZone() {
    }

    default public ClimateAirFlowStyle createAirFlowStyle(int n) {
    }
}

