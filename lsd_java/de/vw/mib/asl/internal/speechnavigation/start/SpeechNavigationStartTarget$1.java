/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.start;

import de.vw.mib.asl.internal.speechnavigation.start.SpeechNavigationStartTarget;
import de.vw.mib.cio.CioDictionary;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechNavigationStartTarget$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechNavigationStartTarget this$0;

    SpeechNavigationStartTarget$1(SpeechNavigationStartTarget speechNavigationStartTarget) {
        this.this$0 = speechNavigationStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.cioDictionary = (CioDictionary)SpeechNavigationStartTarget.getASLServices().getBundleContext().getService(serviceReference);
        this.this$0.checkServices();
        return this.this$0.cioDictionary;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

