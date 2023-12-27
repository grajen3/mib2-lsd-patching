/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.guidance.ASLNavGuidanceDP;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class StateGuidanceActive
extends AbstractHsmState {
    private static final long INVALID_DISTANCE;
    private final HsmTargetGuidance myTarget;
    private long firstDistToFinalDestInRadius = -1L;
    private Route rgCurrentRoute;
    private RgInfoForNextDestination rgInfoForNextDestination;
    private NavRouteListData[] rgDestinationInfo;

    StateGuidanceActive(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 4: {
                ASLNavGuidanceDP.getInstance().setVoicePromptRequired(true);
                break;
            }
            case 100102: {
                this.myTarget.traceState(this, "EV_ASL_INT_TRIGGER_ROUTE_RECALCULATION");
                this.trans(this.myTarget.statePendingGuidanceStop);
                this.myTarget.triggerMe(PersistedGuidanceSetup.getInstance().getLastGuidanceMode());
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
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_START...");
                this.trans(this.myTarget.statePendingGuidanceStop);
                this.myTarget.triggerMe(eventGeneric.getReceiverEventId());
                break;
            }
            case 1073742342: 
            case 0x40000224: {
                this.myTarget.traceState(this, "ABORT/STOP");
                this.myTarget.triggerIt(1397429248, 75956480);
                this.trans(this.myTarget.statePendingGuidanceStop);
                this.myTarget.infoState(this, "Guidance has been stopped -> store guidance stop time");
                this.myTarget.storeTimestamp();
                break;
            }
            case 4300042: {
                this.myTarget.traceState(this, "ASL_SYSTEM_SHUTDOWN_IMMINENT");
                if (!this.isFinalDestinationRadiusReached()) break;
                this.myTarget.traceState(this, "setWasGuidanceActive set value: false");
                PersistedGuidanceSetup.getInstance().setWasGuidanceActive(false, true);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination()");
        if (n == 1 && this.isHIGH() && this.myTarget.isSouthsideInDemoMode() && rgInfoForNextDestination != null && this.myTarget.isRouteValid()) {
            this.rgInfoForNextDestination = rgInfoForNextDestination;
            long l = this.rgInfoForNextDestination != null && this.rgDestinationInfo != null && this.rgCurrentRoute != null ? ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getLastDestinationDistance(this.rgInfoForNextDestination, this.rgDestinationInfo, this.rgCurrentRoute) : ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getLastDestinationDistance();
            this.myTarget.traceState(this, new StringBuffer("Distance to final dest: ").append(l).append(", first in radius: ").append(this.firstDistToFinalDestInRadius).toString());
            if (this.firstDistToFinalDestInRadius >= 0L && l > this.firstDistToFinalDestInRadius) {
                this.myTarget.updateGuidanceState(1);
                this.firstDistToFinalDestInRadius = -1L;
            }
            if (this.firstDistToFinalDestInRadius < l && l <= 0 && l > 0L) {
                this.firstDistToFinalDestInRadius = l;
                this.myTarget.traceState(this, new StringBuffer("New point in destination reached radius detected on distance: ").append(this.firstDistToFinalDestInRadius).toString());
                this.myTarget.traceState(this, "Final destination reached");
                this.myTarget.setFinalDestinationReached();
                this.myTarget.updateGuidanceState(0);
            }
        }
    }

    private boolean isHIGH() {
        return ServiceManager.configManagerDiag.isFeatureFlagSet(70);
    }

    private boolean isFinalDestinationRadiusReached() {
        this.myTarget.traceState(this, "isFinalDestinationReached()");
        boolean bl = false;
        INavGateway iNavGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
        Route route = iNavGateway.getRgCurrentRoute();
        if (route != null) {
            if (route.routelist != null && route.routelist.length > 0) {
                if (route.indexOfCurrentDestination >= 0L && route.indexOfCurrentDestination < (long)route.routelist.length) {
                    if (route.indexOfCurrentDestination == (long)(route.routelist.length - 1)) {
                        if (iNavGateway.getRgInfoForNextDestination().distanceToNextDest <= 0) {
                            bl = true;
                        } else {
                            this.myTarget.traceState(this, new StringBuffer("Distance to final destination is > ").append(50).toString());
                        }
                    } else {
                        this.myTarget.traceState(this, "Current route.indexOfCurrentDestination is not the final destination!");
                    }
                } else {
                    this.myTarget.traceState(this, "Current route.indexOfCurrentDestination is out of range!");
                }
            } else {
                this.myTarget.traceState(this, "Current route.routeList  is null or empty!");
            }
        } else {
            this.myTarget.traceState(this, "Current route is null!");
        }
        return bl;
    }

    private void deactivateDemoMode() {
        this.myTarget.traceState(this, "deactivateDemoMode()");
        try {
            this.myTarget.traceState(this, "Demo Mode: changing from active to inactive");
            this.myTarget.getMainObject().getServiceRegister().triggerObserver(0x24020040);
        }
        catch (Exception exception) {
            this.myTarget.error(new StringBuffer("HsmTargetGuidance StateGuidanceActive.dsiGeneralVehicleStatesUpdateESPData: ").append(exception.getMessage()).toString());
        }
    }

    public HsmState dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.traceState(this, "dsiNavigationUpdateNavstateOfOperation()");
        if (n == 3) {
            this.myTarget.traceState(this, " navstateofoperation is diskrequest eject.");
            if (PersistedGuidanceSetup.getInstance().getLastGuidanceMode() == 520224832) {
                this.deactivateDemoMode();
            } else {
                this.myTarget.traceState(this, "Making transition to StateGuidanceActiveSdCardEject");
                this.trans(this.myTarget.stateGuidanceActiveSdCardEject);
            }
        }
        return this.myParent;
    }

    public void dsiSwdlSelectionUpdateUserSwdl(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiSwdlSelectionUpdateUserSwdl()");
        if (n == 1 && bl && !ServiceManager.configManagerDiag.isFeatureFlagSet(75)) {
            this.myTarget.traceState(this, "SWDL is active -> stop guidance!");
            this.myTarget.getMainObject().getServiceRegister().triggerObserver(0x24020040);
        }
    }

    public HsmState dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgCurrentRoute()");
        this.rgCurrentRoute = route;
        if (route != null && route.routelist != null && route.routelist.length > 0) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(794, ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInWholeRoute(route));
            ServiceManager.aslPropertyManager.valueChangedBoolean(-571469824, ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isIntermediateDestInRoute(route));
        }
        return this.myParent;
    }

    public void dsiNavigationUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgDestinationInfo()");
        this.rgDestinationInfo = navRouteListDataArray;
    }
}

