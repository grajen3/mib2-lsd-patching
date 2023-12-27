/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.diagnosis;

import de.vw.mib.asl.api.speechengine.diagnosis.SpeechDiagnosisListener;

public interface SpeechDiagnosisDataProvider {
    default public void addListener(SpeechDiagnosisListener speechDiagnosisListener) {
    }

    default public void removeListener(SpeechDiagnosisListener speechDiagnosisListener) {
    }

    default public void addListener(de.vw.mib.asl.api.speech.diagnosis.SpeechDiagnosisListener speechDiagnosisListener) {
    }

    default public void removeListener(de.vw.mib.asl.api.speech.diagnosis.SpeechDiagnosisListener speechDiagnosisListener) {
    }
}

