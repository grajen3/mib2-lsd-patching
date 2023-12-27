/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.states;

import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoHsmContext;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoState;
import de.vw.mib.genericevents.hsm.HsmState;

class RunningState
extends NavInfoState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$states$RunningState;

    public RunningState(NavInfoHsmContext navInfoHsmContext, HsmState hsmState) {
        super(navInfoHsmContext, (class$de$vw$mib$asl$internal$mostkombi$navinfo$states$RunningState == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$states$RunningState = RunningState.class$("de.vw.mib.asl.internal.mostkombi.navinfo.states.RunningState")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$states$RunningState).getName(), hsmState);
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

