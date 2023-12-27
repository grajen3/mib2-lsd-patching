/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.internal;

import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import java.io.DataInputStream;

public class SimpleEventFactory
implements EventFactory {
    @Override
    public void freeEvent(EventGeneric eventGeneric) {
    }

    @Override
    public EventGeneric newEvent() {
        return this.createEventGeneric();
    }

    @Override
    public EventGeneric newEvent(DataInputStream dataInputStream) {
        EventGeneric eventGeneric = this.createEventGeneric();
        eventGeneric.fromStream(dataInputStream);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(EventGeneric eventGeneric) {
        EventGeneric eventGeneric2 = this.createEventGeneric();
        eventGeneric2.fromEvent(eventGeneric);
        return eventGeneric2;
    }

    @Override
    public EventGeneric newEvent(int n) {
        EventGeneric eventGeneric = this.createEventGeneric();
        eventGeneric.setServiceId(n);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(int n, int n2, int n3) {
        EventGeneric eventGeneric = this.createEventGeneric();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(n2);
        eventGeneric.setReceiverEventId(n3);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = this.createEventGeneric();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n3);
        eventGeneric.setReceiverTargetId(n2);
        eventGeneric.setReceiverEventId(n4);
        return eventGeneric;
    }

    private EventGeneric createEventGeneric() {
        return new EventGeneric();
    }
}

