/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate.modelclient;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.climate.ClimateAirDistribution;
import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowState;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;
import de.vw.mib.asl.api.car.climate.ClimateAirVolume;
import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateFunctionsAvailability;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateService;
import de.vw.mib.asl.api.car.climate.ClimateServiceListener;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import de.vw.mib.asl.api.car.climate.ClimateZoneConfiguration;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.api.climate.modelclient.AirFlowStyleCollector;
import de.vw.mib.asl.internal.car.api.climate.modelclient.TemperatureButtonCollector;
import de.vw.mib.asl.internal.car.api.climate.modelclient.TemperatureRange;
import de.vw.mib.asl.internal.car.climate.SeatHeaterCollector;
import de.vw.mib.asl.internal.car.climate.SeatVentilationCollector;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;

public class ClimateModelAdapter
extends AbstractASLTarget
implements ClimateServiceListener {
    int CLIMATE_TEMP_LOW = 0;
    int CLIMATE_TEMP_HIGH = 255;
    int CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT = 40;
    int CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS = 60;
    int CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT = 148;
    int CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS = 195;
    public TemperatureButtonCollector[] climateBarTemperatureList = new TemperatureButtonCollector[]{new TemperatureButtonCollector(), new TemperatureButtonCollector()};
    public AirFlowStyleCollector[] climateBarAirFlowCollectorList = new AirFlowStyleCollector[]{new AirFlowStyleCollector(), new AirFlowStyleCollector()};
    public SeatHeaterCollector[] climateBarSeatHeaterList = new SeatHeaterCollector[]{new SeatHeaterCollector(), new SeatHeaterCollector()};
    public SeatVentilationCollector[] climateBarSeatVentilationList = new SeatVentilationCollector[]{new SeatVentilationCollector(), new SeatVentilationCollector()};
    private int[] isTemperatureChangeViaHMI;
    private boolean[] isEcoActive;
    private int currentTemperatureUnit = 0;
    public boolean[] ClimateBarAutoExistenceArray = new boolean[2];
    public boolean[] ClimateBarTemperatureExistenceArray = new boolean[2];
    public boolean[] ClimateBarSeatHeaterExistenceArray = new boolean[2];
    public boolean[] ClimateBarSeatVentilationExistenceArray = new boolean[2];
    private boolean isTempeartureEco = false;
    private boolean[] isAirDistributionCombinedExist = new boolean[2];
    private boolean[] isAirDistributionCombinedWindow = new boolean[2];
    private boolean[] isAirDistributionCombinedWindowFeet = new boolean[2];
    private boolean[] isAirDistributionCombinedFeet = new boolean[2];
    private boolean[] isAirDistributionCombinedBody = new boolean[2];
    private boolean[] isAirDistributionCombinedBodyFeet = new boolean[2];
    private boolean[] isAirDistributionCombinedWindowBodyFeet = new boolean[2];
    private boolean[] isClimateSystemOn = new boolean[2];

    public ClimateModelAdapter(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1806757376;
    }

    private ClimateService getClimateService() {
        return ASLCarFactory.getClimateApi().getClimateService();
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{561330240, 578107456, 544553024, 645216320, 628439104, 695547968, -1132068544, -1115291328, -1148845760, -1182400192, -1098514112, -1165622976});
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.informClimateBarTemperatureCollectorToModel();
                this.informClimateBarAutoAirFlowCollectorToModel();
                this.informClimateBarSeatHeaterCollectorToModel();
                this.informClimateBarSeatVentilationCollectorToModel();
                this.registerOnModelEvents();
                ASLCarFactory.getClimateApi().addClimateServiceListener(this);
                this.informUnitRangeToModel(this.currentTemperatureUnit);
                break;
            }
            case 1073841832: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n2 = eventGeneric.getInt(1);
                    this.increaseDecreaseTemperature(n, n2);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_TEMPERATURE --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1077441825: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n3 = eventGeneric.getInt(1);
                    this.increaseDecreaseTemperature(n, n3);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_BAR_TEMPERATURE_BUTTON --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1077441826: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n4 = eventGeneric.getInt(1);
                    this.setTemperature(n, n4);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_BAR_TEMPERATURE_MENU --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1077441824: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n5 = eventGeneric.getInt(1);
                    this.setAirFlowStyle(n, n5);
                    this.setAirDistributionAuto(n);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_BAR_PROFILE --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1077441830: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n6 = eventGeneric.getInt(1);
                    this.setSeatHeater(n, n6);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_BAR_SEAT_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1077441829: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    int n = eventGeneric.getInt(0);
                    int n7 = eventGeneric.getInt(1);
                    this.setSeatVentilation(n, n7);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_CLIMATE_BAR_SEAT_VENTILATION --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841852: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 3);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_BODY --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841853: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 5);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_BODY_FEET --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841851: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 2);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_FEET --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841849: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 1);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_WINDOW --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841854: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 6);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_WINDOW_BODY_FEET --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841850: {
                if (this.getClimateService().isClimateServiceAvailable()) {
                    this.setClimateAirDistributionCombined(eventGeneric.getInt(0), 4);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("ClimateModelAdapter: SET_AIR_DISTRIBUTION_COMBINED_WINDOW_FEET --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
        }
    }

    @Override
    public void updateClimateTemperature(ClimateTemperature climateTemperature) {
        if (this.isTemperatureChangeViaHMI == null) {
            this.isTemperatureChangeViaHMI = this.temperatureChangeViaHMIModelTransform(this.getClimateService().isTemperatureChangeViaHMI());
        }
        if (this.isEcoActive == null) {
            this.isEcoActive = this.getClimateService().isEcoActive();
        }
        if (climateTemperature.getUnit() != this.currentTemperatureUnit) {
            this.informUnitRangeToModel(climateTemperature.getUnit());
        }
        switch (climateTemperature.getZoneMember()) {
            case 0: {
                this.climateBarTemperatureList[0] = new TemperatureButtonCollector(this.isTemperatureChangeViaHMI[0], this.temperatureValueModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit()), this.temperatureUnitModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit(), this.isEcoActive[0]));
                break;
            }
            case 1: {
                this.climateBarTemperatureList[1] = new TemperatureButtonCollector(this.isTemperatureChangeViaHMI[1], this.temperatureValueModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit()), this.temperatureUnitModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit(), this.isEcoActive[1]));
                break;
            }
            case 2: {
                this.climateBarTemperatureList[2] = new TemperatureButtonCollector(this.isTemperatureChangeViaHMI[2], this.temperatureValueModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit()), this.temperatureUnitModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit(), this.isEcoActive[2]));
                break;
            }
            case 3: {
                this.climateBarTemperatureList[3] = new TemperatureButtonCollector(this.isTemperatureChangeViaHMI[3], this.temperatureValueModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit()), this.temperatureUnitModelTransform(climateTemperature.getTemperature(), climateTemperature.getUnit(), this.isEcoActive[3]));
                break;
            }
        }
        this.informClimateBarTemperatureCollectorToModel();
    }

    @Override
    public void updateClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
        switch (climateAirFlowStyle.getAirFlowMemberZone()) {
            case 0: {
                this.climateBarAirFlowCollectorList[0] = new AirFlowStyleCollector(this.airFlowStyleModelTransform(climateAirFlowStyle.getAirFlowStyle()));
                break;
            }
            case 1: {
                this.climateBarAirFlowCollectorList[1] = new AirFlowStyleCollector(this.airFlowStyleModelTransform(climateAirFlowStyle.getAirFlowStyle()));
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
        }
        this.informClimateBarAutoAirFlowCollectorToModel();
    }

    @Override
    public void updateClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
        switch (climateSeatHeater.getSeatHeaterZone()) {
            case 0: {
                this.climateBarSeatHeaterList[0] = new SeatHeaterCollector(climateSeatHeater.getSeatHeater());
                break;
            }
            case 1: {
                this.climateBarSeatHeaterList[1] = new SeatHeaterCollector(climateSeatHeater.getSeatHeater());
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
        }
        this.informClimateBarSeatHeaterCollectorToModel();
    }

    @Override
    public void updateClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
        switch (climateSeatVentilation.getSeatVentilationZone()) {
            case 0: {
                this.climateBarSeatVentilationList[0] = new SeatVentilationCollector(climateSeatVentilation.getSeatVentilation());
                break;
            }
            case 1: {
                this.climateBarSeatVentilationList[1] = new SeatVentilationCollector(climateSeatVentilation.getSeatVentilation());
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
        }
        this.informClimateBarSeatVentilationCollectorToModel();
    }

    @Override
    public void updateClimateFuntionAvailability(ClimateFunctionsAvailability climateFunctionsAvailability) {
        this.ClimateBarTemperatureExistenceArray[0] = this.evaluateFunctionAvailableState(climateFunctionsAvailability.getTemperatureAvailabilityZone1());
        this.ClimateBarTemperatureExistenceArray[1] = this.evaluateFunctionAvailableState(climateFunctionsAvailability.getTemperatureAvailabilityZone2());
        this.informClimateBarTemperatureButtonExistenceToModle();
    }

    @Override
    public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
        ClimateZoneConfiguration climateZoneConfiguration = climateConfiguration.getConfigurationOfZone(0);
        ClimateZoneConfiguration climateZoneConfiguration2 = climateConfiguration.getConfigurationOfZone(1);
        this.ClimateBarTemperatureExistenceArray[0] = this.evaluateFunctionAvailableState(climateZoneConfiguration.getSeatHeaterDistributionAvailability());
        this.ClimateBarTemperatureExistenceArray[1] = this.evaluateFunctionAvailableState(climateZoneConfiguration2.getSeatHeaterDistributionAvailability());
        this.isAirDistributionCombinedExist[0] = climateZoneConfiguration.getAirDistributionCombinedAvailability() == 2;
        this.isAirDistributionCombinedExist[1] = climateZoneConfiguration2.getAirDistributionCombinedAvailability() == 2;
        this.informPureAirExistenceToModel(climateConfiguration.getGenearlClimateConfiguration().getExistance(2));
        this.informFreshAirExistenceToModel(climateConfiguration.getGenearlClimateConfiguration().getExistance(3));
        if (climateConfiguration.getGenearlClimateConfiguration().getDriverSide() == 1) {
            this.informIonisatorExistenceToModel(climateConfiguration.getConfigurationOfZone(0).getExistance(1));
        } else if (climateConfiguration.getGenearlClimateConfiguration().getDriverSide() == 2) {
            this.informIonisatorExistenceToModel(climateConfiguration.getConfigurationOfZone(1).getExistance(1));
        }
        this.informAirDistributionCombineExistenceToModle();
    }

    @Override
    public void updateClimateAirFlowState(ClimateAirFlowState climateAirFlowState) {
        switch (climateAirFlowState.getAirFlowState()) {
            case 4: 
            case 5: 
            case 6: {
                this.isTempeartureEco = true;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.isTempeartureEco = false;
                break;
            }
        }
        this.informClimateBarAirFlowStateEcoToModle();
    }

    @Override
    public void updateClimateSystemState(ClimateSystemState climateSystemState) {
        switch (climateSystemState.getSystemMemberZone()) {
            case 0: {
                this.isClimateSystemOn[0] = climateSystemState.getSystemState();
                this.informClimateBarSystemStateFrontToModle();
                break;
            }
            case 2: {
                this.isClimateSystemOn[2] = climateSystemState.getSystemState();
                this.informClimateBarSystemStateRearToModle();
                break;
            }
        }
    }

    @Override
    public void updateClimateAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
        switch (climateAirDistributionCombined.getAirDistributionMemberZone()) {
            case 0: {
                this.evaluateAirDistributionCombined(0, climateAirDistributionCombined.getAirDistibutionCombined());
                break;
            }
            case 1: {
                this.evaluateAirDistributionCombined(1, climateAirDistributionCombined.getAirDistibutionCombined());
                break;
            }
        }
    }

    @Override
    public void updateClamp15State(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(865875968, bl);
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
    public void updateClimateSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
    }

    @Override
    public void updateClimateSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
    }

    private void increaseDecreaseTemperature(int n, int n2) {
        if (n < 2) {
            ClimateTemperature climateTemperature = this.getClimateService().getClimateTemperatureValueForZone(this.temperatureZoneDSITransform(n));
            climateTemperature = n2 == 0 ? climateTemperature.decreaseTemperature() : climateTemperature.increaseTemperature();
            this.getClimateService().changeClimateTemperature(this.temperatureZoneDSITransform(n), climateTemperature);
        }
    }

    private void setTemperature(int n, int n2) {
        n = this.temperatureZoneDSITransform(n);
        ClimateTemperature climateTemperature = this.getClimateService().getClimateTemperatureValueForZone(n);
        int n3 = this.tempearatureValueDSITransform(n2, climateTemperature.getUnit());
        ClimateTemperature climateTemperature2 = this.getClimateService().getClimateValueFactory().createTemperatureValue(n, n3, climateTemperature.getUnit());
        this.getClimateService().changeClimateTemperature(n, climateTemperature2);
    }

    private void setAirFlowStyle(int n, int n2) {
        this.getClimateService().changeClimateAirFlowStyle(this.getClimateService().getClimateValueFactory().createAirFlowStyleValue(n, n2));
    }

    private void setSeatHeater(int n, int n2) {
        this.getClimateService().changeClimateSeatHeater(this.getClimateService().getClimateValueFactory().createSeatHeater(n, n2));
    }

    private void setSeatVentilation(int n, int n2) {
        this.getClimateService().changeClimateSeatVentilation(this.getClimateService().getClimateValueFactory().createSeatVentilation(n, n2));
    }

    private void setClimateSystemState(int n, boolean bl) {
        this.getClimateService().changeClimateSystemState(this.getClimateService().getClimateValueFactory().createClimateSystemState(n, bl));
    }

    private void setClimateAirDistributionCombined(int n, int n2) {
        if (this.getClimateService().isClimateServiceAvailable()) {
            this.getClimateService().changeAirDistributionCombined(this.getClimateService().getClimateValueFactory().createClimateAirDistributionCombined(n, n2));
        }
    }

    private void setAirDistributionAuto(int n) {
        ClimateAirDistribution climateAirDistribution = this.getClimateService().getAirDistributionForZone(n);
        climateAirDistribution = climateAirDistribution.modifyAirDistributionBooleanValue(1, true);
        climateAirDistribution = climateAirDistribution.modifyAirDistributionIntValue(1, 0);
        climateAirDistribution = climateAirDistribution.modifyAirDistributionIntValue(2, 0);
        climateAirDistribution = climateAirDistribution.modifyAirDistributionIntValue(3, 0);
        this.getClimateService().changeAirDistribution(climateAirDistribution);
        ClimateAirVolume climateAirVolume = this.getClimateService().getAirVolumeForZone(n);
        this.getClimateService().changeAirVolume(climateAirVolume.modifiyAirVolume(3, 1));
    }

    private boolean evaluateFunctionAvailableState(int n) {
        boolean bl = false;
        switch (n) {
            case 2: {
                bl = true;
                break;
            }
            case 0: 
            case 1: 
            case 3: {
                bl = false;
                break;
            }
        }
        return bl;
    }

    protected int temperatureValueModelTransform(int n, int n2) {
        int n3 = 0;
        switch (n2) {
            case 0: {
                n3 = n + 100;
                break;
            }
            case 1: {
                n3 = (n / 4 + 50) * 10;
                break;
            }
        }
        return n3;
    }

    private int tempearatureValueDSITransform(int n, int n2) {
        int n3 = 0;
        switch (n2) {
            case 0: {
                n3 = n - 100;
                break;
            }
            case 1: {
                n3 = (n / 10 - 50) * 4;
                break;
            }
        }
        return n3;
    }

    private int temperatureUnitModelTransform(int n, int n2, boolean bl) {
        int n3 = 0;
        if (bl) {
            n3 = 5;
        } else {
            switch (n2) {
                case 0: {
                    if (n >= this.CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS && n <= this.CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS) {
                        n3 = 1;
                        break;
                    }
                    if (n == this.CLIMATE_TEMP_LOW || n < this.CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS) {
                        n3 = 3;
                        break;
                    }
                    if (n != this.CLIMATE_TEMP_HIGH && n <= this.CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS) break;
                    n3 = 4;
                    break;
                }
                case 1: {
                    if (n >= this.CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT && n <= this.CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT) {
                        n3 = 2;
                        break;
                    }
                    if (n == this.CLIMATE_TEMP_LOW || n < this.CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT) {
                        n3 = 3;
                        break;
                    }
                    if (n != this.CLIMATE_TEMP_HIGH && n <= this.CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT) break;
                    n3 = 4;
                    break;
                }
            }
        }
        return n3;
    }

    private int[] temperatureChangeViaHMIModelTransform(boolean[] blArray) {
        int[] nArray = new int[]{0, 0, 0, 0};
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            nArray[i2] = blArray[i2] ? 1 : 0;
        }
        return nArray;
    }

    private int temperatureZoneDSITransform(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: 
            case 3: {
                n2 = 2;
                break;
            }
            case 4: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    private int airFlowStyleModelTransform(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    private void evaluateAirDistributionCombined(int n, int n2) {
        switch (n2) {
            case 3: {
                this.isAirDistributionCombinedBody[n] = true;
                this.informAirDistributionCombinedBodyToModel();
                break;
            }
            case 5: {
                this.isAirDistributionCombinedBodyFeet[n] = true;
                this.informAirDistributionCombinedBodyFeetToModel();
                break;
            }
            case 2: {
                this.isAirDistributionCombinedFeet[n] = true;
                this.informAirDistributionCombinedFeetToModel();
                break;
            }
            case 1: {
                this.isAirDistributionCombinedWindow[n] = true;
                this.informAirDistributionCombinedWindowToModel();
                break;
            }
            case 6: {
                this.isAirDistributionCombinedWindowBodyFeet[n] = true;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                break;
            }
            case 4: {
                this.isAirDistributionCombinedWindowFeet[n] = true;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
        }
        this.modifyAirDistributionCombined(n, n2);
    }

    private void modifyAirDistributionCombined(int n, int n2) {
        switch (n2) {
            case 3: {
                this.isAirDistributionCombinedBodyFeet[n] = false;
                this.informAirDistributionCombinedBodyFeetToModel();
                this.isAirDistributionCombinedFeet[n] = false;
                this.informAirDistributionCombinedFeetToModel();
                this.isAirDistributionCombinedWindow[n] = false;
                this.informAirDistributionCombinedWindowToModel();
                this.isAirDistributionCombinedWindowBodyFeet[n] = false;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                this.isAirDistributionCombinedWindowFeet[n] = false;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
            case 5: {
                this.isAirDistributionCombinedBody[n] = false;
                this.informAirDistributionCombinedBodyToModel();
                this.isAirDistributionCombinedFeet[n] = false;
                this.informAirDistributionCombinedFeetToModel();
                this.isAirDistributionCombinedWindow[n] = false;
                this.informAirDistributionCombinedWindowToModel();
                this.isAirDistributionCombinedWindowBodyFeet[n] = false;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                this.isAirDistributionCombinedWindowFeet[n] = false;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
            case 2: {
                this.isAirDistributionCombinedBody[n] = false;
                this.informAirDistributionCombinedBodyToModel();
                this.isAirDistributionCombinedBodyFeet[n] = false;
                this.informAirDistributionCombinedBodyFeetToModel();
                this.isAirDistributionCombinedWindow[n] = false;
                this.informAirDistributionCombinedWindowToModel();
                this.isAirDistributionCombinedWindowBodyFeet[n] = false;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                this.isAirDistributionCombinedWindowFeet[n] = false;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
            case 1: {
                this.isAirDistributionCombinedBody[n] = false;
                this.informAirDistributionCombinedBodyToModel();
                this.isAirDistributionCombinedBodyFeet[n] = false;
                this.informAirDistributionCombinedBodyFeetToModel();
                this.isAirDistributionCombinedFeet[n] = false;
                this.informAirDistributionCombinedFeetToModel();
                this.isAirDistributionCombinedWindowBodyFeet[n] = false;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                this.isAirDistributionCombinedWindowFeet[n] = false;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
            case 6: {
                this.isAirDistributionCombinedBody[n] = false;
                this.informAirDistributionCombinedBodyToModel();
                this.isAirDistributionCombinedBodyFeet[n] = false;
                this.informAirDistributionCombinedBodyFeetToModel();
                this.isAirDistributionCombinedFeet[n] = false;
                this.informAirDistributionCombinedFeetToModel();
                this.isAirDistributionCombinedWindow[n] = false;
                this.informAirDistributionCombinedWindowToModel();
                this.isAirDistributionCombinedWindowFeet[n] = false;
                this.informAirDistributionCombinedWindowFeetToModel();
                break;
            }
            case 4: {
                this.isAirDistributionCombinedBody[n] = false;
                this.informAirDistributionCombinedBodyToModel();
                this.isAirDistributionCombinedBodyFeet[n] = false;
                this.informAirDistributionCombinedBodyFeetToModel();
                this.isAirDistributionCombinedFeet[n] = false;
                this.informAirDistributionCombinedFeetToModel();
                this.isAirDistributionCombinedWindow[n] = false;
                this.informAirDistributionCombinedWindowToModel();
                this.isAirDistributionCombinedWindowBodyFeet[n] = false;
                this.informAirDistributionCombinedWindowBodyFeetToModel();
                break;
            }
        }
    }

    private void informUnitRangeToModel(int n) {
        TemperatureRange temperatureRange = new TemperatureRange();
        if (n == 0) {
            ListManager.getGenericASLList(1520187392).updateList(temperatureRange.celsiusRange.toArray());
            super.getClass();
            ServiceManager.aslPropertyManager.valueChangedInteger(1033648128, 155);
            super.getClass();
            ServiceManager.aslPropertyManager.valueChangedInteger(1050425344, 300);
        } else {
            ListManager.getGenericASLList(1520187392).updateList(temperatureRange.fahrenheitRange.toArray());
            super.getClass();
            ServiceManager.aslPropertyManager.valueChangedInteger(1033648128, 590);
            super.getClass();
            ServiceManager.aslPropertyManager.valueChangedInteger(1050425344, 880);
        }
    }

    private void informClimateBarTemperatureCollectorToModel() {
        ListManager.getGenericASLList(849098752).updateList(this.climateBarTemperatureList);
    }

    private void informClimateBarAutoAirFlowCollectorToModel() {
        ListManager.getGenericASLList(1117534208).updateList(this.climateBarAirFlowCollectorList);
    }

    private void informClimateBarSeatHeaterCollectorToModel() {
        ListManager.getGenericASLList(1184643072).updateList(this.climateBarSeatHeaterList);
    }

    private void informClimateBarSeatVentilationCollectorToModel() {
        ListManager.getGenericASLList(1151088640).updateList(this.climateBarSeatVentilationList);
    }

    private void informClimateBarTemperatureButtonExistenceToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(1016870912, this.ClimateBarTemperatureExistenceArray);
    }

    private void informClimateBarAirFlowStateEcoToModle() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1536964608, this.isTempeartureEco);
    }

    private void informClimateBarSystemStateFrontToModle() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(882653184, this.isClimateSystemOn[0]);
    }

    private void informClimateBarSystemStateRearToModle() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(882653184, this.isClimateSystemOn[2]);
    }

    private void informAirDistributionCombineExistenceToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-139656960, this.isAirDistributionCombinedExist);
    }

    private void informAirDistributionCombinedBodyToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-72548096, this.isAirDistributionCombinedBody);
    }

    private void informAirDistributionCombinedBodyFeetToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-55770880, this.isAirDistributionCombinedBodyFeet);
    }

    private void informAirDistributionCombinedFeetToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-89325312, this.isAirDistributionCombinedFeet);
    }

    private void informAirDistributionCombinedWindowToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-122879744, this.isAirDistributionCombinedWindow);
    }

    private void informAirDistributionCombinedWindowFeetToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-106102528, this.isAirDistributionCombinedWindowFeet);
    }

    private void informAirDistributionCombinedWindowBodyFeetToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-38993664, this.isAirDistributionCombinedWindowBodyFeet);
    }

    private void informPureAirExistenceToModel(int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-257097472, n == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-240320256, n == 2);
    }

    private void informFreshAirExistenceToModel(int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-22216448, n == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-5439232, n == 2);
    }

    private void informIonisatorExistenceToModel(int n) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(28180736, n == 2);
        ServiceManager.aslPropertyManager.valueChangedBoolean(44957952, n == 2);
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

