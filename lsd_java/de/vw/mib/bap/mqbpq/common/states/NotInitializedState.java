/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.mqbpq.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbpq.common.states.NotStartedFunctionControlUnitState;
import de.vw.mib.genericevents.hsm.HsmState;

class NotInitializedState
extends NotStartedFunctionControlUnitState {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$common$states$NotInitializedState;

    public NotInitializedState(FsgHsmContext fsgHsmContext, HsmState hsmState) {
        super(fsgHsmContext, (class$de$vw$mib$bap$mqbpq$common$states$NotInitializedState == null ? (class$de$vw$mib$bap$mqbpq$common$states$NotInitializedState = NotInitializedState.class$("de.vw.mib.bap.mqbpq.common.states.NotInitializedState")) : class$de$vw$mib$bap$mqbpq$common$states$NotInitializedState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "entry stateNotInitialized");
    }

    @Override
    public void stateStart() {
        this.setHMIState(1);
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        if (n3 == 20 && this.getHsmContext().getCurrentHMIState() == 1) {
            FSGOperationState fSGOperationState = this.getLogicalControlUnit().getFunctionRegistry().getBapFSGOperationStateFunction();
            if (fSGOperationState != null) {
                fSGOperationState.setHMISystemDependent(false);
                fSGOperationState.setState(3);
            }
            this.goToState(this.getHsmContext().getInitializingState());
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        super.bapStateStatus(n, n2);
        if (n2 == 0) {
            this.goToState(this.getParent());
        }
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

