/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.config;

import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;

public interface DialogSystemConfigListener {
    default public void onNewTTSAvailabe(TTSConfig tTSConfig) {
    }

    default public void onTTSRemoved(TTSConfig tTSConfig) {
    }

    default public void onNewRecognizerAvailabe(RecognizerConfig recognizerConfig) {
    }

    default public void onRecognizerRemoved(RecognizerConfig recognizerConfig) {
    }
}

