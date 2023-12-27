/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.speechengine.SpeechEngineMaster;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class SpeechPhoneDependencyResolver$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ SpeechPhoneDependencyResolver this$0;

    SpeechPhoneDependencyResolver$1(SpeechPhoneDependencyResolver speechPhoneDependencyResolver) {
        this.this$0 = speechPhoneDependencyResolver;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        this.this$0.speechEngineMaster = (SpeechEngineMaster)this.this$0.bundleContext.getService(serviceReference);
        if (this.this$0.logger.isTraceEnabled()) {
            this.this$0.logger.trace("found SpeechEngine");
        }
        this.this$0.resultHandler = this.this$0.speechEngineMaster.getResultHandler(4);
        this.this$0.registry.requestAPI(SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService = SpeechPhoneDependencyResolver.class$("de.vw.mib.asl.api.phone.PhoneService")) : SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$PhoneService, new SpeechPhoneDependencyResolver$1$1(this));
        return this.this$0.speechEngineMaster;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ SpeechPhoneDependencyResolver access$000(SpeechPhoneDependencyResolver$1 speechPhoneDependencyResolver$1) {
        return speechPhoneDependencyResolver$1.this$0;
    }
}

