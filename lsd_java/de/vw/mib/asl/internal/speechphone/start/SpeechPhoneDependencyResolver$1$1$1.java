/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.phone.services.contact.ContactDetailsService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1$1;

class SpeechPhoneDependencyResolver$1$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ SpeechPhoneDependencyResolver$1$1 this$2;

    SpeechPhoneDependencyResolver$1$1$1(SpeechPhoneDependencyResolver$1$1 speechPhoneDependencyResolver$1$1) {
        this.this$2 = speechPhoneDependencyResolver$1$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)this.this$2)).contactDetailsService = (ContactDetailsService)object;
        if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)this.this$2)).logger.isTraceEnabled()) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)this.this$2)).logger.trace("found ContactDetailsService");
        }
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)SpeechPhoneDependencyResolver$1$1.access$100((SpeechPhoneDependencyResolver$1$1)this.this$2)).registry.requestAPI(SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$callstack$CallstackService == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$callstack$CallstackService = SpeechPhoneDependencyResolver.class$("de.vw.mib.asl.api.phone.services.callstack.CallstackService")) : SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$callstack$CallstackService, new SpeechPhoneDependencyResolver$1$1$1$1(this));
    }

    static /* synthetic */ SpeechPhoneDependencyResolver$1$1 access$200(SpeechPhoneDependencyResolver$1$1$1 speechPhoneDependencyResolver$1$1$1) {
        return speechPhoneDependencyResolver$1$1$1.this$2;
    }
}

