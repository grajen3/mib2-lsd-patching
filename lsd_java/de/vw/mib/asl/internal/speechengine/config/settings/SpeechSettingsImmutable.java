/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.settings;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;

public final class SpeechSettingsImmutable
implements SpeechSettings {
    private final boolean isDisplayAvailableCommandsOnHeadunitActivated;
    private final boolean isDisplayAvailableCommandsOnICActivated;
    private final boolean isUseSpeechSessionStartToneActivate;
    private final boolean isUseSpeechSessionEndToneActivated;
    private final boolean isRecognizerReadyToneActivated;
    private final boolean isRecognizerEndToneActivated;

    public SpeechSettingsImmutable(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        this.isDisplayAvailableCommandsOnHeadunitActivated = bl;
        this.isDisplayAvailableCommandsOnICActivated = bl2;
        this.isUseSpeechSessionStartToneActivate = bl3;
        this.isUseSpeechSessionEndToneActivated = bl4;
        this.isRecognizerReadyToneActivated = bl5;
        this.isRecognizerEndToneActivated = bl6;
    }

    @Override
    public boolean isDisplayAvailableCommandsOnHeadunitActivated() {
        return this.isDisplayAvailableCommandsOnHeadunitActivated;
    }

    @Override
    public boolean isDisplayAvailableCommandsOnICActivated() {
        return this.isDisplayAvailableCommandsOnICActivated;
    }

    @Override
    public boolean isUseSpeechSessionStartToneActivated() {
        return this.isUseSpeechSessionStartToneActivate;
    }

    @Override
    public boolean isUseSpeechSessionEndToneActivated() {
        return this.isUseSpeechSessionEndToneActivated;
    }

    @Override
    public boolean isRecognizerReadyToneActivated() {
        return this.isRecognizerReadyToneActivated;
    }

    @Override
    public boolean isRecognizerEndToneActivated() {
        return this.isRecognizerEndToneActivated;
    }
}

