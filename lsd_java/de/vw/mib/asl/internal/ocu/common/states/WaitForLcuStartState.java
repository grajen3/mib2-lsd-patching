/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.states;

import de.vw.mib.asl.internal.ocu.common.states.AsgControlUnitState;
import de.vw.mib.asl.internal.ocu.common.states.CommonHsmContext;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.bap.util.BAPErrorCodes;

public final class WaitForLcuStartState
extends AsgControlUnitState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$common$states$WaitForLcuStartState;

    public WaitForLcuStartState(CommonHsmContext commonHsmContext, HsmState hsmState) {
        super(commonHsmContext, (class$de$vw$mib$asl$internal$ocu$common$states$WaitForLcuStartState == null ? (class$de$vw$mib$asl$internal$ocu$common$states$WaitForLcuStartState = WaitForLcuStartState.class$("de.vw.mib.asl.internal.ocu.common.states.WaitForLcuStartState")) : class$de$vw$mib$asl$internal$ocu$common$states$WaitForLcuStartState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this.checkInitializeStatus();
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void initialize() {
        this.checkInitializeStatus();
    }

    private void checkInitializeStatus() {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            this.goToState(this.getHsmContext().getWaitForMiddlewareState());
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        this.getLogErrorMessage(n2, "acknowledge").append(" shall not be called, acknowledgeType = ").append(n3).log();
    }

    @Override
    public void indication(int n, int n2, int n3, int n4, int n5) {
        this.getLogErrorMessage(n2, "indication").append(" shall not be called, indicationType = ").append(n4).log();
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        this.getLogErrorMessage(n2, "indicationByteSequence").append(" shall not be called, indicationType = ").append(n3).log();
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        this.getLogErrorMessage(n2, "indicationVoid").append(" shall not be called, indicationType = ").append(n3).log();
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        this.getLogErrorMessage(n2, "indicationError shall not be called").append(", errorCode = ").append(n3).append(", meaning=").append(BAPErrorCodes.stringFromErrorCode(n3)).log();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier()).append("asyncException shall not be called here errorMsg=").append(string).log();
    }

    @Override
    public void requestVoid(int n, int n2) {
    }

    @Override
    public void request(int n, int n2, int n3, int n4) {
    }

    @Override
    public void requestByteSequence(int n, int n2, byte[] byArray) {
    }

    @Override
    public void requestError(int n, int n2) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

