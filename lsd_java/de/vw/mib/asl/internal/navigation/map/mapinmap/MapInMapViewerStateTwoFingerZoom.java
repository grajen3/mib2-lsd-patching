/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;

public class MapInMapViewerStateTwoFingerZoom
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerStateTwoFingerZoom]");
    private final MapInMapViewerTargetHsm target;

    public MapInMapViewerStateTwoFingerZoom(MapInMapViewerTargetHsm mapInMapViewerTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerTargetHsm;
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
            case 1074841865: {
                this.handleClickInMap(eventGeneric);
                break;
            }
            case 1074841860: {
                this.handleTwoFingerZoomed(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleClickInMap(EventGeneric eventGeneric) {
        this.logger.trace("handleClickInMap()");
        int n = eventGeneric.getInt(0);
        if (n != 2) {
            return;
        }
        this.target.transStateMain();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(",Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        int n = MapViewerUtils.calculateZoomIndexByZoomLevel(this.target.datapool.getMapDataPoolZoomLevel());
        int n2 = (int)MapViewerUtils.calculateZoomLevelByZoomIndex(n);
        this.target.datapool.setMapInMapZoomLevel(n2);
        this.target.datapool.setTwoFingerZoomActive(false);
        this.target.notifierDSI.setEnableSoftZoom(true);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setTwoFingerZoomActive(true);
        this.target.notifierDSI.viewSetVisible();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("using zoomLevel=").append(this.target.datapool.getMapInMapZoomLevel()).append(" as startZoomLevel for twoFingerZoom").log();
        }
        this.target.datapool.setZoomLevelTwoFinger(this.target.datapool.getMapDataPoolZoomLevel());
        if (!MapViewerUtils.isMapInMapModeCurrentZoomable()) {
            Point point = MapViewerUtils.calculateHotPointByZoomArea(this.target.datapool.getZoomArea());
            this.logger.makeWarn().append("handleStart() - the MapInMap is not in a zoom-able map mode, we set it to FreeMap, but this is a issue which should be fixed. We using the HotPoint( x=").append(point.xPos).append(", y=").append(point.yPos).append(")").log();
            this.target.notifierDSI.setModeFreeMap();
            this.target.notifierDSI.setHotPoint(point);
        }
        this.target.notifierDSI.setEnableSoftZoom(false);
    }

    private void handleTwoFingerZoomed(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleTwoFingerZoomed(x= ").append(n).append(", y=").append(n2).append(", zDeltaX=").append(n3).append(", zDeltaY=").append(n4).append(")").log();
        }
        int n5 = this.target.datapool.getTwoFingerZDistance();
        float f2 = this.target.datapool.getZoomLevelTwoFinger();
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
        int n6 = MapViewerUtils.calculateZoomLevelNormalized(f4);
        this.target.notifierModel.notifyZoomLevelChanged(n6);
    }
}

