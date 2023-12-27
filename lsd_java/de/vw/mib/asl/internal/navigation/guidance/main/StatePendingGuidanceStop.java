/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.Route;

public class StatePendingGuidanceStop
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;
    private int myBuffer;

    StatePendingGuidanceStop(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.myBuffer = -1;
                this.myTarget.getDsiNavigation().rgStopGuidance();
                this.myTarget.getDsiNavigation().rmMakeRoutePersistent(new Route());
                break;
            }
            case 1073742365: 
            case 1073742366: 
            case 1073742367: 
            case 0x40000220: 
            case 1073742369: 
            case 1073742371: 
            case 0x40000774: 
            case 1073743733: {
                this.myBuffer = eventGeneric.getReceiverEventId();
                this.myTarget.infoState(this, new StringBuffer("received ASL_NAVIGATION_GUIDANCE_START* ").append(this.myBuffer).append(" not handled now").toString());
                if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) break;
                this.trans(this.myTarget.stateGuidanceNotActive);
                if (this.myBuffer < 0) break;
                this.myTarget.triggerMe(this.myBuffer);
                break;
            }
            case 0x40000224: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.myTarget.traceState(this, "DSINAVIGATION_UPDATERGACTIVE");
        if (!bl) {
            this.myTarget.traceState(this, "Guidance stopped!");
            this.trans(this.myTarget.stateGuidanceNotActive);
            if (this.myBuffer >= 0) {
                this.myTarget.triggerMe(this.myBuffer);
            }
        } else {
            this.trans(this.myTarget.stateGuidanceActiveIdle);
        }
    }
}

