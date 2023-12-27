/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerStreetviewStateStreetViewInvisible
extends AbstractHsmState {
    private final IExtLogger logger;
    private final MapViewerStreetviewTargetHSM target;

    public MapViewerStreetviewStateStreetViewInvisible(MapViewerStreetviewTargetHSM mapViewerStreetviewTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerStreetviewTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerStreetviewStateStreetViewInvisible]");
    }

    public HsmState dsiMapViewerStreetViewCtrlStreetViewEnabled(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerStreetViewCtrlStreetViewEnabled(").append(bl).append(")").log();
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
            this.logger.makeTrace().append("handleDefault(").append(eventGeneric.toString()).append(")").log();
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
        this.target.notifierDSI.streetViewLoadFalse();
        this.target.notifierDSI.streetViewSetCrosshairInvisible();
        this.target.notifierDSI.streetViewSetInvisible();
        this.target.notifierDSI.streetViewSetViewFreezeTrue();
        this.target.notifierDSI.mapViewerViewSetVisible();
    }
}

