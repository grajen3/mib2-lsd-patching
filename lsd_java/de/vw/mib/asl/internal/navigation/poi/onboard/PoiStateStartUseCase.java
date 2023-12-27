/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.poi.onboard.DynamicPoiCategoryHandler;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiDatapool;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateDetail;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementSurrounding;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class PoiStateStartUseCase
extends PoiAbstractElementCommon {
    public PoiStateStartUseCase(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(poiHsmTarget, hsm, string, hsmState);
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

    private void handleHsmStart() {
        this.myTarget.myTrace(this, "handleHsmStart");
        PoiStateElementSurrounding.ignoreUpdates = true;
        PoiStateElementNoSurrounding.stopRequestingValueList = true;
        PoiAbstractElementCommon.continueSearch = false;
        this.myTarget.myTrace(this, "CmdCancelSpeller");
        new CmdCancelSpeller(this).execute();
        DynamicPoiCategoryHandler.hideOnlineSearchButton();
    }

    private void proceedWithUseCase() {
        this.myTarget.myTrace(this, "proceedWithUseCase");
        switch (PoiDatapool.getInstance().getCurrentUseCase()) {
            case 14: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                break;
            }
            case 20: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                break;
            }
            case 4: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                break;
            }
            case 0: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementNoSurrounding);
                break;
            }
            case 2: {
                PoiStateDetail.currentDestinationLocation = PoiStateElementNoSurrounding.poiFromMapLocation;
                this.myTarget.transAfterCallback(this.myTarget.statePoiDetail);
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.myTarget.transAfterCallback(this.myTarget.statePoiElementSurrounding);
                break;
            }
            default: {
                this.myTarget.myError(this, "Unknown use case - can't start POI search");
            }
        }
    }

    @Override
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
        this.myTarget.myCmdTrace(this, cmdCancelSpeller);
        if (cmdCancelSpeller.liResult_ReturnCode != 0L) {
            if (this.myTarget.getTextLogger().isTraceEnabled(this.myTarget.getSubClassifier())) {
                this.myTarget.makeError(this).append("Error! returnCode=").append(cmdCancelSpeller.liResult_ReturnCode).log();
            }
            return;
        }
        this.proceedWithUseCase();
    }
}

