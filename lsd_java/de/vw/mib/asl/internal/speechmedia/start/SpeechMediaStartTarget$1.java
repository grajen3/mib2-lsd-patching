/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechmedia.start.SpeechMediaStartTarget;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechMediaStartTarget$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechMediaStartTarget this$0;

    SpeechMediaStartTarget$1(SpeechMediaStartTarget speechMediaStartTarget) {
        this.this$0 = speechMediaStartTarget;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.speechEngine = (SpeechEngineMaster)this.this$0.bundleContext.getService(serviceReference);
        this.this$0.fireReady();
        this.this$0.registerControllers();
        return this.this$0.speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

