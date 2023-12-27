/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.database.IAslPool;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;

public final class AudioManager {
    private final SatDb mDb;
    private final IAslPool mPool;
    private final AbstractTarget mTarget;
    private boolean mAudioAvailable = false;

    public AudioManager(SatDb satDb, AbstractTarget abstractTarget) {
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.mTarget = abstractTarget;
    }

    public void setMuted(boolean bl) {
        this.mPool.setBoolean(61, bl);
        this.setVolumeLock(bl);
    }

    public void setVolumeLock(boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(512)) {
            ServiceManager.logger.trace(512).append("AudioManager - setVolumeLock( ").append(bl).append(" )").log();
        }
        EventGeneric eventGeneric = this.mDb.newEvent();
        if (bl) {
            eventGeneric.setServiceId(185154816);
            eventGeneric.setInt(0, 28);
        } else {
            eventGeneric.setServiceId(201932032);
            eventGeneric.setInt(0, 28);
        }
        this.mTarget.sendSafe(eventGeneric);
    }

    public boolean isAudioAvailable() {
        return this.mAudioAvailable;
    }

    public void setAudioAvailable(boolean bl) {
        this.mAudioAvailable = bl;
    }

    public void requestFadeIn(AbstractTarget abstractTarget, int n) {
        LogMessage logMessage = this.mDb.getLogHandler().getLogMsg();
        if (logMessage != null) {
            logMessage.append("Request fade to audio connection for SDARS with connection id = ").append(28).log();
        }
        EventGeneric eventGeneric = this.mDb.newEvent();
        eventGeneric.setServiceId(50937088);
        eventGeneric.setInt(0, 28);
        eventGeneric.setSenderEventId(n);
        abstractTarget.sendSafe(eventGeneric);
    }
}

