/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rubberband;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RubberBandDatapool {
    public static final int MINIMAL_ZOOM_INDEX;
    private NavRectangle boundingRectangle;
    private boolean dragRoute;
    private int oneFingerClickX;
    private int oneFingerClickY;
    private NavLocationWgs84 positionOnRoute;
    private CalculatedRouteListElement[] rgCalculatedRoutes;
    private int rgRouteCalculcationState;
    private int rgStartRubberbandManipulationResult;
    private NavLocationWgs84 navLocationStartRouteDragging;
    private final MapDataPool mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    private final MapViewerDatapoolShared datapoolShared = MapViewerDatapoolShared.getInstance();
    private boolean needsRubberbandStart = true;
    private boolean rgActiveTrueReceivedAfterCancelRubberBand;
    private boolean activateRubberBandReceivedWhileWaitingForLastCancel;

    public NavRectangle getBoundingRectangle() {
        return this.boundingRectangle;
    }

    public CalculatedRouteListElement[] getCalculatedRoutes() {
        return this.rgCalculatedRoutes;
    }

    public int getDrageRouteMarker() {
        return this.mapDataPool.getDrageRouteMarker();
    }

    public NavLocationWgs84 getNavLocationStartRouteDragging() {
        return this.navLocationStartRouteDragging;
    }

    public int getOneFingerClickX() {
        return this.oneFingerClickX;
    }

    public int getOneFingerClickY() {
        return this.oneFingerClickY;
    }

    public NavLocationWgs84 getPositionOnRoute() {
        return this.positionOnRoute;
    }

    public CalculatedRouteListElement[] getRgCalculatedRoutes() {
        return this.rgCalculatedRoutes;
    }

    public int getRgRouteCalculcationState() {
        return this.rgRouteCalculcationState;
    }

    public int getRgStartRubberbandManipulationResult() {
        return this.rgStartRubberbandManipulationResult;
    }

    public boolean isActivateRubberBandReceivedWhileWaitingForLastCancel() {
        return this.activateRubberBandReceivedWhileWaitingForLastCancel;
    }

    public boolean isDragRoute() {
        return this.dragRoute;
    }

    public boolean isNeedsRubberbandStart() {
        return this.needsRubberbandStart;
    }

    public boolean isPerspectiveOverviewZoom() {
        return this.datapoolShared.isPerspectiveOverviewZoom();
    }

    public boolean isRgActiveTrueReceivedAfterCancelRubberBand() {
        return this.rgActiveTrueReceivedAfterCancelRubberBand;
    }

    public void setActivateRubberBandReceivedWhileWaitingForLastCancel(boolean bl) {
        this.activateRubberBandReceivedWhileWaitingForLastCancel = bl;
    }

    public void setBoundingRectangle(NavRectangle navRectangle) {
        this.boundingRectangle = navRectangle;
    }

    public void setCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.rgCalculatedRoutes = calculatedRouteListElementArray;
    }

    public void setDragRoute(boolean bl) {
        this.dragRoute = bl;
    }

    public void setNavLocationStartRouteDragging(NavLocationWgs84 navLocationWgs84) {
        this.navLocationStartRouteDragging = navLocationWgs84;
    }

    public void setNeedsRubberbandStart(boolean bl) {
        this.needsRubberbandStart = bl;
    }

    public void setOneFingerClickX(int n) {
        this.oneFingerClickX = n;
    }

    public void setOneFingerClickY(int n) {
        this.oneFingerClickY = n;
    }

    public void setPositionOnRoute(NavLocationWgs84 navLocationWgs84) {
        this.positionOnRoute = navLocationWgs84;
    }

    public void setRgActiveTrueReceivedAfterCancelRubberBand(boolean bl) {
        this.rgActiveTrueReceivedAfterCancelRubberBand = bl;
    }

    public void setRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.rgCalculatedRoutes = calculatedRouteListElementArray;
    }

    public void setRgRouteCalculcationState(int n) {
        this.rgRouteCalculcationState = n;
    }

    public void setRgStartRubberbandManipulationResult(int n) {
        this.rgStartRubberbandManipulationResult = n;
    }
}

