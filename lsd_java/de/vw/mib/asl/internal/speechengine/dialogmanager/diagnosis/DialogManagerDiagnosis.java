/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis;

import de.vw.mib.asl.internal.speechengine.dialogmanager.diagnosis.DialogManagerDiagnosisListener;

public interface DialogManagerDiagnosis {
    default public void registerDialogManagerDiagnosisListener(DialogManagerDiagnosisListener dialogManagerDiagnosisListener) {
    }

    default public void unregisterDialogManagerDiagnosisListener(DialogManagerDiagnosisListener dialogManagerDiagnosisListener) {
    }
}

