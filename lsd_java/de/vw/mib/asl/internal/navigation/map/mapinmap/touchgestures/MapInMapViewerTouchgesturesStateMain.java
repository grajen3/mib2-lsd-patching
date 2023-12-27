/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mapinmap.touchgestures.MapInMapViewerTouchgesturesTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerTouchgesturesStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapTouchgesturesStateMain]");
    private final MapInMapViewerTouchgesturesTarget target;

    public MapInMapViewerTouchgesturesStateMain(MapInMapViewerTouchgesturesTarget mapInMapViewerTouchgesturesTarget, String string, HsmState hsmState) {
        super(mapInMapViewerTouchgesturesTarget.getHsm(), string, hsmState);
        this.target = mapInMapViewerTouchgesturesTarget;
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
            case 1074841860: {
                this.handleTwoFingerZoomed(eventGeneric);
                break;
            }
            case 1074841861: {
                this.handleTwoFingerDragged(eventGeneric);
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
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(", Params=").append(eventGeneric.getParamString()).log();
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

    private void handleTwoFingerDragged(EventGeneric eventGeneric) {
        this.logger.trace("handleTwoFingerDragged()");
    }

    private void handleTwoFingerZoomed(EventGeneric eventGeneric) {
        this.logger.trace("handleTwoFingerZoomed()");
        if (this.target.datapool.isPerspectiveOverviewZoomActive() || this.target.datapool.isPerspectiveRangeViewActive()) {
            this.logger.trace("handleTwoFingerZoomed() - OverViewZoom or RangeView is active, ignoring TwoFingerZoom gesture");
            return;
        }
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleTwoFingerZoomed(x= ").append(n).append(", y=").append(n2).append(", zDeltaX=").append(n3).append(", zDeltaY=").append(n4).append(")").log();
        }
        this.target.datapool.setTwoFingerX(n);
        this.target.datapool.setTwoFingerY(n2);
        this.target.datapool.setTwoFingerZDelta(n3);
        this.target.datapool.setTwoFingerZDistance(n4);
        this.target.transStateTwoFingerZoom();
    }
}

