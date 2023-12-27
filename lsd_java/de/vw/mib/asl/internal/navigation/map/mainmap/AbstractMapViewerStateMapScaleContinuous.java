/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerTargetHSM;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventFactory;
import de.vw.mib.genericevents.TimerServer;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class AbstractMapViewerStateMapScaleContinuous
extends AbstractHsmState {
    private final IExtLogger logger;
    protected final MapViewerTargetHSM target;
    protected PersistedMapSetup persistency = PersistedMapSetup.getInstance();
    protected final GenericEventFactory eventFactory = new GenericEventFactory();
    protected static final int EVENTS_INTERVAL;
    final ASLNavigationMapAPI map;
    final MapDataPool datapool;
    final TimerServer timerServer;

    public AbstractMapViewerStateMapScaleContinuous(MapViewerTargetHSM mapViewerTargetHSM, String string, HsmState hsmState) {
        super(mapViewerTargetHSM.getHsm(), string, hsmState);
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - AbstractMapViewerKombiStateMapScale]");
        this.target = mapViewerTargetHSM;
        this.map = ASLNavigationMapFactory.getNavigationMapApi();
        this.datapool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
        this.timerServer = mapViewerTargetHSM.getTimerServer();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        block0 : switch (eventGeneric.getReceiverEventId()) {
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
            case 1073744564: {
                int n = eventGeneric.getInt(0);
                switch (n) {
                    case 0: {
                        this.logger.trace("AbstractMapViewerKombiStateMapScaleContinuous is going to finish continuous zoom. Got step 0 event - meaning stop zoom.");
                        this.trans(this.myParent);
                        break block0;
                    }
                    case -1: 
                    case 1: {
                        this.handleDefault(eventGeneric);
                        return this.myParent;
                    }
                    case -128: 
                    case 127: {
                        this.logger.warn("AbstractMapViewerKombiStateMapScaleContinuous got continuous zoom event more than once. The continuous zoom has already been started.");
                    }
                }
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    protected void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    protected void handleEntry() {
        this.logger.trace("handleEntry()");
        this.target.datapoolShared.setContinuousZoomActive(true);
    }

    protected void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapoolShared.setContinuousZoomActive(false);
    }

    protected void handleStart() {
        this.logger.trace("handleStart()");
    }
}

