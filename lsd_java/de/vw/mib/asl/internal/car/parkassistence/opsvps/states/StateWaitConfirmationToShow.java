/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps.states;

import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public class StateWaitConfirmationToShow
extends StateBase {
    public StateWaitConfirmationToShow(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(opsVpsHsmTarget, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = super.handle(eventGeneric);
        if (hsmState == null) {
            return null;
        }
        hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 1073745153: {
                this.target.info().append("OpsVps: CLOSE_PARKING in state ").append(this.getName()).log();
                this.target.closeParkingPopupByModel();
                this.trans(this.target.stateWaitConfirmationToClose);
                break;
            }
            case 0x40000C0C: {
                this.target.info().append("OpsVps: SHOW_PARKING in state ").append(this.getName()).log();
                int n2 = eventGeneric.getInt(0);
                int n3 = eventGeneric.getInt(1);
                int n4 = eventGeneric.getInt(3);
                int n5 = eventGeneric.getInt(2);
                if (this.target.getPDCOffroadStatus()) {
                    n2 = 8;
                }
                this.target.showParkingPopup(n2, n3, n4, n5);
                boolean bl = this.isConcentToCancel(n2, n3, n4, n5);
                if (!bl) break;
                this.trans(this.target.statePopupOff);
                break;
            }
            default: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: eventId: ").append(n).append(" not handledin state ").append(this.getName()).log();
                }
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private boolean isConcentToCancel(int n, int n2, int n3, int n4) {
        return n == 0 && n2 == 0 && n3 == 0 && n4 == 0;
    }

    public void dsiCarParkingSystemRequestParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemRequestParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        this.target.onRequestToShowClose(displayContent);
        if (OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.closeParkingPopupByDevice();
            this.trans(this.target.stateWaitConfirmationToClose);
        }
    }

    public void dsiCarParkingSystemAcknowledgeParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemAcknowledgeParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        if (!OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.target.storeDisplayContent(displayContent);
            this.target.updateModelDisplayContent(displayContent);
            this.trans(this.target.statePopupOn);
        } else {
            this.target.info().append("OpsVps: dsiCarParkingSystemAcknowledgeParkingPopup req popup != ack popup").log();
        }
    }
}

