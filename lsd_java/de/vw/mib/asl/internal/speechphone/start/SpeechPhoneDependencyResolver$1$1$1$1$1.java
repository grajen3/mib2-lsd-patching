/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1$1$1;
import de.vw.mib.cio.CioDictionary;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechPhoneDependencyResolver$1$1$1$1$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechPhoneDependencyResolver$1$1$1$1 this$4;

    SpeechPhoneDependencyResolver$1$1$1$1$1(SpeechPhoneDependencyResolver$1$1$1$1 speechPhoneDependencyResolver$1$1$1$1) {
        this.this$4 = speechPhoneDependencyResolver$1$1$1$1;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).cioDictionary = (CioDictionary)SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).bundleContext.getService(serviceReference);
        if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).logger.isTraceEnabled()) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).logger.trace("found CioDictionary");
        }
        ServiceTracker serviceTracker = new ServiceTracker(SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).bundleContext, (SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDispatcher == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDispatcher = SpeechPhoneDependencyResolver.class$("de.vw.mib.cio.CioDispatcher")) : SpeechPhoneDependencyResolver.class$de$vw$mib$cio$CioDispatcher).getName(), (ServiceTrackerCustomizer)new SpeechPhoneDependencyResolver$1$1$1$1$1$1(this));
        serviceTracker.open();
        return SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)this.this$4)))).cioDictionary;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ SpeechPhoneDependencyResolver$1$1$1$1 access$400(SpeechPhoneDependencyResolver$1$1$1$1$1 speechPhoneDependencyResolver$1$1$1$1$1) {
        return speechPhoneDependencyResolver$1$1$1$1$1.this$4;
    }
}

