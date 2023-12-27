/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosisImpl;
import de.vw.mib.asl.internal.speechengine.dialogsystem.appstate.ApplicationStateTracker;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.ConfigController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr.AsrController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.grammar.GrammarController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.controller.tts.TtsController;
import de.vw.mib.asl.internal.speechengine.dialogsystem.start.DialogSystemParameter;

public interface DialogSystemInitializer {
    default public void setParameter(DialogSystemParameter dialogSystemParameter) {
    }

    default public void setGrammarController(GrammarController grammarController) {
    }

    default public void setAsrController(AsrController asrController) {
    }

    default public void setAsrConfig(RecognizerConfig recognizerConfig) {
    }

    default public void setTtsController(TtsController ttsController) {
    }

    default public void setTtsConfig(TTSConfig tTSConfig) {
    }

    default public void setDiagnosis(DialogSystemDiagnosisImpl dialogSystemDiagnosisImpl) {
    }

    default public void setApplicationStateTracker(ApplicationStateTracker applicationStateTracker) {
    }

    default public ConfigController getConfiRegistry() {
    }
}

