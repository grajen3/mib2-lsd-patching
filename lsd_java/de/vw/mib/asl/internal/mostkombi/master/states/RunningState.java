/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.master.states;

import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContext;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiState;
import de.vw.mib.genericevents.hsm.HsmState;

class RunningState
extends MostKombiState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$master$states$RunningState;

    public RunningState(MostKombiHsmContext mostKombiHsmContext, HsmState hsmState) {
        super(mostKombiHsmContext, (class$de$vw$mib$asl$internal$mostkombi$master$states$RunningState == null ? (class$de$vw$mib$asl$internal$mostkombi$master$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.mostkombi.master.states.RunningState")) : class$de$vw$mib$asl$internal$mostkombi$master$states$RunningState).getName(), hsmState);
    }

    @Override
    protected void stateEntry() {
    }

    @Override
    protected void stateStart() {
    }

    @Override
    protected void stateExit() {
    }

    @Override
    protected void mostKombiControllerStarted(Controller controller) {
        this.getContextDelegate().addStartedKombiController(controller);
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

