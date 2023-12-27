/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.states;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.states.AbstractControlUnitState;
import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.bap.util.BAPErrorCodes;

abstract class NotStartedFunctionControlUnitState
extends AbstractControlUnitState {
    public NotStartedFunctionControlUnitState(FsgHsmContext fsgHsmContext, String string, HsmState hsmState) {
        super(fsgHsmContext, string, hsmState);
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        if (n3 == 53 || n3 == 66) {
            if (!this.getContextDataPool().restoreLastValidValue(n2)) {
                this.getLogErrorMessage(n2, "indicationError shall not be called").append(", errorCode = ").append(n3).append(", meaning=").append(BAPErrorCodes.stringFromErrorCode(n3)).log();
            }
        } else {
            this.getLogErrorMessage(n2, "indicationError shall not be called").append(", errorCode = ").append(n3).append(", meaning=").append(BAPErrorCodes.stringFromErrorCode(n3)).log();
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
    }

    protected void setHMIState(int n) {
        this.getContextDelegate().getLogicalControlUnit().getService().setHMIState(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID(), n);
        this.getHsmContext().setCurrentHMIState(n);
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        this.getHsmContext().setCurrentBapState(n2);
    }

    @Override
    public void hmiDatapoolValueChanged(int n, int n2) {
        this.getContextDataPool().getStage(n).process(n2);
    }

    @Override
    public void languageChange(int n) {
        this.getContextDataPool().getStage(n).process(-1);
    }

    @Override
    public void persistenceBecomeAvailable(int n) {
        this.getContextDataPool().getStage(n).process(-1);
    }

    @Override
    public void variantChanged() {
    }

    @Override
    public void sendBAPStageOutputValue(int n) {
    }

    @Override
    public void transmitData(int n, int n2, Object object) {
    }

    @Override
    public void processHMIEvent(int n, int n2) {
        BAPStage bAPStage = this.getContextDataPool().getStage(n);
        if (bAPStage == null || !bAPStage.hmiEvent(n2)) {
            this.getLogErrorMessage(n, "processHMIEvent").append(", eventID = ").append(n2).log();
        }
    }

    @Override
    public void notifyTimer(int n, TimerNotifier timerNotifier, int n2) {
        timerNotifier.timerFired(n2);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        this.getLogErrorMessage(n2, "indication").append(" shall not be called, indicationType = ").append(n4).log();
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        this.getLogErrorMessage(n2, "indicationVoid").append(" shall not be called, indicationType = ").append(n3).log();
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        this.getLogErrorMessage(n2, "indicationByteSequence").append(" shall not be called, indicationType = ").append(n3).log();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("asyncException shall not be called here errorMsg=").append(string).log();
    }
}

