/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.connectivitynetworking.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class ConnectivityNetworkingActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public ConnectivityNetworkingActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 28: {
                this.performStateEntryAction_SubHapticNetworkingDynState(n, bl);
                break;
            }
            case 635: {
                this.performStateEntryAction_SubCNetworkingEnterPinPuk(n, bl);
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
            case 28: {
                this.performStateExitAction_SubHapticNetworkingDynState(n);
                break;
            }
            case 635: {
                this.performStateExitAction_SubCNetworkingEnterPinPuk(n);
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
            case 28: {
                return this.evalInternalTransitionGuard_SubHapticNetworkingDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 28: {
                this.performInternalTransitionAction_SubHapticNetworkingDynState(n);
                break;
            }
            case 635: {
                this.performInternalTransitionAction_SubCNetworkingEnterPinPuk(n);
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
            case 28: {
                this.performTriggeredTransitionAction_SubHapticNetworkingDynState(n);
                break;
            }
            case 635: {
                this.performTriggeredTransitionAction_SubCNetworkingEnterPinPuk(n);
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
            case 28: {
                return this.evalUntriggeredTransitionGuard_SubHapticNetworkingDynState(n);
            }
            case 635: {
                return this.evalUntriggeredTransitionGuard_SubCNetworkingEnterPinPuk(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 28: {
                this.performUntriggeredTransitionAction_SubHapticNetworkingDynState(n);
                break;
            }
            case 635: {
                this.performUntriggeredTransitionAction_SubCNetworkingEnterPinPuk(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubHapticNetworkingDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(19157, 2);
                this.setBoolean(-1919614976, false);
                this.setBoolean(17308, false);
                this.setBoolean(-1222311680, false);
                break;
            }
            case 8: {
                this.setInteger(19157, 3);
                this.setInteger(-654508032, SkinDataPool.getInteger(190));
                break;
            }
            case 14: {
                this.showView("Cnscl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 24: {
                this.showView("Cnsec", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 25: {
                this.setBoolean(1225720064, false);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cns", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 26: {
                this.showView("Cnd", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 29: {
                this.showView("Cnspl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 30: {
                this.showView("Cnsm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 31: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1336308407);
                break;
            }
            case 35: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 36: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1281461577);
                break;
            }
            case 37: {
                this.setInteger(19157, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticNetworkingDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(19157, 0);
                break;
            }
            case 8: {
                this.setInteger(-654508032, SkinDataPool.getInteger(180));
                break;
            }
            case 12: {
                this.setInteger(1021706240, 0);
                break;
            }
            case 14: {
                this.hideView("Cnscl");
                break;
            }
            case 21: {
                this.triggerObserver(1242366784);
                break;
            }
            case 24: {
                this.hideView("Cnsec");
                break;
            }
            case 25: {
                this.hideView("Cns");
                this.setBoolean(1225720064, false);
                this.triggerObserver(1040842816);
                this.setInteger(28985, 100);
                this.setInteger(28826, 1);
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 26: {
                this.hideView("Cnd");
                break;
            }
            case 27: {
                this.triggerObserver(1494025024);
                break;
            }
            case 29: {
                this.hideView("Cnspl");
                break;
            }
            case 30: {
                this.hideView("Cnsm");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticNetworkingDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return !this.getBoolean(1486422016);
            }
            case 4: {
                return ConnectivityNetworkingActivity.evListItemEventSender().equals("ButtonSelect");
            }
            case 5: {
                return this.getBoolean(10884);
            }
            case 6: {
                return !this.getBoolean(10884);
            }
            case 26: {
                return this.getInteger(1021706240) == 101;
            }
            case 27: {
                return this.getInteger(1021706240) == 35;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticNetworkingDynState(int n) {
        this.performInternalTransitionAction_SubHapticNetworkingDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticNetworkingDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setBoolean(-1222311680, false);
                this.setBoolean(17308, false);
                this.setBoolean(1020657664, this.getBoolean(17308));
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1020657664));
                this.triggerObserver(1074594624, eventGeneric);
                break;
            }
            case 1: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1533054281);
                break;
            }
            case 2: {
                this.setInteger(-654508032, SkinDataPool.getInteger(190));
                break;
            }
            case 3: {
                this.setInteger(-654508032, SkinDataPool.getInteger(180));
                break;
            }
            case 4: {
                this.setInteger(1793064960, ConnectivityNetworkingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1793064960));
                this.triggerObserver(352387136, eventGeneric);
                break;
            }
            case 5: {
                this.triggerObserver(251723840);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1046121801);
                break;
            }
            case 6: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1062899017);
                break;
            }
            case 7: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 693800265);
                break;
            }
            case 8: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -832139959);
                break;
            }
            case 9: {
                this.triggerObserver(940179520);
                break;
            }
            case 10: {
                this.setInteger(-2036727808, ConnectivityNetworkingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-2036727808));
                this.triggerObserver(554303552, eventGeneric);
                break;
            }
            case 11: {
                this.triggerObserver(453050432);
                break;
            }
            case 12: {
                this.setString(1222049792, ConnectivityNetworkingActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setString(0, this.getString(1222049792));
                this.triggerObserver(469827648, eventGeneric);
                break;
            }
            case 13: {
                this.triggerObserver(302055488);
                break;
            }
            case 14: {
                this.setBoolean(1225720064, true);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 15: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 16: {
                this.setInteger(32605, ConnectivityNetworkingActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32605));
                this.triggerObserver(-670433216, eventGeneric);
                break;
            }
            case 17: {
                this.triggerObserver(1963655232);
                break;
            }
            case 18: {
                this.setBoolean(-839647232, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-839647232));
                this.triggerObserver(1275921216, eventGeneric);
                this.setInteger(32077, ConnectivityNetworkingActivity.evListItemActionIndex());
                eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32077));
                this.triggerObserver(1091371840, eventGeneric);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -765883063);
                break;
            }
            case 19: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1738502839);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -782660279);
                break;
            }
            case 20: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1738502839);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -799437495);
                break;
            }
            case 21: {
                this.triggerObserver(486604864);
                break;
            }
            case 22: {
                this.setInteger(1224802560, ConnectivityNetworkingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1224802560));
                this.triggerObserver(369164352, eventGeneric);
                this.setBoolean(-1222311680, false);
                this.setBoolean(17308, false);
                this.setBoolean(1020657664, this.getBoolean(17308));
                eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1020657664));
                this.triggerObserver(1074594624, eventGeneric);
                break;
            }
            case 23: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -815362743);
                break;
            }
            case 24: {
                if (this.getBoolean(21963)) {
                    this.triggerObserver(536936512);
                }
                if (this.getBoolean(21963)) break;
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 710577481);
                break;
            }
            case 25: {
                this.setInteger(-1682505728, ConnectivityNetworkingActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1682505728));
                this.triggerObserver(1695219776, eventGeneric);
                break;
            }
            case 26: {
                this.setInteger(1021706240, 0);
                this.setInteger(13970, 90);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1264618825);
                break;
            }
            case 27: {
                this.setInteger(1021706240, 0);
                this.setInteger(-522518528, 3);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 28: {
                this.setInteger(1021706240, 0);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1533054281);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticNetworkingDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticNetworkingDynState00(n);
    }

    private void performTriggeredTransitionAction_SubHapticNetworkingDynState00(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 3: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1738502839);
                break;
            }
            case 4: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 5: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 6: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 7: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 8: {
                this.setInteger(1404633088, 6);
                this.setInteger(2029780992, 1);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2029780992));
                this.triggerObserver(184614976, eventGeneric);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.triggerObserver(1007288384);
                this.setInteger(28985, 100);
                this.setInteger(28826, 1);
                break;
            }
            case 9: {
                this.setInteger(1404633088, 7);
                this.setInteger(2029780992, 3);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2029780992));
                this.triggerObserver(184614976, eventGeneric);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.triggerObserver(0x400A0040);
                this.setInteger(28985, 32);
                this.setInteger(28826, 0);
                break;
            }
            case 10: {
                this.setInteger(1404633088, 8);
                this.setInteger(2029780992, 2);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2029780992));
                this.triggerObserver(184614976, eventGeneric);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.triggerObserver(1024065600);
                this.setInteger(28985, 32);
                this.setInteger(28826, 0);
                break;
            }
            case 11: {
                this.setInteger(1404633088, 9);
                this.setInteger(2029780992, 0);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2029780992));
                this.triggerObserver(184614976, eventGeneric);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setInteger(28985, 100);
                this.setInteger(28826, 1);
                break;
            }
            case 12: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                this.triggerObserver(1057620032);
                break;
            }
            case 13: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 14: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 15: {
                this.setBoolean(-839647232, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-839647232));
                this.triggerObserver(1275921216, eventGeneric);
                break;
            }
            case 16: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 17: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 20: {
                this.setBoolean(-839647232, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-839647232));
                this.triggerObserver(1275921216, eventGeneric);
                break;
            }
            case 21: {
                this.triggerObserver(1292698432);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticNetworkingDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                return this.getInteger(-584777472) == 2 || this.getBoolean(23799) && this.getInteger(10348) == 2;
            }
            case 8: {
                return this.getInteger(-584777472) == 1;
            }
            case 9: {
                return this.getInteger(10348) == 1 && this.getBoolean(23799);
            }
            case 11: {
                return this.getBoolean(-1328939008);
            }
            case 13: {
                return this.getInteger(29840) == 17 || this.getInteger(-872480768) == 2;
            }
            case 14: {
                return this.getInteger(29840) == 22 || this.getInteger(-872480768) == 3;
            }
            case 17: {
                return this.getBoolean(1453326336);
            }
            case 20: {
                return this.getBoolean(18942);
            }
            case 24: {
                return !this.getBoolean(1486422016);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticNetworkingDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 8: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 9: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 20: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 727354697);
                break;
            }
        }
    }

    private void performStateEntryAction_SubCNetworkingEnterPinPuk(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.setBoolean(1225720064, false);
                this.setBoolean(-1392115456, true);
                break;
            }
            case 4: {
                this.setInteger(15429, 4);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cnns", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 5: {
                this.setInteger(15429, 3);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cnns", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 6: {
                this.setInteger(15429, 0);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cnns", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.setInteger(15429, 2);
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Cnns", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 11: {
                this.showView("Cisl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 12: {
                this.showView("Cisl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 13: {
                this.showView("Cisl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 14: {
                this.showView("Cisl", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubCNetworkingEnterPinPuk(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.setBoolean(1225720064, false);
                this.triggerObserver(1040842816);
                this.setInteger(28985, 100);
                this.setInteger(28826, 1);
                this.setBoolean(-1392115456, false);
                break;
            }
            case 4: {
                this.hideView("Cnns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 5: {
                this.hideView("Cnns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 6: {
                this.hideView("Cnns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 7: {
                this.hideView("Cnns");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 11: {
                this.hideView("Cisl");
                break;
            }
            case 12: {
                this.hideView("Cisl");
                break;
            }
            case 13: {
                this.hideView("Cisl");
                break;
            }
            case 14: {
                this.hideView("Cisl");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubCNetworkingEnterPinPuk(int n) {
        this.performInternalTransitionAction_SubCNetworkingEnterPinPuk0(n);
    }

    private void performInternalTransitionAction_SubCNetworkingEnterPinPuk0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(1021706240, 0);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 1533054281);
                break;
            }
            case 1: {
                this.triggerObserver(453050432);
                break;
            }
            case 2: {
                this.setString(1222049792, ConnectivityNetworkingActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setString(0, this.getString(1222049792));
                this.triggerObserver(469827648, eventGeneric);
                break;
            }
            case 3: {
                this.setBoolean(1225720064, true);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 4: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 5: {
                this.setInteger(32605, ConnectivityNetworkingActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = ConnectivityNetworkingActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32605));
                this.triggerObserver(-670433216, eventGeneric);
                break;
            }
            case 6: {
                this.setInteger(15429, 1);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
            case 7: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
            case 8: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, 475696457);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubCNetworkingEnterPinPuk(int n) {
        this.performTriggeredTransitionAction_SubCNetworkingEnterPinPuk0(n);
    }

    private void performTriggeredTransitionAction_SubCNetworkingEnterPinPuk0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 1: {
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 2: {
                this.triggerObserver(1208812352);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 3: {
                this.triggerObserver(1192035136);
                ConnectivityNetworkingActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubCNetworkingEnterPinPuk(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                return this.getInteger(26701) == 0;
            }
            case 4: {
                return this.getInteger(26701) == 1;
            }
            case 5: {
                return this.getInteger(26701) == 2;
            }
            case 6: {
                return this.getInteger(26701) == 3;
            }
            case 7: {
                return this.getInteger(26701) == 5;
            }
            case 8: {
                return this.getInteger(26701) == 4;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubCNetworkingEnterPinPuk(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                this.triggerObserver(1275789376);
                break;
            }
            case 8: {
                this.triggerObserver(1275789376);
                break;
            }
        }
    }
}

