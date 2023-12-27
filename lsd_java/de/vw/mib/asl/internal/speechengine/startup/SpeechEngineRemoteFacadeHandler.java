/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechengine.remote.start.SpeechEngineRemoteFacadeActivator;
import de.vw.mib.asl.internal.speechengine.remote.start.SpeechEngineRemoteFacadeParameters;
import de.vw.mib.asl.internal.speechengine.startup.FrameworkServices;
import de.vw.mib.asl.internal.speechengine.startup.SpeechComponentStarter;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class SpeechEngineRemoteFacadeHandler
extends SpeechComponentStarter
implements SpeechEngineRemoteFacadeParameters,
ServiceTrackerCustomizer {
    private final SpeechEngineRemoteFacadeActivator remoteFacadeActivator;
    private final Logger loggerInternal;
    private final FrameworkServices frameworkServices;
    private SpeechEngineMaster speechEngineMaster;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster;

    SpeechEngineRemoteFacadeHandler(AbstractClassifiedLogger abstractClassifiedLogger, FrameworkServices frameworkServices) {
        super(abstractClassifiedLogger);
        this.loggerInternal = frameworkServices.getSpeechLogger();
        this.frameworkServices = frameworkServices;
        this.remoteFacadeActivator = (SpeechEngineRemoteFacadeActivator)super.getActivatorViaReflection("de.vw.mib.asl.internal.speechengine.remote.SpeechEngineRemoteFacadeStart");
        ServiceTracker serviceTracker = new ServiceTracker(frameworkServices.getBundleContext(), (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster = SpeechEngineRemoteFacadeHandler.class$("de.vw.mib.asl.api.speechengine.SpeechEngineMaster")) : class$de$vw$mib$asl$api$speechengine$SpeechEngineMaster).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
    }

    void servicesChanged() {
        if (this.speechEngineMaster != null) {
            this.remoteFacadeActivator.activate(this);
        }
    }

    @Override
    public Logger getLogger() {
        return this.loggerInternal;
    }

    @Override
    public FrameworkEventDispatcher getFrameworkEventDispatcher() {
        return this.frameworkServices.getFrameworkEventDispatcher();
    }

    @Override
    public BundleContext getBundleContext() {
        return this.frameworkServices.getBundleContext();
    }

    @Override
    public SpeechEngineMaster getSpeechEngineMaster() {
        return this.speechEngineMaster;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngineMaster speechEngineMaster;
        this.speechEngineMaster = speechEngineMaster = (SpeechEngineMaster)this.frameworkServices.getBundleContext().getService(serviceReference);
        this.servicesChanged();
        return speechEngineMaster;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Framework4U getFramework4u() {
        return this.frameworkServices.getFramework4u();
    }

    @Override
    public AsyncServiceFactory getAsyncServiceFactoryASL() {
        return this.frameworkServices.getAsyncServiceFactory();
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

