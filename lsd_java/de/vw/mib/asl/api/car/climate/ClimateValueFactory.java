/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateAirDistribution;
import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowState;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;
import de.vw.mib.asl.api.car.climate.ClimateAirVolume;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;

public interface ClimateValueFactory {
    default public ClimateTemperature createTemperatureValue(int n, int n2, int n3) {
    }

    default public ClimateAirFlowStyle createAirFlowStyleValue(int n, int n2) {
    }

    default public ClimateSeatHeater createSeatHeater(int n, int n2) {
    }

    default public ClimateSeatHeaterBalance createSeatHeaterBalance(int n, int n2) {
    }

    default public ClimateSeatVentilation createSeatVentilation(int n, int n2) {
    }

    default public ClimateSeatVentilatorBalance createSeatVentilatorBalance(int n, int n2) {
    }

    default public ClimateAirFlowState createAirFlowState(int n, int n2) {
    }

    default public ClimateSystemState createClimateSystemState(int n, boolean bl) {
    }

    default public ClimateAirDistributionCombined createClimateAirDistributionCombined(int n, int n2) {
    }

    default public ClimateAirDistribution createClimateAirDistribution(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, int n6) {
    }

    default public ClimateAirVolume createClimateAirVolume(int n, int n2, int n3, int n4) {
    }
}

