/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractSubElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class PoiStateSubElementRestore
extends PoiAbstractHsmState {
    private PoiHsmTarget myTarget;

    public PoiStateSubElementRestore(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.myTarget = poiHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeTrace(this).append("Received event ID:").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.myTarget.myTrace(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.myTarget.myTrace(this, "HSM_START");
                this.handleHsmStart();
                break;
            }
            case 4: {
                this.myTarget.myTrace(this, "HSM_EXIT");
                break;
            }
            default: {
                if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                    this.myTarget.makeTrace(this).append("Received event which is not handled in this state (ID=").append(eventGeneric.getReceiverEventId()).append(")").log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
        this.myTarget.myCmdTrace(this, cmdRestoreState);
        if (cmdRestoreState.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdRestoreState.liResult_ReturnCode).log();
            }
            return;
        }
        PoiStateElementSurrounding.ignoreUpdates = true;
        this.myTarget.myTrace(this, "CmdSelectListItem");
        new CmdSelectListItem(this, PoiStateDetail.currentDetailsIndex).execute();
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.myTarget.myCmdTrace(this, cmdSelectListItem);
        if (cmdSelectListItem.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdSelectListItem.liResult_ReturnCode).log();
            }
            return;
        }
        PoiStateDetail.currentDestinationLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        this.myTarget.transAfterCallback(this.myTarget.statePoiDetail);
    }

    private void handleHsmStart() {
        PoiStateSelectFromResultList.currentSpellerState = PoiAbstractSubElementCommon.subPOIState;
        this.myTarget.myTrace(this, "CmdRestoreState");
        new CmdRestoreState(this, PoiAbstractSubElementCommon.subPOIState).execute();
    }
}

