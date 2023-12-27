/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.speechengine.SpeechEngine;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MessagingDependencyResolver$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MessagingDependencyResolver this$0;

    MessagingDependencyResolver$1(MessagingDependencyResolver messagingDependencyResolver) {
        this.this$0 = messagingDependencyResolver;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.speechEngine = (SpeechEngine)this.this$0.bundleContext.getService(serviceReference);
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("found SpeechEngine");
        }
        this.this$0.registry.requestAPI(MessagingDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService == null ? (MessagingDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService = MessagingDependencyResolver.class$("de.vw.mib.asl.api.phone.PhoneService")) : MessagingDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService, new MessagingDependencyResolver$1$1(this));
        return this.this$0.speechEngine;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ MessagingDependencyResolver access$000(MessagingDependencyResolver$1 messagingDependencyResolver$1) {
        return messagingDependencyResolver$1.this$0;
    }
}

