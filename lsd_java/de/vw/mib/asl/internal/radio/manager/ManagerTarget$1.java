/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.manager;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.appadapter.ApiAppAdapterGlobalSetupWizard;
import de.vw.mib.asl.internal.radio.manager.ManagerTarget;

class ManagerTarget$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ ManagerTarget this$0;

    ManagerTarget$1(ManagerTarget managerTarget) {
        this.this$0 = managerTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        try {
            this.this$0.resetAmFmToFactorySettings();
            ApiAppAdapterGlobalSetupWizard.activateStartScanButton();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
        if (null != factoryResetCallback) {
            factoryResetCallback.notifyResetDone();
        }
    }
}

