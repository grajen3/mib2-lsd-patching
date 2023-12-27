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

public final class StateActivate
extends AbstractState {
    private final int TIMEOUT;

    StateActivate(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.TIMEOUT = 5000;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateActivate is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.info(256).append("switchLinkingDevice is set to used in StateActivate").log();
                }
                this.mTarget.mNextState = this.mTarget.stateActive;
                this.mTarget.mDsiDabTuner.switchLinkingDeviceUsage(2);
                this.mTarget.switchLinkingDone = false;
                break;
            }
            case 100112: {
                this.mTarget.mNextState = this.mTarget.stateActive;
                break;
            }
            case 100113: {
                this.mTarget.mNextState = this.mTarget.stateDeactivate;
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
        this.mTarget.getTextLogger().info(this.mTarget.getClassifier(), "SwitchLinking Device Failed, so OnTimeout Called ");
        this.mTarget.switchLinkingDone = false;
        this.trans(this.mTarget.mNextState);
        DabMainApi.notifyTunerActivated();
    }

    public void dsiDABTunerUpdateLinkingUsageStatus(int n, int n2) {
        if (n == 2) {
            this.mTarget.switchLinkingDone = true;
            DabMainApi.notifyTunerActivated();
            this.trans(this.mTarget.mNextState);
        }
        if (n != 2) {
            this.mTarget.switchLinkingDone = false;
        }
    }
}

