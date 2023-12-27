/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service;

import de.vw.mib.asl.api.car.logger.CarLogger;
import de.vw.mib.asl.api.car.rdk.RDKService;
import de.vw.mib.asl.api.car.rdk.RDKServiceListener;
import de.vw.mib.asl.api.car.vehicle.VehicleService;
import de.vw.mib.asl.api.car.vehicle.VehicleServiceListener;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.car.persistence.CarPersistenceServiceImpl;
import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.ASLCarContainer;
import de.vw.mib.asl.internal.car.ASLCarUtil;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import de.vw.mib.asl.internal.car.service.HsmTargetCarService$ValetParkingSystemServiceListenerAdaper;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateContext;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.VehicleStateController;
import de.vw.mib.asl.internal.car.srv.comfort.impl.ComfortViewOptionServiceImpl;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.car.service.ASLCarServicePropertyManager;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceCurrentSpeedCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSSnowTireWarningCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceRDKSTiresCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAOilCollector;
import generated.de.vw.mib.asl.internal.car.service.transformer.CarServiceSIAServiceCollector;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carcomfort.DSICarComfort;
import org.dsi.ifc.carcomfort.RDKTireDisplayData;
import org.dsi.ifc.carcomfort.RDKTireInfo;
import org.dsi.ifc.carcomfort.RDKViewOptions;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics;
import org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlViewOptions;
import org.dsi.ifc.careco.DSICarEco;
import org.dsi.ifc.careco.DSICarEcoListener;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.carkombi.BCSpeedWarningSettings;
import org.dsi.ifc.carkombi.BCVehicleStateUpdateInfoAH;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.carkombi.ListDynValues;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;
import org.dsi.ifc.carkombi.SIAOilInspection;
import org.dsi.ifc.carkombi.SIAServiceData;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public class HsmTargetCarService
extends AbstractASLTarget
implements CarLogger,
VehicleStateContext,
VehicleService,
RDKService,
DSIServiceStateListener {
    private DSICarComfort dsiCarComfort;
    private DSICarKombi dsiCarKombi;
    private DSICarKombiListener dsiCarKombiListener;
    private DSICarVehicleStates dsiCarVehicleStates;
    private DSICarEco dsiCarEco;
    private DSICarEcoListener notificationEco;
    private VehicleStateController _vehicleStateController;
    private DSICarDrivingCharacteristics dsiCarDrivingCharacteristics;
    private DSICarDrivingCharacteristicsListener dsiCarDrivingCharacteristicsListener;
    private DSIPowerManagement dsiPowerManagement;
    private DSIPowerManagementListener dsiPowerManagementListener;
    private static final int EV_RDK_PRESSURE_CHANGE_TIME_OUT;
    private static final int EV_START_STOP_TIME_OUT;
    private static final int EV_START_OIL_LEVEL_CLAMP_TIME_OUT;
    private static final int EV_TIME_OUT_RDK;
    private Boolean[] rdkClampState = new Boolean[]{Boolean.FALSE, Boolean.FALSE};
    private int[] rdksTires;
    private static int RDK_CLAMP_STATE_CLAMP;
    private static int RDK_CLAMP_STATE_INIT;
    private int hmiID;
    private final CarServiceSIAOilCollector siaOilCollector = new CarServiceSIAOilCollector();
    private final CarServiceSIAServiceCollector siaServiceCollector = new CarServiceSIAServiceCollector();
    private final CarServiceRDKSTiresCollector rdksTiresCollector = new CarServiceRDKSTiresCollector();
    private int requiredPressure;
    private int[] decimalValues;
    private final CarServiceRDKSSnowTireWarningCollector rdksSnowWarningTire = new CarServiceRDKSSnowTireWarningCollector();
    private final CarServiceCurrentSpeedCollector currentSpeedCollector = new CarServiceCurrentSpeedCollector();
    private boolean startStopProhibitReasonNoticeRequested = false;
    private boolean startStopProhibitReasonNoticeReasonReceived = false;
    private boolean startStopSystemFailureReasonNoticeRequested = false;
    private boolean startStopRestartReasonNoticeRequested = false;
    private boolean startStopRestartProhibitReasonNoticeRequested = false;
    private boolean startStopRestartProhibitReasonNoticeReasonReceived = false;
    private boolean startStopSystemFailureReasonNoticeReceived = false;
    public boolean isButtonStartStopNoticeHighlighted = false;
    private boolean isStandstill = true;
    private boolean vehicleMoved = false;
    private HsmTargetCarService$ValetParkingSystemServiceListenerAdaper valetParkingSystemServiceListenerAdaper;
    private int rdkSystemModelValue = 0;
    public static final int SLOT_NUMBER_P0_THE_NUMBER_WITHIN_A_FLOAT_OR_DOUBLE_THAT_IS_JUST_BEFORE_THE_DOT_OR_COMMA_INTEGER;
    public static final int SLOT_NUMBER_P1_THE_NUMBER_WITHIN_A_FLOAT_OR_DOUBLE_THAT_IS_JUST_AFTER_THE_DOT_OR_COMMA_INTEGER;
    private static final double COEFFICIENT;
    private static final int PRECISION;
    private Integer[] startStopProhibitList = new Integer[0];
    private Integer[] restartStopProhibitList = new Integer[0];
    private int allElementsStartStopProhibitReasons = 0;
    private int allElementsRestartStopReasons = 0;
    private boolean startStopProhibitReasonList = false;
    private StartStopListUpdateInfo startStopProhibitListUpdateInfo;
    private StartStopListUpdateInfo startStopRestartProhibitList;
    private boolean startStopRestartProhibitReasonList = false;
    private StartStopListUpdateInfo startStopRestartReason;
    private boolean startStopRestartReasonList = false;
    private boolean RDKS_SPEEDWARNING_ACTIVE;
    private int SPEED_WARNING_VALUE;
    private int SPEED_WARNING_UNIT;
    private int TRANSACTION_RESTARTSTOP;
    private int TRANSACTION_STARTSTOPPROHIBITREASON;
    private int TRANSACTION_STARTSTOPRESTARTREASON;
    private static final int MAX_NUMBER_TO_REQUEST_START_STOP;
    private boolean requestingStartStopProhibitReasonList = false;
    private boolean requestingStartStopRestartProhibitReasonList = false;
    private static final int OFF_SET;
    private static final int TRANSFORMATION_FACTOR_OIL_REFILL;
    private boolean carJackMode;
    private boolean carLiftMode;
    private boolean isClamp15Active = false;
    private boolean isInitializing = false;
    private final int OIL_LEVEL_CLAMP_TIME_OUT_LENGTH;
    private int oilLevelViewOptionState = 0;
    private final int SNOW_TIRE_VALUE_KMPH_MIN;
    private final int SNOW_TIRE_VALUE_MPH_MIN;
    private boolean isValetParkingActive;
    private boolean isValetParkingAvailable;
    private int warningCount;
    private boolean pressureLevelAvailable = true;
    private int currentRDKSystem = -1;
    private CarViewOption currentRDKTireDisplay;
    private boolean isRDKSystemActive;
    private int oilLevel;
    private int oilWarning;
    private int oilRefillQuantity;
    private int oilRefillUnit;
    private int oilLevelAvailability;
    private boolean stopProhibitNoticeRequestStored;
    private boolean systemErrorNoticeRequestStored;
    private int carGearType = 0;
    private int automaticGearShiftTransMode = 0;
    private int clutchState = 0;
    private int parkingBrakeState;
    private int oilLevelAvailabilityReason = 0;
    private int rdkAvailaibiltyReason = 0;
    private boolean[] carStatusTileFunctionExistence = new boolean[]{false, false};
    private boolean[] carStatusTileFunctionAvailability = new boolean[]{false, false};
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfort;
    static /* synthetic */ Class class$org$dsi$ifc$carcomfort$DSICarComfortListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombiListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEco;
    static /* synthetic */ Class class$org$dsi$ifc$careco$DSICarEcoListener;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics;
    static /* synthetic */ Class class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagementListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$VehicleService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$rdk$RDKService;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$rdk$RDKServiceListener;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener;

    public HsmTargetCarService(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.OIL_LEVEL_CLAMP_TIME_OUT_LENGTH = 3000;
        this.SNOW_TIRE_VALUE_KMPH_MIN = 30;
        this.SNOW_TIRE_VALUE_MPH_MIN = 20;
    }

    @Override
    public int getDefaultTargetId() {
        return -2024861184;
    }

    @Override
    public int getSubClassifier() {
        return 1;
    }

    private void registerOnModelEvents() {
        this.addObservers(new int[]{1376518208, 1309409344, 1342963776, 1326186560, -418643904, 1359740992, 437059648, 453836864, 739049536, -502595520, 1057292352, 1040515136, 1460469824});
    }

    private void registerCalibrateButton() {
        this.addObserver(1292632128);
    }

    private void clearCalibrateButton() {
        this.removeObserver(1292632128);
    }

    private void registerOnInternalEvents() {
        this.registerService(554377216);
    }

    private void registerOnCarComfort() {
        this.dsiCarComfort = (DSICarComfort)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carcomfort$DSICarComfort == null ? (class$org$dsi$ifc$carcomfort$DSICarComfort = HsmTargetCarService.class$("org.dsi.ifc.carcomfort.DSICarComfort")) : class$org$dsi$ifc$carcomfort$DSICarComfort);
        this.dsiCarComfort.setNotification(new int[]{37, 38, 62, 36, 33, 34, 35}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarService.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarService.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carcomfort$DSICarComfortListener == null ? (class$org$dsi$ifc$carcomfort$DSICarComfortListener = HsmTargetCarService.class$("org.dsi.ifc.carcomfort.DSICarComfortListener")) : class$org$dsi$ifc$carcomfort$DSICarComfortListener));
    }

    private void registerOnCarKombi() {
        this.dsiCarKombi.setNotification(new int[]{2, 3, 33, 41, 4}, (DSIListener)this.dsiCarKombiListener);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetCarService.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener, this.dsiCarKombiListener);
    }

    private void registerOnGeneralVehicleStates() {
        ASLCarContainer.getInstance().getDSIProxy().addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetCarService.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this);
    }

    private void registerOnCarVehicleStates() {
        this.dsiCarVehicleStates = (DSICarVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = HsmTargetCarService.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.dsiCarVehicleStates.setNotification(new int[]{2, 1, 4, 15, 13, 14}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener = HsmTargetCarService.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStatesListener")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStatesListener));
    }

    private void registerOnCarEco() {
        this.dsiCarEco = (DSICarEco)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$careco$DSICarEco == null ? (class$org$dsi$ifc$careco$DSICarEco = HsmTargetCarService.class$("org.dsi.ifc.careco.DSICarEco")) : class$org$dsi$ifc$careco$DSICarEco);
        this.notificationEco = (DSICarEcoListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetCarService.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener);
        this.dsiCarEco.setNotification(new int[]{11, 7, 5, 9, 6, 10}, (DSIListener)this.notificationEco);
        ASLCarContainer.getInstance().getDSIProxy().addResponseListener(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetCarService.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$careco$DSICarEcoListener == null ? (class$org$dsi$ifc$careco$DSICarEcoListener = HsmTargetCarService.class$("org.dsi.ifc.careco.DSICarEcoListener")) : class$org$dsi$ifc$careco$DSICarEcoListener));
    }

    private void registerOnEcoStartStopState() {
        this.dsiCarEco.setNotification(new int[]{8}, (DSIListener)this.notificationEco);
    }

    private void removeOnEcoStartStopState() {
        this.dsiCarEco.clearNotification(new int[]{8}, (DSIListener)this.notificationEco);
    }

    private void registerOnCarDrivingCharacteristics() {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
            this.dsiCarDrivingCharacteristics = (DSICarDrivingCharacteristics)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics = HsmTargetCarService.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristics")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristics);
            this.dsiCarDrivingCharacteristicsListener = (DSICarDrivingCharacteristicsListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener == null ? (class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener = HsmTargetCarService.class$("org.dsi.ifc.cardrivingcharacteristics.DSICarDrivingCharacteristicsListener")) : class$org$dsi$ifc$cardrivingcharacteristics$DSICarDrivingCharacteristicsListener);
            this.dsiCarDrivingCharacteristics.setNotification(new int[]{2, 3, 1}, (DSIListener)this.dsiCarDrivingCharacteristicsListener);
        }
    }

    private void registerOnClampSignal() {
        this.dsiPowerManagement = (DSIPowerManagement)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = HsmTargetCarService.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        this.dsiPowerManagementListener = (DSIPowerManagementListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$powermanagement$DSIPowerManagementListener == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagementListener = HsmTargetCarService.class$("org.dsi.ifc.powermanagement.DSIPowerManagementListener")) : class$org$dsi$ifc$powermanagement$DSIPowerManagementListener);
        this.dsiPowerManagement.setNotification(new int[]{4}, (DSIListener)this.dsiPowerManagementListener);
    }

    private void registerAsServiceProvider() {
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$vehicle$VehicleService == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleService = HsmTargetCarService.class$("de.vw.mib.asl.api.car.vehicle.VehicleService")) : class$de$vw$mib$asl$api$car$vehicle$VehicleService, this);
        ServiceFactory.getInstance().getServiceProviderRegistry().registerServiceProvider(class$de$vw$mib$asl$api$car$rdk$RDKService == null ? (class$de$vw$mib$asl$api$car$rdk$RDKService = HsmTargetCarService.class$("de.vw.mib.asl.api.car.rdk.RDKService")) : class$de$vw$mib$asl$api$car$rdk$RDKService, this);
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        if (this.isTraceEnabled()) {
            this.trace().append("Event received CAR SERVICE: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                this.dsiCarKombi = (DSICarKombi)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = HsmTargetCarService.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
                this.dsiCarKombiListener = (DSICarKombiListener)ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$carkombi$DSICarKombiListener == null ? (class$org$dsi$ifc$carkombi$DSICarKombiListener = HsmTargetCarService.class$("org.dsi.ifc.carkombi.DSICarKombiListener")) : class$org$dsi$ifc$carkombi$DSICarKombiListener);
                this.registerOnCarComfort();
                this.registerOnCarKombi();
                this.registerOnCarVehicleStates();
                this.registerOnGeneralVehicleStates();
                this.registerOnCarEco();
                this.registerOnEcoStartStopState();
                this.registerOnModelEvents();
                this.registerCalibrateButton();
                this.registerOnInternalEvents();
                this.registerOnCarDrivingCharacteristics();
                this.initDefaultValues();
                this.registerOnClampSignal();
                this.registerSystemService();
                this.registerAsServiceProvider();
                this.resetStartStopNoticeRequested();
                break;
            }
            case 1073744978: {
                if (this.isTraceEnabled()) {
                    this.trace().append("resetting oil").log();
                }
                this.dsiCarKombi.resetSIAValue(3);
                break;
            }
            case 1073744974: {
                this.dsiCarKombi.setBCSpeedWarning(new BCSpeedWarningSettings(!this.RDKS_SPEEDWARNING_ACTIVE, this.SPEED_WARNING_VALUE, this.checkSpeedWarningUnitHMI(this.SPEED_WARNING_UNIT)));
                break;
            }
            case 1073744976: {
                this.deIncreaseRDKSSnowTireWarning(eventGeneric.getBoolean(0), eventGeneric.getInt(1), eventGeneric.getInt(2));
                break;
            }
            case 1073744975: {
                this.sendingSpeedWarningsSettings(ASLCarUtil.roundedValue(eventGeneric.getInt(0), this.SPEED_WARNING_UNIT, this.SPEED_WARNING_VALUE > eventGeneric.getInt(0)));
                break;
            }
            case 1073744973: {
                this.sendingPressureChange();
                break;
            }
            case 1073745127: {
                this.toggleRDKSLoad(eventGeneric.getInt(0));
                break;
            }
            case 1073744977: {
                this.dsiCarComfort.setRDKTireSetupSelectedTire(eventGeneric.getInt(0) + 1);
                break;
            }
            case 2100001: {
                this.requestingStartStopLists();
                break;
            }
            case 100100: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CAR SERVICE: we have a problem! Sending Error to HMI and register on model event").log();
                }
                this.sendHMIEvent(10011);
                this.registerCalibrateButton();
                break;
            }
            case 100101: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CAR SERVICE: timer is over and lists are empty ... register on start stop state").log();
                }
                if (this.restartStopProhibitList.length != 0 && this.startStopProhibitList.length != 0 && !this.requestingStartStopProhibitReasonList && !this.requestingStartStopRestartProhibitReasonList) break;
                this.registerOnEcoStartStopState();
                break;
            }
            case 100102: {
                if (this.isTraceEnabled()) {
                    this.trace().append("CAR SERVICE: clamp 15 timer stopped").log();
                }
                this.evaluateOilLevelAvailability();
                break;
            }
            case 1073745178: {
                this.dsiCarDrivingCharacteristics.setSuspensionControlCarJackMode(!this.carJackMode);
                break;
            }
            case 1073745179: {
                this.dsiCarDrivingCharacteristics.setSuspensionControlLiftMode(!this.carLiftMode);
                break;
            }
            case 1073745196: {
                this.toggleButtonStartStopNotice();
                break;
            }
            case 1073744866: {
                if (eventGeneric.getInt(0) != 0) break;
                this.resetStartStopNoticeButton();
                this.resetViewIds();
                break;
            }
            case 1073743167: {
                this.resetStartStopNoticeButton();
                this.resetViewIds();
                break;
            }
            case 1073743166: {
                if (eventGeneric.getInt(0) != 2) break;
                this.resetStartStopNoticeButton();
                this.resetViewIds();
                break;
            }
            case 100103: {
                this.evaluateRDKViewOptions();
                break;
            }
            case 1073745239: {
                int n = eventGeneric.getInt(0);
                int n2 = eventGeneric.getInt(1);
                CarEarly carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
                carEarly.setLastMainViewId(n);
                carEarly.setLastSubViewId(n2);
                HsmTargetCarService.writeIntegerToDatapool(10896, n);
                HsmTargetCarService.writeIntegerToDatapool(10897, n2);
                break;
            }
        }
    }

    private void resetViewIds() {
        CarEarly carEarly = CarEarlyPersistenceServiceImpl.getInstance().loadCarEarly();
        carEarly.setLastMainViewId(-1);
        carEarly.setLastSubViewId(-1);
        HsmTargetCarService.writeIntegerToDatapool(10896, -1);
        HsmTargetCarService.writeIntegerToDatapool(10897, -1);
    }

    private void registerSystemService() {
        this.valetParkingSystemServiceListenerAdaper = new HsmTargetCarService$ValetParkingSystemServiceListenerAdaper(this);
        ASLSystemFactory.getSystemApi().getValetParkingService().addListener(this.valetParkingSystemServiceListenerAdaper);
        HsmTargetCarService.writeBooleanToDatapool(10668, ASLSystemFactory.getSystemApi().getValetParkingService().getCurrentValetParkingState());
    }

    private int checkSpeedWarningUnitHMI(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            default: {
                this.error("Can not evaluate HMI value!");
            }
        }
        return this.hmiID;
    }

    private void deIncreaseRDKSSnowTireWarning(boolean bl, int n, int n2) {
        if (bl) {
            if (ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n) <= n2 && ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n = this.stepSize(n, bl)) <= n2) {
                if (this.isTraceEnabled()) {
                    this.trace().append("modify the snow warning: ").append(ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n)).log();
                }
                this.sendingSpeedWarningsSettings(ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n));
            }
        } else if (ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n) >= n2 && ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n = this.stepSize(n, bl)) >= n2) {
            if (this.isTraceEnabled()) {
                this.trace().append("modify the snow warning: ").append(ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n)).log();
            }
            this.sendingSpeedWarningsSettings(ASLCarUtil.incDecValueInStepSize(bl, this.SPEED_WARNING_VALUE, n));
        }
    }

    private int stepSize(int n, boolean bl) {
        int n2 = this.SPEED_WARNING_VALUE % 10;
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                if (this.SPEED_WARNING_UNIT == 1) {
                    n = bl ? 5 - n2 : n2;
                    break;
                }
                n = bl ? 10 - n2 : n2;
                break;
            }
            case 5: {
                if (this.SPEED_WARNING_UNIT == 1 || this.SPEED_WARNING_UNIT != 0) break;
                n = 5;
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                if (this.SPEED_WARNING_UNIT == 1) {
                    n = bl ? 10 - n2 : n2 - 5;
                    break;
                }
                n = bl ? 10 - n2 : n2;
                break;
            }
        }
        return n;
    }

    private void sendingSpeedWarningsSettings(int n) {
        this.dsiCarKombi.setBCSpeedWarning(new BCSpeedWarningSettings(this.RDKS_SPEEDWARNING_ACTIVE, n, this.checkSpeedWarningUnitHMI(this.SPEED_WARNING_UNIT)));
    }

    private void toggleRDKSLoad(int n) {
        if (!this.pressureLevelAvailable) {
            switch (n) {
                case 2: {
                    this.dsiCarComfort.setRDKSpeedLimit(1);
                    break;
                }
                case 1: {
                    this.dsiCarComfort.setRDKSpeedLimit(2);
                    break;
                }
                case 0: {
                    this.dsiCarComfort.setRDKSpeedLimit(3);
                    break;
                }
                default: {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CarService: RDKS load not implemented!").log();
                        break;
                    } else {
                        break;
                    }
                }
            }
        } else {
            switch (n) {
                case 2: {
                    this.dsiCarComfort.setRDKPressureLevel((byte)1);
                    break;
                }
                case 1: {
                    this.dsiCarComfort.setRDKPressureLevel((byte)2);
                    break;
                }
                case 0: {
                    this.dsiCarComfort.setRDKPressureLevel((byte)3);
                    break;
                }
                default: {
                    if (!this.isTraceEnabled()) break;
                    this.trace().append("CarService: RDKS load not implemented!").log();
                }
            }
        }
    }

    private void sendingPressureChange() {
        if (this.isTraceEnabled()) {
            this.trace().append("CAR SERVICE: we are starting timer for 7 seconds").log();
        }
        this.dsiCarComfort.setRDKPressureChanged();
        this.startTimer(75956480, (long)0, false);
        this.clearCalibrateButton();
    }

    private void evaluateOilLevelAvailability() {
        if (this.isClamp15Active) {
            if (this.getMainObject().getTimerServer().isTimerActive(this.getTargetId(), 109510912)) {
                HsmTargetCarService.writeIntegerToDatapool(10588, 2);
                this.oilLevelAvailability = 2;
                this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
            } else {
                switch (this.oilLevelViewOptionState) {
                    case 0: {
                        HsmTargetCarService.writeIntegerToDatapool(10588, 2);
                        this.oilLevelAvailability = 2;
                        this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
                        break;
                    }
                    case 1: {
                        HsmTargetCarService.writeIntegerToDatapool(10588, 3);
                        this.oilLevelAvailability = 3;
                        this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
                        break;
                    }
                    case 2: {
                        HsmTargetCarService.writeIntegerToDatapool(10588, 0);
                        this.oilLevelAvailability = 0;
                        this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
                        break;
                    }
                }
            }
        } else if (this.getMainObject().getTimerServer().isTimerActive(this.getTargetId(), 109510912)) {
            HsmTargetCarService.writeIntegerToDatapool(10588, 2);
            this.oilLevelAvailability = 2;
            this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
        } else {
            HsmTargetCarService.writeIntegerToDatapool(10588, 1);
            this.oilLevelAvailability = 1;
            this.getVehicleServiceListener().updateOilLevelAvailability(this.oilLevelAvailability);
        }
    }

    public void dsiCarComfortUpdateRDKTireDisplay(RDKTireDisplayData rDKTireDisplayData, int n) {
        this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = 0;
        this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = 0;
        this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear_decimal = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_unit = 0;
        this.rdksTiresCollector.car_service_rdks_tires_pressure_unit = this.checkTiresPressureUnit(rDKTireDisplayData.getWheelPressures().getPressureUnit());
        this.rdksTiresCollector.car_service_rdks_tire_status_front_left = this.checkTireStatusFrontLeft(rDKTireDisplayData.getWheelStates().getFrontLeft());
        this.rdksTiresCollector.car_service_rdks_tire_status_front_right = this.checkTireStatusFrontRight(rDKTireDisplayData.getWheelStates().getFrontRight());
        this.rdksTiresCollector.car_service_rdks_tire_status_rear_left = this.checkTireStatusRearLeft(rDKTireDisplayData.getWheelStates().getRearLeft());
        this.rdksTiresCollector.car_service_rdks_tire_status_rear_right = this.checkTireStatusRearRight(rDKTireDisplayData.getWheelStates().getRearRight());
        switch (rDKTireDisplayData.getWheelPressures().getPressureUnit()) {
            case 0: {
                if (rDKTireDisplayData.getWheelPressures().getFrontLeft() < 255) {
                    this.decimalValues = ASLCarUtil.double2IntArray((float)((double)rDKTireDisplayData.getWheelPressures().getFrontLeft() / 10.0), 1);
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left = this.decimalValues[0];
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left_decimal = this.decimalValues[1];
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getFrontRight() < 255) {
                    this.decimalValues = ASLCarUtil.double2IntArray((float)((double)rDKTireDisplayData.getWheelPressures().getFrontRight() / 10.0), 1);
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right = this.decimalValues[0];
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right_decimal = this.decimalValues[1];
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_right = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearLeft() < 255) {
                    this.decimalValues = ASLCarUtil.double2IntArray((float)((double)rDKTireDisplayData.getWheelPressures().getRearLeft() / 10.0), 1);
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left = this.decimalValues[0];
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left_decimal = this.decimalValues[1];
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearRight() < 255) {
                    this.decimalValues = ASLCarUtil.double2IntArray((float)((double)rDKTireDisplayData.getWheelPressures().getRearRight() / 10.0), 1);
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right = this.decimalValues[0];
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right_decimal = this.decimalValues[1];
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_right = this.checkTireCollectedState(5);
                }
                this.requiredPressure = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight());
                this.decimalValues = ASLCarUtil.double2IntArray((float)((double)this.requiredPressure / 10.0), 1);
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = this.decimalValues[0];
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front_decimal = this.decimalValues[1];
                this.requiredPressure = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getRearLeft(), rDKTireDisplayData.getRequiredWheelPressures().getRearRight());
                this.decimalValues = ASLCarUtil.double2IntArray((float)((double)this.requiredPressure / 10.0), 1);
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = this.decimalValues[0];
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear_decimal = this.decimalValues[1];
                this.requiredPressure = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight());
                this.decimalValues = ASLCarUtil.double2IntArray((float)((double)this.requiredPressure / 10.0), 1);
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = this.decimalValues[0];
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front_decimal = this.decimalValues[1];
                this.requiredPressure = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().rearLeft, rDKTireDisplayData.getRequiredWheelPressures().rearRight);
                this.decimalValues = ASLCarUtil.double2IntArray((float)((double)this.requiredPressure / 10.0), 1);
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = this.decimalValues[0];
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear_decimal = this.decimalValues[1];
                break;
            }
            case 1: {
                if (rDKTireDisplayData.getWheelPressures().getFrontLeft() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left = rDKTireDisplayData.getWheelPressures().getFrontLeft() / 2;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getFrontRight() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right = rDKTireDisplayData.getWheelPressures().getFrontRight() / 2;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_right = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearLeft() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left = rDKTireDisplayData.getWheelPressures().getRearLeft() / 2;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearRight() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right = rDKTireDisplayData.getWheelPressures().getRearRight() / 2;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_right = this.checkTireCollectedState(5);
                }
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight()) / 2;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getRearLeft(), rDKTireDisplayData.getRequiredWheelPressures().getRearRight()) / 2;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight()) / 2;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getRearLeft(), rDKTireDisplayData.getRequiredWheelPressures().getRearRight()) / 2;
                break;
            }
            case 2: {
                if (rDKTireDisplayData.getWheelPressures().getFrontLeft() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left = rDKTireDisplayData.getWheelPressures().getFrontLeft() * 10;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getFrontRight() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right = rDKTireDisplayData.getWheelPressures().getFrontRight() * 10;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_front_right = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearLeft() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left = rDKTireDisplayData.getWheelPressures().getRearLeft() * 10;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_left = this.checkTireCollectedState(5);
                }
                if (rDKTireDisplayData.getWheelPressures().getRearRight() < 255) {
                    this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right = rDKTireDisplayData.getWheelPressures().getRearRight() * 10;
                } else {
                    this.rdksTiresCollector.car_service_rdks_tire_status_rear_right = this.checkTireCollectedState(5);
                }
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight()) * 10;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getRearLeft(), rDKTireDisplayData.getRequiredWheelPressures().getRearRight()) * 10;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getFrontLeft(), rDKTireDisplayData.getRequiredWheelPressures().getFrontRight()) * 10;
                this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear = ASLCarUtil.checkRequiredPressure(rDKTireDisplayData.getRequiredWheelPressures().getRearLeft(), rDKTireDisplayData.getRequiredWheelPressures().getRearRight()) * 10;
                break;
            }
        }
        this.rdksTiresCollector.car_service_rdks_tires_status_collected = this.checkTireCollectedState(rDKTireDisplayData.getWheelStates().getCollectedState());
        Object[] objectArray = new CarServiceRDKSTiresCollector[]{this.rdksTiresCollector};
        ListManager.getGenericASLList(10266).updateList(objectArray);
        this.rdksTires = new int[]{this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front, this.rdksTiresCollector.car_service_rdks_tires_req_pressure_front_decimal, this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear, this.rdksTiresCollector.car_service_rdks_tires_req_pressure_rear_decimal, this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left, this.rdksTiresCollector.car_service_rdks_tires_pressure_front_left_decimal, this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right, this.rdksTiresCollector.car_service_rdks_tires_pressure_front_right_decimal, this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left, this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_left_decimal, this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right, this.rdksTiresCollector.car_service_rdks_tires_pressure_rear_right_decimal, this.rdksTiresCollector.car_service_rdks_tires_pressure_unit, this.rdksTiresCollector.car_service_rdks_tire_status_front_left, this.rdksTiresCollector.car_service_rdks_tire_status_front_right, this.rdksTiresCollector.car_service_rdks_tire_status_rear_left, this.rdksTiresCollector.car_service_rdks_tire_status_rear_right, this.rdksTiresCollector.car_service_rdks_tires_status_collected};
        this.getRDKServiceListener().updateRDKSTires(this.rdksTires);
    }

    private int checkTireStatusFrontLeft(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            case 2: {
                this.hmiID = 2;
                break;
            }
            case 3: {
                this.hmiID = 3;
                break;
            }
            case 4: {
                this.hmiID = 4;
                break;
            }
            case 5: {
                this.hmiID = 5;
                break;
            }
            case 6: {
                this.hmiID = 1;
                break;
            }
            case 14: {
                this.hmiID = 1;
                break;
            }
            case 23: {
                this.hmiID = 6;
                break;
            }
            default: {
                this.hmiID = 5;
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkTireStatusFrontRight(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            case 2: {
                this.hmiID = 2;
                break;
            }
            case 3: {
                this.hmiID = 3;
                break;
            }
            case 4: {
                this.hmiID = 4;
                break;
            }
            case 5: {
                this.hmiID = 5;
                break;
            }
            case 6: {
                this.hmiID = 1;
                break;
            }
            case 14: {
                this.hmiID = 1;
                break;
            }
            case 23: {
                this.hmiID = 6;
                break;
            }
            default: {
                this.hmiID = 5;
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkTireStatusRearLeft(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            case 2: {
                this.hmiID = 2;
                break;
            }
            case 3: {
                this.hmiID = 3;
                break;
            }
            case 4: {
                this.hmiID = 4;
                break;
            }
            case 5: {
                this.hmiID = 5;
                break;
            }
            case 6: {
                this.hmiID = 1;
                break;
            }
            case 14: {
                this.hmiID = 1;
                break;
            }
            case 23: {
                this.hmiID = 6;
                break;
            }
            default: {
                this.hmiID = 5;
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkTireStatusRearRight(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            case 2: {
                this.hmiID = 2;
                break;
            }
            case 3: {
                this.hmiID = 3;
                break;
            }
            case 4: {
                this.hmiID = 4;
                break;
            }
            case 5: {
                this.hmiID = 5;
                break;
            }
            case 6: {
                this.hmiID = 1;
                break;
            }
            case 14: {
                this.hmiID = 1;
                break;
            }
            case 23: {
                this.hmiID = 6;
                break;
            }
            default: {
                this.hmiID = 5;
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkTireCollectedState(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            case 2: {
                this.hmiID = 2;
                break;
            }
            case 3: {
                this.hmiID = 3;
                break;
            }
            case 4: {
                this.hmiID = 4;
                break;
            }
            case 5: 
            case 14: {
                this.hmiID = 5;
                break;
            }
            default: {
                this.hmiID = 5;
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkTiresPressureUnit(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 2;
                break;
            }
            case 2: {
                this.hmiID = 1;
                break;
            }
            default: {
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    public void dsiCarKombiUpdateSIAServiceData(SIAServiceData sIAServiceData, int n) {
        this.siaServiceCollector.car_service_sia_service_time_status = this.checkSIATimeStatus(sIAServiceData.getTimeStatus(), true);
        this.siaServiceCollector.car_service_sia_service_time_value = sIAServiceData.getTime();
        this.siaServiceCollector.car_service_sia_service_distance_status = this.checkSIADistanceStatus(sIAServiceData.getDistanceStatus(), true);
        this.siaServiceCollector.car_service_sia_service_distance_unit = this.checkSIADistanceUnit(sIAServiceData.getDistanceUnit(), true);
        this.siaServiceCollector.car_service_sia_service_distance_value = sIAServiceData.getDistance();
        Object[] objectArray = new CarServiceSIAServiceCollector[]{this.siaServiceCollector};
        ListManager.getGenericASLList(10267).updateList(objectArray);
    }

    public void dsiCarKombiUpdateSIAOilInspection(SIAOilInspection sIAOilInspection, int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("sia oil inspection").append(sIAOilInspection.toString()).log();
        }
        this.siaOilCollector.car_service_sia_oil_time_status = this.checkSIATimeStatus(sIAOilInspection.getTimeStatus(), false);
        this.siaOilCollector.car_service_sia_oil_time_value = sIAOilInspection.getTime();
        this.siaOilCollector.car_service_sia_oil_distance_status = this.checkSIADistanceStatus(sIAOilInspection.getDistanceStatus(), false);
        this.siaOilCollector.car_service_sia_oil_distance_unit = this.checkSIADistanceUnit(sIAOilInspection.getDistanceUnit(), false);
        this.siaOilCollector.car_service_sia_oil_distance_value = sIAOilInspection.getDistance();
        Object[] objectArray = new CarServiceSIAOilCollector[]{this.siaOilCollector};
        ListManager.getGenericASLList(10268).updateList(objectArray);
    }

    private int checkSIATimeStatus(int n, boolean bl) {
        switch (n) {
            case 0: {
                if (bl) {
                    this.hmiID = 0;
                    break;
                }
                this.hmiID = 0;
                break;
            }
            case 1: {
                if (bl) {
                    this.hmiID = 1;
                    break;
                }
                this.hmiID = 1;
                break;
            }
            case 2: {
                if (bl) {
                    this.hmiID = 2;
                    break;
                }
                this.hmiID = 2;
                break;
            }
            case 3: {
                if (bl) {
                    this.hmiID = 3;
                    break;
                }
                this.hmiID = 3;
                break;
            }
            default: {
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkSIADistanceStatus(int n, boolean bl) {
        switch (n) {
            case 0: {
                if (bl) {
                    this.hmiID = 0;
                    break;
                }
                this.hmiID = 0;
                break;
            }
            case 1: {
                if (bl) {
                    this.hmiID = 1;
                    break;
                }
                this.hmiID = 1;
                break;
            }
            case 2: {
                if (bl) {
                    this.hmiID = 2;
                    break;
                }
                this.hmiID = 2;
                break;
            }
            case 3: {
                if (bl) {
                    this.hmiID = 3;
                    break;
                }
                this.hmiID = 3;
                break;
            }
            default: {
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    private int checkSIADistanceUnit(int n, boolean bl) {
        switch (n) {
            case 0: {
                if (bl) {
                    this.hmiID = 0;
                    break;
                }
                this.hmiID = 0;
                break;
            }
            case 1: {
                if (bl) {
                    this.hmiID = 1;
                    break;
                }
                this.hmiID = 1;
                break;
            }
            default: {
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    public void dsiCarVehicleStatesUpdateOilLevelData(OilLevelData oilLevelData, int n) {
        if (this.oilLevelViewOptionState == 2) {
            this.oilLevel = oilLevelData.getLevel();
            HsmTargetCarService.writeIntegerToDatapool(10256, this.oilLevel);
            this.getVehicleServiceListener().updateOilLevel(this.oilLevel);
            this.writeOilWarning(oilLevelData.getWarnings(), this.oilLevel);
            this.oilRefillQuantity = oilLevelData.getRefillVolume().getValue() * 125;
            HsmTargetCarService.writeIntegerToDatapool(10258, this.oilRefillQuantity);
            this.getVehicleServiceListener().updateOilRefillQuantity(this.oilRefillQuantity);
            this.writeOilRefillUnit(oilLevelData.getRefillVolume().getUnit());
        }
    }

    public void dsiCarVehicleStatesUpdateOilLevelViewOption(CarViewOption carViewOption, int n) {
        this.oilLevelViewOptionState = carViewOption.getState();
        this.evaluateOilLevelAvailability();
        this.evaluateCarStatusTileSViewOptions(1, carViewOption);
    }

    private void evaluateCarStatusTileSViewOptions(int n, CarViewOption carViewOption) {
        if (carViewOption == null) {
            return;
        }
        int n2 = carViewOption.getState();
        boolean bl = false;
        boolean bl2 = false;
        if (n2 == 2) {
            bl = true;
            bl2 = true;
        } else if (n2 == 1) {
            bl = true;
            bl2 = false;
        } else if (n2 == 0) {
            bl = false;
            bl2 = false;
        }
        this.getVehicleServiceListener().updateCarStatusTileSFunctionExistence(n, bl);
        this.getVehicleServiceListener().updateCarStatusTileSFunctionAvailabilty(n, bl2);
        if (n == 1) {
            this.getVehicleServiceListener().updateOillevelFunctionAvailableReason(carViewOption.getReason());
        } else if (n == 0) {
            this.getVehicleServiceListener().updateRDKFunctionAvailableReason(carViewOption.getReason());
        }
        this.carStatusTileFunctionAvailability[n] = bl2;
        this.carStatusTileFunctionExistence[n] = bl;
    }

    private void writeOilWarning(int n, int n2) {
        int n3 = 0;
        switch (n) {
            case 0: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 0);
                this.oilWarning = 0;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 1: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 1);
                this.oilWarning = 1;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 2: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 2);
                this.oilWarning = 2;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 3: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 3);
                this.oilWarning = 3;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 4: {
                if (2 < n2) {
                    HsmTargetCarService.writeIntegerToDatapool(10257, 4);
                    this.oilWarning = 4;
                } else {
                    HsmTargetCarService.writeIntegerToDatapool(10257, 9);
                    this.oilWarning = 9;
                }
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 6: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 5);
                this.oilWarning = 5;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 7: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 6);
                this.oilWarning = 6;
                this.getVehicleServiceListener().updateOilWarning(6);
                break;
            }
            case 8: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 7);
                this.oilWarning = 7;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                break;
            }
            case 10: {
                HsmTargetCarService.writeIntegerToDatapool(10257, 8);
                this.oilWarning = 8;
                this.getVehicleServiceListener().updateOilWarning(this.oilWarning);
                n3 = 5;
                this.oilLevelAvailability = 5;
                break;
            }
            case 11: {
                n3 = 4;
                this.oilLevelAvailability = 4;
                break;
            }
        }
        HsmTargetCarService.writeIntegerToDatapool(10588, n3);
        this.getVehicleServiceListener().updateOilLevelAvailability(n3);
    }

    private void writeOilRefillUnit(int n) {
        switch (n) {
            case 2: {
                HsmTargetCarService.writeIntegerToDatapool(10584, 0);
                this.oilRefillUnit = 0;
                this.getVehicleServiceListener().updateOilRefillUnit(this.oilRefillUnit);
                break;
            }
            case 3: {
                HsmTargetCarService.writeIntegerToDatapool(10584, 1);
                this.oilRefillUnit = 1;
                this.getVehicleServiceListener().updateOilRefillUnit(this.oilRefillUnit);
                break;
            }
            case 4: {
                HsmTargetCarService.writeIntegerToDatapool(10584, 1);
                this.oilRefillUnit = 1;
                this.getVehicleServiceListener().updateOilRefillUnit(this.oilRefillUnit);
                break;
            }
        }
    }

    public void dsiCarVehicleStatesUpdateVINData(String string, int n) {
        HsmTargetCarService.writeStringToDatapool(10259, string);
        this.info().append("vin=").append(string).log();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setString(0, string);
        this.triggerObserver(806035456, eventGeneric);
    }

    public void dsiGeneralVehicleStatesUpdateVehicleStandstill(boolean bl, int n) {
        this.isStandstill = bl;
        HsmTargetCarService.writeBooleanToDatapool(10563, !bl);
        if (!this.isStandstill) {
            this.vehicleMoved = true;
        }
        if (!this.startStopProhibitReasonNoticeRequested && this.startStopProhibitReasonNoticeReasonReceived && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active && this.isStandstill && this.vehicleMoved && this.stopProhibitNoticeRequestStored) {
            if (this.isTraceEnabled()) {
                this.trace().append("StartStopNotice: stored notice requested after standstill").log();
            }
            this.sendHMIEvent(10027);
            this.startStopProhibitReasonNoticeRequested = true;
        } else if (this.isTraceEnabled()) {
            this.trace().append("StartStopNotice: Notice not requested after standstill; Notice already requested once before: ").append(this.startStopProhibitReasonNoticeRequested).append("; Reason for Notice received: ").append(this.startStopProhibitReasonNoticeReasonReceived).append("; Notices Active: ").append(!this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).append("; Vehicle moved: ").append(this.vehicleMoved).append("; Notice request stored: ").append(this.stopProhibitNoticeRequestStored).log();
        }
        if (!this.startStopSystemFailureReasonNoticeRequested && this.startStopSystemFailureReasonNoticeReceived && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active && this.isStandstill && this.vehicleMoved && this.systemErrorNoticeRequestStored) {
            if (this.isTraceEnabled()) {
                this.trace().append("StartStopNotice: stored notice requested after standstill").log();
            }
            this.sendHMIEvent(10027);
            this.startStopSystemFailureReasonNoticeRequested = true;
        } else if (this.isTraceEnabled()) {
            this.trace().append("StartStopNotice: Notice not requested after standstill; Notice already requested once before: ").append(this.startStopSystemFailureReasonNoticeRequested).append("; Reason for Notice received: ").append(this.startStopSystemFailureReasonNoticeReceived).append("; Notices Active: ").append(!this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).append("; Vehicle moved: ").append(this.vehicleMoved).append("; Notice request stored: ").append(this.stopProhibitNoticeRequestStored).log();
        }
        if (this.isStandstill) {
            this.stopProhibitNoticeRequestStored = false;
            this.systemErrorNoticeRequestStored = false;
        }
    }

    public void dsiGeneralVehicleStatesUpdateParkingBrake(boolean bl, int n) {
        this.parkingBrakeState = bl ? 1 : 0;
        this.getVehicleServiceListener().updateParkingBrakeState(this.parkingBrakeState);
    }

    public void dsiCarDrivingCharacteristicsUpdateSuspensionControlCarJackMode(boolean bl, int n) {
        this.carJackMode = bl;
        HsmTargetCarService.writeBooleanToDatapool(10576, this.carJackMode);
    }

    public void dsiCarDrivingCharacteristicsUpdateSuspensionControlLiftMode(boolean bl, int n) {
        this.carLiftMode = bl;
        HsmTargetCarService.writeBooleanToDatapool(10578, this.carLiftMode);
    }

    public void dsiCarKombiUpdateBCSpeedWarning(BCSpeedWarningSettings bCSpeedWarningSettings, int n) {
        this.speedWarning(bCSpeedWarningSettings.getSpeedValue(), bCSpeedWarningSettings.getSpeedUnit(), bCSpeedWarningSettings.isState());
        HsmTargetCarService.writeBooleanToDatapool(10253, this.RDKS_SPEEDWARNING_ACTIVE);
    }

    public void dsiCarDrivingCharacteristicsUpdateSuspensionControlViewOptions(SuspensionControlViewOptions suspensionControlViewOptions, int n) {
        CarViewOption carViewOption;
        if (this.isTraceEnabled()) {
            this.trace().append("VIEWOPTIONS: suspensionControlViewOptions: ").append(suspensionControlViewOptions.toString()).log();
        }
        if ((carViewOption = suspensionControlViewOptions.getLiftMode()).getState() == 0) {
            HsmTargetCarService.writeBooleanToDatapool(10579, false);
        } else {
            HsmTargetCarService.writeBooleanToDatapool(10579, true);
        }
        if (carViewOption.getReason() == 0) {
            HsmTargetCarService.writeBooleanToDatapool(10577, true);
        } else {
            HsmTargetCarService.writeBooleanToDatapool(10577, false);
        }
    }

    private void speedWarning(int n, int n2, boolean bl) {
        this.RDKS_SPEEDWARNING_ACTIVE = bl;
        int n3 = n;
        if (0 == n2) {
            n3 = Math.max(n, 30);
        } else if (1 == n2) {
            n3 = Math.max(n, 20);
        }
        this.rdksSnowWarningTire.car_service_rdks_snow_tire_warning_value = n3;
        this.rdksSnowWarningTire.car_service_rdks_snow_tire_warning_unit = this.checkSnowWarningSpeedUnit(n2);
        Object[] objectArray = new CarServiceRDKSSnowTireWarningCollector[]{this.rdksSnowWarningTire};
        ListManager.getGenericASLList(10269).updateList(objectArray);
        this.SPEED_WARNING_VALUE = n3;
        this.SPEED_WARNING_UNIT = n2;
    }

    private int checkSnowWarningSpeedUnit(int n) {
        switch (n) {
            case 0: {
                this.hmiID = 0;
                break;
            }
            case 1: {
                this.hmiID = 1;
                break;
            }
            default: {
                this.error("Can not evaluate the DSI value!");
            }
        }
        return this.hmiID;
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.currentSpeedCollector.car_service_current_speed_value != (int)dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue || this.currentSpeedCollector.car_service_current_speed_unit != dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit) {
            this.currentSpeedCollector.car_service_current_speed_unit = dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit;
            if (dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit != 0 && dynamicVehicleInfoHighFrequent.vehicleSpeed.speedUnit != 1) {
                this.currentSpeedCollector.car_service_current_speed_unit = 0;
                this.warn("HsmTargetCarService.unexpected unit value. Use default 0.");
            }
            this.currentSpeedCollector.car_service_current_speed_value = (int)dynamicVehicleInfoHighFrequent.vehicleSpeed.speedValue;
            ListManager.getGenericASLList(10270).updateListItem(0, this.currentSpeedCollector);
        }
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        switch (dynamicVehicleInfoMidFrequent.getBlinkingState()) {
            case 1: {
                HsmTargetCarService.writeIntegerToDatapool(10260, 1);
                break;
            }
            case 2: {
                HsmTargetCarService.writeIntegerToDatapool(10260, 2);
                break;
            }
            case 3: {
                HsmTargetCarService.writeIntegerToDatapool(10260, 3);
                break;
            }
            case 0: {
                HsmTargetCarService.writeIntegerToDatapool(10260, 0);
                break;
            }
        }
        this.setValetParkingActive(dynamicVehicleInfoMidFrequent.isValetParkingState());
        switch (dynamicVehicleInfoMidFrequent.getAutomaticGearShiftTransMode()) {
            case 1: {
                this.automaticGearShiftTransMode = 1;
                break;
            }
            case 2: {
                this.automaticGearShiftTransMode = 2;
                break;
            }
            case 3: {
                this.automaticGearShiftTransMode = 3;
                break;
            }
            case 4: {
                this.automaticGearShiftTransMode = 4;
                break;
            }
            case 5: {
                this.automaticGearShiftTransMode = 5;
                break;
            }
            case 6: {
                this.automaticGearShiftTransMode = 6;
                break;
            }
            case 7: {
                this.automaticGearShiftTransMode = 7;
                break;
            }
            case 8: {
                this.automaticGearShiftTransMode = 8;
                break;
            }
            case 9: {
                this.automaticGearShiftTransMode = 9;
                break;
            }
            case 10: {
                this.automaticGearShiftTransMode = 10;
                break;
            }
            case 11: {
                this.automaticGearShiftTransMode = 11;
                break;
            }
            case 12: {
                this.automaticGearShiftTransMode = 12;
                break;
            }
            case 13: {
                this.automaticGearShiftTransMode = 13;
                break;
            }
            default: {
                this.automaticGearShiftTransMode = 0;
            }
        }
        this.getVehicleServiceListener().updateAutomaticGearShiftTransMode(this.automaticGearShiftTransMode);
        switch (dynamicVehicleInfoMidFrequent.getClutch()) {
            case 1: {
                this.clutchState = 1;
                break;
            }
            default: {
                this.clutchState = 0;
            }
        }
        this.getVehicleServiceListener().updateClutchState(this.clutchState);
    }

    public void dsiCarVehicleStatesUpdateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        this.setValetParkingAvailable(dynamicVehicleInfoMidFrequentViewOptions.getValetParkingState() != null && dynamicVehicleInfoMidFrequentViewOptions.getValetParkingState().getState() == 2);
        this.carGearType = 0 == dynamicVehicleInfoMidFrequentViewOptions.getAutomaticGearShiftTransMode().getState() ? 0 : 1;
        this.getVehicleServiceListener().updateCarGearType(this.carGearType);
    }

    public void dsiCarVehicleStatesUpdateDrvSchoolBlinkingState(int n, int n2) {
    }

    public void dsiCarComfortResponseRDKPressureChanged(int n) {
        switch (n) {
            case 1: {
                break;
            }
            case 2: {
                this.evaluateRdkProgress(10010);
                break;
            }
            case 3: {
                this.evaluateRdkProgress(10011);
                break;
            }
            case 0: {
                break;
            }
        }
    }

    private void evaluateRdkProgress(int n) {
        if (this.getMainObject().getTimerServer().isTimerActive(this.getTargetId(), 75956480)) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR SERVICE: stopping timer and register on model event").log();
            }
            this.stopTimer(75956480);
            this.registerCalibrateButton();
        }
        this.sendHMIEvent(n);
    }

    public void dsiCarComfortUpdateRDKPressureLevel(byte by, int n) {
        int n2 = 0;
        switch (by) {
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 0;
                break;
            }
            case 0: {
                this.info().append("RDKS: PressureLevel is UNKNOWN. Not implemented by HMI").log();
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("update RDK speed limit: other values are not implemented").log();
            }
        }
        HsmTargetCarService.writeIntegerToDatapool(10487, n2);
        CarPersistenceServiceImpl.getInstance().loadCar().setRDKLoadChange(n2);
    }

    public void dsiCarComfortUpdateRDKSpeedLimit(int n, int n2) {
        int n3 = 0;
        switch (n) {
            case 1: {
                n3 = 2;
                break;
            }
            case 2: {
                n3 = 1;
                break;
            }
            case 3: {
                n3 = 0;
                break;
            }
            default: {
                if (!this.isTraceEnabled()) break;
                this.trace().append("update RDK speed limit: other values are not implemented").log();
            }
        }
        HsmTargetCarService.writeIntegerToDatapool(10487, n3);
        CarPersistenceServiceImpl.getInstance().loadCar().setRDKLoadChange(n3);
    }

    public void dsiCarComfortUpdateRDKTireSetupSelectedTire(int n, int n2) {
        if (n - 1 != -1) {
            HsmTargetCarService.writeIntegerToDatapool(10255, n - 1);
        }
    }

    public void dsiCarComfortUpdateRDKViewOptions(RDKViewOptions rDKViewOptions, int n) {
        this.rdkSystemModelValue = 0;
        this.pressureLevelAvailable = rDKViewOptions.getPressureLevel().getState() == 2;
        this.currentRDKSystem = rDKViewOptions.getConfiguration().getSystem();
        switch (rDKViewOptions.getConfiguration().getSystem()) {
            case 0: {
                this.rdkSystemModelValue = 1;
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                this.rdkSystemModelValue = 2;
                break;
            }
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(10900, this.rdkSystemModelValue);
        this.getRDKServiceListener().updateRDKSystem(this.rdkSystemModelValue);
        CarPersistenceServiceImpl.getInstance().loadCar().setRDKSystem(this.rdkSystemModelValue);
        this.currentRDKTireDisplay = new CarViewOption(rDKViewOptions.getTireDisplay().getState(), rDKViewOptions.getTireDisplay().getReason());
        if (!(ServiceManager.configManagerDiag.isFeatureFlagSet(105) && rDKViewOptions.getConfiguration().getSystem() == 2 || rDKViewOptions.getTireDisplay().getState() != 2)) {
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(101)) {
                boolean[] blArray = ASLCarServicePropertyManager.RDKS_LOAD_CHANGE_OPTIONS_STATE__DEFAULT_VALUE;
                blArray[0] = true;
                blArray[2] = true;
                blArray[1] = true;
                ServiceManager.aslPropertyManager.valueChangedFlagVector(10511, blArray);
            } else if (rDKViewOptions.configuration.pressureLevel2 || rDKViewOptions.configuration.pressureLevel3) {
                boolean[] blArray = ASLCarServicePropertyManager.RDKS_LOAD_CHANGE_OPTIONS_STATE__DEFAULT_VALUE;
                blArray[0] = rDKViewOptions.configuration.pressureLevel3;
                blArray[2] = true;
                blArray[1] = rDKViewOptions.configuration.pressureLevel2;
                ServiceManager.aslPropertyManager.valueChangedFlagVector(10511, blArray);
            }
        }
        this.evaluateRDKViewOptions();
        this.evaluateCarStatusTileSViewOptions(0, rDKViewOptions.actualState);
    }

    private void evaluateRDKViewOptions() {
        switch (this.currentRDKSystem) {
            case 0: 
            case 2: {
                if (!this.isClamp15Active || this.getTimerServer().isTimerActive(this.getTargetId(), 126288128)) break;
                if (this.currentRDKTireDisplay.getState() == 1 && this.currentRDKTireDisplay.getReason() == 5) {
                    this.rdkClampState[HsmTargetCarService.RDK_CLAMP_STATE_INIT] = true;
                    ListManager.getGenericASLList(10491).updateList(this.rdkClampState);
                    this.getRDKServiceListener().updateRKA_RDKS_States(this.rdkClampState);
                    this.startTimer(126288128, (long)0, false);
                    break;
                }
                this.rdkClampState[HsmTargetCarService.RDK_CLAMP_STATE_INIT] = false;
                ListManager.getGenericASLList(10491).updateList(this.rdkClampState);
                this.getRDKServiceListener().updateRKA_RDKS_States(this.rdkClampState);
                if (this.currentRDKSystem == 2) {
                    if (!this.isRDKSystemActive) {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(10466, false);
                    } else {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(10466, true);
                    }
                    this.getRDKServiceListener().updateIsRDKSFSGControlOn(this.isRDKSystemActive);
                }
                ComfortViewOptionServiceImpl.getInstance().setRdkInitialized(true);
                break;
            }
        }
    }

    public void dsiCarComfortUpdateRDKSystemOnOff(boolean bl, int n) {
        this.isRDKSystemActive = bl;
        this.evaluateRDKViewOptions();
    }

    public void dsiCarComfortUpdateRDKTireSetupTireList(RDKTireInfo[] rDKTireInfoArray, int n) {
        Object[] objectArray = new String[rDKTireInfoArray.length];
        for (int i2 = 0; i2 < rDKTireInfoArray.length; ++i2) {
            StringBuffer stringBuffer = new StringBuffer();
            objectArray[i2] = stringBuffer.append(rDKTireInfoArray[i2].getVendorName()).append(" ").append(rDKTireInfoArray[i2].getWheelSize()).toString();
        }
        ListManager.getGenericASLList(10254).updateList(objectArray);
        ComfortViewOptionServiceImpl.getInstance().setTireInfo(rDKTireInfoArray.length);
    }

    public void dsiCarComfortResponseRDKLifeMonitoring() {
        this.dsiCarComfort.requestRDKLifeMonitoring();
    }

    public void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        boolean bl = bCViewOptions.vehicleStateList.state == 2 && bCViewOptions.vehicleStateList.reason == 0;
        this.getVehicleStateController().setListAvailable(bl);
    }

    public void dsiCarKombiResponseVehicleStateUpdateInfo(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateUpdateInfo(bCVehicleStateUpdateInfoAH, nArray);
    }

    public void dsiCarKombiUpdateBCVehicleStateListTotalNumberOfElements(int n, int n2) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiUpdateBCVehicleStateListTotalNumberOfElements(n, n2);
    }

    public void dsiCarKombiResponseVehicleStateListPos(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int[] nArray) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateListPos(bCVehicleStateUpdateInfoAH, nArray);
    }

    public void dsiCarKombiResponseVehicleStateListWarningIDdynValueAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, int n2, String string, String string2) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateListWarningIDdynValueAlternativeText(bCVehicleStateUpdateInfoAH, n, n2, string, string2);
    }

    public void dsiCarKombiResponseVehicleStateListWarningIDdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateListWarningIDdynValue(bCVehicleStateUpdateInfoAH, listWarningIDsDynValuesArray);
    }

    public void dsiCarKombiResponseVehicleStateListdynValue(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, ListDynValues[] listDynValuesArray) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateListdynValue(bCVehicleStateUpdateInfoAH, listDynValuesArray);
    }

    public void dsiCarKombiResponseVehicleStateListAlternativeText(BCVehicleStateUpdateInfoAH bCVehicleStateUpdateInfoAH, int n, String string) {
        this.getVehicleStateController().getVehicleStateDsiListener().dsiCarKombiResponseVehicleStateListAlternativeText(bCVehicleStateUpdateInfoAH, n, string);
    }

    private void requestingStartStopLists() {
        this.TRANSACTION_STARTSTOPPROHIBITREASON = 1;
        this.startStopProhibitReasonList = true;
        StartStopListUpdateInfo startStopListUpdateInfo = new StartStopListUpdateInfo(1, 0, 3, this.TRANSACTION_STARTSTOPPROHIBITREASON);
        this.dsiCarEco.requestStartStopProhibitList(startStopListUpdateInfo);
        this.TRANSACTION_RESTARTSTOP = 1;
        this.startStopRestartProhibitReasonList = true;
        startStopListUpdateInfo = new StartStopListUpdateInfo(1, 0, 3, this.TRANSACTION_RESTARTSTOP);
        this.dsiCarEco.requestStartStopRestartProhibitList(startStopListUpdateInfo);
        this.TRANSACTION_STARTSTOPRESTARTREASON = 1;
        startStopListUpdateInfo = new StartStopListUpdateInfo(1, 0, 3, this.TRANSACTION_STARTSTOPRESTARTREASON);
        this.dsiCarEco.requestStartStopRestartList(startStopListUpdateInfo);
    }

    public void dsiCarEcoUpdateStartStopProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.requestingStartStopProhibitReasonList = true;
        this.startStopProhibitListUpdateInfo = startStopListUpdateInfo;
        this.startStopProhibitReasonList = this.creatingNewListForHMI(this.startStopProhibitListUpdateInfo);
        if (this.startStopProhibitReasonList) {
            this.removeOnEcoStartStopState();
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: requestStartStopProhibitList").log();
            }
            this.startStopProhibitListUpdateInfo.transactionID = this.TRANSACTION_STARTSTOPPROHIBITREASON = 1;
            this.startStopProhibitListUpdateInfo.numOfElements = 3;
            this.dsiCarEco.requestStartStopProhibitList(this.startStopProhibitListUpdateInfo);
        } else {
            this.warn("StartStop Prohibit Reason List: ONLY CHANGES IS NOT IMPLEMENTED!!!");
        }
    }

    public void dsiCarEcoUpdateStartStopProhibitReasonListTotalNumberOfElements(int n, int n2) {
        this.requestingStartStopProhibitReasonList = false;
        this.startStopProhibitReasonNoticeReasonReceived = false;
        if (n == 0) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: creating empty list for HMI --> startStopProhibitReasons").log();
            }
            this.startStopProhibitList = new Integer[0];
            if (this.restartStopProhibitList.length == 0) {
                this.informStartStopProhibitReason();
            }
        } else if (this.startStopProhibitReasonList) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: creating new list for startStopProhibitReasons").log();
            }
            this.allElementsStartStopProhibitReasons = n;
            this.startStopProhibitList = new Integer[this.allElementsStartStopProhibitReasons];
            this.startStopProhibitReasonList = false;
        }
    }

    public void dsiCarEcoResponseStartStopProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopProhibitList[] startStopProhibitListArray) {
        this.requestingStartStopProhibitReasonList = false;
        if (startStopListUpdateInfo.getTransactionID() == this.TRANSACTION_STARTSTOPPROHIBITREASON) {
            if (startStopProhibitListArray.length > 0) {
                for (int i2 = 0; i2 < startStopProhibitListArray.length; ++i2) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CAR service: StartStopProhibitReasonList: counter ").append(startStopProhibitListArray[i2].getListPosition()).append(" value on: ").append(i2).append(" value ").append(startStopProhibitListArray[i2].getReason()).log();
                    }
                    this.startStopProhibitList[startStopProhibitListArray[i2].getListPosition()] = new Integer(ASLCarUtil.startStopReasons(startStopProhibitListArray[i2].getReason()));
                    this.startStopProhibitReasonNoticeReasonReceived = this.startStopProhibitReasonNoticeReasonReceived || ASLCarUtil.isStartStopNoticeReason(startStopProhibitListArray[i2].getReason());
                }
                if (startStopProhibitListArray[startStopProhibitListArray.length - 1].getListPosition() == this.allElementsStartStopProhibitReasons - 1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CAR Service: we are done and inform HMI with new values for StartStopProhibitReasonList!").log();
                    }
                    this.informStartStopProhibitReason();
                    if (!this.startStopProhibitReasonNoticeRequested && this.startStopProhibitReasonNoticeReasonReceived && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active) {
                        if (this.isStandstill && this.vehicleMoved) {
                            if (this.isTraceEnabled()) {
                                this.trace().append("StartStopNotice: ProhibitReason found, Notice requested").log();
                            }
                            this.sendHMIEvent(10027);
                            this.startStopProhibitReasonNoticeRequested = true;
                        } else {
                            if (this.isTraceEnabled()) {
                                this.trace().append("StartStopNotice: ProhibitReason found, Notice request stored because vehicle is moving").log();
                            }
                            this.stopProhibitNoticeRequestStored = true;
                        }
                    } else if (this.isTraceEnabled()) {
                        this.trace().append("StartStopNotice: StopProhibitReason found, Notice not requested; Notice already requested once before: ").append(this.startStopProhibitReasonNoticeRequested).append("; Reason for Notice received: ").append(this.startStopProhibitReasonNoticeReasonReceived).append("; Notices Active: ").append(!this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).log();
                    }
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CAR serivce: requesting next values for StartStopProhibitReasonList").append(" With startElement ").append(startStopProhibitListArray[startStopProhibitListArray.length - 1].getListPosition()).log();
                    }
                    ++this.TRANSACTION_STARTSTOPPROHIBITREASON;
                    this.dsiCarEco.requestStartStopProhibitList(this.requestingNextValues(startStopProhibitListArray[startStopProhibitListArray.length - 1].getListPosition(), this.startStopProhibitListUpdateInfo, this.calculateNextValues(startStopProhibitListArray[startStopProhibitListArray.length - 1].getListPosition(), this.allElementsStartStopProhibitReasons - 1), this.TRANSACTION_STARTSTOPPROHIBITREASON));
                }
            } else {
                if (this.isTraceEnabled()) {
                    this.trace().append("ERROR: requested start stop array is empty!").log();
                }
                this.checkingStartStopState();
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("ERROR: transaction ID (ASL) does not match with the transaction ID (DSI)! ASL: ").append(this.TRANSACTION_STARTSTOPPROHIBITREASON).append(" DSI:").append(startStopListUpdateInfo.getTransactionID()).log();
        }
    }

    private void informStartStopProhibitReason() {
        if (this.isTraceEnabled()) {
            this.trace().append("Inform HMI StartStopProhibitReasons ").log();
        }
        if (this.startStopProhibitList.length != 0) {
            ListManager.getGenericASLList(10844).updateList(this.startStopProhibitList);
        }
        this.checkingStartStopState();
    }

    public void dsiCarEcoUpdateStartStopRestartProhibitReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.requestingStartStopRestartProhibitReasonList = true;
        this.startStopRestartProhibitList = startStopListUpdateInfo;
        this.startStopRestartProhibitReasonList = this.creatingNewListForHMI(this.startStopRestartProhibitList);
        if (this.startStopRestartProhibitReasonList) {
            this.removeOnEcoStartStopState();
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: requestStartStopRestartProhibitList").log();
            }
            this.startStopRestartProhibitList.transactionID = this.TRANSACTION_RESTARTSTOP = 1;
            this.startStopRestartProhibitList.numOfElements = 3;
            this.dsiCarEco.requestStartStopRestartProhibitList(this.startStopRestartProhibitList);
        } else if (this.isTraceEnabled()) {
            this.trace().append("StartStop Restart Prohibit Reason List: ONLY CHANGES IS NOT IMPLEMENTED!!!").log();
        }
    }

    public void dsiCarEcoUpdateStartStopRestartProhibitReasonListTotalNumberOfElements(int n, int n2) {
        this.requestingStartStopRestartProhibitReasonList = false;
        this.startStopRestartProhibitReasonNoticeReasonReceived = false;
        if (n == 0) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: creating empty list for HMI --> StartStopRestartProhibitReason").log();
            }
            this.restartStopProhibitList = new Integer[0];
            if (this.startStopProhibitList.length == 0) {
                this.informRestartProhibitReasonList();
            }
        } else if (this.startStopRestartProhibitReasonList) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: creating new list for StartStopRestartProhibitReason").log();
            }
            this.allElementsRestartStopReasons = n;
            this.restartStopProhibitList = new Integer[this.allElementsRestartStopReasons];
            this.startStopRestartProhibitReasonList = false;
        }
    }

    public void dsiCarEcoResponseStartStopRestartProhibitReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartProhibitList[] startStopRestartProhibitListArray) {
        this.requestingStartStopRestartProhibitReasonList = false;
        if (startStopListUpdateInfo.getTransactionID() == this.TRANSACTION_RESTARTSTOP) {
            if (startStopRestartProhibitListArray.length > 0) {
                for (int i2 = 0; i2 < startStopRestartProhibitListArray.length; ++i2) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("StartStopRestartProhibitReasonList: counter ").append(startStopRestartProhibitListArray[i2].getListPosition()).append(" value: ").append(startStopRestartProhibitListArray[i2].getReason()).log();
                    }
                    this.restartStopProhibitList[startStopRestartProhibitListArray[i2].getListPosition()] = new Integer(ASLCarUtil.startStopReasons(startStopRestartProhibitListArray[i2].getReason()));
                    this.startStopRestartProhibitReasonNoticeReasonReceived = this.startStopRestartProhibitReasonNoticeReasonReceived || ASLCarUtil.isStartStopNoticeReason(startStopRestartProhibitListArray[i2].getReason());
                }
                if (startStopRestartProhibitListArray[startStopRestartProhibitListArray.length - 1].getListPosition() == this.allElementsRestartStopReasons - 1) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CAR Service: we are done and inform HMI with new values for StartStopRestartProhibitReasonList!").log();
                    }
                    this.informRestartProhibitReasonList();
                    if (!this.startStopRestartProhibitReasonNoticeRequested && this.startStopRestartProhibitReasonNoticeReasonReceived && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active && this.isStandstill) {
                        if (this.isTraceEnabled()) {
                            this.trace().append("StartStopNotice: RestartProhibitReason found, Notice requested").log();
                        }
                        this.sendHMIEvent(10027);
                        this.startStopRestartProhibitReasonNoticeRequested = true;
                    } else if (this.isTraceEnabled()) {
                        this.trace().append("StartStopNotice: RestartProhibitReason found, Notice not requested; Notice already requested once before: ").append(this.startStopRestartProhibitReasonNoticeRequested).append("; Reason for Notice received: ").append(this.startStopRestartProhibitReasonNoticeReasonReceived).append("; Notices Active: ").append(!this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).log();
                    }
                    this.startStopRestartProhibitReasonNoticeReasonReceived = false;
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("CAR Service: requesting next values for StartStopRestartProhibitReasonList!").append(" With StartElement: ").append(startStopRestartProhibitListArray[startStopRestartProhibitListArray.length - 1].getListPosition()).log();
                    }
                    ++this.TRANSACTION_RESTARTSTOP;
                    this.dsiCarEco.requestStartStopRestartProhibitList(this.requestingNextValues(startStopRestartProhibitListArray[startStopRestartProhibitListArray.length - 1].getListPosition(), this.startStopRestartProhibitList, this.calculateNextValues(startStopRestartProhibitListArray[startStopRestartProhibitListArray.length - 1].getListPosition(), this.allElementsRestartStopReasons - 1), this.TRANSACTION_RESTARTSTOP));
                }
            } else {
                if (this.isTraceEnabled()) {
                    this.trace().append("ERROR: requested restart stop list is empty!").log();
                }
                this.checkingStartStopState();
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("ERROR: transaction ID (ASL) does not match with the transaction ID (DSI)! ASL: ").append(this.TRANSACTION_RESTARTSTOP).append(" DSI:").append(startStopListUpdateInfo.getTransactionID()).log();
        }
    }

    private void informRestartProhibitReasonList() {
        if (this.isTraceEnabled()) {
            this.trace().append("Inform HMI RestartProhibitReason ").log();
        }
        if (this.restartStopProhibitList.length != 0) {
            ListManager.getGenericASLList(10844).updateList(this.restartStopProhibitList);
        }
        this.checkingStartStopState();
    }

    private void checkingStartStopState() {
        if (this.isTraceEnabled()) {
            this.trace().append("restartStopProhibitList: ").append(this.restartStopProhibitList.length).append(" startStopProhibitList: ").append(this.startStopProhibitList.length).append(" startStopProhibitReasonList: ").append(this.requestingStartStopProhibitReasonList).append(" startStopRestartProhibitReasonList: ").append(this.requestingStartStopRestartProhibitReasonList).log();
        }
        if (this.restartStopProhibitList.length == 0 && this.startStopProhibitList.length == 0 && !this.requestingStartStopProhibitReasonList && !this.requestingStartStopRestartProhibitReasonList) {
            this.startTimer(92733696, (long)0, false);
        }
    }

    public void dsiCarEcoUpdateStartStopRestartReasonListUpdateInfo(StartStopListUpdateInfo startStopListUpdateInfo, int n) {
        this.startStopRestartReason = startStopListUpdateInfo;
        this.startStopRestartReasonList = this.creatingNewListForHMI(this.startStopRestartReason);
        if (this.startStopRestartReasonList) {
            if (this.isTraceEnabled()) {
                this.trace().append("CAR Service: requestStartStopRestartList").log();
            }
            this.startStopRestartReason.transactionID = this.TRANSACTION_STARTSTOPRESTARTREASON = 1;
            this.startStopRestartReason.numOfElements = 3;
            this.dsiCarEco.requestStartStopRestartList(this.startStopRestartReason);
        } else if (this.isTraceEnabled()) {
            this.trace().append("Start Stop Restart Reason List: ONLY CHANGES IS NOT IMPLEMENTED!!!").log();
        }
    }

    public void dsiCarEcoUpdateStartStopRestartReasonListTotalNumberOfElements(int n, int n2) {
        if (n == 0) {
            HsmTargetCarService.writeIntegerToDatapool(10843, 0);
        }
    }

    public void dsiCarEcoResponseStartStopRestartReasonList(StartStopListUpdateInfo startStopListUpdateInfo, StartStopRestartList[] startStopRestartListArray) {
        if (startStopListUpdateInfo.getTransactionID() == this.TRANSACTION_STARTSTOPRESTARTREASON) {
            if (startStopRestartListArray.length > 0) {
                if (this.isTraceEnabled()) {
                    this.trace().append("CAR Service: inform HMI StartStopRestartReasonList with reason: ").append(startStopRestartListArray[0].getReason()).log();
                }
                HsmTargetCarService.writeIntegerToDatapool(10843, ASLCarUtil.restartStopReasons(startStopRestartListArray[0].getReason()));
                if (!this.startStopRestartReasonNoticeRequested && ASLCarUtil.isStartStopNoticeReason(startStopRestartListArray[0].getReason()) && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active && this.isStandstill) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("StartStopNotice: RestartReason found, Notice requested").log();
                    }
                    this.sendHMIEvent(10027);
                    this.startStopRestartReasonNoticeRequested = true;
                } else if (this.isTraceEnabled()) {
                    this.trace().append("StartStopNotice: RestartReason found, Notice not requested; Notice already requested once before: ").append(this.startStopRestartReasonNoticeRequested).append("; Reason for Notice received: ").append(ASLCarUtil.isStartStopNoticeReason(startStopRestartListArray[0].getReason())).append("; Notices Active: ").append(!this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).log();
                }
            } else if (this.isTraceEnabled()) {
                this.trace().append("ERROR: requested restart stop list is empty!").log();
            }
        } else if (this.isTraceEnabled()) {
            this.trace().append("ERROR: transaction ID (ASL) does not match with the transaction ID (DSI)! ASL: ").append(this.TRANSACTION_STARTSTOPRESTARTREASON).append(" DSI:").append(startStopListUpdateInfo.getTransactionID()).log();
        }
    }

    public void dsiCarEcoUpdateStartStopState(int n, int n2) {
        ListManager.getGenericASLList(10844).updateList(this.restartStopProhibitList);
        ListManager.getGenericASLList(10844).updateList(this.startStopProhibitList);
        this.startStopSystemFailureReasonNoticeReceived = false;
        int n3 = ASLCarUtil.startStopState(n);
        if (n3 < 0) {
            return;
        }
        HsmTargetCarService.writeIntegerToDatapool(10842, n3);
        if (n == 7) {
            this.startStopSystemFailureReasonNoticeReceived = true;
            if (!this.startStopSystemFailureReasonNoticeRequested && !this.isButtonStartStopNoticeHighlighted && this.isClamp15Active) {
                if (this.isStandstill && this.vehicleMoved) {
                    if (this.isTraceEnabled()) {
                        this.trace().append("StartStopNotice: STARTSTOPSTATE_SYSTEMERROR found, Notice requested").log();
                    }
                    this.sendHMIEvent(10027);
                    this.startStopSystemFailureReasonNoticeRequested = true;
                } else {
                    if (this.isTraceEnabled()) {
                        this.trace().append("StartStopNotice: System Failure detected, Notice request stored because vehicle is moving").log();
                    }
                    this.systemErrorNoticeRequestStored = true;
                }
            } else if (this.isTraceEnabled()) {
                this.trace().append("StartStopNotice: System Failure detected, Notice not requested; Notice already requested once before: ").append(this.startStopSystemFailureReasonNoticeRequested).append("; Notices Active: ").append(this.isButtonStartStopNoticeHighlighted).append("; Clamp15 Active: ").append(this.isClamp15Active).append("; Standstill: ").append(this.isStandstill).log();
            }
        } else if (n == 2) {
            this.resetStartStopNoticeRequested();
        }
    }

    private boolean creatingNewListForHMI(StartStopListUpdateInfo startStopListUpdateInfo) {
        return startStopListUpdateInfo.getArrayContent() == 0 || startStopListUpdateInfo.getArrayContent() == 1;
    }

    private StartStopListUpdateInfo requestingNextValues(int n, StartStopListUpdateInfo startStopListUpdateInfo, int n2, int n3) {
        if (startStopListUpdateInfo == null) {
            if (this.isTraceEnabled()) {
                this.trace().append("Car Service requesting next values: updateInfo == NULL").log();
            }
            startStopListUpdateInfo = new StartStopListUpdateInfo();
        }
        startStopListUpdateInfo.startElement = n;
        startStopListUpdateInfo.numOfElements = n2;
        startStopListUpdateInfo.transactionID = n3;
        return startStopListUpdateInfo;
    }

    private int calculateNextValues(int n, int n2) {
        int n3 = n + 3;
        if (n3 <= n2) {
            return 3;
        }
        return n2 - n;
    }

    private void initDefaultValues() {
        this.RDKS_SPEEDWARNING_ACTIVE = false;
        this.SPEED_WARNING_VALUE = 120;
        this.SPEED_WARNING_UNIT = 0;
        this.rdksSnowWarningTire.car_service_rdks_snow_tire_warning_value = 120;
        this.rdksSnowWarningTire.car_service_rdks_snow_tire_warning_unit = 0;
        Object[] objectArray = new CarServiceRDKSSnowTireWarningCollector[]{this.rdksSnowWarningTire};
        ListManager.getGenericASLList(10269).updateList(objectArray);
        ListManager.getGenericASLList(10844).updateList(new Integer[0]);
        HsmTargetCarService.writeIntegerToDatapool(10843, 0);
        HsmTargetCarService.writeIntegerToDatapool(10842, 0);
        ListManager.getGenericASLList(10254).updateList(new String[]{""});
        ServiceManager.aslPropertyManager.valueChangedInteger(10255, 0);
        HsmTargetCarService.writeIntegerArrayToDatapool(10264, ASLCarServicePropertyManager.VEHICLE_STATUS_WARNINGS__DEFAULT_VALUE);
        this.isButtonStartStopNoticeHighlighted = CarPersistenceServiceImpl.getInstance().loadCar().isButtonStartStopNoticeHighlighted();
        HsmTargetCarService.writeBooleanToDatapool(10604, this.isButtonStartStopNoticeHighlighted);
        this.setWarningCount(0);
    }

    @Override
    public CarLogger getCarLogger() {
        return this;
    }

    @Override
    public DSICarKombi getDsiVehicleState() {
        return this.dsiCarKombi;
    }

    @Override
    public VehicleStateController getVehicleStateController() {
        if (this._vehicleStateController == null) {
            this._vehicleStateController = new VehicleStateController(this);
        }
        return this._vehicleStateController;
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (clampSignal.isClamp15() && !this.getMainObject().getTimerServer().isTimerActive(this.getTargetId(), 109510912)) {
            this.startTimer(109510912, (long)0, false);
        }
        this.rdkClampState[HsmTargetCarService.RDK_CLAMP_STATE_CLAMP] = clampSignal.isClamp15();
        ListManager.getGenericASLList(10491).updateList(this.rdkClampState);
        this.getRDKServiceListener().updateRKA_RDKS_States(this.rdkClampState);
        this.initRKA(clampSignal.isClamp15());
        this.isClamp15Active = clampSignal.isClamp15();
        this.evaluateOilLevelAvailability();
    }

    private void initRKA(boolean bl) {
        if (!bl && !this.getTimerServer().isTimerActive(this.getTargetId(), 126288128)) {
            this.stopTimer(126288128);
        }
        if (bl && !this.isClamp15Active && !this.getTimerServer().isTimerActive(this.getTargetId(), 126288128)) {
            this.resetStartStopNoticeRequested();
            this.startTimer(126288128, (long)0, false);
            ComfortViewOptionServiceImpl.getInstance().setRdkInitialized(false);
            this.rdkClampState[HsmTargetCarService.RDK_CLAMP_STATE_INIT] = true;
            ListManager.getGenericASLList(10491).updateList(this.rdkClampState);
            this.getRDKServiceListener().updateRKA_RDKS_States(this.rdkClampState);
        }
    }

    private VehicleServiceListener getVehicleServiceListener() {
        return (VehicleServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener == null ? (class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener = HsmTargetCarService.class$("de.vw.mib.asl.api.car.vehicle.VehicleServiceListener")) : class$de$vw$mib$asl$api$car$vehicle$VehicleServiceListener);
    }

    private void setValetParkingActive(boolean bl) {
        if (this.isValetParkingActive != bl) {
            this.isValetParkingActive = bl;
            this.getVehicleServiceListener().updateValetParkingActive(this.isValetParkingActive());
        }
    }

    private void setValetParkingAvailable(boolean bl) {
        if (this.isValetParkingAvailable != bl) {
            this.isValetParkingAvailable = bl;
            this.getVehicleServiceListener().updateValetParkingAvailable(this.isValetParkingAvailable());
        }
    }

    @Override
    public boolean isValetParkingAvailable() {
        return this.isValetParkingAvailable;
    }

    @Override
    public boolean isValetParkingActive() {
        return this.isValetParkingActive && this.isValetParkingAvailable();
    }

    public void setWarningCount(int n) {
        this.warningCount = n;
    }

    @Override
    public int getWarningCount() {
        return this.warningCount;
    }

    @Override
    public int getOilLevel() {
        return this.oilLevel;
    }

    @Override
    public int getOilLevelAvailability() {
        return this.oilLevelAvailability;
    }

    @Override
    public int getOilRefillQuantity() {
        return this.oilRefillQuantity;
    }

    @Override
    public int getOilRefillUnit() {
        return this.oilRefillUnit;
    }

    @Override
    public int getOilWarning() {
        return this.oilWarning;
    }

    @Override
    public boolean[] getSystemState() {
        return new boolean[]{this.isInitializing, this.isClamp15Active};
    }

    private RDKServiceListener getRDKServiceListener() {
        return (RDKServiceListener)ServiceFactory.getInstance().getServiceProviderRegistry().getServiceListener(class$de$vw$mib$asl$api$car$rdk$RDKServiceListener == null ? (class$de$vw$mib$asl$api$car$rdk$RDKServiceListener = HsmTargetCarService.class$("de.vw.mib.asl.api.car.rdk.RDKServiceListener")) : class$de$vw$mib$asl$api$car$rdk$RDKServiceListener);
    }

    @Override
    public int[] getRDKSTires() {
        return this.rdksTires;
    }

    @Override
    public Boolean[] getRKA_RDKS_States() {
        return this.rdkClampState;
    }

    @Override
    public boolean isRDKSFSGControlOn() {
        return this.isRDKSystemActive;
    }

    @Override
    public int getRDKSystem() {
        return this.rdkSystemModelValue;
    }

    @Override
    public boolean[] getCarStatusTileSFunctionExistence() {
        return this.carStatusTileFunctionExistence;
    }

    @Override
    public boolean[] getCarStatusTileSFunctionAvailability() {
        return this.carStatusTileFunctionAvailability;
    }

    @Override
    public int getOilLevelAvailabilityReason() {
        return this.oilLevelAvailabilityReason;
    }

    @Override
    public int getRDKAvailabilityReason() {
        return this.rdkAvailaibiltyReason;
    }

    private void resetStartStopNoticeRequested() {
        if (this.isTraceEnabled()) {
            this.trace().append("StartStopNotice: Notice state resetted").log();
        }
        this.startStopRestartProhibitReasonNoticeRequested = false;
        this.startStopRestartReasonNoticeRequested = false;
        this.startStopProhibitReasonNoticeRequested = false;
        this.startStopSystemFailureReasonNoticeRequested = false;
        this.vehicleMoved = false;
    }

    private void toggleButtonStartStopNotice() {
        CarPersistenceServiceImpl.getInstance().loadCar().setButtonStartStopNoticeHighlighted(!this.isButtonStartStopNoticeHighlighted);
        this.isButtonStartStopNoticeHighlighted = CarPersistenceServiceImpl.getInstance().loadCar().isButtonStartStopNoticeHighlighted();
        HsmTargetCarService.writeBooleanToDatapool(10604, this.isButtonStartStopNoticeHighlighted);
        if (this.isTraceEnabled()) {
            this.trace().append("StartStopNotice: Notice Button toggled to ").append(this.isButtonStartStopNoticeHighlighted).log();
        }
    }

    private void resetStartStopNoticeButton() {
        CarPersistenceServiceImpl.getInstance().loadCar().setButtonStartStopNoticeHighlighted(false);
        this.isButtonStartStopNoticeHighlighted = CarPersistenceServiceImpl.getInstance().loadCar().isButtonStartStopNoticeHighlighted();
        HsmTargetCarService.writeBooleanToDatapool(10604, this.isButtonStartStopNoticeHighlighted);
    }

    @Override
    public void registered(String string, int n) {
        try {
            if ((class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetCarService.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates).getName().equals(string)) {
                DSIGeneralVehicleStates dSIGeneralVehicleStates = (DSIGeneralVehicleStates)ASLCarContainer.getInstance().getDSIProxy().getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = HsmTargetCarService.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                dSIGeneralVehicleStates.setNotification(new int[]{22, 28}, ASLCarContainer.getInstance().getAdapterFactory().createDSIListenerMethodAdapter(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener = HsmTargetCarService.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStatesListener));
            }
        }
        catch (Throwable throwable) {
            this.warn("Could not connect to DSIGeneralVehicleStates");
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    @Override
    public int getCarGearType() {
        return this.carGearType;
    }

    @Override
    public int getAutomaticGearShiftTransMode() {
        return this.automaticGearShiftTransMode;
    }

    @Override
    public int getClutchState() {
        return this.clutchState;
    }

    @Override
    public int getParkingBrakeState() {
        return this.parkingBrakeState;
    }

    @Override
    public void updateInitState(boolean bl) {
        this.isInitializing = bl;
        this.getVehicleServiceListener().updateSystemState(this.isInitializing, this.isClamp15Active);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        RDK_CLAMP_STATE_CLAMP = 0;
        RDK_CLAMP_STATE_INIT = 1;
    }
}

