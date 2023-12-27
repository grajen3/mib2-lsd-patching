/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config.settings;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;

public interface SpeechSettingsListener {
    default public void onSpeechSettingsUpdated(SpeechSettings speechSettings) {
    }
}

