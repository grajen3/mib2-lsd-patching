/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.api.impl;

import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.AbtFeatureService;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.FactorySettingsService;
import de.vw.mib.asl.api.system.KeyListener;
import de.vw.mib.asl.api.system.SharedSystemCommonPersistence;
import de.vw.mib.asl.api.system.UnitChangeListener;
import de.vw.mib.asl.api.system.VelocityThresholdService;
import de.vw.mib.asl.api.system.clock.DateTimeService;
import de.vw.mib.asl.api.system.content.ContentIdValidator;
import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.input.SpaceGestureService;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.api.system.powerstate.PowerStateService;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.impl.system.FactorySettingsServiceImpl;
import de.vw.mib.asl.internal.impl.system.SharedSystemCommonPersistenceImpl;
import de.vw.mib.asl.internal.impl.system.SystemServicesProvider;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl;
import de.vw.mib.asl.internal.impl.system.clock.PropagatingDateTimeService;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;
import de.vw.mib.asl.internal.impl.system.ddp.DriverDistractionPreventionServiceImpl;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import de.vw.mib.asl.internal.system.PersistableEngineType;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.input.gesture.PropagatingSpaceGestureService;
import de.vw.mib.asl.internal.system.transformer.LanguageUpdateDataCollector;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.asl.internal.system.util.SystemUtil;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceServiceImpl;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.system.transformer.SystemCurrentLanguageConfigurationCollector;
import java.util.ArrayList;
import java.util.Calendar;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class ASLSystemAPIImpl
implements ASLSystemAPI {
    private final AsyncServiceFactory asyncServiceFactory;
    private final SharedSystemCommonPersistence sharedSystemCommonPersistence;
    private VelocityThresholdService velocityThresholdService;
    private FactorySettingsService factorySettingsService;
    private ArrayList languageData;
    private final PropagatingPowerStateService powerStateService;
    private final PropagatingDateTimeService dateTimeService;
    private final PropagatingSpaceGestureService gestureService;
    private final SystemServices systemServices = SystemServicesProvider.getSystemServices();
    private DriverDistractionPreventionService driverDistractionPreventionService;

    public ASLSystemAPIImpl() {
        SystemCommonPersistenceServiceImpl systemCommonPersistenceServiceImpl = this.createSystemCommonPersistenceService();
        this.asyncServiceFactory = this.systemServices.getAsyncServiceFactory();
        this.sharedSystemCommonPersistence = this.createSharedCommonPersistence(systemCommonPersistenceServiceImpl);
        this.powerStateService = this.systemServices.getPowerStateService();
        this.dateTimeService = this.systemServices.getDateTimeService();
        this.gestureService = this.systemServices.getSpaceGestureService();
    }

    public static void registerIds(GenericEvents genericEvents) {
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.registerService(-493076224, 0, 5610, 0, false, true);
        serviceRegister.registerService(-509853440, 0, 5609, 0, false, true);
        serviceRegister.registerService(765280512, 0, 5609, 0, false, true);
        serviceRegister.registerService(312295680, 0, 5610, 0, false, true);
        serviceRegister.registerService(580731136, 0, 5609, 0, false, true);
        serviceRegister.registerService(731726080, 0, 5609, 0, false, true);
        serviceRegister.registerService(782057728, 0, 5609, 0, false, true);
        serviceRegister.registerService(832389376, 0, 5609, 0, false, true);
        serviceRegister.registerService(815612160, 0, 5609, 0, false, true);
        serviceRegister.registerService(882721024, 0, 5609, 0, false, true);
        serviceRegister.registerService(563953920, 0, 5610, 0, false, true);
        serviceRegister.registerService(966607104, 0, 5610, 0, false, true);
    }

    @Override
    public boolean isTimeDateValid() {
        return SystemAccessor.getDateTarget().isTimeDateValid();
    }

    @Override
    public ClockTime getCurrentTime() {
        return SystemAccessor.getDateTarget().getCurrentTime();
    }

    @Override
    public byte getCurrentTimeHour() {
        return SystemAccessor.getDateTarget().getCurrentTimeHour();
    }

    @Override
    public byte getCurrentTimeMinute() {
        return SystemAccessor.getDateTarget().getCurrentTimeMinute();
    }

    @Override
    public byte getCurrentTimeSecond() {
        return SystemAccessor.getDateTarget().getCurrentTimeSecond();
    }

    @Override
    public ClockDate getCurrentDate() {
        return SystemAccessor.getDateTarget().getCurrentDate();
    }

    @Override
    public long getCurrentTimestamp() {
        return SystemAccessor.getDateTarget().getCurrentTimestamp();
    }

    @Override
    public Calendar getCurrentCalendar(int n) {
        return SystemAccessor.getDateTarget().getCurrentCalendar(n);
    }

    @Override
    public String getCurrentDateTimeAsString() {
        return SystemAccessor.getDateTarget().getCurrentDateTimeAsString();
    }

    @Override
    public int getConfiguredDistanceUnit() {
        return SystemAccessor.getUnitsTarget().getConfiguredDistanceUnit();
    }

    @Override
    public int getTemperatureUnit() {
        return SystemData.getInstance().getTemperatureUnit();
    }

    @Override
    public int getSpeedUnit() {
        return SystemData.getInstance().getSpeedUnit();
    }

    @Override
    public int getConfiguredDateFormat() {
        return SystemAccessor.getDateTarget().getConfiguredDateFormat();
    }

    @Override
    public int getConfiguredTimeFormat() {
        return SystemAccessor.getDateTarget().getConfiguredTimeFormat();
    }

    @Override
    public int mapValue(int n, int n2, int n3, int n4, int n5) {
        return SystemUtil.mapValue(n, n2, n3, n4, n5);
    }

    @Override
    public void createAndSubmitHardkeyEvent(int n, int n2) {
        SystemKeyUtil.getInstance().createAndSubmitHardkeyEvent(13, n, n2);
    }

    @Override
    public void switchPendingDisplayState() {
        SystemAccessor.getPowerManagementTarget().switchPendingDisplayState();
    }

    @Override
    public void languageDataStart() {
        this.languageData = new ArrayList();
    }

    @Override
    public void languageDataAdd(String string, boolean bl) {
        this.languageData.add(new LanguageUpdateDataCollector(string, bl));
    }

    @Override
    public void languageDataEnd() {
        ListManager.getGenericASLList(1718).updateList(this.languageData.toArray(new LanguageUpdateDataCollector[0]));
    }

    @Override
    public void updateSystemCurrentLanguageConfiguration(int n, String string, String string2, String string3, String string4) {
        Object[] objectArray = (SystemCurrentLanguageConfigurationCollector[])ListManager.getGenericASLList(3624).getDSIObjects();
        objectArray[n].system_current_language_configuration_gui = string;
        objectArray[n].system_current_language_configuration_nav__map = string2;
        objectArray[n].system_current_language_configuration_nav__announcement = string3;
        objectArray[0].system_current_language_configuration_speech = string4;
        ListManager.getGenericASLList(3624).updateList(objectArray);
    }

    @Override
    public void setXResolution(int n) {
        SystemHasBridgeImpl.getInstance().setPropertyXRes(n);
    }

    @Override
    public void setYResolution(int n) {
        SystemHasBridgeImpl.getInstance().setPropertyYRes(n);
    }

    @Override
    public void setExternalApps(boolean bl) {
        SystemAccessor.getFeaturesAndCodingTarget().setExternalApps(bl);
    }

    @Override
    public int getPrimaryEngineType() {
        return PersistableEngineType.getInstance().getPrimaryEngineType();
    }

    @Override
    public int getSecondaryEngineType() {
        return PersistableEngineType.getInstance().getSecondaryEngineType();
    }

    @Override
    public void setClimateECUhasMenuHK(boolean bl) {
        if (this.systemServices.getSystemCommonPersistenceService().loadSystemCommon().isClimateECUhasMenuHK() != bl) {
            this.systemServices.getSystemCommonPersistenceService().loadSystemCommon().setClimateECUhasMenuHK(bl);
            this.systemServices.getConfigManagerDiag().setFeatureFlagValue("ASL.Configuration.isSystem_climateMenuIconVisible", bl);
            this.systemServices.getPropertyManager().valueChangedBoolean(1620121600, bl);
            this.systemServices.getPropertyManager().valueChangedBoolean(1764892672, bl);
        }
    }

    @Override
    public void setEngineTypes(int n, int n2) {
        PersistableEngineType.getInstance().setEngineTypes(n, n2);
    }

    @Override
    public boolean getFeatureFlagValueCombustion() {
        return PersistableEngineType.getInstance().getFeatureFlagValueCombustion();
    }

    @Override
    public boolean getFeatureFlagValueBEV() {
        return PersistableEngineType.getInstance().getFeatureFlagValueBEV();
    }

    @Override
    public boolean getFeatureFlagValuePHEV() {
        return PersistableEngineType.getInstance().getFeatureFlagValuePHEV();
    }

    @Override
    public void setSWaPStatusForApplication(int n, boolean bl) {
        SystemAccessor.getFeaturesAndCodingTarget().setSWaPStatusForApplication(n, bl);
    }

    @Override
    public void addUnitChangeListener(int n, UnitChangeListener unitChangeListener) {
        UnitChangeListener unitChangeListener2 = (UnitChangeListener)this.asyncServiceFactory.create(unitChangeListener);
        SystemData.getInstance().addUnitChangeListener(n, unitChangeListener2);
    }

    @Override
    public void addKeyListener(int n, KeyListener keyListener) {
        SystemKeyUtil.getInstance().addKeyListener(0, n, keyListener);
    }

    @Override
    public void removeKeyListener(int n, KeyListener keyListener) {
        SystemKeyUtil.getInstance().removeKeyListener(0, n, keyListener);
    }

    @Override
    public void addKeyListener(int n, int n2, KeyListener keyListener) {
        SystemKeyUtil.getInstance().addKeyListener(n, n2, keyListener);
    }

    @Override
    public void removeKeyListener(int n, int n2, KeyListener keyListener) {
        SystemKeyUtil.getInstance().removeKeyListener(n, n2, keyListener);
    }

    @Override
    public SharedSystemCommonPersistence getSharedSystemCommonPersistence() {
        return this.sharedSystemCommonPersistence;
    }

    @Override
    public VelocityThresholdService getVelocityThresholdService() {
        if (this.velocityThresholdService == null) {
            this.velocityThresholdService = this.createVelocityThresholdService();
        }
        return this.velocityThresholdService;
    }

    @Override
    public FactorySettingsService getFactorySettingsService() {
        if (this.factorySettingsService == null) {
            this.factorySettingsService = this.createFactorySettingsService(this.getFactoryResetService());
        }
        return this.factorySettingsService;
    }

    @Override
    public PowerStateService getPowerStateService() {
        return this.powerStateService;
    }

    @Override
    public ValetParkingService getValetParkingService() {
        return this.systemServices.getValetParkingService();
    }

    @Override
    public AbtFeatureService getAbtFeatureService() {
        return SystemServicesProvider.getSystemServices().getAbtFeatureServiceImpl();
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        return this.systemServices.getFactoryResetService();
    }

    @Override
    public SystemStateService getSystemStateService() {
        return SystemServicesProvider.getSystemServices().getSystemStateService();
    }

    @Override
    public ProximityService getProximityService() {
        return SystemServicesProvider.getSystemServices().getProximityService();
    }

    @Override
    public DateTimeService getDateTimeService() {
        return this.dateTimeService;
    }

    @Override
    public DayNightService getDayNightService() {
        return this.systemServices.getDayNightService();
    }

    @Override
    public SpaceGestureService getSpaceGestureService() {
        return this.gestureService;
    }

    @Override
    public UserInteractionLockService getUserInteractionLockService() {
        return this.systemServices.getUserInteractionLockService();
    }

    @Override
    public ClampSignalService getClampSignalService() {
        return this.systemServices.getClampSignalService();
    }

    private FactorySettingsServiceImpl createFactorySettingsService(FactoryResetService factoryResetService) {
        return new FactorySettingsServiceImpl(factoryResetService);
    }

    private SharedSystemCommonPersistenceImpl createSharedCommonPersistence(SystemCommonPersistenceService systemCommonPersistenceService) {
        return new SharedSystemCommonPersistenceImpl(systemCommonPersistenceService);
    }

    private SystemCommonPersistenceServiceImpl createSystemCommonPersistenceService() {
        return SystemCommonPersistenceServiceImpl.getInstance();
    }

    private VelocityThresholdServiceImpl createVelocityThresholdService() {
        SystemServices systemServices = SystemServicesProvider.getSystemServices();
        DSIProxy dSIProxy = systemServices.getDsiProxy();
        Logger logger = systemServices.getAsl1Logger();
        return new VelocityThresholdServiceImpl(dSIProxy, this.asyncServiceFactory, logger);
    }

    @Override
    public DriverDistractionPreventionService getDriverDistractionPreventionService() {
        if (this.driverDistractionPreventionService == null) {
            this.driverDistractionPreventionService = this.createDriverDistractionPreventionService();
        }
        return this.driverDistractionPreventionService;
    }

    private DriverDistractionPreventionService createDriverDistractionPreventionService() {
        SystemServices systemServices = SystemServicesProvider.getSystemServices();
        DSIProxy dSIProxy = systemServices.getDsiProxy();
        Logger logger = systemServices.getAsl1Logger();
        ThreadSwitchingTarget threadSwitchingTarget = systemServices.getThreadSwitcher();
        ASLCarVehicleAPI aSLCarVehicleAPI = systemServices.getAslCarVehicleApi();
        ASLDiagnosisAPI aSLDiagnosisAPI = systemServices.getAslDiagnosisApi();
        ClampSignalService clampSignalService = systemServices.getClampSignalService();
        DdpInfoCollector ddpInfoCollector = new DdpInfoCollector(logger, dSIProxy, aSLCarVehicleAPI, aSLDiagnosisAPI, clampSignalService);
        return new DriverDistractionPreventionServiceImpl(logger, threadSwitchingTarget, ddpInfoCollector);
    }

    @Override
    public StageContentRequestProcessor getStageContentRequestProcessor() {
        return this.systemServices.getStageContentRequestProcessor();
    }

    @Override
    public ContentIdValidator getContentIdValidator() {
        return this.systemServices.getContentIdValidator();
    }

    @Override
    public EmergencyAnnouncementService getEmergencyAnnouncementService() {
        return this.systemServices.getEmergencyAnnouncementService();
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -358858496);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -308526848);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -291749632);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -274972416);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -258195200);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -241417984);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -224640768);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -207863552);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -191086336);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -174309120);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -342081280);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -157531904);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -325304064);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -123977472);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -90423040);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5608, -107200256);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5602, 429736192);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5602, 463290624);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5607, 278741248);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5600, -425967360);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5600, 329072896);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5600, 412958976);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 446513408, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 496845056);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 513622272, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 865943808, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 899498240);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 983384320);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 1000161536);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5601, 614285568);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5601, 597508352);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5601, 161300736);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5609, 1091977216);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5609, 1108754432);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 855965760);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1678049344);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1694826560);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1627717696);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1644494912);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1527054400);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1543831616);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1174732864);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 990183488);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 0x45050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 973406272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 0x44050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 956629056);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1124401216);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 939851840);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 1107624000);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 923074624);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5600, -459521792);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1560608832);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1661272128);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1778712640);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1308950592);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1292173376);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 1594163264);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 0x40050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, 587931712);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5607, -459521792);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 429736192);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 872742976);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 1191510080);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, -631499520);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 1610940480);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, -1106706368);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, -1089929152);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 1728380992);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, -1156972480);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 839589952);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5602, 856367168);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5608, -107200256);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5608, 1040515136);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5608, 1057292352);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 1208287296);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 1225064512);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 889520192);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 906297408);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 1359282240);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5601, 0x54050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 345850112);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 496845056);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 1577386048);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 1493499968);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 1091248192);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 899498240);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 983384320);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 1000161536);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 554377280);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5603, 865943808);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5604, 1325727808);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5604, 1258618944);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5604, 0x55050040);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5604, 1510277184);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5604, 1275396160);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, -2075192832);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, 17432640);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, 34209856);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, 587857984);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5609, 1091977216);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5609, 949829888);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5609, 933052672, true);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5610, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5610, 1745158208);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5610, 1459945536);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5610, -1627324352);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5610, -1576992704);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5611, -938934208);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5611, -905379776);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5611, -922156992);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5611, 923402304);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5612, -140754688);
        PreRegisteredIds.addServiceOrObserverToArray(2, 5612, 513622272);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 379404544, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 362627328, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 178077952, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 396181760, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 10305792, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5600, 345850112, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5602, 110969088, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5610, -409190144, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5610, 530399488, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5610, 849166592, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, -459521792, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, -442744576, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, -476299008, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 798834944, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 1016938752, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 5603, 1033715968, true);
    }
}

