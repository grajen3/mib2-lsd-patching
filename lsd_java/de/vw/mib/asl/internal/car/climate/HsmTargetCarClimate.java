/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.climate;

import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.content.AbstractStageContentRequest;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.api.climate.modelclient.ClimateModelAdapter;
import de.vw.mib.asl.internal.car.climate.ClimateMainController;
import de.vw.mib.asl.internal.car.climate.ClimateTargetServices;
import de.vw.mib.asl.internal.car.climate.ClimateTraceUtils;
import de.vw.mib.asl.internal.car.climate.HsmTargetCarClimate$1;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.caraircondition.AirconAirDistribution;
import org.dsi.ifc.caraircondition.AirconAirVolume;
import org.dsi.ifc.caraircondition.AirconContent;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;
import org.dsi.ifc.caraircondition.AirconPureAirSetup;
import org.dsi.ifc.caraircondition.AirconRowViewOptions;
import org.dsi.ifc.caraircondition.AirconSteeringWheelHeater;
import org.dsi.ifc.caraircondition.AirconSynchronisation;
import org.dsi.ifc.caraircondition.AirconTemp;
import org.dsi.ifc.caraircondition.DSICarAirCondition;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.osgi.framework.ServiceRegistration;

public class HsmTargetCarClimate
extends AbstractASLTarget
implements ClimateTargetServices {
    private DSICarAirCondition dsiCarAirCondition;
    private static final int EV_CLIMATE_TIME_OUT;
    private static final int EV_CLIMATE_EDIT_TEMP_TIME_OUT;
    private static final int EV_CLIMATE_SEAT_HEATER_LEFT_TIME_OUT;
    private static final int EV_CLIMATE_SEAT_HEATER_RIGHT_TIME_OUT;
    private AirconContent toSetContent;
    private boolean isClimateFSGDisplayModeActive;
    private boolean systemInStandby;
    private ClimateMainController mainController = new ClimateMainController(this);
    private AirconContent menuToRestore;
    private ClimateModelAdapter climateModelAdapter;
    private static ServiceRegistration serviceRegistration;
    boolean isClimateDesktopActive = false;
    private boolean isRegisterOnAirCondition;
    private AbstractStageContentRequest changeToClimateContextRequest;
    public static Logger log;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirCondition;
    static /* synthetic */ Class class$org$dsi$ifc$caraircondition$DSICarAirConditionListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;

    ClimateMainController getNewClimateView() {
        if (this.mainController == null) {
            this.mainController = new ClimateMainController(this);
        }
        return this.mainController;
    }

    void createContentRequestHandler() {
        this.changeToClimateContextRequest = new HsmTargetCarClimate$1(this, "HMI_CLIMATE");
    }

    public HsmTargetCarClimate(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.createContentRequestHandler();
        this.climateModelAdapter = new ClimateModelAdapter(genericEvents, string);
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    @Override
    public int getDefaultTargetId() {
        return -1940975104;
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{-268435392, -201326528, -184549312, -167772096, -150994880, -1568276160, -930741952, -913964736, -33554368, -133758912, 571080768, 329072896, 0x4090040, -435552192, 1711996992, -897187520, -134217664, -117440448, -100663232, -83886016, -1585053376, -1601830592, -1534721728, -1551498944, -234880960, 6952960, 362627328, 379404544, -1517944512, -1484390080, -1467612864, -1450835648, -1434058432, -1417281216, -1333395136, -1316617920, -1299840704, -1232731840, -1215954624, -150536128, -1199177408, -1048182464, 544553024, 645216320, 628439104, 561330240, 578107456, 661993536, 678770752, 611661888, -947519168, 98397504, 64843072, 14511424, 115174720, 48065856, 81620288});
    }

    private void registerOnCarAirCondition() {
        if (!this.isRegisterOnAirCondition) {
            this.dsiCarAirCondition = (DSICarAirCondition)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = HsmTargetCarClimate.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition);
            this.dsiCarAirCondition.setNotification(new int[]{4, 17, 12, 10, 2, 25, 31, 21, 19, 37, 16, 81, 82, 43, 15, 3, 83, 111, 113, 115, 117, 110, 112, 114, 152, 153, 167, 169, 168, 170, 7}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = HsmTargetCarClimate.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener));
            this.isRegisterOnAirCondition = true;
        }
    }

    void registerOnPowerManagement() {
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetCarClimate.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        dSIPowerManagement.setNotification(new int[]{4}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetCarClimate.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener));
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("CLIMATE Event received: ").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.init();
                this.registerOnPowerManagement();
                this.registerOnModelEvents();
                this.registerOnUpdates(92);
                this.leavingClimateContext();
                this.getClimateModelAdapter().triggerMe(eventGeneric.getReceiverEventId());
                this.getNewClimateView().registerAsServiceProvider();
                break;
            }
            case 0x400000F0: 
            case 1080941824: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleAirconAirCirculationAuto();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_AUTO_AIR_CIRCULATION --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742066: 
            case 1080941830: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirconAuxiliaryHeating();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_AUTO_AUXILIARY_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742069: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleFrontWindowHeater();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_WINDOW_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742070: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.getCarAirconDSI().setAirconSystemOnOffRow(1, !this.mainController.getZoneConfigurationListener().isClimateSystemOn);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargeCarClimate: SWITCH_CLIMATE_SYSTEM_OFF --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742071: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.getCarAirconDSI().setAirconSystemOnOffRow(1, true);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SWITCH_CLIMATE_SYSTEM_ON --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841826: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.EnterClimateContext").log();
                }
                this.triggerObserver(983384320, null);
                if (!this.mainController.isTemperaturePopupLeftOpen && !this.mainController.isTemperaturePopupRightOpen) break;
                this.closeSkodaTemperaturePopup();
                break;
            }
            case 1073841864: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.EnterClimateDesktop").log();
                }
                if (this.isClimateDesktopActive) break;
                this.isClimateDesktopActive = true;
                this.informFSGClimateMenuDisplayed();
                break;
            }
            case 1073841865: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.ExitClimateDesktop").log();
                }
                if (!this.isClimateDesktopActive) break;
                this.isClimateDesktopActive = false;
                this.leavingClimateContext();
                break;
            }
            case 1073742078: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.ExitClimateContext").log();
                }
                this.triggerObserver(1000161536, null);
                break;
            }
            case 1073743863: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate: starting timer").log();
                }
                this.startTimer(75956480, (long)eventGeneric.getInt(0), false);
                break;
            }
            case 1073743864: {
                if (!this.getMainObject().getTimerServer().isTimerActive(this.getTargetId(), 75956480)) break;
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate: stopping active timer").log();
                }
                this.stopTimer(75956480);
                break;
            }
            case 100100: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate: timeout and close view").log();
                }
                this.sendHMIEvent(435);
                break;
            }
            case 4300051: {
                ASLCarContainer.getInstance().setMainUnitTime((ClockTime)eventGeneric.getObject(1));
                break;
            }
            case 0x40000904: {
                this.leavingClimateContext();
                this.isClimateDesktopActive = false;
                break;
            }
            case 1073744418: 
            case 1080941826: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleAutoFrontWindowHeater();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_AUTO_WINDOW_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742072: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setSeatHeater(0, eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_SEAT_HEATER_VALUE_LEFT --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742073: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.SET_SEAT_HEATER_VALUE_RIGHT").log();
                }
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setSeatHeater(1, eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_SEAT_HEATER_VALUE_RIGHT --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742074: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setSeatVentilation(0, eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_SEAT_VENTILATION_VALUE_LEFT --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073742075: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setSeatVentilation(1, eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_SEAT_VENTILATION_VALUE_RIGHT --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073744614: 
            case 1080941828: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setCouplingSeatHeaterWithSteeringWheelHeater();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_COUPLING_SEAT_HEATER_WITH_STEERING_WHEEL_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841825: 
            case 1080941827: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAutoActivationSteeringWheelHeater();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_AUTO_ACTIVATION_STEERING_WHEEL_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 0x400000F4: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleSteeringWheelHeater();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_STEERING_WHEEL_HEATER --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073744742: 
            case 1080941829: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setSteeringWheelHeaterValueOnly(eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Climate.SET_STEERING_WHEEL_HEATER_VALUE").log();
                this.trace().append("HsmTargetCarClimate: SET_STEERING_WHEEL_HEATER_VALUE --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841866: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleSteeringWheelHeaterAndSetValue(eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Climate.TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE").log();
                this.trace().append("HsmTargetCarClimate: TOGGLE_STEERING_WHEEL_HEATER_AND_SET_VALUE --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 111111: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("Climate.EV_CLIMATE_EDIT_TEMP_TIME_OUT").log();
                break;
            }
            case 1073841827: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.SEATHEATING_LEFT_POPUP_CLOSED").log();
                }
                if (this.isClimateFSGDisplayModeActive) {
                    this.toSetContent.zone1 = 7;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                } else {
                    this.leavingClimateContext();
                }
                if (this.mainController.isTemperaturePopupLeftOpen) {
                    this.toSetContent.zone1 = 2;
                    this.toSetContent.zone2 = 0;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                } else if (this.mainController.isTemperaturePopupRightOpen) {
                    this.toSetContent.zone1 = 0;
                    this.toSetContent.zone2 = 2;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                }
                this.mainController.isSeatHeaterPopupLeftOpen = false;
                break;
            }
            case 1073841828: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.SEATHEATING_RIGHT_POPUP_CLOSED").log();
                }
                if (this.isClimateFSGDisplayModeActive) {
                    this.toSetContent.zone1 = 7;
                    this.toSetContent.zone2 = 0;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                } else {
                    this.leavingClimateContext();
                }
                if (this.mainController.isTemperaturePopupLeftOpen) {
                    this.toSetContent.zone1 = 2;
                    this.toSetContent.zone2 = 0;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                } else if (this.mainController.isTemperaturePopupRightOpen) {
                    this.toSetContent.zone1 = 0;
                    this.toSetContent.zone2 = 2;
                    this.getCarAirconDSI().setAirconContent(this.toSetContent);
                }
                this.mainController.isSeatHeaterPopupRightOpen = false;
                break;
            }
            case 1073841857: {
                if (this.isTraceEnabled()) {
                    this.trace().append("Climate.AIR_DISTRIBUTION_POPUP_CLOSED").log();
                }
                if (this.isClimateFSGDisplayModeActive) {
                    AirconContent airconContent = new AirconContent();
                    airconContent.zone1 = 7;
                    this.getCarAirconDSI().setAirconContent(airconContent);
                    break;
                }
                this.leavingClimateContext();
                break;
            }
            case 1073841824: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.getCarAirconDSI().setAirconRearControl(this.mainController.getZoneConfigurationListener().isRearControl);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("Climate.TOGGLE_REAR_LOCK").log();
                this.trace().append("HsmTargetCarClimate: TOGGLE_REAR_LOCK --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1600000: {
                if (this.isClimateDesktopActive) break;
                this.leavingClimateContext();
                break;
            }
            case 4300053: {
                this.dsiCarAirCondition.setAirconContent(new AirconContent());
                this.systemInStandby = true;
                break;
            }
            case 4300054: {
                this.systemInStandby = false;
                break;
            }
            case 1073841829: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setClimatePreset(eventGeneric.getInt(0), eventGeneric.getInt(1));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_CLIMATE_PRESET --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841831: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setClimateProfile(eventGeneric.getInt(0), eventGeneric.getInt(1));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_CLIMATE_PROFILE2 --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841832: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setTemperature(eventGeneric.getInt(0), eventGeneric.getInt(1));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_CLIMATE_TEMPERATURE --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841833: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirDistributionBody(eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIRCON_AIR_DISTRIBUTION_BODY --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841834: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirDistributionFootWell(eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIRCON_AIR_DISTRIBUTION_FOOTWELL --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841835: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirDistributionWindow(eventGeneric.getInt(0));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIRCON_AIR_DISTRIBUTION_UP --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841840: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirCirculationManual();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIR_DISTRIBUTION_SLIDER2 --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841841: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setACCompressor();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIR_DISTRIBUTION_SLIDER2 --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841842: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.toggleRearClimateState();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIRCON_SYSTEM_ON_OFF_REAR2 --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841846: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirVolume(eventGeneric.getInt(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: SET_AIR_DISTRIBUTION_SLIDER2 --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841847: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setAirConSynchronization();
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_SYNCHRONISATION --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841848: {
                if (this.mainController.isClimateServiceAvailable()) {
                    this.mainController.setPureAirState(!this.mainController.getZoneConfigurationListener().pureAirActive.systemOnOff);
                    break;
                }
                if (!this.isTraceEnabled()) break;
                this.trace().append("HsmTargetCarClimate: TOGGLE_PURE_AIR --> CLIMATE SERVICE NOT AVAILABLE ").log();
                break;
            }
            case 1073841863: {
                this.closeSkodaTemperaturePopup();
                this.mainController.isTemperaturePopupLeftOpen = false;
                this.mainController.isTemperaturePopupRightOpen = false;
                break;
            }
        }
    }

    public void dsiCarAirConditionUpdateAirconAirCirculationAuto(boolean bl, int n) {
        this.mainController.updateAirconAirCirculationAuto(bl, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirCirculationAuto", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconHeater(boolean bl, int n) {
        this.mainController.updateAirconHeater(bl, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConHeater", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconSteeringWheelHeater(AirconSteeringWheelHeater airconSteeringWheelHeater, int n) {
        this.mainController.updateAirconSteeringWheelHeater(airconSteeringWheelHeater, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSteeringWheelHeater", airconSteeringWheelHeater.toString());
    }

    public void dsiCarAirConditionUpdateAirconFrontWindowHeater(boolean bl, int n) {
        this.mainController.updateAirconFrontWindowHeater(bl, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConFrontWindowHeater", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconRearWindowHeater(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconRearWindowHeater(bl, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("UpdateAirconFrontWindowHeater: Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConRearWindowHeater", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconTempZone2(AirconTemp airconTemp, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempZone2(airconTemp, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempZone2", airconTemp.toString());
    }

    public void dsiCarAirConditionUpdateAirconTempZone1(AirconTemp airconTemp, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempZone1(airconTemp, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.TempZone1: ").append(airconTemp.getTempValue()).append(" Unit: ").append(airconTemp.getTempUnit()).log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempZone1", airconTemp.toString());
    }

    public void dsiCarAirConditionUpdateAirconClimateStyleZone1(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getClimateStyleController().updateAirconClimateStyleZone1(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStyleZone1", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconClimateStyleZone2(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getClimateStyleController().updateAirconClimateStyleZone2(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStyleZone2", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconClimateStyleZone3(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getClimateStyleController().updateAirconClimateStyleZone3(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStyleZone3", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSynchronisation(AirconSynchronisation airconSynchronisation, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSynchronisation(airconSynchronisation, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSynchronisation", airconSynchronisation.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirDistributionZone1(AirconAirDistribution airconAirDistribution, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirDistributionZone1(airconAirDistribution, n);
            this.informAirdistributionUpdateToModel();
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirDistributionZone1", airconAirDistribution.toString());
    }

    private void informAirdistributionUpdateToModel() {
        this.sendHMIEvent(-1246953216);
    }

    public void dsiCarAirConditionUpdateAirconAirVolumeZone1(AirconAirVolume airconAirVolume, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirVolumeZone1(airconAirVolume, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirVolumeZone1", airconAirVolume.toString());
    }

    public void dsiCarAirConditionUpdateAirconMaxDefrost(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconMaxDefrost(bl, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConMaxDefrost", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconMaxAC(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconMaxAC(bl, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConMaxAC", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconContent(AirconContent airconContent, int n) {
        this.trace("Climate.updateAirconContent: ", airconContent.toString());
        if (airconContent.zone1 == 7) {
            this.isClimateFSGDisplayModeActive = true;
            if (!this.isClimateDesktopActive) {
                if (this.mainController.isClamp15On()) {
                    this.sendWakeupEvent();
                    ASLSystemFactory.getSystemApi().getStageContentRequestProcessor().process(this.changeToClimateContextRequest);
                } else {
                    this.sendHMIEvent(-1230176000);
                    this.leavingClimateContext();
                }
            }
        } else if (airconContent.zone1 == 1) {
            this.sendHMIEvent(-1297284864);
        } else if (airconContent.zone1 == 3 || airconContent.zone1 == 4) {
            this.sendWakeupEvent();
            this.showSeatPopup(569, 145883392);
            this.sendSleepAgainEvent();
            this.mainController.isSeatHeaterPopupLeftOpen = true;
        } else if (airconContent.zone2 == 3 || airconContent.zone2 == 4) {
            this.sendWakeupEvent();
            this.showSeatPopup(568, 162660608);
            this.sendSleepAgainEvent();
            this.mainController.isSeatHeaterPopupRightOpen = true;
        } else if (airconContent.zone1 == 0) {
            this.isClimateFSGDisplayModeActive = false;
            if (!this.isClimateDesktopActive) {
                this.sendHMIEvent(-1314062080);
            }
        }
        if (!this.isClimateDesktopActive) {
            this.mainController.evaluateSkodaPopup(airconContent);
        }
    }

    public void dsiCarAirConditionUpdateAirconSystemOnOffRow1(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().setClimateSystemONOFF(bl);
        } else if (this.isTraceEnabled()) {
            this.trace().append("UpdateAirconSystemOnOffRow1: Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSystemOnOffRow1", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconFrontWindowHeaterAuto(boolean bl, int n) {
        this.mainController.updateAirconFrontWindowHeaterAuto(bl, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConFrontWindowHeaterAuto", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconRearControl(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().isRearControl = !bl;
            HsmTargetCarClimate.writeBooleanToDatapool(-1280507648, this.mainController.getZoneConfigurationListener().isRearControl);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconRearControl ").append(bl).append(" ").append(n).log();
            this.trace().append("UpdateAirconRearControl= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConRearControl", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconAirVolumeZone3(AirconAirVolume airconAirVolume, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirVolumeZone3(airconAirVolume, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconAirVolumeZone3 ").append(airconAirVolume.toString()).append(" ").append(n).log();
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirVolumeZone3", airconAirVolume.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirDistributionZone3(AirconAirDistribution airconAirDistribution, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirDistributionZone3(airconAirDistribution, n);
            this.informAirdistributionUpdateToModel();
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconAirDistributionZone3 ").append(airconAirDistribution.toString()).append(" ").append(n).log();
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirDistributionZone3", airconAirDistribution.toString());
    }

    public void dsiCarAirConditionUpdateAirconTempZone3(AirconTemp airconTemp, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempZone3(airconTemp, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempZone3", airconTemp.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirDistributionZone2(AirconAirDistribution airconAirDistribution, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirDistributionZone2(airconAirDistribution, n);
            this.informAirdistributionUpdateToModel();
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirDistributionZone2", airconAirDistribution.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirVolumeZone2(AirconAirVolume airconAirVolume, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirVolumeZone2(airconAirVolume, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirVolumeZone2", airconAirVolume.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirVolumeZone4(AirconAirVolume airconAirVolume, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirVolumeZone4(airconAirVolume, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirVolumeZone4", airconAirVolume.toString());
    }

    public void dsiCarAirConditionUpdateAirconAirDistributionZone4(AirconAirDistribution airconAirDistribution, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAirDistributionZone4(airconAirDistribution, n);
            this.informAirdistributionUpdateToModel();
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirDistributionZone4", airconAirDistribution.toString());
    }

    public void dsiCarAirConditionUpdateAirconTempZone4(AirconTemp airconTemp, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempZone4(airconTemp, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempZone4", airconTemp.toString());
    }

    public void dsiCarAirConditionUpdateAirconTempStepZone1(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempStepZone1(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempStepZone1", new StringBuffer().append(" state: ").append(Integer.toString(n)).append(" stepCount: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconTempStepZone2(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempStepZone2(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempStepZone2", new StringBuffer().append(" state: ").append(Integer.toString(n)).append(" stepCount: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconTempStepZone3(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempStepZone3(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempStepZone3", new StringBuffer().append(" state: ").append(Integer.toString(n)).append(" stepCount: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconTempStepZone4(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconTempStepZone4(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConTempStepZone3", new StringBuffer().append(" state: ").append(Integer.toString(n)).append(" stepCount: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconAirCirculationMan(boolean bl, int n) {
        this.mainController.updateAirconAirCirculationMan(bl, n);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAirCirculationMan", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconAC(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconAC(bl, n);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConAC", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconViewOptionsMaster(AirconMasterViewOptions airconMasterViewOptions, int n) {
        ClimateTraceUtils.traceAirconVO(super.getClass(), airconMasterViewOptions, 92);
        this.mainController.evaluateMasterViewOptions(airconMasterViewOptions);
    }

    public void dsiCarAirConditionUpdateAirconViewOptionsRow1(AirconRowViewOptions airconRowViewOptions, int n) {
        ClimateTraceUtils.traceAirconVO(super.getClass(), airconRowViewOptions, 93);
        ASLSystemFactory.getSystemApi().setClimateECUhasMenuHK(airconRowViewOptions.configuration.setupButton);
        this.mainController.evaluateRowViewOptions(airconRowViewOptions, 0);
        this.mainController.evaluateRowViewOptions(airconRowViewOptions, 1);
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.registerOnCarAirCondition();
        }
        this.mainController.setRearFunctionsState();
        this.mainController.evaluateClimateBarDisplay();
    }

    public void dsiCarAirConditionUpdateAirconViewOptionsRow2(AirconRowViewOptions airconRowViewOptions, int n) {
        ClimateTraceUtils.traceAirconVO(super.getClass(), airconRowViewOptions, 94);
        this.mainController.evaluateRowViewOptions(airconRowViewOptions, 2);
        this.mainController.evaluateRowViewOptions(airconRowViewOptions, 3);
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.registerOnCarAirCondition();
            this.mainController.setRearFunctionsState();
        }
        this.mainController.evaluateClimateBarDisplay();
    }

    public void dsiCarAirConditionUpdateAirconSystemOnOffRow2(boolean bl, int n) {
        this.mainController.setRearClimateONOFF(bl);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSystemOnOffRow2", Boolean.toString(bl));
    }

    public void dsiCarAirConditionUpdateAirconClimateStateZone1(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconClimateStateZone1(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStateZone1", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconClimateStateZone2(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconClimateStateZone2(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStateZone2", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconClimateStateZone3(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconClimateStateZone3(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStateZone3", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconClimateStateZone4(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconClimateStateZone4(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConClimateStateZone4", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterZone1(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterZone1New(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconSeatHeaterZone1 ").append(n2).append(" ").append(n3).log();
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterZone1:  CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterZone1", new StringBuffer().append("state: ").append(Integer.toString(n)).append(" heaterlevel: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationZone1(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationZone1New(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconSeatVentilationZone1 ").append(n2).append(" ").append(n3).log();
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationZone1: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationZone1", new StringBuffer().append("state: ").append(Integer.toString(n)).append(" heaterlevel: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterZone2(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterZone2New(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconSeatHeaterZone2 ").append(n2).append(" ").append(n3).log();
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterZone2: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterZone2", new StringBuffer().append("state: ").append(Integer.toString(n)).append(" heaterlevel: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationZone2(int n, int n2, int n3) {
        int n4 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n4 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationZone2New(n, n2, n3);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate.updateAirconSeatVentilationZone2 ").append(n2).append(" ").append(n3).log();
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationZone2: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationZone2", new StringBuffer().append("state: ").append(Integer.toString(n)).append(" heaterlevel: ").append(Integer.toString(n2)).toString());
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone1(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterDistributionZone1(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone1: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterDistributionZone1", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone2(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterDistributionZone2(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone2: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterDistributionZone2", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone3(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterDistributionZone3(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone3: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterDistributionZone3", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone4(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatHeaterDistributionZone4(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatHeaterDistributionZone4: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatHeaterDistributionZone4", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone1(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationDistributionZone1(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone1: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationDistributionZone1", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone2(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationDistributionZone2(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone2: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationDistributionZone2", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone3(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationDistributionZone3(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone3: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationDistributionZone3", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone4(int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconSeatVentilationDistributionZone4(n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("dsiCarAirConditionUpdateAirconSeatVentilationDistributionZone4: CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConSeatVentilationDistributionZone4", Integer.toString(n));
    }

    public void dsiCarAirConditionUpdateAirconPureAir(AirconPureAirSetup airconPureAirSetup, int n, int n2) {
        int n3 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n3 != 0) {
            this.mainController.getZoneConfigurationListener().updateAirconPureAir(airconPureAirSetup, n, n2);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConPureAirSetup", airconPureAirSetup.toString());
    }

    public void dsiCarAirConditionUpdateAirconEcoAC(boolean bl, int n) {
        int n2 = this.mainController.currentZoneConfiguration;
        super.getClass();
        if (n2 != 0) {
            this.mainController.setECOPluseMode(bl);
        } else if (this.isTraceEnabled()) {
            this.trace().append("UpdateAirconEcoAC: Climate CurrentZoneConfiguration= UNKNOWN ").log();
        }
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateAirConEcoAC", Boolean.toString(bl));
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        this.mainController.updateClamp15Status(clampSignal);
        ClimateTraceUtils.traceNotification(super.getClass(), "UpdateClampSignal", clampSignal.toString());
    }

    private void showSeatPopup(int n, int n2) {
        if (this.mainController.seatHeaterPopupAllowed) {
            this.sendHMIEvent(n);
        }
    }

    private void closeSkodaTemperaturePopup() {
        AirconContent airconContent = new AirconContent();
        if (this.mainController.isSeatHeaterPopupLeftOpen) {
            airconContent.zone1 = 3;
        } else if (this.mainController.isSeatHeaterPopupRightOpen) {
            airconContent.zone2 = 3;
        }
        this.dsiCarAirCondition.setAirconContent(airconContent);
    }

    private void sendWakeupEvent() {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5603, 211632384);
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error("[HsmTargetCarClimate] Could not send wakeUpEvent to PowerManagement");
        }
    }

    void sendSleepAgainEvent() {
        try {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5603, 228409600);
            this.send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            this.error("[HsmTargetCarClimate] Could not send sleepAgainEvent to PowerManagement");
        }
    }

    private void init() {
        log = this.getTextLogger();
        this.toSetContent = new AirconContent();
        this.menuToRestore = new AirconContent();
        this.menuToRestore.zone1 = 7;
        HsmTargetCarClimate.writeIntegerToDatapool(4094, 0);
    }

    void leavingClimateContext() {
        this.toSetContent.zone1 = 0;
        this.toSetContent.zone2 = 0;
        this.toSetContent.zone3 = 0;
        this.toSetContent.zone4 = 0;
        this.getCarAirconDSI().setAirconContent(this.toSetContent);
    }

    public void append(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append(string).log();
        }
    }

    @Override
    public void writeToLog(int n, Object object) {
        if (this.isTraceEnabled()) {
            switch (n) {
                case 0: {
                    if (!this.isTraceEnabled()) break;
                    this.trace().append(object).log();
                    break;
                }
                case 3: {
                    break;
                }
            }
        }
    }

    @Override
    public void registerOnUpdates(int n) {
        DSIProxyAdapterFactory dSIProxyAdapterFactory = ASLCarContainer.getInstance().getAdapterFactory();
        this.getCarAirconDSI().setNotification(new int[]{n}, dSIProxyAdapterFactory.createDSIListenerMethodAdapter(this, class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = HsmTargetCarClimate.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener));
    }

    @Override
    public DSICarAirCondition getCarAirconDSI() {
        if (this.dsiCarAirCondition == null) {
            this.dsiCarAirCondition = (DSICarAirCondition)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$caraircondition$DSICarAirCondition == null ? (class$org$dsi$ifc$caraircondition$DSICarAirCondition = HsmTargetCarClimate.class$("org.dsi.ifc.caraircondition.DSICarAirCondition")) : class$org$dsi$ifc$caraircondition$DSICarAirCondition);
        }
        return this.dsiCarAirCondition;
    }

    @Override
    public void unregisterOnUpdates(int n) {
        this.getCarAirconDSI().clearNotification(n, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$caraircondition$DSICarAirConditionListener == null ? (class$org$dsi$ifc$caraircondition$DSICarAirConditionListener = HsmTargetCarClimate.class$("org.dsi.ifc.caraircondition.DSICarAirConditionListener")) : class$org$dsi$ifc$caraircondition$DSICarAirConditionListener));
    }

    @Override
    public ClimateModelAdapter getClimateModelAdapter() {
        return this.climateModelAdapter;
    }

    private void informFSGClimateMenuDisplayed() {
        this.getCarAirconDSI().setAirconContent(this.menuToRestore);
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

