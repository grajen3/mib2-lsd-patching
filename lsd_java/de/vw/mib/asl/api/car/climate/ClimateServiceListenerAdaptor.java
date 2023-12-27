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
import de.vw.mib.asl.api.car.climate.ClimateServiceListener;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import java.util.ArrayList;

public class ClimateServiceListenerAdaptor
implements ClimateServiceListener {
    @Override
    public void updateClimateTemperature(ClimateTemperature climateTemperature) {
    }

    @Override
    public void updateClimateTemperatureValues(ArrayList arrayList) {
    }

    @Override
    public void updateClimateServiceAvailable(boolean bl) {
    }

    @Override
    public void updateClimateServiceExisting(boolean bl) {
    }

    @Override
    public void updateClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
    }

    @Override
    public void updateClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
    }

    @Override
    public void updateClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
    }

    @Override
    public void updateClimateFuntionAvailability(ClimateFunctionsAvailability climateFunctionsAvailability) {
    }

    @Override
    public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
    }

    @Override
    public void updateClimateSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
    }

    @Override
    public void updateClimateSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
    }

    @Override
    public void updateClimateAirFlowState(ClimateAirFlowState climateAirFlowState) {
    }

    @Override
    public void updateClimateSystemState(ClimateSystemState climateSystemState) {
    }

    @Override
    public void updateClamp15State(boolean bl) {
    }

    @Override
    public void updateClimateAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
    }

    @Override
    public void updateAirconFrontWindowHeater(boolean bl) {
    }

    @Override
    public void updateAirconMaxDefrost(boolean bl) {
    }

    @Override
    public void updateAirconRearWindowHeater(boolean bl) {
    }
}

