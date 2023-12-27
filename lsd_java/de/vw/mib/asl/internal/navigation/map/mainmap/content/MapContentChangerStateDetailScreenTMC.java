/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateDetailScreenTMC
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateDetailScreenTMC]");
    private MapContentChangerTargetHSM target;
    private boolean poisWasVisible;
    private boolean tmcWasNotVisible;

    public MapContentChangerStateDetailScreenTMC(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
        super(mapContentChangerTargetHSM.getHsm(), string, hsmState);
        this.target = mapContentChangerTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 2: {
                this.handleEntry();
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(", params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.notifierDSI.ensureTMCVisibility(0L);
        if (this.poisWasVisible) {
            this.poisWasVisible = false;
            this.target.notifierDSI.setGeneralPoiVisibility(true);
        }
        if (this.tmcWasNotVisible) {
            this.tmcWasNotVisible = false;
            this.target.notifierDSI.showTMCMessages(false);
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        MapConfiguration mapConfiguration = this.target.datapool.getMapConfiguration();
        this.target.datapool.setChMapInputDetailViewZoomSet(true);
        this.target.datapool.setChMapInputZoomLevelBackup(DSIMapViewerControlFactoryVW.getMapDatapoolMain().getZoomLevel());
        this.target.notifierDSI.viewFreeze(true);
        if (this.target.datapool.isGeneralPOIVisibility()) {
            this.target.notifierDSI.setGeneralPoiVisibility(false);
            this.poisWasVisible = true;
        }
        this.target.setDetailScreenDefaultDSIValues(false);
        TrafficMessageDetails trafficMessageDetails = mapConfiguration.getTmcMessage();
        if (!this.target.datapool.showTmcMessages()) {
            this.target.notifierDSI.showTMCMessages(true);
            this.tmcWasNotVisible = true;
        }
        this.target.notifierDSI.ensureTMCVisibility(trafficMessageDetails.messageID);
        this.target.notifierDSI.goToTMCMessage(trafficMessageDetails.messageID);
        this.target.notifierDSI.viewFreeze(false);
        this.target.notifierDSI.viewSetVisible(true);
        int n = this.target.datapool.getMainMapContent();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleStart() - removing map config for content=").append(n).log();
        }
        this.target.datapool.getQueuedGotoLocations().remove(new Integer(n));
    }
}

