/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilAPI;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;

public class StateWaypointMode
extends AbstractHsmState {
    private HsmTargetInfo target;
    private ASLNavigationUtilAPI aslNavigationUtilAPI;

    StateWaypointMode(HsmTargetInfo hsmTargetInfo, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetInfo;
        this.aslNavigationUtilAPI = ASLNavigationUtilFactory.getNavigationUtilApi();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.initGetterGroupDefaults();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 3497012: {
                this.target.traceState(this, "EV_GUIDANCE_WPM_LEAVE");
                this.trans(this.target.stateMain);
                break;
            }
            case 3497014: {
                this.target.traceState(this, "EV_GUIDANCE_WPM_RECORD_STARTED");
                this.wpmRecordModeStarted();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void wpmRecordModeStarted() {
        this.target.traceState(this, "wpmRecordModeStarted()");
        NavLocation navLocation = this.aslNavigationUtilAPI.getNavigationDp().getWpmLocation();
        this.target.initInternalAPIDataForWPM(navLocation != null && navLocation.positionValid);
        PosPosition posPosition = this.aslNavigationUtilAPI.getNavGateway().getSoPosPosition();
        if (posPosition != null) {
            this.target.traceState(this, "CCP is available -> update RTT/DTD");
            this.calculateRecordModeValues(posPosition);
        } else {
            this.target.traceState(this, "CCP is unavailable");
        }
    }

    private void calculateRecordModeValues(PosPosition posPosition) {
        NavLocation navLocation = this.aslNavigationUtilAPI.getNavigationDp().getWpmLocation();
        if (navLocation != null) {
            if (posPosition != null) {
                ILocationWrapper iLocationWrapper = this.aslNavigationUtilAPI.getLocationWrapper(navLocation);
                int n = this.aslNavigationUtilAPI.getNaviHelper().calculateDistance(posPosition.getLongitude(), posPosition.getLatitude(), iLocationWrapper.getLongitude(), iLocationWrapper.getLatitude());
                int n2 = this.calculateSpeed(6, n);
                int n3 = this.aslNavigationUtilAPI.getNaviHelper().calculateRttHours(n2);
                int n4 = this.aslNavigationUtilAPI.getNaviHelper().calculateRttMinutes(n2);
                int[] nArray = this.aslNavigationUtilAPI.getNaviHelper().calculateEta(n3, n4, ASLSystemFactory.getSystemApi().getCurrentTime());
                this.updateModel(n, n2, n3, n4, nArray);
            } else {
                this.target.traceState(this, "CCP is unavailable");
            }
        } else {
            this.target.traceState(this, "WPM location is unavailable");
        }
    }

    private void updateModel(int n, int n2, int n3, int n4, int[] nArray) {
        this.target.statusLineCollector.navigation_guidance_status_line_information_etad = nArray[2];
        this.target.statusLineCollector.navigation_guidance_status_line_information_etah = nArray[0];
        this.target.statusLineCollector.navigation_guidance_status_line_information_etam = nArray[1];
        this.target.statusLineCollector.navigation_guidance_status_line_information_rtth = n3;
        this.target.statusLineCollector.navigation_guidance_status_line_information_rttm = n4;
        this.target.statusLineCollector.navigation_guidance_status_line_information_rtt_milliseconds = n2;
        this.target.statusLineCollector.navigation_guidance_status_line_information_dtd = n;
        if (this.target.aslGuidanceInfo[1] != null) {
            this.target.aslGuidanceInfo[1].setDestinationType(1);
            this.target.aslGuidanceInfo[1].setEtaDays(nArray[2]);
            this.target.aslGuidanceInfo[1].setEtaHours(nArray[0]);
            this.target.aslGuidanceInfo[1].setEtaMinutes(nArray[1]);
            this.target.aslGuidanceInfo[1].setRttHours(n3);
            this.target.aslGuidanceInfo[1].setRttMinutes(n4);
            this.target.aslGuidanceInfo[1].setRttMilliseconds(n2);
            this.target.aslGuidanceInfo[1].setDistance(n);
        }
        this.target.updateStatusLine();
        if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.target.getSubClassifier());
            logMessage.append("STATUSLINE INFO : etad=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_etad);
            logMessage.append(", etah=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_etah);
            logMessage.append(", etam=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_etam);
            logMessage.append(", rtth=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_rtth);
            logMessage.append(", rttm=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_rttm);
            logMessage.append(", rttms=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_rtt_milliseconds);
            logMessage.append(", dtd=");
            logMessage.append(this.target.statusLineCollector.navigation_guidance_status_line_information_dtd);
            logMessage.log();
        }
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgActive");
        this.target.rgActive = bl;
        if (bl) {
            if (this.aslNavigationUtilAPI.getNavigationDp().getWpmMode() == 2) {
                this.wpmRecordModeStarted();
            }
        } else {
            this.target.initGetterGroupDefaults();
        }
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgInfoForNextDestination()");
        if (this.aslNavigationUtilAPI.getNavigationDp().getWpmMode() == 1) {
            this.target.infoForNextDestination = rgInfoForNextDestination;
            if (this.target.infoForNextDestination != null) {
                int n2 = (int)(this.target.infoForNextDestination.timeToNextDest * 0);
                if (n2 < 0) {
                    this.target.error().append("HsmTargetInfo.StateWaypointMode.dsiNavigationUpdateRgInfoForNextDestination -> RTT=").append(n2).log();
                    n2 = 0;
                }
                int n3 = this.aslNavigationUtilAPI.getNaviHelper().calculateRttHours(n2);
                int n4 = this.aslNavigationUtilAPI.getNaviHelper().calculateRttMinutes(n2);
                int[] nArray = this.aslNavigationUtilAPI.getNaviHelper().calculateEta(n3, n4, ASLSystemFactory.getSystemApi().getCurrentTime());
                if (ServiceManager.logger2.isTraceEnabled(this.target.getSubClassifier())) {
                    LogMessage logMessage = ServiceManager.logger2.trace(this.target.getSubClassifier());
                    logMessage.append("StateWaypointMode: rttMsStopOver=");
                    logMessage.append(n2);
                    logMessage.append(", rttHoursStopOver=");
                    logMessage.append(n4);
                    logMessage.append(", rttMinutesStopOver=");
                    logMessage.append(n4);
                    logMessage.append(", etaStopOver H=");
                    logMessage.append(nArray[0]);
                    logMessage.append(", etaStopOver M=");
                    logMessage.append(nArray[0]);
                    logMessage.log();
                }
                this.updateModel((int)this.target.infoForNextDestination.distanceToNextDest, n2, n3, n4, nArray);
            }
        }
    }

    public void dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        NavLocation navLocation;
        this.target.traceState(this, "dsiNavigationUpdateSoPosPosition()");
        if (this.aslNavigationUtilAPI.getNavigationDp().getWpmMode() == 2 && (navLocation = this.aslNavigationUtilAPI.getNavigationDp().getWpmLocation()) != null && posPosition != null) {
            this.calculateRecordModeValues(posPosition);
        }
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCurrentRoute()");
        this.target.currentRoute = route;
        this.target.initInternalAPIData();
    }

    public int calculateSpeed(int n, int n2) {
        return -2131872256 / (n * 1000) * n2;
    }
}

