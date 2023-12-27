/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechheadline.utils.implementation;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineLogger;
import de.vw.mib.asl.internal.speechheadline.utils.SpeechHeadlineServiceManager;
import de.vw.mib.asl.internal.speechheadline.utils.implementation.SpeechHeadlineLoggerImpl;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class SpeechHeadlineServiceManagerImpl
implements SpeechHeadlineServiceManager {
    private static final String LOGGER_PREFIX;
    private Services frameworkServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
    private Logger logger;
    private BundleContext bundleContext = this.frameworkServices.getBundleContext();
    private SpeechHeadlineLogger myLogger;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public SpeechHeadlineServiceManagerImpl() {
        LoggerFactory loggerFactory = (LoggerFactory)this.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechHeadlineServiceManagerImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        this.logger = loggerFactory.getLogger(4096);
        this.myLogger = this.createSpeechHeadlineLogger("[SpeechHeadlineServiceManager] ");
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public SpeechHeadlineLogger createSpeechHeadlineLogger(String string) {
        return new SpeechHeadlineLoggerImpl(string, this.logger);
    }

    private Object retrieveService(Class clazz) {
        String string = clazz.getName();
        ServiceReference serviceReference = this.bundleContext.getServiceReference(string);
        return this.getServiceObject(serviceReference, string);
    }

    private Object getServiceObject(ServiceReference serviceReference, String string) {
        Object object;
        if (serviceReference == null) {
            this.myLogger.fatal(new StringBuffer().append("retrieveService(").append(string).append(") triggered before the service was ready. This service should be ready before the ASL.").toString());
            object = null;
        } else {
            object = this.bundleContext.getService(serviceReference);
        }
        return object;
    }

    @Override
    public void writeIntegerToDatapool(int n, int n2) {
        this.frameworkServices.getASLPropertyManager().valueChangedInteger(n, n2);
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

