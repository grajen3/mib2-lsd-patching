/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.swdlcustomerdownload.sm;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import generated.de.vw.mib.global.datapool.SkinDataPool;
import generated.de.vw.mib.global.sm.internal.activity.StatemachineActivityBase;

public class SwdlCustomerDownloadActivity
extends StatemachineActivityBase {
    private final int subStatemachineId;

    public SwdlCustomerDownloadActivity(TopStatemachine topStatemachine, int n, int n2, int n3, int n4, int n5) {
        super(topStatemachine, n2, n3, n4, n5);
        this.subStatemachineId = n;
    }

    @Override
    public void performStateEntryAction(int n, boolean bl) {
        switch (this.subStatemachineId) {
            case 54: {
                this.performStateEntryAction_SubHapticSwdlCustomerDownloadDynState(n, bl);
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
            case 54: {
                this.performStateExitAction_SubHapticSwdlCustomerDownloadDynState(n);
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
            case 54: {
                return this.evalInternalTransitionGuard_SubHapticSwdlCustomerDownloadDynState(n);
            }
        }
        return true;
    }

    @Override
    public void performInternalTransitionAction(int n) {
        switch (this.subStatemachineId) {
            case 54: {
                this.performInternalTransitionAction_SubHapticSwdlCustomerDownloadDynState(n);
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
            case 54: {
                this.performTriggeredTransitionAction_SubHapticSwdlCustomerDownloadDynState(n);
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
            case 54: {
                return this.evalUntriggeredTransitionGuard_SubHapticSwdlCustomerDownloadDynState(n);
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

    private void performStateEntryAction_SubHapticSwdlCustomerDownloadDynState(int n, boolean bl) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1527709952, 2);
                break;
            }
            case 8: {
                this.setInteger(26545, SkinDataPool.getInteger(190));
                this.setInteger(0x820000, 21);
                this.setInteger(1527709952, 3);
                break;
            }
            case 11: {
                this.setBoolean(-351993600, true);
                break;
            }
            case 18: {
                this.setInteger(84869376, 3);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                this.showView("Scdanp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 19: {
                this.setInteger(84869376, 2);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                this.showView("Scdnanp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 20: {
                this.setInteger(84869376, 4);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                break;
            }
            case 23: {
                this.showView("Scda", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 24: {
                this.showView("Scdp", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 25: {
                this.showView("Scdpe", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 26: {
                this.setInteger(84869376, 1);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                this.showView("Scdnap", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 27: {
                this.showView("Srw", bl, this.getIncludeDdpGroupId());
                break;
            }
            case 31: {
                this.setInteger(0x100A0100, 5);
                this.setInteger(1150418944, 7);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(1150418944));
                this.triggerObserver(0x50050040, eventGeneric);
                break;
            }
            case 34: {
                SwdlCustomerDownloadActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 35: {
                this.setInteger(1527709952, 2);
                break;
            }
        }
    }

    private void performStateExitAction_SubHapticSwdlCustomerDownloadDynState(int n) {
        switch (n - this.S_OFFSET) {
            case 0: {
                this.setInteger(1527709952, 0);
                break;
            }
            case 8: {
                this.setInteger(26545, SkinDataPool.getInteger(180));
                this.setInteger(0x820000, 0);
                break;
            }
            case 11: {
                this.setBoolean(-351993600, false);
                break;
            }
            case 18: {
                this.hideView("Scdanp");
                this.setInteger(84869376, 0);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                break;
            }
            case 19: {
                this.hideView("Scdnanp");
                this.setInteger(84869376, 0);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                break;
            }
            case 20: {
                this.setInteger(84869376, 0);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                break;
            }
            case 23: {
                this.hideView("Scda");
                break;
            }
            case 24: {
                this.hideView("Scdp");
                break;
            }
            case 25: {
                this.hideView("Scdpe");
                break;
            }
            case 26: {
                this.hideView("Scdnap");
                this.setInteger(84869376, 0);
                EventGeneric eventGeneric = SwdlCustomerDownloadActivity.newEvent();
                eventGeneric.setInt(0, this.getInteger(84869376));
                this.triggerObserver(1460142144, eventGeneric);
                break;
            }
            case 27: {
                this.hideView("Srw");
                break;
            }
        }
    }

    private boolean evalInternalTransitionGuard_SubHapticSwdlCustomerDownloadDynState(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                return this.getBoolean(-1347092480);
            }
        }
        return true;
    }

    private void performInternalTransitionAction_SubHapticSwdlCustomerDownloadDynState(int n) {
        this.performInternalTransitionAction_SubHapticSwdlCustomerDownloadDynState0(n);
    }

    private void performInternalTransitionAction_SubHapticSwdlCustomerDownloadDynState0(int n) {
        switch (n - this.IT_OFFSET) {
            case 0: {
                SwdlCustomerDownloadActivity.fireHMIEvent(ANY, BROADCAST, 1231064393);
                break;
            }
            case 1: {
                this.setInteger(26545, SkinDataPool.getInteger(190));
                break;
            }
            case 2: {
                this.setInteger(26545, SkinDataPool.getInteger(180));
                break;
            }
            case 3: {
                SwdlCustomerDownloadActivity.fireHMIEvent(ANY, BROADCAST, 1264684361);
                break;
            }
            case 4: {
                this.triggerObserver(1476919360);
                this.triggerObserver(1493696576);
                SwdlCustomerDownloadActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1150841527);
                break;
            }
            case 5: {
                this.triggerObserver(1476919360);
                this.triggerObserver(1493696576);
                SwdlCustomerDownloadActivity.fireHMIEvent(this.fromMe(), this.meSelf(), -1150841527);
                break;
            }
        }
    }

    private void performTriggeredTransitionAction_SubHapticSwdlCustomerDownloadDynState(int n) {
        this.performTriggeredTransitionAction_SubHapticSwdlCustomerDownloadDynState0(n);
    }

    private void performTriggeredTransitionAction_SubHapticSwdlCustomerDownloadDynState0(int n) {
        switch (n - this.TT_OFFSET) {
            case 3: {
                this.triggerObserver(939589696);
                break;
            }
        }
    }

    private boolean evalUntriggeredTransitionGuard_SubHapticSwdlCustomerDownloadDynState(int n) {
        switch (n - this.UT_OFFSET) {
            case 6: {
                return this.getInteger(-561905664) == 0;
            }
            case 7: {
                return this.getInteger(-561905664) == 1;
            }
            case 10: {
                return this.getBoolean(-1028980736) && this.getBoolean(-1347092480);
            }
            case 11: {
                return !this.getBoolean(-1028980736);
            }
            case 14: {
                return !this.getBoolean(-1347092480);
            }
            case 17: {
                return !this.getBoolean(-2066743296);
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

