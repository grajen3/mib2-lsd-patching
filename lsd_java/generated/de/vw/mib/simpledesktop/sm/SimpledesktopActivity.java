/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.simpledesktop.sm;

import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SimpledesktopActivity
extends StatemachineActivityBase {
    public SimpledesktopActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.showView("Sdl_7DD2", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.hideView("Sdl_7DD2");
                break;
            }
        }
    }
}

