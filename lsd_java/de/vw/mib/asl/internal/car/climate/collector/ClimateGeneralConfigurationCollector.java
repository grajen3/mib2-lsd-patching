/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.collector;

import de.vw.mib.asl.api.car.climate.ClimateGeneralConfiguration;

public class ClimateGeneralConfigurationCollector
implements ClimateGeneralConfiguration {
    public int airconACAvailability;
    public int airconSyncAvailability;
    public int airCirculationManAvailability;
    public int maxACAvailability;
    public int maxDefrostAvailability;
    public int pureAir;
    public int freshAir;
    public int driverSide;

    public ClimateGeneralConfigurationCollector(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.airconACAvailability = n;
        this.airconSyncAvailability = n2;
        this.airCirculationManAvailability = n3;
        this.maxACAvailability = n4;
        this.maxDefrostAvailability = n5;
        this.pureAir = n6;
        this.freshAir = n7;
        this.driverSide = n8;
    }

    public ClimateGeneralConfigurationCollector() {
        this.airconACAvailability = 0;
        this.airconSyncAvailability = 0;
        this.airCirculationManAvailability = 0;
        this.maxACAvailability = 0;
        this.maxDefrostAvailability = 0;
        this.pureAir = 0;
        this.freshAir = 0;
        this.driverSide = 0;
    }

    public ClimateGeneralConfigurationCollector getCopyofGenearlConfiguration() {
        return new ClimateGeneralConfigurationCollector(this.airconACAvailability, this.airconSyncAvailability, this.airCirculationManAvailability, this.maxACAvailability, this.maxDefrostAvailability, this.pureAir, this.freshAir, this.driverSide);
    }

    @Override
    public int getTemperatureSyncAvaiability() {
        return this.airconSyncAvailability;
    }

    @Override
    public int getExistance(int n) {
        int n2 = 0;
        switch (n) {
            case 3: {
                n2 = this.freshAir;
                break;
            }
            case 2: {
                n2 = this.pureAir;
                break;
            }
            case 1: {
                n2 = this.airconSyncAvailability;
                break;
            }
            case 4: {
                n2 = this.airconACAvailability;
                break;
            }
        }
        return n2;
    }

    @Override
    public int getDriverSide() {
        return this.driverSide;
    }
}

