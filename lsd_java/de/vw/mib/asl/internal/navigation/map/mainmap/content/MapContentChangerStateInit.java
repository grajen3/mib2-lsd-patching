/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVER = new int[]{771883072, -60607232, -490205120, -10275584, 1029977344};
    private static final int[] ATTRIBUTES_MAPVIEWERCONTROL = new int[]{16, 9, 22, 13};
    private IExtLogger logger;
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateInit(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
        super(mapContentChangerTargetHSM.getHsm(), string, hsmState);
        this.target = mapContentChangerTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateInit]");
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
                this.handleDefault();
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault() {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initASL();
        this.initDSI();
        this.target.datapool.setZoomLevelMainMapBackup(this.target.datapool.getMainMapZoomLevel());
        this.target.transStateNoMap();
    }

    private void initASL() {
        this.logger.trace("addObservers()");
        ServiceRegister serviceRegister = ServiceManager.eventMain.getServiceRegister();
        serviceRegister.registerService(-60607232, 1632310272);
        serviceRegister.registerService(-10275584, 1632310272);
        this.target.registerService(1029977344, false);
        this.target.addObservers(ASL_OBSERVER);
    }

    private void initDSI() {
        this.logger.trace("initDSIMapViewer()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWERCONTROL));
    }
}

