/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navhomeadressglobalwizardpage.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class NavHomeAdressGlobalWizardPageActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public NavHomeAdressGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 537: {
                this.performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageHomeStoredDynState(n, bl);
                break;
            }
            case 538: {
                this.performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageNaviNotAvailableDynState(n, bl);
                break;
            }
            case 539: {
                this.performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageWaitstateDynState(n, bl);
                break;
            }
            case 23: {
                this.performStateEntryAction_SubHapticNavhomeadressglobalwizardpageDynState(n, bl);
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
            case 537: {
                this.performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageHomeStoredDynState(n);
                break;
            }
            case 538: {
                this.performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageNaviNotAvailableDynState(n);
                break;
            }
            case 539: {
                this.performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageWaitstateDynState(n);
                break;
            }
            case 23: {
                this.performStateExitAction_SubHapticNavhomeadressglobalwizardpageDynState(n);
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
            case 23: {
                return this.evalInternalTransitionGuard_SubHapticNavhomeadressglobalwizardpageDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 23: {
                this.performInternalTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(n);
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
            case 23: {
                return this.evalTriggeredTransitionGuard_SubHapticNavhomeadressglobalwizardpageDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 23: {
                this.performTriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(n);
                break;
            }
            default: {
                return;
            }
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
            case 23: {
                this.performUntriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageHomeStoredDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pnhagwphs", 537, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageHomeStoredDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                NavHomeAdressGlobalWizardPageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pnhagwphs");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageNaviNotAvailableDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pnhagwpnna", 538, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageNaviNotAvailableDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                NavHomeAdressGlobalWizardPageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pnhagwpnna");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoNavHomeAdressGlobalWizardPageWaitstateDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pnhagwpw", 539, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoNavHomeAdressGlobalWizardPageWaitstateDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                NavHomeAdressGlobalWizardPageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pnhagwpw");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticNavhomeadressglobalwizardpageDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.enterWaitaphoreForProperty(27618, 456, 565, 996773193, 979995977);
                break;
            }
            case 10: {
                this.showView("Nhagwpm", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.leaveWaitaphore();
                break;
            }
            case 10: {
                this.hideView("Nhagwpm");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return !this.getBoolean(1846411520);
            }
            case 2: {
                return this.getBoolean(1846411520);
            }
            case 3: {
                return !this.getBoolean(1846411520);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        this.performInternalTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                NavHomeAdressGlobalWizardPageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1381666121);
                break;
            }
            case 2: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(17));
                break;
            }
            case 3: {
                NavHomeAdressGlobalWizardPageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1381666121);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 4: {
                return this.getBoolean(1846411520);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 2: {
                NavHomeAdressGlobalWizardPageActivity.fireHMIEvent(ANY, BROADCAST, 1382059337);
                break;
            }
        }
    }

    private void performUntriggeredTransitionAction_SubHapticNavhomeadressglobalwizardpageDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                NavHomeAdressGlobalWizardPageActivity.lockWaitaphore(27618, -386072576);
                this.fireModelApiDownEvent(this.createModelApiDownEvent(18));
                break;
            }
        }
    }
}

