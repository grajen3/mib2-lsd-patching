/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.SoundPersistence;
import de.vw.mib.genericevents.EventGeneric;

class SoundPersistence$2
implements GlobalProfileChangeListener {
    private final /* synthetic */ SoundPersistence this$0;

    SoundPersistence$2(SoundPersistence soundPersistence) {
        this.this$0 = soundPersistence;
    }

    @Override
    public void onProfileChangeStarted() {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundP Received ProfileChangeStarted COMMON").log();
        }
        this.this$0.setProfileChangeOngoing(true);
    }

    @Override
    public void onProfileChangeCompleted() {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundP Received ProfileChangeCompleted COMMON").log();
        }
        this.this$0.setProfileChangeOngoing(false);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1305144064, -1305144064, -1517944576);
        ServiceManager.eventMain.getEventDispatcher().sendSafe(eventGeneric);
    }
}

