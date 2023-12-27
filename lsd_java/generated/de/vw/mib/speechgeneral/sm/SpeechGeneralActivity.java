/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechgeneral.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpeechGeneralActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SpeechGeneralActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 570: {
                this.performStateEntryAction_SubPopupPoSdsDomainNotAvailableDynState(n, bl);
                break;
            }
            case 571: {
                this.performStateEntryAction_SubPopupPoSdsLanguageChangingDynState(n, bl);
                break;
            }
            case 572: {
                this.performStateEntryAction_SubPopupPoSdsLanguageNoSdsSupportDynState(n, bl);
                break;
            }
            case 573: {
                this.performStateEntryAction_SubPopupPoSdsNotAcquiredViaSwapDynState(n, bl);
                break;
            }
            case 45: {
                this.performStateEntryAction_SubHapticSpeechGeneralDynState(n, bl);
                break;
            }
            case 73: {
                this.performStateEntryAction_SubSpeechGeneralDialogDynState(n, bl);
                break;
            }
            case 703: {
                this.performStateEntryAction_SubISpeechGeneralIncludeNoExamplesView(n, bl);
                break;
            }
            case 74: {
                this.performStateEntryAction_SubSpeechGeneralGlobalDynState(n, bl);
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
            case 570: {
                this.performStateExitAction_SubPopupPoSdsDomainNotAvailableDynState(n);
                break;
            }
            case 571: {
                this.performStateExitAction_SubPopupPoSdsLanguageChangingDynState(n);
                break;
            }
            case 572: {
                this.performStateExitAction_SubPopupPoSdsLanguageNoSdsSupportDynState(n);
                break;
            }
            case 573: {
                this.performStateExitAction_SubPopupPoSdsNotAcquiredViaSwapDynState(n);
                break;
            }
            case 45: {
                this.performStateExitAction_SubHapticSpeechGeneralDynState(n);
                break;
            }
            case 73: {
                this.performStateExitAction_SubSpeechGeneralDialogDynState(n);
                break;
            }
            case 703: {
                this.performStateExitAction_SubISpeechGeneralIncludeNoExamplesView(n);
                break;
            }
            case 74: {
                this.performStateExitAction_SubSpeechGeneralGlobalDynState(n);
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
            case 45: {
                this.performInternalTransitionAction_SubHapticSpeechGeneralDynState(n);
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
            case 45: {
                return this.evalUntriggeredTransitionGuard_SubHapticSpeechGeneralDynState(n);
            }
            case 73: {
                return this.evalUntriggeredTransitionGuard_SubSpeechGeneralDialogDynState(n);
            }
            case 703: {
                return this.evalUntriggeredTransitionGuard_SubISpeechGeneralIncludeNoExamplesView(n);
            }
            case 74: {
                return this.evalUntriggeredTransitionGuard_SubSpeechGeneralGlobalDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 74: {
                this.performUntriggeredTransitionAction_SubSpeechGeneralGlobalDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSdsDomainNotAvailableDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Psdna", 570, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSdsDomainNotAvailableDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SpeechGeneralActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Psdna");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSdsLanguageChangingDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pslc", 571, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSdsLanguageChangingDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SpeechGeneralActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pslc");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSdsLanguageNoSdsSupportDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pslnss", 572, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSdsLanguageNoSdsSupportDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SpeechGeneralActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pslnss");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoSdsNotAcquiredViaSwapDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Psnavs", 573, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoSdsNotAcquiredViaSwapDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                SpeechGeneralActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Psnavs");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticSpeechGeneralDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 1: {
                this.setInteger(16664, 1);
                break;
            }
            case 6: {
                this.showView("Sgmm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 7: {
                this.showView("Sgnv", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.showView("Sgtdc", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 9: {
                this.showView("Sgths", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 10: {
                this.showView("Sgtvb", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 11: {
                this.showView("Sgubt", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSpeechGeneralDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 6: {
                this.hideView("Sgmm");
                break;
            }
            case 7: {
                this.hideView("Sgnv");
                break;
            }
            case 8: {
                this.hideView("Sgtdc");
                break;
            }
            case 9: {
                this.hideView("Sgths");
                break;
            }
            case 10: {
                this.hideView("Sgtvb");
                break;
            }
            case 11: {
                this.hideView("Sgubt");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticSpeechGeneralDynState(int n) {
        this.performInternalTransitionAction_SubHapticSpeechGeneralDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticSpeechGeneralDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                if (!this.getBoolean(22334)) {
                    if (this.getInteger(16664) == 0 && this.getInteger(30104) == 0) {
                        this.setString(-587399168, this.getI18nString(5511));
                    }
                    if (this.getInteger(16664) == 1 && this.getInteger(30104) == 0) {
                        this.setString(-587399168, this.getString(-192610304));
                    }
                    if (this.getInteger(30104) == 1) {
                        this.setString(-587399168, this.getI18nString(5526));
                    }
                }
                if (!this.getBoolean(22334)) break;
                if (this.getInteger(16664) == 0 && this.getInteger(30104) == 0) {
                    this.setString(-587399168, this.getI18nString(5528));
                }
                if (this.getInteger(16664) == 1 && this.getInteger(30104) == 0) {
                    this.setString(-587399168, this.getString(-192610304));
                }
                if (this.getInteger(30104) != 1) break;
                this.setString(-587399168, this.getI18nString(5532));
                break;
            }
            case 1: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 2: {
                this.setInteger(16664, 0);
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 3: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                this.setInteger(16664, 1);
                break;
            }
            case 4: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 6: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                this.triggerObserver(416559168);
                break;
            }
            case 7: {
                this.triggerObserver(315895872);
                break;
            }
            case 8: {
                this.triggerObserver(500445248);
                break;
            }
            case 9: {
                this.triggerObserver(399781952);
                break;
            }
            case 10: {
                this.triggerObserver(366227520);
                break;
            }
            case 11: {
                this.triggerObserver(332673088);
                break;
            }
            case 12: {
                this.triggerObserver(349450304);
                break;
            }
            case 13: {
                this.triggerObserver(383004736);
                break;
            }
            case 14: {
                if (!this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5506));
                }
                if (this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5527));
                }
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 15: {
                if (!this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5512));
                }
                if (this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5529));
                }
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 16: {
                if (!this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5513));
                }
                if (this.getBoolean(22334)) {
                    this.setString(-192610304, this.getI18nString(5530));
                }
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1398902089);
                break;
            }
            case 17: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 385560576);
                break;
            }
            case 18: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 402337792);
                break;
            }
            case 19: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 419115008);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticSpeechGeneralDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(-1984036864) == 1;
            }
            case 1: {
                return this.getInteger(-1984036864) == 2;
            }
            case 2: {
                return this.getInteger(-1984036864) == 3;
            }
            case 3: {
                return this.getInteger(-1984036864) == 4;
            }
            case 4: {
                return this.getInteger(-1984036864) == 5;
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechGeneralDialogDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 11);
                break;
            }
            case 4: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 13);
                this.setInteger(-1984036864, 1);
                this.setString(-192610304, this.getI18nString(5516));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 5: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 15);
                break;
            }
            case 8: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 16);
                break;
            }
            case 11: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 17);
                break;
            }
            case 14: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 18);
                break;
            }
            case 17: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 19);
                break;
            }
            case 20: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 20);
                break;
            }
            case 23: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 21);
                break;
            }
            case 26: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 22);
                break;
            }
            case 29: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 23);
                break;
            }
            case 32: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 24);
                break;
            }
            case 35: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 25);
                break;
            }
            case 38: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 26);
                break;
            }
            case 41: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 27);
                break;
            }
            case 44: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 28);
                break;
            }
            case 47: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 32);
                this.setInteger(-1984036864, 3);
                this.setString(-192610304, this.getI18nString(5506));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 48: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 33);
                this.setInteger(-1984036864, 4);
                this.setString(-192610304, this.getI18nString(5512));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 49: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 34);
                this.setInteger(-1984036864, 3);
                this.setString(-192610304, this.getI18nString(5527));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 50: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 35);
                this.setInteger(-1984036864, 4);
                this.setString(-192610304, this.getI18nString(5529));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 51: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 36);
                this.setInteger(-1984036864, 5);
                this.setString(-192610304, this.getI18nString(5530));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 52: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 37);
                this.setInteger(-1984036864, 5);
                this.setString(-192610304, this.getI18nString(5513));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 53: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 12);
                this.setInteger(-1984036864, 0);
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1449233737);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 54: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 30);
                this.setInteger(-1984036864, 2);
                this.setString(-192610304, this.getI18nString(5523));
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                break;
            }
            case 55: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 29);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 56: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 31);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 60: {
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechGeneralDialogDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 4: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 5: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 8: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 11: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 14: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 17: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 20: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 23: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 26: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 29: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 32: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 35: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 38: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 41: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 44: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 47: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 48: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 49: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 50: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 51: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 52: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 53: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 54: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 55: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 56: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubSpeechGeneralDialogDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 16: {
                return this.getBoolean(22334);
            }
            case 18: {
                return this.getBoolean(22334);
            }
            case 20: {
                return this.getBoolean(22334);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubISpeechGeneralIncludeNoExamplesView(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 4: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 14);
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1432456521);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubISpeechGeneralIncludeNoExamplesView(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubISpeechGeneralIncludeNoExamplesView(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(-1984036864) == 0;
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechGeneralGlobalDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 40);
                break;
            }
            case 4: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 38);
                break;
            }
            case 6: {
                SpeechGeneralActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 39);
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 18: {
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 19: {
                SpeechGeneralActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechGeneralGlobalDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 4: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 6: {
                SpeechGeneralActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubSpeechGeneralGlobalDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                return this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 6: {
                return !this.getBoolean(0x7A00000) && this.getBoolean(10059);
            }
            case 10: {
                return !this.getBoolean(10059);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubSpeechGeneralGlobalDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 721104896);
                this.setInteger(27884, 0);
                EventGeneric eventGeneric = SpeechGeneralActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
            case 6: {
                SpeechGeneralActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 687550464);
                this.setInteger(27884, 0);
                EventGeneric eventGeneric = SpeechGeneralActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
            case 11: {
                this.setInteger(27884, 2);
                EventGeneric eventGeneric = SpeechGeneralActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
        }
    }
}

