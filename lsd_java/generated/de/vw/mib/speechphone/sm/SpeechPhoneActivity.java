/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechphone.sm;

import de.vw.mib.datapool.FormatterService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpeechPhoneActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SpeechPhoneActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 49: {
                this.performStateEntryAction_SubHapticSpeechPhoneDynState(n, bl);
                break;
            }
            case 79: {
                this.performStateEntryAction_SubSpeechPhoneDialogDynState(n, bl);
                break;
            }
            case 706: {
                this.performStateEntryAction_SubISpeechPhoneIncludeNoExamplesView(n, bl);
                break;
            }
            case 80: {
                this.performStateEntryAction_SubSpeechPhoneGlobalDynState(n, bl);
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
            case 49: {
                this.performStateExitAction_SubHapticSpeechPhoneDynState(n);
                break;
            }
            case 79: {
                this.performStateExitAction_SubSpeechPhoneDialogDynState(n);
                break;
            }
            case 706: {
                this.performStateExitAction_SubISpeechPhoneIncludeNoExamplesView(n);
                break;
            }
            case 80: {
                this.performStateExitAction_SubSpeechPhoneGlobalDynState(n);
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
            case 49: {
                this.performInternalTransitionAction_SubHapticSpeechPhoneDynState(n);
                break;
            }
            case 79: {
                this.performInternalTransitionAction_SubSpeechPhoneDialogDynState(n);
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
            case 79: {
                return this.evalTriggeredTransitionGuard_SubSpeechPhoneDialogDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 79: {
                this.performTriggeredTransitionAction_SubSpeechPhoneDialogDynState(n);
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
            case 49: {
                return this.evalUntriggeredTransitionGuard_SubHapticSpeechPhoneDynState(n);
            }
            case 79: {
                return this.evalUntriggeredTransitionGuard_SubSpeechPhoneDialogDynState(n);
            }
            case 706: {
                return this.evalUntriggeredTransitionGuard_SubISpeechPhoneIncludeNoExamplesView(n);
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

    private void performStateEntryAction_SubHapticSpeechPhoneDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.showView("She", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Shi", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.showView("Shr", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 9: {
                this.showView("Shs_D9C3", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 10: {
                this.showView("Srs", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 11: {
                this.showView("Sc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 12: {
                this.showView("Scn", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 13: {
                this.showView("Sdc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 14: {
                this.showView("Sdn", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 15: {
                this.showView("Shc_AC25", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 16: {
                this.showView("Shc_80F4", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 17: {
                this.showView("Shm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 18: {
                this.showView("Shn", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 19: {
                this.showView("Shs_17CD", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 20: {
                this.showView("Sm_02B1", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 21: {
                this.showView("Snc_CF6A", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 22: {
                this.showView("Snc_2549", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 23: {
                this.showView("Sne", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSpeechPhoneDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("She");
                break;
            }
            case 7: {
                this.hideView("Shi");
                break;
            }
            case 8: {
                this.hideView("Shr");
                break;
            }
            case 9: {
                this.hideView("Shs_D9C3");
                break;
            }
            case 10: {
                this.hideView("Srs");
                break;
            }
            case 11: {
                this.hideView("Sc");
                break;
            }
            case 12: {
                this.hideView("Scn");
                break;
            }
            case 13: {
                this.hideView("Sdc");
                break;
            }
            case 14: {
                this.hideView("Sdn");
                break;
            }
            case 15: {
                this.hideView("Shc_AC25");
                break;
            }
            case 16: {
                this.hideView("Shc_80F4");
                break;
            }
            case 17: {
                this.hideView("Shm");
                break;
            }
            case 18: {
                this.hideView("Shn");
                break;
            }
            case 19: {
                this.hideView("Shs_17CD");
                break;
            }
            case 20: {
                this.hideView("Sm_02B1");
                break;
            }
            case 21: {
                this.hideView("Snc_CF6A");
                break;
            }
            case 22: {
                this.hideView("Snc_2549");
                break;
            }
            case 23: {
                this.hideView("Sne");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticSpeechPhoneDynState(int n) {
        this.performInternalTransitionAction_SubHapticSpeechPhoneDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticSpeechPhoneDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                if (this.getInteger(27480) == 1) {
                    this.setInteger(787152896, 0);
                }
                if (this.getInteger(27480) == 2) {
                    this.setInteger(787152896, 1);
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 1: {
                if (!this.getBoolean(22334)) {
                    if (!this.getBoolean(13507) && this.getInteger(27480) == 1) {
                        this.setString(-587661312, this.getString(1872429056));
                    }
                    if (this.getBoolean(13507) && this.getInteger(27480) == 1) {
                        this.setString(-587661312, this.getI18nString(5915));
                    }
                    if (this.getInteger(27480) == 2) {
                        this.setString(-587661312, this.getI18nString(5916));
                    }
                }
                if (!this.getBoolean(22334)) break;
                if (!this.getBoolean(13507) && this.getInteger(27480) == 1) {
                    this.setString(-587661312, this.getString(1872429056));
                }
                if (this.getBoolean(13507) && this.getInteger(27480) == 1) {
                    this.setString(-587661312, this.getI18nString(5913));
                }
                if (this.getInteger(27480) != 2) break;
                this.setString(-587661312, this.getI18nString(5914));
                break;
            }
            case 3: {
                this.triggerObserver(-1568523456);
                break;
            }
            case 4: {
                this.triggerObserver(2005023552);
                break;
            }
            case 5: {
                this.setBoolean(13507, true);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 6: {
                this.setBoolean(13507, false);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 7: {
                if (!this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5968));
                }
                if (this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5972));
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 8: {
                if (!this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5987));
                }
                if (this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5988));
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 9: {
                if (!this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5994));
                }
                if (this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(5996));
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 10: {
                if (!this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(6024));
                }
                if (this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(6025));
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
            case 11: {
                if (!this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(6030));
                }
                if (this.getBoolean(22334)) {
                    this.setString(1872429056, this.getI18nString(6031));
                }
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticSpeechPhoneDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(19918) == 1;
            }
            case 1: {
                return this.getInteger(19918) == 2 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getInteger(19918) == 3 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 3: {
                return this.getInteger(19918) == 4 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getInteger(19918) == 5 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getInteger(19918) == 6;
            }
            case 6: {
                return this.getInteger(19918) == 7 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 7: {
                return this.getInteger(19918) == 9 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 8: {
                return this.getInteger(19918) == 10 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 9: {
                return this.getInteger(19918) == 11 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 10: {
                return this.getInteger(19918) == 12 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 11: {
                return this.getInteger(19918) == 13 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 12: {
                return this.getInteger(19918) == 14;
            }
            case 13: {
                return this.getInteger(19918) == 15;
            }
            case 14: {
                return this.getInteger(19918) == 16 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 15: {
                return this.getInteger(19918) == 17 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 16: {
                return this.getInteger(19918) == 18 && this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechPhoneDialogDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 420);
                break;
            }
            case 6: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 421);
                break;
            }
            case 7: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 422);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 8: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 423);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 9: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 424);
                break;
            }
            case 10: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 425);
                break;
            }
            case 13: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 426);
                break;
            }
            case 16: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 427);
                break;
            }
            case 17: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 428);
                this.setInteger(19918, 9);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 18: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 429);
                this.setInteger(19918, 9);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 19: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 514);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 20: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 430);
                this.setInteger(19918, 9);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 21: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 431);
                this.setInteger(19918, 9);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 22: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 432);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 23: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 433);
                this.setInteger(19918, 10);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 24: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 434);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 25: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 435);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 26: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 515);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 27: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 531);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 28: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 436);
                this.setInteger(19918, 13);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 29: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 439);
                break;
            }
            case 30: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 437);
                this.setBoolean(26809, this.getBoolean(-654901248));
                this.setBoolean(22462, this.getBoolean(-654901248));
                this.setBoolean(22462, !this.getBoolean(22462));
                this.setString(31151, FormatterService.format(this.getI18nString(5940), this.getI18nStrings(302)[this.getLicValue(-1918289152, 1, 0, 0)]));
                this.setString(31148, this.getI18nString(5928));
                this.setInteger(19918, 12);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 31: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 516);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 32: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 438);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 33: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 440);
                this.setBoolean(26809, true);
                this.setBoolean(22462, false);
                this.setString(31151, this.getI18nString(5925));
                this.setString(31148, this.getI18nString(5928));
                this.setInteger(19918, 12);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 34: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 441);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 35: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 442);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 36: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 443);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 37: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 517);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 38: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 462);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 39: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 444);
                this.setBoolean(26809, this.getBoolean(-654901248));
                this.setBoolean(22462, this.getBoolean(-654901248));
                this.setBoolean(22462, !this.getBoolean(22462));
                this.setString(31151, FormatterService.format(this.getI18nString(5940), this.getI18nStrings(302)[this.getLicValue(-1918289152, 1, 0, 0)]));
                this.setString(31148, this.getI18nString(5928));
                this.setInteger(19918, 12);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 40: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 445);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 41: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 518);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 42: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 446);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 43: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 447);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 44: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 466);
                this.setBoolean(26809, true);
                this.setBoolean(22462, false);
                this.setString(31151, this.getI18nString(5925));
                this.setString(31148, this.getI18nString(5922));
                this.setInteger(19918, 12);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 45: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 519);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 46: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 467);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 47: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 468);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 48: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 469);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 49: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 463);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 50: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 448);
                break;
            }
            case 51: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 449);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 52: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 451);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 53: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 450);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 54: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 452);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 55: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 471);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 56: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 470);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 57: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 453);
                break;
            }
            case 58: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 454);
                break;
            }
            case 61: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 455);
                break;
            }
            case 64: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 456);
                break;
            }
            case 67: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 457);
                break;
            }
            case 70: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 458);
                break;
            }
            case 73: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 465);
                break;
            }
            case 76: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 464);
                break;
            }
            case 79: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 474);
                this.setInteger(19918, 7);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 80: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 477);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 81: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 513);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 82: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 480);
                break;
            }
            case 83: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 479);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 84: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 475);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 85: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 476);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 86: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 478);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 87: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 481);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 88: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 483);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 89: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 482);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 90: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 484);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 91: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 485);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 92: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 487);
                break;
            }
            case 95: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 494);
                break;
            }
            case 98: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 493);
                this.setString(1872429056, this.getI18nString(5968));
                this.setInteger(19918, 4);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 99: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 491);
                this.setString(1872429056, this.getI18nString(5968));
                this.setInteger(19918, 4);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 100: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 498);
                break;
            }
            case 103: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 497);
                this.setString(1872429056, this.getI18nString(5987));
                this.setInteger(19918, 2);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 104: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 495);
                this.setString(1872429056, this.getI18nString(5987));
                this.setInteger(19918, 2);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 105: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 488);
                this.setInteger(19918, 16);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 106: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 489);
                this.setInteger(19918, 18);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 107: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 502);
                break;
            }
            case 110: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 501);
                this.setString(1872429056, this.getI18nString(5994));
                this.setInteger(19918, 5);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 111: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 499);
                this.setString(1872429056, this.getI18nString(5994));
                this.setInteger(19918, 5);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 112: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 506);
                break;
            }
            case 115: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 505);
                this.setString(1872429056, this.getI18nString(6024));
                this.setInteger(19918, 3);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 116: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 503);
                this.setString(1872429056, this.getI18nString(6024));
                this.setInteger(19918, 3);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 117: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 510);
                break;
            }
            case 120: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 509);
                this.setString(1872429056, this.getI18nString(6030));
                this.setInteger(19918, 6);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 121: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 507);
                this.setString(1872429056, this.getI18nString(6030));
                this.setInteger(19918, 6);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 122: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 511);
                this.setInteger(19918, 15);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 123: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 490);
                this.setInteger(19918, 17);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 124: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 523);
                break;
            }
            case 125: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 522);
                this.setString(1872429056, this.getI18nString(6018));
                this.setInteger(19918, 1);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 126: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 521);
                this.setString(1872429056, this.getI18nString(6018));
                this.setInteger(19918, 1);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 127: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 524);
                this.setInteger(19918, 14);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 128: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 525);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 129: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 527);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 130: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 528);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 131: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 526);
                break;
            }
            case 132: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 529);
                break;
            }
            case 135: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 530);
                break;
            }
            case 138: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 459);
                this.setInteger(19918, 11);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                break;
            }
            case 139: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 460);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 140: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 461);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 141: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 520);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 142: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 532);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 143: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 533);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 144: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 535);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 145: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 536);
                break;
            }
            case 150: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 537);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 151: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 539);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 152: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 538);
                break;
            }
            case 155: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 540);
                break;
            }
            case 158: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 541);
                break;
            }
            case 161: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 542);
                break;
            }
            case 162: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 472);
                break;
            }
            case 165: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 473);
                break;
            }
            case 168: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 486);
                break;
            }
            case 171: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 546);
                break;
            }
            case 174: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 545);
                this.setString(1872429056, this.getI18nString(5972));
                this.setInteger(19918, 4);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 175: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 492);
                this.setString(1872429056, this.getI18nString(5972));
                this.setInteger(19918, 4);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 176: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 548);
                break;
            }
            case 179: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 547);
                this.setString(1872429056, this.getI18nString(5988));
                this.setInteger(19918, 2);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 180: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 496);
                this.setString(1872429056, this.getI18nString(5988));
                this.setInteger(19918, 2);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 181: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 550);
                break;
            }
            case 184: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 549);
                this.setString(1872429056, this.getI18nString(5996));
                this.setInteger(19918, 5);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 185: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 500);
                this.setString(1872429056, this.getI18nString(5996));
                this.setInteger(19918, 5);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 186: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 552);
                break;
            }
            case 189: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 551);
                this.setString(1872429056, this.getI18nString(6025));
                this.setInteger(19918, 3);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 190: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 504);
                this.setString(1872429056, this.getI18nString(6025));
                this.setInteger(19918, 3);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 191: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 554);
                break;
            }
            case 194: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 553);
                this.setString(1872429056, this.getI18nString(6031));
                this.setInteger(19918, 6);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 195: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 508);
                this.setString(1872429056, this.getI18nString(6031));
                this.setInteger(19918, 6);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1667337545);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 212: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 512);
                this.setInteger(19918, 0);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1650560329);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 213: {
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechPhoneDialogDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 6: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 7: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 8: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 9: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 10: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 13: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 16: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 17: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 18: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 19: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 20: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 21: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 22: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 23: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 24: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 25: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 26: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 27: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 28: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 29: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 30: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 31: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 32: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 33: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 34: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 35: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 36: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 37: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 38: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 39: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 40: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 41: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 42: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 43: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 44: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 45: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 46: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 47: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 48: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 49: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 50: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 51: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 52: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 53: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 54: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 55: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 56: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 57: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 58: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 61: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 64: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 67: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 70: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 73: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 76: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 79: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 80: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 81: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 82: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 83: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 84: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 85: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 86: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 87: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 88: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 89: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 90: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 91: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 92: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 95: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 98: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 99: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 100: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 103: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 104: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 105: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 106: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 107: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 110: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 111: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 112: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 115: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 116: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 117: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 120: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 121: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 122: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 123: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 124: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 125: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 126: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 127: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 128: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 129: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 130: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 131: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 132: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 135: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 138: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 139: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 140: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 141: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 142: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 143: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 144: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 145: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 150: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 151: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 152: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 155: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 158: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 161: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 162: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 165: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 168: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 171: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 174: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 175: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 176: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 179: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 180: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 181: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 184: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 185: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 186: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 189: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 190: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 191: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 194: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 195: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 212: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubSpeechPhoneDialogDynState(int n) {
        this.performInternalTransitionAction_SubSpeechPhoneDialogDynState00(n);
    }

    private void performInternalTransitionAction_SubSpeechPhoneDialogDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(11738, 0);
                SpeechPhoneActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 1: {
                this.setInteger(11738, 1);
                SpeechPhoneActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 2: {
                this.setInteger(11738, 2);
                SpeechPhoneActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 3: {
                this.triggerObserver(1870805824);
                break;
            }
            case 4: {
                this.triggerObserver(2021800768);
                break;
            }
            case 5: {
                this.triggerObserver(2038577984);
                break;
            }
            case 6: {
                this.triggerObserver(2055355200);
                break;
            }
            case 7: {
                this.setInteger(17659, 0);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 8: {
                this.setInteger(17659, 1);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 9: {
                this.setInteger(17659, 2);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 10: {
                this.setInteger(17659, 3);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 11: {
                this.setInteger(17659, 4);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 12: {
                this.setInteger(17659, 5);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 13: {
                this.setInteger(17659, 6);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 14: {
                this.setInteger(17659, 7);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 15: {
                this.setInteger(17659, 8);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1969720649);
                break;
            }
            case 16: {
                this.setBoolean(102170880, true);
                this.setInteger(-1037631232, this.getInteger(615907328));
                this.setInteger(-1037631232, this.getInteger(-1037631232) - 1);
                SpeechPhoneActivity.fireIntegerValueEvent(this.fromMe(), this.meSelf(), 1852280137, this.getInteger(-1037631232));
                break;
            }
            case 17: {
                this.setBoolean(102170880, false);
                break;
            }
            case 18: {
                this.setInteger(1974534144, SpeechPhoneActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SpeechPhoneActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1974534144));
                this.triggerObserver(-1870513344, eventGeneric);
                break;
            }
            case 19: {
                this.setInteger(21173, SpeechPhoneActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SpeechPhoneActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21173));
                this.triggerObserver(-1853736128, eventGeneric);
                break;
            }
            case 20: {
                this.triggerObserver(-1551746240);
                break;
            }
            case 21: {
                this.triggerObserver(-1669186752);
                break;
            }
            case 22: {
                this.triggerObserver(-1769850048);
                break;
            }
            case 23: {
                this.triggerObserver(-2138948800);
                break;
            }
            case 24: {
                this.triggerObserver(-2105394368);
                break;
            }
            case 25: {
                this.triggerObserver(1921137472);
                break;
            }
            case 26: {
                this.triggerObserver(1954691904);
                break;
            }
            case 27: {
                this.triggerObserver(1937914688);
                break;
            }
            case 28: {
                this.triggerObserver(1887583040);
                break;
            }
            case 29: {
                this.triggerObserver(2072132416);
                break;
            }
            case 30: {
                this.triggerObserver(-1585300672);
                break;
            }
            case 31: {
                this.setInteger(11738, 0);
                SpeechPhoneActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 32: {
                this.setInteger(11738, 0);
                SpeechPhoneActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 33: {
                this.triggerObserver(-1669186752);
                break;
            }
            case 34: {
                this.triggerObserver(-1685963968);
                break;
            }
            case 35: {
                this.triggerObserver(2072132416);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubSpeechPhoneDialogDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 2: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 4: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 5: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 7: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 8: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 9: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 10: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 12: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 14: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 15: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 16: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 17: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 19: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 20: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 21: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 22: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 23: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 24: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 25: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 26: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 27: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 28: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 29: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 30: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 32: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 33: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 34: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 35: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 36: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 37: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 38: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 39: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 40: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 41: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 42: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 43: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 44: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 45: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 46: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 47: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 48: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 51: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 52: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 53: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 54: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 56: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 57: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 58: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 59: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 61: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 62: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 63: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 64: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 66: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 68: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 69: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 70: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 71: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 72: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 73: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 74: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 75: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 76: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 77: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 78: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 79: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 80: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 81: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 82: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 83: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 84: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 85: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 86: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 87: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 109: {
                return this.getInteger(17659) == 8;
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubSpeechPhoneDialogDynState(int n) {
        this.performTriggeredTransitionAction_SubSpeechPhoneDialogDynState00(n);
    }

    private void performTriggeredTransitionAction_SubSpeechPhoneDialogDynState00(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setBoolean(27957, true);
                break;
            }
            case 5: {
                this.setString(-928251904, FormatterService.format(this.getI18nString(5941), this.getLicValue(-1985398016, 2, 0, "")));
                break;
            }
            case 6: {
                this.setString(-928251904, FormatterService.format((CharSequence)this.getI18nString(5945), this.getI18nStrings(301)[this.getInteger(2147090432)], this.getLicValue(-1985398016, 2, 0, "")));
                break;
            }
            case 7: {
                this.setString(-928251904, FormatterService.format(this.getI18nString(5944), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getInteger(2147090432)], Integer.toString(this.getInteger(22167))));
                break;
            }
            case 20: {
                this.setString(-928251904, FormatterService.format((CharSequence)this.getI18nString(5943), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getInteger(2147090432)]));
                break;
            }
            case 23: {
                this.setString(-928251904, FormatterService.format(this.getI18nString(5942), this.getLicValue(-1985398016, 2, 0, "")));
                break;
            }
            case 26: {
                this.setString(-928251904, FormatterService.format((CharSequence)this.getI18nString(5943), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getInteger(2147090432)]));
                break;
            }
            case 28: {
                this.setString(-928251904, FormatterService.format((CharSequence)this.getI18nString(5946), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getLicValue(-1985398016, 6, 0, 0)]));
                break;
            }
            case 31: {
                this.setString(-928251904, FormatterService.format(this.getI18nString(5941), this.getLicValue(-1985398016, 2, 0, "")));
                break;
            }
            case 35: {
                this.setString(-928251904, FormatterService.format(this.getI18nString(5941), this.getLicValue(-1985398016, 2, 0, "")));
                break;
            }
            case 42: {
                this.setBoolean(27957, false);
                break;
            }
            case 46: {
                this.setString(-928251904, FormatterService.format((CharSequence)this.getI18nString(5946), this.getLicValue(-1985398016, 2, 0, ""), this.getI18nStrings(301)[this.getLicValue(-1985398016, 6, 0, 0)]));
                break;
            }
            case 69: {
                this.setBoolean(102170880, true);
                break;
            }
            case 71: {
                this.setBoolean(21570, true);
                break;
            }
            case 72: {
                this.setBoolean(21570, false);
                break;
            }
            case 73: {
                this.setBoolean(21570, false);
                break;
            }
            case 75: {
                this.setBoolean(21570, false);
                break;
            }
            case 78: {
                this.setBoolean(21570, true);
                break;
            }
            case 80: {
                this.setBoolean(21570, true);
                break;
            }
            case 82: {
                this.setBoolean(21570, false);
                break;
            }
            case 87: {
                this.setBoolean(21570, true);
                break;
            }
            case 100: {
                this.setBoolean(-107544576, true);
                break;
            }
            case 101: {
                this.setBoolean(-107544576, false);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubSpeechPhoneDialogDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 12: {
                return this.getInteger(787152896) == 0;
            }
            case 15: {
                return this.getInteger(787152896) == 0;
            }
            case 18: {
                return this.getInteger(787152896) == 0;
            }
            case 21: {
                return this.getInteger(787152896) == 0;
            }
            case 24: {
                return this.getInteger(787152896) == 0;
            }
            case 36: {
                return this.getInteger(787152896) == 0;
            }
            case 39: {
                return this.getInteger(787152896) == 0;
            }
            case 42: {
                return this.getInteger(787152896) == 0;
            }
            case 45: {
                return this.getInteger(787152896) == 0;
            }
            case 48: {
                return this.getInteger(787152896) == 0;
            }
            case 51: {
                return this.getBoolean(22334);
            }
            case 53: {
                return this.getBoolean(22334);
            }
            case 55: {
                return this.getBoolean(22334);
            }
            case 57: {
                return this.getBoolean(22334);
            }
            case 59: {
                return this.getBoolean(22334);
            }
            case 61: {
                return this.getBoolean(22334);
            }
            case 63: {
                return this.getBoolean(22334);
            }
            case 65: {
                return this.getBoolean(22334);
            }
            case 67: {
                return this.getBoolean(22334);
            }
            case 69: {
                return this.getBoolean(22334);
            }
            case 71: {
                return this.getBoolean(22334);
            }
            case 73: {
                return this.getBoolean(22334);
            }
            case 75: {
                return this.getBoolean(22334);
            }
            case 77: {
                return this.getBoolean(22334);
            }
            case 79: {
                return this.getBoolean(22334);
            }
            case 81: {
                return this.getBoolean(22334);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubISpeechPhoneIncludeNoExamplesView(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 4: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 534);
                SpeechPhoneActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1633783113);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubISpeechPhoneIncludeNoExamplesView(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubISpeechPhoneIncludeNoExamplesView(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(19918) == 0;
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechPhoneGlobalDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 543);
                break;
            }
            case 4: {
                SpeechPhoneActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 544);
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 5: {
                SpeechPhoneActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechPhoneGlobalDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 4: {
                SpeechPhoneActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }
}

