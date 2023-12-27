/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerZoomEngineFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerStateInit
extends AbstractHsmState {
    public static final int[] ATTRIBUTES_MAPVIEWERCONTROL = new int[]{14, 12, 9, 8};
    private static final int[] ATTRIBUTES_MAPVIEWERZOOMENGINE = new int[]{3};
    private static final int[] OBSERVERS = new int[]{956432448, 973209664, 1040318528, 1090650176, 0x42020040, 185204800, 1124204608, 0x44020040, 80285760, 97062976, 164171840, 929314048, 946091264};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerStateInit]");
    private final MapInMapViewerTargetHsm target;

    public MapInMapViewerStateInit(MapInMapViewerTargetHsm mapInMapViewerTargetHsm, String string, HsmState hsmState) {
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
            case 101003: {
                this.handleNaviTargetPrepareOn(eventGeneric);
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

    private void handleNaviTargetPrepareOn(EventGeneric eventGeneric) {
        this.logger.trace("handleNaviTargetPrepareOn()");
        this.target.addObservers(OBSERVERS);
        this.initDSI();
        this.initModel();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void initDSI() {
        this.initDSIMapViewer();
        this.initDSIMapViewerZoomEngine();
    }

    private void initDSIMapViewer() {
        this.logger.trace("initDSIMapViewer()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerSplitscreen(this.target, ATTRIBUTES_MAPVIEWERCONTROL);
        this.target.notifierDSI.setDsiMapViewerControl(dSIMapViewerControlVW);
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setCityModelModeOff();
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.setGeneralPoiVisibilityFalse();
        this.target.notifierDSI.viewSetInvisible();
        this.target.notifierDSI.viewFreezeFalse();
    }

    private void initDSIMapViewerZoomEngine() {
        this.logger.trace("initDSIMapViewerZoomEngine()");
        DSIMapViewerZoomEngineVW dSIMapViewerZoomEngineVW = DSIMapViewerZoomEngineFactoryVW.createMapViewerZoomEngine(this.target, ATTRIBUTES_MAPVIEWERZOOMENGINE);
        this.target.notifierDSI.setDsiMapViewerZoomEngineVW(dSIMapViewerZoomEngineVW);
    }

    private void initModel() {
        this.logger.trace("initModel()");
        boolean bl = this.target.datapool.isAutoZoomMapInMap();
        if (bl) {
            this.target.notifierModel.notifyMapAutoZoomActive();
        } else {
            this.target.notifierModel.notifyMapAutoZoomInactive();
        }
    }
}

