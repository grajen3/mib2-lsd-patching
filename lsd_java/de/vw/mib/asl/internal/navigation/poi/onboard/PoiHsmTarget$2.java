/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PoiHsmTarget$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ DialogStateConsumer val$dialogStateConsumer;
    private final /* synthetic */ PoiHsmTarget this$0;

    PoiHsmTarget$2(PoiHsmTarget poiHsmTarget, BundleContext bundleContext, DialogStateConsumer dialogStateConsumer) {
        this.this$0 = poiHsmTarget;
        this.val$bundleContext = bundleContext;
        this.val$dialogStateConsumer = dialogStateConsumer;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)this.val$bundleContext.getService(serviceReference);
        speechEngine.getDialogStateRouter().register(this.val$dialogStateConsumer);
        return speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

