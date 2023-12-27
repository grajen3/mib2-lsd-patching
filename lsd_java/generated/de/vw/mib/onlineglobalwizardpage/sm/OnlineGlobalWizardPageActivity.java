/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.onlineglobalwizardpage.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class OnlineGlobalWizardPageActivity
extends StatemachineActivityBase {
    public OnlineGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Gwocov", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 5: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(23));
                this.showView("Gwocsv", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Gwocov");
                break;
            }
            case 5: {
                this.hideView("Gwocsv");
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
                this.setInteger(29840, 23);
                this.setBoolean(32339, true);
                this.fireModelApiDownEvent(this.createModelApiDownEvent(22));
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return !(this.getInteger(20401) != 1 && this.getInteger(20401) != 0 || !this.getBoolean(-234422016) && this.getInteger(-471465984) != 2);
            }
        }
        return true;
    }
}

