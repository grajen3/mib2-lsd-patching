/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate;

import de.vw.mib.asl.api.car.climate.ClimateAirDistribution;
import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;
import de.vw.mib.asl.api.car.climate.ClimateAirVolume;
import de.vw.mib.asl.api.car.climate.ClimateFunctionsAvailability;
import de.vw.mib.asl.api.car.climate.ClimateGeneralConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateService;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import de.vw.mib.asl.api.car.climate.ClimateValueFactory;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;

public class NotAvailableClimateService
implements ClimateService {
    @Override
    public ClimateTemperature getClimateTemperatureValueForZone(int n) {
        return null;
    }

    @Override
    public ClimateTemperature[] getClimateTemperatures() {
        return null;
    }

    @Override
    public boolean isClimateServiceAvailable() {
        return false;
    }

    @Override
    public ClimateValueFactory getClimateValueFactory() {
        return null;
    }

    @Override
    public boolean isClimateServiceExisting() {
        return false;
    }

    @Override
    public void changeClimateTemperature(int n, ClimateTemperature climateTemperature) {
    }

    @Override
    public void changeClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
    }

    @Override
    public ClimateAirFlowStyle getClimateAirFlowStyleForZone(int n) {
        return null;
    }

    @Override
    public boolean[] isTemperatureChangeViaHMI() {
        return null;
    }

    @Override
    public boolean[] isEcoActive() {
        return null;
    }

    @Override
    public void changeClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
    }

    @Override
    public ClimateSeatHeater getClimateSeatHeaterForZone(int n) {
        return null;
    }

    @Override
    public void changeClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
    }

    @Override
    public ClimateSeatVentilation getClimateSeatVentilationForZone(int n) {
        return null;
    }

    @Override
    public ClimateFunctionsAvailability getClimateFunctionsAvailability() {
        return null;
    }

    @Override
    public ClimateZoneConfiguration getClimateZoneConfiguration(int n) {
        return null;
    }

    @Override
    public ClimateZoneConfiguration[] getClimateZoneConfigurationAllZones() {
        return null;
    }

    @Override
    public ClimateGeneralConfiguration getClimateGeneralConfiguration() {
        return null;
    }

    @Override
    public ClimateSeatHeaterBalance getSeatHeaterBalanceForZone(int n) {
        return null;
    }

    @Override
    public ClimateSeatVentilatorBalance getSeatVentilatorBalanceForZone(int n) {
        return null;
    }

    @Override
    public void changeSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
    }

    @Override
    public void changeSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
    }

    @Override
    public boolean getClamp15OnState() {
        return false;
    }

    @Override
    public boolean getClimateSystemState(int n) {
        return false;
    }

    @Override
    public void changeClimateSystemState(ClimateSystemState climateSystemState) {
    }

    @Override
    public ClimateAirDistributionCombined getAirDistributionCombinedForZone(int n) {
        return null;
    }

    @Override
    public void changeAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
    }

    @Override
    public boolean getFrontWindowHeater() {
        return false;
    }

    @Override
    public void changeFrontWindowHeater(boolean bl) {
    }

    @Override
    public boolean getMaxDefrost() {
        return false;
    }

    @Override
    public void changeMaxDefrost(boolean bl) {
    }

    @Override
    public boolean getRearWindowHeater() {
        return false;
    }

    @Override
    public void changeRearWindowHeater(boolean bl) {
    }

    @Override
    public ClimateAirDistribution getAirDistributionForZone(int n) {
        return null;
    }

    @Override
    public void changeAirDistribution(ClimateAirDistribution climateAirDistribution) {
    }

    @Override
    public ClimateAirVolume getAirVolumeForZone(int n) {
        return null;
    }

    @Override
    public void changeAirVolume(ClimateAirVolume climateAirVolume) {
    }
}

