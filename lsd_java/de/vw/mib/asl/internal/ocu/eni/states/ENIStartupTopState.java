/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.states;

import de.vw.mib.asl.internal.ocu.eni.states.ENIHsmContext;
import de.vw.mib.asl.internal.ocu.eni.states.ENIState;
import de.vw.mib.genericevents.hsm.HsmState;

final class ENIStartupTopState
extends ENIState {
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$eni$states$ENIStartupTopState;

    public ENIStartupTopState(ENIHsmContext eNIHsmContext, HsmState hsmState) {
        super(eNIHsmContext, (class$de$vw$mib$asl$internal$ocu$eni$states$ENIStartupTopState == null ? (class$de$vw$mib$asl$internal$ocu$eni$states$ENIStartupTopState = ENIStartupTopState.class$("de.vw.mib.asl.internal.ocu.eni.states.ENIStartupTopState")) : class$de$vw$mib$asl$internal$ocu$eni$states$ENIStartupTopState).getName(), hsmState);
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

