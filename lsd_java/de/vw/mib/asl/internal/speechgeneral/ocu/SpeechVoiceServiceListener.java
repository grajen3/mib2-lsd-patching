/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ocu;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.ocu.voiceservices10.ECallServiceListenerAdapter;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceService;
import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceProvider;
import de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices;

public class SpeechVoiceServiceListener
extends ECallServiceListenerAdapter {
    private final ASLPropertyManager aslPropertyManager;
    private VoiceServiceProvider voiceServiceProvider;

    public SpeechVoiceServiceListener(ASLPropertyManager aSLPropertyManager, VoiceServiceProvider voiceServiceProvider) {
        this.aslPropertyManager = aSLPropertyManager;
        this.voiceServiceProvider = voiceServiceProvider;
    }

    public void startTracking() {
        VoiceService voiceService = this.voiceServiceProvider.getVoiceService();
        if (voiceService.getVoiceSupportedServices().isInfoCallAvailable()) {
            this.voiceServiceProvider = null;
            this.onOcuInfoCallAvailable();
        } else {
            this.voiceServiceProvider.registerVoiceServiceLister(this);
        }
    }

    private void onOcuInfoCallAvailable() {
        if (this.voiceServiceProvider != null) {
            this.voiceServiceProvider.unregisterVoiceServiceLister(this);
        }
        this.aslPropertyManager.valueChangedInteger(352006144, 1);
    }

    @Override
    public void updateVoiceSupportedServices(VoiceService voiceService, VoiceSupportedServices voiceSupportedServices) {
        if (voiceSupportedServices != null && voiceSupportedServices.isServiceCallAvailable()) {
            this.onOcuInfoCallAvailable();
        }
    }
}

