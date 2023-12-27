/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateGuidanceActiveIdle
extends AbstractHsmState {
    private final HsmTargetGuidance target;

    StateGuidanceActiveIdle(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.updateCalculationState(new ASLCalculationState[]{new ASLCalculationState()});
                this.target.updateGuidanceState(1);
                ServiceManager.aslPropertyManager.valueChangedInteger(806, 1);
                ServiceManager.aslPropertyManager.valueChangedInteger(803, 0);
                ServiceManager.aslPropertyManager.valueChangedInteger(1911558144, this.target.navigationDp.getGuidanceType());
                if (!ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isPNavActive()) {
                    this.target.traceState(this, "setWasGuidanceActive set value: true");
                    PersistedGuidanceSetup.getInstance().setWasGuidanceActive(true, false);
                    this.target.infoState(this, "Guidance has been started -> store guidance start time");
                    this.target.storeTimestamp();
                    break;
                }
                this.target.traceState(this, "PNAV route is active -> do not call setWasGuidanceActive(true)");
                break;
            }
            case 3497004: {
                this.target.traceState(this, "EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START");
                this.trans(this.target.stateGuidanceActiveRubberband);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        if (!bl) {
            this.target.traceState(this, "transition to stateGuidanceFinished.");
            this.trans(this.target.stateGuidanceFinished);
        }
    }
}

