/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speech.diagnosis;

import de.vw.mib.asl.api.speech.diagnosis.SpeechDiagnosisListener;

public interface SpeechDiagnosisDataProvider {
    default public void addListener(SpeechDiagnosisListener speechDiagnosisListener) {
    }

    default public void removeListener(SpeechDiagnosisListener speechDiagnosisListener) {
    }
}

