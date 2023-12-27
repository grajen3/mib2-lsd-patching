/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.flush.ApiPersFlush;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateDiagnosis
extends AbstractHsmState {
    private final PersistenceMainTarget mTarget;

    public StateDiagnosis(PersistenceMainTarget persistenceMainTarget, String string, HsmState hsmState) {
        super(persistenceMainTarget.getHsm(), string, hsmState);
        this.mTarget = persistenceMainTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("State Main:Diagnosis (Remote Control on)", true);
                this.mTarget.mIsDiagnosisOn = true;
                ApiPersFlush.deactivate();
                ApiPersDbImpl.INSTANCE.useClonedCache();
                break;
            }
            case 4: {
                PersDebug.trace("Remote Control off", true);
                this.mTarget.mIsDiagnosisOn = false;
                ApiPersDbImpl.INSTANCE.restoreCache();
                ApiPersDbImpl.INSTANCE.reloadAllSharedPersistables();
                ApiPersFlush.activate();
                this.mTarget.triggerObserver(513622272, null);
                this.mTarget.startTimer(-1551499008, (long)0, false);
                break;
            }
            case 1200001: {
                break;
            }
            case 1200002: {
                this.trans(this.mTarget.mStateIdle);
                break;
            }
            case 1700003: 
            case 1700005: 
            case 1700007: 
            case 1700009: {
                eventGeneric.setResult(2);
                eventGeneric.setInt(3, 6);
                break;
            }
            case 1700002: {
                this.mTarget.handleRead(eventGeneric, (byte)1);
                break;
            }
            case 1700004: {
                this.mTarget.handleRead(eventGeneric, (byte)2);
                break;
            }
            case 1700006: {
                this.mTarget.handleRead(eventGeneric, (byte)4);
                break;
            }
            case 1700008: {
                this.mTarget.handleRead(eventGeneric, (byte)3);
                break;
            }
            case 1700010: {
                eventGeneric.setResult(2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

