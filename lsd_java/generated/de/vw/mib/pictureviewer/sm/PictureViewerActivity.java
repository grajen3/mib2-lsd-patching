/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.pictureviewer.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class PictureViewerActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public PictureViewerActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 157: {
                this.performStateEntryAction_SubPopupPictureViewerOverlayEndOfDirectoryDynState(n, bl);
                break;
            }
            case 158: {
                this.performStateEntryAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(n, bl);
                break;
            }
            case 159: {
                this.performStateEntryAction_SubPopupPictureViewerOverlayWaitDynState(n, bl);
                break;
            }
            case 37: {
                this.performStateEntryAction_SubHapticPictureviewerDynState(n, bl);
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
            case 157: {
                this.performStateExitAction_SubPopupPictureViewerOverlayEndOfDirectoryDynState(n);
                break;
            }
            case 158: {
                this.performStateExitAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(n);
                break;
            }
            case 159: {
                this.performStateExitAction_SubPopupPictureViewerOverlayWaitDynState(n);
                break;
            }
            case 37: {
                this.performStateExitAction_SubHapticPictureviewerDynState(n);
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
            case 37: {
                return this.evalInternalTransitionGuard_SubHapticPictureviewerDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 37: {
                this.performInternalTransitionAction_SubHapticPictureviewerDynState(n);
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
            case 37: {
                return this.evalTriggeredTransitionGuard_SubHapticPictureviewerDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 158: {
                this.performTriggeredTransitionAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(n);
                break;
            }
            case 37: {
                this.performTriggeredTransitionAction_SubHapticPictureviewerDynState(n);
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
            case 37: {
                return this.evalUntriggeredTransitionGuard_SubHapticPictureviewerDynState(n);
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

    private void performStateEntryAction_SubPopupPictureViewerOverlayEndOfDirectoryDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pvoeod", 157, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPictureViewerOverlayEndOfDirectoryDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                PictureViewerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pvoeod");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pvomcp", 158, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                PictureViewerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pvomcp");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPictureViewerOverlayMediaCdPlayingDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setInteger(-1294860288, 2);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1294860288));
                this.triggerObserver(0x11000040, eventGeneric);
                eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32229));
                this.triggerObserver(0x41040040, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPictureViewerOverlayWaitDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pvow", 159, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPictureViewerOverlayWaitDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                PictureViewerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pvow");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticPictureviewerDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(19247, 2);
                break;
            }
            case 8: {
                this.setInteger(0x100A0100, 9);
                this.setInteger(-1747714048, SkinDataPool.getInteger(190));
                this.setInteger(0x820000, 10);
                this.setInteger(19247, 3);
                break;
            }
            case 11: {
                this.setInteger(-519372544, 11);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-519372544));
                this.triggerObserver(1191510080, eventGeneric);
                PictureViewerActivity.changeContext("PictureViewer");
                break;
            }
            case 13: {
                this.triggerObserver(0x45040040);
                this.setInteger(805044224, 10);
                this.setInteger(-450428672, 500);
                this.setInteger(-303562752, 3);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                break;
            }
            case 15: {
                this.setInteger(23582, 0);
                this.showView("Pvb", bl, 27);
                break;
            }
            case 16: {
                this.showView("Pvbs", bl, 27);
                break;
            }
            case 17: {
                this.triggerObserver(0x55050040);
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                this.setInteger(-1456996096, 1331727689);
                this.setBoolean(-368508672, true);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(26);
                modelApiDownEvent.setBoolean(0, this.getBoolean(-368508672));
                this.fireModelApiDownEvent(modelApiDownEvent);
                this.showView("Pvm", bl, 28);
                break;
            }
            case 18: {
                this.showView("Pvs", bl, 29);
                break;
            }
            case 25: {
                this.setInteger(19247, 2);
                break;
            }
            case 26: {
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, 1281396041);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticPictureviewerDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(19247, 0);
                break;
            }
            case 8: {
                this.setInteger(-1747714048, SkinDataPool.getInteger(180));
                this.setInteger(0x820000, 0);
                break;
            }
            case 13: {
                this.triggerObserver(1057226816);
                this.triggerObserver(1359282240);
                this.setInteger(-1747714048, SkinDataPool.getInteger(190));
                break;
            }
            case 15: {
                this.hideView("Pvb");
                this.setBoolean(-2050097152, true);
                break;
            }
            case 16: {
                this.hideView("Pvbs");
                break;
            }
            case 17: {
                this.hideView("Pvm");
                this.triggerObserver(0x55050040);
                this.setBoolean(0x2AA0000, false);
                this.setInteger(-1025441792, 1);
                Object object = PictureViewerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(-1025441792));
                this.triggerObserver(0x47040040, (EventGeneric)object);
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2006414007);
                this.setBoolean(-368508672, false);
                object = this.createModelApiDownEvent(26);
                object.setBoolean(0, this.getBoolean(-368508672));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                break;
            }
            case 18: {
                this.hideView("Pvs");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticPictureviewerDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 6: {
                return PictureViewerActivity.evListItemEventSender().equals("Button_Folder");
            }
            case 7: {
                return PictureViewerActivity.evListItemEventSender().equals("Button_File") && this.getInteger(2024865792) == 1 && this.getInteger(18985) == 2 && this.getInteger(1409810688) == 1 && (this.getInteger(-994836480) == 1 || this.getInteger(-994836480) == 6 || this.getInteger(-994836480) == 7);
            }
            case 8: {
                return PictureViewerActivity.evListItemEventSender().equals("Button_File");
            }
            case 17: {
                return this.getBoolean(0x2AA0000);
            }
            case 18: {
                return !this.getBoolean(0x2AA0000);
            }
            case 27: {
                return !this.getBoolean(0x2AA0000);
            }
            case 28: {
                return this.getBoolean(0x2AA0000) && !this.getBoolean(479526912);
            }
            case 31: {
                return this.getBoolean(30067);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticPictureviewerDynState(int n) {
        this.performInternalTransitionAction_SubHapticPictureviewerDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticPictureviewerDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(-1747714048, SkinDataPool.getInteger(190));
                break;
            }
            case 1: {
                this.setInteger(-1747714048, SkinDataPool.getInteger(180));
                break;
            }
            case 2: {
                this.setInteger(-1747714048, SkinDataPool.getInteger(189));
                break;
            }
            case 3: {
                this.setInteger(-1747714048, SkinDataPool.getInteger(179));
                break;
            }
            case 4: {
                this.setInteger(29840, 13);
                this.setInteger(1021706240, 80);
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 5: {
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 6: {
                this.setInteger(23582, 1);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 794922313);
                this.setBoolean(-2050097152, false);
                this.setInteger(21362, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21362));
                this.triggerObserver(0x44040040, eventGeneric);
                break;
            }
            case 7: {
                this.setBoolean(-2050097152, false);
                this.setInteger(32229, PictureViewerActivity.evListItemActionIndex());
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1889956535);
                break;
            }
            case 8: {
                this.setBoolean(-2050097152, false);
                this.setInteger(32229, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32229));
                this.triggerObserver(0x41040040, eventGeneric);
                break;
            }
            case 9: {
                this.setBoolean(-2050097152, false);
                this.setInteger(1694761216, 0);
                break;
            }
            case 10: {
                this.setInteger(28404, 1);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -312111799);
                break;
            }
            case 11: {
                this.setInteger(28404, 2);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -312111799);
                break;
            }
            case 12: {
                this.setInteger(28404, 0);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -312111799);
                break;
            }
            case 13: {
                this.setInteger(23582, 2);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 794922313);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28404));
                this.triggerObserver(0x43040040, eventGeneric);
                this.setBoolean(-2050097152, false);
                break;
            }
            case 14: {
                break;
            }
            case 15: {
                this.setInteger(1486028800, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1486028800));
                this.triggerObserver(-771162048, eventGeneric);
                break;
            }
            case 16: {
                this.setResourceLocator(31377, this.getResourceLocator(18032));
                this.setInteger(1021706240, 80);
                this.setInteger(-540737536, 5);
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, 1382059337);
                break;
            }
            case 17: {
                this.setBoolean(0x2AA0000, false);
                this.setInteger(-1025441792, 1);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1025441792));
                this.triggerObserver(0x47040040, eventGeneric);
                break;
            }
            case 18: {
                this.setBoolean(0x2AA0000, true);
                this.setInteger(-1025441792, 0);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1025441792));
                this.triggerObserver(0x47040040, eventGeneric);
                break;
            }
            case 19: {
                break;
            }
            case 20: {
                this.setInteger(1695285504, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1695285504));
                this.triggerObserver(1040449600, eventGeneric);
                break;
            }
            case 21: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 945917257);
                break;
            }
            case 22: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 945917257);
                break;
            }
            case 23: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 929140041);
                break;
            }
            case 24: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 912362825);
                break;
            }
            case 25: {
                this.triggerObserver(0x40040040);
                break;
            }
            case 26: {
                this.triggerObserver(0x42040040);
                break;
            }
            case 27: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1906733751);
                break;
            }
            case 28: {
                this.setBoolean(0x2AA0000, false);
                this.setInteger(-1025441792, 1);
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1025441792));
                this.triggerObserver(0x47040040, eventGeneric);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1906733751);
                break;
            }
            case 29: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2023191223);
                this.setBoolean(30067, true);
                break;
            }
            case 30: {
                this.setBoolean(30067, false);
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -2006414007);
                break;
            }
            case 31: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1923510967);
                break;
            }
            case 32: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 341675337);
                this.setInteger(22154, 1);
                this.setBoolean(1678508288, true);
                if (this.getInteger(25684) == 0 || !this.getBoolean(19239)) {
                    this.setBoolean(1678508288, false);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(27);
                modelApiDownEvent.setInt(0, this.getInteger(22154));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1678508288));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
            case 33: {
                PictureViewerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 375229769);
                this.setInteger(22154, 0);
                this.setBoolean(1678508288, true);
                if (this.getInteger(25684) == 0 || !this.getBoolean(19239)) {
                    this.setBoolean(1678508288, false);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(27);
                modelApiDownEvent.setInt(0, this.getInteger(22154));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1678508288));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
            case 34: {
                this.triggerObserver(0x49040040);
                break;
            }
            case 35: {
                this.setInteger(32661, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32661));
                this.triggerObserver(0x48040040, eventGeneric);
                break;
            }
            case 36: {
                this.setInteger(31604, PictureViewerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = PictureViewerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(31604));
                this.triggerObserver(0x46040040, eventGeneric);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticPictureviewerDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 4: {
                return this.getInteger(25684) == 0;
            }
            case 10: {
                return this.getBoolean(651821056);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticPictureviewerDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticPictureviewerDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticPictureviewerDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 7: {
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, -1973908151);
                break;
            }
            case 9: {
                PictureViewerActivity.fireHMIEvent(ANY, BROADCAST, -1990685367);
                break;
            }
            case 10: {
                this.setBoolean(-2050097152, false);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticPictureviewerDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                return this.getInteger(183304192) == 1 && this.getInteger(27660) == 1;
            }
            case 7: {
                return this.getInteger(183304192) == 0 || this.getInteger(27660) == 0;
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

