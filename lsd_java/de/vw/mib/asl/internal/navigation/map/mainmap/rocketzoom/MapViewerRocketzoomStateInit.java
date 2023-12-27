/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerRocketzoomStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVERS = new int[]{822214720, 1208090688, 1174536256, 1086918720, 201982016, 1342308416, 1375862848, 889323584, 342111488, 358888704, -523759552, -506982336, 1409417280, 1442971712, 1258422336, 771883072};
    private static final int[] ATTRIBUTES_MAPVIEWER = new int[]{11};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerRocketzoomStateInit]");
    private final MapViewerRocketzoomTargetHSM target;

    public MapViewerRocketzoomStateInit(MapViewerRocketzoomTargetHSM mapViewerRocketzoomTargetHSM, String string, HsmState hsmState) {
        super(mapViewerRocketzoomTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerRocketzoomTargetHSM;
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
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
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
        this.initASL();
        this.initDSI();
        this.target.transStateInactive();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        this.target.notifierDSI.setDsiMapViewerControl(DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, ATTRIBUTES_MAPVIEWER));
    }
}

