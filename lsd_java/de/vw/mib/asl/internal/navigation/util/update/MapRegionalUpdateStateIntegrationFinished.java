/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.update;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.util.update.MapRegionalUpdateTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapRegionalUpdateStateIntegrationFinished
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[MapRegionalUpdateStateIntegrationFinished]");
    private MapRegionalUpdateTargetHSM target;

    public MapRegionalUpdateStateIntegrationFinished(MapRegionalUpdateTargetHSM mapRegionalUpdateTargetHSM, String string, HsmState hsmState) {
        super(mapRegionalUpdateTargetHSM.getHsm(), string, hsmState);
        this.target = mapRegionalUpdateTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 2: {
                this.handleEntry();
                break;
            }
            case 1074841960: {
                this.target.handleNavigationRestartRequest();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.sendHMIEvent(233836544);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    public void dsiNavigationUpdateMapIntegrationState(int n, int n2) {
        this.logger.trace("dsiNavigationUpdateMapIntegrationState");
        if (n2 == 1) {
            if (n == 0) {
                this.target.transStateMapIntegrationIdle();
            } else {
                this.logger.warn("Got update of map integration state != MAPINTEGRATIONSTATE_IDLE in state progress. This should not happen and will be discarded");
            }
        } else {
            this.logger.warn("validFlag was != DSIListener.ATTRVALIDFLAG_VALID");
        }
    }

    public void dsiNavigationEtcTriggerNavigationRestartResult(int n, int n2) {
        this.logger.trace("dsiNavigationEtcTriggerNavigationRestartResult");
        this.target.handleNavigationRestartRequestResult(n, n2);
    }
}

