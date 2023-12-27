/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerZoomEngineFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mapinmap.autozoom.MapInMapViewerAutoZoomTargetHsm;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapInMapViewerAutoZoomStateInit
extends AbstractHsmState {
    private static final int[] ATTRIBUTES_MAPVIEWERZOOMENGINE = new int[]{3};
    private static final int[] OBSERVERS = new int[]{0x44020040, 862205184, 878982400};
    private static final int[] SERVICES = new int[]{862205184, 878982400};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapInMapViewerAutoZoomStateInit]");
    private final MapInMapViewerAutoZoomTargetHsm target;

    public MapInMapViewerAutoZoomStateInit(MapInMapViewerAutoZoomTargetHsm mapInMapViewerAutoZoomTargetHsm, String string, HsmState hsmState) {
        super(mapInMapViewerAutoZoomTargetHsm.getHsm(), string, hsmState);
        this.target = mapInMapViewerAutoZoomTargetHsm;
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
        this.initDSI();
        this.initModel();
        this.initASL();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.transStateWork();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.registerServices(SERVICES, true);
        this.target.addObservers(OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.initDSIMapViewer();
        this.initDSIMapViewerZoomEngine();
    }

    private void initDSIMapViewer() {
        this.logger.trace("initDSIMapViewer()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerSplitscreen(this.target, null);
        this.target.notifierDSI.setDsiMapViewerControl(dSIMapViewerControlVW);
    }

    private void initDSIMapViewerZoomEngine() {
        this.logger.trace("initDSIMapViewerZoomEngine()");
        DSIMapViewerZoomEngineVW dSIMapViewerZoomEngineVW = DSIMapViewerZoomEngineFactoryVW.createMapViewerZoomEngine(this.target, ATTRIBUTES_MAPVIEWERZOOMENGINE);
        this.target.notifierDSI.setDsiMapViewerZoomEngineVW(dSIMapViewerZoomEngineVW);
        this.target.notifierDSI.autoZoomEnable(true);
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

