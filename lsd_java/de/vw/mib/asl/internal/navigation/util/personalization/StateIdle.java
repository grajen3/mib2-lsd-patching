/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.personalization;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.util.personalization.HsmTargetProfileChange;
import de.vw.mib.asl.internal.navigation.util.personalization.NavProfileChangeHandler;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateIdle
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[StateIdle]");
    private HsmTargetProfileChange target;

    public StateIdle(HsmTargetProfileChange hsmTargetProfileChange, String string, HsmState hsmState) {
        super(hsmTargetProfileChange.getHsm(), string, hsmState);
        this.target = hsmTargetProfileChange;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 100100: {
                NavProfileChangeHandler navProfileChangeHandler = (NavProfileChangeHandler)eventGeneric.getObject(0);
                this.handlePrepareForProfileChange(navProfileChangeHandler);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handlePrepareForProfileChange(NavProfileChangeHandler navProfileChangeHandler) {
        this.logger.trace("handlePrepareForProfileChange()");
        this.target.profileChangeHandler = navProfileChangeHandler;
        this.target.transStatePrepareForProfileChange();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    public void dsiPredictiveNavigationUpdateOperationMode(int n, int n2) {
        if (n2 == 1) {
            this.target.currentPnavOperationMode = n;
        }
    }
}

