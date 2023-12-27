/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.states;

import de.vw.mib.asl.internal.ocu.ecall.states.ECallHsmContext;
import de.vw.mib.asl.internal.ocu.ecall.states.ECallState;
import de.vw.mib.genericevents.hsm.HsmState;

final class ECallStartupTopState
extends ECallState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$states$ECallStartupTopState;

    public ECallStartupTopState(ECallHsmContext eCallHsmContext, HsmState hsmState) {
        super(eCallHsmContext, (class$de$vw$mib$asl$internal$ocu$ecall$states$ECallStartupTopState == null ? (class$de$vw$mib$asl$internal$ocu$ecall$states$ECallStartupTopState = ECallStartupTopState.class$("de.vw.mib.asl.internal.ocu.ecall.states.ECallStartupTopState")) : class$de$vw$mib$asl$internal$ocu$ecall$states$ECallStartupTopState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
    }

    @Override
    public void stateExit() {
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

