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

public class MapRegionalUpdateStateIntegrationInProgress
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[MapRegionalUpdateStateIntegrationInProgress]");
    private MapRegionalUpdateTargetHSM target;

    public MapRegionalUpdateStateIntegrationInProgress(MapRegionalUpdateTargetHSM mapRegionalUpdateTargetHSM, String string, HsmState hsmState) {
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
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierModel.showProgressIndicatorInDatabaseInfo(true);
        this.target.sendHMIEvent(217059328);
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
            switch (n) {
                case 2: {
                    this.logger.trace("Got MAPINTEGRATIONSTATE_FINISHED");
                    this.target.transStateMapIntegrationFinished();
                    break;
                }
                case 0: {
                    this.logger.warn("Got update of map integration state != MAPINTEGRATIONSTATE_IDLE in state progress. This should not happen in this state");
                    this.target.transStateMapIntegrationIdle();
                    break;
                }
                default: {
                    this.logger.warn("Got update of map integration state != MAPINTEGRATIONSTATE_FINISHED in state progress. This should not happen and will be discarded");
                    break;
                }
            }
        } else {
            this.logger.warn("validFlag was != DSIListener.ATTRVALIDFLAG_VALID");
        }
    }

    public void dsiNavigationUpdateMapIntegrationProgress(int n, int n2) {
        this.logger.trace("got DSINavigationListener.updateMapIntegrationProgress");
        if (n2 == 1) {
            if (n >= 0 && n <= 100) {
                this.target.notifierModel.updateProgressInDatabaseInfo(n);
            } else {
                this.logger.error(new StringBuffer().append("Map integration progress out of defined range! It was ").append(n).toString());
            }
        } else {
            this.logger.warn("validFlag was != DSIListener.ATTRVALIDFLAG_VALID");
        }
    }
}

