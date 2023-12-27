/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.internal.radio.sdars.database.AslPool;
import de.vw.mib.asl.internal.radio.sdars.dsi.DsiProxy;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateActive;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateIdle;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateInactive;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateReset;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateSelectStation;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatDsiStateTop;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.hsm.TargetHsmImpl;
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.sdars.DSISDARSTuner;

public final class SatDsiTarget
extends TargetHsmImpl {
    private final SatDb mDb;
    private final AslPool mPool;
    private static final int MAX_QUEUE_SIZE;
    private EventGeneric mCurrentEvent = null;
    private DsiProxy mProxy;
    private boolean mTimeoutRunning;
    private int mLastSID = -1;
    private final List mQueue = new LinkedList();
    private final HsmState mStateTop;
    private final HsmState mStateActive;
    private final HsmState mStateInactive;
    private final HsmState mStateIdle;
    private final HsmState mStateSelectStation;
    private final HsmState mStateReset;

    SatDsiTarget(SatDb satDb, GenericEvents genericEvents, int n, String string) {
        super(genericEvents);
        this.mStateTop = new SatDsiStateTop(satDb, this);
        this.mStateActive = new SatDsiStateActive(satDb, this, this.mStateTop);
        this.mStateInactive = new SatDsiStateInactive(satDb, this, this.mStateTop);
        this.mStateIdle = new SatDsiStateIdle(satDb, this, this.mStateActive);
        this.mStateSelectStation = new SatDsiStateSelectStation(satDb, this, this.mStateActive);
        this.mStateReset = new SatDsiStateReset(satDb, this, this.mStateActive);
        this.mDb = satDb;
        this.mPool = this.mDb.getPool();
        this.startHsmAndRegisterTarget(genericEvents, n, string, this.mStateTop);
        this.hsm.verbose = false;
    }

    void transStateActive() {
        this.hsm.trans(this.mStateActive);
    }

    void transStateIdle() {
        this.hsm.trans(this.mStateIdle);
    }

    void transStateInactive() {
        this.hsm.trans(this.mStateInactive);
    }

    void transStateSelectStation() {
        this.hsm.trans(this.mStateSelectStation);
    }

    void transStateReset() {
        this.hsm.trans(this.mStateReset);
    }

    SatDb getDb() {
        return this.mDb;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void addEvent(EventGeneric eventGeneric) {
        if (eventGeneric == null) return;
        List list = this.mQueue;
        synchronized (list) {
            while (true) {
                if (this.mQueue.size() < 1) {
                    eventGeneric.setBlocked(true);
                    this.mQueue.add(eventGeneric);
                    return;
                }
                EventGeneric eventGeneric2 = (EventGeneric)this.mQueue.remove(0);
                eventGeneric2.setBlocked(false);
                eventGeneric2.setResult(11);
                try {
                    this.mDb.getMainTarget().getEventDispatcher().sendBack(eventGeneric2);
                }
                catch (GenericEventException genericEventException) {
                }
            }
        }
    }

    void allocateProxy() {
        this.mProxy = new DsiProxy(this.mDb, this, null);
    }

    @Override
    public int getClassifier() {
        return 1;
    }

    EventGeneric getCurrentEvent() {
        return this.mCurrentEvent;
    }

    DSISDARSTuner getSdarsTuner() {
        return this.mProxy;
    }

    @Override
    public int getSubClassifier() {
        return 512;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    EventGeneric nextEvent() {
        this.mCurrentEvent = null;
        List list = this.mQueue;
        synchronized (list) {
            if (!this.mQueue.isEmpty()) {
                this.mCurrentEvent = (EventGeneric)this.mQueue.remove(0);
            }
        }
        return this.mCurrentEvent;
    }

    void retriggerTimeout(int n) {
        if (this.mTimeoutRunning) {
            this.getTimerServer().restartTimedEvent(this.getTargetId(), 143065344);
        } else {
            this.startTimeout(n);
        }
        this.mTimeoutRunning = true;
    }

    void sendAnswer() {
        if (this.mCurrentEvent != null) {
            if (this.mCurrentEvent.isBlocked()) {
                this.mCurrentEvent.setBlocked(false);
                this.sendBack(this.mCurrentEvent);
            }
            this.mCurrentEvent = null;
        }
    }

    void setCurrentEvent(EventGeneric eventGeneric) {
        this.mCurrentEvent = eventGeneric;
    }

    void setResult(int n) {
        this.mCurrentEvent.setResult(n);
    }

    void startTimeout(int n) {
        if (!this.mTimeoutRunning && n > 0) {
            int n2 = this.getTargetId();
            EventGeneric eventGeneric = this.getEventFactory().newEvent();
            eventGeneric.setSenderTargetId(n2);
            eventGeneric.setReceiverTargetId(n2);
            eventGeneric.setReceiverEventId(143065344);
            this.getTimerServer().sendTimedEvent(eventGeneric, (long)n, false, true);
            this.mTimeoutRunning = true;
        }
    }

    void stopTimeout() {
        if (this.mTimeoutRunning) {
            this.getTimerServer().stopTimedEvent(this.getTargetId(), 143065344);
        }
        this.mTimeoutRunning = false;
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        SatDb.logEvent("DSI", eventGeneric);
        super.gotEvent(eventGeneric);
    }

    void setLastSID(int n) {
        this.mLastSID = n;
    }

    int getLastSID() {
        return this.mLastSID;
    }

    void notifySelectionStatus(int n) {
        switch (n) {
            case 3: {
                this.mDb.getChannels().removeInvalidChannel(this.mLastSID);
                this.mPool.setInt(34, 0);
                this.mPool.setInt(81, 0);
                break;
            }
            case 6: {
                this.mPool.setInt(34, 0);
                this.mPool.setInt(81, 0);
                break;
            }
            case 4: {
                this.mDb.getChannels().addInvalidChannel(this.mLastSID);
                this.mPool.setInt(34, this.mLastSID);
                this.mPool.setInt(81, 0);
                break;
            }
            case 5: {
                this.mPool.setInt(34, 0);
                this.mPool.setInt(81, this.mLastSID);
                break;
            }
        }
    }
}

