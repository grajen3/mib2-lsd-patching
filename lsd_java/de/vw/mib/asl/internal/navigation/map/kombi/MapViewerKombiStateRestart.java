/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateRestart
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateRestart]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateRestart(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
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
            case 3499012: {
                this.handleMapKombiReady();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return null;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(") - ignoring all events until the kombi mapviewer is ready again").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleMapKombiReady() {
        this.logger.trace("handleMapKombiReady()");
        this.target.transStateInitMapViewer();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierModel.notifyKombiStatusRestarting();
        this.target.notifierModel.notifyKombiMapInvisible();
    }
}

