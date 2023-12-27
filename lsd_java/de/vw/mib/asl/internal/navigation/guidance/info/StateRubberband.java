/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class StateRubberband
extends AbstractHsmState {
    private HsmTargetInfo target;

    StateRubberband(HsmTargetInfo hsmTargetInfo, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetInfo;
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
            case 4300052: {
                this.target.traceState(this, "ASL_SYSTEM_VALID_TIME_DATE_AVAILABLE");
                this.updateValues();
                break;
            }
            case 4300051: {
                this.target.traceState(this, "ASL_SYSTEM_MINUTE_TRIGGER");
                this.updateValues();
                break;
            }
            case 4300006: {
                this.target.traceState(this, "ASL_SYSTEM_NEW_DATE_TIME");
                this.updateValues();
                break;
            }
            case 3497001: 
            case 3497002: {
                this.target.traceState(this, "EV_MAP_MAIN_RUBBERBAND_MANIPULATION_CANCEL / START_CALCULATED_ROUTE");
                this.trans(this.target.stateMain);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiNavigationUpdateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgCalculatedRoutes()");
        this.target.calculatedRouteListElements = calculatedRouteListElementArray;
        this.updateValues();
    }

    private void updateValues() {
        if (this.target.calculatedRouteListElements != null && this.target.calculatedRouteListElements.length > 0 && this.target.calculatedRouteListElements[0].calculationPercentage == 100 && this.target.calculatedRouteListElements[0].calculationState == 3) {
            int n = (int)this.target.calculatedRouteListElements[0].eta;
            int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttHours(n);
            int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateRttMinutes(n);
            int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateEta(n2, n3, ASLSystemFactory.getSystemApi().getCurrentTime());
            this.target.statusLineCollector.navigation_guidance_status_line_information_etad = nArray[2];
            this.target.statusLineCollector.navigation_guidance_status_line_information_etah = nArray[0];
            this.target.statusLineCollector.navigation_guidance_status_line_information_etam = nArray[1];
            this.target.statusLineCollector.navigation_guidance_status_line_information_rtth = n2;
            this.target.statusLineCollector.navigation_guidance_status_line_information_rttm = n3;
            this.target.statusLineCollector.navigation_guidance_status_line_information_rtt_milliseconds = n;
            this.target.statusLineCollector.navigation_guidance_status_line_information_dtd = (int)this.target.calculatedRouteListElements[0].distance;
            this.target.updateStatusLine();
        }
    }
}

