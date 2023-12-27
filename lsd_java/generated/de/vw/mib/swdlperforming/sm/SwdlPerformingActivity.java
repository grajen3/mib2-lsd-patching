/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.swdlperforming.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SwdlPerformingActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SwdlPerformingActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 55: {
                this.performStateEntryAction_SubHapticSwdlPerformingDynState(n, bl);
                break;
            }
            case 657: {
                this.performStateEntryAction_SubIGenericDomainErrorBridge(n, bl);
                break;
            }
            case 658: {
                this.performStateEntryAction_SubIGenericDomainNotAvailableBridge(n, bl);
                break;
            }
            case 698: {
                this.performStateEntryAction_SubISwdlDeviceNotReady(n, bl);
                break;
            }
            case 699: {
                this.performStateEntryAction_SubISwdlLogging(n, bl);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (this.subStatemachineId) {
            case 55: {
                this.performStateExitAction_SubHapticSwdlPerformingDynState(n);
                break;
            }
            case 657: {
                this.performStateExitAction_SubIGenericDomainErrorBridge(n);
                break;
            }
            case 658: {
                this.performStateExitAction_SubIGenericDomainNotAvailableBridge(n);
                break;
            }
            case 698: {
                this.performStateExitAction_SubISwdlDeviceNotReady(n);
                break;
            }
            case 699: {
                this.performStateExitAction_SubISwdlLogging(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateFocusGainedAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public void performStateFocusLostAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    @Override
    public boolean evalInternalTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 55: {
                this.performInternalTransitionAction_SubHapticSwdlPerformingDynState(n);
                break;
            }
            case 699: {
                this.performInternalTransitionAction_SubISwdlLogging(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public boolean evalTriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 55: {
                this.performTriggeredTransitionAction_SubHapticSwdlPerformingDynState(n);
                break;
            }
            case 699: {
                this.performTriggeredTransitionAction_SubISwdlLogging(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 55: {
                return this.evalUntriggeredTransitionGuard_SubHapticSwdlPerformingDynState(n);
            }
            case 698: {
                return this.evalUntriggeredTransitionGuard_SubISwdlDeviceNotReady(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 55: {
                this.performUntriggeredTransitionAction_SubHapticSwdlPerformingDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubHapticSwdlPerformingDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1527709952, 2);
                break;
            }
            case 8: {
                this.setInteger(26545, SkinDataPool.getInteger(190));
                this.setInteger(0x820000, 21);
                this.setInteger(1527709952, 3);
                break;
            }
            case 14: {
                this.setInteger(0x100A0100, 5);
                this.setInteger(1150418944, 7);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 20: {
                this.triggerObserver(822149184);
                break;
            }
            case 26: {
                this.showView("Srw", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 27: {
                this.showView("Srvd", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 28: {
                this.showView("Srvdf", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 29: {
                this.showView("Se", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 30: {
                this.showView("Spm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 31: {
                SwdlPerformingActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1117287095);
                this.showView("Sri", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 32: {
                SwdlPerformingActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1117287095);
                this.showView("Src", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 33: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 34: {
                this.setInteger(1527709952, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSwdlPerformingDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1527709952, 0);
                break;
            }
            case 8: {
                this.setInteger(26545, SkinDataPool.getInteger(180));
                this.setInteger(0x820000, 0);
                break;
            }
            case 26: {
                this.hideView("Srw");
                break;
            }
            case 27: {
                this.hideView("Srvd");
                break;
            }
            case 28: {
                this.hideView("Srvdf");
                break;
            }
            case 29: {
                this.hideView("Se");
                break;
            }
            case 30: {
                this.hideView("Spm");
                break;
            }
            case 31: {
                this.hideView("Sri");
                break;
            }
            case 32: {
                this.hideView("Src");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticSwdlPerformingDynState(int n) {
        this.performInternalTransitionAction_SubHapticSwdlPerformingDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticSwdlPerformingDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(26545, SkinDataPool.getInteger(190));
                break;
            }
            case 1: {
                this.setInteger(26545, SkinDataPool.getInteger(180));
                break;
            }
            case 2: {
                this.setBoolean(-988348160, false);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-988348160));
                this.triggerObserver(922812480, eventGeneric);
                SwdlPerformingActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1167618743);
                break;
            }
            case 3: {
                this.triggerObserver(587268160);
                break;
            }
            case 4: {
                this.setInteger(-1195573248, 3);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1195573248));
                this.triggerObserver(771817536, eventGeneric);
                break;
            }
            case 5: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, 1448774985);
                this.setInteger(-1195573248, 2);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1195573248));
                this.triggerObserver(771817536, eventGeneric);
                break;
            }
            case 6: {
                this.triggerObserver(587268160);
                break;
            }
            case 7: {
                this.triggerObserver(587268160);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticSwdlPerformingDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticSwdlPerformingDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticSwdlPerformingDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 9: {
                this.triggerObserver(-1224277952);
                break;
            }
            case 10: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1117745847);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticSwdlPerformingDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                return this.getInteger(-561905664) == 0;
            }
            case 7: {
                return this.getInteger(-561905664) == 1;
            }
            case 12: {
                return !this.getBoolean(22678) && !this.getBoolean(14738);
            }
            case 13: {
                return this.getBoolean(22678) && !this.getBoolean(14738);
            }
            case 17: {
                return !this.getBoolean(-789184512);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticSwdlPerformingDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 12: {
                this.setBoolean(27691, false);
                break;
            }
            case 13: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1117745847);
                break;
            }
            case 17: {
                this.setBoolean(-988348160, true);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-988348160));
                this.triggerObserver(922812480, eventGeneric);
                break;
            }
            case 18: {
                this.setBoolean(-988348160, false);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-988348160));
                this.triggerObserver(922812480, eventGeneric);
                SwdlPerformingActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1167618743);
                break;
            }
            case 20: {
                this.setInteger(814350336, 0);
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(814350336));
                this.triggerObserver(721485888, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIGenericDomainErrorBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Gde", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIGenericDomainErrorBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Gde");
                break;
            }
        }
    }

    private void performStateEntryAction_SubIGenericDomainNotAvailableBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Gdna", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIGenericDomainNotAvailableBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Gdna");
                break;
            }
        }
    }

    private void performStateEntryAction_SubISwdlDeviceNotReady(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.showView("Sdr", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.showView("Sdnr", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubISwdlDeviceNotReady(int n) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.hideView("Sdr");
                break;
            }
            case 8: {
                this.hideView("Sdnr");
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubISwdlDeviceNotReady(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getBoolean(13642);
            }
            case 3: {
                return this.getBoolean(-789184512);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubISwdlLogging(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.showView("Sal", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 4: {
                this.showView("Sdl_9DCD", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 5: {
                this.showView("Sil", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 6: {
                this.showView("Sml", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubISwdlLogging(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.hideView("Sal");
                break;
            }
            case 4: {
                this.hideView("Sdl_9DCD");
                break;
            }
            case 5: {
                this.hideView("Sil");
                break;
            }
            case 6: {
                this.hideView("Sml");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubISwdlLogging(int n) {
        this.performInternalTransitionAction_SubISwdlLogging0(n);
    }

    private void performInternalTransitionAction_SubISwdlLogging0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(696451072, SwdlPerformingActivity.evListItemActionIndex());
                break;
            }
            case 1: {
                this.setInteger(-1061224448, SwdlPerformingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1061224448));
                this.triggerObserver(738263104, eventGeneric);
                break;
            }
            case 2: {
                this.setInteger(27478, SwdlPerformingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SwdlPerformingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27478));
                this.triggerObserver(755040320, eventGeneric);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubISwdlLogging(int n) {
        this.performTriggeredTransitionAction_SubISwdlLogging0(n);
    }

    private void performTriggeredTransitionAction_SubISwdlLogging0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 1: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 2: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 3: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 4: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 5: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 6: {
                SwdlPerformingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }
}

