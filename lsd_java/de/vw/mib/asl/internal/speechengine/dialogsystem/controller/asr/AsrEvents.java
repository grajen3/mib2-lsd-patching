/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller.asr;

import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public final class AsrEvents {
    private static final int[] OBSERVER = new int[0];
    private static final int[] SERVICES = new int[0];

    private AsrEvents() {
    }

    static void register(AbstractTarget abstractTarget) {
        abstractTarget.registerServices(SERVICES, true);
        abstractTarget.addObservers(SERVICES);
        abstractTarget.addObservers(OBSERVER);
    }

    static void unregister(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVER);
        abstractTarget.removeObservers(SERVICES);
        abstractTarget.unregisterServices(SERVICES);
    }

    static String getEventName(EventGeneric eventGeneric) {
        String string = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 106: {
                string = "IdEvent.POWER_ON";
                break;
            }
            case 107: {
                string = "IdEvent.POWER_OFF";
                break;
            }
            case 8: {
                string = "NOTIFY_TARGET_REGISTERED";
                break;
            }
            default: {
                string = new StringBuffer().append("UNKNOWN-").append(eventGeneric.getReceiverEventId()).toString();
            }
        }
        return new StringBuffer().append(string).append(":").append(eventGeneric.getParamString()).toString();
    }
}

