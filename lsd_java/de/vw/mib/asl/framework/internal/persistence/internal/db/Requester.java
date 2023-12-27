/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.EventGeneric;

public final class Requester {
    private final int targetId;
    private final int eventId;
    private final int namespace;
    private final long key;
    private final long time;
    private final EventGeneric event;
    private final PersistenceReadCallback callback;

    public Requester(int n, long l, int n2, int n3) {
        this.namespace = n;
        this.key = l;
        this.targetId = n2;
        this.eventId = n3;
        this.event = null;
        this.time = ServiceManager.timerManager.getSystemTimeMillis();
        this.callback = null;
    }

    public Requester(int n, long l, EventGeneric eventGeneric, PersistenceReadCallback persistenceReadCallback) {
        this.namespace = n;
        this.key = l;
        this.targetId = eventGeneric.getSenderTargetId();
        this.eventId = eventGeneric.getSenderEventId();
        this.event = eventGeneric;
        this.time = ServiceManager.timerManager.getSystemTimeMillis();
        this.callback = persistenceReadCallback;
    }

    public int getTID() {
        return this.targetId;
    }

    public int getEID() {
        return this.eventId;
    }

    public EventGeneric getEvent() {
        if (this.event != null) {
            return this.event;
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(5120, this.targetId, this.eventId);
        eventGeneric.setInt(0, this.namespace);
        eventGeneric.setLong(1, this.key);
        return eventGeneric;
    }

    public PersistenceReadCallback getCallback() {
        return this.callback;
    }

    public long getTime() {
        return this.time;
    }

    boolean isOld(long l) {
        return this.time + l < ServiceManager.timerManager.getSystemTimeMillis();
    }

    public int getNamespace() {
        return this.namespace;
    }

    public long getKey() {
        return this.key;
    }
}

