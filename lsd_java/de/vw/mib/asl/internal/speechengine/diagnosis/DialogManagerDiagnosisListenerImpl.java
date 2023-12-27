/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;

public class DialogManagerDiagnosisListenerImpl
implements DialogManagerDiagnosisListener {
    private final SpeechDiagnosisListener listener;

    public DialogManagerDiagnosisListenerImpl(SpeechDiagnosisListener speechDiagnosisListener) {
        this.listener = speechDiagnosisListener;
    }

    @Override
    public void changedDialogManagerState(int n) {
        this.listener.changedDialogManagerState(n);
    }

    @Override
    public void changedBackStack(String string) {
        this.listener.changedBackStack(string);
    }
}

