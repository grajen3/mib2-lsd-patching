/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.main;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.main.MapInMapViewerTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerStateWork
extends AbstractHsmState {
    private IExtLogger logger;
    private MapInMapViewerTargetHsm target;

    public MapInMapViewerStateWork(MapInMapViewerTargetHsm mapInMapViewerTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerTargetHsm;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerStateMain]");
    }

    public HsmState dsiMapViewerControlUpdateMapMode(int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapMode( mapMode=").append(n).append(" )").log();
        }
        this.target.datapool.setMapInMapMode(n);
        return null;
    }

    public HsmState dsiMapViewerControlUpdateMapRotation(short s, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateMapRotation( mapRotation=").append(s).append(" )").log();
        }
        int n2 = MapViewerUtils.calculateHeadingValue(s);
        this.target.notifierModel.notifyViewHeadingValueChanged(n2);
        return null;
    }

    public HsmState dsiMapViewerControlUpdateZoomLevel(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateZoomLevel(float, int)( zoomLevel=").append(f2).append(" )").log();
        }
        int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(f2);
        int n3 = (int)(MapViewerUtils.calculateZoomLevelByZoomIndex(n2) / 51266);
        this.target.notifierModel.notifyZoomLevelChanged(n3);
        if (this.target.datapool.isPerspective2DCarUpActive() || this.target.datapool.isPerspective2DNorthUpActive() || this.target.datapool.isPerspective3DCarUpActive()) {
            this.target.datapool.setMapInMapZoomLevel((int)f2);
        } else if (this.target.datapool.isPerspectiveRangeViewActive()) {
            this.target.datapool.setLastZoomLevelRangeview((int)f2);
        }
        return null;
    }

    public HsmState dsiMapViewerZoomEngineUpdateRecommendedZoom(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerZoomEngineUpdateRecommendedZoom( recommendedZoom=").append(f2).append(" )").log();
        }
        if (this.target.datapool.isAutoZoomMapInMap() && (this.target.datapool.isPerspective2DNorthUpActive() || this.target.datapool.isPerspective2DNorthUpActive()) || this.target.datapool.isPerspective3DCarUpActive()) {
            this.target.notifierDSI.setZoomLevel(f2);
            int n2 = MapViewerUtils.calculateZoomIndexByZoomLevel(f2);
            int n3 = (int)(MapViewerUtils.calculateZoomLevelByZoomIndex(n2) / 51266);
            this.target.notifierModel.notifyZoomLevelChanged(n3);
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
            case 1073742398: {
                this.handleSetMapContent(eventGeneric);
                break;
            }
            case 1073742393: {
                this.handleSetCurrentContentG(eventGeneric);
                break;
            }
            case 1073742394: {
                this.handleSetCurrentContentNG(eventGeneric);
                break;
            }
            case 1073742395: {
                break;
            }
            case 1073742396: {
                break;
            }
            case 1073742397: {
                break;
            }
            case 1073742401: {
                this.handleSetMapCarsorPosition(eventGeneric);
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

    private void handleSetCurrentContentG(EventGeneric eventGeneric) {
        this.logger.trace("handleSetCurrentContentG()");
        int n = eventGeneric.getInt(0);
        if (n == 6) {
            this.target.notifierDSI.viewSetVisible();
        } else {
            this.target.notifierDSI.viewSetInvisible();
        }
    }

    private void handleSetCurrentContentNG(EventGeneric eventGeneric) {
        this.logger.trace("handleSetCurrentContentNG()");
        int n = eventGeneric.getInt(0);
        if (n == 4) {
            this.target.notifierDSI.viewSetVisible();
        } else {
            this.target.notifierDSI.viewSetInvisible();
        }
    }

    private void handleSetMapCarsorPosition(EventGeneric eventGeneric) {
        this.logger.trace("handleSetMapCarsorPosition()");
        Point point = this.target.datapool.getMapInMapCarPosition();
        point.xPos = eventGeneric.getInt(0);
        point.yPos = eventGeneric.getInt(1);
        this.target.datapool.setMapInMapCarPosition(point);
        this.target.notifierDSI.setHotPoint(point);
        this.target.notifierDSI.setCarPosition(point);
        this.target.notifierDSI.setLocation(0, (short)0);
    }

    private void handleSetMapContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetMapContent( content=").append(n).append(" )").log();
        }
        int n2 = eventGeneric.getInt(1);
        int n3 = eventGeneric.getInt(2);
        int n4 = eventGeneric.getInt(3);
        int n5 = eventGeneric.getInt(4);
        if (n != 255) {
            this.target.notifierDSI.setZoomArea(new Rect(n2, n3, n5, n4));
            if (n == 0) {
                this.target.datapool.setMapInMapMode(1);
                this.target.notifierDSI.setModePositionMap();
            }
        } else {
            this.target.notifierDSI.viewSetInvisible();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }
}

