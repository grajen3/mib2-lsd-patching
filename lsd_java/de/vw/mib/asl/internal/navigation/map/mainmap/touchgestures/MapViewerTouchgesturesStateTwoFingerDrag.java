/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerTouchgesturesStateTwoFingerDrag
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateTwoFingerDrag]");
    private final MapViewerTouchgesturesTargetHSM target;

    public MapViewerTouchgesturesStateTwoFingerDrag(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 1074841825: {
                this.handleASLNavigationMapViewTwoFingerDragged(eventGeneric);
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

    private void handleASLNavigationMapViewTwoFingerDragged(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewTwoFingerDragged(x= ").append(n).append(", y=").append(n2).append(", zDeltaX=").append(n3).append(", zDeltaY=").append(n4).append(")").log();
        }
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
    }

    private HsmState handleSetClickInMainMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMap()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                return this.myParent;
            }
            case 1: {
                return this.myParent;
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

    private void handleSetClickInMainMapActionTypeC2Released(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapActionTypeC2Released()");
        this.target.datapool.setTwoFingerX(eventGeneric.getInt(1));
        this.target.datapool.setTwoFingerY(eventGeneric.getInt(2));
        this.target.notifierDSI.stopScrollToDirection();
        this.target.transStateMain();
    }

    private void handleStart() {
        int n;
        this.logger.trace("handleStart()");
        if (!this.target.datapool.isAlternativeRouteMap()) {
            this.target.notifierModel.notifyMapMovedTrue();
            if (this.target.datapool.isPerspective25DCarUp() || this.target.datapool.isPerspective2DCarUp() || this.target.datapool.isPerspective2DNorthUp() || this.target.datapool.isPerspective3DCarUp() || this.target.datapool.isPerspective3DDTM()) {
                this.target.datapool.setMapMoved(true);
            }
        }
        if (!MapViewerUtils.isMapModeDraggable(n = this.target.datapool.getMapMode()) || this.target.datapool.isPerspectiveDestinationZoom()) {
            this.target.notifierDSI.setModeFreeMap();
        }
    }
}

