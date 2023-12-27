/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.drivingdatatiles.sm;

import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class DrivingDataTileSActivity
extends StatemachineActivityBase {
    public DrivingDataTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.showView("Ddts", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Ddtslc", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Ddts");
                break;
            }
            case 7: {
                this.hideView("Ddtslc");
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
                this.setInteger(-475922432, DrivingDataTileSActivity.evIntegerValueValue());
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(12);
                modelApiDownEvent.setInt(0, this.getInteger(-475922432));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(1307770880) == 1;
            }
        }
        return true;
    }
}

