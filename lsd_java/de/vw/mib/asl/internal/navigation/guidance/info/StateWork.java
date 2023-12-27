/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.PersistedGuidanceSetup;
import de.vw.mib.asl.internal.navigation.guidance.info.Events;
import de.vw.mib.asl.internal.navigation.guidance.info.HsmTargetInfo;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;

public class StateWork
extends AbstractHsmState {
    private HsmTargetInfo target;

    StateWork(HsmTargetInfo hsmTargetInfo, Hsm hsm, String string, HsmState hsmState) {
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
                break;
            }
            case 101001: {
                this.target.traceState(this, "NAVI_TARGET_GO_ON");
                Events.addObservers(this.target);
                this.target.initDSI();
                this.target.aslNavigationGuidanceAPI = ASLNavigationGuidanceFactory.getNavigationGuidanceApi();
                this.target.isStatusLineStopOver = PersistedGuidanceSetup.getInstance().isStatusLineInfo();
                this.trans(this.target.stateMain);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                Events.removeObservers(this.target);
                break;
            }
            case 4300001: {
                this.target.traceState(this, "ASL_SYSTEM_GNSS_RECEIVER_SETTING");
                this.updateSatelliteSystem(eventGeneric);
                break;
            }
            case 3497004: {
                this.target.traceState(this, "EV_MAP_MAIN_RUBBERBAND_MANIPULATION_START");
                this.trans(this.target.stateRubberband);
                break;
            }
            case 0x355C33: {
                this.target.traceState(this, "EV_GUIDANCE_WPM_ENTER");
                this.trans(this.target.stateWaypointMode);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    protected void updateSatelliteSystem(EventGeneric eventGeneric) {
        if (eventGeneric.getBoolean(0)) {
            ServiceManager.aslPropertyManager.valueChangedInteger(3835, 2);
            this.target.getGuidanceAPINotifier().sendEvSatelliteSystemUpdate(2);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(3835, 1);
            this.target.getGuidanceAPINotifier().sendEvSatelliteSystemUpdate(1);
        }
    }

    public void dsiNavigationUpdateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        this.target.traceState(this, "dsiNavigationUpdateRgRouteCostChangeInformation()");
        if (rgRouteCostChangeInformation != null && rgRouteCostChangeInformation.newRoute != null && rgRouteCostChangeInformation.oldRoute != null) {
            long l = rgRouteCostChangeInformation.newRoute.distance - rgRouteCostChangeInformation.oldRoute.distance;
            ServiceManager.aslPropertyManager.valueChangedInteger(819, (int)l);
            long l2 = rgRouteCostChangeInformation.newRoute.eta - rgRouteCostChangeInformation.oldRoute.eta;
            ServiceManager.aslPropertyManager.valueChangedInteger(820, (int)l2 / 1625948160);
            this.target.traceState(this, new StringBuffer("deviation distance -> ").append(l).toString());
            this.target.traceState(this, new StringBuffer("deviation rtt -> ").append(l2 / 0).toString());
        }
    }
}

