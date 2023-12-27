/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateChnCrosshairMapInput
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateChnCrosshairMapInput]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateChnCrosshairMapInput(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(", params=").append(eventGeneric.getParamString()).append(")").log();
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
        MapConfiguration mapConfiguration = this.target.datapool.getMapConfiguration();
        if (mapConfiguration.getNavLocation() == null) {
            this.logger.error("The NavLocation is null, can't configure map input detail screen");
            return;
        }
        this.target.datapool.getQueuedGotoLocations().remove(new Integer(12));
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setMode(2);
        this.target.notifierDSI.set3DLandmarksVisible(true);
        if (this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelMode(2);
        } else {
            this.target.notifierDSI.setCityModelMode(0);
        }
        this.target.notifierDSI.setZoomArea(this.target.datapool.getZoomArea());
        this.target.notifierDSI.setHotPoint(this.target.datapool.getHotPoint());
        if (this.target.datapool.isChMapInputDetailViewZoomSet()) {
            this.target.notifierDSI.setZoomLevel(this.target.datapool.getChMapInputZoomLevelBackup());
            this.target.datapool.setChMapInputDetailViewZoomSet(false);
        } else {
            this.target.notifierDSI.setZoomLevel(DSIMapViewerControlFactoryVW.getMapDatapoolMain().getZoomLevel());
        }
        this.target.notifierDSI.setLocationByLocation(mapConfiguration.getNavLocation());
        this.target.sendEventContentReadyMainSetup();
        this.target.notifierDSI.viewFreeze(false);
    }
}

