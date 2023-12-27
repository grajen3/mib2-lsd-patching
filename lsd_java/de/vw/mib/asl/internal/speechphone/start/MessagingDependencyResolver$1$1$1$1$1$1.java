/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.ASLTimeAndDateServiceTarget;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1$1$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MessagingDependencyResolver$1$1$1$1$1$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ MessagingDependencyResolver$1$1$1$1$1 this$5;

    MessagingDependencyResolver$1$1$1$1$1$1(MessagingDependencyResolver$1$1$1$1$1 messagingDependencyResolver$1$1$1$1$1) {
        this.this$5 = messagingDependencyResolver$1$1$1$1$1;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)MessagingDependencyResolver$1$1$1$1$1.access$400((MessagingDependencyResolver$1$1$1$1$1)this.this$5))))).aslTimeAndDateServiceTarget = (ASLTimeAndDateServiceTarget)MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)MessagingDependencyResolver$1$1$1$1$1.access$400((MessagingDependencyResolver$1$1$1$1$1)this.this$5))))).bundleContext.getService(serviceReference);
        if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)MessagingDependencyResolver$1$1$1$1$1.access$400((MessagingDependencyResolver$1$1$1$1$1)this.this$5))))).logger.isTraceEnabled()) {
            MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)MessagingDependencyResolver$1$1$1$1$1.access$400((MessagingDependencyResolver$1$1$1$1$1)this.this$5))))).logger.trace("found ASLTimeAndDateService");
        }
        MessagingDependencyResolver$1.access$000(MessagingDependencyResolver$1$1.access$100(MessagingDependencyResolver$1$1$1.access$200(MessagingDependencyResolver$1$1$1$1.access$300(MessagingDependencyResolver$1$1$1$1$1.access$400(this.this$5))))).activate();
        return MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)MessagingDependencyResolver$1$1$1$1$1.access$400((MessagingDependencyResolver$1$1$1$1$1)this.this$5))))).aslTimeAndDateServiceTarget;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

