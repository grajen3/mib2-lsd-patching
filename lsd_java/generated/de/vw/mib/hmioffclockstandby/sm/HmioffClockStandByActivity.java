/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.hmioffclockstandby.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class HmioffClockStandByActivity
extends StatemachineActivityBase {
    public HmioffClockStandByActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.setInteger(27625, this.getInteger(-657391616));
                break;
            }
            case 7: {
                this.setInteger(27625, this.getInteger(-657391616));
                if (!this.getBoolean(1016659968)) {
                    this.setInteger(24868, 0);
                }
                if (this.getBoolean(1016659968)) {
                    this.setInteger(24868, 1);
                }
                this.showView("Hocv_08DA85708EEB9B2F_DA1F", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.hideView("Hocv_08DA85708EEB9B2F_DA1F");
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return this.getInteger(-325517312) == 6;
            }
            case 2: {
                return this.getInteger(-325517312) == 4;
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
                this.setInteger(-519372544, 4);
                EventGeneric eventGeneric = HmioffClockStandByActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-519372544));
                this.triggerObserver(1191510080, eventGeneric);
                break;
            }
            case 2: {
                this.setInteger(-519372544, 6);
                EventGeneric eventGeneric = HmioffClockStandByActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-519372544));
                this.triggerObserver(1191510080, eventGeneric);
                break;
            }
            case 3: {
                this.setInteger(27625, HmioffClockStandByActivity.evIntegerValueValue());
                this.setInteger(11494, this.getInteger(27625));
                EventGeneric eventGeneric = HmioffClockStandByActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(11494));
                this.triggerObserver(1612800064, eventGeneric);
                break;
            }
        }
    }
}

