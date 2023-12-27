/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApi;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApiImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.GenericDeserializer;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceTracing;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileCopyService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileOperationRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileResetService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.RawPersistenceIdsDataProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProviderImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerFactory;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerFactoryImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.GenericDeserializerImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistableServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistenceKeyProviderImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistenceLoggerImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersistenceTracingImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileCopyServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ProfileResetServiceImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.RawPersistenceIdsDataProviderImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.PersistenceStartupServiceImpl;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.file.FileManager;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class PersistenceServicesImpl
implements PersistenceServices {
    private final ApiPersDb apiPersDb;
    private final AslPersistenceAsyncApi aslPersistenceAsyncApi;
    private final ASLStartupv7rAPI aslStartupApi;
    private final BundleContext bundleContext;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final DsiAdapterProvider dsiAdapterProvider;
    private final DsiAwareProfileChangeListenerFactory dsiAwareProfileChangeListenerFactory;
    private final GenericDeserializer genericDeserializer;
    private final GenericEvents genericEvents;
    private final Logger logger;
    private final PerfService perfService;
    private final PersistableService persistableService;
    private final PersistenceLogger persistenceLogger;
    private final ModuleDescriptorRegistry moduleDescriptorRegistry;
    private final PersistenceTracing persistenceTracing;
    private final ProfileCopyService profileCopyService;
    private final ProfileResetService profileResetService;
    private final StartupStateService startupStateService;
    private final TimerManager timerManager;
    private final DSIProxy dsiProxy;
    private final ProfileOperationRegistry profileOperationRegistry;
    private final ASLPersistenceAPI persistenceApi;
    private PersistenceKeyProvider persistenceKeyProvider;
    private PersistenceStartupService persistenceStartupService;
    private RawPersistenceIdsDataProvider rawPersistenceIdsDataProvider;
    private ThreadSwitchingTarget threadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;

    PersistenceServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.persistenceLogger = PersistenceLoggerImpl.INSTANCE;
        this.bundleContext = services.getBundleContext();
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.configurationManagerDiag = services.getConfigurationManagerDiag();
        this.apiPersDb = ApiPersDbImpl.INSTANCE;
        this.genericDeserializer = new GenericDeserializerImpl(PersistenceLoggerImpl.INSTANCE);
        this.genericEvents = services.getGenericEvents();
        this.timerManager = services.getTimerManager();
        this.aslPersistenceAsyncApi = AslPersistenceAsyncApiImpl.INSTANCE;
        this.persistenceTracing = new PersistenceTracingImpl();
        this.perfService = services.getPerfService();
        this.aslStartupApi = ASLStartupv7rFactory.getStartupv7rApi();
        this.startupStateService = this.aslStartupApi.getStartupStateService();
        this.profileOperationRegistry = new ProfileOperationRegistry();
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi();
        this.dsiAdapterProvider = new DsiAdapterProviderImpl(this.bundleContext, this.logger, this.getThreadSwitchingTarget());
        this.moduleDescriptorRegistry = new ModuleDescriptorRegistry(this);
        this.persistableService = new PersistableServiceImpl(this);
        this.dsiAwareProfileChangeListenerFactory = new DsiAwareProfileChangeListenerFactoryImpl(this);
        this.profileCopyService = new ProfileCopyServiceImpl(this);
        this.profileResetService = new ProfileResetServiceImpl(this);
    }

    @Override
    public ApiPersDb getApiPersDb() {
        return this.apiPersDb;
    }

    @Override
    public AslPersistenceAsyncApi getAslPersistenceAsyncApi() {
        return this.aslPersistenceAsyncApi;
    }

    @Override
    public ASLStartupv7rAPI getAslStartupApi() {
        return this.aslStartupApi;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public ASLDiagnosisAPI getDiagnosisAPI() {
        return ASLDiagnosisFactory.getDiagnosisApi();
    }

    @Override
    public DsiAdapterProvider getDsiAdapterProvider() {
        return this.dsiAdapterProvider;
    }

    @Override
    public DsiAwareProfileChangeListenerFactory getDsiAwareProfileChangeListenerFactory() {
        return this.dsiAwareProfileChangeListenerFactory;
    }

    @Override
    public DSIProxy getDsiProxy() {
        return this.dsiProxy;
    }

    @Override
    public GenericDeserializer getGenericDeserializer() {
        return this.genericDeserializer;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public PerfService getPerfService() {
        return this.perfService;
    }

    @Override
    public PersistableService getPersistableService() {
        return this.persistableService;
    }

    @Override
    public PersistenceKeyProvider getPersistenceKeyProvider() {
        if (this.persistenceKeyProvider == null) {
            this.persistenceKeyProvider = new PersistenceKeyProviderImpl(this.getRawPersistenceIdsDataProvider(), PersistenceLoggerImpl.INSTANCE);
        }
        return this.persistenceKeyProvider;
    }

    @Override
    public PersistenceLogger getPersistenceLogger() {
        return this.persistenceLogger;
    }

    @Override
    public ModuleDescriptorRegistry getModuleDescriptorRegistry() {
        return this.moduleDescriptorRegistry;
    }

    @Override
    public PersistenceStartupService getPersistenceStartupService() {
        if (this.persistenceStartupService == null) {
            this.persistenceStartupService = new PersistenceStartupServiceImpl(this.getThreadSwitchingTarget(), this.getStartupStateService(), this.getPersistableService(), this.logger);
        }
        return this.persistenceStartupService;
    }

    @Override
    public PersistenceTracing getPersistenceTracing() {
        return this.persistenceTracing;
    }

    @Override
    public ProfileCopyService getProfileCopyService() {
        return this.profileCopyService;
    }

    @Override
    public ProfileResetService getProfileResetService() {
        return this.profileResetService;
    }

    @Override
    public RawPersistenceIdsDataProvider getRawPersistenceIdsDataProvider() {
        if (this.rawPersistenceIdsDataProvider == null) {
            this.rawPersistenceIdsDataProvider = this.createRawPersistenceIdsDataProvider();
        }
        return this.rawPersistenceIdsDataProvider;
    }

    @Override
    public StartupStateService getStartupStateService() {
        return this.startupStateService;
    }

    @Override
    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        if (this.threadSwitchingTarget == null) {
            this.threadSwitchingTarget = this.retrieveThreadSwitchingTarget();
        }
        return this.threadSwitchingTarget;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public ProfileOperationRegistry getProfileOperationRegistry() {
        return this.profileOperationRegistry;
    }

    @Override
    public ASLPersistenceAPI getASLPersistenceAPI() {
        return this.persistenceApi;
    }

    private RawPersistenceIdsDataProvider createRawPersistenceIdsDataProvider() {
        FileManager fileManager = (FileManager)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = PersistenceServicesImpl.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName()));
        RawPersistenceIdsDataProviderImpl rawPersistenceIdsDataProviderImpl = new RawPersistenceIdsDataProviderImpl(this.configurationManagerDiag, fileManager, ClassLoader.getSystemClassLoader(), PersistenceLoggerImpl.INSTANCE);
        return rawPersistenceIdsDataProviderImpl;
    }

    private ThreadSwitchingTarget retrieveThreadSwitchingTarget() {
        ThreadSwitchingTarget threadSwitchingTarget;
        try {
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = PersistenceServicesImpl.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName(), "(genericEvents.task=hsmtask)");
            ServiceReference serviceReference = serviceReferenceArray[0];
            threadSwitchingTarget = (ThreadSwitchingTarget)this.bundleContext.getService(serviceReference);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Could not find ThreadSwitchTarget in Bundle Context", throwable);
        }
        return threadSwitchingTarget;
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

