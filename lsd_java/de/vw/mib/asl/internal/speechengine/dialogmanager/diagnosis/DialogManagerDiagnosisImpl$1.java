/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis;

import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStack;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.back.BackStackListener;

class DialogManagerDiagnosisImpl$1
implements BackStackListener {
    private final /* synthetic */ DialogManagerDiagnosisImpl this$0;

    DialogManagerDiagnosisImpl$1(DialogManagerDiagnosisImpl dialogManagerDiagnosisImpl) {
        this.this$0 = dialogManagerDiagnosisImpl;
    }

    @Override
    public void onBackStackChanged(BackStack backStack) {
        String string = backStack.toString();
        if (DialogManagerDiagnosisImpl.logger.isTraceEnabled()) {
            DialogManagerDiagnosisImpl.logger.trace(string);
        }
        for (int i2 = 0; i2 < this.this$0.dialogManagerDiagnosisListeners.size(); ++i2) {
            DialogManagerDiagnosisListener dialogManagerDiagnosisListener = (DialogManagerDiagnosisListener)this.this$0.dialogManagerDiagnosisListeners.get(i2);
            dialogManagerDiagnosisListener.changedBackStack(string);
        }
    }
}

