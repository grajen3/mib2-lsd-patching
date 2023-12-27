/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.perspectives;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerPerspectivesStateCarUp3D
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerPerspectivesStateCarUp3D]");
    private final MapViewerPerspectivesTargetHSM target;

    public MapViewerPerspectivesStateCarUp3D(MapViewerPerspectivesTargetHSM mapViewerPerspectivesTargetHSM, String string, HsmState hsmState) {
        super(mapViewerPerspectivesTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerPerspectivesTargetHSM;
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
            this.logger.makeTrace().append("handleDefault() ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setPerspective3DDTM(false);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setMainMapPerspective(4);
        this.target.datapool.setPerspective3DDTM(true);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setViewType3D();
        this.target.notifierDSI.setOrientationHeadingUp();
        this.target.notifierDSI.setCityModelModeEnhanced();
        this.target.notifierDSI.set3DLandmarksVisible();
        if (!this.target.datapool.isAutoZoomMainMap() && MapViewerUtils.isMainMapMaximumZoomListIndexFor3DReached()) {
            this.target.datapool.setMainMapZoomLevel(1078071040);
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainZoomLevelChanged(1078071040);
        }
        this.target.notifierDSI.viewFreezeFalse();
        this.target.notifierModel.notifyPerspective3DDTM();
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainMapPerspectiveStateChanged(6);
    }
}

