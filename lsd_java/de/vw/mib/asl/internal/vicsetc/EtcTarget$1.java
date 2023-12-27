/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.vicsetc.EtcTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class EtcTarget$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$bundleContext;
    private final /* synthetic */ EtcTarget this$0;

    EtcTarget$1(EtcTarget etcTarget, BundleContext bundleContext) {
        this.this$0 = etcTarget;
        this.val$bundleContext = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)this.val$bundleContext.getService(serviceReference);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(295326976);
        EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent(this.this$0.getTargetId(), this.this$0.getTargetId(), 295326976);
        try {
            ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
        }
        catch (GenericEventException genericEventException) {
            EtcTarget.access$000(this.this$0, "EtcTarget: EventDispatcher could not send VICSETC_SPEECH_PROMP_ENGINE_READY");
        }
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

