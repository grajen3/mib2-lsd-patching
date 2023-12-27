/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.speechproxy;

import de.vw.mib.activation.BundleActivatorExtension;
import de.vw.mib.asl.internal.speechengine.features.FeatureFactoryImpl;
import de.vw.mib.asl.internal.speechengine.speechproxy.Activator$1;
import de.vw.mib.asl.internal.speechengine.speechproxy.SpeechProxyImpl;
import de.vw.mib.asl.internal.speechengine.speechproxy.SpeechProxyLogger;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.log4mib.LoggerFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class Activator
implements BundleActivatorExtension {
    private boolean preloaded = false;
    SpeechProxyImpl speechProxy;
    FeatureFactoryImpl featureFactory;
    BundleContext bundleContext;
    AbstractClassifiedLogger logger;
    private ServiceTrackerCustomizer dialogManagerTracker = new Activator$1(this);
    static /* synthetic */ Class class$de$vw$mib$log4mib$LoggerFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$features$FeatureFactory;

    @Override
    public void start(BundleContext bundleContext) {
        if (!this.preloaded) {
            this.preload(bundleContext);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    @Override
    public void preload(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$vw$mib$log4mib$LoggerFactory == null ? (class$de$vw$mib$log4mib$LoggerFactory = Activator.class$("de.vw.mib.log4mib.LoggerFactory")) : class$de$vw$mib$log4mib$LoggerFactory).getName());
        LoggerFactory loggerFactory = (LoggerFactory)bundleContext.getService(serviceReference);
        this.logger = new SpeechProxyLogger(loggerFactory.getLogger(4096));
        this.speechProxy = new SpeechProxyImpl(this.logger);
        this.featureFactory = new FeatureFactoryImpl(this.logger);
        this.retrieveServices();
        this.provideServices();
        this.preloaded = true;
    }

    private void retrieveServices() {
        ServiceTracker serviceTracker = new ServiceTracker(this.bundleContext, (class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy == null ? (class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy = Activator.class$("de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy")) : class$de$vw$mib$asl$internal$speechengine$dialogmanager$DialogManagerProxy).getName(), this.dialogManagerTracker);
        serviceTracker.open();
    }

    private void provideServices() {
        this.bundleContext.registerService((class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy == null ? (class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy = Activator.class$("de.vw.mib.asl.api.speechengine.speechproxy.SpeechProxy")) : class$de$vw$mib$asl$api$speechengine$speechproxy$SpeechProxy).getName(), (Object)this.speechProxy, null);
        this.bundleContext.registerService((class$de$vw$mib$asl$api$speechengine$features$FeatureFactory == null ? (class$de$vw$mib$asl$api$speechengine$features$FeatureFactory = Activator.class$("de.vw.mib.asl.api.speechengine.features.FeatureFactory")) : class$de$vw$mib$asl$api$speechengine$features$FeatureFactory).getName(), (Object)this.featureFactory, null);
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

