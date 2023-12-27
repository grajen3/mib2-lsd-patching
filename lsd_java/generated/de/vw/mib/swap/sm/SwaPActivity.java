/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.swap.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SwaPActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SwaPActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 53: {
                this.performStateEntryAction_SubHapticSwapDynState(n, bl);
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
            case 433: {
                this.performStateExitAction_SubPopupPoInfoSwapFeatureUnlockErrorDynState(n);
                break;
            }
            case 434: {
                this.performStateExitAction_SubPopupPoInfoSwapFeatureUnlockDynState(n);
                break;
            }
            case 435: {
                this.performStateExitAction_SubPopupPoInfoSwapGeneratedSuccessDynState(n);
                break;
            }
            case 53: {
                this.performStateExitAction_SubHapticSwapDynState(n);
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
            case 53: {
                this.performInternalTransitionAction_SubHapticSwapDynState(n);
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

    private void performStateExitAction_SubPopupPoInfoSwapFeatureUnlockErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SwaPActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoSwapFeatureUnlockDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SwaPActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoSwapGeneratedSuccessDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SwaPActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticSwapDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(453116160, 2);
                break;
            }
            case 8: {
                this.setInteger(453116160, 3);
                break;
            }
            case 12: {
                this.setInteger(453116160, 2);
                break;
            }
            case 13: {
                SwaPActivity.fireHMIEvent(ANY, BROADCAST, 1281461577);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSwapDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(453116160, 0);
                break;
            }
            case 8: {
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticSwapDynState(int n) {
        this.performInternalTransitionAction_SubHapticSwapDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticSwapDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
        }
    }
}

