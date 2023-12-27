/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.phone.services.callstack.CallstackService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1$1;
import de.vw.mib.configuration.ConfigurationManager;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechPhoneDependencyResolver$1$1$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ SpeechPhoneDependencyResolver$1$1$1 this$3;

    SpeechPhoneDependencyResolver$1$1$1$1(SpeechPhoneDependencyResolver$1$1$1 speechPhoneDependencyResolver$1$1$1) {
        this.this$3 = speechPhoneDependencyResolver$1$1$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ServiceReference serviceReference;
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).callstackService = (CallstackService)object;
        if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).logger.isTraceEnabled()) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).logger.trace("found CallstackService");
        }
        if ((serviceReference = SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).bundleContext.getServiceReference((SpeechPhoneDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager = SpeechPhoneDependencyResolver.class$("de.vw.mib.configuration.ConfigurationManager")) : SpeechPhoneDependencyResolver.class$de$vw$mib$configuration$ConfigurationManager).getName())) != null) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).configurationManager = (ConfigurationManager)SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).bundleContext.getService(serviceReference);
            if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).logger.isTraceEnabled()) {
                SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).logger.trace("found ConfigurationManager");
            }
            ServiceTracker serviceTracker = new ServiceTracker(SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)this.this$3))).bundleContext, (SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDictionary == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDictionary = SpeechPhoneDependencyResolver.class$("de.vw.mib.cio.CioDictionary")) : SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDictionary).getName(), (ServiceTrackerCustomizer)new SpeechPhoneDependencyResolver$1$1$1$1$1(this));
            serviceTracker.open();
        }
    }

    static /* synthetic */ SpeechPhoneDependencyResolver$1$1$1 access$300(SpeechPhoneDependencyResolver$1$1$1$1 speechPhoneDependencyResolver$1$1$1$1) {
        return speechPhoneDependencyResolver$1$1$1$1.this$3;
    }
}

