/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.states;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.eni.states.ENIHsmContext;
import de.vw.mib.asl.internal.ocu.eni.states.ENIState;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.genericevents.hsm.HsmState;
import java.nio.BufferUnderflowException;

final class RunningState
extends ENIState
implements BAPValueObserver {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$states$RunningState;

    public RunningState(ENIHsmContext eNIHsmContext, HsmState hsmState) {
        super(eNIHsmContext, (class$de$vw$mib$asl$internal$ocu$eni$states$RunningState == null ? (class$de$vw$mib$asl$internal$ocu$eni$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.ocu.eni.states.RunningState")) : class$de$vw$mib$asl$internal$ocu$eni$states$RunningState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this._startObservingBapOperationState();
        this.setHMIState(2);
    }

    @Override
    public void stateExit() {
        this._stopObservingBapFunctionList();
        this.getContextDelegate().getLogicalControlUnit().uninitialize();
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
            this._bapStackBecomesUnavailable();
        }
    }

    private void _fsgBecomesUnavailableOrRestarted() {
        this.goToState(this.getHsmContext().getVersionCheckState());
    }

    private void _bapStackBecomesUnavailable() {
        this.goToState(this.getHsmContext().getWaitForMiddlewareState());
    }

    private void _checkOperationState() {
        if (this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getOperationState().getState() != 0) {
            this.goToState(this.getHsmContext().getWaitForFsgOperationState());
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

