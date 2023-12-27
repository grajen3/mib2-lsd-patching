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

public class NavMapTileStateInit
extends AbstractHsmState {
    private MapTileLogger logger = new MapTileLogger(256, "[NavMapTileStateInit]");
    private NavMapTileTargetHSM target;

    public NavMapTileStateInit(NavMapTileTargetHSM navMapTileTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 8000001: {
                this.logger.trace("handleNaviServiceReady()");
                this.target.initServices();
                this.target.datapool.setPerspective(this.target.navMapService.getMainMapPerspective());
                this.target.datapool.setZoomLevel(this.target.navMapService.getMainMapZoomLevel());
                this.target.datapool.setAutozoomActivated(this.target.navMapService.isAutozoomActivated());
                this.target.notifierModel.notifyMapTypeChanged(this.target.navMapService.getMapType() - 1);
                this.target.notifierModel.notifyLastMapTypeChanged(this.target.navMapService.getLastMapType() - 1);
                this.target.notifierModel.notifyZoomValueChanged(this.target.getMainmapZoomLevel());
                this.target.notifierModel.notifyAutozoom(this.target.datapool.isAutozoomActivated());
                this.target.notifierModel.notifyPerspectiveChanged(this.target.datapool.getPerspective());
                this.target.notifierModel.notifyHeadingValueChanged(this.target.navMapService.getHeadingValue());
                this.target.notifierModel.notifyNavReady();
                this.target.notifySetupTrafficSignMode(this.target.navGuidanceService.getSetupTrafficSignMode());
                this.target.transStateMainInactive();
                break;
            }
            case 1079541832: {
                this.handleSetContent(eventGeneric);
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
            case 1079541833: {
                this.handleStopGuidance();
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
            this.logger.trace("handleSetCarsorPosition() - call ignored, not in main state");
        }
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetContent() - call ignored, not in main state");
        }
    }

    private void handleSetHotPoint(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleSetHotPoint() - call ignored, not in main state");
        }
    }

    private void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
    }

    private void handleStopGuidance() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStopGuidance() - call ignored, not in main state");
        }
    }

    private void handleToggleOverviewZoom() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleToggleOverviewZoom() - call should not happen, not in main state");
        }
    }
}

