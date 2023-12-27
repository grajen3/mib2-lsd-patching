/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.main;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.main.SatMainStateTop;

class SatMainStateTop$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ SatMainStateTop this$0;

    SatMainStateTop$1(SatMainStateTop satMainStateTop) {
        this.this$0 = satMainStateTop;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        try {
            this.this$0.resetSiriusToFactorySettings();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        if (null != factoryResetCallback) {
            factoryResetCallback.notifyResetDone();
        }
    }
}

