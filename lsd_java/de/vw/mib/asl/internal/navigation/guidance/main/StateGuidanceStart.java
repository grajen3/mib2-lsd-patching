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
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.Route;

public class StateGuidanceStart
extends AbstractHsmState {
    private HsmTargetGuidance myTarget;
    private boolean isAbort;

    StateGuidanceStart(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
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
            case 1073742342: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_ABORT");
                this.isAbort = true;
                break;
            }
            case 0x40000224: 
            case 1073743954: {
                this.myTarget.traceState(this, "STOP/ABORT_AND_STOP");
                this.myTarget.triggerIt(1397429248, 75956480);
                if (!this.isAbort) {
                    this.trans(this.myTarget.stateCalculationAbortedAndStopped);
                    break;
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
        this.myTarget.getDsiNavigation().rgStartGuidanceCalculatedRoute(this.myTarget.dsiRouteIndex);
    }

    private void addTourListToLastDestinationsList() {
        Route route = this.myTarget.myRoute;
        if (route != null && route.routeID != 0 && route.routelist != null && route.routelist.length > 0) {
            NavLastDest[] navLastDestArray = new NavLastDest[route.routelist.length];
            for (int i2 = 0; i2 < route.routelist.length; ++i2) {
                FixFormatterFieldData fixFormatterFieldData = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(route.routelist[i2].routeLocation));
                int n = 10 + ServiceManager.configManagerDiag.getNaviCommonOptionDefault(1);
                navLastDestArray[i2] = new NavLastDest(ServiceManager.fixFormat4Asl.fmtRulesetBasedString(n, fixFormatterFieldData), route.routelist[i2].routeLocation, null);
            }
            this.myTarget.getDsiNavigation().dmLastDestinationsAddList(navLastDestArray);
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgActive");
        if (!this.isAbort) {
            if (bl) {
                if (this.myTarget.isRubberbandStartFromRC && this.myTarget.isFFNavRouteCalcAdjustRoute()) {
                    this.myTarget.isRubberbandStartFromRC = false;
                    this.quitModelWaitState();
                } else {
                    this.myTarget.traceState(this, "Not quitting wait-state...");
                    this.myTarget.traceState(this, new StringBuffer("target.isRubberbandStartFromRC: ").append(this.myTarget.isRubberbandStartFromRC).toString());
                    this.myTarget.traceState(this, new StringBuffer("target.isFFNavRouteCalcAdjustRoute(): ").append(this.myTarget.isFFNavRouteCalcAdjustRoute()).toString());
                }
                this.addTourListToLastDestinationsList();
                this.myTarget.traceState(this, "Trans: myTarget.stateGuidanceActiveIdle");
                this.trans(this.myTarget.stateGuidanceActiveIdle);
            } else {
                this.myTarget.traceState(this, "Trans: myTarget.stateGuidanceNotActive");
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
            this.trans(this.myTarget.stateCalculationAbortedAndStopped);
        }
        return this.myParent;
    }

    private void quitModelWaitState() {
        this.myTarget.traceState(this, "quitModelWaitState()");
        ServiceManager.aslPropertyManager.valueChangedInteger(3019, 0);
    }
}

