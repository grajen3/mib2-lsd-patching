/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractHsmState;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LISpellerData;

public final class PoiStateSelectFromResultList
extends PoiAbstractHsmState {
    private PoiHsmTarget myTarget;
    public static boolean restore = false;
    public static LISpellerData currentSpellerState = null;

    public PoiStateSelectFromResultList(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
        this.myTarget.myCmdTrace(this, cmdSelectListItem);
        if (cmdSelectListItem.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdSelectListItem.liResult_ReturnCode).log();
            }
            return;
        }
        if (PoiDatapool.getInstance().isSpecialSpellerHandlingNeeded() && null != currentSpellerState) {
            CmdRestoreState cmdRestoreState = new CmdRestoreState(this, currentSpellerState);
            cmdRestoreState.setBlindArgument("DetailedPoi", new Object());
            cmdRestoreState.execute();
        }
        PoiStateDetail.currentDestinationLocation = cmdSelectListItem.liCurrentState_liCurrentLD;
        PoiHsmTarget.handleOnboardPoiResult(PoiStateDetail.currentDestinationLocation);
        this.myTarget.transAfterCallback(this.myTarget.statePoiDetail);
    }

    private void handleHsmStart() {
        if (PoiAbstractElementCommon.poiResultList.length > 0) {
            PoiStateElementSurrounding.ignoreUpdates = true;
            PoiStateElementNoSurrounding.stopRequestingValueList = true;
            this.getPoiDetailsByIndex(PoiStateDetail.currentDetailsIndex);
            if (currentSpellerState != PoiAbstractElementCommon.savedSpellerState) {
                currentSpellerState = PoiAbstractElementCommon.savedSpellerState;
            }
            this.myTarget.transAfterCallback(this.myTarget.statePoiDetail);
        } else {
            new CmdLiGetState(this).execute();
        }
    }

    private void getPoiDetailsByIndex(int n) {
        if (PoiStateDetail.currentDetailsIndex < PoiAbstractElementCommon.poiResultList.length) {
            NavLocation navLocation = PoiAbstractElementCommon.poiResultList[PoiStateDetail.currentDetailsIndex].poiNavLocation;
            if (!PoiDatapool.getInstance().isUpdateModel()) {
                PoiHsmTarget.handleOnboardPoiResult(navLocation);
            }
            PoiStateDetail.currentDestinationLocation = navLocation;
        }
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        if (cmdLiGetState.liGetStateResult_spellerState != null) {
            currentSpellerState = cmdLiGetState.liGetStateResult_spellerState;
            new CmdSelectListItem(this, PoiStateDetail.currentDetailsIndex).execute();
        } else if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
            this.myTarget.makeError(this).append("handleCommandCmdLiGetState: getStateResult_spellerState is null.").log();
        }
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
    }
}

