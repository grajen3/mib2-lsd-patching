/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateConsumer;

public class DialogStateListenerImpl
implements DialogStateConsumer {
    private final SpeechDiagnosisListener listener;

    public DialogStateListenerImpl(SpeechDiagnosisListener speechDiagnosisListener) {
        this.listener = speechDiagnosisListener;
    }

    @Override
    public void onDialogStateChanged(int n) {
        this.listener.changedDialogState(n);
    }
}

