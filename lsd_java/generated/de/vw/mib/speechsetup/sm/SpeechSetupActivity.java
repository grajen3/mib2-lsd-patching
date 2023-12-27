/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechsetup.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpeechSetupActivity
extends StatemachineActivityBase {
    public SpeechSetupActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 10: {
                this.showView("Sssm_1CF0", bl, 120);
                break;
            }
            case 11: {
                SpeechSetupActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 10: {
                this.hideView("Sssm_1CF0");
                break;
            }
        }
    }

    @Override
    public void performInternalTransitionAction(int n) {
        this.performInternalTransitionAction0(n);
    }

    private void performInternalTransitionAction0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(1142308928);
                break;
            }
            case 1: {
                this.triggerObserver(1159086144);
                break;
            }
            case 2: {
                this.triggerObserver(1075200064);
                break;
            }
            case 3: {
                this.triggerObserver(1091977280);
                break;
            }
            case 4: {
                this.triggerObserver(1108754496);
                break;
            }
            case 5: {
                this.triggerObserver(1125531712);
                break;
            }
            case 6: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(33));
                break;
            }
        }
    }
}

