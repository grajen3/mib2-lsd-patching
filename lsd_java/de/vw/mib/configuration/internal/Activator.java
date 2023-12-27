/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.configuration.internal.AppDefinitionDataProviderImpl;
import de.vw.mib.configuration.internal.ConfigurationManagerImpl;
import de.vw.mib.configuration.internal.EsamDefinitionDataServiceImpl;
import de.vw.mib.configuration.internal.PropertiesReader;
import de.vw.mib.configuration.internal.ServiceManager;
import de.vw.mib.configuration.internal.SkinInformationServiceImpl;
import de.vw.mib.configuration.internal.generated.SpeechConfigurationImpl;
import de.vw.mib.dynamicresourcedata.DynamicResourceDataFactory;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.log4mib.LogManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.LscController;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.util.StringBuilder;
import java.io.File;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public class Activator
implements BundleActivator,
ServiceListener {
    private static final String UI_THREAD_ID = String.valueOf(2);
    private BundleContext context;
    private ConfigurationManagerImpl configurationManager;
    private SkinInformationServiceImpl skinInformationService;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService;
    static /* synthetic */ Class class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LogManager;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerValueSetter;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerDiag;
    static /* synthetic */ Class class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider;
    static /* synthetic */ Class class$de$vw$mib$configuration$internal$generated$SpeechConfiguration;
    static /* synthetic */ Class class$de$vw$mib$configuration$SkinInformationService;
    static /* synthetic */ Class class$de$vw$mib$configuration$EsamDefinitionDataService;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscController;

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        String string;
        Object object = this.context.getService(serviceEvent.getServiceReference());
        if (object instanceof LscController) {
            ServiceManager.lscController = (LscController)object;
            ServiceManager.lscController.addListener(this.configurationManager, 2, "NO_LANGUAGE", -1, -1);
        } else if (object instanceof FrameworkEventDispatcher) {
            ServiceManager.eventDispatcher = (FrameworkEventDispatcher)object;
        } else if (object instanceof AsyncServiceFactory && UI_THREAD_ID.equals(string = (String)serviceEvent.getServiceReference().getProperty("MIBThreadId"))) {
            AsyncServiceFactory asyncServiceFactory = (AsyncServiceFactory)object;
            this.context.registerService((class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService == null ? (class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService = Activator.class$("de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService")) : class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService).getName(), asyncServiceFactory.createNarrow(this.configurationManager, new Class[]{class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService == null ? (class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService = Activator.class$("de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService")) : class$de$vw$mib$configuration$ConfigurationManagerAsyncValueSetterService}), null);
            this.context.registerService((class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService == null ? (class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService = Activator.class$("de.vw.mib.configuration.SkinInformationAsyncValueSetterService")) : class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService).getName(), asyncServiceFactory.createNarrow(this.skinInformationService, new Class[]{class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService == null ? (class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService = Activator.class$("de.vw.mib.configuration.SkinInformationAsyncValueSetterService")) : class$de$vw$mib$configuration$SkinInformationAsyncValueSetterService}), null);
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        this.context = bundleContext;
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory == null ? (class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory = Activator.class$("de.vw.mib.dynamicresourcedata.DynamicResourceDataFactory")) : class$de$vw$mib$dynamicresourcedata$DynamicResourceDataFactory).getName());
        if (serviceReference != null) {
            ServiceManager.dynamicResourceDataFactory = (DynamicResourceDataFactory)bundleContext.getService(serviceReference);
        }
        ServiceManager.loggerFactory = (LoggerFactory)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName()));
        ServiceManager.logManager = (LogManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$log4mib$LogManager == null ? (class$de$vw$mib$log4mib$LogManager = Activator.class$("de.vw.mib.log4mib.LogManager")) : class$de$vw$mib$log4mib$LogManager).getName()));
        ServiceManager.fileManager = (FileManager)bundleContext.getService(bundleContext.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = Activator.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName()));
        this.configurationManager = new ConfigurationManagerImpl(new PropertiesReader());
        AppDefinitionDataProviderImpl appDefinitionDataProviderImpl = new AppDefinitionDataProviderImpl(this.configurationManager);
        bundleContext.registerService(new String[]{(class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = Activator.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager).getName(), (class$de$vw$mib$configuration$ConfigurationManagerValueSetter == null ? (class$de$vw$mib$configuration$ConfigurationManagerValueSetter = Activator.class$("de.vw.mib.configuration.ConfigurationManagerValueSetter")) : class$de$vw$mib$configuration$ConfigurationManagerValueSetter).getName(), (class$de$vw$mib$configuration$ConfigurationManagerDiag == null ? (class$de$vw$mib$configuration$ConfigurationManagerDiag = Activator.class$("de.vw.mib.configuration.ConfigurationManagerDiag")) : class$de$vw$mib$configuration$ConfigurationManagerDiag).getName()}, (Object)this.configurationManager, null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider == null ? (class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider = Activator.class$("de.vw.mib.app.framework.assembly.AppDefinitionDataProvider")) : class$de$vw$mib$app$framework$assembly$AppDefinitionDataProvider).getName()}, (Object)appDefinitionDataProviderImpl, null);
        bundleContext.registerService(new String[]{(class$de$vw$mib$configuration$internal$generated$SpeechConfiguration == null ? (class$de$vw$mib$configuration$internal$generated$SpeechConfiguration = Activator.class$("de.vw.mib.configuration.internal.generated.SpeechConfiguration")) : class$de$vw$mib$configuration$internal$generated$SpeechConfiguration).getName()}, (Object)new SpeechConfigurationImpl(), null);
        this.skinInformationService = new SkinInformationServiceImpl(this.configurationManager);
        bundleContext.registerService((class$de$vw$mib$configuration$SkinInformationService == null ? (class$de$vw$mib$configuration$SkinInformationService = Activator.class$("de.vw.mib.configuration.SkinInformationService")) : class$de$vw$mib$configuration$SkinInformationService).getName(), (Object)this.skinInformationService, null);
        File file = new File(this.configurationManager.getConfigurationResourcesPath(), "esamDefinition.res");
        EsamDefinitionDataServiceImpl esamDefinitionDataServiceImpl = file.exists() ? new EsamDefinitionDataServiceImpl(this.configurationManager, file) : new EsamDefinitionDataServiceImpl(this.configurationManager);
        bundleContext.registerService((class$de$vw$mib$configuration$EsamDefinitionDataService == null ? (class$de$vw$mib$configuration$EsamDefinitionDataService = Activator.class$("de.vw.mib.configuration.EsamDefinitionDataService")) : class$de$vw$mib$configuration$EsamDefinitionDataService).getName(), (Object)esamDefinitionDataServiceImpl, null);
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("(|");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = Activator.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName()).append(")");
        stringBuilder.append("(").append("objectClass").append("=").append((class$de$vw$mib$lsctng$LscController == null ? (class$de$vw$mib$lsctng$LscController = Activator.class$("de.vw.mib.lsctng.LscController")) : class$de$vw$mib$lsctng$LscController).getName()).append(")");
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        this.context.addServiceListener(this, string);
        ServiceReference[] serviceReferenceArray = bundleContext.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            this.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
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

