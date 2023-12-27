/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateGeneralConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;
import de.vw.mib.asl.internal.car.climate.collector.ClimateGeneralConfigurationCollector;
import de.vw.mib.asl.internal.car.climate.collector.ClimateZoneConfigurationCollector;
import java.util.ArrayList;

public class ClimateZoneConfigurationImpl
implements ClimateConfiguration {
    public ClimateZoneConfigurationCollector[] zoneConfigurations = new ClimateZoneConfigurationCollector[]{new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector(), new ClimateZoneConfigurationCollector()};
    public ClimateGeneralConfigurationCollector generalConfiguration = new ClimateGeneralConfigurationCollector();

    public ClimateZoneConfigurationImpl(ClimateGeneralConfigurationCollector climateGeneralConfigurationCollector, ClimateZoneConfigurationCollector[] climateZoneConfigurationCollectorArray) {
        this.zoneConfigurations = climateZoneConfigurationCollectorArray;
        this.generalConfiguration = climateGeneralConfigurationCollector;
    }

    public ClimateConfiguration createClimateConfiguration(ClimateGeneralConfigurationCollector climateGeneralConfigurationCollector, ClimateZoneConfigurationCollector[] climateZoneConfigurationCollectorArray) {
        ClimateZoneConfigurationImpl climateZoneConfigurationImpl = null;
        climateZoneConfigurationImpl = new ClimateZoneConfigurationImpl(climateGeneralConfigurationCollector, climateZoneConfigurationCollectorArray);
        return climateZoneConfigurationImpl;
    }

    @Override
    public ClimateConfiguration createClimateConfiguration() {
        return new ClimateZoneConfigurationImpl(this.generalConfiguration, this.zoneConfigurations);
    }

    @Override
    public ClimateGeneralConfiguration getGenearlClimateConfiguration() {
        return this.generalConfiguration;
    }

    @Override
    public ClimateZoneConfiguration getConfigurationOfZone(int n) {
        ClimateZoneConfigurationCollector climateZoneConfigurationCollector = null;
        switch (n) {
            case 0: {
                climateZoneConfigurationCollector = this.zoneConfigurations[0];
                break;
            }
            case 1: {
                climateZoneConfigurationCollector = this.zoneConfigurations[1];
                break;
            }
            case 2: {
                climateZoneConfigurationCollector = this.zoneConfigurations[2];
                break;
            }
            case 3: {
                climateZoneConfigurationCollector = this.zoneConfigurations[3];
                break;
            }
        }
        return climateZoneConfigurationCollector;
    }

    @Override
    public ClimateZoneConfiguration[] getConfigurationOfAllZone() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.zoneConfigurations.length; ++i2) {
            arrayList.add(this.zoneConfigurations[i2]);
        }
        return (ClimateZoneConfiguration[])arrayList.toArray();
    }
}

