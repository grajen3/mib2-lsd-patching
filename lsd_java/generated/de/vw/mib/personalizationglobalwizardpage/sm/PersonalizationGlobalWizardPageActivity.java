/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.personalizationglobalwizardpage.sm;

import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class PersonalizationGlobalWizardPageActivity
extends StatemachineActivityBase {
    public PersonalizationGlobalWizardPageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.showView("Pgwp", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.hideView("Pgwp");
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
                if (this.getInteger(14951) > 0) {
                    this.setString(1226309888, this.getI18nStrings(223)[this.getInteger(14951)]);
                }
                if (this.getInteger(14951) == 0) {
                    this.setString(1226309888, this.getString(18518));
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(24);
                modelApiDownEvent.setString(0, this.getString(1226309888));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
        }
    }
}

