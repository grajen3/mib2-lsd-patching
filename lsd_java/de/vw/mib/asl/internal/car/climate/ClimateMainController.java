/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateServiceListener;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.climate.ClimateStyleController;
import de.vw.mib.asl.internal.car.climate.ClimateTargetServices;
import de.vw.mib.asl.internal.car.climate.ClimateViewOptionCollector;
import de.vw.mib.asl.internal.car.climate.HsmTargetCarClimate;
import de.vw.mib.asl.internal.car.climate.collector.ClimateConfigurationCollector;
import de.vw.mib.asl.internal.car.climate.service.ClimateServiceImpl;
import de.vw.mib.asl.internal.car.climate.zone_configuration.BaseConfiguration;
import de.vw.mib.asl.internal.car.climate.zone_configuration.FourZonesAvailable;
import de.vw.mib.asl.internal.car.climate.zone_configuration.KME;
import de.vw.mib.asl.internal.car.climate.zone_configuration.Zone1Zone2Available;
import de.vw.mib.asl.internal.car.climate.zone_configuration.Zone1Zone2Zone3Available;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.lang.reflect.Field;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowConfiguration;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeaterViewOptions;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.AirconZoneViewOptions;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.powermanagement.ClampSignal;

public class ClimateMainController {
    public boolean existZone1 = false;
    public boolean existZone2 = false;
    public boolean existZone3 = false;
    public boolean existZone4 = false;
    boolean sytleExtendedZone1 = false;
    boolean sytleExtendedZone2 = false;
    boolean sytleExtendedZone3 = false;
    boolean sytleExtendedZone4 = false;
    boolean isOldClimateDevice = false;
    public final int ZONE_UNKNOWN;
    public final int ZONE1;
    public final int ZONE1AUTO_ZONE2AUTO;
    public final int ZONE1MANUALZONE2MANUAL;
    public final int ZONE1MANUALZONE3MANUAL;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3AUTO;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL;
    public final int ZONE1MANUAL_ZONE2MANUAL_ZONE3MANUAL;
    public final int ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4AUTO;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4MANUAL;
    public final int ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO_ZONE4AUTO;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4MANUAL;
    public final int ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4AUTO;
    public final int KME;
    public final int AIR_DISTRIBUTION_COMBINED_LOW;
    public final int AIR_DISTRIBUTION_COMBINED_HIGH;
    private static final int CLIMATE_TEMP_LOW;
    private static final int CLIMATE_TEMP_HIGH;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_LOW_CELSIUS;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_FAHRENHEIT;
    private static final int CLIMATE_TEMP_LIMIT_BEFORE_HI_CELSIUS;
    private static final int CLIMATE_TEMP_STEP_SIZE_CELSIUS;
    private static final int CLIMATE_TEMP_STEP_SIZE_FAHRENHEIT;
    public static final int CLIMATE_TEMPERATURE_ZONE_1;
    public static final int CLIMATE_TEMPERATURE_ZONE_2;
    public static final int CLIMATE_TEMPERATURE_ZONE_3;
    public static final int CLIMATE_TEMPERATURE_ZONE_4;
    public int currentZoneConfiguration = 0;
    public int previousZoneConfiguration = 0;
    public BaseConfiguration currentZoneConfiguationListener = null;
    private ClimateStyleController climateStyleController;
    private boolean isRearClimateSystemON = false;
    public boolean isAutoAirVolumeFront = false;
    public boolean isAutoAirDistributionFront = false;
    public boolean isAutoAirVolumeRear = false;
    public boolean isAutoAirDistributionRear = false;
    public boolean isMaxAC = false;
    public boolean isMaxDefrost = false;
    public boolean seatHeaterPopupAllowed;
    public static final int TEMPERATURE_TYPE_UNKNOWN;
    public static final int TEMPERATURE;
    public static final int STEPS;
    public boolean isAutoModeFront = false;
    public boolean isAutoModeRear = false;
    public boolean isRow1 = false;
    public boolean isRow2 = false;
    public boolean[] temperatureButtonExistenceArray = new boolean[5];
    public boolean[] temperatureButtonExistenceArrayRearOff = new boolean[]{true, true, false, false, false};
    public boolean[] temperatureButtonExistenceArrayECOPluse = new boolean[]{false, false, false, false, false};
    public boolean[] flyingWindowExistenceArray = new boolean[2];
    public boolean[] presetExistenceArray = new boolean[2];
    public boolean[] presetExistenceArrayRearOff = new boolean[]{true, false};
    public boolean[] ClimateBarAutoExistenceArray = new boolean[2];
    public boolean[] ClimateBarTemperatureExistenceArray = new boolean[2];
    public boolean[] ClimateBarSeatHeaterExistenceArray = new boolean[2];
    public boolean[] ClimateBarSeatVentilationExistenceArray = new boolean[2];
    private AirconSteeringWheelHeaterViewOptions steeringWheelViewOptions;
    private boolean isClamp15On = false;
    private ClimateTargetServices climateTarget;
    private ClimateViewOptionCollector viewOptionCollector = new ClimateViewOptionCollector();
    private ClimateServiceImpl climateService;
    private ClimateConfigurationCollector climateConfiguration = new ClimateConfigurationCollector();
    private boolean isClimateServiceExisting;
    private boolean isClimateServiceAvailable;
    public boolean isPureAirUpdateRegistered;
    public boolean isrow1ViewOptionsRegistered;
    public boolean isrow2ViewOptionsRegistered;
    public boolean isZone1SeatHeaterRegistered;
    public boolean isZone2SeatHeaterRegistered;
    public boolean isZone3SeatHeaterRegistered;
    public boolean isZone4SeatHeaterRegistered;
    public boolean isZone1SeatVentilationRegistered;
    public boolean isZone2SeatVentilationRegistered;
    public boolean isZone3SeatVentilationRegistered;
    public boolean isZone4SeatVentilationRegistered;
    public boolean isZone1TempeatureRegistered;
    public boolean isZone2TempeatureRegistered;
    public boolean isZone3TempeatureRegistered;
    public boolean isZone4TempeatureRegistered;
    public boolean isZone1TempeatureStepRegistered;
    public boolean isZone2TempeatureStepRegistered;
    public boolean isZone3TempeatureStepRegistered;
    public boolean isZone4TempeatureStepRegistered;
    public boolean isSeatHeaterPopupLeftOpen = false;
    public boolean isSeatHeaterPopupRightOpen = false;
    public boolean isTemperaturePopupLeftOpen = false;
    public boolean isTemperaturePopupRightOpen = false;
    private AirconContent lastAirconContent = new AirconContent();
    private AirconSteeringWheelHeater currentSteeringWheelHeater = new AirconSteeringWheelHeater(false, false, false, false, 1);
    public boolean isFrontWindowHeater = false;
    public boolean isautoWindowHeater = false;
    public boolean isButtonFrontAirCirculationManActive = false;
    public boolean isAutoAirCirculation = false;
    public boolean isAuxiliaryHeating = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ClimateServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$global$CarViewOption;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ClimateService;

    ClimateStyleController getClimateStyleController() {
        return this.climateStyleController;
    }

    public void setRearClimateSystemON(boolean bl) {
        this.isRearClimateSystemON = bl;
    }

    public boolean isRearClimateSystemON() {
        return this.isRearClimateSystemON;
    }

    void setRearClimateONOFF(boolean bl) {
        this.setRearClimateSystemON(bl);
        this.getZoneConfigurationListener().informAirFlowArrowStateToModel();
        this.setRearFunctionsState();
    }

    void toggleRearClimateState() {
        this.climateTarget.getCarAirconDSI().setAirconSystemOnOffRow(2, !this.isRearClimateSystemON());
    }

    public ClimateMainController(HsmTargetCarClimate hsmTargetCarClimate) {
        this.ZONE_UNKNOWN = 0;
        this.ZONE1 = 1;
        this.ZONE1AUTO_ZONE2AUTO = 2;
        this.ZONE1MANUALZONE2MANUAL = 3;
        this.ZONE1MANUALZONE3MANUAL = 13;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO = 4;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL = 5;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3MANUAL = 6;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO = 7;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4AUTO = 8;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4MANUAL = 9;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO_ZONE4AUTO = 10;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4MANUAL = 11;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4AUTO = 12;
        this.KME = 14;
        this.AIR_DISTRIBUTION_COMBINED_LOW = 0;
        this.AIR_DISTRIBUTION_COMBINED_HIGH = 12;
        this.climateTarget = hsmTargetCarClimate;
        this.climateStyleController = new ClimateStyleController(hsmTargetCarClimate);
    }

    public ClimateMainController() {
        this.ZONE_UNKNOWN = 0;
        this.ZONE1 = 1;
        this.ZONE1AUTO_ZONE2AUTO = 2;
        this.ZONE1MANUALZONE2MANUAL = 3;
        this.ZONE1MANUALZONE3MANUAL = 13;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO = 4;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL = 5;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3MANUAL = 6;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO = 7;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4AUTO = 8;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4MANUAL = 9;
        this.ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO_ZONE4AUTO = 10;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4MANUAL = 11;
        this.ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4AUTO = 12;
        this.KME = 14;
        this.AIR_DISTRIBUTION_COMBINED_LOW = 0;
        this.AIR_DISTRIBUTION_COMBINED_HIGH = 12;
    }

    public ClimateServiceListener getClimateServiceListener() {
        return (ClimateServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$climate$ClimateServiceListener == null ? (class$de$vw$mib$asl$api$car$climate$ClimateServiceListener = ClimateMainController.class$("de.vw.mib.asl.api.car.climate.ClimateServiceListener")) : class$de$vw$mib$asl$api$car$climate$ClimateServiceListener);
    }

    public int evaluateClimateDeviceConfiguation(ClimateViewOptionCollector climateViewOptionCollector) {
        int n = 0;
        this.currentZoneConfiguration = n = this.identifyZoneConfig(climateViewOptionCollector);
        this.evaluateClimateServiceAvailable(this.currentZoneConfiguration);
        if (this.currentZoneConfiguration != 0 && this.currentZoneConfiguration != 14) {
            if (this.currentZoneConfiguationListener == null) {
                this.currentZoneConfiguationListener = this.createConfigurationListener(this.currentZoneConfiguration);
            } else if (this.currentZoneConfiguration != this.previousZoneConfiguration) {
                this.currentZoneConfiguationListener = this.createConfigurationListener(this.currentZoneConfiguration);
            }
            this.evaluateTemperatureButtonViewOption(this.currentZoneConfiguration);
            this.updateTemperatureButtonExistencyToModle();
            this.identifyOldClimate(this.currentZoneConfiguration);
            this.evaluateFlyingWindowViewOption(climateViewOptionCollector);
            this.updateFlyingWindowExistencyToModel();
            this.evaluatePresetViewOption(climateViewOptionCollector);
            this.updatePresetExistencyToModel();
            this.getZoneConfigurationListener().informPresetCollectorToModel();
            this.evaluateTemperatureModifiableViaHMI(climateViewOptionCollector);
            this.fillTemperatureColletorModifiableViaHMI();
            this.evaluateTemperatureButtonViewOption(this.currentZoneConfiguration);
            this.evaluateClimateInformation(climateViewOptionCollector);
            this.evaluateSeatHeaterPopUp(climateViewOptionCollector);
            if (!this.isOldClimateDevice) {
                this.evaluateSyncExistence(climateViewOptionCollector);
            }
            this.evaluateSyncMaster(climateViewOptionCollector);
            this.evaluateAirDistribution(climateViewOptionCollector);
            this.conditionalTemperatureUpdateRegistration();
            this.evaluateRearLockExistence(climateViewOptionCollector);
            this.evaluateAutoAirCirculation(climateViewOptionCollector);
            this.evaluateAutoFrontWindowHeater(climateViewOptionCollector);
            this.updateClimateBarTemperatureButtonExistencyToModle();
            this.evaluateSeatHeaterExistence(climateViewOptionCollector);
            this.updateClimateBarSeatHeaterExistencyToModle();
            this.evaluateSeatVentilationExistence(climateViewOptionCollector);
            this.updateClimateBarSeatVentilationExistencyToModle();
            this.evaluateSeatHeaterBalanceExistence();
            this.evaluateSeatVentilatorBalanceExistence();
            this.updateSetupButtonToModel();
            this.evaluateSteeringWheelViewOptions(climateViewOptionCollector);
            CarPersistenceServiceImpl.getInstance().loadCar().setClimateSetupButton(climateViewOptionCollector.isSetupButtonZone1);
            this.evaluateFrontWindowHeater(climateViewOptionCollector);
            CarPersistenceServiceImpl.getInstance().loadCar().setFrontWindowHeater(!climateViewOptionCollector.isSetupButtonZone1 && climateViewOptionCollector.frontWindowHeaterState != 0);
            this.evaluateAuxilaryHeaterExistence(climateViewOptionCollector);
            this.evaluatePureAirExistence(climateViewOptionCollector);
            this.climateStyleController.evaluateProfileExistency();
            this.climateStyleController.updateProfileExistencyToModel();
            this.climateTarget.registerOnUpdates(152);
        } else if (this.currentZoneConfiguration == 14) {
            this.currentZoneConfiguationListener = this.createConfigurationListener(this.currentZoneConfiguration);
            this.updateSetupButtonToModel();
            this.evaluateSteeringWheelViewOptions(climateViewOptionCollector);
            CarPersistenceServiceImpl.getInstance().loadCar().setClimateSetupButton(climateViewOptionCollector.isSetupButtonZone1);
            this.evaluateFrontWindowHeater(climateViewOptionCollector);
            CarPersistenceServiceImpl.getInstance().loadCar().setFrontWindowHeater(!climateViewOptionCollector.isSetupButtonZone1 && climateViewOptionCollector.frontWindowHeaterState != 0);
            this.evaluateAuxilaryHeaterExistence(climateViewOptionCollector);
        } else {
            this.climateTarget.unregisterOnUpdates(152);
        }
        return n;
    }

    public void identifyOldClimate(int n) {
        switch (n) {
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                this.isOldClimateDevice = !this.viewOptionCollector.isStyleExtendedZone1 || !this.viewOptionCollector.isStyleExtendedZone2 || !this.viewOptionCollector.isStyleExtendedZone3 || !this.viewOptionCollector.isStyleExtendedZone4;
                ServiceManager.aslPropertyManager.valueChangedBoolean(-760413952, !this.isOldClimateDevice);
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                this.isOldClimateDevice = !this.viewOptionCollector.isStyleExtendedZone1 || !this.viewOptionCollector.isStyleExtendedZone2 || !this.viewOptionCollector.isStyleExtendedZone3;
                ServiceManager.aslPropertyManager.valueChangedBoolean(-760413952, !this.isOldClimateDevice);
                break;
            }
            case 2: {
                this.isOldClimateDevice = !this.viewOptionCollector.isStyleExtendedZone1 || !this.viewOptionCollector.isStyleExtendedZone2;
                ServiceManager.aslPropertyManager.valueChangedBoolean(-760413952, !this.isOldClimateDevice);
                break;
            }
            case 3: {
                this.isOldClimateDevice = !this.viewOptionCollector.isStyleExtendedZone1 || !this.viewOptionCollector.isStyleExtendedZone2;
                ServiceManager.aslPropertyManager.valueChangedBoolean(-760413952, !this.isOldClimateDevice);
                break;
            }
            case 13: {
                this.isOldClimateDevice = !this.viewOptionCollector.isStyleExtendedZone1 || !this.viewOptionCollector.isStyleExtendedZone3;
                ServiceManager.aslPropertyManager.valueChangedBoolean(-760413952, !this.isOldClimateDevice);
                break;
            }
            default: {
                this.climateTarget.writeToLog(0, "identifyOldClimate: ClimateZoneConfig: ZONE_UNKNOWN");
            }
        }
    }

    private void evaluateTemperatureButtonViewOption(int n) {
        switch (n) {
            case 8: 
            case 9: 
            case 11: 
            case 12: {
                this.temperatureButtonExistenceArray[0] = true;
                this.temperatureButtonExistenceArray[1] = true;
                this.temperatureButtonExistenceArray[2] = true;
                this.temperatureButtonExistenceArray[4] = true;
                this.temperatureButtonExistenceArray[3] = false;
                this.updateZoneTempType();
                break;
            }
            case 10: {
                this.temperatureButtonExistenceArray[0] = false;
                this.temperatureButtonExistenceArray[1] = false;
                this.temperatureButtonExistenceArray[2] = true;
                this.temperatureButtonExistenceArray[4] = true;
                this.temperatureButtonExistenceArray[3] = false;
                this.updateZoneTempType();
                break;
            }
            case 4: 
            case 5: {
                this.temperatureButtonExistenceArray[0] = true;
                this.temperatureButtonExistenceArray[1] = true;
                this.temperatureButtonExistenceArray[2] = false;
                this.temperatureButtonExistenceArray[4] = false;
                this.temperatureButtonExistenceArray[3] = true;
                this.updateZoneTempType();
                break;
            }
            case 6: 
            case 7: 
            case 13: {
                this.temperatureButtonExistenceArray[0] = false;
                this.temperatureButtonExistenceArray[1] = false;
                this.temperatureButtonExistenceArray[2] = false;
                this.temperatureButtonExistenceArray[4] = false;
                this.temperatureButtonExistenceArray[3] = true;
                this.updateZoneTempType();
                break;
            }
            case 2: {
                this.temperatureButtonExistenceArray[0] = true;
                this.temperatureButtonExistenceArray[1] = true;
                this.temperatureButtonExistenceArray[2] = false;
                this.temperatureButtonExistenceArray[4] = false;
                this.temperatureButtonExistenceArray[3] = false;
                this.updateZoneTempType();
                break;
            }
            case 3: {
                this.temperatureButtonExistenceArray[0] = false;
                this.temperatureButtonExistenceArray[1] = false;
                this.temperatureButtonExistenceArray[2] = false;
                this.temperatureButtonExistenceArray[4] = false;
                this.temperatureButtonExistenceArray[3] = false;
                this.updateZoneTempType();
                break;
            }
            default: {
                this.climateTarget.writeToLog(0, "evaluateTemperatureButtonViewOption: ClimateZoneConfig: ZONE_UNKNOWN");
            }
        }
    }

    private void fillTemperatureColletorModifiableViaHMI() {
        if (this.getZoneConfigurationListener().isTemperatureModifiableViaHMI) {
            this.getZoneConfigurationListener().temperatureButtonList[0].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().temperatureButtonList[1].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().temperatureButtonList[2].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().temperatureButtonList[3].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().temperatureButtonList[4].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().climateBarTemperatureList[0].tempIncDecModifiableViaHMI = 1;
            this.getZoneConfigurationListener().climateBarTemperatureList[1].tempIncDecModifiableViaHMI = 1;
        } else {
            this.getZoneConfigurationListener().temperatureButtonList[0].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().temperatureButtonList[1].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().temperatureButtonList[2].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().temperatureButtonList[3].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().temperatureButtonList[4].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().climateBarTemperatureList[0].tempIncDecModifiableViaHMI = 0;
            this.getZoneConfigurationListener().climateBarTemperatureList[1].tempIncDecModifiableViaHMI = 0;
        }
    }

    private BaseConfiguration createConfigurationListener(int n) {
        BaseConfiguration baseConfiguration = null;
        switch (n) {
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: {
                baseConfiguration = new FourZonesAvailable(this);
                this.previousZoneConfiguration = n;
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 13: {
                baseConfiguration = new Zone1Zone2Zone3Available(this);
                this.previousZoneConfiguration = n;
                break;
            }
            case 2: {
                baseConfiguration = new Zone1Zone2Available(this);
                this.previousZoneConfiguration = n;
                break;
            }
            case 3: {
                break;
            }
            case 14: {
                baseConfiguration = new KME(this);
                this.previousZoneConfiguration = n;
                break;
            }
            default: {
                this.climateTarget.writeToLog(0, "createConfigurationListener:ClimateZoneConfig: ZONE_UNKNOWN");
            }
        }
        return baseConfiguration;
    }

    public void evaluateRowViewOptions(AirconRowViewOptions airconRowViewOptions, int n) {
        switch (n) {
            case 0: {
                this.viewOptionCollector.tempTypeZone1 = this.evaluateTemperatureType(airconRowViewOptions.zoneLeftViewOptions);
                this.viewOptionCollector.isExistZone1 = this.evaluateZoneExist(this.viewOptionCollector.tempTypeZone1);
                this.viewOptionCollector.isStyleExtendedZone1 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateState.state);
                this.viewOptionCollector.isAirDistributionExistZone1 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconAirDistribution.state);
                this.viewOptionCollector.isAirFlowExistZone1 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconAirVolume.state);
                this.viewOptionCollector.isStyleZone1 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateStyle.state);
                this.climateStyleController.getClimateStyleExistencyArray()[n] = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateStyle.state);
                this.viewOptionCollector.isTemperatureModifiableViaHMIZone1 = airconRowViewOptions.configuration.airconTempStepViaHMI;
                this.viewOptionCollector.isSetupButtonZone1 = airconRowViewOptions.configuration.setupButton;
                this.viewOptionCollector.seatHeaterStateZone1 = airconRowViewOptions.zoneLeftViewOptions.airconSeatHeater.state;
                this.viewOptionCollector.seatVentilationStateZone1 = airconRowViewOptions.zoneLeftViewOptions.airconSeatVentilation.state;
                this.viewOptionCollector.tempStateZone1 = this.evaluateViewOptionforModelAdapter(airconRowViewOptions.zoneLeftViewOptions.airconTemp.state, airconRowViewOptions.zoneLeftViewOptions.airconTemp.reason);
                this.evaluateZoneConfiguration(airconRowViewOptions.zoneLeftViewOptions, n);
                this.evaluateRowConfiguration(airconRowViewOptions.configuration, n);
                this.evaluateAirConTemperatureVO(airconRowViewOptions.zoneLeftViewOptions);
                break;
            }
            case 1: {
                this.viewOptionCollector.tempTypeZone2 = this.evaluateTemperatureType(airconRowViewOptions.zoneRightViewOptions);
                this.viewOptionCollector.tempStateZone2 = this.evaluateViewOptionforModelAdapter(airconRowViewOptions.zoneRightViewOptions.airconTemp.state, airconRowViewOptions.zoneRightViewOptions.airconTemp.reason);
                this.viewOptionCollector.isExistZone2 = this.evaluateZoneExist(this.viewOptionCollector.tempTypeZone2);
                this.viewOptionCollector.isStyleExtendedZone2 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateState.state);
                this.viewOptionCollector.isAirDistributionExistZone2 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconAirDistribution.state);
                this.viewOptionCollector.isAirFlowExistZone2 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconAirVolume.state);
                this.viewOptionCollector.isStyleZone2 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateStyle.state);
                this.climateStyleController.getClimateStyleExistencyArray()[n] = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateStyle.state);
                this.viewOptionCollector.isTemperatureModifiableViaHMIZone2 = airconRowViewOptions.configuration.airconTempStepViaHMI;
                this.viewOptionCollector.seatHeaterStateZone2 = airconRowViewOptions.zoneRightViewOptions.airconSeatHeater.state;
                this.viewOptionCollector.seatVentilationStateZone2 = airconRowViewOptions.zoneRightViewOptions.airconSeatVentilation.state;
                this.evaluateZoneConfiguration(airconRowViewOptions.zoneRightViewOptions, n);
                this.evaluateRowConfiguration(airconRowViewOptions.configuration, n);
                this.evaluateAirConTemperatureVO(airconRowViewOptions.zoneRightViewOptions);
                break;
            }
            case 2: {
                this.viewOptionCollector.tempTypeZone3 = this.evaluateTemperatureType(airconRowViewOptions.zoneLeftViewOptions);
                this.viewOptionCollector.isExistZone3 = this.evaluateZoneExist(this.viewOptionCollector.tempTypeZone3);
                this.viewOptionCollector.isStyleExtendedZone3 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateState.state);
                this.viewOptionCollector.isAirDistributionExistZone3 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconAirDistribution.state);
                this.viewOptionCollector.isAirFlowExistZone3 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconAirVolume.state);
                this.viewOptionCollector.isStyleZone3 = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateStyle.state);
                this.climateStyleController.getClimateStyleExistencyArray()[n] = this.evaluateViewOption(airconRowViewOptions.zoneLeftViewOptions.airconClimateStyle.state);
                this.viewOptionCollector.isTemperatureModifiableViaHMIZone3 = airconRowViewOptions.configuration.airconTempStepViaHMI;
                this.viewOptionCollector.isAirDistributionAutoSupportedRow2 = airconRowViewOptions.configuration.airDistributionConfigZoneLeft.autoSupported;
                this.viewOptionCollector.isWindowExistRow2 = airconRowViewOptions.configuration.airFlowConfigZoneLeft.outletUp;
                this.viewOptionCollector.seatHeaterStateZone3 = airconRowViewOptions.zoneLeftViewOptions.airconSeatHeater.state;
                this.viewOptionCollector.seatVentilationStateZone3 = airconRowViewOptions.zoneLeftViewOptions.airconSeatVentilation.state;
                this.evaluateZoneConfiguration(airconRowViewOptions.zoneLeftViewOptions, n);
                this.evaluateRowConfiguration(airconRowViewOptions.configuration, n);
                break;
            }
            case 3: {
                this.viewOptionCollector.tempTypeZone4 = this.evaluateTemperatureType(airconRowViewOptions.zoneRightViewOptions);
                this.viewOptionCollector.isExistZone4 = this.evaluateZoneExist(this.viewOptionCollector.tempTypeZone4);
                this.viewOptionCollector.isStyleExtendedZone4 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateState.state);
                this.viewOptionCollector.isAirDistributionExistZone4 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconAirDistribution.state);
                this.viewOptionCollector.isAirFlowExistZone4 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconAirVolume.state);
                this.viewOptionCollector.isStyleZone4 = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateStyle.state);
                this.climateStyleController.getClimateStyleExistencyArray()[n] = this.evaluateViewOption(airconRowViewOptions.zoneRightViewOptions.airconClimateStyle.state);
                this.viewOptionCollector.isTemperatureModifiableViaHMIZone4 = airconRowViewOptions.configuration.airconTempStepViaHMI;
                this.viewOptionCollector.seatHeaterStateZone4 = airconRowViewOptions.zoneRightViewOptions.airconSeatHeater.state;
                this.viewOptionCollector.seatVentilationStateZone4 = airconRowViewOptions.zoneRightViewOptions.airconSeatVentilation.state;
                this.evaluateZoneConfiguration(airconRowViewOptions.zoneRightViewOptions, n);
                this.evaluateRowConfiguration(airconRowViewOptions.configuration, n);
                break;
            }
            default: {
                this.climateTarget.writeToLog(1, new StringBuffer().append("evaluateRowViewOption =").append(n).append("Zone doesn't exsit").toString());
            }
        }
        this.evaluateClimateDeviceConfiguation(this.viewOptionCollector);
        this.getClimateServiceListener().updateClimateConfiguration(this.climateConfiguration.getCopyOfClimateConfigurationCollector());
    }

    private void evaluateAirConTemperatureVO(AirconZoneViewOptions airconZoneViewOptions) {
        if (!this.evaluateViewOption(airconZoneViewOptions.airconTemp.state)) {
            this.climateTarget.sendHMIEvent(-1263730432);
        }
    }

    private void evaluateZoneConfiguration(AirconZoneViewOptions airconZoneViewOptions, int n) {
        this.climateConfiguration.zoneConfigurations[n].airDistributionAvailability = this.evaluateViewOption(airconZoneViewOptions.airconAirDistribution.state, airconZoneViewOptions.airconAirDistribution.reason);
        this.climateConfiguration.zoneConfigurations[n].airDistributionStyleExtendedAvailability = this.evaluateViewOption(airconZoneViewOptions.airconClimateState.state, airconZoneViewOptions.airconClimateState.reason);
        this.climateConfiguration.zoneConfigurations[n].airDistributionStyleAvailability = this.evaluateViewOption(airconZoneViewOptions.airconClimateStyle.state, airconZoneViewOptions.airconClimateStyle.reason);
        this.climateConfiguration.zoneConfigurations[n].airFlowAvailability = this.evaluateViewOption(airconZoneViewOptions.airconAirVolume.state, airconZoneViewOptions.airconAirVolume.reason);
        this.climateConfiguration.zoneConfigurations[n].seatHeaterAvailability = this.evaluateViewOption(airconZoneViewOptions.airconSeatHeater.state, airconZoneViewOptions.airconSeatHeater.reason);
        this.climateConfiguration.zoneConfigurations[n].seatHeaterDistributionAvailability = this.evaluateViewOption(airconZoneViewOptions.airconSeatHeaterDistribution.state, airconZoneViewOptions.airconSeatHeaterDistribution.reason);
        this.climateConfiguration.zoneConfigurations[n].seatVentilationAvailability = this.evaluateViewOption(airconZoneViewOptions.airconSeatVentilation.state, airconZoneViewOptions.airconSeatVentilation.reason);
        this.climateConfiguration.zoneConfigurations[n].seatVentilationDistributionAvailability = this.evaluateViewOption(airconZoneViewOptions.airconSeatVentilationDistribution.state, airconZoneViewOptions.airconSeatVentilationDistribution.reason);
        this.climateConfiguration.zoneConfigurations[n].temperatureAvailability = this.evaluateViewOption(airconZoneViewOptions.airconTemp.state, airconZoneViewOptions.airconTemp.reason);
        this.climateConfiguration.zoneConfigurations[n].temperatureStepsAvailability = this.evaluateViewOption(airconZoneViewOptions.airconTempStep.state, airconZoneViewOptions.airconTempStep.reason);
        this.climateConfiguration.zoneConfigurations[n].temperatureType = this.evaluateTemperatureType(airconZoneViewOptions);
        this.climateConfiguration.zoneConfigurations[n].ionisator = this.evaluateViewOption(airconZoneViewOptions.airconIonisator.state, airconZoneViewOptions.airconIonisator.reason);
    }

    private void evaluateRowConfiguration(AirconRowConfiguration airconRowConfiguration, int n) {
        this.climateConfiguration.zoneConfigurations[n].airDistributionAutoSupported = this.evaluateViewOptionConfiguration(airconRowConfiguration.airDistributionConfigZoneRight.autoSupported);
        this.climateConfiguration.zoneConfigurations[n].airDistributionBodyAvailability = this.evaluateViewOptionConfiguration(airconRowConfiguration.airDistributionConfigZoneRight.up);
        this.climateConfiguration.zoneConfigurations[n].airDistributionFootAvailability = this.evaluateViewOptionConfiguration(airconRowConfiguration.airDistributionConfigZoneRight.down);
        this.climateConfiguration.zoneConfigurations[n].airDistributionWindowAvailability = this.evaluateViewOptionConfiguration(airconRowConfiguration.airDistributionConfigZoneRight.downUp);
        this.climateConfiguration.zoneConfigurations[n].setupButtonAvailability = this.evaluateViewOptionConfiguration(airconRowConfiguration.setupButton);
        this.climateConfiguration.zoneConfigurations[n].temperatureModifiableViaHMI = this.evaluateViewOptionConfiguration(airconRowConfiguration.airconTempStepViaHMI);
        this.climateConfiguration.zoneConfigurations[n].airDistributionCombined = this.evaluateViewOptionConfiguration(airconRowConfiguration.airDistributionCombined);
    }

    public void evaluateMasterViewOptions(AirconMasterViewOptions airconMasterViewOptions) {
        boolean bl = this.evaluateClimateDeviceOperational(airconMasterViewOptions);
        ServiceManager.aslPropertyManager.valueChangedBoolean(309, bl);
        this.steeringWheelViewOptions = new AirconSteeringWheelHeaterViewOptions(airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.heating, airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.autoHeating, airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.heatingStep, airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.adjustViaSeatHeating, airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.currentState);
        this.viewOptionCollector.isAirconAC = this.evaluateViewOption(airconMasterViewOptions.airconAC.state);
        this.viewOptionCollector.isAirCirculationMan = this.evaluateViewOption(airconMasterViewOptions.airconAirCirculationMan.state);
        this.viewOptionCollector.airconSyncState = airconMasterViewOptions.airconSynchronisation.state;
        this.viewOptionCollector.steeringWheelHeaterState = airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.heating.state;
        this.viewOptionCollector.steeringWheelAdjustViaSeatHeatingState = airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.adjustViaSeatHeating.state;
        this.viewOptionCollector.steeringWheelAutoHeaterState = airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.autoHeating.state;
        this.viewOptionCollector.steeringWheelHeaterStepsState = airconMasterViewOptions.airconSteeringWheelHeaterViewOptions.heatingStep.state;
        this.viewOptionCollector.isMaxAC = this.evaluateViewOption(airconMasterViewOptions.airconMaxAC.state);
        this.viewOptionCollector.isMaxDeforst = this.evaluateViewOption(airconMasterViewOptions.airconMaxDefrost.state);
        this.viewOptionCollector.isDriverSideRight = airconMasterViewOptions.configuration.carDriverSide;
        this.viewOptionCollector.isLeftZoneRow1 = airconMasterViewOptions.configuration.zl1r;
        this.viewOptionCollector.isRightZoneRow1 = airconMasterViewOptions.configuration.zr1r;
        this.viewOptionCollector.isLeftZoneRow2 = airconMasterViewOptions.configuration.zl2r;
        this.viewOptionCollector.isRightZoneRow2 = airconMasterViewOptions.configuration.zr2r;
        this.viewOptionCollector.frontWindowHeaterState = airconMasterViewOptions.airconFrontWindowHeater.state;
        this.viewOptionCollector.auxiliaryHeating = airconMasterViewOptions.airconHeater.state;
        this.viewOptionCollector.rearLockState = airconMasterViewOptions.airconRearControl.state;
        this.viewOptionCollector.autoAirCirculationState = airconMasterViewOptions.airconAirCirculationAuto.state;
        this.viewOptionCollector.autoFrontWindowHeater = airconMasterViewOptions.airconFrontWindowHeaterAuto.state;
        this.viewOptionCollector.pureAirState = airconMasterViewOptions.airconPureAir.state;
        this.evaluateRowAvailablity(this.viewOptionCollector);
        this.evaluateClimateDeviceConfiguation(this.viewOptionCollector);
        this.climateConfiguration.generalConfiguration.airCirculationManAvailability = this.evaluateViewOption(airconMasterViewOptions.airconAirCirculationMan.state, airconMasterViewOptions.airconAirCirculationMan.reason);
        this.climateConfiguration.generalConfiguration.airconACAvailability = this.evaluateViewOption(airconMasterViewOptions.airconAC.state, airconMasterViewOptions.airconAC.reason);
        this.climateConfiguration.generalConfiguration.airconSyncAvailability = this.evaluateViewOption(airconMasterViewOptions.airconSynchronisation.state, airconMasterViewOptions.airconSynchronisation.reason);
        this.climateConfiguration.generalConfiguration.maxACAvailability = this.evaluateViewOption(airconMasterViewOptions.airconMaxAC.state, airconMasterViewOptions.airconMaxAC.reason);
        this.climateConfiguration.generalConfiguration.maxDefrostAvailability = this.evaluateViewOption(airconMasterViewOptions.airconMaxDefrost.state, airconMasterViewOptions.airconMaxDefrost.reason);
        this.climateConfiguration.generalConfiguration.freshAir = this.evaluateViewOption(airconMasterViewOptions.airconFreshAirState.state, airconMasterViewOptions.airconFreshAirState.reason);
        this.climateConfiguration.generalConfiguration.pureAir = this.evaluateViewOption(airconMasterViewOptions.airconPureAir.state, airconMasterViewOptions.airconPureAir.reason);
        this.climateConfiguration.generalConfiguration.driverSide = this.transformDriverSideToInt(airconMasterViewOptions.configuration.carDriverSide);
        this.getClimateServiceListener().updateClimateConfiguration(this.climateConfiguration.getCopyOfClimateConfigurationCollector());
    }

    private boolean evaluateClimateDeviceOperational(AirconMasterViewOptions airconMasterViewOptions) {
        Class clazz = super.getClass();
        boolean bl = false;
        for (int i2 = 0; i2 < clazz.getFields().length; ++i2) {
            Field field = clazz.getDeclaredFields()[i2];
            if (!field.getType().equals(class$org$dsi$ifc$global$CarViewOption == null ? ClimateMainController.class$("org.dsi.ifc.global.CarViewOption") : class$org$dsi$ifc$global$CarViewOption)) continue;
            field.setAccessible(true);
            CarViewOption carViewOption = null;
            try {
                carViewOption = (CarViewOption)field.get(airconMasterViewOptions);
            }
            catch (Exception exception) {
                // empty catch block
            }
            if (carViewOption == null || carViewOption.state != 2) continue;
            bl = true;
        }
        return bl;
    }

    public void evaluateRowAvailablity(ClimateViewOptionCollector climateViewOptionCollector) {
        if ((climateViewOptionCollector.isLeftZoneRow1 || climateViewOptionCollector.isRightZoneRow1) && !this.isrow1ViewOptionsRegistered) {
            this.climateTarget.registerOnUpdates(93);
            this.isrow1ViewOptionsRegistered = true;
        }
        if ((climateViewOptionCollector.isLeftZoneRow2 || climateViewOptionCollector.isRightZoneRow2) && !this.isrow2ViewOptionsRegistered) {
            this.climateTarget.registerOnUpdates(94);
            this.isrow2ViewOptionsRegistered = true;
        }
    }

    public void evaluateAirDistribution(ClimateViewOptionCollector climateViewOptionCollector) {
        if (this.currentZoneConfiguration != 0) {
            if (climateViewOptionCollector.isAirDistributionExistZone1) {
                this.getZoneConfigurationListener().airDistributionAvailableZone1 = true;
                this.climateTarget.registerOnUpdates(26);
            } else {
                this.getZoneConfigurationListener().airDistributionAvailableZone1 = false;
                this.climateTarget.unregisterOnUpdates(26);
            }
            if (climateViewOptionCollector.isAirDistributionExistZone3) {
                this.getZoneConfigurationListener().airDistributionAvailableZone3 = true;
                this.climateTarget.registerOnUpdates(38);
                this.getZoneConfigurationListener().isRearWindowOutletAvailable = climateViewOptionCollector.isWindowExistRow2;
            } else {
                this.getZoneConfigurationListener().airDistributionAvailableZone3 = false;
                this.climateTarget.unregisterOnUpdates(38);
            }
        }
    }

    public void evaluateFlyingWindowViewOption(ClimateViewOptionCollector climateViewOptionCollector) {
        if (!this.isOldClimateDevice) {
            if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.isAirconAC && climateViewOptionCollector.isAirCirculationMan) {
                this.flyingWindowExistenceArray[0] = true;
                this.climateTarget.writeToLog(0, "NewClimateView: Flying Window Front available");
            } else {
                this.flyingWindowExistenceArray[0] = false;
                this.climateTarget.writeToLog(0, "NewClimateView:Flying Window Front NOT available");
            }
            if (climateViewOptionCollector.isAirFlowExistZone3) {
                this.flyingWindowExistenceArray[1] = true;
                this.climateTarget.writeToLog(0, "Flying Window Rear available");
            } else {
                this.flyingWindowExistenceArray[1] = false;
                this.climateTarget.writeToLog(0, "Flying Window rear NOT available");
            }
            this.updateFlyingWindowRearWindowButtonToModel(climateViewOptionCollector.isWindowExistRow2);
        } else {
            this.flyingWindowExistenceArray[0] = false;
            this.flyingWindowExistenceArray[1] = false;
            this.climateTarget.writeToLog(0, "NewClimateView:Old device;Flying Window Front and Rear NOT available");
        }
    }

    public void evaluatePresetViewOption(ClimateViewOptionCollector climateViewOptionCollector) {
        if (climateViewOptionCollector.tempTypeZone1 == 1) {
            this.presetExistenceArray[0] = true;
            this.climateTarget.writeToLog(0, "NewClimateView:Preset DD Front available");
        } else {
            this.presetExistenceArray[0] = false;
            this.climateTarget.writeToLog(0, "NewClimateView:Preset DD Front NOT available");
        }
        if (climateViewOptionCollector.isStyleExtendedZone1) {
            if (climateViewOptionCollector.isMaxAC) {
                this.getZoneConfigurationListener().presetList[0].presetModeMaxAc = 1;
                this.getZoneConfigurationListener().isFrontMaxACExist = true;
            } else {
                this.getZoneConfigurationListener().presetList[0].presetModeMaxAc = 0;
                this.getZoneConfigurationListener().isFrontMaxACExist = false;
            }
            if (climateViewOptionCollector.isMaxDeforst) {
                this.getZoneConfigurationListener().presetList[0].presetModeMaxDefrost = 1;
                this.getZoneConfigurationListener().isFrontMaxDefrostExist = true;
            } else {
                this.getZoneConfigurationListener().presetList[0].presetModeMaxDefrost = 0;
                this.getZoneConfigurationListener().isFrontMaxDefrostExist = false;
            }
        }
        if (climateViewOptionCollector.isAirFlowExistZone3 && climateViewOptionCollector.isAirDistributionAutoSupportedRow2) {
            this.presetExistenceArray[1] = true;
            this.getZoneConfigurationListener().presetList[1].presetModeMaxAc = 0;
            this.getZoneConfigurationListener().presetList[1].presetModeMaxDefrost = 0;
            this.climateTarget.writeToLog(0, "NewClimateView:Preset DD Rear available");
        } else {
            this.presetExistenceArray[1] = false;
            this.climateTarget.writeToLog(0, "NewClimateView:Preset DD Rear NOT available");
        }
    }

    public int identifyZoneConfig(ClimateViewOptionCollector climateViewOptionCollector) {
        int n = 0;
        if (this.climateConfiguration.zoneConfigurations[0].setupButtonAvailability == 1) {
            n = 14;
            this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: KME");
        } else if (climateViewOptionCollector.isRightZoneRow2 && climateViewOptionCollector.isLeftZoneRow2 && climateViewOptionCollector.isLeftZoneRow1 && climateViewOptionCollector.isRightZoneRow1) {
            if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 1 && climateViewOptionCollector.tempTypeZone4 == 1) {
                n = 8;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4AUTO");
            } else if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 2 && climateViewOptionCollector.tempTypeZone4 == 2) {
                n = 9;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4MANUAL");
            } else if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 1 && climateViewOptionCollector.tempTypeZone1 == 2) {
                n = 11;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3AUTO_ZONE4MANUAL");
            } else if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 2 && climateViewOptionCollector.tempTypeZone4 == 1) {
                n = 12;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL_ZONE4AUTO");
            } else if (climateViewOptionCollector.tempTypeZone1 == 2 && climateViewOptionCollector.tempTypeZone2 == 2 && climateViewOptionCollector.tempTypeZone3 == 1 && climateViewOptionCollector.tempTypeZone4 == 1) {
                n = 10;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO_ZONE4AUTO");
            } else {
                n = 0;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig 4 Zone: ZONE_UNKNOWN");
            }
        } else if (climateViewOptionCollector.isLeftZoneRow2 && climateViewOptionCollector.isRightZoneRow1 && climateViewOptionCollector.isLeftZoneRow1 || climateViewOptionCollector.isRightZoneRow2 && climateViewOptionCollector.isRightZoneRow1 && climateViewOptionCollector.isLeftZoneRow1) {
            if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 1) {
                n = 4;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3AUTO");
            } else if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1 && climateViewOptionCollector.tempTypeZone3 == 2) {
                n = 5;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO_ZONE3MANUAL");
            } else if (climateViewOptionCollector.tempTypeZone1 == 2 && climateViewOptionCollector.tempTypeZone2 == 2 && climateViewOptionCollector.tempTypeZone3 == 1) {
                n = 7;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1MANUAL_ZONE2MANUAL_ZONE3AUTO");
            } else if (climateViewOptionCollector.tempTypeZone1 == 2 && climateViewOptionCollector.tempTypeZone2 == 2 && climateViewOptionCollector.tempTypeZone3 == 2) {
                n = 6;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1MANUAL_ZONE2MANUAL_ZONE3MANUAL");
            } else {
                n = 0;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig 3 zone: ZONE_UNKNOWN");
            }
        } else if (climateViewOptionCollector.isRightZoneRow1 && climateViewOptionCollector.isLeftZoneRow1) {
            if (climateViewOptionCollector.tempTypeZone1 == 1 && climateViewOptionCollector.tempTypeZone2 == 1) {
                n = 2;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1AUTO_ZONE2AUTO");
            } else if (climateViewOptionCollector.tempTypeZone1 == 2 && climateViewOptionCollector.tempTypeZone2 == 2) {
                n = 3;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig: ZONE1MANUALZONE2MANUAL");
            } else if (climateViewOptionCollector.tempTypeZone1 == 0 && climateViewOptionCollector.tempTypeZone3 == 2) {
                n = 13;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig KME1/KME3 work around: ZONE1MANUALZONE3MANUAL");
            } else if (climateViewOptionCollector.tempTypeZone1 == 0) {
                if (!this.isrow2ViewOptionsRegistered) {
                    this.climateTarget.registerOnUpdates(94);
                    this.isrow2ViewOptionsRegistered = true;
                }
            } else {
                n = 0;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig 2 zone: ZONE_UNKNOWN");
            }
        } else if (climateViewOptionCollector.isLeftZoneRow1 && climateViewOptionCollector.isLeftZoneRow2) {
            if (climateViewOptionCollector.tempTypeZone1 == 2 && climateViewOptionCollector.tempTypeZone3 == 2) {
                n = 13;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig KME1/KME3: ZONE1MANUALZONE3MANUAL");
            } else {
                n = 0;
                this.climateTarget.writeToLog(0, "identifyZoneConfig:ClimateZoneConfig KME1/KME3: ZONE_UNKNOWN");
            }
        } else if (climateViewOptionCollector.isLeftZoneRow1) {
            if (this.climateConfiguration.zoneConfigurations[0].setupButtonAvailability == 1) {
                n = 14;
                this.climateTarget.writeToLog(0, "ClimateZoneConfig: KME");
            } else {
                n = 0;
                this.climateTarget.writeToLog(0, "ClimateZoneConfig: ZONE_UNKNOWN");
            }
        } else {
            n = 0;
            this.climateTarget.writeToLog(0, "identifyZoneConfig atlast: ClimateZoneConfig: ZONE_UNKNOWN");
        }
        return n;
    }

    private void evaluateTemperatureModifiableViaHMI(ClimateViewOptionCollector climateViewOptionCollector) {
        this.getZoneConfigurationListener().isTemperatureModifiableViaHMI = climateViewOptionCollector.isTemperatureModifiableViaHMIZone1;
    }

    private void evaluateClimateInformation(ClimateViewOptionCollector climateViewOptionCollector) {
        switch (this.currentZoneConfiguration) {
            case 2: 
            case 3: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-944963328, false);
                this.climateTarget.writeToLog(0, "NewClimateView: WELL_FEELING_CLIMATE_SYSTEM doesn't exisit");
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                if (!climateViewOptionCollector.isAirFlowExistZone1) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-944963328, true);
                    this.climateTarget.writeToLog(0, "NewClimateView: WELL_FEELING_CLIMATE_SYSTEM exisit");
                    break;
                }
                ServiceManager.aslPropertyManager.valueChangedBoolean(-944963328, false);
                this.climateTarget.writeToLog(0, "NewClimateView: WELL_FEELING_CLIMATE_SYSTEM doesn't exisit");
                break;
            }
            default: {
                this.climateTarget.writeToLog(0, "evaluateClimateInformation:ClimateZoneConfig: ZONE_UNKNOWN");
            }
        }
    }

    private void evaluateSeatHeaterPopUp(ClimateViewOptionCollector climateViewOptionCollector) {
        this.seatHeaterPopupAllowed = climateViewOptionCollector.seatHeaterStateZone1 != 0 && (climateViewOptionCollector.steeringWheelHeaterState != 0 || climateViewOptionCollector.seatVentilationStateZone1 != 0);
    }

    private void evaluateSyncExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        switch (climateViewOptionCollector.airconSyncState) {
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-424869632, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-408092416, true);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-424869632, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-408092416, false);
                break;
            }
            default: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-424869632, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-408092416, false);
            }
        }
    }

    private void evaluateSyncMaster(ClimateViewOptionCollector climateViewOptionCollector) {
        this.getZoneConfigurationListener().syncMaster = climateViewOptionCollector.isDriverSideRight ? 2 : 1;
    }

    private void evaluateSeatHeaterExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        this.ClimateBarSeatHeaterExistenceArray[0] = climateViewOptionCollector.seatHeaterStateZone1 != 0;
        this.ClimateBarSeatHeaterExistenceArray[1] = climateViewOptionCollector.seatHeaterStateZone2 != 0;
    }

    private void evaluateSeatVentilationExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        this.ClimateBarSeatVentilationExistenceArray[0] = climateViewOptionCollector.seatVentilationStateZone1 != 0;
        this.ClimateBarSeatVentilationExistenceArray[1] = climateViewOptionCollector.seatVentilationStateZone2 != 0;
        this.solvingViewOptionsClimate(climateViewOptionCollector.seatVentilationStateZone1, 3995, 3995);
        this.solvingViewOptionsClimate(climateViewOptionCollector.seatVentilationStateZone2, 3995, 3996);
    }

    private void evaluateSteeringWheelViewOptions(ClimateViewOptionCollector climateViewOptionCollector) {
        if (climateViewOptionCollector.steeringWheelHeaterState == 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(4180, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(4181, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(4178, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(4179, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(3993, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(3994, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(318, false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(312, false);
            CarPersistenceServiceImpl.getInstance().loadCar().setSteeringWheelheater(false);
        } else {
            this.solvingViewOptionsClimate(climateViewOptionCollector.steeringWheelHeaterState, 318, 312);
            CarPersistenceServiceImpl.getInstance().loadCar().setSteeringWheelheater(!climateViewOptionCollector.isSetupButtonZone1);
            this.solvingViewOptionsClimate(climateViewOptionCollector.steeringWheelHeaterStepsState, 4178, 4179);
            this.solvingViewOptionsClimate(climateViewOptionCollector.steeringWheelAutoHeaterState, 4180, 4181);
            if (climateViewOptionCollector.seatHeaterStateZone1 == 2 && climateViewOptionCollector.steeringWheelHeaterState == 2) {
                this.solvingViewOptionsClimate(climateViewOptionCollector.steeringWheelAdjustViaSeatHeatingState, 3993, 3994);
            } else if (climateViewOptionCollector.seatHeaterStateZone1 == 1 || climateViewOptionCollector.steeringWheelHeaterState == 1) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(3993, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(3994, false);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(3993, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(3994, false);
            }
        }
    }

    private void evaluateFrontWindowHeater(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.frontWindowHeaterState, 319, 311);
    }

    private void evaluateAuxilaryHeaterExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.auxiliaryHeating, 322, 313);
    }

    private void evaluateRearLockExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.rearLockState, -1314062080, -1297284864);
    }

    private void evaluateAutoAirCirculation(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.autoAirCirculationState, 325, 314);
    }

    private void evaluateAutoFrontWindowHeater(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.autoFrontWindowHeater, 3621, -357760768);
    }

    private void evaluatePureAirExistence(ClimateViewOptionCollector climateViewOptionCollector) {
        this.solvingViewOptionsClimate(climateViewOptionCollector.pureAirState, -257097472, -240320256);
        if (climateViewOptionCollector.pureAirState != 0 && !this.isPureAirUpdateRegistered) {
            this.climateTarget.registerOnUpdates(103);
            this.isPureAirUpdateRegistered = true;
        }
    }

    private void evaluateSeatHeaterBalanceExistence() {
        if (!this.isZone1SeatHeaterRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[0].seatHeaterDistributionAvailability, 63);
            this.isZone1SeatHeaterRegistered = true;
        }
        if (!this.isZone2SeatHeaterRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[1].seatHeaterDistributionAvailability, 64);
            this.isZone2SeatHeaterRegistered = true;
        }
        if (!this.isZone3SeatHeaterRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[2].seatHeaterDistributionAvailability, 65);
            this.isZone3SeatHeaterRegistered = true;
        }
        if (!this.isZone4SeatHeaterRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[3].seatHeaterDistributionAvailability, 66);
            this.isZone4SeatHeaterRegistered = true;
        }
    }

    private void evaluateSeatVentilatorBalanceExistence() {
        if (!this.isZone1SeatVentilationRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[0].seatVentilationDistributionAvailability, 69);
            this.isZone1SeatVentilationRegistered = true;
        }
        if (!this.isZone2SeatVentilationRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[1].seatVentilationDistributionAvailability, 70);
            this.isZone2SeatVentilationRegistered = true;
        }
        if (!this.isZone3SeatVentilationRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[2].seatVentilationDistributionAvailability, 71);
            this.isZone3SeatVentilationRegistered = true;
        }
        if (!this.isZone4SeatVentilationRegistered) {
            this.conditionalDSIUpdateRegistration(this.climateConfiguration.zoneConfigurations[3].seatVentilationDistributionAvailability, 72);
            this.isZone4SeatVentilationRegistered = true;
        }
    }

    private void conditionalDSIUpdateRegistration(int n, int n2) {
        if (n == 2) {
            this.getClimateTarget().registerOnUpdates(n2);
        }
    }

    private void updateSetupButtonToModel() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(321, this.viewOptionCollector.isSetupButtonZone1);
    }

    private int evaluateTemperatureType(AirconZoneViewOptions airconZoneViewOptions) {
        int n = 0;
        if (airconZoneViewOptions.airconTemp.state != 0 && airconZoneViewOptions.airconTempStep.state == 0) {
            n = 1;
        } else if (airconZoneViewOptions.airconTempStep.state != 0 && airconZoneViewOptions.airconTemp.state == 0) {
            n = 2;
        }
        return n;
    }

    private boolean evaluateViewOption(int n) {
        boolean bl = false;
        bl = n != 0;
        return bl;
    }

    private int evaluateViewOption(int n, int n2) {
        int n3 = 0;
        if (n == 0) {
            n3 = 1;
        } else if (n == 2) {
            n3 = 2;
        } else if (n == 1) {
            n3 = 3;
        }
        return n3;
    }

    private int evaluateViewOptionConfiguration(boolean bl) {
        int n = 0;
        n = bl ? 2 : 1;
        return n;
    }

    private int evaluateViewOptionforModelAdapter(int n, int n2) {
        int n3 = 0;
        if (n == 2) {
            n3 = 2;
        } else if (n == 1) {
            n3 = 3;
        } else if (n == 0) {
            n3 = 1;
        }
        return n3;
    }

    private int transformDriverSideToInt(boolean bl) {
        int n = 0;
        n = !bl ? 1 : 2;
        return n;
    }

    private boolean evaluateZoneExist(int n) {
        boolean bl = false;
        if (n == 1 || n == 2) {
            bl = true;
        }
        return bl;
    }

    private void updateZoneTempType() {
        this.getZoneConfigurationListener().tempTypeZone1 = this.viewOptionCollector.tempTypeZone1;
        this.getZoneConfigurationListener().tempTypeZone2 = this.viewOptionCollector.tempTypeZone2;
        this.getZoneConfigurationListener().tempTypeZone3 = this.viewOptionCollector.tempTypeZone3;
        this.getZoneConfigurationListener().tempTypeZone4 = this.viewOptionCollector.tempTypeZone4;
    }

    protected void setRearFunctionsState() {
        if ((this.viewOptionCollector.isRightZoneRow2 || this.viewOptionCollector.isLeftZoneRow2) && this.getZoneConfigurationListener() != null) {
            if (!this.isRearClimateSystemON()) {
                this.copyBooleanExistenceArray(this.temperatureButtonExistenceArray, this.temperatureButtonExistenceArrayRearOff);
                this.copyBooleanExistenceArray(this.presetExistenceArray, this.presetExistenceArrayRearOff);
                this.copyIntExistenceArray(this.getZoneConfigurationListener().airFlowArrowStateCollector, this.getZoneConfigurationListener().airFlowArrowStateCollectorRearOff);
                this.setSelectionElementsFalse(this.temperatureButtonExistenceArrayRearOff, 2, 4);
                this.setSelectionElementsFalse(this.presetExistenceArrayRearOff, 1, 1);
                this.setSelectionElementsFalse(this.getZoneConfigurationListener().airFlowArrowStateCollectorRearOff, 6, 11);
                ServiceManager.aslPropertyManager.valueChangedFlagVector(-575864576, this.temperatureButtonExistenceArrayRearOff);
                ServiceManager.aslPropertyManager.valueChangedFlagVector(-609419008, this.presetExistenceArrayRearOff);
                ServiceManager.aslPropertyManager.valueChangedIntegerArray(-458424064, Arrays.copyOf(this.getZoneConfigurationListener().airFlowArrowStateCollectorRearOff, this.getZoneConfigurationListener().airFlowArrowStateCollectorRearOff.length));
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1045626624, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1028849408, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1012072192, false);
            } else {
                ServiceManager.aslPropertyManager.valueChangedFlagVector(-575864576, this.temperatureButtonExistenceArray);
                ServiceManager.aslPropertyManager.valueChangedFlagVector(-609419008, this.presetExistenceArray);
                ServiceManager.aslPropertyManager.valueChangedIntegerArray(-458424064, Arrays.copyOf(this.getZoneConfigurationListener().airFlowArrowStateCollector, this.getZoneConfigurationListener().airFlowArrowStateCollector.length));
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1045626624, this.getZoneConfigurationListener().isButtonRearAirFlowBodyActive);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1028849408, this.getZoneConfigurationListener().isButtonRearAirFlowFootWellActive);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1012072192, this.getZoneConfigurationListener().isButtonRearAirFlowWindowActive);
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(-961740544, this.isRearClimateSystemON());
        }
    }

    protected void setECOPluseMode(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-340983552, !bl);
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedFlagVector(-575864576, this.temperatureButtonExistenceArrayECOPluse);
        } else {
            ServiceManager.aslPropertyManager.valueChangedFlagVector(-575864576, this.temperatureButtonExistenceArray);
        }
    }

    private void copyBooleanExistenceArray(boolean[] blArray, boolean[] blArray2) {
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            blArray2[i2] = blArray[i2];
        }
    }

    private void copyIntExistenceArray(int[] nArray, int[] nArray2) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray2[i2] = nArray[i2];
        }
    }

    private void setSelectionElementsFalse(boolean[] blArray, int n, int n2) {
        for (int i2 = n; i2 <= n2; ++i2) {
            blArray[i2] = false;
        }
    }

    private void setSelectionElementsFalse(int[] nArray, int n, int n2) {
        for (int i2 = n; i2 <= n2; ++i2) {
            nArray[i2] = 0;
        }
    }

    private void updateTemperatureButtonExistencyToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-575864576, this.temperatureButtonExistenceArray);
    }

    private void updateFlyingWindowExistencyToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-559087360, this.flyingWindowExistenceArray);
    }

    private void updatePresetExistencyToModel() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(-609419008, this.presetExistenceArray);
    }

    private void updateFlyingWindowRearWindowButtonToModel(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(-995294976, bl);
    }

    public void updateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        this.getCurrentSteeringWheelHeater().heating = airconSteeringWheelHeater.heating;
        ServiceManager.aslPropertyManager.valueChangedBoolean(299, this.getCurrentSteeringWheelHeater().heating);
        this.getCurrentSteeringWheelHeater().adjustViaSeatHeating = airconSteeringWheelHeater.adjustViaSeatHeating;
        ServiceManager.aslPropertyManager.valueChangedBoolean(738487808, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating);
        this.getCurrentSteeringWheelHeater().heatingStep = airconSteeringWheelHeater.heatingStep;
        ServiceManager.aslPropertyManager.valueChangedInteger(486829568, this.transformSteeringWheelHeatingStepToModel(this.getCurrentSteeringWheelHeater().heatingStep));
        ServiceManager.aslPropertyManager.valueChangedInteger(4094, this.transformSteeringWheelHeatingStepToModel(this.getCurrentSteeringWheelHeater().heatingStep));
        this.getCurrentSteeringWheelHeater().autoHeating = airconSteeringWheelHeater.autoHeating;
        ServiceManager.aslPropertyManager.valueChangedBoolean(704933376, this.getCurrentSteeringWheelHeater().autoHeating);
        this.getCurrentSteeringWheelHeater().currentState = airconSteeringWheelHeater.currentState;
    }

    private int transformSteeringWheelHeatingStepToModel(int n) {
        int n2 = 0;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    private void updateClimateBarTemperatureButtonExistencyToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(1016870912, this.ClimateBarTemperatureExistenceArray);
    }

    private void updateClimateBarSeatHeaterExistencyToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(1016870912, this.ClimateBarSeatHeaterExistenceArray);
    }

    private void updateClimateBarSeatVentilationExistencyToModle() {
        ServiceManager.aslPropertyManager.valueChangedFlagVector(1016870912, this.ClimateBarSeatHeaterExistenceArray);
    }

    public BaseConfiguration getZoneConfigurationListener() {
        return this.currentZoneConfiguationListener;
    }

    private void conditionalTemperatureUpdateRegistration() {
        if (this.viewOptionCollector.tempTypeZone1 == 1) {
            if (!this.isZone1TempeatureRegistered) {
                this.climateTarget.registerOnUpdates(24);
                this.isZone1TempeatureRegistered = true;
            }
        } else if (this.viewOptionCollector.tempTypeZone1 == 2 && !this.isZone1TempeatureStepRegistered) {
            this.climateTarget.registerOnUpdates(75);
            this.isZone1TempeatureStepRegistered = true;
        }
        if (this.viewOptionCollector.tempTypeZone2 == 1) {
            if (!this.isZone2TempeatureRegistered) {
                this.climateTarget.registerOnUpdates(30);
                this.isZone2TempeatureRegistered = true;
            }
        } else if (this.viewOptionCollector.tempTypeZone2 == 2 && !this.isZone2TempeatureStepRegistered) {
            this.climateTarget.registerOnUpdates(76);
            this.isZone2TempeatureStepRegistered = true;
        }
        if (this.viewOptionCollector.tempTypeZone3 == 1) {
            if (!this.isZone3TempeatureRegistered) {
                this.climateTarget.registerOnUpdates(36);
                this.isZone3TempeatureRegistered = true;
            }
        } else if (this.viewOptionCollector.tempTypeZone3 == 2 && !this.isZone3TempeatureStepRegistered) {
            this.climateTarget.registerOnUpdates(77);
            this.isZone3TempeatureStepRegistered = true;
        }
        if (this.viewOptionCollector.tempTypeZone4 == 1) {
            if (!this.isZone4TempeatureRegistered) {
                this.climateTarget.registerOnUpdates(42);
                this.isZone4TempeatureRegistered = true;
            }
        } else if (this.viewOptionCollector.tempTypeZone4 == 2 && !this.isZone4TempeatureStepRegistered) {
            this.climateTarget.registerOnUpdates(78);
            this.isZone4TempeatureStepRegistered = true;
        }
    }

    public void setTemperature(int n, int n2) {
        switch (n) {
            case 0: {
                if (this.viewOptionCollector.tempTypeZone1 == 1) {
                    AirconTemp airconTemp = this.evaluateTemperatureChange(this.getZoneConfigurationListener().airconTempZone1, n2);
                    this.climateTarget.getCarAirconDSI().setAirconTempZone(1, airconTemp);
                    break;
                }
                int n3 = this.evaluateTemperatureStepChange(this.getZoneConfigurationListener().airConTempStepZone1, this.getZoneConfigurationListener().airconTempStepMaxCount1, n2);
                this.climateTarget.getCarAirconDSI().setAirconTempStep(1, n3);
                break;
            }
            case 1: {
                if (this.viewOptionCollector.tempTypeZone2 == 1) {
                    AirconTemp airconTemp = this.evaluateTemperatureChange(this.getZoneConfigurationListener().airconTempZone2, n2);
                    this.climateTarget.getCarAirconDSI().setAirconTempZone(2, airconTemp);
                    break;
                }
                int n4 = this.evaluateTemperatureStepChange(this.getZoneConfigurationListener().airConTempStepZone2, this.getZoneConfigurationListener().airconTempStepMaxCount2, n2);
                this.climateTarget.getCarAirconDSI().setAirconTempStep(2, n4);
                break;
            }
            case 2: 
            case 3: {
                if (this.viewOptionCollector.tempTypeZone3 == 1) {
                    AirconTemp airconTemp = this.evaluateTemperatureChange(this.getZoneConfigurationListener().airconTempZone3, n2);
                    this.climateTarget.getCarAirconDSI().setAirconTempZone(4, airconTemp);
                    break;
                }
                int n5 = this.evaluateTemperatureStepChange(this.getZoneConfigurationListener().airConTempStepZone3, this.getZoneConfigurationListener().airconTempStepMaxCount3, n2);
                this.climateTarget.getCarAirconDSI().setAirconTempStep(4, n5);
                break;
            }
            case 4: {
                if (this.viewOptionCollector.tempTypeZone4 == 1) {
                    AirconTemp airconTemp = this.evaluateTemperatureChange(this.getZoneConfigurationListener().airconTempZone4, n2);
                    this.climateTarget.getCarAirconDSI().setAirconTempZone(8, airconTemp);
                    break;
                }
                int n6 = this.evaluateTemperatureStepChange(this.getZoneConfigurationListener().airConTempStepZone4, this.getZoneConfigurationListener().airconTempStepMaxCount4, n2);
                this.climateTarget.getCarAirconDSI().setAirconTempStep(8, n6);
                break;
            }
        }
    }

    public void setClimateBarTemparature(int n, int n2) {
        switch (n) {
            case 0: {
                AirconTemp airconTemp = new AirconTemp(n2, this.getZoneConfigurationListener().airconTempZone1.tempUnit);
                airconTemp.tempValue = this.evlauteClimateBarTemperature(airconTemp.tempValue, airconTemp.tempUnit);
                this.climateTarget.getCarAirconDSI().setAirconTempZone(1, airconTemp);
                break;
            }
            case 1: {
                AirconTemp airconTemp = new AirconTemp(n2, this.getZoneConfigurationListener().airconTempZone2.tempUnit);
                airconTemp.tempValue = this.evlauteClimateBarTemperature(airconTemp.tempValue, airconTemp.tempUnit);
                this.climateTarget.getCarAirconDSI().setAirconTempZone(2, airconTemp);
                break;
            }
            case 2: {
                AirconTemp airconTemp = new AirconTemp(n2, this.getZoneConfigurationListener().airconTempZone3.tempUnit);
                airconTemp.tempValue = this.evlauteClimateBarTemperature(airconTemp.tempValue, airconTemp.tempUnit);
                this.climateTarget.getCarAirconDSI().setAirconTempZone(4, airconTemp);
                break;
            }
            case 3: {
                AirconTemp airconTemp = new AirconTemp(n2, this.getZoneConfigurationListener().airconTempZone4.tempUnit);
                airconTemp.tempValue = this.evlauteClimateBarTemperature(airconTemp.tempValue, airconTemp.tempUnit);
                this.climateTarget.getCarAirconDSI().setAirconTempZone(8, airconTemp);
                break;
            }
        }
    }

    private AirconTemp evaluateTemperatureChange(AirconTemp airconTemp, int n) {
        AirconTemp airconTemp2 = new AirconTemp();
        airconTemp2.tempUnit = airconTemp.tempUnit;
        if (n == 0) {
            airconTemp2.tempValue = this.decTemp(airconTemp.tempValue, airconTemp.tempUnit);
        } else if (n == 1) {
            airconTemp2.tempValue = this.incTemp(airconTemp.tempValue, airconTemp.tempUnit);
        }
        return airconTemp2;
    }

    private int evaluateTemperatureStepChange(int n, int n2, int n3) {
        int n4 = 0;
        if (n3 == 0) {
            n4 = n - 1 <= 0 ? 0 : n - 1;
        }
        if (n3 == 1) {
            n4 = n + 1 >= n2 ? n2 : n + 1;
        }
        return n4;
    }

    public int incTemp(int n, int n2) {
        switch (n2) {
            case 1: {
                n = n + 4 > 148 ? 255 : (n + 4 < 40 ? 40 : (n += 4));
                return n;
            }
            case 0: {
                n = n + 5 > 195 ? 255 : (n + 5 < 60 ? 60 : (n += 5));
                return n;
            }
        }
        return n;
    }

    public int evlauteClimateBarTemperature(int n, int n2) {
        int n3;
        switch (n2) {
            case 1: {
                if (n > 148) {
                    n3 = 255;
                    break;
                }
                if (n < 40) {
                    n3 = 0;
                    break;
                }
                n3 = n;
                break;
            }
            case 0: {
                if (n > 195) {
                    n3 = 255;
                    break;
                }
                if (n < 60) {
                    n3 = 0;
                    break;
                }
                n3 = n;
                break;
            }
            default: {
                n3 = n;
            }
        }
        return n3;
    }

    public int decTemp(int n, int n2) {
        switch (n2) {
            case 1: {
                n = n - 4 < 40 ? 0 : (n - 4 > 148 ? 148 : (n -= 4));
                return n;
            }
            case 0: {
                n = n - 5 < 60 ? 0 : (n - 5 > 195 ? 195 : (n -= 5));
                return n;
            }
        }
        return n;
    }

    public void setClimateProfile(int n, int n2) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(1, this.getClimateDSIProfileValue(n2));
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(4, this.getClimateDSIProfileValue(n2));
                break;
            }
        }
    }

    public void setClimateBarProfile(int n, int n2) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(1, this.getClimateDSIProfileValue(n2));
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(2, this.getClimateDSIProfileValue(n2));
                break;
            }
            case 2: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(4, this.getClimateDSIProfileValue(n2));
                break;
            }
            case 3: {
                this.climateTarget.getCarAirconDSI().setAirconClimateStyle(8, this.getClimateDSIProfileValue(n2));
                break;
            }
        }
    }

    private int getClimateDSIProfileValue(int n) {
        int n2 = 0;
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

    public void setClimatePreset(int n, int n2) {
        AirconAirVolume airconAirVolume;
        AirconAirDistribution airconAirDistribution;
        if (n == 0) {
            switch (n2) {
                case 0: {
                    airconAirDistribution = new AirconAirDistribution();
                    airconAirVolume = new AirconAirVolume(this.getZoneConfigurationListener().airVolumeZone1.airVolume, this.getZoneConfigurationListener().airVolumeZone1.airVolumeRegulated, this.getZoneConfigurationListener().airVolumeZone1.airVolumeAuto);
                    airconAirDistribution.automode = true;
                    airconAirVolume.airVolumeAuto = 1;
                    this.climateTarget.getCarAirconDSI().setAirconAirVolume(1, airconAirVolume);
                    this.climateTarget.getCarAirconDSI().setAirconAirDistribution(1, airconAirDistribution);
                    break;
                }
                case 1: {
                    if (this.getZoneConfigurationListener().presetList[0].presetModeMaxAc == 1) {
                        this.climateTarget.getCarAirconDSI().setAirconMaxAC(true);
                        break;
                    }
                    if (this.getZoneConfigurationListener().presetList[0].presetModeMaxAc != 2) break;
                    this.climateTarget.getCarAirconDSI().setAirconMaxAC(false);
                    break;
                }
                case 2: {
                    if (this.getZoneConfigurationListener().presetList[0].presetModeMaxDefrost == 1) {
                        this.climateTarget.getCarAirconDSI().setAirconMaxDefrost(true);
                        break;
                    }
                    if (this.getZoneConfigurationListener().presetList[0].presetModeMaxDefrost != 2) break;
                    this.climateTarget.getCarAirconDSI().setAirconMaxDefrost(false);
                    break;
                }
                case 3: {
                    break;
                }
            }
        }
        if (n == 1) {
            switch (n2) {
                case 0: {
                    airconAirDistribution = new AirconAirDistribution();
                    airconAirDistribution.automode = true;
                    airconAirVolume = new AirconAirVolume(this.getZoneConfigurationListener().airVolumeZone3.airVolume, this.getZoneConfigurationListener().airVolumeZone3.airVolumeRegulated, this.getZoneConfigurationListener().airVolumeZone3.airVolumeAuto);
                    airconAirVolume.airVolumeAuto = 1;
                    this.climateTarget.getCarAirconDSI().setAirconAirDistribution(4, airconAirDistribution);
                    this.climateTarget.getCarAirconDSI().setAirconAirVolume(4, airconAirVolume);
                    break;
                }
                case 3: {
                    break;
                }
            }
        }
    }

    public void setAirDistributionBody(int n) {
        if (n == 0) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone1);
            airconAirDistribution.body = this.negateAirDistributionIntAttribute(airconAirDistribution.body);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(1, airconAirDistribution);
        } else if (n == 1) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone3);
            airconAirDistribution.body = this.negateAirDistributionIntAttribute(airconAirDistribution.body);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(4, airconAirDistribution);
        }
    }

    public void setAirDistributionFootWell(int n) {
        if (n == 0) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone1);
            airconAirDistribution.footwell = this.negateAirDistributionIntAttribute(airconAirDistribution.footwell);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(1, airconAirDistribution);
        } else if (n == 1) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone3);
            airconAirDistribution.footwell = this.negateAirDistributionIntAttribute(airconAirDistribution.footwell);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(4, airconAirDistribution);
        }
    }

    public void setAirDistributionWindow(int n) {
        if (n == 0) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone1);
            airconAirDistribution.up = this.negateAirDistributionIntAttribute(airconAirDistribution.up);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(1, airconAirDistribution);
        } else if (n == 1) {
            AirconAirDistribution airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone3);
            airconAirDistribution.up = this.negateAirDistributionIntAttribute(airconAirDistribution.up);
            this.climateTarget.getCarAirconDSI().setAirconAirDistribution(4, airconAirDistribution);
        }
    }

    public void setAirDistribution(int n, AirconAirDistribution airconAirDistribution) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconAirDistribution(1, airconAirDistribution);
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconAirDistribution(2, airconAirDistribution);
                break;
            }
            case 2: {
                this.climateTarget.getCarAirconDSI().setAirconAirDistribution(4, airconAirDistribution);
                break;
            }
            case 3: {
                this.climateTarget.getCarAirconDSI().setAirconAirDistribution(8, airconAirDistribution);
                break;
            }
        }
    }

    public void setAirVolume(int n, AirconAirVolume airconAirVolume) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconAirVolume(1, airconAirVolume);
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconAirVolume(2, airconAirVolume);
                break;
            }
            case 2: {
                this.climateTarget.getCarAirconDSI().setAirconAirVolume(4, airconAirVolume);
                break;
            }
            case 3: {
                this.climateTarget.getCarAirconDSI().setAirconAirVolume(8, airconAirVolume);
                break;
            }
        }
    }

    public AirconAirDistribution getAirDistributionFromAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
        AirconAirDistribution airconAirDistribution = this.getAirDistributionOfZone(climateAirDistributionCombined.getAirDistributionMemberZone());
        switch (climateAirDistributionCombined.getAirDistibutionCombined()) {
            case 3: {
                airconAirDistribution.body = 12;
                airconAirDistribution.footwell = 0;
                airconAirDistribution.up = 0;
                break;
            }
            case 5: {
                airconAirDistribution.body = 12;
                airconAirDistribution.footwell = 12;
                airconAirDistribution.up = 0;
                break;
            }
            case 2: {
                airconAirDistribution.body = 0;
                airconAirDistribution.footwell = 12;
                airconAirDistribution.up = 0;
                break;
            }
            case 1: {
                airconAirDistribution.body = 0;
                airconAirDistribution.footwell = 0;
                airconAirDistribution.up = 12;
                break;
            }
            case 6: {
                airconAirDistribution.body = 12;
                airconAirDistribution.footwell = 12;
                airconAirDistribution.up = 12;
                break;
            }
            case 4: {
                airconAirDistribution.body = 0;
                airconAirDistribution.up = 12;
                airconAirDistribution.footwell = 12;
                break;
            }
            case 0: {
                airconAirDistribution.body = 0;
                airconAirDistribution.up = 0;
                airconAirDistribution.footwell = 0;
                break;
            }
        }
        return airconAirDistribution;
    }

    public AirconAirDistribution getAirDistributionOfZone(int n) {
        AirconAirDistribution airconAirDistribution;
        switch (n) {
            case 0: {
                airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone1);
                break;
            }
            case 1: {
                airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone2);
                break;
            }
            case 2: {
                airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone3);
                break;
            }
            case 3: {
                airconAirDistribution = this.createNewAirDistribution(this.getZoneConfigurationListener().airDistributionZone4);
                break;
            }
            default: {
                airconAirDistribution = new AirconAirDistribution();
            }
        }
        return airconAirDistribution;
    }

    public AirconAirVolume getAirVolumeOfZone(int n) {
        AirconAirVolume airconAirVolume;
        switch (n) {
            case 0: {
                airconAirVolume = this.getZoneConfigurationListener().airVolumeZone1;
                break;
            }
            case 1: {
                airconAirVolume = this.getZoneConfigurationListener().airVolumeZone2;
                break;
            }
            case 2: {
                airconAirVolume = this.getZoneConfigurationListener().airVolumeZone3;
                break;
            }
            case 3: {
                airconAirVolume = this.getZoneConfigurationListener().airVolumeZone4;
                break;
            }
            default: {
                airconAirVolume = new AirconAirVolume();
            }
        }
        AirconAirVolume airconAirVolume2 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
        return airconAirVolume2;
    }

    public void setAirCirculationManual() {
        this.climateTarget.getCarAirconDSI().setAirconAirCirculationMan(!this.isButtonFrontAirCirculationManActive);
    }

    public void setACCompressor() {
        this.climateTarget.getCarAirconDSI().setAirconAC(!this.getZoneConfigurationListener().isButtonFrontACActive);
    }

    public void setAirVolume(int n, int n2, int n3) {
        AirconAirVolume airconAirVolume;
        if (n == 0) {
            airconAirVolume = this.createNewAirVolumeAutoModified(this.getZoneConfigurationListener().airVolumeZone1);
            airconAirVolume.airVolume = this.modifyAirVolume(this.getZoneConfigurationListener().airVolumeZone1.airVolume, n2, n3);
            this.climateTarget.getCarAirconDSI().setAirconAirVolume(1, airconAirVolume);
        }
        if (n == 1) {
            airconAirVolume = this.createNewAirVolumeAutoModified(this.getZoneConfigurationListener().airVolumeZone3);
            airconAirVolume.airVolume = airconAirVolume.airVolume = this.modifyAirVolume(this.getZoneConfigurationListener().airVolumeZone3.airVolume, n2, n3);
            this.climateTarget.getCarAirconDSI().setAirconAirVolume(4, airconAirVolume);
        }
    }

    public void setAirConSynchronization() {
        AirconSynchronisation airconSynchronisation;
        if (this.getZoneConfigurationListener().airconSynchronisation.master == 0) {
            airconSynchronisation = new AirconSynchronisation(this.getZoneConfigurationListener().syncMaster, true, true, true, true, true, true);
            airconSynchronisation.master = this.getZoneConfigurationListener().syncMaster;
        } else {
            airconSynchronisation = new AirconSynchronisation();
            airconSynchronisation.master = 0;
        }
        this.climateTarget.getCarAirconDSI().setAirconSynchronisation(airconSynchronisation);
    }

    public void toggleAirconAirCirculationAuto() {
        this.climateTarget.getCarAirconDSI().setAirconAirCirculationAuto(!this.isAutoAirCirculation);
    }

    public void setAirconAuxiliaryHeating() {
        this.climateTarget.getCarAirconDSI().setAirconHeater(!this.isAuxiliaryHeating);
    }

    public void toggleAutoFrontWindowHeater() {
        this.climateTarget.getCarAirconDSI().setAirconFrontWindowHeaterAuto(!this.isautoWindowHeater);
    }

    public void toggleFrontWindowHeater() {
        this.climateTarget.getCarAirconDSI().setAirconFrontWindowHeater(!this.isFrontWindowHeater);
    }

    public void setFrontWindowHeater(boolean bl) {
        this.climateTarget.getCarAirconDSI().setAirconFrontWindowHeater(bl);
    }

    public void setRearWindowHeater(boolean bl) {
        this.climateTarget.getCarAirconDSI().setAirconRearWindowHeater(bl);
    }

    public void setMaxDefrost(boolean bl) {
        this.climateTarget.getCarAirconDSI().setAirconMaxDefrost(bl);
    }

    public void setSeatHeater(int n, int n2) {
        switch (n) {
            case 0: {
                if (n2 == this.getZoneConfigurationListener().seatHeaterFrontLeft) break;
                this.climateTarget.getCarAirconDSI().setAirconSeatHeater(1, 1, n2);
                break;
            }
            case 1: {
                if (n2 == this.getZoneConfigurationListener().seatHeaterFrontRigth) break;
                this.climateTarget.getCarAirconDSI().setAirconSeatHeater(2, 1, n2);
                break;
            }
        }
    }

    public void setSeatHeaterBalance(int n, int n2) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconSeatHeaterDistribution(1, n2);
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconSeatHeaterDistribution(2, n2);
                break;
            }
            case 2: {
                this.climateTarget.getCarAirconDSI().setAirconSeatHeaterDistribution(4, n2);
                break;
            }
            case 3: {
                this.climateTarget.getCarAirconDSI().setAirconSeatHeaterDistribution(8, n2);
                break;
            }
        }
    }

    public void setSeatVentilation(int n, int n2) {
        switch (n) {
            case 0: {
                if (n2 == this.getZoneConfigurationListener().seatVentilationFrontLeft) break;
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilation(1, 1, n2);
                break;
            }
            case 1: {
                if (n2 == this.getZoneConfigurationListener().seatVentilationFrontRight) break;
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilation(2, 1, n2);
                break;
            }
        }
    }

    public void setSeatVentilationBalance(int n, int n2) {
        switch (n) {
            case 0: {
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilationDistribution(1, n2);
                break;
            }
            case 1: {
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilationDistribution(2, n2);
                break;
            }
            case 2: {
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilationDistribution(4, n2);
                break;
            }
            case 3: {
                this.climateTarget.getCarAirconDSI().setAirconSeatVentilationDistribution(8, n2);
                break;
            }
        }
    }

    public void toggleSteeringWheelHeater() {
        AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(this.getCurrentSteeringWheelHeater().heating, this.getCurrentSteeringWheelHeater().currentState, this.getCurrentSteeringWheelHeater().autoHeating, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating, this.getCurrentSteeringWheelHeater().heatingStep);
        airconSteeringWheelHeater.heating = !airconSteeringWheelHeater.heating;
        this.climateTarget.getCarAirconDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
    }

    public void setSteeringWheelHeaterValueOnly(int n) {
        AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(this.getCurrentSteeringWheelHeater().heating, this.getCurrentSteeringWheelHeater().currentState, this.getCurrentSteeringWheelHeater().autoHeating, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating, this.getCurrentSteeringWheelHeater().heatingStep);
        airconSteeringWheelHeater.heatingStep = this.transformSteeringWheelHeatingStepToDSI(n);
        this.climateTarget.getCarAirconDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
    }

    public void toggleSteeringWheelHeaterAndSetValue(int n) {
        AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(this.getCurrentSteeringWheelHeater().heating, this.getCurrentSteeringWheelHeater().currentState, this.getCurrentSteeringWheelHeater().autoHeating, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating, this.getCurrentSteeringWheelHeater().heatingStep);
        airconSteeringWheelHeater.heatingStep = this.transformSteeringWheelHeatingStepToDSI(n);
        airconSteeringWheelHeater.heating = !airconSteeringWheelHeater.heating;
        this.climateTarget.getCarAirconDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
    }

    public void setCouplingSeatHeaterWithSteeringWheelHeater() {
        AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(this.getCurrentSteeringWheelHeater().heating, this.getCurrentSteeringWheelHeater().currentState, this.getCurrentSteeringWheelHeater().autoHeating, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating, this.getCurrentSteeringWheelHeater().heatingStep);
        airconSteeringWheelHeater.adjustViaSeatHeating = !airconSteeringWheelHeater.adjustViaSeatHeating;
        this.climateTarget.getCarAirconDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
    }

    public void setAutoActivationSteeringWheelHeater() {
        AirconSteeringWheelHeater airconSteeringWheelHeater = new AirconSteeringWheelHeater(this.getCurrentSteeringWheelHeater().heating, this.getCurrentSteeringWheelHeater().currentState, this.getCurrentSteeringWheelHeater().autoHeating, this.getCurrentSteeringWheelHeater().adjustViaSeatHeating, this.getCurrentSteeringWheelHeater().heatingStep);
        airconSteeringWheelHeater.autoHeating = !airconSteeringWheelHeater.autoHeating;
        this.climateTarget.getCarAirconDSI().setAirconSteeringWheelHeater(airconSteeringWheelHeater);
    }

    public void setPureAirState(boolean bl) {
        AirconPureAirSetup airconPureAirSetup = new AirconPureAirSetup(bl, this.getZoneConfigurationListener().pureAirActive.ionisator, this.getZoneConfigurationListener().pureAirActive.fragrance);
        this.climateTarget.getCarAirconDSI().setAirconPureAir(airconPureAirSetup);
    }

    public void updateClamp15Status(ClampSignal clampSignal) {
        this.isClamp15On = clampSignal.clamp15;
        this.getClimateServiceListener().updateClamp15State(this.isClamp15On);
    }

    public void setClimateSystemStateOfRow(int n, boolean bl) {
        this.climateTarget.getCarAirconDSI().setAirconSystemOnOffRow(n, bl);
    }

    public void evaluateClimateBarDisplay() {
        if (this.isClamp15On() && this.currentZoneConfiguration != 0 && this.currentZoneConfiguration != 14) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1553741824, true);
            this.climateTarget.writeToLog(0, "ClimateBar: Display Climate bar");
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1553741824, false);
            this.climateTarget.writeToLog(0, "ClimateBar: Climate bar not displayed");
        }
    }

    private int modifyAirVolume(int n, int n2, int n3) {
        int n4;
        block9: {
            block8: {
                n4 = 0;
                if (n2 == -1) break block8;
                switch (n2) {
                    case 1: {
                        n4 = n + 1;
                        if (n4 > this.getZoneConfigurationListener().airVolumeSliderFrontCollector.climate_air_distribution_slider_front_maximum) {
                            n4 = this.getZoneConfigurationListener().airVolumeSliderFrontCollector.climate_air_distribution_slider_front_maximum;
                            break;
                        }
                        if (n4 < 0) {
                            n4 = 0;
                            break;
                        }
                        break block9;
                    }
                    case 0: {
                        n4 = n - 1;
                        if (n4 < 0) {
                            n4 = 0;
                            break;
                        }
                        if (n4 > this.getZoneConfigurationListener().airVolumeSliderFrontCollector.climate_air_distribution_slider_front_maximum) {
                            n4 = this.getZoneConfigurationListener().airVolumeSliderFrontCollector.climate_air_distribution_slider_front_maximum;
                            break;
                        }
                        break block9;
                    }
                }
                break block9;
            }
            n4 = n3;
        }
        return n4;
    }

    private AirconAirDistribution createNewAirDistribution(AirconAirDistribution airconAirDistribution) {
        AirconAirDistribution airconAirDistribution2 = new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, 0);
        return airconAirDistribution2;
    }

    private AirconAirVolume createNewAirVolumeAutoModified(AirconAirVolume airconAirVolume) {
        AirconAirVolume airconAirVolume2 = new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto == 1 ? 0 : airconAirVolume.airVolumeAuto);
        return airconAirVolume2;
    }

    private int negateAirDistributionIntAttribute(int n) {
        int n2 = 0;
        n2 = n == 0 ? 12 : 0;
        return n2;
    }

    private int transformSteeringWheelHeatingStepToDSI(int n) {
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
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    private void solvingViewOptionsClimate(int n, int n2, int n3) {
        switch (n) {
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(n2, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(n3, true);
                break;
            }
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(n2, true);
                ServiceManager.aslPropertyManager.valueChangedBoolean(n3, false);
                break;
            }
            case 0: {
                ServiceManager.aslPropertyManager.valueChangedBoolean(n2, false);
                ServiceManager.aslPropertyManager.valueChangedBoolean(n3, false);
                break;
            }
        }
    }

    public void evaluateSkodaPopup(AirconContent airconContent) {
        if ((this.isTemperaturePopupLeftOpen || this.isTemperaturePopupRightOpen) && airconContent.zone1 == 0 && airconContent.zone2 == 0) {
            this.climateTarget.sendHMIEvent(-1263730432);
        }
        if (airconContent.zone1 == 3 && airconContent.zone2 == 2) {
            this.climateTarget.sendHMIEvent(-1280507648);
            this.isTemperaturePopupRightOpen = true;
        } else if (airconContent.zone1 == 2 && airconContent.zone2 == 3) {
            this.climateTarget.sendHMIEvent(-1280507648);
            this.isTemperaturePopupLeftOpen = true;
        } else if (airconContent.zone1 == 2 && airconContent.zone2 == 2) {
            this.climateTarget.sendHMIEvent(-1280507648);
            this.isTemperaturePopupLeftOpen = true;
            this.isTemperaturePopupRightOpen = true;
        } else if (airconContent.zone1 == 2 && airconContent.zone2 == 0) {
            this.climateTarget.sendHMIEvent(-1280507648);
            this.isTemperaturePopupLeftOpen = true;
        } else if (airconContent.zone1 == 0 && airconContent.zone2 == 2) {
            this.climateTarget.sendHMIEvent(-1280507648);
            this.isTemperaturePopupRightOpen = true;
        }
        this.setLastAirconContent(airconContent);
    }

    private ClimateServiceImpl getClimateService() {
        if (this.climateService == null) {
            this.climateService = new ClimateServiceImpl(this);
        }
        return this.climateService;
    }

    public void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$climate$ClimateService == null ? (class$de$vw$mib$asl$api$car$climate$ClimateService = ClimateMainController.class$("de.vw.mib.asl.api.car.climate.ClimateService")) : class$de$vw$mib$asl$api$car$climate$ClimateService, this.getClimateService());
        this.isClimateServiceAvailable = true;
        this.isClimateServiceExisting = true;
        this.getClimateServiceListener().updateClimateServiceAvailable(this.isClimateServiceAvailable);
        this.getClimateServiceListener().updateClimateServiceExisting(this.isClimateServiceExisting);
    }

    public void setTemperature(int n, int n2, int n3) {
        AirconTemp airconTemp = new AirconTemp(n2, n3);
        this.climateTarget.getCarAirconDSI().setAirconTempZone(n, airconTemp);
    }

    public ClimateTargetServices getClimateTarget() {
        return this.climateTarget;
    }

    public ClimateViewOptionCollector getViewOptionCollector() {
        return this.viewOptionCollector;
    }

    public ClimateConfigurationCollector getClimateConfiguration() {
        return this.climateConfiguration;
    }

    public boolean isClamp15On() {
        return this.isClamp15On;
    }

    public boolean isClimateServiceExisting() {
        return this.isClimateServiceExisting;
    }

    public boolean isClimateServiceAvailable() {
        return this.isClimateServiceAvailable;
    }

    private void evaluateClimateServiceAvailable(int n) {
        switch (n) {
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                this.isClimateServiceAvailable = true;
                break;
            }
            default: {
                this.isClimateServiceAvailable = false;
                this.climateTarget.writeToLog(0, "evaluateClimateServiceAvailable: ClimateService NOT AVAILABLE");
            }
        }
    }

    public AirconContent getLastAirconContent() {
        return this.lastAirconContent;
    }

    public void setLastAirconContent(AirconContent airconContent) {
        this.lastAirconContent = airconContent;
    }

    public AirconSteeringWheelHeater getCurrentSteeringWheelHeater() {
        return this.currentSteeringWheelHeater;
    }

    public void updateAirconFrontWindowHeater(boolean bl, int n) {
        this.isFrontWindowHeater = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(300, this.isFrontWindowHeater);
        this.getClimateServiceListener().updateAirconFrontWindowHeater(bl);
    }

    public void updateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        this.isautoWindowHeater = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(671378944, this.isautoWindowHeater);
    }

    public void updateAirconHeater(boolean bl, int n) {
        this.isAuxiliaryHeating = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(721710592, this.isAuxiliaryHeating);
    }

    public void updateAirconAirCirculationMan(boolean bl, int n) {
        this.isButtonFrontAirCirculationManActive = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(-1062403840, this.isButtonFrontAirCirculationManActive);
    }

    public void updateAirconAirCirculationAuto(boolean bl, int n) {
        this.isAutoAirCirculation = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(688156160, this.isAutoAirCirculation);
    }

    public boolean isTwoZonesMLB() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(101) && (this.currentZoneConfiguration == 2 || this.currentZoneConfiguration == 3);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

