/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate.zone_configuration;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.climate.ClimateMainController;
import de.vw.mib.asl.internal.car.climate.PresetCollector;
import de.vw.mib.asl.internal.car.climate.ProfileCollector;
import de.vw.mib.asl.internal.car.climate.SeatHeaterCollector;
import de.vw.mib.asl.internal.car.climate.SeatVentilationCollector;
import de.vw.mib.asl.internal.car.climate.TemperatureButtonCollector;
import de.vw.mib.asl.internal.car.climate.service.ClimateServiceValueFactory;
import de.vw.mib.asl.internal.car.climate.zone_configuration.BaseZoneConfiguationListener;
import edu.emory.mathcs.backport.java.util.Arrays;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderFrontCollector;
import generated.de.vw.mib.asl.internal.climate.transformer.ClimateAirDistributionSliderRearCollector;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;

public abstract class BaseConfiguration
implements BaseZoneConfiguationListener {
    private ClimateMainController mainControllerHandel;
    int ASLZoneConfiguration;
    boolean Zone1SytleExtended;
    boolean Zone2SytleExtended;
    boolean Zone3SytleExtended;
    boolean Zone4SytleExtended;
    boolean isMaxDeforstSupported;
    boolean isMaxACSupported;
    boolean isPresetRearAUTOSupported;
    public boolean isAutoAirVolumeFront = false;
    public boolean isAutoAirDistributionFront = false;
    public boolean isAutoAirVolumeRear = false;
    public boolean isAutoAirDistributionRear = false;
    public boolean isFrontPresetExsit = false;
    public boolean isFrontMaxAC = false;
    public boolean isFrontMaxDefrost = false;
    public boolean isFrontMaxACExist = false;
    public boolean isFrontMaxDefrostExist = false;
    public boolean isRearPresetExist = false;
    public boolean isRearMaxAC = false;
    public boolean isRearMaxDefrost = false;
    public boolean isRearMaxACExist = false;
    public boolean isRearMaxDefrostExist = false;
    public boolean isTemperatureModifiableViaHMI;
    public boolean isEcoZone1 = false;
    public boolean isEcoZone2 = false;
    public boolean isEcoZone3 = false;
    public boolean isEcoZone4 = false;
    public int styleStateZone1 = 0;
    public int styleStateZone2 = 0;
    public int styleStateZone3 = 0;
    public int styleStateZone4 = 0;
    public boolean isButtonFrontACActive = false;
    public boolean isButtonFrontAirFlowWindowActive = false;
    public boolean isButtonFrontAirFlowBodyActive = false;
    public boolean isButttonFrontAirFlowFootWellActive = false;
    public boolean isButtonRearClimateONOFF = false;
    public boolean isButtonRearAirFlowWindowActive = false;
    public boolean isButtonRearAirFlowBodyActive = false;
    public boolean isButtonRearAirFlowFootWellActive = false;
    public boolean isRearWindowOutletAvailable = false;
    public boolean isAutoModeFront = false;
    public boolean isAutoModeRear = false;
    public boolean isRearWindowHeater = false;
    public int seatHeaterFrontLeft = -1;
    public int seatHeaterFrontRigth = -1;
    public int seatVentilationFrontRight = -1;
    public int seatVentilationFrontLeft = -1;
    public int seatHeaterBalanceFrontLeft = -1;
    public int seatHeaterBalanceFrontRigth = -1;
    public int seatHeaterBalanceRearLeft = -1;
    public int seatHeaterBalanceRearRigth = -1;
    public int seatVentilationBalanceFrontRight = -1;
    public int seatVentilationBalanceFrontLeft = -1;
    public int seatVentilationBalanceRearRight = -1;
    public int seatVentilationBalanceRearLeft = -1;
    public final int TEMPERATURE_DISPLAY_NOT_AVAILABLE;
    public final int TEMPERATURE_DISPLAY_TEMPERATURE;
    public final int TEMPERATURE_DISPLAY_TEMPERATURE_STEPS;
    private static final int CLIMATE_TEMP_LOW;
    private static final int CLIMATE_TEMP_HIGH;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS;
    public final int AIR_DISTRIBUTION_SILDER_FONT_MAX;
    public final int AIR_DISTRIBUTION_SILDER_REAR_MAX;
    private static final int CLIMATE_TEMP_MAX_BLUE_ARROW_FAHRENHEIT;
    private static final int CLIMATE_TEMP_MAX_BLUE_ARROW_CELSIUS;
    public final int ZONEFL;
    public final int ZONEFR;
    public final int ZONERL;
    public final int ZONERR;
    public AirconAirDistribution airDistributionZone1 = new AirconAirDistribution();
    public AirconAirDistribution airDistributionZone2 = new AirconAirDistribution();
    public AirconAirDistribution airDistributionZone3 = new AirconAirDistribution();
    public AirconAirDistribution airDistributionZone4 = new AirconAirDistribution();
    public AirconAirVolume airVolumeZone1 = new AirconAirVolume();
    public AirconAirVolume airVolumeZone2 = new AirconAirVolume();
    public AirconAirVolume airVolumeZone3 = new AirconAirVolume();
    public AirconAirVolume airVolumeZone4 = new AirconAirVolume();
    public AirconTemp airconTempZone1 = new AirconTemp();
    public AirconTemp airconTempZone2 = new AirconTemp();
    public AirconTemp airconTempZone3 = new AirconTemp();
    public AirconTemp airconTempZone4 = new AirconTemp();
    public int airConTempStepZone1 = 0;
    public int airConTempStepZone2 = 0;
    public int airConTempStepZone3 = 0;
    public int airConTempStepZone4 = 0;
    public int airconTempStepMaxCount1 = 0;
    public int airconTempStepMaxCount2 = 0;
    public int airconTempStepMaxCount3 = 0;
    public int airconTempStepMaxCount4 = 0;
    public int tempTypeZone1 = 1;
    public int tempTypeZone2 = 1;
    public int tempTypeZone3 = 1;
    public int tempTypeZone4 = 1;
    public boolean airDistributionAvailableZone1 = false;
    public boolean airDistributionAvailableZone2 = false;
    public boolean airDistributionAvailableZone3 = false;
    public boolean airDistributionAvailableZone4 = false;
    public AirconPureAirSetup pureAirActive = new AirconPureAirSetup(false, false, false);
    public int pureAirProgress = 10;
    public AirconSteeringWheelHeater steeringWheelHeater = new AirconSteeringWheelHeater(false, false, false, false, 1);
    public int syncMaster = 0;
    public AirconSynchronisation airconSynchronisation = new AirconSynchronisation();
    public PresetCollector[] presetList = new PresetCollector[]{new PresetCollector(), new PresetCollector()};
    public TemperatureButtonCollector[] temperatureButtonList = new TemperatureButtonCollector[]{new TemperatureButtonCollector(), new TemperatureButtonCollector(), new TemperatureButtonCollector(), new TemperatureButtonCollector(), new TemperatureButtonCollector()};
    public ClimateAirDistributionSliderFrontCollector airVolumeSliderFrontCollector = new ClimateAirDistributionSliderFrontCollector();
    public ClimateAirDistributionSliderFrontCollector[] airVolumeSliderFrontCollectorArray = new ClimateAirDistributionSliderFrontCollector[]{this.airVolumeSliderFrontCollector};
    public ClimateAirDistributionSliderRearCollector airDistributionSliderRearCollector = new ClimateAirDistributionSliderRearCollector();
    public ClimateAirDistributionSliderRearCollector[] airDistributionSliderRearCollectorArray = new ClimateAirDistributionSliderRearCollector[]{this.airDistributionSliderRearCollector};
    public int[] airFlowArrowStateCollector = new int[12];
    public int[] airFlowArrowStateCollectorRearOff = new int[12];
    public ProfileCollector[] climateBarAutoProfileList = new ProfileCollector[]{new ProfileCollector(), new ProfileCollector()};
    public TemperatureButtonCollector[] climateBarTemperatureList = new TemperatureButtonCollector[]{new TemperatureButtonCollector(), new TemperatureButtonCollector()};
    public SeatHeaterCollector[] climateBarSeatHeaterList = new SeatHeaterCollector[]{new SeatHeaterCollector(), new SeatHeaterCollector()};
    public SeatVentilationCollector[] climateBarSeatVentilationList = new SeatVentilationCollector[]{new SeatVentilationCollector(), new SeatVentilationCollector()};
    public boolean isClimateSystemOn = false;
    public boolean isRearControl;

    protected BaseConfiguration(ClimateMainController climateMainController) {
        this.TEMPERATURE_DISPLAY_NOT_AVAILABLE = 0;
        this.TEMPERATURE_DISPLAY_TEMPERATURE = 1;
        this.TEMPERATURE_DISPLAY_TEMPERATURE_STEPS = 2;
        this.AIR_DISTRIBUTION_SILDER_FONT_MAX = 7;
        this.AIR_DISTRIBUTION_SILDER_REAR_MAX = 7;
        this.ZONEFL = 1;
        this.ZONEFR = 2;
        this.ZONERL = 3;
        this.ZONERR = 4;
        this.mainControllerHandel = climateMainController;
        this.informTemperaturToModel();
        this.informPresetCollectorToModel();
        this.informAirFlowArrowStateToModel();
        this.informAirDistributionSliderRearToModel();
        this.informAirDistributionSliderFrontToModel();
    }

    public void updateAirconMaxAC(boolean bl, int n) {
        if (this.isFrontMaxACExist) {
            this.isFrontMaxAC = bl;
            this.evaluatePresetMaxAC();
            this.informPresetCollectorToModel();
        }
    }

    public void updateAirconMaxDefrost(boolean bl, int n) {
        if (this.isFrontMaxDefrostExist) {
            this.isFrontMaxDefrost = bl;
            this.evaluatePresetMaxDefrost();
            this.informPresetCollectorToModel();
        }
        if (this.getMainControllerHandel().getClimateConfiguration().generalConfiguration.maxDefrostAvailability == 2) {
            this.isFrontMaxDefrost = bl;
        }
        this.getMainControllerHandel().getClimateServiceListener().updateAirconMaxDefrost(bl);
    }

    @Override
    public void updateAirconTempStepZone1(int n, int n2, int n3) {
        this.airConTempStepZone1 = n;
        this.airconTempStepMaxCount1 = n2;
        this.temperatureButtonList[0].temperatureValue = n;
        this.temperatureButtonList[0].unit = this.evaluateTemperatureStepUnit(n, n2, this.isEcoZone1);
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconTempStepZone2(int n, int n2, int n3) {
        this.airConTempStepZone2 = n;
        this.airconTempStepMaxCount2 = n2;
        this.temperatureButtonList[1].temperatureValue = n;
        this.temperatureButtonList[1].unit = this.evaluateTemperatureStepUnit(n, n2, this.isEcoZone2);
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconTempStepZone4(int n, int n2, int n3) {
        this.airConTempStepZone4 = n;
        this.airconTempStepMaxCount3 = n2;
        this.temperatureButtonList[4].temperatureValue = n;
        this.temperatureButtonList[4].unit = this.evaluateTemperatureStepUnit(n, n2, this.isEcoZone4);
        this.informTemperaturToModel();
    }

    @Override
    public void updateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        this.airconSynchronisation = new AirconSynchronisation(airconSynchronisation.master, airconSynchronisation.slaveZL1R, airconSynchronisation.slaveZR1R, airconSynchronisation.slaveZL2R, airconSynchronisation.slaveZR2R, airconSynchronisation.slaveZL3R, airconSynchronisation.slaveZR3R);
        this.informSyncToModle();
        this.informClimateBarSyncToModle();
    }

    public void updateAirconAC(boolean bl, int n) {
        this.isButtonFrontACActive = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(-978517760, this.isButtonFrontACActive);
    }

    public void updateAirconRearWindowHeater(boolean bl, int n) {
        this.isRearWindowHeater = bl;
        this.getMainControllerHandel().getClimateServiceListener().updateAirconRearWindowHeater(bl);
    }

    @Override
    public void updateAirconSeatHeaterZone1New(int n, int n2, int n3) {
        this.seatHeaterFrontLeft = n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(286, n2);
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeater(new ClimateServiceValueFactory().createSeatHeater(0, n2));
    }

    @Override
    public void updateAirconSeatVentilationZone1New(int n, int n2, int n3) {
        this.seatVentilationFrontLeft = n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(288, n2);
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilation(new ClimateServiceValueFactory().createSeatVentilation(0, n2));
    }

    @Override
    public void updateAirconSeatHeaterZone2New(int n, int n2, int n3) {
        this.seatHeaterFrontRigth = n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(287, n2);
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeater(new ClimateServiceValueFactory().createSeatHeater(1, n2));
    }

    @Override
    public void updateAirconSeatVentilationZone2New(int n, int n2, int n3) {
        this.seatVentilationFrontRight = n2;
        ServiceManager.aslPropertyManager.valueChangedInteger(289, n2);
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilation(new ClimateServiceValueFactory().createSeatVentilation(1, n2));
    }

    public void updateAirconSeatHeaterDistributionZone1(int n, int n2) {
        this.seatHeaterBalanceFrontLeft = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeaterBalance(new ClimateServiceValueFactory().createSeatHeaterBalance(0, n));
    }

    public void updateAirconSeatHeaterDistributionZone2(int n, int n2) {
        this.seatHeaterBalanceFrontRigth = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeaterBalance(new ClimateServiceValueFactory().createSeatHeaterBalance(1, n));
    }

    public void updateAirconSeatHeaterDistributionZone3(int n, int n2) {
        this.seatHeaterBalanceRearLeft = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeaterBalance(new ClimateServiceValueFactory().createSeatHeaterBalance(2, n));
    }

    public void updateAirconSeatHeaterDistributionZone4(int n, int n2) {
        this.seatHeaterBalanceRearRigth = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatHeaterBalance(new ClimateServiceValueFactory().createSeatHeaterBalance(3, n));
    }

    public void updateAirconSeatVentilationDistributionZone1(int n, int n2) {
        this.seatVentilationBalanceFrontLeft = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilatorBalance(new ClimateServiceValueFactory().createSeatVentilatorBalance(0, n));
    }

    public void updateAirconSeatVentilationDistributionZone2(int n, int n2) {
        this.seatVentilationBalanceFrontRight = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilatorBalance(new ClimateServiceValueFactory().createSeatVentilatorBalance(1, n));
    }

    public void updateAirconSeatVentilationDistributionZone3(int n, int n2) {
        this.seatVentilationBalanceRearLeft = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilatorBalance(new ClimateServiceValueFactory().createSeatVentilatorBalance(2, n));
    }

    public void updateAirconSeatVentilationDistributionZone4(int n, int n2) {
        this.seatVentilationBalanceRearRight = n;
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSeatVentilatorBalance(new ClimateServiceValueFactory().createSeatVentilatorBalance(3, n));
    }

    public void updateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
        this.pureAirActive = new AirconPureAirSetup(airconPureAirSetup.systemOnOff, airconPureAirSetup.ionisator, airconPureAirSetup.fragrance);
        this.pureAirProgress = n;
        this.informPureAirStateToModel();
    }

    public void evaluateAutoModeFront() {
        if (this.isAutoAirDistributionFront && this.isAutoAirVolumeFront) {
            this.isAutoModeFront = true;
            if (!this.airDistributionAvailableZone3) {
                this.isAutoModeRear = true;
            }
        } else {
            this.isAutoModeFront = false;
            if (!this.airDistributionAvailableZone3) {
                this.isAutoModeRear = false;
            }
        }
    }

    public void evaluateAutoModeRear() {
        this.isAutoModeRear = this.isAutoAirDistributionRear && this.isAutoAirVolumeRear;
    }

    public void evaluatePresetFront() {
        if (this.isAutoModeFront) {
            this.presetList[0].presetModeAuto = 2;
            this.presetList[0].presetModeManual = 1;
            this.presetList[0].presetModeMaxAc = this.isFrontMaxACExist ? 1 : 0;
            this.presetList[0].presetModeMaxDefrost = this.isFrontMaxDefrostExist ? 1 : 0;
        } else {
            this.presetList[0].presetModeAuto = 1;
            if (!this.isFrontMaxAC && !this.isFrontMaxDefrost) {
                this.presetList[0].presetModeManual = 2;
            } else {
                this.presetList[0].presetModeManual = 1;
                if (this.isFrontMaxDefrostExist && this.isFrontMaxDefrost) {
                    this.presetList[0].presetModeMaxDefrost = 2;
                }
                if (this.isFrontMaxACExist && this.isFrontMaxAC) {
                    this.presetList[0].presetModeMaxAc = 2;
                }
            }
        }
    }

    public void evaluatePresetMaxAC() {
        if (this.isFrontMaxACExist) {
            if (this.isFrontMaxAC) {
                this.presetList[0].presetModeMaxAc = 2;
                this.presetList[0].presetModeManual = 1;
                this.presetList[0].presetModeAuto = 1;
                this.presetList[0].presetModeMaxDefrost = this.isFrontMaxDefrostExist ? 1 : 0;
            } else {
                this.presetList[0].presetModeMaxAc = 1;
                this.evaluatePresetFront();
                if (this.isFrontMaxDefrost) {
                    this.presetList[0].presetModeMaxDefrost = 2;
                }
            }
        }
    }

    public void evaluatePresetMaxDefrost() {
        if (this.isFrontMaxDefrostExist) {
            if (this.isFrontMaxDefrost) {
                this.presetList[0].presetModeMaxDefrost = 2;
                this.presetList[0].presetModeManual = 1;
                this.presetList[0].presetModeAuto = 1;
                this.presetList[0].presetModeMaxAc = this.isFrontMaxACExist ? 1 : 0;
            } else {
                this.presetList[0].presetModeMaxDefrost = 1;
                this.evaluatePresetFront();
                if (this.isFrontMaxAC) {
                    this.presetList[0].presetModeMaxAc = 2;
                }
            }
        }
    }

    public void evaluatePresetRear() {
        if (this.isAutoModeRear) {
            this.presetList[1].presetModeAuto = 2;
            this.presetList[1].presetModeManual = 1;
        } else {
            this.presetList[1].presetModeAuto = 1;
            this.presetList[1].presetModeManual = 2;
        }
    }

    protected boolean evaluateEcoTempearture(int n) {
        boolean bl = false;
        switch (n) {
            case 4: 
            case 5: 
            case 6: {
                bl = true;
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                bl = false;
                break;
            }
        }
        return bl;
    }

    protected int evaluateTemperatureUnit(AirconTemp airconTemp, boolean bl) {
        int n = 0;
        if (bl) {
            n = 5;
        } else {
            switch (airconTemp.tempUnit) {
                case 0: {
                    if (airconTemp.tempValue >= 60 && airconTemp.tempValue <= 195) {
                        n = 1;
                        break;
                    }
                    if (airconTemp.tempValue == 0 || airconTemp.tempValue < 60) {
                        n = 3;
                        break;
                    }
                    if (airconTemp.tempValue != 255 && airconTemp.tempValue <= 195) break;
                    n = 4;
                    break;
                }
                case 1: {
                    if (airconTemp.tempValue >= 40 && airconTemp.tempValue <= 148) {
                        n = 2;
                        break;
                    }
                    if (airconTemp.tempValue == 0 || airconTemp.tempValue < 40) {
                        n = 3;
                        break;
                    }
                    if (airconTemp.tempValue != 255 && airconTemp.tempValue <= 148) break;
                    n = 4;
                    break;
                }
            }
        }
        return n;
    }

    protected int evaluateTemperatureStepUnit(int n, int n2, boolean bl) {
        int n3 = 0;
        if (bl) {
            n3 = 5;
        } else if (n > 0 && n < n2) {
            n3 = 0;
        } else if (n == 0) {
            n3 = 3;
        } else if (n >= n2) {
            n3 = 4;
        }
        return n3;
    }

    protected int evaluateTemperatureValue(int n, int n2) {
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

    public int evaluateArrowColor(int n, int n2, AirconTemp airconTemp, boolean bl) {
        int n3 = 0;
        if (bl) {
            switch (n) {
                case 1: {
                    n3 = 259;
                    break;
                }
                case 4: {
                    n3 = 771;
                    break;
                }
                case 2: {
                    n3 = 261;
                    break;
                }
                case 5: {
                    n3 = 773;
                    break;
                }
                case 3: {
                    n3 = 265;
                    break;
                }
                case 6: {
                    n3 = 777;
                    break;
                }
                case 0: {
                    n3 = this.airColourDependingOnTemperatureAuto(n2, airconTemp);
                    break;
                }
            }
        } else {
            switch (n) {
                case 1: {
                    n3 = 3;
                    break;
                }
                case 4: {
                    n3 = 515;
                    break;
                }
                case 2: {
                    n3 = 5;
                    break;
                }
                case 5: {
                    n3 = 517;
                    break;
                }
                case 3: {
                    n3 = 9;
                    break;
                }
                case 6: {
                    n3 = 521;
                    break;
                }
                case 0: {
                    n3 = this.airColourDependingOnTemperature(n2, airconTemp);
                    break;
                }
            }
        }
        return n3;
    }

    public int airColourDependingOnTemperature(int n, AirconTemp airconTemp) {
        int n2 = 0;
        if (n == 1) {
            if (airconTemp.tempUnit == 0) {
                n2 = airconTemp.tempValue <= 120 ? 3 : 9;
            } else if (airconTemp.tempUnit == 1) {
                n2 = airconTemp.tempValue <= 88 ? 3 : 9;
            }
        }
        return n2;
    }

    public int airColourDependingOnTemperatureAuto(int n, AirconTemp airconTemp) {
        int n2 = 0;
        if (n == 1) {
            if (airconTemp.tempUnit == 0) {
                n2 = airconTemp.tempValue <= 120 ? 259 : 265;
            } else if (airconTemp.tempUnit == 1) {
                n2 = airconTemp.tempValue <= 88 ? 259 : 265;
            }
        }
        return n2;
    }

    public int evaluateAirDistributionCombined(AirconAirDistribution airconAirDistribution) {
        int n = 0;
        if (airconAirDistribution.up > 0 && airconAirDistribution.body > 0 && airconAirDistribution.footwell > 0) {
            n = 6;
        } else if (airconAirDistribution.up > 0 && airconAirDistribution.footwell > 0) {
            n = 4;
        } else if (airconAirDistribution.body > 0 && airconAirDistribution.footwell > 0) {
            n = 5;
        } else if (airconAirDistribution.body > 0) {
            n = 3;
        } else if (airconAirDistribution.up > 0) {
            n = 1;
        } else if (airconAirDistribution.footwell > 0) {
            n = 2;
        }
        return n;
    }

    public void informPresetCollectorToModel() {
        ListManager.getGenericASLList(-626196224).updateList(this.presetList);
    }

    public void informTemperaturToModel() {
        ListManager.getGenericASLList(-508755712).updateList(this.temperatureButtonList);
    }

    public void informAirDistributionSliderFrontToModel() {
        ListManager.getGenericASLList(-928186112).updateList(this.airVolumeSliderFrontCollectorArray);
    }

    public void informAirDistributionSliderRearToModel() {
        ListManager.getGenericASLList(-911408896).updateList(this.airDistributionSliderRearCollectorArray);
    }

    public void informAirFlowArrowStateToModel() {
        int[] nArray = Arrays.copyOf(this.airFlowArrowStateCollector, this.airFlowArrowStateCollector.length);
        if (!this.mainControllerHandel.isRearClimateSystemON() || this.mainControllerHandel.isTwoZonesMLB()) {
            this.removeRearAirFlow(nArray);
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1045626624, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1028849408, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1012072192, false);
        }
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(-458424064, nArray);
    }

    private void removeRearAirFlow(int[] nArray) {
        for (int i2 = 6; i2 < 12; ++i2) {
            nArray[i2] = 0;
        }
    }

    public void informSyncToModle() {
        if (this.airconSynchronisation.master == 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-441646848, false);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-441646848, true);
        }
    }

    public void informFlyingWindowFrontContentToModel(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public void informPureAirStateToModel() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-223543040, this.pureAirActive.isSystemOnOff());
        ServiceManager.aslPropertyManager.valueChangedInteger(-206765824, this.pureAirProgress);
    }

    public void informClimateBarAutoProfileCollectorToModel() {
        ListManager.getGenericASLList(1117534208).updateList(this.climateBarAutoProfileList);
    }

    public void informClimateBarTemperatureCollectorToModel() {
        ListManager.getGenericASLList(849098752).updateList(this.climateBarTemperatureList);
    }

    public void informClimateBarSyncToModle() {
        if (this.airconSynchronisation.master == 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1100756992, false);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1100756992, true);
        }
    }

    public void informClimateBarSeatHeaterCollectorToModel() {
        ListManager.getGenericASLList(1184643072).updateList(this.climateBarSeatHeaterList);
    }

    public void informClimateBarSeatVentilationCollectorToModel() {
        ListManager.getGenericASLList(1151088640).updateList(this.climateBarSeatVentilationList);
    }

    public void setClimateSystemONOFF(boolean bl) {
        this.isClimateSystemOn = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(304, this.isClimateSystemOn);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-324206336, this.isClimateSystemOn);
        if (this.isClimateSystemOn) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-1280507648, this.isRearControl);
            ServiceManager.aslPropertyManager.valueChangedBoolean(299, this.getMainControllerHandel().getCurrentSteeringWheelHeater().heating);
            ServiceManager.aslPropertyManager.valueChangedBoolean(300, this.getMainControllerHandel().isFrontWindowHeater);
            this.informSyncToModle();
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(-441646848, false);
        }
        this.getMainControllerHandel().getClimateServiceListener().updateClimateSystemState(new ClimateServiceValueFactory().createClimateSystemState(0, bl));
    }

    public ClimateMainController getMainControllerHandel() {
        return this.mainControllerHandel;
    }
}

