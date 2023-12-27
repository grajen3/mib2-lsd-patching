/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.switchmapviewer.DSIMapViewerControlSwitchMapviewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew
extends AbstractHsmState {
    private static final int TIMEOUT_VIEW_FREEZE;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew]");
    private final MapDataPool mapDataPool;
    private final DSIMapViewerControlSwitchMapviewerTargetHSM target;
    private boolean viewFreezTrueWasCalled;

    public DSIMapViewerControlSwitchMapviewerStateConfigureMapViewerNew(DSIMapViewerControlSwitchMapviewerTargetHSM dSIMapViewerControlSwitchMapviewerTargetHSM, String string, HsmState hsmState) {
        super(dSIMapViewerControlSwitchMapviewerTargetHSM.getHsm(), string, hsmState);
        this.target = dSIMapViewerControlSwitchMapviewerTargetHSM;
        this.mapDataPool = dSIMapViewerControlSwitchMapviewerTargetHSM.datapool.getMapDataPool();
    }

    private void configureMapViewerNew() {
        this.logger.trace("configureMapViewerNew()");
        this.timerViewFreezeStart();
        this.target.notifierDSI.viewFreeze(true);
        this.configureMapViewerNewHotPoint();
        this.configureMapViewerNewMapMode();
        this.configureMapViewerNew3DLandmarks();
        this.configureMapViewerNewCarPosition();
        this.configureMapViewerNewCityModelMode();
        this.configureMapViewerNewMetricSystem();
        this.configureMapViewerNewMobilityHorizon();
        this.configureMapViewerNewOrientation();
        this.configureMapViewerNewRotation();
        this.configureMapViewerNewViewType();
        this.configureMapViewerNewZoom();
        this.configureMapViewerNewShowSpeedAndFlow();
        this.configureMapViewerNewTrafficMapStyle();
        this.configureMapViewerNewDayNightView();
        this.configureMapViewerNewBrandIcons();
        this.configureMapViewerNewShowTmcMessage();
        this.configureMapViewerNewEnsurceTmcVisibility();
        this.configureMapViewerNewFlags();
        this.configureMapViewerNewGeneralPOIVisibility();
        this.configureMapViewerRouteVisiblity();
        this.configureMapViewerNewGoogle();
        this.configureMapViewerNewSoftFunctionsEnable();
        this.target.notifierDSI.viewSetVisible(true);
        this.target.notifierDSI.viewFreeze(false);
    }

    private void configureMapViewerNew3DLandmarks() {
        this.logger.trace("configureMapViewerNew3DLandmarks()");
        if (this.isMapViewerNewGoogleEarth()) {
            return;
        }
        boolean bl = this.mapDataPool.isLandmarks3DVisible();
        this.target.notifierDSI.set3DLandmarksVisible(bl);
    }

    private void configureMapViewerNewBrandIcons() {
        this.logger.trace("configureMapViewerNewBrandIcons()");
        int[] nArray = this.mapDataPool.getBrandIconUIDs();
        int n = this.mapDataPool.getBrandIconStyle();
        this.target.notifierDSI.setBrandIconStyle(nArray, n);
    }

    private void configureMapViewerNewCarPosition() {
        this.logger.trace("configureMapViewerNewCarPosition()");
        this.target.notifierDSI.setCarPosition(this.target.datapool.getMainMapCarPosition());
    }

    private void configureMapViewerNewCityModelMode() {
        this.logger.trace("configureMapViewerNewCityModelMode()");
        int n = this.mapDataPool.getCityModelMode();
        switch (n) {
            case 0: {
                this.target.notifierDSI.setCityModelMode(0);
                break;
            }
            case 2: {
                this.target.notifierDSI.setCityModelMode(2);
                break;
            }
            default: {
                this.logger.warn("no valid cityModelMode was set, set to CITYMODELMODE_OFF");
                this.target.notifierDSI.setCityModelMode(0);
            }
        }
    }

    private void configureMapViewerNewDayNightView() {
        this.logger.trace("configureDayNightView()");
        if (this.mapDataPool.isNightView()) {
            this.target.notifierDSI.setNightView();
        } else {
            this.target.notifierDSI.setDayView();
        }
    }

    private void configureMapViewerNewEnsurceTmcVisibility() {
        long l = this.mapDataPool.getEnsureTMCVisibilityMessageId();
        this.target.notifierDSI.ensureTMCVisibility(l);
    }

    private void configureMapViewerNewFlags() {
        this.logger.trace("configureMapViewerNewFlags()");
    }

    private void configureMapViewerNewGeneralPOIVisibility() {
        this.logger.trace("configureMapViewerNewGeneralPOIVisibility()");
        boolean bl = this.mapDataPool.isGeneralPOIVisibility();
        this.target.notifierDSI.setGeneralPOIVisibility(bl);
    }

    private void configureMapViewerNewGoogle() {
        this.logger.trace("configureMapViewerNewGoogle()");
        if (this.isMapViewerNewGoogleEarth()) {
            // empty if block
        }
    }

    private void configureMapViewerNewHotPoint() {
        this.logger.trace("configureMapViewerNewHotPoint()");
        Point point = this.mapDataPool.getHotPoint();
        if (point == null) {
            this.logger.error("The HotPoint is null and will not be set. The HotPoint must be valid!");
            return;
        }
        this.target.notifierDSI.setHotPoint(this.mapDataPool.getHotPoint());
    }

    private void configureMapViewerNewLocationType() {
        this.logger.trace("configureMapViewerNewLocationType()");
        int n = this.mapDataPool.getLocationType();
        switch (n) {
            case 1: {
                this.target.notifierDSI.setLocationByLocation(this.mapDataPool.getMapPosition());
                break;
            }
            case 2: {
                this.target.notifierDSI.setLocationCar();
                break;
            }
            case 3: {
                this.target.notifierDSI.setLocationDestination();
                break;
            }
            default: {
                if (this.mapDataPool.getMapPosition() == null) break;
                this.logger.warn("locationType was not set, using LOCATION_TYPE_BY_LOCATION");
                this.target.notifierDSI.setLocationByLocation(this.mapDataPool.getMapPosition());
            }
        }
    }

    private void configureMapViewerNewMapMode() {
        int n = this.mapDataPool.getMapMode();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("configureMapViewerNewMapMode(mapMode=").append(n).append(")").log();
        }
        if (this.target.datapool.getMapViewerNewId() == 1) {
            boolean bl;
            if (n == 2 && (bl = GoogleEarthUtils.isUseCrosshairMap())) {
                n = 3;
            }
        } else if (this.target.datapool.getMapViewerNewId() == 0 && n == 3) {
            n = 2;
        }
        this.mapDataPool.setMapMode(n);
        this.target.notifierDSI.setMode(n);
        if (n == 3 || n == 2) {
            this.configureMapViewerNewLocationType();
        }
    }

    private void configureMapViewerNewMetricSystem() {
        this.logger.trace("configureMapViewerNewMetricSystem()");
        this.target.notifierDSI.setMetricSystem(this.mapDataPool.getMetricSystem());
    }

    private void configureMapViewerNewMobilityHorizon() {
        this.logger.trace("configureMapViewerNewMobilityHorizon()");
        if (this.isMapViewerNewGoogleEarth()) {
            this.logger.trace("Google Earth is active, but MobilityHorizon is not yet available on Google Earth, this call will be ignored");
            return;
        }
        boolean bl = this.mapDataPool.isMobilityHorzionVisible();
        this.target.notifierDSI.setMobilityHorizonVisibility(bl);
        int n = this.mapDataPool.getMobilityHorizonZoomMode();
        this.target.notifierDSI.setMobilityHorizonZoomMode(n);
    }

    private void configureMapViewerNewOrientation() {
        this.logger.trace("configureMapViewerNewMoneuvreZoom()");
        int n = this.mapDataPool.getOrientation();
        this.target.notifierDSI.setOrientation(n);
    }

    private void configureMapViewerNewRotation() {
        this.logger.trace("configureMapViewerNewRotation()");
        this.target.notifierDSI.setRotation(this.target.datapool.getMapRotation());
    }

    private void configureMapViewerNewShowSpeedAndFlow() {
        this.logger.trace("configureMapViewerShowSpeedAndFlow()");
        boolean bl = this.mapDataPool.isShowSpeedAndFlowFreeFlow();
        boolean bl2 = this.mapDataPool.isShowSpeedAndFlowCongestions();
        this.target.notifierDSI.showSpeedAndFlow(bl, bl2);
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
            this.target.notifierDSI.setSpeedAndFlowRoadClass(this.mapDataPool.getSpeedAndFlowRoadClass());
        }
    }

    private void configureMapViewerNewShowTmcMessage() {
        boolean bl = this.mapDataPool.isShowTmcMessages();
        this.target.notifierDSI.showTMCMessages(bl);
    }

    private void configureMapViewerNewSoftFunctionsEnable() {
        this.logger.trace("softFunctionsEnable()");
        this.target.notifierDSI.softFunctionsEnable();
    }

    private void configureMapViewerNewTrafficMapStyle() {
        this.logger.trace("configureMapViewerTrafficMapStyle()");
        if (this.isMapViewerNewGoogleEarth()) {
            return;
        }
        boolean bl = this.mapDataPool.isTrafficMapStyle();
        this.target.notifierDSI.setTrafficMapStyle(bl);
    }

    private void configureMapViewerNewViewType() {
        this.logger.trace("configureMapViewerNewViewType()");
        int n = this.mapDataPool.getViewType();
        this.target.notifierDSI.setViewType(n);
    }

    private void configureMapViewerNewZoom() {
        int n;
        this.logger.trace("configureMapViewerNewZoom()");
        Rect rect = this.mapDataPool.getZoomArea();
        if (rect == null) {
            this.logger.error("The ZoomArea is null and will not be set. The ZoomArea must be valid!");
        } else {
            this.target.notifierDSI.setZoomArea(rect);
        }
        if (!MapViewerUtils.isMainMapModeCurrentZoomable()) {
            this.logger.trace("The zoomLevel will not be set, because the mapMode is not zoomable");
            return;
        }
        if (this.target.datapool.isAutoZoomMainMap()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("Autozoom is enabled, so we use the last recommended zoom level");
            }
            n = MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getAutoZoomRecommendedZoomLast());
        } else {
            n = this.mapDataPool.getZoomListIndex();
        }
        this.target.notifierDSI.setZoomIndex(n);
    }

    private void configureMapViewerRouteVisiblity() {
        this.logger.trace("configureMapViewerRouteVisiblity()");
        boolean bl = this.mapDataPool.isRouteVisible();
        this.target.notifierDSI.setRouteVisibility(bl);
    }

    public HsmState dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewFreeze(viewFreeze=").append(bl).append(", viewFreezTrueWasCalled=").append(this.viewFreezTrueWasCalled).append(")").log();
        }
        if (bl) {
            this.viewFreezTrueWasCalled = true;
            return null;
        }
        if (!bl) {
            this.timerViewFreezeStop();
        }
        int n2 = this.target.datapool.getMapViewerNewId();
        this.target.managerTarget.mapViewerFacadesUpdateMapViewer(n2);
        this.target.managerTarget.mapViewersResponseListenerAndNotificationAdd(n2);
        this.viewFreezTrueWasCalled = false;
        this.logger.trace("MapViewerNew was completly configured, going back to stateIdle");
        if (this.target.datapool.isResetGoogleEarth()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthClearCache();
            this.target.datapool.setResetGoogleEarth(false);
            this.target.datapool.setResentConnectionState(true);
        }
        if (this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId() == 1 && this.target.datapool.isResentConnectionState()) {
            int n3 = this.target.datapool.isConnectionStateAllow() ? 0 : 255;
            this.target.notifierDSI.setConnectionInformation(n3);
            this.target.datapool.setResentConnectionState(false);
        }
        this.target.datapool.setSwitchInProgress(false);
        this.target.managerTarget.mapViewerFacadesSetStatusMainMap(true);
        this.target.managerTarget.setCreateMainMapMapViewerEnabled(true);
        this.target.notifierModel.notifyMapViewerSwitchDone();
        this.notifyModelMapTypChanged();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainSwitchMapViewerDone();
        this.target.transStateMain();
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
                this.handleStart();
                break;
            }
            case 3499052: {
                this.handleTimeoutViewFreeze();
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

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.configureMapViewerNew();
    }

    private void handleTimeoutViewFreeze() {
        this.logger.error("updateViewFreeze(false) has not arrived before timeout elapsed, simulating this call to prevent HMI freezes");
        this.dsiMapViewerControlUpdateViewFreeze(false, 1);
    }

    private boolean isMapViewerNewGoogleEarth() {
        int n = this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId();
        return n == 1;
    }

    private void notifyModelMapTypChanged() {
        int n = this.target.datapool.getDsiMapViewerControlCurrentMainMapInstanceId();
        if (n == 0) {
            this.target.notifierModel.notifyMapTypeCurrentOnboard();
            this.target.notifierModel.notifyMapTypeLastOnboard();
            this.target.datapool.setMainMapLastMapType(0);
        } else if (n == 1) {
            this.target.notifierModel.notifyMapTypeCurrentGoogleEarth();
            this.target.notifierModel.notifyMapTypeLastGoogleEarth();
            this.target.datapool.setMainMapLastMapType(1);
        } else {
            this.logger.makeWarn().append("invalid mapViewer instanceId: ").append(n).log();
        }
    }

    private void timerViewFreezeStart() {
        this.logger.trace("start()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), 744764672);
        this.target.startTimer(eventGeneric, 0, false, true);
    }

    private void timerViewFreezeStop() {
        this.logger.trace("timerViewFreeezeStop()");
        this.target.stopTimer(5000);
    }
}

