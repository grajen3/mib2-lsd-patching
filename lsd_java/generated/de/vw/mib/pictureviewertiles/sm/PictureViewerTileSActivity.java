/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.pictureviewertiles.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class PictureViewerTileSActivity
extends StatemachineActivityBase {
    public PictureViewerTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.showView("Ptslc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Ptvs", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Ptslc");
                break;
            }
            case 7: {
                this.hideView("Ptvs");
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
                this.fireModelApiDownEvent(this.createModelApiDownEvent(28));
                break;
            }
            case 2: {
                this.fireModelApiDownEvent(this.createModelApiDownEvent(29));
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(183304192) == 1;
            }
        }
        return true;
    }
}

