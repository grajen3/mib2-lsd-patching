/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.api.persistence.PersistenceReadCallback;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.internal.Persistence;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Requester;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.main.StateDiagnosis;
import de.vw.mib.asl.framework.internal.persistence.internal.main.StateFlashOk;
import de.vw.mib.asl.framework.internal.persistence.internal.main.StateIdle;
import de.vw.mib.asl.framework.internal.persistence.internal.main.StateTop;
import de.vw.mib.asl.framework.internal.persistence.internal.main.StateWaitingForDatabase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;

final class PersistenceMainTarget
extends AbstractASLHsmTarget {
    final HsmState mStateTop = new StateTop(this, "stateTop", this.getWorkStateParent());
    final HsmState mStateWaitingForDatabase = new StateWaitingForDatabase(this, "stateWaitingForDatabase", this.mStateTop);
    final HsmState mStateFlashOk = new StateFlashOk(this, "stateFlashOk", this.mStateTop);
    final HsmState mStateIdle = new StateIdle(this, "stateIdle", this.mStateFlashOk);
    final HsmState mStateDiagnosis = new StateDiagnosis(this, "stateDiagnosis", this.mStateFlashOk);
    boolean mIsDiagnosisOn = false;
    boolean mIsEnabled = false;
    boolean mIsDisabledDueToError = false;
    private int writeTimerTime = 5000;

    PersistenceMainTarget(GenericEvents genericEvents, int n, String string, Persistence persistence) {
        super(genericEvents, n, string);
        this.hsm.verbose = false;
        String string2 = System.getProperty("de.vw.mib.persistenceWriteTimer");
        if (string2 != null) {
            try {
                this.writeTimerTime = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    @Override
    public int getSubClassifier() {
        return 32;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.mStateTop;
    }

    void handleWrite(EventGeneric eventGeneric, byte by) {
        if (eventGeneric != null) {
            int n = eventGeneric.getInt(0);
            long l = eventGeneric.getLong(1);
            boolean bl = eventGeneric.getBoolean(4);
            PersistenceReadCallback persistenceReadCallback = null;
            AbstractRecord abstractRecord = AbstractRecord.getDataFromEvent(eventGeneric, by);
            if (bl) {
                ApiPersDbImpl.INSTANCE.putIntoCache(n, l, abstractRecord, false);
            }
            if (eventGeneric.getSenderEventId() != 0 && eventGeneric.getSenderTargetId() != 0) {
                if (!ApiPersDbImpl.INSTANCE.putRequest(n, l, (byte)1, eventGeneric, persistenceReadCallback)) {
                    eventGeneric.setResult(12);
                    eventGeneric.setInt(3, 9);
                    return;
                }
                eventGeneric.setBlocked(true);
            }
            abstractRecord.writeToDsi(n, l);
            ApiPersFlush.handleWrite(n, l);
        }
    }

    void handleRead(EventGeneric eventGeneric, byte by) {
        AbstractRecord abstractRecord;
        int n = eventGeneric.getInt(0);
        long l = eventGeneric.getLong(1);
        boolean bl = eventGeneric.getBoolean(4);
        PersistenceReadCallback persistenceReadCallback = (PersistenceReadCallback)eventGeneric.getObject(5);
        if (bl && (abstractRecord = ApiPersDbImpl.INSTANCE.getCachedRecord(n, l)) != null) {
            abstractRecord.setDataInEvent(eventGeneric);
            eventGeneric.setInt(3, 0);
            eventGeneric.setResult(0);
            this.invokeCallback(persistenceReadCallback, n, l, 0, abstractRecord);
            return;
        }
        if (!ApiPersDbImpl.INSTANCE.putRequest(n, l, (byte)2, eventGeneric, persistenceReadCallback)) {
            eventGeneric.setResult(12);
            eventGeneric.setInt(3, 9);
            this.invokeCallback(persistenceReadCallback, n, l, 9, null);
            return;
        }
        switch (by) {
            case 1: {
                ApiPersDsi.readInt(n, l);
                eventGeneric.setBlocked(true);
                break;
            }
            case 2: {
                ApiPersDsi.readString(n, l);
                eventGeneric.setBlocked(true);
                break;
            }
            case 4: {
                ApiPersDsi.readStringArray(n, l);
                eventGeneric.setBlocked(true);
                break;
            }
            case 3: {
                ApiPersDsi.readBuffer(n, l);
                eventGeneric.setBlocked(true);
                break;
            }
            default: {
                eventGeneric.setResult(12);
                eventGeneric.setInt(3, 5);
                this.invokeCallback(persistenceReadCallback, n, l, 5, null);
            }
        }
    }

    void handleWriteResponse(int n, long l, int n2) {
        Requester requester = ApiPersDbImpl.INSTANCE.removeRequester(n, l, (byte)1);
        if (requester != null) {
            this.deliver(requester, null, n2);
        }
    }

    void handleReadResponse(int n, long l, AbstractRecord abstractRecord, int n2) {
        ApiPersDbImpl.INSTANCE.markDataWasLoaded(n, l);
        if (n2 == 0 && abstractRecord != null && abstractRecord.isValid()) {
            ApiPersDbImpl.INSTANCE.putIntoCache(n, l, abstractRecord, true);
        }
        byte by = abstractRecord == null ? (byte)0 : abstractRecord.getType();
        PersDebug.ioLog("DSI UP", n, l, n2, by, abstractRecord == null ? "" : abstractRecord.toString());
        Requester requester = ApiPersDbImpl.INSTANCE.removeRequester(n, l, (byte)2);
        if (requester != null) {
            this.deliver(requester, abstractRecord, n2);
        }
    }

    void handleFlushResponse(int n) {
        boolean bl = n == 0;
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 5608, -23314176);
        eventGeneric.setBoolean(0, bl);
        this.sendSafe(eventGeneric);
    }

    void startTimerForWritingRecords() {
        boolean bl = this.getTimerServer().isTimerActive(this.getTargetId(), -1568276224);
        if (!bl) {
            this.startTimer(-1568276224, (long)this.writeTimerTime, false);
        }
    }

    private void deliver(Requester requester, AbstractRecord abstractRecord, int n) {
        this.sendEvent(requester, abstractRecord, n);
        PersistenceReadCallback persistenceReadCallback = requester.getCallback();
        if (persistenceReadCallback != null) {
            this.invokeCallback(persistenceReadCallback, requester.getNamespace(), requester.getKey(), n, abstractRecord);
        }
    }

    private void sendEvent(Requester requester, AbstractRecord abstractRecord, int n) {
        EventGeneric eventGeneric = requester.getEvent();
        if (eventGeneric != null && eventGeneric.getSenderTargetId() != 0 && eventGeneric.getSenderEventId() != 0) {
            if (abstractRecord != null) {
                abstractRecord.setDataInEvent(eventGeneric);
            }
            eventGeneric.setInt(3, n);
            eventGeneric.setResult(n == 0 ? 0 : 12);
            if (eventGeneric.isBlocked()) {
                eventGeneric.setBlocked(false);
                this.sendBackSafe(eventGeneric);
            } else {
                this.sendSafe(eventGeneric);
            }
        }
    }

    private void invokeCallback(PersistenceReadCallback persistenceReadCallback, int n, long l, int n2, AbstractRecord abstractRecord) {
        if (persistenceReadCallback != null) {
            byte[] byArray = this.extractByteArray(abstractRecord);
            persistenceReadCallback.onDataRead(n, l, n2, byArray);
        }
    }

    private byte[] extractByteArray(AbstractRecord abstractRecord) {
        byte[] byArray = null;
        if (abstractRecord instanceof RecordByteArray) {
            byArray = ((RecordByteArray)abstractRecord).getByteArray();
        }
        return byArray;
    }
}

