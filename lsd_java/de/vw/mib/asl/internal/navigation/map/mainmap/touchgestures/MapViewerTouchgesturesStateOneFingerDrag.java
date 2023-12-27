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

public final class MapViewerTouchgesturesStateOneFingerDrag
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateOneFingerDrag]");
    private final MapViewerTouchgesturesTargetHSM target;

    public MapViewerTouchgesturesStateOneFingerDrag(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTouchgesturesTargetHSM;
    }

    private void changeMapModeToFreeMap() {
        int n = this.target.datapool.getMapMode();
        if (!MapViewerUtils.isMapModeDraggable(n) || this.target.datapool.isPerspectiveDestinationZoom()) {
            this.logger.trace("changeMapModeToFreeMap()");
            this.target.notifierDSI.setModeFreeMap();
        }
    }

    private void disableAutozoom() {
        this.logger.trace("disableAutozoom()");
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapMovedByUser();
        this.target.notifierModel.notifyMapMovedTrue();
        if (this.target.isValidPerspectiveForMapMoved()) {
            this.target.datapool.setMapMoved(true);
        }
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
                return this.handleSetClickInMainMap(eventGeneric);
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
            this.logger.makeTrace().append("handleDefault(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.notifierDSI.stopScrollToDirection();
    }

    private HsmState handleSetClickInMainMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMap()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                return this.myParent;
            }
            case 1: {
                this.handleSetClickInMainMapActionTypeC1Dragged(eventGeneric);
                break;
            }
            case 2: {
                this.handleSetClickInMainMapActionTypeC2Released(eventGeneric);
                break;
            }
            case 3: {
                return this.myParent;
            }
            case 4: {
                return this.myParent;
            }
            default: {
                return this.myParent;
            }
        }
        return null;
    }

    private void handleSetClickInMainMapActionTypeC1Dragged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(1);
        int n2 = eventGeneric.getInt(2);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetClickInMainMapActionTypeC1Dragged(pressedX=").append(n).append(", pressedY=").append(n2).append(")").log();
        }
        short s = (short)(n - this.target.datapool.getOneFingerClickX());
        short s2 = (short)(n2 - this.target.datapool.getOneFingerClickY());
        this.target.notifierDSI.dragMap(s, s2);
        this.target.datapool.setOneFingerClickX(n);
        this.target.datapool.setOneFingerClickY(n2);
    }

    private void handleSetClickInMainMapActionTypeC2Released(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapActionTypeC2Released()");
        this.target.datapool.setOneFingerClickX(eventGeneric.getInt(1));
        this.target.datapool.setOneFingerClickY(eventGeneric.getInt(2));
        this.target.transStateMain();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.backupZoomLevel();
        if (!this.target.datapool.isAlternativeRouteMap() && !this.target.datapool.isPerspectivePNavOverview()) {
            this.disableAutozoom();
        }
        this.changeMapModeToFreeMap();
        this.target.backupLocationType();
        this.uncheckStreetViewAvailable();
    }

    private void uncheckStreetViewAvailable() {
        if (GoogleEarthUtils.isGoogleEarthActive()) {
            this.logger.trace("uncheckStreetViewAvailable()");
            this.target.notifierModel.notifyStreetViewNotAvailable();
        }
    }
}

