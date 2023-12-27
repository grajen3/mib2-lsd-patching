/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navmaptile;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.internal.navmaptile.NavMapTileTargetHSM;
import de.vw.mib.asl.internal.navmaptile.util.MapTileLogger;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class NavMapTileStateMainSpeechActive
extends AbstractHsmState {
    private MapTileLogger logger = new MapTileLogger(256, "[NavMapTileStateMainSpeechActive]");
    private NavMapTileTargetHSM target;

    public NavMapTileStateMainSpeechActive(NavMapTileTargetHSM navMapTileTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 8000003: {
                this.handleReinitMapview(eventGeneric);
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

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleUpdateZoomValue(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleUpdateZoomValue() - call ignored, not in main state");
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

    private void handleUpdateMapMode(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleUpdateMapMode() - call ignored, not in main state");
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

    private void handleReinitMapview(EventGeneric eventGeneric) {
        this.target.datapool.prepareConfiguration();
        ASLNavigationMapConfiguration aSLNavigationMapConfiguration = this.target.datapool.createMapConfiguration();
        this.target.navMapService.viewSetVisible();
        this.target.navMapService.goToLocationWithoutLocking(aSLNavigationMapConfiguration);
        this.target.navMapService.autozoomForcedByOtherContext(this.target.datapool.isAutozoomCurrentlyActivated());
        this.target.navMapService.mapVisibleInOtherContext(true);
        this.target.navMapService.setHotPoint(aSLNavigationMapConfiguration.getHotPoint().getXPos(), aSLNavigationMapConfiguration.getHotPoint().getYPos());
        this.target.transStateMain();
    }

    private void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
        this.target.navMapService.autozoomForcedByOtherContext(false);
        this.target.navMapService.mapVisibleInOtherContext(false);
    }
}

