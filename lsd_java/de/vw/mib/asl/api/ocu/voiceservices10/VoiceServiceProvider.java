/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.voiceservices10;

import de.vw.mib.asl.api.ocu.voiceservices10.VoiceService;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceListener;

public interface VoiceServiceProvider {
    default public VoiceService getVoiceService() {
    }

    default public void registerVoiceServiceLister(VoiceServiceListener voiceServiceListener) {
    }

    default public void unregisterVoiceServiceLister(VoiceServiceListener voiceServiceListener) {
    }
}

