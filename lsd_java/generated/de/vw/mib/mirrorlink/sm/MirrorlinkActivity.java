/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.mirrorlink.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class MirrorlinkActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public MirrorlinkActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 251: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(n, bl);
                break;
            }
            case 252: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorAppIncompatibleDynState(n, bl);
                break;
            }
            case 253: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorAppNotStartableRegionDynState(n, bl);
                break;
            }
            case 254: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorAppNotStartableDynState(n, bl);
                break;
            }
            case 255: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorDeveloperModeDynState(n, bl);
                break;
            }
            case 256: {
                this.performStateEntryAction_SubPopupPoConfirmMirrorLimitedCompatibleDynState2(n, bl);
                break;
            }
            case 308: {
                this.performStateEntryAction_SubPopupPoErrorMirrorAppNotFunctionalDynState(n, bl);
                break;
            }
            case 310: {
                this.performStateEntryAction_SubPopupPoFatalErrorMirrorlinkDynState(n, bl);
                break;
            }
            case 324: {
                this.performStateEntryAction_SubPopupPoGobalMirrorAudioErrorDynState(n, bl);
                break;
            }
            case 405: {
                this.performStateEntryAction_SubPopupPoInfoMirrolinkAppIncompatibleDynState(n, bl);
                break;
            }
            case 22: {
                this.performStateEntryAction_SubHapticMirrorlinkDynState(n, bl);
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
            case 659: {
                this.performStateEntryAction_SubIGenericDomainNotAvailableSwapBridge(n, bl);
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
            case 251: {
                this.performStateExitAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(n);
                break;
            }
            case 252: {
                this.performStateExitAction_SubPopupPoConfirmMirrorAppIncompatibleDynState(n);
                break;
            }
            case 253: {
                this.performStateExitAction_SubPopupPoConfirmMirrorAppNotStartableRegionDynState(n);
                break;
            }
            case 254: {
                this.performStateExitAction_SubPopupPoConfirmMirrorAppNotStartableDynState(n);
                break;
            }
            case 255: {
                this.performStateExitAction_SubPopupPoConfirmMirrorDeveloperModeDynState(n);
                break;
            }
            case 256: {
                this.performStateExitAction_SubPopupPoConfirmMirrorLimitedCompatibleDynState2(n);
                break;
            }
            case 308: {
                this.performStateExitAction_SubPopupPoErrorMirrorAppNotFunctionalDynState(n);
                break;
            }
            case 310: {
                this.performStateExitAction_SubPopupPoFatalErrorMirrorlinkDynState(n);
                break;
            }
            case 324: {
                this.performStateExitAction_SubPopupPoGobalMirrorAudioErrorDynState(n);
                break;
            }
            case 405: {
                this.performStateExitAction_SubPopupPoInfoMirrolinkAppIncompatibleDynState(n);
                break;
            }
            case 22: {
                this.performStateExitAction_SubHapticMirrorlinkDynState(n);
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
            case 659: {
                this.performStateExitAction_SubIGenericDomainNotAvailableSwapBridge(n);
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
            case 22: {
                this.performInternalTransitionAction_SubHapticMirrorlinkDynState(n);
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
            case 22: {
                return this.evalTriggeredTransitionGuard_SubHapticMirrorlinkDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 251: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(n);
                break;
            }
            case 310: {
                this.performTriggeredTransitionAction_SubPopupPoFatalErrorMirrorlinkDynState(n);
                break;
            }
            case 22: {
                this.performTriggeredTransitionAction_SubHapticMirrorlinkDynState(n);
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
            case 22: {
                return this.evalUntriggeredTransitionGuard_SubHapticMirrorlinkDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 22: {
                this.performUntriggeredTransitionAction_SubHapticMirrorlinkDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setBoolean(1997668608, false);
                break;
            }
            case 3: {
                this.enterPopupView("Pcman", 251, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                if (this.getBoolean(1997668608)) break;
                this.setInteger(10902, 0);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(1, this.getInteger(10902));
                this.triggerObserver(1161957184, eventGeneric);
                break;
            }
            case 3: {
                this.leavePopupView("Pcman");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMirrorlinkAppNotificationDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setBoolean(1997668608, true);
                this.setInteger(10902, 1);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(1, this.getInteger(10902));
                this.triggerObserver(1161957184, eventGeneric);
                break;
            }
            case 1: {
                this.setBoolean(1997668608, true);
                this.setInteger(10902, 2);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(1, this.getInteger(10902));
                this.triggerObserver(1161957184, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorAppIncompatibleDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcmai", 252, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorAppIncompatibleDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcmai");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorAppNotStartableRegionDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcmansr", 253, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorAppNotStartableRegionDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcmansr");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorAppNotStartableDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcmans", 254, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorAppNotStartableDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcmans");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorDeveloperModeDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcmdm", 255, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorDeveloperModeDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcmdm");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMirrorLimitedCompatibleDynState2(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pcmlc", 256, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMirrorLimitedCompatibleDynState2(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pcmlc");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoErrorMirrorAppNotFunctionalDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pemanf", 308, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoErrorMirrorAppNotFunctionalDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pemanf");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoFatalErrorMirrorlinkDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pfem", 310, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoFatalErrorMirrorlinkDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pfem");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoFatalErrorMirrorlinkDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoFatalErrorMirrorlinkDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoFatalErrorMirrorlinkDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.triggerObserver(1527316544);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoGobalMirrorAudioErrorDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pgmae", 324, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoGobalMirrorAudioErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pgmae");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMirrolinkAppIncompatibleDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pimai", 405, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMirrolinkAppIncompatibleDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MirrorlinkActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pimai");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticMirrorlinkDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-1307901696, 2);
                this.setBoolean(519897088, false);
                if (!this.getBoolean(17873)) {
                    this.setBoolean(32614, true);
                }
                if (this.getBoolean(17873)) {
                    this.setBoolean(32614, false);
                }
                this.setBoolean(2075656192, true);
                this.setBoolean(16559, true);
                break;
            }
            case 8: {
                this.setInteger(0x820000, 26);
                this.setInteger(-1307901696, 3);
                break;
            }
            case 10: {
                this.triggerObserver(1678377024);
                MirrorlinkActivity.changeContext("Mirrorlink");
                break;
            }
            case 13: {
                this.showView("Mcoa", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 15: {
                this.triggerObserver(1644822592);
                this.setBoolean(519897088, false);
                this.setBoolean(2075656192, true);
                this.setBoolean(16559, true);
                break;
            }
            case 17: {
                this.showView("Mam", bl, 124);
                break;
            }
            case 18: {
                this.setBoolean(519897088, true);
                this.showView("Mm_FD5A", bl, 123);
                break;
            }
            case 19: {
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 20: {
                this.setInteger(-1307901696, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticMirrorlinkDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-1307901696, 0);
                break;
            }
            case 8: {
                this.setInteger(0x820000, 0);
                break;
            }
            case 10: {
                this.triggerObserver(1695154240);
                break;
            }
            case 13: {
                this.hideView("Mcoa");
                break;
            }
            case 15: {
                this.triggerObserver(1661599808);
                break;
            }
            case 17: {
                this.hideView("Mam");
                break;
            }
            case 18: {
                this.hideView("Mm_FD5A");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticMirrorlinkDynState(int n) {
        this.performInternalTransitionAction_SubHapticMirrorlinkDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticMirrorlinkDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setBoolean(519897088, false);
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                this.setInteger(250675200, 100);
                this.setInteger(-641466368, 100);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-641466368));
                eventGeneric.setInt(1, this.getInteger(250675200));
                this.triggerObserver(1560936512, eventGeneric);
                break;
            }
            case 3: {
                this.setInteger(-1583153152, SkinDataPool.getInteger(190));
                break;
            }
            case 4: {
                this.setInteger(-1583153152, SkinDataPool.getInteger(180));
                break;
            }
            case 5: {
                this.triggerObserver(1078071104);
                break;
            }
            case 6: {
                this.triggerObserver(1527316544);
                this.setBoolean(519897088, false);
                break;
            }
            case 7: {
                this.setInteger(30370, MirrorlinkActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(30370));
                this.triggerObserver(-301400000, eventGeneric);
                break;
            }
            case 8: {
                MirrorlinkActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 90541385);
                break;
            }
            case 9: {
                this.triggerObserver(1094848320);
                break;
            }
            case 10: {
                this.setBoolean(25386, true);
                break;
            }
            case 11: {
                this.setBoolean(25386, false);
                break;
            }
            case 12: {
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, 610897225);
                break;
            }
            case 13: {
                this.setInteger(1337327616, MirrorlinkActivity.evPointX());
                this.setInteger(1286995968, MirrorlinkActivity.evPointY());
                this.setInteger(152436992, 0);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1337327616));
                eventGeneric.setInt(1, this.getInteger(1286995968));
                eventGeneric.setInt(2, this.getInteger(1824456704));
                eventGeneric.setInt(3, this.getInteger(1790902272));
                eventGeneric.setInt(4, this.getInteger(23553));
                eventGeneric.setInt(5, this.getInteger(-343932928));
                eventGeneric.setInt(6, this.getInteger(152436992));
                this.triggerObserver(-1140195264, eventGeneric);
                this.setInteger(10717, MirrorlinkActivity.evPointX());
                this.setInteger(10716, MirrorlinkActivity.evPointY());
                this.setInteger(-1165688832, 0);
                eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10717));
                eventGeneric.setInt(1, this.getInteger(10716));
                eventGeneric.setInt(2, this.getInteger(-1165688832));
                this.triggerObserver(-1609957312, eventGeneric);
                break;
            }
            case 14: {
                this.setInteger(1337327616, MirrorlinkActivity.evPointX());
                this.setInteger(1286995968, MirrorlinkActivity.evPointY());
                this.setInteger(152436992, 2);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1337327616));
                eventGeneric.setInt(1, this.getInteger(1286995968));
                eventGeneric.setInt(2, this.getInteger(1824456704));
                eventGeneric.setInt(3, this.getInteger(1790902272));
                eventGeneric.setInt(4, this.getInteger(23553));
                eventGeneric.setInt(5, this.getInteger(-343932928));
                eventGeneric.setInt(6, this.getInteger(152436992));
                this.triggerObserver(-1140195264, eventGeneric);
                this.setInteger(10717, MirrorlinkActivity.evPointX());
                this.setInteger(10716, MirrorlinkActivity.evPointY());
                this.setInteger(-1165688832, 0);
                eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10717));
                eventGeneric.setInt(1, this.getInteger(10716));
                eventGeneric.setInt(2, this.getInteger(-1165688832));
                this.triggerObserver(-1609957312, eventGeneric);
                this.setInteger(-1165688832, 1);
                eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10717));
                eventGeneric.setInt(1, this.getInteger(10716));
                eventGeneric.setInt(2, this.getInteger(-1165688832));
                this.triggerObserver(-1609957312, eventGeneric);
                break;
            }
            case 15: {
                this.setInteger(1337327616, MirrorlinkActivity.evPointX());
                this.setInteger(1286995968, MirrorlinkActivity.evPointY());
                this.setInteger(1824456704, MirrorlinkActivity.evPointGestureParam1());
                this.setInteger(1790902272, MirrorlinkActivity.evPointGestureParam2());
                this.setInteger(152436992, 3);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1337327616));
                eventGeneric.setInt(1, this.getInteger(1286995968));
                eventGeneric.setInt(2, this.getInteger(1824456704));
                eventGeneric.setInt(3, this.getInteger(1790902272));
                eventGeneric.setInt(4, this.getInteger(23553));
                eventGeneric.setInt(5, this.getInteger(-343932928));
                eventGeneric.setInt(6, this.getInteger(152436992));
                this.triggerObserver(-1140195264, eventGeneric);
                this.setInteger(10717, MirrorlinkActivity.evPointX());
                this.setInteger(10716, MirrorlinkActivity.evPointY());
                this.setInteger(-1165688832, 0);
                eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10717));
                eventGeneric.setInt(1, this.getInteger(10716));
                eventGeneric.setInt(2, this.getInteger(-1165688832));
                this.triggerObserver(-1609957312, eventGeneric);
                break;
            }
            case 16: {
                this.setInteger(1337327616, MirrorlinkActivity.evPointX());
                this.setInteger(1286995968, MirrorlinkActivity.evPointY());
                this.setInteger(-343932928, MirrorlinkActivity.evPointGestureParam1());
                this.setInteger(23553, MirrorlinkActivity.evPointGestureParam2());
                this.setInteger(152436992, 4);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1337327616));
                eventGeneric.setInt(1, this.getInteger(1286995968));
                eventGeneric.setInt(2, this.getInteger(1824456704));
                eventGeneric.setInt(3, this.getInteger(1790902272));
                eventGeneric.setInt(4, this.getInteger(23553));
                eventGeneric.setInt(5, this.getInteger(-343932928));
                eventGeneric.setInt(6, this.getInteger(152436992));
                this.triggerObserver(-1140195264, eventGeneric);
                break;
            }
            case 17: {
                this.setInteger(1337327616, MirrorlinkActivity.evPointX());
                this.setInteger(1286995968, MirrorlinkActivity.evPointY());
                this.setInteger(152436992, 1);
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1337327616));
                eventGeneric.setInt(1, this.getInteger(1286995968));
                eventGeneric.setInt(2, this.getInteger(1824456704));
                eventGeneric.setInt(3, this.getInteger(1790902272));
                eventGeneric.setInt(4, this.getInteger(23553));
                eventGeneric.setInt(5, this.getInteger(-343932928));
                eventGeneric.setInt(6, this.getInteger(152436992));
                this.triggerObserver(-1140195264, eventGeneric);
                this.setInteger(10717, MirrorlinkActivity.evPointX());
                this.setInteger(10716, MirrorlinkActivity.evPointY());
                this.setInteger(-1165688832, 1);
                eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10717));
                eventGeneric.setInt(1, this.getInteger(10716));
                eventGeneric.setInt(2, this.getInteger(-1165688832));
                this.triggerObserver(-1609957312, eventGeneric);
                break;
            }
            case 18: {
                this.setBoolean(13682, !this.getBoolean(13682));
                this.setBoolean(32614, !this.getBoolean(32614));
                this.setBoolean(17873, !this.getBoolean(17873));
                break;
            }
            case 19: {
                this.setBoolean(21100, !this.getBoolean(21100));
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, 610897225);
                break;
            }
            case 20: {
                if (!this.getBoolean(17873)) {
                    this.setBoolean(2075656192, !this.getBoolean(2075656192));
                }
                if (!this.getBoolean(17873)) break;
                this.setBoolean(16559, !this.getBoolean(16559));
                break;
            }
            case 21: {
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setInteger(19672, 2);
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, 1549831497);
                break;
            }
            case 22: {
                this.setInteger(19672, 1);
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, 1549831497);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticMirrorlinkDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                return this.getBoolean(-1449721856);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticMirrorlinkDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticMirrorlinkDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticMirrorlinkDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                this.setBoolean(519897088, false);
                break;
            }
            case 4: {
                this.triggerObserver(1376387136);
                break;
            }
            case 8: {
                this.triggerObserver(2114650176);
                break;
            }
            case 9: {
                this.setInteger(483983360, MirrorlinkActivity.evListItemActionIndex());
                this.setInteger(-84934656, MirrorlinkActivity.evListItemActionIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticMirrorlinkDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                return !this.getLicValue(3419, 1, this.getInteger(-84934656), false) && this.getBoolean(-1426325504);
            }
            case 8: {
                return !this.getLicValue(3419, 3, this.getInteger(-84934656), false) && this.getBoolean(-1426325504);
            }
            case 9: {
                return this.getBoolean(-1443627008);
            }
            case 12: {
                return this.getListItemControl(3545, true).getItemCount() > 0 && !this.getBoolean(519897088);
            }
            case 13: {
                return this.getBoolean(-1449721856) && !this.getBoolean(519897088);
            }
            case 14: {
                return this.getBoolean(0x10C10000) && this.getBoolean(-1945894656) && !this.getBoolean(519897088);
            }
            case 15: {
                return this.getBoolean(-39911424);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticMirrorlinkDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                MirrorlinkActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -60519095);
                break;
            }
            case 8: {
                MirrorlinkActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 124095817);
                break;
            }
            case 9: {
                MirrorlinkActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -43741879);
                break;
            }
            case 10: {
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(483983360));
                this.triggerObserver(1460207680, eventGeneric);
                break;
            }
            case 11: {
                MirrorlinkActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                this.setInteger(16776, SkinDataPool.getInteger(190));
                break;
            }
            case 13: {
                if (this.getListItemControl(3545, true).getItemCount() == 0) {
                    this.setInteger(483983360, 0);
                }
                if (this.getListItemControl(3545, true).getItemCount() != 0) break;
                EventGeneric eventGeneric = MirrorlinkActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(483983360));
                this.triggerObserver(1460207680, eventGeneric);
                break;
            }
            case 14: {
                this.triggerObserver(2114650176);
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

    private void performStateEntryAction_SubIGenericDomainNotAvailableSwapBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.showView("Gdnas", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIGenericDomainNotAvailableSwapBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                this.hideView("Gdnas");
                break;
            }
        }
    }
}

