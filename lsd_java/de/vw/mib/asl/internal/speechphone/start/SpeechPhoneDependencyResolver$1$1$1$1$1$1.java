/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1$1;
import de.vw.mib.cio.CioDispatcher;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechPhoneDependencyResolver$1$1$1$1$1$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechPhoneDependencyResolver$1$1$1$1$1 this$5;

    SpeechPhoneDependencyResolver$1$1$1$1$1$1(SpeechPhoneDependencyResolver$1$1$1$1$1 speechPhoneDependencyResolver$1$1$1$1$1) {
        this.this$5 = speechPhoneDependencyResolver$1$1$1$1$1;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1$1.access$400((SpeechPhoneDependencyResolver$1$1$1$1$1)this.this$5))))).cioDispatcher = (CioDispatcher)SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1$1.access$400((SpeechPhoneDependencyResolver$1$1$1$1$1)this.this$5))))).bundleContext.getService(serviceReference);
        if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1$1.access$400((SpeechPhoneDependencyResolver$1$1$1$1$1)this.this$5))))).logger.isTraceEnabled()) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1$1.access$400((SpeechPhoneDependencyResolver$1$1$1$1$1)this.this$5))))).logger.trace("found CioDispatcher");
        }
        SpeechPhoneDependencyResolver$1.access$000(SpeechPhoneDependencyResolver$1$1.access$100(SpeechPhoneDependencyResolver$1$1$1.access$200(SpeechPhoneDependencyResolver$1$1$1$1.access$300(SpeechPhoneDependencyResolver$1$1$1$1$1.access$400(this.this$5))))).activate();
        return SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)SpeechPhoneDependencyResolver$1$1$1.access$200((SpeechPhoneDependencyResolver$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1.access$300((SpeechPhoneDependencyResolver$1$1$1$1)SpeechPhoneDependencyResolver$1$1$1$1$1.access$400((SpeechPhoneDependencyResolver$1$1$1$1$1)this.this$5))))).cioDispatcher;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

