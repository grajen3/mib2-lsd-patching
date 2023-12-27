/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config.voice;

import de.vw.mib.asl.api.speechengine.config.voice.VoiceServiceListener;

public interface VoiceService {
    default public int[] getAvailableVoices() {
    }

    default public int getVoice() {
    }

    default public void setVoice(int n) {
    }

    default public boolean isVoiceChangeActive() {
    }

    default public void addListener(VoiceServiceListener voiceServiceListener) {
    }

    default public void removeListener(VoiceServiceListener voiceServiceListener) {
    }
}

