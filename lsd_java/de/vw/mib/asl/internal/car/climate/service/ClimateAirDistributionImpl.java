/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateAirDistribution;

public class ClimateAirDistributionImpl
implements ClimateAirDistribution {
    int zone;
    int up;
    int body;
    int footWell;
    boolean autoMode;
    int indirect;
    boolean autoDemandOriented;
    int side;

    public ClimateAirDistributionImpl(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, int n6) {
        this.zone = n;
        this.up = n2;
        this.body = n3;
        this.footWell = n4;
        this.autoMode = bl;
        this.indirect = n5;
        this.autoDemandOriented = bl2;
        this.side = n6;
    }

    @Override
    public int getAirDistributionIntValue(int n) {
        int n2 = 5;
        switch (n) {
            case 1: {
                n2 = this.body;
                break;
            }
            case 2: {
                n2 = this.footWell;
                break;
            }
            case 3: {
                n2 = this.up;
                break;
            }
            case 6: {
                n2 = this.zone;
                break;
            }
        }
        return n2;
    }

    @Override
    public boolean getAirDistributionBooleanValue(int n) {
        boolean bl = false;
        switch (n) {
            case 1: {
                bl = this.autoMode;
                break;
            }
            case 2: {
                bl = this.autoDemandOriented;
                break;
            }
        }
        return bl;
    }

    @Override
    public ClimateAirDistribution modifyAirDistributionIntValue(int n, int n2) {
        ClimateAirDistributionImpl climateAirDistributionImpl = new ClimateAirDistributionImpl(this.zone, this.up, this.body, this.footWell, this.indirect, this.autoMode, this.autoDemandOriented, this.side);
        switch (n) {
            case 1: {
                climateAirDistributionImpl.body = n2;
                break;
            }
            case 2: {
                climateAirDistributionImpl.footWell = n2;
                break;
            }
            case 3: {
                climateAirDistributionImpl.up = n2;
                break;
            }
            case 6: {
                climateAirDistributionImpl.zone = n2;
                break;
            }
            case 4: {
                climateAirDistributionImpl.indirect = n2;
                break;
            }
            case 5: {
                climateAirDistributionImpl.side = n2;
                break;
            }
        }
        return climateAirDistributionImpl;
    }

    @Override
    public ClimateAirDistribution modifyAirDistributionBooleanValue(int n, boolean bl) {
        ClimateAirDistributionImpl climateAirDistributionImpl = new ClimateAirDistributionImpl(this.zone, this.up, this.body, this.footWell, this.indirect, this.autoMode, this.autoDemandOriented, this.side);
        switch (n) {
            case 1: {
                climateAirDistributionImpl.autoMode = bl;
                break;
            }
        }
        return climateAirDistributionImpl;
    }
}

