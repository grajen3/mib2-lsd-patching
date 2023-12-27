/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDeactivate
extends AbstractState {
    private final int TIMEOUT;

    StateDeactivate(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.TIMEOUT = 2000;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDeactivate is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.info(256).append("switchLinkingDevice is set to Available in StateDeactivate").log();
                }
                this.mTarget.mNextState = this.mTarget.stateInactive;
                this.mTarget.mDsiDabTuner.switchLinkingDeviceUsage(1);
                this.mTarget.stopTimer(-1937309440);
                break;
            }
            case 100112: {
                this.mTarget.mNextState = this.mTarget.stateActivate;
                break;
            }
            case 100113: {
                this.mTarget.mNextState = this.mTarget.stateInactive;
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    @Override
    long getTimeout() {
        return 0;
    }

    @Override
    void onTimeout() {
        this.trans(this.mTarget.stateInactive);
        DabMainApi.notifyTunerDeactivated();
    }

    public void dsiDABTunerUpdateLinkingUsageStatus(int n, int n2) {
        switch (n) {
            case 0: 
            case 1: {
                DabMainApi.notifyTunerDeactivated();
                this.trans(this.mTarget.mNextState);
                break;
            }
        }
    }
}

