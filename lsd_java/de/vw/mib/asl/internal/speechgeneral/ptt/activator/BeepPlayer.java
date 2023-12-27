/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt.activator;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;

public class BeepPlayer {
    private final GenericEvents genericEvents;

    public BeepPlayer(GenericEvents genericEvents) {
        this.genericEvents = genericEvents;
    }

    public boolean playErrorBeep() {
        EventGeneric eventGeneric = this.genericEvents.getEventFactory().newEvent();
        eventGeneric.setReceiverEventId(638139648);
        eventGeneric.setInt(0, 0);
        return this.genericEvents.getServiceRegister().triggerObserver(eventGeneric.getReceiverEventId(), eventGeneric);
    }
}

