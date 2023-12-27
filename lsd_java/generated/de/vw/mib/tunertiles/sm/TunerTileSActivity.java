/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tunertiles.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class TunerTileSActivity
extends StatemachineActivityBase {
    public TunerTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.showView("Ttvs_33E6", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Ttvs_33E6");
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
                this.setInteger(-1038417664, TunerTileSActivity.evIntegerValueValue());
                EventGeneric eventGeneric = TunerTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1038417664));
                this.triggerObserver(362751040, eventGeneric);
                break;
            }
            case 2: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(44));
                break;
            }
        }
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        this.performTriggeredTransitionAction0(n);
    }

    private void performTriggeredTransitionAction0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.triggerObserver(429859904);
                break;
            }
            case 1: {
                this.triggerObserver(446637120);
                break;
            }
        }
    }
}

