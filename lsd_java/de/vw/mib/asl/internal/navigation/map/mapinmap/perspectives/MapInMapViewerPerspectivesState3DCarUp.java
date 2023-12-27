/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mapinmap.perspectives.MapInMapViewerPerspectivesTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapInMapViewerPerspectivesState3DCarUp
extends AbstractHsmState {
    private final IExtLogger logger;
    private final MapInMapViewerPerspectivesTargetHsm target;

    public MapInMapViewerPerspectivesState3DCarUp(MapInMapViewerPerspectivesTargetHsm mapInMapViewerPerspectivesTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerPerspectivesTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerPerspectivesTargetHsm;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerPerspectivesState3DCarUp]");
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
            this.logger.makeTrace().append("handle(): DEFAULT ev.Id=").append(eventGeneric.getReceiverEventId()).append(",Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setPerspective3DCarUpActive(false);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setPerspective3DCarUpActive(true);
        this.target.datapool.setMapInMapPersepctive(2);
        int n = this.target.zoomLevelDependingOnAutoZoom();
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setViewType3D();
        this.target.notifierDSI.setOrientationHeadingUp();
        this.target.notifierDSI.setZoomLevel(n);
        this.target.notifierDSI.viewSetVisible();
        this.target.notifierDSI.viewFreezeFalse();
        this.target.notifierModel.notifyPerspectiveIs3DHeading();
        int n2 = MapViewerUtils.calculateZoomLevelNormalized(n);
        this.target.notifierModel.notifyZoomLevelChanged(n2);
    }
}

