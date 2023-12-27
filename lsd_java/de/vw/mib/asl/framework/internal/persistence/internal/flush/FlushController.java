/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.flush;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.StateActive;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.StateInactive;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.StateShutdown;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.StateTop;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;

final class FlushController
extends TargetHsmImpl {
    private final HsmState mStateTop = new StateTop(this, null);
    private final HsmState mStateInactive = new StateInactive(this, this.mStateTop);
    private final HsmState mStateActive = new StateActive(this, this.mStateTop);
    private final HsmState mStateShutdown = new StateShutdown(this, this.mStateTop);
    private int mTimerStep = 0;
    private int mFlushesPerformed;
    private int mFlushesAllowed;
    private boolean mIsFlushPending = false;
    private boolean mActive = false;
    private long mNextTimeout = 0L;
    private boolean mDeactivatedDueToError = false;
    private boolean mShutdownFlushPerformed = false;

    FlushController(GenericEvents genericEvents, String string) {
        super(genericEvents);
        try {
            this.startHsmAndRegisterTarget(genericEvents, genericEvents.getEventDispatcher().getNextTargetId(), string, this.mStateTop);
        }
        catch (Exception exception) {
            ServiceManager.logger.error(32, "COULD NOT START Persistence FlushController.");
        }
    }

    void deactivateDueToError() {
        this.mDeactivatedDueToError = true;
    }

    void activateAfterError() {
        this.mDeactivatedDueToError = false;
    }

    int createNextTimeout() {
        int n = 60;
        for (int i2 = 1; i2 <= this.mTimerStep; ++i2) {
            n += i2 * 150;
        }
        ++this.mTimerStep;
        return n;
    }

    private void flush() {
        this.mIsFlushPending = false;
        ++this.mFlushesPerformed;
        ApiPersDbImpl.INSTANCE.writeRecords();
        ApiPersDsi.flushSQLDatabase();
    }

    int getTimerStep() {
        return this.mTimerStep;
    }

    void stat() {
        if (PersDebug.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer = stringBuffer.append("Persistence: ").append("PersFlushInfo: Active=").append(this.mActive).append(", Pending=").append(this.mIsFlushPending).append(", allowed/performed=").append(this.mFlushesAllowed).append("/").append(this.mFlushesPerformed).append(", NextTimeIn=").append((this.mNextTimeout - ServiceManager.timerManager.getSystemTimeMillis()) / 0).append(" seconds");
            PersDebug.trace(stringBuffer.toString(), false);
        }
    }

    void forceFlush() {
        if (this.mFlushesAllowed <= this.mFlushesPerformed) {
            this.mFlushesAllowed = this.mFlushesPerformed + 1;
            PersDebug.trace("forceFlush (to allow flushing during shutdown)", true);
        }
    }

    void incomingFlushRequest() {
        PersDebug.trace("Incoming Persistence flush database request", true);
        this.mIsFlushPending = true;
        this.stat();
        this.checkForPendingFlush();
    }

    private void checkForPendingFlush() {
        if (this.mIsFlushPending) {
            if (this.isFlushAllowed()) {
                this.flush();
            } else {
                this.simulateFlushResponse();
            }
        }
    }

    private void simulateFlushResponse() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5608, -23314176);
        eventGeneric.setBoolean(0, true);
        this.sendSafe(eventGeneric);
    }

    void nextTimeout(int n) {
        this.mNextTimeout = ServiceManager.timerManager.getSystemTimeMillis() + (long)n;
    }

    void goingActive() {
        this.mActive = true;
        this.checkForPendingFlush();
    }

    void goingInactive() {
        this.mActive = false;
    }

    private boolean isFlushAllowed() {
        return !this.mDeactivatedDueToError && this.mActive && this.mFlushesAllowed > this.mFlushesPerformed;
    }

    void nextTimeoutReached() {
        ++this.mFlushesAllowed;
        this.checkForPendingFlush();
    }

    void transStateActive() {
        this.hsm.trans(this.mStateActive);
    }

    void transStateInactive() {
        this.hsm.trans(this.mStateInactive);
    }

    void transStateShutdown() {
        this.hsm.trans(this.mStateShutdown);
    }

    void handleWrite(int n, long l) {
        if (this.mShutdownFlushPerformed) {
            this.error().append("[Persistence FlushController] Written into persistence after shutdown flush, (namespace/key): (").append(n).append("/").append(l).append(")").log();
        }
    }

    void setShutdownFlushPerformed(boolean bl) {
        this.mShutdownFlushPerformed = bl;
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }
}

