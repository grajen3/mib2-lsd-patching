/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard;

import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiAbstractSubElementCommon;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiHsmTarget;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateElementNoSurrounding;
import de.vw.mib.asl.internal.navigation.poi.onboard.PoiStateSelectFromResultList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.LISpellerData;

public final class PoiStateSubElementNoSurrounding
extends PoiAbstractSubElementCommon {
    public PoiStateSubElementNoSurrounding(PoiHsmTarget poiHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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

    private void handleLIGETSTATERESULT(LISpellerData lISpellerData) {
        this.myTarget.myTrace(this, "StatePoiSubElement:handle:AbstractIdServiceDSI.DSINAVIGATION_LIGETSTATERESULT");
        if (this.getParentPOIState) {
            this.getParentPOIState = false;
            PoiStateElementNoSurrounding.parentPOIState = lISpellerData;
            this.myTarget.myTrace(this, "CmdSelectListItem");
            new CmdSelectListItem(this, PoiAbstractSubElementCommon.listSelection).execute();
        } else {
            PoiAbstractSubElementCommon.subPOIState = lISpellerData;
            PoiStateSelectFromResultList.currentSpellerState = lISpellerData;
            PoiAbstractElementCommon.continueSearch = true;
            this.myTarget.transAfterCallback(this.myTarget.statePoiElementNoSurrounding);
        }
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
        this.myTarget.myCmdTrace(this, cmdLiGetState);
        this.handleLIGETSTATERESULT(cmdLiGetState.liGetStateResult_spellerState);
    }
}

