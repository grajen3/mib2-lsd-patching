/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tuner.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.modelapi.ModelApiDownEvent;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class TunerActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public TunerActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 294: {
                this.performStateEntryAction_SubPopupPoConfirmTunerSetupAfDynState(n, bl);
                break;
            }
            case 295: {
                this.performStateEntryAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(n, bl);
                break;
            }
            case 296: {
                this.performStateEntryAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(n, bl);
                break;
            }
            case 297: {
                this.performStateEntryAction_SubPopupPoConfirmTunerSetupRdsDynState(n, bl);
                break;
            }
            case 453: {
                this.performStateEntryAction_SubPopupPoInfoTunerDabAnnouncementDynState(n, bl);
                break;
            }
            case 454: {
                this.performStateEntryAction_SubPopupPoInfoTunerInitialAutostoreDynState(n, bl);
                break;
            }
            case 455: {
                this.performStateEntryAction_SubPopupPoInfoTunerTaDynState(n, bl);
                break;
            }
            case 456: {
                this.performStateEntryAction_SubPopupPoInfoTunerTpSeekDynState(n, bl);
                break;
            }
            case 626: {
                this.performStateEntryAction_SubPopupTunerConfirmDeleteAllPresetsDynState(n, bl);
                break;
            }
            case 627: {
                this.performStateEntryAction_SubPopupTunerOverlayAmbiguousLogosDynState(n, bl);
                break;
            }
            case 628: {
                this.performStateEntryAction_SubPopupTunerOverlayDabHierarchicalListUpdateNoservicesDynState(n, bl);
                break;
            }
            case 629: {
                this.performStateEntryAction_SubPopupTunerOverlayLinkingPreferenceDynState(n, bl);
                break;
            }
            case 630: {
                this.performStateEntryAction_SubPopupTunerOverlayPty31DynState(n, bl);
                break;
            }
            case 631: {
                this.performStateEntryAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(n, bl);
                break;
            }
            case 62: {
                this.performStateEntryAction_SubHapticTunerDynState(n, bl);
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
            case 294: {
                this.performStateExitAction_SubPopupPoConfirmTunerSetupAfDynState(n);
                break;
            }
            case 295: {
                this.performStateExitAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(n);
                break;
            }
            case 296: {
                this.performStateExitAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(n);
                break;
            }
            case 297: {
                this.performStateExitAction_SubPopupPoConfirmTunerSetupRdsDynState(n);
                break;
            }
            case 453: {
                this.performStateExitAction_SubPopupPoInfoTunerDabAnnouncementDynState(n);
                break;
            }
            case 454: {
                this.performStateExitAction_SubPopupPoInfoTunerInitialAutostoreDynState(n);
                break;
            }
            case 455: {
                this.performStateExitAction_SubPopupPoInfoTunerTaDynState(n);
                break;
            }
            case 456: {
                this.performStateExitAction_SubPopupPoInfoTunerTpSeekDynState(n);
                break;
            }
            case 626: {
                this.performStateExitAction_SubPopupTunerConfirmDeleteAllPresetsDynState(n);
                break;
            }
            case 627: {
                this.performStateExitAction_SubPopupTunerOverlayAmbiguousLogosDynState(n);
                break;
            }
            case 628: {
                this.performStateExitAction_SubPopupTunerOverlayDabHierarchicalListUpdateNoservicesDynState(n);
                break;
            }
            case 629: {
                this.performStateExitAction_SubPopupTunerOverlayLinkingPreferenceDynState(n);
                break;
            }
            case 630: {
                this.performStateExitAction_SubPopupTunerOverlayPty31DynState(n);
                break;
            }
            case 631: {
                this.performStateExitAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(n);
                break;
            }
            case 62: {
                this.performStateExitAction_SubHapticTunerDynState(n);
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
            case 453: {
                return this.evalInternalTransitionGuard_SubPopupPoInfoTunerDabAnnouncementDynState(n);
            }
            case 455: {
                return this.evalInternalTransitionGuard_SubPopupPoInfoTunerTaDynState(n);
            }
            case 456: {
                return this.evalInternalTransitionGuard_SubPopupPoInfoTunerTpSeekDynState(n);
            }
            case 630: {
                return this.evalInternalTransitionGuard_SubPopupTunerOverlayPty31DynState(n);
            }
            case 62: {
                return this.evalInternalTransitionGuard_SubHapticTunerDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 453: {
                this.performInternalTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState(n);
                break;
            }
            case 454: {
                this.performInternalTransitionAction_SubPopupPoInfoTunerInitialAutostoreDynState(n);
                break;
            }
            case 455: {
                this.performInternalTransitionAction_SubPopupPoInfoTunerTaDynState(n);
                break;
            }
            case 456: {
                this.performInternalTransitionAction_SubPopupPoInfoTunerTpSeekDynState(n);
                break;
            }
            case 630: {
                this.performInternalTransitionAction_SubPopupTunerOverlayPty31DynState(n);
                break;
            }
            case 62: {
                this.performInternalTransitionAction_SubHapticTunerDynState(n);
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
            case 453: {
                return this.evalTriggeredTransitionGuard_SubPopupPoInfoTunerDabAnnouncementDynState(n);
            }
            case 455: {
                return this.evalTriggeredTransitionGuard_SubPopupPoInfoTunerTaDynState(n);
            }
            case 630: {
                return this.evalTriggeredTransitionGuard_SubPopupTunerOverlayPty31DynState(n);
            }
            case 62: {
                return this.evalTriggeredTransitionGuard_SubHapticTunerDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 294: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupAfDynState(n);
                break;
            }
            case 295: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(n);
                break;
            }
            case 296: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(n);
                break;
            }
            case 297: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupRdsDynState(n);
                break;
            }
            case 453: {
                this.performTriggeredTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState(n);
                break;
            }
            case 455: {
                this.performTriggeredTransitionAction_SubPopupPoInfoTunerTaDynState(n);
                break;
            }
            case 627: {
                this.performTriggeredTransitionAction_SubPopupTunerOverlayAmbiguousLogosDynState(n);
                break;
            }
            case 629: {
                this.performTriggeredTransitionAction_SubPopupTunerOverlayLinkingPreferenceDynState(n);
                break;
            }
            case 630: {
                this.performTriggeredTransitionAction_SubPopupTunerOverlayPty31DynState(n);
                break;
            }
            case 631: {
                this.performTriggeredTransitionAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(n);
                break;
            }
            case 62: {
                this.performTriggeredTransitionAction_SubHapticTunerDynState(n);
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
            case 62: {
                return this.evalUntriggeredTransitionGuard_SubHapticTunerDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 62: {
                this.performUntriggeredTransitionAction_SubHapticTunerDynState(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmTunerSetupAfDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tosa_F067", 294, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmTunerSetupAfDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tosa_F067");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupAfDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupAfDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupAfDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                this.setBoolean(18768, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(18768));
                this.triggerObserver(-1341915072, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tosdp", 295, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tosdp");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupDeletePresetsDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1825636352));
                eventGeneric.setInt(1, this.getInteger(769982464));
                this.triggerObserver(-1677459392, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tospld", 296, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tospld");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupPresetLogosDeleteDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(11897));
                this.triggerObserver(-1660682176, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmTunerSetupRdsDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tosr", 297, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmTunerSetupRdsDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tosr");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupRdsDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupRdsDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmTunerSetupRdsDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                this.setBoolean(23731, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(23731));
                this.triggerObserver(-956039104, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoTunerDabAnnouncementDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.enterPopupView("Toda", 453, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoTunerDabAnnouncementDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Toda");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoInfoTunerDabAnnouncementDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(10548);
            }
            case 1: {
                return this.getInteger(19434) == 1;
            }
            case 3: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 4: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 6: {
                return this.getInteger(0x820000) == 4;
            }
            case 7: {
                return this.getInteger(0x820000) > 4 || this.getInteger(0x820000) < 4;
            }
            case 8: {
                return this.getInteger(-1245773824) == 2;
            }
            case 11: {
                return !this.getBoolean(20317) && !this.getBoolean(30686);
            }
            case 15: {
                return this.getInteger(0x820000) == 6;
            }
            case 16: {
                return this.getBoolean(690422016);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState00(n);
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-737935296);
                break;
            }
            case 1: {
                this.setBoolean(539492608, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(539492608));
                this.triggerObserver(-1190920128, eventGeneric);
                this.triggerObserver(-737935296);
                break;
            }
            case 2: {
                this.setBoolean(-340459520, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-340459520));
                this.triggerObserver(-1274806208, eventGeneric);
                this.triggerObserver(-737935296);
                break;
            }
            case 5: {
                this.triggerObserver(-737935296);
                break;
            }
            case 6: {
                this.triggerObserver(-737935296);
                break;
            }
            case 7: {
                this.triggerObserver(-737935296);
                break;
            }
            case 8: {
                this.triggerObserver(-737935296);
                break;
            }
            case 10: {
                this.triggerObserver(-737935296);
                break;
            }
            case 11: {
                this.triggerObserver(-737935296);
                break;
            }
            case 13: {
                this.triggerObserver(-737935296);
                break;
            }
            case 14: {
                this.triggerObserver(-737935296);
                break;
            }
            case 15: {
                this.triggerObserver(-737935296);
                if (this.getBoolean(462290944)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 555);
                break;
            }
            case 16: {
                this.triggerObserver(-737935296);
                break;
            }
            case 17: {
                this.triggerObserver(-737935296);
                break;
            }
            case 18: {
                this.triggerObserver(-737935296);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubPopupPoInfoTunerDabAnnouncementDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                return this.getBoolean(20317) || this.getBoolean(30686);
            }
            case 5: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
            case 6: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
            case 8: {
                return !this.getBoolean(10548);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoInfoTunerDabAnnouncementDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                if (this.getInteger(0x820000) <= 3 && this.getInteger(0x820000) >= 3) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 263);
                break;
            }
            case 1: {
                if (this.getInteger(0x820000) <= 1 && this.getInteger(0x820000) >= 1) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 361);
                break;
            }
            case 2: {
                this.triggerObserver(-737935296);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 344);
                break;
            }
            case 3: {
                if (this.getInteger(0x820000) <= 5 && this.getInteger(0x820000) >= 5) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 341);
                break;
            }
            case 4: {
                if (this.getInteger(0x820000) <= 9 && this.getInteger(0x820000) >= 9) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 303);
                break;
            }
            case 5: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 288);
                break;
            }
            case 6: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 283);
                break;
            }
            case 7: {
                this.triggerObserver(-737935296);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 358);
                break;
            }
            case 9: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 320);
                break;
            }
            case 10: {
                if (this.getInteger(0x820000) <= 12 && this.getInteger(0x820000) >= 12) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 306);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoTunerInitialAutostoreDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Toia", 454, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoTunerInitialAutostoreDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Toia");
                this.triggerObserver(-704380864);
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerInitialAutostoreDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoInfoTunerInitialAutostoreDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerInitialAutostoreDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-704380864);
                break;
            }
            case 2: {
                this.triggerObserver(-704380864);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoTunerTaDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.enterPopupView("Tot", 455, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoTunerTaDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tot");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoInfoTunerTaDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(837550080);
            }
            case 2: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 4: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 5: {
                return this.getInteger(0x820000) == 4;
            }
            case 6: {
                return this.getInteger(0x820000) > 4 || this.getInteger(0x820000) < 4;
            }
            case 7: {
                return this.getInteger(-1245773824) == 2;
            }
            case 10: {
                return !this.getBoolean(20317) && !this.getBoolean(30686);
            }
            case 14: {
                return this.getInteger(0x820000) == 6;
            }
            case 15: {
                return this.getBoolean(690422016);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerTaDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoInfoTunerTaDynState00(n);
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerTaDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-586940352);
                break;
            }
            case 1: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                this.triggerObserver(-586940352);
                break;
            }
            case 3: {
                this.triggerObserver(-586940352);
                break;
            }
            case 5: {
                this.triggerObserver(-586940352);
                break;
            }
            case 6: {
                this.triggerObserver(-586940352);
                break;
            }
            case 7: {
                this.triggerObserver(-586940352);
                break;
            }
            case 8: {
                this.triggerObserver(-586940352);
                break;
            }
            case 10: {
                this.triggerObserver(-586940352);
                break;
            }
            case 12: {
                this.triggerObserver(-586940352);
                break;
            }
            case 13: {
                this.triggerObserver(-586940352);
                break;
            }
            case 14: {
                this.triggerObserver(-586940352);
                if (this.getBoolean(462290944)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 555);
                break;
            }
            case 15: {
                this.triggerObserver(-586940352);
                break;
            }
            case 16: {
                this.triggerObserver(-586940352);
                break;
            }
            case 17: {
                this.triggerObserver(-586940352);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubPopupPoInfoTunerTaDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 2: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
            case 3: {
                return this.getBoolean(20317) || this.getBoolean(30686);
            }
            case 5: {
                return !this.getBoolean(837550080);
            }
            case 7: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubPopupPoInfoTunerTaDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoInfoTunerTaDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoInfoTunerTaDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 320);
                break;
            }
            case 1: {
                if (this.getInteger(0x820000) <= 12 && this.getInteger(0x820000) >= 12) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 306);
                break;
            }
            case 2: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 288);
                break;
            }
            case 3: {
                if (this.getInteger(0x820000) <= 5 && this.getInteger(0x820000) >= 5) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 341);
                break;
            }
            case 4: {
                if (this.getInteger(0x820000) <= 1 && this.getInteger(0x820000) >= 1) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 361);
                break;
            }
            case 6: {
                this.triggerObserver(-586940352);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 358);
                break;
            }
            case 7: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 283);
                break;
            }
            case 8: {
                if (this.getInteger(0x820000) <= 3 && this.getInteger(0x820000) >= 3) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 263);
                break;
            }
            case 9: {
                this.triggerObserver(-586940352);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 344);
                break;
            }
            case 10: {
                if (this.getInteger(0x820000) <= 9 && this.getInteger(0x820000) >= 9) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 303);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoTunerTpSeekDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tots", 456, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoTunerTpSeekDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tots");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupPoInfoTunerTpSeekDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 2: {
                return this.getBoolean(690422016);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerTpSeekDynState(int n) {
        this.performInternalTransitionAction_SubPopupPoInfoTunerTpSeekDynState0(n);
    }

    private void performInternalTransitionAction_SubPopupPoInfoTunerTpSeekDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 190942537);
                break;
            }
            case 1: {
                this.triggerObserver(-603717568);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 190942537);
                break;
            }
            case 2: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 190942537);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerConfirmDeleteAllPresetsDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tcdap", 626, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerConfirmDeleteAllPresetsDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tcdap");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerOverlayAmbiguousLogosDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Toal", 627, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerOverlayAmbiguousLogosDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                if (!this.getBoolean(23839)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 3: {
                this.leavePopupView("Toal");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayAmbiguousLogosDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupTunerOverlayAmbiguousLogosDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayAmbiguousLogosDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                this.setInteger(-1644363776, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1644363776));
                this.triggerObserver(1443430464, eventGeneric);
                break;
            }
            case 2: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 282);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerOverlayDabHierarchicalListUpdateNoservicesDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Todhlun", 628, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerOverlayDabHierarchicalListUpdateNoservicesDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Todhlun");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerOverlayLinkingPreferenceDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tolp", 629, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerOverlayLinkingPreferenceDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tolp");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayLinkingPreferenceDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupTunerOverlayLinkingPreferenceDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayLinkingPreferenceDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.triggerObserver(966730816);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerOverlayPty31DynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.enterPopupView("Top", 630, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerOverlayPty31DynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Top");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubPopupTunerOverlayPty31DynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(21917);
            }
            case 1: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 3: {
                return this.getInteger(0x820000) == 4 || this.getBoolean(-1459814400);
            }
            case 4: {
                return this.getInteger(0x820000) == 4;
            }
            case 5: {
                return this.getInteger(0x820000) > 4 || this.getInteger(0x820000) < 4;
            }
            case 6: {
                return this.getInteger(-1245773824) == 2;
            }
            case 10: {
                return !this.getBoolean(20317) && !this.getBoolean(30686);
            }
            case 15: {
                return this.getInteger(0x820000) == 6;
            }
            case 16: {
                return this.getBoolean(690422016);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubPopupTunerOverlayPty31DynState(int n) {
        this.performInternalTransitionAction_SubPopupTunerOverlayPty31DynState00(n);
    }

    private void performInternalTransitionAction_SubPopupTunerOverlayPty31DynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.triggerObserver(-721158080);
                break;
            }
            case 2: {
                this.triggerObserver(-721158080);
                break;
            }
            case 4: {
                this.triggerObserver(-721158080);
                break;
            }
            case 5: {
                this.triggerObserver(-721158080);
                break;
            }
            case 6: {
                this.triggerObserver(-721158080);
                break;
            }
            case 7: {
                this.triggerObserver(-721158080);
                break;
            }
            case 9: {
                this.triggerObserver(-721158080);
                break;
            }
            case 10: {
                this.triggerObserver(-721158080);
                break;
            }
            case 11: {
                this.triggerObserver(-721158080);
                break;
            }
            case 13: {
                this.triggerObserver(-721158080);
                break;
            }
            case 14: {
                this.triggerObserver(-721158080);
                break;
            }
            case 15: {
                this.triggerObserver(-721158080);
                if (this.getBoolean(462290944)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 555);
                break;
            }
            case 16: {
                this.triggerObserver(-721158080);
                break;
            }
            case 17: {
                this.triggerObserver(-721158080);
                break;
            }
            case 18: {
                this.triggerObserver(-721158080);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubPopupTunerOverlayPty31DynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                return this.getBoolean(20317) || this.getBoolean(30686);
            }
            case 4: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
            case 6: {
                return !this.getBoolean(-1459814400) && this.getInteger(0x820000) != 4;
            }
            case 10: {
                return !this.getBoolean(21917);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayPty31DynState(int n) {
        this.performTriggeredTransitionAction_SubPopupTunerOverlayPty31DynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlayPty31DynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                if (this.getInteger(0x820000) <= 5 && this.getInteger(0x820000) >= 5) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 341);
                break;
            }
            case 1: {
                this.triggerObserver(-721158080);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 358);
                break;
            }
            case 2: {
                this.triggerObserver(-721158080);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 344);
                break;
            }
            case 3: {
                if (this.getInteger(0x820000) <= 12 && this.getInteger(0x820000) >= 12) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 306);
                break;
            }
            case 4: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 288);
                break;
            }
            case 5: {
                if (this.getInteger(0x820000) <= 1 && this.getInteger(0x820000) >= 1) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 361);
                break;
            }
            case 6: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 283);
                break;
            }
            case 7: {
                if (this.getInteger(0x820000) <= 9 && this.getInteger(0x820000) >= 9) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 303);
                break;
            }
            case 8: {
                if (this.getInteger(0x820000) <= 3 && this.getInteger(0x820000) >= 3) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 263);
                break;
            }
            case 9: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 320);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Tosplda", 631, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                TunerActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Tosplda");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupTunerOverlaySetupPresetLogosDeleteAllDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setInteger(247070720, this.getInteger(1797128448));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(247070720));
                this.triggerObserver(722075712, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticTunerDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-356843520, 2);
                this.setInteger(22807, 0);
                this.setInteger(-1814626304, this.getInteger(23328));
                break;
            }
            case 8: {
                this.setInteger(0x100A0100, 1);
                this.setInteger(-1664614400, SkinDataPool.getInteger(190));
                this.setInteger(0x820000, 6);
                this.setInteger(-356843520, 3);
                if (this.getListItemControl(1461, true).getItemCount() == 15) {
                    this.setInteger(27767, 10);
                }
                if (this.getListItemControl(1461, true).getItemCount() == 18) {
                    this.setInteger(27767, 12);
                }
                if (this.getListItemControl(1461, true).getItemCount() == 15) {
                    this.setInteger(27769, 5);
                }
                if (this.getListItemControl(1461, true).getItemCount() == 18) {
                    this.setInteger(27769, 6);
                }
                this.setInteger(1796538624, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1796538624));
                this.triggerObserver(983508032, eventGeneric);
                break;
            }
            case 14: {
                this.setInteger(1150418944, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 19: {
                if (this.getBoolean(32205)) {
                    this.setBoolean(-84344832, false);
                }
                if (!this.getBoolean(32205)) {
                    this.setBoolean(-84344832, false);
                }
                this.setInteger(1105723392, SkinDataPool.getInteger(175));
                this.setInteger(0x1880000, SkinDataPool.getInteger(176));
                this.setInteger(-739835904, SkinDataPool.getInteger(177));
                this.setInteger(25127, SkinDataPool.getInteger(178));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1105723392));
                eventGeneric.setInt(1, this.getInteger(0x1880000));
                eventGeneric.setInt(2, this.getInteger(-739835904));
                eventGeneric.setInt(3, this.getInteger(25127));
                this.triggerObserver(161424448, eventGeneric);
                this.setInteger(19348, SkinDataPool.getInteger(44));
                this.setInteger(15167, SkinDataPool.getInteger(43));
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(19348));
                eventGeneric.setInt(1, this.getInteger(15167));
                this.triggerObserver(-1107034048, eventGeneric);
                if (this.getInteger(-325517312) != 6) {
                    this.setInteger(-519372544, 6);
                }
                if (this.getInteger(-325517312) != 6) {
                    eventGeneric = TunerActivity.newEvent();
                    eventGeneric.setInt(0, this.getInteger(-519372544));
                    this.triggerObserver(1191510080, eventGeneric);
                }
                this.setInteger(20194, 1);
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(20194));
                this.triggerObserver(-284950464, eventGeneric);
                TunerActivity.changeContext("Tuner");
                this.setInteger(0x820000, 6);
                this.setBoolean(-190775296, false);
                break;
            }
            case 23: {
                if (this.getBoolean(23839)) {
                    this.setInteger(-1508245248, 0);
                }
                if (this.getBoolean(23839)) break;
                this.setInteger(-1508245248, 1);
                break;
            }
            case 26: {
                this.triggerObserver(-419168192);
                break;
            }
            case 31: {
                this.setInteger(805044224, 10);
                this.setInteger(-303562752, 3);
                this.setInteger(-450428672, 500);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                if (!this.getBoolean(-376438784) || !this.getBoolean(471990528)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                }
                if (this.getInteger(20548) == 1) {
                    this.setBoolean(-1313734656, true);
                }
                if (this.getInteger(20548) == 0) {
                    this.setBoolean(-1313734656, false);
                }
                if (this.getInteger(20548) == 1) {
                    this.setBoolean(19259, true);
                }
                if (this.getInteger(20548) == 0) {
                    this.setBoolean(19259, false);
                }
                if (this.getInteger(20548) == 1) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -311915191);
                }
                this.showView("Talm", bl, 0);
                break;
            }
            case 32: {
                if (this.getInteger(1337917440) < this.getInteger(27769)) {
                    this.setInteger(431947776, 0);
                }
                if (this.getInteger(1337917440) < this.getInteger(27767) && (this.getInteger(1337917440) == this.getInteger(27769) || this.getInteger(1337917440) > this.getInteger(27769))) {
                    this.setInteger(431947776, this.getInteger(27769));
                }
                if (this.getInteger(1337917440) == this.getInteger(27767) || this.getInteger(1337917440) > this.getInteger(27767)) {
                    this.setInteger(431947776, this.getInteger(27767));
                }
                this.triggerObserver(118161472);
                this.setBoolean(1275658496, true);
                this.showView("Tals", bl, 8);
                break;
            }
            case 33: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 34: {
                this.setBoolean(462290944, true);
                if (this.getBoolean(837550080)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getBoolean(10548)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                if (this.getBoolean(21917)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1214352713);
                }
                this.setBoolean(985530368, false);
                break;
            }
            case 36: {
                this.setBoolean(-1459814400, true);
                if (this.getBoolean(837550080)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getBoolean(10548)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                this.setInteger(-1664614400, SkinDataPool.getInteger(190));
                this.setBoolean(181927936, false);
                this.setInteger(-1508245248, 1);
                this.setInteger(-1456996096, 1633717577);
                this.setInteger(-274661376, 3);
                Object object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(-274661376));
                this.triggerObserver(77538368, (EventGeneric)object);
                this.setBoolean(1947926784, true);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                this.showView("Tam_593A", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 43: {
                this.setInteger(22807, 0);
                this.showView("Taspl", bl, 5);
                break;
            }
            case 44: {
                this.showView("Tasdp", bl, 4);
                break;
            }
            case 45: {
                this.showView("Tasm", bl, 7);
                break;
            }
            case 46: {
                this.triggerObserver(-419168192);
                break;
            }
            case 55: {
                this.setInteger(22807, 0);
                this.showView("Tdspl", bl, 5);
                break;
            }
            case 56: {
                this.showView("Tdsm", bl, 7);
                break;
            }
            case 57: {
                this.showView("Tdsa", bl, 3);
                break;
            }
            case 58: {
                this.showView("Tdsdp", bl, 4);
                break;
            }
            case 65: {
                if (this.getInteger(215351296) < this.getInteger(27769)) {
                    this.setInteger(915603456, 0);
                }
                if (this.getInteger(215351296) < this.getInteger(27767) && (this.getInteger(215351296) == this.getInteger(27769) || this.getInteger(215351296) > this.getInteger(27769))) {
                    this.setInteger(915603456, this.getInteger(27769));
                }
                if (this.getInteger(215351296) == this.getInteger(27767) || this.getInteger(215351296) > this.getInteger(27767)) {
                    this.setInteger(915603456, this.getInteger(27767));
                }
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.triggerObserver(118161472);
                this.setBoolean(1275658496, true);
                this.showView("Tdls", bl, 8);
                break;
            }
            case 66: {
                this.setInteger(805044224, 10);
                this.setInteger(-303562752, 3);
                this.setInteger(-450428672, 500);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                if (this.getInteger(2010775552) == 1) {
                    this.setBoolean(-1313734656, true);
                }
                if (this.getInteger(2010775552) == 0) {
                    this.setBoolean(-1313734656, false);
                }
                if (this.getInteger(2010775552) == 1) {
                    this.setBoolean(19259, true);
                }
                if (this.getInteger(2010775552) == 0) {
                    this.setBoolean(19259, false);
                }
                if (this.getInteger(2010775552) == 1) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -311915191);
                }
                this.showView("Tdhl", bl, 0);
                break;
            }
            case 67: {
                this.setInteger(805044224, 10);
                this.setInteger(-303562752, 3);
                this.setInteger(-450428672, 500);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                this.showView("Tdssl", bl, 0);
                break;
            }
            case 68: {
                this.setBoolean(22157, true);
                this.setBoolean(462290944, true);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1483246921);
                this.setBoolean(-1459814400, true);
                this.setInteger(-1664614400, SkinDataPool.getInteger(190));
                this.setBoolean(181927936, false);
                this.setInteger(-1508245248, 1);
                if (!this.getBoolean(471990528) || this.getBoolean(-376438784)) {
                    this.setBoolean(1673068544, false);
                }
                this.triggerObserver(235536448);
                if (this.getBoolean(837550080)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getBoolean(10548)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                if (this.getBoolean(21917)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1214352713);
                }
                this.setInteger(-1456996096, 1633717577);
                this.setInteger(-274661376, 6);
                Object object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(-274661376));
                this.triggerObserver(77538368, (EventGeneric)object);
                this.setBoolean(1947926784, true);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                this.showView("Tdm_86AD", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 69: {
                break;
            }
            case 74: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 75: {
                this.showView("Tfshcl", bl, 7);
                break;
            }
            case 77: {
                this.setInteger(22807, 0);
                this.showView("Tfspl", bl, 5);
                break;
            }
            case 78: {
                this.showView("Tfsdp", bl, 4);
                break;
            }
            case 79: {
                this.showView("Tfsa", bl, 3);
                break;
            }
            case 80: {
                this.setInteger(-274661376, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-274661376));
                this.triggerObserver(77538368, eventGeneric);
                this.showView("Tfsm", bl, 7);
                break;
            }
            case 82: {
                this.setBoolean(462290944, true);
                this.triggerObserver(-419168192);
                if (this.getBoolean(837550080)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getBoolean(10548)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                if (this.getBoolean(21917)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1214352713);
                }
                this.setBoolean(985530368, false);
                break;
            }
            case 84: {
                this.setInteger(-274661376, 0);
                Object object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(-274661376));
                this.triggerObserver(77538368, (EventGeneric)object);
                this.setBoolean(-1459814400, true);
                if (this.getBoolean(837550080)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1231129929);
                }
                if (this.getBoolean(10548)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, 1197575497);
                }
                this.setInteger(-1664614400, SkinDataPool.getInteger(190));
                this.setBoolean(181927936, false);
                this.setInteger(-1508245248, 1);
                this.setInteger(-1456996096, 1633717577);
                this.setBoolean(1947926784, true);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                if (!this.getBoolean(404357376) && this.getInteger(-1249181696) != 0) {
                    this.setInteger(1755447296, 0);
                    object = TunerActivity.newEvent();
                    ((EventGeneric)object).setInt(0, this.getInteger(1755447296));
                    this.triggerObserver(-1308360640, (EventGeneric)object);
                }
                this.showView("Tfm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 85: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 88: {
                this.setInteger(805044224, 10);
                this.setInteger(-303562752, 3);
                this.setInteger(-450428672, 500);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                this.showView("Tflm", bl, 0);
                break;
            }
            case 89: {
                if (this.getInteger(29376) < this.getInteger(27769)) {
                    this.setInteger(16873, 0);
                }
                if (this.getInteger(29376) < this.getInteger(27767) && (this.getInteger(29376) == this.getInteger(27769) || this.getInteger(29376) > this.getInteger(27769))) {
                    this.setInteger(16873, this.getInteger(27769));
                }
                if (this.getInteger(29376) == this.getInteger(27767) || this.getInteger(29376) > this.getInteger(27767)) {
                    this.setInteger(16873, this.getInteger(27767));
                }
                if (!this.getBoolean(-376438784)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                }
                this.triggerObserver(118161472);
                this.setBoolean(1275658496, true);
                this.showView("Tfls", bl, 8);
                break;
            }
            case 90: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1281396041);
                break;
            }
            case 91: {
                this.setInteger(-356843520, 2);
                this.setInteger(1796538624, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1796538624));
                this.triggerObserver(983508032, eventGeneric);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticTunerDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-356843520, 0);
                break;
            }
            case 8: {
                this.setInteger(22807, 0);
                this.setInteger(-1664614400, SkinDataPool.getInteger(180));
                this.setInteger(0x820000, 0);
                break;
            }
            case 19: {
                this.setInteger(22807, 0);
                this.setInteger(14862, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(14862));
                this.triggerObserver(1208287296, eventGeneric);
                this.setInteger(0x820000, 0);
                break;
            }
            case 29: {
                if (this.getInteger(20548) == 1) {
                    this.triggerObserver(-1727791040);
                }
                this.triggerObserver(-1593573312);
                break;
            }
            case 31: {
                this.hideView("Talm");
                this.triggerObserver(1359282240);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 32: {
                this.hideView("Tals");
                this.triggerObserver(-435945408);
                this.triggerObserver(134938688);
                this.setBoolean(1275658496, false);
                break;
            }
            case 34: {
                this.setBoolean(462290944, false);
                break;
            }
            case 36: {
                this.hideView("Tam_593A");
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                if (this.getBoolean(12614) && this.getBoolean(23839)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.triggerObserver(0x55050040);
                this.setBoolean(-1459814400, false);
                this.setInteger(-1664614400, SkinDataPool.getInteger(180));
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                Object object = TunerActivity.newEvent();
                ((EventGeneric)object).setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, (EventGeneric)object);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                this.setInteger(-1508245248, 1);
                this.setBoolean(985530368, false);
                this.setBoolean(966721536, false);
                this.setBoolean(-190775296, false);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -479687351);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -379024055);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -429355703);
                this.setInteger(31458, 3);
                object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(31458));
                this.triggerObserver(262087744, (EventGeneric)object);
                this.setBoolean(1947926784, false);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                break;
            }
            case 37: {
                this.setInteger(22807, 0);
                break;
            }
            case 43: {
                this.hideView("Taspl");
                break;
            }
            case 44: {
                this.hideView("Tasdp");
                this.setBoolean(11157, true);
                break;
            }
            case 45: {
                this.hideView("Tasm");
                break;
            }
            case 49: {
                this.setInteger(22807, 0);
                break;
            }
            case 55: {
                this.hideView("Tdspl");
                break;
            }
            case 56: {
                this.hideView("Tdsm");
                break;
            }
            case 57: {
                this.hideView("Tdsa");
                break;
            }
            case 58: {
                this.hideView("Tdsdp");
                this.setBoolean(11157, true);
                break;
            }
            case 59: {
                if (!this.getBoolean(17711)) break;
                this.triggerObserver(-670826432);
                break;
            }
            case 61: {
                this.triggerObserver(-1593573312);
                if (this.getInteger(2010775552) != 1) break;
                this.triggerObserver(-1727791040);
                break;
            }
            case 65: {
                this.hideView("Tdls");
                this.triggerObserver(134938688);
                this.setBoolean(1275658496, false);
                break;
            }
            case 66: {
                this.hideView("Tdhl");
                this.triggerObserver(1359282240);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 67: {
                this.hideView("Tdssl");
                this.triggerObserver(1359282240);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.triggerObserver(-1610350528);
                break;
            }
            case 68: {
                Object object;
                this.hideView("Tdm_86AD");
                this.setBoolean(22157, false);
                this.setBoolean(462290944, false);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                this.triggerObserver(0x55050040);
                this.setBoolean(-1459814400, false);
                this.setInteger(-1664614400, SkinDataPool.getInteger(180));
                if (this.getBoolean(12614) && this.getBoolean(23839)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (this.getBoolean(23839)) {
                    object = TunerActivity.newEvent();
                    ((EventGeneric)object).setBoolean(0, this.getBoolean(17118));
                    this.triggerObserver(-1023147968, (EventGeneric)object);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                this.setInteger(-1508245248, 1);
                this.setBoolean(29417, false);
                this.triggerObserver(252313664);
                this.setInteger(31458, 6);
                object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(31458));
                this.triggerObserver(262087744, (EventGeneric)object);
                this.setBoolean(1947926784, false);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                break;
            }
            case 71: {
                this.setInteger(22807, 0);
                break;
            }
            case 75: {
                this.hideView("Tfshcl");
                break;
            }
            case 77: {
                this.hideView("Tfspl");
                break;
            }
            case 78: {
                this.hideView("Tfsdp");
                this.setBoolean(11157, true);
                break;
            }
            case 79: {
                this.hideView("Tfsa");
                break;
            }
            case 80: {
                this.hideView("Tfsm");
                break;
            }
            case 82: {
                this.setBoolean(462290944, false);
                break;
            }
            case 84: {
                Object object;
                this.hideView("Tfm");
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.triggerObserver(0x55050040);
                this.setBoolean(-1459814400, false);
                this.setInteger(-1664614400, SkinDataPool.getInteger(180));
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (this.getBoolean(23839)) {
                    object = TunerActivity.newEvent();
                    ((EventGeneric)object).setBoolean(0, this.getBoolean(17118));
                    this.triggerObserver(-1023147968, (EventGeneric)object);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                this.setBoolean(985530368, false);
                this.setBoolean(966721536, false);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -479687351);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -379024055);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -429355703);
                this.setInteger(-1508245248, 1);
                this.setBoolean(-190775296, false);
                this.setInteger(31458, 0);
                object = TunerActivity.newEvent();
                ((EventGeneric)object).setInt(0, this.getInteger(31458));
                this.triggerObserver(262087744, (EventGeneric)object);
                this.setBoolean(1947926784, false);
                object = this.createModelApiDownEvent(39);
                object.setBoolean(0, this.getBoolean(1947926784));
                this.fireModelApiDownEvent((ModelApiDownEvent)object);
                break;
            }
            case 85: {
                this.setInteger(22807, 0);
                this.triggerObserver(-1593573312);
                break;
            }
            case 88: {
                this.hideView("Tflm");
                this.triggerObserver(1359282240);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 89: {
                this.hideView("Tfls");
                this.triggerObserver(-435945408);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.triggerObserver(134938688);
                this.setBoolean(1275658496, false);
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticTunerDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getInteger(0x2020100) == 1 && this.getBoolean(1619591168);
            }
            case 1: {
                return this.getInteger(0x2020100) == 1 && !this.getBoolean(1619591168);
            }
            case 2: {
                return this.getBoolean(837550080) || this.getBoolean(10548) || this.getBoolean(21917);
            }
            case 3: {
                return this.getInteger(18985) == 1 && !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(21917) && !this.getBoolean(23839) && !this.getBoolean(1275658496);
            }
            case 4: {
                return this.getBoolean(837550080) || this.getBoolean(10548) || this.getBoolean(21917);
            }
            case 5: {
                return this.getInteger(18985) == 1 && !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(21917) && !this.getBoolean(23839) && !this.getBoolean(1275658496);
            }
            case 6: {
                return this.getInteger(18985) == 1 && !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(21917);
            }
            case 7: {
                return this.getInteger(18985) == 1 && !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(21917);
            }
            case 9: {
                return this.getInteger(-1245773824) == 2;
            }
            case 10: {
                return this.getInteger(0x820000) == 4 || this.getInteger(0x820000) == 13 || this.getInteger(0x820000) == 18 || this.getInteger(0x820000) == 23 || this.getInteger(0x820000) == 22 || this.getInteger(0x820000) == 26 && this.getInteger(18985) == 6;
            }
            case 11: {
                return this.getInteger(29005) < 3 && this.getInteger(-1814626304) == 0;
            }
            case 12: {
                return this.getInteger(29005) < 3 && this.getInteger(-1814626304) == 1;
            }
            case 13: {
                return this.getInteger(29005) > 2;
            }
            case 14: {
                return this.getInteger(23328) == 1;
            }
            case 15: {
                return this.getInteger(23328) == 0;
            }
            case 16: {
                return !this.getBoolean(10548) && !this.getBoolean(17711) && !this.getBoolean(837550080) && !this.getBoolean(21917) && !this.getBoolean(23839) && !this.getBoolean(11006) && this.getBoolean(-1358495488);
            }
            case 19: {
                return !this.getBoolean(19517);
            }
            case 21: {
                return this.getInteger(0x2020100) == 1;
            }
            case 23: {
                return this.getInteger(1797128448) != 0;
            }
            case 24: {
                return this.getInteger(1797128448) != 1;
            }
            case 25: {
                return this.getInteger(1797128448) != 2;
            }
            case 27: {
                return this.getBoolean(17711);
            }
            case 28: {
                return !this.getBoolean(23839);
            }
            case 29: {
                return this.getBoolean(23839);
            }
            case 30: {
                return this.getBoolean(23839);
            }
            case 31: {
                return this.getBoolean(23839);
            }
            case 32: {
                return this.getBoolean(17711);
            }
            case 33: {
                return !this.getBoolean(23839);
            }
            case 34: {
                return this.getBoolean(23839) && !this.getBoolean(12614);
            }
            case 35: {
                return this.getBoolean(23839) && this.getBoolean(12614);
            }
            case 36: {
                return this.getBoolean(23839);
            }
            case 37: {
                return this.getBoolean(17711);
            }
            case 38: {
                return !this.getBoolean(23839);
            }
            case 39: {
                return this.getBoolean(23839);
            }
            case 40: {
                return this.getBoolean(23839);
            }
            case 41: {
                return this.getBoolean(23839);
            }
            case 42: {
                return this.getBoolean(17711);
            }
            case 43: {
                return !this.getBoolean(23839);
            }
            case 44: {
                return this.getBoolean(23839) && !this.getBoolean(12614);
            }
            case 45: {
                return this.getBoolean(23839) && this.getBoolean(12614);
            }
            case 46: {
                return this.getBoolean(23839);
            }
            case 55: {
                return this.getBoolean(23839);
            }
            case 56: {
                return this.getBoolean(23839);
            }
            case 62: {
                return this.getBoolean(23839);
            }
            case 68: {
                return this.getBoolean(23839);
            }
            case 69: {
                return !this.getBoolean(23839);
            }
            case 70: {
                return this.getBoolean(23839);
            }
            case 71: {
                return this.getBoolean(23839);
            }
            case 72: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 73: {
                return !this.getBoolean(17711) && !this.getBoolean(23839) && (!this.getBoolean(13866) || this.getBoolean(1021640704));
            }
            case 74: {
                return !this.getBoolean(17711) && !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704) && this.getInteger(1049624576) == 4;
            }
            case 75: {
                return this.getBoolean(23839);
            }
            case 86: {
                return this.getBoolean(17711);
            }
            case 87: {
                return this.getBoolean(17711);
            }
            case 88: {
                return this.getBoolean(23839);
            }
            case 89: {
                return this.getBoolean(23839) && !this.getBoolean(12614);
            }
            case 90: {
                return this.getBoolean(23839);
            }
            case 97: {
                return this.getBoolean(23839);
            }
            case 98: {
                return this.getInteger(1108738304) == this.getInteger(1797128448);
            }
            case 99: {
                return this.getInteger(1108738304) == this.getInteger(1797128448);
            }
            case 100: {
                return this.getInteger(1108738304) == this.getInteger(1797128448);
            }
            case 106: {
                return this.getInteger(1797128448) == 0;
            }
            case 107: {
                return this.getInteger(1797128448) == 1;
            }
            case 108: {
                return this.getInteger(1797128448) == 2;
            }
            case 109: {
                return !this.getBoolean(23839);
            }
            case 110: {
                return !this.getBoolean(23839);
            }
            case 111: {
                return this.getBoolean(32205);
            }
            case 113: {
                return TunerActivity.evIntegerValueValue() == 0;
            }
            case 114: {
                return TunerActivity.evIntegerValueValue() == 1;
            }
            case 115: {
                return TunerActivity.evIntegerValueValue() == 2;
            }
            case 125: {
                return this.getBoolean(17711);
            }
            case 126: {
                return !this.getBoolean(17711);
            }
            case 128: {
                return this.getBoolean(17711);
            }
            case 129: {
                return !this.getBoolean(17711);
            }
            case 130: {
                return this.getBoolean(17711);
            }
            case 131: {
                return !this.getBoolean(17711);
            }
            case 133: {
                return this.getBoolean(17711);
            }
            case 134: {
                return !this.getBoolean(17711);
            }
            case 143: {
                return this.getInteger(20548) == 0 && !this.getBoolean(-1313734656);
            }
            case 144: {
                return this.getInteger(20548) == 0;
            }
            case 145: {
                return this.getInteger(20548) == 1;
            }
            case 161: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 162: {
                return !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704);
            }
            case 163: {
                return !this.getBoolean(23839) && (!this.getBoolean(13866) || this.getBoolean(1021640704));
            }
            case 164: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 165: {
                return !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704);
            }
            case 166: {
                return !this.getBoolean(23839) && (!this.getBoolean(13866) || this.getBoolean(1021640704));
            }
            case 167: {
                return this.getBoolean(23839);
            }
            case 168: {
                return this.getBoolean(17711);
            }
            case 169: {
                return this.getBoolean(837550080);
            }
            case 170: {
                return this.getBoolean(10548);
            }
            case 171: {
                return this.getBoolean(21917);
            }
            case 172: {
                return !this.getBoolean(837550080) && !this.getBoolean(10548) && this.getBoolean(12357) && !this.getBoolean(17711) && !this.getBoolean(21917) && !this.getBoolean(23839);
            }
            case 173: {
                return !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(17711) && !this.getBoolean(21917) && !this.getBoolean(12357) && !this.getBoolean(23839);
            }
            case 174: {
                return this.getBoolean(10548) && this.getBoolean(23839);
            }
            case 175: {
                return this.getBoolean(21917) && this.getBoolean(23839);
            }
            case 176: {
                return this.getBoolean(837550080) && this.getBoolean(23839);
            }
            case 177: {
                return this.getBoolean(837550080) && !this.getBoolean(23839);
            }
            case 178: {
                return this.getBoolean(32205);
            }
            case 179: {
                return this.getBoolean(32205);
            }
            case 180: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(10535) == 0;
            }
            case 181: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(10535) == 0;
            }
            case 182: {
                return this.getBoolean(17711);
            }
            case 189: {
                return TunerActivity.evListItemEventSender().equals("Button_delete");
            }
            case 190: {
                return TunerActivity.evListItemEventSender().equals("Button_load");
            }
            case 192: {
                return this.getBoolean(1619591168);
            }
            case 193: {
                return !this.getBoolean(1619591168);
            }
            case 194: {
                return this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 195: {
                return !this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 201: {
                return TunerActivity.evIntegerValueValue() == 0;
            }
            case 202: {
                return TunerActivity.evIntegerValueValue() == 1;
            }
            case 203: {
                return TunerActivity.evIntegerValueValue() == 2;
            }
            case 204: {
                return this.getBoolean(17711);
            }
            case 211: {
                return this.getBoolean(24652);
            }
            case 212: {
                return !this.getBoolean(24652);
            }
            case 213: {
                return TunerActivity.evListItemEventSender().equals("Button_delete");
            }
            case 214: {
                return TunerActivity.evListItemEventSender().equals("Button_load");
            }
            case 215: {
                return this.getBoolean(1619591168);
            }
            case 216: {
                return !this.getBoolean(1619591168);
            }
            case 217: {
                return this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 218: {
                return !this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 219: {
                return !this.getBoolean(-1783955456);
            }
            case 220: {
                return this.getBoolean(-1783955456);
            }
            case 221: {
                return this.getBoolean(-960299008);
            }
            case 222: {
                return !this.getBoolean(-960299008);
            }
            case 223: {
                return this.getBoolean(10139);
            }
            case 224: {
                return !this.getBoolean(10139);
            }
            case 225: {
                return this.getBoolean(0x1C0100);
            }
            case 226: {
                return !this.getBoolean(0x1C0100);
            }
            case 227: {
                return !this.getBoolean(-518389504);
            }
            case 228: {
                return this.getBoolean(-518389504);
            }
            case 258: {
                return this.getInteger(-1650851840) < 0 || this.getInteger(-1650851840) != TunerActivity.evListItemActionIndex();
            }
            case 259: {
                return this.getInteger(-1650851840) == TunerActivity.evListItemActionIndex() && this.getInteger(-1650851840) >= 0;
            }
            case 262: {
                return this.getInteger(2010775552) == 0;
            }
            case 263: {
                return this.getInteger(2010775552) == 1;
            }
            case 264: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("Button");
            }
            case 265: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("AdditionalService");
            }
            case 266: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("AdditionalService_long");
            }
            case 267: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("AdditionalService");
            }
            case 268: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("AdditionalService_long");
            }
            case 269: {
                return this.getInteger(2010775552) == 0 && !this.getBoolean(-1313734656);
            }
            case 273: {
                return this.getInteger(112328704) != 2;
            }
            case 274: {
                return this.getInteger(112328704) != 2;
            }
            case 275: {
                return this.getInteger(112328704) != 2;
            }
            case 276: {
                return this.getInteger(112328704) != 2;
            }
            case 277: {
                return this.getInteger(112328704) == 1 || this.getInteger(112328704) == 2;
            }
            case 278: {
                return !this.getBoolean(23839) && !this.getBoolean(12614);
            }
            case 279: {
                return !this.getBoolean(23839) && !this.getBoolean(12614);
            }
            case 287: {
                return this.getInteger(18303) == 1 && !this.getBoolean(471990528) && !this.getBoolean(-855310080) && !this.getBoolean(32205);
            }
            case 288: {
                return this.getInteger(18303) == 1;
            }
            case 289: {
                return this.getInteger(18303) == 1 && this.getBoolean(-855310080) && !this.getBoolean(32205);
            }
            case 292: {
                return !this.getBoolean(23839);
            }
            case 294: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 295: {
                return !this.getBoolean(23839);
            }
            case 296: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 297: {
                return !this.getBoolean(23839);
            }
            case 298: {
                return this.getBoolean(23839);
            }
            case 299: {
                return this.getBoolean(17711);
            }
            case 300: {
                return this.getBoolean(837550080);
            }
            case 301: {
                return this.getBoolean(10548);
            }
            case 302: {
                return this.getBoolean(21917);
            }
            case 303: {
                return !this.getBoolean(10548) && !this.getBoolean(17711) && !this.getBoolean(837550080) && !this.getBoolean(21917) && !this.getBoolean(23839);
            }
            case 305: {
                return this.getBoolean(10548);
            }
            case 306: {
                return this.getBoolean(837550080);
            }
            case 307: {
                return this.getBoolean(21917) && this.getBoolean(23839);
            }
            case 308: {
                return this.getBoolean(23839);
            }
            case 310: {
                return this.getBoolean(23839);
            }
            case 312: {
                return this.getInteger(-741736448) != 1;
            }
            case 313: {
                return this.getInteger(18303) != 1;
            }
            case 314: {
                return this.getBoolean(29417);
            }
            case 315: {
                return this.getBoolean(32205);
            }
            case 316: {
                return this.getBoolean(32205);
            }
            case 317: {
                return !this.getBoolean(311754752) && !this.getBoolean(-1291648768);
            }
            case 318: {
                return !this.getBoolean(311754752) && !this.getBoolean(1673068544) && this.getBoolean(32205);
            }
            case 319: {
                return !this.getBoolean(311754752) && !this.getBoolean(1673068544) && this.getBoolean(32205);
            }
            case 320: {
                return this.getBoolean(32205) && this.getBoolean(1673068544) && this.getInteger(18303) == 1 && (!this.getBoolean(311754752) || !this.getBoolean(471990528));
            }
            case 321: {
                return this.getInteger(18303) == 1 && this.getBoolean(32205) && !this.getBoolean(1673068544) && (!this.getBoolean(311754752) || !this.getBoolean(471990528));
            }
            case 322: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(29746) == 0;
            }
            case 323: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(29746) == 0;
            }
            case 325: {
                return TunerActivity.evIntegerValueValue() == 0;
            }
            case 326: {
                return TunerActivity.evIntegerValueValue() == 1;
            }
            case 327: {
                return TunerActivity.evIntegerValueValue() == 2;
            }
            case 328: {
                return this.getBoolean(17711);
            }
            case 337: {
                return TunerActivity.evListItemEventSender().equals("Button_delete");
            }
            case 338: {
                return TunerActivity.evListItemEventSender().equals("Button_load");
            }
            case 340: {
                return !this.getBoolean(17970);
            }
            case 341: {
                return !this.getBoolean(1173618688);
            }
            case 344: {
                return this.getBoolean(17970);
            }
            case 345: {
                return this.getBoolean(1173618688);
            }
            case 349: {
                return this.getBoolean(1619591168);
            }
            case 350: {
                return !this.getBoolean(1619591168);
            }
            case 351: {
                return this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 352: {
                return !this.getBoolean(1619591168) && this.getBoolean(690422016);
            }
            case 359: {
                return this.getBoolean(1657274368) && !this.getBoolean(25920) && this.getBoolean(1173618688);
            }
            case 360: {
                return this.getBoolean(1657274368) && this.getBoolean(25920) && this.getBoolean(1173618688);
            }
            case 364: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 365: {
                return !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704);
            }
            case 366: {
                return !this.getBoolean(23839) && (!this.getBoolean(13866) || this.getBoolean(1021640704));
            }
            case 367: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 368: {
                return !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704) && this.getInteger(1049624576) != 4;
            }
            case 369: {
                return !this.getBoolean(23839) && (!this.getBoolean(13866) || this.getBoolean(1021640704));
            }
            case 370: {
                return !this.getBoolean(23839) && this.getBoolean(13866) && !this.getBoolean(1021640704) && this.getInteger(1049624576) == 4;
            }
            case 371: {
                return this.getBoolean(17711) && !this.getBoolean(23839);
            }
            case 372: {
                return this.getBoolean(837550080) && !this.getBoolean(23839);
            }
            case 373: {
                return this.getBoolean(10548) && !this.getBoolean(23839);
            }
            case 374: {
                return !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(17711) && !this.getBoolean(21917) && !this.getBoolean(23839) && this.getBoolean(-1358495488);
            }
            case 375: {
                return !this.getBoolean(837550080) && !this.getBoolean(10548) && !this.getBoolean(17711) && !this.getBoolean(21917) && !this.getBoolean(23839) && !this.getBoolean(-1358495488) && this.getBoolean(12357) && !this.getBoolean(12614);
            }
            case 376: {
                return this.getBoolean(21917) && !this.getBoolean(23839);
            }
            case 377: {
                return this.getBoolean(23839);
            }
            case 378: {
                return this.getBoolean(10548) && this.getBoolean(23839);
            }
            case 379: {
                return this.getBoolean(21917) && this.getBoolean(23839);
            }
            case 380: {
                return this.getBoolean(837550080) && !this.getBoolean(23839);
            }
            case 381: {
                return this.getBoolean(837550080) && !this.getBoolean(23839);
            }
            case 382: {
                return this.getBoolean(837550080) && this.getBoolean(23839);
            }
            case 383: {
                return this.getBoolean(32205);
            }
            case 384: {
                return this.getBoolean(32205);
            }
            case 385: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(-1249181696) == 0;
            }
            case 386: {
                return this.getBoolean(17711) || this.getBoolean(23839) || this.getInteger(-1249181696) == 0;
            }
            case 393: {
                return this.getInteger(1890451456) != 1;
            }
            case 394: {
                return this.getInteger(1890451456) != 0;
            }
            case 395: {
                return this.getInteger(1890451456) != 3;
            }
            case 399: {
                return this.getBoolean(17711);
            }
            case 400: {
                return !this.getBoolean(17711);
            }
            case 402: {
                return this.getBoolean(17711);
            }
            case 403: {
                return !this.getBoolean(17711);
            }
            case 405: {
                return this.getBoolean(17711);
            }
            case 406: {
                return !this.getBoolean(17711);
            }
            case 408: {
                return this.getBoolean(17711);
            }
            case 409: {
                return !this.getBoolean(17711);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticTunerDynState(int n) {
        this.performInternalTransitionAction_SubHapticTunerDynState000(n);
        this.performInternalTransitionAction_SubHapticTunerDynState300(n);
    }

    private void performInternalTransitionAction_SubHapticTunerDynState000(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 1: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 2: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                break;
            }
            case 3: {
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1962672064);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(0x4F040040);
                break;
            }
            case 4: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                break;
            }
            case 5: {
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1895563200);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(1375993920);
                break;
            }
            case 6: {
                this.triggerObserver(-1962672064);
                break;
            }
            case 7: {
                this.triggerObserver(-1895563200);
                break;
            }
            case 8: {
                this.setInteger(22807, 2);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 9: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                break;
            }
            case 10: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1633717577);
                break;
            }
            case 11: {
                this.setInteger(29005, this.getInteger(29005) + 1);
                this.setInteger(-1814626304, 1);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1268282039);
                break;
            }
            case 12: {
                this.setInteger(29005, this.getInteger(29005) + 1);
                this.setInteger(-1814626304, 0);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1268282039);
                break;
            }
            case 13: {
                this.setInteger(29005, 0);
                this.setInteger(-1814626304, this.getInteger(23328));
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1251504823);
                break;
            }
            case 14: {
                this.setInteger(-1814626304, this.getInteger(23328));
                this.setInteger(29005, 0);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1268282039);
                break;
            }
            case 15: {
                this.setInteger(-1814626304, this.getInteger(23328));
                break;
            }
            case 16: {
                this.setInteger(-487522304, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 17: {
                this.setInteger(-1664614400, SkinDataPool.getInteger(190));
                break;
            }
            case 18: {
                this.setInteger(-1664614400, SkinDataPool.getInteger(180));
                break;
            }
            case 20: {
                if (this.getListItemControl(1461, true).getItemCount() == 15) {
                    this.setInteger(27767, 10);
                }
                if (this.getListItemControl(1461, true).getItemCount() == 18) {
                    this.setInteger(27767, 12);
                }
                if (this.getListItemControl(1461, true).getItemCount() == 15) {
                    this.setInteger(27769, 5);
                }
                if (this.getListItemControl(1461, true).getItemCount() != 18) break;
                this.setInteger(27769, 6);
                break;
            }
            case 22: {
                this.setInteger(1021706240, this.getInteger(1384448000));
                this.setInteger(32204, 1);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 23: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.setInteger(-487522304, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 24: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.setInteger(-487522304, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 25: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-487522304, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 26: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.setInteger(-487522304, 4);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 27: {
                this.triggerObserver(-670826432);
                break;
            }
            case 28: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1962672064);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(0x4F040040);
                break;
            }
            case 29: {
                this.setInteger(-454426624, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-454426624));
                this.triggerObserver(-788266944, eventGeneric);
                break;
            }
            case 30: {
                this.triggerObserver(-620494784);
                break;
            }
            case 31: {
                this.triggerObserver(-620494784);
                break;
            }
            case 32: {
                this.triggerObserver(-670826432);
                break;
            }
            case 33: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1962672064);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(0x4F040040);
                break;
            }
            case 34: {
                this.setInteger(-476250112, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-476250112));
                this.triggerObserver(-805044160, eventGeneric);
                break;
            }
            case 35: {
                this.triggerObserver(-654049216);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 36: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 37: {
                this.triggerObserver(-670826432);
                break;
            }
            case 38: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1895563200);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(1375993920);
                break;
            }
            case 39: {
                this.setInteger(-454426624, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-454426624));
                this.triggerObserver(-788266944, eventGeneric);
                break;
            }
            case 40: {
                this.triggerObserver(-620494784);
                break;
            }
            case 41: {
                this.triggerObserver(-620494784);
                break;
            }
            case 42: {
                this.triggerObserver(-670826432);
                break;
            }
            case 43: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1895563200);
                }
                if (this.getInteger(1797128448) != 3) break;
                this.triggerObserver(1375993920);
                break;
            }
            case 44: {
                this.setInteger(-476250112, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-476250112));
                this.triggerObserver(-805044160, eventGeneric);
                break;
            }
            case 45: {
                this.triggerObserver(-654049216);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 46: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 47: {
                this.triggerObserver(-855375808);
                break;
            }
            case 48: {
                this.triggerObserver(-754712512);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 49: {
                this.triggerObserver(-1509687232);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 50: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 51: {
                this.triggerObserver(-872153024);
                break;
            }
            case 52: {
                this.triggerObserver(-754712512);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 53: {
                this.triggerObserver(-1711013824);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 54: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 55: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 56: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 57: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-1257176832, TunerActivity.evIntegerValueValue());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1257176832));
                this.triggerObserver(-1123811264, eventGeneric);
                break;
            }
            case 58: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (!this.getBoolean(23839)) break;
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 59: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                if (!this.getBoolean(23839)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 60: {
                this.triggerObserver(-452722624);
                break;
            }
            case 61: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                this.triggerObserver(-452722624);
                break;
            }
            case 62: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 63: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1532661065);
                break;
            }
            case 64: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1515883849);
                break;
            }
            case 65: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1084191415);
                break;
            }
            case 66: {
                this.setInteger(-1667497984, this.getInteger(1797128448));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1667497984));
                this.triggerObserver(-1694236608, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1084191415);
                break;
            }
            case 67: {
                if (this.getBoolean(-1685913600)) {
                    this.setBoolean(30222, false);
                }
                if (!this.getBoolean(-1685913600)) {
                    this.setBoolean(30222, true);
                }
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(30222));
                this.triggerObserver(-972816320, eventGeneric);
                break;
            }
            case 68: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 69: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 70: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                if (!this.getBoolean(12614)) break;
                this.triggerObserver(-654049216);
                break;
            }
            case 71: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 72: {
                this.triggerObserver(-670826432);
                break;
            }
            case 73: {
                this.triggerObserver(-821821376);
                if (this.getInteger(1797128448) != 2) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1654747831);
                break;
            }
            case 74: {
                this.triggerObserver(-821821376);
                if (this.getInteger(1797128448) != 2) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1654747831);
                break;
            }
            case 75: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 76: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1721856695);
                break;
            }
            case 77: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1705079479);
                break;
            }
            case 78: {
                this.setBoolean(16349, true);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1688302263);
                break;
            }
            case 79: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1671525047);
                break;
            }
            case 80: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1621193399);
                break;
            }
            case 81: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1604416183);
                break;
            }
            case 82: {
                this.setBoolean(16349, true);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1587638967);
                break;
            }
            case 83: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1570861751);
                break;
            }
            case 84: {
                this.setInteger(21122, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21122));
                this.triggerObserver(-922484672, eventGeneric);
                break;
            }
            case 85: {
                this.setInteger(21122, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(21122));
                this.triggerObserver(-922484672, eventGeneric);
                break;
            }
            case 86: {
                this.triggerObserver(-670826432);
                break;
            }
            case 87: {
                this.triggerObserver(-670826432);
                break;
            }
            case 88: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 89: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 90: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 91: {
                if (!this.getBoolean(17711)) break;
                this.triggerObserver(-670826432);
                break;
            }
            case 92: {
                if (!this.getBoolean(17711)) break;
                this.triggerObserver(-670826432);
                break;
            }
            case 93: {
                this.triggerObserver(-16515008);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 94: {
                this.triggerObserver(327744);
                if (!this.getBoolean(23839)) break;
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                break;
            }
            case 95: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                this.setInteger(14862, 10);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(14862));
                this.triggerObserver(1208287296, eventGeneric);
                this.setInteger(-303562752, this.getInteger(-81592064));
                this.setInteger(805044224, this.getInteger(22872));
                this.setInteger(-450428672, this.getInteger(-2079063808));
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-450428672));
                eventGeneric.setInt(1, this.getInteger(805044224));
                eventGeneric.setInt(2, this.getInteger(-303562752));
                this.triggerObserver(889520192, eventGeneric);
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.triggerObserver(1258618944);
                this.setInteger(-1508245248, 0);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 96: {
                this.setInteger(14862, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(14862));
                this.triggerObserver(1208287296, eventGeneric);
                this.triggerObserver(1359282240);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                if (!this.getBoolean(-1291648768)) {
                    this.triggerObserver(0x55050040);
                }
                this.setInteger(-1508245248, 1);
                break;
            }
            case 97: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 98: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -496464567);
                this.setBoolean(966721536, true);
                break;
            }
            case 99: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -446132919);
                this.setBoolean(-190775296, true);
                break;
            }
            case 100: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -395801271);
                this.setBoolean(985530368, true);
                break;
            }
            case 101: {
                this.setBoolean(-190775296, false);
                break;
            }
            case 102: {
                this.setBoolean(966721536, false);
                break;
            }
            case 103: {
                this.setBoolean(985530368, false);
                break;
            }
            case 104: {
                this.setInteger(27884, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
            case 105: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 106: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 107: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 108: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 109: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1962672064);
                }
                if (this.getInteger(1797128448) == 3) {
                    this.triggerObserver(0x4F040040);
                }
                this.setInteger(29686, 1);
                this.setBoolean(1889140736, true);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
            case 110: {
                if (this.getInteger(21957) == 0) {
                    this.setBoolean(181927936, true);
                }
                if (this.getInteger(1797128448) != 3) {
                    this.triggerObserver(-1895563200);
                }
                if (this.getInteger(1797128448) == 3) {
                    this.triggerObserver(1375993920);
                }
                this.setInteger(29686, 0);
                this.setBoolean(1889140736, true);
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                break;
            }
            case 111: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1331727689);
                break;
            }
            case 113: {
                this.setInteger(296484864, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(296484864));
                this.triggerObserver(-1073479616, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-1619001344, 0);
                break;
            }
            case 114: {
                this.setInteger(296484864, this.getInteger(27769));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(296484864));
                this.triggerObserver(-1073479616, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-1619001344, 1);
                break;
            }
            case 115: {
                this.setInteger(296484864, this.getInteger(27767));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(296484864));
                this.triggerObserver(-1073479616, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-1619001344, 2);
                break;
            }
            case 116: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 117: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 118: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 119: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 120: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 121: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 122: {
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                this.setInteger(366018560, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(366018560));
                this.triggerObserver(-1845231552, eventGeneric);
                this.triggerObserver(-435945408);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 123: {
                this.setInteger(194183168, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(194183168));
                this.triggerObserver(-1526464448, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 124: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 125: {
                this.triggerObserver(-670826432);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 126: {
                this.triggerObserver(-1979449280);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 127: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 128: {
                this.triggerObserver(-670826432);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 129: {
                this.triggerObserver(-1979449280);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 130: {
                this.triggerObserver(-670826432);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 131: {
                this.triggerObserver(-1929117632);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 132: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 133: {
                this.triggerObserver(-670826432);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 134: {
                this.triggerObserver(-1929117632);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 135: {
                this.triggerObserver(-402390976);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(-1313734656, false);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -311915191);
                this.setBoolean(19259, true);
                break;
            }
            case 136: {
                this.triggerObserver(-1727791040);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -295137975);
                this.setBoolean(19259, false);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 137: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(16349, true);
                break;
            }
            case 138: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(16349, true);
                break;
            }
            case 139: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 140: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 141: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 142: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 143: {
                this.setBoolean(19259, false);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 144: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -295137975);
                this.setBoolean(19259, false);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 145: {
                this.setBoolean(-1313734656, false);
                break;
            }
            case 146: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 147: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 148: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 150: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 155: {
                this.setInteger(1302003712, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1302003712));
                this.triggerObserver(-1325137856, eventGeneric);
                break;
            }
            case 156: {
                this.setInteger(1302003712, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1302003712));
                this.triggerObserver(-1325137856, eventGeneric);
                break;
            }
            case 157: {
                this.triggerObserver(-670826432);
                break;
            }
            case 158: {
                EventGeneric eventGeneric;
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (this.getBoolean(23839)) {
                    eventGeneric = TunerActivity.newEvent();
                    eventGeneric.setBoolean(0, this.getBoolean(17118));
                    this.triggerObserver(-1023147968, eventGeneric);
                }
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(319947008, TunerActivity.evListItemActionIndex());
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(319947008));
                this.triggerObserver(-1811677120, eventGeneric);
                this.triggerObserver(-452722624);
                break;
            }
            case 159: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.triggerObserver(-1543241664);
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 160: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 161: {
                this.triggerObserver(-670826432);
                break;
            }
            case 162: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 163: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 164: {
                this.triggerObserver(-670826432);
                break;
            }
            case 165: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 166: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 167: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 168: {
                this.triggerObserver(-670826432);
                break;
            }
            case 169: {
                this.triggerObserver(-586940352);
                break;
            }
            case 170: {
                this.triggerObserver(-737935296);
                break;
            }
            case 171: {
                this.triggerObserver(-721158080);
                break;
            }
            case 172: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-487522304, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 173: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-487522304, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 174: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 175: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 176: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 177: {
                this.triggerObserver(-670826432);
                break;
            }
            case 178: {
                this.triggerObserver(1258618944);
                this.setBoolean(-1291648768, true);
                break;
            }
            case 179: {
                this.triggerObserver(0x55050040);
                this.setBoolean(-1291648768, false);
                break;
            }
            case 180: {
                this.setInteger(29686, 1);
                this.setBoolean(1889140736, false);
                if (this.getInteger(-1619001344) < 2) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -546796215);
                break;
            }
            case 181: {
                this.setInteger(29686, 0);
                this.setBoolean(1889140736, false);
                if (this.getInteger(-1619001344) > 0) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -530018999);
                break;
            }
            case 182: {
                this.triggerObserver(-670826432);
                break;
            }
            case 189: {
                this.setInteger(11897, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -899248823);
                break;
            }
            case 190: {
                this.setInteger(-543227904, TunerActivity.evListItemActionIndex());
                this.setInteger(1021706240, 10);
                this.setInteger(22807, 4);
                this.setInteger(780271616, 2);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1247841609);
                break;
            }
            case 191: {
                this.setInteger(1825636352, 0);
                this.setInteger(769982464, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 593595721);
                break;
            }
            case 192: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 193: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 194: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 195: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 197: {
                this.triggerObserver(-637272000);
                break;
            }
            case 198: {
                this.triggerObserver(-637272000);
                break;
            }
            case 199: {
                this.triggerObserver(-637272000);
                break;
            }
            case 200: {
                this.triggerObserver(-637272000);
                break;
            }
            case 201: {
                this.setInteger(-1882914816, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1882914816));
                this.triggerObserver(-1056702400, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(23664, 0);
                break;
            }
            case 202: {
                this.setInteger(-1882914816, this.getInteger(27769));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1882914816));
                this.triggerObserver(-1056702400, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(23664, 1);
                break;
            }
            case 203: {
                this.setInteger(-1882914816, this.getInteger(27767));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1882914816));
                this.triggerObserver(-1056702400, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(23664, 2);
                break;
            }
            case 204: {
                this.triggerObserver(-670826432);
                break;
            }
            case 211: {
                this.setBoolean(539492608, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(539492608));
                this.triggerObserver(-1190920128, eventGeneric);
                break;
            }
            case 212: {
                this.setBoolean(539492608, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(539492608));
                this.triggerObserver(-1190920128, eventGeneric);
                break;
            }
            case 213: {
                this.setInteger(11897, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -899248823);
                break;
            }
            case 214: {
                this.setInteger(-543227904, TunerActivity.evListItemActionIndex());
                this.setInteger(1510277376, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1510277376));
                this.triggerObserver(-905707456, eventGeneric);
                this.setBoolean(21249, this.getBoolean(-1063452672));
                this.setInteger(1021706240, 10);
                this.setInteger(22807, 4);
                this.setInteger(780271616, 2);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1247841609);
                break;
            }
            case 215: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 216: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 217: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 218: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 219: {
                this.setBoolean(-340459520, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-340459520));
                this.triggerObserver(-1274806208, eventGeneric);
                break;
            }
            case 220: {
                this.setBoolean(-340459520, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-340459520));
                this.triggerObserver(-1274806208, eventGeneric);
                break;
            }
            case 221: {
                this.setBoolean(29687, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(29687));
                this.triggerObserver(-1224474560, eventGeneric);
                break;
            }
            case 222: {
                this.setBoolean(29687, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(29687));
                this.triggerObserver(-1224474560, eventGeneric);
                break;
            }
            case 223: {
                this.setBoolean(28409, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(28409));
                this.triggerObserver(-1207697344, eventGeneric);
                break;
            }
            case 224: {
                this.setBoolean(28409, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(28409));
                this.triggerObserver(-1207697344, eventGeneric);
                break;
            }
            case 225: {
                this.setBoolean(1324613632, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1324613632));
                this.triggerObserver(144647232, eventGeneric);
                break;
            }
            case 226: {
                this.setBoolean(1324613632, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1324613632));
                this.triggerObserver(144647232, eventGeneric);
                break;
            }
            case 227: {
                this.setBoolean(26699, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(26699));
                this.triggerObserver(-1291583424, eventGeneric);
                break;
            }
            case 228: {
                this.setBoolean(26699, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(26699));
                this.triggerObserver(-1291583424, eventGeneric);
                break;
            }
            case 229: {
                if (this.getBoolean(12291)) {
                    this.setBoolean(-1078591488, false);
                }
                if (!this.getBoolean(12291)) {
                    this.setBoolean(-1078591488, true);
                }
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1078591488));
                this.triggerObserver(-1073151936, eventGeneric);
                break;
            }
            case 230: {
                this.setInteger(1825636352, 2);
                this.setInteger(769982464, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 593595721);
                break;
            }
            case 231: {
                if (this.getInteger(112328704) == 2) {
                    this.triggerObserver(-1996226496);
                }
                if (this.getInteger(112328704) != 2) {
                    this.triggerObserver(-1979449280);
                }
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 232: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 233: {
                if (this.getInteger(112328704) == 2) {
                    this.triggerObserver(-1996226496);
                }
                if (this.getInteger(112328704) != 2) {
                    this.triggerObserver(-1979449280);
                }
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 234: {
                if (this.getBoolean(-376438784)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                }
                this.setBoolean(16349, true);
                break;
            }
            case 235: {
                if (this.getInteger(112328704) == 2) {
                    this.triggerObserver(-1945894848);
                }
                if (this.getInteger(112328704) != 2) {
                    this.triggerObserver(-1929117632);
                }
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 236: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 237: {
                if (this.getBoolean(-376438784)) {
                    TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                }
                this.setBoolean(16349, true);
                break;
            }
            case 238: {
                if (this.getInteger(112328704) == 2) {
                    this.triggerObserver(-1945894848);
                }
                if (this.getInteger(112328704) != 2) {
                    this.triggerObserver(-1929117632);
                }
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 239: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 240: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 241: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 242: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 244: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 245: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 246: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 247: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 248: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 249: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 250: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 251: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 252: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 258: {
                this.setInteger(-937819904, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-937819904));
                this.triggerObserver(-1392246720, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 259: {
                this.setInteger(-937819904, -1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-937819904));
                this.triggerObserver(-1392246720, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 260: {
                this.triggerObserver(-402390976);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                this.setBoolean(-1313734656, true);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -311915191);
                this.setBoolean(19259, true);
                break;
            }
            case 261: {
                this.triggerObserver(-1727791040);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -295137975);
                this.setBoolean(19259, false);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 262: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -295137975);
                this.setBoolean(19259, false);
                this.setBoolean(-1313734656, false);
                break;
            }
            case 263: {
                this.setBoolean(-1313734656, false);
                break;
            }
            case 264: {
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                this.setInteger(17372, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17372));
                this.triggerObserver(-2063335360, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 265: {
                this.setInteger(28703, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28703));
                this.triggerObserver(-1492910016, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1067676343);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 266: {
                this.setInteger(28703, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28703));
                this.triggerObserver(-1492910016, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1067676343);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 267: {
                this.setInteger(28703, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28703));
                this.triggerObserver(-1492910016, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1067676343);
                if (this.getBoolean(-376438784) && this.getBoolean(471990528)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 268: {
                this.setInteger(28703, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(28703));
                this.triggerObserver(-1492910016, eventGeneric);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1067676343);
                if (this.getBoolean(-376438784) && this.getBoolean(471990528)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 269: {
                this.setBoolean(19259, false);
                break;
            }
            case 270: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 271: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 272: {
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                this.setInteger(-891748352, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-891748352));
                this.triggerObserver(-1862008768, eventGeneric);
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 273: {
                this.triggerObserver(-1979449280);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 274: {
                this.triggerObserver(-1979449280);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 275: {
                this.triggerObserver(-1929117632);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 276: {
                this.triggerObserver(-1929117632);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 277: {
                this.triggerObserver(-2113667008);
                break;
            }
            case 278: {
                this.triggerObserver(-2013003712);
                break;
            }
            case 279: {
                this.triggerObserver(-1912340416);
                break;
            }
            case 280: {
                this.setInteger(953024512, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 281: {
                this.setInteger(953024512, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 282: {
                this.setInteger(953024512, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 283: {
                this.setInteger(953024512, 3);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 284: {
                this.triggerObserver(-670826432);
                break;
            }
            case 285: {
                EventGeneric eventGeneric;
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (this.getBoolean(23839)) {
                    eventGeneric = TunerActivity.newEvent();
                    eventGeneric.setBoolean(0, this.getBoolean(17118));
                    this.triggerObserver(-1023147968, eventGeneric);
                }
                this.setInteger(319947008, TunerActivity.evListItemActionIndex());
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(319947008));
                this.triggerObserver(-1811677120, eventGeneric);
                this.triggerObserver(-452722624);
                break;
            }
            case 286: {
                this.triggerObserver(-1543241664);
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 287: {
                this.setBoolean(1673068544, !this.getBoolean(1673068544));
                break;
            }
            case 288: {
                this.setBoolean(29417, !this.getBoolean(29417));
                break;
            }
            case 289: {
                break;
            }
            case 290: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 291: {
                this.setInteger(953024512, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 292: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 293: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1483246921);
                break;
            }
            case 294: {
                this.triggerObserver(-670826432);
                break;
            }
            case 295: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 296: {
                this.triggerObserver(-670826432);
                break;
            }
            case 297: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 298: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 299: {
                this.triggerObserver(-670826432);
                break;
            }
            case 300: {
                this.triggerObserver(-586940352);
                break;
            }
            case 301: {
                this.triggerObserver(-737935296);
                break;
            }
            case 302: {
                this.triggerObserver(-721158080);
                break;
            }
            case 303: {
                this.setInteger(-487522304, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 304: {
                break;
            }
            case 305: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (!this.getBoolean(23839)) break;
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 306: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (!this.getBoolean(23839)) break;
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 307: {
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 308: {
                if (!this.getBoolean(12614)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                if (!this.getBoolean(471990528)) break;
                this.setBoolean(1673068544, true);
                break;
            }
            case 309: {
                if (!this.getBoolean(311754752) || !this.getBoolean(471990528)) break;
                this.setBoolean(1673068544, true);
                break;
            }
            case 310: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                if (!this.getBoolean(471990528)) break;
                this.setBoolean(1673068544, false);
                break;
            }
            case 311: {
                if (!this.getBoolean(311754752) || !this.getBoolean(471990528)) break;
                this.setBoolean(1673068544, false);
                break;
            }
            case 312: {
                break;
            }
            case 313: {
                this.setBoolean(29417, false);
                break;
            }
            case 314: {
                this.setBoolean(29417, false);
                break;
            }
            case 315: {
                this.triggerObserver(1258618944);
                this.setBoolean(-1291648768, true);
                break;
            }
            case 316: {
                this.triggerObserver(0x55050040);
                this.setBoolean(-1291648768, false);
                break;
            }
            case 317: {
                this.setBoolean(1673068544, true);
                break;
            }
            case 318: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1033335479);
                break;
            }
            case 319: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1050112695);
                break;
            }
            case 320: {
                this.setBoolean(1673068544, false);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1050112695);
                break;
            }
            case 321: {
                this.setBoolean(1673068544, true);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1033335479);
                break;
            }
            case 322: {
                this.setInteger(29686, 1);
                this.setBoolean(1889140736, false);
                if (this.getInteger(23664) < 2) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -546796215);
                break;
            }
            case 323: {
                this.setInteger(29686, 0);
                this.setBoolean(1889140736, false);
                if (this.getInteger(23664) > 0) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -530018999);
                break;
            }
            case 325: {
                this.setInteger(27392, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27392));
                this.triggerObserver(-1039925184, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-385351424, 0);
                break;
            }
            case 326: {
                this.setInteger(27392, this.getInteger(27769));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27392));
                this.triggerObserver(-1039925184, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-385351424, 1);
                break;
            }
            case 327: {
                this.setInteger(27392, this.getInteger(27767));
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27392));
                this.triggerObserver(-1039925184, eventGeneric);
                if (this.getBoolean(23839)) {
                    TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681013943);
                }
                this.setInteger(-385351424, 2);
                break;
            }
        }
    }

    private void performInternalTransitionAction_SubHapticTunerDynState300(int n) {
        switch (n - this.IT_OFFSET) {
            case 328: {
                this.triggerObserver(-670826432);
                break;
            }
            case 335: {
                this.setBoolean(-1115029504, true);
                this.setInteger(-1480654848, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1480654848));
                this.triggerObserver(178201664, eventGeneric);
                break;
            }
            case 336: {
                this.triggerObserver(278864960);
                this.setBoolean(-1115029504, true);
                break;
            }
            case 337: {
                this.setInteger(11897, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -899248823);
                break;
            }
            case 338: {
                this.setInteger(-543227904, TunerActivity.evListItemActionIndex());
                this.setInteger(1021706240, 10);
                this.setInteger(22807, 4);
                this.setInteger(780271616, 2);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1247841609);
                break;
            }
            case 339: {
                this.setInteger(1825636352, 1);
                this.setInteger(769982464, TunerActivity.evListItemActionIndex());
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 593595721);
                break;
            }
            case 340: {
                this.setBoolean(18768, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(18768));
                this.triggerObserver(-1341915072, eventGeneric);
                break;
            }
            case 341: {
                this.setBoolean(23731, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(23731));
                this.triggerObserver(-956039104, eventGeneric);
                break;
            }
            case 342: {
                this.setInteger(-393609216, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-393609216));
                this.triggerObserver(-939261888, eventGeneric);
                break;
            }
            case 343: {
                this.setInteger(-393609216, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-393609216));
                this.triggerObserver(-939261888, eventGeneric);
                break;
            }
            case 344: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 761367881);
                break;
            }
            case 345: {
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 778145097);
                break;
            }
            case 346: {
                if (this.getBoolean(12291)) {
                    this.setBoolean(-1078591488, false);
                }
                if (!this.getBoolean(12291)) {
                    this.setBoolean(-1078591488, true);
                }
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1078591488));
                this.triggerObserver(-1073151936, eventGeneric);
                break;
            }
            case 347: {
                this.setInteger(32156, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32156));
                this.triggerObserver(655424, eventGeneric);
                break;
            }
            case 348: {
                this.setInteger(32156, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32156));
                this.triggerObserver(655424, eventGeneric);
                break;
            }
            case 349: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 350: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 351: {
                this.setBoolean(0x9D0000, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 352: {
                this.setBoolean(0x9D0000, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(0x9D0000));
                this.triggerObserver(-888930240, eventGeneric);
                break;
            }
            case 353: {
                this.setInteger(1755447296, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1755447296));
                this.triggerObserver(-1308360640, eventGeneric);
                break;
            }
            case 354: {
                this.setInteger(1755447296, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1755447296));
                this.triggerObserver(-1308360640, eventGeneric);
                break;
            }
            case 355: {
                this.setInteger(1755447296, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1755447296));
                this.triggerObserver(-1308360640, eventGeneric);
                break;
            }
            case 356: {
                this.triggerObserver(-670826432);
                break;
            }
            case 357: {
                EventGeneric eventGeneric;
                if (this.getBoolean(23839)) {
                    this.setBoolean(17118, false);
                }
                if (this.getBoolean(23839)) {
                    eventGeneric = TunerActivity.newEvent();
                    eventGeneric.setBoolean(0, this.getBoolean(17118));
                    this.triggerObserver(-1023147968, eventGeneric);
                }
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(319947008, TunerActivity.evListItemActionIndex());
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(319947008));
                this.triggerObserver(-1811677120, eventGeneric);
                this.triggerObserver(-452722624);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1100444343);
                break;
            }
            case 358: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.triggerObserver(-1543241664);
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -664236727);
                break;
            }
            case 359: {
                this.triggerObserver(-1560018880);
                this.setInteger(27884, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
            case 360: {
                this.triggerObserver(-469499840);
                this.setInteger(27884, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(27884));
                this.triggerObserver(-301727680, eventGeneric);
                break;
            }
            case 361: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.triggerObserver(-1543241664);
                break;
            }
            case 362: {
                this.triggerObserver(-452722624);
                break;
            }
            case 363: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 364: {
                this.triggerObserver(-670826432);
                break;
            }
            case 365: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 366: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 367: {
                this.triggerObserver(-670826432);
                break;
            }
            case 368: {
                this.triggerObserver(-1459355584);
                break;
            }
            case 369: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 370: {
                this.setBoolean(17118, true);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 371: {
                this.triggerObserver(-670826432);
                break;
            }
            case 372: {
                this.triggerObserver(-586940352);
                break;
            }
            case 373: {
                this.triggerObserver(-737935296);
                break;
            }
            case 374: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-487522304, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 375: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setInteger(-487522304, 2);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-487522304));
                this.triggerObserver(-2096889792, eventGeneric);
                break;
            }
            case 376: {
                this.triggerObserver(-721158080);
                break;
            }
            case 377: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 378: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 379: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 380: {
                this.triggerObserver(-670826432);
                break;
            }
            case 381: {
                this.triggerObserver(-670826432);
                break;
            }
            case 382: {
                if (this.getBoolean(12614)) {
                    this.triggerObserver(-654049216);
                }
                this.setBoolean(17118, false);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(17118));
                this.triggerObserver(-1023147968, eventGeneric);
                break;
            }
            case 383: {
                this.triggerObserver(1258618944);
                this.setBoolean(-1291648768, true);
                break;
            }
            case 384: {
                this.triggerObserver(0x55050040);
                this.setBoolean(-1291648768, false);
                break;
            }
            case 385: {
                this.setInteger(29686, 1);
                this.setBoolean(1889140736, false);
                if (this.getInteger(-385351424) < 2) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -546796215);
                break;
            }
            case 386: {
                this.setInteger(29686, 0);
                this.setBoolean(1889140736, false);
                if (this.getInteger(-385351424) > 0) {
                    this.setBoolean(1889140736, true);
                }
                ModelApiDownEvent modelApiDownEvent = this.createModelApiDownEvent(40);
                modelApiDownEvent.setInt(0, this.getInteger(29686));
                modelApiDownEvent.setBoolean(1, this.getBoolean(1889140736));
                this.fireModelApiDownEvent(modelApiDownEvent);
                TunerActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -530018999);
                break;
            }
            case 387: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 388: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 389: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 390: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 391: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 392: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 393: {
                this.setInteger(32156, 1);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32156));
                this.triggerObserver(655424, eventGeneric);
                this.setBoolean(16349, true);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 394: {
                this.setInteger(32156, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32156));
                this.triggerObserver(655424, eventGeneric);
                this.setBoolean(16349, true);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 395: {
                this.setInteger(32156, 3);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(32156));
                this.triggerObserver(655424, eventGeneric);
                this.setBoolean(16349, true);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 396: {
                if (this.getBoolean(10548)) {
                    this.triggerObserver(-737935296);
                }
                if (this.getBoolean(837550080)) {
                    this.triggerObserver(-586940352);
                }
                if (this.getBoolean(21917)) {
                    this.triggerObserver(-721158080);
                }
                this.setInteger(366018560, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(366018560));
                this.triggerObserver(-1845231552, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                this.triggerObserver(-435945408);
                break;
            }
            case 397: {
                this.setInteger(194183168, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(194183168));
                this.triggerObserver(-1526464448, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 398: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 399: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 400: {
                this.triggerObserver(-1979449280);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 401: {
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 402: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 403: {
                this.triggerObserver(-1979449280);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 404: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(16349, true);
                break;
            }
            case 405: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 406: {
                this.triggerObserver(-1929117632);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 407: {
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 408: {
                this.triggerObserver(-670826432);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 409: {
                this.triggerObserver(-1929117632);
                if (this.getBoolean(471990528) && this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 410: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                this.setBoolean(16349, true);
                break;
            }
            case 411: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 412: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 413: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 414: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 415: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 416: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 417: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 418: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -748122807);
                break;
            }
            case 419: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 421: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
            case 422: {
                this.setInteger(-1106837248, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1106837248));
                this.triggerObserver(-553385920, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1515949385);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticTunerDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 4: {
                return this.getBoolean(12357);
            }
            case 11: {
                return !this.getBoolean(17711);
            }
            case 26: {
                return !this.getBoolean(17711);
            }
            case 39: {
                return TunerActivity.evListItemEventSender().equalsIgnoreCase("Button");
            }
            case 43: {
                return !this.getBoolean(17711);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticTunerDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticTunerDynState00(n);
    }

    private void performTriggeredTransitionAction_SubHapticTunerDynState00(int n) {
        switch (n - this.TT_OFFSET) {
            case 2: {
                this.setInteger(22807, 2);
                break;
            }
            case 6: {
                this.setInteger(22807, 2);
                break;
            }
            case 9: {
                this.setInteger(1755447296, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1755447296));
                this.triggerObserver(-1308360640, eventGeneric);
                this.setInteger(1302003712, 0);
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1302003712));
                this.triggerObserver(-1325137856, eventGeneric);
                this.setInteger(953024512, 0);
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                this.setInteger(-16514816, 0);
                eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-16514816));
                this.triggerObserver(1694761024, eventGeneric);
                break;
            }
            case 11: {
                this.triggerObserver(-821821376);
                break;
            }
            case 15: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                this.setInteger(366018560, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(366018560));
                this.triggerObserver(-1845231552, eventGeneric);
                break;
            }
            case 20: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 21: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 22: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 23: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 24: {
                this.setInteger(1021706240, 10);
                this.setInteger(32204, 1);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 26: {
                this.setInteger(953024512, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                this.triggerObserver(-821821376);
                break;
            }
            case 27: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 28: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 29: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 30: {
                this.setInteger(1021706240, 10);
                this.setInteger(32204, 1);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 31: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 33: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 38: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 39: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                this.setInteger(17372, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17372));
                this.triggerObserver(-2063335360, eventGeneric);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 40: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 41: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 43: {
                this.triggerObserver(-821821376);
                break;
            }
            case 45: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 46: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 47: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 48: {
                this.setBoolean(-1115029504, true);
                break;
            }
            case 49: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 50: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 51: {
                this.setInteger(1021706240, 10);
                this.setInteger(32204, 1);
                TunerActivity.fireHMIEvent(ANY, BROADCAST, 1600163145);
                break;
            }
            case 52: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 56: {
                this.triggerObserver(-586940352);
                this.triggerObserver(-737935296);
                this.triggerObserver(-721158080);
                this.setInteger(366018560, TunerActivity.evListItemActionIndex());
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(366018560));
                this.triggerObserver(-1845231552, eventGeneric);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticTunerDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                return this.getInteger(0x2020100) == 0;
            }
            case 8: {
                return this.getInteger(0x2020100) == 1;
            }
            case 14: {
                return this.getInteger(22807) == 2 && !this.getBoolean(19517);
            }
            case 15: {
                return this.getBoolean(19517);
            }
            case 17: {
                return this.getInteger(1797128448) == 0;
            }
            case 18: {
                return this.getBoolean(12357) && this.getInteger(1797128448) == 2;
            }
            case 22: {
                return (this.getInteger(22807) == 5 || this.getInteger(22807) == 6) && !this.getBoolean(19517);
            }
            case 23: {
                return (this.getInteger(22807) == 3 || this.getInteger(22807) == 4) && !this.getBoolean(19517);
            }
            case 24: {
                return this.getBoolean(19517) && this.getBoolean(638124288);
            }
            case 30: {
                return this.getInteger(22807) == 4;
            }
            case 34: {
                return (this.getInteger(22807) == 3 || this.getInteger(22807) == 4) && !this.getBoolean(19517);
            }
            case 35: {
                return (this.getInteger(22807) == 5 || this.getInteger(22807) == 6) && !this.getBoolean(19517);
            }
            case 36: {
                return this.getBoolean(19517) && this.getBoolean(638124288);
            }
            case 40: {
                return this.getInteger(22807) == 4;
            }
            case 48: {
                return this.getInteger(22807) == 4;
            }
            case 50: {
                return (this.getInteger(22807) == 3 || this.getInteger(22807) == 4) && !this.getBoolean(19517);
            }
            case 51: {
                return (this.getInteger(22807) == 5 || this.getInteger(22807) == 6) && !this.getBoolean(19517);
            }
            case 52: {
                return this.getBoolean(19517) && this.getBoolean(638124288);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticTunerDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 14: {
                if (this.getBoolean(17711)) {
                    this.triggerObserver(-670826432);
                }
                this.triggerObserver(-838598592);
                break;
            }
            case 23: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 24: {
                this.setInteger(1302003712, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1302003712));
                this.triggerObserver(-1325137856, eventGeneric);
                break;
            }
            case 26: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 34: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 36: {
                this.setInteger(953024512, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(953024512));
                this.triggerObserver(-1174142912, eventGeneric);
                break;
            }
            case 38: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 44: {
                if (this.getBoolean(-376438784)) break;
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -764900023);
                break;
            }
            case 45: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 50: {
                TunerActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 52: {
                this.setInteger(1755447296, 0);
                EventGeneric eventGeneric = TunerActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1755447296));
                this.triggerObserver(-1308360640, eventGeneric);
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

