/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.autostore;

import de.vw.mib.asl.api.radio.ASLRadioTargetIds;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public class ApiAutostorePresets {
    public static void startInitialAutostore() {
        try {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
            eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE);
            eventGeneric.setReceiverEventId(-838598592);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void stopInitialAutostore() {
        try {
            EventGeneric eventGeneric = ServiceManager.eventMain.getEventFactory().newEvent();
            eventGeneric.setReceiverTargetId(ASLRadioTargetIds.ASL_RADIO_HSMTARGET_AUTOSTORE);
            eventGeneric.setReceiverEventId(-704380864);
            ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

