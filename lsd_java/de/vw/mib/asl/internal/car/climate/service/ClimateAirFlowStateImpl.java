/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateAirFlowState;

public class ClimateAirFlowStateImpl
implements ClimateAirFlowState {
    private final int airFlowState;
    private final int zoneMember;

    public ClimateAirFlowStateImpl(int n, int n2) {
        this.airFlowState = n2;
        this.zoneMember = n;
    }

    @Override
    public int getAirFlowState() {
        return this.airFlowState;
    }

    @Override
    public int getAirFlowMemberZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateAirFlowState createAirFlowState(int n) {
        ClimateAirFlowStateImpl climateAirFlowStateImpl = new ClimateAirFlowStateImpl(this.zoneMember, n);
        return climateAirFlowStateImpl;
    }
}

