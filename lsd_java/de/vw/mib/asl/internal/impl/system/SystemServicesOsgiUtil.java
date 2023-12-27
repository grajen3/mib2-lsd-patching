/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

class SystemServicesOsgiUtil {
    private static final String LOGGER_PREFIX;
    private final BundleContext bundleContext;
    private final Logger logger;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;

    SystemServicesOsgiUtil(BundleContext bundleContext, Logger logger) {
        this.bundleContext = bundleContext;
        this.logger = logger;
    }

    AsyncServiceFactory retrieveAsyncServiceFactory() {
        String string = "(MIBThreadId=3)";
        return (AsyncServiceFactory)this.retrieveOsgiService(class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = SystemServicesOsgiUtil.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory, string);
    }

    Object retrieveOsgiService(Class clazz, String string) {
        ServiceReference[] serviceReferenceArray;
        if (clazz == null) {
            this.logger.error(2048, "[SystemServicesOsgiUtil] Mandatory argument is null.");
            return null;
        }
        try {
            serviceReferenceArray = this.bundleContext.getServiceReferences(clazz.getName(), string);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            this.logger.error(2048, new StringBuffer().append("[SystemServicesOsgiUtil] Invalid synthax to retrieve >").append(clazz.getName()).append("<.").toString());
            return null;
        }
        if (serviceReferenceArray == null || serviceReferenceArray.length != 1 || serviceReferenceArray[0] == null) {
            this.logger.error(2048, new StringBuffer().append("[SystemServicesOsgiUtil] Could not find service >").append(clazz.getName()).append("< which is mandantory for the ASL-System.").toString());
            return null;
        }
        Object object = this.bundleContext.getService(serviceReferenceArray[0]);
        object = this.checkResultType(clazz, object);
        return object;
    }

    private Object checkResultType(Class clazz, Object object) {
        if (object == null) {
            this.logger.error(2048, new StringBuffer().append("[SystemServicesOsgiUtil] Invalid service reference for >").append(clazz.getName()).append("<.").toString());
        } else if (!clazz.isInstance(object)) {
            this.logger.error(2048, new StringBuffer().append("[SystemServicesOsgiUtil] Searched service type >").append(clazz.getName()).append("< but found >").append(object.getClass().getName()).append("<.").toString());
            object = null;
        }
        return object;
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

