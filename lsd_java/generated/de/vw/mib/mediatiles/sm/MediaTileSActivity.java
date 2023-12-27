/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.mediatiles.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class MediaTileSActivity
extends StatemachineActivityBase {
    public MediaTileSActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.showView("Mslc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Mvs", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Mslc");
                break;
            }
            case 7: {
                this.hideView("Mvs");
                break;
            }
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return this.getBoolean(-1642725120);
            }
            case 2: {
                return MediaTileSActivity.evPointGestureParam1() > 0;
            }
            case 3: {
                return MediaTileSActivity.evPointGestureParam1() < 0;
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
            case 1: {
                if (this.getInteger(-994836480) == 6 || this.getInteger(-994836480) == 7 || this.getInteger(-994836480) == 1) {
                    this.setInteger(-1294860288, 2);
                }
                if (this.getInteger(-994836480) != 6 && this.getInteger(-994836480) != 7 && this.getInteger(-994836480) != 1) {
                    this.setInteger(-1294860288, 1);
                }
                EventGeneric eventGeneric = MediaTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1294860288));
                this.triggerObserver(0x11000040, eventGeneric);
                break;
            }
            case 2: {
                MediaTileSActivity.fireHMIEvent(ANY, BROADCAST, -1889825463);
                break;
            }
            case 3: {
                MediaTileSActivity.fireHMIEvent(ANY, BROADCAST, -1956934327);
                break;
            }
            case 4: {
                this.setInteger(20194, 1);
                EventGeneric eventGeneric = MediaTileSActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(20194));
                this.triggerObserver(-284950464, eventGeneric);
                break;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(27660) == 1;
            }
        }
        return true;
    }
}

