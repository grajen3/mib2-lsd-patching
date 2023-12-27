/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.autozoom;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils;
import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils$ZoomLevelThreshold;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Rect;

public final class MapViewerAutoZoomStateWork
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerAutoZoomStateWork]");
    private final MapViewerAutoZoomTargetHSM target;
    private boolean forceAutozoom = false;

    public MapViewerAutoZoomStateWork(MapViewerAutoZoomTargetHSM mapViewerAutoZoomTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerAutoZoomTargetHSM;
    }

    public HsmState dsiMapViewerZoomEngineUpdateRecommendedZoom(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerZoomEngineUpdateRecommendedZoom(recommendedZoom=").append(f2).append(")").log();
        }
        if (!MapViewerUtils.isZoomLevelWithinRange(f2)) {
            this.logger.trace("Invalid zoom level - will be ignored");
            return null;
        }
        this.target.datapool.setAutozoomRecommendedZoomLast((int)f2);
        if (this.target.datapool.isPerspectiveRocketZoom()) {
            return null;
        }
        if (this.target.datapool.isAutoZoomMainMap()) {
            this.updateZoomLevelToRecommendedZoom();
        }
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
            case 1073742389: {
                this.handleASLNavigationMapSetupToggleAutoZoom();
                break;
            }
            case 3499040: {
                this.handleMapMainMapMovedByUser();
                break;
            }
            case 3499036: {
                this.handleZoomLevelChangedByUser();
                break;
            }
            case 3499079: {
                this.handleMapVisibleInAnotherContext(eventGeneric);
                break;
            }
            case 3499087: {
                this.handleAutozoomForcedByOtherContext(eventGeneric);
                break;
            }
            case 3499091: {
                this.handleASLNavigationSetZoomArea(eventGeneric);
                break;
            }
            case 1073744564: {
                if (this.target.datapool.isContinuousZoomActive() || !this.target.datapool.isMapLocatedInKombi() || !ServiceManager.configManagerDiag.isFeatureFlagSet(369)) break;
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        this.handleASLNavigationMapSetupToggleAutoZoom();
                        break block0;
                    }
                }
                if (!this.target.datapool.isAutoZoomMainMap()) break;
                this.handleASLNavigationMapSetupToggleAutoZoom();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleAutozoomForcedByOtherContext(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleAutozoomForcedByOtherContext(visible=").append(bl).append(")").log();
        }
        this.forceAutozoom = bl;
        if (!this.target.datapool.isPerspectiveRocketZoom()) {
            this.updateZoomLevelToRecommendedZoom();
        }
    }

    private void handleASLNavigationSetZoomArea(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        Rect rect = new Rect(n, n2, n3, n4);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationSetZoomArea(rect=").append(rect.toString()).append(")").log();
        }
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setZoomArea(rect);
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleMapVisibleInAnotherContext(EventGeneric eventGeneric) {
        boolean bl = eventGeneric.getBoolean(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleMapVisibleInAnotherContext(visible=").append(bl).append(")").log();
        }
        this.forceAutozoom = bl;
    }

    private void handleASLNavigationMapSetupToggleAutoZoom() {
        boolean bl = !this.target.datapool.isAutoZoomMainMap();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapSetupToggleAutoZoom(").append(bl).append(") ").log();
        }
        this.target.datapool.setAutoZoomMainMap(bl);
        if (bl) {
            this.target.notifierModel.notifyAutoZoomEnabled();
            this.updateZoomLevelToRecommendedZoom();
            this.target.datapool.setAutozoomDeactivatedWhileDrag(false);
        } else {
            this.target.notifierDSI.setZoomLevel(this.target.datapool.getMainMapZoomLevel());
            this.target.notifierModel.notifyAutoZoomDisabled();
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(bl);
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

    private void handleMapMainMapMovedByUser() {
        this.logger.trace("handleMapMainMapMovedByUser()");
        if (!this.target.datapool.isAutoZoomMainMap()) {
            return;
        }
        this.target.datapool.setAutozoomDeactivatedWhileDrag(true);
        this.handleASLNavigationMapSetupToggleAutoZoom();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierDSI.autoZoomEnable();
        if (this.target.datapool.isAutoZoomMainMap()) {
            this.target.notifierModel.notifyAutoZoomEnabled();
            this.updateZoomLevelToRecommendedZoom();
            this.target.datapool.setAutozoomDeactivatedWhileDrag(false);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(true);
        } else {
            this.target.notifierDSI.setZoomLevel(this.target.datapool.getMainMapZoomLevel());
            this.target.notifierModel.notifyAutoZoomDisabled();
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainAutozoomStatusChanged(false);
        }
    }

    private void handleZoomLevelChangedByUser() {
        this.logger.trace("handleZoomLevelChangedByUser()");
        if (!this.target.datapool.isAutoZoomMainMap()) {
            return;
        }
        if (this.target.datapool.isMapMoved()) {
            return;
        }
        if (!this.isValidPersepctiveActive()) {
            return;
        }
        int n = this.target.datapool.getMainMapContent();
        if (n != 0) {
            this.logger.trace("zoomLevel changed will be ignored, because we are not in nav main, autozoom will not be disabled");
            return;
        }
        this.handleASLNavigationMapSetupToggleAutoZoom();
    }

    private boolean isValidPersepctiveActive() {
        return this.target.datapool.isPerspective25DCarUp() || this.target.datapool.isPerspective2DCarUp() || this.target.datapool.isPerspective2DNorthUp() || this.target.datapool.isPerspective3DCarUp() || this.target.datapool.isPerspective3DDTM() || this.target.datapool.isPerspectiveCountryOverview();
    }

    private void updateZoomLevelToRecommendedZoom() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateZoomLevelToRecommendedZoom()").log();
        }
        if (!this.target.datapool.isAutoZoomMainMap()) {
            return;
        }
        int n = this.target.datapool.getMainMapContent();
        if (n != 0 && !this.forceAutozoom && !this.target.datapool.isMapLocatedInKombi()) {
            this.logger.trace("autozoom will be ignored, because we are not in nav main");
            return;
        }
        if (this.target.datapool.isMapExternalConfigured()) {
            this.logger.trace("autozoom will be ignored, because the map is external configured");
            return;
        }
        if (!this.target.datapool.isFocusCCPZoom()) {
            this.logger.trace("autozoom will be ignored, because the carsor is not in focus");
            return;
        }
        if (n == 0 && !this.isValidPersepctiveActive() && !this.target.datapool.isMapLocatedInKombi()) {
            this.logger.trace("autozoom will be ignored, because no valid perspective is set");
            return;
        }
        if (this.target.datapool.isMapLocatedInKombi() && (this.target.datapool.getMainMapMapMode() == 10 || this.target.datapool.getMainMapMapMode() == 9)) {
            this.logger.trace("autozoom will be ignored, because map is in kombi and Overview or Destination Map is active");
            return;
        }
        int n2 = this.target.datapool.getAutoZoomRecommendedZoomLast();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(369) && this.target.datapool.isMapLocatedInKombi()) {
            this.updateMapScaleInBAP(MapViewerUtils.calculateZoomLevelNormalized(n2));
        }
        this.target.datapool.setMainMapZoomLevel(n2);
        this.target.notifierDSI.setZoomLevel(n2);
        int n3 = MapViewerUtils.calculateZoomLevelNormalized(n2);
        this.target.notifierModel.notifyZoomLevelChanged(n3);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomValueChanged(n3);
    }

    private void updateMapScaleInBAP(int n) {
        FPKMapScaleUtils$ZoomLevelThreshold fPKMapScaleUtils$ZoomLevelThreshold = FPKMapScaleUtils.getFPKMapScaleThreshold(n);
        switch (ASLSystemFactory.getSystemApi().getConfiguredDistanceUnit()) {
            case 1: {
                ASLNavBAPFactory.getNavBAPApi().updateMapsScale(fPKMapScaleUtils$ZoomLevelThreshold.zoomImperial, fPKMapScaleUtils$ZoomLevelThreshold.unitImperial, 1);
                break;
            }
            case 0: {
                ASLNavBAPFactory.getNavBAPApi().updateMapsScale(fPKMapScaleUtils$ZoomLevelThreshold.zoomMetric, fPKMapScaleUtils$ZoomLevelThreshold.unitMetric, 1);
                break;
            }
        }
    }
}

