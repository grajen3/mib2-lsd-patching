/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerMapSwitchStateRestart
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerMapSwitchStateRestart]");
    private MapViewerMapSwitchTargetHSM target;

    public MapViewerMapSwitchStateRestart(MapViewerMapSwitchTargetHSM mapViewerMapSwitchTargetHSM, Hsm hsm, String string, HsmState hsmState) {
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
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 101001: {
                this.handleNaviTargetGoOn();
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
            this.logger.makeTrace().append("handleDefault(ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (this.target.datapool.isMapLocatedInKombi()) {
            this.logger.trace("Last mode: Map was visible in Kombi - set switch state so a switch is triggered as soon as MOST is available");
            this.target.datapool.setMapSwitchState(5);
            this.target.notifierModel.notifyMainMapNotShownInABT();
            this.target.datapool.setMapVisibilityForFPKSwitch(false);
        } else {
            this.target.datapool.setMapSwitchState(1);
            this.target.datapool.setMapVisibilityForFPKSwitch(true);
            if (!this.target.datapool.isMapSwitchFunctionAvailableInKombi()) {
                this.target.notifierModel.notifyMapSwitchButtonDisabled();
            }
        }
        this.target.transStateWork();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleNaviTargetGoOn() {
        this.logger.trace("handleNaviTargetGoOn()");
    }
}

