/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.messages.services.detail.MessageDetailService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.MessagingDependencyResolver$1$1$1$1$1$1;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class MessagingDependencyResolver$1$1$1$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ MessagingDependencyResolver$1$1$1$1 this$4;

    MessagingDependencyResolver$1$1$1$1$1(MessagingDependencyResolver$1$1$1$1 messagingDependencyResolver$1$1$1$1) {
        this.this$4 = messagingDependencyResolver$1$1$1$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ServiceReference serviceReference;
        MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).messageDetailService = (MessageDetailService)object;
        if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.isTraceEnabled()) {
            MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.trace("found MessageDetailService");
        }
        if ((serviceReference = MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).bundleContext.getServiceReference((MessagingDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager == null ? (MessagingDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager = MessagingDependencyResolver.class$("de.vw.mib.configuration.ConfigurationManager")) : MessagingDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager).getName())) != null) {
            ServiceReference serviceReference2;
            MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).configurationManager = (ConfigurationManager)MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).bundleContext.getService(serviceReference);
            if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.isTraceEnabled()) {
                MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.trace("found ConfigurationManager");
            }
            if ((serviceReference2 = MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).bundleContext.getServiceReference((MessagingDependencyResolver.class$de$vw$mib$genericevents$ThreadSwitchingTarget == null ? (MessagingDependencyResolver.class$de$vw$mib$genericevents$ThreadSwitchingTarget = MessagingDependencyResolver.class$("de.vw.mib.genericevents.ThreadSwitchingTarget")) : MessagingDependencyResolver.class$de$vw$mib$genericevents$ThreadSwitchingTarget).getName())) != null) {
                MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).threadSwitchingTarget = (ThreadSwitchingTarget)MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).bundleContext.getService(serviceReference2);
                if (MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.isTraceEnabled()) {
                    MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).logger.trace("found ThreadSwitchingTarget");
                }
                ServiceTracker serviceTracker = new ServiceTracker(MessagingDependencyResolver$1.access$000((MessagingDependencyResolver$1)MessagingDependencyResolver$1$1.access$100((MessagingDependencyResolver$1$1)MessagingDependencyResolver$1$1$1.access$200((MessagingDependencyResolver$1$1$1)MessagingDependencyResolver$1$1$1$1.access$300((MessagingDependencyResolver$1$1$1$1)this.this$4)))).bundleContext, (MessagingDependencyResolver.class$de$vw$mib$asl$ASLTimeAndDateServiceTarget == null ? (MessagingDependencyResolver.class$de$vw$mib$asl$ASLTimeAndDateServiceTarget = MessagingDependencyResolver.class$("de.vw.mib.asl.ASLTimeAndDateServiceTarget")) : MessagingDependencyResolver.class$de$vw$mib$asl$ASLTimeAndDateServiceTarget).getName(), (ServiceTrackerCustomizer)new MessagingDependencyResolver$1$1$1$1$1$1(this));
                serviceTracker.open();
            }
        }
    }

    static /* synthetic */ MessagingDependencyResolver$1$1$1$1 access$400(MessagingDependencyResolver$1$1$1$1$1 messagingDependencyResolver$1$1$1$1$1) {
        return messagingDependencyResolver$1$1$1$1$1.this$4;
    }
}

