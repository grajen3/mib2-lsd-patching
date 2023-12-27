/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;

public class EventWrappingAdaptionResponse
implements AdaptionResponse {
    private final int targetId;
    private final int eventId;
    private final EventFactory eventFactory;
    private final EventDispatcherHSM eventDispatcher;
    private final int namespace;
    private final long key;

    public EventWrappingAdaptionResponse(int n, long l, int n2, int n3, EventFactory eventFactory, EventDispatcherHSM eventDispatcherHSM) {
        this.namespace = n;
        this.key = l;
        this.targetId = n2;
        this.eventId = n3;
        this.eventFactory = eventFactory;
        this.eventDispatcher = eventDispatcherHSM;
    }

    @Override
    public void onSuccess(Access access) {
        EventGeneric eventGeneric = this.createAnswerEvent();
        eventGeneric.setObject(1, access);
        this.eventDispatcher.sendSafe(eventGeneric);
    }

    @Override
    public void onError() {
        EventGeneric eventGeneric = this.createAnswerEvent();
        eventGeneric.setResult(12);
        this.eventDispatcher.sendSafe(eventGeneric);
    }

    private EventGeneric createAnswerEvent() {
        EventGeneric eventGeneric = this.eventFactory.newEvent(0, this.targetId, this.eventId);
        eventGeneric.setInt(2, this.namespace);
        eventGeneric.setLong(3, this.key);
        return eventGeneric;
    }
}

