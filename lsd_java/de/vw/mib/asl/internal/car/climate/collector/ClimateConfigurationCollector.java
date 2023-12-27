/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.collector;

import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateGeneralConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;
import de.vw.mib.asl.internal.car.climate.collector.ClimateGeneralConfigurationCollector;
import de.vw.mib.asl.internal.car.climate.collector.ClimateZoneConfigurationCollector;

public class ClimateConfigurationCollector
implements ClimateConfiguration {
    public ClimateZoneConfigurationCollector[] zoneConfigurations = new ClimateZoneConfigurationCollector[]{new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector()};
    public ClimateGeneralConfigurationCollector generalConfiguration = new ClimateGeneralConfigurationCollector();

    public ClimateConfigurationCollector(ClimateZoneConfigurationCollector[] climateZoneConfigurationCollectorArray, ClimateGeneralConfigurationCollector climateGeneralConfigurationCollector) {
        this.zoneConfigurations = climateZoneConfigurationCollectorArray;
        this.generalConfiguration = climateGeneralConfigurationCollector;
    }

    public ClimateConfigurationCollector() {
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
            case 2: {
                climateZoneConfigurationCollector = new ClimateZoneConfigurationCollector(this.zoneConfigurations[2].temperatureAvailability, this.zoneConfigurations[2].temperatureStepsAvailability, this.zoneConfigurations[2].temperatureType, this.zoneConfigurations[2].temperatureModifiableViaHMI, this.zoneConfigurations[2].airDistributionAvailability, this.zoneConfigurations[2].airFlowAvailability, this.zoneConfigurations[2].airDistributionStyleExtendedAvailability, this.zoneConfigurations[2].airDistributionStyleAvailability, this.zoneConfigurations[2].airDistributionFootAvailability, this.zoneConfigurations[2].airDistributionBodyAvailability, this.zoneConfigurations[2].airDistributionWindowAvailability, this.zoneConfigurations[2].airDistributionAutoSupported, this.zoneConfigurations[2].setupButtonAvailability, this.zoneConfigurations[2].seatHeaterAvailability, this.zoneConfigurations[2].seatHeaterDistributionAvailability, this.zoneConfigurations[2].seatVentilationAvailability, this.zoneConfigurations[2].seatVentilationDistributionAvailability, this.zoneConfigurations[2].airDistributionCombined, this.zoneConfigurations[2].ionisator);
                break;
            }
            case 3: {
                climateZoneConfigurationCollector = new ClimateZoneConfigurationCollector(this.zoneConfigurations[3].temperatureAvailability, this.zoneConfigurations[3].temperatureStepsAvailability, this.zoneConfigurations[3].temperatureType, this.zoneConfigurations[3].temperatureModifiableViaHMI, this.zoneConfigurations[3].airDistributionAvailability, this.zoneConfigurations[3].airFlowAvailability, this.zoneConfigurations[3].airDistributionStyleExtendedAvailability, this.zoneConfigurations[3].airDistributionStyleAvailability, this.zoneConfigurations[3].airDistributionFootAvailability, this.zoneConfigurations[3].airDistributionBodyAvailability, this.zoneConfigurations[3].airDistributionWindowAvailability, this.zoneConfigurations[3].airDistributionAutoSupported, this.zoneConfigurations[3].setupButtonAvailability, this.zoneConfigurations[3].seatHeaterAvailability, this.zoneConfigurations[3].seatHeaterDistributionAvailability, this.zoneConfigurations[3].seatVentilationAvailability, this.zoneConfigurations[3].seatVentilationDistributionAvailability, this.zoneConfigurations[3].airDistributionCombined, this.zoneConfigurations[3].ionisator);
                break;
            }
        }
        return climateZoneConfigurationCollector;
    }

    public ClimateConfigurationCollector getCopyOfClimateConfigurationCollector() {
        ClimateZoneConfigurationCollector[] climateZoneConfigurationCollectorArray = new ClimateZoneConfigurationCollector[]{this.zoneConfigurations[0].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[1].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[2].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[3].getCopyClimateZoneConfigurationColletor()};
        ClimateGeneralConfigurationCollector climateGeneralConfigurationCollector = this.generalConfiguration.getCopyofGenearlConfiguration();
        ClimateConfigurationCollector climateConfigurationCollector = new ClimateConfigurationCollector(climateZoneConfigurationCollectorArray, climateGeneralConfigurationCollector);
        return climateConfigurationCollector;
    }

    @Override
    public ClimateConfiguration createClimateConfiguration() {
        return this.getCopyOfClimateConfigurationCollector();
    }

    @Override
    public ClimateZoneConfiguration getConfigurationOfZone(int n) {
        return this.zoneConfigurations[n].getCopyClimateZoneConfigurationColletor();
    }

    @Override
    public ClimateZoneConfiguration[] getConfigurationOfAllZone() {
        ClimateZoneConfiguration[] climateZoneConfigurationArray = new ClimateZoneConfigurationCollector[]{this.zoneConfigurations[0].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[1].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[2].getCopyClimateZoneConfigurationColletor(), this.zoneConfigurations[3].getCopyClimateZoneConfigurationColletor()};
        return climateZoneConfigurationArray;
    }

    @Override
    public ClimateGeneralConfiguration getGenearlClimateConfiguration() {
        return this.generalConfiguration.getCopyofGenearlConfiguration();
    }
}

