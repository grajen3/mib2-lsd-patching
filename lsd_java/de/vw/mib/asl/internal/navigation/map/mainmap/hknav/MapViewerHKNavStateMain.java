/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.hknav;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;

public final class MapViewerHKNavStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerHKNavStateMain]");
    private final MapViewerHKNavTargetHSM target;

    public MapViewerHKNavStateMain(MapViewerHKNavTargetHSM mapViewerHKNavTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerHKNavTargetHSM;
    }

    private void configureView() {
        this.logger.trace("configureView()");
        this.target.notifierDSI.viewFreezeTrue();
        this.target.notifierDSI.setModeFreeMap();
        this.target.notifierDSI.setViewType2D();
        this.target.notifierDSI.setOrientationNorthUp();
        this.target.notifierDSI.setZoomLevel(4234310);
        if (this.target.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.target.notifierDSI.setCityModelModeEnhanced();
        } else {
            this.target.notifierDSI.setCityModelModeOff();
        }
        this.target.notifierDSI.set3DLandmarksVisible();
        this.target.notifierDSI.viewFreezeFalse();
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
            case 1073742382: {
                this.handleSetContent(eventGeneric);
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

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (n != 32) {
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetContent(content=").append(32).append(")").log();
        }
        this.configureView();
        this.moveMapToFinalDestination();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void moveMapToFinalDestination() {
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getFinalDestinationNavLocation();
        if (navLocation == null) {
            this.logger.error("moveMapToFinalDestination() - No FinalDestination found, can't move the map.");
            return;
        }
        MapConfiguration mapConfiguration = this.target.datapool.isRgActive() ? new MapConfiguration(navLocation, 29, 0) : new MapConfiguration(navLocation, 25, 0);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapMainContentGotoLocation(32, mapConfiguration);
    }
}

