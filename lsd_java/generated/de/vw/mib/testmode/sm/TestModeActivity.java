/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.testmode.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class TestModeActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public TestModeActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 57: {
                this.performStateEntryAction_SubHapticTestmodeDynState(n, bl);
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
            case 57: {
                this.performStateExitAction_SubHapticTestmodeDynState(n);
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
            case 57: {
                return this.evalInternalTransitionGuard_SubHapticTestmodeDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 57: {
                this.performInternalTransitionAction_SubHapticTestmodeDynState(n);
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
            default: 
        }
    }

    @Override
    public boolean evalUntriggeredTransitionGuard(int n) {
        switch (this.subStatemachineId) {
            case 57: {
                return this.evalUntriggeredTransitionGuard_SubHapticTestmodeDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            default: 
        }
    }

    private void performStateEntryAction_SubHapticTestmodeDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1484849152, 2);
                break;
            }
            case 8: {
                this.setInteger(1484849152, 3);
                break;
            }
            case 11: {
                this.setInteger(13512, 1);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(13512));
                this.triggerObserver(-1257963456, eventGeneric);
                TestModeActivity.changeContext("Testmode");
                break;
            }
            case 14: {
                this.showView("Tcp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 18: {
                this.showView("Tft_A625", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 19: {
                this.showView("Tft_340F", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 20: {
                this.showView("Tfts", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 21: {
                this.showView("Tfts2", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 22: {
                this.setInteger(-137560064, 0);
                this.setInteger(-154337280, 61);
                this.setInteger(-137560064, this.getInteger(-137560064) + 0);
                this.setInteger(-154337280, this.getInteger(-154337280) + 0);
                this.setInteger(11259, 400);
                this.setInteger(1726152704, 419);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-137560064));
                eventGeneric.setInt(1, this.getInteger(-154337280));
                eventGeneric.setInt(2, this.getInteger(11259));
                eventGeneric.setInt(3, this.getInteger(1726152704));
                this.triggerObserver(218824768, eventGeneric);
                this.setInteger(-74579968, 1);
                this.setInteger(-779026432, 1);
                eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-779026432));
                this.triggerObserver(202047552, eventGeneric);
                this.showView("Th", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 23: {
                this.showView("Tlc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 24: {
                this.setInteger(-1902051328, 53);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                break;
            }
            case 26: {
                this.showView("Tth", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 27: {
                this.showView("Tths", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 28: {
                this.showView("Tt", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 29: {
                this.showView("Tto", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 30: {
                this.showView("Tts", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 31: {
                this.showView("Tap", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 33: {
                this.showView("Tfc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 34: {
                this.triggerObserver(17432640);
                this.showView("Tdd", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 35: {
                this.showView("Tff", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 36: {
                this.showView("Tft_0715", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 37: {
                this.showView("Tft_6EC7", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 38: {
                this.setInteger(-1902051328, 50);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Thd", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 39: {
                this.showView("Hmw", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 40: {
                this.showView("Ttt", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 41: {
                this.showView("Tpt_9425", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 45: {
                this.showView("Tfwi", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 46: {
                this.showView("Tfwt", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 47: {
                this.showView("Tsm_9B74", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 48: {
                this.setInteger(-1902051328, 64);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Tg", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 49: {
                this.showView("Thss", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 50: {
                this.setInteger(-1902051328, 0);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Tm_0E5E", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 51: {
                this.setInteger(-1902051328, 48);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Tpl_5577", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 52: {
                this.setInteger(-1902051328, 1);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Tsm_B4D2", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 53: {
                this.setInteger(-1902051328, 53);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1902051328));
                this.triggerObserver(-335216576, eventGeneric);
                this.showView("Tts", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 54: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Tus_0A1E", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 55: {
                this.setInteger(0x100A0100, 16);
                break;
            }
            case 58: {
                this.setInteger(0x100A0100, 16);
                this.setInteger(1150418944, 9);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 62: {
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 63: {
                this.setInteger(1484849152, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticTestmodeDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1484849152, 0);
                break;
            }
            case 8: {
                break;
            }
            case 11: {
                this.setInteger(13512, 0);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(13512));
                this.triggerObserver(-1257963456, eventGeneric);
                break;
            }
            case 14: {
                this.hideView("Tcp");
                break;
            }
            case 18: {
                this.hideView("Tft_A625");
                break;
            }
            case 19: {
                this.hideView("Tft_340F");
                break;
            }
            case 20: {
                this.hideView("Tfts");
                break;
            }
            case 21: {
                this.hideView("Tfts2");
                break;
            }
            case 22: {
                this.hideView("Th");
                this.setInteger(-779026432, 0);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-779026432));
                this.triggerObserver(202047552, eventGeneric);
                break;
            }
            case 23: {
                this.hideView("Tlc");
                break;
            }
            case 26: {
                this.hideView("Tth");
                break;
            }
            case 27: {
                this.hideView("Tths");
                break;
            }
            case 28: {
                this.hideView("Tt");
                break;
            }
            case 29: {
                this.hideView("Tto");
                break;
            }
            case 30: {
                this.hideView("Tts");
                break;
            }
            case 31: {
                this.hideView("Tap");
                break;
            }
            case 33: {
                this.hideView("Tfc");
                break;
            }
            case 34: {
                this.hideView("Tdd");
                this.triggerObserver(34209856);
                break;
            }
            case 35: {
                this.hideView("Tff");
                break;
            }
            case 36: {
                this.hideView("Tft_0715");
                break;
            }
            case 37: {
                this.hideView("Tft_6EC7");
                break;
            }
            case 38: {
                this.hideView("Thd");
                break;
            }
            case 39: {
                this.hideView("Hmw");
                break;
            }
            case 40: {
                this.hideView("Ttt");
                break;
            }
            case 41: {
                this.hideView("Tpt_9425");
                break;
            }
            case 45: {
                this.hideView("Tfwi");
                break;
            }
            case 46: {
                this.hideView("Tfwt");
                break;
            }
            case 47: {
                this.hideView("Tsm_9B74");
                break;
            }
            case 48: {
                this.hideView("Tg");
                break;
            }
            case 49: {
                this.hideView("Thss");
                break;
            }
            case 50: {
                this.hideView("Tm_0E5E");
                break;
            }
            case 51: {
                this.hideView("Tpl_5577");
                break;
            }
            case 52: {
                this.hideView("Tsm_B4D2");
                break;
            }
            case 53: {
                this.hideView("Tts");
                break;
            }
            case 54: {
                this.hideView("Tus_0A1E");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticTestmodeDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getBoolean(12357);
            }
            case 3: {
                return !this.getBoolean(12357);
            }
            case 15: {
                return TestModeActivity.evListItemEventSender().equals("Button");
            }
            case 16: {
                return TestModeActivity.evListItemEventSender().equals("onoff");
            }
            case 18: {
                return TestModeActivity.evListItemEventSender().equals("SD");
            }
            case 19: {
                return TestModeActivity.evListItemEventSender().equals("TCPIP");
            }
            case 20: {
                return TestModeActivity.evListItemEventSender().equals("Serial");
            }
            case 21: {
                return TestModeActivity.evListItemEventSender().equals("Button");
            }
            case 22: {
                return TestModeActivity.evListItemEventSender().equals("onoff");
            }
            case 23: {
                return TestModeActivity.evListItemEventSender().equals("Button");
            }
            case 24: {
                return TestModeActivity.evListItemEventSender().equals("onoff");
            }
            case 40: {
                return !this.getBoolean(-376438784);
            }
            case 41: {
                return !this.getBoolean(-376438784);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticTestmodeDynState(int n) {
        this.performInternalTransitionAction_SubHapticTestmodeDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticTestmodeDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                break;
            }
            case 1: {
                break;
            }
            case 2: {
                this.setInteger(217382912, 1);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(217382912));
                this.triggerObserver(537264192, eventGeneric);
                break;
            }
            case 3: {
                this.setInteger(217382912, 0);
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(217382912));
                this.triggerObserver(537264192, eventGeneric);
                break;
            }
            case 6: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 459836745);
                break;
            }
            case 7: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 476613961);
                break;
            }
            case 8: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 493391177);
                break;
            }
            case 9: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 510168393);
                break;
            }
            case 10: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 526945609);
                break;
            }
            case 11: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 543722825);
                break;
            }
            case 12: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 577277257);
                this.triggerObserver(805961792);
                break;
            }
            case 13: {
                this.setInteger(-74579968, TestModeActivity.evListItemActionIndex());
                this.setInteger(-779026432, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-779026432));
                this.triggerObserver(202047552, eventGeneric);
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 577277257);
                break;
            }
            case 14: {
                this.setInteger(27089, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27089));
                this.triggerObserver(-997121728, eventGeneric);
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 577277257);
                break;
            }
            case 15: {
                this.setInteger(17469, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17469));
                this.triggerObserver(168165440, eventGeneric);
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 594054473);
                break;
            }
            case 16: {
                this.setInteger(21449, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21449));
                this.triggerObserver(184942656, eventGeneric);
                break;
            }
            case 17: {
                this.setInteger(21483, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21483));
                this.triggerObserver(218497088, eventGeneric);
                break;
            }
            case 18: {
                this.triggerObserver(33947712);
                break;
            }
            case 19: {
                this.triggerObserver(50724928);
                break;
            }
            case 20: {
                this.triggerObserver(0x4060040);
                break;
            }
            case 21: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 610831689);
                break;
            }
            case 22: {
                this.triggerObserver(84279360);
                break;
            }
            case 23: {
                TestModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 627608905);
                break;
            }
            case 24: {
                this.triggerObserver(0x6060040);
                break;
            }
            case 25: {
                this.triggerObserver(117833792);
                break;
            }
            case 26: {
                this.triggerObserver(134611008);
                break;
            }
            case 27: {
                this.triggerObserver(151388224);
                break;
            }
            case 28: {
                this.setInteger(-98434816, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-98434816));
                this.triggerObserver(201719872, eventGeneric);
                break;
            }
            case 29: {
                this.triggerObserver(-1013898944);
                break;
            }
            case 30: {
                this.triggerObserver(-1064230592);
                break;
            }
            case 31: {
                this.triggerObserver(-1047453376);
                break;
            }
            case 32: {
                this.triggerObserver(-1030676160);
                break;
            }
            case 33: {
                this.triggerObserver(587857984);
                break;
            }
            case 34: {
                this.triggerObserver(688259136);
                break;
            }
            case 35: {
                this.triggerObserver(705036352);
                break;
            }
            case 36: {
                this.setBoolean(1034813440, !this.getBoolean(1034813440));
                break;
            }
            case 37: {
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1264618825);
                break;
            }
            case 38: {
                this.triggerObserver(-930012864);
                break;
            }
            case 39: {
                this.triggerObserver(-946790080);
                break;
            }
            case 40: {
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 41: {
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 42: {
                this.setInteger(1186594816, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1186594816));
                this.triggerObserver(1443168320, eventGeneric);
                break;
            }
            case 43: {
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1499499849);
                break;
            }
            case 44: {
                this.triggerObserver(-963567296);
                break;
            }
            case 45: {
                this.setInteger(26534, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(26534));
                this.triggerObserver(-980344512, eventGeneric);
                break;
            }
            case 46: {
                this.triggerObserver(503709760);
                break;
            }
            case 47: {
                this.triggerObserver(486932544);
                break;
            }
            case 48: {
                this.setInteger(28813, 1);
                this.setBoolean(28778, true);
                TestModeActivity.fireHMIEvent(ANY, BROADCAST, 1516277065);
                break;
            }
            case 49: {
                this.setInteger(-98434816, TestModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TestModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-98434816));
                this.triggerObserver(201719872, eventGeneric);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticTestmodeDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 16: {
                return this.getInteger(183304192) == 2;
            }
            case 17: {
                return this.getInteger(183304192) == 0 && !this.getBoolean(26124);
            }
        }
        return true;
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

