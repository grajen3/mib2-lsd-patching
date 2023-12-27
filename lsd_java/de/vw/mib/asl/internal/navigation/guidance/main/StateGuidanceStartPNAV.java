/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavSegmentID;

public class StateGuidanceStartPNAV
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;
    private boolean isAbort;

    StateGuidanceStartPNAV(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
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
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                break;
            }
            case 1073742342: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_ABORT");
                this.myTarget.getDsiNavigation().rgStopGuidance();
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 3);
                this.isAbort = true;
                break;
            }
            case 0x40000224: 
            case 1073743954: {
                this.myTarget.traceState(this, "STOP/ABORT_AND_STOP");
                if (!this.isAbort) {
                    this.myTarget.getDsiNavigation().rgStopGuidance();
                }
                this.trans(this.myTarget.stateGuidanceNotActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void start() {
        this.isAbort = false;
        this.myTarget.services.getNavigation().rgStartGuidanceCalculatedRouteByUID(this.myTarget.pnavDestination);
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setPNavActive(true);
        if (PersistedGuidanceSetup.getInstance().isSoundOn()) {
            this.myTarget.services.getNavigation().rgSetRouteGuidanceMode(2);
        }
        this.myTarget.navigationDp.setGuidanceType(2);
        this.myTarget.aslNavGuidanceDP.setGuidanceMode(2);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainRouteVisibility(true);
    }

    public void dsiNavigationRgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        if (n != 0) {
            this.myTarget.traceState(this, "Starting guidance by UID failed!");
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgActive");
        if (!this.isAbort) {
            if (bl) {
                this.trans(this.myTarget.stateGuidanceActiveIdle);
            } else {
                this.trans(this.myTarget.stateGuidanceNotActive);
            }
        } else if (bl) {
            this.myTarget.getDsiNavigation().rgStopGuidance();
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(803, 3);
        }
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        if (n == 3) {
            this.myTarget.traceState(this, " navstateofoperation is diskrequest eject.");
            this.myTarget.getDsiNavigation().rgStopGuidance();
            this.trans(this.myTarget.stateGuidanceNotActive);
        }
        return this.myParent;
    }
}

