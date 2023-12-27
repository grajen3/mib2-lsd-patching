/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.hknav;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class MapViewerHKNavStateInit
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerHKNavStateInit]");
    private final MapViewerHKNavTargetHSM target;
    private static final int[] ASL_OBSERVERS = new int[]{771883072};

    public MapViewerHKNavStateInit(MapViewerHKNavTargetHSM mapViewerHKNavTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerHKNavTargetHSM;
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
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params=").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleEntry()");
        }
    }

    private void handleExit() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleExit()");
        }
    }

    private void handleStart() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("handleStart()");
        }
        this.initDSI();
        this.initASL();
        this.target.transStateMain();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        DSIMapViewerControlVW dSIMapViewerControlVW = DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, null);
        this.target.notifierDSI.setDsiMapViewerControl(dSIMapViewerControlVW);
    }
}

