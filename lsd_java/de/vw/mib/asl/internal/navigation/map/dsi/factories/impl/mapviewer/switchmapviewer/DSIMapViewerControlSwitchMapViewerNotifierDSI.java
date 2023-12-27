/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.DSIMapViewerControl;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerControlSwitchMapViewerNotifierDSI {
    private final IExtLogger logger;
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    private DSIMapViewerGoogleCtrlVW mapViewerGoogleCtrl;

    public DSIMapViewerControlSwitchMapViewerNotifierDSI(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM) {
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapViewerNotifierDSI]");
    }

    public void ensureTMCVisibility(long l) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("ensureTMCVisibility(tmcMessageId=").append(l).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().ensureTMCVisibility(l);
    }

    private boolean isMapViewerCurrentGoogleEarth() {
        int n = DSIMapViewerControlFactoryVW.getMapViewerInstanceIdCurrentMain();
        return n == 1;
    }

    public void set3DLandmarksVisible(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("set3DLandmarksVisible(visible=").append(bl).append(")").log();
        }
        if (this.isMapViewerCurrentGoogleEarth()) {
            return;
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().set3DLandmarksVisible(bl);
    }

    public void setBrandIconStyle(int[] nArray, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("setBrandIconStyle()");
        }
        if (this.isMapViewerCurrentGoogleEarth()) {
            this.logger.trace("The call will be ignored, setBrandIconStyle(int[] brandUid, int brandIconStyle) is not implemented in the Google Earth MapViewer");
            return;
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setBrandIconStyle(nArray, n);
    }

    public void setCarPosition(Point point) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setCarPosition(carPosition=").append(point).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setCarPosition(point);
    }

    public void setCityModelMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setCityModelMode(cityModelMode=").append(n).append(")").log();
        }
        if (this.isMapViewerCurrentGoogleEarth()) {
            this.logger.trace("Google Earth map viewer is active. City model will be explicitly deactivated.");
            this.target.datapool.getDsiMapViewerControlCurrentMainMap().setCityModelMode(0);
        } else {
            this.target.datapool.getDsiMapViewerControlCurrentMainMap().setCityModelMode(n);
        }
    }

    public void setDayView() {
        this.logger.trace("setDayView()");
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setDayView();
    }

    public void setGeneralPOIVisibility(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setGeneralPOIVisibility(visible=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setGeneralPoiVisibility(bl);
    }

    public void setHotPoint(Point point) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setHotPoint(hotPoint=").append(point.toString()).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setHotPoint(point);
    }

    public void setLocationByLocation(NavLocation navLocation) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setLocationByLocation(location=").append(navLocation.toString()).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setLocationByLocation(navLocation);
    }

    public void setLocationCar() {
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setLocation(0, (short)0);
    }

    public void setLocationDestination() {
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setLocation(1, (short)0);
    }

    public void setMetricSystem(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setMetricSystem(metricSystem=").append(n).append(")").log();
        }
        this.logger.trace("setMetricSystem() -  we don't notify the southside anymore about a unit change, because all MapViewer implementations showing a differen behavior");
    }

    public void setMobilityHorizonVisibility(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setMobilityHorizonVisibility(visible=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setMobilityHorizonVisibility(bl);
    }

    public void setMobilityHorizonZoomMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setMobilityHorizonZoomMode(mobilitsHorizonZoomMode=").append(n).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setMobilityHorizonZoomMode(n);
    }

    public void setMode(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setMode(mode=").append(n).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setMode(n);
    }

    public void setNightView() {
        this.logger.trace("setNightView()");
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setNightView();
    }

    public void setOrientation(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setOrientation(orientation=").append(n).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setOrientation(n, null);
    }

    public void setRotation(short s) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setRotation(rotation=").append(s).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setRotation(s);
    }

    public void setRouteVisibility(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setRouteVisibility(routeVisibility=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setRouteVisibility(bl);
    }

    public void setSpeedAndFlowRoadClass(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setSpeedAndFlowRoadClass(roadClass=").append(n).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setSpeedAndFlowRoadClass(n);
    }

    public void setTrafficMapStyle(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setTrafficMapStyle(enabled=").append(bl).append(")").log();
        }
        if (this.isMapViewerCurrentGoogleEarth()) {
            return;
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setTrafficMapStyle(bl);
    }

    public void setViewType(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setViewType(viewType=").append(n).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setZoomArea(zoomArea=").append(rect.toString()).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setZoomArea(rect);
    }

    public void setZoomIndex(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("setZoomIndex(zoomListIndex=").append(n).append(")").log();
        }
        if (n == -1) {
            n = MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getMapDataPool().getZoomLevel());
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().setZoomLevel(32959, n);
    }

    public void showSpeedAndFlow(boolean bl, boolean bl2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("showSpeedAndFlow( freeFlow=").append(bl).append(", congestions=").append(bl2).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().showSpeedAndFlowCongestions(bl2);
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().showSpeedAndFlowFreeFlow(bl);
    }

    public void showTMCMessages(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("showTMCMessages(showTMCMessages=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().showTMCMessages(bl);
    }

    public void softFunctionsDisable() {
        this.logger.trace("softFunctionsDisable()");
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.setEnableSoftJump(false);
        dSIMapViewerControl.setEnableSoftRotation(false);
        dSIMapViewerControl.setEnableSoftTilt(false);
        dSIMapViewerControl.setEnableSoftZoom(false);
    }

    public void softFunctionsEnable() {
        this.logger.trace("softFunctionsEnable()");
        DSIMapViewerControl dSIMapViewerControl = this.target.datapool.getDsiMapViewerControlCurrentMainMap();
        dSIMapViewerControl.setEnableSoftJump(true);
        dSIMapViewerControl.setEnableSoftRotation(true);
        dSIMapViewerControl.setEnableSoftTilt(true);
        dSIMapViewerControl.setEnableSoftZoom(true);
    }

    public void viewFreeze(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("viewFreeze(viewFreeze=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().viewFreeze(bl);
    }

    public void viewSetVisible(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("viewSetVisible(visible=").append(bl).append(")").log();
        }
        this.target.datapool.getDsiMapViewerControlCurrentMainMap().viewSetVisible(bl);
    }

    public void setConnectionInformation(int n) {
        this.mapViewerGoogleCtrl.setConnectionInformation(n);
    }

    public void setMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlVW dSIMapViewerGoogleCtrlVW) {
        this.mapViewerGoogleCtrl = dSIMapViewerGoogleCtrlVW;
    }
}

