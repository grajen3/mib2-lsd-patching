/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.generated.telephone.TelephoneBindingFactory;
import de.vw.mib.bap.mqbab2.telephone.functions.AcceptCall;
import de.vw.mib.bap.mqbab2.telephone.functions.ActiveUser;
import de.vw.mib.bap.mqbab2.telephone.functions.AutomaticRedial;
import de.vw.mib.bap.mqbab2.telephone.functions.AutomaticRedialExtendedInfo;
import de.vw.mib.bap.mqbab2.telephone.functions.CCJoin;
import de.vw.mib.bap.mqbab2.telephone.functions.CCSplit;
import de.vw.mib.bap.mqbab2.telephone.functions.CallDurationSync;
import de.vw.mib.bap.mqbab2.telephone.functions.CallHold;
import de.vw.mib.bap.mqbab2.telephone.functions.CallInfo;
import de.vw.mib.bap.mqbab2.telephone.functions.CallStackDeleteAll;
import de.vw.mib.bap.mqbab2.telephone.functions.CallState;
import de.vw.mib.bap.mqbab2.telephone.functions.CombinedNumbers;
import de.vw.mib.bap.mqbab2.telephone.functions.ConfirmEmergencyCall;
import de.vw.mib.bap.mqbab2.telephone.functions.DataConnectionIndication;
import de.vw.mib.bap.mqbab2.telephone.functions.DialNumber;
import de.vw.mib.bap.mqbab2.telephone.functions.DialService;
import de.vw.mib.bap.mqbab2.telephone.functions.DialedNumbers;
import de.vw.mib.bap.mqbab2.telephone.functions.DisconnectReason;
import de.vw.mib.bap.mqbab2.telephone.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbab2.telephone.functions.FSGSetup;
import de.vw.mib.bap.mqbab2.telephone.functions.FavoriteList;
import de.vw.mib.bap.mqbab2.telephone.functions.FunctionList;
import de.vw.mib.bap.mqbab2.telephone.functions.GetNextListPos;
import de.vw.mib.bap.mqbab2.telephone.functions.HandsFreeOnOff;
import de.vw.mib.bap.mqbab2.telephone.functions.HangupCall;
import de.vw.mib.bap.mqbab2.telephone.functions.Keypad;
import de.vw.mib.bap.mqbab2.telephone.functions.LockState;
import de.vw.mib.bap.mqbab2.telephone.functions.MPCallHoldAcceptWaitingCall;
import de.vw.mib.bap.mqbab2.telephone.functions.MPReleaseActiveCallAccpetWaitingCall;
import de.vw.mib.bap.mqbab2.telephone.functions.MPReleaseAllCallsAcceptWaitingCall;
import de.vw.mib.bap.mqbab2.telephone.functions.MPSetWaitingCallOnHold;
import de.vw.mib.bap.mqbab2.telephone.functions.MPSwap;
import de.vw.mib.bap.mqbab2.telephone.functions.MicroMuteOnOff;
import de.vw.mib.bap.mqbab2.telephone.functions.MissedCallIndication;
import de.vw.mib.bap.mqbab2.telephone.functions.MissedCalls;
import de.vw.mib.bap.mqbab2.telephone.functions.MobileBatteryLevel;
import de.vw.mib.bap.mqbab2.telephone.functions.MobileServiceSupport;
import de.vw.mib.bap.mqbab2.telephone.functions.NetworkProvider;
import de.vw.mib.bap.mqbab2.telephone.functions.PbSpeller;
import de.vw.mib.bap.mqbab2.telephone.functions.PbState;
import de.vw.mib.bap.mqbab2.telephone.functions.Phonebook;
import de.vw.mib.bap.mqbab2.telephone.functions.ReceivedCalls;
import de.vw.mib.bap.mqbab2.telephone.functions.RegisterState;
import de.vw.mib.bap.mqbab2.telephone.functions.ResumeCall;
import de.vw.mib.bap.mqbab2.telephone.functions.RingToneMuteOnOff;
import de.vw.mib.bap.mqbab2.telephone.functions.SMSState;
import de.vw.mib.bap.mqbab2.telephone.functions.SignalQuality;
import de.vw.mib.bap.mqbab2.telephone.functions.SupportedServiceNumbers;

public class TelephoneBindingFactoryAll
implements TelephoneBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetup();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewMobileServiceSupportStage() {
        return new MobileServiceSupport();
    }

    @Override
    public BAPStage createNewActiveUserStage() {
        return new ActiveUser();
    }

    @Override
    public BAPStage createNewRegisterStateStage() {
        return new RegisterState();
    }

    @Override
    public BAPStage createNewLockStateStage() {
        return new LockState();
    }

    @Override
    public BAPStage createNewNetworkProviderStage() {
        return new NetworkProvider();
    }

    @Override
    public BAPStage createNewSignalQualityStage() {
        return new SignalQuality();
    }

    @Override
    public BAPStage createNewCallStateStage() {
        return new CallState();
    }

    @Override
    public BAPStage createNewCallInfoStage() {
        return new CallInfo();
    }

    @Override
    public BAPStage createNewCallDurationSyncStage() {
        return new CallDurationSync();
    }

    @Override
    public BAPStage createNewDisconnectReasonStage() {
        return new DisconnectReason();
    }

    @Override
    public BAPStage createNewDialNumberStage() {
        return new DialNumber();
    }

    @Override
    public BAPStage createNewDialServiceStage() {
        return new DialService();
    }

    @Override
    public BAPStage createNewConfirmEmergencyCallStage() {
        return new ConfirmEmergencyCall();
    }

    @Override
    public BAPStage createNewHangupCallStage() {
        return new HangupCall();
    }

    @Override
    public BAPStage createNewAcceptCallStage() {
        return new AcceptCall();
    }

    @Override
    public BAPStage createNewCallHoldStage() {
        return new CallHold();
    }

    @Override
    public BAPStage createNewResumeCallStage() {
        return new ResumeCall();
    }

    @Override
    public BAPStage createNewHandsFreeOnOffStage() {
        return new HandsFreeOnOff();
    }

    @Override
    public BAPStage createNewMicroMuteOnOffStage() {
        return new MicroMuteOnOff();
    }

    @Override
    public BAPStage createNewMPReleaseActiveCallAccpetWaitingCallStage() {
        return new MPReleaseActiveCallAccpetWaitingCall();
    }

    @Override
    public BAPStage createNewMPSwapStage() {
        return new MPSwap();
    }

    @Override
    public BAPStage createNewMPCallHoldAcceptWaitingCallStage() {
        return new MPCallHoldAcceptWaitingCall();
    }

    @Override
    public BAPStage createNewMPReleaseAllCallsAcceptWaitingCallStage() {
        return new MPReleaseAllCallsAcceptWaitingCall();
    }

    @Override
    public BAPStage createNewMPSetWaitingCallOnHoldStage() {
        return new MPSetWaitingCallOnHold();
    }

    @Override
    public BAPStage createNewCCJoinStage() {
        return new CCJoin();
    }

    @Override
    public BAPStage createNewCCSplitStage() {
        return new CCSplit();
    }

    @Override
    public BAPStage createNewKeypadStage() {
        return new Keypad();
    }

    @Override
    public BAPStage createNewMobileBatteryLevelStage() {
        return new MobileBatteryLevel();
    }

    @Override
    public BAPStage createNewDataConnectionIndicationStage() {
        return new DataConnectionIndication();
    }

    @Override
    public BAPStage createNewMissedCallIndicationStage() {
        return new MissedCallIndication();
    }

    @Override
    public BAPStage createNewMissedCallsStage() {
        return new MissedCalls();
    }

    @Override
    public BAPStage createNewReceivedCallsStage() {
        return new ReceivedCalls();
    }

    @Override
    public BAPStage createNewDialedNumbersStage() {
        return new DialedNumbers();
    }

    @Override
    public BAPStage createNewCombinedNumbersStage() {
        return new CombinedNumbers();
    }

    @Override
    public BAPStage createNewCallStackDeleteAllStage() {
        return new CallStackDeleteAll();
    }

    @Override
    public BAPStage createNewPbStateStage() {
        return new PbState();
    }

    @Override
    public BAPStage createNewPhonebookStage() {
        return new Phonebook();
    }

    @Override
    public BAPStage createNewPbSpellerStage() {
        return new PbSpeller();
    }

    @Override
    public BAPStage createNewGetNextListPosStage() {
        return new GetNextListPos();
    }

    @Override
    public BAPStage createNewSMSStateStage() {
        return new SMSState();
    }

    @Override
    public BAPStage createNewRingToneMuteOnOffStage() {
        return new RingToneMuteOnOff();
    }

    @Override
    public BAPStage createNewAutomaticRedialStage() {
        return new AutomaticRedial();
    }

    @Override
    public BAPStage createNewAutomaticRedialExtendedInfoStage() {
        return new AutomaticRedialExtendedInfo();
    }

    @Override
    public BAPStage createNewSupportedServiceNumbersStage() {
        return new SupportedServiceNumbers();
    }

    @Override
    public BAPStage createNewFavoriteListStage() {
        return new FavoriteList();
    }
}

