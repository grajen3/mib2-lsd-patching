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
import org.dsi.ifc.global.NavLocation;

public class MapContentChangerStateDetailScreenPOI
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateDetailScreenPOI]");
    private MapContentChangerTargetHSM target;

    public MapContentChangerStateDetailScreenPOI(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
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
        this.target.datapool.setChMapInputDetailViewZoomSet(true);
        this.target.datapool.setChMapInputZoomLevelBackup(DSIMapViewerControlFactoryVW.getMapDatapoolMain().getZoomLevel());
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.notifierDSI.ensurePoiVisibility(new NavLocation[0]);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        MapConfiguration mapConfiguration = this.target.datapool.getMapConfiguration();
        this.target.notifierDSI.viewFreeze(true);
        this.target.setDetailScreenDefaultDSIValues(true);
        this.target.notifierDSI.setZoomLevel(4234310);
        NavLocation navLocation = mapConfiguration.getNavLocation();
        if (navLocation == null) {
            this.logger.error("The NavLocation is null, we can't move the map to the POI location and make the POI category icon visible");
        } else {
            this.target.notifierDSI.ensurePoiVisibility(new NavLocation[]{navLocation});
            this.target.notifierDSI.setLocationByLocation(navLocation);
        }
        this.target.configureDetailMapFlag(mapConfiguration);
        this.target.notifierDSI.viewFreeze(false);
    }
}

