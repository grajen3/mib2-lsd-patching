/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.map.Rect;

public class MapViewerMapSwitchStateAtAbt
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchStateAtAbt]");
    private MapViewerMapSwitchTargetHSM target;
    private static final Rect SCREEN_VIEW_PORT_MAP_MAIN = new Rect(0, 0, 800, 480);

    public MapViewerMapSwitchStateAtAbt(MapViewerMapSwitchTargetHSM mapViewerMapSwitchTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerMapSwitchTargetHSM;
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setMapFPKSwitchRunning(true);
        this.target.notifierDSI.setScreenViewport(SCREEN_VIEW_PORT_MAP_MAIN);
        this.target.notifierDSI.setZoomArea(ASLNavigationMapConfiguration.ZOOM_AREA_DEFAULT);
        if (this.target.datapool.getMainMapCurrentContent() == 255 && !this.target.datapool.isSwitchDoneAtLockMapViewer()) {
            this.logger.trace("Current Content is NO_MAP so we have to call viewSetVisible(false)");
            this.target.notifierDSI.viewSetInvisible();
            this.target.datapool.setViewVisible(false);
        } else {
            this.target.notifierDSI.viewSetVisible();
            this.target.datapool.setViewVisible(true);
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }
}

