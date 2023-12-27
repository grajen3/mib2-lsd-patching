/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.states;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapController;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateNotActive$1;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;

public class TrafficMiniMapStateNotActive
extends AbstractHsmState {
    private final TrafficMiniMapTarget _target;
    private final String _classname;

    public TrafficMiniMapStateNotActive(TrafficMiniMapTarget trafficMiniMapTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._classname = "TrafficMiniMapStateNotActive";
        this._target = trafficMiniMapTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapStateNotActive").append(".TrafficMiniMapStateNotActive()").log();
        }
    }

    private TrafficMiniMapTarget getTarget() {
        return this._target;
    }

    private TrafficMiniMapController getController() {
        return TrafficMiniMapManager.getTrafficMiniMapController();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 4800009: {
                boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceConfigured(new TrafficMiniMapStateNotActive$1(this));
                if (!bl) break;
                this.trans(this.getTarget().getStateActive());
                break;
            }
            case 1076541830: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateNotActive").append(".handle(ASLTrafficMiniMapServiceConstants.REQUEST_MAP)").log();
                }
                TrafficMiniMapManager.getModelController().setMapDataRequestState(3);
                break;
            }
            case 1076541826: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateNotActive").append(".handle(ASLTrafficMiniMapServiceConstants.UPDATE_LAST_REQUESTED_MINI_MAP_DATA)").log();
                }
                TrafficMiniMapManager.getModelController().setLastRequestedMiniMap(0);
                break;
            }
            case 1076541831: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateNotActive").append(".handle(ASLTrafficMiniMapServiceConstants.REQUEST_MAP)").log();
                }
                TrafficMiniMapManager.getModelController().sendSystemEvent(-1830802944);
                break;
            }
            case 1076541832: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateNotActive").append(".handle(ASLTrafficMiniMapServiceConstants.REQUEST_REFRESH_MAP)").log();
                }
                TrafficMiniMapManager.getModelController().setRefreshMapDataRequestState(3);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAsiaTrafficInfoMenuUpdateActiveInterrupts(Interrupt[] interruptArray, int n) {
    }

    public void dsiAsiaTrafficInfoMenuUpdateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.getController().reset();
        TrafficMiniMapManager.getModelController().sendSystemEvent(-1830802944);
    }

    public void dsiAsiaTrafficInfoMenuRequestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        this.getController().reset();
        TrafficMiniMapManager.getModelController().sendSystemEvent(-1830802944);
    }
}

