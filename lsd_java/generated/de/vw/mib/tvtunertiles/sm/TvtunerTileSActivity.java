/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tvtunertiles.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class TvtunerTileSActivity
extends StatemachineActivityBase {
    public TvtunerTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Ttvs_324A", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Ttvs_324A");
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return TvtunerTileSActivity.evPointGestureParam1() > 0;
            }
            case 2: {
                return TvtunerTileSActivity.evPointGestureParam1() < 0;
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        this.performInternalTransitionAction0(n);
    }

    private void performInternalTransitionAction0(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(36));
                break;
            }
            case 2: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(35));
                break;
            }
        }
    }
}

