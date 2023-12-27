/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.phoneglobalwizardpage.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class PhoneGlobalWizardPageActivity
extends StatemachineActivityBase {
    public PhoneGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                PhoneGlobalWizardPageActivity.fireHMIEvent(ANY, BROADCAST, 2069466441);
                this.showView("Pgwpm", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Pgwpm");
                this.setInteger(28218, 0);
                EventGeneric eventGeneric = PhoneGlobalWizardPageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28218));
                this.triggerObserver(11034944, eventGeneric);
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getInteger(1695809792) == 5 && this.getInteger(-878772224) == 2;
            }
            case 1: {
                return this.getInteger(1695809792) == 5 && this.getInteger(-878772224) == 2;
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
            case 0: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(25));
                break;
            }
            case 1: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(25));
                break;
            }
            case 3: {
                this.setInteger(28218, 1);
                EventGeneric eventGeneric = PhoneGlobalWizardPageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28218));
                this.triggerObserver(11034944, eventGeneric);
                break;
            }
        }
    }
}

