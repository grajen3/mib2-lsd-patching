/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.start;

import de.vw.mib.asl.api.phone.PhoneService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1;
import de.vw.mib.asl.internal.speechphone.start.SpeechPhoneDependencyResolver$1$1$1;

class SpeechPhoneDependencyResolver$1$1
implements ASLComponentAPICallback {
    private final /* synthetic */ SpeechPhoneDependencyResolver$1 this$1;

    SpeechPhoneDependencyResolver$1$1(SpeechPhoneDependencyResolver$1 speechPhoneDependencyResolver$1) {
        this.this$1 = speechPhoneDependencyResolver$1;
    }

    @Override
    public void registered(Class clazz, Object object) {
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)this.this$1).phoneService = (PhoneService)object;
        if (SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)this.this$1).logger.isTraceEnabled()) {
            SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)this.this$1).logger.trace("found PhoneService");
        }
        SpeechPhoneDependencyResolver$1.access$000((SpeechPhoneDependencyResolver$1)this.this$1).registry.requestAPI(SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService == null ? (SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService = SpeechPhoneDependencyResolver.class$("de.vw.mib.asl.api.phone.services.contact.ContactDetailsService")) : SpeechPhoneDependencyResolver.class$de$vw$mib$asl$api$phone$services$contact$ContactDetailsService, new SpeechPhoneDependencyResolver$1$1$1(this));
    }

    static /* synthetic */ SpeechPhoneDependencyResolver$1 access$100(SpeechPhoneDependencyResolver$1$1 speechPhoneDependencyResolver$1$1) {
        return speechPhoneDependencyResolver$1$1.this$1;
    }
}

