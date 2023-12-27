/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.parking.ASLParkingAPI;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.globalsetupwizard.ASLGlobalSetupWizardFactory;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.api.system.content.ContentIdValidator;
import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.api.system.contentprocessor.ContentProcessorManager;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.api.testmode.ASLTestmodeFactory;
import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.internal.impl.system.SystemServicesImpl$1;
import de.vw.mib.asl.internal.impl.system.SystemServicesImpl$2;
import de.vw.mib.asl.internal.impl.system.SystemServicesOsgiUtil;
import de.vw.mib.asl.internal.impl.system.clock.DateTimeServiceImpl;
import de.vw.mib.asl.internal.impl.system.clock.PropagatingDateTimeService;
import de.vw.mib.asl.internal.impl.system.content.ContentIdValidatorImpl;
import de.vw.mib.asl.internal.impl.system.content.StageContentRequestProcessorImpl;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetServiceFactory;
import de.vw.mib.asl.internal.impl.system.powerstate.ClampSignalServiceImpl;
import de.vw.mib.asl.internal.impl.system.powerstate.PowerStateServiceImpl;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import de.vw.mib.asl.internal.system.AslTargetSystemProximity;
import de.vw.mib.asl.internal.system.SystemAccessor;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureServiceImpl;
import de.vw.mib.asl.internal.system.daynight.DayNightServiceImpl;
import de.vw.mib.asl.internal.system.emergency.EmergencyAnnouncementServiceImpl;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.asl.internal.system.has.SystemHasBridgeImpl;
import de.vw.mib.asl.internal.system.input.UserInteractionLockServiceImpl;
import de.vw.mib.asl.internal.system.input.gesture.PropagatingSpaceGestureService;
import de.vw.mib.asl.internal.system.input.gesture.SpaceGestureServiceImpl;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.processor.ContentProcessorManagerFactory;
import de.vw.mib.asl.internal.system.processor.manager.ClockManager;
import de.vw.mib.asl.internal.system.processor.manager.MenuManager;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdmin;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdminImpl;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceFactory;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceFactory;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceServiceImpl;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceService;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceServiceImpl;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class SystemServicesImpl
implements SystemServices {
    private final EventFactory eventFactory;
    private final ConfigurationManagerDiag configManagerDiag;
    private final SystemEventDispatcher systemEventDispatcher;
    private final AslPersistenceSyncApi persistenceSyncApi;
    private final ASLPropertyManager aslPropertyManager;
    private final DSIProxy dsiProxy;
    private final ServiceRegister serviceRegister;
    private final Logger asl1Logger;
    private final Logger asl2Logger;
    private final IPersistableEarlyData persistableEarlyData;
    private final ThreadSwitchingTarget aslThreadSwitcher;
    private final TimerManager timerManager;
    private final PropagatingPowerStateService powerStateService;
    private final DSIProxyAdapterFactory dsiProxyAdapterFactory;
    private final BundleContext bundleContext;
    private final ASLStartupv7rAPI aslStartupv7rAPI;
    private final PersonalizationService personalizationService;
    private final AsyncServiceFactory asyncServiceFactory;
    private final ASLCarVehicleAPI aslCarVehicleApi;
    private final SystemCommonPersistenceService systemCommonPersistenceService;
    private final KeyLockManager keyLockManager;
    private final ValetParkingTestmodeService valetParkingTestmodeService;
    private final EventDispatcherHSM eventDispatcher;
    private final ASLOnlineCoreServices onlineCoreServices;
    private final ASLParkingAPI parkingAPI;
    private final ASLDiagnosisAPI aslDiagnosisApi;
    private SystemEarlyPersistenceService systemEarlyPersistenceService;
    private CioDictionary cioDictionary;
    private CioDispatcher cioDispatcher;
    private ValetParkingService valetParkingService;
    private GenericEvents genericEvents;
    private AbtFeatureServiceImpl abtFeatureServiceImpl;
    private SystemStateService systemStateService;
    private FactoryResetService factoryResetService;
    private ProximityServiceImpl proximityService;
    private ClockManager standByClockManager;
    private ClockManager displayOffClockManager;
    private CioFactory cioFactory;
    private WizardService wizardService;
    private PropagatingDateTimeService dateTimeService;
    private DayNightService dayNightService;
    private PropagatingSpaceGestureService gestureService;
    private ClampSignalService clampSignalService;
    private UserInteractionLockService userInteractionLockService;
    private ConfigurationManagerAsyncValueSetterService asyncValueSetterService;
    private ContentProcessorManager contentProcessorManager;
    private EmergencyAnnouncementService eaService;
    private MenuManager menuManager;
    private StageContentProcessor stageContentProcessor;
    private StageContentRequestProcessor stageContentRequestProcessor;
    private StageContentRequestAdmin stageContentRequestAdmin;
    private ContentIdValidatorImpl contentIdValidator;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService;

    SystemServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.eventFactory = services.getEventFactory();
        this.configManagerDiag = services.getConfigurationManagerDiag();
        this.systemEventDispatcher = services.getSystemEventDispatcher();
        this.aslPropertyManager = services.getASLPropertyManager();
        this.aslThreadSwitcher = services.getASLThreadSwitch();
        this.persistenceSyncApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.dsiProxyAdapterFactory = this.dsiProxy.getAdapterFactory();
        this.asl1Logger = aSLFrameworkAPI.getASLLogger();
        this.asl2Logger = aSLFrameworkAPI.getASL2Logger();
        this.serviceRegister = services.getGenericEvents().getServiceRegister();
        this.persistableEarlyData = ASLStartupv7rFactory.getStartupv7rApi().getPersistableEarlyData();
        this.timerManager = services.getTimerManager();
        this.powerStateService = new PowerStateServiceImpl();
        this.bundleContext = services.getBundleContext();
        this.aslStartupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
        this.genericEvents = services.getGenericEvents();
        this.personalizationService = ASLCarFactory.getCarApi().getCarPersonalizationService();
        this.asyncServiceFactory = this.retrieveAsyncFactory(this.bundleContext, this.asl1Logger);
        this.aslCarVehicleApi = ASLCarFactory.getCarApi().getCarVehicleAPI();
        this.valetParkingTestmodeService = ASLTestmodeFactory.getTestmodeApi().getTestmodeValetParkingService();
        this.systemEarlyPersistenceService = SystemEarlyPersistenceServiceImpl.getInstance();
        this.systemCommonPersistenceService = SystemCommonPersistenceServiceImpl.getInstance();
        this.keyLockManager = new KeyLockManager(this.asl1Logger);
        this.eventDispatcher = this.genericEvents.getEventDispatcher();
        this.onlineCoreServices = ASLOnlineFactory.getOnlineCoreServices();
        this.parkingAPI = ASLCarFactory.getParkingApi();
        this.dateTimeService = new DateTimeServiceImpl();
        this.gestureService = new SpaceGestureServiceImpl();
        this.aslDiagnosisApi = ASLDiagnosisFactory.getDiagnosisApi();
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public Logger getAsl1Logger() {
        return this.asl1Logger;
    }

    @Override
    public IPersistableEarlyData getPersistableEarlyData() {
        return this.persistableEarlyData;
    }

    @Override
    public EventFactory getEventFactory() {
        return this.eventFactory;
    }

    @Override
    public ConfigurationManagerDiag getConfigManagerDiag() {
        return this.configManagerDiag;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.systemEventDispatcher;
    }

    @Override
    public AslPersistenceSyncApi getPersistence() {
        return this.persistenceSyncApi;
    }

    @Override
    public ASLPropertyManager getPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public DSIProxy getDsiProxy() {
        return this.dsiProxy;
    }

    @Override
    public AslTargetSystemProximity getProximityTarget() {
        return SystemAccessor.getProximityTarget();
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitcher() {
        return this.aslThreadSwitcher;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public PropagatingPowerStateService getPowerStateService() {
        return this.powerStateService;
    }

    @Override
    public DSIProxyAdapterFactory getDsiProxyAdapterFactory() {
        return this.dsiProxyAdapterFactory;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public ASLStartupv7rAPI getAslStartupv7rAPI() {
        return this.aslStartupv7rAPI;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public PersonalizationService getPersonalizationService() {
        return this.personalizationService;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        return this.asyncServiceFactory;
    }

    @Override
    public ASLCarVehicleAPI getAslCarVehicleApi() {
        return this.aslCarVehicleApi;
    }

    @Override
    public ASLDiagnosisAPI getAslDiagnosisApi() {
        return this.aslDiagnosisApi;
    }

    @Override
    public AbtFeatureServiceImpl getAbtFeatureServiceImpl() {
        if (this.abtFeatureServiceImpl == null) {
            AbtFeatures abtFeatures = this.systemCommonPersistenceService.loadAbtFeatures();
            this.abtFeatureServiceImpl = new AbtFeatureServiceImpl(abtFeatures);
        }
        return this.abtFeatureServiceImpl;
    }

    @Override
    public SystemEarlyPersistenceService getEarlyPersistenceService() {
        return this.systemEarlyPersistenceService;
    }

    @Override
    public KeyLockManager getKeyLockManager() {
        return this.keyLockManager;
    }

    @Override
    public SystemStateService getSystemStateService() {
        return this.systemStateService;
    }

    public void setSystemStateService(SystemStateService systemStateService) {
        this.systemStateService = systemStateService;
    }

    @Override
    public SystemCommonPersistenceService getSystemCommonPersistenceService() {
        return this.systemCommonPersistenceService;
    }

    @Override
    public FactoryResetService getFactoryResetService() {
        if (this.factoryResetService == null) {
            this.factoryResetService = new FactoryResetServiceFactory(this).createFactoryResetService();
        }
        return this.factoryResetService;
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        if (this.cioDispatcher == null) {
            this.cioDispatcher = (CioDispatcher)this.getOsgiService(this.bundleContext, class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = SystemServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher);
        }
        return this.cioDispatcher;
    }

    @Override
    public CioDictionary getCioDictionary() {
        if (this.cioDictionary == null) {
            this.cioDictionary = (CioDictionary)this.getOsgiService(this.bundleContext, class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = SystemServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary);
        }
        return this.cioDictionary;
    }

    @Override
    public ValetParkingService getValetParkingService() {
        if (this.valetParkingService == null) {
            this.valetParkingService = this.createValetParkingService(this.systemCommonPersistenceService);
        }
        return this.valetParkingService;
    }

    @Override
    public ValetParkingTestmodeService getValetParkingTestmodeService() {
        return this.valetParkingTestmodeService;
    }

    @Override
    public ProximityServiceImpl getProximityService() {
        if (this.proximityService == null) {
            this.proximityService = new ProximityServiceFactory().createProximityService(this);
        }
        return this.proximityService;
    }

    @Override
    public ClockManager getClockManager() {
        if (this.standByClockManager == null) {
            SystemServicesImpl$1 systemServicesImpl$1 = new SystemServicesImpl$1(this);
            this.standByClockManager = new ClockManager(this, -190180096, 1577386048, 1693, systemServicesImpl$1);
        }
        return this.standByClockManager;
    }

    @Override
    public ClockManager getDisplayOffClockManager() {
        if (this.displayOffClockManager == null) {
            SystemServicesImpl$2 systemServicesImpl$2 = new SystemServicesImpl$2(this);
            this.displayOffClockManager = new ClockManager(this, -106294016, 1091248192, 1731338240, systemServicesImpl$2);
        }
        return this.displayOffClockManager;
    }

    @Override
    public SystemKeyUtil getSystemKeyUtil() {
        return SystemKeyUtil.getInstance();
    }

    @Override
    public EventDispatcherHSM getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public CioFactory getCioFactory() {
        if (this.cioFactory == null) {
            this.cioFactory = (CioFactory)this.getOsgiService(this.bundleContext, class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = SystemServicesImpl.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory);
        }
        return this.cioFactory;
    }

    @Override
    public SystemHasBridge getSystemHasBridge() {
        return SystemHasBridgeImpl.getInstance();
    }

    @Override
    public WizardService getWizardService() {
        if (this.wizardService == null) {
            this.wizardService = ASLGlobalSetupWizardFactory.getGlobalSetupWizardApi().getWizardService();
        }
        return this.wizardService;
    }

    @Override
    public ASLOnlineCoreServices getOnlineCoreServices() {
        return this.onlineCoreServices;
    }

    @Override
    public ASLParkingAPI getParkingAPI() {
        return this.parkingAPI;
    }

    @Override
    public PropagatingDateTimeService getDateTimeService() {
        return this.dateTimeService;
    }

    @Override
    public DayNightService getDayNightService() {
        if (this.dayNightService == null) {
            this.dayNightService = new DayNightServiceImpl(this.getDsiProxy(), this.getAsl1Logger());
        }
        return this.dayNightService;
    }

    @Override
    public PropagatingSpaceGestureService getSpaceGestureService() {
        return this.gestureService;
    }

    @Override
    public ClampSignalService getClampSignalService() {
        if (this.clampSignalService == null) {
            this.clampSignalService = new ClampSignalServiceImpl(this.getDsiProxy(), this.getThreadSwitcher());
        }
        return this.clampSignalService;
    }

    @Override
    public UserInteractionLockService getUserInteractionLockService() {
        if (this.userInteractionLockService == null) {
            this.userInteractionLockService = new UserInteractionLockServiceImpl(this.getSystemEventDispatcher(), this.getValetParkingService());
        }
        return this.userInteractionLockService;
    }

    @Override
    public ConfigurationManagerAsyncValueSetterService getConfigurationManagerAsyncValueSetterService() {
        if (this.asyncValueSetterService == null) {
            this.asyncValueSetterService = (ConfigurationManagerAsyncValueSetterService)this.getOsgiService(this.bundleContext, class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService == null ? (class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService = SystemServicesImpl.class$("de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService")) : class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService);
        }
        return this.asyncValueSetterService;
    }

    @Override
    public ContentProcessorManager getContentProcessorManager() {
        if (this.contentProcessorManager == null) {
            this.contentProcessorManager = new ContentProcessorManagerFactory().create(this);
        }
        return this.contentProcessorManager;
    }

    @Override
    public SystemData getSystemData() {
        return SystemData.getInstance();
    }

    private ValetParkingService createValetParkingService(SystemCommonPersistenceService systemCommonPersistenceService) {
        return new ValetParkingServiceFactory().createValetParkingService(this, systemCommonPersistenceService);
    }

    private AsyncServiceFactory retrieveAsyncFactory(BundleContext bundleContext, Logger logger) {
        return new SystemServicesOsgiUtil(bundleContext, logger).retrieveAsyncServiceFactory();
    }

    private Object getOsgiService(BundleContext bundleContext, Class clazz) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    @Override
    public EmergencyAnnouncementService getEmergencyAnnouncementService() {
        if (this.eaService == null) {
            this.eaService = new EmergencyAnnouncementServiceImpl(this.asl1Logger, this.getThreadSwitcher());
        }
        return this.eaService;
    }

    private MenuManager getMenuManager() {
        if (this.menuManager == null) {
            this.menuManager = new MenuManager(this);
        }
        return this.menuManager;
    }

    @Override
    public StageContentProcessor getStageContentProcessor() {
        if (this.stageContentProcessor == null) {
            this.stageContentProcessor = new StageContentProcessor(this);
        }
        return this.stageContentProcessor;
    }

    @Override
    public StageContentRequestAdmin getStageContentRequestAdmin() {
        if (this.stageContentRequestAdmin == null) {
            this.stageContentRequestAdmin = new StageContentRequestAdminImpl(this.getAsl1Logger());
        }
        return this.stageContentRequestAdmin;
    }

    @Override
    public StageContentRequestProcessor getStageContentRequestProcessor() {
        if (this.stageContentRequestProcessor == null) {
            this.stageContentRequestProcessor = new StageContentRequestProcessorImpl(this.getMenuManager(), this.getStageContentProcessor(), this.getStageContentRequestAdmin());
        }
        return this.stageContentRequestProcessor;
    }

    @Override
    public ContentIdValidator getContentIdValidator() {
        if (this.contentIdValidator == null) {
            this.contentIdValidator = new ContentIdValidatorImpl(this.getAsl1Logger());
        }
        return this.contentIdValidator;
    }

    @Override
    public Logger getAsl2Logger() {
        return this.asl2Logger;
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

