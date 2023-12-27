/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config.settings;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;

public interface SpeechSettingsService {
    default public void toggleDisplayAvailableCommandsOnHeadunitActivated() {
    }

    default public void toggleDisplayAvailableCommandsOnICActivated() {
    }

    default public void toggleUseSpeechSessionStartToneActivated() {
    }

    default public void toggleUseSpeechSessionEndToneActivated() {
    }

    default public void toggleRecognizerReadyToneActivated() {
    }

    default public void toggleRecognizerEndToneActivated() {
    }

    default public SpeechSettings getSpeechSettings() {
    }

    default public void register(SpeechSettingsListener speechSettingsListener) {
    }

    default public void unregister(SpeechSettingsListener speechSettingsListener) {
    }
}

