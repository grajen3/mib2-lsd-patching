/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.startup;

import de.vw.mib.asl.internal.speechgeneral.startup.SpeechGeneralStartTarget;
import de.vw.mib.cio.CioDictionary;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechGeneralStartTarget$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechGeneralStartTarget this$0;

    SpeechGeneralStartTarget$2(SpeechGeneralStartTarget speechGeneralStartTarget) {
        this.this$0 = speechGeneralStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.cioDictionary = (CioDictionary)this.this$0.bundleContext.getService(serviceReference);
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

