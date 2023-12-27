/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllSupported;
    public boolean fctBapConfigSupported;
    public boolean fctFunctionListSupported;
    public boolean fctHeartbeatSupported;
    private static final int RESERVED_BIT_5__13_BITSIZE;
    public boolean fctFsg_SetupSupported;
    public boolean fctFsg_OperationStateSupported;
    public boolean fctMobileServiceSupportAvailable;
    public boolean fctActiveUserSupported;
    public boolean fctRegisterStateSupported;
    public boolean fctLockStateSupported;
    public boolean fctNetworkProviderSupported;
    public boolean fctSignalQualitySupported;
    public boolean fctCallStateSupported;
    public boolean fctCallInfoSupported;
    public boolean fctCallDurationSyncSupported;
    public boolean fctDisconnectReasonSupported;
    public boolean fctDialNumberSupported;
    public boolean fctDialServiceSupported;
    public boolean fctConfirmEmergencyCallSupported;
    public boolean fctHangupCallSupported;
    public boolean fctAcceptCallSupported;
    public boolean fctCallHoldSupported;
    public boolean fctResumeCallSupported;
    public boolean fctHandsFreeOnOffSupported;
    public boolean fctMicroMuteOnOffSupported;
    public boolean fctMpreleaseActiveCallAcceptWaitingCallSupported;
    public boolean fctMpswapSupported;
    public boolean fctMpcallHoldAcceptWaitingCallSupported;
    public boolean fctMpreleaseAllCallsAcceptWaitingCallSupported;
    public boolean fctMpsetWaitingCallOnHoldSupported;
    public boolean fctCcjoinSupported;
    public boolean fctCcsplitSupported;
    public boolean fctKeypadSupported;
    public boolean fctMobileBatteryLevelSupported;
    public boolean fctDataConnectionIndicationSupported;
    public boolean fctMissedCallIndicationSupported;
    public boolean fctMissedCallsSupported;
    public boolean fctReceivedCallsSupported;
    public boolean fctDialedNumbersSupported;
    public boolean fctCombinedNumbersSupported;
    public boolean fctCallStackDeleteAllSupported;
    public boolean fctPbStateSupported;
    public boolean fctPhonebookSupported;
    public boolean fctPbSpellerSupported;
    public boolean fctGetNextListPosSupported;
    public boolean fctSmsstateSupported;
    public boolean fctRingToneMuteOnOffSupported;
    public boolean fctAutomaticRedialSupported;
    public boolean fctAutomaticRedialExtendedInfoSupported;
    public boolean fctSupportedServiceNumbersSupported;
    public boolean fctFavoriteListSupported;
    private static final int RESERVED_BIT_61__63_BITSIZE;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctGetAllSupported = false;
        this.fctBapConfigSupported = false;
        this.fctFunctionListSupported = false;
        this.fctHeartbeatSupported = false;
        this.fctFsg_SetupSupported = false;
        this.fctFsg_OperationStateSupported = false;
        this.fctMobileServiceSupportAvailable = false;
        this.fctActiveUserSupported = false;
        this.fctRegisterStateSupported = false;
        this.fctLockStateSupported = false;
        this.fctNetworkProviderSupported = false;
        this.fctSignalQualitySupported = false;
        this.fctCallStateSupported = false;
        this.fctCallInfoSupported = false;
        this.fctCallDurationSyncSupported = false;
        this.fctDisconnectReasonSupported = false;
        this.fctDialNumberSupported = false;
        this.fctDialServiceSupported = false;
        this.fctConfirmEmergencyCallSupported = false;
        this.fctHangupCallSupported = false;
        this.fctAcceptCallSupported = false;
        this.fctCallHoldSupported = false;
        this.fctResumeCallSupported = false;
        this.fctHandsFreeOnOffSupported = false;
        this.fctMicroMuteOnOffSupported = false;
        this.fctMpreleaseActiveCallAcceptWaitingCallSupported = false;
        this.fctMpswapSupported = false;
        this.fctMpcallHoldAcceptWaitingCallSupported = false;
        this.fctMpreleaseAllCallsAcceptWaitingCallSupported = false;
        this.fctMpsetWaitingCallOnHoldSupported = false;
        this.fctCcjoinSupported = false;
        this.fctCcsplitSupported = false;
        this.fctKeypadSupported = false;
        this.fctMobileBatteryLevelSupported = false;
        this.fctDataConnectionIndicationSupported = false;
        this.fctMissedCallIndicationSupported = false;
        this.fctMissedCallsSupported = false;
        this.fctReceivedCallsSupported = false;
        this.fctDialedNumbersSupported = false;
        this.fctCombinedNumbersSupported = false;
        this.fctCallStackDeleteAllSupported = false;
        this.fctPbStateSupported = false;
        this.fctPhonebookSupported = false;
        this.fctPbSpellerSupported = false;
        this.fctGetNextListPosSupported = false;
        this.fctSmsstateSupported = false;
        this.fctRingToneMuteOnOffSupported = false;
        this.fctAutomaticRedialSupported = false;
        this.fctAutomaticRedialExtendedInfoSupported = false;
        this.fctSupportedServiceNumbersSupported = false;
        this.fctFavoriteListSupported = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllSupported == functionList_Status.fctGetAllSupported && this.fctBapConfigSupported == functionList_Status.fctBapConfigSupported && this.fctFunctionListSupported == functionList_Status.fctFunctionListSupported && this.fctHeartbeatSupported == functionList_Status.fctHeartbeatSupported && this.fctFsg_SetupSupported == functionList_Status.fctFsg_SetupSupported && this.fctFsg_OperationStateSupported == functionList_Status.fctFsg_OperationStateSupported && this.fctMobileServiceSupportAvailable == functionList_Status.fctMobileServiceSupportAvailable && this.fctActiveUserSupported == functionList_Status.fctActiveUserSupported && this.fctRegisterStateSupported == functionList_Status.fctRegisterStateSupported && this.fctLockStateSupported == functionList_Status.fctLockStateSupported && this.fctNetworkProviderSupported == functionList_Status.fctNetworkProviderSupported && this.fctSignalQualitySupported == functionList_Status.fctSignalQualitySupported && this.fctCallStateSupported == functionList_Status.fctCallStateSupported && this.fctCallInfoSupported == functionList_Status.fctCallInfoSupported && this.fctCallDurationSyncSupported == functionList_Status.fctCallDurationSyncSupported && this.fctDisconnectReasonSupported == functionList_Status.fctDisconnectReasonSupported && this.fctDialNumberSupported == functionList_Status.fctDialNumberSupported && this.fctDialServiceSupported == functionList_Status.fctDialServiceSupported && this.fctConfirmEmergencyCallSupported == functionList_Status.fctConfirmEmergencyCallSupported && this.fctHangupCallSupported == functionList_Status.fctHangupCallSupported && this.fctAcceptCallSupported == functionList_Status.fctAcceptCallSupported && this.fctCallHoldSupported == functionList_Status.fctCallHoldSupported && this.fctResumeCallSupported == functionList_Status.fctResumeCallSupported && this.fctHandsFreeOnOffSupported == functionList_Status.fctHandsFreeOnOffSupported && this.fctMicroMuteOnOffSupported == functionList_Status.fctMicroMuteOnOffSupported && this.fctMpreleaseActiveCallAcceptWaitingCallSupported == functionList_Status.fctMpreleaseActiveCallAcceptWaitingCallSupported && this.fctMpswapSupported == functionList_Status.fctMpswapSupported && this.fctMpcallHoldAcceptWaitingCallSupported == functionList_Status.fctMpcallHoldAcceptWaitingCallSupported && this.fctMpreleaseAllCallsAcceptWaitingCallSupported == functionList_Status.fctMpreleaseAllCallsAcceptWaitingCallSupported && this.fctMpsetWaitingCallOnHoldSupported == functionList_Status.fctMpsetWaitingCallOnHoldSupported && this.fctCcjoinSupported == functionList_Status.fctCcjoinSupported && this.fctCcsplitSupported == functionList_Status.fctCcsplitSupported && this.fctKeypadSupported == functionList_Status.fctKeypadSupported && this.fctMobileBatteryLevelSupported == functionList_Status.fctMobileBatteryLevelSupported && this.fctDataConnectionIndicationSupported == functionList_Status.fctDataConnectionIndicationSupported && this.fctMissedCallIndicationSupported == functionList_Status.fctMissedCallIndicationSupported && this.fctMissedCallsSupported == functionList_Status.fctMissedCallsSupported && this.fctReceivedCallsSupported == functionList_Status.fctReceivedCallsSupported && this.fctDialedNumbersSupported == functionList_Status.fctDialedNumbersSupported && this.fctCombinedNumbersSupported == functionList_Status.fctCombinedNumbersSupported && this.fctCallStackDeleteAllSupported == functionList_Status.fctCallStackDeleteAllSupported && this.fctPbStateSupported == functionList_Status.fctPbStateSupported && this.fctPhonebookSupported == functionList_Status.fctPhonebookSupported && this.fctPbSpellerSupported == functionList_Status.fctPbSpellerSupported && this.fctGetNextListPosSupported == functionList_Status.fctGetNextListPosSupported && this.fctSmsstateSupported == functionList_Status.fctSmsstateSupported && this.fctRingToneMuteOnOffSupported == functionList_Status.fctRingToneMuteOnOffSupported && this.fctAutomaticRedialSupported == functionList_Status.fctAutomaticRedialSupported && this.fctAutomaticRedialExtendedInfoSupported == functionList_Status.fctAutomaticRedialExtendedInfoSupported && this.fctSupportedServiceNumbersSupported == functionList_Status.fctSupportedServiceNumbersSupported && this.fctFavoriteListSupported == functionList_Status.fctFavoriteListSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FunctionList_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fctGetAllSupported);
        bitStream.pushBoolean(this.fctBapConfigSupported);
        bitStream.pushBoolean(this.fctFunctionListSupported);
        bitStream.pushBoolean(this.fctHeartbeatSupported);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupSupported);
        bitStream.pushBoolean(this.fctFsg_OperationStateSupported);
        bitStream.pushBoolean(this.fctMobileServiceSupportAvailable);
        bitStream.pushBoolean(this.fctActiveUserSupported);
        bitStream.pushBoolean(this.fctRegisterStateSupported);
        bitStream.pushBoolean(this.fctLockStateSupported);
        bitStream.pushBoolean(this.fctNetworkProviderSupported);
        bitStream.pushBoolean(this.fctSignalQualitySupported);
        bitStream.pushBoolean(this.fctCallStateSupported);
        bitStream.pushBoolean(this.fctCallInfoSupported);
        bitStream.pushBoolean(this.fctCallDurationSyncSupported);
        bitStream.pushBoolean(this.fctDisconnectReasonSupported);
        bitStream.pushBoolean(this.fctDialNumberSupported);
        bitStream.pushBoolean(this.fctDialServiceSupported);
        bitStream.pushBoolean(this.fctConfirmEmergencyCallSupported);
        bitStream.pushBoolean(this.fctHangupCallSupported);
        bitStream.pushBoolean(this.fctAcceptCallSupported);
        bitStream.pushBoolean(this.fctCallHoldSupported);
        bitStream.pushBoolean(this.fctResumeCallSupported);
        bitStream.pushBoolean(this.fctHandsFreeOnOffSupported);
        bitStream.pushBoolean(this.fctMicroMuteOnOffSupported);
        bitStream.pushBoolean(this.fctMpreleaseActiveCallAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpswapSupported);
        bitStream.pushBoolean(this.fctMpcallHoldAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpreleaseAllCallsAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpsetWaitingCallOnHoldSupported);
        bitStream.pushBoolean(this.fctCcjoinSupported);
        bitStream.pushBoolean(this.fctCcsplitSupported);
        bitStream.pushBoolean(this.fctKeypadSupported);
        bitStream.pushBoolean(this.fctMobileBatteryLevelSupported);
        bitStream.pushBoolean(this.fctDataConnectionIndicationSupported);
        bitStream.pushBoolean(this.fctMissedCallIndicationSupported);
        bitStream.pushBoolean(this.fctMissedCallsSupported);
        bitStream.pushBoolean(this.fctReceivedCallsSupported);
        bitStream.pushBoolean(this.fctDialedNumbersSupported);
        bitStream.pushBoolean(this.fctCombinedNumbersSupported);
        bitStream.pushBoolean(this.fctCallStackDeleteAllSupported);
        bitStream.pushBoolean(this.fctPbStateSupported);
        bitStream.pushBoolean(this.fctPhonebookSupported);
        bitStream.pushBoolean(this.fctPbSpellerSupported);
        bitStream.pushBoolean(this.fctGetNextListPosSupported);
        bitStream.pushBoolean(this.fctSmsstateSupported);
        bitStream.pushBoolean(this.fctRingToneMuteOnOffSupported);
        bitStream.pushBoolean(this.fctAutomaticRedialSupported);
        bitStream.pushBoolean(this.fctAutomaticRedialExtendedInfoSupported);
        bitStream.pushBoolean(this.fctSupportedServiceNumbersSupported);
        bitStream.pushBoolean(this.fctFavoriteListSupported);
        bitStream.resetBits(3);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 3;
    }

    @Override
    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

