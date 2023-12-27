/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.settings;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsImmutable;

public final class SpeechSettingsDefaultProvider {
    public static SpeechSettings getDefaultSettings() {
        return new SpeechSettingsImmutable(SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnHeadunitActivated(), SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnICActivated(), SpeechSettingsDefaultProvider.isUseSpeechSessionStartToneActivated(), SpeechSettingsDefaultProvider.isUseSpeechSessionEndToneActivated(), SpeechSettingsDefaultProvider.isRecognizerReadyToneActivated(), SpeechSettingsDefaultProvider.isRecognizerEndToneActivated());
    }

    public static boolean isDisplayAvailableCommandsOnHeadunitActivated() {
        return true;
    }

    public static boolean isDisplayAvailableCommandsOnICActivated() {
        return true;
    }

    public static boolean isUseSpeechSessionStartToneActivated() {
        return true;
    }

    public static boolean isUseSpeechSessionEndToneActivated() {
        return true;
    }

    public static boolean isRecognizerReadyToneActivated() {
        return true;
    }

    public static boolean isRecognizerEndToneActivated() {
        return true;
    }

    public static int getCurrentVoiceType() {
        return 0;
    }
}

