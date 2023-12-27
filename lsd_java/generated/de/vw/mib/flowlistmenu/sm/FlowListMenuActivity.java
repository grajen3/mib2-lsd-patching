/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.flowlistmenu.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class FlowListMenuActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public FlowListMenuActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 10: {
                this.performStateEntryAction_SubHapticFlowlistmenuDynState(n, bl);
                break;
            }
            case 654: {
                this.performStateEntryAction_SubIConnWizardMainBridge(n, bl);
                break;
            }
            case 655: {
                this.performStateEntryAction_SubIConnWlanSpeller(n, bl);
                break;
            }
            case 702: {
                this.performStateEntryAction_SubIWizardOnlineCarNetInternetbrowserSpeller(n, bl);
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
            case 10: {
                this.performStateExitAction_SubHapticFlowlistmenuDynState(n);
                break;
            }
            case 654: {
                this.performStateExitAction_SubIConnWizardMainBridge(n);
                break;
            }
            case 655: {
                this.performStateExitAction_SubIConnWlanSpeller(n);
                break;
            }
            case 702: {
                this.performStateExitAction_SubIWizardOnlineCarNetInternetbrowserSpeller(n);
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
            case 654: {
                return this.evalInternalTransitionGuard_SubIConnWizardMainBridge(n);
            }
            case 655: {
                return this.evalInternalTransitionGuard_SubIConnWlanSpeller(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 10: {
                this.performInternalTransitionAction_SubHapticFlowlistmenuDynState(n);
                break;
            }
            case 654: {
                this.performInternalTransitionAction_SubIConnWizardMainBridge(n);
                break;
            }
            case 655: {
                this.performInternalTransitionAction_SubIConnWlanSpeller(n);
                break;
            }
            case 702: {
                this.performInternalTransitionAction_SubIWizardOnlineCarNetInternetbrowserSpeller(n);
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
            case 10: {
                return this.evalTriggeredTransitionGuard_SubHapticFlowlistmenuDynState(n);
            }
            case 654: {
                return this.evalTriggeredTransitionGuard_SubIConnWizardMainBridge(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 10: {
                this.performTriggeredTransitionAction_SubHapticFlowlistmenuDynState(n);
                break;
            }
            case 654: {
                this.performTriggeredTransitionAction_SubIConnWizardMainBridge(n);
                break;
            }
            case 655: {
                this.performTriggeredTransitionAction_SubIConnWlanSpeller(n);
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
            case 10: {
                return this.evalUntriggeredTransitionGuard_SubHapticFlowlistmenuDynState(n);
            }
            case 654: {
                return this.evalUntriggeredTransitionGuard_SubIConnWizardMainBridge(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 654: {
                this.performUntriggeredTransitionAction_SubIConnWizardMainBridge(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubHapticFlowlistmenuDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                FlowListMenuActivity.changeContext("Menu");
                this.setInteger(0x820000, 40);
                this.setInteger(-1456996096, 1331727689);
                break;
            }
            case 12: {
                this.showView("Fav", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 13: {
                this.setInteger(-1483997184, 11);
                FlowListMenuActivity.changeContext("Menu");
                this.showView("Fd", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 14: {
                this.setInteger(-1483997184, 7);
                FlowListMenuActivity.changeContext("Menu");
                this.showView("Fds", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticFlowlistmenuDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.setInteger(0x820000, 0);
                break;
            }
            case 12: {
                this.hideView("Fav");
                break;
            }
            case 13: {
                this.hideView("Fd");
                break;
            }
            case 14: {
                this.hideView("Fds");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticFlowlistmenuDynState(int n) {
        this.performInternalTransitionAction_SubHapticFlowlistmenuDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticFlowlistmenuDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                break;
            }
            case 2: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1197509961);
                break;
            }
            case 3: {
                this.setInteger(2113732608, 1);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1197509961);
                break;
            }
            case 4: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1214287177);
                break;
            }
            case 5: {
                if (this.getBoolean(537067776)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1318613687);
                }
                if (this.getBoolean(537067776)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1046515017);
                break;
            }
            case 6: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1298173257);
                break;
            }
            case 7: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1382059337);
                break;
            }
            case 8: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 9: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1499499849);
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1533054281);
                break;
            }
            case 12: {
                this.setBoolean(840433920, false);
                this.setBoolean(15665, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 13: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 14: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1667272009);
                break;
            }
            case 15: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1314950473);
                break;
            }
            case 16: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1566608713);
                break;
            }
            case 17: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1616940361);
                break;
            }
            case 18: {
                break;
            }
            case 19: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1549831497);
                break;
            }
            case 20: {
                break;
            }
            case 21: {
                this.setInteger(1418985472, FlowListMenuActivity.evIntegerValueValue());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1418985472));
                this.triggerObserver(605504, eventGeneric);
                break;
            }
            case 22: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1264618825);
                break;
            }
            case 25: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticFlowlistmenuDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                return !this.getBoolean(537067776);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticFlowlistmenuDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticFlowlistmenuDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticFlowlistmenuDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -630813367);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticFlowlistmenuDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 2: {
                return this.getBoolean(690422016);
            }
            case 3: {
                return this.getBoolean(32205);
            }
            case 4: {
                return this.getBoolean(1989541888);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubIConnWizardMainBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                if (this.getBoolean(-184090368)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                }
                if (this.getBoolean(-184090368)) break;
                this.setBoolean(-184090368, true);
                break;
            }
            case 6: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 626691401);
                break;
            }
            case 7: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1319531191);
                break;
            }
            case 8: {
                if (!this.getBoolean(32339) && this.getInteger(18981) != 0 && !this.getBoolean(30264)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 442142025);
                }
                if (!this.getBoolean(32339) && this.getInteger(18981) != 0 && !this.getBoolean(30264)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -815952567);
                break;
            }
            case 26: {
                this.showView("Wccs_974F", bl, 167);
                break;
            }
            case 27: {
                this.showView("Wcscm", bl, 167);
                break;
            }
            case 28: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 31: {
                this.setInteger(15429, 4);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Wcns", bl, 167);
                break;
            }
            case 32: {
                this.setInteger(15429, 3);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Wcns", bl, 167);
                break;
            }
            case 33: {
                this.setInteger(15429, 0);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Wcns", bl, 167);
                break;
            }
            case 34: {
                this.setInteger(15429, 2);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Wcns", bl, 167);
                break;
            }
            case 35: {
                this.showView("Wcsi", bl, 167);
                break;
            }
            case 41: {
                this.showView("Wccs_259D", bl, 167);
                break;
            }
            case 42: {
                this.showView("Wcsep", bl, 167);
                break;
            }
            case 43: {
                this.showView("Wcid", bl, 167);
                break;
            }
            case 45: {
                this.showView("Wcwhl", bl, 167);
                break;
            }
            case 46: {
                this.enterIncludeDdpGroup(167);
                break;
            }
            case 47: {
                this.showView("Wcw", bl, 167);
                break;
            }
            case 48: {
                this.showView("Wcc", bl, 167);
                break;
            }
            case 49: {
                this.showView("Wcnw", bl, 167);
                break;
            }
            case 50: {
                if (!this.getBoolean(32339) || this.getBoolean(1759969280) || this.getBoolean(19680)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                break;
            }
            case 51: {
                if (!this.getBoolean(605880576)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -161051319);
                break;
            }
            case 56: {
                this.setInteger(-1478492160, 3);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1478492160));
                this.triggerObserver(1460470592, eventGeneric);
                this.triggerObserver(1561002048);
                break;
            }
            case 58: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.setBoolean(1225720064, false);
                this.showView("Wcnsa", bl, 167);
                break;
            }
            case 60: {
                this.enterWaitaphoreForProperty(-1416364032, 336, 441, 1500089673, 1483312457);
                break;
            }
            case 63: {
                this.setBoolean(-308543488, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-308543488));
                this.triggerObserver(-836302528, eventGeneric);
                this.setBoolean(30452, true);
                eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(337838336));
                eventGeneric.setBoolean(1, this.getBoolean(30452));
                this.triggerObserver(973668416, eventGeneric);
                break;
            }
            case 65: {
                this.enterIncludeDdpGroup(167);
                break;
            }
            case 66: {
                this.enterIncludeDdpGroup(167);
                break;
            }
            case 67: {
                this.showView("Wocnip", bl, 167);
                break;
            }
            case 68: {
                this.showView("Wocnipwf", bl, 167);
                break;
            }
            case 69: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945524041);
                break;
            }
            case 72: {
                this.showView("Wocnaa", bl, 167);
                break;
            }
            case 73: {
                this.showView("Wocnp", bl, 167);
                break;
            }
            case 74: {
                this.showView("Wocnpoa", bl, 167);
                break;
            }
            case 75: {
                this.showView("Wocnui", bl, 167);
                break;
            }
            case 76: {
                this.showView("Wof", bl, 167);
                break;
            }
            case 77: {
                this.showView("Wosll", bl, 167);
                break;
            }
            case 78: {
                this.showView("Wos", bl, 167);
                break;
            }
            case 79: {
                this.showView("Wos", bl, 167);
                break;
            }
        }
    }

    private void performStateExitAction_SubIConnWizardMainBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.setBoolean(184287232, false);
                this.setBoolean(-644415488, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-644415488));
                this.triggerObserver(1443693376, eventGeneric);
                this.setBoolean(32339, false);
                this.setBoolean(605880576, false);
                this.setInteger(1201799168, 0);
                this.setInteger(32117, 0);
                break;
            }
            case 26: {
                this.hideView("Wccs_974F");
                this.setInteger(1896677632, 5);
                break;
            }
            case 27: {
                this.hideView("Wcscm");
                this.setInteger(1896677632, 3);
                break;
            }
            case 28: {
                this.setBoolean(1225720064, false);
                this.triggerObserver(1040842816);
                this.setInteger(-1478492160, 0);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1478492160));
                this.triggerObserver(1460470592, eventGeneric);
                break;
            }
            case 31: {
                this.hideView("Wcns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 32: {
                this.hideView("Wcns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 33: {
                this.hideView("Wcns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 34: {
                this.hideView("Wcns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 35: {
                this.hideView("Wcsi");
                break;
            }
            case 41: {
                this.hideView("Wccs_259D");
                this.setInteger(1896677632, 6);
                break;
            }
            case 42: {
                this.hideView("Wcsep");
                this.setInteger(1896677632, 2);
                break;
            }
            case 43: {
                this.hideView("Wcid");
                if (!this.getBoolean(-1781858304)) {
                    this.triggerObserver(1544159296);
                }
                this.setBoolean(-1781858304, false);
                break;
            }
            case 45: {
                this.hideView("Wcwhl");
                break;
            }
            case 46: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 47: {
                this.hideView("Wcw");
                break;
            }
            case 48: {
                this.hideView("Wcc");
                this.setInteger(1896677632, 1);
                break;
            }
            case 49: {
                this.hideView("Wcnw");
                break;
            }
            case 56: {
                this.setInteger(25273, 0);
                break;
            }
            case 58: {
                this.hideView("Wcnsa");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.setBoolean(1225720064, false);
                break;
            }
            case 60: {
                this.leaveWaitaphore();
                break;
            }
            case 63: {
                this.setBoolean(30452, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(337838336));
                eventGeneric.setBoolean(1, this.getBoolean(30452));
                this.triggerObserver(973668416, eventGeneric);
                break;
            }
            case 65: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 66: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 67: {
                this.hideView("Wocnip");
                break;
            }
            case 68: {
                this.hideView("Wocnipwf");
                break;
            }
            case 69: {
                this.setInteger(25273, 0);
                break;
            }
            case 71: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1184854711);
                break;
            }
            case 72: {
                this.hideView("Wocnaa");
                break;
            }
            case 73: {
                this.hideView("Wocnp");
                break;
            }
            case 74: {
                this.hideView("Wocnpoa");
                break;
            }
            case 75: {
                this.hideView("Wocnui");
                break;
            }
            case 76: {
                this.hideView("Wof");
                this.setBoolean(1491599360, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1491599360));
                this.triggerObserver(1426916160, eventGeneric);
                this.setBoolean(184287232, false);
                this.setBoolean(-644415488, false);
                eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-644415488));
                this.triggerObserver(1443693376, eventGeneric);
                break;
            }
            case 77: {
                this.hideView("Wosll");
                break;
            }
            case 78: {
                this.hideView("Wos");
                this.setBoolean(1491599360, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1491599360));
                this.triggerObserver(1426916160, eventGeneric);
                this.setBoolean(184287232, false);
                this.setBoolean(-644415488, false);
                eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-644415488));
                this.triggerObserver(1443693376, eventGeneric);
                this.triggerObserver(1645019968);
                break;
            }
            case 79: {
                this.hideView("Wos");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIConnWizardMainBridge(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(32339);
            }
            case 1: {
                return this.getInteger(18981) == 0;
            }
            case 2: {
                return this.getBoolean(32339);
            }
            case 3: {
                return !this.getBoolean(32339);
            }
            case 4: {
                return this.getBoolean(32339);
            }
            case 5: {
                return !this.getBoolean(32339);
            }
            case 7: {
                return this.getBoolean(1745027328);
            }
            case 18: {
                return this.getBoolean(32339) && !this.getBoolean(1759969280) && !this.getBoolean(19680);
            }
            case 22: {
                return this.getLicValue(1899234048, 3, this.getInteger(-1396703232), 0) != 0 && (!this.getBoolean(-695599104) || this.getLicValue(1899234048, 3, this.getInteger(-1396703232), 0) != 1);
            }
            case 25: {
                return this.getBoolean(32339) && !this.getBoolean(1759969280) && !this.getBoolean(19680);
            }
            case 26: {
                return !this.getBoolean(25376);
            }
            case 27: {
                return this.getBoolean(32339);
            }
            case 45: {
                return this.getLicValue(3344, 1, 0, 0) == 4 && !this.getBoolean(-1779892224);
            }
            case 46: {
                return this.getBoolean(32339);
            }
            case 57: {
                return this.getLicValue(3344, 1, 0, 0) == 4 && !this.getBoolean(-1779892224);
            }
            case 58: {
                return this.getBoolean(32339);
            }
            case 59: {
                return this.getBoolean(32339) && this.getInteger(25273) == 1;
            }
            case 60: {
                return this.getBoolean(32339);
            }
            case 61: {
                return this.getInteger(1201799168) != 0;
            }
            case 62: {
                return !this.getBoolean(32339) && this.getInteger(32117) != 0;
            }
            case 63: {
                return this.getInteger(11190) == 0;
            }
            case 64: {
                return this.getInteger(11190) == 1;
            }
            case 74: {
                return this.getBoolean(0x30EE0000);
            }
            case 79: {
                return this.getBoolean(32339);
            }
            case 82: {
                return !this.getBoolean(32339) && this.getInteger(32117) == 2;
            }
            case 83: {
                return this.getInteger(32117) == 3 && !this.getBoolean(32339);
            }
            case 84: {
                return !this.getBoolean(32339) && this.getInteger(32117) == 1;
            }
            case 85: {
                return this.getBoolean(32339);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIConnWizardMainBridge(int n) {
        this.performInternalTransitionAction_SubIConnWizardMainBridge00(n);
    }

    private void performInternalTransitionAction_SubIConnWizardMainBridge00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 1: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 2: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 3: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 4: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 5: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 7: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 425364809);
                break;
            }
            case 8: {
                this.setBoolean(786497536, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(786497536));
                this.triggerObserver(1510802240, eventGeneric);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201894071);
                break;
            }
            case 9: {
                this.setBoolean(786497536, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(786497536));
                this.triggerObserver(1510802240, eventGeneric);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201894071);
                break;
            }
            case 10: {
                this.triggerObserver(453050432);
                break;
            }
            case 11: {
                this.setString(1222049792, FlowListMenuActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setString(0, this.getString(1222049792));
                this.triggerObserver(469827648, eventGeneric);
                break;
            }
            case 12: {
                this.setBoolean(1225720064, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 13: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 14: {
                this.setInteger(32605, FlowListMenuActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32605));
                this.triggerObserver(-670433216, eventGeneric);
                break;
            }
            case 15: {
                this.setInteger(15429, 1);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
            case 16: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
            case 17: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
            case 18: {
                this.triggerObserver(83951680);
                this.setBoolean(-1222311680, true);
                this.setBoolean(17308, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                this.setBoolean(-1781858304, true);
                break;
            }
            case 19: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1080069449);
                this.triggerObserver(83951680);
                this.setBoolean(-1222311680, true);
                this.setBoolean(17308, true);
                this.setBoolean(-1781858304, true);
                break;
            }
            case 20: {
                this.triggerObserver(1544159296);
                this.setBoolean(-1781858304, true);
                break;
            }
            case 21: {
                this.setInteger(-1396703232, FlowListMenuActivity.evListItemActionIndex());
                break;
            }
            case 22: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -816214711);
                break;
            }
            case 23: {
                this.setInteger(1963393280, FlowListMenuActivity.evListItemActionIndex());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1963393280));
                this.triggerObserver(1477247808, eventGeneric);
                break;
            }
            case 24: {
                this.triggerObserver(235601984);
                break;
            }
            case 25: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                break;
            }
            case 26: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -732328631);
                break;
            }
            case 27: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 29: {
                this.triggerObserver(1326121024);
                break;
            }
            case 30: {
                this.setString(-1160380416, FlowListMenuActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1160380416));
                this.triggerObserver(1359675456, eventGeneric);
                break;
            }
            case 31: {
                this.setBoolean(1225720064, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 32: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 33: {
                this.setInteger(19318, FlowListMenuActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(19318));
                this.triggerObserver(1376452672, eventGeneric);
                break;
            }
            case 34: {
                this.triggerObserver(1342898240);
                break;
            }
            case 35: {
                this.setInteger(2129723392, 0);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 36: {
                this.setInteger(2129723392, 1);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 37: {
                this.setInteger(2129723392, 2);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 38: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-199753472, 0);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 39: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(29408, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(29405, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-199753472, 3);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 40: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(29408, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(29405, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-199753472, 3);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 41: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-292356096, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-1680015360, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(-199753472, 4);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 42: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-199753472, 1);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 43: {
                this.setInteger(317063168, FlowListMenuActivity.evIntegerValueValue());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(317063168));
                this.triggerObserver(-886634176, eventGeneric);
                break;
            }
            case 44: {
                this.setInteger(-907870208, FlowListMenuActivity.evIntegerValueValue());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-907870208));
                this.triggerObserver(-903411392, eventGeneric);
                break;
            }
            case 45: {
                this.setBoolean(-1779892224, true);
                break;
            }
            case 46: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 47: {
                this.setInteger(2129723392, 0);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 48: {
                this.setInteger(2129723392, 1);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 49: {
                this.setInteger(2129723392, 2);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2129723392));
                this.triggerObserver(1057554496, eventGeneric);
                break;
            }
            case 50: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-199753472, 0);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 51: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(29408, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(29405, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-199753472, 3);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 52: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(29408, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(29405, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-199753472, 3);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 53: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-292356096, FlowListMenuActivity.evPointGestureParam2());
                this.setInteger(-1680015360, FlowListMenuActivity.evPointGestureParam1());
                this.setInteger(-199753472, 4);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 54: {
                this.setInteger(1623261184, FlowListMenuActivity.evPointX());
                this.setInteger(1556152320, FlowListMenuActivity.evPointY());
                this.setInteger(-199753472, 1);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1623261184));
                eventGeneric.setInt(1, this.getInteger(1556152320));
                eventGeneric.setInt(2, this.getInteger(29408));
                eventGeneric.setInt(3, this.getInteger(29405));
                eventGeneric.setInt(4, this.getInteger(-292356096));
                eventGeneric.setInt(5, this.getInteger(-1680015360));
                eventGeneric.setInt(6, this.getInteger(-199753472));
                this.triggerObserver(1040777280, eventGeneric);
                break;
            }
            case 55: {
                this.setInteger(317063168, FlowListMenuActivity.evIntegerValueValue());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(317063168));
                this.triggerObserver(-886634176, eventGeneric);
                break;
            }
            case 56: {
                this.setInteger(-907870208, FlowListMenuActivity.evIntegerValueValue());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-907870208));
                this.triggerObserver(-903411392, eventGeneric);
                break;
            }
            case 57: {
                this.setBoolean(-1779892224, true);
                break;
            }
            case 58: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 59: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1281396041);
                break;
            }
            case 60: {
                this.triggerObserver(1628242752);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929074505);
                break;
            }
            case 61: {
                this.setInteger(32117, 0);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 62: {
                this.setInteger(1185677312, 3);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1449168201);
                break;
            }
            case 63: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 929664329);
                break;
            }
            case 64: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 778669385);
                break;
            }
            case 65: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1134195383);
                break;
            }
            case 66: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 67: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 68: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 69: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 70: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 71: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 72: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 73: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 912887113);
                break;
            }
            case 74: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1217950391);
                this.setBoolean(0x30EE0000, false);
                break;
            }
            case 75: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 777686345);
                break;
            }
            case 76: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 794463561);
                break;
            }
            case 77: {
                if (this.getInteger(1201799168) == 1 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -362771127);
                }
                if (this.getInteger(1201799168) == 4 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -345993911);
                }
                if (this.getInteger(-1833435136) == 1) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -329216695);
                }
                if (this.getInteger(1201799168) == 3 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -312439479);
                }
                if (this.getInteger(1201799168) == 9 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -295662263);
                }
                if (this.getInteger(1201799168) == 10 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -278885047);
                }
                if (this.getInteger(1201799168) == 15 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -262107831);
                }
                if (this.getInteger(1201799168) == 14 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -245330615);
                }
                if (this.getInteger(1201799168) == 13 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -228553399);
                }
                if (this.getInteger(1201799168) == 98 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -396325559);
                }
                if (this.getInteger(1201799168) == 2 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -379548343);
                }
                if (this.getInteger(1201799168) == 16 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -211776183);
                }
                if (this.getInteger(1201799168) == 19 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -194998967);
                }
                if (this.getInteger(1201799168) == 97 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -161444535);
                }
                if (this.getInteger(1201799168) == 8 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -178221751);
                }
                if (this.getInteger(1201799168) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                }
                this.setInteger(1201799168, 0);
                break;
            }
            case 78: {
                this.setInteger(1185677312, 4);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1449168201);
                break;
            }
            case 79: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                break;
            }
            case 80: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                this.setBoolean(30264, true);
                break;
            }
            case 81: {
                if (this.getInteger(1201799168) == 1 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -362771127);
                }
                if (this.getInteger(1201799168) == 4 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -345993911);
                }
                if (this.getInteger(-1833435136) == 1) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -329216695);
                }
                if (this.getInteger(1201799168) == 3 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -312439479);
                }
                if (this.getInteger(1201799168) == 9 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -295662263);
                }
                if (this.getInteger(1201799168) == 10 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -278885047);
                }
                if (this.getInteger(1201799168) == 15 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -262107831);
                }
                if (this.getInteger(1201799168) == 14 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -245330615);
                }
                if (this.getInteger(1201799168) == 13 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -228553399);
                }
                if (this.getInteger(1201799168) == 98 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -396325559);
                }
                if (this.getInteger(1201799168) == 2 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -379548343);
                }
                if (this.getInteger(1201799168) == 16 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -211776183);
                }
                if (this.getInteger(1201799168) == 19 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -194998967);
                }
                if (this.getInteger(1201799168) == 97 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -161444535);
                }
                if (this.getInteger(1201799168) == 8 && this.getInteger(-1833435136) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -178221751);
                }
                if (this.getInteger(1201799168) == 0) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                }
                this.setInteger(1201799168, 0);
                break;
            }
            case 82: {
                this.setInteger(1201799168, 0);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1217950391);
                break;
            }
            case 83: {
                this.setInteger(32117, 0);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1281396041);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1392317184);
                break;
            }
            case 84: {
                this.setInteger(1201799168, 0);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1217950391);
                break;
            }
            case 85: {
                this.setBoolean(1491599360, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1491599360));
                this.triggerObserver(1426916160, eventGeneric);
                this.setBoolean(184287232, false);
                this.setBoolean(-644415488, false);
                eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-644415488));
                this.triggerObserver(1443693376, eventGeneric);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubIConnWizardMainBridge(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                return this.getInteger(-1197146112) == 0 && this.getBoolean(30686);
            }
            case 16: {
                return this.getInteger(-1197146112) == 1 || this.getInteger(-1197146112) == 2;
            }
            case 27: {
                return (this.getInteger(-1197146112) == 0 || this.getInteger(10348) == 1 || this.getInteger(-584777472) == 1) && this.getBoolean(30686);
            }
            case 38: {
                return this.getLicValue(3344, 4, 0, 0) == 3;
            }
            case 41: {
                return this.getLicValue(3344, 4, 0, 0) == 2;
            }
            case 51: {
                return !this.getBoolean(0x30EE0000);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubIConnWizardMainBridge(int n) {
        this.performTriggeredTransitionAction_SubIConnWizardMainBridge00(n);
    }

    private void performTriggeredTransitionAction_SubIConnWizardMainBridge00(int n) {
        switch (n - this.TT_OFFSET) {
            case 2: {
                this.setBoolean(184287232, true);
                this.setBoolean(-644415488, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-644415488));
                this.triggerObserver(1443693376, eventGeneric);
                this.setInteger(1201799168, this.getInteger(18981));
                this.setBoolean(30264, false);
                break;
            }
            case 3: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 4: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 5: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 7: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 8: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 9: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 10: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 11: {
                this.triggerObserver(1208812352);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 12: {
                this.triggerObserver(1192035136);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 13: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 14: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setInteger(-1478492160, 1);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1478492160));
                this.triggerObserver(1460470592, eventGeneric);
                break;
            }
            case 17: {
                this.setInteger(28826, 8);
                this.setInteger(28985, 63);
                this.setInteger(1404633088, 3);
                this.triggerObserver(688586816);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 18: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 19: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 20: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 21: {
                this.triggerObserver(235601984);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 22: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 23: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 24: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 25: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 28: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                this.setInteger(25273, 1);
                break;
            }
            case 29: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 32: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945524041);
                break;
            }
            case 34: {
                this.triggerObserver(-987297472);
                break;
            }
            case 35: {
                this.triggerObserver(-1004074688);
                break;
            }
            case 36: {
                this.triggerObserver(-987297472);
                break;
            }
            case 37: {
                this.triggerObserver(-1004074688);
                break;
            }
            case 47: {
                this.setInteger(337838336, 4);
                break;
            }
            case 51: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setInteger(25273, 1);
                break;
            }
            case 52: {
                this.setInteger(25273, 2);
                break;
            }
            case 53: {
                this.setInteger(337838336, 3);
                break;
            }
            case 54: {
                this.setInteger(25273, 1);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubIConnWizardMainBridge(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(0x1040100) != 1 && !this.getBoolean(1770520576) && this.getInteger(32117) != 2;
            }
            case 2: {
                return (this.getBoolean(-234422016) || this.getInteger(-471465984) == 2 && this.getBoolean(-1695154176)) && this.getBoolean(-124059648) && !this.getBoolean(24645) && this.getInteger(32117) != 2;
            }
            case 3: {
                return this.getInteger(32117) != 0;
            }
            case 5: {
                return this.getBoolean(-234422016) || this.getInteger(-471465984) == 2 && this.getBoolean(-1695154176) || this.getBoolean(1770520576) && !this.getBoolean(19680);
            }
            case 8: {
                return this.getInteger(-584777472) == 0 && this.getInteger(10348) == 0;
            }
            case 10: {
                return this.getInteger(-584777472) == 0 && this.getInteger(10348) == 0;
            }
            case 12: {
                return !this.getBoolean(30686) && this.getBoolean(1402273792);
            }
            case 13: {
                return !this.getBoolean(1402273792);
            }
            case 16: {
                return this.getInteger(1896677632) == 3;
            }
            case 17: {
                return this.getInteger(1896677632) == 2;
            }
            case 18: {
                return this.getInteger(1896677632) == 5;
            }
            case 20: {
                return this.getInteger(10348) == 2;
            }
            case 22: {
                return this.getBoolean(30686);
            }
            case 27: {
                return !this.getBoolean(20928) && this.getBoolean(938409984);
            }
            case 29: {
                return this.getInteger(10348) == 0;
            }
            case 30: {
                return !this.getBoolean(20928) && this.getBoolean(938409984);
            }
            case 32: {
                return this.getInteger(10348) == 0;
            }
            case 35: {
                return this.getInteger(26701) == 3;
            }
            case 36: {
                return this.getInteger(26701) == 4;
            }
            case 39: {
                return this.getInteger(-584777472) == 0;
            }
            case 40: {
                return this.getInteger(-584777472) == 2;
            }
            case 42: {
                return this.getInteger(-584777472) == 0;
            }
            case 44: {
                return this.getInteger(-584777472) == 1;
            }
            case 49: {
                return this.getInteger(18981) == 0 && !this.getBoolean(32339) && (this.getBoolean(-1778581504) || this.getInteger(20401) == 1 || this.getInteger(20401) == 0);
            }
            case 50: {
                return (this.getBoolean(-1778581504) || this.getInteger(20401) == 1) && this.getInteger(18981) != 0;
            }
            case 51: {
                return !this.getBoolean(-124059648) && this.getBoolean(32339) && (this.getInteger(20401) == 0 || this.getInteger(20401) == 1);
            }
            case 52: {
                return !this.getBoolean(-124059648) && this.getInteger(20401) == 2 && this.getInteger(32117) != 0;
            }
            case 53: {
                return !this.getBoolean(-124059648) && this.getInteger(20401) == 2 && this.getInteger(32117) == 0;
            }
            case 54: {
                return !this.getBoolean(-124059648) && this.getInteger(20401) == 1 && this.getInteger(1201799168) == 0;
            }
            case 55: {
                return this.getBoolean(-124059648);
            }
            case 57: {
                return this.getInteger(1201799168) == 0;
            }
            case 58: {
                return this.getBoolean(19680) && this.getInteger(-1416364032) == 3 && this.getInteger(1201799168) != 0;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubIConnWizardMainBridge(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                this.setBoolean(-184090368, false);
                break;
            }
            case 4: {
                this.setBoolean(24645, false);
                break;
            }
            case 8: {
                if (this.getBoolean(-1695154176)) break;
                this.triggerObserver(520159296);
                break;
            }
            case 10: {
                if (this.getBoolean(-1695154176)) break;
                this.triggerObserver(520159296);
                break;
            }
            case 12: {
                if (this.getBoolean(-1695154176)) break;
                this.triggerObserver(520159296);
                break;
            }
            case 13: {
                this.setInteger(1896677632, 0);
                break;
            }
            case 17: {
                this.setInteger(1896677632, 0);
                break;
            }
            case 18: {
                this.setInteger(1896677632, 0);
                break;
            }
            case 19: {
                this.setInteger(1896677632, 0);
                break;
            }
            case 21: {
                if (this.getBoolean(1926299648)) {
                    this.setInteger(-1478492160, 2);
                }
                if (!this.getBoolean(1926299648)) {
                    this.setInteger(-1478492160, 1);
                }
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1478492160));
                this.triggerObserver(1460470592, eventGeneric);
                break;
            }
            case 24: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 32: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 35: {
                this.triggerObserver(1275789376);
                break;
            }
            case 36: {
                this.triggerObserver(1275789376);
                break;
            }
            case 42: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 47: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 50: {
                if (this.getBoolean(32339)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                }
                if (!this.getBoolean(32339)) {
                    this.setInteger(1051197440, this.getInteger(1201799168));
                }
                if (!this.getBoolean(32339)) {
                    EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(1051197440));
                    this.triggerObserver(1054217024, eventGeneric);
                }
                if (this.getBoolean(32339)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1197116745);
                break;
            }
            case 51: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                break;
            }
            case 53: {
                this.setInteger(26351, 44);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(26351));
                this.triggerObserver(1523979072, eventGeneric);
                break;
            }
            case 59: {
                if (this.getBoolean(32339)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                }
                if (!this.getBoolean(32339)) {
                    this.setInteger(1051197440, this.getInteger(1201799168));
                }
                if (!this.getBoolean(32339)) {
                    EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(1051197440));
                    this.triggerObserver(1054217024, eventGeneric);
                }
                if (this.getBoolean(32339)) break;
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1197116745);
                break;
            }
            case 62: {
                if (this.getBoolean(32339)) {
                    FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 945851721);
                }
                if (!this.getBoolean(32339)) {
                    this.setInteger(1051197440, this.getInteger(18981));
                }
                if (this.getBoolean(32339)) break;
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1051197440));
                this.triggerObserver(1054217024, eventGeneric);
                break;
            }
            case 63: {
                FlowListMenuActivity.lockWaitaphore(-1416364032, 10000);
                this.triggerObserver(1792414528);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIConnWlanSpeller(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.setBoolean(1225720064, false);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cws", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIConnWlanSpeller(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.hideView("Cws");
                this.setBoolean(1225720064, false);
                this.setInteger(28985, 100);
                this.setInteger(28826, 1);
                this.triggerObserver(-1224081344);
                this.setInteger(1404633088, 0);
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIConnWlanSpeller(int n) {
        switch (n - this.IT_OFFSET) {
            case 5: {
                return this.getInteger(1404633088) == 1;
            }
            case 6: {
                return this.getInteger(1404633088) == 2;
            }
            case 7: {
                return this.getInteger(1404633088) == 3;
            }
            case 8: {
                return this.getInteger(1404633088) == 5;
            }
            case 9: {
                return this.getInteger(1404633088) == 4;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIConnWlanSpeller(int n) {
        this.performInternalTransitionAction_SubIConnWlanSpeller0(n);
    }

    private void performInternalTransitionAction_SubIConnWlanSpeller0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-1190526912);
                break;
            }
            case 1: {
                this.setString(21124, FlowListMenuActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setString(0, this.getString(21124));
                this.triggerObserver(-1173749696, eventGeneric);
                break;
            }
            case 2: {
                this.setBoolean(1225720064, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 3: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 4: {
                this.setInteger(531955712, FlowListMenuActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(531955712));
                this.triggerObserver(-703987648, eventGeneric);
                break;
            }
            case 5: {
                this.triggerObserver(722141248);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1180732745);
                break;
            }
            case 6: {
                this.triggerObserver(705364032);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1180732745);
                break;
            }
            case 7: {
                this.triggerObserver(772472896);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1180732745);
                break;
            }
            case 8: {
                this.triggerObserver(738918464);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1180732745);
                break;
            }
            case 9: {
                this.triggerObserver(755695680);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, 1180732745);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubIConnWlanSpeller(int n) {
        this.performTriggeredTransitionAction_SubIConnWlanSpeller0(n);
    }

    private void performTriggeredTransitionAction_SubIConnWlanSpeller0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 1: {
                this.triggerObserver(-1207304128);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIWizardOnlineCarNetInternetbrowserSpeller(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.setBoolean(1225720064, false);
                this.showView("Wocnis", bl, 167);
                break;
            }
        }
    }

    private void performStateExitAction_SubIWizardOnlineCarNetInternetbrowserSpeller(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.hideView("Wocnis");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubIWizardOnlineCarNetInternetbrowserSpeller(int n) {
        this.performInternalTransitionAction_SubIWizardOnlineCarNetInternetbrowserSpeller0(n);
    }

    private void performInternalTransitionAction_SubIWizardOnlineCarNetInternetbrowserSpeller0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-1020851904);
                break;
            }
            case 1: {
                this.setString(19436, FlowListMenuActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setString(0, this.getString(19436));
                this.triggerObserver(-1037629120, eventGeneric);
                break;
            }
            case 2: {
                this.setInteger(-258080768, FlowListMenuActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = FlowListMenuActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-258080768));
                this.triggerObserver(-970520256, eventGeneric);
                break;
            }
            case 3: {
                this.setBoolean(1225720064, true);
                FlowListMenuActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 4: {
                this.setBoolean(1225720064, false);
                break;
            }
        }
    }
}

