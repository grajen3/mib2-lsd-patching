/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.states;

import de.vw.mib.asl.api.online.ASLOnlineFactory;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapController;
import de.vw.mib.asl.internal.trafficminimap.control.TrafficMiniMapManager;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapStateActive$1;
import de.vw.mib.asl.internal.trafficminimap.states.TrafficMiniMapTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.trafficminimap.transformer.TrafficMiniMapLastRequestedMapDataCollector;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;

public class TrafficMiniMapStateActive
extends AbstractHsmState {
    private final TrafficMiniMapTarget _target;
    private final String _classname;

    public TrafficMiniMapStateActive(TrafficMiniMapTarget trafficMiniMapTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this._classname = "TrafficMiniMapStateActive";
        this._target = trafficMiniMapTarget;
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append("TrafficMiniMapStateActive").append(".TrafficMiniMapStateActive()").log();
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
                this.getController().startUp();
                break;
            }
            case 4: {
                break;
            }
            case 4800009: {
                boolean bl = ASLOnlineFactory.getOnlineCoreServices().isServiceConfigured(new TrafficMiniMapStateActive$1(this));
                if (bl) break;
                this.trans(this.getTarget().getStateNotActive());
                break;
            }
            case 1076541830: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateActive").append(".handle(ASLTrafficMiniMapServiceConstants.REQUEST_MAP)").log();
                }
                int n = (int)eventGeneric.getLong(0);
                this.getController().requestResourceInformationForMiniMap(n);
                break;
            }
            case 1076541826: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateActive").append(".handle(ASLTrafficMiniMapServiceConstants.UPDATE_LAST_REQUESTED_MINI_MAP_DATA)").log();
                }
                int n = 0;
                TrafficMiniMapLastRequestedMapDataCollector trafficMiniMapLastRequestedMapDataCollector = TrafficMiniMapManager.getPersistence().getLastRequestedMiniMap();
                if (trafficMiniMapLastRequestedMapDataCollector != null && trafficMiniMapLastRequestedMapDataCollector.trafficminimap_last_requested_map_graphic != null) {
                    n = 1;
                }
                TrafficMiniMapManager.getModelController().updateLastRequestedMiniMap(trafficMiniMapLastRequestedMapDataCollector);
                TrafficMiniMapManager.getModelController().setLastRequestedMiniMap(n);
                TrafficMiniMapManager.getModelController().setMapDataRequestState(4);
                TrafficMiniMapManager.getModelController().setRefreshMapDataRequestState(4);
                break;
            }
            case 1076541832: {
                if (this.getTarget().isTraceEnabled()) {
                    this.getTarget().trace().append("TrafficMiniMapStateActive").append(".handle(ASLTrafficMiniMapServiceConstants.REQUEST_REFRESH_MAP)").log();
                }
                int n = (int)eventGeneric.getLong(0);
                this.getController().requestResourceInformationOnRefresh(n);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    public void dsiAsiaTrafficInfoMenuUpdateActiveInterrupts(Interrupt[] interruptArray, int n) {
        if (n == 1) {
            this.getController().updateActiveInterrupts(interruptArray);
        }
    }

    public void dsiAsiaTrafficInfoMenuUpdateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
        if (n == 1) {
            this.getController().updateTrafficType(trafficInformationArray);
        }
    }

    public void dsiAsiaTrafficInfoMenuRequestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        this.getController().responseResourceInformation(n, resourceInformation);
    }

    public void dsiAsiaTrafficInfoMenuRequestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        this.getController().responseTrafficInformationDetails(n, trafficInformationDetailsArray);
    }
}

