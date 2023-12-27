/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps.states;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.OpsVpsHsmTarget;
import de.vw.mib.asl.internal.car.parkassistence.opsvps.states.StateBase;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public class StatePopupOn
extends StateBase {
    int colorValue;
    int contrastValue;
    int brightnessValue;

    public StatePopupOn(OpsVpsHsmTarget opsVpsHsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(opsVpsHsmTarget, hsm, string, hsmState);
        this.target = opsVpsHsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        int n = eventGeneric.getReceiverEventId();
        int n2 = this.target.getLastDisplayContent().popup;
        switch (n) {
            case 2: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_ENTRY in state ").append(this.getName()).log();
                break;
            }
            case 3: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: HSM_START in state ").append(this.getName()).log();
                }
                if (n2 == 1 || n2 == 7) {
                    this.trans(this.target.statePopupOnOps);
                    break;
                }
                if (n2 == 2) {
                    this.trans(this.target.statePopupOnVps);
                    break;
                }
                if (n2 == 3 || n2 == 8) {
                    this.trans(this.target.statePopupOnOpsVps);
                    break;
                }
                if (n2 == 4) {
                    this.trans(this.target.statePopupOnOpsAuto);
                    break;
                }
                if (n2 != 18) break;
                this.trans(this.target.statePopupOnOffroad);
                break;
            }
            case 4: {
                if (!this.target.isTraceEnabled()) break;
                this.target.trace().append("OpsVps: HSM_EXIT in state ").append(this.getName()).log();
                break;
            }
            case 1073745153: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: CLOSE_PARKING in state ").append(this.getName()).log();
                }
                this.target.closeParkingPopupByModel();
                this.trans(this.target.stateWaitConfirmationToClose);
                break;
            }
            case 1073745118: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: 3DBV pos in state ").append(this.getName()).log();
                }
                this.target.set3DBVPosition(eventGeneric.getInt(0), eventGeneric.getInt(1));
                break;
            }
            case 1073744913: {
                int n3 = eventGeneric.getInt(0);
                boolean bl = eventGeneric.getBoolean(1);
                this.incDecRVCDisplaySettings(n3, bl);
                break;
            }
            case 1073744911: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_COLOR in state ").append(this.getName()).log();
                }
                this.colorValue = eventGeneric.getInt(0);
                this.target.setVPSColor(this.colorValue);
                break;
            }
            case 1073744912: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_CONTRAST in state ").append(this.getName()).log();
                }
                this.contrastValue = eventGeneric.getInt(0);
                this.target.setVPSContrast(this.contrastValue);
                break;
            }
            case 1073744910: {
                if (this.target.isTraceEnabled()) {
                    this.target.trace().append("OpsVps: SET_BRIGHTNESS in state ").append(this.getName()).log();
                }
                this.brightnessValue = eventGeneric.getInt(0);
                this.target.setVPSBrightness(this.brightnessValue);
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

    private void incDecRVCDisplaySettings(int n, boolean bl) {
        if (n == 0) {
            if (bl) {
                if (this.brightnessValue < 70) {
                    this.target.setVPSBrightness(++this.brightnessValue);
                }
            } else if (this.brightnessValue > 30) {
                this.target.setVPSBrightness(--this.brightnessValue);
            }
        }
        if (n == 1) {
            if (bl) {
                if (this.contrastValue < 70) {
                    this.target.setVPSContrast(++this.contrastValue);
                }
            } else if (this.contrastValue > 30) {
                this.target.setVPSContrast(--this.contrastValue);
            }
        }
        if (n == 2) {
            if (bl) {
                if (this.colorValue < 70) {
                    this.target.setVPSColor(++this.colorValue);
                }
            } else if (this.colorValue > 30) {
                this.target.setVPSColor(--this.colorValue);
            }
        }
    }

    public void dsiCarParkingSystemRequestParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemRequestParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        this.target.onRequestToShowClose(displayContent);
        if (OpsVpsHsmTarget.isContentToCancel(displayContent)) {
            this.target.updateModelDisplayContent(displayContent);
            this.trans(this.target.stateWaitConfirmationToClose);
        }
    }

    public void dsiCarParkingSystemUpdateParkingPopupContent(DisplayContent displayContent, int n) {
        this.target.info().append("OpsVps: dsiCarParkingSystemUpdateParkingPopupContent ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        this.updateModel(displayContent);
    }

    public void dsiCarParkingSystemAcknowledgeParkingPopup(DisplayContent displayContent) {
        this.target.info().append("OpsVps: dsiCarParkingSystemAcknowledgeParkingPopup ").append(displayContent.toString()).append(" in class ").append(this.getName()).log();
        this.updateModel(displayContent);
    }

    private void updateModel(DisplayContent displayContent) {
        if (displayContent.popup != 6 && this.isContentDifferent(displayContent)) {
            this.target.updateModelDisplayContent(displayContent);
            this.target.storeDisplayContent(displayContent);
        }
    }

    private boolean isContentDifferent(DisplayContent displayContent) {
        return displayContent.popup != this.target.getLastDisplayContent().popup || displayContent.screen != this.target.getLastDisplayContent().screen || displayContent.view != this.target.getLastDisplayContent().view || displayContent.mode != this.target.getLastDisplayContent().mode;
    }

    public void dsiCarParkingSystemResponseLifeMonitoring(boolean bl) {
        this.target.requestLifeMonitoring(bl);
    }

    public void dsiCarParkingSystemUpdateVPSColor(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSColor ").append(n).append(", ").append(n2).log();
        }
        this.updateHMIColor(n);
    }

    public void dsiCarParkingSystemUpdateVPSContrast(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSContrast ").append(n).append(n2).log();
        }
        this.updateHMIContrast(n);
    }

    public void dsiCarParkingSystemUpdateVPSBrightness(int n, int n2) {
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("OpsVps: dsiCarParkingSystemUpdateVPSBrightness ").append(n).append(n2).log();
        }
        this.updateHMIBrightness(n);
    }

    public void updateColor(int n) {
        this.updateHMIColor(n);
    }

    public void updateContrast(int n) {
        this.updateHMIContrast(n);
    }

    public void updateBrightness(int n) {
        this.updateHMIBrightness(n);
    }

    private void updateHMIColor(int n) {
        if (n < 30) {
            n = 30;
        } else if (n > 70) {
            n = 70;
        }
        this.colorValue = n;
        AbstractASLHsmTarget.writeIntegerToDatapool(10182, n);
    }

    private void updateHMIContrast(int n) {
        if (n < 30) {
            n = 30;
        } else if (n > 70) {
            n = 70;
        }
        this.contrastValue = n;
        AbstractASLHsmTarget.writeIntegerToDatapool(10183, n);
    }

    private void updateHMIBrightness(int n) {
        if (n < 30) {
            n = 30;
        } else if (n > 70) {
            n = 70;
        }
        this.brightnessValue = n;
        AbstractASLHsmTarget.writeIntegerToDatapool(10181, n);
    }
}

