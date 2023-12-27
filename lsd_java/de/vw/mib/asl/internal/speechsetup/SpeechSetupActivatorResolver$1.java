/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechsetup.SpeechSetupActivatorResolver;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechSetupActivatorResolver$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechSetupActivatorResolver this$0;

    SpeechSetupActivatorResolver$1(SpeechSetupActivatorResolver speechSetupActivatorResolver) {
        this.this$0 = speechSetupActivatorResolver;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.speechEngine = (SpeechEngineMaster)this.this$0.bundleContext.getService(serviceReference);
        this.this$0.serviceChanged();
        return this.this$0.speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

