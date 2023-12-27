/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.collector;

import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;

public class ClimateZoneConfigurationCollector
implements ClimateZoneConfiguration {
    public int temperatureAvailability = 0;
    public int temperatureStepsAvailability = 0;
    public int temperatureType = 0;
    public int temperatureModifiableViaHMI = 0;
    public int airDistributionAvailability = 0;
    public int airFlowAvailability = 0;
    public int airDistributionStyleExtendedAvailability = 0;
    public int airDistributionStyleAvailability = 0;
    public int airDistributionFootAvailability = 0;
    public int airDistributionBodyAvailability = 0;
    public int airDistributionWindowAvailability = 0;
    public int airDistributionAutoSupported = 0;
    public int setupButtonAvailability = 0;
    public int seatHeaterAvailability = 0;
    public int seatHeaterDistributionAvailability = 0;
    public int seatVentilationAvailability = 0;
    public int seatVentilationDistributionAvailability = 0;
    public int airDistributionCombined = 0;
    public int ionisator = 0;

    public ClimateZoneConfigurationCollector(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19) {
        this.temperatureAvailability = n;
        this.temperatureStepsAvailability = n2;
        this.temperatureType = n3;
        this.temperatureModifiableViaHMI = n4;
        this.airDistributionAvailability = n5;
        this.airFlowAvailability = n6;
        this.airDistributionStyleExtendedAvailability = n7;
        this.airDistributionStyleAvailability = n8;
        this.airDistributionFootAvailability = n9;
        this.airDistributionBodyAvailability = n10;
        this.airDistributionWindowAvailability = n11;
        this.airDistributionAutoSupported = n12;
        this.setupButtonAvailability = n13;
        this.seatHeaterAvailability = n14;
        this.seatHeaterDistributionAvailability = n15;
        this.seatVentilationAvailability = n16;
        this.seatVentilationDistributionAvailability = n17;
        this.airDistributionCombined = n18;
        this.ionisator = n19;
    }

    public ClimateZoneConfigurationCollector() {
        this.temperatureAvailability = 0;
        this.temperatureStepsAvailability = 0;
        this.temperatureType = 0;
        this.temperatureModifiableViaHMI = 0;
        this.airDistributionAvailability = 0;
        this.airFlowAvailability = 0;
        this.airDistributionStyleExtendedAvailability = 0;
        this.airDistributionStyleAvailability = 0;
        this.airDistributionFootAvailability = 0;
        this.airDistributionBodyAvailability = 0;
        this.airDistributionWindowAvailability = 0;
        this.airDistributionAutoSupported = 0;
        this.setupButtonAvailability = 0;
        this.seatHeaterAvailability = 0;
        this.seatHeaterDistributionAvailability = 0;
        this.seatVentilationAvailability = 0;
        this.seatVentilationDistributionAvailability = 0;
        this.airDistributionCombined = 0;
        this.ionisator = 0;
    }

    public ClimateZoneConfigurationCollector(ClimateZoneConfigurationCollector climateZoneConfigurationCollector) {
        new ClimateZoneConfigurationCollector(climateZoneConfigurationCollector.temperatureAvailability, climateZoneConfigurationCollector.temperatureStepsAvailability, climateZoneConfigurationCollector.temperatureType, climateZoneConfigurationCollector.temperatureModifiableViaHMI, climateZoneConfigurationCollector.airDistributionAvailability, climateZoneConfigurationCollector.airFlowAvailability, climateZoneConfigurationCollector.airDistributionStyleExtendedAvailability, climateZoneConfigurationCollector.airDistributionStyleAvailability, climateZoneConfigurationCollector.airDistributionFootAvailability, climateZoneConfigurationCollector.airDistributionBodyAvailability, climateZoneConfigurationCollector.airDistributionWindowAvailability, climateZoneConfigurationCollector.airDistributionAutoSupported, climateZoneConfigurationCollector.setupButtonAvailability, climateZoneConfigurationCollector.seatHeaterAvailability, climateZoneConfigurationCollector.seatHeaterDistributionAvailability, climateZoneConfigurationCollector.seatVentilationAvailability, climateZoneConfigurationCollector.seatVentilationDistributionAvailability, climateZoneConfigurationCollector.airDistributionCombined, climateZoneConfigurationCollector.ionisator);
    }

    public ClimateZoneConfigurationCollector getCopyClimateZoneConfigurationColletor(ClimateZoneConfigurationCollector climateZoneConfigurationCollector) {
        return new ClimateZoneConfigurationCollector(climateZoneConfigurationCollector.temperatureAvailability, climateZoneConfigurationCollector.temperatureStepsAvailability, climateZoneConfigurationCollector.temperatureType, climateZoneConfigurationCollector.temperatureModifiableViaHMI, climateZoneConfigurationCollector.airDistributionAvailability, climateZoneConfigurationCollector.airFlowAvailability, climateZoneConfigurationCollector.airDistributionStyleExtendedAvailability, climateZoneConfigurationCollector.airDistributionStyleAvailability, climateZoneConfigurationCollector.airDistributionFootAvailability, climateZoneConfigurationCollector.airDistributionBodyAvailability, climateZoneConfigurationCollector.airDistributionWindowAvailability, climateZoneConfigurationCollector.airDistributionAutoSupported, climateZoneConfigurationCollector.setupButtonAvailability, climateZoneConfigurationCollector.seatHeaterAvailability, climateZoneConfigurationCollector.seatHeaterDistributionAvailability, climateZoneConfigurationCollector.seatVentilationAvailability, climateZoneConfigurationCollector.seatVentilationDistributionAvailability, climateZoneConfigurationCollector.airDistributionCombined, climateZoneConfigurationCollector.ionisator);
    }

    public ClimateZoneConfigurationCollector getCopyClimateZoneConfigurationColletor() {
        return new ClimateZoneConfigurationCollector(this.temperatureAvailability, this.temperatureStepsAvailability, this.temperatureType, this.temperatureModifiableViaHMI, this.airDistributionAvailability, this.airFlowAvailability, this.airDistributionStyleExtendedAvailability, this.airDistributionStyleAvailability, this.airDistributionFootAvailability, this.airDistributionBodyAvailability, this.airDistributionWindowAvailability, this.airDistributionAutoSupported, this.setupButtonAvailability, this.seatHeaterAvailability, this.seatHeaterDistributionAvailability, this.seatVentilationAvailability, this.seatVentilationDistributionAvailability, this.airDistributionCombined, this.ionisator);
    }

    @Override
    public int getSeatHeaterDistributionAvailability() {
        return this.seatHeaterDistributionAvailability;
    }

    @Override
    public int getTempeatureAvailability() {
        return this.temperatureAvailability;
    }

    @Override
    public int getTempeatureType() {
        return this.temperatureType;
    }

    @Override
    public int getSeatHeaterAvailability() {
        return this.seatHeaterAvailability;
    }

    @Override
    public int getSeatVentilationAvailability() {
        return this.seatVentilationAvailability;
    }

    @Override
    public int getSeatVentilationDistributionAvailability() {
        return this.seatVentilationDistributionAvailability;
    }

    @Override
    public int getAirDistributionAutoAvailability() {
        return this.airDistributionAutoSupported;
    }

    @Override
    public int getAirDistributionCombinedAvailability() {
        return this.airDistributionCombined;
    }

    @Override
    public int getExistance(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = this.ionisator;
                break;
            }
        }
        return n2;
    }
}

