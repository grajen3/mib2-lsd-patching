/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

public abstract class ServiceRetriever {
    static final String LOGGING_PREFIX;
    protected final BundleContext bundleContext;
    protected Logger logger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    protected ServiceRetriever(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        LoggerFactory loggerFactory = (LoggerFactory)this.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = ServiceRetriever.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        this.logger = loggerFactory.getLogger(4096);
    }

    public Logger getSpeechLogger() {
        return this.logger;
    }

    protected Object retrieveService(Class clazz) {
        return this.retrieveService(clazz, null);
    }

    protected Object retrieveService(Class clazz, String string) {
        Object object;
        String string2 = clazz.getName();
        ServiceReference serviceReference = null;
        if (string == null) {
            serviceReference = this.bundleContext.getServiceReference(string2);
        } else {
            try {
                object = this.bundleContext.getServiceReferences(string2, string);
                if (object != null && ((ServiceReference[])object).length > 0) {
                    serviceReference = this.bundleContext.getServiceReferences(string2, string)[0];
                }
            }
            catch (InvalidSyntaxException invalidSyntaxException) {
                serviceReference = null;
            }
        }
        if (serviceReference == null) {
            LogMessage logMessage = this.logger.fatal(8);
            logMessage.append("[ServiceRetriever] ");
            logMessage.append("SpeechServiceManager#retrieveService( ");
            logMessage.append(string2);
            logMessage.append(" ) triggered before the service was ready. This service should be ready before the ASL.");
            logMessage.log();
            object = null;
        } else {
            object = this.bundleContext.getService(serviceReference);
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

