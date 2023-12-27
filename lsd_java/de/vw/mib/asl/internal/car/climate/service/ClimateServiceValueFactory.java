/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

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
import de.vw.mib.asl.api.car.climate.ClimateValueFactory;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirDistributionCombinedImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirDistributionImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirFlowStateImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirFlowsStyleImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirVolumeImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatHeaterBalanceImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatHeaterImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatVentilationImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatVentilatorBalanceImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSystemStateImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateTemperatureImpl;

public class ClimateServiceValueFactory
implements ClimateValueFactory {
    @Override
    public ClimateTemperature createTemperatureValue(int n, int n2, int n3) {
        ClimateTemperatureImpl climateTemperatureImpl = new ClimateTemperatureImpl(n, n2, n3);
        return climateTemperatureImpl;
    }

    @Override
    public ClimateAirFlowStyle createAirFlowStyleValue(int n, int n2) {
        ClimateAirFlowsStyleImpl climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(n, n2);
        return climateAirFlowsStyleImpl;
    }

    @Override
    public ClimateSeatHeater createSeatHeater(int n, int n2) {
        ClimateSeatHeaterImpl climateSeatHeaterImpl = new ClimateSeatHeaterImpl(n, n2);
        return climateSeatHeaterImpl;
    }

    @Override
    public ClimateSeatVentilation createSeatVentilation(int n, int n2) {
        ClimateSeatVentilationImpl climateSeatVentilationImpl = new ClimateSeatVentilationImpl(n, n2);
        return climateSeatVentilationImpl;
    }

    @Override
    public ClimateSeatHeaterBalance createSeatHeaterBalance(int n, int n2) {
        ClimateSeatHeaterBalanceImpl climateSeatHeaterBalanceImpl = new ClimateSeatHeaterBalanceImpl(n, n2);
        return climateSeatHeaterBalanceImpl;
    }

    @Override
    public ClimateSeatVentilatorBalance createSeatVentilatorBalance(int n, int n2) {
        ClimateSeatVentilatorBalanceImpl climateSeatVentilatorBalanceImpl = new ClimateSeatVentilatorBalanceImpl(n, n2);
        return climateSeatVentilatorBalanceImpl;
    }

    @Override
    public ClimateAirFlowState createAirFlowState(int n, int n2) {
        ClimateAirFlowStateImpl climateAirFlowStateImpl = new ClimateAirFlowStateImpl(n, n2);
        return climateAirFlowStateImpl;
    }

    @Override
    public ClimateSystemState createClimateSystemState(int n, boolean bl) {
        ClimateSystemStateImpl climateSystemStateImpl = new ClimateSystemStateImpl(n, bl);
        return climateSystemStateImpl;
    }

    @Override
    public ClimateAirDistributionCombined createClimateAirDistributionCombined(int n, int n2) {
        ClimateAirDistributionCombinedImpl climateAirDistributionCombinedImpl = new ClimateAirDistributionCombinedImpl(n, n2);
        return climateAirDistributionCombinedImpl;
    }

    @Override
    public ClimateAirDistribution createClimateAirDistribution(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, int n6) {
        return new ClimateAirDistributionImpl(n, n2, n3, n4, n5, bl, bl2, n6);
    }

    @Override
    public ClimateAirVolume createClimateAirVolume(int n, int n2, int n3, int n4) {
        return new ClimateAirVolumeImpl(n, n2, n3, n4);
    }
}

