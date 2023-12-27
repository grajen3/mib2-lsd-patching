/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config;

import de.vw.mib.asl.api.speechengine.config.SpeechConfigurator;
import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettingsService;

public interface SpeechConfiguratorFactory {
    default public SpeechConfigurator createSpeechConfiguration(int n) {
    }

    default public SpeechEngineSettingsService getSpeechEngineSettingsService(int n) {
    }
}

