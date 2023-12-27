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
import org.dsi.ifc.powermanagement.ClampSignal;

public class StateWaitConfirmationToClose
extends StateBase {
    private boolean isAlreadyClosedByFSG;

    public StateWaitConfirmationToClose(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
            case 1073744914: {
                this.target.info().append("OpsVps: CLOSE_PARKING_POPUP_ACKNOWLEDGED in state ").append(this.getName()).log();
                this.target.closeParkingPopupByDevice();
                this.isAlreadyClosedByFSG = true;
                if (!this.target.getClamp15()) {
                    this.closeParkingCycle();
                }
                this.isAlreadyClosedByFSG = false;
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

    public void dsiCarParkingSystemRequestParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemRequestParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        this.target.onRequestToShowClose(displayContent);
        if (!OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.trans(this.target.stateWaitConfirmationToShow);
        } else {
            this.target.info().append("OpsVps: dsiCarParkingSystemRequestParkingPopup to cancel not impl").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        }
    }

    public void dsiCarParkingSystemAcknowledgeParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemAcknowledgeParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        if (OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOff);
        } else {
            this.target.info().append("OpsVps: dsiCarParkingSystemAcknowledgeParkingPopup not from cancel request ").log();
        }
    }

    public void dsiPowerManagementUpdateClampSignal(ClampSignal clampSignal, int n) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: clamp status").append(clampSignal.toString()).log();
        }
        if (!clampSignal.clamp15) {
            this.closeParkingCycle();
        }
    }

    private void closeParkingCycle() {
        this.target.updateModelDisplayContent(new DisplayContent(0, 0, 0, 0));
        if (!this.isAlreadyClosedByFSG) {
            this.target.info().append("OpsVps: StateWaitConfirmationToClose closeParkingCycle").log();
            this.target.closeParkingPopupByModel();
        }
        this.trans(this.target.statePopupOff);
    }
}

