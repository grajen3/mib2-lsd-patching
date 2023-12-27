/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils;
import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils$ZoomLevelThreshold;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;

public final class MapViewerStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStateMain]");
    private final MapViewerTargetHSM target;
    private static final String VARIANT = ServiceManager.configManagerDiag.getPureVariant();

    public MapViewerStateMain(MapViewerTargetHSM mapViewerTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapPosition(mapPosition=").append(navLocationWgs84.toString()).append(")").log();
        }
        if (!(this.isContentMainMap() || this.isContentCrosshairMap() || this.isASLServiceActive())) {
            this.logger.warn("updateMapPosition will be ignored, because we are neither on the main map, crosshairmap nor in ASL Service");
            return null;
        }
        if (this.target.datapool.isDestinationZoom() && !this.target.datapool.isMapMoved()) {
            this.logger.warn("updateMapPosition will be ignored, because we show the destination map");
            return null;
        }
        if (this.target.datapool.isOverviewZoom() && !this.target.datapool.isMapMoved()) {
            this.logger.warn("updateMapPosition will be ignored, because we show the overview map");
            return null;
        }
        if (this.target.datapool.isPerspectiveAlternativeRouteMap()) {
            this.logger.warn("updateMapPosition will be ignored, because we show the alternative route map");
            return null;
        }
        if (this.target.datapool.isSpeechActive()) {
            this.logger.warn("updateMapPosition will be ignored, because speech is active");
            return null;
        }
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocationWgs84.latitude, navLocationWgs84.longitude);
        this.target.datapool.setMapPosition(iLocationWrapper.getLocation());
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapRotation(short s, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapRotation(mapRotation=").append(s).append(")").log();
        }
        if (this.target.datapool.getMainMapContent() == 0 && !this.target.datapool.isSurroundingZoom()) {
            this.target.datapool.setMapRotation(s);
        }
        int n2 = MapViewerUtils.calculateHeadingValue(s);
        this.target.datapool.setHeadingValue(n2);
        this.target.notifierModel.notifyHeadingValueChanged(n2);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainHeadingValueChanged(n2);
        return null;
    }

    public HsmState dsiMapViewerControlUpdateZoomLevel(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomLevel(zoomLevel=").append(f2).append(")").log();
        }
        this.target.datapool.setZoomLevel(f2);
        int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(f2);
        this.updateZoomLevelAndIndex(n2, this.target.datapool.isAutoZoomMainMap());
        return null;
    }

    public HsmState dsiMapViewerControlUpdateZoomListIndex(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomListIndex(zoomListIndex=").append(n).append(")").log();
        }
        this.target.datapool.setZoomListIndex(n);
        this.updateZoomLevelAndIndex(n, this.target.datapool.isAutoZoomMainMap());
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 1073742415: {
                this.handleASLNavigationMapViewSetCarsurPosition(eventGeneric);
                break;
            }
            case 1073742420: {
                this.handleASLNavigationMapViewZoomIn();
                break;
            }
            case 1073742422: {
                this.handleASLNavigationMapViewZoomOut();
                break;
            }
            case 1073744665: {
                this.handleASLNavigationMapViewSetHotPointPosition(eventGeneric);
                break;
            }
            case 3499051: {
                this.handleZoomLevelChanged(eventGeneric);
                break;
            }
            case 1074841951: {
                this.handleSetZoomLevelSlider(eventGeneric);
                break;
            }
            case 3499063: {
                this.handleSpeechRecognizerActive();
                break;
            }
            case 3499064: {
                this.handleSpeechRecognizerInactive();
                break;
            }
            case 1073744564: {
                int n = eventGeneric.getInt(0);
                if (!this.target.datapool.isMapLocatedInKombi() || !ServiceManager.configManagerDiag.isFeatureFlagSet(369)) break;
                switch (n) {
                    case -128: {
                        this.target.transStateMapScaleContinuousIn();
                        break block0;
                    }
                    case 127: {
                        this.target.transStateMapScaleContinuousOut();
                        break block0;
                    }
                    case 1: {
                        this.handleASLNavigationMapViewZoomOut();
                        break block0;
                    }
                    case -1: {
                        this.handleASLNavigationMapViewZoomIn();
                        break block0;
                    }
                }
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleSpeechRecognizerInactive() {
        if (VARIANT.startsWith("HIGH2") && (this.target.datapool.getMainMapContent() != 255 || this.target.datapoolShared.isMapSetToVisibleByClient())) {
            this.logger.trace("handleSpeechRecognizerInactive");
            this.logger.trace("Map shown, therefore set view to visible again");
            this.target.notifierDSI.viewSetVisible(true);
        }
    }

    private void handleSpeechRecognizerActive() {
        if (VARIANT.startsWith("HIGH2")) {
            this.logger.trace("handleSpeechRecognizerActive - set map to invisible");
            this.target.notifierDSI.viewSetVisible(false);
        }
    }

    private void handleASLNavigationMapViewSetCarsurPosition(EventGeneric eventGeneric) {
        Point point = this.target.datapool.getMainMapCarPosition();
        point.xPos = eventGeneric.getInt(0);
        point.yPos = eventGeneric.getInt(1);
        this.target.datapool.setMainMapCarPosition(point);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewSetCarsurPosition(x=").append(point.xPos).append(", y=").append(point.yPos).append(")").log();
        }
        this.target.notifierDSI.setCarPosition(point);
    }

    private void handleASLNavigationMapViewSetHotPointPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        Point point = new Point(n, n2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewSetHotPointPosition(hotPoint=").append(point.toString()).append(")").log();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139) && this.target.datapool.isMapLocatedInKombi() && !this.target.datapool.isMapFPKSwitchRunning()) {
            this.logger.makeTrace().append("setHotPointPosition() will be ignored because map is in FPK").log();
            return;
        }
        this.target.notifierDSI.setHotPoint(point);
        this.moveMapToNewHotPoint();
    }

    private void handleASLNavigationMapViewZoomIn() {
        this.logger.trace("handleASLNavigationMapViewZoomIn()");
        if (this.target.datapool.isPerspectiveRocketZoom() || this.target.datapool.isClickInMapMenuActive()) {
            return;
        }
        this.prepareMapViewerForZoom();
        int n = MapViewerUtils.calculateZoomListIndexNew(-1);
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        MapViewerUtils.updateMainMapPersistedZoomLevel(n2);
        this.updateZoomLevelAndIndex(n, false);
        this.target.notifierDSI.setZoomIndex(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomIndexChanged(n);
    }

    private void handleASLNavigationMapViewZoomOut() {
        this.logger.trace("handleNavigationMapViewZoomOut()");
        if (this.target.datapool.isPerspectiveRocketZoom() || this.target.datapool.isClickInMapMenuActive()) {
            return;
        }
        this.prepareMapViewerForZoom();
        int n = MapViewerUtils.calculateZoomListIndexNew(1);
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        MapViewerUtils.updateMainMapPersistedZoomLevel(n2);
        this.updateZoomLevelAndIndex(n, false);
        this.target.notifierDSI.setZoomIndex(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomIndexChanged(n);
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleZoomLevelChanged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.datapool.isAutoZoomMainMap() && n != this.target.datapool.getAutoZoomRecommendedZoomLast()) {
            this.logger.trace("Autozoom is active and zoom level has changed meanwhile. Update zoom level.");
            n = this.target.datapool.getAutoZoomRecommendedZoomLast();
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleZoomLevelChanged( zoomLevel=").append(n).append(" )").log();
        }
        int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(n);
        this.updateZoomLevelAndIndex(n2, this.target.datapool.isAutoZoomMainMap());
        this.target.notifierDSI.setZoomIndex(n2);
    }

    private boolean isASLServiceActive() {
        return this.target.datapool.isASLServiceActive();
    }

    private boolean isContentCrosshairMap() {
        return this.target.datapool.getMainMapContent() == 12;
    }

    private boolean isContentMainMap() {
        return this.target.datapool.getMainMapContent() == 0;
    }

    private void moveMapToNewHotPoint() {
        this.logger.trace("moveMapToNewHotPoint()");
        if (!this.isContentMainMap()) {
            this.logger.trace("the map will not be moved, because we'r not in content 'NAV_MAIN'");
            return;
        }
        if (!this.target.datapool.isMapMoved()) {
            this.logger.trace("map wasn't moved");
            return;
        }
        if (this.target.datapool.isPerspective2DCarUp() || this.target.datapool.isPerspective2DNorthUp() || this.target.datapool.isPerspective25DCarUp() || this.target.datapool.isPerspective3DCarUp() || this.target.datapool.isPerspective3DDTM() || this.target.datapool.isPerspectiveMobilityHorizon() || this.target.datapool.isPerspectiveOverviewZoom() || this.target.datapool.isPerspectiveDestinationZoom() || this.target.datapool.isPerspectiveAlternativeRouteMap() || this.target.datapool.isSurroundingZoom()) {
            this.target.notifierDSI.setLocationByLocation(this.target.datapool.getMapPosition());
        }
    }

    private void prepareMapViewerForZoom() {
        boolean bl = MapViewerUtils.isMainMapModeCurrentZoomable();
        if (!bl) {
            this.logger.trace("The current mapmode is not zoomable, switching to MapMode FreeMap");
            this.target.notifierDSI.setModeFreeMap();
        }
    }

    private void updateZoomLevelAndIndex(int n, boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateZoomLevelAndIndex(").append(n).append(")").log();
        }
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        int n3 = n2 / 100;
        int n4 = this.target.datapool.getZoomListIndexMax();
        int n5 = this.target.datapool.getZoomListIndexMin();
        if (n == n5) {
            this.target.notifierModel.notifyZoomListIndexMinimumReachedTrue();
            this.target.notifierModel.notifyZoomListIndexMaximumReachedFalse();
        } else if (n > n5 && n < n4) {
            this.target.notifierModel.notifyZoomListIndexMinimumReachedFalse();
            this.target.notifierModel.notifyZoomListIndexMaximumReachedFalse();
        } else if (n == n4) {
            this.target.notifierModel.notifyZoomListIndexMinimumReachedFalse();
            this.target.notifierModel.notifyZoomListIndexMaximumReachedTrue();
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(369)) {
            this.updateMapScaleInBAP(n3, bl);
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(470)) {
            this.target.notifierModel.notifyZoomListIndexChanged(this.target.datapool.getZoomListIndexMax() - n);
        } else {
            this.target.notifierModel.notifyZoomListIndexChanged(n);
        }
        this.target.notifierModel.notifyZoomLevelChanged(n3);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomValueChanged(n3);
    }

    private void updateMapScaleInBAP(int n, boolean bl) {
        int n2 = bl ? 1 : 0;
        FPKMapScaleUtils$ZoomLevelThreshold fPKMapScaleUtils$ZoomLevelThreshold = FPKMapScaleUtils.getFPKMapScaleThreshold(n);
        switch (ASLSystemFactory.getSystemApi().getConfiguredDistanceUnit()) {
            case 1: {
                ASLNavBAPFactory.getNavBAPApi().updateMapsScale(fPKMapScaleUtils$ZoomLevelThreshold.zoomImperial, fPKMapScaleUtils$ZoomLevelThreshold.unitImperial, n2);
                break;
            }
            case 0: {
                ASLNavBAPFactory.getNavBAPApi().updateMapsScale(fPKMapScaleUtils$ZoomLevelThreshold.zoomMetric, fPKMapScaleUtils$ZoomLevelThreshold.unitMetric, n2);
                break;
            }
        }
    }

    private void handleSetZoomLevelSlider(EventGeneric eventGeneric) {
        int n = this.target.datapool.getZoomListIndexMax() - eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetZoomLevel(zoomListIndex=").append(n).append(")").log();
        }
        if (this.target.datapool.isPerspectiveRocketZoom() || this.target.datapool.isClickInMapMenuActive()) {
            return;
        }
        this.prepareMapViewerForZoom();
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        MapViewerUtils.updateMainMapPersistedZoomLevel(n2);
        this.updateZoomLevelAndIndex(n, false);
        this.target.notifierDSI.setZoomIndex(n);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomIndexChanged(n);
    }
}

