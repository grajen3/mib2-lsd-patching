/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.TargetPhoneStartup;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TargetPhoneStartup$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TargetPhoneStartup this$0;

    TargetPhoneStartup$1(TargetPhoneStartup targetPhoneStartup) {
        this.this$0 = targetPhoneStartup;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        PromptEngine promptEngine = (PromptEngine)ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext().getService(serviceReference);
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-477948672);
        return promptEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

