/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowState;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;
import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateFunctionsAvailability;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import java.util.ArrayList;

public interface ClimateServiceListener {
    default public void updateClimateTemperature(ClimateTemperature climateTemperature) {
    }

    default public void updateClimateTemperatureValues(ArrayList arrayList) {
    }

    default public void updateClimateServiceAvailable(boolean bl) {
    }

    default public void updateClimateServiceExisting(boolean bl) {
    }

    default public void updateClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
    }

    default public void updateClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
    }

    default public void updateClimateSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
    }

    default public void updateClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
    }

    default public void updateClimateSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
    }

    default public void updateClimateFuntionAvailability(ClimateFunctionsAvailability climateFunctionsAvailability) {
    }

    default public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
    }

    default public void updateClimateAirFlowState(ClimateAirFlowState climateAirFlowState) {
    }

    default public void updateClimateSystemState(ClimateSystemState climateSystemState) {
    }

    default public void updateClamp15State(boolean bl) {
    }

    default public void updateClimateAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
    }

    default public void updateAirconFrontWindowHeater(boolean bl) {
    }

    default public void updateAirconMaxDefrost(boolean bl) {
    }

    default public void updateAirconRearWindowHeater(boolean bl) {
    }
}

