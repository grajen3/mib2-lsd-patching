/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.destinput.TourList;
import de.vw.mib.asl.internal.navigation.guidance.main.Events;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteProperties;

public class StateWork
extends AbstractHsmState {
    private final HsmTargetGuidance myTarget;

    StateWork(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.traceState(this, "HSM_ENTRY");
                this.myTarget.navigationDp = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
                this.myTarget.isFeatHigh = ServiceManager.configManagerDiag.isFeatureFlagSet(70);
                this.myTarget.setIsFFNavRouteCalcAdjustRoute();
                boolean bl = Boolean.valueOf(System.getProperty("de.vw.mib.asl.navigation.wpm.clusterManeuver", "true"));
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmClusterShowmaneuver(bl);
                ASLSystemFactory.getSystemApi().getPowerStateService().addListener(this.myTarget);
                this.myTarget.powerState = ASLSystemFactory.getSystemApi().getPowerStateService().getPowerState();
                break;
            }
            case 3: {
                this.myTarget.traceState(this, "HSM_START");
                break;
            }
            case 101001: {
                this.myTarget.traceState(this, "NAVI_TARGET_GO_ON");
                this.myTarget.initDSI();
                Events.addObservers(this.myTarget);
                this.myTarget.rcProgressHandling.resetDefaults();
                this.trans(this.myTarget.stateGuidanceResumePending);
                break;
            }
            case 4: {
                this.myTarget.traceState(this, "HSM_EXIT");
                Events.removeObservers(this.myTarget);
                break;
            }
            case 0x40000224: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_STOP");
                this.trans(this.myTarget.stateCalculationAbortedAndStopped);
                break;
            }
            case 1073743954: {
                this.myTarget.traceState(this, "ASL_NAVIGATION_GUIDANCE_ABORT_AND_STOP");
                this.trans(this.myTarget.stateCalculationAbortedAndStopped);
                break;
            }
            case 0x355C33: {
                this.myTarget.traceState(this, "EV_GUIDANCE_WPM_ENTER");
                this.myTarget.traceState(this, "GUIDANCE_MODE -> GUIDANCE_MODE_WAYPOINT");
                this.myTarget.updateGuidanceMode(1);
                break;
            }
            case 3497012: {
                this.myTarget.traceState(this, "EV_GUIDANCE_WPM_LEAVE");
                this.myTarget.traceState(this, "GUIDANCE_MODE -> GUIDANCE_MODE_NORMAL");
                this.myTarget.updateGuidanceMode(0);
                break;
            }
            case 100108: {
                int n = eventGeneric.getInt(0);
                this.handleTriggerAudioEventFromExtern(n);
                break;
            }
            case 1074841968: {
                boolean bl = eventGeneric.getBoolean(0);
                this.myTarget.traceState(this, new StringBuffer("SET_EXTERNAL_DESTINATION_TOUR: ").append(bl).toString());
                ServiceManager.aslPropertyManager.valueChangedBoolean(-1678766080, bl);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleTriggerAudioEventFromExtern(int n) {
        this.myTarget.services.getNavigation().triggerEventAudioMessage(n);
    }

    public void dsiNavigationUpdateRmPersistentRoute(Route route, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRmPersistentRoute");
        this.myTarget.myPersistentRoute = route;
    }

    public void dsiNavigationTriggerEventAudioMessageResult(int n) {
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1079784704);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    public void dsiNavigationRgNotPossible(int n) {
        this.myTarget.traceState(this, "dsiNavigationRgNotPossible");
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(802, 1);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(802, 5);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(802, 6);
                break;
            }
        }
        try {
            this.trans(this.myTarget.stateCalculationError);
        }
        catch (Exception exception) {
            this.myTarget.error(new StringBuffer("StateWork.dsiNavigationRgNotPossible: ").append(exception.getMessage()).toString());
        }
    }

    public void dsiNavigationUpdateRgRouteProperties(RouteProperties routeProperties, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgRouteProperties");
        if (routeProperties.isolatedMapArea) {
            ServiceManager.aslPropertyManager.valueChangedInteger(802, 2);
        }
        if (routeProperties.restrictedArea) {
            ServiceManager.aslPropertyManager.valueChangedInteger(802, 3);
        }
    }

    public void dsiNavigationUpdateEtcDemoModeState(boolean bl, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateEtcDemoModeState");
        this.myTarget.southsideIsInDemoMode = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(2763, bl);
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.myTarget.traceState(this, "dsiNavigationUpdateRgCurrentRoute");
        if (route != null && route.routelist != null && route.routelist.length > 0) {
            if (this.myTarget.navigationDp.getGuidanceType() != 2) {
                this.myTarget.traceState(this, "Current route will be persisted!");
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setCurrentRoute(route);
                this.myTarget.aslNavGuidanceDP.setCurrentRoute(route);
                this.myTarget.getDsiNavigation().rmMakeRoutePersistent(route);
                TourList.getInstance().updateCurrentRoute(route);
            } else {
                this.myTarget.traceState(this, "Current route is a PNav Route and will NOT be persisted!");
                this.myTarget.aslNavGuidanceDP.setCurrentRoute(null);
            }
            boolean bl = false;
            for (int i2 = 0; i2 < route.getRoutelist().length; ++i2) {
                if (bl || route.getRoutelist()[i2].destinationType != 2) continue;
                bl = true;
            }
            if (!bl) {
                this.notifyRubberBandPointUnavailable();
                this.notifyRouteSegmentViaPointFalse();
            }
        }
    }

    public void dsiNavigationUpdateNavstateOfOperation(int n, int n2) {
        this.myTarget.traceState(this, "dsiNavigationUpdateNavstateOfOperation");
        switch (n) {
            case 1: 
            case 2: 
            case 4: 
            case 6: 
            case 7: {
                ServiceManager.aslPropertyManager.valueChangedInteger(802, 0);
                break;
            }
        }
    }

    public void notifyRubberBandPointUnavailable() {
        this.myTarget.trace("notifyRubberBandPointUnavailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, false);
    }

    public void notifyRubberBandPointAvailable() {
        this.myTarget.trace("notifyRubberBandPointAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(435163136, true);
    }

    public void notifyRouteSegmentViaPointFalse() {
        this.myTarget.trace("notifyRouteSegmentViaPointFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(451940352, false);
    }

    public void notifyRouteSegmentViaPointTrue() {
        this.myTarget.trace("notifyRouteSegmentViaPointTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(451940352, true);
    }
}

