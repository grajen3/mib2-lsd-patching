/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.utils;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public final class SpeechGeneralServiceManager {
    static final String LOGGING_PREFIX;
    static Services SGSM_ASL_API_SERVICES;
    static Logger SGSM_LOGGER;
    static AsyncServiceFactory SGSM_ASYNC_SERVICE_FACTORY;
    static BundleContext SGSM_BUNDLE_CONTEXT;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    private SpeechGeneralServiceManager() {
    }

    public static Logger getLogger() {
        if (SGSM_LOGGER == null) {
            LoggerFactory loggerFactory = (LoggerFactory)SpeechGeneralServiceManager.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechGeneralServiceManager.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
            SGSM_LOGGER = loggerFactory.getLogger(4096);
        }
        return SGSM_LOGGER;
    }

    public static BundleContext getBundleContext() {
        return SGSM_BUNDLE_CONTEXT;
    }

    public static SystemEventDispatcher getSystemEventDispatcher() {
        return SGSM_ASL_API_SERVICES.getSystemEventDispatcher();
    }

    public static Services getAslApiServices() {
        return SGSM_ASL_API_SERVICES;
    }

    private static Object retrieveService(Class clazz) {
        return SpeechGeneralServiceManager.retrieveService(clazz, null);
    }

    private static Object retrieveService(Class clazz, String string) {
        String string2 = clazz.getName();
        ServiceReference serviceReference = SpeechGeneralServiceManager.getServiceReference(string2, string);
        return SpeechGeneralServiceManager.getServiceObject(serviceReference, string2);
    }

    private static ServiceReference getServiceReference(String string, String string2) {
        if (string2 == null) {
            return SGSM_BUNDLE_CONTEXT.getServiceReference(string);
        }
        return SpeechGeneralServiceManager.getServiceReferenceByFilter(string, string2);
    }

    private static ServiceReference getServiceReferenceByFilter(String string, String string2) {
        ServiceReference serviceReference = null;
        try {
            ServiceReference[] serviceReferenceArray = SGSM_BUNDLE_CONTEXT.getServiceReferences(string, string2);
            if (serviceReferenceArray != null && serviceReferenceArray.length > 0) {
                serviceReference = SGSM_BUNDLE_CONTEXT.getServiceReferences(string, string2)[0];
            }
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            serviceReference = null;
        }
        return serviceReference;
    }

    private static Object getServiceObject(ServiceReference serviceReference, String string) {
        Object object;
        if (serviceReference == null) {
            SpeechGeneralServiceManager.logNullPointerError(string);
            object = null;
        } else {
            object = SGSM_BUNDLE_CONTEXT.getService(serviceReference);
        }
        return object;
    }

    private static void logNullPointerError(String string) {
        LogMessage logMessage = SpeechGeneralServiceManager.getLogger().fatal(8);
        logMessage.append("[SpeechGeneralServiceManager] ");
        logMessage.append("SpeechGeneralServiceManager#retrieveService( ");
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

    static {
        SGSM_ASL_API_SERVICES = null;
        SGSM_LOGGER = null;
        SGSM_ASYNC_SERVICE_FACTORY = null;
        SGSM_BUNDLE_CONTEXT = null;
        SGSM_ASL_API_SERVICES = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        SGSM_BUNDLE_CONTEXT = SGSM_ASL_API_SERVICES.getBundleContext();
    }
}

