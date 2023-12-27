/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng;

import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public interface DSIMobileEquipmentReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseAbortNetworkRegistration(int n) {
    }

    default public void responseAbortNetworkSearch(int n) {
    }

    default public void responseAcceptCall(int n) {
    }

    default public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    default public void responseCallWaiting(int n, int n2) {
    }

    default public void responseChangeSIMCode(int n, int n2) {
    }

    default public void responseCLIR(int n, int n2, int n3) {
    }

    default public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    default public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    default public void responseSendDTMF(int n) {
    }

    default public void updateDTMFTonePlaying(String string, int n) {
    }

    default public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
    }

    default public void responseRemoveOtherSIM(int n) {
    }

    default public void responseSIMPINRequired(int n) {
    }

    default public void updateOtherSIMAvailable(boolean bl, int n) {
    }

    default public void updateSIMPINRequired(boolean bl, int n) {
    }

    default public void responseHangupCall(int n) {
    }

    default public void responseJoinCalls(int n) {
    }

    default public void responseNetworkRegistration(int n) {
    }

    default public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    default public void responseUnlockOtherSIM(int n) {
    }

    default public void responseUnlockSIM(int n) {
    }

    default public void responseCheckSIMPINCode(int n) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseSetHandsFreeMode(int n) {
    }

    default public void responseSetAutomaticPinEntryActive(int n) {
    }

    default public void responseSetAutomaticRedialActive(int n) {
    }

    default public void responseServiceCodeAbort(int n) {
    }

    default public void responseSplitCall(int n) {
    }

    default public void responseSwapCalls(int n) {
    }

    default public void responseTelPower(int n) {
    }

    default public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
    }

    default public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    default public void updateAutomaticRedialActive(boolean bl, int n) {
    }

    default public void updateBatteryChargeLevel(int n, int n2) {
    }

    default public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
    }

    default public void updateCallList(CallInformation[] callInformationArray, int n) {
    }

    default public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
    }

    default public void updateCradlePlugInState(int n, int n2) {
    }

    default public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
    }

    default public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
    }

    default public void updateEnhancedPrivacyMode(boolean bl, int n) {
    }

    default public void updateHandsFreeMode(int n, int n2) {
    }

    default public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    default public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
    }

    default public void updateMICMuteState(int n, int n2) {
    }

    default public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
    }

    default public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
    }

    default public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
    }

    default public void updateNetworkType(int n, int n2) {
    }

    default public void updatePrivacyMode(boolean bl, int n) {
    }

    default public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
    }

    default public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    default public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
    }

    default public void updateSignalQuality(int n, int n2) {
    }

    default public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
    }

    default public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
    }

    default public void updateNADMode(int n, int n2) {
    }

    default public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    default public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    default public void responseSetMailboxContent(int n) {
    }

    default public void responseSetPrivacyMode(int n) {
    }

    default public void responseSetSIMAliases(int n) {
    }

    default public void responseSetMICMuteState(int n) {
    }

    default public void responseSetOptimizationMode(int n, int n2) {
    }

    default public void responseSetNADMode(int n, int n2) {
    }

    default public void updateMicGainLevel(int n, int n2) {
    }

    default public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
    }

    default public void updateOptimizationMode(int n, int n2) {
    }

    default public void responseSetPhoneReminderSetting(int n) {
    }

    default public void responseSetPrefixActivated(int n) {
    }

    default public void responseSetPrefixContent(int n) {
    }

    default public void updatePhoneReminderSetting(boolean bl, int n) {
    }

    default public void updatePrefixActivated(boolean bl, int n) {
    }

    default public void updatePrefixContent(String string, int n) {
    }

    default public void updateWidebandSpeech(boolean bl, int n) {
    }

    default public void responseSetPhoneRingtone(int n) {
    }

    default public void updatePhoneRingtone(int n, String string, int n2) {
    }

    default public void responseSetFavorites(int n) {
    }

    default public void updateFavorites(Favorite[] favoriteArray, int n) {
    }

    default public void updateSAPUpgradeActive(boolean bl, int n) {
    }

    default public void responseSetSIMName(int n) {
    }

    default public void responseSetESIMActive(int n) {
    }

    default public void updateEUICCID(String string, int n) {
    }

    default public void updateESIMMSISDN(String string, int n) {
    }

    default public void updateESimActive(boolean bl, int n) {
    }

    default public void updateESimB2BMode(boolean bl, int n) {
    }

    default public void updateCallstacksIsReverted(boolean bl, int n) {
    }

    default public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    default public void updateMEDataValidity(int n, int n2) {
    }

    default public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
    }

    default public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    default public void updateSpeechRecognitionActive(int n, int n2) {
    }

    default public void updateSpeechRecognitionType(int n, int n2) {
    }

    default public void responseStartSpeechRecognition(int n) {
    }

    default public void responseStopSpeechRecognition(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

