/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerTouchgesturesStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVERS = new int[]{1258422336, -523759552, -506982336, -83296192, 1191772224, -255324096, 348721216, -305655744, 1288245312, 1305022528, 912536832};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerTouchgesturesStateInit]");
    private final MapViewerTouchgesturesTargetHSM target;

    public MapViewerTouchgesturesStateInit(MapViewerTouchgesturesTargetHSM mapViewerTouchgesturesTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerTouchgesturesTargetHSM;
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
        this.initDSI();
        this.initASL();
        this.target.transStateMain();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.initASLAddObservers();
    }

    private void initASLAddObservers() {
        this.logger.trace("initASLAddObservers()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, null);
        this.target.notifierDSI.setDsiMapViewerControl(dSIMapViewerControlVW);
    }
}

