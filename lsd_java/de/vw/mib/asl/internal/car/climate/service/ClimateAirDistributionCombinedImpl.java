/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;

public class ClimateAirDistributionCombinedImpl
implements ClimateAirDistributionCombined {
    private final int airDistributionCombined;
    private final int zoneMember;

    public ClimateAirDistributionCombinedImpl(int n, int n2) {
        this.zoneMember = n;
        this.airDistributionCombined = n2;
    }

    @Override
    public int getAirDistibutionCombined() {
        return this.airDistributionCombined;
    }

    @Override
    public int getAirDistributionMemberZone() {
        return this.zoneMember;
    }

    @Override
    public ClimateAirDistributionCombined createAirDistributionCombined(int n) {
        ClimateAirDistributionCombinedImpl climateAirDistributionCombinedImpl = new ClimateAirDistributionCombinedImpl(this.zoneMember, n);
        return climateAirDistributionCombinedImpl;
    }
}

