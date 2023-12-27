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

public class StatePopupOnVps
extends StateBase {
    private int restoreScreen;

    public StatePopupOnVps(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
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
                DisplayContent displayContent = this.target.getLastDisplayContent();
                if (displayContent.mode == 9 || displayContent.screen != 2) break;
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
        if (this.isPopupRvcOps(n)) {
            if (StatePopupOff.opsConfig == 0 && this.target.getLastDisplayContent().screen == 3) {
                this.target.showParkingPopup(3, 1, -1, -1);
            } else {
                int n2 = this.target.isAreaViewExist() ? 2 : 1;
                this.target.showParkingPopup(n, n2, -1, -1);
                this.trans(this.target.statePopupOnOpsVps);
            }
        } else if (n == 3 && this.target.getLastDisplayContent().screen == 3) {
            this.target.showParkingPopup(3, 1, -1, -1);
        }
    }

    private void changeScreen(int n) {
        this.target.info().append("OpsVps: CHANGE_SCREEN to ").append(n).append(" in state ").append(this.getName()).log();
        switch (n) {
            case 2: {
                if (StatePopupOff.opsConfig == 0) {
                    this.target.showParkingPopup(-1, n, -1, -1);
                    break;
                }
                int n2 = StatePopupOff.opsConfig == 1 ? (this.target.getPDCOffroadStatus() ? 8 : 7) : 4;
                n = this.target.isAreaViewExist() ? 2 : 1;
                this.target.showParkingPopup(n2, n, -1, -1);
                this.trans(this.target.getPDCOffroadStatus() ? this.target.statePopupOnOffroad : this.target.statePopupOnOpsVps);
                break;
            }
            case 1: {
                this.target.showParkingPopup(-1, n, -1, -1);
                this.trans(this.target.statePopupOnVps);
                break;
            }
        }
    }

    private void changeView(int n) {
        this.target.info().append("OpsVps: CHANGE_VIEW to ").append(n).append(" in state ").append(this.getName()).log();
        if (StatePopupOff.opsConfig == 0) {
            this.changeViewInAVStandalone(n);
        } else {
            this.changeViewInAVOPS(n);
        }
    }

    private void changeViewInAVOPS(int n) {
        switch (n) {
            case 1: {
                if (this.target.getHsm().getPreviousState().getName().compareTo("StatePopupOnOpsVps") == 0) {
                    int n2 = StatePopupOff.opsConfig == 1 ? 7 : 4;
                    this.target.showParkingPopup(n2, 2, n, 15);
                    this.trans(this.target.statePopupOnOpsVps);
                    break;
                }
                if (this.target.getHsm().getPreviousState().getName().compareTo("StatePopupOnVps") == 0) {
                    this.target.showParkingPopup(-1, -1, n, 15);
                    break;
                }
                this.target.showParkingPopup(-1, 2, n, 15);
                this.trans(this.target.statePopupOnVps);
                break;
            }
            case 5: {
                this.target.showParkingPopup(-1, -1, n, 0);
                this.trans(this.target.statePopupOnVps);
                break;
            }
            case 4: {
                this.target.showParkingPopup(-1, 1, n, 10);
                break;
            }
            default: {
                this.target.showParkingPopup(-1, 2, n, 15);
                this.trans(this.target.statePopupOnVps);
            }
        }
    }

    private void changeViewInAVStandalone(int n) {
        switch (n) {
            case 4: {
                this.target.showParkingPopup(-1, 1, n, 10);
                break;
            }
            case 5: {
                this.restoreScreen = this.target.getLastDisplayContent().screen;
                this.target.showParkingPopup(-1, 1, n, 0);
                break;
            }
            default: {
                int n2 = 2;
                if (this.target.getLastDisplayContent().view == 6 && this.restoreScreen != 0) {
                    n2 = this.restoreScreen;
                    this.restoreScreen = 0;
                }
                this.target.showParkingPopup(-1, n2, n, 15);
            }
        }
    }

    private void changeMode(int n) {
        this.target.info().append("OpsVps: CHANGE_MODE to ").append(n).append(" in state ").append(this.getName()).log();
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 8: {
                this.target.showParkingPopup(-1, -1, -1, n);
                break;
            }
            case 5: 
            case 6: 
            case 7: {
                this.target.showParkingPopup(-1, 1, 3, n);
                break;
            }
            case 11: {
                this.target.showParkingPopup(-1, -1, -1, n);
                break;
            }
            case 10: {
                if (StatePopupOff.opsConfig == 0) {
                    this.target.showParkingPopup(-1, -1, -1, n);
                    break;
                }
                int n2 = StatePopupOff.opsConfig == 1 ? 7 : 4;
                this.target.showParkingPopup(n2, -1, -1, n);
                this.trans(this.target.statePopupOnOpsVps);
                break;
            }
            case 12: {
                this.target.showParkingPopup(3, 1, 3, n);
                break;
            }
            case 0: {
                break;
            }
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
            this.target.showParkingPopup(displayContent);
        }
    }

    private boolean isPopupRvcOps(int n) {
        return n == 4 || n == 7;
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(n).append(" in class ").append(this.getName()).log();
        if (displayContent.popup == 3 || displayContent.popup == 8) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOpsVps);
        } else if (displayContent.popup == 1 || displayContent.popup == 7) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(10178, false);
            this.target.updateModelDisplayContent(displayContent);
            if (!this.target.isQueuedUp) {
                this.target.showParkingPopup(displayContent);
            }
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOps);
        } else if (displayContent.popup == 2) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
        } else if (displayContent.popup == 18) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.showParkingPopup(displayContent);
            this.target.storeDisplayContent(displayContent);
            this.trans(this.target.statePopupOnOffroad);
        }
    }

    public void dsiCarParkingSystemUpdatePDCFailure(boolean bl, int n) {
        this.target.info().append("OpsVps: StatePopupOnVps dsiCarParkingSystemUpdatePDCFailure: ").append(bl).log();
        this.target.updatePDCFailure(bl);
    }
}

