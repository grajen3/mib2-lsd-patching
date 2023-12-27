/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.speech;

import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant;
import de.vw.mib.asl.internal.exboxm.state.ExboxSpeechListener;

class ExboxSpeechApplicant$2
implements ExboxSpeechListener {
    private final /* synthetic */ ExboxSpeechApplicant this$0;

    ExboxSpeechApplicant$2(ExboxSpeechApplicant exboxSpeechApplicant) {
        this.this$0 = exboxSpeechApplicant;
    }

    @Override
    public void onSpeechStateChange(boolean bl) {
        if (!bl) {
            this.this$0.deactivateSpeech();
        }
    }
}

