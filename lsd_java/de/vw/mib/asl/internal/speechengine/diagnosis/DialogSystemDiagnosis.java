/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.diagnosis;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisListener;

public interface DialogSystemDiagnosis {
    default public void addListener(DialogSystemDiagnosisListener dialogSystemDiagnosisListener) {
    }

    default public void removeListener(DialogSystemDiagnosisListener dialogSystemDiagnosisListener) {
    }
}

