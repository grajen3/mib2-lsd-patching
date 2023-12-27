/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.mediacontrol.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class MediaControlActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public MediaControlActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 89: {
                this.performStateEntryAction_SubPopupMediacontrolOverlayNoDevicesSelectedDynState(n, bl);
                break;
            }
            case 18: {
                this.performStateEntryAction_SubHapticMediacontrolDynState(n, bl);
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
            case 89: {
                this.performStateExitAction_SubPopupMediacontrolOverlayNoDevicesSelectedDynState(n);
                break;
            }
            case 18: {
                this.performStateExitAction_SubHapticMediacontrolDynState(n);
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
            case 18: {
                return this.evalInternalTransitionGuard_SubHapticMediacontrolDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 18: {
                this.performInternalTransitionAction_SubHapticMediacontrolDynState(n);
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
            case 18: {
                return this.evalTriggeredTransitionGuard_SubHapticMediacontrolDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 18: {
                this.performTriggeredTransitionAction_SubHapticMediacontrolDynState(n);
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
            case 18: {
                return this.evalUntriggeredTransitionGuard_SubHapticMediacontrolDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 18: {
                this.performUntriggeredTransitionAction_SubHapticMediacontrolDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupMediacontrolOverlayNoDevicesSelectedDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Monds", 89, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupMediacontrolOverlayNoDevicesSelectedDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MediaControlActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Monds");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticMediacontrolDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(20496, 0);
                break;
            }
            case 2: {
                this.setInteger(0x100A0100, 25);
                this.setInteger(32112, SkinDataPool.getInteger(190));
                this.setInteger(-1456996096, 1314950473);
                break;
            }
            case 5: {
                MediaControlActivity.changeContext("Media");
                this.setInteger(14165, 0);
                break;
            }
            case 12: {
                this.showView("Mb", bl, 30);
                break;
            }
            case 16: {
                this.showView("Mm_6E21", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 17: {
                this.showView("Mmf", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 18: {
                this.setInteger(20496, 0);
                this.showView("Msm_CE8C", bl, 31);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticMediacontrolDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.setInteger(32112, SkinDataPool.getInteger(180));
                break;
            }
            case 5: {
                this.setInteger(20496, 0);
                break;
            }
            case 8: {
                this.setInteger(32112, SkinDataPool.getInteger(190));
                break;
            }
            case 12: {
                this.hideView("Mb");
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1550355785);
                break;
            }
            case 16: {
                this.hideView("Mm_6E21");
                this.setInteger(14165, 0);
                break;
            }
            case 17: {
                this.hideView("Mmf");
                this.setInteger(14165, 1);
                break;
            }
            case 18: {
                this.hideView("Msm_CE8C");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticMediacontrolDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 13: {
                return this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) != 1 && this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) != 3 && this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) != 2 && this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) != 24 && this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) != 25;
            }
            case 14: {
                return (this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 1 || this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 3 || this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 2) && this.getInteger(-1043136512) > 0;
            }
            case 15: {
                return (this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 1 || this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 3 || this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0) == 2) && this.getInteger(-1043136512) == 0;
            }
            case 19: {
                return MediaControlActivity.evListItemEventSender().equalsIgnoreCase("Button_Play_Pause") && !this.evalBoolean(19);
            }
            case 20: {
                return MediaControlActivity.evListItemEventSender().equalsIgnoreCase("Button_Play_Pause") && this.evalBoolean(19);
            }
            case 21: {
                return MediaControlActivity.evListItemEventSender().equalsIgnoreCase("Button_Cover");
            }
            case 22: {
                return this.getInteger(-1785462784) == 2 || this.getInteger(-1785462784) == 3;
            }
            case 23: {
                return this.getInteger(-1785462784) == 1 || this.getInteger(-1785462784) == 0;
            }
            case 35: {
                return this.getInteger(1243021568) == 0 || this.getListItemControl(-1306503424, true).getItemCount() == 0;
            }
            case 36: {
                return this.getListItemControl(-1306503424, true).getItemCount() == 1;
            }
            case 37: {
                return this.getBoolean(25376);
            }
            case 38: {
                return !this.getBoolean(25376);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticMediacontrolDynState(int n) {
        this.performInternalTransitionAction_SubHapticMediacontrolDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticMediacontrolDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                this.setInteger(32112, SkinDataPool.getInteger(190));
                break;
            }
            case 2: {
                this.setInteger(32112, SkinDataPool.getInteger(180));
                break;
            }
            case 3: {
                this.setInteger(32112, SkinDataPool.getInteger(189));
                break;
            }
            case 4: {
                this.setInteger(32112, SkinDataPool.getInteger(179));
                break;
            }
            case 5: {
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 6: {
                this.setInteger(0x1C100100, 0);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 224496969);
                break;
            }
            case 7: {
                this.setInteger(0x1C100100, 1);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 224496969);
                break;
            }
            case 8: {
                this.setInteger(0x1C100100, 2);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 224496969);
                break;
            }
            case 9: {
                this.setInteger(0x1C100100, 3);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 224496969);
                break;
            }
            case 10: {
                this.setInteger(1428553984, 0);
                break;
            }
            case 11: {
                this.setInteger(582287360, 2);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 241274185);
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(0x1C100100));
                this.triggerObserver(-1392945600, eventGeneric);
                break;
            }
            case 12: {
                this.setInteger(2089353216, MediaControlActivity.evListItemActionIndex());
                break;
            }
            case 13: {
                this.setInteger(582287360, 1);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 241274185);
                this.setString(1221459968, this.getLicValue(-1138731264, 4, this.getInteger(2089353216), "0"));
                this.setInteger(-1073676032, this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(1221459968));
                eventGeneric.setInt(1, this.getInteger(-1073676032));
                this.triggerObserver(-1208396224, eventGeneric);
                break;
            }
            case 14: {
                this.setString(-1746141184, this.getLicValue(-1138731264, 4, this.getInteger(2089353216), "0"));
                this.setInteger(-1164312576, this.getLicValue(-1138731264, 0, this.getInteger(2089353216), 0));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1746141184));
                eventGeneric.setInt(1, this.getInteger(-1164312576));
                this.triggerObserver(-1191619008, eventGeneric);
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1533578569);
                break;
            }
            case 15: {
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 2103020873);
                break;
            }
            case 16: {
                break;
            }
            case 17: {
                MediaControlActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1550355785);
                break;
            }
            case 18: {
                this.setInteger(31753, MediaControlActivity.evListItemActionIndex());
                break;
            }
            case 19: {
                this.setString(619446272, this.getLicValue(-1306503424, 1, this.getInteger(31753), ""));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(619446272));
                this.triggerObserver(-1292282304, eventGeneric);
                break;
            }
            case 20: {
                this.setString(-1215496192, this.getLicValue(-1306503424, 1, this.getInteger(31753), ""));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1215496192));
                this.triggerObserver(-1325836736, eventGeneric);
                break;
            }
            case 21: {
                this.setString(1743060992, this.getLicValue(-1306503424, 1, this.getInteger(31753), ""));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(1743060992));
                this.triggerObserver(-1225173440, eventGeneric);
                break;
            }
            case 22: {
                this.triggerObserver(-1275505088);
                break;
            }
            case 23: {
                this.triggerObserver(-1258727872);
                break;
            }
            case 24: {
                this.setInteger(12358, MediaControlActivity.evIntegerValueValue());
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(12358));
                this.triggerObserver(-1527163328, eventGeneric);
                break;
            }
            case 25: {
                this.triggerObserver(-1493608896);
                break;
            }
            case 26: {
                this.triggerObserver(-1141287360);
                break;
            }
            case 27: {
                this.triggerObserver(-1141287360);
                break;
            }
            case 28: {
                this.triggerObserver(-1460054464);
                break;
            }
            case 29: {
                this.triggerObserver(-1476831680);
                break;
            }
            case 30: {
                this.triggerObserver(-1443277248);
                break;
            }
            case 31: {
                this.triggerObserver(-1141287360);
                break;
            }
            case 32: {
                this.triggerObserver(-1141287360);
                break;
            }
            case 33: {
                this.triggerObserver(-1560717760);
                break;
            }
            case 34: {
                this.triggerObserver(-1543940544);
                break;
            }
            case 36: {
                this.setInteger(31753, 0);
                this.setString(1743060992, this.getLicValue(-1306503424, 1, this.getInteger(31753), ""));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(1743060992));
                this.triggerObserver(-1225173440, eventGeneric);
                break;
            }
            case 37: {
                this.setInteger(1021706240, 102);
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, 1684049225);
                break;
            }
            case 38: {
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, -732328631);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticMediacontrolDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 8: {
                return this.getListItemControl(-1306503424, true).getItemCount() < 2;
            }
            case 10: {
                return this.getListItemControl(-1306503424, true).getItemCount() > 1;
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticMediacontrolDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticMediacontrolDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticMediacontrolDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 6: {
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 12: {
                MediaControlActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticMediacontrolDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return this.getInteger(183304192) == 0;
            }
            case 1: {
                return this.getInteger(183304192) == 1;
            }
            case 4: {
                return this.getInteger(20496) == 2;
            }
            case 10: {
                return this.getInteger(1243021568) == 0 || this.getListItemControl(-1306503424, true).getItemCount() == 0;
            }
            case 11: {
                return this.getListItemControl(-1306503424, true).getItemCount() > 1 && this.getInteger(1243021568) == 1 && this.getInteger(14165) == 1;
            }
            case 12: {
                return this.getListItemControl(-1306503424, true).getItemCount() > 1 && this.getInteger(1243021568) == 1 && this.getInteger(14165) == 0;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticMediacontrolDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 13: {
                this.setInteger(31753, 0);
                this.setString(1743060992, this.getLicValue(-1306503424, 1, this.getInteger(31753), ""));
                EventGeneric eventGeneric = MediaControlActivity.newEvent();
                eventGeneric.setString(0, this.getString(1743060992));
                this.triggerObserver(-1225173440, eventGeneric);
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

