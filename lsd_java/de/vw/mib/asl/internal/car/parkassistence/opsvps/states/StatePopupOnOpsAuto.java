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

public class StatePopupOnOpsAuto
extends StateBase
implements HsmState {
    public StatePopupOnOpsAuto(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
            case 1073745150: {
                this.changePopup(eventGeneric.getInt(0));
                break;
            }
            case 1073744915: {
                this.changeQueueUpParking(eventGeneric.getBoolean(0));
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

    private void changePopup(int n) {
        this.target.info().append("OpsVps: CHANGE_POPUP to ").append(n).append(" in state ").append(this.getName()).log();
        if (n == 1 || n == 6) {
            this.target.showParkingPopup(n, 0, 0, 0);
            this.trans(this.target.statePopupOnOps);
        } else if (n == 7 || n == 4) {
            this.target.showParkingPopup(n, 1, 4, 15);
            this.trans(this.target.statePopupOnOpsVps);
        }
    }

    private void changeQueueUpParking(boolean bl) {
        if (!this.target.isQueuedUp && bl) {
            this.target.isQueuedUp = true;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            this.target.info().append("OpsVps: QUEUE_UP_PARKING_POPUP content: ").append(displayContent.toString()).append(" in state ").append(this.getName()).log();
            displayContent.popup = 6;
            this.target.showParkingPopup(displayContent);
        } else if (this.target.isQueuedUp) {
            this.target.info().append("OpsVps: QUEUE_UP_PARKING_POPUP end in state ").append(" in state ").append(this.getName()).log();
            this.target.isQueuedUp = false;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            displayContent.popup = 4;
            this.target.showParkingPopup(displayContent);
        }
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
        if (displayContent.popup == 3 || displayContent.popup == 8) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.trans(this.target.statePopupOnOpsVps);
        } else if (displayContent.popup == 7 || displayContent.popup == 1) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOps);
        } else if (displayContent.screen == 3) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.trans(this.target.statePopupOnVps);
        }
    }
}

