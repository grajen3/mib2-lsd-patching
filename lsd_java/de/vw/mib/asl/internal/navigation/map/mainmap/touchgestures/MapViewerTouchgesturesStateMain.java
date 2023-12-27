/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerTouchgesturesStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateMain]");
    private final MapViewerTouchgesturesTargetHSM target;

    public MapViewerTouchgesturesStateMain(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 101001: {
                this.handleNaviTargetGoOn();
                break;
            }
            case 1074841824: {
                this.handleASLNavigationMapViewTwoFingerZoomed(eventGeneric);
                break;
            }
            case 1074841825: {
                this.handleASLNavigationMapViewTwoFingerDragged(eventGeneric);
                break;
            }
            case 1073742411: {
                this.handleASLNavigationMapViewSetClickInMainMap(eventGeneric);
                break;
            }
            case 1074841932: {
                this.handleASLNavigationMapHideClickInMapMenu();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapHideClickInMapMenu() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapHideClickInMapMenu()").log();
        }
        MapViewerDatapoolShared.getInstance().setClickInMapMenuActive(false);
        if (!this.target.datapool.isStreetViewVisible()) {
            this.target.notifierDSI.setModeFreeMap();
            this.target.notifierModel.notifyMapMovedTrue();
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapMovedByUser();
        }
        this.target.notifierModel.notifyClickInMapMenuNotReady();
    }

    private void handleASLNavigationMapViewTwoFingerDragged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewTwoFingerDragged(x= ").append(n).append(", y=").append(n2).append(", zDeltaX=").append(n3).append(", zDeltaY=").append(n4).append(")").log();
        }
    }

    private void handleASLNavigationMapViewSetClickInMainMap(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewSetClickInMainMap(x=").append(n).append(", y=").append(n2).append(")").log();
        }
        this.target.datapool.setOneFingerClickX(n);
        this.target.datapool.setOneFingerClickY(n2);
        int n3 = eventGeneric.getInt(0);
        switch (n3) {
            case 0: {
                this.handleASLNavigationMapViewSetClickInMainMapPressed();
                break;
            }
            case 1: {
                this.handleASLNavigationMapViewSetClickInMainMapDragged();
                break;
            }
            case 2: {
                this.handleASLNavigationMapViewSetClickInMainMapReleased();
                break;
            }
            case 3: {
                this.handleASLNavigationMapViewSetClickInMainMapClicked();
                break;
            }
            default: {
                this.logger.trace("handle() DEFAULT: UNKNOWN ClickMode");
            }
        }
    }

    private void handleASLNavigationMapViewSetClickInMainMapClicked() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapClicked()");
        if (this.target.datapool.isSwitchInProgress()) {
            this.logger.trace("Map Switch running, ignore click event and set menu not ready.");
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            return;
        }
        if (this.target.datapool.getMainMapContent() != 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive() || this.target.datapool.isAlternativeRouteMap()) {
            this.logger.trace("Not in main map or WPM active or Alternative Route Map active, ignore click event and set menu not ready.");
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            return;
        }
        this.target.transStateOneFingerClickInMap();
    }

    private void handleASLNavigationMapViewSetClickInMainMapDragged() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handle() received ev ASL_NAVIGATION_MAP_VIEW_SET_CLICK_IN_MAIN_MAP ->DRAGGED(x=").append(this.target.datapool.getOneFingerClickX()).append(", y=").append(this.target.datapool.getOneFingerClickY()).append(")").log();
        }
        this.target.notifierModel.notifyClickInMapMenuNotReady();
        this.target.transStateOneFingerDrag();
    }

    private void handleASLNavigationMapViewSetClickInMainMapPressed() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapPressed()");
        this.target.notifierModel.notifyClickInMapMenuNotReady();
    }

    private void handleASLNavigationMapViewSetClickInMainMapReleased() {
        this.logger.trace("handleASLNavigationMapViewSetClickInMainMapReleased()");
        if (this.target.datapool.isSwitchInProgress()) {
            this.logger.trace("Map Switch running, ignore release event and set menu not ready.");
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            return;
        }
        if (this.target.datapool.getMainMapContent() != 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive() || this.target.datapool.isAlternativeRouteMap()) {
            this.logger.trace("Not in main map or WPM active or Alternative Route Map active, ignore release event and set menu not ready.");
            this.target.notifierModel.notifyClickInMapMenuNotReady();
            return;
        }
        this.target.transStateOneFingerClickInMap();
    }

    private void handleASLNavigationMapViewTwoFingerZoomed(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewTwoFingerZoomed(x= ").append(n).append(", y=").append(n2).append(", zDelta=").append(n3).append(", zDist=").append(n4).append(")").log();
        }
        this.target.datapool.setTwoFingerX(n);
        this.target.datapool.setTwoFingerY(n2);
        this.target.datapool.setTwoFingerZDelta(n3);
        this.target.datapool.setTwoFingerZDistance(n4);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainTwoFingersZoomDone();
        this.target.notifierModel.notifyClickInMapMenuNotReady();
        this.target.transStateTwoFingerZoom();
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

    private void handleNaviTargetGoOn() {
        this.logger.trace("handleNaviTargetGoOn()");
        this.target.transStateInit();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }
}

