/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class VicsTarget$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ VicsTarget this$0;

    VicsTarget$1(VicsTarget vicsTarget, BundleContext bundleContext) {
        this.this$0 = vicsTarget;
        this.val$bundleContext = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.promptEngine = (PromptEngine)this.val$bundleContext.getService(serviceReference);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(295326976);
        return this.this$0.promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

