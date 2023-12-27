/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.target;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.target.ASLHandler;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class ASLHandler$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ ASLHandler this$0;

    ASLHandler$3(ASLHandler aSLHandler) {
        this.this$0 = aSLHandler;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechEngine speechEngine = (SpeechEngine)ServiceManager.bundleContext.getService(serviceReference);
        speechEngine.getIndicatorStateRouter().register(this.this$0.indicatorStateConsumer);
        return speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

