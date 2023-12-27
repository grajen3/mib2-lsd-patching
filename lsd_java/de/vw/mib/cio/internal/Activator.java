/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.app.framework.assembly.AppDefinitionDataProvider;
import de.vw.mib.cio.framework.CioVisualizationService;
import de.vw.mib.cio.framework.diag.CioDiagListener;
import de.vw.mib.cio.internal.DiagService;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.Dispatcher;
import de.vw.mib.cio.internal.Factory;
import de.vw.mib.cio.internal.IdService;
import de.vw.mib.cio.internal.ScriptWidgetService;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivator,
ServiceListener {
    private BundleContext bundleContext;
    private CioVisualizationService cioVisualizationService;
    private DiagService diagService;
    private Dictionary dictionary;
    private Factory factory;
    private IdService idService;
    private Logger logger;
    private ScriptWidgetService scriptWidgetCioService;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$CioIdService;
    static /* synthetic */ Class class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$CioFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$ScriptWidgetCioService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$CioVisualizationChangeService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$CioVisualizationService;
    static /* synthetic */ Class class$de$vw$mib$cio$framework$diag$CioDiagListener;

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
                this.handleServiceUnregistering(stringArray[i3], object);
            }
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        this.logger = loggerFactory.getLogger(3);
        AppDefinitionDataProvider appDefinitionDataProvider = (AppDefinitionDataProvider)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider == null ? (class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider = Activator.class$("de.vw.mib.app.framework.assembly.AppDefinitionDataProvider")) : class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider).getName()));
        ConfigurationManager configurationManager = (ConfigurationManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName()));
        this.dictionary = new Dictionary(this.logger, appDefinitionDataProvider);
        bundleContext.registerService((class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = Activator.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary).getName(), (Object)this.dictionary, null);
        Dispatcher dispatcher = new Dispatcher(this.logger);
        bundleContext.registerService((class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = Activator.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher).getName(), (Object)dispatcher, null);
        this.idService = new IdService();
        this.factory = new Factory(this.logger, configurationManager, this.dictionary, this.idService);
        bundleContext.registerService((class$de$vw$mib$cio$framework$CioIdService == null ? (class$de$vw$mib$cio$framework$CioIdService = Activator.class$("de.vw.mib.cio.framework.CioIdService")) : class$de$vw$mib$cio$framework$CioIdService).getName(), (Object)this.idService, null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory == null ? (class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory = Activator.class$("de.vw.mib.cio.app.framework.AppFrameworkCioFactory")) : class$de$vw$mib$cio$app$framework$AppFrameworkCioFactory).getName(), (class$de$vw$mib$cio$CioFactory == null ? (class$de$vw$mib$cio$CioFactory = Activator.class$("de.vw.mib.cio.CioFactory")) : class$de$vw$mib$cio$CioFactory).getName()}, (Object)this.factory, null);
        this.diagService = new DiagService(this.dictionary, dispatcher, this.factory);
        bundleContext.registerService((class$de$vw$mib$cio$framework$diag$CioDiagService == null ? (class$de$vw$mib$cio$framework$diag$CioDiagService = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagService")) : class$de$vw$mib$cio$framework$diag$CioDiagService).getName(), (Object)this.diagService, null);
        this.registerServiceListener();
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    private void createAndRegisterScriptWidgetCioServiceIfNeeded() {
        if (this.scriptWidgetCioService != null) {
            return;
        }
        if (this.cioVisualizationService == null) {
            return;
        }
        this.scriptWidgetCioService = new ScriptWidgetService(this.logger, this.dictionary, this.cioVisualizationService);
        this.factory.setScriptWidgetService(this.scriptWidgetCioService);
        this.bundleContext.registerService(new String[]{(class$de$vw$mib$cio$framework$ScriptWidgetCioService == null ? (class$de$vw$mib$cio$framework$ScriptWidgetCioService = Activator.class$("de.vw.mib.cio.framework.ScriptWidgetCioService")) : class$de$vw$mib$cio$framework$ScriptWidgetCioService).getName(), (class$de$vw$mib$cio$framework$CioVisualizationChangeService == null ? (class$de$vw$mib$cio$framework$CioVisualizationChangeService = Activator.class$("de.vw.mib.cio.framework.CioVisualizationChangeService")) : class$de$vw$mib$cio$framework$CioVisualizationChangeService).getName()}, (Object)this.scriptWidgetCioService, null);
    }

    private void handleServiceRegistered(String string, Object object, ServiceReference serviceReference) {
        if ((class$de$vw$mib$cio$framework$CioVisualizationService == null ? (class$de$vw$mib$cio$framework$CioVisualizationService = Activator.class$("de.vw.mib.cio.framework.CioVisualizationService")) : class$de$vw$mib$cio$framework$CioVisualizationService).getName().equals(string)) {
            this.cioVisualizationService = (CioVisualizationService)object;
            this.cioVisualizationService.load(this.idService);
        } else if ((class$de$vw$mib$cio$framework$diag$CioDiagListener == null ? (class$de$vw$mib$cio$framework$diag$CioDiagListener = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagListener")) : class$de$vw$mib$cio$framework$diag$CioDiagListener).getName().equals(string)) {
            if (this.diagService == null) {
                return;
            }
            CioDiagListener cioDiagListener = (CioDiagListener)object;
            this.diagService.registerCioDiagListener(cioDiagListener);
        }
        this.createAndRegisterScriptWidgetCioServiceIfNeeded();
    }

    private void handleServiceUnregistering(String string, Object object) {
        if ((class$de$vw$mib$cio$framework$diag$CioDiagListener == null ? (class$de$vw$mib$cio$framework$diag$CioDiagListener = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagListener")) : class$de$vw$mib$cio$framework$diag$CioDiagListener).getName().equals(string)) {
            if (this.diagService == null) {
                return;
            }
            CioDiagListener cioDiagListener = (CioDiagListener)object;
            this.diagService.unregisterCioDiagListener(cioDiagListener);
        }
    }

    private void registerServiceListener() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$framework$diag$CioDiagListener == null ? (class$de$vw$mib$cio$framework$diag$CioDiagListener = Activator.class$("de.vw.mib.cio.framework.diag.CioDiagListener")) : class$de$vw$mib$cio$framework$diag$CioDiagListener).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$cio$framework$CioVisualizationService == null ? (class$de$vw$mib$cio$framework$CioVisualizationService = Activator.class$("de.vw.mib.cio.framework.CioVisualizationService")) : class$de$vw$mib$cio$framework$CioVisualizationService).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        this.bundleContext.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
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

