/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AslTargetSystemPowerManagementHandling$6
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$6(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling, BundleContext bundleContext) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
        this.val$bundleContext = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)this.val$bundleContext.getService(serviceReference);
        this.this$0.installDialogStateRouter(speechEngine.getDialogStateRouter());
        return speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

