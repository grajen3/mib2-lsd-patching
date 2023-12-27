/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.vza.Events;
import de.vw.mib.asl.internal.navigation.guidance.vza.HsmTargetVZA;
import de.vw.mib.asl.internal.navigation.guidance.vza.Services;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.cardriverassistance.TSDSignFct;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class StateWork
extends AbstractHsmState {
    private HsmTargetVZA target;
    private int trafficSignMode = -1;
    private TrafficSignInformation info;
    private TSDSignFct sign1;
    private TSDSignFct sign2;
    private TSDSignFct sign3;
    private TSDViewOptions tSDViewOptions;

    StateWork(HsmTargetVZA hsmTargetVZA, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetVZA;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState("HSM_ENTRY ");
                break;
            }
            case 101001: {
                this.target.traceState("NAVI_TARGET_GO_ON");
                Events.addObservers(this.target);
                this.target.services = new Services(this.target);
                this.target.initEmptyList();
                break;
            }
            case 4: {
                this.target.traceState("HSM_EXIT");
                Events.removeObservers(this.target);
                break;
            }
            case 2100006: {
                this.target.traceState("ASL_CAR_TRAFFIC_SIGN ");
                this.trafficSignMode = eventGeneric.getInt(0);
                ServiceManager.aslPropertyManager.valueChangedBoolean(2406, this.trafficSignMode != 0);
                this.target.traceState(new StringBuffer().append("ASL_CAR_TRAFFIC_SIGN mode: ").append(this.trafficSignMode).toString());
                this.updateAfterInit();
                break;
            }
            case 4300004: {
                this.target.traceState("ASL_SYSTEM_POWERMANAGEMENT_CLAMPSTATE_15 ");
                this.target.initEmptyList();
                break;
            }
            case 2100010: {
                this.target.traceState("ASL_CAR_TRAFFIC_SIGN_TRAILER_ASSIST ");
                this.handleTrafficSignTrailerAssist(eventGeneric);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    void updateAfterInit() {
        this.target.traceState("updateAfterInit");
        if (this.sign1 != null) {
            this.dsiCarDriverAssistanceUpdateTSDSign1(this.sign1, 1);
        }
        if (this.sign2 != null) {
            this.dsiCarDriverAssistanceUpdateTSDSign2(this.sign2, 1);
        }
        if (this.sign3 != null) {
            this.dsiCarDriverAssistanceUpdateTSDSign3(this.sign3, 1);
        }
        if (this.tSDViewOptions != null) {
            this.dsiCarDriverAssistanceUpdateTSDViewOptions(this.tSDViewOptions, 1);
        }
        if (this.info != null) {
            this.dsiTrafficRegulationUpdateCurrentTrafficSign(this.info, 1);
        }
    }

    void handleTrafficSignTrailerAssist(EventGeneric eventGeneric) {
        this.target.traceState("handleTrafficSignTrailerAssist()");
        if (this.target.services.getDsiTrafficRegulation() != null) {
            boolean bl = eventGeneric.getBoolean(0);
            this.target.services.getDsiTrafficRegulation().setTrailerStatus(bl);
        } else {
            this.target.traceState("DSITrafficRegulation service is null");
        }
    }

    public void dsiTrafficRegulationUpdateCurrentTrafficSign(TrafficSignInformation trafficSignInformation, int n) {
        this.target.traceState("dsiTrafficRegulationUpdateCurrentTrafficSign()");
        this.info = trafficSignInformation;
        if (this.trafficSignMode == 1) {
            this.target.traceState("dsiTrafficRegulationUpdateCurrentTrafficSign() -- Country Dependent VZEVZA");
            this.target.vzaHandlingUG.updateCurrentTrafficSign(trafficSignInformation);
        } else {
            this.traceTrafficSignMode();
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDSign1(TSDSignFct tSDSignFct, int n) {
        this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign1()");
        this.sign1 = tSDSignFct;
        if (this.trafficSignMode == 2) {
            this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign1() -- Country Dependent VZEVZA");
            this.target.vzeHandlingUG.updateTSDSign1(tSDSignFct);
        } else {
            this.traceTrafficSignMode();
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDSign2(TSDSignFct tSDSignFct, int n) {
        this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign2()");
        this.sign2 = tSDSignFct;
        if (this.trafficSignMode == 2) {
            this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign2() -- Country Dependent VZEVZA");
            this.target.vzeHandlingUG.updateTSDSign2(tSDSignFct);
        } else {
            this.traceTrafficSignMode();
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDSign3(TSDSignFct tSDSignFct, int n) {
        this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign3()");
        this.sign3 = tSDSignFct;
        if (this.trafficSignMode == 2) {
            this.target.traceState("dsiCarDriverAssistanceUpdateTSDSign3() -- Country Dependent VZEVZA");
            this.target.vzeHandlingUG.updateTSDSign3(tSDSignFct);
        } else {
            this.traceTrafficSignMode();
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        this.target.traceState("dsiCarDriverAssistanceUpdateTSDViewOptions()");
        this.tSDViewOptions = tSDViewOptions;
        if (this.trafficSignMode == 2 && tSDViewOptions != null && tSDViewOptions.systemOnOff != null && tSDViewOptions.systemOnOff.state != 2) {
            this.target.traceState("tSDViewOptions.systemOnOff.state != VIEWOPTIONSTATE_NORMAL_OPERATION -> Clear VZE signs! ");
            this.target.initEmptyList();
        }
    }

    private void traceTrafficSignMode() {
        switch (this.trafficSignMode) {
            case 1: {
                this.target.traceState(new StringBuffer("ASL_CAR_TRAFFIC_SIGN mode: ASLCarAPI.ASL_NAVIGATION_TRAFFIC_SIGN_VZA: ").append(this.trafficSignMode).toString());
                break;
            }
            case 2: {
                this.target.traceState(new StringBuffer("ASL_CAR_TRAFFIC_SIGN mode: ASLCarAPI.ASL_NAVIGATION_TRAFFIC_SIGN_VZE: ").append(this.trafficSignMode).toString());
                break;
            }
            default: {
                this.target.traceState(new StringBuffer("ASL_CAR_TRAFFIC_SIGN mode: NEITHER VZA OR VZE: ").append(this.trafficSignMode).toString());
            }
        }
    }

    public void dsiCarDriverAssistanceUpdateTSDSystemOnOff(boolean bl, int n) {
        this.target.traceState("dsiCarDriverAssistanceUpdateTSDSystemOnOff()");
        if (this.trafficSignMode == 2 && !bl) {
            this.target.initEmptyList();
        }
    }
}

