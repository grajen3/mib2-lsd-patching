/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.speechmedia.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SpeechMediaActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SpeechMediaActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 47: {
                this.performStateEntryAction_SubHapticSpeechMediaDynState(n, bl);
                break;
            }
            case 75: {
                this.performStateEntryAction_SubSpeechMediaDialogDynState(n, bl);
                break;
            }
            case 704: {
                this.performStateEntryAction_SubISpeechMediaIncludeNoExamplesView(n, bl);
                break;
            }
            case 76: {
                this.performStateEntryAction_SubSpeechMediaGlobalDynState(n, bl);
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
            case 47: {
                this.performStateExitAction_SubHapticSpeechMediaDynState(n);
                break;
            }
            case 75: {
                this.performStateExitAction_SubSpeechMediaDialogDynState(n);
                break;
            }
            case 704: {
                this.performStateExitAction_SubISpeechMediaIncludeNoExamplesView(n);
                break;
            }
            case 76: {
                this.performStateExitAction_SubSpeechMediaGlobalDynState(n);
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
            case 47: {
                this.performInternalTransitionAction_SubHapticSpeechMediaDynState(n);
                break;
            }
            case 75: {
                this.performInternalTransitionAction_SubSpeechMediaDialogDynState(n);
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
            case 75: {
                this.performTriggeredTransitionAction_SubSpeechMediaDialogDynState(n);
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
            case 47: {
                return this.evalUntriggeredTransitionGuard_SubHapticSpeechMediaDynState(n);
            }
            case 75: {
                return this.evalUntriggeredTransitionGuard_SubSpeechMediaDialogDynState(n);
            }
            case 704: {
                return this.evalUntriggeredTransitionGuard_SubISpeechMediaIncludeNoExamplesView(n);
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

    private void performStateEntryAction_SubHapticSpeechMediaDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.showView("Smms", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 8: {
                this.showView("Smps", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 9: {
                this.showView("Smss", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 10: {
                this.showView("Smm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 11: {
                this.showView("Smdms", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 12: {
                this.showView("Smdmn", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 13: {
                this.showView("Smnv", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 14: {
                this.showView("Smdss", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSpeechMediaDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.hideView("Smms");
                break;
            }
            case 8: {
                this.hideView("Smps");
                break;
            }
            case 9: {
                this.hideView("Smss");
                break;
            }
            case 10: {
                this.hideView("Smm");
                break;
            }
            case 11: {
                this.hideView("Smdms");
                break;
            }
            case 12: {
                this.hideView("Smdmn");
                break;
            }
            case 13: {
                this.hideView("Smnv");
                break;
            }
            case 14: {
                this.hideView("Smdss");
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticSpeechMediaDynState(int n) {
        this.performInternalTransitionAction_SubHapticSpeechMediaDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticSpeechMediaDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-1520815552);
                break;
            }
            case 1: {
                if (!this.getBoolean(22334)) {
                    if (this.getBoolean(2146566144) && !this.getBoolean(1521745920)) {
                        this.setString(387776768, this.getString(28940));
                    }
                    if (!this.getBoolean(2146566144)) {
                        this.setString(387776768, this.getI18nString(5607));
                    }
                    if (this.getBoolean(2146566144) && this.getBoolean(1521745920)) {
                        this.setString(387776768, this.getI18nString(5587));
                    }
                }
                if (!this.getBoolean(22334)) break;
                if (this.getBoolean(2146566144) && !this.getBoolean(1521745920)) {
                    this.setString(387776768, this.getString(28940));
                }
                if (!this.getBoolean(2146566144)) {
                    this.setString(387776768, this.getI18nString(5612));
                }
                if (!this.getBoolean(2146566144) || !this.getBoolean(1521745920)) break;
                this.setString(387776768, this.getI18nString(5609));
                break;
            }
            case 2: {
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                break;
            }
            case 3: {
                this.setBoolean(1521745920, true);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                break;
            }
            case 4: {
                this.setBoolean(1521745920, false);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                break;
            }
            case 6: {
                this.triggerObserver(-916835776);
                break;
            }
            case 7: {
                if (!this.getBoolean(22334)) {
                    this.setString(28940, this.getI18nString(5590));
                }
                if (this.getBoolean(22334)) {
                    this.setString(28940, this.getI18nString(5610));
                }
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                break;
            }
            case 8: {
                if (!this.getBoolean(22334)) {
                    this.setString(28940, this.getI18nString(5605));
                }
                if (this.getBoolean(22334)) {
                    this.setString(28940, this.getI18nString(5611));
                }
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticSpeechMediaDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return this.getInteger(-108920832) == 4;
            }
            case 2: {
                return this.getInteger(-108920832) == 5;
            }
            case 3: {
                return this.getInteger(-108920832) == 6;
            }
            case 4: {
                return this.getInteger(-108920832) == 7;
            }
            case 5: {
                return this.getInteger(-108920832) == 1;
            }
            case 6: {
                return this.getInteger(-108920832) == 3;
            }
            case 7: {
                return this.getInteger(-108920832) == 2;
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechMediaDialogDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 41);
                break;
            }
            case 4: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 46);
                break;
            }
            case 7: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 47);
                break;
            }
            case 10: {
                this.triggerObserver(-1420152256);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 11: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 52);
                this.setInteger(-108920832, 7);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 12: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 84);
                this.setInteger(-108920832, 5);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 13: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 82);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 14: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 83);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 15: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 90);
                break;
            }
            case 16: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 85);
                this.setInteger(-108920832, 6);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 17: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 60);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 18: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 58);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 19: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 62);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 20: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 63);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 21: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 66);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 22: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 64);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 23: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 68);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 24: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 70);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 25: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 71);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 26: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 75);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 27: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 77);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 28: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 73);
                this.setBoolean(536739840, true);
                SpeechMediaActivity.fireIntegerValueEvent(this.fromMe(), this.meSelf(), 476548425, this.getInteger(-1037631232));
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 29: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 113);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 30: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 91);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 31: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 92);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 32: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 104);
                this.triggerObserver(-1118162368);
                break;
            }
            case 33: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 101);
                this.setString(28940, this.getI18nString(5583));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 4);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 34: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 61);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 35: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 59);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 36: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 67);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 37: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 65);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 38: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 69);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 39: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 72);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 40: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 76);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 41: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 78);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 42: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 74);
                this.setBoolean(536739840, true);
                SpeechMediaActivity.fireIntegerValueEvent(this.fromMe(), this.meSelf(), 476548425, this.getInteger(-1037631232));
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 43: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 105);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 44: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 106);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 45: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 108);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 46: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 102);
                break;
            }
            case 49: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 103);
                break;
            }
            case 52: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 107);
                if (this.getInteger(-874905600) != 11) break;
                SpeechMediaActivity.fireHMIEvent(ANY, BROADCAST, 1684049225);
                break;
            }
            case 55: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 114);
                EventGeneric eventGeneric = SpeechMediaActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-1983315968));
                this.triggerObserver(-1353043392, eventGeneric);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 56: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 109);
                this.setInteger(-108920832, 5);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 57: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 110);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 58: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 111);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 59: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 86);
                break;
            }
            case 62: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 87);
                this.setInteger(0x10F0100, 1);
                SpeechMediaActivity.fireHMIEvent(ANY, BROADCAST, 1298173257);
                break;
            }
            case 65: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 88);
                break;
            }
            case 68: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 89);
                break;
            }
            case 71: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 93);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 72: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 112);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 73: {
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 74: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 57);
                this.setInteger(-108920832, 0);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1499565385);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 75: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 42);
                break;
            }
            case 78: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 51);
                this.setString(28940, this.getI18nString(5590));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 3);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 79: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 50);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 80: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 48);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 81: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 43);
                break;
            }
            case 84: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 56);
                this.setString(28940, this.getI18nString(5605));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 2);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 85: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 55);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 86: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 53);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 87: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 81);
                this.setString(28940, this.getI18nString(5589));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 1);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 88: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 80);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 89: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 79);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 90: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 100);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 91: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 95);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 92: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 96);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 93: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 97);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 94: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 98);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 95: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 99);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 96: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 44);
                break;
            }
            case 99: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 118);
                this.setString(28940, this.getI18nString(5610));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 3);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 100: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 117);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 101: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 49);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 102: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 45);
                break;
            }
            case 105: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 120);
                this.setString(28940, this.getI18nString(5611));
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1516342601);
                this.setInteger(-108920832, 2);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                break;
            }
            case 106: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 119);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 107: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 54);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 114: {
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechMediaDialogDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 4: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 7: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 11: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 12: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 13: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 14: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 15: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 16: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 17: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 18: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 19: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 20: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 21: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 22: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 23: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 24: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 25: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 26: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 27: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                this.setBoolean(536739840, false);
                break;
            }
            case 28: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 29: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                this.setBoolean(536739840, false);
                break;
            }
            case 30: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 31: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 32: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                this.triggerObserver(-1134939584);
                break;
            }
            case 33: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 34: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 35: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 36: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 37: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 38: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 39: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 40: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 41: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                this.setBoolean(536739840, false);
                break;
            }
            case 42: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 43: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 44: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 45: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 46: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 49: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 52: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 55: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 56: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 57: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 58: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 59: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 62: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 65: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 68: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 71: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 72: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 74: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 75: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 78: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 79: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 80: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 81: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 84: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 85: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 86: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 87: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 88: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 89: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 90: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 91: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 92: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 93: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 94: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 95: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 96: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 99: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 100: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 101: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 102: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 105: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 106: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 107: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubSpeechMediaDialogDynState(int n) {
        this.performInternalTransitionAction_SubSpeechMediaDialogDynState0(n);
    }

    private void performInternalTransitionAction_SubSpeechMediaDialogDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-1571147200);
                break;
            }
            case 1: {
                this.triggerObserver(-1554369984);
                break;
            }
            case 2: {
                this.triggerObserver(-900058560);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubSpeechMediaDialogDynState(int n) {
        this.performTriggeredTransitionAction_SubSpeechMediaDialogDynState0(n);
    }

    private void performTriggeredTransitionAction_SubSpeechMediaDialogDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 43: {
                this.setInteger(29886, SpeechMediaActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SpeechMediaActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(29886));
                this.triggerObserver(-1168494016, eventGeneric);
                break;
            }
            case 44: {
                this.setInteger(-1037631232, this.getInteger(-1684865024));
                this.setInteger(-1037631232, this.getInteger(-1037631232) - 1);
                break;
            }
            case 49: {
                this.setInteger(-1043988480, SpeechMediaActivity.evListItemActionIndex());
                EventGeneric eventGeneric = SpeechMediaActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1043988480));
                this.triggerObserver(-1151716800, eventGeneric);
                break;
            }
            case 59: {
                this.setInteger(-1037631232, this.getInteger(-1684865024));
                this.setInteger(-1037631232, this.getInteger(-1037631232) - 1);
                break;
            }
            case 60: {
                this.setLong(-1983315968, SpeechMediaActivity.evListItemObjectId());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubSpeechMediaDialogDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 11: {
                return this.getBoolean(2146566144);
            }
            case 14: {
                return this.getBoolean(2146566144);
            }
            case 17: {
                return this.getBoolean(2146566144);
            }
            case 20: {
                return this.getBoolean(2146566144);
            }
            case 23: {
                return this.getBoolean(22334);
            }
            case 25: {
                return this.getBoolean(22334);
            }
            case 27: {
                return this.getBoolean(22334);
            }
            case 29: {
                return this.getBoolean(22334);
            }
            case 31: {
                return this.getBoolean(22334);
            }
            case 33: {
                return this.getBoolean(22334);
            }
        }
        return true;
    }

    private void performStateEntryAction_SubISpeechMediaIncludeNoExamplesView(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 4: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 94);
                SpeechMediaActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1466010953);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubISpeechMediaIncludeNoExamplesView(int n) {
        switch (n - this.S_OFFSET) {
            case 4: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubISpeechMediaIncludeNoExamplesView(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(-108920832) == 0;
            }
        }
        return true;
    }

    private void performStateEntryAction_SubSpeechMediaGlobalDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 115);
                break;
            }
            case 4: {
                SpeechMediaActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 116);
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 5: {
                SpeechMediaActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubSpeechMediaGlobalDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 4: {
                SpeechMediaActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }
}

