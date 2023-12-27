/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps.states;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateBase;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StatePopupOff;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public class StatePopupSettings
extends StateBase {
    public StatePopupSettings(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(opsVpsHsmTarget, hsm, string, hsmState);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        switch (n) {
            case 2: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_ENTRY in state ").append(this.getName()).log();
                break;
            }
            case 3: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_START in state ").append(this.getName()).log();
                break;
            }
            case 4: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            case 1073745155: {
                this.target.info().append("OpsVps: CLOSE_COLOR_SETTINGS in ").append(this.getName()).log();
                HsmState hsmState2 = this.myHsm.getPreviousState();
                if (!this.target.isQueuedUp) {
                    if (hsmState2.equals(this.target.statePopupOnVps)) {
                        if (StatePopupOff.opsConfig == 0 && this.target.isAreaViewExist()) {
                            this.target.showParkingPopup(3, 2, -1, -1);
                        }
                        this.trans(this.target.statePopupOnVps);
                        break;
                    }
                    if (hsmState2.equals(this.target.statePopupOnOpsVps)) {
                        int n2 = StatePopupOff.opsConfig == 1 ? 7 : 4;
                        this.target.showParkingPopup(n2, 2, -1, -1);
                        this.trans(this.target.statePopupOnOpsVps);
                        break;
                    }
                    if (!hsmState2.equals(this.target.statePopupOnOffroad)) break;
                    this.target.showParkingPopup(8, 2, -1, -1);
                    this.trans(this.target.statePopupOnOffroad);
                    break;
                }
                if (hsmState2.equals(this.target.statePopupOnVps)) {
                    this.trans(this.target.statePopupOnVps);
                    break;
                }
                if (hsmState2.equals(this.target.statePopupOnOpsVps)) {
                    this.trans(this.target.statePopupOnOpsVps);
                    break;
                }
                if (!hsmState2.equals(this.target.statePopupOnOffroad)) break;
                this.trans(this.target.statePopupOnOffroad);
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

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
        if (displayContent.popup == 2 || displayContent.popup == 6) {
            this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append("do not store VPS in Settings").append(n).append(" in class ").append(this.getName()).log();
            if (StatePopupOff.opsConfig == 0) {
                this.target.updateModelDisplayContent(displayContent);
            }
            return;
        }
        if (displayContent.popup == 1 || displayContent.popup == 7) {
            if (this.target.isRvcLowCoded()) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10178, false);
            }
            this.target.updateModelDisplayContent(displayContent);
            if (!this.target.isQueuedUp) {
                this.target.showParkingPopup(displayContent);
            }
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOps);
        } else if (displayContent.popup == 3 || displayContent.popup == 8) {
            this.target.updateModelDisplayContent(displayContent);
            if (!this.target.isQueuedUp) {
                this.target.showParkingPopup(displayContent);
            }
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOpsVps);
        } else if (this.target.getPDCOffroadStatus()) {
            this.target.warn("OpsVps: unexpected update here. just store the content");
            this.target.storeDisplayContent(displayContent);
        }
    }

    private void changeQueueUpParking(boolean bl) {
        this.target.info().append("OpsVps: QUEUE_UP_PARKING_POPUP in state ").append(this.getName()).log();
        if (!this.target.isQueuedUp && bl) {
            this.target.isQueuedUp = true;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            displayContent.popup = 6;
            this.target.showParkingPopup(displayContent);
        } else if (this.target.isQueuedUp) {
            this.target.isQueuedUp = false;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            displayContent.popup = 2;
            displayContent.screen = 1;
            this.target.showParkingPopup(displayContent);
        }
    }
}

