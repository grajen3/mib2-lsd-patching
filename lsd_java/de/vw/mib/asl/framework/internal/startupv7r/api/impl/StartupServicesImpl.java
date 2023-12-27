/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.api.impl;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rFactory;
import de.vw.mib.asl.framework.internal.startupv7r.ContextInfo;
import de.vw.mib.asl.framework.internal.startupv7r.DsiInformationService;
import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.PersistenceInformationService;
import de.vw.mib.asl.framework.internal.startupv7r.StartupServices;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryConditionService;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryConditionServiceFactory;
import de.vw.mib.asl.framework.internal.startupv7r.model.DomainStates;
import de.vw.mib.asl.framework.internal.startupv7r.restart.RestartHandler;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public class StartupServicesImpl
implements StartupServices {
    private final Services services;
    private final ASLDiagnosisAPI diagnosisAPI;
    private final DsiInformationService dsiInformationsService;
    private final PersistenceInformationService persistenceInformationService;
    private final Logger logger;
    private final StartupStateServiceImpl startupStateService;
    private final ConfigurationManagerDiag configurationManagerDiag;
    private final EventDispatcherHSM eventDispatcher;
    private final ASLPropertyManager aslPropertyManager;
    private final EventFactory eventFactory;
    private final ASLStartupv7rAPI startupv7rAPI;
    private final TimerManager timerManager;
    private final ThreadSwitchingTarget threadSwitchingTarget;
    private final ASLPersistenceAPI persistenceApi;
    private final GenericEvents genericEvents;
    private final BundleContext bundleContext;
    private EntryConditionService entryConditionService;
    private PerfService perfService;
    private DSIProxy dsiProxy;
    private RestartHandler restartHandler;
    private DomainStates domainStates;
    private ASLSystemAPI aslSystemApi;
    private StartupEventDispatcher startupEventDispatcher;
    private AsyncServiceFactory asyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;

    StartupServicesImpl() {
        ContextInfo contextInfo = new ContextInfo();
        this.services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.bundleContext = this.services.getBundleContext();
        this.diagnosisAPI = ASLDiagnosisFactory.getDiagnosisApi();
        this.logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
        this.dsiInformationsService = new DsiInformationService(this.logger, contextInfo);
        this.persistenceInformationService = new PersistenceInformationService(this.logger);
        this.startupStateService = new StartupStateServiceImpl();
        this.configurationManagerDiag = this.services.getConfigurationManagerDiag();
        this.eventDispatcher = this.services.getGenericEvents().getEventDispatcher();
        this.aslPropertyManager = this.services.getASLPropertyManager();
        this.eventFactory = this.services.getEventFactory();
        this.timerManager = this.services.getTimerManager();
        this.threadSwitchingTarget = this.services.getASLThreadSwitch();
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi();
        this.perfService = (PerfService)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = StartupServicesImpl.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService).getName()));
        this.dsiProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
        this.genericEvents = this.services.getGenericEvents();
        this.startupv7rAPI = ASLStartupv7rFactory.getStartupv7rApi();
    }

    @Override
    public ASLDiagnosisAPI getDiagnosisAPI() {
        return this.diagnosisAPI;
    }

    @Override
    public DsiInformationService getDsiInformationService() {
        return this.dsiInformationsService;
    }

    @Override
    public PersistenceInformationService getPersistenceInformationService() {
        return this.persistenceInformationService;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public StartupStateServiceImpl getStartupStateService() {
        return this.startupStateService;
    }

    @Override
    public ConfigurationManagerDiag getConfigurationManagerDiag() {
        return this.configurationManagerDiag;
    }

    @Override
    public EventDispatcherHSM getEventDispatcher() {
        return this.eventDispatcher;
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.aslPropertyManager;
    }

    @Override
    public EventFactory getEventFactory() {
        return this.eventFactory;
    }

    @Override
    public ASLStartupv7rAPI getASLStartupv7rAPI() {
        return this.startupv7rAPI;
    }

    @Override
    public EntryConditionService getEntryConditionService() {
        if (this.entryConditionService == null) {
            this.entryConditionService = new EntryConditionServiceFactory().create(this);
        }
        return this.entryConditionService;
    }

    @Override
    public SystemStateService getSystemStateService() {
        return ASLSystemFactory.getSystemApi().getSystemStateService();
    }

    @Override
    public ASLPersistenceAPI getPersistenceApi() {
        return this.persistenceApi;
    }

    @Override
    public ThreadSwitchingTarget getAslThreadSwitchingTarget() {
        return this.threadSwitchingTarget;
    }

    @Override
    public TimerManager getTimerManager() {
        return this.timerManager;
    }

    @Override
    public Services getAslFrameworkServices() {
        return this.services;
    }

    @Override
    public PerfService getPerfService() {
        return this.perfService;
    }

    @Override
    public DSIProxy getDSIProxy() {
        return this.dsiProxy;
    }

    @Override
    public GenericEvents getGenericEvents() {
        return this.genericEvents;
    }

    @Override
    public RestartHandler getRestartHandler() {
        if (this.restartHandler == null) {
            this.restartHandler = new RestartHandler();
        }
        return this.restartHandler;
    }

    @Override
    public DomainStates getDomainStates() {
        if (this.domainStates == null) {
            this.domainStates = new DomainStates();
        }
        return this.domainStates;
    }

    @Override
    public PersistableEarlyData getPersistableEarlyData() {
        return PersistableEarlyData.getInstance();
    }

    @Override
    public ASLSystemAPI getAslSystemApi() {
        if (this.aslSystemApi == null) {
            this.aslSystemApi = ASLSystemFactory.getSystemApi();
        }
        return this.aslSystemApi;
    }

    @Override
    public StartupEventDispatcher getStartupEventDispatcher() {
        if (this.startupEventDispatcher == null) {
            this.startupEventDispatcher = (StartupEventDispatcher)this.bundleContext.getService(this.bundleContext.getServiceReference((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = StartupServicesImpl.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName()));
        }
        return this.startupEventDispatcher;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        if (this.asyncServiceFactory == null) {
            this.asyncServiceFactory = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLAsyncServiceFactory();
        }
        return this.asyncServiceFactory;
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

