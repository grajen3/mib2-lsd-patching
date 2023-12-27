/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechheadline.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpeechHeadlineActivity
extends StatemachineActivityBase {
    public SpeechHeadlineActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.showView("Sh", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.hideView("Sh");
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
            case 1: {
                this.triggerObserver(-509853376);
                break;
            }
            case 2: {
                this.triggerObserver(-526630592);
                break;
            }
        }
    }
}

