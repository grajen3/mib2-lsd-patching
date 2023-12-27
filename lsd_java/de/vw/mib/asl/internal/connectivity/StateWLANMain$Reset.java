/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.connectivity.StateWLANMain;
import de.vw.mib.asl.internal.connectivity.StateWLANMain$1;

class StateWLANMain$Reset
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ StateWLANMain this$0;

    private StateWLANMain$Reset(StateWLANMain stateWLANMain) {
        this.this$0 = stateWLANMain;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        StateWLANMain.access$102(this.this$0, factoryResetCallback);
        StateWLANMain.access$200(this.this$0);
    }

    /* synthetic */ StateWLANMain$Reset(StateWLANMain stateWLANMain, StateWLANMain$1 stateWLANMain$1) {
        this(stateWLANMain);
    }
}

