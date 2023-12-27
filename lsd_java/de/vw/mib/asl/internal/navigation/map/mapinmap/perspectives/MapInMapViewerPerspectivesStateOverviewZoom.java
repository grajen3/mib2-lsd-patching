/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapInMapViewerPerspectivesStateOverviewZoom
extends AbstractHsmState {
    private final IExtLogger logger;
    private final MapInMapViewerPerspectivesTargetHsm target;

    public MapInMapViewerPerspectivesStateOverviewZoom(MapInMapViewerPerspectivesTargetHsm mapInMapViewerPerspectivesTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerPerspectivesTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerPerspectivesTargetHsm;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesStateOverviewZoom]");
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() evId: ").append(eventGeneric.getReceiverEventId()).append(",Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setPerspectiveOverviewZoomActive(false);
        if (this.target.datapool.isAutoZoomMapInMap()) {
            this.target.mapAPI.sendEvMapInMapPerspectiveChanged();
        }
        this.target.notifierModel.notifyOverviewZoomOff();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setPerspectiveOverviewZoomActive(true);
        this.target.datapool.setMapInMapMode(10);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeOverviewMap();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setOrientationNorthUp();
        this.target.notifierDSI.viewSetVisible();
        this.target.notifierDSI.viewFreezeFalse();
        if (this.target.datapool.isAutoZoomMapInMap()) {
            this.target.mapAPI.sendEvMapInMapPerspectiveChanged();
        }
        this.target.notifierModel.notifyOverviewZoomOn();
    }
}

