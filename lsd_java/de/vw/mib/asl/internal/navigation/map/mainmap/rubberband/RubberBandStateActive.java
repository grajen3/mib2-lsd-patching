/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RubberBandStateActive
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[RubberBandStateActive]");
    private final RubberBandHsmTarget target;
    boolean overviewValueBeforeRubberband = false;

    public RubberBandStateActive(RubberBandHsmTarget rubberBandHsmTarget, String string, HsmState hsmState) {
        super(rubberBandHsmTarget.getHsm(), string, hsmState);
        this.target = rubberBandHsmTarget;
    }

    public HsmState dsiMapViewerControlAsyncException(int n, String string, int n2) {
        this.logger.makeError().append("dsiMapViewerControlAsyncException(errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).log();
        return null;
    }

    public HsmState dsiMapViewerControlUpdateDragRoutePosition(NavLocationWgs84 navLocationWgs84, int n) {
        this.logger.trace("dsiMapViewerControlUpdateDragRoutePosition()");
        if (this.target.datapool.isDragRoute()) {
            this.target.notifierDSI.rgSetRubberbandPosition(navLocationWgs84);
        }
        return null;
    }

    public HsmState dsiNavigationAsyncException(int n, String string, int n2) {
        this.logger.makeError().append("dsiNavigationAsyncException(errorCode=").append(n).append(", errorMsg=").append(string).append(", requestType=").append(n2).log();
        return null;
    }

    public HsmState dsiNavigationRgGetRouteBoundingRectangleResult(NavRectangle navRectangle, int n) {
        this.logger.trace("dsiNavigationRgGetRouteBoundingRectangleResult()");
        this.target.datapool.setBoundingRectangle(navRectangle);
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setMapViewPortByWGS84Rectangle(navRectangle, 5);
        this.target.notifierModel.notifyLoadingStatusComplete();
        this.target.notifierDSI.viewFreeze(false);
        return null;
    }

    public HsmState dsiNavigationRgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        this.logger.trace("dsiNavigationRgGetRubberBandPointPositionResult()");
        if (bl) {
            this.target.notifierModel.notifyRubberBandPointAvailable();
            this.target.notifierModel.notifyRouteSegmentViaPointTrue();
            this.target.notifierDSI.setDragRouteMarker(1);
            this.target.notifierDSI.startRouteDragging(navLocationWgs84);
        } else {
            this.target.notifierModel.notifyRubberBandPointUnavailable();
            this.target.notifierModel.notifyRouteSegmentViaPointFalse();
        }
        this.target.datapool.setPositionOnRoute(navLocationWgs84);
        return null;
    }

    public HsmState dsiNavigationRgStartRubberbandManipulationResult(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiNavigationRgStartRubberbandManipulationResult(resultCode=").append(n).log();
        }
        this.target.datapool.setRgStartRubberbandManipulationResult(n);
        return null;
    }

    public HsmState dsiNavigationUpdateRgActive(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiNavigationUpdateRgActive(rgActive=").append(bl).append(", validFlag=").append(n).append(")").log();
        }
        return null;
    }

    public HsmState dsiNavigationUpdateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray, int n) {
        this.logger.trace("dsiNavigationUpdateRgCalculatedRoutes");
        this.target.datapool.setCalculatedRoutes(calculatedRouteListElementArray);
        return null;
    }

    public HsmState dsiNavigationUpdateRgRouteCalculationState(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiNavigationUpdateRgRouteCalculationState(rgRouteCalculationState=").append(n).append(")").log();
        }
        this.target.datapool.setRgRouteCalculcationState(n);
        if (n == 2) {
            this.target.notifierDSI.rgGetRouteBoundingRectangle(true, 0);
        } else if (n != 3) {
            this.target.notifierModel.notifyRouteAdjustedFalse();
        }
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle(event=").append(eventGeneric).append(")").log();
        }
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
                this.handleStart();
                break;
            }
            case 1074841840: {
                this.handleSetClickInMap(eventGeneric);
                break;
            }
            case 1074841841: {
                this.handleRestoreMap();
                break;
            }
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 3499036: {
                this.handleZoomLevelChangedByUser();
                break;
            }
            case 1074841842: {
                this.handleDeleteViaPoint();
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
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleDeleteViaPoint() {
        this.logger.trace("handleDeleteViaPoint()");
        this.target.notifierDSI.setDragRouteMarker(0);
        this.target.notifierDSI.rgDeleteCalculatedRubberbandPoint();
        this.target.notifierModel.notifyRubberBandPointUnavailable();
        this.target.notifierModel.notifyRouteSegmentViaPointFalse();
        this.target.notifierModel.notifyRouteAdjustedTrue();
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.target.datapool.isNeedsRubberbandStart()) {
            this.target.datapool.setNeedsRubberbandStart(false);
            this.target.notifierModel.notifyLoadingStatusLoading();
            this.target.notifierModel.notifyRubberBandPointUnavailable();
            this.target.notifierModel.notifyRouteSegmentViaPointFalse();
            ASLNavigationGuidanceFactory.getNavigationGuidanceApi().sendEvMapMainRubberbandManipulationStart();
            this.target.notifierDSI.rgPrepareRubberbandManipulation(true);
            this.target.notifierDSI.rgStartRubberbandManipulation(0);
        } else {
            this.target.notifierDSI.rgGetRouteBoundingRectangle(true, 0);
        }
        this.target.notifierDSI.rgGetRubberBandPointPosition();
        this.target.notifierModel.notifyMapMovedFalse();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.overviewValueBeforeRubberband) {
            this.target.notifierModel.notifyOverviewZoomOn();
        } else {
            this.target.notifierModel.notifyOverviewZoomOff();
        }
    }

    private void handleRestoreMap() {
        this.logger.trace("handleRestoreMap()");
        this.target.notifierDSI.setMapViewPortByWGS84Rectangle(this.target.datapool.getBoundingRectangle(), 5);
        this.target.notifierModel.notifyMapMovedFalse();
    }

    private HsmState handleSetClickInMap(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        this.target.datapool.setOneFingerClickX(n);
        this.target.datapool.setOneFingerClickY(n2);
        int n3 = eventGeneric.getInt(0);
        switch (n3) {
            case 0: {
                this.handleSetClickInMapPressed();
                break;
            }
            case 1: {
                this.handleSetClickInMapDragged();
                break;
            }
            case 2: {
                this.handleSetClickInMapReleased();
                break;
            }
            case 3: {
                this.handleSetClickInMapReleased();
                break;
            }
        }
        return null;
    }

    private void handleSetClickInMapDragged() {
        this.logger.trace("handleSetClickInMapDragged()");
        if (this.target.datapool.isDragRoute()) {
            this.target.transStateDragRoute();
        } else {
            this.target.transStateDragMap();
        }
    }

    private void handleSetClickInMapPressed() {
        this.logger.trace("handleSetClickInMapPressed()");
        this.target.transStatePressed();
    }

    private void handleSetClickInMapReleased() {
        this.logger.trace("handleSetClickInMainMapActionTypeC2Released()");
        if (this.target.datapool.isDragRoute()) {
            this.target.notifierDSI.setDragRouteMarker(1);
        }
        this.target.datapool.setDragRoute(false);
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content=").append(n).log();
        }
        if (n == 36) {
            this.target.transStateRubberBandInactive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.overviewValueBeforeRubberband = this.target.datapool.isPerspectiveOverviewZoom();
        this.target.notifierModel.notifyOverviewZoomOn();
    }

    private void handleZoomLevelChangedByUser() {
        this.logger.trace("handleZoomLevelChangedByUser()");
        this.target.notifierModel.notifyMapMovedTrue();
    }
}

