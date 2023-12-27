/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.processor;

import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;
import de.vw.mib.asl.internal.system.processor.SpeechContentProcessor;

class SpeechContentProcessor$1
implements DialogStateConsumer {
    private final /* synthetic */ SpeechContentProcessor this$0;

    SpeechContentProcessor$1(SpeechContentProcessor speechContentProcessor) {
        this.this$0 = speechContentProcessor;
    }

    @Override
    public void onDialogStateChanged(int n) {
        if (n == 8) {
            this.this$0.requestContent("NO_CONTENT");
        }
    }
}

