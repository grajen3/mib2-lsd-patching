/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerStateMain
extends AbstractHsmState {
    private IExtLogger logger;
    private MapInMapViewerTargetHsm target;
    private static final String VARIANT = ServiceManager.configManagerDiag.getPureVariant();

    public MapInMapViewerStateMain(MapInMapViewerTargetHsm mapInMapViewerTargetHsm, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
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
        if (this.target.datapool.isAutoZoomMapInMap() && (this.target.datapool.isPerspective2DNorthUpActive() || this.target.datapool.isPerspective2DCarUpActive() || this.target.datapool.isPerspective3DCarUpActive())) {
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
            case 1074841860: {
                this.handleTwoFingerZoomed(eventGeneric);
                break;
            }
            case 1074841861: {
                this.handleTwoFingerDragged(eventGeneric);
                break;
            }
            case 1073742401: {
                this.handleSetMapCarsorPosition(eventGeneric);
                break;
            }
            case 0x40000242: {
                this.handleSetMapPerspective(eventGeneric);
                break;
            }
            case 1073742403: {
                this.handleToggleMapOverviewZoom();
                break;
            }
            case 0x40000244: {
                this.handleToggleMapAutoZoom();
                break;
            }
            case 1073744395: {
                this.handleSetRangeViewEnabled(eventGeneric);
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
                this.handleSetMapContentPositionMap();
            } else if (n == 1) {
                this.target.transStateOverviewZoom();
            }
        } else {
            this.target.notifierDSI.viewSetInvisible();
        }
    }

    private void handleSetMapContentPositionMap() {
        this.logger.trace("handleSetMapContentPositionMap()");
        this.target.datapool.setMapInMapMode(1);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModePositionMap();
        this.target.notifierDSI.viewFreezeFalse();
    }

    private void handleSetMapPerspective(EventGeneric eventGeneric) {
        this.logger.trace("handleSetMapPerspective()");
        int n = eventGeneric.getInt(0);
        switch (n) {
            case 0: {
                this.handleSetMapPerspective2DNorth();
                break;
            }
            case 1: {
                this.handleSetMapPerspective2DHeading();
                break;
            }
            case 2: {
                this.handleSetMapPerspective3DHeading();
                break;
            }
            default: {
                this.logger.warn("handleSetMapPerspectiveDefault() - undefined perspective");
            }
        }
    }

    private void handleSetMapPerspective2DHeading() {
        this.logger.trace("handleSetMapPerspective2DHeading()");
        this.target.transState2DCarUp();
    }

    private void handleSetMapPerspective2DNorth() {
        this.logger.trace("handleSetMapPerspective2DNorth()");
        this.target.transState2DNorthUp();
    }

    private void handleSetMapPerspective3DHeading() {
        this.logger.trace("handleSetMapPerspective3DHeading()");
        this.target.transState3DCarUp();
    }

    private void handleSetRangeViewEnabled(EventGeneric eventGeneric) {
        this.logger.trace("handleSetRangeViewEnabled()");
        boolean bl = eventGeneric.getBoolean(0);
        if (bl) {
            this.target.transStateRangeView();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleToggleMapAutoZoom() {
        this.target.datapool.setAutoZoomMapInMap(!this.target.datapool.isAutoZoomMapInMap());
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("toogleAutoZoomMapInMap(").append(this.target.datapool.isAutoZoomMapInMap()).append(") ").log();
        }
        if (!this.target.datapool.isAutoZoomMapInMap()) {
            this.target.notifierModel.notifyMapAutoZoomInactive();
            return;
        }
        this.target.notifierModel.notifyMapAutoZoomActive();
        if (this.target.datapool.getMapInMapMode() == 1) {
            this.logger.trace("toogleAutoZoomMapInMap() AutoZoom=ON");
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("toogleAutoZoomMapInMap set recommendedZoom=").append(this.target.datapool.getAutoZoomRecommendedZoomLast()).log();
            }
            float f2 = this.target.datapool.getAutoZoomRecommendedZoomLast();
            this.target.notifierDSI.setZoomLevel(f2);
            int n = MapViewerUtils.calculateZoomLevelNormalized(f2);
            this.target.notifierModel.notifyZoomLevelChanged(n);
        } else {
            this.logger.warn("autozoom level not set because the carsor is not infocus");
        }
    }

    private void handleToggleMapOverviewZoom() {
        this.logger.trace("handleToggleMapOverviewZoom()");
        this.target.transStateOverviewZoom();
    }

    private void handleTwoFingerDragged(EventGeneric eventGeneric) {
        this.logger.trace("handleTwoFingerDragged()");
    }

    private void handleTwoFingerZoomed(EventGeneric eventGeneric) {
        this.logger.trace("handleTwoFingerZoomed()");
        if (this.target.datapool.isOverviewZoomActive() || this.target.datapool.isPerspectiveRangeViewActive()) {
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

    private void handleSpeechRecognizerInactive() {
        if (VARIANT.startsWith("HIGH2") && this.target.datapool.isSplitscreenMapVisible()) {
            this.logger.trace("handleSpeechRecognizerInactive");
            this.logger.trace("Map shown, therefore set view to visible again");
            this.target.notifierDSI.viewSetVisible();
        }
    }

    private void handleSpeechRecognizerActive() {
        if (VARIANT.startsWith("HIGH2")) {
            this.logger.trace("handleSpeechRecognizerActive - set map to invisible");
            this.target.notifierDSI.viewSetInvisible();
        }
    }
}

