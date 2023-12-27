/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.internal.navigation.guidance.main.GuidanceUtils;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.Route;

public class StateDSINotAvailable
extends AbstractHsmState {
    private final HsmTargetGuidance target;
    private boolean fullyOperable = false;
    private boolean rmPersistentRoutereceived = false;
    private boolean rmPersistentRouteValid;

    StateDSINotAvailable(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.handleStart();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleStart() {
        this.fullyOperable = false;
        this.rmPersistentRoutereceived = false;
        GuidanceUtils.notifyGuidanceDeactivated(this.target, true);
    }

    public HsmState dsiNavigationUpdateRmPersistentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRmPersistentRoute");
        this.rmPersistentRoutereceived = true;
        this.rmPersistentRouteValid = route != null && route.routelist != null && route.routelist.length != 0;
        this.resumeGuidanceIfPossible();
        return this.myParent;
    }

    private void resumeGuidanceIfPossible() {
        if (this.fullyOperable && this.rmPersistentRoutereceived) {
            this.target.getHsm().trans(this.target.stateGuidanceNotActive);
            this.target.getHsm().activateTransition();
            if (!GuidanceUtils.wasDemoGuidance() && this.rmPersistentRouteValid) {
                this.target.triggerMe(285343808);
            }
        }
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.target.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        if (n == 5) {
            this.target.traceState(this, " navstateofoperation is NAVSTATEOFOPERATION_FULLY_OPERABLE.");
            this.fullyOperable = true;
            this.resumeGuidanceIfPossible();
            return null;
        }
        return this.myParent;
    }
}

