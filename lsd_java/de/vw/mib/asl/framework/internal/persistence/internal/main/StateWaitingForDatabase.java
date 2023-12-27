/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.main;

import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.asl.framework.internal.persistence.internal.dsi.ApiPersDsi;
import de.vw.mib.asl.framework.internal.persistence.internal.main.PersistenceMainTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateWaitingForDatabase
extends AbstractHsmState {
    private final PersistenceMainTarget mTarget;

    public StateWaitingForDatabase(PersistenceMainTarget persistenceMainTarget, String string, HsmState hsmState) {
        super(persistenceMainTarget.getHsm(), string, hsmState);
        this.mTarget = persistenceMainTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                PersDebug.trace("State Main:WaitingForDatabase", true);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiPersistenceUpdateActiveSQLDatabaseMedium(int n, int n2) {
        if (n != 1) {
            ApiPersDsi.setSQLDatabaseMedium(1);
        } else if (this.mTarget.mIsDiagnosisOn) {
            this.trans(this.mTarget.mStateDiagnosis);
        } else {
            this.trans(this.mTarget.mStateFlashOk);
        }
    }
}

