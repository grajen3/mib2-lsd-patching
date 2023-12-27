/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech;
import de.vw.mib.genericevents.EventGeneric;

public final class ASLSound {
    private ASLSound() {
    }

    public static void pinMute() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-100401088);
    }

    public static void setCurrentAudioComponent(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(-284950464, eventGeneric);
        ASLSpeech.performingBAPAction(0);
    }

    public static void activateRadioSource() {
        ASLSound.setCurrentAudioComponent(1);
    }

    public static void activateMediaSource() {
        ASLSound.setCurrentAudioComponent(2);
    }

    public static void activateTvSource() {
        ASLSound.setCurrentAudioComponent(5);
    }
}

