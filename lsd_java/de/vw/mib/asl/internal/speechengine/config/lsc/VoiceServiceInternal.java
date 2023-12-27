/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.lsc;

import de.vw.mib.asl.api.speechengine.config.voice.VoiceService;

public interface VoiceServiceInternal
extends VoiceService {
    default public void updateVoiceChangeActive() {
    }

    default public void updateAvailableVoices(String string) {
    }

    default public void changeToDefaultVoice() {
    }

    default public void doSilentMatchFromAvailableToCurrentVoice() {
    }
}

