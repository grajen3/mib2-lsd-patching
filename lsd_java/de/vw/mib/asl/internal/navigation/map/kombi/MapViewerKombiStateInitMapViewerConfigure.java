/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiStateMain;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateInitMapViewerConfigure
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateStart]");
    private final MapViewerKombiTargetHSM target;
    private boolean viewFreezeFalseCalled;

    public MapViewerKombiStateInitMapViewerConfigure(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewFreeze(viewFreeze=").append(bl).append(")").log();
        }
        if (!this.viewFreezeFalseCalled && !bl) {
            this.logger.warn("This state did'nt call viewFreez(false) yet, the update will be ignored");
            return null;
        }
        if (!bl) {
            this.viewFreezeFalseCalled = false;
            this.target.notifierModel.notifyKombiStatusReady();
            if (this.target.datapool.isMapViewerVisibleAfterKombiRestartFinished()) {
                this.target.datapool.setMapViewerVisibleAfterKombiRestartFinished(false);
                this.target.transStateVisible();
            } else {
                this.target.transStateInvisible();
            }
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
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
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
        this.target.notifierDSI.viewFreeze(true);
        this.setPerspective();
        if (!this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelModeEnhanced();
        } else {
            this.target.notifierDSI.setCityModelModeOff();
        }
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.setModePositionMap();
        this.target.notifierDSI.setEnableSoftZoom();
        if (!ServiceManager.configManagerDiag.isFeatureFlagSet(238)) {
            this.target.notifierDSI.showTMCMessages(this.target.datapool.isTrafficShowIncidents());
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(472)) {
            this.target.notifierDSI.setSpeedAndFlowRoadClass(this.target.datapool.getSpeedAndFlowRoadClassDSI());
        }
        this.target.notifierDSI.setMetricSystem(this.target.datapool.getMetricSystem());
        boolean bl = this.target.datapool.isNightView();
        if (bl) {
            this.target.notifierDSI.setNightView();
        } else {
            this.target.notifierDSI.setDayView();
        }
        this.target.notifierDSI.setRouteColoringPolicyRouteoption();
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(70) && DSIMapViewerControlFactoryVW.getMapDatapoolMain().isGeneralPOIVisibility()) {
            this.target.notifierDSI.setGeneralPoiVisibilityTrue();
        } else {
            this.target.notifierDSI.setGeneralPoiVisibilityFalse();
        }
        int n = this.target.datapool.getZoomLevel() != 10000 ? this.target.datapool.getZoomLevel() : this.target.datapool.getZoomLevelLow();
        this.target.notifierDSI.setZoomLevel(n);
        MapViewerKombiStateMain.updateMapScaleInBAP(MapViewerUtils.calculateZoomLevelNormalized(n), this.target.datapool.isAutozoomActive());
        this.viewFreezeFalseCalled = true;
        this.target.notifierDSI.viewFreeze(false);
    }

    private void setPerspective() {
        int n = this.target.datapool.getMapInKombiPerspective();
        this.logger.makeTrace().append("setPerspective( perspective = ").append(n).append(" )").log();
        switch (n) {
            case 0: {
                this.target.setPerspective2DNorth();
                break;
            }
            case 1: {
                this.target.setPerspective2DHeading();
                break;
            }
            case 2: {
                this.target.setPerspective3D();
                break;
            }
        }
    }
}

