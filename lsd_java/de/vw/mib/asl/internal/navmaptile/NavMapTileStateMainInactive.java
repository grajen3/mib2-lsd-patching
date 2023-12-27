/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.internal.navmaptile.NavMapTileTargetHSM;
import de.vw.mib.asl.internal.navmaptile.util.MapTileLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Rect;

public class NavMapTileStateMainInactive
extends AbstractHsmState {
    private MapTileLogger logger = new MapTileLogger(256, "[NavMapTileStateMainInactive]");
    private NavMapTileTargetHSM target;

    public NavMapTileStateMainInactive(NavMapTileTargetHSM navMapTileTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = navMapTileTargetHSM;
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
            case 8000005: {
                this.handleUpdateMapMode(eventGeneric);
                break;
            }
            case 8000004: {
                break;
            }
            case 8000006: {
                this.handleGuidanceStateChanged(eventGeneric);
                break;
            }
            case 1079541832: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 8000002: {
                this.handleUpdateZoomValue(eventGeneric);
                break;
            }
            case 1079541827: {
                this.handleToggleOverviewZoom();
                break;
            }
            case 1079541826: {
                this.handleSetHotPoint(eventGeneric);
                break;
            }
            case 1079541825: {
                this.handleSetCarsorPosition(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleUpdateMapMode(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.isMapModeValidInTileContext(n)) {
            if (this.target.datapool.getPerspectiveCurrent() != 99) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace(new StringBuffer().append("handleUpdateMapMode( mapMode = ").append(n).append(")").toString());
                }
                this.target.datapool.setMapMode(n);
            } else if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("handleUpdateMapMode( mapMode = ").append(n).append(") - ignored because main map perspective").toString());
            }
        }
    }

    private boolean isMapModeValidInTileContext(int n) {
        return n == 10 || n == 2 || n == 3 || n == 1 || n == 9 || n == 14;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleUpdateZoomValue(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.datapool.isPerspectiveCurrentOverview()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("handleUpdateZoomValue( zoomValue = ").append(n).append(" - saved to overview)").toString());
            }
            this.target.datapool.setZoomLevelOverview(n);
        } else if (this.target.datapool.isPerspectiveCurrentMain()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("handleUpdateZoomValue( zoomValue = ").append(n).append(" - saved to main)").toString());
            }
            this.target.datapool.setZoomLevelMain(n);
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleUpdateZoomValue() - ignored because no known perspective");
        }
    }

    private void handleSetCarsorPosition(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetCarsorPosition() - call ignored, not in main state");
        }
    }

    private void handleSetHotPoint(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetHotPoint() - call ignored, not in main state");
        }
    }

    private void handleToggleOverviewZoom() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleToggleOverviewZoom() - call should not happen, not in main state");
        }
    }

    private void handleEntry() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleEntry()");
        }
    }

    private void handleExit() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleExit()");
        }
    }

    private void handleGuidanceStateChanged(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleGuidanceStateChanged()");
        }
        if (!this.target.datapool.isGuidanceActive()) {
            if (this.target.datapool.getPerspective() == 3 || this.target.datapool.getPerspective() == 1 || this.target.datapool.getPerspective() == 2) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.trace("activate no guidance perspective");
                }
                this.target.datapool.setPerspective(this.target.datapool.getPerspectiveNoGuidance());
            }
            this.target.datapool.prepareDefaultConfiguration();
        } else if (this.target.datapool.isGuidanceActive()) {
            this.target.datapool.prepareDefaultConfiguration();
        }
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetContent()");
        }
        if ((n = eventGeneric.getInt(0)) == 0) {
            Rect rect = this.target.getZoomArea(eventGeneric);
            this.target.datapool.setZoomArea(rect);
            this.decideZoomLevel();
            this.target.notifierModel.notifyAutozoom(this.target.datapool.isAutozoomCurrentlyActivated());
            this.target.navMapService.viewSetVisible();
            if (this.target.datapool.isConfigureRequired()) {
                this.target.datapool.prepareConfiguration();
                this.target.navMapService.goToLocationWithoutLocking(this.target.datapool.createMapConfiguration());
            } else {
                this.target.navMapService.setZoomArea(this.target.datapool.getZoomArea().getKordX(), this.target.datapool.getZoomArea().getKordY(), this.target.datapool.getZoomArea().getDiffX(), this.target.datapool.getZoomArea().getDiffY());
            }
            this.target.setManeuverViewStyle(true);
            if (this.target.datapool.isAutozoomCurrentlyActivated()) {
                this.target.navMapService.autozoomForcedByOtherContext(this.target.datapool.isAutozoomCurrentlyActivated());
            }
            this.target.navMapService.mapVisibleInOtherContext(true);
            this.target.transStateMain();
        }
    }

    private void decideZoomLevel() {
        if (this.target.datapool.isPerspectiveOverview() && this.target.datapool.getZoomLevelOverview() != 0) {
            this.target.notifierModel.notifyZoomValueChanged(this.target.datapool.getZoomLevelOverview());
            this.target.datapool.setZoomLevel(this.target.datapool.getZoomLevelOverview());
        } else if (this.target.datapool.isPerspectiveMain() && this.target.datapool.getZoomLevelMain() != 0) {
            this.target.notifierModel.notifyZoomValueChanged(this.target.datapool.getZoomLevelMain());
            this.target.datapool.setZoomLevel(this.target.datapool.getZoomLevelMain());
        } else {
            this.target.notifierModel.notifyZoomValueChanged(this.target.getMainmapZoomLevel());
            this.target.datapool.setZoomLevel(this.target.getMainmapZoomLevel());
            this.target.datapool.setZoomLevelOverview(this.target.getMainmapZoomLevel());
            this.target.datapool.setZoomLevelMain(this.target.getMainmapZoomLevel());
        }
    }

    private void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
    }
}

