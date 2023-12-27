/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.homescreen.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class HomeScreenActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public HomeScreenActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 325: {
                this.performStateEntryAction_SubPopupPoHomescreenDisclaimerDynState(n, bl);
                break;
            }
            case 16: {
                this.performStateEntryAction_SubHapticHomescreenDynState(n, bl);
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
            default: {
                return;
            }
        }
    }

    @Override
    public void performStateExitAction(int n) {
        switch (this.subStatemachineId) {
            case 325: {
                this.performStateExitAction_SubPopupPoHomescreenDisclaimerDynState(n);
                break;
            }
            case 16: {
                this.performStateExitAction_SubHapticHomescreenDynState(n);
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
            case 16: {
                return this.evalInternalTransitionGuard_SubHapticHomescreenDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 325: {
                this.performInternalTransitionAction_SubPopupPoHomescreenDisclaimerDynState(n);
                break;
            }
            case 16: {
                this.performInternalTransitionAction_SubHapticHomescreenDynState(n);
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
            case 16: {
                this.performTriggeredTransitionAction_SubHapticHomescreenDynState(n);
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
            case 16: {
                return this.evalUntriggeredTransitionGuard_SubHapticHomescreenDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 16: {
                this.performUntriggeredTransitionAction_SubHapticHomescreenDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoHomescreenDisclaimerDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Phd", 325, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoHomescreenDisclaimerDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                HomeScreenActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Phd");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubPopupPoHomescreenDisclaimerDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoHomescreenDisclaimerDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoHomescreenDisclaimerDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1772057271);
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticHomescreenDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.setInteger(0x100A0100, 26);
                break;
            }
            case 9: {
                this.setInteger(1150418944, 15);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                this.setInteger(0x100A0100, 26);
                break;
            }
            case 12: {
                HomeScreenActivity.changeContext("HomeScreen");
                this.setInteger(10969, this.getInteger(730988544));
                this.setInteger(24703, 0);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(24703));
                this.triggerObserver(-1547417024, eventGeneric);
                this.setInteger(32569, 0);
                this.setInteger(-519372544, 26);
                eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-519372544));
                this.triggerObserver(1191510080, eventGeneric);
                this.showView("H_69BD", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticHomescreenDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 12: {
                EventGeneric eventGeneric;
                this.hideView("H_69BD");
                if (this.getInteger(10969) != this.getInteger(730988544)) {
                    this.setInteger(420675840, this.getInteger(10969));
                }
                if (this.getInteger(10969) != this.getInteger(730988544)) {
                    eventGeneric = HomeScreenActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(420675840));
                    this.triggerObserver(-1530639808, eventGeneric);
                }
                this.setInteger(24703, 2);
                eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(24703));
                this.triggerObserver(-1547417024, eventGeneric);
                this.triggerObserver(-1463530944);
                this.setInteger(14784, this.getInteger(1653932032));
                eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(14784));
                this.triggerObserver(-1480308160, eventGeneric);
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticHomescreenDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return this.getBoolean(1891106816);
            }
            case 2: {
                return !this.getBoolean(1891106816);
            }
            case 3: {
                return this.getBoolean(1891106816);
            }
            case 4: {
                return !this.getBoolean(1891106816);
            }
            case 5: {
                return this.getBoolean(1891106816);
            }
            case 6: {
                return !this.getBoolean(1891106816);
            }
            case 7: {
                return this.getBoolean(1891106816);
            }
            case 8: {
                return !this.getBoolean(1891106816);
            }
            case 9: {
                return this.getBoolean(1891106816);
            }
            case 10: {
                return !this.getBoolean(1891106816);
            }
            case 11: {
                return this.getBoolean(1891106816);
            }
            case 12: {
                return !this.getBoolean(1891106816);
            }
            case 13: {
                return this.getBoolean(1891106816);
            }
            case 14: {
                return !this.getBoolean(1891106816);
            }
            case 15: {
                return this.getBoolean(1891106816);
            }
            case 16: {
                return !this.getBoolean(1891106816);
            }
            case 17: {
                return this.getBoolean(1891106816);
            }
            case 20: {
                return HomeScreenActivity.evListItemEventSender().equals("ButtonHeadlineIcon") || HomeScreenActivity.evListItemEventSender().equals("ButtonHeadline");
            }
            case 21: {
                return HomeScreenActivity.evListItemEventSender().equals("ButtonHeadlineIcon") || HomeScreenActivity.evListItemEventSender().equals("ButtonHeadline");
            }
            case 22: {
                return HomeScreenActivity.evListItemEventSender().equals("ButtonHeadlineIcon") || HomeScreenActivity.evListItemEventSender().equals("ButtonHeadline");
            }
            case 23: {
                return HomeScreenActivity.evListItemEventSender().equals("ButtonHeadlineIcon") || HomeScreenActivity.evListItemEventSender().equals("ButtonHeadline");
            }
            case 24: {
                return HomeScreenActivity.evListItemEventSender().equals("ButtonHeadlineIcon") || HomeScreenActivity.evListItemEventSender().equals("ButtonHeadline");
            }
            case 25: {
                return this.getInteger(32569) == this.getInteger(-1709506304);
            }
            case 27: {
                return this.getInteger(-1709506304) != this.getInteger(32569);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticHomescreenDynState(int n) {
        this.performInternalTransitionAction_SubHapticHomescreenDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticHomescreenDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 2: {
                this.setInteger(1653932032, 1);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 3: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 4: {
                this.setInteger(1653932032, 1);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 5: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 6: {
                this.setInteger(1653932032, 2);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 7: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 8: {
                this.setInteger(1653932032, 2);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 9: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 10: {
                this.setInteger(1653932032, 3);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 11: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 12: {
                this.setInteger(1653932032, 3);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 13: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 14: {
                this.setInteger(1653932032, 4);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 15: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 16: {
                this.setInteger(1653932032, 4);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1918995785);
                break;
            }
            case 17: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -967209655);
                break;
            }
            case 18: {
                if (this.getInteger(169672960) == 1 && this.getInteger(10969) != 0) {
                    this.setInteger(10969, 0);
                }
                if (this.getInteger(169672960) != -1 || this.getInteger(10969) == 1) break;
                this.setInteger(10969, 1);
                break;
            }
            case 19: {
                this.setInteger(1653932032, 5);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1653932032));
                this.triggerObserver(-1580971456, eventGeneric);
                break;
            }
            case 20: {
                this.setInteger(-977207296, SkinDataPool.getInteger(181));
                this.setInteger(1368391680, 0);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 21: {
                if (this.getInteger(-1709506304) == 0) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(182));
                }
                if (this.getInteger(-1709506304) == 1) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(184));
                }
                this.setInteger(1368391680, 1);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 22: {
                if (this.getInteger(-1709506304) == 0) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(183));
                }
                if (this.getInteger(-1709506304) == 1) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(185));
                }
                this.setInteger(1368391680, 2);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 23: {
                this.setInteger(-977207296, SkinDataPool.getInteger(186));
                this.setInteger(1368391680, 3);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 24: {
                this.setInteger(-977207296, SkinDataPool.getInteger(187));
                this.setInteger(1368391680, 4);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 25: {
                if (this.getInteger(32569) == 0) {
                    this.setInteger(32569, 1);
                }
                if (this.getInteger(32569) == 1 && this.getInteger(32569) == this.getInteger(-1709506304)) {
                    this.setInteger(32569, 0);
                }
                this.setInteger(24703, this.getInteger(32569));
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(24703));
                this.triggerObserver(-1547417024, eventGeneric);
                break;
            }
            case 26: {
                if (this.getInteger(32569) == 0) {
                    this.setInteger(32569, 1);
                }
                if (this.getInteger(32569) != 1 || this.getInteger(32569) == this.getInteger(-1709506304)) break;
                this.setInteger(32569, 0);
                break;
            }
            case 27: {
                if (this.getInteger(-1709506304) == 1 && this.getInteger(32569) == 0) {
                    HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1768000841);
                }
                if (this.getInteger(-1709506304) != 0 || this.getInteger(32569) != 1) break;
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1784778057);
                break;
            }
            case 28: {
                if (HomeScreenActivity.evPointGestureParam1() < 0) {
                    this.setInteger(169672960, 1);
                }
                if (HomeScreenActivity.evPointGestureParam1() <= 0) break;
                this.setInteger(169672960, -1);
                break;
            }
            case 29: {
                this.setInteger(-977207296, SkinDataPool.getInteger(181));
                this.setInteger(1368391680, 0);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 30: {
                if (this.getInteger(-1709506304) == 0) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(182));
                }
                if (this.getInteger(-1709506304) == 1) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(184));
                }
                this.setInteger(1368391680, 1);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 31: {
                if (this.getInteger(-1709506304) == 0) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(183));
                }
                if (this.getInteger(-1709506304) == 1) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(185));
                }
                this.setInteger(1368391680, 2);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 32: {
                this.setInteger(-977207296, SkinDataPool.getInteger(186));
                this.setInteger(1368391680, 3);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 33: {
                this.setInteger(-977207296, SkinDataPool.getInteger(187));
                this.setInteger(1368391680, 4);
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1368391680));
                this.triggerObserver(-1564194240, eventGeneric);
                break;
            }
            case 34: {
                HomeScreenActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1801555273);
                break;
            }
            case 35: {
                this.setInteger(14784, this.getInteger(1653932032));
                EventGeneric eventGeneric = HomeScreenActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(14784));
                this.triggerObserver(-1480308160, eventGeneric);
                break;
            }
            case 36: {
                this.setInteger(-977207296, SkinDataPool.getInteger(188));
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticHomescreenDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticHomescreenDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticHomescreenDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.triggerObserver(-1597748672);
                break;
            }
            case 1: {
                if (this.getInteger(755106048) != 1) break;
                this.triggerObserver(-1597748672);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticHomescreenDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(755106048) == 2;
            }
            case 2: {
                return this.getInteger(755106048) == 0;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticHomescreenDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                if (this.getBoolean(311885824)) {
                    this.setInteger(-977207296, SkinDataPool.getInteger(188));
                }
                if (!this.getBoolean(311885824)) break;
                this.setBoolean(311885824, false);
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
}

