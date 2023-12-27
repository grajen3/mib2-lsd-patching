/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.engine;

import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettings;
import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettingsService;
import de.vw.mib.asl.internal.speechengine.config.engine.SpeechEngineSettingsDefinition;

public class SpeechEngineSettingsManager
implements SpeechEngineSettingsService {
    private final SpeechEngineSettingsDefinition speechEngineSettings = new SpeechEngineSettingsDefinition();

    @Override
    public SpeechEngineSettings geSpeechEngineSettings() {
        return this.speechEngineSettings;
    }
}

