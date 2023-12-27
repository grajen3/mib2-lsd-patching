/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.zone_configuration;

import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;

public interface BaseZoneConfiguationListener {
    default public void updateAirconTempZone1(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconSeatHeaterZone1New(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone1New(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone2(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconSeatHeaterZone2New(int n, int n2, int n3) {
    }

    default public void updateAirconSeatVentilationZone2New(int n, int n2, int n3) {
    }

    default public void updateAirconTempZone3(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconTempZone4(AirconTemp airconTemp, int n) {
    }

    default public void updateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
    }

    default public void updateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
    }

    default public void updateAirconTempStepZone1(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone2(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone3(int n, int n2, int n3) {
    }

    default public void updateAirconTempStepZone4(int n, int n2, int n3) {
    }

    default public void updateAirconClimateStateZone1(int n, int n2) {
    }

    default public void updateAirconClimateStateZone2(int n, int n2) {
    }

    default public void updateAirconClimateStateZone3(int n, int n2) {
    }

    default public void updateAirconClimateStateZone4(int n, int n2) {
    }

    default public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
    }
}

