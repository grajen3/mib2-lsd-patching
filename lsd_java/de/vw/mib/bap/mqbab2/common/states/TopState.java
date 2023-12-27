/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.states;

import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbab2.common.states.NotStartedFunctionControlUnitState;
import de.vw.mib.genericevents.hsm.HsmState;

class TopState
extends NotStartedFunctionControlUnitState {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$states$TopState;

    public TopState(FsgHsmContext fsgHsmContext, HsmState hsmState) {
        super(fsgHsmContext, (class$de$vw$mib$bap$mqbab2$common$states$TopState == null ? (class$de$vw$mib$bap$mqbab2$common$states$TopState = TopState.class$("de.vw.mib.bap.mqbab2.common.states.TopState")) : class$de$vw$mib$bap$mqbab2$common$states$TopState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "entry topState");
        super.bapStateStatus(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID(), 0);
    }

    @Override
    public void stateStart() {
        if (this.getHsmContext().getCurrentHMIState() != 0) {
            this.setHMIState(0);
        } else {
            this.getContextDelegate().getLogicalControlUnit().getService().getBAPState(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID());
        }
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        if (n3 == 20 && this.getHsmContext().getCurrentHMIState() == 0) {
            this.getContextDelegate().getLogicalControlUnit().getService().getBAPState(this.getContextDelegate().getLogicalControlUnit().getLogicalControlUnitID());
        }
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        super.bapStateStatus(n, n2);
        if (n2 == 1 && this.getHsmContext().getCurrentHMIState() == 0) {
            this.goToState(this.getHsmContext().getNotInitializedState());
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

