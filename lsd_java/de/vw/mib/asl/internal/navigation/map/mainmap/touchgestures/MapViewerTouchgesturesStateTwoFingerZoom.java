/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;

public class MapViewerTouchgesturesStateTwoFingerZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateTwoFingerZoom]");
    private final MapViewerTouchgesturesTargetHSM target;

    public MapViewerTouchgesturesStateTwoFingerZoom(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTouchgesturesTargetHSM;
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
            case 1073742411: {
                this.handleASLNavigationMapViewSetClickInMainMap(eventGeneric);
                break;
            }
            case 1074841824: {
                this.handleASLNavigationMapViewTwoFingerZoomed(eventGeneric);
                break;
            }
            case 1073744379: {
                this.handleASLNavigationDestInputGPSClickInMainMap(eventGeneric);
                break;
            }
            case 1073744199: {
                this.handleASLNavigationCrosshairModeClickInMainMap(eventGeneric);
                break;
            }
            case 1074841840: {
                this.handleASLNavigationRubberBandClickInMainMap(eventGeneric);
                break;
            }
            case 1074841876: {
                this.handleASLNavigationMapViewSetClickInDetailScreenMap(eventGeneric);
                break;
            }
            case 1074841837: {
                this.handleASLNavigationMapViewSetClickInDualListView(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapViewSetClickInDualListView(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapViewSetClickInDualListView()");
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        this.handleClickInMapReleased(n2, n3);
    }

    private void handleASLNavigationCrosshairModeClickInMainMap(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationCrosshairModeClickInMainMap()");
        int n = eventGeneric.getInt(1);
        if (n != 2) {
            return;
        }
        int n2 = eventGeneric.getInt(2);
        int n3 = eventGeneric.getInt(3);
        this.handleClickInMapReleased(n2, n3);
    }

    private void handleASLNavigationDestInputGPSClickInMainMap(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationDestInputGPSClickInMainMap()");
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(0);
        this.handleClickInMapReleased(n2, n3);
    }

    private void handleASLNavigationMapViewSetClickInDetailScreenMap(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapViewSetClickInDetailScreenMap()");
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        this.handleClickInMapReleased(n2, n3);
    }

    private void handleASLNavigationMapViewSetClickInMainMap(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.handleASLNavigationMapViewSetClickInMainMapPressed();
                break;
            }
            case 1: {
                this.handleASLNavigationMapViewSetClickInMainMapDragged();
                break;
            }
            case 2: {
                this.handleASLNavigationMapViewSetClickInMainMapReleased(eventGeneric);
                break;
            }
            case 3: {
                this.handleASLNavigationMapViewSetClickInMainMapClicked();
                break;
            }
            case 4: {
                this.handleASLNavigationMapViewSetClickInMainMapSelected();
                break;
            }
            default: {
                this.logger.trace("handle() DEFAULT: UNKNOWN ClickMode");
            }
        }
    }

    private void handleASLNavigationMapViewSetClickInMainMapClicked() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapClicked()");
        this.target.notifierModel.notifyClickInMapMenuNotReady();
    }

    private void handleASLNavigationMapViewSetClickInMainMapDragged() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapDragged()");
    }

    private void handleASLNavigationMapViewSetClickInMainMapPressed() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapPressed()");
    }

    private void handleASLNavigationMapViewSetClickInMainMapReleased(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapReleased()");
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        this.handleClickInMapReleased(n, n2);
    }

    private void handleASLNavigationMapViewSetClickInMainMapSelected() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapSelected()");
    }

    private void handleASLNavigationMapViewTwoFingerZoomed(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewTwoFingerZoomed(x=").append(n).append(", y=").append(n2).append(", zDelta=").append(n3).append(", zDist=").append(n4).append(")").log();
        }
        int n5 = this.target.datapool.getTwoFingerZDistance();
        float f2 = this.target.datapool.getZoomLevelTwoFinger();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("zoomLevelCurrent=").append(f2).append(", zDistanceCurrent=").append(n5).log();
        }
        float f3 = (float)n4 / (float)n5;
        float f4 = f2 / f3;
        f4 = MapViewerUtils.checkZoomLevelIsInRange(f4);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("zoomLevelNew=").append(f4).log();
        }
        this.target.notifierDSI.setZoomLevel(f4);
        this.target.datapool.setZoomLevelTwoFinger(f4);
        this.target.datapool.setTwoFingerX(n);
        this.target.datapool.setTwoFingerY(n2);
        this.target.datapool.setTwoFingerZDelta(n3);
        this.target.datapool.setTwoFingerZDistance(n4);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainTwoFingersZoomDone();
    }

    private void handleASLNavigationRubberBandClickInMainMap(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationRubberBandClickInMainMap()");
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        this.handleClickInMapReleased(n2, n3);
    }

    private void handleClickInMapReleased(int n, int n2) {
        if (this.target.datapool.isMapInMainScreen()) {
            this.target.notifierDSI.setHotPoint(this.target.datapool.getHotPoint());
        }
        this.target.transStateMain();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setTwoFingerZoomActive(false);
        int n = MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getZoomLevelTwoFinger());
        float f2 = MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthCheckCrosshairVisibility();
        }
        if (this.target.datapool.isMapInMainScreen()) {
            MapViewerUtils.updateMainMapPersistedZoomLevel(f2);
            this.target.notifierModel.notifyMapMovedTrue();
        }
        this.target.notifierDSI.setEnableSoftZoom(true);
        this.target.notifierDSI.setEnableSoftJump(true);
        this.target.notifierDSI.setEnableSoftTilt(true);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setTwoFingerZoomActive(true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainGoogleEarthCheckCrosshairVisibility();
        this.target.datapool.setHotPoint(this.target.datapool.getMainMapHotPoint());
        float f2 = this.target.datapool.getZoomLevel();
        if (f2 == 32959) {
            int n = this.target.datapool.getZoomListIndex();
            if (n == -1) {
                this.logger.error("handleStart() both, zoomLevel and zoomListIndex can't be -1, stopping execution");
                return;
            }
            f2 = MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("zoomLevelCurrent= ").append(f2).log();
        }
        this.target.datapool.setZoomLevelTwoFinger(f2);
        if (this.target.datapool.getMapMode() != 2) {
            this.target.notifierDSI.setModeFreeMap();
        }
        this.target.notifierDSI.setEnableSoftZoom(false);
        this.target.notifierDSI.setEnableSoftJump(false);
        this.target.notifierDSI.setEnableSoftTilt(false);
        if (this.target.datapool.isMapInMainScreen()) {
            Point point = new Point(this.target.datapool.getTwoFingerX(), this.target.datapool.getTwoFingerY());
            this.target.notifierDSI.setHotPoint(point);
            this.target.notifierModel.notifyMapMovedTrue();
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomIndexChanged(MapViewerUtils.calculateZoomIndexByZoomLevel(f2));
    }
}

