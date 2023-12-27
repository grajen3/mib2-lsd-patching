/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.GuidanceUtils;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavSegmentID;

public class StateGuidanceNotActive
extends AbstractHsmState {
    private final HsmTargetGuidance myTarget;

    StateGuidanceNotActive(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.handleStart();
                break;
            }
            case 1073742365: 
            case 1073742366: 
            case 1073742367: 
            case 0x40000220: 
            case 1073742369: 
            case 1073742371: 
            case 0x40000774: 
            case 1073743733: 
            case 1074841914: 
            case 1074841915: 
            case 1074841916: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_START...");
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846538240, 0);
                this.handleGuidanceStart(eventGeneric.getReceiverEventId());
                break;
            }
            case 100103: {
                this.myTarget.traceState(this, "EV_ASL_INT_GUIDANCE_START_FROM_EXTERN");
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846538240, 1);
                this.handleGuidanceStart(587333696);
                break;
            }
            case 100106: {
                this.myTarget.traceState(this, "EV_ASL_INT_GUIDANCE_START_RECALCULATION_FROM_EXTERN");
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846538240, 1);
                this.handleGuidanceStart(0x74070040);
                break;
            }
            case 100104: {
                this.myTarget.traceState(this, "EV_ASL_INT_GUIDANCE_START_DEMO_FROM_EXTERN");
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846538240, 1);
                this.handleGuidanceStart(553779264);
                break;
            }
            case 100107: {
                this.myTarget.traceState(this, "EV_ASL_INT_GUIDANCE_START_DEMO_RECALCULATION_FROM_EXTERN");
                ServiceManager.aslPropertyManager.valueChangedInteger(-1846538240, 1);
                this.handleGuidanceStart(1963393088);
                break;
            }
            case 1073742353: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_RESUME");
                this.myTarget.isResumeGuidance = true;
                this.myTarget.triggerMe(PersistedGuidanceSetup.getInstance().getLastGuidanceMode());
                EventGeneric eventGeneric2 = ASLNavigationEventFactory.createEvent(895235328);
                ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric2);
                break;
            }
            case 100105: {
                this.myTarget.traceState(this, "EV_ASL_INT_PREDICTIVE_GUIDANCE_ACTIVE");
                this.myTarget.pnavDestination = (NavSegmentID)eventGeneric.getObject(0);
                this.trans(this.myTarget.stateGuidanceStartPNAV);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleStart() {
        ServiceManager.aslPropertyManager.valueChangedBoolean(794, false);
        ServiceManager.aslPropertyManager.valueChangedBoolean(-571469824, false);
        if (this.myTarget.navigationDp.getGuidanceType() == 2 || !this.myTarget.isFeatHigh) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainRouteVisibility(false);
        }
        if (this.myTarget.aslNavGuidanceDP.getGuidanceMode() == 2) {
            this.myTarget.traceState(this, "GUIDANCE_MODE = GUIDANCE_MODE_PNAV -> reset to GUIDANCE_MODE_NORMAL");
            this.myTarget.updateGuidanceMode(0);
        }
        if (!this.myTarget.isSouthsideInDemoMode()) {
            GuidanceUtils.notifyGuidanceDeactivated(this.myTarget, false);
        } else {
            this.myTarget.traceState(this, "Deactivate demo mode");
            this.trans(this.myTarget.stateDeactivateDemoModeNoGuidance);
        }
    }

    private void handleGuidanceStart(int n) {
        PersistedGuidanceSetup.getInstance().setLastGuidanceMode(n);
        if (!this.myTarget.isFeatHigh) {
            this.myTarget.traceState(this, "Target != HIGH -> set route visibility true");
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainRouteVisibility(true);
        }
        this.trans(this.myTarget.stateCalculationPrepare);
    }
}

