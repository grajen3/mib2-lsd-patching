/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.persistence.internal.db.AbstractRecord;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateTop
extends AbstractHsmState {
    private final PersistenceMainTarget target;

    public StateTop(PersistenceMainTarget persistenceMainTarget, String string, HsmState hsmState) {
        super(persistenceMainTarget.getHsm(), string, hsmState);
        this.target = persistenceMainTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                ApiPersDsi.initialize(this.target);
                break;
            }
            case 3: {
                this.trans(this.target.mStateWaitingForDatabase);
                break;
            }
            case 4: {
                break;
            }
            case 1200001: {
                this.trans(this.target.mStateDiagnosis);
                break;
            }
            case 4300039: {
                this.target.mIsEnabled = true;
                PersDebug.trace("Enable Persistence, normal operation", true);
                ApiPersFlush.activate();
                break;
            }
            case 4300040: {
                boolean bl = eventGeneric.getBoolean(0);
                boolean bl2 = this.target.mIsDisabledDueToError = !bl;
                if (bl) {
                    PersDebug.trace("Enable Persistence after error", true);
                    ApiPersFlush.activate();
                    break;
                }
                PersDebug.trace("Disable Persistence due to error", true);
                ApiPersFlush.deactivate();
                break;
            }
            case 100003: {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 5608, -358858496);
                this.target.send(eventGeneric2);
                break;
            }
            case 1700002: {
                this.target.error("StateTop: Received READ_INT event, however persistence is not ready for read operations yet.");
                break;
            }
            case 1700004: {
                this.target.error("StateTop: Received READ_STRING event, however persistence is not ready for read operations yet.");
                break;
            }
            case 1700006: {
                this.target.error("StateTop: Received READ_STRING event, however persistence is not ready for read operations yet.");
                break;
            }
            case 1700008: {
                this.target.error("StateTop: Received READ_BYTEARRAY event, however persistence is not ready for read operations yet.");
                break;
            }
            case 1700003: {
                this.target.error("StateTop: Received WRITE_INT event, however persistence is not ready for write operations yet.");
                break;
            }
            case 1700005: {
                this.target.error("StateTop: Received WRITE_STRING event, however persistence is not ready for write operations yet.");
                break;
            }
            case 1700007: {
                this.target.error("StateTop: Received WRITE_STRINGARRAY event, however persistence is not ready for write operations yet.");
                break;
            }
            case 1700009: {
                this.target.error("StateTop: Received WRITE_BYTEARRAY event, however persistence is not ready for write operations yet.");
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiPersistenceWriteInt(int n, long l, int n2) {
        this.target.handleWriteResponse(n, l, n2);
    }

    public void dsiPersistenceWriteString(int n, long l, int n2) {
        this.target.handleWriteResponse(n, l, n2);
    }

    public void dsiPersistenceWriteStringArray(int n, long l, int n2) {
        this.target.handleWriteResponse(n, l, n2);
    }

    public void dsiPersistenceWriteBuffer(int n, long l, int n2) {
        this.target.handleWriteResponse(n, l, n2);
    }

    public void dsiPersistenceReadInt(int n, long l, int n2, int n3) {
        AbstractRecord abstractRecord = AbstractRecord.createRecord(n, l, n2);
        this.target.handleReadResponse(n, l, abstractRecord, n3);
    }

    public void dsiPersistenceReadString(int n, long l, String string, int n2) {
        AbstractRecord abstractRecord = AbstractRecord.createRecord(n, l, string);
        this.target.handleReadResponse(n, l, abstractRecord, n2);
    }

    public void dsiPersistenceReadStringArray(int n, long l, String[] stringArray, int n2) {
        AbstractRecord abstractRecord = AbstractRecord.createRecord(n, l, stringArray);
        this.target.handleReadResponse(n, l, abstractRecord, n2);
    }

    public void dsiPersistenceReadBuffer(int n, long l, byte[] byArray, int n2) {
        AbstractRecord abstractRecord = AbstractRecord.createRecord(n, l, byArray);
        this.target.handleReadResponse(n, l, abstractRecord, n2);
    }

    public void dsiPersistenceUpdateActiveSQLDatabaseMedium(int n, int n2) {
        if (n != 1) {
            ApiPersDsi.setSQLDatabaseMedium(1);
            this.trans(this.target.mStateWaitingForDatabase);
        }
    }

    public void dsiPersistenceFlushSQLDatabase(int n) {
        this.target.handleFlushResponse(n);
    }
}

