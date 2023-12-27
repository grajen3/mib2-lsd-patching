/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.AbstractMapViewerStateMapScaleContinuous;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerStateMapScaleContinuousIn
extends AbstractMapViewerStateMapScaleContinuous {
    private static final int STEP_VALUE;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateMapScaleContinuousIn]");
    private EventGeneric event;

    public MapViewerStateMapScaleContinuousIn(MapViewerTargetHSM mapViewerTargetHSM, String string, HsmState hsmState) {
        super(mapViewerTargetHSM, string, hsmState);
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

