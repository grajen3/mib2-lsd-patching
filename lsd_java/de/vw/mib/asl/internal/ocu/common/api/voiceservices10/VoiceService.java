/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.voiceservices10;

import de.vw.mib.asl.api.ocu.voiceservices10.VoiceServiceListener;
import de.vw.mib.asl.internal.ocu.common.api.voiceservices10.VoiceService$IteratorProvider;
import de.vw.mib.asl.internal.ocu.common.api.voiceservices10.data.VoiceSupportedServices;
import de.vw.mib.asl.internal.ocu.ecall.api.voice.SupportedServicesListener;
import java.util.Iterator;

class VoiceService
implements de.vw.mib.asl.api.ocu.voiceservices10.VoiceService,
SupportedServicesListener {
    private final VoiceService$IteratorProvider listenerIteratorProvider;
    private de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices voiceSupportedServices;

    VoiceService(VoiceService$IteratorProvider voiceService$IteratorProvider) {
        this.listenerIteratorProvider = voiceService$IteratorProvider;
    }

    private Iterator getListenerIterator() {
        return this.listenerIteratorProvider.getIterator();
    }

    @Override
    public de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices getVoiceSupportedServices() {
        if (this.voiceSupportedServices == null) {
            this.voiceSupportedServices = new VoiceSupportedServices(false, false, false);
        }
        return this.voiceSupportedServices;
    }

    private void setVoiceSupportedServices(de.vw.mib.asl.api.ocu.voiceservices10.data.VoiceSupportedServices voiceSupportedServices) {
        if (!this.getVoiceSupportedServices().equals(voiceSupportedServices)) {
            this.voiceSupportedServices = voiceSupportedServices;
            Iterator iterator = this.getListenerIterator();
            while (iterator.hasNext()) {
                VoiceServiceListener voiceServiceListener = (VoiceServiceListener)iterator.next();
                voiceServiceListener.updateVoiceSupportedServices(this, this.getVoiceSupportedServices());
            }
        }
    }

    @Override
    public void updateSupportedServices(boolean bl, boolean bl2, boolean bl3) {
        this.setVoiceSupportedServices(new VoiceSupportedServices(bl, bl2, bl3));
    }
}

