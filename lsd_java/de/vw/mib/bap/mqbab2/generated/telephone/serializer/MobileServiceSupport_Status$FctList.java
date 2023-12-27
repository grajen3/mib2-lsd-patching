/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileServiceSupport_Status$FctList
implements BAPEntity {
    private static final int RESERVED_BIT_0__15_BITSIZE;
    public boolean reserved_bit_16;
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

    public MobileServiceSupport_Status$FctList() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileServiceSupport_Status$FctList(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_16 = false;
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
        MobileServiceSupport_Status$FctList mobileServiceSupport_Status$FctList = (MobileServiceSupport_Status$FctList)bAPEntity;
        return this.reserved_bit_16 == mobileServiceSupport_Status$FctList.reserved_bit_16 && this.fctActiveUserSupported == mobileServiceSupport_Status$FctList.fctActiveUserSupported && this.fctRegisterStateSupported == mobileServiceSupport_Status$FctList.fctRegisterStateSupported && this.fctLockStateSupported == mobileServiceSupport_Status$FctList.fctLockStateSupported && this.fctNetworkProviderSupported == mobileServiceSupport_Status$FctList.fctNetworkProviderSupported && this.fctSignalQualitySupported == mobileServiceSupport_Status$FctList.fctSignalQualitySupported && this.fctCallStateSupported == mobileServiceSupport_Status$FctList.fctCallStateSupported && this.fctCallInfoSupported == mobileServiceSupport_Status$FctList.fctCallInfoSupported && this.fctCallDurationSyncSupported == mobileServiceSupport_Status$FctList.fctCallDurationSyncSupported && this.fctDisconnectReasonSupported == mobileServiceSupport_Status$FctList.fctDisconnectReasonSupported && this.fctDialNumberSupported == mobileServiceSupport_Status$FctList.fctDialNumberSupported && this.fctDialServiceSupported == mobileServiceSupport_Status$FctList.fctDialServiceSupported && this.fctConfirmEmergencyCallSupported == mobileServiceSupport_Status$FctList.fctConfirmEmergencyCallSupported && this.fctHangupCallSupported == mobileServiceSupport_Status$FctList.fctHangupCallSupported && this.fctAcceptCallSupported == mobileServiceSupport_Status$FctList.fctAcceptCallSupported && this.fctCallHoldSupported == mobileServiceSupport_Status$FctList.fctCallHoldSupported && this.fctResumeCallSupported == mobileServiceSupport_Status$FctList.fctResumeCallSupported && this.fctHandsFreeOnOffSupported == mobileServiceSupport_Status$FctList.fctHandsFreeOnOffSupported && this.fctMicroMuteOnOffSupported == mobileServiceSupport_Status$FctList.fctMicroMuteOnOffSupported && this.fctMpreleaseActiveCallAcceptWaitingCallSupported == mobileServiceSupport_Status$FctList.fctMpreleaseActiveCallAcceptWaitingCallSupported && this.fctMpswapSupported == mobileServiceSupport_Status$FctList.fctMpswapSupported && this.fctMpcallHoldAcceptWaitingCallSupported == mobileServiceSupport_Status$FctList.fctMpcallHoldAcceptWaitingCallSupported && this.fctMpreleaseAllCallsAcceptWaitingCallSupported == mobileServiceSupport_Status$FctList.fctMpreleaseAllCallsAcceptWaitingCallSupported && this.fctMpsetWaitingCallOnHoldSupported == mobileServiceSupport_Status$FctList.fctMpsetWaitingCallOnHoldSupported && this.fctCcjoinSupported == mobileServiceSupport_Status$FctList.fctCcjoinSupported && this.fctCcsplitSupported == mobileServiceSupport_Status$FctList.fctCcsplitSupported && this.fctKeypadSupported == mobileServiceSupport_Status$FctList.fctKeypadSupported && this.fctMobileBatteryLevelSupported == mobileServiceSupport_Status$FctList.fctMobileBatteryLevelSupported && this.fctDataConnectionIndicationSupported == mobileServiceSupport_Status$FctList.fctDataConnectionIndicationSupported && this.fctMissedCallIndicationSupported == mobileServiceSupport_Status$FctList.fctMissedCallIndicationSupported && this.fctMissedCallsSupported == mobileServiceSupport_Status$FctList.fctMissedCallsSupported && this.fctReceivedCallsSupported == mobileServiceSupport_Status$FctList.fctReceivedCallsSupported && this.fctDialedNumbersSupported == mobileServiceSupport_Status$FctList.fctDialedNumbersSupported && this.fctCombinedNumbersSupported == mobileServiceSupport_Status$FctList.fctCombinedNumbersSupported && this.fctCallStackDeleteAllSupported == mobileServiceSupport_Status$FctList.fctCallStackDeleteAllSupported && this.fctPbStateSupported == mobileServiceSupport_Status$FctList.fctPbStateSupported && this.fctPhonebookSupported == mobileServiceSupport_Status$FctList.fctPhonebookSupported && this.fctPbSpellerSupported == mobileServiceSupport_Status$FctList.fctPbSpellerSupported && this.fctGetNextListPosSupported == mobileServiceSupport_Status$FctList.fctGetNextListPosSupported && this.fctSmsstateSupported == mobileServiceSupport_Status$FctList.fctSmsstateSupported && this.fctRingToneMuteOnOffSupported == mobileServiceSupport_Status$FctList.fctRingToneMuteOnOffSupported && this.fctAutomaticRedialSupported == mobileServiceSupport_Status$FctList.fctAutomaticRedialSupported && this.fctAutomaticRedialExtendedInfoSupported == mobileServiceSupport_Status$FctList.fctAutomaticRedialExtendedInfoSupported && this.fctSupportedServiceNumbersSupported == mobileServiceSupport_Status$FctList.fctSupportedServiceNumbersSupported && this.fctFavoriteListSupported == mobileServiceSupport_Status$FctList.fctFavoriteListSupported;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FctList:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(16);
        bitStream.pushBoolean(this.reserved_bit_16);
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
}

