/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.internal.speechengine.config.lsc.SpeechTTSLACHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigCallback;

class SpeechTTSLACHandler$1
implements DialogSystemConfigCallback {
    private final /* synthetic */ SpeechTTSLACHandler this$0;

    SpeechTTSLACHandler$1(SpeechTTSLACHandler speechTTSLACHandler) {
        this.this$0 = speechTTSLACHandler;
    }

    @Override
    public void setLanguageCallback(int n, boolean bl) {
        this.this$0.isVoiceChangeActive = false;
        this.this$0.voiceServiceInternal.updateVoiceChangeActive();
    }
}

