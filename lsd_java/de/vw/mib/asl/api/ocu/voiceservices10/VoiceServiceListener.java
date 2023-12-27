/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.voiceservices10;

import de.vw.mib.asl.api.ocu.voiceservices10.VoiceService;
import de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices;

public interface VoiceServiceListener {
    default public void updateVoiceSupportedServices(VoiceService voiceService, VoiceSupportedServices voiceSupportedServices) {
    }
}

