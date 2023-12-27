/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.engine;

import de.vw.mib.asl.internal.speechengine.config.SpeechEngineSettings;

public final class SpeechEngineSettingsDefinition
implements SpeechEngineSettings {
    protected static final int PAUSE_TIMEOUT;
    protected static final int FIRST_RECOGNITION_TIMER_DELAY;
    protected static final int NEXT_RECOGNITION_TIMER_DELAY;

    @Override
    public int getPauseTimeout() {
        return 549388800;
    }

    @Override
    public int getFirstPleaseWaitTimeout() {
        return 5000;
    }

    @Override
    public int getNextPleaseWaitTimeout() {
        return 8000;
    }
}

