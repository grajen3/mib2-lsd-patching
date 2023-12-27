/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.collections.ints.MultiIntegerTupleList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;

final class ServiceEntry {
    private static final int IDS_PER_OBSERVER;
    private static final int INDEX_TARGET_ID;
    private static final int INDEX_EVENT_ID;
    private static final int INDEX_ROUTER_ID;
    private static final int OBSERVER_SENDER_TARGET_ID;
    private int chainId = -1;
    private final GenericEvents eventContext;
    private EventGeneric lastEvent = null;
    private MultiIntegerTupleList observers = new MultiIntegerTupleList(3);
    private final int ownerEventId;
    private final int ownerRouterId;
    private final int ownerTargetId;
    private final boolean saveLastEvent;
    private final int serviceId;
    private final boolean wantEvent;

    ServiceEntry(GenericEvents genericEvents, int n) {
        this(genericEvents, n, 0, 0, 0, false, false);
    }

    ServiceEntry(GenericEvents genericEvents, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.eventContext = genericEvents;
        this.serviceId = n;
        this.ownerRouterId = n2;
        this.ownerTargetId = n3;
        this.ownerEventId = n4 == 0 ? n : n4;
        this.saveLastEvent = bl;
        this.wantEvent = bl2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!(object instanceof ServiceEntry)) {
            return false;
        }
        ServiceEntry serviceEntry = (ServiceEntry)object;
        return this.serviceId == serviceEntry.serviceId;
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.serviceId;
        return n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("Service ");
        stringBuffer.append(this.serviceId);
        stringBuffer.append(": ");
        stringBuffer.append(this.observers.chainLength(this.chainId));
        stringBuffer.append(" observers");
        if (this.ownerTargetId != 0) {
            stringBuffer.append(", Owner = ");
            stringBuffer.append(this.ownerRouterId);
            stringBuffer.append('.');
            stringBuffer.append(this.ownerTargetId);
            stringBuffer.append(':');
            stringBuffer.append(this.ownerEventId);
        }
        if (this.saveLastEvent) {
            stringBuffer.append(", SafeLastEvent");
        }
        if (this.wantEvent) {
            stringBuffer.append(", OwnerWantsEvent");
        }
        if (this.lastEvent != null) {
            stringBuffer.append(", LastEvent=");
            stringBuffer.append(this.lastEvent);
        }
        return stringBuffer.toString();
    }

    private EventGeneric createObserverEvent(EventGeneric eventGeneric, int n, int n2, int n3, int n4, int n5) {
        EventGeneric eventGeneric2 = ServiceManager.mEventFactory.newEvent();
        if (n == 0) {
            if (eventGeneric != null && eventGeneric.getSenderTargetId() != 0) {
                eventGeneric2.setSenderTargetId(eventGeneric.getSenderTargetId());
            } else if (this.ownerTargetId != 0) {
                eventGeneric2.setSenderTargetId(this.ownerTargetId);
            } else {
                eventGeneric2.setSenderTargetId(5001);
            }
        } else {
            eventGeneric2.setSenderTargetId(n);
            eventGeneric2.setSenderEventId(n2);
        }
        eventGeneric2.setReceiverTargetId(n4);
        eventGeneric2.setReceiverRouterId(n3);
        if (n5 != 0) {
            eventGeneric2.setReceiverEventId(n5);
        } else {
            eventGeneric2.setReceiverEventId(this.serviceId);
        }
        if (eventGeneric != null) {
            eventGeneric2.setSenderRouterId(eventGeneric.getSenderRouterId());
            eventGeneric2.takeParams(eventGeneric);
        }
        return eventGeneric2;
    }

    private int getObserverEventId(int n, int n2) {
        int n3 = this.chainId;
        while (n3 != -1) {
            if (this.observers.getValueAt(n3, 0) == n2 && this.observers.getValueAt(n3, 2) == n) {
                int n4 = this.observers.getValueAt(n3, 1);
                return n4 == 0 ? this.serviceId : n4;
            }
            n3 = this.observers.getPredecessorId(n3);
        }
        return 0;
    }

    private void setLastEvent(EventGeneric eventGeneric) {
        if (!this.saveLastEvent) {
            return;
        }
        if (this.lastEvent != null) {
            ServiceManager.mEventFactory.freeEvent(this.lastEvent);
        }
        this.lastEvent = eventGeneric != null ? ServiceManager.mEventFactory.newEvent(eventGeneric) : ServiceManager.mEventFactory.newEvent(this.serviceId);
    }

    int addObserver(int n, int n2, int n3) {
        if (this.observers.containsValue3(this.chainId, n2, n3, n)) {
            return 0;
        }
        this.chainId = this.observers.addValue3(this.chainId, n2, n3, n);
        if (this.lastEvent != null) {
            EventGeneric eventGeneric = this.createObserverEvent(this.lastEvent, 0, 0, n, n2, n3);
            this.eventContext.getEventDispatcher().send(eventGeneric);
        }
        return 1;
    }

    void addObservers(ServiceEntry serviceEntry) {
        this.observers = serviceEntry.observers;
        this.chainId = serviceEntry.chainId;
    }

    int getOwnerEventId() {
        return this.ownerEventId;
    }

    int getOwnerTargetId() {
        return this.ownerTargetId;
    }

    boolean isEmpty() {
        return this.chainId == -1;
    }

    int removeObserver(int n, int n2) {
        int n3 = this.getObserverEventId(n, n2);
        if (!this.observers.containsValue3(this.chainId, n2, n3, n)) {
            return 0;
        }
        this.chainId = this.observers.removeAllValues3(this.chainId, n2, n3, n);
        return 1;
    }

    boolean triggerLastEvent() {
        if (this.lastEvent == null) {
            return false;
        }
        this.triggerObserver(this.lastEvent);
        return true;
    }

    void triggerObserver(EventGeneric eventGeneric) {
        boolean bl;
        this.setLastEvent(eventGeneric);
        boolean bl2 = bl = eventGeneric == null;
        if (eventGeneric == null) {
            eventGeneric = ServiceManager.mEventFactory.newEvent();
        }
        eventGeneric.setInvocationContext(InvocationContext.getCurrentInvocationContext(null));
        if (this.isEmpty() && (!this.wantEvent || this.ownerTargetId == 0)) {
            ServiceManager.eventTracer.trace((byte)3, (byte)1, this.serviceId, eventGeneric);
        } else {
            ServiceManager.eventTracer.trace((byte)2, (byte)1, this.serviceId, eventGeneric);
        }
        if (this.wantEvent && this.ownerTargetId != 0) {
            EventGeneric eventGeneric2 = bl ? this.createObserverEvent(null, 0, 0, this.ownerRouterId, this.ownerTargetId, this.ownerEventId) : this.createObserverEvent(eventGeneric, eventGeneric.getSenderTargetId(), eventGeneric.getSenderEventId(), this.ownerRouterId, this.ownerTargetId, this.ownerEventId);
            this.eventContext.getEventDispatcher().sendSafe(eventGeneric2);
        }
        if (!this.isEmpty()) {
            int n = this.chainId;
            while (n != -1) {
                int n2 = this.observers.getValueAt(n, 0);
                int n3 = this.observers.getValueAt(n, 2);
                int n4 = this.observers.getValueAt(n, 1);
                EventGeneric eventGeneric3 = this.createObserverEvent(eventGeneric, 0, 0, n3, n2, n4);
                this.eventContext.getEventDispatcher().sendSafe(eventGeneric3);
                n = this.observers.getPredecessorId(n);
            }
        }
        if (eventGeneric != null && eventGeneric != this.lastEvent) {
            ServiceManager.mEventFactory.freeEvent(eventGeneric);
        }
    }
}

