/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.messages;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.messages.HsmPhoneSMSHandling;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HsmPhoneSMSHandling$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HsmPhoneSMSHandling this$0;

    HsmPhoneSMSHandling$1(HsmPhoneSMSHandling hsmPhoneSMSHandling) {
        this.this$0 = hsmPhoneSMSHandling;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)this.this$0.bundleContext.getService(serviceReference);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1176367872);
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

