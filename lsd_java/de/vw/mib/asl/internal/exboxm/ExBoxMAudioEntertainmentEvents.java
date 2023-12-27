/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm;

import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;

class ExBoxMAudioEntertainmentEvents {
    private final EventFactory eventFactory;

    ExBoxMAudioEntertainmentEvents(EventFactory eventFactory) {
        this.eventFactory = eventFactory;
    }

    EventGeneric createSoundSetConnection(int n, boolean bl, boolean bl2, int n2) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(34159872);
        eventGeneric.setInt(0, n);
        eventGeneric.setBoolean(1, bl);
        eventGeneric.setBoolean(2, bl2);
        eventGeneric.setSenderEventId(n2);
        return eventGeneric;
    }

    EventGeneric createEntActivated() {
        return this.eventFactory.newEvent(-1067707136);
    }

    EventGeneric createEntDeactivated() {
        return this.eventFactory.newEvent(-1050929920);
    }

    EventGeneric createEntRequest(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(-866380544);
        eventGeneric.setInt(0, n);
        return eventGeneric;
    }

    EventGeneric createEntWeakRequest(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent(-732162816);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, 4);
        return eventGeneric;
    }

    EventGeneric createEntRegisterTarget() {
        EventGeneric eventGeneric = this.eventFactory.newEvent(-899934976);
        eventGeneric.setInt(0, 4);
        eventGeneric.setInt(1, -1);
        eventGeneric.setBoolean(2, true);
        return eventGeneric;
    }
}

