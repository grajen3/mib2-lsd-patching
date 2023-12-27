/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.navtraffictiles.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class NavTrafficTileSActivity
extends StatemachineActivityBase {
    public NavTrafficTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.triggerObserver(-2134743232);
                NavTrafficTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2023387831);
                this.showView("Nt", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Nt");
                NavTrafficTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2006610615);
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
                this.triggerObserver(-2134743232);
                NavTrafficTileSActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2023387831);
                break;
            }
        }
    }
}

