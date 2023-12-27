/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateGuidanceActiveRubberband
extends AbstractHsmState {
    private final HsmTargetGuidance target;
    private boolean isStopped;

    StateGuidanceActiveRubberband(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.isStopped = false;
                this.target.traceState(this, "GUIDANCE_MODE -> reset to GUIDANCE_MODE_RUBBERBAND");
                this.target.updateGuidanceMode(3);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                this.target.traceState(this, "GUIDANCE_MODE -> reset to GUIDANCE_MODE_NORMAL");
                this.target.updateGuidanceMode(0);
                break;
            }
            case 3497001: {
                this.target.traceState(this, "EV_MAP_MAIN_RUBBERBAND_MANIPULATION_CANCEL");
                break;
            }
            case 3497002: {
                this.target.traceState(this, "EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START_CALCULATED_ROUTE");
                this.startGuidanceCalculatedRoute(eventGeneric.getInt(0));
                break;
            }
            case 1073742342: 
            case 0x40000224: 
            case 1073743954: {
                this.target.traceState(this, "STOP/ABORT/ABORT_AND_STOP");
                this.isStopped = true;
                ServiceManager.aslPropertyManager.valueChangedInteger(-2114973696, 1);
                this.target.infoState(this, "Rubberband guidance has been stopped -> store guidance stop time");
                this.target.storeTimestamp();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void startGuidanceCalculatedRoute(int n) {
        this.target.traceState(this, "startGuidanceCalculatedRoute()");
        this.target.getDsiNavigation().rgStartGuidanceCalculatedRoute(n);
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        if (bl) {
            if (!this.isStopped) {
                this.trans(this.target.stateGuidanceActiveIdle);
                ServiceManager.aslPropertyManager.valueChangedInteger(752, 0);
            } else {
                this.target.getDsiNavigation().rgStopGuidance();
            }
        } else if (this.isStopped) {
            this.target.traceState(this, "Guidance has been stopped -> leave rubberband state");
            ServiceManager.aslPropertyManager.valueChangedInteger(-2114973696, 2);
            ServiceManager.aslPropertyManager.valueChangedInteger(752, 0);
            this.trans(this.target.stateGuidanceNotActive);
        }
    }
}

