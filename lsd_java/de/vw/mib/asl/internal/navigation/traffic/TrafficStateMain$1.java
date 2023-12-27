/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMain;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TrafficStateMain$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ TrafficStateMain this$0;

    TrafficStateMain$1(TrafficStateMain trafficStateMain, BundleContext bundleContext) {
        this.this$0 = trafficStateMain;
        this.val$bundleContext = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)this.val$bundleContext.getService(serviceReference);
        this.this$0.target.sendHMIEvent(133173248);
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

