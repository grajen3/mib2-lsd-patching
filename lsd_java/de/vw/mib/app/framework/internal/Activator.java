/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.internal;

import de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory;
import de.vw.mib.app.desktop.ContentProcessor;
import de.vw.mib.app.framework.AppUIGateFactory;
import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.app.framework.diag.AppFrameworkDiagListener;
import de.vw.mib.app.framework.diag.EsamDiagListener;
import de.vw.mib.app.framework.diag.ModelApiTracer;
import de.vw.mib.app.framework.internal.AppDiagManager;
import de.vw.mib.app.framework.internal.AppVisibilityManager;
import de.vw.mib.app.framework.internal.Services$AppFrameworkManagerServices;
import de.vw.mib.app.framework.internal.Services$AppFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CioFrameworkServices;
import de.vw.mib.app.framework.internal.Services$CommonFrameworkServices;
import de.vw.mib.app.framework.internal.Services$ConfigurationDataServices;
import de.vw.mib.app.framework.internal.Services$EventDispatcherServices;
import de.vw.mib.asl.clientapi.ASLClientAPIRegistry;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.app.framework.AppFrameworkCioFactory;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.EsamDefinitionDataService;
import de.vw.mib.desktop.DesktopManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.list.HMIListDataFactory;
import de.vw.mib.list.HMIListRegistry;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.util.StringBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivator,
ServiceListener {
    private AppDefinitionDataProvider appDefinitionDataProvider;
    private AppDiagManager appDiagManager;
    private AppFrameworkCioFactory appFrameworkCioFactory;
    private final ArrayList appFrameworkDiagListeners = new ArrayList();
    private boolean appLifecycleManagerRegistered;
    private AppUIGateFactory appUIGateFactory;
    private ASLClientAPIRegistry aslClientApiRegistry;
    private BundleContext bundleContext;
    private CioDictionary cioDictionary;
    private CioDispatcher cioDispatcher;
    private CioFactory cioFactory;
    private ConfigurationManager configurationManager;
    private ContentProcessor contentProcessor;
    private DesktopManager desktopManager;
    private EsamDefinitionDataService esamDefinitionDataService;
    private final ArrayList esamDiagListeners = new ArrayList();
    private FrameworkEventDispatcher frameworkEventDispatcher;
    private HMIListDataFactory hmiListDataFactory;
    private HMIListRegistry hmiListRegistry;
    private Logger logger;
    private LoggerFactory loggerFactory;
    private ModelApiProxyFactory modelApiProxyFactory;
    private final ArrayList modelApiTracers = new ArrayList();
    private StartupEventDispatcher startupEventDispatcher;
    private StatemachineEventDispatcherExt statemachineEventDispatcher;
    private ThreadSwitchingTarget threadSwitchingTarget;
    private ViewEventDispatcher viewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$app$desktop$ContentManager;
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$AppFrameworkDiagService;
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$EsamDiagService;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider;
    static /* synthetic */ Class class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory;
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener;
    static /* synthetic */ Class class$de$vw$mib$app$framework$AppUIGateFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;
    static /* synthetic */ Class class$de$vw$mib$app$desktop$ContentProcessor;
    static /* synthetic */ Class class$de$vw$mib$desktop$DesktopManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$EsamDefinitionDataService;
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$EsamDiagListener;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$list$HMIListDataFactory;
    static /* synthetic */ Class class$de$vw$mib$list$HMIListRegistry;
    static /* synthetic */ Class class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory;
    static /* synthetic */ Class class$de$vw$mib$app$framework$diag$ModelApiTracer;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$ViewEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        block3: {
            String[] stringArray;
            Object object;
            block2: {
                object = this.bundleContext.getService(serviceEvent.getServiceReference());
                stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
                if (serviceEvent.getType() != 1) break block2;
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    this.handleServiceRegistered(stringArray[i2], object, serviceEvent.getServiceReference());
                }
                break block3;
            }
            if (serviceEvent.getType() != 4) break block3;
            for (int i3 = 0; i3 < stringArray.length; ++i3) {
                this.handleServiceUnregistering(stringArray[i3], object, serviceEvent.getServiceReference());
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        this.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        this.logger = this.loggerFactory.getLogger(128);
        this.configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        this.registerServiceListener();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void createAndRegisterAppLifecycleManagerIfNeeded() {
        Object object;
        if (this.appLifecycleManagerRegistered) {
            return;
        }
        if (this.appDefinitionDataProvider == null) {
            return;
        }
        if (this.appFrameworkCioFactory == null) {
            return;
        }
        if (this.appUIGateFactory == null) {
            return;
        }
        if (this.aslClientApiRegistry == null) {
            return;
        }
        if (this.cioDictionary == null) {
            return;
        }
        if (this.cioDispatcher == null) {
            return;
        }
        if (this.cioFactory == null) {
            return;
        }
        if (this.contentProcessor == null) {
            return;
        }
        if (this.desktopManager == null) {
            return;
        }
        if (this.esamDefinitionDataService == null) {
            return;
        }
        if (this.modelApiProxyFactory == null) {
            return;
        }
        if (this.frameworkEventDispatcher == null) {
            return;
        }
        if (this.startupEventDispatcher == null) {
            return;
        }
        if (this.statemachineEventDispatcher == null) {
            return;
        }
        if (this.threadSwitchingTarget == null) {
            return;
        }
        if (this.viewEventDispatcher == null) {
            return;
        }
        this.appLifecycleManagerRegistered = true;
        Services$CioFrameworkServices services$CioFrameworkServices = new Services$CioFrameworkServices(this.appFrameworkCioFactory, this.cioDictionary, this.cioDispatcher, this.cioFactory);
        Services$EventDispatcherServices services$EventDispatcherServices = new Services$EventDispatcherServices(this.frameworkEventDispatcher, this.startupEventDispatcher, this.statemachineEventDispatcher, this.viewEventDispatcher, this.threadSwitchingTarget);
        Services$CommonFrameworkServices services$CommonFrameworkServices = new Services$CommonFrameworkServices(this.bundleContext, this.loggerFactory, this.aslClientApiRegistry, this.hmiListDataFactory, this.hmiListRegistry);
        Services$ConfigurationDataServices services$ConfigurationDataServices = new Services$ConfigurationDataServices(this.appDefinitionDataProvider, this.configurationManager, this.esamDefinitionDataService);
        Services$AppFrameworkServices services$AppFrameworkServices = new Services$AppFrameworkServices(this.appUIGateFactory, this.contentProcessor, this.desktopManager, this.modelApiProxyFactory, services$EventDispatcherServices);
        Services$AppFrameworkManagerServices services$AppFrameworkManagerServices = new Services$AppFrameworkManagerServices(services$AppFrameworkServices, services$CioFrameworkServices, services$CommonFrameworkServices, services$ConfigurationDataServices, services$EventDispatcherServices);
        this.logger.info(8, "initializing app framework ...");
        AppVisibilityManager appVisibilityManager = services$AppFrameworkManagerServices.getAppVisibilityManager();
        this.bundleContext.registerService((class$de$vw$mib$app$desktop$ContentManager == null ? (class$de$vw$mib$app$desktop$ContentManager = Activator.class$("de.vw.mib.app.desktop.ContentManager")) : class$de$vw$mib$app$desktop$ContentManager).getName(), (Object)appVisibilityManager, null);
        this.appDiagManager = services$AppFrameworkManagerServices.getAppDiagManager();
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$app$framework$diag$AppFrameworkDiagService == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagService = Activator.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagService")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagService).getName(), (class$de$vw$mib$app$framework$diag$EsamDiagService == null ? (class$de$vw$mib$app$framework$diag$EsamDiagService = Activator.class$("de.vw.mib.app.framework.diag.EsamDiagService")) : class$de$vw$mib$app$framework$diag$EsamDiagService).getName()}, (Object)this.appDiagManager, null);
        Iterator iterator = this.appFrameworkDiagListeners.iterator();
        while (iterator.hasNext()) {
            object = (AppFrameworkDiagListener)iterator.next();
            this.appDiagManager.registerAppFrameworkDiagListener((AppFrameworkDiagListener)object);
            iterator.remove();
        }
        iterator = this.esamDiagListeners.iterator();
        while (iterator.hasNext()) {
            object = (EsamDiagListener)iterator.next();
            this.appDiagManager.registerEsamDiagListener((EsamDiagListener)object);
            iterator.remove();
        }
        iterator = this.modelApiTracers.iterator();
        while (iterator.hasNext()) {
            object = (ModelApiTracer)iterator.next();
            this.appDiagManager.registerModelApiTracer((ModelApiTracer)object);
            iterator.remove();
        }
        this.bundleContext.registerService((class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer == null ? (class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer = Activator.class$("de.vw.mib.event.consumer.AppStartupManagerEventConsumer")) : class$de$vw$mib$event$consumer$AppStartupManagerEventConsumer).getName(), (Object)services$AppFrameworkManagerServices.getAppLifecycleManager(), null);
        this.logger.info(8, "app framework initialized!");
    }

    private void handleServiceRegistered(String string, Object object, ServiceReference serviceReference) {
        if ((class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider == null ? (class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider = Activator.class$("de.vw.mib.app.framework.assembly.AppDefinitionDataProvider")) : class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider).getName().equals(string)) {
            this.appDefinitionDataProvider = (AppDefinitionDataProvider)object;
        } else if ((class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory == null ? (class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory = Activator.class$("de.vw.mib.cio.app.framework.AppFrameworkCioFactory")) : class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory).getName().equals(string)) {
            this.appFrameworkCioFactory = (AppFrameworkCioFactory)object;
        } else if ((class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener = Activator.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagListener")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener).getName().equals(string)) {
            this.registerAppFrameworkDiagListener((AppFrameworkDiagListener)object);
        } else if ((class$de$vw$mib$app$framework$AppUIGateFactory == null ? (class$de$vw$mib$app$framework$AppUIGateFactory = Activator.class$("de.vw.mib.app.framework.AppUIGateFactory")) : class$de$vw$mib$app$framework$AppUIGateFactory).getName().equals(string)) {
            this.appUIGateFactory = (AppUIGateFactory)object;
        } else if ((class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry == null ? (class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry = Activator.class$("de.vw.mib.asl.clientapi.ASLClientAPIRegistry")) : class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry).getName().equals(string)) {
            this.aslClientApiRegistry = (ASLClientAPIRegistry)object;
        } else if ((class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = Activator.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName().equals(string)) {
            this.cioDictionary = (CioDictionary)object;
        } else if ((class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = Activator.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName().equals(string)) {
            this.cioDispatcher = (CioDispatcher)object;
        } else if ((class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = Activator.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory).getName().equals(string)) {
            this.cioFactory = (CioFactory)object;
        } else if ((class$de$vw$mib$app$desktop$ContentProcessor == null ? (class$de$vw$mib$app$desktop$ContentProcessor = Activator.class$("de.vw.mib.app.desktop.ContentProcessor")) : class$de$vw$mib$app$desktop$ContentProcessor).getName().equals(string)) {
            this.contentProcessor = (ContentProcessor)object;
        } else if ((class$de$vw$mib$desktop$DesktopManager == null ? (class$de$vw$mib$desktop$DesktopManager = Activator.class$("de.vw.mib.desktop.DesktopManager")) : class$de$vw$mib$desktop$DesktopManager).getName().equals(string)) {
            this.desktopManager = (DesktopManager)object;
        } else if ((class$de$vw$mib$configuration$EsamDefinitionDataService == null ? (class$de$vw$mib$configuration$EsamDefinitionDataService = Activator.class$("de.vw.mib.configuration.EsamDefinitionDataService")) : class$de$vw$mib$configuration$EsamDefinitionDataService).getName().equals(string)) {
            this.esamDefinitionDataService = (EsamDefinitionDataService)object;
        } else if ((class$de$vw$mib$app$framework$diag$EsamDiagListener == null ? (class$de$vw$mib$app$framework$diag$EsamDiagListener = Activator.class$("de.vw.mib.app.framework.diag.EsamDiagListener")) : class$de$vw$mib$app$framework$diag$EsamDiagListener).getName().equals(string)) {
            this.registerEsamDiagListener((EsamDiagListener)object);
        } else if ((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName().equals(string)) {
            this.frameworkEventDispatcher = (FrameworkEventDispatcher)object;
        } else if ((class$de$vw$mib$list$HMIListDataFactory == null ? (class$de$vw$mib$list$HMIListDataFactory = Activator.class$("de.vw.mib.list.HMIListDataFactory")) : class$de$vw$mib$list$HMIListDataFactory).getName().equals(string)) {
            this.hmiListDataFactory = (HMIListDataFactory)object;
        } else if ((class$de$vw$mib$list$HMIListRegistry == null ? (class$de$vw$mib$list$HMIListRegistry = Activator.class$("de.vw.mib.list.HMIListRegistry")) : class$de$vw$mib$list$HMIListRegistry).getName().equals(string)) {
            this.hmiListRegistry = (HMIListRegistry)object;
        } else if ((class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory == null ? (class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory = Activator.class$("de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory")) : class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory).getName().equals(string)) {
            this.modelApiProxyFactory = (ModelApiProxyFactory)object;
        } else if ((class$de$vw$mib$app$framework$diag$ModelApiTracer == null ? (class$de$vw$mib$app$framework$diag$ModelApiTracer = Activator.class$("de.vw.mib.app.framework.diag.ModelApiTracer")) : class$de$vw$mib$app$framework$diag$ModelApiTracer).getName().equals(string)) {
            this.registerModelApiTracer((ModelApiTracer)object);
        } else if ((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName().equals(string)) {
            this.startupEventDispatcher = (StartupEventDispatcher)object;
        } else if ((class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher).getName().equals(string)) {
            this.viewEventDispatcher = (ViewEventDispatcher)object;
        } else if ((class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt = Activator.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt).getName().equals(string)) {
            this.statemachineEventDispatcher = (StatemachineEventDispatcherExt)object;
        } else if ((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName().equals(string)) {
            this.threadSwitchingTarget = (ThreadSwitchingTarget)object;
        }
        this.createAndRegisterAppLifecycleManagerIfNeeded();
    }

    private void handleServiceUnregistering(String string, Object object, ServiceReference serviceReference) {
        if ((class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener = Activator.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagListener")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener).getName().equals(string)) {
            this.unregisterAppFrameworkDiagListener((AppFrameworkDiagListener)object);
        } else if ((class$de$vw$mib$app$framework$diag$EsamDiagListener == null ? (class$de$vw$mib$app$framework$diag$EsamDiagListener = Activator.class$("de.vw.mib.app.framework.diag.EsamDiagListener")) : class$de$vw$mib$app$framework$diag$EsamDiagListener).getName().equals(string)) {
            this.unregisterEsamDiagListener((EsamDiagListener)object);
        } else if ((class$de$vw$mib$app$framework$diag$ModelApiTracer == null ? (class$de$vw$mib$app$framework$diag$ModelApiTracer = Activator.class$("de.vw.mib.app.framework.diag.ModelApiTracer")) : class$de$vw$mib$app$framework$diag$ModelApiTracer).getName().equals(string)) {
            this.unregisterModelApiTracer((ModelApiTracer)object);
        }
    }

    private void registerAppFrameworkDiagListener(AppFrameworkDiagListener appFrameworkDiagListener) {
        if (this.appDiagManager != null) {
            this.appDiagManager.registerAppFrameworkDiagListener(appFrameworkDiagListener);
        } else {
            this.appFrameworkDiagListeners.add(appFrameworkDiagListener);
        }
    }

    private void registerEsamDiagListener(EsamDiagListener esamDiagListener) {
        if (this.appDiagManager != null) {
            this.appDiagManager.registerEsamDiagListener(esamDiagListener);
        } else {
            this.esamDiagListeners.add(esamDiagListener);
        }
    }

    private void registerModelApiTracer(ModelApiTracer modelApiTracer) {
        if (this.appDiagManager != null) {
            this.appDiagManager.registerModelApiTracer(modelApiTracer);
        } else {
            this.modelApiTracers.add(modelApiTracer);
        }
    }

    private void registerServiceListener() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider == null ? (class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider = Activator.class$("de.vw.mib.app.framework.assembly.AppDefinitionDataProvider")) : class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$configuration$EsamDefinitionDataService == null ? (class$de$vw$mib$configuration$EsamDefinitionDataService = Activator.class$("de.vw.mib.configuration.EsamDefinitionDataService")) : class$de$vw$mib$configuration$EsamDefinitionDataService).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory == null ? (class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory = Activator.class$("de.vw.mib.cio.app.framework.AppFrameworkCioFactory")) : class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = Activator.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = Activator.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = Activator.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$desktop$ContentProcessor == null ? (class$de$vw$mib$app$desktop$ContentProcessor = Activator.class$("de.vw.mib.app.desktop.ContentProcessor")) : class$de$vw$mib$app$desktop$ContentProcessor).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$desktop$DesktopManager == null ? (class$de$vw$mib$desktop$DesktopManager = Activator.class$("de.vw.mib.desktop.DesktopManager")) : class$de$vw$mib$desktop$DesktopManager).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$framework$AppUIGateFactory == null ? (class$de$vw$mib$app$framework$AppUIGateFactory = Activator.class$("de.vw.mib.app.framework.AppUIGateFactory")) : class$de$vw$mib$app$framework$AppUIGateFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory == null ? (class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory = Activator.class$("de.vw.mib.app.appadapter.proxy.ModelApiProxyFactory")) : class$de$vw$mib$app$appadapter$proxy$ModelApiProxyFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt == null ? (class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt = Activator.class$("de.vw.mib.event.dispatcher.StatemachineEventDispatcherExt")) : class$de$vw$mib$event$dispatcher$StatemachineEventDispatcherExt).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = Activator.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$event$dispatcher$ViewEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$ViewEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.ViewEventDispatcher")) : class$de$vw$mib$event$dispatcher$ViewEventDispatcher).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener == null ? (class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener = Activator.class$("de.vw.mib.app.framework.diag.AppFrameworkDiagListener")) : class$de$vw$mib$app$framework$diag$AppFrameworkDiagListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$framework$diag$EsamDiagListener == null ? (class$de$vw$mib$app$framework$diag$EsamDiagListener = Activator.class$("de.vw.mib.app.framework.diag.EsamDiagListener")) : class$de$vw$mib$app$framework$diag$EsamDiagListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$app$framework$diag$ModelApiTracer == null ? (class$de$vw$mib$app$framework$diag$ModelApiTracer = Activator.class$("de.vw.mib.app.framework.diag.ModelApiTracer")) : class$de$vw$mib$app$framework$diag$ModelApiTracer).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry == null ? (class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry = Activator.class$("de.vw.mib.asl.clientapi.ASLClientAPIRegistry")) : class$de$vw$mib$asl$clientapi$ASLClientAPIRegistry).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$list$HMIListDataFactory == null ? (class$de$vw$mib$list$HMIListDataFactory = Activator.class$("de.vw.mib.list.HMIListDataFactory")) : class$de$vw$mib$list$HMIListDataFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$list$HMIListRegistry == null ? (class$de$vw$mib$list$HMIListRegistry = Activator.class$("de.vw.mib.list.HMIListRegistry")) : class$de$vw$mib$list$HMIListRegistry).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        this.bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    private void unregisterAppFrameworkDiagListener(AppFrameworkDiagListener appFrameworkDiagListener) {
        if (this.appDiagManager != null) {
            this.appDiagManager.unregisterAppFrameworkDiagListener(appFrameworkDiagListener);
        } else {
            this.appFrameworkDiagListeners.remove(appFrameworkDiagListener);
        }
    }

    private void unregisterEsamDiagListener(EsamDiagListener esamDiagListener) {
        if (this.appDiagManager != null) {
            this.appDiagManager.unregisterEsamDiagListener(esamDiagListener);
        } else {
            this.esamDiagListeners.remove(esamDiagListener);
        }
    }

    private void unregisterModelApiTracer(ModelApiTracer modelApiTracer) {
        if (this.appDiagManager != null) {
            this.appDiagManager.unregisterModelApiTracer(modelApiTracer);
        } else {
            this.modelApiTracers.remove(modelApiTracer);
        }
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

