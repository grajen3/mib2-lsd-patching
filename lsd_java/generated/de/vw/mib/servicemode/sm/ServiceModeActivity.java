/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.servicemode.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class ServiceModeActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public ServiceModeActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 39: {
                this.performStateEntryAction_SubHapticServicemodeDynState(n, bl);
                break;
            }
            case 637: {
                this.performStateEntryAction_SubCSwdlEntryBridge(n, bl);
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
            case 39: {
                this.performStateExitAction_SubHapticServicemodeDynState(n);
                break;
            }
            case 637: {
                this.performStateExitAction_SubCSwdlEntryBridge(n);
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
            case 39: {
                return this.evalInternalTransitionGuard_SubHapticServicemodeDynState(n);
            }
            case 637: {
                return this.evalInternalTransitionGuard_SubCSwdlEntryBridge(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 39: {
                this.performInternalTransitionAction_SubHapticServicemodeDynState(n);
                break;
            }
            case 637: {
                this.performInternalTransitionAction_SubCSwdlEntryBridge(n);
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
            case 39: {
                this.performTriggeredTransitionAction_SubHapticServicemodeDynState(n);
                break;
            }
            case 637: {
                this.performTriggeredTransitionAction_SubCSwdlEntryBridge(n);
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
            case 39: {
                return this.evalUntriggeredTransitionGuard_SubHapticServicemodeDynState(n);
            }
            case 637: {
                return this.evalUntriggeredTransitionGuard_SubCSwdlEntryBridge(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 39: {
                this.performUntriggeredTransitionAction_SubHapticServicemodeDynState(n);
                break;
            }
            case 637: {
                this.performUntriggeredTransitionAction_SubCSwdlEntryBridge(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubHapticServicemodeDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-728367104, 2);
                break;
            }
            case 7: {
                this.setInteger(25955, SkinDataPool.getInteger(190));
                this.setInteger(-728367104, 3);
                break;
            }
            case 10: {
                ServiceModeActivity.changeContext("Servicemode");
                this.setInteger(688783616, 1);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(688783616));
                this.triggerObserver(839254080, eventGeneric);
                break;
            }
            case 17: {
                this.showView("Sf", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 18: {
                this.showView("Sfdi", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 19: {
                this.showView("Sfi", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 20: {
                this.showView("Tfi", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 21: {
                this.setInteger(28326, 0);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28326));
                this.triggerObserver(856031296, eventGeneric);
                this.showView("Sm_3832", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 22: {
                this.showView("Tvh", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 23: {
                this.setInteger(0x100A0100, 17);
                break;
            }
            case 26: {
                this.setInteger(0x100A0100, 17);
                this.setInteger(1150418944, 9);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 30: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 32: {
                this.setInteger(-728367104, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticServicemodeDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-728367104, 0);
                break;
            }
            case 7: {
                this.setInteger(25955, SkinDataPool.getInteger(180));
                break;
            }
            case 10: {
                this.setInteger(688783616, 0);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(688783616));
                this.triggerObserver(839254080, eventGeneric);
                break;
            }
            case 17: {
                this.hideView("Sf");
                break;
            }
            case 18: {
                this.hideView("Sfdi");
                break;
            }
            case 19: {
                this.hideView("Sfi");
                break;
            }
            case 20: {
                this.hideView("Tfi");
                break;
            }
            case 21: {
                this.hideView("Sm_3832");
                break;
            }
            case 22: {
                this.hideView("Tvh");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticServicemodeDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 5: {
                return this.getBoolean(26124);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticServicemodeDynState(int n) {
        this.performInternalTransitionAction_SubHapticServicemodeDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticServicemodeDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(25955, SkinDataPool.getInteger(190));
                break;
            }
            case 1: {
                this.setInteger(25955, SkinDataPool.getInteger(180));
                break;
            }
            case 2: {
                this.setInteger(798949376, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(798949376));
                this.triggerObserver(805634112, eventGeneric);
                break;
            }
            case 3: {
                this.setInteger(772866304, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(772866304));
                this.triggerObserver(788856896, eventGeneric);
                break;
            }
            case 4: {
                ServiceModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -647590583);
                break;
            }
            case 5: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, 1583385929);
                break;
            }
            case 6: {
                this.triggerObserver(-1510991552);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticServicemodeDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticServicemodeDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticServicemodeDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 5: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 6: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 8: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 11: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 12: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 14: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticServicemodeDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                return this.getInteger(28813) == 1;
            }
            case 13: {
                return this.getInteger(183304192) == 2;
            }
            case 14: {
                return this.getInteger(183304192) == 0;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticServicemodeDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                this.setInteger(28813, 0);
                break;
            }
        }
    }

    private void performStateEntryAction_SubCSwdlEntryBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.setInteger(0x100A0100, 5);
                break;
            }
            case 5: {
                this.triggerObserver(838926400);
                break;
            }
            case 9: {
                this.triggerObserver(956366912);
                break;
            }
            case 10: {
                this.enterIncludeDdpGroup(125);
                break;
            }
            case 12: {
                this.showView("Slm", bl, 125);
                break;
            }
            case 22: {
                this.showView("Sd", bl, 125);
                break;
            }
            case 23: {
                this.showView("Sdnf", bl, 125);
                break;
            }
            case 24: {
                this.showView("Sw", bl, 125);
                break;
            }
            case 25: {
                this.showView("Sdsm", bl, 125);
                break;
            }
            case 26: {
                this.showView("Smsm", bl, 125);
                break;
            }
            case 27: {
                this.showView("Ss", bl, 125);
                break;
            }
            case 28: {
                this.showView("Sme", bl, 125);
                break;
            }
            case 29: {
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(0x55880000));
                this.triggerObserver(620822592, eventGeneric);
                this.showView("Srm", bl, 125);
                break;
            }
            case 30: {
                this.showView("Srsm", bl, 125);
                break;
            }
            case 33: {
                this.showView("Srri", bl, 125);
                break;
            }
            case 34: {
                this.showView("Sre", bl, 125);
                break;
            }
            case 35: {
                this.setBoolean(-56950784, true);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-56950784));
                this.triggerObserver(-1241055168, eventGeneric);
                this.showView("Sss", bl, 125);
                break;
            }
            case 36: {
                this.showView("Se", bl, 125);
                break;
            }
            case 37: {
                this.setBoolean(28778, false);
                this.showView("Sm_866A", bl, 125);
                break;
            }
            case 41: {
                this.setInteger(1150418944, 7);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
        }
    }

    private void performStateExitAction_SubCSwdlEntryBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 9: {
                this.triggerObserver(973144128);
                break;
            }
            case 10: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 12: {
                this.hideView("Slm");
                break;
            }
            case 22: {
                this.hideView("Sd");
                break;
            }
            case 23: {
                this.hideView("Sdnf");
                break;
            }
            case 24: {
                this.hideView("Sw");
                break;
            }
            case 25: {
                this.hideView("Sdsm");
                break;
            }
            case 26: {
                this.hideView("Smsm");
                break;
            }
            case 27: {
                this.hideView("Ss");
                break;
            }
            case 28: {
                this.hideView("Sme");
                break;
            }
            case 29: {
                this.hideView("Srm");
                break;
            }
            case 30: {
                this.hideView("Srsm");
                break;
            }
            case 33: {
                this.hideView("Srri");
                break;
            }
            case 34: {
                this.hideView("Sre");
                break;
            }
            case 35: {
                this.hideView("Sss");
                this.setBoolean(-56950784, false);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-56950784));
                this.triggerObserver(-1241055168, eventGeneric);
                break;
            }
            case 36: {
                this.hideView("Se");
                break;
            }
            case 37: {
                this.hideView("Sm_866A");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubCSwdlEntryBridge(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return ServiceModeActivity.evListItemEventSender().equals("All");
            }
            case 3: {
                return ServiceModeActivity.evListItemEventSender().equals("None");
            }
            case 5: {
                return this.getBoolean(-789184512);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubCSwdlEntryBridge(int n) {
        this.performInternalTransitionAction_SubCSwdlEntryBridge00(n);
    }

    private void performInternalTransitionAction_SubCSwdlEntryBridge00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(814350336, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(814350336));
                this.triggerObserver(721485888, eventGeneric);
                break;
            }
            case 1: {
                this.setInteger(-1962606336, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1962606336));
                this.triggerObserver(637599808, eventGeneric);
                break;
            }
            case 2: {
                this.triggerObserver(1023475776);
                break;
            }
            case 3: {
                this.triggerObserver(1040252992);
                break;
            }
            case 4: {
                this.setInteger(-1977483008, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1977483008));
                this.triggerObserver(654377024, eventGeneric);
                break;
            }
            case 5: {
                this.setInteger(10923, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10923));
                this.triggerObserver(671154240, eventGeneric);
                break;
            }
            case 6: {
                this.setInteger(0x55880000, ServiceModeActivity.evListItemActionIndex());
                break;
            }
            case 7: {
                this.setInteger(-307429376, 0);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-307429376));
                this.triggerObserver(604045376, eventGeneric);
                ServiceModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1100509879);
                break;
            }
            case 8: {
                this.setInteger(-307429376, 1);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-307429376));
                this.triggerObserver(604045376, eventGeneric);
                ServiceModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1100509879);
                break;
            }
            case 9: {
                this.setInteger(-307429376, 2);
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-307429376));
                this.triggerObserver(604045376, eventGeneric);
                ServiceModeActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1100509879);
                break;
            }
            case 10: {
                this.triggerObserver(587268160);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubCSwdlEntryBridge(int n) {
        this.performTriggeredTransitionAction_SubCSwdlEntryBridge00(n);
    }

    private void performTriggeredTransitionAction_SubCSwdlEntryBridge00(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 4: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 5: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 7: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 9: {
                this.triggerObserver(570490944);
                break;
            }
            case 14: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 16: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 17: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 18: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 22: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 23: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 26: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 27: {
                this.setBoolean(27691, true);
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 28: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 29: {
                this.setBoolean(27691, true);
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubCSwdlEntryBridge(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(-561905664) == 0;
            }
            case 2: {
                return this.getInteger(-561905664) == 1;
            }
            case 5: {
                return this.getBoolean(28778) && this.getBoolean(1972436992);
            }
            case 13: {
                return this.getBoolean(25554);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubCSwdlEntryBridge(int n) {
        switch (n - this.UT_OFFSET) {
            case 5: {
                this.setBoolean(-789184512, true);
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 6: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setBoolean(-789184512, false);
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
                this.setInteger(696451072, ServiceModeActivity.evListItemActionIndex());
                break;
            }
            case 1: {
                this.setInteger(-1061224448, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1061224448));
                this.triggerObserver(738263104, eventGeneric);
                break;
            }
            case 2: {
                this.setInteger(27478, ServiceModeActivity.evListItemActionIndex());
                EventGeneric eventGeneric = ServiceModeActivity.newEvent();
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
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 1: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 2: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 3: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 4: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 5: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 6: {
                ServiceModeActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }
}

