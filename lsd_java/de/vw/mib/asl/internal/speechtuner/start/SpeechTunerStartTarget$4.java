/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.start;

import de.vw.mib.asl.internal.speechtuner.start.SpeechTunerStartTarget;
import de.vw.mib.cio.CioDispatcher;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechTunerStartTarget$4
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechTunerStartTarget this$0;

    SpeechTunerStartTarget$4(SpeechTunerStartTarget speechTunerStartTarget) {
        this.this$0 = speechTunerStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("found a CioDispatcher");
        }
        this.this$0.cioDispatcher = (CioDispatcher)this.this$0.bundleContext.getService(serviceReference);
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

