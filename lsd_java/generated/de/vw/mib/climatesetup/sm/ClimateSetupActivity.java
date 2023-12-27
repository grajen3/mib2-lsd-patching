/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.climatesetup.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class ClimateSetupActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public ClimateSetupActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 304: {
                this.performStateEntryAction_SubPopupPoDisclaimerClimatesetupNotAvailableDynState(n, bl);
                break;
            }
            case 5: {
                this.performStateEntryAction_SubHapticClimatesetupDynState(n, bl);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (this.subStatemachineId) {
            case 304: {
                this.performStateExitAction_SubPopupPoDisclaimerClimatesetupNotAvailableDynState(n);
                break;
            }
            case 5: {
                this.performStateExitAction_SubHapticClimatesetupDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateFocusGainedAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public void performStateFocusLostAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 5: {
                return this.evalInternalTransitionGuard_SubHapticClimatesetupDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 5: {
                this.performInternalTransitionAction_SubHapticClimatesetupDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public boolean evalTriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    private void performStateEntryAction_SubPopupPoDisclaimerClimatesetupNotAvailableDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pdcna", 304, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoDisclaimerClimatesetupNotAvailableDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                ClimateSetupActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pdcna");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticClimatesetupDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.showView("C", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticClimatesetupDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.hideView("C");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticClimatesetupDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return !this.getLicValue(637824512, 0, 3, false);
            }
            case 1: {
                return this.getLicValue(637824512, 0, 3, false);
            }
            case 2: {
                return !this.getLicValue(637824512, 0, 2, false);
            }
            case 3: {
                return this.getLicValue(637824512, 0, 2, false);
            }
            case 4: {
                return !this.getLicValue(637824512, 0, 1, false);
            }
            case 5: {
                return this.getLicValue(637824512, 0, 1, false);
            }
            case 6: {
                return !this.getLicValue(637824512, 0, 5, false);
            }
            case 7: {
                return this.getLicValue(637824512, 0, 5, false);
            }
            case 8: {
                return !this.getLicValue(637824512, 0, 4, false);
            }
            case 9: {
                return this.getLicValue(637824512, 0, 4, false);
            }
            case 10: {
                return !this.getLicValue(637824512, 0, 0, false);
            }
            case 11: {
                return !this.getLicValue(637824512, 0, 0, false);
            }
            case 12: {
                return this.getLicValue(637824512, 0, 0, false);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticClimatesetupDynState(int n) {
        this.performInternalTransitionAction_SubHapticClimatesetupDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticClimatesetupDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 1: {
                this.triggerObserver(64843072);
                break;
            }
            case 2: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 3: {
                this.triggerObserver(14511424);
                break;
            }
            case 4: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 5: {
                this.triggerObserver(48065856);
                break;
            }
            case 6: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 7: {
                this.triggerObserver(81620288);
                break;
            }
            case 8: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 9: {
                this.triggerObserver(115174720);
                break;
            }
            case 10: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 11: {
                ClimateSetupActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811240777);
                break;
            }
            case 12: {
                this.setInteger(23745, ClimateSetupActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ClimateSetupActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23745));
                this.triggerObserver(98397504, eventGeneric);
                break;
            }
        }
    }
}

