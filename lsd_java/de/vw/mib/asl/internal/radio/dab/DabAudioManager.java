/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public final class DabAudioManager {
    private boolean mMuted = false;
    private boolean mNoAudio = false;
    private boolean mLocked = false;
    public AbstractTarget mTarget = null;

    public void setMuted(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabAudioManager setMuted : ").append(bl).log();
        }
        this.mMuted = bl;
        this.setVolumeLock(this.mMuted);
    }

    public void setNoAudio(boolean bl) {
        this.mNoAudio = bl;
        this.setVolumeLock(this.mMuted);
    }

    private void notifyAudioManagement(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("notifyAudioManagement aLock : ").append(bl).log();
        }
        this.mLocked = bl;
        if (this.mLocked) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(185154816);
            eventGeneric.setInt(0, 26);
            this.mTarget.send(eventGeneric);
        } else {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(201932032);
            eventGeneric.setInt(0, 26);
            this.mTarget.send(eventGeneric);
        }
    }

    public void resetAudioLock() {
        this.mLocked = false;
    }

    public void setVolumeLock(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("DabAudioManager setVolumeLock : ").append(bl).append(" Prev Lock State (mLocked) : ").append(this.mLocked).append(" with mMuted : ").append(this.mMuted).append(" & mNoAudio : ").append(this.mNoAudio).log();
        }
        if (this.mLocked != bl && (bl || !this.mMuted && !this.mNoAudio)) {
            this.notifyAudioManagement(bl);
        }
    }
}

