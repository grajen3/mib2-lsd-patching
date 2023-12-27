/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.startup.clients;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateConsumer;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class LegacyDomainAvailableHandler
implements ApplicationStateConsumer,
ServiceTrackerCustomizer {
    private final BundleContext bundleContext;
    private final ASLPropertyManager aslPropertyManager;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$SpeechEngine;

    public LegacyDomainAvailableHandler(BundleContext bundleContext, ASLPropertyManager aSLPropertyManager) {
        this.bundleContext = bundleContext;
        this.aslPropertyManager = aSLPropertyManager;
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$SpeechEngine == null ? (class$de$vw$mib$asl$api$speechengine$SpeechEngine = LegacyDomainAvailableHandler.class$("de.vw.mib.asl.api.speechengine.SpeechEngine")) : class$de$vw$mib$asl$api$speechengine$SpeechEngine).getName(), (ServiceTrackerCustomizer)this);
        serviceTracker.open();
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)this.bundleContext.getService(serviceReference);
        ApplicationStateRouter applicationStateRouter = speechEngine.getApplicationStateRouter();
        applicationStateRouter.register(this);
        int n = applicationStateRouter.getApplicationState();
        this.onApplicationStateChanged(n);
        return speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void onApplicationStateChanged(int n) {
        if (n == 2) {
            this.setDomainAvailable(true);
        } else {
            this.setDomainAvailable(false);
        }
    }

    private void setDomainAvailable(boolean bl) {
        if (bl) {
            this.aslPropertyManager.valueChangedInteger(1691, 1);
        } else {
            this.aslPropertyManager.valueChangedInteger(1691, 0);
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

