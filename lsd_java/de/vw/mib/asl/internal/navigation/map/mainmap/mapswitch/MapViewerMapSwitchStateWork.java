/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerMapSwitchStateWork
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchStateWork]");
    private MapViewerMapSwitchTargetHSM target;

    public MapViewerMapSwitchStateWork(MapViewerMapSwitchTargetHSM mapViewerMapSwitchTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = mapViewerMapSwitchTargetHSM;
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
            case 1074841939: {
                this.handleASLNavigationMapViewSwitchMap();
                break;
            }
            case 3400029: {
                this.handleKombiSwitchStateUpdate(eventGeneric);
                break;
            }
            case 3499072: {
                this.handleSwitchFinished();
                break;
            }
            case 3499074: {
                this.handleASLNavigationMapViewSwitchMap();
                break;
            }
            case 1074841976: {
                if (eventGeneric.getParamCount() == 1) {
                    this.handleNotifiedAboutMapTemporarilyInABT(eventGeneric.getBoolean(0));
                    break;
                }
                this.logger.error(new StringBuffer().append("NOTIFY_MAP_TEMPORARY_IN_ABT parameters number is not correct. Got: ").append(eventGeneric.toString()).toString());
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleNotifiedAboutMapTemporarilyInABT(boolean bl) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(new StringBuffer().append("Set in datapool MapTemporarilyInABT to ").append(bl).toString());
        }
        this.target.datapool.setMapTemporarilyInABT(bl);
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.datapool.setICMapServiceState(10);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapICMapServiceStateChanged(10);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleASLNavigationMapViewSwitchMap() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNavigationMapViewSwitchMap()").log();
        }
        if (!this.target.datapool.isMapSwitchFunctionAvailableInKombi()) {
            this.setMapVisibleInABTandDisableSwitchButton();
            return;
        }
        if (this.target.isStateActive(this.target.getStateAtKombi())) {
            this.trySwitchingToABT();
        } else if (this.target.isStateActive(this.target.getStateAtAbt())) {
            this.trySwitchingToKombi();
        } else {
            this.logger.error("Error while switching Map, no valid configuration! Workaround: Trigger switch to Kombi!");
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToKombi();
        }
    }

    private void trySwitchingToKombi() {
        if (!this.target.datapool.isMapFPKSwitchRunning()) {
            this.logger.trace("Switching to Kombi");
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToKombi();
        } else if (this.target.datapool.getNextSwitchTo() != 1) {
            this.logger.warn("MapSwitch currently running. Postpone next switch to Kombi!");
            this.target.datapool.setNextSwitchTo(1);
        } else {
            this.logger.warn("MapSwitch currently running. Postpone next switch to ABT!");
            this.target.datapool.setNextSwitchTo(0);
        }
    }

    private void trySwitchingToABT() {
        if (!this.target.datapool.isMapFPKSwitchRunning()) {
            this.logger.trace("Switching to ABT");
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToABT();
        } else if (this.target.datapool.getNextSwitchTo() != 0) {
            this.logger.warn("MapSwitch currently running. Postpone next switch to ABT!");
            this.target.datapool.setNextSwitchTo(0);
        } else {
            this.logger.warn("MapSwitch currently running. Postpone next switch to Kombi!");
            this.target.datapool.setNextSwitchTo(1);
        }
    }

    private void handleKombiSwitchStateUpdate(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleKombiSwitchStateUpdate( state = ").append(n).append(" )").log();
        }
        switch (n) {
            case 3: {
                this.target.transStateAtAbt();
                break;
            }
            case 5: {
                this.target.transStateAtKombi();
                break;
            }
        }
    }

    private void handleSwitchFinished() {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSwitchFinished()").log();
        }
        this.target.datapool.setMapFPKSwitchRunning(false);
        if (this.target.datapool.getNextSwitchTo() == 0) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToABT();
        } else if (this.target.datapool.getNextSwitchTo() == 1) {
            ASLNavigationMapFactory.getNavigationMapApi().sendEvMapViewSwitchToKombi();
        }
        this.target.datapool.setNextSwitchTo(2);
    }

    private void setMapVisibleInABTandDisableSwitchButton() {
        this.logger.trace("Map Switch Function not available - move map to ABT");
        this.target.notifierModel.notifyMainMapShownInABT();
        this.target.notifierModel.notifyMapSwitchButtonDisabled();
        this.target.notifierDSI.viewSetVisible();
        this.target.datapool.setViewVisible(true);
        this.target.datapool.setMainMapLocatedInAbt(true);
        this.target.datapool.setMainMapLocatedInKombi(false);
        this.target.datapool.setMapSwitchState(1);
        ASLNavigationServiceMainMapEvents.sendEventKombiMapSwitchState(1);
    }
}

