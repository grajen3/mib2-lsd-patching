/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.message.sm;

import de.vw.mib.datapool.FormatterService;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class MessageActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public MessageActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 169: {
                this.performStateEntryAction_SubPopupPoAlertMessageSmsMemoryFullDynState(n, bl);
                break;
            }
            case 248: {
                this.performStateEntryAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(n, bl);
                break;
            }
            case 249: {
                this.performStateEntryAction_SubPopupPoConfirmMessageSmsDeleteDynState(n, bl);
                break;
            }
            case 250: {
                this.performStateEntryAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(n, bl);
                break;
            }
            case 393: {
                this.performStateEntryAction_SubPopupPoInfoMessageNotDisplayedDynState(n, bl);
                break;
            }
            case 394: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDeleteAllErrorDynState(n, bl);
                break;
            }
            case 395: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDeleteAllDynState(n, bl);
                break;
            }
            case 396: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDeleteErrorDynState(n, bl);
                break;
            }
            case 397: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDeleteWaitDynState(n, bl);
                break;
            }
            case 398: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDeleteDynState(n, bl);
                break;
            }
            case 399: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsDownloadErrorDynState(n, bl);
                break;
            }
            case 400: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsSaveAsDraftFailedDynState(n, bl);
                break;
            }
            case 401: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsSaveAsDraftSuccessfulDynState(n, bl);
                break;
            }
            case 402: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsSaveWaitDynState(n, bl);
                break;
            }
            case 403: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsSendingDynState(n, bl);
                break;
            }
            case 404: {
                this.performStateEntryAction_SubPopupPoInfoMessageSmsSendErrorDynState(n, bl);
                break;
            }
            case 457: {
                this.performStateEntryAction_SubPopupPoMessageWaitstateDynState(n, bl);
                break;
            }
            case 564: {
                this.performStateEntryAction_SubPopupPoProgressMessageSmsDeleteAllDynState(n, bl);
                break;
            }
            case 21: {
                this.performStateEntryAction_SubHapticMessageDynState(n, bl);
                break;
            }
            case 656: {
                this.performStateEntryAction_SubICustomerUpdateActiveBridge(n, bl);
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
            case 663: {
                this.performStateEntryAction_SubIMessageSmsContactList(n, bl);
                break;
            }
            case 664: {
                this.performStateEntryAction_SubIMessageSmsIncomingOptions(n, bl);
                break;
            }
            case 665: {
                this.performStateEntryAction_SubIMessageSmsNew(n, bl);
                break;
            }
            case 666: {
                this.performStateEntryAction_SubIMessageSmsTemplate(n, bl);
                break;
            }
            case 68: {
                this.performStateEntryAction_SubPromptingMessagesDynState(n, bl);
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
            case 169: {
                this.performStateExitAction_SubPopupPoAlertMessageSmsMemoryFullDynState(n);
                break;
            }
            case 248: {
                this.performStateExitAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(n);
                break;
            }
            case 249: {
                this.performStateExitAction_SubPopupPoConfirmMessageSmsDeleteDynState(n);
                break;
            }
            case 250: {
                this.performStateExitAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(n);
                break;
            }
            case 393: {
                this.performStateExitAction_SubPopupPoInfoMessageNotDisplayedDynState(n);
                break;
            }
            case 394: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDeleteAllErrorDynState(n);
                break;
            }
            case 395: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDeleteAllDynState(n);
                break;
            }
            case 396: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDeleteErrorDynState(n);
                break;
            }
            case 397: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDeleteWaitDynState(n);
                break;
            }
            case 398: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDeleteDynState(n);
                break;
            }
            case 399: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsDownloadErrorDynState(n);
                break;
            }
            case 400: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsSaveAsDraftFailedDynState(n);
                break;
            }
            case 401: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsSaveAsDraftSuccessfulDynState(n);
                break;
            }
            case 402: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsSaveWaitDynState(n);
                break;
            }
            case 403: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsSendingDynState(n);
                break;
            }
            case 404: {
                this.performStateExitAction_SubPopupPoInfoMessageSmsSendErrorDynState(n);
                break;
            }
            case 457: {
                this.performStateExitAction_SubPopupPoMessageWaitstateDynState(n);
                break;
            }
            case 564: {
                this.performStateExitAction_SubPopupPoProgressMessageSmsDeleteAllDynState(n);
                break;
            }
            case 21: {
                this.performStateExitAction_SubHapticMessageDynState(n);
                break;
            }
            case 656: {
                this.performStateExitAction_SubICustomerUpdateActiveBridge(n);
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
            case 663: {
                this.performStateExitAction_SubIMessageSmsContactList(n);
                break;
            }
            case 664: {
                this.performStateExitAction_SubIMessageSmsIncomingOptions(n);
                break;
            }
            case 665: {
                this.performStateExitAction_SubIMessageSmsNew(n);
                break;
            }
            case 666: {
                this.performStateExitAction_SubIMessageSmsTemplate(n);
                break;
            }
            case 68: {
                this.performStateExitAction_SubPromptingMessagesDynState(n);
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
            case 21: {
                return this.evalInternalTransitionGuard_SubHapticMessageDynState(n);
            }
            case 663: {
                return this.evalInternalTransitionGuard_SubIMessageSmsContactList(n);
            }
            case 664: {
                return this.evalInternalTransitionGuard_SubIMessageSmsIncomingOptions(n);
            }
            case 665: {
                return this.evalInternalTransitionGuard_SubIMessageSmsNew(n);
            }
            case 666: {
                return this.evalInternalTransitionGuard_SubIMessageSmsTemplate(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 21: {
                this.performInternalTransitionAction_SubHapticMessageDynState(n);
                break;
            }
            case 663: {
                this.performInternalTransitionAction_SubIMessageSmsContactList(n);
                break;
            }
            case 664: {
                this.performInternalTransitionAction_SubIMessageSmsIncomingOptions(n);
                break;
            }
            case 665: {
                this.performInternalTransitionAction_SubIMessageSmsNew(n);
                break;
            }
            case 666: {
                this.performInternalTransitionAction_SubIMessageSmsTemplate(n);
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
            case 21: {
                return this.evalTriggeredTransitionGuard_SubHapticMessageDynState(n);
            }
            case 663: {
                return this.evalTriggeredTransitionGuard_SubIMessageSmsContactList(n);
            }
            case 664: {
                return this.evalTriggeredTransitionGuard_SubIMessageSmsIncomingOptions(n);
            }
            case 665: {
                return this.evalTriggeredTransitionGuard_SubIMessageSmsNew(n);
            }
        }
        return true;
    }

    @Override
    public void performTriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 169: {
                this.performTriggeredTransitionAction_SubPopupPoAlertMessageSmsMemoryFullDynState(n);
                break;
            }
            case 248: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(n);
                break;
            }
            case 249: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteDynState(n);
                break;
            }
            case 250: {
                this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(n);
                break;
            }
            case 21: {
                this.performTriggeredTransitionAction_SubHapticMessageDynState(n);
                break;
            }
            case 663: {
                this.performTriggeredTransitionAction_SubIMessageSmsContactList(n);
                break;
            }
            case 664: {
                this.performTriggeredTransitionAction_SubIMessageSmsIncomingOptions(n);
                break;
            }
            case 665: {
                this.performTriggeredTransitionAction_SubIMessageSmsNew(n);
                break;
            }
            case 666: {
                this.performTriggeredTransitionAction_SubIMessageSmsTemplate(n);
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
            case 21: {
                return this.evalUntriggeredTransitionGuard_SubHapticMessageDynState(n);
            }
            case 656: {
                return this.evalUntriggeredTransitionGuard_SubICustomerUpdateActiveBridge(n);
            }
            case 663: {
                return this.evalUntriggeredTransitionGuard_SubIMessageSmsContactList(n);
            }
            case 664: {
                return this.evalUntriggeredTransitionGuard_SubIMessageSmsIncomingOptions(n);
            }
            case 665: {
                return this.evalUntriggeredTransitionGuard_SubIMessageSmsNew(n);
            }
            case 666: {
                return this.evalUntriggeredTransitionGuard_SubIMessageSmsTemplate(n);
            }
        }
        return true;
    }

    @Override
    public void performUntriggeredTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 21: {
                this.performUntriggeredTransitionAction_SubHapticMessageDynState(n);
                break;
            }
            case 663: {
                this.performUntriggeredTransitionAction_SubIMessageSmsContactList(n);
                break;
            }
            case 664: {
                this.performUntriggeredTransitionAction_SubIMessageSmsIncomingOptions(n);
                break;
            }
            case 665: {
                this.performUntriggeredTransitionAction_SubIMessageSmsNew(n);
                break;
            }
            case 666: {
                this.performUntriggeredTransitionAction_SubIMessageSmsTemplate(n);
                break;
            }
            default: {
                return;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoAlertMessageSmsMemoryFullDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setBoolean(888078336, false);
                break;
            }
            case 3: {
                this.enterPopupView("Pamsmf", 169, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoAlertMessageSmsMemoryFullDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                this.setBoolean(888078336, false);
                break;
            }
            case 3: {
                this.leavePopupView("Pamsmf");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoAlertMessageSmsMemoryFullDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoAlertMessageSmsMemoryFullDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoAlertMessageSmsMemoryFullDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setInteger(1021706240, 0);
                this.setInteger(-1014628352, 3);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1348504905);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pcmsda", 248, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pcmsda");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteAllDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteAllDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteAllDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23521));
                this.triggerObserver(-1212478144, eventGeneric);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 492473673);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMessageSmsDeleteDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pcmsd", 249, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMessageSmsDeleteDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pcmsd");
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsDeleteDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 1: {
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1370685440));
                this.triggerObserver(1761673280, eventGeneric);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1298238793);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1096453449);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pcmssad", 250, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1013353801);
                break;
            }
            case 3: {
                this.leavePopupView("Pcmssad");
                this.setBoolean(14815, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState(int n) {
        this.performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState0(n);
    }

    private void performTriggeredTransitionAction_SubPopupPoConfirmMessageSmsSaveAsDraftDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 996576585);
                break;
            }
            case 1: {
                this.setString(18669, this.getLicValue(4037, 2, 0, ""));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(18669));
                this.triggerObserver(1912668224, eventGeneric);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1030131017);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -581333687);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageNotDisplayedDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pimnd", 393, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageNotDisplayedDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pimnd");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDeleteAllErrorDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsdae", 394, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDeleteAllErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsdae");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDeleteAllDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsda", 395, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDeleteAllDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsda");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDeleteErrorDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsde_45FB", 396, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDeleteErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsde_45FB");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDeleteWaitDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsdw", 397, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDeleteWaitDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsdw");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDeleteDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsd", 398, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDeleteDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsd");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsDownloadErrorDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsde_0488", 399, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsDownloadErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsde_0488");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsSaveAsDraftFailedDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.enterPopupView("Pimssadf", 400, 3);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsSaveAsDraftFailedDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 3: {
                this.leavePopupView("Pimssadf");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsSaveAsDraftSuccessfulDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimssads", 401, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsSaveAsDraftSuccessfulDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimssads");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsSaveWaitDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimssw", 402, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsSaveWaitDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimssw");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsSendingDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimss", 403, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsSendingDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimss");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoInfoMessageSmsSendErrorDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pimsse", 404, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoInfoMessageSmsSendErrorDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pimsse");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoMessageWaitstateDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Pmw", 457, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoMessageWaitstateDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                break;
            }
            case 2: {
                this.leavePopupView("Pmw");
                break;
            }
        }
    }

    private void performStateEntryAction_SubPopupPoProgressMessageSmsDeleteAllDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                this.enterPopupView("Ppmsda", 564, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubPopupPoProgressMessageSmsDeleteAllDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                MessageActivity.fireDynamicStateEvent(this.topStatemachine.getId(), 2, this.topStatemachine.getPopupInfoId());
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1298238793);
                break;
            }
            case 2: {
                this.leavePopupView("Ppmsda");
                break;
            }
        }
    }

    private void performStateEntryAction_SubHapticMessageDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-911343616, 2);
                break;
            }
            case 8: {
                this.setInteger(29725, SkinDataPool.getInteger(190));
                this.setInteger(0x820000, 16);
                this.setInteger(-911343616, 3);
                break;
            }
            case 13: {
                MessageActivity.changeContext("Message");
                break;
            }
            case 17: {
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 23: {
                this.enterWaitaphoreForProperty(-173015040, 374, 479, 963218761, 946441545);
                break;
            }
            case 24: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Msns_C6E5", bl, 46);
                break;
            }
            case 26: {
                this.showView("Msm_3BEA", bl, 46);
                break;
            }
            case 37: {
                this.showView("Msdp", bl, 46);
                break;
            }
            case 38: {
                this.showView("Msl", bl, 46);
                break;
            }
            case 39: {
                this.setInteger(83361792, 1);
                this.setBoolean(1225720064, false);
                break;
            }
            case 42: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Msns_45A9", bl, 46);
                break;
            }
            case 46: {
                this.enterWaitaphoreForProperty(-134020864, 374, 479, 963218761, 946441545);
                break;
            }
            case 50: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 51: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 61: {
                this.showView("Msis", bl, 46);
                break;
            }
            case 62: {
                this.showView("Msivs", bl, 46);
                break;
            }
            case 64: {
                this.showView("Msl", bl, 46);
                break;
            }
            case 68: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 72: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 76: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 80: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 82: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 83: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 84: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 93: {
                this.showView("Msos", bl, 46);
                break;
            }
            case 94: {
                this.showView("Msovs", bl, 46);
                break;
            }
            case 96: {
                this.showView("Msl", bl, 46);
                break;
            }
            case 100: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 101: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 105: {
                this.showView("Mssc", bl, 46);
                break;
            }
            case 109: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 110: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 114: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 118: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 122: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 126: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 130: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 134: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 138: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 142: {
                this.enterWaitaphoreForProperty(28112, 374, 479, 963218761, 946441545);
                break;
            }
            case 146: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 147: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 148: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 149: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 150: {
                this.setBoolean(14815, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                this.setInteger(1006305280, 0);
                this.setBoolean(20413, false);
                this.showView("Mslm", bl, 46);
                break;
            }
            case 154: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 158: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 963218761, 946441545);
                break;
            }
            case 163: {
                this.enterIncludeDdpGroup(46);
                break;
            }
            case 166: {
                this.showView("Masm", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 170: {
                this.setInteger(0x100A0100, 15);
                this.setInteger(1150418944, 10);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 173: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 174: {
                this.setInteger(-911343616, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticMessageDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-911343616, 0);
                break;
            }
            case 8: {
                this.setInteger(29725, SkinDataPool.getInteger(180));
                this.setInteger(0x820000, 0);
                this.triggerObserver(-1246032576);
                break;
            }
            case 13: {
                this.setInteger(-1014628352, 0);
                break;
            }
            case 23: {
                this.leaveWaitaphore();
                break;
            }
            case 24: {
                this.hideView("Msns_C6E5");
                this.triggerObserver(-1744764864);
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.setBoolean(28287, false);
                break;
            }
            case 26: {
                this.hideView("Msm_3BEA");
                break;
            }
            case 37: {
                this.hideView("Msdp");
                break;
            }
            case 38: {
                this.hideView("Msl");
                break;
            }
            case 39: {
                this.triggerObserver(-1627324352);
                this.setBoolean(1225720064, false);
                break;
            }
            case 42: {
                this.hideView("Msns_45A9");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 46: {
                this.leaveWaitaphore();
                break;
            }
            case 50: {
                this.leaveWaitaphore();
                break;
            }
            case 51: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 61: {
                this.hideView("Msis");
                break;
            }
            case 62: {
                this.hideView("Msivs");
                break;
            }
            case 64: {
                this.hideView("Msl");
                break;
            }
            case 68: {
                this.leaveWaitaphore();
                break;
            }
            case 72: {
                this.leaveWaitaphore();
                break;
            }
            case 76: {
                this.leaveWaitaphore();
                break;
            }
            case 80: {
                this.leaveWaitaphore();
                break;
            }
            case 82: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 83: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 84: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 93: {
                this.hideView("Msos");
                break;
            }
            case 94: {
                this.hideView("Msovs");
                break;
            }
            case 96: {
                this.hideView("Msl");
                break;
            }
            case 100: {
                this.leaveWaitaphore();
                break;
            }
            case 101: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 102: {
                this.setBoolean(67567872, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(67567872));
                this.triggerObserver(-519438272, eventGeneric);
                break;
            }
            case 105: {
                this.hideView("Mssc");
                this.setInteger(29725, SkinDataPool.getInteger(180));
                break;
            }
            case 109: {
                this.leaveWaitaphore();
                break;
            }
            case 110: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 114: {
                this.leaveWaitaphore();
                break;
            }
            case 118: {
                this.leaveWaitaphore();
                break;
            }
            case 122: {
                this.leaveWaitaphore();
                break;
            }
            case 126: {
                this.leaveWaitaphore();
                break;
            }
            case 130: {
                this.leaveWaitaphore();
                break;
            }
            case 134: {
                this.leaveWaitaphore();
                break;
            }
            case 138: {
                this.leaveWaitaphore();
                break;
            }
            case 142: {
                this.leaveWaitaphore();
                break;
            }
            case 146: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 147: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 148: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 149: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 150: {
                this.hideView("Mslm");
                this.setInteger(1006305280, 0);
                this.setBoolean(20413, false);
                this.setInteger(29725, SkinDataPool.getInteger(180));
                break;
            }
            case 154: {
                this.leaveWaitaphore();
                break;
            }
            case 158: {
                this.leaveWaitaphore();
                break;
            }
            case 163: {
                this.leaveIncludeDdpGroup();
                break;
            }
            case 166: {
                this.hideView("Masm");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticMessageDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.evalBoolean(22);
            }
            case 1: {
                return this.evalBoolean(22);
            }
            case 2: {
                return this.evalBoolean(22);
            }
            case 3: {
                return this.evalBoolean(22);
            }
            case 4: {
                return this.evalBoolean(22);
            }
            case 5: {
                return this.evalBoolean(22);
            }
            case 6: {
                return this.evalBoolean(22);
            }
            case 7: {
                return this.evalBoolean(22);
            }
            case 8: {
                return this.evalBoolean(22);
            }
            case 9: {
                return this.evalBoolean(22);
            }
            case 10: {
                return this.evalBoolean(22);
            }
            case 11: {
                return this.getInteger(27122) == 1 && !this.getBoolean(-939261696);
            }
            case 18: {
                return this.getBoolean(888078336);
            }
            case 20: {
                return !this.getBoolean(28287);
            }
            case 23: {
                return MessageActivity.evSpellerValuePressedChar().equals("0");
            }
            case 25: {
                return MessageActivity.evListItemEventSender().equals("Button_SaveSendMessage") && !this.getBoolean(905904128);
            }
            case 26: {
                return MessageActivity.evListItemEventSender().equals("Button_SaveSendMessage") && this.getBoolean(905904128);
            }
            case 27: {
                return MessageActivity.evListItemEventSender().equals("Button_ReplyIncludes") && this.getBoolean(1795555584);
            }
            case 28: {
                return MessageActivity.evListItemEventSender().equals("Button_ReplyIncludes") && !this.getBoolean(1795555584);
            }
            case 29: {
                return MessageActivity.evListItemEventSender().equals("Button_NotifyEmptySubject") && this.getBoolean(-183238400);
            }
            case 30: {
                return MessageActivity.evListItemEventSender().equals("Button_NotifyEmptySubject") && !this.getBoolean(-183238400);
            }
            case 42: {
                return MessageActivity.evListItemEventSender().equals("Button_Number") || MessageActivity.evListItemEventSender().equals("Button_Message") || MessageActivity.evListItemEventSender().equals("Button_DialPrefix") || MessageActivity.evListItemEventSender().equals("Button_Edit");
            }
            case 43: {
                return MessageActivity.evListItemEventSender().equals("Button_Number");
            }
            case 44: {
                return MessageActivity.evListItemEventSender().equals("Button_DialPrefix");
            }
            case 45: {
                return MessageActivity.evListItemEventSender().equals("Button_Edit");
            }
            case 46: {
                return MessageActivity.evListItemEventSender().equals("Button_Address") && this.getBoolean(22877);
            }
            case 47: {
                return MessageActivity.evListItemEventSender().equals("Button_Number");
            }
            case 52: {
                return this.getLicValue(462, 4, 0, 0) == 0;
            }
            case 53: {
                return this.getLicValue(462, 4, 0, 0) == 0;
            }
            case 56: {
                return MessageActivity.evListItemEventSender().equals("Button_Folder");
            }
            case 58: {
                return this.getLicValue(463, 12, this.getInteger(31330), false) && !this.getLicValue(463, 19, this.getInteger(31330), true);
            }
            case 59: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
            case 60: {
                return MessageActivity.evListItemEventSender().equals("Button_Readout");
            }
            case 61: {
                return this.getBoolean(20413) && this.getBoolean(28112);
            }
            case 62: {
                return this.getLicValue(462, 4, 0, 0) == 0;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticMessageDynState(int n) {
        this.performInternalTransitionAction_SubHapticMessageDynState00(n);
    }

    private void performInternalTransitionAction_SubHapticMessageDynState00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1721725623);
                break;
            }
            case 1: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1721725623);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -547779255);
                break;
            }
            case 2: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -698774199);
                break;
            }
            case 3: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -648442551);
                break;
            }
            case 4: {
                this.setBoolean(888078336, true);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1738961591);
                break;
            }
            case 5: {
                this.setBoolean(888078336, false);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1973383863);
                break;
            }
            case 6: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -631665335);
                break;
            }
            case 7: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1637839543);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -681996983);
                break;
            }
            case 8: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1637839543);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -665219767);
                break;
            }
            case 9: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1050636983);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -614888119);
                break;
            }
            case 10: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1050636983);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -598110903);
                break;
            }
            case 11: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1721725623);
                break;
            }
            case 12: {
                this.setInteger(29725, SkinDataPool.getInteger(190));
                break;
            }
            case 13: {
                this.setInteger(29725, SkinDataPool.getInteger(180));
                break;
            }
            case 14: {
                this.setInteger(29725, SkinDataPool.getInteger(189));
                break;
            }
            case 15: {
                this.setInteger(29725, SkinDataPool.getInteger(179));
                break;
            }
            case 16: {
                break;
            }
            case 17: {
                if (this.getBoolean(-939261696)) break;
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1721725623);
                break;
            }
            case 18: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1738961591);
                break;
            }
            case 19: {
                this.setBoolean(522191104, true);
                this.setInteger(-522518528, 0);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 20: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -77296311);
                break;
            }
            case 21: {
                this.triggerObserver(-1727987648);
                break;
            }
            case 22: {
                this.setString(1507917824, MessageActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(1507917824));
                this.triggerObserver(-1677656000, eventGeneric);
                break;
            }
            case 23: {
                this.setString(1507917824, "+");
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(1507917824));
                this.triggerObserver(-1677656000, eventGeneric);
                break;
            }
            case 24: {
                this.setInteger(150798336, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(150798336));
                this.triggerObserver(-1660878784, eventGeneric);
                break;
            }
            case 25: {
                this.setBoolean(25515, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(25515));
                this.triggerObserver(-1862205376, eventGeneric);
                break;
            }
            case 26: {
                this.setBoolean(25515, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(25515));
                this.triggerObserver(-1862205376, eventGeneric);
                break;
            }
            case 27: {
                this.setBoolean(-874250240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-874250240));
                this.triggerObserver(-1761542080, eventGeneric);
                break;
            }
            case 28: {
                this.setBoolean(-874250240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-874250240));
                this.triggerObserver(-1761542080, eventGeneric);
                break;
            }
            case 29: {
                this.setBoolean(12692, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(12692));
                this.triggerObserver(-1778319296, eventGeneric);
                break;
            }
            case 30: {
                this.setBoolean(12692, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(12692));
                this.triggerObserver(-1778319296, eventGeneric);
                break;
            }
            case 31: {
                this.setInteger(23521, MessageActivity.evListItemActionIndex());
                this.setInteger(-404357120, MessageActivity.evListItemActionIndex());
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1285976759);
                break;
            }
            case 32: {
                this.setInteger(17879, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17879));
                this.triggerObserver(-1845428160, eventGeneric);
                break;
            }
            case 33: {
                this.setInteger(0x4EE40000, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(0x4EE40000));
                this.triggerObserver(-1581576896, eventGeneric);
                break;
            }
            case 34: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -194605751);
                break;
            }
            case 35: {
                this.setString(-1441267456, MessageActivity.evSpellerValuePressedChar());
                this.setInteger(-955842304, MessageActivity.evSpellerValueCursorPosition());
                this.setInteger(27008, MessageActivity.evSpellerValueSelectionStart());
                this.setInteger(-553385728, MessageActivity.evSpellerValueSelectionEnd());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1441267456));
                eventGeneric.setInt(1, this.getInteger(27008));
                eventGeneric.setInt(2, this.getInteger(-553385728));
                eventGeneric.setInt(3, this.getInteger(-955842304));
                this.triggerObserver(-1380250304, eventGeneric);
                break;
            }
            case 36: {
                this.triggerObserver(-1610547136);
                break;
            }
            case 37: {
                this.triggerObserver(-1593769920);
                break;
            }
            case 38: {
                this.setInteger(11933, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(11933));
                this.triggerObserver(-1526661056, eventGeneric);
                break;
            }
            case 39: {
                this.setBoolean(1225720064, true);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 40: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 41: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -177828535);
                break;
            }
            case 42: {
                this.setInteger(-2033647616, MessageActivity.evListItemActionIndex());
                this.setInteger(784793600, MessageActivity.evListItemActionIndex());
                break;
            }
            case 43: {
                this.setString(950992896, this.getLicValue(459, 1, this.getInteger(-2033647616), ""));
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 44: {
                this.setString(950992896, FormatterService.format((CharSequence)"${0}${1}", this.getString(0x1C0C0100), this.getLicValue(459, 1, this.getInteger(-2033647616), "")));
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 45: {
                this.setString(28686, this.getLicValue(459, 1, this.getInteger(-2033647616), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 41);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 46: {
                this.setInteger(23093, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(23093));
                this.triggerObserver(-1313141440, eventGeneric);
                break;
            }
            case 47: {
                this.setString(28686, this.getLicValue(459, 1, this.getInteger(-2033647616), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 48: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1302753975);
                break;
            }
            case 49: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -177828535);
                break;
            }
            case 50: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1302753975);
                break;
            }
            case 51: {
                this.setInteger(-628686848, MessageActivity.evListItemActionIndex());
                break;
            }
            case 52: {
                this.triggerObserver(1694564416);
                break;
            }
            case 53: {
                this.triggerObserver(1694564416);
                break;
            }
            case 54: {
                this.setInteger(1006305280, 2);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 509709641);
                this.setInteger(2077425664, 5);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2077425664));
                this.triggerObserver(1862336576, eventGeneric);
                break;
            }
            case 55: {
                this.setInteger(1006305280, 2);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 509709641);
                this.setInteger(2077425664, 0);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(2077425664));
                this.triggerObserver(1862336576, eventGeneric);
                break;
            }
            case 56: {
                this.setInteger(1006305280, 1);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 509709641);
                this.setInteger(600702976, this.getInteger(31330));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(600702976));
                this.triggerObserver(1879113792, eventGeneric);
                break;
            }
            case 57: {
                this.setInteger(31330, MessageActivity.evListItemActionIndex());
                this.setString(18852, MessageActivity.evListItemEventSender());
                break;
            }
            case 58: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -715551415);
                break;
            }
            case 59: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                this.setBoolean(20413, true);
                break;
            }
            case 60: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                this.setBoolean(20413, true);
                break;
            }
            case 61: {
                this.setBoolean(20413, false);
                if (this.getLicValue(463, 0, this.getInteger(31330), "").equals("") && this.getLicValue(463, 1, this.getInteger(31330), "").equals("")) {
                    this.setInteger(-1346502656, 429);
                }
                if (!this.getLicValue(463, 0, this.getInteger(31330), "").equals("")) {
                    this.setInteger(-1346502656, 426);
                }
                if (this.getLicValue(463, 0, this.getInteger(31330), "").equals("") && !this.getLicValue(463, 1, this.getInteger(31330), "").equals("")) {
                    this.setInteger(-1346502656, 427);
                }
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -211382967);
                break;
            }
            case 62: {
                this.triggerObserver(1694564416);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubHapticMessageDynState(int n) {
        switch (n - this.TT_OFFSET) {
            case 15: {
                return this.getBoolean(-1076297728) && this.getBoolean(-1076297728);
            }
            case 19: {
                return !this.getLicValue(4037, 7, 0, false);
            }
            case 32: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
            case 46: {
                return this.getLicValue(469, 0, this.getInteger(-628686848), 0L) != 0L;
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubHapticMessageDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticMessageDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticMessageDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 8: {
                this.triggerObserver(-1711210432);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 9: {
                this.triggerObserver(-1644101568);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 15: {
                this.setInteger(-1933901824, 0);
                break;
            }
            case 17: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1096453449);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-669515520));
                this.triggerObserver(1744896064, eventGeneric);
                break;
            }
            case 18: {
                if (this.getBoolean(383909888)) break;
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1784414208));
                this.triggerObserver(1778450496, eventGeneric);
                break;
            }
            case 20: {
                this.triggerObserver(-1593769920);
                break;
            }
            case 26: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                this.setInteger(20200, 2);
                break;
            }
            case 32: {
                this.setLong(29990, 0L);
                this.setString(-795082752, "");
                this.setString(1407320064, this.getLicValue(459, 1, this.getInteger(784793600), ""));
                break;
            }
            case 73: {
                this.setInteger(179437568, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(179437568));
                this.triggerObserver(-1929314240, eventGeneric);
                break;
            }
            case 74: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticMessageDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 15: {
                return MessageActivity.evListItemEventSender().equals("Button_ServiceNumber");
            }
            case 19: {
                return this.getInteger(11272) == 1;
            }
            case 24: {
                return !this.getBoolean(1911750656);
            }
            case 33: {
                return this.getInteger(28341) == 1;
            }
            case 39: {
                return this.getLicValue(465, 8, 0, false);
            }
            case 41: {
                return !this.getBoolean(28112);
            }
            case 51: {
                return this.getInteger(28341) == 1;
            }
            case 52: {
                return this.getInteger(-1816264704) == 1;
            }
            case 61: {
                return this.getLicValue(465, 8, 0, false);
            }
            case 63: {
                return !this.getBoolean(28112);
            }
            case 89: {
                return this.getInteger(28341) == 1;
            }
            case 91: {
                return MessageActivity.evListItemEventSender().equals("Button_Template");
            }
            case 93: {
                return this.getString(18852).equals("Button_SendContact");
            }
            case 94: {
                return this.getLicValue(463, 10, this.getInteger(31330), 0) == 3 && this.getString(18852).equals("Button_Message") && this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true);
            }
            case 95: {
                return this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true) && this.getString(18852).equals("Button_Next") && this.getBoolean(-1076297728);
            }
            case 96: {
                return this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true) && this.getString(18852).equals("Button_Forward") && this.getBoolean(-1076297728);
            }
            case 97: {
                return this.getString(18852).equals("Button_Reply") && this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true) && this.getBoolean(-1076297728);
            }
            case 98: {
                return this.getLicValue(463, 10, this.getInteger(31330), 0) == 0 && this.getString(18852).equals("Button_Message") && this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true);
            }
            case 99: {
                return (this.getLicValue(463, 10, this.getInteger(31330), 0) == 1 || this.getLicValue(463, 10, this.getInteger(31330), 0) == 2) && this.getString(18852).equals("Button_Message") && this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true);
            }
            case 100: {
                return this.getLicValue(463, 10, this.getInteger(31330), 0) == 1 && this.getString(18852).equals("Button_Send") && this.getLicValue(463, 12, this.getInteger(31330), false) && this.getLicValue(463, 19, this.getInteger(31330), true);
            }
            case 110: {
                return this.getInteger(-1014628352) == 3;
            }
            case 111: {
                return this.getInteger(-1014628352) == 4;
            }
            case 112: {
                return this.getInteger(-1014628352) == 1;
            }
            case 113: {
                return this.getInteger(-1014628352) == 2;
            }
            case 114: {
                return this.getBoolean(15371);
            }
            case 116: {
                return this.getInteger(1021706240) == 36;
            }
            case 118: {
                return this.getInteger(1021706240) == 30;
            }
            case 119: {
                return this.getInteger(1021706240) == 36;
            }
            case 121: {
                return this.getInteger(1021706240) == 35;
            }
            case 124: {
                return this.getListItemControl(478, true).getItemCount() > 1 && this.getInteger(20927) == 0 && this.getInteger(-1014628352) != 3 && !this.getBoolean(15371) && this.getInteger(-1014628352) != 4;
            }
            case 126: {
                return this.getInteger(27122) == 0;
            }
            case 127: {
                return this.getInteger(27122) == 1;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubHapticMessageDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 12: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 14: {
                this.setString(-116850432, this.getString(-173015040));
                MessageActivity.lockWaitaphore(-173015040, 10000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-116850432));
                this.triggerObserver(-1694433216, eventGeneric);
                this.setBoolean(28287, true);
                break;
            }
            case 15: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 18: {
                this.triggerObserver(2063663168);
                break;
            }
            case 22: {
                this.setInteger(-1784414208, this.getInteger(31330));
                this.setInteger(-669515520, this.getInteger(31330));
                break;
            }
            case 29: {
                this.setString(1354956800, this.getLicValue(4037, 6, 0, ""));
                MessageActivity.lockWaitaphore(-134020864, 10000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(1354956800));
                this.triggerObserver(-1576992704, eventGeneric);
                this.setBoolean(28287, true);
                break;
            }
            case 31: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(-1560215488);
                break;
            }
            case 33: {
                this.setInteger(83361792, 2);
                break;
            }
            case 34: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 43: {
                this.setInteger(83361792, 2);
                break;
            }
            case 44: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1828782144);
                break;
            }
            case 45: {
                this.setInteger(83361792, 1);
                break;
            }
            case 46: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(29990));
                eventGeneric.setString(1, this.getString(-795082752));
                eventGeneric.setString(2, this.getString(1407320064));
                this.triggerObserver(-1329918656, eventGeneric);
                break;
            }
            case 47: {
                this.setInteger(83361792, 1);
                break;
            }
            case 48: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1895891008);
                break;
            }
            case 50: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1895891008);
                break;
            }
            case 51: {
                this.setInteger(83361792, 2);
                break;
            }
            case 52: {
                this.setInteger(83361792, 1);
                break;
            }
            case 65: {
                this.setInteger(83361792, 2);
                break;
            }
            case 66: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1828782144);
                break;
            }
            case 68: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1973908151);
                break;
            }
            case 69: {
                this.setBoolean(1477050624, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1477050624));
                this.triggerObserver(-2147418048, eventGeneric);
                break;
            }
            case 70: {
                this.setInteger(83361792, 2);
                break;
            }
            case 71: {
                this.setLong(-611713024, this.getLicValue(469, 0, this.getInteger(-628686848), 0L));
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-611713024));
                this.triggerObserver(1728118848, eventGeneric);
                break;
            }
            case 74: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1828782144);
                break;
            }
            case 76: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1895891008);
                break;
            }
            case 77: {
                this.setInteger(1370685440, this.getInteger(31330));
                this.setInteger(-1563623424, this.getInteger(31330));
                break;
            }
            case 78: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 79: {
                this.setInteger(1350828032, this.getInteger(31330));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1350828032));
                this.triggerObserver(1845559360, eventGeneric);
                this.setInteger(1370685440, this.getInteger(31330));
                this.setInteger(-1563623424, this.getInteger(31330));
                this.setInteger(83361792, 2);
                break;
            }
            case 80: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 81: {
                this.setInteger(1350828032, this.getInteger(31330));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1350828032));
                this.triggerObserver(1845559360, eventGeneric);
                this.setInteger(1370685440, this.getInteger(31330));
                this.setInteger(-1563623424, this.getInteger(31330));
                this.setInteger(83361792, 1);
                break;
            }
            case 82: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 83: {
                this.setInteger(1350828032, this.getInteger(31330));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1350828032));
                this.triggerObserver(1845559360, eventGeneric);
                this.setInteger(1370685440, this.getInteger(31330));
                this.setInteger(-1563623424, this.getInteger(31330));
                break;
            }
            case 84: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 85: {
                this.setInteger(1370685440, this.getInteger(31330));
                break;
            }
            case 86: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 88: {
                this.setInteger(17582, this.getInteger(31330));
                MessageActivity.lockWaitaphore(28112, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(17582));
                this.triggerObserver(1996554304, eventGeneric);
                break;
            }
            case 89: {
                this.setInteger(83361792, 2);
                break;
            }
            case 90: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1973908151);
                break;
            }
            case 91: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1990685367);
                this.setInteger(20200, 1);
                break;
            }
            case 92: {
                this.setInteger(83361792, 1);
                break;
            }
            case 93: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1990685367);
                break;
            }
            case 100: {
                this.setInteger(-1828716288, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1828716288));
                this.triggerObserver(-1346695872, eventGeneric);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -564556471);
                break;
            }
            case 106: {
                this.setInteger(83361792, 1);
                break;
            }
            case 107: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(29990));
                eventGeneric.setString(1, this.getString(-795082752));
                eventGeneric.setString(2, this.getString(1407320064));
                this.triggerObserver(-1329918656, eventGeneric);
                break;
            }
            case 108: {
                this.setInteger(83361792, 2);
                break;
            }
            case 109: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(-611713024));
                this.triggerObserver(1728118848, eventGeneric);
                break;
            }
            case 116: {
                this.setInteger(-522518528, 9);
                break;
            }
            case 118: {
                this.setInteger(-522518528, 0);
                break;
            }
            case 119: {
                this.setInteger(-522518528, 9);
                break;
            }
            case 121: {
                this.setInteger(-522518528, 3);
                break;
            }
            case 122: {
                this.setInteger(-522518528, 0);
                break;
            }
        }
    }

    private void performStateEntryAction_SubICustomerUpdateActiveBridge(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.showView("Scdac", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubICustomerUpdateActiveBridge(int n) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.hideView("Scdac");
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubICustomerUpdateActiveBridge(int n) {
        switch (n - this.UT_OFFSET) {
            case 1: {
                return (this.getInteger(0x100A0100) == 10 || this.getInteger(0x100A0100) == 13) && (this.getInteger(20027) == 1 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 3 && (this.getInteger(20027) == 2 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 2 && (this.getInteger(20027) == 3 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 0 && (this.getInteger(20027) == 4 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 8 && (this.getInteger(20027) == 5 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 1 && (this.getInteger(20027) == 6 || this.getInteger(20027) == -1) || this.getInteger(0x100A0100) == 4 && (this.getInteger(20027) == 7 || this.getInteger(20027) == -1);
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

    private void performStateEntryAction_SubIMessageSmsContactList(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 8: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Mscs", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 9: {
                this.enterWaitaphoreForProperty(32458, 374, 479, 1533644105, 1516866889);
                break;
            }
            case 15: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Msns_1B89", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 16: {
                this.enterWaitaphoreForProperty(-2112880384, 374, 479, 1533644105, 1516866889);
                break;
            }
            case 26: {
                this.setInteger(13361, -1);
                this.setBoolean(-1306787584, true);
                this.showView("Mscl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 28: {
                this.showView("Msst", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIMessageSmsContactList(int n) {
        switch (n - this.S_OFFSET) {
            case 5: {
                this.triggerObserver(-1497690816);
                this.setBoolean(1225720064, false);
                this.setBoolean(28287, false);
                break;
            }
            case 8: {
                this.hideView("Mscs");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 9: {
                this.leaveWaitaphore();
                break;
            }
            case 12: {
                this.triggerObserver(-2080309184);
                this.setBoolean(28287, false);
                break;
            }
            case 15: {
                this.hideView("Msns_1B89");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 16: {
                this.leaveWaitaphore();
                break;
            }
            case 23: {
                this.triggerObserver(-1514468032);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(67567872));
                this.triggerObserver(-519438272, eventGeneric);
                break;
            }
            case 26: {
                this.hideView("Mscl");
                this.setBoolean(-1306787584, false);
                break;
            }
            case 28: {
                this.hideView("Msst");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIMessageSmsContactList(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return !this.getBoolean(28287);
            }
            case 8: {
                return !this.getBoolean(28287);
            }
            case 11: {
                return MessageActivity.evSpellerValuePressedChar().equals("0");
            }
            case 13: {
                return !this.getBoolean(-1306787584);
            }
            case 14: {
                return this.getBoolean(0x10150100);
            }
            case 16: {
                return this.getLicValue(469, 4, this.getInteger(-628686848), false) && MessageActivity.evListItemEventSender().equals("Button_Contact") && (this.getInteger(13361) > MessageActivity.evListItemActionIndex() || this.getInteger(13361) < MessageActivity.evListItemActionIndex());
            }
            case 17: {
                return this.getLicValue(469, 4, this.getInteger(-628686848), false) && MessageActivity.evListItemEventSender().equals("Button_Contact") && this.getInteger(13361) == MessageActivity.evListItemActionIndex();
            }
            case 18: {
                return this.getBoolean(-288227328) && !this.getLicValue(469, 4, this.getInteger(-628686848), false) && MessageActivity.evListItemEventSender().equals("Button_Contact");
            }
            case 20: {
                return this.getBoolean(-288227328);
            }
            case 21: {
                return MessageActivity.evListItemEventSender().equals("Button_Delete");
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIMessageSmsContactList(int n) {
        this.performInternalTransitionAction_SubIMessageSmsContactList00(n);
    }

    private void performInternalTransitionAction_SubIMessageSmsContactList00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -77296311);
                break;
            }
            case 1: {
                if (this.getSpellerData(32458).getEnteredText().length() <= 0) break;
                this.triggerObserver(-1397027520);
                break;
            }
            case 2: {
                if (this.getSpellerData(32458).getEnteredText().length() <= 0) break;
                this.triggerObserver(-1397027520);
                break;
            }
            case 3: {
                this.triggerObserver(-1480913600);
                break;
            }
            case 4: {
                this.setString(-1316880384, MessageActivity.evSpellerValuePressedChar());
                this.setInteger(24206, MessageActivity.evSpellerValueSelectionStart());
                this.setInteger(24043, MessageActivity.evSpellerValueSelectionEnd());
                this.setInteger(-2004221952, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1316880384));
                eventGeneric.setInt(1, this.getInteger(24206));
                eventGeneric.setInt(2, this.getInteger(24043));
                eventGeneric.setInt(3, this.getInteger(-2004221952));
                this.triggerObserver(-1296364224, eventGeneric);
                break;
            }
            case 5: {
                this.setInteger(1305870336, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1305870336));
                this.triggerObserver(-1413804736, eventGeneric);
                break;
            }
            case 6: {
                this.setBoolean(1225720064, true);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 7: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 8: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -77296311);
                break;
            }
            case 9: {
                this.triggerObserver(-2063531968);
                break;
            }
            case 10: {
                this.setString(28795, MessageActivity.evSpellerValuePressedChar());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(28795));
                this.triggerObserver(-1979645888, eventGeneric);
                break;
            }
            case 11: {
                this.setString(28795, "+");
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(28795));
                this.triggerObserver(-1979645888, eventGeneric);
                break;
            }
            case 12: {
                this.setInteger(-552599296, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-552599296));
                this.triggerObserver(-1962868672, eventGeneric);
                break;
            }
            case 13: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -77296311);
                break;
            }
            case 14: {
                this.triggerObserver(-1514468032);
                this.setInteger(13361, -1);
                break;
            }
            case 15: {
                this.setInteger(-628686848, MessageActivity.evListItemActionIndex());
                break;
            }
            case 16: {
                this.setInteger(-16187136, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-16187136));
                this.triggerObserver(2080440384, eventGeneric);
                this.setInteger(13361, MessageActivity.evListItemActionIndex());
                break;
            }
            case 17: {
                this.setInteger(13361, -1);
                break;
            }
            case 18: {
                this.setInteger(13361, -1);
                this.setInteger(-16187136, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-16187136));
                this.triggerObserver(2080440384, eventGeneric);
                break;
            }
            case 19: {
                break;
            }
            case 20: {
                this.setInteger(1387462656, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1387462656));
                this.triggerObserver(2113994816, eventGeneric);
                break;
            }
            case 21: {
                this.setInteger(1554186240, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1554186240));
                this.triggerObserver(-1531245248, eventGeneric);
                break;
            }
            case 22: {
                this.setBoolean(14815, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                this.triggerObserver(2130772032);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -564556471);
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1298238793);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubIMessageSmsContactList(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                return this.getSpellerData(32458).getMatchCount() > 0 && (this.getSpellerData(32458).getMatchCount() < SkinDataPool.getInteger(45) || this.getSpellerData(32458).getMatchCount() == SkinDataPool.getInteger(45)) && !this.getBoolean(21705);
            }
            case 14: {
                return !this.getBoolean(0x10150100);
            }
            case 16: {
                return !this.getBoolean(-288227328);
            }
            case 17: {
                return !this.getBoolean(-288227328) && !this.getLicValue(469, 4, this.getInteger(-628686848), false) && MessageActivity.evListItemEventSender().equals("Button_Contact");
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubIMessageSmsContactList(int n) {
        this.performTriggeredTransitionAction_SubIMessageSmsContactList0(n);
    }

    private void performTriggeredTransitionAction_SubIMessageSmsContactList0(int n) {
        switch (n - this.TT_OFFSET) {
            case 2: {
                this.triggerObserver(-1464136384);
                break;
            }
            case 3: {
                if (this.getSpellerData(32458).getEnteredText().length() <= 0) break;
                this.triggerObserver(-1397027520);
                break;
            }
            case 7: {
                this.setBoolean(14815, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                this.triggerObserver(-2013200320);
                break;
            }
            case 8: {
                this.triggerObserver(-2046754752);
                break;
            }
            case 16: {
                this.setInteger(1387462656, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1387462656));
                this.triggerObserver(2113994816, eventGeneric);
                this.setBoolean(14815, false);
                eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                break;
            }
            case 17: {
                this.setInteger(-16187136, MessageActivity.evListItemActionIndex());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-16187136));
                this.triggerObserver(2080440384, eventGeneric);
                this.setBoolean(14815, false);
                eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(14815));
                this.triggerObserver(2046885952, eventGeneric);
                break;
            }
            case 18: {
                this.setInteger(11272, 1);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubIMessageSmsContactList(int n) {
        switch (n - this.UT_OFFSET) {
            case 7: {
                return !this.getBoolean(-1129119744);
            }
            case 9: {
                return !this.getBoolean(-1129119744) && this.getListItemControl(469, true).getItemCount() == 0;
            }
            case 10: {
                return this.getListItemControl(469, true).getItemCount() == 0 && this.getBoolean(-1129119744);
            }
            case 12: {
                return this.getListItemControl(469, true).getItemCount() == 0 && this.getInteger(11097) == 0;
            }
            case 18: {
                return this.getBoolean(-1129119744);
            }
            case 19: {
                return this.getListItemControl(469, true).getItemCount() == 0 && !this.getBoolean(-1129119744) && this.getInteger(11097) == 0;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubIMessageSmsContactList(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                this.setBoolean(1477050624, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1477050624));
                this.triggerObserver(-2147418048, eventGeneric);
                break;
            }
            case 1: {
                this.setString(10875, "");
                this.setInteger(0x4BB0000, 0);
                MessageActivity.lockWaitaphore(32458, 10000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(10875));
                eventGeneric.setInt(1, this.getInteger(0x4BB0000));
                this.triggerObserver(-1447359168, eventGeneric);
                this.setBoolean(28287, true);
                break;
            }
            case 4: {
                this.setString(-572129280, "");
                MessageActivity.lockWaitaphore(-2112880384, 10000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-572129280));
                this.triggerObserver(-2029977536, eventGeneric);
                this.setBoolean(28287, true);
                break;
            }
            case 7: {
                this.setInteger(11272, 1);
                break;
            }
            case 8: {
                this.setBoolean(67567872, true);
                break;
            }
            case 9: {
                this.setInteger(11272, 1);
                break;
            }
            case 13: {
                this.setBoolean(1477050624, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(1477050624));
                this.triggerObserver(-2147418048, eventGeneric);
                break;
            }
            case 17: {
                this.setBoolean(-606076928, true);
                this.setBoolean(67567872, true);
                this.setString(-1650262016, this.getI18nString(2508));
                if (this.getInteger(-1933901824) == 0) {
                    this.setString(-1650262016, this.getI18nString(2509));
                }
                MessageActivity.lockWaitaphore(11097, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-606076928));
                this.triggerObserver(-502661056, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIMessageSmsIncomingOptions(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(-1014628352, 0);
                break;
            }
            case 7: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1567198537, 1550421321);
                break;
            }
            case 11: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1567198537, 1550421321);
                break;
            }
            case 15: {
                this.showView("Msen", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 16: {
                this.showView("Msend", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 17: {
                this.setInteger(-1816264704, 0);
                this.showView("Msio", bl, this.getIncludeDdpGroupId());
                break;
            }
        }
    }

    private void performStateExitAction_SubIMessageSmsIncomingOptions(int n) {
        switch (n - this.S_OFFSET) {
            case 7: {
                this.leaveWaitaphore();
                break;
            }
            case 11: {
                this.leaveWaitaphore();
                break;
            }
            case 15: {
                this.hideView("Msen");
                break;
            }
            case 16: {
                this.hideView("Msend");
                break;
            }
            case 17: {
                this.hideView("Msio");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIMessageSmsIncomingOptions(int n) {
        switch (n - this.IT_OFFSET) {
            case 1: {
                return MessageActivity.evListItemEventSender().equals("Button_Number");
            }
            case 2: {
                return MessageActivity.evListItemEventSender().equals("Button_DialPrefix");
            }
            case 3: {
                return MessageActivity.evListItemEventSender().equals("Button_Edit");
            }
            case 4: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
            case 5: {
                return MessageActivity.evListItemEventSender().equals("Button_Number");
            }
            case 7: {
                return MessageActivity.evListItemEventSender().equals("Button_ContactDetails");
            }
            case 8: {
                return MessageActivity.evListItemEventSender().equals("Button_DialPrefix");
            }
            case 9: {
                return MessageActivity.evListItemEventSender().equals("Button_Edit");
            }
            case 10: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
            case 11: {
                return MessageActivity.evListItemEventSender().equals("Button_ContactDetails");
            }
            case 12: {
                return MessageActivity.evListItemEventSender().equals("Button_DeleteMessage");
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIMessageSmsIncomingOptions(int n) {
        this.performInternalTransitionAction_SubIMessageSmsIncomingOptions00(n);
    }

    private void performInternalTransitionAction_SubIMessageSmsIncomingOptions00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(27961, MessageActivity.evListItemActionIndex());
                break;
            }
            case 1: {
                this.setString(950992896, this.getLicValue(460, 4, this.getInteger(27961), ""));
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 2: {
                this.setString(950992896, FormatterService.format((CharSequence)"${0}${1}", this.getString(0x1C0C0100), this.getLicValue(459, 1, this.getInteger(784793600), "")));
                this.setLong(-544604160, this.getLicValue(460, 2, this.getInteger(27961), 0L));
                this.setInteger(29056, this.getLicValue(459, 2, this.getInteger(784793600), 0));
                this.setInteger(1620967424, -1);
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 3: {
                this.setString(28686, this.getLicValue(460, 4, this.getInteger(27961), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 41);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 4: {
                this.setString(-795082752, this.getLicValue(460, 1, this.getInteger(27961), ""));
                this.setString(1407320064, this.getLicValue(460, 4, this.getInteger(27961), ""));
                this.setLong(29990, this.getLicValue(460, 2, this.getInteger(27961), 0L));
                break;
            }
            case 5: {
                this.setString(28686, this.getLicValue(460, 4, this.getInteger(27961), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 6: {
                this.setInteger(784793600, MessageActivity.evListItemActionIndex());
                break;
            }
            case 7: {
                this.setString(950992896, this.getLicValue(459, 1, this.getInteger(784793600), ""));
                this.setLong(-544604160, this.getLicValue(460, 2, this.getInteger(27961), 0L));
                this.setInteger(29056, this.getLicValue(459, 2, this.getInteger(784793600), 0));
                this.setInteger(1620967424, -1);
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 8: {
                this.setString(950992896, FormatterService.format((CharSequence)"${0}${1}", this.getString(0x1C0C0100), this.getLicValue(459, 1, this.getInteger(784793600), "")));
                this.setLong(-544604160, this.getLicValue(460, 2, this.getInteger(27961), 0L));
                this.setInteger(29056, this.getLicValue(459, 2, this.getInteger(784793600), 0));
                this.setInteger(1620967424, -1);
                this.setInteger(-522518528, 1);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 9: {
                this.setString(28686, this.getLicValue(459, 1, this.getInteger(784793600), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 41);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 10: {
                this.setString(-795082752, this.getLicValue(460, 1, this.getInteger(27961), ""));
                this.setString(1407320064, this.getLicValue(459, 1, this.getInteger(784793600), ""));
                this.setLong(29990, this.getLicValue(460, 2, this.getInteger(27961), 0L));
                break;
            }
            case 11: {
                this.setString(28686, this.getLicValue(459, 1, this.getInteger(784793600), ""));
                this.setInteger(-522518528, 8);
                this.setInteger(1021706240, 0);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, 1465945417);
                break;
            }
            case 12: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1302753975);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubIMessageSmsIncomingOptions(int n) {
        switch (n - this.TT_OFFSET) {
            case 6: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubIMessageSmsIncomingOptions(int n) {
        this.performTriggeredTransitionAction_SubIMessageSmsIncomingOptions0(n);
    }

    private void performTriggeredTransitionAction_SubIMessageSmsIncomingOptions0(int n) {
        switch (n - this.TT_OFFSET) {
            case 5: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 6: {
                this.setInteger(-1816264704, 1);
                break;
            }
            case 7: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
            case 8: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 9: {
                this.setInteger(28341, 2);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubIMessageSmsIncomingOptions(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                return MessageActivity.evListItemEventSender().equals("Button_Details");
            }
            case 1: {
                return MessageActivity.evListItemEventSender().equals("Button_Message");
            }
            case 8: {
                return MessageActivity.evListItemEventSender().equals("Button_ReplyWithTemplate");
            }
            case 9: {
                return MessageActivity.evListItemEventSender().equals("Button_ExtractNumbers");
            }
            case 11: {
                return this.getInteger(28341) == 1;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubIMessageSmsIncomingOptions(int n) {
        switch (n - this.UT_OFFSET) {
            case 0: {
                this.setInteger(365363200, this.getInteger(27961));
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(365363200));
                this.triggerObserver(1979777088, eventGeneric);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1957130935);
                break;
            }
            case 1: {
                this.setInteger(-1816264704, 1);
                break;
            }
            case 5: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setLong(0, this.getLong(29990));
                eventGeneric.setString(1, this.getString(-795082752));
                eventGeneric.setString(2, this.getString(1407320064));
                this.triggerObserver(-1329918656, eventGeneric);
                break;
            }
            case 7: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(1895891008);
                break;
            }
            case 8: {
                this.setInteger(20200, 2);
                break;
            }
            case 9: {
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(-1563623424));
                this.triggerObserver(1812004928, eventGeneric);
                break;
            }
            case 12: {
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1940353719);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIMessageSmsNew(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 3: {
                this.setInteger(83361792, 2);
                break;
            }
            case 8: {
                this.showView("Msnp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 9: {
                this.showView("Msnvp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 11: {
                this.showView("Msl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 15: {
                this.setInteger(83361792, 1);
                this.setBoolean(1225720064, false);
                this.setBoolean(-316669696, false);
                break;
            }
            case 18: {
                this.setBoolean(-1431306240, true);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                this.showView("Msns_45A9", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 22: {
                this.enterWaitaphoreForProperty(-134020864, 374, 479, 1600752969, 1583975753);
                break;
            }
            case 26: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1600752969, 1583975753);
                break;
            }
        }
    }

    private void performStateExitAction_SubIMessageSmsNew(int n) {
        switch (n - this.S_OFFSET) {
            case 8: {
                this.hideView("Msnp");
                break;
            }
            case 9: {
                this.hideView("Msnvp");
                break;
            }
            case 11: {
                this.hideView("Msl");
                break;
            }
            case 12: {
                if (!this.getBoolean(-316669696)) {
                    MessageActivity.lockWaitaphore(1911750656, 1000);
                    this.triggerObserver(-1560215488);
                }
                this.triggerObserver(-1627324352);
                break;
            }
            case 15: {
                this.setBoolean(1225720064, false);
                this.setBoolean(28287, false);
                break;
            }
            case 18: {
                this.hideView("Msns_45A9");
                this.setBoolean(-1431306240, false);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setBoolean(0, this.getBoolean(-1431306240));
                this.triggerObserver(1459945536, eventGeneric);
                break;
            }
            case 22: {
                this.leaveWaitaphore();
                break;
            }
            case 26: {
                this.leaveWaitaphore();
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIMessageSmsNew(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(-124387328) && !this.getBoolean(383909888);
            }
            case 5: {
                return !this.getBoolean(28287);
            }
            case 6: {
                return this.getBoolean(-124387328) && this.getInteger(21581) == 0 && this.getSpellerData(-134020864).getEnteredText().length() > 0;
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIMessageSmsNew(int n) {
        this.performInternalTransitionAction_SubIMessageSmsNew00(n);
    }

    private void performInternalTransitionAction_SubIMessageSmsNew00(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1269199543);
                this.setBoolean(19089, false);
                break;
            }
            case 1: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1269199543);
                this.setBoolean(19089, true);
                break;
            }
            case 2: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -194605751);
                break;
            }
            case 5: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -77296311);
                break;
            }
            case 6: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1269199543);
                break;
            }
            case 7: {
                this.setString(-1441267456, MessageActivity.evSpellerValuePressedChar());
                this.setInteger(-955842304, MessageActivity.evSpellerValueCursorPosition());
                this.setInteger(27008, MessageActivity.evSpellerValueSelectionStart());
                this.setInteger(-553385728, MessageActivity.evSpellerValueSelectionEnd());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-1441267456));
                eventGeneric.setInt(1, this.getInteger(27008));
                eventGeneric.setInt(2, this.getInteger(-553385728));
                eventGeneric.setInt(3, this.getInteger(-955842304));
                this.triggerObserver(-1380250304, eventGeneric);
                break;
            }
            case 8: {
                this.triggerObserver(-1610547136);
                break;
            }
            case 9: {
                this.triggerObserver(-1593769920);
                break;
            }
            case 10: {
                this.setInteger(11933, MessageActivity.evSpellerValueCursorPosition());
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(11933));
                this.triggerObserver(-1526661056, eventGeneric);
                break;
            }
            case 11: {
                this.setBoolean(1225720064, true);
                MessageActivity.fireHMIEvent(ANY, BROADCAST, -1201107639);
                break;
            }
            case 12: {
                this.setBoolean(1225720064, false);
                break;
            }
            case 13: {
                this.triggerObserver(-1593769920);
                break;
            }
            case 14: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(-1560215488);
                break;
            }
        }
    }

    private boolean evalTriggeredTransitionGuard_SubIMessageSmsNew(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                return !this.getLicValue(4037, 7, 0, false);
            }
            case 3: {
                return this.getBoolean(-1076297728) && this.getBoolean(-1076297728);
            }
            case 4: {
                return !this.getBoolean(19089);
            }
        }
        return true;
    }

    private void performTriggeredTransitionAction_SubIMessageSmsNew(int n) {
        this.performTriggeredTransitionAction_SubIMessageSmsNew0(n);
    }

    private void performTriggeredTransitionAction_SubIMessageSmsNew0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setString(1354956800, this.getLicValue(4037, 6, 0, ""));
                this.setInteger(21581, 1);
                break;
            }
            case 2: {
                this.setInteger(20200, 0);
                break;
            }
            case 3: {
                this.setInteger(-1933901824, 0);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubIMessageSmsNew(int n) {
        switch (n - this.UT_OFFSET) {
            case 3: {
                return this.getLicValue(4037, 7, 0, false);
            }
            case 5: {
                return !this.getBoolean(1911750656);
            }
            case 15: {
                return this.getInteger(11272) == 1;
            }
            case 17: {
                return this.getInteger(21581) == 1 && this.getSpellerData(-134020864).getEnteredText().length() > 0;
            }
            case 19: {
                return this.getInteger(83361792) == 2;
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubIMessageSmsNew(int n) {
        switch (n - this.UT_OFFSET) {
            case 12: {
                MessageActivity.lockWaitaphore(-134020864, 10000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(1354956800));
                this.triggerObserver(-1576992704, eventGeneric);
                this.setBoolean(28287, true);
                break;
            }
            case 14: {
                MessageActivity.lockWaitaphore(1911750656, 1000);
                this.triggerObserver(-1560215488);
                this.setBoolean(-316669696, true);
                break;
            }
            case 20: {
                this.setString(1354956800, "");
                if (this.getBoolean(15371)) {
                    this.setString(1354956800, this.getLicValue(4037, 6, 0, ""));
                }
                this.setInteger(21581, 0);
                break;
            }
        }
    }

    private void performStateEntryAction_SubIMessageSmsTemplate(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(28341, 2);
                break;
            }
            case 3: {
                MessageActivity.fireHMIEvent(this.fromMe(), this.meSelf(), 1298238793);
                break;
            }
            case 8: {
                this.showView("Mstl", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 12: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1634307401, 1617530185);
                break;
            }
            case 16: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1634307401, 1617530185);
                break;
            }
            case 20: {
                this.enterWaitaphoreForAslList(-1226699520, 374, 479, 1634307401, 1617530185);
                break;
            }
            case 24: {
                this.enterWaitaphoreForAslList(-1226699520, 374, 479, 1634307401, 1617530185);
                break;
            }
            case 28: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1634307401, 1617530185);
                break;
            }
            case 32: {
                this.enterWaitaphoreForProperty(1911750656, 374, 479, 1634307401, 1617530185);
                break;
            }
        }
    }

    private void performStateExitAction_SubIMessageSmsTemplate(int n) {
        switch (n - this.S_OFFSET) {
            case 8: {
                this.hideView("Mstl");
                this.setInteger(29725, SkinDataPool.getInteger(180));
                break;
            }
            case 12: {
                this.leaveWaitaphore();
                break;
            }
            case 16: {
                this.leaveWaitaphore();
                break;
            }
            case 20: {
                this.leaveWaitaphore();
                break;
            }
            case 24: {
                this.leaveWaitaphore();
                break;
            }
            case 28: {
                this.leaveWaitaphore();
                break;
            }
            case 32: {
                this.leaveWaitaphore();
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubIMessageSmsTemplate(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return MessageActivity.evListItemEventSender().equals("Button_Template") || MessageActivity.evListItemEventSender().equals("Button_Next");
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubIMessageSmsTemplate(int n) {
        this.performInternalTransitionAction_SubIMessageSmsTemplate0(n);
    }

    private void performInternalTransitionAction_SubIMessageSmsTemplate0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                this.setInteger(-729153536, MessageActivity.evListItemActionIndex());
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubIMessageSmsTemplate(int n) {
        this.performTriggeredTransitionAction_SubIMessageSmsTemplate0(n);
    }

    private void performTriggeredTransitionAction_SubIMessageSmsTemplate0(int n) {
        switch (n - this.TT_OFFSET) {
            case 0: {
                this.setInteger(28341, 1);
                this.setString(18852, MessageActivity.evListItemEventSender());
                break;
            }
            case 1: {
                this.setInteger(28341, 2);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubIMessageSmsTemplate(int n) {
        switch (n - this.UT_OFFSET) {
            case 16: {
                return MessageActivity.evListItemEventSender().equals("Button_Next") && this.getBoolean(-1076297728) && this.getBoolean(-1076297728);
            }
            case 17: {
                return MessageActivity.evListItemEventSender().equals("Button_Template");
            }
            case 18: {
                return MessageActivity.evListItemEventSender().equals("Button_Template_Navigation") && this.getBoolean(22877);
            }
            case 19: {
                return MessageActivity.evListItemEventSender().equals("Button_Next_Navigation") && this.getBoolean(-1076297728) && this.getBoolean(-1076297728);
            }
        }
        return true;
    }

    private void performUntriggeredTransitionAction_SubIMessageSmsTemplate(int n) {
        switch (n - this.UT_OFFSET) {
            case 2: {
                this.triggerObserver(-1564799680);
                break;
            }
            case 3: {
                this.setBoolean(-1666973696, true);
                this.setBoolean(-1745879040, false);
                break;
            }
            case 5: {
                if (this.getInteger(388038912) != 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2604), this.getLicValue(-1226699520, 1, 0, "")));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2598), this.getLicValue(-1226699520, 1, 0, ""), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2601), this.getLicValue(-1226699520, 1, 0, ""), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && !this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2599), this.getLicValue(-1226699520, 1, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && !this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2602), this.getLicValue(-1226699520, 1, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2600), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2603), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && !this.getLicValue(-1226699520, 11, 0, false) && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2605), this.getLicValue(-1226699520, 2, 0, "")));
                }
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-403243008));
                this.triggerObserver(2030108736, eventGeneric);
                break;
            }
            case 6: {
                this.setInteger(-1933901824, 0);
                break;
            }
            case 7: {
                if (this.getInteger(388038912) != 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2604), this.getLicValue(-1226699520, 1, 0, "")));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2598), this.getLicValue(-1226699520, 1, 0, ""), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2601), this.getLicValue(-1226699520, 1, 0, ""), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && !this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2599), this.getLicValue(-1226699520, 1, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && this.getLicValue(-1226699520, 8, 0, false) && !this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2602), this.getLicValue(-1226699520, 1, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 0 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2600), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(71, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && this.getLicValue(-1226699520, 11, 0, false) && this.getInteger(435814400) == 1 && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format((CharSequence)this.getI18nString(2603), this.getLicValue(-1226699520, 2, 0, ""), ServiceManagerCommon.fixFormat.format(72, this.getLicValue(-1226699520, 5, 0, 0), this.getLicValue(-1226699520, 6, 0, 0), this.getLicValue(-1226699520, 4, 0, 0))));
                }
                if (this.getInteger(388038912) == 1 && !this.getLicValue(-1226699520, 8, 0, false) && this.getLicValue(-1226699520, 9, 0, false) && !this.getLicValue(-1226699520, 11, 0, false) && this.getBoolean(22877)) {
                    this.setString(-403243008, FormatterService.format(this.getI18nString(2605), this.getLicValue(-1226699520, 2, 0, "")));
                }
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-403243008));
                this.triggerObserver(2030108736, eventGeneric);
                break;
            }
            case 9: {
                this.triggerObserver(-1564799680);
                break;
            }
            case 11: {
                this.triggerObserver(-1564799680);
                break;
            }
            case 13: {
                this.setString(-403243008, this.getI18nStrings(158)[this.getInteger(-729153536)]);
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-403243008));
                this.triggerObserver(2030108736, eventGeneric);
                break;
            }
            case 14: {
                this.setInteger(-1933901824, 0);
                break;
            }
            case 15: {
                this.setString(-403243008, this.getI18nStrings(158)[this.getInteger(-729153536)]);
                MessageActivity.lockWaitaphore(1911750656, 1000);
                EventGeneric eventGeneric = MessageActivity.newEvent();
                eventGeneric.setString(0, this.getString(-403243008));
                this.triggerObserver(2030108736, eventGeneric);
                break;
            }
        }
    }

    private void performStateEntryAction_SubPromptingMessagesDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 2: {
                MessageActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 3: {
                MessageActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 8);
                break;
            }
            case 5: {
                MessageActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 5);
                MessageActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 6: {
                MessageActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 7);
                MessageActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 7: {
                MessageActivity.pushSdFeatureCollection(this.topStatemachine.getSpeechIndex(), 6);
                MessageActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
            case 8: {
                MessageActivity.changeSdFeatureCollection(this.topStatemachine.getSpeechIndex(), this.topStatemachine.getSpeechClientId());
                break;
            }
        }
    }

    private void performStateExitAction_SubPromptingMessagesDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 3: {
                MessageActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 5: {
                MessageActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 6: {
                MessageActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
            case 7: {
                MessageActivity.popSdFeatureCollection(this.topStatemachine.getSpeechIndex());
                break;
            }
        }
    }
}

