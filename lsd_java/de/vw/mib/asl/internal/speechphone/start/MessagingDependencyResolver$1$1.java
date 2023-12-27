/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1;

class MessagingDependencyResolver$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ MessagingDependencyResolver$1 this$1;

    MessagingDependencyResolver$1$1(MessagingDependencyResolver$1 messagingDependencyResolver$1) {
        this.this$1 = messagingDependencyResolver$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)this.this$1).phoneService = (PhoneService)object;
        if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)this.this$1).logger.isTraceEnabled()) {
            MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)this.this$1).logger.trace("found PhoneService");
        }
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)this.this$1).registry.requestAPI(MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService == null ? (MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService = MessagingDependencyResolver.class$("de.vw.mib.asl.api.messages.services.available.MessageAvailableService")) : MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$available$MessageAvailableService, new MessagingDependencyResolver$1$1$1(this));
    }

    static /* synthetic */ MessagingDependencyResolver$1 access$100(MessagingDependencyResolver$1$1 messagingDependencyResolver$1$1) {
        return messagingDependencyResolver$1$1.this$1;
    }
}

