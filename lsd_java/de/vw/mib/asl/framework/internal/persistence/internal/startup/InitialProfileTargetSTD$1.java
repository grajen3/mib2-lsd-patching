/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.startup;

import de.vw.mib.asl.framework.api.diagnosis.AdaptionResponse;
import de.vw.mib.asl.framework.api.diagnosis.config.Access;
import de.vw.mib.asl.framework.internal.persistence.internal.startup.InitialProfileTargetSTD;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;

class InitialProfileTargetSTD$1
implements AdaptionResponse {
    private final /* synthetic */ EventDispatcherHSM val$eventDispatcher;
    private final /* synthetic */ EventFactory val$eventFactory;
    private final /* synthetic */ InitialProfileTargetSTD this$0;

    InitialProfileTargetSTD$1(InitialProfileTargetSTD initialProfileTargetSTD, EventDispatcherHSM eventDispatcherHSM, EventFactory eventFactory) {
        this.this$0 = initialProfileTargetSTD;
        this.val$eventDispatcher = eventDispatcherHSM;
        this.val$eventFactory = eventFactory;
    }

    @Override
    public void onSuccess(Access access) {
        EventGeneric eventGeneric = this.createAnswerEvent();
        eventGeneric.setObject(1, access);
        this.val$eventDispatcher.sendSafe(eventGeneric);
    }

    @Override
    public void onError() {
        EventGeneric eventGeneric = this.createAnswerEvent();
        eventGeneric.setResult(12);
        this.val$eventDispatcher.sendSafe(eventGeneric);
    }

    private EventGeneric createAnswerEvent() {
        EventGeneric eventGeneric = this.val$eventFactory.newEvent(0, this.this$0.getTargetId(), -1434058496);
        eventGeneric.setInt(2, -1945800920);
        eventGeneric.setLong(3, 0);
        return eventGeneric;
    }
}

