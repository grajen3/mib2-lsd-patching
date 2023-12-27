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
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class NavMapTileStateMain
extends AbstractHsmState {
    private MapTileLogger logger = new MapTileLogger(256, "[NavMapTileStateMain]");
    private NavMapTileTargetHSM target;

    public NavMapTileStateMain(NavMapTileTargetHSM navMapTileTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 1079541832: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 1079541827: {
                break;
            }
            case 1079541826: {
                this.handleSetHotPoint(eventGeneric);
                break;
            }
            case 8000004: {
                this.handleMapViewUsedBy(eventGeneric);
                break;
            }
            case 8000002: {
                this.handleUpdateZoomValue(eventGeneric);
                break;
            }
            case 8000005: {
                this.handleUpdateMapMode(eventGeneric);
                break;
            }
            case 8000006: {
                this.handleGuidanceStateChanged(eventGeneric);
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
                this.disableOverview();
            }
        } else if (this.target.datapool.isGuidanceActive()) {
            this.target.datapool.setMapMode(1);
            boolean bl = this.target.navMapService.isAutozoomActivated() || this.target.navMapService.isAutozoomDeactivatedWhileDrag();
            this.target.setAutoozoom(bl);
            this.target.navMapService.autozoomForcedByOtherContext(bl);
            this.target.navMapService.goToLocationWithoutLocking(this.target.datapool.createMapConfiguration());
        }
    }

    private void handleUpdateMapMode(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("handleUpdateMapMode( mapMode = ").append(n).append(")").toString());
        }
        this.target.datapool.setMapMode(n);
    }

    private void handleMapViewUsedBy(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleMapViewUsedBy()");
        }
        this.target.transStateMainSpeechActive();
    }

    private void handleUpdateZoomValue(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.target.datapool.isPerspectiveOverview()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("handleUpdateZoomValue( zoomValue = ").append(n).append(" - saved to overview)").toString());
            }
            this.target.datapool.setZoomLevelOverview(n);
        } else if (this.target.datapool.isPerspectiveMain()) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace(new StringBuffer().append("handleUpdateZoomValue( zoomValue = ").append(n).append(" - saved to main)").toString());
            }
            this.target.datapool.setZoomLevelMain(n);
        }
        this.target.datapool.setZoomLevel(n);
        this.target.notifierModel.notifyZoomValueChanged(n);
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
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

    private void handleSetCarsorPosition(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetCarsorPosition()");
        }
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        this.target.datapool.setCarPosition(new Point(n, n2));
        this.target.navMapService.setCarsorPosition(n, n2);
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n;
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetContent()");
        }
        if ((n = eventGeneric.getInt(0)) == 0) {
            Rect rect = this.target.getZoomArea(eventGeneric);
            this.target.datapool.setZoomArea(rect);
            this.target.navMapService.viewSetVisible();
            if (this.target.datapool.isConfigureRequired()) {
                this.target.datapool.prepareConfiguration();
                this.target.navMapService.goToLocationWithoutLocking(this.target.datapool.createMapConfiguration());
            } else {
                this.target.navMapService.setZoomArea(this.target.datapool.getZoomArea().getKordX(), this.target.datapool.getZoomArea().getKordY(), this.target.datapool.getZoomArea().getDiffX(), this.target.datapool.getZoomArea().getDiffY());
            }
            this.target.setManeuverViewStyle(true);
            this.target.navMapService.autozoomForcedByOtherContext(this.target.datapool.isAutozoomCurrentlyActivated());
            this.target.navMapService.mapVisibleInOtherContext(true);
        }
        if (n == 1) {
            this.target.setManeuverViewStyle(false);
            this.target.navMapService.autozoomForcedByOtherContext(false);
            this.target.navMapService.mapVisibleInOtherContext(false);
            this.target.transStateMainInactive();
            this.target.navMapService.viewSetInvisible();
        }
    }

    private void handleSetHotPoint(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetHotPoint()");
        }
        int n = eventGeneric.getInt(0);
        int n2 = eventGeneric.getInt(1);
        this.target.datapool.setHotPoint(new Point(n, n2));
        this.target.navMapService.setHotPoint(n, n2);
    }

    private void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
    }

    private void handleStopGuidance() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStopGuidance()");
        }
        this.target.navGuidanceService.stopGuidance();
        if (this.target.isPerspectiveNoGuidanceValid(this.target.datapool.getPerspective())) {
            this.target.datapool.setPerspective(this.target.datapool.getPerspectiveNoGuidance());
            this.disableOverview();
        }
    }

    private void disableOverview() {
        this.target.datapool.prepareDefaultConfiguration();
        this.target.navMapService.goToLocationWithoutLocking(this.target.datapool.createMapConfiguration());
        this.target.notifierModel.notifyAutozoom(this.target.datapool.isAutozoomCurrentlyActivated());
        this.target.navMapService.autozoomForcedByOtherContext(this.target.datapool.isAutozoomCurrentlyActivated());
    }
}

