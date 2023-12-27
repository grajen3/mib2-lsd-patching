/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.manager;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public final class RadioManagerApi {
    private RadioManagerApi() {
    }

    public static void notifyAutostoreFinished(int n) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-2071527168);
        eventGeneric.setInt(0, n);
        RadioManagerApi.send(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, eventGeneric);
    }

    public static void notifyAutostoreStarted() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setReceiverEventId(-2088304384);
        RadioManagerApi.send(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE, eventGeneric);
    }

    private static void send(int n, EventGeneric eventGeneric) {
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_MANAGER);
        ServiceManager.eventMain.getEventDispatcher().send(eventGeneric);
    }
}

