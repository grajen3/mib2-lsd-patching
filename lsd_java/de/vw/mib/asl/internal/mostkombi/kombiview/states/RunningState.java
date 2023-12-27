/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.kombiview.states;

import de.vw.mib.asl.internal.mostkombi.kombiview.states.KombiViewHsmContext;
import de.vw.mib.asl.internal.mostkombi.kombiview.states.KombiViewState;
import de.vw.mib.genericevents.hsm.HsmState;

class RunningState
extends KombiViewState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$kombiview$states$RunningState;

    public RunningState(KombiViewHsmContext kombiViewHsmContext, HsmState hsmState) {
        super(kombiViewHsmContext, (class$de$vw$mib$asl$internal$mostkombi$kombiview$states$RunningState == null ? (class$de$vw$mib$asl$internal$mostkombi$kombiview$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.mostkombi.kombiview.states.RunningState")) : class$de$vw$mib$asl$internal$mostkombi$kombiview$states$RunningState).getName(), hsmState);
    }

    @Override
    protected void stateEntry() {
    }

    @Override
    protected void stateStart() {
    }

    @Override
    protected void stateExit() {
        this.getContextDelegate().uninitialize();
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

