/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiClient;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.app.esam.EsamService;
import de.vw.mib.app.framework.AppDefinition;
import de.vw.mib.app.framework.internal.AppAdapterController$1;
import de.vw.mib.app.framework.internal.AppAdapterController$2;
import de.vw.mib.app.framework.internal.AppAdapterController$3;
import de.vw.mib.app.framework.internal.AppAdapterManager;
import de.vw.mib.app.framework.internal.AppContext;
import de.vw.mib.app.framework.internal.AppDiagController;
import de.vw.mib.app.framework.internal.ModelApiEventService;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.asl.clientapi.ASLClientAPIRegistry;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioExecutor;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.modelapi.ModelApiUpEvent;
import de.vw.mib.modelapi.appadapter.ModelApiDownEventHandler;
import de.vw.mib.modelapi.appadapter.ModelApiUpEventService;
import de.vw.mib.modelapi.ui.ModelApiUpEventHandler;
import java.util.HashMap;
import java.util.Map;

final class AppAdapterController
implements AppAdapterSystemServices,
ModelApiUpEventService {
    AbstractAppAdapter appAdapter;
    private final AppAdapterManager appAdapterManager;
    private final AppContext appContext;
    private final AppDiagController appDiagController;
    private final Services$CioFrameworkServices cioFrameworkServices;
    private final Services$CommonFrameworkServices commonFrameworkServices;
    private final ConfigurationManager configurationManager;
    private final Logger logger;
    private final Map modelApiClients;
    private final ModelApiEventService modelApiEventService;
    private ModelApiUpEventHandler modelApiUpEventHandler;
    private final ThreadSwitchingTarget threadSwitchingTarget;

    AppAdapterController(AppContext appContext, Services$AppFrameworkManagerServices services$AppFrameworkManagerServices, Services$CioFrameworkServices services$CioFrameworkServices, Services$CommonFrameworkServices services$CommonFrameworkServices, Services$ConfigurationDataServices services$ConfigurationDataServices, Services$EventDispatcherServices services$EventDispatcherServices) {
        this.logger = appContext.getLogger();
        this.appContext = appContext;
        this.appDiagController = appContext.getAppDiagController();
        this.appAdapterManager = services$AppFrameworkManagerServices.getAppAdapterManager();
        this.cioFrameworkServices = services$CioFrameworkServices;
        this.commonFrameworkServices = services$CommonFrameworkServices;
        this.configurationManager = services$ConfigurationDataServices.getConfigurationManager();
        this.modelApiEventService = services$EventDispatcherServices.getModelApiEventService();
        this.threadSwitchingTarget = services$EventDispatcherServices.getThreadSwitchingTarget();
        this.modelApiClients = new HashMap();
    }

    @Override
    public ModelApiUpEvent createEvent(int n) {
        if (this.modelApiUpEventHandler == null) {
            this.logger.error(128).append(this.appContext).append(" - couldn't perform model api up call due app lifecycle violation!").append(" The app is not ready yet!").attachThrowable(new IllegalStateException()).log();
        }
        return this.modelApiEventService.createEvent(n, this.modelApiUpEventHandler);
    }

    @Override
    public Logger createLogger(int n) {
        return this.commonFrameworkServices.getLogger(n);
    }

    @Override
    public ModelApiClient createModelApiClient(Class clazz) {
        ModelApiClient modelApiClient = (ModelApiClient)this.modelApiClients.get(clazz);
        if (modelApiClient == null) {
            modelApiClient = this.appAdapterManager.createModelApiClientProxy(this.appContext.getAppDefinition(), clazz, this);
            this.modelApiClients.put(clazz, modelApiClient);
        }
        return modelApiClient;
    }

    @Override
    public String getAppName() {
        return this.appContext.getAppDefinition().getAppName();
    }

    @Override
    public int getAppInstanceId() {
        return this.appContext.getAppDefinition().getAppInstanceId();
    }

    @Override
    public String getAppInstanceName() {
        return this.appContext.getAppDefinition().getAppInstanceName();
    }

    @Override
    public ASLClientAPIRegistry getASLClientAPIRegistry() {
        return this.commonFrameworkServices.getAslClientApiRegistry();
    }

    @Override
    public CioDictionary getCioDictionary() {
        return this.cioFrameworkServices.getCioDictionary();
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        return this.cioFrameworkServices.getCioDispatcher();
    }

    @Override
    public CioFactory getCioFactory() {
        return this.cioFrameworkServices.getCioFactory();
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

    @Override
    public EsamService getEsamService() {
        return this.appContext.getEsamService();
    }

    @Override
    public HMIListDataFactory getHMIListDataFactory() {
        return this.commonFrameworkServices.getHmiListDataFactory();
    }

    @Override
    public HMIListRegistry getHMIListRegistry() {
        return this.commonFrameworkServices.getHmiListRegistry();
    }

    @Override
    public Logger getLogger(int n) {
        return this.createLogger(n);
    }

    @Override
    public ModelApiClient getModelApiClient(Class clazz) {
        return this.createModelApiClient(clazz);
    }

    @Override
    public void sendEvent(ModelApiUpEvent modelApiUpEvent) {
        this.modelApiEventService.sendEvent(this.appDiagController, modelApiUpEvent);
    }

    CioExecutor getCioExecutor() {
        if (this.appAdapter == null) {
            return null;
        }
        return this.appAdapter.getCioExecutor();
    }

    boolean init() {
        this.appAdapter = this.appAdapterManager.createAppAdapter(this.appContext);
        if (this.appAdapter == null) {
            return true;
        }
        AppDefinition appDefinition = this.appContext.getAppDefinition();
        int n = appDefinition.getAppInstanceId();
        String string = appDefinition.getAppInstanceName();
        this.appAdapter.init(n, string);
        ModelApiService[] modelApiServiceArray = this.appAdapter.getModelApiServices();
        if (modelApiServiceArray == null || modelApiServiceArray.length == 0) {
            if (this.logger.isTraceEnabled(128)) {
                this.logger.warn(128).append(this.appContext).append(" - no model api service provided by the app adapter").log();
            }
            return true;
        }
        try {
            ModelApiDownEventHandler modelApiDownEventHandler = this.appAdapterManager.createModelApiServiceProxy(appDefinition, modelApiServiceArray);
            this.appContext.getAppUIController().setModelApiDownEventHandler(modelApiDownEventHandler);
        }
        catch (Throwable throwable) {
            this.logger.error(128).append(this.appContext).append(" - couldn't create model api service proxy!").attachThrowable(throwable).log();
            return false;
        }
        return true;
    }

    void ready() {
        if (this.appAdapter == null) {
            return;
        }
        this.threadSwitchingTarget.enqueue(new AppAdapterController$1(this));
    }

    void start() {
        if (this.appAdapter == null) {
            return;
        }
        this.threadSwitchingTarget.enqueue(new AppAdapterController$2(this));
    }

    void started(ModelApiUpEventHandler modelApiUpEventHandler) {
        this.modelApiUpEventHandler = modelApiUpEventHandler;
    }

    void stop() {
        if (this.appAdapter == null) {
            return;
        }
        this.threadSwitchingTarget.enqueue(new AppAdapterController$3(this));
    }
}

