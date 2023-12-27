/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapContentChangerStateTrafficDualList
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerStateDualListViewTMC]");
    private MapContentChangerTargetHSM target;
    private boolean poisWasVisible;
    private boolean tmcWasNotVisible;

    public MapContentChangerStateTrafficDualList(MapContentChangerTargetHSM mapContentChangerTargetHSM, String string, HsmState hsmState) {
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
            case 1074841826: {
                this.handleRestoreMap(eventGeneric);
                break;
            }
            case 3499069: {
                this.handleShowTMCDualListView(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleRestoreMap(EventGeneric eventGeneric) {
        this.logger.trace("handleRestoreMap()");
        TrafficDualListViewConfiguration trafficDualListViewConfiguration = this.target.datapool.getTrafficDualiListViewConfig();
        if (trafficDualListViewConfiguration != null) {
            this.applyConfig(trafficDualListViewConfiguration);
        }
    }

    private void handleShowTMCDualListView(EventGeneric eventGeneric) {
        TrafficDualListViewConfiguration trafficDualListViewConfiguration = (TrafficDualListViewConfiguration)eventGeneric.getObject(0);
        this.target.datapool.setTrafficDualiListViewConfig(trafficDualListViewConfiguration);
        this.applyConfig(trafficDualListViewConfiguration);
    }

    private void applyConfig(TrafficDualListViewConfiguration trafficDualListViewConfiguration) {
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.showTrafficEventListView(trafficDualListViewConfiguration.getMessageIDs(), trafficDualListViewConfiguration.isAdjustViewPort(), trafficDualListViewConfiguration.isAdjustPins());
        this.target.notifierDSI.viewFreeze(false);
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
        MapViewerUtils.updateMainMapPersistedZoomLevel(this.target.datapool.getZoomLevelMainMapBackup());
        this.target.notifierDSI.ensureTMCVisibility(0L);
        if (this.poisWasVisible) {
            this.poisWasVisible = false;
            this.target.notifierDSI.setGeneralPoiVisibility(true);
        }
        if (this.tmcWasNotVisible) {
            this.tmcWasNotVisible = false;
            this.target.notifierDSI.showTMCMessages(false);
        }
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.showTrafficEventListView(new long[0], false, false);
        this.target.notifierDSI.viewFreeze(false);
        this.target.datapool.setTrafficDualiListViewConfig(null);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setZoomLevelMainMapBackup(this.target.datapool.getMainMapZoomLevel());
        this.target.notifierDSI.viewFreeze(true);
        if (this.target.datapool.isGeneralPOIVisibility()) {
            this.target.notifierDSI.setGeneralPoiVisibility(false);
            this.poisWasVisible = true;
        }
        this.target.setDetailScreenDefaultDSIValues(false);
        if (!this.target.datapool.showTmcMessages()) {
            this.target.notifierDSI.showTMCMessages(true);
            this.tmcWasNotVisible = true;
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(408)) {
            this.target.notifierDSI.resetLayers();
        }
        this.target.notifierDSI.viewFreeze(false);
        this.target.notifierDSI.viewSetVisible(true);
    }
}

