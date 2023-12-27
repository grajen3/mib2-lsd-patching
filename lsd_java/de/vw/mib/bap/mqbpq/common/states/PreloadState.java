/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.mqbpq.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbpq.common.states.NotStartedFunctionControlUnitState;
import de.vw.mib.genericevents.hsm.HsmState;

class PreloadState
extends NotStartedFunctionControlUnitState {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$common$states$PreloadState;

    public PreloadState(FsgHsmContext fsgHsmContext, HsmState hsmState) {
        super(fsgHsmContext, (class$de$vw$mib$bap$mqbpq$common$states$PreloadState == null ? (class$de$vw$mib$bap$mqbpq$common$states$PreloadState = PreloadState.class$("de.vw.mib.bap.mqbpq.common.states.PreloadState")) : class$de$vw$mib$bap$mqbpq$common$states$PreloadState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
        this.getContextDelegate().getLogger().trace(this.getContextDelegate().getSubClassifier(), "entry preloadState");
    }

    @Override
    public void stateStart() {
    }

    @Override
    public void stateExit() {
    }

    @Override
    public void initialize() {
        super.initialize();
        this.goToState(this.getHsmContext().getTopState());
    }

    @Override
    public void hmiDatapoolValueChanged(int n, int n2) {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            super.hmiDatapoolValueChanged(n, n2);
        }
    }

    @Override
    public void languageChange(int n) {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            super.languageChange(n);
        }
    }

    @Override
    public void processHMIEvent(int n, int n2) {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            super.processHMIEvent(n, n2);
        }
    }

    @Override
    public void persistenceBecomeAvailable(int n) {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            super.persistenceBecomeAvailable(n);
        }
    }

    @Override
    public void notifyTimer(int n, TimerNotifier timerNotifier, int n2) {
        if (this.getContextDelegate().getLogicalControlUnit().isInitialized()) {
            super.notifyTimer(n, timerNotifier, n2);
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

