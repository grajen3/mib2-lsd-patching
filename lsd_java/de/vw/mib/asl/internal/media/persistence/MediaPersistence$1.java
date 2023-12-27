/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence;
import de.vw.mib.genericevents.EventGeneric;

class MediaPersistence$1
extends AbstractProfileChangeHandler {
    private final /* synthetic */ MediaPersistence this$0;

    MediaPersistence$1(MediaPersistence mediaPersistence) {
        this.this$0 = mediaPersistence;
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.this$0.loadPersi2_0();
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(380572416, 380572416, -1585053440);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
        EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric2.setInt(0, this.this$0.getVideoFormat());
        ServiceManager.eventMain.getServiceRegister().triggerObserver(2046820416, eventGeneric2);
        this.notifyProfileChanged(true);
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MediaPersistence.changeProfile(): ").append(this.this$0.toString()).log();
        }
    }
}

