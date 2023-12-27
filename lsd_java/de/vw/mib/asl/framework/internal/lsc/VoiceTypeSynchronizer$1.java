/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.api.speechengine.config.voice.VoiceServiceListenerEmpty;
import de.vw.mib.asl.framework.internal.lsc.VoiceTypeSynchronizer;

class VoiceTypeSynchronizer$1
extends VoiceServiceListenerEmpty {
    private final /* synthetic */ VoiceTypeSynchronizer this$0;

    VoiceTypeSynchronizer$1(VoiceTypeSynchronizer voiceTypeSynchronizer) {
        this.this$0 = voiceTypeSynchronizer;
    }

    @Override
    public void availableVoicesChanged(int[] nArray) {
        this.this$0.updateVoiceAvailability(nArray);
    }

    @Override
    public void voiceChanged(int n) {
        this.this$0.updateCurrentVoice(n);
    }
}

