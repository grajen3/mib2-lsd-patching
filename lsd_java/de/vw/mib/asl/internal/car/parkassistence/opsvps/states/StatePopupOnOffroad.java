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

public class StatePopupOnOffroad
extends StateBase
implements HsmState {
    public StatePopupOnOffroad(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
            case 1073745157: {
                this.changeScreen(eventGeneric.getInt(0));
                break;
            }
            case 1073745151: {
                this.changeView(eventGeneric.getInt(0));
                break;
            }
            case 0x40000D00: {
                this.changeMode(eventGeneric.getInt(0));
                break;
            }
            case 1073744915: {
                this.changeQueueUpParking(eventGeneric.getBoolean(0));
                break;
            }
            case 1073745154: {
                if (this.target.getLastDisplayContent().screen != 2) break;
                this.target.showParkingPopup(3, 1, -1, -1);
                this.trans(this.target.statePopupOnSettings);
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
    }

    private void changeScreen(int n) {
        this.target.info().append("OpsVps: CHANGE_SCREEN to ").append(n).append(" in state ").append(this.getName()).log();
        switch (n) {
            case 1: {
                this.target.showParkingPopup(3, n, -1, -1);
                this.trans(this.target.statePopupOnVps);
                break;
            }
            case 2: {
                this.target.showParkingPopup(8, n, -1, -1);
                break;
            }
        }
    }

    private void changeView(int n) {
        this.target.info().append("OpsVps: CHANGE_VIEW to ").append(n).append(" in state ").append(this.getName()).log();
        switch (n) {
            case 4: {
                this.target.showParkingPopup(-1, 1, n, 10);
                break;
            }
            default: {
                this.target.showParkingPopup(-1, 2, n, 15);
            }
        }
    }

    private void changeMode(int n) {
        this.target.info().append("OpsVps: CHANGE_MODE to ").append(n).append(" in state ").append(this.getName()).log();
        switch (n) {
            case 5: 
            case 6: {
                this.target.showParkingPopup(-1, 2, 3, n);
                break;
            }
            case 11: {
                this.target.showParkingPopup(-1, -1, -1, n);
                break;
            }
            case 12: {
                this.target.showParkingPopup(3, 1, 3, n);
                this.trans(this.target.statePopupOnVps);
                break;
            }
            default: {
                this.target.showParkingPopup(-1, -1, -1, n);
            }
        }
    }

    private void changeQueueUpParking(boolean bl) {
        this.target.info().append("OpsVps: QUEUEDUP to ").append(bl).append(" NOT NEEDED in state ").append(this.getName()).log();
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
            this.target.showParkingPopup(displayContent);
        }
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
        if (displayContent.popup == 1 || displayContent.popup == 7) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOps);
        } else if (displayContent.popup == 3 || displayContent.popup == 8) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOpsVps);
        } else if (displayContent.popup == 2) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnVps);
        } else if (displayContent.popup == 18) {
            this.target.warn(new StringBuffer().append("OpsVps. unexpected here because screen paramter was overwritten in VPS state (to synch popup and screen)(workaround): ").append(displayContent.popup).toString());
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
        }
    }
}

