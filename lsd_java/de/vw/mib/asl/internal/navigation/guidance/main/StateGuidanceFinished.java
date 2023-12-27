/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.Route;

public class StateGuidanceFinished
extends AbstractHsmState {
    private final HsmTargetGuidance myTarget;

    StateGuidanceFinished(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                this.myTarget.traceState(this, "Final destination reached");
                this.myTarget.setFinalDestinationReached();
                if (this.myTarget.isSouthsideInDemoMode()) {
                    this.myTarget.isGuidanceRestartAfterDemo = true;
                    this.myTarget.traceState("Destination is reached and demomode is on -> guidance will be started again");
                    this.trans(this.myTarget.stateCalculationPrepare);
                    break;
                }
                this.myTarget.traceState("Guidance is finished");
                ServiceManager.aslPropertyManager.valueChangedInteger(806, 2);
                ASLNavGuidanceDP.getInstance().setVoicePromptRequired(true);
                this.myTarget.getDsiNavigation().rmMakeRoutePersistent(new Route());
                break;
            }
            case 0x40000224: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_STOP");
                this.trans(this.myTarget.stateGuidanceNotActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

