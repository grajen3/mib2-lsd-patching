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

public class StatePopupOnOps
extends StateBase {
    public StatePopupOnOps(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
        if (n == 4 || n == 7) {
            int n2 = n = StatePopupOff.opsConfig == 1 ? 7 : 4;
            if (this.target.isRvcLowCoded()) {
                DisplayContent displayContent = new DisplayContent();
                displayContent.popup = n;
                displayContent.screen = 1;
                displayContent.view = 1;
                displayContent.mode = 1;
                this.target.doInternalSwitch(displayContent);
            } else {
                this.target.showParkingPopup(n, 1, 1, 15);
            }
            this.trans(this.target.statePopupOnOpsVps);
        }
    }

    private void changeQueueUpParking(boolean bl) {
        if (!this.target.isQueuedUp && bl) {
            this.target.isQueuedUp = true;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            displayContent.popup = 6;
            this.target.showParkingPopup(displayContent);
        } else if (this.target.isQueuedUp) {
            int n;
            this.target.isQueuedUp = false;
            DisplayContent displayContent = this.target.getLastDisplayContent();
            displayContent.popup = n = StatePopupOff.opsConfig == 1 ? 7 : 1;
            displayContent.screen = 0;
            displayContent.view = 0;
            displayContent.mode = 0;
            this.target.showParkingPopup(displayContent);
        }
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
        if (displayContent.popup == 3 || displayContent.popup == 8) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOpsVps);
        } else if (displayContent.popup == 2) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.trans(this.target.statePopupOnVps);
        } else if (displayContent.popup == 1 || displayContent.popup == 7) {
            if (this.target.isRvcLowCoded()) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(10178, false);
                this.target.updateModelDisplayContent(displayContent);
            } else {
                this.target.updateModelDisplayContent(displayContent);
            }
            this.target.storeDisplayContent(displayContent);
        } else if (displayContent.popup == 18) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOffroad);
        }
    }
}

