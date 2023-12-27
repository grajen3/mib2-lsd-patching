/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tunerautostoreglobalwizardpage.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class TunerAutostoreGlobalWizardPageActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public TunerAutostoreGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 452: {
                this.performStateEntryAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(n, bl);
                break;
            }
            case 60: {
                this.performStateEntryAction_SubHapticTunerautostoreglobalwizardpageDynState(n, bl);
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
            case 452: {
                this.performStateExitAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(n);
                break;
            }
            case 60: {
                this.performStateExitAction_SubHapticTunerautostoreglobalwizardpageDynState(n);
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
            default: 
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 452: {
                this.performInternalTransitionAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(n);
                break;
            }
            case 60: {
                this.performInternalTransitionAction_SubHapticTunerautostoreglobalwizardpageDynState(n);
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

    private void performStateEntryAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Ptia", 452, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerAutostoreGlobalWizardPageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Ptia");
                this.fireModelApiDownEvent(this.createModelApiDownEvent(42));
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerautostoreglobalwizardpageInitialAutostoreDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(42));
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticTunerautostoreglobalwizardpageDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.showView("Tm_14BA", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticTunerautostoreglobalwizardpageDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Tm_14BA");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticTunerautostoreglobalwizardpageDynState(int n) {
        this.performInternalTransitionAction_SubHapticTunerautostoreglobalwizardpageDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticTunerautostoreglobalwizardpageDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(41));
                break;
            }
            case 2: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(43));
                break;
            }
        }
    }
}

