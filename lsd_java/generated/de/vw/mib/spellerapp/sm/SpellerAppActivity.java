/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.spellerapp.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpellerAppActivity
extends StatemachineActivityBase {
    public SpellerAppActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Sgaffm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 6: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Sgasfm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Sm_036E", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Suaffm", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Sgaffm");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 6: {
                this.hideView("Sgasfm");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 7: {
                this.hideView("Sm_036E");
                break;
            }
            case 8: {
                this.hideView("Suaffm");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = SpellerAppActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
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
                this.setBoolean(1225720064, true);
                SpellerAppActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 2: {
                this.setInteger(30292, 0);
                this.setInteger(16591, 1);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
            case 3: {
                this.setInteger(30292, 1);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
            case 4: {
                this.setInteger(30292, 1);
                this.setInteger(16591, 0);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
            case 5: {
                this.setInteger(30292, 0);
                this.setInteger(16591, 0);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
            case 6: {
                this.setInteger(30292, 2);
                this.setInteger(16591, 1);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
            case 7: {
                this.setInteger(30292, 2);
                this.setInteger(16591, 0);
                SpellerAppActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570271927);
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(30292) == 0;
            }
            case 1: {
                return this.getInteger(30292) == 1;
            }
            case 2: {
                return this.getInteger(30292) == 2;
            }
        }
        return true;
    }
}

