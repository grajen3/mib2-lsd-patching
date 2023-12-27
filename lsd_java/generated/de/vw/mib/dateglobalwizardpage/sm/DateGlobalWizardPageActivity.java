/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.dateglobalwizardpage.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class DateGlobalWizardPageActivity
extends StatemachineActivityBase {
    public DateGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.setInteger(1444479232, 1);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(10);
                modelApiDownEvent.setInt(0, this.getInteger(1444479232));
                this.fireModelApiDownEvent(modelApiDownEvent);
                this.showView("Dgwpt", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(11));
                this.setInteger(1444479232, 0);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(10);
                modelApiDownEvent.setInt(0, this.getInteger(1444479232));
                this.fireModelApiDownEvent(modelApiDownEvent);
                this.showView("Dgwpm", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Dgwpt");
                break;
            }
            case 8: {
                this.hideView("Dgwpm");
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 16: {
                return this.getInteger(435814400) != DateGlobalWizardPageActivity.evListItemActionIndex();
            }
            case 17: {
                return this.getInteger(-1886781440) != DateGlobalWizardPageActivity.evListItemActionIndex();
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        this.performInternalTransitionAction00(n);
    }

    private void performInternalTransitionAction00(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.setInteger(30515, DateGlobalWizardPageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = DateGlobalWizardPageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(30515));
                this.triggerObserver(1543831616, eventGeneric);
                DateGlobalWizardPageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1734380873);
                break;
            }
            case 2: {
                this.setBoolean(-368180992, true);
                this.triggerObserver(1694826560);
                break;
            }
            case 3: {
                this.setBoolean(-368180992, false);
                this.triggerObserver(1694826560);
                break;
            }
            case 6: {
                this.setBoolean(-368180992, true);
                if (this.getInteger(-1886781440) == 0) {
                    this.triggerObserver(923074624);
                }
                if (this.getInteger(-1886781440) == 2) {
                    this.triggerObserver(939851840);
                }
                if (this.getInteger(-1886781440) != 1) break;
                this.triggerObserver(956629056);
                break;
            }
            case 7: {
                this.setBoolean(-368180992, false);
                if (this.getInteger(-1886781440) == 0) {
                    this.triggerObserver(1107624000);
                }
                if (this.getInteger(-1886781440) == 2) {
                    this.triggerObserver(1124401216);
                }
                if (this.getInteger(-1886781440) != 1) break;
                this.triggerObserver(0x44050040);
                break;
            }
            case 8: {
                this.setBoolean(-368180992, true);
                this.triggerObserver(973406272);
                break;
            }
            case 9: {
                this.setBoolean(-368180992, false);
                this.triggerObserver(0x45050040);
                break;
            }
            case 10: {
                this.setBoolean(-368180992, true);
                this.triggerObserver(990183488);
                break;
            }
            case 11: {
                this.setBoolean(-368180992, false);
                this.triggerObserver(1174732864);
                break;
            }
            case 12: {
                this.setBoolean(-368180992, true);
                if (this.getInteger(-1886781440) == 0 || this.getInteger(-1886781440) == 1) {
                    this.triggerObserver(939851840);
                }
                if (this.getInteger(-1886781440) != 2) break;
                this.triggerObserver(923074624);
                break;
            }
            case 13: {
                this.setBoolean(-368180992, false);
                if (this.getInteger(-1886781440) == 0 || this.getInteger(-1886781440) == 1) {
                    this.triggerObserver(1124401216);
                }
                if (this.getInteger(-1886781440) != 2) break;
                this.triggerObserver(1107624000);
                break;
            }
            case 14: {
                this.setBoolean(-368180992, true);
                if (this.getInteger(-1886781440) == 0 || this.getInteger(-1886781440) == 2) {
                    this.triggerObserver(956629056);
                }
                if (this.getInteger(-1886781440) != 1) break;
                this.triggerObserver(923074624);
                break;
            }
            case 15: {
                this.setBoolean(-368180992, false);
                if (this.getInteger(-1886781440) == 0 || this.getInteger(-1886781440) == 2) {
                    this.triggerObserver(0x44050040);
                }
                if (this.getInteger(-1886781440) != 1) break;
                this.triggerObserver(1107624000);
                break;
            }
            case 16: {
                this.triggerObserver(1678049344);
                break;
            }
            case 17: {
                this.setInteger(465174528, DateGlobalWizardPageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = DateGlobalWizardPageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(465174528));
                this.triggerObserver(855965760, eventGeneric);
                break;
            }
        }
    }
}

