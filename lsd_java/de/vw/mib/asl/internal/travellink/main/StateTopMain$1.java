/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.main;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.main.StateTopMain;

class StateTopMain$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ StateTopMain this$0;

    StateTopMain$1(StateTopMain stateTopMain) {
        this.this$0 = stateTopMain;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        try {
            this.this$0.resetTravelLinkToFactorySettings();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        if (null != factoryResetCallback) {
            factoryResetCallback.notifyResetDone();
        }
    }
}

