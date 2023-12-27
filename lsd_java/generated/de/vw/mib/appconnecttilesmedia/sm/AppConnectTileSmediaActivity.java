/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appconnecttilesmedia.sm;

import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class AppConnectTileSmediaActivity
extends StatemachineActivityBase {
    public AppConnectTileSmediaActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Acls", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 5: {
                this.setInteger(-1714880512, 0);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(1);
                modelApiDownEvent.setInt(0, this.getInteger(-1714880512));
                this.fireModelApiDownEvent(modelApiDownEvent);
                this.showView("Acms", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Acls");
                break;
            }
            case 5: {
                this.hideView("Acms");
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
                this.fireModelApiDownEvent(this.createModelApiDownEvent(0));
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(23881) != 1 || !this.getBoolean(278396928);
            }
        }
        return true;
    }
}

