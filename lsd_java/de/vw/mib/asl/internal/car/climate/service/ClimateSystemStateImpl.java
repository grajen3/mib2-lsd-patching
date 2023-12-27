/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateSystemState;

public class ClimateSystemStateImpl
implements ClimateSystemState {
    private final boolean systemState;
    private final int zoneMember;

    public ClimateSystemStateImpl(int n, boolean bl) {
        this.systemState = bl;
        this.zoneMember = n;
    }

    @Override
    public boolean getSystemState() {
        return this.systemState;
    }

    @Override
    public int getSystemMemberZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateSystemState createClimateSystemState(boolean bl) {
        ClimateSystemStateImpl climateSystemStateImpl = new ClimateSystemStateImpl(this.zoneMember, bl);
        return climateSystemStateImpl;
    }
}

