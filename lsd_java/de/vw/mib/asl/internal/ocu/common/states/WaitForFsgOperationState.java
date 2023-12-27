/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.states;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.states.AsgControlUnitState;
import de.vw.mib.asl.internal.ocu.common.states.CommonHsmContext;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.genericevents.hsm.HsmState;
import java.nio.BufferUnderflowException;

public class WaitForFsgOperationState
extends AsgControlUnitState
implements BAPValueObserver {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$common$states$WaitForFsgOperationState;

    public WaitForFsgOperationState(CommonHsmContext commonHsmContext, HsmState hsmState) {
        super(commonHsmContext, (class$de$vw$mib$asl$internal$ocu$common$states$WaitForFsgOperationState == null ? (class$de$vw$mib$asl$internal$ocu$common$states$WaitForFsgOperationState = WaitForFsgOperationState.class$("de.vw.mib.asl.internal.ocu.common.states.WaitForFsgOperationState")) : class$de$vw$mib$asl$internal$ocu$common$states$WaitForFsgOperationState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this.getContextDelegate().getLogger().info(this.getContextDelegate().getSubClassifier()).append("Wait for Operation state switch to normal").log();
        this._startObservingBapOperationState();
        this._checkOperationState();
    }

    @Override
    public void stateExit() {
        this._stopObservingBapFunctionList();
    }

    @Override
    public void indicationError(int n, int n2, int n3) {
        super.indicationError(n, n2, n3);
        if (n2 == 4 && n3 == 33) {
            this._fsgBecomesUnavailableOrRestarted();
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        super.bapStateStatus(n, n2);
        if (n2 == 0) {
            this.goToState(this.getHsmContext().getWaitForMiddlewareState());
        }
    }

    @Override
    public void indicationByteSequence(int n, int n2, int n3, byte[] byArray) {
        try {
            super.indicationByteSequence(n, n2, n3, byArray);
            if (n2 == 2 && n3 == 13) {
                this._fsgBecomesUnavailableOrRestarted();
            }
        }
        catch (BufferUnderflowException bufferUnderflowException) {
            this.getLogErrorMessage(n2, "indicationByteSequence").append(" not processed, indicationType = ").append(n3).append(byArray).append(bufferUnderflowException).log();
        }
    }

    private void _fsgBecomesUnavailableOrRestarted() {
        this.goToState(this.getHsmContext().getVersionCheckState());
    }

    private void _requestOperationstate() {
        this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getFunctionController(15).initialize(true);
    }

    private void _checkOperationState() {
        if (this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getOperationState().getState() == 0) {
            this.getContextDelegate().getLogicalControlUnit().reinitialize();
            this.goToState(this.getHsmContext().getRunningState());
        } else {
            this._requestOperationstate();
        }
    }

    private void _startObservingBapOperationState() {
        this.getContextDelegate().getLogicalControlUnit().getBapObserverRegistry().getBapValueObservable(15).addObserver(this, null);
    }

    private void _stopObservingBapFunctionList() {
        this.getContextDelegate().getLogicalControlUnit().getBapObserverRegistry().getBapValueObservable(15).removeObserver(this);
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        this._checkOperationState();
    }

    @Override
    public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
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

