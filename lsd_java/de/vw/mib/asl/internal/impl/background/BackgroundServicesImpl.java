/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.background;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.internal.background.BackgroundServices;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class BackgroundServicesImpl
implements BackgroundServices {
    private final ASLPropertyManager propertyManager;
    private final BundleContext bundleContext;
    private final ConfigurationManagerDiag configurationManager;
    private final AsyncServiceFactory asyncServiceFactory;
    private final Logger logger;
    static /* synthetic */ Class class$de$vw$mib$threads$AsyncServiceFactory;

    public BackgroundServicesImpl() {
        Services services = ASLFrameworkFactory.getASLFrameworkAPI().getServices();
        this.logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
        this.propertyManager = services.getASLPropertyManager();
        this.bundleContext = services.getBundleContext();
        this.configurationManager = services.getConfigurationManagerDiag();
        this.asyncServiceFactory = this.retreiveAsyncServiceFactory();
    }

    @Override
    public ASLPropertyManager getAslPropertyManager() {
        return this.propertyManager;
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public ConfigurationManagerDiag getConfigurationManager() {
        return this.configurationManager;
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactory() {
        return this.asyncServiceFactory;
    }

    private AsyncServiceFactory retreiveAsyncServiceFactory() {
        String string = "(MIBThreadId=3)";
        try {
            ServiceReference[] serviceReferenceArray = this.bundleContext.getServiceReferences((class$de$vw$mib$threads$AsyncServiceFactory == null ? (class$de$vw$mib$threads$AsyncServiceFactory = BackgroundServicesImpl.class$("de.vw.mib.threads.AsyncServiceFactory")) : class$de$vw$mib$threads$AsyncServiceFactory).getName(), string);
            return (AsyncServiceFactory)this.bundleContext.getService(serviceReferenceArray[0]);
        }
        catch (Exception exception) {
            this.logger.error(2048).append("Cannot get AsyncServiceFactory").attachThrowable(exception).log();
            return null;
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

