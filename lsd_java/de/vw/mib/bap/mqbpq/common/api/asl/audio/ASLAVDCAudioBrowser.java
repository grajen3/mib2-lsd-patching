/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.api.asl.audio;

import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public final class ASLAVDCAudioBrowser {
    private ASLAVDCAudioBrowser() {
    }

    public static void setRepeatMode(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1056964672, eventGeneric);
    }

    public static void setMixMode(int n) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setInt(0, n);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(989855808, eventGeneric);
    }

    public static void setPlayMoreLikeThisState(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.serviceManager.genericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.serviceManager.genericEvents.getServiceRegister().triggerObserver(1023410240, eventGeneric);
    }
}

