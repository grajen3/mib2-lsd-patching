/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSpeech;
import de.vw.mib.genericevents.EventGeneric;

public final class ASLAVDCAudio {
    private ASLAVDCAudio() {
    }

    public static void toggleSubfolderInclusionState() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(520093760);
    }

    public static void startFastForward() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(385876032);
        ASLSpeech.performingBAPAction(2);
    }

    public static void startFastRewind() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(402653248);
        ASLSpeech.performingBAPAction(2);
    }

    public static void stopFastForward() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(419430464);
        ASLSpeech.performingBAPAction(2);
    }

    public static void stopFastRewind() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(436207680);
        ASLSpeech.performingBAPAction(2);
    }

    public static void activateAudioSourceByID(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(0x2000040, eventGeneric);
        ASLSpeech.performingBAPAction(0);
    }

    public static void skipForwardWithCounter(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(705298496, eventGeneric);
        ASLSpeech.performingBAPAction(2);
    }

    public static void skipBackwardWithCounter(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setBoolean(0, true);
        eventGeneric.setInt(1, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(688521280, eventGeneric);
        ASLSpeech.performingBAPAction(2);
    }

    public static void activateNextDVDChapter() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1660944448);
        ASLSpeech.performingBAPAction(2);
    }

    public static void activatePreviousDVDChapter() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1694498880);
        ASLSpeech.performingBAPAction(2);
    }

    public static void activateSelectedDVDMenuItem() {
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1728053312);
        ASLSpeech.performingBAPAction(2);
    }
}

