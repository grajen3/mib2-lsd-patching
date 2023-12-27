/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.HsmSoundConnectionHandling$StateSoundConnectionHandlingInit;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class HsmSoundConnectionHandling$StateSoundConnectionHandlingInit$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ HsmSoundConnectionHandling$StateSoundConnectionHandlingInit this$1;

    HsmSoundConnectionHandling$StateSoundConnectionHandlingInit$1(HsmSoundConnectionHandling$StateSoundConnectionHandlingInit hsmSoundConnectionHandling$StateSoundConnectionHandlingInit) {
        this.this$1 = hsmSoundConnectionHandling$StateSoundConnectionHandlingInit;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)this.this$1.bundleContext.getService(serviceReference);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1386093312);
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

