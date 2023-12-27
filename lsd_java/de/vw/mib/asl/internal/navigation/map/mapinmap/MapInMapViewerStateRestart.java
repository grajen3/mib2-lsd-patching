/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerStateRestart
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerStateRestart]");
    private final MapInMapViewerTargetHsm target;

    public MapInMapViewerStateRestart(MapInMapViewerTargetHsm mapInMapViewerTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerTargetHsm;
    }

    public void dsiMapViewerControlUpdateViewFreeze(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewFreeze(viewFreeze=").append(bl).append(")").log();
        }
        if (!bl) {
            if (this.target.datapool.isOverviewZoomActive() && ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getRGIsActive()) {
                this.target.transStateOverviewZoom();
                return;
            }
            int n2 = this.target.datapool.getMapInMapOrientation();
            switch (n2) {
                case 0: {
                    this.target.transState2DNorthUp();
                    break;
                }
                case 1: {
                    this.target.transState2DCarUp();
                    break;
                }
                case 2: {
                    this.target.transState3DCarUp();
                    break;
                }
                default: {
                    this.target.transState2DCarUp();
                }
            }
        }
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
            case 3499016: {
                this.initDSIMapViewer();
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
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void initDSIMapViewer() {
        this.logger.trace("initDSIMapViewer()");
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setCityModelModeOff();
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.setGeneralPoiVisibilityFalse();
        this.target.notifierDSI.viewSetInvisible();
        this.target.notifierDSI.viewFreezeFalse();
    }
}

