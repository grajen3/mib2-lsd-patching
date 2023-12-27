/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.start;

import de.vw.mib.asl.internal.speechnavigation.start.SpeechNavigationStartTarget;
import de.vw.mib.cio.CioDispatcher;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechNavigationStartTarget$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechNavigationStartTarget this$0;

    SpeechNavigationStartTarget$2(SpeechNavigationStartTarget speechNavigationStartTarget) {
        this.this$0 = speechNavigationStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.cioDispatcher = (CioDispatcher)SpeechNavigationStartTarget.getASLServices().getBundleContext().getService(serviceReference);
        this.this$0.checkServices();
        return this.this$0.cioDispatcher;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

