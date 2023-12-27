/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbab2.generated.telephone.TelephoneBindingFactory;

public class BAPTelephoneDataPool
extends AbstractBAPDataPool {
    private TelephoneBindingFactory _factory;

    public BAPTelephoneDataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public TelephoneBindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(TelephoneBindingFactory telephoneBindingFactory) {
        this._factory = telephoneBindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    public final void reinitialize(TelephoneBindingFactory telephoneBindingFactory) {
        super.uninitialize();
        this.initializeInternal(telephoneBindingFactory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(TelephoneBindingFactory telephoneBindingFactory) {
        this.addStage(telephoneBindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(telephoneBindingFactory.createNewFSGSetupStage(), 3, 1, "FSGSetup");
        this.addStage(telephoneBindingFactory.createNewFSGOperationStateStage(), 3, 1, "FSGOperationState");
        this.addStage(telephoneBindingFactory.createNewMobileServiceSupportStage(), 3, 1, "MobileServiceSupport");
        this.addStage(telephoneBindingFactory.createNewActiveUserStage(), 3, 1, "ActiveUser");
        this.addStage(telephoneBindingFactory.createNewRegisterStateStage(), 3, 1, "RegisterState");
        this.addStage(telephoneBindingFactory.createNewLockStateStage(), 0, 1, "LockState");
        this.addStage(telephoneBindingFactory.createNewNetworkProviderStage(), 3, 1, "NetworkProvider");
        this.addStage(telephoneBindingFactory.createNewSignalQualityStage(), 0, 1, "SignalQuality");
        this.addStage(telephoneBindingFactory.createNewCallStateStage(), 3, 1, "CallState");
        this.addStage(telephoneBindingFactory.createNewCallInfoStage(), 3, 1, "CallInfo");
        this.addStage(telephoneBindingFactory.createNewCallDurationSyncStage(), 3, 1, "CallDurationSync");
        this.addStage(telephoneBindingFactory.createNewDisconnectReasonStage(), 0, 1, "DisconnectReason");
        this.addStage(telephoneBindingFactory.createNewDialNumberStage(), 0, 3, "DialNumber");
        this.addStage(telephoneBindingFactory.createNewDialServiceStage(), 0, 3, "DialService");
        this.addStage(telephoneBindingFactory.createNewConfirmEmergencyCallStage(), 0, 3, "ConfirmEmergencyCall");
        this.addStage(telephoneBindingFactory.createNewHangupCallStage(), 0, 3, "HangupCall");
        this.addStage(telephoneBindingFactory.createNewAcceptCallStage(), 0, 3, "AcceptCall");
        this.addStage(telephoneBindingFactory.createNewCallHoldStage(), 0, 3, "CallHold");
        this.addStage(telephoneBindingFactory.createNewResumeCallStage(), 0, 3, "ResumeCall");
        this.addStage(telephoneBindingFactory.createNewHandsFreeOnOffStage(), 0, 1, "HandsFreeOnOff");
        this.addStage(telephoneBindingFactory.createNewMicroMuteOnOffStage(), 0, 1, "MicroMuteOnOff");
        this.addStage(telephoneBindingFactory.createNewMPReleaseActiveCallAccpetWaitingCallStage(), 0, 3, "MPReleaseActiveCallAccpetWaitingCall");
        this.addStage(telephoneBindingFactory.createNewMPSwapStage(), 0, 3, "MPSwap");
        this.addStage(telephoneBindingFactory.createNewMPCallHoldAcceptWaitingCallStage(), 0, 3, "MPCallHoldAcceptWaitingCall");
        this.addStage(telephoneBindingFactory.createNewMPReleaseAllCallsAcceptWaitingCallStage(), 0, 3, "MPReleaseAllCallsAcceptWaitingCall");
        this.addStage(telephoneBindingFactory.createNewMPSetWaitingCallOnHoldStage(), 0, 3, "MPSetWaitingCallOnHold");
        this.addStage(telephoneBindingFactory.createNewCCJoinStage(), 0, 3, "CCJoin");
        this.addStage(telephoneBindingFactory.createNewCCSplitStage(), 0, 3, "CCSplit");
        this.addStage(telephoneBindingFactory.createNewKeypadStage(), 0, 1, "Keypad");
        this.addStage(telephoneBindingFactory.createNewMobileBatteryLevelStage(), 3, 1, "MobileBatteryLevel");
        this.addStage(telephoneBindingFactory.createNewDataConnectionIndicationStage(), 3, 1, "DataConnectionIndication");
        this.addStage(telephoneBindingFactory.createNewMissedCallIndicationStage(), 3, 1, "MissedCallIndication");
        this.addStage(telephoneBindingFactory.createNewMissedCallsStage(), 3, 2, "MissedCalls");
        this.addStage(telephoneBindingFactory.createNewReceivedCallsStage(), 3, 2, "ReceivedCalls");
        this.addStage(telephoneBindingFactory.createNewDialedNumbersStage(), 3, 2, "DialedNumbers");
        this.addStage(telephoneBindingFactory.createNewCombinedNumbersStage(), 3, 2, "CombinedNumbers");
        this.addStage(telephoneBindingFactory.createNewCallStackDeleteAllStage(), 0, 3, "CallStackDeleteAll");
        this.addStage(telephoneBindingFactory.createNewPbStateStage(), 3, 1, "PbState");
        this.addStage(telephoneBindingFactory.createNewPhonebookStage(), 3, 2, "Phonebook");
        this.addStage(telephoneBindingFactory.createNewPbSpellerStage(), 3, 3, "PbSpeller");
        this.addStage(telephoneBindingFactory.createNewGetNextListPosStage(), 3, 3, "GetNextListPos");
        this.addStage(telephoneBindingFactory.createNewSMSStateStage(), 3, 1, "SMSState");
        this.addStage(telephoneBindingFactory.createNewRingToneMuteOnOffStage(), 0, 1, "RingToneMuteOnOff");
        this.addStage(telephoneBindingFactory.createNewAutomaticRedialStage(), 0, 1, "AutomaticRedial");
        this.addStage(telephoneBindingFactory.createNewAutomaticRedialExtendedInfoStage(), 3, 1, "AutomaticRedialExtendedInfo");
        this.addStage(telephoneBindingFactory.createNewSupportedServiceNumbersStage(), 3, 1, "SupportedServiceNumbers");
        this.addStage(telephoneBindingFactory.createNewFavoriteListStage(), 3, 2, "FavoriteList");
    }
}

