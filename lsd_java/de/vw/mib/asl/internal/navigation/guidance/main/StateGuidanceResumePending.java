/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.main.GuidanceUtils;
import de.vw.mib.asl.internal.navigation.guidance.main.HsmTargetGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.ASLNavigationGuidancePropertyManager;
import generated.de.vw.mib.asl.internal.navigation.guidance.transformer.NavigationGuidanceSavedGuidanceInfoDetailCollector;
import org.dsi.ifc.navigation.Route;

public class StateGuidanceResumePending
extends AbstractHsmState {
    private long currentTimestamp;
    private int hmiOffTime;
    private final HsmTargetGuidance myTarget;

    StateGuidanceResumePending(HsmTargetGuidance hsmTargetGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = hsmTargetGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.myTarget.infoState(this, "HSM_START");
                this.handleStart();
                break;
            }
            case 100303: {
                this.myTarget.infoState(this, "EV_NAV_IS_COMPLETELY_READY");
                if (!this.isPopUpTrigger()) break;
                this.showResumeGuidancePopUp();
                break;
            }
            case 4300052: {
                this.myTarget.infoState(this, "VALID_TIME_DATE_AVAILABLE");
                this.checkTimeAndTriggerPopUp();
                break;
            }
            case 100103: 
            case 100104: 
            case 100106: 
            case 100107: 
            case 1073742353: 
            case 1073742365: 
            case 1073742366: 
            case 1073742367: 
            case 0x40000220: 
            case 1073742369: 
            case 1073742371: 
            case 0x40000774: 
            case 1073743733: {
                this.myTarget.infoState(this, "START/RESUME received -> StateGuidanceResumePending will be left");
                this.trans(this.myTarget.stateGuidanceNotActive);
                this.myTarget.triggerMe(eventGeneric.getReceiverEventId());
                break;
            }
            case 100105: {
                this.myTarget.infoState(this, "Predictive guidance start triggered -> StateGuidanceResumePending will be left");
                this.trans(this.myTarget.stateGuidanceNotActive);
                this.myTarget.triggerMe(eventGeneric, eventGeneric.getReceiverEventId());
                break;
            }
            case 1074841972: {
                this.myTarget.infoState(this, "CANCEL_RESUME");
                this.trans(this.myTarget.stateGuidanceNotActive);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void handleStart() {
        this.hmiOffTime = -1;
        this.currentTimestamp = -1L;
        if (!PersistedGuidanceSetup.getInstance().getWasGuidanceActive()) {
            this.myTarget.infoState(this, "Guidance was not active before shutdown -> no resume");
            this.enterStateGuidanceNotActiveAndDeleteRoute();
        } else if (GuidanceUtils.wasDemoGuidance()) {
            this.myTarget.infoState(this, "Demo guidance was active before shutdown -> no resume");
            this.enterStateGuidanceNotActiveAndDeleteRoute();
        } else {
            this.checkTimeAndTriggerPopUp();
        }
    }

    private void enterStateGuidanceNotActiveAndDeleteRoute() {
        this.deletePersistentRoute();
        this.trans(this.myTarget.stateGuidanceNotActive);
    }

    private void checkTimeAndTriggerPopUp() {
        this.currentTimestamp = ASLSystemFactory.getSystemApi().getCurrentTimestamp();
        if (GuidanceUtils.isSystemTimestampValid(this.currentTimestamp)) {
            long l = PersistedGuidanceSetup.getInstance().getLastTimeStampBeforeHmiOff();
            if (GuidanceUtils.isNaviTimestampValid(l)) {
                this.hmiOffTime = GuidanceUtils.calculateHmiOffTimeMinutes(this.currentTimestamp, l);
                this.myTarget.infoState(this, new StringBuffer("hmiOffTime: ").append(this.hmiOffTime).append(" min").toString());
                if (this.hmiOffTime >= 0) {
                    if (this.hmiOffTime < 120) {
                        if (this.isPopUpTrigger()) {
                            this.showResumeGuidancePopUp();
                        }
                    } else {
                        this.myTarget.infoState(this, "HMIOff time >= 120 min -> no resume");
                        this.enterStateGuidanceNotActiveAndDeleteRoute();
                    }
                } else {
                    this.myTarget.infoState(this, "HMIOff time < 0 min");
                    this.myTarget.infoState(this, new StringBuffer("Current timestamp: ").append(this.currentTimestamp).append(" lastTimestampBeforeHmiOff: ").append(l).toString());
                    this.enterStateGuidanceNotActiveAndDeleteRoute();
                }
            } else {
                this.myTarget.infoState(this, "No valid timestamp has been set before shutdown -> no resume");
                this.enterStateGuidanceNotActiveAndDeleteRoute();
            }
        } else {
            this.myTarget.infoState(this, "CurrentTimestamp is not set");
        }
    }

    private void showResumeGuidancePopUp() {
        this.myTarget.infoState(this, "showResumeGuidancePopUp");
        int n = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().getExecutionMode();
        if (n == 1) {
            this.myTarget.infoState(this, "Waypointmode is active -> do NOT show resume pop up!");
            this.enterStateGuidanceNotActiveAndDeleteRoute();
        } else {
            this.updateResumeGuidanceInfo();
            this.myTarget.infoState(this, "CL15_OFF_TIME < 120 Min ->  show popup NAVI_ACTIVATE_POPUP_RESTART_GUIDANCE_QUERY!");
            this.myTarget.sendHMIEvent(77);
        }
    }

    private void updateResumeGuidanceInfo() {
        NavigationGuidanceSavedGuidanceInfoDetailCollector navigationGuidanceSavedGuidanceInfoDetailCollector = new NavigationGuidanceSavedGuidanceInfoDetailCollector();
        if (this.myTarget.myPersistentRoute != null && this.myTarget.myPersistentRoute.routelist != null && this.myTarget.myPersistentRoute.routelist.length > 0) {
            int n = this.myTarget.myPersistentRoute.routelist.length - 1;
            ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.myTarget.myPersistentRoute.routelist[n].routeLocation);
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_city = iLocationWrapper.getCity();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_city_refinement = iLocationWrapper.getCityRefinement();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_country_code = iLocationWrapper.getCountryCode();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_crossing = iLocationWrapper.getCrossing();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_hn = iLocationWrapper.getHousenumber();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_street = iLocationWrapper.getStreet();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_street_refinement = iLocationWrapper.getStreetRefinement();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_zip = iLocationWrapper.getPostalCode();
            navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_final_dest_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            if ((long)n > this.myTarget.myPersistentRoute.indexOfCurrentDestination) {
                int n2 = (int)this.myTarget.myPersistentRoute.indexOfCurrentDestination;
                iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(this.myTarget.myPersistentRoute.routelist[n2].routeLocation);
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city = iLocationWrapper.getCity();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city_refinement = iLocationWrapper.getCityRefinement();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_country_code = iLocationWrapper.getCountryCode();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_crossing = iLocationWrapper.getCrossing();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_hn = iLocationWrapper.getHousenumber();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street = iLocationWrapper.getStreet();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street_refinement = iLocationWrapper.getStreetRefinement();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_zip = iLocationWrapper.getPostalCode();
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_for_fix_formatter = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationFormatter().prepareFixFormatterFieldData(iLocationWrapper);
            } else {
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_city_refinement = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_country_code = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_crossing = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_hn = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_street_refinement = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_zip = "";
                navigationGuidanceSavedGuidanceInfoDetailCollector.navigation_guidance_saved_guidance_info_detail_stopover_for_fix_formatter = ASLNavigationGuidancePropertyManager.SAVED_GUIDANCE_INFO_DETAIL__SAVED_GUIDANCE_INFO_DETAIL_STOPOVER_FOR_FIX_FORMATTER__DEFAULT_VALUE;
            }
            ListManager.getGenericASLList(828).updateList(new NavigationGuidanceSavedGuidanceInfoDetailCollector[]{navigationGuidanceSavedGuidanceInfoDetailCollector});
            ServiceManager.aslPropertyManager.valueChangedString(-2031087616, iLocationWrapper.getGpxName());
        }
    }

    public void dsiNavigationUpdateRmPersistentRoute(Route route, int n) {
        this.myTarget.infoState(this, "dsiNavigationUpdateRmPersistentRoute");
        if (n == 1) {
            this.myTarget.myPersistentRoute = route;
            if (this.isPopUpTrigger()) {
                this.showResumeGuidancePopUp();
            }
        } else {
            this.myTarget.infoState(this, "validFlag != ATTRVALIDFLAG_VALID");
        }
    }

    private boolean isPopUpTrigger() {
        this.myTarget.infoState(this, "isPopUpTrigger");
        if (!ASLNavigationStartupFactory.getNavigationStartupApi().isNaviRunning()) {
            this.myTarget.infoState(this, "NavCompletelyReady not received yet");
            return false;
        }
        if (this.myTarget.powerState != 2) {
            this.myTarget.infoState(this, "PowerState != PowerStateService.POWER_STATE_ON");
            return false;
        }
        if (!this.myTarget.isPersistentRouteValid()) {
            this.myTarget.infoState(this, "Persistent route is not valid or available");
            return false;
        }
        if (this.hmiOffTime < 0) {
            this.myTarget.infoState(this, "HMIOff time < 0");
            return false;
        }
        if (ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().isRgActive()) {
            this.myTarget.infoState(this, "Guidance is already active -> no need to trigger resume");
            return false;
        }
        return true;
    }

    private void deletePersistentRoute() {
        this.myTarget.infoState(this, "deletePersistentRoute");
        this.myTarget.getDsiNavigation().rmMakeRoutePersistent(new Route());
    }

    void powerStateSwitchedOn() {
        this.myTarget.infoState(this, "powerStateSwitchedOn");
        this.checkTimeAndTriggerPopUp();
        this.myTarget.getHsm().activateTransition();
    }
}

