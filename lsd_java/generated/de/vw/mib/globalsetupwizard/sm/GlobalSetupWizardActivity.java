/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.globalsetupwizard.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class GlobalSetupWizardActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public GlobalSetupWizardActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 246: {
                this.performStateEntryAction_SubPopupPoConfirmGlobalWizardDriveDynState(n, bl);
                break;
            }
            case 247: {
                this.performStateEntryAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(n, bl);
                break;
            }
            case 12: {
                this.performStateEntryAction_SubHapticGlobalsetupwizardDynState(n, bl);
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
            case 246: {
                this.performStateExitAction_SubPopupPoConfirmGlobalWizardDriveDynState(n);
                break;
            }
            case 247: {
                this.performStateExitAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(n);
                break;
            }
            case 12: {
                this.performStateExitAction_SubHapticGlobalsetupwizardDynState(n);
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
            case 246: {
                return this.evalInternalTransitionGuard_SubPopupPoConfirmGlobalWizardDriveDynState(n);
            }
            case 247: {
                return this.evalInternalTransitionGuard_SubPopupPoConfirmGlobalWizardIgnitionDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 246: {
                this.performInternalTransitionAction_SubPopupPoConfirmGlobalWizardDriveDynState(n);
                break;
            }
            case 247: {
                this.performInternalTransitionAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(n);
                break;
            }
            case 12: {
                this.performInternalTransitionAction_SubHapticGlobalsetupwizardDynState(n);
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
            case 12: {
                return this.evalUntriggeredTransitionGuard_SubHapticGlobalsetupwizardDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 12: {
                this.performUntriggeredTransitionAction_SubHapticGlobalsetupwizardDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmGlobalWizardDriveDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcgwd", 246, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmGlobalWizardDriveDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                GlobalSetupWizardActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcgwd");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoConfirmGlobalWizardDriveDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return !this.getBoolean(1436418048) || this.getInteger(-1173159680) != 1;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoConfirmGlobalWizardDriveDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoConfirmGlobalWizardDriveDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoConfirmGlobalWizardDriveDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                if (this.getInteger(-1173159680) == 1) {
                    this.triggerObserver(-2057810112);
                }
                if (this.getInteger(-1173159680) == 1) break;
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1402958519);
                break;
            }
            case 1: {
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1402958519);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcgwi", 247, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                GlobalSetupWizardActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcgwi");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoConfirmGlobalWizardIgnitionDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return this.getBoolean(-1243086848) || this.getInteger(-1173159680) != 1;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoConfirmGlobalWizardIgnitionDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoConfirmGlobalWizardIgnitionDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoConfirmGlobalWizardIgnitionDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                if (this.getInteger(-1173159680) == 1) {
                    this.triggerObserver(-2057810112);
                }
                if (this.getInteger(-1173159680) == 1) break;
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1386181303);
                break;
            }
            case 1: {
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1386181303);
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticGlobalsetupwizardDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                GlobalSetupWizardActivity.changeContext("Setup");
                break;
            }
            case 6: {
                this.showView("Gsws", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Gswf", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.showView("Gswp", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticGlobalsetupwizardDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.triggerObserver(-2057810112);
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1402958519);
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1386181303);
                break;
            }
            case 6: {
                this.hideView("Gsws");
                break;
            }
            case 7: {
                this.hideView("Gswf");
                break;
            }
            case 8: {
                this.hideView("Gswp");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticGlobalsetupwizardDynState(int n) {
        this.performInternalTransitionAction_SubHapticGlobalsetupwizardDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticGlobalsetupwizardDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.triggerObserver(-2091364544);
                this.triggerObserver(-2057810112);
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1402958519);
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1386181303);
                break;
            }
            case 2: {
                this.triggerObserver(-2074587328);
                break;
            }
            case 3: {
                this.triggerObserver(-2141696192);
                break;
            }
            case 4: {
                this.setInteger(-1330315264, GlobalSetupWizardActivity.evListItemActionIndex());
                this.setLong(-55771136, this.getLicValue(-1820373248, 0, this.getInteger(-1330315264), 0L));
                EventGeneric eventGeneric = GlobalSetupWizardActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-55771136));
                this.triggerObserver(-2108141760, eventGeneric);
                break;
            }
            case 5: {
                this.triggerObserver(-2091364544);
                break;
            }
            case 6: {
                this.setInteger(-1330315264, GlobalSetupWizardActivity.evListItemActionIndex());
                this.setLong(-55771136, this.getLicValue(-1820373248, 0, this.getInteger(-1330315264), 0L));
                EventGeneric eventGeneric = GlobalSetupWizardActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-55771136));
                this.triggerObserver(-2108141760, eventGeneric);
                break;
            }
            case 7: {
                this.triggerObserver(-2124918976);
                break;
            }
            case 8: {
                this.triggerObserver(-2141696192);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticGlobalsetupwizardDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(-1173159680) == 0;
            }
            case 2: {
                return this.getInteger(-1173159680) == 1;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticGlobalsetupwizardDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 2: {
                if (!this.getBoolean(-1243086848)) {
                    GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 760909129);
                }
                if (!this.getBoolean(1436418048)) break;
                GlobalSetupWizardActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 744131913);
                break;
            }
        }
    }
}

