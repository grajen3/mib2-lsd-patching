/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerASLServices;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerLogger;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerModelServices;
import de.vw.mib.asl.internal.speechtuner.utils.SpeechTunerServiceManager;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.RadioUtilsImpl;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.SpeechTunerASLServiceImpl;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.SpeechTunerLoggerImpl;
import de.vw.mib.asl.internal.speechtuner.utils.implementation.SpeechTunerModelServicesImpl;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class SpeechTunerServiceManagerImpl
implements SpeechTunerServiceManager {
    private static final String LOGGER_PREFIX;
    private final Services frameworkServices = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
    private final Logger logger;
    private final BundleContext bundleContext = this.frameworkServices.getBundleContext();
    private final SpeechTunerLogger myLogger;
    private final SpeechTunerModelServices modelServices;
    private final SpeechTunerASLServices aslServices;
    private final RadioUtils radioUtils;
    static /* synthetic */ Class class$de$vw$mib$configuration$ConfigurationManager;
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;

    public SpeechTunerServiceManagerImpl() {
        ConfigurationManager configurationManager = (ConfigurationManager)this.retrieveService(class$de$vw$mib$configuration$ConfigurationManager == null ? (class$de$vw$mib$configuration$ConfigurationManager = SpeechTunerServiceManagerImpl.class$("de.vw.mib.configuration.ConfigurationManager")) : class$de$vw$mib$configuration$ConfigurationManager);
        LoggerFactory loggerFactory = (LoggerFactory)this.retrieveService(class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = SpeechTunerServiceManagerImpl.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory);
        this.logger = loggerFactory.getLogger(4096);
        this.myLogger = this.createSpeechTunerLogger("[SpeechTunerServiceManager] ");
        this.modelServices = new SpeechTunerModelServicesImpl(this.frameworkServices);
        this.aslServices = new SpeechTunerASLServiceImpl(this.frameworkServices, configurationManager);
        this.radioUtils = new RadioUtilsImpl(this.frameworkServices.getFixFormat4Asl());
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public SpeechTunerModelServices getModelServices() {
        return this.modelServices;
    }

    @Override
    public SpeechTunerASLServices getASLServices() {
        return this.aslServices;
    }

    @Override
    public RadioUtils getRadioUtils() {
        return this.radioUtils;
    }

    @Override
    public SpeechTunerLogger createSpeechTunerLogger(String string) {
        return new SpeechTunerLoggerImpl(string, this.logger);
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

