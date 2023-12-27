/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.start;

import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;
import de.vw.mib.asl.internal.speechengine.diagnosis.DialogSystemDiagnosis;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;

public interface DialogSystemCallback {
    default public void onPromptSystemReady(PromptSystem promptSystem) {
    }

    default public void onSpeechDialogSystemReady(SpeechDialogSystem speechDialogSystem) {
    }

    default public void onDialogDystemDiagnosisReady(DialogSystemDiagnosis dialogSystemDiagnosis) {
    }

    default public void onDialogSystemConfigReady(DialogSystemConfigRegistry dialogSystemConfigRegistry) {
    }

    default public void onAudioAccessorReady(AudioAccessor audioAccessor) {
    }

    default public void onVoiceDestinationEntryReady(VoiceDestinationEntry voiceDestinationEntry) {
    }
}

