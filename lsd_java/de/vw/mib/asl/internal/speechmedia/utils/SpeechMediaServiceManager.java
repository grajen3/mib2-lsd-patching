/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.utils;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public final class SpeechMediaServiceManager {
    private static final String LOGGING_PREFIX;
    private static final String SSM_ASYNC_SERVICE_FACTORY_FILTER;
    private final BundleContext bundleContext;
    private final Services aslApiServices;
    private Logger logger = null;
    private ThreadSwitchingTarget threadSwitchingTarget = null;
    private TimerManager timerManager = null;
    private AsyncServiceFactory asyncServiceFactory = null;
    private CioDictionary cioDictionary;
    private CioDispatcher cioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$genericevents$ThreadSwitchingTarget;
    static /* synthetic */ Class class$de$vw$mib$timer$TimerManager;

    public SpeechMediaServiceManager(BundleContext bundleContext, Services services) {
        this.bundleContext = bundleContext;
        this.aslApiServices = services;
    }

    public AsyncServiceFactory getAsyncServiceFactory() {
        if (this.asyncServiceFactory == null) {
            this.asyncServiceFactory = (AsyncServiceFactory)this.retrieveService(class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = SpeechMediaServiceManager.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory, "(MIBThreadId=3)");
        }
        return this.asyncServiceFactory;
    }

    public CioDictionary getCioDictionary() {
        if (this.cioDictionary == null) {
            this.cioDictionary = (CioDictionary)this.retrieveService(class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = SpeechMediaServiceManager.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary);
        }
        return this.cioDictionary;
    }

    public CioDispatcher getCioDispatcher() {
        if (this.cioDispatcher == null) {
            this.cioDispatcher = (CioDispatcher)this.retrieveService(class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = SpeechMediaServiceManager.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher);
        }
        return this.cioDispatcher;
    }

    public Logger getLogger() {
        if (this.logger == null) {
            LoggerFactory loggerFactory = (LoggerFactory)this.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechMediaServiceManager.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
            this.logger = loggerFactory.getLogger(4096);
        }
        return this.logger;
    }

    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.aslApiServices.getSystemEventDispatcher();
    }

    public Services getAslApiServices() {
        return this.aslApiServices;
    }

    public ThreadSwitchingTarget getThreadSwitchingTarget() {
        if (this.threadSwitchingTarget == null) {
            this.threadSwitchingTarget = (ThreadSwitchingTarget)this.retrieveService(class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (class$de$vw$mib$genericevents$ThreadSwitchingTarget = SpeechMediaServiceManager.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : class$de$vw$mib$genericevents$ThreadSwitchingTarget);
        }
        return this.threadSwitchingTarget;
    }

    public ASLListManager getAslListManager() {
        return this.aslApiServices.getASLListManager();
    }

    public TimerManager getTimerManager() {
        if (this.timerManager == null) {
            this.timerManager = (TimerManager)this.retrieveService(class$de$vw$mib$timer$TimerManager == null ? (class$de$vw$mib$timer$TimerManager = SpeechMediaServiceManager.class$("de.vw.mib.timer.TimerManager")) : class$de$vw$mib$timer$TimerManager);
        }
        return this.timerManager;
    }

    private Object retrieveService(Class clazz) {
        return this.retrieveService(clazz, null);
    }

    private Object retrieveService(Class clazz, String string) {
        String string2 = clazz.getName();
        ServiceReference serviceReference = this.getServiceReference(string2, string);
        return this.getServiceObject(serviceReference, string2);
    }

    private ServiceReference getServiceReference(String string, String string2) {
        if (string2 == null) {
            return this.bundleContext.getServiceReference(string);
        }
        return this.getServiceReferenceByFilter(string, string2);
    }

    private ServiceReference getServiceReferenceByFilter(String string, String string2) {
        ServiceReference serviceReference = null;
        try {
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences(string, string2);
            if (serviceReferenceArray != null && serviceReferenceArray.length > 0) {
                serviceReference = this.bundleContext.getServiceReferences(string, string2)[0];
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            serviceReference = null;
        }
        return serviceReference;
    }

    private Object getServiceObject(ServiceReference serviceReference, String string) {
        Object object;
        if (serviceReference == null) {
            this.logNullPointerError(string);
            object = null;
        } else {
            object = this.bundleContext.getService(serviceReference);
        }
        return object;
    }

    private void logNullPointerError(String string) {
        LogMessage logMessage = this.getLogger().fatal(8192);
        logMessage.append("[SpeechMediaServiceManager] ");
        logMessage.append("SpeechMediaServiceManager#retrieveService( ");
        logMessage.append(string);
        logMessage.append(" ) triggered before the service was ready. This service should be ready before the ASL.");
        logMessage.log();
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

