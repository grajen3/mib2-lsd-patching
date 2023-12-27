/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng.internal;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.configuration.ConfigurationManagerValueSetter;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.EventDispatcherManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.file.FileManager;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.i18n.I18nGuiUpdater;
import de.vw.mib.i18n.I18nTableDecoder;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.lsctng.AslLscBullhorn;
import de.vw.mib.lsctng.LscUserInteractionFilterService;
import de.vw.mib.lsctng.internal.CachableSkinClassLoaderInternal;
import de.vw.mib.lsctng.internal.CachingClassloader;
import de.vw.mib.lsctng.internal.ClassLoaderCache;
import de.vw.mib.lsctng.internal.ClassLoaderCacheSoftRef;
import de.vw.mib.lsctng.internal.ClassLoaderCacheStrongRef;
import de.vw.mib.lsctng.internal.GuiLscListener;
import de.vw.mib.lsctng.internal.GuiLscListener$TemporaryViewLanguageSkinChanger;
import de.vw.mib.lsctng.internal.JxeSkinClassLoader;
import de.vw.mib.lsctng.internal.LscControllerImpl;
import de.vw.mib.lsctng.internal.ServiceManager;
import de.vw.mib.lsctng.internal.SkinClassLoaderImpl;
import de.vw.mib.lsctng.internal.SkinClassLoaderInternal;
import de.vw.mib.skin.SkinAnimationUpdater;
import de.vw.mib.skin.SkinImagePoolUpdater;
import de.vw.mib.skin.ViewLanguageSkinChanger;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.util.StringBuilder;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

public final class Activator
implements BundleActivatorExtension,
ServiceListener {
    private BundleContext context;
    private boolean preloaded = false;
    private LscControllerImpl lscController;
    private Logger log;
    private boolean alreadyRegisteredLscController;
    private GuiLscListener guiLscListener;
    private static final String VIEWHANDLER_FORMAT_PROPERTY_NAME;
    private static final String FORMAT_ZIP;
    private static final String FORMAT_JAR;
    private static final String FORMAT_DEFAULT;
    private static final String VIEWHANDLER_FORMAT;
    private static final String CACHING_TYPE_PROPERTY_NAME;
    private static final String TYPE_STRONG;
    private static final String TYPE_SOFT;
    private static final String TYPE_WEAK;
    private static final String TYPE_DEFAULT;
    private static final String CACHING_TYPE;
    private static final int SUB_CLASSIFIER;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManagerValueSetter;
    static /* synthetic */ Class class$de$vw$mib$file$FileManager;
    static /* synthetic */ Class class$de$vw$mib$error$ErrorHandler;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$EventDispatcherManager;
    static /* synthetic */ Class class$de$vw$mib$event$dispatcher$StartupEventDispatcher;
    static /* synthetic */ Class class$de$vw$mib$threads$MIBThreadManager;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinClassLoader;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscController;
    static /* synthetic */ Class class$de$vw$mib$event$consumer$LSChangeEventConsumer;
    static /* synthetic */ Class class$de$vw$mib$lsctng$AslLscBullhorn;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinImagePoolUpdater;
    static /* synthetic */ Class class$de$vw$mib$skin$SkinAnimationUpdater;
    static /* synthetic */ Class class$de$vw$mib$framework4u$Framework4U;
    static /* synthetic */ Class class$de$vw$mib$i18n$I18nGuiUpdater;
    static /* synthetic */ Class class$de$vw$mib$i18n$I18nTableDecoder;
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscUserInteractionFilterService;
    static /* synthetic */ Class class$de$vw$mib$skin$ViewLanguageSkinChanger;

    @Override
    public void preload(BundleContext bundleContext) {
        this.context = bundleContext;
        this.alreadyRegisteredLscController = false;
        this.getAndCreateLogger();
        this.getAlreadyRegisteredServices();
        this.createServices();
        this.registerServiceListener();
        this.preloaded = true;
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    private void getAndCreateLogger() {
        ServiceManager.setLoggerFactory((LoggerFactory)this.context.getService(this.context.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName())));
        this.log = ServiceManager.createLogger();
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "logger created.");
        }
    }

    private void getAlreadyRegisteredServices() {
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "getAlreadyRegisteredServices() [start]");
        }
        ServiceManager.setConfigValueSetter((ConfigurationManagerValueSetter)this.context.getService(this.context.getServiceReference((class$de$vw$mib$configuration$ConfigurationManagerValueSetter == null ? (class$de$vw$mib$configuration$ConfigurationManagerValueSetter = Activator.class$("de.vw.mib.configuration.ConfigurationManagerValueSetter")) : class$de$vw$mib$configuration$ConfigurationManagerValueSetter).getName())));
        ServiceManager.setFileManager((FileManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$file$FileManager == null ? (class$de$vw$mib$file$FileManager = Activator.class$("de.vw.mib.file.FileManager")) : class$de$vw$mib$file$FileManager).getName())));
        ServiceManager.setErrorHandler((ErrorHandler)this.context.getService(this.context.getServiceReference((class$de$vw$mib$error$ErrorHandler == null ? (class$de$vw$mib$error$ErrorHandler = Activator.class$("de.vw.mib.error.ErrorHandler")) : class$de$vw$mib$error$ErrorHandler).getName())));
        ServiceManager.setEventDispatcher((FrameworkEventDispatcher)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.FrameworkEventDispatcher")) : class$de$vw$mib$event$dispatcher$FrameworkEventDispatcher).getName())));
        ServiceManager.setEventDispatcherManager((EventDispatcherManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$EventDispatcherManager == null ? (class$de$vw$mib$event$dispatcher$EventDispatcherManager = Activator.class$("de.vw.mib.event.dispatcher.EventDispatcherManager")) : class$de$vw$mib$event$dispatcher$EventDispatcherManager).getName())));
        ServiceManager.setStartupEventDispatcher((StartupEventDispatcher)this.context.getService(this.context.getServiceReference((class$de$vw$mib$event$dispatcher$StartupEventDispatcher == null ? (class$de$vw$mib$event$dispatcher$StartupEventDispatcher = Activator.class$("de.vw.mib.event.dispatcher.StartupEventDispatcher")) : class$de$vw$mib$event$dispatcher$StartupEventDispatcher).getName())));
        ServiceManager.setThreadManager((MIBThreadManager)this.context.getService(this.context.getServiceReference((class$de$vw$mib$threads$MIBThreadManager == null ? (class$de$vw$mib$threads$MIBThreadManager = Activator.class$("de.vw.mib.threads.MIBThreadManager")) : class$de$vw$mib$threads$MIBThreadManager).getName())));
        ServiceManager.setViewLanguageSkinChanger(GuiLscListener.getTemporaryViewLanguageSkinChanger());
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "getAlreadyRegisteredServices() [end]");
        }
    }

    private void createServices() {
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "createServices() [start]");
        }
        SkinClassLoaderInternal skinClassLoaderInternal = this.createSkinClassloader();
        this.context.registerService((class$de$vw$mib$skin$SkinClassLoader == null ? (class$de$vw$mib$skin$SkinClassLoader = Activator.class$("de.vw.mib.skin.SkinClassLoader")) : class$de$vw$mib$skin$SkinClassLoader).getName(), (Object)skinClassLoaderInternal, null);
        this.lscController = new LscControllerImpl();
        this.guiLscListener = new GuiLscListener(skinClassLoaderInternal);
        this.registerLscControllerServiceIfPossible();
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "createServices() [end]");
        }
    }

    private void registerLscControllerServiceIfPossible() {
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "registerLscControllerServiceIfPossible() [start]");
        }
        if (!this.alreadyRegisteredLscController && this.allNecessaryServicesRegistered()) {
            this.context.registerService(new String[]{(class$de$vw$mib$lsctng$LscController == null ? (class$de$vw$mib$lsctng$LscController = Activator.class$("de.vw.mib.lsctng.LscController")) : class$de$vw$mib$lsctng$LscController).getName(), (class$de$vw$mib$event$consumer$LSChangeEventConsumer == null ? (class$de$vw$mib$event$consumer$LSChangeEventConsumer = Activator.class$("de.vw.mib.event.consumer.LSChangeEventConsumer")) : class$de$vw$mib$event$consumer$LSChangeEventConsumer).getName()}, (Object)this.lscController, null);
            this.lscController.addHighPrioListener(this.guiLscListener, 1, "NO_LANGUAGE", -1, -1);
            this.alreadyRegisteredLscController = true;
        }
    }

    private boolean allNecessaryServicesRegistered() {
        return ServiceManager.lscBullhorn != null && ServiceManager.loggerFactory != null && ServiceManager.configValueSetter != null && ServiceManager.sipUpdater != null && ServiceManager.saUpdater != null && ServiceManager.i18nGuiUpdater != null && ServiceManager.i18nTableDecoder != null;
    }

    private SkinClassLoaderInternal createSkinClassloader() {
        return new CachingClassloader(this.createCachableSkinClassloader(VIEWHANDLER_FORMAT), this.createClassloaderCache(CACHING_TYPE));
    }

    private CachableSkinClassLoaderInternal createCachableSkinClassloader(String string) {
        if ("zip".equalsIgnoreCase(string)) {
            this.log.info(1, "Instatiating class loader: loading JXEs from viewhandler.zip");
            return new JxeSkinClassLoader();
        }
        if ("jar".equalsIgnoreCase(string)) {
            this.log.info(1, "Instantiating class loader: loading CLASSes from viewhandler.jar");
            return new SkinClassLoaderImpl();
        }
        this.log.warn(1).append("Unknown viewhandler format: ").append("viewhandler.format").append("=").append(string).append(". Fallback to default: ").append("jar").log();
        return this.createCachableSkinClassloader("jar");
    }

    private ClassLoaderCache createClassloaderCache(String string) {
        if ("strong".equalsIgnoreCase(string)) {
            if (this.log.isTraceEnabled(1)) {
                this.log.trace(1, "Instantiating class loader cache: using STRONG references.");
            }
            return new ClassLoaderCacheStrongRef();
        }
        if ("soft".equalsIgnoreCase(string) || "weak".equalsIgnoreCase(string)) {
            if (this.log.isTraceEnabled(1)) {
                this.log.trace(1, "Instantiating class loader cache: using SOFT references.");
            }
            return new ClassLoaderCacheSoftRef();
        }
        this.log.warn(1).append("Unknown caching type for classloaders: ").append("viewhandler.classloader.caching").append("=").append(string).append(". Fallback to default: ").append("strong").log();
        return this.createClassloaderCache("strong");
    }

    private void registerServiceListener() {
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "registerServiceListener() [start]");
        }
        String string = this.createFilter();
        ServiceListener serviceListener = this.addServiceListener(string);
        this.getAlreadyRegisteredServices(string, serviceListener);
        if (this.log.isTraceEnabled(1)) {
            this.log.trace(1, "registerServiceListener() [end]");
        }
    }

    private String createFilter() {
        StringBuilder stringBuilder = new StringBuilder(175);
        stringBuilder.append("(|(").append("objectClass").append("=").append((class$de$vw$mib$lsctng$AslLscBullhorn == null ? (class$de$vw$mib$lsctng$AslLscBullhorn = Activator.class$("de.vw.mib.lsctng.AslLscBullhorn")) : class$de$vw$mib$lsctng$AslLscBullhorn).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$skin$SkinImagePoolUpdater == null ? (class$de$vw$mib$skin$SkinImagePoolUpdater = Activator.class$("de.vw.mib.skin.SkinImagePoolUpdater")) : class$de$vw$mib$skin$SkinImagePoolUpdater).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$skin$SkinAnimationUpdater == null ? (class$de$vw$mib$skin$SkinAnimationUpdater = Activator.class$("de.vw.mib.skin.SkinAnimationUpdater")) : class$de$vw$mib$skin$SkinAnimationUpdater).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$framework4u$Framework4U == null ? (class$de$vw$mib$framework4u$Framework4U = Activator.class$("de.vw.mib.framework4u.Framework4U")) : class$de$vw$mib$framework4u$Framework4U).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$i18n$I18nGuiUpdater == null ? (class$de$vw$mib$i18n$I18nGuiUpdater = Activator.class$("de.vw.mib.i18n.I18nGuiUpdater")) : class$de$vw$mib$i18n$I18nGuiUpdater).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$i18n$I18nTableDecoder == null ? (class$de$vw$mib$i18n$I18nTableDecoder = Activator.class$("de.vw.mib.i18n.I18nTableDecoder")) : class$de$vw$mib$i18n$I18nTableDecoder).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$lsctng$LscUserInteractionFilterService == null ? (class$de$vw$mib$lsctng$LscUserInteractionFilterService = Activator.class$("de.vw.mib.lsctng.LscUserInteractionFilterService")) : class$de$vw$mib$lsctng$LscUserInteractionFilterService).getName());
        stringBuilder.append(")(").append("objectClass").append("=").append((class$de$vw$mib$skin$ViewLanguageSkinChanger == null ? (class$de$vw$mib$skin$ViewLanguageSkinChanger = Activator.class$("de.vw.mib.skin.ViewLanguageSkinChanger")) : class$de$vw$mib$skin$ViewLanguageSkinChanger).getName());
        stringBuilder.append("))");
        String string = stringBuilder.toString();
        return string;
    }

    private ServiceListener addServiceListener(String string) {
        this.context.addServiceListener(this, string);
        return this;
    }

    private void getAlreadyRegisteredServices(String string, ServiceListener serviceListener) {
        ServiceReference[] serviceReferenceArray = this.context.getServiceReferences(null, string);
        for (int i2 = 0; serviceReferenceArray != null && i2 < serviceReferenceArray.length; ++i2) {
            serviceListener.serviceChanged(new ServiceEvent(1, serviceReferenceArray[i2]));
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (serviceEvent.getType() != 1) {
            return;
        }
        String[] stringArray = (String[])serviceEvent.getServiceReference().getProperty("objectClass");
        Object object = this.context.getService(serviceEvent.getServiceReference());
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            this.handleServiceRegistered(stringArray[i2], object);
        }
        this.registerLscControllerServiceIfPossible();
    }

    private void handleServiceRegistered(String string, Object object) {
        if ((class$de$vw$mib$lsctng$AslLscBullhorn == null ? (class$de$vw$mib$lsctng$AslLscBullhorn = Activator.class$("de.vw.mib.lsctng.AslLscBullhorn")) : class$de$vw$mib$lsctng$AslLscBullhorn).getName().equals(string)) {
            ServiceManager.setLscBullhorn((AslLscBullhorn)object);
        } else if ((class$de$vw$mib$skin$SkinImagePoolUpdater == null ? (class$de$vw$mib$skin$SkinImagePoolUpdater = Activator.class$("de.vw.mib.skin.SkinImagePoolUpdater")) : class$de$vw$mib$skin$SkinImagePoolUpdater).getName().equals(string)) {
            ServiceManager.setSkinImagePoolUpdater((SkinImagePoolUpdater)object);
        } else if ((class$de$vw$mib$skin$SkinAnimationUpdater == null ? (class$de$vw$mib$skin$SkinAnimationUpdater = Activator.class$("de.vw.mib.skin.SkinAnimationUpdater")) : class$de$vw$mib$skin$SkinAnimationUpdater).getName().equals(string)) {
            ServiceManager.setSkinAnimationUpdater((SkinAnimationUpdater)object);
        } else if ((class$de$vw$mib$framework4u$Framework4U == null ? (class$de$vw$mib$framework4u$Framework4U = Activator.class$("de.vw.mib.framework4u.Framework4U")) : class$de$vw$mib$framework4u$Framework4U).getName().equals(string)) {
            ServiceManager.setFw4u((Framework4U)object);
        } else if ((class$de$vw$mib$i18n$I18nGuiUpdater == null ? (class$de$vw$mib$i18n$I18nGuiUpdater = Activator.class$("de.vw.mib.i18n.I18nGuiUpdater")) : class$de$vw$mib$i18n$I18nGuiUpdater).getName().equals(string)) {
            ServiceManager.setI18nGuiUpdater((I18nGuiUpdater)object);
        } else if ((class$de$vw$mib$i18n$I18nTableDecoder == null ? (class$de$vw$mib$i18n$I18nTableDecoder = Activator.class$("de.vw.mib.i18n.I18nTableDecoder")) : class$de$vw$mib$i18n$I18nTableDecoder).getName().equals(string)) {
            ServiceManager.setI18nTableDecoder((I18nTableDecoder)object);
        } else if ((class$de$vw$mib$lsctng$LscUserInteractionFilterService == null ? (class$de$vw$mib$lsctng$LscUserInteractionFilterService = Activator.class$("de.vw.mib.lsctng.LscUserInteractionFilterService")) : class$de$vw$mib$lsctng$LscUserInteractionFilterService).getName().equals(string)) {
            this.lscController.registerLscUserInteractionFilterService((LscUserInteractionFilterService)object);
        } else if ((class$de$vw$mib$skin$ViewLanguageSkinChanger == null ? (class$de$vw$mib$skin$ViewLanguageSkinChanger = Activator.class$("de.vw.mib.skin.ViewLanguageSkinChanger")) : class$de$vw$mib$skin$ViewLanguageSkinChanger).getName().equals(string) && ServiceManager.viewLanguageSkinChanger instanceof GuiLscListener$TemporaryViewLanguageSkinChanger) {
            ((GuiLscListener$TemporaryViewLanguageSkinChanger)ServiceManager.viewLanguageSkinChanger).installNewViewLanguageSkinChanger((ViewLanguageSkinChanger)object);
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

    static {
        VIEWHANDLER_FORMAT = System.getProperty("viewhandler.format", "jar");
        CACHING_TYPE = System.getProperty("viewhandler.classloader.caching", "strong");
    }
}

