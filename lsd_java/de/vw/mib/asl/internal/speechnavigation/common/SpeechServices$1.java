/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.common;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechnavigation.common.SpeechServices;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

final class SpeechServices$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$ctx;

    SpeechServices$1(BundleContext bundleContext) {
        this.val$ctx = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechServices.speechEngine = (SpeechEngineMaster)this.val$ctx.getService(serviceReference);
        return SpeechServices.speechEngine;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

