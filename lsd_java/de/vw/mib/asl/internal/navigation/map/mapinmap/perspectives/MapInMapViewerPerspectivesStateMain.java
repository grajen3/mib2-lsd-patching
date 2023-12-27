/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Rect;

public class MapInMapViewerPerspectivesStateMain
extends AbstractHsmState {
    private IExtLogger logger;
    private MapInMapViewerPerspectivesTargetHsm target;

    public MapInMapViewerPerspectivesStateMain(MapInMapViewerPerspectivesTargetHsm mapInMapViewerPerspectivesTargetHsm, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapInMapViewerPerspectivesTargetHsm;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesStateInit]");
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
            case 0x40000242: {
                this.handleSetMapPerspective(eventGeneric);
                break;
            }
            case 1073742403: {
                this.handleToggleMapOverviewZoom();
                break;
            }
            case 1073744395: {
                this.handleSetRangeViewEnabled(eventGeneric);
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

    private void handleToggleMapOverviewZoom() {
        this.logger.trace("handleToggleMapOverviewZoom()");
        this.target.transStateOverviewZoom();
    }
}

