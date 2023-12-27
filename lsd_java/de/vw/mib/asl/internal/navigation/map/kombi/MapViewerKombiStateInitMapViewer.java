/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateInitMapViewer
extends AbstractHsmState {
    private static final int[] ATTRIBUTES_MAPVIEWER_CONTROL = new int[]{8, 7, 45, 40};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateInitMapViewer]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateInitMapViewer(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
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

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
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
        if (!this.target.isFirstStartupDone) {
            DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerKombi(this.target, ATTRIBUTES_MAPVIEWER_CONTROL);
            this.target.notifierDSI.setMapViewerControl(dSIMapViewerControlVW);
            this.target.addDayNightModeListener();
            this.target.notifierModel.notifyKombiStatusStarting();
        }
        this.target.transStateInitMapViewerConfigure();
    }
}

