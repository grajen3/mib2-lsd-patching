/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.poi.ASLNavigationPoiFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.navigation.PosPosition;

public class GPSInputStateInit
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[GPSInputStateInit] ");
    private GPSInputTargetHSM target;

    public GPSInputStateInit(GPSInputTargetHSM gPSInputTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = gPSInputTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        this.logger.trace("dsiMapViewerControlUpdateMapPosition()");
        this.target.notifierDSI.getInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
        return null;
    }

    public HsmState dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        this.logger.trace("dsiMapViewerControlUpdateViewFreeze()");
        if (n == 2) {
            this.logger.trace("dsiMapViewerControlUpdateViewFreeze() validFlag == INVALID");
            return null;
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleHSMStart();
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            case 3499054: {
                this.handleGetInfoForScreenPositionResultAsyncExcetion(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        this.target.updateLocationCurrentByPosInfo(posInfoArray);
        this.target.notifierModel.notifyMapInputLocationChanged();
        this.target.notifierModel.notifyCoordinatesChanged();
        this.target.notifierModel.notifyMapIsReady();
        this.target.transStateMain();
    }

    private void handleGetInfoForScreenPositionResultAsyncExcetion(EventGeneric eventGeneric) {
        this.logger.trace("handleGetInfoForScreenPositionResultAsyncExcetion()");
    }

    private void handleHSMStart() {
        this.logger.trace("handleHSMStart()");
        ILocationWrapper iLocationWrapper = this.initLocationCurrent();
        this.target.updateLocationCurrentAndSendEvent(iLocationWrapper);
        int n = MapViewerUtils.calculateZoomIndexByZoomLevel(4234310);
        this.target.notifierModel.presetZoomLevel(n);
        this.target.notifierModel.notifyCoordinatesChanged();
        this.target.notifierModel.notifyMapInputLocationChanged();
        this.target.notifierModel.notifyActionResultIsOk();
    }

    private ILocationWrapper initLocationCurrent() {
        this.logger.trace("initLocationCurrent()");
        int n = this.target.datapool.getScope();
        if (n == 0) {
            this.initLocationCurrentByCopyLocation();
        } else {
            this.initLocationCurrentByScope();
        }
        return this.target.datapool.getLocationCurrent();
    }

    private void initLocationCurrentByCopyLocation() {
        this.logger.trace("initLocationCurrentByCopyLocation()");
        NavLocation navLocation = this.target.datapool.getMapInputLocation();
        if (navLocation == null) {
            this.logger.warn("The mapInputLocation is null, the defaultLocation will be used instead");
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition.getLatitude(), posPosition.getLongitude()));
        } else if (navLocation.longitude == 0 && navLocation.latitude == 0) {
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition.getLatitude(), posPosition.getLongitude()));
        } else {
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation));
        }
    }

    private void initLocationCurrentByScope() {
        this.logger.trace("initLocationCurrentByScope()");
        int n = this.target.datapool.getScope();
        switch (n) {
            case 1: {
                this.initLocationCurrentByScopeDestinationMap();
                break;
            }
            case 4: {
                this.initLocationCurrentByScopeMapRefinement();
                break;
            }
            case 2: {
                this.initLocationCurrentByScopePoi();
                break;
            }
            case 3: {
                this.initLocationCurrentByScopeSearchArea();
                break;
            }
            case 0: {
                this.initLocationCurrentByScopeUnused();
                return;
            }
            default: {
                this.logger.makeWarn().append("undefined scope: ").append(n);
            }
        }
    }

    private void initLocationCurrentByScopeDestinationMap() {
        this.logger.trace("initLocationCurrentByScopeDestinationMap()");
        NavLocation navLocation = this.target.datapool.getDestInputLocation();
        if (navLocation == null) {
            this.logger.warn("DestInputLocation was null, using PosPosition");
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition));
        } else {
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation));
        }
    }

    private void initLocationCurrentByScopeMapRefinement() {
        this.logger.trace("initLocationCurrentByScopeMapRefinement()");
        NavLocation navLocation = this.target.datapool.getSpellerLocation();
        if (navLocation == null) {
            this.logger.warn("SpellerLocation was null, using PosPosition");
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition));
        } else {
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation));
        }
    }

    private void initLocationCurrentByScopePoi() {
        this.logger.trace("initLocationCurrentByScopePoi()");
        PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
        this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition.latitude, posPosition.longitude));
    }

    private void initLocationCurrentByScopeSearchArea() {
        this.logger.trace("initLocationCurrentByScopeSearchArea()");
        NavLocation navLocation = ASLNavigationPoiFactory.getNavigationPoiApi().getPoiSetup().getLocationForSearchAreaMap();
        if (navLocation == null) {
            this.logger.warn("ReferenceMapPosition was null, using PosPosition");
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition));
        } else {
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation));
        }
    }

    private void initLocationCurrentByScopeUnused() {
        this.logger.warn("initLocationCurrentByScopeUnused()");
        NavLocation navLocation = this.target.datapool.getDestInputLocation();
        if (navLocation == null) {
            this.logger.warn("DestInputLocation was null, using PosPosition");
            PosPosition posPosition = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition();
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(posPosition));
        } else {
            this.target.datapool.setLocationCurrent(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation));
        }
    }
}

