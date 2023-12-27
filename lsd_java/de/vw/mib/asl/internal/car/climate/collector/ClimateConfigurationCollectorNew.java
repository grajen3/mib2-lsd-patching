/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.collector;

import de.vw.mib.asl.internal.car.climate.collector.ClimateGeneralConfigurationCollector;
import de.vw.mib.asl.internal.car.climate.collector.ClimateZoneConfigurationCollector;

public class ClimateConfigurationCollectorNew {
    public ClimateZoneConfigurationCollector[] zoneConfigurations = new ClimateZoneConfigurationCollector[]{new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector()};
    public ClimateGeneralConfigurationCollector generalConfiguration = new ClimateGeneralConfigurationCollector();

    public ClimateConfigurationCollectorNew(ClimateZoneConfigurationCollector[] climateZoneConfigurationCollectorArray, ClimateGeneralConfigurationCollector climateGeneralConfigurationCollector) {
        this.zoneConfigurations = climateZoneConfigurationCollectorArray;
        this.generalConfiguration = climateGeneralConfigurationCollector;
    }

    public ClimateConfigurationCollectorNew() {
    }

    public ClimateZoneConfigurationCollector getZoneConfiguration(int n) {
        ClimateZoneConfigurationCollector climateZoneConfigurationCollector = null;
        switch (n) {
            case 0: {
                climateZoneConfigurationCollector = new ClimateZoneConfigurationCollector(this.zoneConfigurations[0].temperatureAvailability, this.zoneConfigurations[0].temperatureStepsAvailability, this.zoneConfigurations[0].temperatureType, this.zoneConfigurations[0].temperatureModifiableViaHMI, this.zoneConfigurations[0].airDistributionAvailability, this.zoneConfigurations[0].airFlowAvailability, this.zoneConfigurations[0].airDistributionStyleExtendedAvailability, this.zoneConfigurations[0].airDistributionStyleAvailability, this.zoneConfigurations[0].airDistributionFootAvailability, this.zoneConfigurations[0].airDistributionBodyAvailability, this.zoneConfigurations[0].airDistributionWindowAvailability, this.zoneConfigurations[0].airDistributionAutoSupported, this.zoneConfigurations[0].setupButtonAvailability, this.zoneConfigurations[0].seatHeaterAvailability, this.zoneConfigurations[0].seatHeaterDistributionAvailability, this.zoneConfigurations[0].seatVentilationAvailability, this.zoneConfigurations[0].seatVentilationDistributionAvailability, this.zoneConfigurations[0].airDistributionCombined, this.zoneConfigurations[0].ionisator);
                break;
            }
            case 1: {
                climateZoneConfigurationCollector = new ClimateZoneConfigurationCollector(this.zoneConfigurations[1].temperatureAvailability, this.zoneConfigurations[1].temperatureStepsAvailability, this.zoneConfigurations[1].temperatureType, this.zoneConfigurations[1].temperatureModifiableViaHMI, this.zoneConfigurations[1].airDistributionAvailability, this.zoneConfigurations[1].airFlowAvailability, this.zoneConfigurations[1].airDistributionStyleExtendedAvailability, this.zoneConfigurations[1].airDistributionStyleAvailability, this.zoneConfigurations[1].airDistributionFootAvailability, this.zoneConfigurations[1].airDistributionBodyAvailability, this.zoneConfigurations[1].airDistributionWindowAvailability, this.zoneConfigurations[1].airDistributionAutoSupported, this.zoneConfigurations[1].setupButtonAvailability, this.zoneConfigurations[1].seatHeaterAvailability, this.zoneConfigurations[1].seatHeaterDistributionAvailability, this.zoneConfigurations[1].seatVentilationAvailability, this.zoneConfigurations[1].seatVentilationDistributionAvailability, this.zoneConfigurations[1].airDistributionCombined, this.zoneConfigurations[1].ionisator);
                break;
            }
        }
        return climateZoneConfigurationCollector;
    }
}

