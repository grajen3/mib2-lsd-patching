/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.media.services.sources.MediaEjectionService;
import de.vw.mib.asl.api.media.services.sources.SourceId;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.contentprocessor.ContentProcessorManager;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListenerAdapter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.RuntimeGeneratedConstants;
import de.vw.mib.asl.internal.impl.system.SystemServicesInstaller;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.ddp.DdpGetterNhtsaSpeedLimitExceeded;
import de.vw.mib.asl.internal.impl.system.systemstate.SystemStateServiceImpl;
import de.vw.mib.asl.internal.system.AslCopyrightFetcher;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$1;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$2;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$3;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$4;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$5;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$6;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$7;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral$8;
import de.vw.mib.asl.internal.system.MediaDeviceUpdater;
import de.vw.mib.asl.internal.system.OffclockLayoutNvListener;
import de.vw.mib.asl.internal.system.PersonalizationResetAvailablityUpdater;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureUpdater;
import de.vw.mib.asl.internal.system.ambient.ColorSRGBUpdater;
import de.vw.mib.asl.internal.system.has.AslTargetSystemHas;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.input.InputDeviceRegistrator;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureManager;
import de.vw.mib.asl.internal.system.keypanel.SensorKeyToneManager;
import de.vw.mib.asl.internal.system.processor.stage.CarPreventClimateOnKoreaEwsPermission;
import de.vw.mib.asl.internal.system.processor.stage.SmiPreventDisplayOnKoreaEwsPermission;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdmin;
import de.vw.mib.asl.internal.system.setup.SetupTarget;
import de.vw.mib.asl.internal.system.util.SystemLogger;
import de.vw.mib.asl.internal.system.util.SystemUtil;
import de.vw.mib.asl.internal.system.util.VersionNumberUpdater;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.carkombi.DSICarKombi;
import org.dsi.ifc.carkombi.DSICarKombiListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.global.CarBCTemperature;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagement;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;

public final class AslTargetSystemGeneral
extends AbstractASLTarget
implements DSIServiceStateListener {
    private static final int OUTSIDE_TEMPERATURE_MULTIPLIER;
    String copyrightPath = null;
    String copyrightIndexPath = null;
    MediaEjectionService mediaEjectionService;
    private SystemData systemData = SystemData.getInstance();
    private boolean valueClamp15 = false;
    private boolean nightDesign = false;
    private boolean dayNightMode = false;
    private boolean dayNightInitallyTriggered = false;
    private CarBCTemperature outsideTemperature;
    private boolean outsideTemperatureValid = false;
    private CarViewOption outsideTemperatureViewOption = null;
    private boolean naviTargetReady = false;
    private final SystemServices systemServices = SystemServicesProvider.getSystemServices();
    private final DSIProxy dsiProxy = this.systemServices.getDsiProxy();
    private final ASLStartupv7rAPI aslStartupv7rAPI = this.systemServices.getAslStartupv7rAPI();
    private final SystemCommonPersistenceServiceImpl systemCommonPersistenceService = SystemCommonPersistenceServiceImpl.getInstance();
    private final ConfigurationManagerDiag configManagerDiag = this.systemServices.getConfigManagerDiag();
    private final PersonalizationService personalizationService = this.systemServices.getPersonalizationService();
    private final ASLPropertyManager propertyManager = this.systemServices.getPropertyManager();
    private final SystemEventDispatcher systemEventDispatcher = this.systemServices.getSystemEventDispatcher();
    private AslCopyrightFetcher fetcher = null;
    private SystemCommon systemCommonPersistence;
    private DSIGeneralVehicleStates dsiGeneralVehicleStates;
    private DSIListener dsiGeneralVehicleStatesListener;
    private SystemLogger systemLogger;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$DSIPowerManagement;

    public AslTargetSystemGeneral(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.initializeTarget();
    }

    public AslTargetSystemGeneral(GenericEvents genericEvents, String string) {
        super(genericEvents, string);
        this.initializeTarget();
    }

    private void initializeTarget() {
        SystemAccessor.setGeneralTarget(this);
        this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = AslTargetSystemGeneral.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi, this);
        this.systemLogger = new SystemLogger(this.systemServices.getAsl1Logger(), super.getClass());
    }

    @Override
    public int getSubClassifier() {
        return 2048;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 5: {
                this.processPing(eventGeneric);
                break;
            }
            case 106: {
                this.processPowerOn();
                break;
            }
            case 4300062: {
                this.systemLogger.trace("Event ASLSystemServiceIds.RELOAD_PERSISTABLES received.");
                this.initDataFromPersistence();
                break;
            }
            case 4300057: {
                String string = eventGeneric.getString(0);
                if (string == null) {
                    string = "NO DB DATA";
                    this.systemLogger.warn("Event ASLSystemServiceIds.NAV_DB_VERSION received. Nav DB version is null.");
                } else {
                    this.systemLogger.trace(new Object[]{"Event ASLSystemServiceIds.NAV_DB_VERSION received. Nav DB version: ", string});
                }
                AslTargetSystemGeneral.writeStringToDatapool(1613, string);
                break;
            }
            case 1073744318: {
                this.processAslDownLoadCopyrightInfo();
                break;
            }
            case 1073744319: {
                this.processAslDownUnloadCopyrightInfo();
                break;
            }
            case 1073743175: {
                int n = eventGeneric.getInt(0);
                AslTargetSystemGeneral.writeIntegerToDatapool(1612, n);
                break;
            }
            case 1073743200: {
                this.processAslDownToggleSpellerLayout();
                break;
            }
            case 1073743207: {
                this.processAslDownUnmountUsbStorage(0);
                break;
            }
            case 1073744571: {
                this.processAslDownUnmountUsbStorage(1);
                break;
            }
            case 1075841842: {
                this.processAslDownUnmountUsbStorage(2);
                break;
            }
            case 1075841843: {
                this.processAslDownUnmountUsbStorage(3);
                break;
            }
        }
    }

    @Override
    public void registered(String string, int n) {
        String string2 = string.intern();
        if (string2 == RuntimeGeneratedConstants.SERVICE_TS_NS[23]) {
            this.setNotificationForCarKombi();
            this.dsiProxy.removeServiceStateListener(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = AslTargetSystemGeneral.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi, this);
        }
    }

    @Override
    public void unregistered(String string, int n) {
    }

    void dsiGeneralVehicleStatesUpdateDisplayDayNightDesign(boolean bl) {
        this.systemLogger.trace(new Object[]{"dsiGeneralVehicleStatesUpdateDisplayDayNightDesign called. displayNightDesign = ", new Boolean(bl)});
        this.nightDesign = bl;
        this.processDayNight(this.configManagerDiag.getSystemDayNightModeDefault());
    }

    void dsiCarKombiUpdateBCViewOptions(BCViewOptions bCViewOptions) {
        this.outsideTemperatureViewOption = bCViewOptions.outsideTemperature;
        this.updateOutsideTemperatureAvailability();
    }

    void dsiCarKombiUpdateBCOutsideTemperature(CarBCTemperature carBCTemperature) {
        this.outsideTemperature = carBCTemperature;
        this.systemLogger.trace(new Object[]{"dsiCarKombiUpdateBCOutsideTemperature called. ", carBCTemperature});
        this.updateOutsideTemperature();
    }

    void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal) {
        this.valueClamp15 = clampSignal.clamp15;
        this.updateOutsideTemperatureAvailability();
    }

    @Override
    public int getDefaultTargetId() {
        return 5602;
    }

    boolean isNaviTargetReady() {
        return this.naviTargetReady;
    }

    void updateOutsideTemperature() {
        this.updateOutsideTemperatureAvailability();
        if (this.outsideTemperature != null) {
            float f2 = this.outsideTemperature.temperatureValue;
            if (this.outsideTemperature.temperatureUnit == 0) {
                if (this.systemData.getTemperatureUnit() == 1) {
                    f2 = SystemUtil.getTemperatureCelsius2Fahrenheit(f2);
                }
            } else if (this.outsideTemperature.temperatureUnit == 1 && this.systemData.getTemperatureUnit() == 0) {
                f2 = SystemUtil.getTemperatureFahrenheit2Celsius(f2);
            }
            int n = (int)(f2 * 8257);
            this.systemLogger.trace(new Object[]{"updateOutsideTemperature: Write temperature to datapool: ", new Integer(n)});
            AslTargetSystemGeneral.writeIntegerToDatapool(1614, n);
        }
    }

    void loadDataFromSystemCommonPersistence() {
        this.systemCommonPersistence = this.systemCommonPersistenceService.loadSystemCommon();
        AslTargetSystemGeneral.writeIntegerToDatapool(1629, this.systemCommonPersistence.getSpellerLayout());
        AslTargetSystemGeneral.writeBooleanToDatapool(1764892672, this.systemCommonPersistence.isClimateECUhasMenuHK());
    }

    void processRevertSystemGeneral() {
        this.systemLogger.trace("processRevertSystemGeneral called.");
        int n = this.configManagerDiag.getSystemSpellerLayoutDefault();
        if (this.systemCommonPersistence.getSpellerLayout() != n) {
            this.systemCommonPersistence.setSpellerLayout(n);
            AslTargetSystemGeneral.writeIntegerToDatapool(1629, n);
        }
        int n2 = this.configManagerDiag.getSystemDayNightModeDefault();
        this.processDayNight(n2);
        AslTargetSystemGeneral.writeIntegerToDatapool(1602, n2);
    }

    private void processAslDownToggleSpellerLayout() {
        int n = this.systemCommonPersistence.getSpellerLayout() == 0 ? 1 : 0;
        this.systemCommonPersistence.setSpellerLayout(n);
        AslTargetSystemGeneral.writeIntegerToDatapool(1629, n);
    }

    private void initDataFromPersistence() {
        int n = this.configManagerDiag.getSystemDayNightModeDefault();
        AslTargetSystemGeneral.writeIntegerToDatapool(1602, n);
        this.processDayNight(n);
        this.loadDataFromSystemCommonPersistence();
        this.systemCommonPersistenceService.addProfileChangeListener(this.createProfileChangeListener());
    }

    private AbstractProfileChangeHandler createProfileChangeListener() {
        return new AslTargetSystemGeneral$1(this);
    }

    private void processPowerOn() {
        this.systemLogger.trace("processPowerOn called.");
        this.registerPersonalizationResetAvailabilityUpdater();
        this.registerMediaDeviceUpdater();
        if (!this.aslStartupv7rAPI.isNonCustomerSwdlIsInProgress()) {
            this.systemLogger.trace("processPowerOn: no SWDL in progress (enter).");
            this.setNotificationForPowerManagement();
            this.setNotificationForGeneralVehicleStates();
            this.dsiProxy.addServiceStateListener(class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemGeneral.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates, this.createDsiServiceStateAdapter());
            this.initDataFromPersistence();
            this.instantiateHasTarget();
            new AbtFeatureUpdater(this.systemServices);
            this.createSystemStateService();
            this.createProximityServie();
            new SetupTarget(this.systemServices);
            new SensorKeyToneManager(this.systemServices);
            new VersionNumberUpdater(this.systemServices).run();
            this.createDayNightService();
            new ColorSRGBUpdater(this.systemServices.getBundleContext(), this.systemServices.getSystemHasBridge()).registerAmbientHmiAndSrgbColor();
            new SpaceGestureManager(this.systemServices).run();
            this.registerFactoryResetParticipant();
            this.initOffclockLayout();
            ASLSystemFactory.getSystemApi().getDriverDistractionPreventionService().addDriverDistractionPreventionListener(new DdpGetterNhtsaSpeedLimitExceeded(this.systemServices.getPropertyManager()));
            this.systemLogger.trace("processPowerOn: no SWDL in progress (exit).");
        }
        ContentProcessorManager contentProcessorManager = this.systemServices.getContentProcessorManager();
        StageContentProcessor stageContentProcessor = this.systemServices.getStageContentProcessor();
        contentProcessorManager.registerContentProcessor(stageContentProcessor);
        this.createAndAddStageContentPermissions();
        new InputDeviceRegistrator(this.systemServices).registerInputDevices();
    }

    private void createAndAddStageContentPermissions() {
        StageContentRequestAdmin stageContentRequestAdmin = this.systemServices.getStageContentRequestAdmin();
        stageContentRequestAdmin.addPermission(new CarPreventClimateOnKoreaEwsPermission(this.systemServices.getEmergencyAnnouncementService()));
        stageContentRequestAdmin.addPermission(new SmiPreventDisplayOnKoreaEwsPermission(this.systemServices.getEmergencyAnnouncementService()));
    }

    private void createDayNightService() {
        this.systemServices.getDayNightService();
    }

    private void createProximityServie() {
        this.systemServices.getProximityService();
    }

    private void initOffclockLayout() {
        int n = this.systemCommonPersistence.getOffclockLayout();
        this.configManagerDiag.setOffClockLayout(n);
        OffclockLayoutNvListener offclockLayoutNvListener = new OffclockLayoutNvListener(this.systemCommonPersistence, this.configManagerDiag);
        this.configManagerDiag.addNvListener(offclockLayoutNvListener, 5);
    }

    private void registerFactoryResetParticipant() {
        FactoryResetService factoryResetService = SystemServicesProvider.getSystemServices().getFactoryResetService();
        AslTargetSystemGeneral$2 aslTargetSystemGeneral$2 = new AslTargetSystemGeneral$2(this);
        factoryResetService.addParticipant(aslTargetSystemGeneral$2, FactoryResetComponents.SYSTEM);
    }

    private void registerMediaDeviceUpdater() {
        ASLComponentRegistry aSLComponentRegistry = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLComponentRegistry();
        this.acquireMediaIndicationService(aSLComponentRegistry);
        this.acquireMediaEjectionService(aSLComponentRegistry);
    }

    private void acquireMediaEjectionService(ASLComponentRegistry aSLComponentRegistry) {
        aSLComponentRegistry.requestAPI(class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService == null ? (class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService = AslTargetSystemGeneral.class$("de.vw.mib.asl.api.media.services.sources.MediaEjectionService")) : class$de$vw$mib$asl$api$media$services$sources$MediaEjectionService, new AslTargetSystemGeneral$3(this));
    }

    private void acquireMediaIndicationService(ASLComponentRegistry aSLComponentRegistry) {
        Logger logger = SystemServicesProvider.getSystemServices().getAsl1Logger();
        MediaDeviceUpdater mediaDeviceUpdater = new MediaDeviceUpdater(this.propertyManager, this.systemEventDispatcher, logger);
        aSLComponentRegistry.requestAPI(class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService == null ? (class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService = AslTargetSystemGeneral.class$("de.vw.mib.asl.api.media.services.sources.medialist.MediaIndicationService")) : class$de$vw$mib$asl$api$media$services$sources$medialist$MediaIndicationService, new AslTargetSystemGeneral$4(this, mediaDeviceUpdater));
    }

    private void createSystemStateService() {
        SystemStateServiceImpl systemStateServiceImpl = new SystemStateServiceImpl(SystemCommonPersistenceServiceImpl.getInstance());
        new SystemServicesInstaller().installSystemStateService(systemStateServiceImpl);
    }

    private void registerPersonalizationResetAvailabilityUpdater() {
        PersonalizationResetAvailablityUpdater personalizationResetAvailablityUpdater = new PersonalizationResetAvailablityUpdater(this.propertyManager);
        this.personalizationService.addListener(personalizationResetAvailablityUpdater);
        boolean bl = this.personalizationService.getResetState() == 3;
        personalizationResetAvailablityUpdater.updateDatapoolValue(bl);
    }

    private void instantiateHasTarget() {
        try {
            new AslTargetSystemHas(this.getMainObject(), SystemHasBridgeImpl.getInstance());
        }
        catch (Exception exception) {
            this.systemLogger.error("AslTargetSystemHas could not be instantiated.");
        }
    }

    private void processDayNight(int n) {
        this.systemLogger.trace("processDayNight called.");
        int n2 = n;
        if (n == 2) {
            n2 = this.nightDesign ? 1 : 0;
        }
        AslTargetSystemGeneral.writeIntegerToDatapool(1583, n2);
        this.triggerDayNightService(0 == n2);
        SystemHasBridgeImpl.getInstance().setPropertyDayNightState(n2);
    }

    void setNotificationForGeneralVehicleStates() {
        this.systemLogger.trace("setNotificationForGeneralVehicleStates called.");
        try {
            if (this.dsiGeneralVehicleStatesListener == null) {
                this.dsiGeneralVehicleStates = (DSIGeneralVehicleStates)this.dsiProxy.getService(this, class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates == null ? (class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates = AslTargetSystemGeneral.class$("org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates")) : class$org$dsi$ifc$generalvehiclestates$DSIGeneralVehicleStates);
                this.dsiGeneralVehicleStatesListener = this.createDsiGeneralVehicleStatesListener();
            }
            this.dsiGeneralVehicleStates.setNotification(16, this.dsiGeneralVehicleStatesListener);
        }
        catch (Exception exception) {
            this.systemLogger.warn("Could not connect to DSIGeneralVehicleStates.");
        }
    }

    private DSIGeneralVehicleStatesListener createDsiGeneralVehicleStatesListener() {
        return new AslTargetSystemGeneral$5(this);
    }

    private void setNotificationForPowerManagement() {
        this.systemLogger.trace("setNotificationForPowerManagement called.");
        DSIPowerManagementListener dSIPowerManagementListener = this.createDsiPowerManagementListener();
        DSIPowerManagement dSIPowerManagement = (DSIPowerManagement)this.dsiProxy.getService(this, class$org$dsi$ifc$powermanagement$DSIPowerManagement == null ? (class$org$dsi$ifc$powermanagement$DSIPowerManagement = AslTargetSystemGeneral.class$("org.dsi.ifc.powermanagement.DSIPowerManagement")) : class$org$dsi$ifc$powermanagement$DSIPowerManagement);
        dSIPowerManagement.setNotification(4, (DSIListener)dSIPowerManagementListener);
    }

    private DSIPowerManagementListener createDsiPowerManagementListener() {
        return new AslTargetSystemGeneral$6(this);
    }

    private void setNotificationForCarKombi() {
        this.systemLogger.trace("setNotificationForCarKombi called.");
        DSICarKombiListener dSICarKombiListener = this.createDsiCarKombiListener();
        DSICarKombi dSICarKombi = (DSICarKombi)this.dsiProxy.getService(this, class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = AslTargetSystemGeneral.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        dSICarKombi.setNotification(new int[]{65, 4}, (DSIListener)dSICarKombiListener);
    }

    private DSICarKombiListener createDsiCarKombiListener() {
        return new AslTargetSystemGeneral$7(this);
    }

    private void triggerDayNightService(boolean bl) {
        boolean bl2 = false;
        if (!this.dayNightInitallyTriggered) {
            bl2 = true;
            this.dayNightInitallyTriggered = true;
        }
        if (bl != this.dayNightMode) {
            bl2 = true;
            this.dayNightMode = bl;
        }
        if (bl2) {
            EventGeneric eventGeneric = this.systemServices.getEventFactory().newEvent();
            eventGeneric.setBoolean(0, !bl);
            this.triggerObserver(110969088, eventGeneric);
        }
    }

    private void updateOutsideTemperatureAvailability() {
        boolean bl = false;
        if (this.outsideTemperatureViewOption != null && this.outsideTemperatureViewOption.state == 2 && this.valueClamp15 && this.outsideTemperature != null && this.outsideTemperature.state == 1) {
            bl = true;
        }
        if (bl != this.outsideTemperatureValid) {
            this.outsideTemperatureValid = bl;
            AslTargetSystemGeneral.writeBooleanToDatapool(1677, bl);
        }
    }

    private void readCopyrightPaths() {
        this.copyrightPath = this.configManagerDiag.getCopyrightFilePath();
        this.copyrightIndexPath = this.configManagerDiag.getCopyrightIndexFilePath();
    }

    private void processAslDownLoadCopyrightInfo() {
        this.systemLogger.trace("processAslDownLoadCopyrightInfo called.");
        this.readCopyrightPaths();
        if (this.copyrightPath != null && this.copyrightIndexPath != null) {
            this.fetcher = new AslCopyrightFetcher(this);
        } else {
            this.systemLogger.error("Copyright paths could not be retrieved!");
        }
        this.systemLogger.trace("processAslDownLoadCopyrightInfo done.");
    }

    private void processAslDownUnloadCopyrightInfo() {
        this.systemLogger.trace("processAslDownUnloadCopyrightInfo called.");
        if (this.fetcher != null) {
            this.fetcher.close();
            this.fetcher = null;
        }
        this.copyrightPath = null;
        this.copyrightIndexPath = null;
    }

    private void processAslDownUnmountUsbStorage(int n) {
        this.mediaEjectionService.eject(new SourceId(2, n), null);
    }

    private void processPing(EventGeneric eventGeneric) {
        int n = eventGeneric.getSenderTargetId();
        switch (n) {
            case 1330009: {
                this.systemLogger.trace("Received PING from Navigation target, send value of nightDesign.");
                this.naviTargetReady = true;
                SystemAccessor.getUnitsTarget().triggerDistanceUnitChanged();
                if (!this.configManagerDiag.isFeatureFlagSet(400)) break;
                this.triggerObserver(463290624, null);
                break;
            }
            case 0x111700: {
                this.systemLogger.trace("Received PING from ASL_DISPLAYMANAGEMENT_INTERNAL_TARGET, send rvc and ami flags and inform power management.");
                SystemAccessor.getPowerManagementTarget().pingByDisplayManagement();
                SystemAccessor.getFeaturesAndCodingTarget().pingByDisplayManagement();
                break;
            }
            case 7800: {
                this.systemLogger.trace("Received PING from ASL_CONNECTIVITY_WLAN, send WLAN coding status.");
                SystemAccessor.getFeaturesAndCodingTarget().pingByWlan();
                break;
            }
            default: {
                this.systemLogger.trace(new Object[]{"processPing unimplemented senderTargetId ", new Integer(n), "."});
            }
        }
    }

    private DSIServiceStateListenerAdapter createDsiServiceStateAdapter() {
        return new AslTargetSystemGeneral$8(this);
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

