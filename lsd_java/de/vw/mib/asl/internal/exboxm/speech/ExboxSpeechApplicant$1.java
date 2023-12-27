/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.speech;

import de.vw.mib.asl.internal.exboxm.ExBoxMAudio;
import de.vw.mib.asl.internal.exboxm.speech.ExboxSpeechApplicant;
import de.vw.mib.asl.internal.exboxm.speech.SpeechConnectionStatusListener;

class ExboxSpeechApplicant$1
implements SpeechConnectionStatusListener {
    private final /* synthetic */ ExboxSpeechApplicant this$0;

    ExboxSpeechApplicant$1(ExboxSpeechApplicant exboxSpeechApplicant) {
        this.this$0 = exboxSpeechApplicant;
    }

    @Override
    public void onSpeechConnectionStatusChange(int n) {
        this.this$0.exboxLogger.trace(new StringBuffer().append("onSpeechConnectionStatusChange called with connection status ").append(n).append(" (").append(ExBoxMAudio.getAudioConnectionStateString(n)).append(").").toString());
        this.this$0.handleSpeechConnectionStatusChange(n);
    }
}

