/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.viewoption;

import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.vo.DeviceManagerInterface;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetListener;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.dm.DeviceManager;
import de.vw.mib.asl.internal.car.light.transformer.AmbienceLightAreaCollector;
import de.vw.mib.asl.internal.car.light.transformer.CarLightAmbienceColorAreaSettings_1CollectorFactory;
import de.vw.mib.asl.internal.car.model.ModelDeviceStartupManager;
import de.vw.mib.asl.internal.car.transformer.CarFunctionCollector;
import de.vw.mib.asl.internal.car.viewoption.FunctionIds;
import de.vw.mib.asl.internal.car.viewoption.HsmTargetCarViewOption;
import de.vw.mib.asl.internal.car.viewoption.StateWork$1;
import de.vw.mib.asl.internal.car.viewoption.StateWork$2;
import de.vw.mib.asl.internal.car.viewoption.StateWork$ResetCARParticipant;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.personal.transformer.CarPersonalAssignKeyAvailabilityCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceOilServiceButtonAvailabilityCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;
import org.dsi.ifc.carcomfort.BrakeViewOptions;
import org.dsi.ifc.carcomfort.DoorLockingCLSettings;
import org.dsi.ifc.carcomfort.DoorLockingConfiguration;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.carcomfort.RGSViewOptions;
import org.dsi.ifc.carcomfort.UGDOViewOptions;
import org.dsi.ifc.carcomfort.WiperViewOptions;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;
import org.dsi.ifc.cardriverassistance.AWVViewOptions;
import org.dsi.ifc.cardriverassistance.LDWHCAViewOptions;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.cardriverassistance.PAViewOptions;
import org.dsi.ifc.cardriverassistance.SWAViewOptions;
import org.dsi.ifc.cardriverassistance.TSDConfiguration;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.CharismaViewOptions;
import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.StartStopViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.HybridViewOptions;
import org.dsi.ifc.carkombi.BCConfiguration;
import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;
import org.dsi.ifc.carkombi.BCFunctionSupport;
import org.dsi.ifc.carkombi.BCTransmittableElements;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.HUDViewOptions;
import org.dsi.ifc.carkombi.SIAViewOptions;
import org.dsi.ifc.carlight.ExtLightViewOptions;
import org.dsi.ifc.carlight.IntLightConfig;
import org.dsi.ifc.carlight.IntLightMembersIlluminationSet;
import org.dsi.ifc.carlight.IntLightMembersMultiColor;
import org.dsi.ifc.carlight.IntLightViewOptions;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateWork
extends AbstractHsmState
implements FactoryResetListener {
    private static final int EV_TIME_OUT_ECO_CONSUMER_LIST;
    private static final int EV_TIME_OUT_VEHICLESTATUS;
    protected final HsmTargetCarViewOption myTarget;
    boolean funcationState = false;
    int functionReason = 0;
    private final int[] reasons = new int[6];
    private boolean readingAdaptation = false;
    private boolean readingCODING = false;
    private ClockViewOptions myClockViewOptions = new ClockViewOptions();
    private UnitmasterViewOptions myUnitMasterViewOptions = new UnitmasterViewOptions();
    AdaptionResponse funcAdapResponse = new StateWork$1(this);
    AdaptionResponse codingResponse = new StateWork$2(this);
    protected Access configManPersCarFuncAdapImpl;
    private Access confManPersCoding;
    public static boolean isCompass;
    public static boolean isNavi;
    private CarServiceOilServiceButtonAvailabilityCollector oilServiceButtonCollector = new CarServiceOilServiceButtonAvailabilityCollector();
    private final boolean[] espOptions = new boolean[5];
    private static final int ESP_OPTIONS_ACTIVE;
    private static final int ESP_OPTIONS_NO_ASR;
    private static final int ESP_OPTIONS_SPORT;
    private static final int ESP_OPTIONS_OFFROAD;
    private static final int ESP_OPTIONS_OFF;
    private final boolean[] manualUnlockMode = new boolean[3];
    private static final int MANUAL_UNLOCK_ALL;
    private static final int MANUAL_UNLOCK_DRIVER;
    private static final int MANUAL_UNLOCK_SINGLE;
    private final boolean[] colorSettings = new boolean[7];
    private static final int COLOR_SETTING_OFF;
    private static final int COLOR_SETTING_WARM_WHITE;
    private static final int COLOR_SETTING_COOL_WHITE;
    private static final int COLOR_SETTING_RED_WHITE;
    private static final int COLOR_SETTING_ORANGE;
    private static final int COLOR_SETTING_BLUE;
    private static final int COLOR_SETTING_CYAN;
    private final boolean[] accDrivingPrograms = new boolean[4];
    private static final int ACC_DRIVING_PROGRAMM_ECO;
    private static final int ACC_DRIVING_PROGRAMM_COMFORT;
    private static final int ACC_DRIVING_PROGRAMM_NORMAL;
    private static final int ACC_DRIVING_PROGRAMM_SPORT;
    private int rememberLastValueStandStill = -1;
    private final boolean FUNCTION_DOES_NOT_EXIST;
    private boolean isClamp15Active = false;
    private boolean isInitializing = false;
    IntArrayList notificationList = new IntArrayList();
    BCViewOptions myBcViewOptions = new BCViewOptions(new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new BCConfiguration(0, 0, new BCFISAdditionalConfiguration(), new BCTransmittableElements(), new BCFunctionSupport()));
    private BCmEViewOptions myBcMeViewOptions = new BCmEViewOptions(new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new BCmEConfiguration(), new CarViewOption(0, 0), new CarViewOption(0, 0));
    private TSDViewOptions myTdsViewOptions = new TSDViewOptions(new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new CarViewOption(0, 0), new TSDConfiguration());
    protected static final int LIGHT_AREA_AVAILABILITY_VISIBLE;
    protected static final int LIGHT_AREA_AVAILABILITY_INVISIBLE;
    public static boolean isPoloCoded;
    private static int AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP;
    private static int AMBIENCE_LIGHT_FEATURE_COCKPIT;
    protected static int AMBIENCE_LIGHT_FEATURE_DOORS;
    protected static int AMBIENCE_LIGHT_FEATURE_HANDLE;
    protected static int AMBIENCE_LIGHT_FEATURE_RECTANGLE;
    protected static int AMBIENCE_LIGHT_FEATURE_FOOTWELL;
    private static int AMBIENCE_LIGHT_FEATURE_ROOF;
    private static int AMBIENCE_LIGHT_FEATURE_FRONT_SLIDER;
    private static int AMBIENCE_LIGHT_FEATURE_FRONT_DOOR_POCKET;
    private static int AMBIENCE_LIGHT_FEATURE_FRONT_DOORS_ENTRANCE;
    private static int AMBIENCE_LIGHT_FEATURE_FRONT_CLIMATE_CONTROL_STRIP;
    private static int AMBIENCE_LIGHT_FEATURE_GEAR_SHIFT;
    private static int AMBIENCE_LIGHT_FEATURE_CENTER_CONTROL_LIGHTING_FRONT;
    private static int AMBIENCE_LIGHT_FEATURE_NAVI_DEVICE_STRIP;
    private static int AMBIENCE_LIGHT_FEATURE_PREMIUMSOUND;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_DOORS;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP;
    protected static int AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET;
    private static int AMBIENCE_LIGHT_FEATURE_REAR_ROOF;
    private static int AMBIENCE_LIGHT_FEATURE_SUNROOF_STRIP;
    static final int AMBIENCE_LIGHT_BUTTON_CENTER_CONSOLE;
    static final int AMBIENCE_LIGHT_BUTTON_COCKPIT;
    static final int AMBIENCE_LIGHT_BUTTON_DOORS_FRONT;
    static final int AMBIENCE_LIGHT_BUTTON_FOOTWELL_FRONT;
    static final int AMBIENCE_LIGHT_BUTTON_ROOF_FRONT;
    static final int AMBIENCE_LIGHT_BUTTON_FOOTWELL_FRONT_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_FOOTWELL_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_DOORS_FRONT_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_NOT_DOORS_FOOTWELL_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_ROOF_FRONT_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_ROOF_REAR;
    static final int AMBIENCE_LIGHT_BUTTON_FRONT;
    private int[] ambienceLightMapping = new int[23];
    private FactoryResetService resetService;
    private StateWork$ResetCARParticipant resetParticipant;
    private boolean resetIsDirty;
    private static DeviceManager dm;
    private boolean sportHMIStarted = false;

    public StateWork(HsmTargetCarViewOption hsmTargetCarViewOption, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.FUNCTION_DOES_NOT_EXIST = false;
        this.myTarget = hsmTargetCarViewOption;
    }

    private void requestFactoryReset() {
        if (this.resetService.getFactoryResetState() == 0) {
            this.resetService.reset(FactoryResetComponents.CAR, 0);
        } else {
            this.resetIsDirty = true;
        }
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.resetService = ASLSystemFactory.getSystemApi().getFactoryResetService();
                this.resetParticipant = new StateWork$ResetCARParticipant(this);
                this.resetService.addParticipant(this.resetParticipant, FactoryResetComponents.CAR);
                this.resetService.addListener(this);
                this.startDeviceManager();
                this.myTarget.initDsi();
                this.myTarget.registerOnModelEvents();
                this.myTarget.registerServices(new int[]{621486080, 604708864, 655040512, 688594944, 0x2B0B2000, 822812672, 638263296, 0x220B2000}, true);
                this.initClockTimeMasterViewOptions();
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(394)) {
                    EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
                    this.myTarget.triggerObserver(0x220B2000, eventGeneric2);
                }
                ServiceManager.adaptionApi.requestCarFuncAdap(this.funcAdapResponse);
                ServiceManager.adaptionApi.requestCoding(this.codingResponse);
                boolean bl = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData().getSportHMIEnabled();
                this.myTarget.info().append("Persisted SWaP - SportHmi: ").append(bl).log();
                ServiceManager.aslPropertyManager.valueChangedBoolean(10115, bl);
                ASLCarContainer.functionExistent[140] = bl;
                EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric3.setBoolean(0, bl);
                this.myTarget.triggerObserver(822812672, eventGeneric3);
                if (!bl) break;
                this.sportHMIStarted = true;
                break;
            }
            case 1200004: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("coding values has changed").log();
                }
                ServiceManager.adaptionApi.requestCarFuncAdap(this.funcAdapResponse);
                ServiceManager.adaptionApi.requestCoding(this.codingResponse);
                break;
            }
            case 4: {
                break;
            }
            case 1073744866: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("reset to factory settings").log();
                }
                this.resetToFactorySettings(eventGeneric);
                break;
            }
            case 4200002: {
                if (this.sportHMIStarted) break;
                boolean bl = eventGeneric.getBoolean(0);
                this.myTarget.info().append("SWaP - SportHmi: ").append(bl).log();
                ServiceManager.aslPropertyManager.valueChangedBoolean(10115, bl);
                ASLCarContainer.functionExistent[140] = bl;
                EventGeneric eventGeneric4 = ServiceManager.mGenericEventFactory.newEvent();
                eventGeneric4.setBoolean(0, bl);
                this.myTarget.triggerObserver(822812672, eventGeneric4);
                this.sportHMIStarted = true;
                break;
            }
            case 100004: {
                this.evaluateViewOptionsBcMe();
                break;
            }
            case 100005: {
                this.evaluateViewOptionsVehicleStatus();
                break;
            }
            case 2100014: {
                this.myTarget.info().append("internal event for battery control").log();
                this.evaluateBatteryControl((BatteryControlViewOptions)eventGeneric.getObject(0));
                break;
            }
            case 2100015: {
                this.evaluateHybrid((HybridViewOptions)eventGeneric.getObject(0));
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void startDeviceManager() {
        try {
            if (dm == null) {
                dm = new DeviceManager(ServiceManager.eventMain, "hsmtask");
                dm.requestMenuCoding();
            } else {
                dm.requestMenuCoding();
            }
        }
        catch (Exception exception) {
            this.myTarget.warn(exception.toString());
        }
        ModelDeviceStartupManager.start();
    }

    private void readDevicesConfig() {
        Car car = CarPersistenceServiceImpl.getInstance().loadCar();
        ServiceManager.aslPropertyManager.valueChangedBoolean(319, car.isFrontWindowHeater());
        ServiceManager.aslPropertyManager.valueChangedBoolean(318, car.isSteeringWheelheater());
        ASLCarContainer.functionExistent[153] = car.isPersonalization();
        ASLCarContainer.functionExistent[123] = car.isAmbientLight();
        ServiceManager.aslPropertyManager.valueChangedBoolean(10544, car.isHDC());
        ServiceManager.aslPropertyManager.valueChangedBoolean(321, car.isClimateSetupButton());
        ServiceManager.aslPropertyManager.valueChangedInteger(10900, car.getRDKSystem());
        ServiceManager.aslPropertyManager.valueChangedInteger(10487, car.getRDKLoadChange());
        ServiceManager.aslPropertyManager.valueChangedInteger(10553, car.getSportLeftTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10552, car.getSportMiddleTube());
        ServiceManager.aslPropertyManager.valueChangedInteger(10558, car.getSportRightTube());
        this.readCarOffroadPersistence();
    }

    private void readCarOffroadPersistence() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(360) && !ServiceManager.configManagerDiag.isFeatureFlagSet(441);
        CarOffroad carOffroad = CarPersistenceServiceImpl.getInstance().loadCar().getCarOffroad();
        ServiceManager.aslPropertyManager.valueChangedInteger(10555, bl ? carOffroad.getOffroadLeftTubeNonNav() : carOffroad.getOffroadLeftTubeNav());
        ServiceManager.aslPropertyManager.valueChangedInteger(10556, bl ? carOffroad.getOffroadMiddleTubeNonNav() : carOffroad.getOffroadMiddleTubeNav());
        ServiceManager.aslPropertyManager.valueChangedInteger(10557, bl ? carOffroad.getOffroadRightTubeNonNav() : carOffroad.getOffroadRightTubeNav());
    }

    private void resetOffroadHMI() {
        CarPersistenceServiceImpl.getInstance().loadCar().getCarOffroad().resetToDefaults();
        this.readCarOffroadPersistence();
    }

    private void evaluationCodingValues(int n, boolean bl, boolean bl2, boolean bl3, int[] nArray) {
        ASLCarContainer.getInstance().setMenuCoding(n, bl);
        if (!bl3 && bl2) {
            ASLCarContainer.getInstance().setMenuStandStill(n, bl2);
        } else if (!bl3) {
            ASLCarContainer.getInstance().setMenuSpeedThreshold(n, true);
        } else if (bl2) {
            ASLCarContainer.getInstance().setMenuStandStill(n, bl2);
        }
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            ASLCarContainer.functionExistent[nArray[i2]] = bl;
        }
    }

    protected void carMenuAvailability() {
        if (this.configManPersCarFuncAdapImpl.getBoolean(380)) {
            this.myTarget.dsiCarComfort.setNotification(45, (DSIListener)this.myTarget.dsiCarComfortListener);
        } else {
            this.myTarget.dsiCarComfort.clearNotification(45, (DSIListener)this.myTarget.dsiCarComfortListener);
        }
        isCompass = this.configManPersCarFuncAdapImpl.getBoolean(270);
        this.evaluatingOffroadHMI();
        this.evaluateEngine();
        ASLCarContainer.functionExistent[142] = this.configManPersCarFuncAdapImpl.getBoolean(395);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10112, this.configManPersCarFuncAdapImpl.getBoolean(395));
        ASLCarContainer.functionExistent[138] = this.configManPersCarFuncAdapImpl.getBoolean(395);
        ASLCarContainer.functionExistent[143] = this.configManPersCarFuncAdapImpl.getBoolean(375);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10113, this.configManPersCarFuncAdapImpl.getBoolean(375));
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, this.configManPersCarFuncAdapImpl.getBoolean(375));
        this.myTarget.triggerObserver(0x2B0B2000, eventGeneric);
        ASLCarContainer.functionExistent[124] = false;
        ASLCarContainer.collector[124] = new CarFunctionCollector(false, 0);
        ASLCarContainer.getInstance().setMenuCoding(33, this.configManPersCarFuncAdapImpl.getBoolean(275));
        this.evaluationCodingValues(4, this.configManPersCarFuncAdapImpl.getBoolean(380), this.configManPersCarFuncAdapImpl.getBoolean(383), this.configManPersCarFuncAdapImpl.getBoolean(382), FunctionIds.EXISTENT_BRAKE);
        this.existentState(32, FunctionIds.EXISTENT_BATTERY, this.configManPersCarFuncAdapImpl.getBoolean(395), this.configManPersCarFuncAdapImpl.getBoolean(397), this.configManPersCarFuncAdapImpl.getBoolean(398), 187, FunctionIds.CHILD_CAR_BATTERY_MANAGEMENT);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10353, this.configManPersCarFuncAdapImpl.getBoolean(395));
        if (this.configManPersCarFuncAdapImpl.getBoolean(395)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10481, true);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10112, this.configManPersCarFuncAdapImpl.getBoolean(395));
        ServiceManager.aslPropertyManager.valueChangedBoolean(3675, this.configManPersCarFuncAdapImpl.getBoolean(395));
        ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isECar", this.configManPersCarFuncAdapImpl.getBoolean(395));
        this.existentState(20, FunctionIds.EXISTENT_DRIVINGSCHOOL, this.configManPersCarFuncAdapImpl.getBoolean(360), this.configManPersCarFuncAdapImpl.getBoolean(362), this.configManPersCarFuncAdapImpl.getBoolean(363), 0, FunctionIds.CHILD_CAR_DRIVING_SCHOOL);
        this.existentState(14, FunctionIds.EXISTENT_TIRES, this.configManPersCarFuncAdapImpl.getBoolean(245), this.configManPersCarFuncAdapImpl.getBoolean(247), this.configManPersCarFuncAdapImpl.getBoolean(248), 8, FunctionIds.CHILD_TIRES);
        ASLCarContainer.functionExistent[110] = this.configManPersCarFuncAdapImpl.getBoolean(245);
        ASLCarContainer.functionExistent[84] = this.configManPersCarFuncAdapImpl.getBoolean(245);
        this.existentState(14, FunctionIds.EXISTENT_RDK_VEHICLESTATUS, this.configManPersCarFuncAdapImpl.getBoolean(245), this.configManPersCarFuncAdapImpl.getBoolean(247), this.configManPersCarFuncAdapImpl.getBoolean(248), 107, FunctionIds.PARENT_VEHICLE_STATUS_RDK_SYSTEM);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10124, this.configManPersCarFuncAdapImpl.getBoolean(245));
        this.myTarget.existentParentChild(107, FunctionIds.PARENT_VEHICLE_STATUS_RDK_SYSTEM);
        this.myTarget.existentParentChild(3, FunctionIds.CHILD_VEHICLESTATUS);
        this.existentState(12, FunctionIds.EXISTENT_WIPER, this.configManPersCarFuncAdapImpl.getBoolean(250), this.configManPersCarFuncAdapImpl.getBoolean(252), this.configManPersCarFuncAdapImpl.getBoolean(253), 12, FunctionIds.CHILD_MIRRORWIPER);
        this.existentState(15, FunctionIds.EXISTENT_BC_MFA, this.configManPersCarFuncAdapImpl.getBoolean(240), this.configManPersCarFuncAdapImpl.getBoolean(242), this.configManPersCarFuncAdapImpl.getBoolean(243), 15, FunctionIds.CHILD_MFASETUP);
        this.existentState(24, FunctionIds.EXISTENT_HUD, this.configManPersCarFuncAdapImpl.getBoolean(300), this.configManPersCarFuncAdapImpl.getBoolean(302), this.configManPersCarFuncAdapImpl.getBoolean(303), 188, FunctionIds.CHILD_HUD);
        this.existentState(15, FunctionIds.EXISTENT_BC_MFA_BORDCOMUPTER, this.configManPersCarFuncAdapImpl.getBoolean(240), this.configManPersCarFuncAdapImpl.getBoolean(242), this.configManPersCarFuncAdapImpl.getBoolean(243), 1, FunctionIds.CHILD_CAR_COMPUTER);
        ASLCarContainer.functionExistent[8] = this.configManPersCarFuncAdapImpl.getBoolean(245) || this.configManPersCarFuncAdapImpl.getBoolean(240);
        ASLCarContainer.functionExistent[120] = this.configManPersCarFuncAdapImpl.getBoolean(240);
        this.existentState(21, FunctionIds.EXISTENT_STARTSTOP, this.configManPersCarFuncAdapImpl.getBoolean(385), this.configManPersCarFuncAdapImpl.getBoolean(387), this.configManPersCarFuncAdapImpl.getBoolean(388), 108, FunctionIds.CHILD_CAR_VEHICLE_STATUS);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10123, this.configManPersCarFuncAdapImpl.getBoolean(385) || this.configManPersCarFuncAdapImpl.getBoolean(240));
        this.myTarget.existentParentChild(3, FunctionIds.CHILD_VEHICLESTATUS);
        this.existentState(19, FunctionIds.EXISTENT_ECO, this.configManPersCarFuncAdapImpl.getBoolean(370), this.configManPersCarFuncAdapImpl.getBoolean(372), this.configManPersCarFuncAdapImpl.getBoolean(373), 2, FunctionIds.CHILD_CAR_ECO_ASSIST);
        if (this.configManPersCarFuncAdapImpl.getBoolean(395)) {
            ASLCarContainer.functionExistent[2] = false;
            ServiceManager.aslPropertyManager.valueChangedBoolean(10121, false);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10121, this.configManPersCarFuncAdapImpl.getBoolean(370));
        }
        eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, ASLCarContainer.functionExistent[2]);
        this.myTarget.triggerObserver(755703808, eventGeneric);
        this.existentState(0, FunctionIds.EXISTENT_ACC, this.configManPersCarFuncAdapImpl.getBoolean(190), this.configManPersCarFuncAdapImpl.getBoolean(192), this.configManPersCarFuncAdapImpl.getBoolean(193), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(1, FunctionIds.EXISTENT_AWV, this.configManPersCarFuncAdapImpl.getBoolean(205), this.configManPersCarFuncAdapImpl.getBoolean(207), this.configManPersCarFuncAdapImpl.getBoolean(208), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.myTarget.isCentralLocking = this.configManPersCarFuncAdapImpl.getBoolean(265);
        this.existentState(26, FunctionIds.EXISTENT_DOORLOCKING, this.configManPersCarFuncAdapImpl.getBoolean(265), this.configManPersCarFuncAdapImpl.getBoolean(267), this.configManPersCarFuncAdapImpl.getBoolean(268), 13, FunctionIds.CHILD_OPENCLOSE);
        this.myTarget.isWindow = this.configManPersCarFuncAdapImpl.getBoolean(225);
        this.existentState(16, FunctionIds.EXISTENT_WINDOW, this.configManPersCarFuncAdapImpl.getBoolean(225), this.configManPersCarFuncAdapImpl.getBoolean(227), this.configManPersCarFuncAdapImpl.getBoolean(228), 13, FunctionIds.CHILD_OPENCLOSE);
        this.existentState(10, FunctionIds.EXISTENT_EXTERIEUR_LIGHT, this.configManPersCarFuncAdapImpl.getBoolean(220), this.configManPersCarFuncAdapImpl.getBoolean(222), this.configManPersCarFuncAdapImpl.getBoolean(223), 11, FunctionIds.CHILD_LIGHT);
        this.existentState(9, FunctionIds.EXISTENT_INTERIEUR_LIGHT, this.configManPersCarFuncAdapImpl.getBoolean(195), this.configManPersCarFuncAdapImpl.getBoolean(197), this.configManPersCarFuncAdapImpl.getBoolean(198), 11, FunctionIds.CHILD_LIGHT);
        this.existentState(3, FunctionIds.EXISTENT_HCA, this.configManPersCarFuncAdapImpl.getBoolean(210), this.configManPersCarFuncAdapImpl.getBoolean(212), this.configManPersCarFuncAdapImpl.getBoolean(213), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(11, FunctionIds.EXISTENT_MIRROR, this.configManPersCarFuncAdapImpl.getBoolean(355), this.configManPersCarFuncAdapImpl.getBoolean(357), this.configManPersCarFuncAdapImpl.getBoolean(358), 12, FunctionIds.CHILD_MIRRORWIPER);
        this.existentState(8, FunctionIds.EXISTENT_PARKING_ASSISTANTS, this.configManPersCarFuncAdapImpl.getBoolean(200), this.configManPersCarFuncAdapImpl.getBoolean(202), this.configManPersCarFuncAdapImpl.getBoolean(203), 10, FunctionIds.CHILD_PARKING);
        this.existentState(13, FunctionIds.EXISTENT_SEAT_MEMORY, this.configManPersCarFuncAdapImpl.getBoolean(260), this.configManPersCarFuncAdapImpl.getBoolean(262), this.configManPersCarFuncAdapImpl.getBoolean(263), 14, FunctionIds.CHILD_SEATS);
        this.existentState(5, FunctionIds.EXISTENT_REVERSIBLE_BELT_PRE_LOAD, this.configManPersCarFuncAdapImpl.getBoolean(330), this.configManPersCarFuncAdapImpl.getBoolean(332), this.configManPersCarFuncAdapImpl.getBoolean(333), 14, FunctionIds.CHILD_SEATS);
        this.existentState(29, FunctionIds.EXISTENT_PRE_CRASH, this.configManPersCarFuncAdapImpl.getBoolean(330), this.configManPersCarFuncAdapImpl.getBoolean(332), this.configManPersCarFuncAdapImpl.getBoolean(333), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(17, FunctionIds.EXISTENT_VIN, this.configManPersCarFuncAdapImpl.getBoolean(285), this.configManPersCarFuncAdapImpl.getBoolean(287), this.configManPersCarFuncAdapImpl.getBoolean(288), 18, FunctionIds.CHILD_SERVICE);
        this.existentState(27, FunctionIds.EXISTENT_PEDESTRIAN_PROTECTION, this.configManPersCarFuncAdapImpl.getBoolean(425), this.configManPersCarFuncAdapImpl.getBoolean(427), this.configManPersCarFuncAdapImpl.getBoolean(428), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(34, FunctionIds.EXISTENT_PEA, this.configManPersCarFuncAdapImpl.getBoolean(465), this.configManPersCarFuncAdapImpl.getBoolean(467), this.configManPersCarFuncAdapImpl.getBoolean(468), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(18, FunctionIds.EXISTENT_SIA, this.configManPersCarFuncAdapImpl.getBoolean(255), this.configManPersCarFuncAdapImpl.getBoolean(257), this.configManPersCarFuncAdapImpl.getBoolean(258), 18, FunctionIds.CHILD_SERVICE);
        this.existentState(2, FunctionIds.EXISTENT_SWA, this.configManPersCarFuncAdapImpl.getBoolean(215), this.configManPersCarFuncAdapImpl.getBoolean(217), this.configManPersCarFuncAdapImpl.getBoolean(218), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        ServiceManager.aslPropertyManager.valueChangedBoolean(320, this.configManPersCarFuncAdapImpl.getBoolean(235));
        ASLCarContainer.functionExistent[20] = this.configManPersCarFuncAdapImpl.getBoolean(235);
        ASLCarContainer.getInstance().setMenuCoding(25, this.configManPersCarFuncAdapImpl.getBoolean(235));
        this.existentState(31, FunctionIds.EXISTENT_CLIMATE, this.configManPersCarFuncAdapImpl.getBoolean(230), this.configManPersCarFuncAdapImpl.getBoolean(232), this.configManPersCarFuncAdapImpl.getBoolean(233), 152, FunctionIds.CHILD_CLIMATE);
        ServiceManager.aslPropertyManager.valueChangedBoolean(308, this.configManPersCarFuncAdapImpl.getBoolean(230));
        this.existentState(23, FunctionIds.EXISTENT_UNITMASTER, this.configManPersCarFuncAdapImpl.getBoolean(305), this.configManPersCarFuncAdapImpl.getBoolean(307), this.configManPersCarFuncAdapImpl.getBoolean(308), 17, FunctionIds.CHILD_UNITMASTER);
        this.existentState(22, FunctionIds.EXISTENT_CLOCK, this.configManPersCarFuncAdapImpl.getBoolean(290), this.configManPersCarFuncAdapImpl.getBoolean(292), this.configManPersCarFuncAdapImpl.getBoolean(293), 16, FunctionIds.CHILD_CLOCK);
        ASLCarContainer.functionExistent[108] = ASLCarContainer.functionExistent[7] || ASLCarContainer.functionExistent[120];
        ServiceManager.aslPropertyManager.valueChangedBoolean(10122, this.configManPersCarFuncAdapImpl.getBoolean(385) || this.configManPersCarFuncAdapImpl.getBoolean(240) || this.configManPersCarFuncAdapImpl.getBoolean(245));
        this.myTarget.existentParentChild(18, FunctionIds.CHILD_SERVICE);
        this.existentState(7, FunctionIds.EXISTENT_MKE, this.configManPersCarFuncAdapImpl.getBoolean(365), this.configManPersCarFuncAdapImpl.getBoolean(367), this.configManPersCarFuncAdapImpl.getBoolean(368), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
        this.existentState(35, FunctionIds.EXISTENT_UGDO, this.configManPersCarFuncAdapImpl.getBoolean(315), this.configManPersCarFuncAdapImpl.getBoolean(377), this.configManPersCarFuncAdapImpl.getBoolean(318), 13, FunctionIds.CHILD_OPENCLOSE);
        this.evaluateHeadingMirrorWiper(this.configManPersCarFuncAdapImpl.getBoolean(250), this.configManPersCarFuncAdapImpl.getBoolean(355));
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: notificationList len: ").append(this.notificationList.size()).log();
        }
    }

    private void evaluatingOffroadHMI() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(60);
        boolean bl2 = isNavi || bl;
        ASLCarContainer.functionExistent[141] = isCompass && bl2;
        ServiceManager.aslPropertyManager.valueChangedBoolean(10114, isCompass && bl2);
    }

    private void evaluateHeadingMirrorWiper(boolean bl, boolean bl2) {
        if (bl && bl2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10590, 0);
        } else if (bl) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10590, 2);
        } else if (bl2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(10590, 1);
        }
    }

    private void codingAll() {
        isNavi = this.confManPersCoding.getBoolean(105);
        isPoloCoded = this.confManPersCoding.getValue(1) == 2;
        this.evaluatingOffroadHMI();
    }

    private void evaluateVzeVza() {
        if (this.configManPersCarFuncAdapImpl.getBoolean(340)) {
            this.existentState(28, FunctionIds.EXISTENT_VZE, this.configManPersCarFuncAdapImpl.getBoolean(340), this.configManPersCarFuncAdapImpl.getBoolean(342), this.configManPersCarFuncAdapImpl.getBoolean(343), 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, 2);
            this.myTarget.triggerObserver(638263296, eventGeneric);
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric2.setInt(0, 2);
            this.myTarget.triggerObserver(688594944, eventGeneric2);
            ASLCarContainer.getInstance().setMenuCoding(6, this.configManPersCarFuncAdapImpl.getBoolean(340));
        } else if (this.confManPersCoding.getBoolean(109)) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, 1);
            this.myTarget.triggerObserver(638263296, eventGeneric);
            EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric3.setInt(0, 1);
            this.myTarget.triggerObserver(688594944, eventGeneric3);
        } else {
            this.existentState(6, FunctionIds.EXISTENT_VZA, false, false, false, 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
            this.existentState(28, FunctionIds.EXISTENT_VZE, false, false, false, 9, FunctionIds.CHILD_ASSISTANTS_DRIVING);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setInt(0, 0);
            this.myTarget.triggerObserver(638263296, eventGeneric);
        }
    }

    protected void existentState(int n, int[] nArray, boolean bl, boolean bl2, boolean bl3, int n2, int[] nArray2) {
        this.myTarget.registerFunction(n, bl);
        if (bl && n != 32 && !this.notificationList.contains(n)) {
            this.notificationList.add(n);
        }
        ASLCarContainer.getInstance().setMenuCoding(n, bl);
        if (!bl2 && bl3) {
            ASLCarContainer.getInstance().setMenuStandStill(n, bl3);
        } else if (!bl2) {
            ASLCarContainer.getInstance().setMenuSpeedThreshold(n, true);
        } else if (bl3) {
            ASLCarContainer.getInstance().setMenuStandStill(n, bl3);
        }
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            ASLCarContainer.functionExistent[nArray[i2]] = bl;
        }
        this.myTarget.existentParentChild(n2, nArray2);
    }

    private void resetToFactorySettings(EventGeneric eventGeneric) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("resetting: ").append(eventGeneric.getReceiverEventId()).append(" Param: ").append(eventGeneric.getParamString()).log();
        }
        switch (eventGeneric.getInt(0)) {
            case 0: {
                this.requestFactoryReset();
                break;
            }
            case 1: {
                this.myTarget.dsiCarDriverAssistance.setLdwhcaSetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setTsdSetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setMKESetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setPASetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setACCSetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setCurveAssistSetFactoryDefault();
                this.myTarget.dsiCarComfort.setRgsSetFactoryDefault();
                this.myTarget.dsiCarDriverAssistance.setAWVSetFactoryDefault();
                this.myTarget.dsiCarEco.setEASetFactoryDefault();
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                if (!this.myTarget.isAmbienceLight) {
                    this.myTarget.dsiCarLight.setIntLightSetFactoryDefault();
                }
                this.myTarget.dsiCarLight.setExtLightSetFactoryDefault();
                break;
            }
            case 4: {
                this.myTarget.dsiCarComfort.setMirrorSetFactoryDefault();
                this.myTarget.dsiCarComfort.setWiperSetFactoryDefault();
                break;
            }
            case 5: {
                this.myTarget.dsiCarComfort.setDoorLockingSetFactoryDefault();
                break;
            }
            case 6: {
                this.myTarget.dsiCarComfort.setRgsSetFactoryDefault();
                this.myTarget.dsiCarSeat.setSeatSetFactoryDefault();
                break;
            }
            case 7: {
                this.myTarget.dsiCarKombi.setBcSetFactoryDefault();
                break;
            }
            case 9: {
                this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultMaster();
                this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultRow(1);
                this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultRow(2);
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                this.myTarget.dsiCarLight.setIntLightSetFactoryDefault();
                break;
            }
            case 13: {
                this.myTarget.dsiCarKombi.setHUDSetFactoryDefault();
                break;
            }
            default: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("[INFO] This function does not exists in \" reset to factory\"").log();
            }
        }
    }

    protected void resettingAllSettings() {
        this.myTarget.dsiCarDriverAssistance.setLdwhcaSetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setTsdSetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setPASetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setACCSetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setCurveAssistSetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setMKESetFactoryDefault();
        this.myTarget.dsiCarDriverAssistance.setAWVSetFactoryDefault();
        this.myTarget.dsiCarParkingSystem.setPdcSetFactoryDefault();
        this.myTarget.dsiCarLight.setIntLightSetFactoryDefault();
        this.myTarget.dsiCarLight.setExtLightSetFactoryDefault();
        this.myTarget.dsiCarComfort.setMirrorSetFactoryDefault();
        this.myTarget.dsiCarComfort.setWiperSetFactoryDefault();
        this.myTarget.dsiCarComfort.setDoorLockingSetFactoryDefault();
        this.myTarget.dsiCarComfort.setRgsSetFactoryDefault();
        this.myTarget.dsiCarSeat.setSeatSetFactoryDefault();
        this.myTarget.dsiCarKombi.setBcSetFactoryDefault();
        this.myTarget.dsiCarAuxHeaterCooler.setAuxHeaterSetFactoryDefault();
        this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultMaster();
        this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultRow(1);
        this.myTarget.dsiCarAirCondition.setAirconSetFactoryDefaultRow(2);
        this.myTarget.dsiCarEco.setEASetFactoryDefault();
        this.myTarget.dsiCarKombi.setHUDSetFactoryDefault();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(360)) {
            this.resetOffroadHMI();
        }
        this.resetParticipant.resetDone();
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("TARGET VIEWOPTIONS: signal: ").append(clampSignal.toString()).log();
        }
        if (this.isClamp15Active != clampSignal.isClamp15()) {
            this.isClamp15Active = clampSignal.isClamp15();
            if (!clampSignal.isClamp15()) {
                this.myTarget.sendHMIEvent(10007);
                ASLCarContainer.collector[121] = new CarFunctionCollector(false, 0);
                this.myTarget.rememberOldSettingsSetupMain();
                if (this.myTarget.getTimerServer().isTimerActive(this.myTarget.getTargetId(), -1534721792)) {
                    this.myTarget.stopTimer(-1534721792);
                }
                if (this.myTarget.getTimerServer().isTimerActive(this.myTarget.getTargetId(), -1517944576)) {
                    this.myTarget.stopTimer(-1517944576);
                }
            } else {
                if (!ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV() && !ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
                    this.startingEcoConsumers();
                }
                this.startingVehicleStatus();
            }
        }
        this.myTarget.informClamp15(clampSignal.isClampS() && clampSignal.isClamp15());
    }

    private void initClockTimeMasterViewOptions() {
        this.myClockViewOptions.time = new CarViewOption(0, 1);
        this.myClockViewOptions.date = new CarViewOption(0, 1);
        this.myClockViewOptions.timeZone = new CarViewOption(0, 1);
        this.myClockViewOptions.dayLightSaving = new CarViewOption(0, 1);
        this.myClockViewOptions.dayLightSavingData = new CarViewOption(0, 1);
        this.myClockViewOptions.clockSource = new CarViewOption(0, 1);
        this.myClockViewOptions.gpsSyncData = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.clockFormat = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.dateFormat = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.distanceUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.pressureUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.speedUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.temperatureUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.volumeUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.consumptionGasUnit = new CarViewOption(0, 1);
        this.myUnitMasterViewOptions.consumptionPetrolUnit = new CarViewOption(0, 1);
    }

    public void dsiCarParkingSystemUpdateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: Parkingsystem: ").append(parkingSystemViewOptions.toString()).log();
        }
        if (this.notificationList.contains(8)) {
            this.notificationList.removeValue(8);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcAutoActivation().getState(), 39, parkingSystemViewOptions.getPdcAutoActivation().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcVolumeFront().getState(), 40, parkingSystemViewOptions.getPdcVolumeFront().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcVolumeRear().getState(), 42, parkingSystemViewOptions.getPdcVolumeRear().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcVolumeRear().getState(), 44, parkingSystemViewOptions.getPdcVolumeRear().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcFrequencyFront().getState(), 41, parkingSystemViewOptions.getPdcFrequencyFront().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcFrequencyRear().getState(), 43, parkingSystemViewOptions.getPdcFrequencyRear().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcSystemOnOff().getState(), 144, parkingSystemViewOptions.getPdcSystemOnOff().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getVpsExtCamConfig().getState(), 155, parkingSystemViewOptions.getVpsExtCamConfig().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcParkboxVisualisation().getState(), 154, parkingSystemViewOptions.getPdcParkboxVisualisation().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcManeuverAssistConfig().getState(), 194, parkingSystemViewOptions.getPdcManeuverAssistConfig().getReason());
        this.evaluateViewOptions(parkingSystemViewOptions.getPdcManeuverAssist().getState(), 196, parkingSystemViewOptions.getPdcManeuverAssist().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_PARKING, 10, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        CarPersistenceServiceImpl.getInstance().loadCar().setFifthCamera(parkingSystemViewOptions.getVpsExtCamConfig().getState() != 0);
    }

    public void dsiCarLightUpdateIntLightViewOptions(IntLightViewOptions intLightViewOptions, int n) {
        boolean bl;
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: intLight: ").append(intLightViewOptions.toString()).log();
        }
        if (this.notificationList.contains(9)) {
            this.notificationList.removeValue(9);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        IntLightConfig intLightConfig = intLightViewOptions.getIntLightConfig();
        this.deactivateSlider();
        ASLCarContainer.LIGHT_AREAR_COLLECTOR = new AmbienceLightAreaCollector[]{new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector(), new AmbienceLightAreaCollector()};
        ServiceManager.aslPropertyManager.valueChangedBoolean(10159, false);
        this.myTarget.isAmbienceLight = false;
        this.evaluateAmbienceLightSettings(intLightConfig);
        this.ambienceLightMapping = new int[23];
        for (bl = false; bl < this.ambienceLightMapping.length; bl += 1) {
            this.ambienceLightMapping[bl] = -1;
        }
        if (intLightConfig.getSetupIlluminationSet1() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet1(), intLightViewOptions.getIntLightIlluminationSet1(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_1, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet1(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet2() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet2(), intLightViewOptions.getIntLightIlluminationSet2(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_2, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet2(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet3() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet3(), intLightViewOptions.getIntLightIlluminationSet3(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_3, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet3(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet4() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet4(), intLightViewOptions.getIntLightIlluminationSet4(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_4, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet4(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet5() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet5(), intLightViewOptions.getIntLightIlluminationSet5(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_5, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet5(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet6() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet6(), intLightViewOptions.getIntLightIlluminationSet6(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_6, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet6(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet7() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet7(), intLightViewOptions.getIntLightIlluminationSet7(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_7, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet7(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        if (intLightConfig.getSetupIlluminationSet8() != 255) {
            this.illuminationSet(intLightConfig.getSetupIlluminationSet8(), intLightViewOptions.getIntLightIlluminationSet8(), ASLCarContainer.DP_ILLUMINATION_INT_SETTINGS_8, intLightViewOptions.getIntLightConfig().getMembersIlluminationSet8(), intLightViewOptions.getIntLightConfig().getMembersMultiColor());
        }
        ServiceManager.aslPropertyManager.valueChangedIntegerArray(10489, this.ambienceLightMapping);
        bl = intLightViewOptions.getIntLightRGBColorList().getState() == 0 && intLightViewOptions.getIntLightAmbientLightColor().getState() == 0;
        ListManager.getGenericASLList(10599).updateList(CarLightAmbienceColorAreaSettings_1CollectorFactory.createCarLightAmbienceColorAreaSettings_1Collector(ASLCarContainer.LIGHT_AREAR_COLLECTOR, 0, bl));
        if (this.myTarget.isAmbienceLight) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10159, true);
            ASLCarContainer.functionExistent[123] = true;
            this.colorSettings[0] = intLightViewOptions.getIntLightState().getState() == 2;
            this.colorSettings[5] = intLightViewOptions.getIntLightConfig().getSetupColors().isBlue();
            this.colorSettings[2] = intLightViewOptions.getIntLightConfig().getSetupColors().isColdWhite();
            this.colorSettings[6] = intLightViewOptions.getIntLightConfig().getSetupColors().isCyan();
            this.colorSettings[4] = intLightViewOptions.getIntLightConfig().getSetupColors().isOrange();
            this.colorSettings[3] = intLightViewOptions.getIntLightConfig().getSetupColors().isRedWhite();
            this.colorSettings[1] = intLightViewOptions.getIntLightConfig().getSetupColors().isWarmWhite();
            int n2 = 0;
            for (int i2 = 0; i2 < this.colorSettings.length; ++i2) {
                if (!this.colorSettings[i2]) continue;
                ++n2;
            }
            if (n2 >= 3) {
                this.evaluateViewOptions(intLightViewOptions.getIntLightColour().getState(), 177, intLightViewOptions.getIntLightColour().getReason());
                ServiceManager.aslPropertyManager.valueChangedFlagVector(10463, this.colorSettings);
            } else {
                this.evaluateViewOptions(0, 177, 0);
                ServiceManager.aslPropertyManager.valueChangedFlagVector(10463, this.colorSettings);
            }
            this.evaluateViewOptionsRGBColorList(intLightViewOptions);
            this.myTarget.parentChildRelation(FunctionIds.CHILD_AMBIENCELIGHT, 123, ASLCarContainer.collector, ASLCarContainer.functionExistent);
            this.myTarget.parentChildRelation(FunctionIds.CHILD_LIGHT_WHEN_AMBIENCELIGHT_AVAILABLE, 11, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        } else {
            CarPersistenceServiceImpl.getInstance().loadCar().setAmbientLight(false);
            ServiceManager.aslPropertyManager.valueChangedBoolean(10159, false);
            ASLCarContainer.functionExistent[123] = false;
            ASLCarContainer.collector[123] = new CarFunctionCollector(false, 0);
            this.myTarget.parentChildRelation(FunctionIds.CHILD_LIGHT, 11, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        }
        this.evaluateViewOptions(intLightViewOptions.getIntLightBrightness().getState(), 57, intLightViewOptions.getIntLightBrightness().getReason());
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, intLightViewOptions.getIntLightIlluminationSet1().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet2().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet3().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet4().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet5().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet6().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet7().getState() != 2 && intLightViewOptions.getIntLightIlluminationSet8().getState() != 2);
        eventGeneric.setBoolean(1, this.myTarget.isAmbienceLight);
        this.myTarget.triggerObserver(655040512, eventGeneric);
        AbstractASLTarget.writeBooleanToDatapool(10800, intLightViewOptions.intLightAmbientLightColor.getState() != 2);
    }

    private void deactivateSlider() {
        this.evaluateViewOptions(0, 58, 1);
        this.evaluateViewOptions(0, 59, 1);
        this.evaluateViewOptions(0, 106, 1);
        this.evaluateViewOptions(0, 175, 1);
        this.evaluateViewOptions(0, 176, 1);
        this.evaluateViewOptions(0, 177, 1);
        this.evaluateViewOptions(0, 198, 1);
        this.evaluateViewOptions(0, 199, 1);
        this.evaluateViewOptions(0, 200, 1);
        this.evaluateViewOptions(0, 201, 1);
        this.evaluateViewOptions(0, 202, 1);
        this.evaluateViewOptions(0, 203, 1);
        this.evaluateViewOptions(0, 204, 1);
        this.evaluateViewOptions(0, 218, 1);
    }

    void illuminationSet(int n, CarViewOption carViewOption, int n2, IntLightMembersIlluminationSet intLightMembersIlluminationSet, IntLightMembersMultiColor intLightMembersMultiColor) {
        switch (n) {
            case 14: {
                ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 202, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_ROOF, intLightMembersIlluminationSet.isFrontRoofLighting() ? 1 : 0, intLightMembersMultiColor.isFrontRoofLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_ROOF, intLightMembersIlluminationSet.isRearRoofLighting() ? 1 : 0, intLightMembersMultiColor.isRearRoofLighting(), n2);
                this.featureMapping(9, intLightMembersIlluminationSet);
                break;
            }
            case 1: {
                ASLCarContainer.DP_ILLUMINATION_ROOF_FRONT = n2;
                this.evaluateViewOptions(carViewOption.getState(), 175, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_ROOF, intLightMembersIlluminationSet.isFrontRoofLighting() ? 1 : 0, intLightMembersMultiColor.isFrontRoofLighting(), n2);
                this.featureMapping(4, intLightMembersIlluminationSet);
                break;
            }
            case 2: {
                ASLCarContainer.DP_ILLUMINATION_ROOF_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 203, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_ROOF, intLightMembersIlluminationSet.isRearRoofLighting() ? 1 : 0, intLightMembersMultiColor.isRearRoofLighting(), n2);
                this.featureMapping(10, intLightMembersIlluminationSet);
                break;
            }
            case 3: {
                ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT = n2;
                this.evaluateViewOptions(carViewOption.getState(), 59, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_FOOTWELL, intLightMembersIlluminationSet.isFrontFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isFrontFootwellLighting(), n2);
                this.featureMapping(3, intLightMembersIlluminationSet);
                break;
            }
            case 4: {
                ASLCarContainer.DP_ILLUMINATION_FOOTWELL_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 199, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL, intLightMembersIlluminationSet.isRearFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isRearFootwellLighting(), n2);
                this.featureMapping(6, intLightMembersIlluminationSet);
                break;
            }
            case 5: {
                ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 198, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_FOOTWELL, intLightMembersIlluminationSet.isFrontFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isFrontFootwellLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL, intLightMembersIlluminationSet.isRearFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isRearFootwellLighting(), n2);
                this.featureMapping(5, intLightMembersIlluminationSet);
                break;
            }
            case 6: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("DSICarLight.SETUPILLUMINATIONSET_COCKPIT has IlluminationSet= ").append(n2).append(" members.isCockpitStripLighting = ").append(intLightMembersIlluminationSet.isCockpitStripLighting()).append(" color.isCockpitStripLighting() = ").append(intLightMembersMultiColor.isCockpitStripLighting()).log();
                }
                ASLCarContainer.DP_ILLUMINATION_COCKPIT = n2;
                this.evaluateViewOptions(carViewOption.getState(), 106, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_COCKPIT, intLightMembersIlluminationSet.isCockpitStripLighting() ? 1 : 0, intLightMembersMultiColor.isCockpitStripLighting(), n2);
                this.featureMapping(1, intLightMembersIlluminationSet);
                break;
            }
            case 7: {
                ASLCarContainer.DP_ILLUMINATION_DOORS_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 200, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_DOORS, intLightMembersIlluminationSet.isFrontDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_HANDLE, intLightMembersIlluminationSet.isFrontDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_RECTANGLE, intLightMembersIlluminationSet.isFrontDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsWarningLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP, intLightMembersIlluminationSet.isRearDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS, intLightMembersIlluminationSet.isRearDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING, intLightMembersIlluminationSet.isRearDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsWarningLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET, intLightMembersIlluminationSet.isRearDoorPocketLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorPocketLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE, intLightMembersIlluminationSet.isRearDoorsEntranceLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsEntranceLighting(), n2);
                this.featureMapping(7, intLightMembersIlluminationSet);
                break;
            }
            case 8: {
                ASLCarContainer.DP_ILLUMINATION_DOORS_FRONTWELL_FRONT = n2;
                this.evaluateViewOptions(carViewOption.getState(), 58, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_DOORS, intLightMembersIlluminationSet.isFrontDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_HANDLE, intLightMembersIlluminationSet.isFrontDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_RECTANGLE, intLightMembersIlluminationSet.isFrontDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isFrontDoorsWarningLighting(), n2);
                this.featureMapping(2, intLightMembersIlluminationSet);
                break;
            }
            case 9: {
                ASLCarContainer.NOT_DOORS_FOOTWELLREAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 201, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP, intLightMembersIlluminationSet.isRearDoorsStripLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsStripLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS, intLightMembersIlluminationSet.isRearDoorsLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING, intLightMembersIlluminationSet.isRearDoorsWarningLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsWarningLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET, intLightMembersIlluminationSet.isRearDoorPocketLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorPocketLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE, intLightMembersIlluminationSet.isRearDoorsEntranceLighting() ? 1 : 0, intLightMembersMultiColor.isRearDoorsEntranceLighting(), n2);
                this.featureMapping(8, intLightMembersIlluminationSet);
                break;
            }
            case 10: {
                if (this.myTarget.isTraceEnabled()) {
                    this.myTarget.trace().append("DSICarLight.SETUPILLUMINATIONSET_ALLSETSSYNC has IlluminationSet = ").append(n2).log();
                }
                this.evaluateViewOptions(carViewOption.getState(), 176, carViewOption.getReason());
                ASLCarContainer.DP_ILLUMINATION_ALL_SYNC = n2;
                break;
            }
            case 11: {
                ASLCarContainer.DP_ILLUMINATION_FOOTWELL_FRONT_REAR = n2;
                this.evaluateViewOptions(carViewOption.getState(), 198, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_FOOTWELL, intLightMembersIlluminationSet.isFrontFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isFrontFootwellLighting(), n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL, intLightMembersIlluminationSet.isRearFootwellLighting() ? 1 : 0, intLightMembersMultiColor.isRearFootwellLighting(), n2);
                this.featureMapping(5, intLightMembersIlluminationSet);
                break;
            }
            case 12: {
                ASLCarContainer.DP_ILLUMINATION_FRONT = n2;
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.featureMapping(11, intLightMembersIlluminationSet);
                break;
            }
            case 255: {
                if (!this.myTarget.isTraceEnabled()) break;
                this.myTarget.trace().append("DSICarLight.SETUPILLUMINATIONSET_NOT_EXISTING! IlluminationSet = ").append(n2).log();
                break;
            }
            case 15: {
                ASLCarContainer.DP_ILLUMINATION_CENTER_CONSOLE = n2;
                this.evaluateViewOptions(carViewOption.getState(), 174, carViewOption.getReason());
                this.evaluateButtonToLightAreas(intLightMembersIlluminationSet, intLightMembersMultiColor, n2);
                this.fillingGetterAmbienceLight(AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP, intLightMembersIlluminationSet.isCupholderStripLighting() ? 1 : 0, intLightMembersMultiColor.isCupholderStripLighting(), n2);
                this.featureMapping(0, intLightMembersIlluminationSet);
                break;
            }
        }
    }

    void featureMapping(int n, IntLightMembersIlluminationSet intLightMembersIlluminationSet) {
        this.featureMapping(n, intLightMembersIlluminationSet.isCupholderStripLighting(), intLightMembersIlluminationSet.isCockpitStripLighting(), intLightMembersIlluminationSet.isFrontDoorsStripLighting(), intLightMembersIlluminationSet.isFrontDoorsLighting(), intLightMembersIlluminationSet.isFrontDoorsWarningLighting(), intLightMembersIlluminationSet.isFrontFootwellLighting(), intLightMembersIlluminationSet.isFrontRoofLighting(), intLightMembersIlluminationSet.isFrontSliderLighting(), intLightMembersIlluminationSet.isFrontDoorPocketLighting(), intLightMembersIlluminationSet.isFrontDoorsEntranceLighting(), intLightMembersIlluminationSet.isFrontClimateControlStripLighting(), intLightMembersIlluminationSet.isGearShiftLighting(), intLightMembersIlluminationSet.isCenterControlLighting(), intLightMembersIlluminationSet.isNavigationDeviceStripLighting(), intLightMembersIlluminationSet.isPremiumSoundLighting(), intLightMembersIlluminationSet.isRearFootwellLighting(), intLightMembersIlluminationSet.isRearDoorsLighting(), intLightMembersIlluminationSet.isRearDoorsWarningLighting(), intLightMembersIlluminationSet.isRearDoorsEntranceLighting(), intLightMembersIlluminationSet.isRearDoorsStripLighting(), intLightMembersIlluminationSet.isRearDoorPocketLighting(), intLightMembersIlluminationSet.isRearRoofLighting(), intLightMembersIlluminationSet.isSunRoofStripLighting());
    }

    private void featureMapping(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19, boolean bl20, boolean bl21, boolean bl22, boolean bl23) {
        if (bl) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP] = n;
        }
        if (bl2) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_COCKPIT] = n;
        }
        if (bl3) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_DOORS] = n;
        }
        if (bl4) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_HANDLE] = n;
        }
        if (bl5) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_RECTANGLE] = n;
        }
        if (bl6) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_FOOTWELL] = n;
        }
        if (bl7) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_ROOF] = n;
        }
        if (bl8) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_FRONT_SLIDER] = n;
        }
        if (bl9) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_FRONT_DOOR_POCKET] = n;
        }
        if (bl10) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_FRONT_DOORS_ENTRANCE] = n;
        }
        if (bl11) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_FRONT_CLIMATE_CONTROL_STRIP] = n;
        }
        if (bl12) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_GEAR_SHIFT] = n;
        }
        if (bl13) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_CENTER_CONTROL_LIGHTING_FRONT] = n;
        }
        if (bl14) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_NAVI_DEVICE_STRIP] = n;
        }
        if (bl15) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_PREMIUMSOUND] = n;
        }
        if (bl16) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL] = n;
        }
        if (bl17) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_DOORS] = n;
        }
        if (bl18) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING] = n;
        }
        if (bl19) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE] = n;
        }
        if (bl20) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP] = n;
        }
        if (bl21) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET] = n;
        }
        if (bl22) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_REAR_ROOF] = n;
        }
        if (bl23) {
            this.ambienceLightMapping[StateWork.AMBIENCE_LIGHT_FEATURE_SUNROOF_STRIP] = n;
        }
    }

    protected void fillingGetterAmbienceLight(int n, int n2, boolean bl, int n3) {
        ASLCarContainer.LIGHT_AREAR_COLLECTOR[n] = new AmbienceLightAreaCollector(n2, bl, 0, n3);
    }

    private void evaluateButtonToLightArea(int n, boolean bl, boolean bl2, int n2) {
        if (ASLCarContainer.LIGHT_AREAR_COLLECTOR[n].getColorAreaAvailability() == 0 && bl) {
            this.fillingGetterAmbienceLight(n, bl ? 1 : 0, bl2, n2);
        }
    }

    protected void evaluateButtonToLightAreas(IntLightMembersIlluminationSet intLightMembersIlluminationSet, IntLightMembersMultiColor intLightMembersMultiColor, int n) {
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP, intLightMembersIlluminationSet.isCupholderStripLighting(), intLightMembersMultiColor.isCupholderStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_COCKPIT, intLightMembersIlluminationSet.isCockpitStripLighting(), intLightMembersMultiColor.isCockpitStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_DOORS, intLightMembersIlluminationSet.isFrontDoorsStripLighting(), intLightMembersMultiColor.isFrontDoorsStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_HANDLE, intLightMembersIlluminationSet.isFrontDoorsLighting(), intLightMembersMultiColor.isFrontDoorsLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_RECTANGLE, intLightMembersIlluminationSet.isFrontDoorsWarningLighting(), intLightMembersMultiColor.isFrontDoorsWarningLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_FOOTWELL, intLightMembersIlluminationSet.isFrontFootwellLighting(), intLightMembersMultiColor.isFrontFootwellLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_ROOF, intLightMembersIlluminationSet.isFrontRoofLighting(), intLightMembersMultiColor.isFrontRoofLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_FRONT_SLIDER, intLightMembersIlluminationSet.isFrontSliderLighting(), intLightMembersMultiColor.isFrontSliderLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_FRONT_DOOR_POCKET, intLightMembersIlluminationSet.isFrontDoorPocketLighting(), intLightMembersMultiColor.isFrontDoorPocketLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_FRONT_DOORS_ENTRANCE, intLightMembersIlluminationSet.isFrontDoorsEntranceLighting(), intLightMembersMultiColor.isFrontDoorsEntranceLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_FRONT_CLIMATE_CONTROL_STRIP, intLightMembersIlluminationSet.isFrontClimateControlStripLighting(), intLightMembersMultiColor.isFrontClimateControlStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_GEAR_SHIFT, intLightMembersIlluminationSet.isGearShiftLighting(), intLightMembersMultiColor.isGearShiftLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_CENTER_CONTROL_LIGHTING_FRONT, intLightMembersIlluminationSet.isCenterControlLighting(), intLightMembersMultiColor.isCenterControlLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_NAVI_DEVICE_STRIP, intLightMembersIlluminationSet.isNavigationDeviceStripLighting(), intLightMembersMultiColor.isNavigationDeviceStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_PREMIUMSOUND, intLightMembersIlluminationSet.isPremiumSoundLighting(), intLightMembersMultiColor.isPremiumSoundLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL, intLightMembersIlluminationSet.isRearFootwellLighting(), intLightMembersMultiColor.isRearFootwellLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_DOORS, intLightMembersIlluminationSet.isRearDoorsLighting(), intLightMembersMultiColor.isRearDoorsLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING, intLightMembersIlluminationSet.isRearDoorsWarningLighting(), intLightMembersMultiColor.isRearDoorsWarningLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE, intLightMembersIlluminationSet.isRearDoorsEntranceLighting(), intLightMembersMultiColor.isRearDoorsEntranceLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP, intLightMembersIlluminationSet.isRearDoorsStripLighting(), intLightMembersMultiColor.isRearDoorsStripLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET, intLightMembersIlluminationSet.isRearDoorPocketLighting(), intLightMembersMultiColor.isRearDoorPocketLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_REAR_ROOF, intLightMembersIlluminationSet.isRearRoofLighting(), intLightMembersMultiColor.isRearRoofLighting(), n);
        this.evaluateButtonToLightArea(AMBIENCE_LIGHT_FEATURE_SUNROOF_STRIP, intLightMembersIlluminationSet.isSunRoofStripLighting(), intLightMembersMultiColor.isSunRoofStripLighting(), n);
    }

    private void evaluateAmbienceLightSettings(IntLightConfig intLightConfig) {
        if (intLightConfig.getSetupIlluminationSet1() != 255 && intLightConfig.getSetupIlluminationSet1() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet2() != 255 && intLightConfig.getSetupIlluminationSet2() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet3() != 255 && intLightConfig.getSetupIlluminationSet3() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet4() != 255 && intLightConfig.getSetupIlluminationSet4() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet5() != 255 && intLightConfig.getSetupIlluminationSet5() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet6() != 255 && intLightConfig.getSetupIlluminationSet6() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet7() != 255 && intLightConfig.getSetupIlluminationSet7() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
        if (intLightConfig.getSetupIlluminationSet8() != 255 && intLightConfig.getSetupIlluminationSet8() == 10) {
            this.myTarget.isAmbienceLight = true;
        }
    }

    public void dsiCarLightUpdateExtLightViewOptions(ExtLightViewOptions extLightViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: extLight: ").append(extLightViewOptions.toString()).log();
        }
        if (this.notificationList.contains(10)) {
            this.notificationList.removeValue(10);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(extLightViewOptions.getAdaptiveLightSystem().getState(), 49, extLightViewOptions.getAdaptiveLightSystem().getReason());
        this.evaluateViewOptions(extLightViewOptions.getDayLight().getState(), 53, extLightViewOptions.getDayLight().getReason());
        this.evaluateViewOptions(extLightViewOptions.getMotorwayBlinking().getState(), 54, extLightViewOptions.getMotorwayBlinking().getReason());
        this.evaluateViewOptions(extLightViewOptions.getComingHome().getState(), 60, extLightViewOptions.getComingHome().getReason());
        this.evaluateViewOptions(extLightViewOptions.getLeavingHome().getState(), 61, extLightViewOptions.getLeavingHome().getReason());
        this.evaluateViewOptions(extLightViewOptions.getTouristLight().getState(), 55, extLightViewOptions.getTouristLight().getReason());
        this.evaluateViewOptions(extLightViewOptions.getMaskedHighBeam().getState(), 56, extLightViewOptions.getMaskedHighBeam().getReason());
        this.evaluateViewOptions(extLightViewOptions.getSwitchOnSensitivity().getState(), 50, extLightViewOptions.getSwitchOnSensitivity().getReason());
        this.evaluateViewOptions(extLightViewOptions.getAutomaticLight().getState(), 52, extLightViewOptions.getAutomaticLight().getReason());
        if (extLightViewOptions.getHeadlightRange() != null) {
            this.evaluateViewOptions(extLightViewOptions.getHeadlightRange().getState(), 216, extLightViewOptions.getHeadlightRange().getReason());
        } else {
            this.myTarget.error("southside not support viewoptions Headlightrange = null");
        }
        if (extLightViewOptions.getExtLightConfig().isRainDependency()) {
            this.evaluateViewOptions(extLightViewOptions.getAutomaticLight().getState(), 51, extLightViewOptions.getAutomaticLight().getReason());
        } else {
            this.evaluateViewOptions(0, 51, 0);
        }
        this.evaluateViewOptions(extLightViewOptions.getHeadlightSystem().getState(), 122, extLightViewOptions.getHeadlightSystem().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_LIGHT, 11, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, extLightViewOptions.getExtLightConfig().isLeftHandTraffic());
        this.myTarget.triggerObserver(621486080, eventGeneric);
    }

    public void dsiCarDriverAssistanceUpdateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: accViewOptions: ").append(aCCViewOptions.toString()).log();
        }
        if (this.notificationList.contains(0)) {
            this.notificationList.removeValue(0);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(aCCViewOptions.getTimegap().getState(), 24, aCCViewOptions.getTimegap().getReason());
        this.evaluateViewOptions(aCCViewOptions.getDefaultMode().getState(), 25, aCCViewOptions.getDefaultMode().getReason());
        if (!(aCCViewOptions.getConfiguration().getDrivingPrograms().isEco() || aCCViewOptions.getConfiguration().getDrivingPrograms().isComfort() || aCCViewOptions.getConfiguration().getDrivingPrograms().isDynamic())) {
            this.accDrivingPrograms[0] = true;
            this.accDrivingPrograms[2] = true;
            this.accDrivingPrograms[3] = true;
            this.accDrivingPrograms[1] = false;
            ServiceManager.aslPropertyManager.valueChangedFlagVector(10475, this.accDrivingPrograms);
            this.evaluateViewOptions(aCCViewOptions.getDrivingProgram().getState(), 26, aCCViewOptions.getDrivingProgram().getReason());
        } else {
            this.saveDrivingProgram(aCCViewOptions);
            int n2 = 0;
            for (int i2 = 0; i2 < this.accDrivingPrograms.length; ++i2) {
                if (!this.accDrivingPrograms[i2]) continue;
                ++n2;
            }
            if (n2 < 2) {
                this.evaluateViewOptions(0, 26, 1);
            } else {
                this.evaluateViewOptions(aCCViewOptions.getDrivingProgram().getState(), 26, aCCViewOptions.getDrivingProgram().getReason());
            }
        }
        if (isNavi) {
            this.evaluateViewOptions(aCCViewOptions.getCurveAssist().getState(), 125, aCCViewOptions.getCurveAssist().getReason());
        } else {
            this.evaluateViewOptions(0, 125, 0);
        }
        this.evaluateViewOptions(aCCViewOptions.getSpeedLimitAdoption().getState(), 126, aCCViewOptions.getSpeedLimitAdoption().getReason());
        this.evaluateViewOptions(0, 127, 0);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    private void saveDrivingProgram(ACCViewOptions aCCViewOptions) {
        this.accDrivingPrograms[0] = aCCViewOptions.getConfiguration().getDrivingPrograms().isEco();
        this.accDrivingPrograms[2] = aCCViewOptions.getConfiguration().getDrivingPrograms().isStandard();
        this.accDrivingPrograms[3] = aCCViewOptions.getConfiguration().getDrivingPrograms().isDynamic();
        this.accDrivingPrograms[1] = aCCViewOptions.getConfiguration().getDrivingPrograms().isComfort();
        ServiceManager.aslPropertyManager.valueChangedFlagVector(10475, this.accDrivingPrograms);
    }

    public void dsiCarDriverAssistanceUpdateSWAViewOptions(SWAViewOptions sWAViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: swaViewOptions: ").append(sWAViewOptions.toString()).log();
        }
        if (this.notificationList.contains(2)) {
            this.notificationList.removeValue(2);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        if (sWAViewOptions.getConfiguration().getSystem() == 1) {
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: swaConfig: SWASYSTEM_BSD").log();
            }
            this.evaluateViewOptions(sWAViewOptions.getSystem().getState(), 128, sWAViewOptions.getSystem().getReason());
            this.evaluateViewOptions(sWAViewOptions.getGongState().getState(), 129, sWAViewOptions.getGongState().getReason());
            this.evaluateViewOptions(0, 31, 1);
            this.evaluateViewOptions(0, 32, 1);
        } else {
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: swaConfig: SWASYSTEM_SWA").log();
            }
            this.evaluateViewOptions(0, 128, 1);
            this.evaluateViewOptions(0, 129, 1);
            this.evaluateViewOptions(sWAViewOptions.getBrightness().getState(), 32, sWAViewOptions.getBrightness().getReason());
        }
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(sWAViewOptions.getRcta().getState(), 135, sWAViewOptions.getRcta().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_PARKING, 10, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarDriverAssistanceUpdateAWVViewOptions(AWVViewOptions aWVViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: awvViewOptions: ").append(aWVViewOptions.toString()).log();
        }
        if (this.notificationList.contains(1)) {
            this.notificationList.removeValue(1);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        switch (aWVViewOptions.getConfiguration().getSystemMode()) {
            case 1: {
                ASLCarContainer.functionExistent[30] = false;
                ASLCarContainer.functionExistent[27] = true;
                ASLCarContainer.functionExistent[28] = true;
                ASLCarContainer.functionExistent[29] = true;
                ASLCarContainer.functionExistent[109] = true;
                ASLCarContainer.functionExistent[214] = true;
                this.evaluateViewOptions(aWVViewOptions.getSystem().getState(), 27, aWVViewOptions.getSystem().getReason());
                this.evaluateViewOptions(aWVViewOptions.getWarning().getState(), 28, aWVViewOptions.getWarning().getReason());
                this.evaluateViewOptions(aWVViewOptions.getDistanceWarning().getState(), 29, aWVViewOptions.getDistanceWarning().getReason());
                this.evaluateViewOptions(aWVViewOptions.getEmergencyBrake().getState(), 109, aWVViewOptions.getEmergencyBrake().getReason());
                this.evaluateViewOptions(aWVViewOptions.getWarningTimegap().getState(), 214, aWVViewOptions.getWarningTimegap().getReason());
                break;
            }
            case 2: {
                ASLCarContainer.functionExistent[27] = false;
                ASLCarContainer.functionExistent[28] = false;
                ASLCarContainer.functionExistent[29] = false;
                ASLCarContainer.functionExistent[109] = false;
                ASLCarContainer.functionExistent[214] = false;
                ASLCarContainer.functionExistent[30] = true;
                this.evaluateViewOptions(aWVViewOptions.getSystem().getState(), 30, aWVViewOptions.getSystem().getReason());
                break;
            }
        }
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarDriverAssistanceUpdateLDWHCAViewOptions(LDWHCAViewOptions lDWHCAViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: ldwhcaViewOptions: ").append(lDWHCAViewOptions.toString()).log();
        }
        if (this.notificationList.contains(3)) {
            this.notificationList.removeValue(3);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(lDWHCAViewOptions.getLdwhcaSystemOnOff().getState(), 33, lDWHCAViewOptions.getLdwhcaSystemOnOff().getReason());
        this.evaluateViewOptions(lDWHCAViewOptions.getHCAToleranceLevel().getState(), 34, lDWHCAViewOptions.getHCAToleranceLevel().getReason());
        this.evaluateViewOptions(lDWHCAViewOptions.getLDWSteeringWheelVibration().getState(), 35, lDWHCAViewOptions.getLDWSteeringWheelVibration().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarDriverAssistanceUpdateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: tsdViewOptions: ").append(tSDViewOptions.toString()).log();
        }
        if (this.notificationList.contains(28)) {
            this.notificationList.removeValue(28);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.myTdsViewOptions = tSDViewOptions;
        this.evaluateViewOptionsVzeVza();
        this.evaluateViewOptionsTrailer();
    }

    private void evaluateViewOptionsVzeVza() {
        switch (this.myTdsViewOptions.getConfiguration().getType()) {
            case 1: {
                this.myTarget.error().append("[CAR] ViewOptionsTarget: getType == VZA will not be evaluate by HMI! User did a wrong coding of target!").log();
                break;
            }
            case 2: {
                this.evaluateViewOptions(this.myTdsViewOptions.getRoadSignFilter().getState(), 47, this.myTdsViewOptions.getTrailerDetection().getReason());
                this.evaluateViewOptions(this.myTdsViewOptions.getTrailerSpeedLimit().getState(), 130, this.myTdsViewOptions.getTrailerSpeedLimit().getReason());
                this.evaluateViewOptions(this.myTdsViewOptions.getSpeedWarningThreshold().getState(), 131, this.myTdsViewOptions.getSpeedWarningThreshold().getReason());
                this.evaluateViewOptions(this.myTdsViewOptions.getSpeedWarnAcoustics().getState(), 211, this.myTdsViewOptions.getSpeedWarnAcoustics().getReason());
                this.evaluateViewOptions(this.myBcViewOptions.getVZADisplay().getState(), 46, this.myBcViewOptions.getVZADisplay().getReason());
                this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
                break;
            }
        }
    }

    private void evaluateViewOptionsTrailer() {
        switch (this.myTdsViewOptions.getConfiguration().getType()) {
            case 1: {
                this.myTarget.error().append("[CAR] ViewOptionsTarget: getType == VZA will not be evaluate by HMI! User did a wrong coding of target!").log();
                break;
            }
            case 2: {
                this.evaluateViewOptions(this.myTdsViewOptions.getRoadSignFilter().getState(), 219, this.myTdsViewOptions.getRoadSignFilter().getReason());
                this.evaluateViewOptions(this.myTdsViewOptions.getRoadSignFilter().getState(), 220, this.myTdsViewOptions.getRoadSignFilter().getReason());
                this.evaluateViewOptions(this.myTdsViewOptions.getTrailerSpeedLimit().getState(), 221, this.myTdsViewOptions.getTrailerSpeedLimit().getReason());
                break;
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateMKEViewOptions(MKEViewOptions mKEViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: mkeViewOptions: ").append(mKEViewOptions.toString()).log();
        }
        if (this.notificationList.contains(7)) {
            this.notificationList.removeValue(7);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(mKEViewOptions.getSystemOnOff().getState(), 48, mKEViewOptions.getSystemOnOff().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarDriverAssistanceUpdatePAViewOptions(PAViewOptions pAViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: paViewOptions: ").append(pAViewOptions.toString()).log();
        }
        if (this.notificationList.contains(27)) {
            this.notificationList.removeValue(27);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(pAViewOptions.getPaSystemOnOff().getState(), 132, pAViewOptions.getPaSystemOnOff().getReason());
        this.evaluateViewOptions(pAViewOptions.getPaConfigInformation().getState(), 133, pAViewOptions.getPaConfigInformation().getReason());
        this.evaluateViewOptions(pAViewOptions.getPaConfigWarning().getState(), 134, pAViewOptions.getPaConfigWarning().getReason());
        this.evaluateViewOptions(pAViewOptions.getPaWarningTimegap().getState(), 181, pAViewOptions.getPaWarningTimegap().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateMirrorViewOptions(MirrorViewOptions mirrorViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: mirrorViewOptions: ").append(mirrorViewOptions.toString()).log();
        }
        if (this.notificationList.contains(11)) {
            this.notificationList.removeValue(11);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        if (isPoloCoded) {
            this.evaluateViewOptions(0, 62, 0);
        } else {
            this.evaluateViewOptions(mirrorViewOptions.getMirrorSyncAdjust().getState(), 62, mirrorViewOptions.getMirrorSyncAdjust().getReason());
        }
        this.evaluateViewOptions(mirrorViewOptions.getMirrorLowering().getState(), 63, mirrorViewOptions.getMirrorLowering().getReason());
        this.evaluateViewOptions(mirrorViewOptions.getMirrorFolding().getState(), 64, mirrorViewOptions.getMirrorFolding().getReason());
        this.evaluateViewOptions(mirrorViewOptions.getMirrorHeating().getState(), 145, mirrorViewOptions.getMirrorHeating().getReason());
        this.evaluateViewOptions(mirrorViewOptions.getMirrorDimming().getState(), 146, mirrorViewOptions.getMirrorDimming().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_MIRRORWIPER, 12, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateWiperViewOptions(WiperViewOptions wiperViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: wiperViewOptions: ").append(wiperViewOptions.toString()).log();
        }
        if (this.notificationList.contains(12)) {
            this.notificationList.removeValue(12);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(wiperViewOptions.getWiperRainSensorOnOff().getState(), 65, wiperViewOptions.getWiperRainSensorOnOff().getReason());
        this.evaluateViewOptions(wiperViewOptions.getWiperRearWiping().getState(), 66, wiperViewOptions.getWiperRearWiping().getReason());
        this.evaluateViewOptions(wiperViewOptions.getWiperWinterPosition().getState(), 67, wiperViewOptions.getWiperWinterPosition().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_MIRRORWIPER, 12, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateDoorLockingViewOptions(DoorLockingViewOptions doorLockingViewOptions, int n) {
        Object object;
        DoorLockingConfiguration doorLockingConfiguration;
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: doorLockingViewOptions: ").append(doorLockingViewOptions.toString()).log();
        }
        if (this.notificationList.contains(16)) {
            this.notificationList.removeValue(16);
        }
        if (this.notificationList.contains(16)) {
            this.notificationList.removeValue(16);
        }
        if (this.notificationList.contains(26)) {
            this.notificationList.removeValue(26);
        }
        if ((doorLockingConfiguration = doorLockingViewOptions.getConfiguration()) == null) {
            throw new NullPointerException("doorLockingViewOptions.getConfiguration() is NULL!");
        }
        if (doorLockingConfiguration.getCentralLockingSettings() != null) {
            object = doorLockingConfiguration.getCentralLockingSettings();
            int bl = doorLockingViewOptions.getConfiguration().getNumberOfDoors();
            this.manualUnlockMode[0] = ((DoorLockingCLSettings)object).allDoors;
            this.manualUnlockMode[1] = ((DoorLockingCLSettings)object).seperateDoor;
            this.manualUnlockMode[2] = bl == 2 || bl == 3 ? false : ((DoorLockingCLSettings)object).sideDoors;
        } else {
            this.manualUnlockMode[0] = false;
            this.manualUnlockMode[1] = false;
            this.manualUnlockMode[2] = false;
        }
        ServiceManager.aslPropertyManager.valueChangedFlagVector(10201, this.manualUnlockMode);
        ASLCarContainer.getInstance().setNumberOfWindows(doorLockingViewOptions.getConfiguration().getNumberOfWindows());
        ASLCarContainer.getInstance().setSunRoofAvailable(doorLockingViewOptions.getConfiguration().isSunRoof());
        object = ServiceManager.mGenericEventFactory.newEvent();
        this.myTarget.triggerObserver(604708864, (EventGeneric)object);
        if (!this.myTarget.isWindow) {
            this.evaluateViewOptions(0, 68, doorLockingViewOptions.getComfortOpen().getReason());
            this.evaluateViewOptions(0, 69, doorLockingViewOptions.getRainClosing().getReason());
            this.evaluateViewOptions(0, 209, doorLockingViewOptions.getWindowAutoClose().getReason());
        } else {
            this.evaluateViewOptions(doorLockingViewOptions.getComfortOpen().getState(), 68, doorLockingViewOptions.getComfortOpen().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getRainClosing().getState(), 69, doorLockingViewOptions.getRainClosing().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getWindowAutoClose().getState(), 209, doorLockingViewOptions.getWindowAutoClose().getReason());
        }
        if (!this.myTarget.isCentralLocking) {
            this.evaluateViewOptions(0, 70, doorLockingViewOptions.getUnlockingMode().getReason());
            this.evaluateViewOptions(0, 71, doorLockingViewOptions.getAutoLock().getReason());
            this.evaluateViewOptions(0, 72, doorLockingViewOptions.getAutoUnlock().getReason());
            this.evaluateViewOptions(0, 73, doorLockingViewOptions.getBootOpen().getReason());
            this.evaluateViewOptions(0, 156, doorLockingViewOptions.getRearBlind().getReason());
            this.evaluateViewOptions(0, 74, doorLockingViewOptions.getLockingConfirmation().getReason());
        } else {
            this.evaluateViewOptions(doorLockingViewOptions.getUnlockingMode().getState(), 70, doorLockingViewOptions.getUnlockingMode().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getAutoLock().getState(), 71, doorLockingViewOptions.getAutoLock().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getAutoUnlock().getState(), 72, doorLockingViewOptions.getAutoUnlock().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getBootOpen().getState(), 73, doorLockingViewOptions.getBootOpen().getReason());
            if (doorLockingViewOptions.getConfiguration().isBootBlind()) {
                this.evaluateViewOptions(doorLockingViewOptions.getComfortOpen().getState(), 156, doorLockingViewOptions.getComfortOpen().getReason());
            } else {
                this.evaluateViewOptions(0, 156, doorLockingViewOptions.getRearBlind().getReason());
            }
            this.evaluateViewOptions(doorLockingViewOptions.getLockingConfirmation().getState(), 74, doorLockingViewOptions.getLockingConfirmation().getReason());
            this.evaluateViewOptions(doorLockingViewOptions.getTheftWarning().getState(), 210, doorLockingViewOptions.getTheftWarning().getReason());
        }
        this.myTarget.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        boolean bl = doorLockingViewOptions.getUserProfileOnOff().getState() != 0;
        this.existentState(30, FunctionIds.EXISTENT_PERSONALIZATION, bl, this.configManPersCarFuncAdapImpl.getBoolean(267), this.configManPersCarFuncAdapImpl.getBoolean(268), 153, FunctionIds.CHILD_PERSONALIZATION);
        if (this.notificationList.contains(30)) {
            this.notificationList.removeValue(30);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        CarPersistenceServiceImpl.getInstance().loadCar().setPersonalization(bl);
        this.evaluateViewOptions(doorLockingViewOptions.getUserProfileOnOff().getState(), 178, doorLockingViewOptions.getUserProfileOnOff().getReason());
        this.evaluateViewOptions(doorLockingViewOptions.getUserList().getState(), 179, doorLockingViewOptions.getUserList().getReason());
        int n2 = doorLockingViewOptions.getUserProfileControl().getState();
        int n3 = doorLockingViewOptions.getUserProfileControl().getReason();
        this.evaluateViewOptions(n2, 195, n3);
        if (n2 == 2) {
            this.updatePersonalAssignKeyVO(true, n3);
        } else if (n2 == 1) {
            this.updatePersonalAssignKeyVO(false, n3);
        }
        this.myTarget.parentChildRelation(FunctionIds.CHILD_PERSONALIZATION, 153, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    void updatePersonalAssignKeyVO(boolean bl, int n) {
        CarPersonalAssignKeyAvailabilityCollector carPersonalAssignKeyAvailabilityCollector = new CarPersonalAssignKeyAvailabilityCollector();
        carPersonalAssignKeyAvailabilityCollector.car_personal_assign_key_available_state = bl;
        carPersonalAssignKeyAvailabilityCollector.car_personal_assign_key_available_reason = this.carViewOptionsReason(n);
        ListManager.getGenericASLList(10534).updateList(new CarPersonalAssignKeyAvailabilityCollector[]{carPersonalAssignKeyAvailabilityCollector});
    }

    public void dsiCarKombiUpdateSIAViewOptions(SIAViewOptions sIAViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: siaViewOptions: ").append(sIAViewOptions.toString()).log();
        }
        if (this.notificationList.contains(18)) {
            this.notificationList.removeValue(18);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(sIAViewOptions.getServiceData().getState(), 76, sIAViewOptions.getServiceData().getReason());
        this.evaluateViewOptions(sIAViewOptions.getOilInspection().getState(), 77, sIAViewOptions.getOilInspection().getReason());
        this.evaluateViewOptions(sIAViewOptions.getReset().getState(), 80, sIAViewOptions.getReset().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_SERVICE, 18, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.oilServiceButtonCollector.car_service_oil_service_button_availability_reason = ASLCarContainer.collector[18].functionReason;
        this.oilServiceButtonCollector.car_service_oil_service_button_availability_state = ASLCarContainer.collector[18].functionAvailable;
        ListManager.getGenericASLList(10598).updateListItem(0, this.oilServiceButtonCollector);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10597, ASLCarContainer.functionExistent[18]);
        ServiceManager.aslPropertyManager.valueChangedBoolean(10596, this.configManPersCarFuncAdapImpl.getBoolean(255));
    }

    public void dsiCarVehicleStatesUpdateVINViewOption(CarViewOption carViewOption, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: vinViewOptions: ").append(carViewOption.toString()).log();
        }
        if (this.notificationList.contains(17)) {
            this.notificationList.removeValue(17);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(carViewOption.getState(), 75, carViewOption.getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_SERVICE, 18, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateRGSViewOptions(RGSViewOptions rGSViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: rgsViewOptions: ").append(rGSViewOptions.toString()).log();
        }
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: notificationList len: ").append(this.notificationList.toString()).append(" size: ").append(this.notificationList.size()).log();
        }
        if (this.notificationList.contains(5)) {
            this.notificationList.removeValue(5);
        }
        if (this.notificationList.contains(29)) {
            this.notificationList.removeValue(29);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.myTarget.isRgsFactorySetting = rGSViewOptions.getRgsSetFactoryDefault().getState() != 0;
        this.evaluateViewOptions(rGSViewOptions.getBeltPretensionerFrontDataLeft().getState(), 82, rGSViewOptions.getBeltPretensionerFrontDataLeft().getReason());
        this.evaluateViewOptions(rGSViewOptions.getBeltPretensionerFrontDataRight().getState(), 83, rGSViewOptions.getBeltPretensionerFrontDataRight().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_SEATS, 14, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(rGSViewOptions.getPreCrashSystem().getState(), 37, rGSViewOptions.getPreCrashSystem().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: rdkViewOptions: ").append(rDKViewOptions.toString()).log();
        }
        if (this.notificationList.contains(14)) {
            this.notificationList.removeValue(14);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateRDKPartFullLoadViewOptions(rDKViewOptions);
        this.myTarget.parentChildRelation(FunctionIds.PARENT_VEHICLE_STATUS_RDK_SYSTEM, 107, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_VEHICLESTATUS, 3, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    private void evaluateRDKPartFullLoadViewOptions(RDKViewOptions rDKViewOptions) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(105) && rDKViewOptions.getConfiguration().getSystem() == 2) {
            this.evaluateViewOptions(0, 110, 1);
        } else {
            this.evaluateViewOptions(rDKViewOptions.getTireDisplay().getState(), 110, rDKViewOptions.getTireDisplay().getReason());
            if (!(rDKViewOptions.getTireDisplay().getState() != 2 || rDKViewOptions.configuration.pressureLevel2 || rDKViewOptions.configuration.pressureLevel3 || ServiceManager.configManagerDiag.isFeatureFlagSet(101))) {
                this.evaluateViewOptions(0, 110, 1);
            }
        }
    }

    public void dsiCarComfortUpdateUGDOViewOptions(UGDOViewOptions uGDOViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: UGDOViewOptions: ").append(uGDOViewOptions.toString()).log();
        }
        if (this.notificationList.contains(35)) {
            this.notificationList.removeValue(35);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(uGDOViewOptions.getButtonList().getState(), 190, uGDOViewOptions.getButtonList().getReason());
        this.evaluateViewOptions(uGDOViewOptions.getDeleteButton().getState(), 191, uGDOViewOptions.getDeleteButton().getReason());
        this.evaluateViewOptions(uGDOViewOptions.getVersionData().getState(), 192, uGDOViewOptions.getVersionData().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_OPENCLOSE, 13, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        this.myTarget.info().append("CAR: BC ViewOptions").append(bCViewOptions.getShortTermAverageConsumption1().getState()).log();
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: bordComputerViewOptions: ").append(bCViewOptions.toString()).log();
        }
        if (this.notificationList.contains(15)) {
            this.notificationList.removeValue(15);
        }
        if (this.notificationList.contains(6)) {
            this.notificationList.removeValue(6);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.myBcViewOptions = bCViewOptions;
        switch (bCViewOptions.getConfiguration().getPrimaryEngineType()) {
            case 0: 
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 0);
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 1);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 5);
                break;
            }
            case 2: 
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10133, 4);
                break;
            }
        }
        switch (bCViewOptions.getConfiguration().getSecondaryEngineType()) {
            case 0: 
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 0);
                break;
            }
            case 1: 
            case 6: 
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 1);
                break;
            }
            case 9: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 5);
                break;
            }
            case 2: 
            case 8: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(10134, 4);
                break;
            }
        }
        if ((bCViewOptions.getConfiguration().getPrimaryEngineType() == 1 || bCViewOptions.getConfiguration().getPrimaryEngineType() == 6 || bCViewOptions.getConfiguration().getPrimaryEngineType() == 7) && bCViewOptions.getConfiguration().getSecondaryEngineType() == 3) {
            if (this.configManPersCarFuncAdapImpl.getBoolean(395) && this.configManPersCarFuncAdapImpl.getBoolean(275)) {
                this.myTarget.registerOnFpaViewOptions();
            } else {
                this.myTarget.clearOnFpaViewOptions();
            }
        }
        this.evaluateViewOptions(bCViewOptions.getDigitalSpeed().getState(), 95, bCViewOptions.getDigitalSpeed().getReason());
        this.evaluateViewOptions(bCViewOptions.getConsumerDisplay().getState(), 90, bCViewOptions.getConsumerDisplay().getReason());
        this.evaluateViewOptions(bCViewOptions.getLifeTipsDisplay().getState(), 91, bCViewOptions.getLifeTipsDisplay().getReason());
        this.evaluateViewOptions(bCViewOptions.getOilTemperature().getState(), 97, bCViewOptions.getOilTemperature().getReason());
        this.evaluateViewOptions(bCViewOptions.getVzaMFA().getState(), 99, bCViewOptions.getVzaMFA().getReason());
        this.evaluateViewOptions(bCViewOptions.getAstaMFA(), 215);
        if (bCViewOptions.getMenue1Config().getState() == 0 && bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isRefuelVolume() || !bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isRefuelVolume()) {
            ASLCarContainer.functionExistent[89] = false;
        } else {
            this.evaluateViewOptions(bCViewOptions.getMenue1Config().getState(), 89, bCViewOptions.getMenue1Config().getReason());
        }
        if (bCViewOptions.getMenue1Config().getState() == 0 && bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isCoolantTemp() || !bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isCoolantTemp()) {
            ASLCarContainer.functionExistent[98] = false;
        } else {
            this.evaluateViewOptions(bCViewOptions.getMenue1Config().getState(), 98, bCViewOptions.getMenue1Config().getReason());
        }
        if (bCViewOptions.getMenue1Config().getState() == 0 && bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isSpeedWarning() || !bCViewOptions.getConfiguration().getFisAdditionalConfiguration().isSpeedWarning()) {
            ASLCarContainer.functionExistent[96] = false;
        } else {
            this.evaluateViewOptions(bCViewOptions.getMenue1Config().getState(), 96, bCViewOptions.getMenue1Config().getReason());
        }
        if (bCViewOptions.getMenue1Config().getState() == 0 && bCViewOptions.getMenue2Config().getState() == 0 && bCViewOptions.getMenue3Config().getState() == 0) {
            this.settingUpViewOptionsBCNotExisting(false);
        } else {
            this.settingUpViewOptionsBCNotExisting(true);
            if (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() == 2 && bCViewOptions.getMenue3Config().getState() == 2) {
                this.settingUpViewOptionsBC(bCViewOptions.getMenue1Config());
            } else if (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() == 2 && bCViewOptions.getMenue3Config().getState() != 2) {
                this.settingUpViewOptionsBC(bCViewOptions.getMenue3Config());
            } else if (bCViewOptions.getMenue1Config().getState() == 2 && bCViewOptions.getMenue2Config().getState() != 2) {
                this.settingUpViewOptionsBC(bCViewOptions.getMenue2Config());
            } else {
                this.settingUpViewOptionsBC(bCViewOptions.getMenue1Config());
            }
        }
        this.evaluateViewOptions(bCViewOptions.getResetMenue1().getState(), 100, bCViewOptions.getResetMenue1().getReason());
        this.evaluateViewOptions(bCViewOptions.getResetMenue2().getState(), 101, bCViewOptions.getResetMenue2().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_MFASETUP, 15, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(bCViewOptions.getCurrentRange1().getState(), 21, bCViewOptions.getCurrentRange1().getReason());
        this.evaluateViewOptions(bCViewOptions.getShortTermAverageConsumption1().getState(), 23, bCViewOptions.getShortTermAverageConsumption1().getReason());
        this.evaluateViewOptions(bCViewOptions.getShortTermGeneral().getState(), 22, bCViewOptions.getShortTermGeneral().getReason());
        this.evaluateViewOptions(bCViewOptions.getShortTermAverageConsumption2().getState(), 147, bCViewOptions.getShortTermAverageConsumption2().getReason());
        this.evaluateViewOptions(bCViewOptions.getLongTermAverageConsumption2().getState(), 150, bCViewOptions.getLongTermAverageConsumption2().getReason());
        this.evaluateViewOptions(bCViewOptions.getCycleAverageConsumption2().getState(), 151, bCViewOptions.getCycleAverageConsumption2().getReason());
        this.evaluateViewOptions(bCViewOptions.getCurrentRange1().getState(), 148, bCViewOptions.getCurrentRange1().getReason());
        this.evaluateViewOptions(bCViewOptions.getCurrentRange2().getState(), 149, bCViewOptions.getCurrentRange2().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_BORDCOMPUTER_SHORTTERM, 4, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(bCViewOptions.getLongTermAverageConsumption1().getState(), 103, bCViewOptions.getLongTermAverageConsumption1().getReason());
        this.evaluateViewOptions(bCViewOptions.getLongTermGeneral().getState(), 102, bCViewOptions.getLongTermGeneral().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_BORDCOMPUTER_LONGTERM, 5, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(bCViewOptions.getCycleAverageConsumption1().getState(), 105, bCViewOptions.getCycleAverageConsumption1().getReason());
        this.evaluateViewOptions(bCViewOptions.getCycleGeneral().getState(), 104, bCViewOptions.getCycleGeneral().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_BORDCOMPUTER_CYCLE, 6, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_COMPUTER, 1, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.evaluateViewOptions(bCViewOptions.getVehicleStateList().getState(), 120, bCViewOptions.getVehicleStateList().getReason());
        ServiceManager.aslPropertyManager.valueChangedBoolean(10887, bCViewOptions.getVehicleStateList().getState() == 2);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_VEHICLE_STATUS, 108, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_VEHICLESTATUS, 3, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        if (this.configManPersCarFuncAdapImpl.getBoolean(340)) {
            this.evaluateViewOptionsVzeVza();
        }
        ASLSystemFactory.getSystemApi().setEngineTypes(bCViewOptions.getConfiguration().getPrimaryEngineType(), bCViewOptions.getConfiguration().getSecondaryEngineType());
        this.evaluateEngine();
        if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV() || ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            ASLCarContainer.functionExistent[2] = false;
            ServiceManager.aslPropertyManager.valueChangedBoolean(10121, false);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            this.myTarget.triggerObserver(0x220B2000, eventGeneric);
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: bordComputerViewOptions: PHEV or BEV detected ").append(bCViewOptions.toString()).log();
            }
        }
        this.evaluateViewOptionsVehicleStatus();
    }

    private void evaluateEngine() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(394)) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, true);
        } else if (ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10359, false);
        }
    }

    private void evaluateViewOptionsVehicleStatus() {
        if (this.isClamp15Active && this.isClamp15Active && !this.myTarget.getTimerServer().isTimerActive(this.myTarget.getTargetId(), -1517944576)) {
            if (this.myBcViewOptions.getVehicleStateList().getState() == 1 && this.myBcViewOptions.getVehicleStateList().getReason() == 5) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10265, true);
                this.isInitializing = true;
                ASLCarFactory.getCarVehicleApi().getVehicleService().updateInitState(this.isInitializing);
                this.myTarget.startTimer(-1517944576, (long)0, false);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10265, false);
                this.isInitializing = false;
                ASLCarFactory.getCarVehicleApi().getVehicleService().updateInitState(this.isInitializing);
                this.evaluateViewOptions(this.myBcViewOptions.getVehicleStateList().getState(), 120, this.myBcViewOptions.getVehicleStateList().getReason());
            }
        }
    }

    private void settingUpViewOptionsBCNotExisting(boolean bl) {
        ASLCarContainer.functionExistent[87] = bl;
        ASLCarContainer.functionExistent[88] = bl;
        ASLCarContainer.functionExistent[92] = bl;
        ASLCarContainer.functionExistent[93] = bl;
        ASLCarContainer.functionExistent[94] = bl;
    }

    private void settingUpViewOptionsBC(CarViewOption carViewOption) {
        ASLCarContainer.collector[87] = new CarFunctionCollector(carViewOption.getState() == 2, this.carViewOptionsReason(carViewOption.getReason()));
        ASLCarContainer.collector[88] = new CarFunctionCollector(carViewOption.getState() == 2, this.carViewOptionsReason(carViewOption.getReason()));
        ASLCarContainer.collector[92] = new CarFunctionCollector(carViewOption.getState() == 2, this.carViewOptionsReason(carViewOption.getReason()));
        ASLCarContainer.collector[93] = new CarFunctionCollector(carViewOption.getState() == 2, this.carViewOptionsReason(carViewOption.getReason()));
        ASLCarContainer.collector[94] = new CarFunctionCollector(carViewOption.getState() == 2, this.carViewOptionsReason(carViewOption.getReason()));
    }

    public void dsiCarVehicleStatesUpdateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: drivingSchoolViewOptions: ").append(vehicleInfoViewOptions.toString()).log();
        }
        if (this.notificationList.contains(20)) {
            this.notificationList.removeValue(20);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(vehicleInfoViewOptions.getDrvSchoolSystem().getState(), 79, vehicleInfoViewOptions.getDrvSchoolSystem().getReason());
        this.evaluateViewOptions(vehicleInfoViewOptions.getDrvSchoolSystem().getState(), 78, vehicleInfoViewOptions.getDrvSchoolSystem().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_DRIVING_SCHOOL, 0, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarSeatUpdateSeatViewOptions(SeatViewOptions seatViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: seatViewOptions: ").append(seatViewOptions.toString()).log();
        }
        if (this.notificationList.contains(13)) {
            this.notificationList.removeValue(13);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(seatViewOptions.getSeatRadioKeyAutomatic().getState(), 81, seatViewOptions.getSeatRadioKeyAutomatic().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_SEATS, 14, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarComfortUpdateBrakeViewOptions(BrakeViewOptions brakeViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: brakeViewOptions: ").append(brakeViewOptions.toString()).log();
        }
        this.evaluateViewOptions(brakeViewOptions.getBrakeEscMode().getState(), 36, brakeViewOptions.getBrakeEscMode().getReason());
        if (brakeViewOptions.getBrakeEscMode().getState() != 0) {
            this.espOptions[0] = true;
            this.espOptions[1] = brakeViewOptions.getConfiguration().isEscTcsOff();
            this.espOptions[2] = brakeViewOptions.getConfiguration().isEscSport();
            this.espOptions[3] = brakeViewOptions.getConfiguration().isEscOffroad();
            this.espOptions[4] = brakeViewOptions.getConfiguration().isEscOff();
            ServiceManager.aslPropertyManager.valueChangedFlagVector(10233, this.espOptions);
        }
    }

    public void dsiCarAuxHeaterCoolerUpdateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: parkheaterViewOptions: ").append(auxHeaterCoolerViewOptions.toString()).log();
        }
        if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff().getState() == 2 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime().getState() == 2 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1().getState() == 2 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2().getState() == 2 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer3().getState() == 2 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerState().getState() == 2) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(310, true);
            if (!ASLCarContainer.functionExistent[20]) {
                ASLCarContainer.functionExistent[20] = true;
            }
            ASLCarContainer.collector[20] = new CarFunctionCollector(true, 0);
            this.myTarget.informHmi();
        } else if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff().getState() == 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime().getState() == 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1().getState() == 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2().getState() == 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer3().getState() == 0 && auxHeaterCoolerViewOptions.getAuxHeaterCoolerState().getState() == 0) {
            ASLCarContainer.functionExistent[20] = false;
            this.myTarget.informHmi();
        } else {
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerOnOff().getReason());
            }
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerRunningTime().getReason());
            }
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer1().getReason());
            }
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer2().getReason());
            }
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer3().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerTimer3().getReason());
            }
            if (auxHeaterCoolerViewOptions.getAuxHeaterCoolerState().getState() != 2) {
                this.collectingReason(auxHeaterCoolerViewOptions.getAuxHeaterCoolerState().getReason());
            }
            if (!ASLCarContainer.functionExistent[20]) {
                ASLCarContainer.functionExistent[20] = true;
            }
            ASLCarContainer.collector[20] = new CarFunctionCollector(false, this.gettingHighestReason());
            this.clearReasons();
            this.myTarget.informHmi();
            ServiceManager.aslPropertyManager.valueChangedBoolean(310, false);
        }
    }

    public void dsiCarEcoUpdateBCmEViewOptions(BCmEViewOptions bCmEViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: bcmeViewOptions: ").append(bCmEViewOptions.toString()).log();
        }
        if (this.notificationList.contains(19)) {
            this.notificationList.removeValue(19);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.myBcMeViewOptions = bCmEViewOptions;
        if (ASLSystemFactory.getSystemApi().getFeatureFlagValuePHEV() || ASLSystemFactory.getSystemApi().getFeatureFlagValueBEV()) {
            ASLCarContainer.functionExistent[2] = false;
            ServiceManager.aslPropertyManager.valueChangedBoolean(10121, false);
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            this.myTarget.triggerObserver(0x220B2000, eventGeneric);
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: bcmeViewOptions: PHEV or BEV detected ").append(bCmEViewOptions.toString()).log();
            }
        } else {
            this.evaluateViewOptions(bCmEViewOptions.getConsumption().getState(), 2, bCmEViewOptions.getConsumption().getReason());
            ServiceManager.aslPropertyManager.valueChangedBoolean(10121, bCmEViewOptions.getConsumption().getState() != 0 || bCmEViewOptions.getConsumerListRange().getState() != 0);
            ServiceManager.aslPropertyManager.valueChangedBoolean(10888, bCmEViewOptions.getConsumption().getState() == 2);
        }
        this.myTarget.informHmi();
        this.evaluateViewOptionsBcMe();
    }

    private void evaluateViewOptionsBcMe() {
        if (this.isClamp15Active && this.isClamp15Active && !this.myTarget.getTimerServer().isTimerActive(this.myTarget.getTargetId(), -1534721792)) {
            if (this.myBcMeViewOptions.getConsumption().getState() == 1 && this.myBcMeViewOptions.getConsumption().getReason() == 5) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10132, true);
                this.myTarget.startTimer(-1534721792, (long)0, false);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10132, false);
                this.evaluateViewOptions(this.myBcMeViewOptions.getConsumption().getState(), 2, this.myBcMeViewOptions.getConsumption().getReason());
            }
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        this.myClockViewOptions = clockViewOptions;
        this.checkingViewOptions();
        if (this.notificationList.contains(22)) {
            this.notificationList.removeValue(22);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
    }

    public void dsiCarTimeUnitsLanguageUpdateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: unitmasterViewOptions: ").append(unitmasterViewOptions.toString()).log();
        }
        if (this.notificationList.contains(23)) {
            this.notificationList.removeValue(23);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.myUnitMasterViewOptions = unitmasterViewOptions;
        this.checkingViewOptions();
        if (unitmasterViewOptions.getDistanceUnit().getState() == 2 || unitmasterViewOptions.getPressureUnit().getState() == 2 || unitmasterViewOptions.getSpeedUnit().getState() == 2 || unitmasterViewOptions.getTemperatureUnit().getState() == 2 || unitmasterViewOptions.getVolumeUnit().getState() == 2 || unitmasterViewOptions.getConsumptionGasUnit().getState() == 2 || unitmasterViewOptions.getConsumptionPetrolUnit().getState() == 2) {
            if (!ASLCarContainer.functionExistent[17]) {
                ASLCarContainer.functionExistent[17] = true;
            }
            ASLCarContainer.collector[17] = new CarFunctionCollector(true, 0);
        } else if (unitmasterViewOptions.getDistanceUnit().getState() == 0 && unitmasterViewOptions.getPressureUnit().getState() == 0 && unitmasterViewOptions.getSpeedUnit().getState() == 0 && unitmasterViewOptions.getTemperatureUnit().getState() == 0 && unitmasterViewOptions.getVolumeUnit().getState() == 0 && unitmasterViewOptions.getConsumptionGasUnit().getState() == 0 && unitmasterViewOptions.getConsumptionPetrolUnit().getState() == 0) {
            ASLCarContainer.functionExistent[17] = false;
        } else {
            if (!ASLCarContainer.functionExistent[17]) {
                ASLCarContainer.functionExistent[17] = true;
            }
            if (unitmasterViewOptions.getDistanceUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getDistanceUnit().getReason());
            }
            if (unitmasterViewOptions.getPressureUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getPressureUnit().getReason());
            }
            if (unitmasterViewOptions.getSpeedUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getSpeedUnit().getReason());
            }
            if (unitmasterViewOptions.getTemperatureUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getTemperatureUnit().getReason());
            }
            if (unitmasterViewOptions.getVolumeUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getVolumeUnit().getReason());
            }
            if (unitmasterViewOptions.getConsumptionGasUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getConsumptionGasUnit().getReason());
            }
            if (unitmasterViewOptions.getConsumptionPetrolUnit().getState() != 2) {
                this.collectingReason(unitmasterViewOptions.getConsumptionPetrolUnit().getReason());
            }
            ASLCarContainer.collector[17] = new CarFunctionCollector(false, this.gettingHighestReason());
            this.clearReasons();
        }
        this.myTarget.informHmi();
    }

    private void checkingViewOptions() {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: clockViewOptions: ").append(this.myClockViewOptions.toString()).append(" unitMasterViewOptions: ").append(this.myUnitMasterViewOptions.toString()).log();
        }
        if (this.myClockViewOptions.getTime().getState() == 2 || this.myClockViewOptions.getDate().getState() == 2 || this.myClockViewOptions.getTimeZone().getState() == 2 || this.myClockViewOptions.getDayLightSaving().getState() == 2 || this.myClockViewOptions.getDayLightSavingData().getState() == 2 || this.myClockViewOptions.getClockSource().getState() == 2 || this.myClockViewOptions.getGpsSyncData().getState() == 2 || this.myUnitMasterViewOptions.getClockFormat().getState() == 2 || this.myUnitMasterViewOptions.getDateFormat().getState() == 2) {
            if (!ASLCarContainer.functionExistent[16]) {
                ASLCarContainer.functionExistent[16] = true;
            }
            ASLCarContainer.collector[16] = new CarFunctionCollector(true, 0);
        } else if (this.myClockViewOptions.getTime().getState() == 0 && this.myClockViewOptions.getDate().getState() == 0 && this.myClockViewOptions.getTimeZone().getState() == 0 && this.myClockViewOptions.getDayLightSaving().getState() == 0 && this.myClockViewOptions.getDayLightSavingData().getState() == 0 && this.myClockViewOptions.getClockSource().getState() == 0 && this.myClockViewOptions.getGpsSyncData().getState() == 0 && this.myUnitMasterViewOptions.getClockFormat().getState() == 0 && this.myUnitMasterViewOptions.getDateFormat().getState() == 0) {
            ASLCarContainer.functionExistent[16] = false;
        } else {
            if (!ASLCarContainer.functionExistent[16]) {
                ASLCarContainer.functionExistent[16] = true;
            }
            if (this.myClockViewOptions.getTime().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getTime().getReason());
            }
            if (this.myClockViewOptions.getDate().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDate().getReason());
            }
            if (this.myClockViewOptions.getTimeZone().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getTimeZone().getReason());
            }
            if (this.myClockViewOptions.getDayLightSaving().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDayLightSaving().getReason());
            }
            if (this.myClockViewOptions.getDayLightSavingData().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getDayLightSavingData().getReason());
            }
            if (this.myClockViewOptions.getClockSource().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getClockSource().getReason());
            }
            if (this.myClockViewOptions.getGpsSyncData().getState() != 2) {
                this.collectingReason(this.myClockViewOptions.getGpsSyncData().getReason());
            }
            if (this.myUnitMasterViewOptions.getClockFormat().getState() != 2) {
                this.collectingReason(this.myUnitMasterViewOptions.getClockFormat().getReason());
            }
            if (this.myUnitMasterViewOptions.getDateFormat().getState() != 2) {
                this.collectingReason(this.myUnitMasterViewOptions.getDateFormat().getReason());
            }
            ASLCarContainer.collector[16] = new CarFunctionCollector(false, this.gettingHighestReason());
            this.clearReasons();
        }
        this.myTarget.informHmi();
    }

    public void dsiCarEcoUpdateStartStopViewOptions(StartStopViewOptions startStopViewOptions, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: startStopViewOptions: ").append(startStopViewOptions.toString()).log();
        }
        if (this.notificationList.contains(21)) {
            this.notificationList.removeValue(21);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        if (startStopViewOptions.getStartStopProhibitReasonList().getState() == 0 || startStopViewOptions.getStartStopRestartProhibitReasonList().getState() == 0 || startStopViewOptions.getStartStopRestartReasonList().getState() == 0 || startStopViewOptions.getState().getState() == 0) {
            ASLCarContainer.functionExistent[7] = false;
        } else {
            if (!ASLCarContainer.functionExistent[7]) {
                ASLCarContainer.functionExistent[7] = true;
            }
            if (startStopViewOptions.getStartStopProhibitReasonList().getState() == 2 && startStopViewOptions.getStartStopRestartProhibitReasonList().getState() == 2 && startStopViewOptions.getStartStopRestartReasonList().getState() == 2 && startStopViewOptions.getState().getState() == 2) {
                ASLCarContainer.collector[7] = new CarFunctionCollector(true, 0);
                try {
                    EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.myTarget.getTargetId(), -2024861184, 554377216);
                    this.myTarget.send(eventGeneric);
                }
                catch (GenericEventException genericEventException) {
                    this.myTarget.error("Not able to send event to CarService!");
                }
            } else {
                if (startStopViewOptions.getStartStopProhibitReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopProhibitReasonList().getReason());
                }
                if (startStopViewOptions.getStartStopRestartProhibitReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopRestartProhibitReasonList().getReason());
                }
                if (startStopViewOptions.getStartStopRestartReasonList().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getStartStopRestartReasonList().getReason());
                }
                if (startStopViewOptions.getState().getState() != 2) {
                    this.collectingReason(startStopViewOptions.getState().getReason());
                }
                ASLCarContainer.collector[7] = new CarFunctionCollector(false, this.gettingHighestReason());
                this.clearReasons();
            }
        }
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_VEHICLE_STATUS, 108, ASLCarContainer.collector, ASLCarContainer.functionExistent);
        this.myTarget.parentChildRelation(FunctionIds.CHILD_VEHICLESTATUS, 3, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarKombiUpdateHUDViewOptions(HUDViewOptions hUDViewOptions, int n) {
        if (this.notificationList.contains(24)) {
            this.notificationList.removeValue(24);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        if (!hUDViewOptions.getConfiguration().isAcc()) {
            ASLCarContainer.functionExistent[160] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 160, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isEfficiencyAssist()) {
            // empty if block
        }
        if (!hUDViewOptions.getConfiguration().isHca()) {
            ASLCarContainer.functionExistent[166] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 166, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isInfoList()) {
            ASLCarContainer.functionExistent[165] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 165, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isNavInfo()) {
            ASLCarContainer.functionExistent[164] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 164, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isNightvision()) {
            ASLCarContainer.functionExistent[161] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 161, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isRgi()) {
            ASLCarContainer.functionExistent[163] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 163, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isRoadsign()) {
            ASLCarContainer.functionExistent[162] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 162, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isSpeed()) {
            ASLCarContainer.functionExistent[158] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 158, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isTelephone()) {
            ASLCarContainer.functionExistent[168] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 168, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isWarning()) {
            ASLCarContainer.functionExistent[159] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 159, hUDViewOptions.getContent().getReason());
        }
        if (!hUDViewOptions.getConfiguration().isGra()) {
            ASLCarContainer.functionExistent[167] = false;
        } else {
            this.evaluateViewOptions(hUDViewOptions.getContent().getState(), 167, hUDViewOptions.getContent().getReason());
        }
        if (hUDViewOptions.getConfiguration().isColourAlternative() && hUDViewOptions.getConfiguration().isColourDefault()) {
            this.evaluateViewOptions(hUDViewOptions.getColour().getState(), 189, hUDViewOptions.getColour().getReason());
        } else {
            this.evaluateViewOptions(0, 189, hUDViewOptions.getColour().getReason());
        }
        this.evaluateViewOptions(hUDViewOptions.getBrightness().getState(), 157, hUDViewOptions.getBrightness().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_HUD, 188, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarDrivingCharacteristicsUpdateCharismaViewOptions(CharismaViewOptions charismaViewOptions, int n) {
        this.evaluateViewOptions(charismaViewOptions.getActiveOperationMode().getState(), 139, charismaViewOptions.getActiveOperationMode().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_HYBRID_MODE, 139, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiCarEcoUpdateEAViewOptions(EAViewOptions eAViewOptions, int n) {
        if (this.notificationList.contains(34)) {
            this.notificationList.removeValue(34);
        }
        if (!this.myTarget.standStillNotificationDone && this.notificationList.size() == 0) {
            this.myTarget.registerOnCarSpeedThreshold();
        }
        this.evaluateViewOptions(eAViewOptions.getSystem().getState(), 193, eAViewOptions.getSystem().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_ASSISTANTS_DRIVING, 9, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    public void dsiGeneralVehicleStatesUpdateCarVelocityThreshold(boolean bl, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: Threshold: ").append(bl).log();
        }
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: car threshold: ").append(bl).log();
        }
        this.myTarget.evaluateCarFunctionSpeedThreshold(bl);
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: esp data: ").append(bl).log();
        }
        if (this.rememberLastValueStandStill == -1) {
            int n2 = this.rememberLastValueStandStill = bl ? 0 : 1;
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.myTarget.evaluateCarFunctionStandStill(bl);
        } else if (this.rememberLastValueStandStill == 0 && !bl) {
            this.rememberLastValueStandStill = 1;
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.myTarget.evaluateCarFunctionStandStill(bl);
        } else if (this.rememberLastValueStandStill == 1 && bl) {
            this.rememberLastValueStandStill = 0;
            if (this.myTarget.isTraceEnabled()) {
                this.myTarget.trace().append("VIEWOPTIONS: car standstill: ").append(bl).log();
            }
            this.myTarget.evaluateCarFunctionStandStill(bl);
        } else if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("VIEWOPTIONS: car standstill: same value as previous update ").append(bl).log();
        }
    }

    private void evaluateBatteryControl(BatteryControlViewOptions batteryControlViewOptions) {
    }

    private void evaluateHybrid(HybridViewOptions hybridViewOptions) {
        this.evaluateViewOptions(hybridViewOptions.getHybridTargetRange().getState(), 186, hybridViewOptions.getHybridTargetRange().getReason());
        this.evaluateViewOptions(hybridViewOptions.getHybridActivePedal().getState(), 213, hybridViewOptions.getHybridActivePedal().getReason());
        this.myTarget.parentChildRelation(FunctionIds.CHILD_CAR_BATTERY_MANAGEMENT, 187, ASLCarContainer.collector, ASLCarContainer.functionExistent);
    }

    private int carViewOptionsReason(int n) {
        switch (n) {
            case 1: {
                this.functionReason = 1;
                break;
            }
            case 3: {
                this.functionReason = 3;
                break;
            }
            case 2: {
                this.functionReason = 2;
                break;
            }
            case 4: {
                this.functionReason = 4;
                break;
            }
            case 8: {
                this.functionReason = 5;
                break;
            }
            case 13: {
                this.functionReason = 7;
                break;
            }
            default: {
                this.functionReason = 6;
            }
        }
        return this.functionReason;
    }

    private void collectingReason(int n) {
        switch (n) {
            case 2: {
                this.reasons[0] = 2;
                break;
            }
            case 3: {
                this.reasons[1] = 3;
                break;
            }
            case 4: {
                this.reasons[2] = 4;
                break;
            }
            case 8: {
                this.reasons[3] = 5;
                break;
            }
            case 1: {
                this.reasons[4] = 1;
                break;
            }
            default: {
                this.reasons[5] = 6;
            }
        }
    }

    private int gettingHighestReason() {
        int n = 0;
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            if (this.reasons[i2] == 0) continue;
            n = this.reasons[i2];
            break;
        }
        return n;
    }

    private void clearReasons() {
        for (int i2 = 0; i2 < this.reasons.length; ++i2) {
            this.reasons[i2] = 0;
        }
    }

    protected void evaluateViewOptions(CarViewOption carViewOption, int n) {
        if (carViewOption == null) {
            this.evaluateViewOptions(0, n, 0);
        } else {
            this.evaluateViewOptions(carViewOption.getState(), n, carViewOption.getReason());
        }
    }

    private void evaluateViewOptionsRGBColorList(IntLightViewOptions intLightViewOptions) {
        CarViewOption carViewOption = intLightViewOptions.getIntLightRGBColorList();
        CarViewOption carViewOption2 = intLightViewOptions.getIntLightAmbientLightColor();
        this.evaluateViewOptions(carViewOption, 218);
        if (carViewOption.getState() == 2 && (carViewOption2 == null || carViewOption2.getState() != 2)) {
            this.evaluateViewOptions(carViewOption2, 218);
        }
    }

    protected void evaluateViewOptions(int n, int n2, int n3) {
        if (n == 0) {
            ASLCarContainer.functionExistent[n2] = false;
        } else {
            if (!ASLCarContainer.functionExistent[n2]) {
                ASLCarContainer.functionExistent[n2] = true;
            }
            if (ASLCarContainer.collector[n2].functionReason != 7 || ASLCarContainer.collector[n2].functionReason != 3) {
                if (!this.myTarget.isStandStillActive) {
                    this.myTarget.evaluateCarFunctionStandStill(this.myTarget.isStandStillActive);
                }
                if (this.myTarget.isSpeedToHighActive) {
                    this.myTarget.evaluateCarFunctionSpeedThreshold(this.myTarget.isSpeedToHighActive);
                }
            }
            ASLCarContainer.collector[n2] = new CarFunctionCollector(n == 2, this.carViewOptionsReason(n3));
        }
    }

    private void startingEcoConsumers() {
        if (this.isClamp15Active) {
            this.myTarget.startTimer(-1534721792, (long)0, false);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10132, true);
    }

    private void startingVehicleStatus() {
        if (this.isClamp15Active) {
            this.myTarget.startTimer(-1517944576, (long)0, false);
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(10265, true);
        this.isInitializing = true;
        ASLCarFactory.getCarVehicleApi().getVehicleService().updateInitState(this.isInitializing);
    }

    private void myNotifications() {
        this.myTarget.registerOnPowerManagement();
        this.myTarget.registerOnCarAuxHeaterCooler();
    }

    public static DeviceManagerInterface getDeviceManager() {
        if (dm == null) {
            try {
                dm = new DeviceManager(ServiceManager.eventMain, "hsmtask");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return dm;
    }

    @Override
    public void onFactoryResetStateChanged(int n) {
        if (n == 0 && this.resetIsDirty) {
            this.resetIsDirty = false;
            this.resetService.reset(FactoryResetComponents.CAR, 0);
        }
    }

    public void onSuccess_funcAdap(Access access) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("reading CarFuncAdap values").log();
        }
        this.configManPersCarFuncAdapImpl = access;
        this.carMenuAvailability();
        this.readingAdaptation = true;
        this.consumeValues();
    }

    private void consumeValues() {
        if (this.readingCODING && this.readingAdaptation) {
            this.readDevicesConfig();
            this.readingAdaptation = false;
            this.readingCODING = false;
            this.myNotifications();
            this.evaluateVzeVza();
        }
    }

    public void onSuccess_coding(Access access) {
        if (this.myTarget.isTraceEnabled()) {
            this.myTarget.trace().append("reading coding values").log();
        }
        this.confManPersCoding = access;
        this.codingAll();
        this.readingCODING = true;
        this.consumeValues();
    }

    static {
        isCompass = false;
        isNavi = false;
        isPoloCoded = false;
        AMBIENCE_LIGHT_FEATURE_CUPHOLDER_STRIP = 0;
        AMBIENCE_LIGHT_FEATURE_COCKPIT = 1;
        AMBIENCE_LIGHT_FEATURE_DOORS = 2;
        AMBIENCE_LIGHT_FEATURE_HANDLE = 3;
        AMBIENCE_LIGHT_FEATURE_RECTANGLE = 4;
        AMBIENCE_LIGHT_FEATURE_FOOTWELL = 5;
        AMBIENCE_LIGHT_FEATURE_ROOF = 6;
        AMBIENCE_LIGHT_FEATURE_FRONT_SLIDER = 7;
        AMBIENCE_LIGHT_FEATURE_FRONT_DOOR_POCKET = 8;
        AMBIENCE_LIGHT_FEATURE_FRONT_DOORS_ENTRANCE = 9;
        AMBIENCE_LIGHT_FEATURE_FRONT_CLIMATE_CONTROL_STRIP = 10;
        AMBIENCE_LIGHT_FEATURE_GEAR_SHIFT = 11;
        AMBIENCE_LIGHT_FEATURE_CENTER_CONTROL_LIGHTING_FRONT = 12;
        AMBIENCE_LIGHT_FEATURE_NAVI_DEVICE_STRIP = 13;
        AMBIENCE_LIGHT_FEATURE_PREMIUMSOUND = 14;
        AMBIENCE_LIGHT_FEATURE_REAR_FOOTWELL = 15;
        AMBIENCE_LIGHT_FEATURE_REAR_DOORS = 16;
        AMBIENCE_LIGHT_FEATURE_REAR_DOORS_WARNING = 17;
        AMBIENCE_LIGHT_FEATURE_REAR_DOORS_ENTRANCE = 18;
        AMBIENCE_LIGHT_FEATURE_REAR_DOORS_STRIP = 19;
        AMBIENCE_LIGHT_FEATURE_REAR_DOOR_POCKET = 20;
        AMBIENCE_LIGHT_FEATURE_REAR_ROOF = 21;
        AMBIENCE_LIGHT_FEATURE_SUNROOF_STRIP = 22;
    }
}

