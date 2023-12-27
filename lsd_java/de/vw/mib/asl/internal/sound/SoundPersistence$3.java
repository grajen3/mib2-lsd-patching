/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.sound;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.sound.SoundPersistence;

class SoundPersistence$3
implements GlobalProfileChangeListener {
    private final /* synthetic */ SoundPersistence this$0;

    SoundPersistence$3(SoundPersistence soundPersistence) {
        this.this$0 = soundPersistence;
    }

    @Override
    public void onProfileChangeStarted() {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundP Received ProfileChangeStarted AUDIO").log();
        }
        this.this$0.profileChanceWithAudioMuteClampOngoing = true;
    }

    @Override
    public void onProfileChangeCompleted() {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16).append("SoundP Received ProfileChangeCompleted AUDIO").log();
        }
        this.this$0.profileChanceWithAudioMuteClampOngoing = false;
    }
}

