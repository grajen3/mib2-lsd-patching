/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.viewoption;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.car.viewoption.StateWork;

class StateWork$ResetCARParticipant
extends AbstractFactoryResetParticipant {
    private FactoryResetCallback callback;
    private final /* synthetic */ StateWork this$0;

    StateWork$ResetCARParticipant(StateWork stateWork) {
        this.this$0 = stateWork;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.callback = factoryResetCallback;
        this.this$0.resettingAllSettings();
    }

    public void resetDone() {
        this.callback.notifyResetDone();
    }
}

