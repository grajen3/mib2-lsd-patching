/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis;

import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;

class DialogManagerDiagnosisImpl$2
implements DialogManagerStateListener {
    private final /* synthetic */ DialogManagerDiagnosisImpl this$0;

    DialogManagerDiagnosisImpl$2(DialogManagerDiagnosisImpl dialogManagerDiagnosisImpl) {
        this.this$0 = dialogManagerDiagnosisImpl;
    }

    @Override
    public void onDialogManagerStateChanged(int n, int n2) {
        this.notifyDialogManagerStateChanged(n2);
    }

    @Override
    public void setCurrentDialogManagerState(int n) {
        this.notifyDialogManagerStateChanged(n);
    }

    private void notifyDialogManagerStateChanged(int n) {
        this.this$0.dialogManagerState = n;
        for (int i2 = 0; i2 < this.this$0.dialogManagerDiagnosisListeners.size(); ++i2) {
            DialogManagerDiagnosisListener dialogManagerDiagnosisListener = (DialogManagerDiagnosisListener)this.this$0.dialogManagerDiagnosisListeners.get(i2);
            dialogManagerDiagnosisListener.changedDialogManagerState(n);
        }
    }
}

