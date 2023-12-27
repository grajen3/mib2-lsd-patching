/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventPool;
import java.io.DataInputStream;

public final class GenericEventFactory
implements EventFactory {
    private final GenericEventPool eventPool = new GenericEventPool(this);

    @Override
    public void freeEvent(EventGeneric eventGeneric) {
        eventGeneric.release();
    }

    void releaseEvent(EventGeneric eventGeneric) {
        this.eventPool.release(eventGeneric);
    }

    @Override
    public EventGeneric newEvent() {
        EventGeneric eventGeneric = this.eventPool.borrow();
        eventGeneric.removeFromPool();
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(DataInputStream dataInputStream) {
        EventGeneric eventGeneric = this.newEvent();
        eventGeneric.fromStream(dataInputStream);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(EventGeneric eventGeneric) {
        EventGeneric eventGeneric2 = this.newEvent();
        eventGeneric2.fromEvent(eventGeneric);
        return eventGeneric2;
    }

    @Override
    public EventGeneric newEvent(int n) {
        EventGeneric eventGeneric = this.newEvent();
        eventGeneric.setServiceId(n);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(int n, int n2, int n3) {
        EventGeneric eventGeneric = this.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setReceiverTargetId(n2);
        eventGeneric.setReceiverEventId(n3);
        return eventGeneric;
    }

    @Override
    public EventGeneric newEvent(int n, int n2, int n3, int n4) {
        EventGeneric eventGeneric = this.newEvent();
        eventGeneric.setSenderTargetId(n);
        eventGeneric.setSenderEventId(n3);
        eventGeneric.setReceiverTargetId(n2);
        eventGeneric.setReceiverEventId(n4);
        return eventGeneric;
    }

    public String toString() {
        return new StringBuffer().append("GenericEventFactory - ").append(this.eventPool).toString();
    }
}

