/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateCalculationAbortedAndStopped
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;
    private boolean isRgActiveReceived;
    private boolean isRgActive;
    private boolean isRgStartGuidanceCalculatedRouteResultReceived;

    StateCalculationAbortedAndStopped(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.start();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void start() {
        this.isRgActiveReceived = false;
        ServiceManager.aslPropertyManager.valueChangedInteger(803, 3);
        if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgActive");
        this.isRgActiveReceived = true;
        this.isRgActive = bl;
        if (bl) {
            this.myTarget.traceState(this, "Guidance is active.");
            if (this.isRgStartGuidanceCalculatedRouteResultReceived) {
                this.myTarget.traceState(this, "rgStartGuidanceCalculatedRouteResultReceived -> calling stop guidance");
                this.myTarget.getDsiNavigation().rgStopGuidance();
            }
        } else {
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
    }

    public void dsiNavigationRgStartGuidanceCalculatedRouteResult(int n) {
        this.myTarget.traceState(this, "rgStartGuidanceCalculatedRouteResult");
        this.isRgStartGuidanceCalculatedRouteResultReceived = true;
        if (this.isRgActiveReceived && this.isRgActive) {
            this.myTarget.traceState(this, "Guidance was active -> calling stop guidance");
            this.myTarget.getDsiNavigation().rgStopGuidance();
        }
    }
}

