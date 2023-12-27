/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.sound.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SoundActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SoundActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 584: {
                this.performStateEntryAction_SubPopupPoSoundAlertSoundSetupNotAccessibleDynState(n, bl);
                break;
            }
            case 585: {
                this.performStateEntryAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(n, bl);
                break;
            }
            case 586: {
                this.performStateEntryAction_SubPopupPoSoundVolumeSoundNavDynState(n, bl);
                break;
            }
            case 587: {
                this.performStateEntryAction_SubPopupPoSoundVolumeSoundPhoneDynState(n, bl);
                break;
            }
            case 588: {
                this.performStateEntryAction_SubPopupPoSoundVolumeSoundSdsDynState(n, bl);
                break;
            }
            case 589: {
                this.performStateEntryAction_SubPopupPoSoundVolumeSoundTaDynState(n, bl);
                break;
            }
            case 59: {
                this.performStateEntryAction_SubHapticToneSetupDynState(n, bl);
                break;
            }
            case 71: {
                this.performStateEntryAction_SubPromptingSoundDynState(n, bl);
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
            case 584: {
                this.performStateExitAction_SubPopupPoSoundAlertSoundSetupNotAccessibleDynState(n);
                break;
            }
            case 585: {
                this.performStateExitAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(n);
                break;
            }
            case 586: {
                this.performStateExitAction_SubPopupPoSoundVolumeSoundNavDynState(n);
                break;
            }
            case 587: {
                this.performStateExitAction_SubPopupPoSoundVolumeSoundPhoneDynState(n);
                break;
            }
            case 588: {
                this.performStateExitAction_SubPopupPoSoundVolumeSoundSdsDynState(n);
                break;
            }
            case 589: {
                this.performStateExitAction_SubPopupPoSoundVolumeSoundTaDynState(n);
                break;
            }
            case 59: {
                this.performStateExitAction_SubHapticToneSetupDynState(n);
                break;
            }
            case 71: {
                this.performStateExitAction_SubPromptingSoundDynState(n);
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
            case 585: {
                return this.evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundEntertainmentDynState(n);
            }
            case 586: {
                return this.evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundNavDynState(n);
            }
            case 587: {
                return this.evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundPhoneDynState(n);
            }
            case 588: {
                return this.evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundSdsDynState(n);
            }
            case 589: {
                return this.evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundTaDynState(n);
            }
            case 59: {
                return this.evalInternalTransitionGuard_SubHapticToneSetupDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 585: {
                this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(n);
                break;
            }
            case 586: {
                this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundNavDynState(n);
                break;
            }
            case 587: {
                this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundPhoneDynState(n);
                break;
            }
            case 588: {
                this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundSdsDynState(n);
                break;
            }
            case 589: {
                this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundTaDynState(n);
                break;
            }
            case 59: {
                this.performInternalTransitionAction_SubHapticToneSetupDynState(n);
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
            case 71: {
                return this.evalTriggeredTransitionGuard_SubPromptingSoundDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 59: {
                this.performTriggeredTransitionAction_SubHapticToneSetupDynState(n);
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
            case 59: {
                return this.evalUntriggeredTransitionGuard_SubHapticToneSetupDynState(n);
            }
            case 71: {
                return this.evalUntriggeredTransitionGuard_SubPromptingSoundDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 59: {
                this.performUntriggeredTransitionAction_SubHapticToneSetupDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundAlertSoundSetupNotAccessibleDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Psassna", 584, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundAlertSoundSetupNotAccessibleDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Psassna");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psvse", 585, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psvse");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundEntertainmentDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getInteger(28093) != 0;
            }
            case 3: {
                return this.getBoolean(27559);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundEntertainmentDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundEntertainmentDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundEntertainmentDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 1: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811633993);
                break;
            }
            case 3: {
                this.setInteger(-943587328, -1);
                this.setInteger(14308, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(58);
                break;
            }
            case 4: {
                this.setInteger(32204, 1);
                this.setBoolean(-1767440384, true);
                this.setBoolean(15665, true);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 5: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 6: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 7: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundVolumeSoundNavDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psvsn", 586, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundVolumeSoundNavDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psvsn");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundNavDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getInteger(28093) != 1;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundNavDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundNavDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundNavDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 1: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811633993);
                break;
            }
            case 3: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 4: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 5: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundVolumeSoundPhoneDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psvsp", 587, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundVolumeSoundPhoneDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psvsp");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundPhoneDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getInteger(28093) != 2;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundPhoneDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundPhoneDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundPhoneDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 1: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811633993);
                break;
            }
            case 3: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 4: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 5: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundVolumeSoundSdsDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psvss", 588, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundVolumeSoundSdsDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psvss");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundSdsDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getInteger(28093) != 4;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundSdsDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundSdsDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundSdsDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 1: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811633993);
                break;
            }
            case 3: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 4: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 5: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSoundVolumeSoundTaDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psvst", 589, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSoundVolumeSoundTaDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psvst");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoSoundVolumeSoundTaDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getInteger(28093) != 3;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundTaDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoSoundVolumeSoundTaDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoSoundVolumeSoundTaDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 1: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 811633993);
                break;
            }
            case 3: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 4: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 5: {
                SoundActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 3, this.topStatemachine.getPopupInfoId());
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticToneSetupDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-418840320, 2);
                break;
            }
            case 8: {
                if (this.getBoolean(15665)) {
                    this.setBoolean(840433920, false);
                }
                if (!this.getBoolean(15665)) {
                    this.setBoolean(840433920, true);
                }
                this.setBoolean(15665, false);
                this.setBoolean(26114, true);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1017082551);
                this.setInteger(-418840320, 3);
                if (this.getBoolean(15665)) {
                    this.setInteger(-1456996096, 1331727689);
                }
                this.setInteger(1324154880, SkinDataPool.getInteger(190));
                break;
            }
            case 11: {
                this.setBoolean(1257046016, false);
                this.setBoolean(1704984576, false);
                break;
            }
            case 13: {
                this.setInteger(-1332281344, this.getLicValue(3529, 1, 0, 0));
                this.setInteger(287703296, this.getLicValue(3529, 0, 0, 0));
                this.showView("Tssbf", bl, 121);
                break;
            }
            case 16: {
                if (this.getInteger(-1245773824) != 1) {
                    this.setBoolean(967442432, false);
                }
                if (this.getInteger(-1245773824) == 1) {
                    this.setBoolean(967442432, true);
                }
                if (this.getBoolean(32583) && this.getInteger(-1245773824) == 1) {
                    this.setBoolean(1309147392, true);
                }
                if (!this.getBoolean(32583)) {
                    this.setBoolean(1309147392, false);
                }
                if (this.getBoolean(32583) && this.getInteger(-1245773824) == 1) {
                    this.setBoolean(-1870331904, true);
                }
                if (!this.getBoolean(32583)) {
                    this.setBoolean(-1870331904, false);
                }
                this.setInteger(29077, -1);
                this.setBoolean(11087, true);
                this.setBoolean(-2016804864, true);
                this.showView("Tsmv", bl, 121);
                break;
            }
            case 17: {
                this.setBoolean(27559, true);
                this.setInteger(32204, 0);
                if (!this.getBoolean(-1767440384)) {
                    this.setInteger(-943587328, -1);
                    this.setInteger(14308, -1);
                    this.setInteger(1407254528, -1);
                    this.handleGlobalAction(59);
                }
                if (this.getBoolean(-1767440384)) {
                    this.setInteger(-943587328, -1);
                    this.setInteger(14308, -1);
                    this.setInteger(1407254528, -1);
                    this.setBoolean(11087, true);
                    this.setInteger(22221, 0);
                    this.setInteger(29077, -1);
                    this.setInteger(149880832, 12);
                    EventGeneric eventGeneric = SoundActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(149880832));
                    this.triggerObserver(-352059328, eventGeneric);
                }
                this.showView("Tsm_3BE1", bl, 121);
                break;
            }
            case 18: {
                this.setBoolean(10948, false);
                this.setBoolean(22149, false);
                this.setBoolean(-14810880, false);
                this.setBoolean(10041, false);
                this.showView("Tsds", bl, 121);
                break;
            }
            case 19: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1281461577);
                break;
            }
            case 20: {
                this.setInteger(-418840320, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticToneSetupDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-418840320, 0);
                break;
            }
            case 8: {
                this.setInteger(1021706240, 0);
                this.setInteger(32204, 0);
                this.setBoolean(26114, false);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -530543287);
                this.setInteger(1324154880, SkinDataPool.getInteger(180));
                break;
            }
            case 13: {
                this.hideView("Tssbf");
                break;
            }
            case 16: {
                this.hideView("Tsmv");
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                this.setBoolean(11087, false);
                this.setInteger(29077, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setBoolean(-2016804864, false);
                break;
            }
            case 17: {
                this.hideView("Tsm_3BE1");
                this.setBoolean(27559, false);
                this.setInteger(-943587328, -1);
                this.setInteger(14308, -1);
                this.setInteger(1407254528, -1);
                this.setBoolean(-1767440384, false);
                this.handleGlobalAction(59);
                break;
            }
            case 18: {
                this.hideView("Tsds");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticToneSetupDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 5: {
                return this.getInteger(-1245773824) == 1;
            }
            case 23: {
                return this.getLicValue(3529, 0, 0, 0) < this.getLicValue(1514, 0, 0, 0);
            }
            case 24: {
                return this.getLicValue(3529, 0, 0, 0) > this.getLicValue(1514, 1, 0, 0);
            }
            case 25: {
                return this.getLicValue(3529, 1, 0, 0) < this.getLicValue(1517, 0, 0, 0);
            }
            case 26: {
                return this.getInteger(-1332281344) > this.getLicValue(1517, 1, 0, 0);
            }
            case 34: {
                return this.getInteger(1021706240) != 35;
            }
            case 35: {
                return this.getInteger(1021706240) == 35;
            }
            case 37: {
                return SoundActivity.evListItemActionIndex() == 1 && this.getInteger(29077) != 1;
            }
            case 38: {
                return SoundActivity.evListItemActionIndex() == 1 && this.getInteger(29077) == 1;
            }
            case 39: {
                return SoundActivity.evListItemActionIndex() == 2 && this.getInteger(29077) != 2;
            }
            case 40: {
                return SoundActivity.evListItemActionIndex() == 2 && this.getInteger(29077) == 2;
            }
            case 41: {
                return SoundActivity.evListItemActionIndex() == 3 && this.getInteger(29077) != 3;
            }
            case 42: {
                return SoundActivity.evListItemActionIndex() == 3 && this.getInteger(29077) == 3;
            }
            case 43: {
                return SoundActivity.evListItemActionIndex() == 4 && this.getInteger(29077) != 4;
            }
            case 44: {
                return SoundActivity.evListItemActionIndex() == 4 && this.getInteger(29077) == 4;
            }
            case 45: {
                return SoundActivity.evListItemActionIndex() == 5 && this.getInteger(29077) != 5;
            }
            case 46: {
                return SoundActivity.evListItemActionIndex() == 5 && this.getInteger(29077) == 5;
            }
            case 47: {
                return SoundActivity.evListItemActionIndex() == 0 && this.getInteger(29077) != 0;
            }
            case 48: {
                return SoundActivity.evListItemActionIndex() == 0 && this.getInteger(29077) == 0;
            }
            case 49: {
                return this.getInteger(-1625816832) != -1;
            }
            case 50: {
                return this.getInteger(-1625816832) == -1;
            }
            case 51: {
                return this.getInteger(32302) != -1;
            }
            case 52: {
                return this.getInteger(32302) == -1;
            }
            case 53: {
                return this.getInteger(29077) == 1;
            }
            case 54: {
                return this.getInteger(29077) == 2;
            }
            case 55: {
                return this.getInteger(29077) == 3;
            }
            case 56: {
                return this.getInteger(29077) == 4;
            }
            case 57: {
                return this.getInteger(29077) == 5;
            }
            case 58: {
                return this.getInteger(29077) == 0;
            }
            case 68: {
                return this.getBoolean(32583) && (this.getInteger(-1245773824) == 1 || this.getInteger(-1245773824) == 5);
            }
            case 69: {
                return !this.getBoolean(32583);
            }
            case 74: {
                return this.getInteger(1021706240) == 81;
            }
            case 75: {
                return this.getInteger(1021706240) == 80;
            }
            case 76: {
                return this.getInteger(1021706240) == 20;
            }
            case 77: {
                return this.getInteger(1021706240) == 21;
            }
            case 78: {
                return this.getInteger(1021706240) == this.getInteger(1384448000);
            }
            case 79: {
                return this.getInteger(1021706240) == 10;
            }
            case 80: {
                return this.getInteger(32204) == 1;
            }
            case 81: {
                return this.getInteger(32204) == 1;
            }
            case 82: {
                return this.getInteger(29840) == 13 || this.getInteger(32204) == 3;
            }
            case 86: {
                return this.getInteger(-943587328) == -1;
            }
            case 87: {
                return this.getInteger(-943587328) != -1;
            }
            case 88: {
                return this.getInteger(1407254528) == -1;
            }
            case 89: {
                return this.getInteger(1407254528) != -1;
            }
            case 102: {
                return this.getInteger(14308) != -1;
            }
            case 103: {
                return this.getInteger(14308) == -1;
            }
            case 105: {
                return !this.getBoolean(32583);
            }
            case 107: {
                return this.getInteger(22221) == -1;
            }
            case 108: {
                return this.getInteger(22221) != -1;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticToneSetupDynState(int n) {
        this.performInternalTransitionAction_SubHapticToneSetupDynState000(n);
    }

    private void performInternalTransitionAction_SubHapticToneSetupDynState000(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(446627840, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(446627840));
                this.triggerObserver(1225064512, eventGeneric);
                break;
            }
            case 1: {
                this.setInteger(446627840, 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(446627840));
                this.triggerObserver(1225064512, eventGeneric);
                break;
            }
            case 2: {
                this.setInteger(446627840, 2);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(446627840));
                this.triggerObserver(1225064512, eventGeneric);
                break;
            }
            case 3: {
                this.setInteger(446627840, 4);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(446627840));
                this.triggerObserver(1225064512, eventGeneric);
                break;
            }
            case 4: {
                this.setInteger(446627840, 3);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(446627840));
                this.triggerObserver(1225064512, eventGeneric);
                if (this.getInteger(-1245773824) == 2 && this.getBoolean(837550080)) {
                    SoundActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getInteger(-1245773824) == 2 && this.getBoolean(10548)) {
                    SoundActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                if (this.getInteger(-1245773824) != 2 || !this.getBoolean(21917)) break;
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -630682295);
                break;
            }
            case 5: {
                this.triggerObserver(-100401088);
                break;
            }
            case 6: {
                this.triggerObserver(-33292224);
                break;
            }
            case 7: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 8: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1298173257);
                break;
            }
            case 9: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 10: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1566608713);
                break;
            }
            case 11: {
                this.setInteger(1324154880, SkinDataPool.getInteger(190));
                break;
            }
            case 12: {
                this.setInteger(1324154880, SkinDataPool.getInteger(180));
                break;
            }
            case 13: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 14: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 15: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 16: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 17: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 18: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 19: {
                this.setBoolean(1704984576, false);
                this.setInteger(-208797696, SoundActivity.evPointX());
                this.setInteger(-510787584, SoundActivity.evPointY());
                this.setInteger(287703296, SoundActivity.evPointGestureParam1());
                this.setInteger(-1332281344, SoundActivity.evPointGestureParam2());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1519874743);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1536651959);
                break;
            }
            case 21: {
                this.setBoolean(1704984576, true);
                this.setInteger(-208797696, SoundActivity.evPointX());
                this.setInteger(-510787584, SoundActivity.evPointY());
                this.setInteger(287703296, SoundActivity.evPointGestureParam1());
                this.setInteger(-1332281344, SoundActivity.evPointGestureParam2());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 22: {
                this.setBoolean(1704984576, false);
                break;
            }
            case 23: {
                this.setBoolean(1257046016, true);
                this.setBoolean(1704984576, false);
                this.setInteger(287703296, this.getInteger(287703296) + 1);
                this.setInteger(-1332281344, this.getLicValue(3529, 1, 0, 0));
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 24: {
                this.setBoolean(1257046016, true);
                this.setBoolean(1704984576, false);
                this.setInteger(287703296, this.getInteger(287703296) - 1);
                this.setInteger(-1332281344, this.getLicValue(3529, 1, 0, 0));
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 25: {
                this.setBoolean(1257046016, true);
                this.setBoolean(1704984576, false);
                this.setInteger(287703296, this.getLicValue(3529, 0, 0, 0));
                this.setInteger(-1332281344, this.getInteger(-1332281344) + 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 26: {
                this.setBoolean(1257046016, true);
                this.setBoolean(1704984576, false);
                this.setInteger(287703296, this.getLicValue(3529, 0, 0, 0));
                this.setInteger(-1332281344, this.getInteger(-1332281344) - 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 27: {
                this.setBoolean(1257046016, true);
                this.setBoolean(1704984576, false);
                this.setInteger(287703296, 0);
                this.setInteger(-1332281344, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 28: {
                this.setBoolean(1704984576, false);
                this.setBoolean(1257046016, false);
                this.setInteger(-1332281344, this.getLicValue(3529, 1, 0, 0));
                this.setInteger(287703296, this.getLicValue(3529, 0, 0, 0));
                break;
            }
            case 29: {
                this.setBoolean(1704984576, false);
                this.setInteger(-1649082368, SoundActivity.evListItemActionIndex());
                this.setInteger(16606, 2);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1649082368));
                this.triggerObserver(1711931456, eventGeneric);
                break;
            }
            case 30: {
                this.setInteger(16606, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(16606));
                this.triggerObserver(1594425408, eventGeneric);
                break;
            }
            case 31: {
                this.setInteger(16606, 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(16606));
                this.triggerObserver(1594425408, eventGeneric);
                break;
            }
            case 32: {
                this.setInteger(16606, 3);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(16606));
                this.triggerObserver(1594425408, eventGeneric);
                break;
            }
            case 33: {
                this.setInteger(16606, 2);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(16606));
                this.triggerObserver(1594425408, eventGeneric);
                break;
            }
            case 34: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 526290249);
                break;
            }
            case 35: {
                this.setInteger(-522518528, 3);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 36: {
                this.setInteger(29077, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 37: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 3);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 38: {
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 39: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 40: {
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 41: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 5);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 42: {
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 43: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 4);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 44: {
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 45: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 46: {
                this.setInteger(29077, -1);
                break;
            }
            case 47: {
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(29077, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 12);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 48: {
                this.setInteger(29077, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 49: {
                this.setInteger(-1625816832, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 50: {
                this.setInteger(29077, -1);
                this.setInteger(32302, -1);
                this.setInteger(-1625816832, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 8);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 51: {
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 52: {
                this.setInteger(29077, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, SoundActivity.evListItemActionIndex());
                this.setInteger(149880832, 11);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 53: {
                this.setInteger(32080, 3);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 54: {
                this.setInteger(32080, 1);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 55: {
                this.setInteger(32080, 5);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 56: {
                this.setInteger(32080, 4);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 57: {
                this.setInteger(23278, 6);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                break;
            }
            case 58: {
                this.setInteger(32080, 9);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 59: {
                this.setInteger(18168, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(18168));
                this.triggerObserver(17563712, eventGeneric);
                break;
            }
            case 60: {
                this.setInteger(25283, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(25283));
                this.triggerObserver(1282874176, eventGeneric);
                break;
            }
            case 61: {
                this.setBoolean(967442432, true);
                this.setBoolean(1309147392, true);
                this.setBoolean(-1870331904, true);
                break;
            }
            case 62: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setBoolean(967442432, false);
                this.setInteger(29077, -1);
                this.setBoolean(1309147392, false);
                this.setInteger(-1625816832, -1);
                this.setBoolean(-1870331904, false);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 63: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setBoolean(967442432, false);
                this.setInteger(29077, -1);
                this.setBoolean(1309147392, false);
                this.setInteger(-1625816832, -1);
                this.setBoolean(-1870331904, false);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 64: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setBoolean(967442432, false);
                this.setInteger(29077, -1);
                this.setBoolean(1309147392, false);
                this.setInteger(-1625816832, -1);
                this.setBoolean(-1870331904, false);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 65: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setBoolean(967442432, false);
                this.setInteger(29077, -1);
                this.setBoolean(1309147392, false);
                this.setInteger(-1625816832, -1);
                this.setBoolean(-1870331904, false);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 66: {
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 67: {
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 68: {
                this.setBoolean(967442432, true);
                this.setBoolean(1309147392, true);
                this.setBoolean(-1870331904, true);
                break;
            }
            case 69: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setBoolean(967442432, false);
                this.setBoolean(1309147392, false);
                this.setBoolean(-1870331904, false);
                this.setInteger(29077, -1);
                this.setInteger(32302, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 70: {
                this.setInteger(29077, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 71: {
                this.setInteger(29077, -1);
                this.setInteger(-1625816832, -1);
                this.setInteger(32302, -1);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 72: {
                this.setInteger(1255211008, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1255211008));
                this.triggerObserver(1215765312, eventGeneric);
                break;
            }
            case 73: {
                this.setInteger(-1978990336, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1978990336));
                this.triggerObserver(1198988096, eventGeneric);
                break;
            }
            case 74: {
                this.setInteger(31196, 1);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1566608713);
                break;
            }
            case 75: {
                this.setInteger(31196, 2);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1566608713);
                break;
            }
            case 76: {
                this.setInteger(0x10F0100, 1);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1298173257);
                break;
            }
            case 77: {
                this.setInteger(0x10F0100, 2);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1298173257);
                break;
            }
            case 78: {
                this.setInteger(22807, 1);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 79: {
                this.setInteger(22807, 3);
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 80: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1667272009);
                break;
            }
            case 81: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1667272009);
                break;
            }
            case 82: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 1281396041);
                this.setInteger(29840, 0);
                this.setInteger(32204, 0);
                break;
            }
            case 83: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1889628855);
                break;
            }
            case 84: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2057401015);
                break;
            }
            case 85: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2124509879);
                break;
            }
            case 86: {
                this.setInteger(-943587328, 0);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 87: {
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 88: {
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, 0);
                this.setInteger(14308, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 89: {
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 90: {
                if (!this.getBoolean(1636761600)) {
                    this.setInteger(1326645504, 0);
                }
                if (this.getBoolean(1636761600)) {
                    this.setInteger(1326645504, 1);
                }
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1326645504));
                this.triggerObserver(-368836544, eventGeneric);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 91: {
                this.setInteger(10845, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10845));
                this.triggerObserver(1443364928, eventGeneric);
                break;
            }
            case 92: {
                this.setInteger(10667, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(10667));
                this.triggerObserver(1316428608, eventGeneric);
                break;
            }
            case 93: {
                this.triggerObserver(33882176);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 94: {
                this.setInteger(287703296, SoundActivity.evIntegerValueValue());
                this.setInteger(-1332281344, this.getLicValue(3529, 1, 0, 0));
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(287703296));
                eventGeneric.setInt(1, this.getInteger(-1332281344));
                this.triggerObserver(-586612672, eventGeneric);
                break;
            }
            case 95: {
                this.setInteger(23278, 7);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                break;
            }
            case 96: {
                if (!this.getBoolean(1090978048)) {
                    this.setInteger(15736, 0);
                }
                if (this.getBoolean(1090978048)) {
                    this.setInteger(15736, 1);
                }
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(15736));
                this.triggerObserver(1266096960, eventGeneric);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 97: {
                if (!this.getBoolean(1121058816)) {
                    this.setInteger(1589444608, 0);
                }
                if (this.getBoolean(1121058816)) {
                    this.setInteger(1589444608, 1);
                }
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1589444608));
                this.triggerObserver(1098324800, eventGeneric);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 98: {
                this.setInteger(0x30FF0000, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(0x30FF0000));
                this.triggerObserver(1148656448, eventGeneric);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 99: {
                this.setInteger(29436, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(29436));
                this.triggerObserver(1165433664, eventGeneric);
                break;
            }
            case 100: {
                this.setInteger(-1109590016, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1109590016));
                this.triggerObserver(1131879232, eventGeneric);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 101: {
                this.setInteger(23278, 8);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                break;
            }
            case 102: {
                this.setInteger(14308, -1);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 103: {
                this.setInteger(14308, 0);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 104: {
                this.setInteger(-943587328, -1);
                this.setInteger(14308, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 105: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.setInteger(22221, -1);
                this.setInteger(29077, -1);
                this.setBoolean(11087, false);
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 106: {
                this.triggerObserver(1299651392);
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 107: {
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.handleGlobalAction(58);
                break;
            }
            case 108: {
                this.setInteger(-943587328, -1);
                this.setInteger(1407254528, -1);
                this.setInteger(14308, -1);
                this.handleGlobalAction(59);
                break;
            }
            case 109: {
                if (this.getInteger(29077) != 0) {
                    this.setInteger(29077, 0);
                }
                this.setInteger(32080, 9);
                this.setInteger(19412, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32080));
                eventGeneric.setInt(1, this.getInteger(19412));
                this.triggerObserver(0x4050040, eventGeneric);
                break;
            }
            case 110: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.handleGlobalAction(59);
                break;
            }
            case 111: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.handleGlobalAction(59);
                break;
            }
            case 112: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.handleGlobalAction(59);
                break;
            }
            case 113: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, 577342793);
                this.handleGlobalAction(59);
                break;
            }
            case 114: {
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 115: {
                this.setInteger(149880832, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(149880832));
                this.triggerObserver(-352059328, eventGeneric);
                break;
            }
            case 116: {
                this.setInteger(23278, 3);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 117: {
                this.setInteger(23278, 2);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 118: {
                this.setInteger(23278, 1);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 119: {
                this.setInteger(23278, 7);
                this.setInteger(13393, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 120: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 121: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 122: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 123: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 124: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 125: {
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 57118025);
                break;
            }
            case 126: {
                this.setInteger(23278, 3);
                this.setInteger(13393, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 2);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 1);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 7);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(243531776, 0);
                this.setInteger(890175744, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                this.setInteger(243531776, 1);
                this.setInteger(890175744, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                this.setInteger(243531776, 2);
                this.setInteger(890175744, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                this.setInteger(243531776, 3);
                this.setInteger(890175744, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                this.setInteger(243531776, 4);
                this.setInteger(890175744, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                break;
            }
            case 127: {
                this.setInteger(23278, 3);
                this.setInteger(13393, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 2);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 1);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(23278, 7);
                this.setInteger(13393, 0);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23278));
                eventGeneric.setInt(1, this.getInteger(13393));
                this.triggerObserver(50659392, eventGeneric);
                this.setInteger(29126, 1);
                eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(29126));
                this.triggerObserver(1258946624, eventGeneric);
                break;
            }
            case 128: {
                this.setInteger(202309888, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(202309888));
                this.triggerObserver(1577648192, eventGeneric);
                break;
            }
            case 129: {
                this.setInteger(202309888, 2);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(202309888));
                this.triggerObserver(1577648192, eventGeneric);
                break;
            }
            case 130: {
                this.setInteger(202309888, 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(202309888));
                this.triggerObserver(1577648192, eventGeneric);
                break;
            }
            case 131: {
                this.setInteger(202309888, 3);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(202309888));
                this.triggerObserver(1577648192, eventGeneric);
                break;
            }
            case 132: {
                this.setInteger(29126, SoundActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(29126));
                this.triggerObserver(1258946624, eventGeneric);
                break;
            }
            case 133: {
                this.setInteger(-2018574336, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-2018574336));
                this.triggerObserver(1249319744, eventGeneric);
                break;
            }
            case 134: {
                this.setInteger(-2018574336, 3);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-2018574336));
                this.triggerObserver(1249319744, eventGeneric);
                break;
            }
            case 135: {
                this.setInteger(-2018574336, 2);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-2018574336));
                this.triggerObserver(1249319744, eventGeneric);
                break;
            }
            case 136: {
                this.setInteger(-2018574336, 1);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-2018574336));
                this.triggerObserver(1249319744, eventGeneric);
                break;
            }
            case 137: {
                this.setInteger(-1846018048, SoundActivity.evListItemActionIndex());
                this.setBoolean(537198848, true);
                break;
            }
            case 138: {
                this.setInteger(243531776, this.getInteger(-1846018048));
                this.setInteger(890175744, SoundActivity.evIntegerValueValue());
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(243531776));
                eventGeneric.setInt(1, this.getInteger(890175744));
                this.triggerObserver(-167509952, eventGeneric);
                break;
            }
            case 139: {
                this.setBoolean(10948, true);
                this.setBoolean(22149, false);
                this.setBoolean(-14810880, false);
                this.setBoolean(10041, false);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 140: {
                this.setBoolean(10948, false);
                this.setBoolean(22149, true);
                this.setBoolean(-14810880, false);
                this.setBoolean(10041, false);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 141: {
                this.setBoolean(10948, false);
                this.setBoolean(22149, false);
                this.setBoolean(-14810880, true);
                this.setBoolean(10041, false);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 142: {
                this.setBoolean(10948, false);
                this.setBoolean(22149, false);
                this.setBoolean(-14810880, false);
                this.setBoolean(10041, true);
                SoundActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1435988663);
                break;
            }
            case 143: {
                this.setInteger(29126, 0);
                EventGeneric eventGeneric = SoundActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(29126));
                this.triggerObserver(1258946624, eventGeneric);
                break;
            }
            case 144: {
                this.setBoolean(10948, false);
                this.setBoolean(22149, false);
                this.setBoolean(-14810880, false);
                this.setBoolean(10041, false);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticToneSetupDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticToneSetupDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticToneSetupDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 4: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 5: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 6: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 7: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 8: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 9: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 10: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticToneSetupDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                return this.getBoolean(19517);
            }
            case 7: {
                return this.getInteger(29840) == 4 || this.getInteger(32204) == 2;
            }
            case 8: {
                return this.getInteger(32204) == 1;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticToneSetupDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                SoundActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPromptingSoundDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SoundActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 3: {
                SoundActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 2);
                break;
            }
            case 8: {
                SoundActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 0);
                SoundActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 9: {
                SoundActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 1);
                SoundActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 10: {
                SoundActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubPromptingSoundDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                SoundActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 8: {
                SoundActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 9: {
                SoundActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubPromptingSoundDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                return this.getBoolean(11087) && this.getInteger(29077) != -1 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(11087) && this.getInteger(30932) > this.getLicValue(1524, 0, 0, 0) && (this.getInteger(32302) != -1 || this.getInteger(29077) != -1);
            }
            case 3: {
                return this.getBoolean(11087) && this.getInteger(32302) != -1;
            }
        }
        return true;
    }

    private boolean evalUntriggeredTransitionGuard_SubPromptingSoundDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 2: {
                return this.getInteger(149880832) == 5;
            }
        }
        return true;
    }
}

