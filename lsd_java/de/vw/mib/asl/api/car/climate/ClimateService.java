/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

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
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import de.vw.mib.asl.api.car.climate.ClimateValueFactory;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;

public interface ClimateService {
    public static final int TEMPERATURE_BUTTON_POSITION_FRONT_LEFT;
    public static final int TEMPERATURE_BUTTON_POSITION_FRONT_RIGHT;
    public static final int TEMPERATURE_BUTTON_POSITION_REAR_LEFT;
    public static final int TEMPERATURE_BUTTON_POSITION_REAR_RIGHT;
    public static final int TEMPERATURE_BUTTON_POSITION_REAR_CENTER;

    default public void changeClimateTemperature(int n, ClimateTemperature climateTemperature) {
    }

    default public ClimateTemperature getClimateTemperatureValueForZone(int n) {
    }

    default public ClimateTemperature[] getClimateTemperatures() {
    }

    default public boolean isClimateServiceExisting() {
    }

    default public boolean isClimateServiceAvailable() {
    }

    default public ClimateValueFactory getClimateValueFactory() {
    }

    default public void changeClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
    }

    default public ClimateAirFlowStyle getClimateAirFlowStyleForZone(int n) {
    }

    default public void changeClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
    }

    default public ClimateSeatHeater getClimateSeatHeaterForZone(int n) {
    }

    default public void changeClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
    }

    default public ClimateSeatVentilation getClimateSeatVentilationForZone(int n) {
    }

    default public boolean[] isTemperatureChangeViaHMI() {
    }

    default public boolean[] isEcoActive() {
    }

    default public ClimateFunctionsAvailability getClimateFunctionsAvailability() {
    }

    default public ClimateZoneConfiguration getClimateZoneConfiguration(int n) {
    }

    default public ClimateZoneConfiguration[] getClimateZoneConfigurationAllZones() {
    }

    default public ClimateGeneralConfiguration getClimateGeneralConfiguration() {
    }

    default public ClimateSeatHeaterBalance getSeatHeaterBalanceForZone(int n) {
    }

    default public void changeSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
    }

    default public ClimateSeatVentilatorBalance getSeatVentilatorBalanceForZone(int n) {
    }

    default public void changeSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
    }

    default public boolean getClamp15OnState() {
    }

    default public boolean getClimateSystemState(int n) {
    }

    default public void changeClimateSystemState(ClimateSystemState climateSystemState) {
    }

    default public ClimateAirDistributionCombined getAirDistributionCombinedForZone(int n) {
    }

    default public void changeAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
    }

    default public boolean getFrontWindowHeater() {
    }

    default public void changeFrontWindowHeater(boolean bl) {
    }

    default public boolean getMaxDefrost() {
    }

    default public void changeMaxDefrost(boolean bl) {
    }

    default public boolean getRearWindowHeater() {
    }

    default public void changeRearWindowHeater(boolean bl) {
    }

    default public ClimateAirDistribution getAirDistributionForZone(int n) {
    }

    default public void changeAirDistribution(ClimateAirDistribution climateAirDistribution) {
    }

    default public ClimateAirVolume getAirVolumeForZone(int n) {
    }

    default public void changeAirVolume(ClimateAirVolume climateAirVolume) {
    }
}

