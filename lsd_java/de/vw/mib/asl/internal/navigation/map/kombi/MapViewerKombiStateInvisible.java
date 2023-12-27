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

public class MapViewerKombiStateInvisible
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateInvisible]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateInvisible(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
    }

    public HsmState dsiMapViewerControlUpdateViewVisible(boolean bl, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerControlUpdateViewVisible(visible=").append(bl).append(")").log();
        }
        if (!bl) {
            this.target.notifierModel.notifyKombiMapInvisible();
        }
        return null;
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
            case 1074841846: {
                this.handleMapKombiSetInvisible();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleMapKombiSetInvisible() {
        this.logger.trace("handleMapKombiSetInvisible() - the Kombi MapViewer is already invisible, event will be ignored");
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
        this.target.notifierDSI.viewSetInvisible();
    }
}

