/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.selectiontiles.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SelectionTileSActivity
extends StatemachineActivityBase {
    public SelectionTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.showView("Sts", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.hideView("Sts");
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
                this.setInteger(1038548992, SelectionTileSActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SelectionTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1038548992));
                this.triggerObserver(-1067101632, eventGeneric);
                break;
            }
        }
    }
}

