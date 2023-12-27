/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.service;

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
import de.vw.mib.asl.internal.car.climate.ClimateMainController;
import de.vw.mib.asl.internal.car.climate.service.ClimateAirFlowsStyleImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateFuntionsAvailabilityImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatHeaterBalanceImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatHeaterImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatVentilationImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateSeatVentilatorBalanceImpl;
import de.vw.mib.asl.internal.car.climate.service.ClimateServiceValueFactory;
import de.vw.mib.asl.internal.car.climate.service.ClimateTemperatureImpl;
import java.util.ArrayList;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;

public class ClimateServiceImpl
implements ClimateService {
    ClimateMainController climateMainController;
    ClimateServiceValueFactory serviceValueFactory = new ClimateServiceValueFactory();

    public ClimateServiceImpl(ClimateMainController climateMainController) {
        if (this.climateMainController == null) {
            this.climateMainController = climateMainController;
        }
    }

    private ClimateMainController getClimateMainControllerInstance() {
        return this.climateMainController;
    }

    @Override
    public void changeClimateTemperature(int n, ClimateTemperature climateTemperature) {
        this.getClimateMainControllerInstance().setTemperature(this.getZoneFromButtonPosition(n), climateTemperature.getTemperature(), climateTemperature.getUnit());
    }

    @Override
    public ClimateTemperature getClimateTemperatureValueForZone(int n) {
        ClimateTemperatureImpl climateTemperatureImpl;
        switch (n) {
            case 0: {
                climateTemperatureImpl = new ClimateTemperatureImpl(n, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone1.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone1.tempUnit);
                break;
            }
            case 1: {
                climateTemperatureImpl = new ClimateTemperatureImpl(n, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone2.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone2.tempUnit);
                break;
            }
            case 2: {
                climateTemperatureImpl = new ClimateTemperatureImpl(n, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone3.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone3.tempUnit);
                break;
            }
            case 3: {
                climateTemperatureImpl = new ClimateTemperatureImpl(n, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone4.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone4.tempUnit);
                break;
            }
            default: {
                climateTemperatureImpl = null;
                this.getClimateMainControllerInstance().getClimateTarget().writeToLog(1, "getClimateTemperatureValueForZone:Unknown Zone");
            }
        }
        return climateTemperatureImpl;
    }

    @Override
    public ClimateTemperature[] getClimateTemperatures() {
        ClimateTemperature[] climateTemperatureArray = new ClimateTemperature[]{new ClimateTemperatureImpl(this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone1.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone1.tempUnit, 0), new ClimateTemperatureImpl(this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone2.tempValue, this.getClimateMainControllerInstance().getZoneConfigurationListener().airconTempZone2.tempUnit, 1)};
        return climateTemperatureArray;
    }

    @Override
    public boolean isClimateServiceExisting() {
        return this.getClimateMainControllerInstance().isClimateServiceExisting();
    }

    @Override
    public boolean isClimateServiceAvailable() {
        return this.getClimateMainControllerInstance().isClimateServiceAvailable();
    }

    @Override
    public ClimateValueFactory getClimateValueFactory() {
        return this.serviceValueFactory;
    }

    private int getZoneFromButtonPosition(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 8;
                break;
            }
        }
        return n2;
    }

    @Override
    public void changeClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
        this.getClimateMainControllerInstance().setClimateBarProfile(climateAirFlowStyle.getAirFlowMemberZone(), climateAirFlowStyle.getAirFlowStyle());
    }

    @Override
    public ClimateAirFlowStyle getClimateAirFlowStyleForZone(int n) {
        ClimateAirFlowsStyleImpl climateAirFlowsStyleImpl;
        switch (n) {
            case 0: {
                climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(0, this.getClimateMainControllerInstance().getZoneConfigurationListener().styleStateZone1);
                break;
            }
            case 1: {
                climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().styleStateZone2);
                break;
            }
            case 2: {
                climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(2, this.getClimateMainControllerInstance().getZoneConfigurationListener().styleStateZone3);
                break;
            }
            case 3: {
                climateAirFlowsStyleImpl = new ClimateAirFlowsStyleImpl(3, this.getClimateMainControllerInstance().getZoneConfigurationListener().styleStateZone4);
                break;
            }
            default: {
                climateAirFlowsStyleImpl = null;
            }
        }
        return climateAirFlowsStyleImpl;
    }

    @Override
    public void changeClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
        this.getClimateMainControllerInstance().setSeatHeater(climateSeatHeater.getSeatHeaterZone(), climateSeatHeater.getSeatHeater());
    }

    @Override
    public ClimateSeatHeater getClimateSeatHeaterForZone(int n) {
        ClimateSeatHeaterImpl climateSeatHeaterImpl;
        switch (n) {
            case 0: {
                climateSeatHeaterImpl = new ClimateSeatHeaterImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatHeaterFrontLeft);
                break;
            }
            case 1: {
                climateSeatHeaterImpl = new ClimateSeatHeaterImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatHeaterFrontRigth);
                break;
            }
            case 2: {
                climateSeatHeaterImpl = null;
                break;
            }
            case 3: {
                climateSeatHeaterImpl = null;
                break;
            }
            default: {
                climateSeatHeaterImpl = null;
            }
        }
        return climateSeatHeaterImpl;
    }

    @Override
    public void changeClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
        this.getClimateMainControllerInstance().setSeatVentilation(climateSeatVentilation.getSeatVentilationZone(), climateSeatVentilation.getSeatVentilation());
    }

    @Override
    public ClimateSeatVentilation getClimateSeatVentilationForZone(int n) {
        ClimateSeatVentilationImpl climateSeatVentilationImpl;
        switch (n) {
            case 0: {
                climateSeatVentilationImpl = new ClimateSeatVentilationImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatVentilationFrontLeft);
                break;
            }
            case 1: {
                climateSeatVentilationImpl = new ClimateSeatVentilationImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatVentilationFrontRight);
                break;
            }
            case 2: {
                climateSeatVentilationImpl = null;
                break;
            }
            case 3: {
                climateSeatVentilationImpl = null;
                break;
            }
            default: {
                climateSeatVentilationImpl = null;
            }
        }
        return climateSeatVentilationImpl;
    }

    @Override
    public boolean[] isTemperatureChangeViaHMI() {
        boolean[] blArray = new boolean[]{false, false, false, false};
        blArray[0] = this.getClimateMainControllerInstance().getViewOptionCollector().isTemperatureModifiableViaHMIZone1;
        blArray[1] = this.getClimateMainControllerInstance().getViewOptionCollector().isTemperatureModifiableViaHMIZone2;
        blArray[2] = this.getClimateMainControllerInstance().getViewOptionCollector().isTemperatureModifiableViaHMIZone3;
        blArray[3] = this.getClimateMainControllerInstance().getViewOptionCollector().isTemperatureModifiableViaHMIZone4;
        return blArray;
    }

    @Override
    public boolean[] isEcoActive() {
        boolean[] blArray = new boolean[]{false, false, false, false};
        blArray[0] = this.getClimateMainControllerInstance().getZoneConfigurationListener().isEcoZone1;
        blArray[1] = this.getClimateMainControllerInstance().getZoneConfigurationListener().isEcoZone2;
        blArray[2] = this.getClimateMainControllerInstance().getZoneConfigurationListener().isEcoZone3;
        blArray[3] = this.getClimateMainControllerInstance().getZoneConfigurationListener().isEcoZone4;
        return blArray;
    }

    @Override
    public ClimateFunctionsAvailability getClimateFunctionsAvailability() {
        ClimateFuntionsAvailabilityImpl climateFuntionsAvailabilityImpl = new ClimateFuntionsAvailabilityImpl(this.getClimateMainControllerInstance().getViewOptionCollector().tempTypeZone1, this.getClimateMainControllerInstance().getViewOptionCollector().tempTypeZone2, this.getClimateMainControllerInstance().getViewOptionCollector().tempTypeZone3, this.getClimateMainControllerInstance().getViewOptionCollector().tempTypeZone4, this.getClimateMainControllerInstance().getViewOptionCollector().seatHeaterStateZone1, this.getClimateMainControllerInstance().getViewOptionCollector().seatHeaterStateZone2, this.getClimateMainControllerInstance().getViewOptionCollector().seatHeaterStateZone3, this.getClimateMainControllerInstance().getViewOptionCollector().seatHeaterStateZone4, this.getClimateMainControllerInstance().getViewOptionCollector().seatVentilationStateZone1, this.getClimateMainControllerInstance().getViewOptionCollector().seatVentilationStateZone2, this.getClimateMainControllerInstance().getViewOptionCollector().seatVentilationStateZone3, this.getClimateMainControllerInstance().getViewOptionCollector().seatVentilationStateZone4);
        return climateFuntionsAvailabilityImpl;
    }

    @Override
    public ClimateZoneConfiguration getClimateZoneConfiguration(int n) {
        return this.getClimateMainControllerInstance().getClimateConfiguration().zoneConfigurations[n].getCopyClimateZoneConfigurationColletor();
    }

    @Override
    public ClimateZoneConfiguration[] getClimateZoneConfigurationAllZones() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.getClimateMainControllerInstance().getClimateConfiguration().zoneConfigurations.length; ++i2) {
            arrayList.add(this.getClimateMainControllerInstance().getClimateConfiguration().zoneConfigurations[i2].getCopyClimateZoneConfigurationColletor());
        }
        return (ClimateZoneConfiguration[])arrayList.toArray();
    }

    @Override
    public ClimateGeneralConfiguration getClimateGeneralConfiguration() {
        return this.getClimateMainControllerInstance().getClimateConfiguration().generalConfiguration.getCopyofGenearlConfiguration();
    }

    @Override
    public ClimateSeatHeaterBalance getSeatHeaterBalanceForZone(int n) {
        ClimateSeatHeaterBalanceImpl climateSeatHeaterBalanceImpl;
        switch (n) {
            case 0: {
                climateSeatHeaterBalanceImpl = new ClimateSeatHeaterBalanceImpl(0, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatHeaterBalanceFrontLeft);
                break;
            }
            case 1: {
                climateSeatHeaterBalanceImpl = new ClimateSeatHeaterBalanceImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatHeaterBalanceFrontRigth);
                break;
            }
            case 2: {
                climateSeatHeaterBalanceImpl = null;
                break;
            }
            case 3: {
                climateSeatHeaterBalanceImpl = null;
                break;
            }
            default: {
                climateSeatHeaterBalanceImpl = null;
            }
        }
        return climateSeatHeaterBalanceImpl;
    }

    @Override
    public void changeSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
        if (climateSeatHeaterBalance.isSeatHeatingBalanceInDeviceRange()) {
            this.getClimateMainControllerInstance().setSeatHeaterBalance(climateSeatHeaterBalance.getZoneMember(), climateSeatHeaterBalance.getSeatHeatingBalance());
        }
    }

    @Override
    public ClimateSeatVentilatorBalance getSeatVentilatorBalanceForZone(int n) {
        ClimateSeatVentilatorBalanceImpl climateSeatVentilatorBalanceImpl;
        switch (n) {
            case 0: {
                climateSeatVentilatorBalanceImpl = new ClimateSeatVentilatorBalanceImpl(0, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatVentilationBalanceFrontLeft);
                break;
            }
            case 1: {
                climateSeatVentilatorBalanceImpl = new ClimateSeatVentilatorBalanceImpl(1, this.getClimateMainControllerInstance().getZoneConfigurationListener().seatVentilationBalanceFrontRight);
                break;
            }
            case 2: {
                climateSeatVentilatorBalanceImpl = null;
                break;
            }
            case 3: {
                climateSeatVentilatorBalanceImpl = null;
                break;
            }
            default: {
                climateSeatVentilatorBalanceImpl = null;
            }
        }
        return climateSeatVentilatorBalanceImpl;
    }

    @Override
    public void changeSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
        if (climateSeatVentilatorBalance.isSeatVentilatorBalanceInDeviceRange()) {
            this.getClimateMainControllerInstance().setSeatVentilationBalance(climateSeatVentilatorBalance.getZoneMember(), climateSeatVentilatorBalance.getSeatVentilationBalance());
        }
    }

    @Override
    public boolean getClamp15OnState() {
        return this.getClimateMainControllerInstance().isClamp15On();
    }

    @Override
    public boolean getClimateSystemState(int n) {
        boolean bl = false;
        switch (n) {
            case 0: 
            case 1: {
                bl = this.getClimateMainControllerInstance().getZoneConfigurationListener().isClimateSystemOn;
                break;
            }
            case 2: 
            case 3: {
                bl = this.getClimateMainControllerInstance().getZoneConfigurationListener().isButtonRearClimateONOFF;
                break;
            }
        }
        return bl;
    }

    @Override
    public void changeClimateSystemState(ClimateSystemState climateSystemState) {
        switch (climateSystemState.getSystemMemberZone()) {
            case 0: 
            case 1: {
                this.getClimateMainControllerInstance().setClimateSystemStateOfRow(1, climateSystemState.getSystemState());
                break;
            }
            case 2: 
            case 3: {
                this.getClimateMainControllerInstance().setClimateSystemStateOfRow(2, climateSystemState.getSystemState());
                break;
            }
        }
    }

    @Override
    public ClimateAirDistributionCombined getAirDistributionCombinedForZone(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = this.getClimateMainControllerInstance().getZoneConfigurationListener().evaluateAirDistributionCombined(this.getClimateMainControllerInstance().getZoneConfigurationListener().airDistributionZone1);
                break;
            }
            case 1: {
                n2 = this.getClimateMainControllerInstance().getZoneConfigurationListener().evaluateAirDistributionCombined(this.getClimateMainControllerInstance().getZoneConfigurationListener().airDistributionZone2);
                break;
            }
        }
        return this.getClimateValueFactory().createClimateAirDistributionCombined(n, n2);
    }

    @Override
    public void changeAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
        AirconAirDistribution airconAirDistribution = this.getClimateMainControllerInstance().getAirDistributionFromAirDistributionCombined(climateAirDistributionCombined);
        this.getClimateMainControllerInstance().setAirDistribution(climateAirDistributionCombined.getAirDistributionMemberZone(), airconAirDistribution);
    }

    @Override
    public boolean getFrontWindowHeater() {
        return this.getClimateMainControllerInstance().isFrontWindowHeater;
    }

    @Override
    public void changeFrontWindowHeater(boolean bl) {
        this.getClimateMainControllerInstance().setFrontWindowHeater(bl);
    }

    @Override
    public boolean getMaxDefrost() {
        return this.getClimateMainControllerInstance().getZoneConfigurationListener().isFrontMaxDefrost;
    }

    @Override
    public void changeMaxDefrost(boolean bl) {
        this.getClimateMainControllerInstance().setMaxDefrost(bl);
    }

    @Override
    public boolean getRearWindowHeater() {
        return this.getClimateMainControllerInstance().getZoneConfigurationListener().isRearWindowHeater;
    }

    @Override
    public void changeRearWindowHeater(boolean bl) {
        this.getClimateMainControllerInstance().setRearWindowHeater(bl);
    }

    @Override
    public ClimateAirDistribution getAirDistributionForZone(int n) {
        AirconAirDistribution airconAirDistribution = this.getClimateMainControllerInstance().getAirDistributionOfZone(n);
        ClimateAirDistribution climateAirDistribution = this.getClimateValueFactory().createClimateAirDistribution(n, airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, airconAirDistribution.side);
        return climateAirDistribution;
    }

    private AirconAirDistribution transformAirDistribution2InterfaceValue(AirconAirDistribution airconAirDistribution) {
        AirconAirDistribution airconAirDistribution2 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, airconAirDistribution.side);
        airconAirDistribution2.body = this.evaluateAirDistributionValue(airconAirDistribution.body);
        airconAirDistribution2.footwell = this.evaluateAirDistributionValue(airconAirDistribution.footwell);
        airconAirDistribution2.up = this.evaluateAirDistributionValue(airconAirDistribution.up);
        return airconAirDistribution2;
    }

    @Override
    public void changeAirDistribution(ClimateAirDistribution climateAirDistribution) {
        AirconAirDistribution airconAirDistribution = new AirconAirDistribution(climateAirDistribution.getAirDistributionIntValue(3), climateAirDistribution.getAirDistributionIntValue(1), climateAirDistribution.getAirDistributionIntValue(2), climateAirDistribution.getAirDistributionIntValue(4), climateAirDistribution.getAirDistributionBooleanValue(1), climateAirDistribution.getAirDistributionBooleanValue(2), climateAirDistribution.getAirDistributionIntValue(5));
        this.getClimateMainControllerInstance().setAirDistribution(climateAirDistribution.getAirDistributionIntValue(6), airconAirDistribution);
    }

    @Override
    public ClimateAirVolume getAirVolumeForZone(int n) {
        AirconAirVolume airconAirVolume = this.getClimateMainControllerInstance().getAirVolumeOfZone(n);
        ClimateAirVolume climateAirVolume = this.getClimateValueFactory().createClimateAirVolume(n, airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        return climateAirVolume;
    }

    @Override
    public void changeAirVolume(ClimateAirVolume climateAirVolume) {
        AirconAirVolume airconAirVolume = new AirconAirVolume(climateAirVolume.getAirVolumeIntSettings(1), climateAirVolume.getAirVolumeIntSettings(2), climateAirVolume.getAirVolumeIntSettings(3));
        this.getClimateMainControllerInstance().setAirVolume(climateAirVolume.getAirVolumeIntSettings(4), airconAirVolume);
    }

    private int evaluateAirDistributionValue(int n) {
        int n2 = 5;
        n2 = n == 12 ? 12 : 0;
        return n2;
    }

    private boolean transformAirDistributionBooleanValue(boolean bl) {
        boolean bl2 = false;
        if (bl) {
            bl2 = true;
        }
        return bl2;
    }
}

