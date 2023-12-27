/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config.voice;

public interface VoiceServiceListener {
    default public void availableVoicesChanged(int[] nArray) {
    }

    default public void voiceChanged(int n) {
    }

    default public void isVoiceChangeActive(boolean bl) {
    }
}

