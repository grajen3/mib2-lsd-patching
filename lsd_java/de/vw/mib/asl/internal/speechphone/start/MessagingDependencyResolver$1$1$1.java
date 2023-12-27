/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.messages.services.available.MessageAvailableService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1$1;

class MessagingDependencyResolver$1$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ MessagingDependencyResolver$1$1 this$2;

    MessagingDependencyResolver$1$1$1(MessagingDependencyResolver$1$1 messagingDependencyResolver$1$1) {
        this.this$2 = messagingDependencyResolver$1$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)this.this$2)).messageAvailableService = (MessageAvailableService)object;
        if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)this.this$2)).logger.isTraceEnabled()) {
            MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)this.this$2)).logger.trace("found MessageAvailableService");
        }
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)this.this$2)).registry.requestAPI(MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService == null ? (MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService = MessagingDependencyResolver.class$("de.vw.mib.asl.api.messages.services.status.MessagesStatusService")) : MessagingDependencyResolver.class$de$vw$mib$asl$api$messages$services$status$MessagesStatusService, new MessagingDependencyResolver$1$1$1$1(this));
    }

    static /* synthetic */ MessagingDependencyResolver$1$1 access$200(MessagingDependencyResolver$1$1$1 messagingDependencyResolver$1$1$1) {
        return messagingDependencyResolver$1$1$1.this$2;
    }
}

