/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.config.voice;

import de.vw.mib.asl.api.speechengine.config.voice.VoiceServiceListener;

public class VoiceServiceListenerEmpty
implements VoiceServiceListener {
    @Override
    public void availableVoicesChanged(int[] nArray) {
    }

    @Override
    public void voiceChanged(int n) {
    }

    @Override
    public void isVoiceChangeActive(boolean bl) {
    }
}

