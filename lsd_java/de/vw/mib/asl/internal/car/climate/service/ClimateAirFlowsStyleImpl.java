/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;

public class ClimateAirFlowsStyleImpl
implements ClimateAirFlowStyle {
    private final int airFlowStyle;
    private final int zoneMember;

    public ClimateAirFlowsStyleImpl(int n, int n2) {
        this.zoneMember = n;
        this.airFlowStyle = n2;
    }

    @Override
    public int getAirFlowStyle() {
        return this.airFlowStyle;
    }

    @Override
    public int getAirFlowMemberZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateAirFlowStyle createAirFlowStyle(int n) {
        ClimateAirFlowsStyleImpl climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(this.zoneMember, n);
        return climateAirFlowsStyleImpl;
    }
}

