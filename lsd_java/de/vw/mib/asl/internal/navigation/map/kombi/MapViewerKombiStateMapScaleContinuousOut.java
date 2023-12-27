/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.kombi.AbstractMapViewerKombiStateMapScaleContinuous;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateMapScaleContinuousOut
extends AbstractMapViewerKombiStateMapScaleContinuous {
    private static final int STEP_VALUE;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateMapScaleContinuousOut]");
    private EventGeneric event;

    public MapViewerKombiStateMapScaleContinuousOut(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM, string, hsmState);
    }

    @Override
    protected void handleEntry() {
        super.handleEntry();
        this.logger.trace("handleEntry()");
        this.event = this.eventFactory.newEvent(this.target.getTargetId(), this.target.getTargetId(), -1274412992);
        this.event.setInt(0, -1);
    }

    @Override
    protected void handleStart() {
        super.handleStart();
        this.logger.trace("handleStart()");
        this.timerServer.restartOrStartTimedEvent(this.event, 0, true);
    }

    @Override
    protected void handleExit() {
        super.handleExit();
        this.timerServer.stopTimedEvent(this.target.getTargetId(), -1274412992);
    }
}

