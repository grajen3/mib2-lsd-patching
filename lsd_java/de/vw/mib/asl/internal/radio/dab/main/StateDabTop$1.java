/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.main.StateDabTop;

class StateDabTop$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ StateDabTop this$0;

    StateDabTop$1(StateDabTop stateDabTop) {
        this.this$0 = stateDabTop;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        try {
            this.this$0.resetDabToFactorySettings();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        if (null != factoryResetCallback) {
            factoryResetCallback.notifyResetDone();
        }
    }
}

