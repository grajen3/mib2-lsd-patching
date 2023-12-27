/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.config.voice.VoiceService;

public interface SpeechConfigurator {
    default public VoiceService getVoiceService() {
    }

    default public SpeechSettingsService getSpeechSettingsManager() {
    }
}

